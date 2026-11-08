package filesystem;

import java.util.List;
import java.util.Objects;

/** An immutable directory containing files and/or nested directories. */
public final class
Directory implements Element {
    private final String name;
    private final List<Element> children;

    public Directory(String name, List<? extends Element> children) {
        this.name = File.requireName(name);
        Objects.requireNonNull(children, "children");
        this.children = List.copyOf(children);
    }

    public String getName() {
        return name;
    }

    /** Returns an unmodifiable snapshot of this directory's contents. */
    public List<Element> getChildren() {
        return children;
    }

    @Override
    public void accept(Visitor visitor) {
        Objects.requireNonNull(visitor, "visitor").visitDirectory(this);
    }
}
