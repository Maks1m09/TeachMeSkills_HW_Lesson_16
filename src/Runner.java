
import java.util.List;

public class Runner {
    public static void main(String[] args) {
       Dom dom = new Dom();
        String filepath = "C:\\NewHomework\\Fail\\hw.xml";
        List<Sonnet> sonnets = dom.process(filepath);
        System.out.println("Result:");
//        System.out.println(sonnets.get(0).toString());
    }
}