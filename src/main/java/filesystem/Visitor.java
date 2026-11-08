package filesystem;

/** Defines one operation for each concrete filesystem element type. */
public interface Visitor {
    void visitFile(File file);

    void visitDirectory(Directory directory);
}
