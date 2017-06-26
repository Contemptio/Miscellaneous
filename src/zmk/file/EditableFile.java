package zmk.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import zmk.file.util.FileUtil;

/**
 * Class representing an editable file.
 * <p>
 * Used for loading a file, managing its contents, then saving them.
 * 
 * @author Zimon
 * @date 2017-04-04
 */
public class EditableFile {
    private List<String> lines;
    private File source;
    private File destination;

    /**
     * Constructs an {@code EditableFile}.
     * 
     * @param source
     *            The path of the file to edit.
     * @param destination
     *            The path where the edited file should be saved.
     * @throws IOException
     *             if there was any error reading {@code source}.
     */
    public EditableFile(File source, File destination) throws IOException {
        this.destination = destination;
        this.source = source;
    }

    /**
     * Constructs an {@code EditableFile}.
     * 
     * @param path
     *            The path of the file to edit.
     * @throws IOException
     *             if there was any error reading the file at {@code path}.
     */
    public EditableFile(Path path) throws IOException {
        this(path.toString());
    }

    /**
     * Constructs an {@code EditableFile}.
     * 
     * @param path
     *            The path of the file to edit.
     * @throws IOException
     *             if there was any error reading the file at {@code path}.
     */
    public EditableFile(String path) throws IOException {
        this(new File(path));
    }

    /**
     * Constructs an {@code EditableFile}.
     * 
     * @param file
     *            The file to edit.
     * @throws IOException
     *             if there was any error reading {@code file}.
     */
    public EditableFile(File file) throws IOException {
        this(file, file);
    }

    /**
     * Constructs an {@code EditableFile}.
     * 
     * @param sourcePath
     *            The path of the file to edit.
     * @param destinationPath
     *            The path where the edited file should be saved.
     * @throws IOException
     *             if there was any error reading {@code source}.
     */
    public EditableFile(String sourcePath, String destinationPath) throws IOException {
        this(new File(sourcePath), new File(destinationPath));
    }

    /**
     * Constructs an {@code EditableFile}.
     * 
     * @param sourcePath
     *            The path of the file to edit.
     * @param destinationPath
     *            The path where the edited file should be saved.
     * @throws IOException
     *             if there was any error reading {@code source}.
     */
    public EditableFile(Path sourcePath, Path destinationPath) throws IOException {
        this(sourcePath.toString(), destinationPath.toString());
    }

    /**
     * Saves, i.e. writes the current contents to the destination.
     * 
     * @return
     *         {@code true} if it was possible to save the file, {@code false}
     *         otherwise.
     */
    public boolean save() {
        FileUtil.rewriteFile(destination, lines);
        /*
         * TODO: Implement.
         */
        return false;
    }

    /**
     * Re-reads the contents of the source file.
     * 
     * @throws IOException
     *             if there was any error reading the source file.
     */
    @SuppressWarnings("unused")
    private void reset() throws IOException {
        this.lines = FileUtil.fileAsLines(source);
    }
}
