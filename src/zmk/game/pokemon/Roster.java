package zmk.game.pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import zmk.game.pokemon.type.Type;
import zmk.util.EnumUtil;

public class Roster {
    public static final int ROSTER_SIZE = 6;
    private List<Pokemon> roster;

    public Roster(Pokemon... pokemon) {
        this.roster = new ArrayList<Pokemon>();

        int length = pokemon.length;
        if (length > ROSTER_SIZE) {
            throw new IllegalArgumentException(
                    "Too large team, expected " + ROSTER_SIZE + " pokemon, got " + length + ",");
        }

        for (Pokemon mon : pokemon) {
            roster.add(mon);
        }
        System.out.println(roster);
        Collections.<Pokemon> sort(roster);
    }

    public List<Type> strengths() {
        SortedSet<Type> strengths = new TreeSet<Type>();
        for (Pokemon mon : roster) {
            strengths.addAll(mon.strengths());
        }
        return new ArrayList<Type>(strengths);
    }

    public List<Type> resistances() {
        SortedSet<Type> resistances = new TreeSet<Type>(Type.types());
        for (Pokemon mon : roster) {
            resistances.removeAll(mon.strengths());
        }
        return new ArrayList<Type>(resistances);
    }

    public List<Type> weaknesses() {
        SortedSet<Type> weaknesses = new TreeSet<Type>(Type.types());
        for (Pokemon mon : roster) {
            weaknesses.removeAll(mon.strengths());
        }
        return new ArrayList<Type>(weaknesses);
    }

    public List<Type> missingStrengths() {
        return EnumUtil.complement(Type.class, strengths());
    }

    public List<Type> missingResistances() {
        return EnumUtil.complement(Type.class, resistances());
    }

    public List<Type> missingWeaknesses() {
        return EnumUtil.complement(Type.class, weaknesses());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[\n");
        for (Pokemon mon : roster) {
            Type type2 = mon.type2();
            string.append(
                    "    " + mon.name() + ": " + mon.type1() + (type2 != Type.NO_TYPE ? ", " + type2 : "") + "\n");
        }
        return string.append("]").toString();
    }

    public static void main(String[] args) {
        Pokemon[] mons = new Pokemon[] {
            new Pokemon("Test1", "Normal", "Ground"), new Pokemon("Test2", "Steel", "Dark"),
            new Pokemon("Test3", "Fighting", "Ice"), new Pokemon("Test4", "Electric", "Bug"),
            new Pokemon("Test5", "Fairy", "Fire"), new Pokemon("Test6", "Grass", "Water"),
        };
        Roster team = new Roster(mons);
        System.out.println(team.missingStrengths());
        System.out.println(team.missingResistances());
        System.out.println(team.missingWeaknesses());
    }
}
