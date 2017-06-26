package zmk.file.searcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zmk.file.util.FileUtil;

/**
 * Class that searches through files for matches.
 */
public class FileSearcher {

    /**
     * Program that searches through files for matches.
     * 
     * @param args
     *            Expected arguments:
     *            <ul>
     *            <li><PATH> - path at which to start searching.</li>
     *            <li><REGEXP> - regular expression to match.</li>
     *            </ul>
     * @throws IOException
     *             if there was any error reading the file specified by
     *             {@code args[0]}.
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            error("Usage: FileSearcher <PATH> <REGEXP>");
        }

        File path = new File(args[0]);
        if (!path.exists()) {
            error(path + " does not exist.");
        }

        for (File file : recursiveFileList(path)) {
            if (FileUtil.fileAsString(file).equals("")) {
                /*
                 * TODO: implement.
                 */
            }
        }
    }

    /**
     * Returns {@link File} objects of all files recursively from a directory.
     * 
     * @param root
     *            The root directory. If a file, only that file is returned.
     * @return
     *         a list of all files recursively starting at {@code root}.
     */
    private static List<File> recursiveFileList(File root) {
        List<File> files = new ArrayList<File>();

        return files;
    }

    /**
     * Prints a message and exits.
     * 
     * @param message
     *            The message to print.
     */
    private static void error(String message) {
        System.err.println(message);
        System.exit(1);
    }
}
