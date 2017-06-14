package pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import pokemon.type.Type;

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
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        for (Pokemon mon : roster) {
            
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
        System.out.println(team.strengths());
        System.out.println(team.resistances());
        System.out.println(team.weaknesses());
    }
}
