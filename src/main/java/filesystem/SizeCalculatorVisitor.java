package filesystem;

import java.util.Objects;

/** Calculates the combined size of all files below a selected element. */
public final class SizeCalculatorVisitor implements Visitor {
    private long totalSizeInBytes;

    public long calculate(Element element) {
        totalSizeInBytes = 0;
        Objects.requireNonNull(element, "element").accept(this);
        return totalSizeInBytes;
    }

    @Override
    public void visitFile(File file) {
        totalSizeInBytes = Math.addExact(totalSizeInBytes,
                Objects.requireNonNull(file, "file").getSizeInBytes());
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (Element child : Objects.requireNonNull(directory, "directory").getChildren()) {
            child.accept(this);
        }
    }
}
