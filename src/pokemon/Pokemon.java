package pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pokemon.type.Type;

public class Pokemon implements Comparable<Pokemon> {
    private String name;
    private Type type1;
    private Type type2;

    public Pokemon(String name, String primary, String secondary) {
        this(name, Type.get(primary), Type.get(secondary));
    }

    public Pokemon(String name, Type type) {
        this(name, type, Type.NO_TYPE);
    }

    public Pokemon(String name, Type primary, Type secondary) {
        type1 = primary;
        type2 = secondary;
    }

    public Type type1() {
        return type1;
    }

    public Type type2() {
        return type2;
    }

    public double defense(Type attacker) {
        return attacker.strength(this);
    }

    public List<Type> resistances() {
        List<Type> resistances = new ArrayList<Type>();
        for (Type attacker : Type.types()) {
            if (defense(attacker) < 1) {
                resistances.add(attacker);
            }
        }
        return resistances;
    }

    public List<Type> weaknesses() {
        List<Type> weaknesses = new ArrayList<Type>();
        for (Type attacker : Type.types()) {
            if (defense(attacker) > 1) {
                weaknesses.add(attacker);
            }
        }
        return weaknesses;
    }

    public List<Type> strengths() {
        List<Type> strengths = new ArrayList<Type>();
        for (Type defender : Type.types()) {
            if (type1.strength(defender) > 1 || type2.strength(defender) > 1) {
                strengths.add(defender);
            }
        }
        Collections.<Type> sort(strengths);
        return strengths;
    }

    @Override
    public int compareTo(Pokemon other) {
        return this.name.compareTo(other.name);
    }

    public static void main(String[] args) {
        Pokemon mon = new Pokemon("Test", Type.NORMAL, Type.STEEL);
        System.out.println(mon.strengths());
        System.out.println(mon.resistances());
        System.out.println(mon.weaknesses());
    }

    public String name() {
        return name;
    }
}
