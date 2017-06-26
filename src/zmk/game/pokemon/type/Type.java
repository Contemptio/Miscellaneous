package zmk.game.pokemon.type;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zmk.game.pokemon.Pokemon;

/**
 * Pokemon types.
 */
public enum Type implements Comparable<Type> {
    BUG(1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 0.5, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0),
    DARK(1.0, 0.5, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0),
    DRAGON(1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0),
    ELECTRIC(1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0),
    FAIRY(1.0, 2.0, 2.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 0.5, 1.0),
    FIGHTING(0.5, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 0.5, 0.0, 1.0, 1.0, 2.0, 2.0, 0.5, 0.5, 2.0, 2.0, 1.0),
    FIRE(2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 0.5),
    FLYING(2.0, 1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0),
    GHOST(1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.0, 1.0, 2.0, 1.0, 1.0, 1.0),
    GRASS(0.5, 1.0, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 1.0, 2.0, 0.5, 2.0),
    GROUND(0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 0.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 2.0, 2.0, 1.0),
    ICE(1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0),
    NORMAL(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0),
    POISON(1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 0.5, 1.0, 0.5, 0.0, 1.0),
    PSYCHIC(1.0, 0.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 1.0),
    ROCK(2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 2.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0),
    STEEL(1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5),
    WATER(1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5),
    NO_TYPE(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);

    private static final Type[] valueArray = values();
    private static final List<Type> values = Collections.<Type> unmodifiableList(Arrays.asList(valueArray));
    private static final Type[] typeArray = Arrays.copyOf(valueArray, valueArray.length - 1);
    private static final List<Type> types = Collections.<Type> unmodifiableList(Arrays.asList(typeArray));
    private static final Map<String, Type> stringToEnum =
            Collections.<String, Type> unmodifiableMap(compileStringToEnumMap());

    private static Map<String, Type> compileStringToEnumMap() {
        Map<String, Type> map = new HashMap<String, Type>();
        for (Type type : values) {
            map.put(type.name().toUpperCase(), type);
        }
        return map;
    }

    private double[] strengths;

    public static Collection<Type> types() {
        return types;
    }

    public static Type get(String name) {
        String key = name.toUpperCase();
        if (!stringToEnum.containsKey(key)) {
            return NO_TYPE;
        }
        return stringToEnum.get(key);
    }

    private Type(double... strengths) {
        int length = 18;
        if (strengths.length != length) {
            throw new IllegalArgumentException("Must specify strength against all types.");
        }
        this.strengths = Arrays.copyOf(strengths, length + 1);
        this.strengths[length] = 1.0;
    }

    public double strength(Pokemon defender) {
        return strength(defender.type1(), defender.type2());
    }

    public double strength(Type defenderPrimary, Type defenderSecondary) {
        double d1 = strength(defenderPrimary.index());
        double d2 = strength(defenderSecondary.index());
        return strength(defenderPrimary.index()) * strength(defenderSecondary.index());
    }

    public double strength(int index) {
        return strengths[index];
    }

    public double strength(Type type) {
        return strength(type.index());
    }

    public int index() {
        return values.indexOf(this);
    }
}
