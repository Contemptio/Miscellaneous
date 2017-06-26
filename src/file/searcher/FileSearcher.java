package file.searcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            error("Usage: FileSearcher <PATH> <REGEXP>");
        }

        File path = new File(args[0]);
        String regexp = args[1];

        if (!path.exists()) {
            error(path + " does not exist.");
        }

        List<String> fileNames = new ArrayList<String>();
        for (File file : recursiveFileList(path)) {
            if (FileUtil.fileAsString(file).equals("")) {
                
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
