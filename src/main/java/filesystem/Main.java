package filesystem;

import java.util.List;

/** Builds one sample filesystem tree and runs both visitor operations. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        Directory documents = new Directory("documents", List.of(
                new File("report.pdf", 4_096),
                new File("notes.txt", 512)));
        Directory source = new Directory("source", List.of(
                new File("Main.java", 1_500),
                new File("Visitor.java", 900)));
        Directory root = new Directory("project", List.of(
                new File("README.md", 1_200),
                new File("photo.jpg", 2_048),
                documents,
                source));

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        System.out.println("Total size of '" + root.getName() + "': "
                + sizeCalculator.calculate(root) + " bytes");

        SearchVisitor search = new SearchVisitor(".txt");
        List<File> matches = search.search(root);
        System.out.println("Files matching .txt:");
        for (File file : matches) {
            System.out.println("- " + file.getName() + " (" + file.getSizeInBytes() + " bytes)");
        }
    }
}
