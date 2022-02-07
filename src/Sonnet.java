import java.util.List;

public class Sonnet {
    private  Author author;
   private String title;
   private List<String> lines;

    public Sonnet(Author author, String title, List<String> lines) {
        this.author = author;
        this.title = title;
        this.lines = lines;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Sonnet{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", lines=" + lines +
                '}';
    }
}
