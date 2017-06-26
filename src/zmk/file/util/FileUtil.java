package zmk.file.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import zmk.collection.ArrayList;
import zmk.exception.NotImplementedException;

/**
 * Utility class for reading files.
 * 
 * @author Zimon
 * @date 2017-04-23
 */
public class FileUtil {

    /**
     * Short-hand method for getting all lines in a file as a {@link List}.
     * 
     * @param file
     *            The file to read.
     * @return a {@link List} containing all the lines in {@code file}.
     * @throws IOException
     *             if there was any error reading the file.
     */
    public static List<String> fileAsLines(File file) throws IOException {
        return new ArrayList<String>(new String(Files.readAllBytes(file.toPath()), "UTF-8").split("\n"));
    }

    /**
     * Rewrites a file.
     * 
     * @param destination
     *            The file to rewrite.
     * @param lines
     *            The lines to write to {@code destination}.
     */
    public static void rewriteFile(File destination, List<String> lines) {
        throw new NotImplementedException("rewriteFile");
    }

    /**
     * Reads the contents of a file into a string.
     * 
     * @param file
     *            The file to read.
     * @return
     *         a string of {@code file}'s contents.
     * @throws IOException
     *             if there was any error reading {@code file}.
     */
    public static String fileAsString(File file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file.getPath())));
    }
}
