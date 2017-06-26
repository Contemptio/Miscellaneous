package zmk.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for {@code enum}erations.
 * 
 * @author Zimon
 * @date 2017-06-25
 */
public class EnumerationUtil {

    /**
     * Builds a {@code String} to {@code enum}eration map.
     * 
     * @param <T>
     *            The type of {@code enum}eration.
     * @param values
     *            The {@code enum}erations.
     * @return
     *         a map from {@code enum}eration names to their values.
     */
    public static <T extends Enum<T>> Map<String, T> stringMap(T[] values) {
        Map<String, T> map = new HashMap<String, T>();
        for (T value : values) {
            map.put(value.name(), value);
        }
        return map;
    }
}
