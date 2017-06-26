package zmk.run.util;

import java.util.List;

/**
 * @author Zimon
 *
 */
public class ArgumentUtil {

    public static boolean checkArguments(List<String> arguments, String... required) {
        int length = required.length;
        if (arguments.size() >= length) {
            return true;
        }

        StringBuilder message = new StringBuilder("Missing required arguments:\n");
        for (int i = 0; i < length; ++i) {
            message.append("    " + required[i] + "\n");
        }
        throw new IllegalArgumentException(message.toString());
    }
}
