package filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/** Finds files whose names end with a selected extension, ignoring case. */
public final class SearchVisitor implements Visitor {
    private final String extension;
    private final List<File> matches = new ArrayList<>();

    public SearchVisitor(String extension) {
        Objects.requireNonNull(extension, "extension");
        if (extension.length() < 2 || extension.charAt(0) != '.'
                || extension.substring(1).isBlank()) {
            throw new IllegalArgumentException("Extension must look like .txt");
        }
        this.extension = extension.toLowerCase(Locale.ROOT);
    }

    public List<File> search(Element element) {
        matches.clear();
        Objects.requireNonNull(element, "element").accept(this);
        return List.copyOf(matches);
    }

    @Override
    public void visitFile(File file) {
        File checkedFile = Objects.requireNonNull(file, "file");
        if (checkedFile.getName().toLowerCase(Locale.ROOT).endsWith(extension)) {
            matches.add(checkedFile);
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (Element child : Objects.requireNonNull(directory, "directory").getChildren()) {
            child.accept(this);
        }
    }
}
