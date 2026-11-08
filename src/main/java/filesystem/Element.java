package filesystem;

/** An element that can be processed by a filesystem visitor. */
public interface Element {
    void accept(Visitor visitor);
}
