package zmk.file.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.nio.file.Files;
import java.util.List;

import zmk.collection.ArrayList;

/**
 * Utility class for reading files.
 * 
 * @author Zimon
 * @date 2017-04-23
 */
public class FileReadUtil {

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
}
