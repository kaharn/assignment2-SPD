package filesystem;

import java.util.Objects;

/** A named file with a non-negative size in bytes. */
public final class File implements Element {
    private final String name;
    private final long sizeInBytes;

    public File(String name, long sizeInBytes) {
        this.name = requireName(name);
        if (sizeInBytes < 0) {
            throw new IllegalArgumentException("File size cannot be negative");
        }
        this.sizeInBytes = sizeInBytes;
    }

    public String getName() {
        return name;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public void accept(Visitor visitor) {
        Objects.requireNonNull(visitor, "visitor").visitFile(this);
    }

    static String requireName(String name) {
        Objects.requireNonNull(name, "name");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        return name;
    }
}
