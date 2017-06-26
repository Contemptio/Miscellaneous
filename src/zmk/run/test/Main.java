package zmk.run.test;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import zmk.collection.PriorityQueue;
import zmk.file.util.FileReadUtil;

/**
 * Runs anything.
 * 
 * @author Zimon Kuhs
 * @date 2017-04-23
 */
public class Main {
    private String[] args;
    
    /**
     * Constructs a {@link Main} object and {@link #run()}s it.
     * @param args
     */
    public Main(String[] args) {
        this.args = args;
        run();
    }
    
    public final void run() {
        try {
            for (String row : new TreeSet<String>(FileReadUtil.fileAsLines(new File(args[0])))) {
                System.out.println(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method that runs from the outside.
     */
    public static void main(String[] args) {
        new Main(args);
    }
}
