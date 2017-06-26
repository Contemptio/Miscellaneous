package zmk.file;

import java.io.File;
import java.nio.file.Path;

public class EditableFile {
    private File source;
    private File destination;

    public EditableFile(String path) {
        this(new File(path));
    }

    public EditableFile(String sourcePath, String destinationPath) {
        this(new File(sourcePath), new File(destinationPath));
    }

    public EditableFile(Path path) {
        this(path.toString());
    }

    public EditableFile(Path sourcePath, Path destinationPath) {
        this(sourcePath.toString(), destinationPath.toString());
    }

    public EditableFile(File file) {
        this(file, file);
    }

    public EditableFile(File source, File destination) {
        this.destination = destination;
        this.source = source;
    }
}
