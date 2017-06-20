package util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class EnumUtil {

    public static <T extends Enum<T>> List<T> complement(Class<T> enumType, List<T> strengths) {
        Set<T> set = EnumSet.allOf(enumType);
        set.removeAll(strengths);
        return new ArrayList<T>(set);
    }

}
