import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dom implements Parser {
    @Override
    public List<Sonnet> process(String file) {
        List <Sonnet> sonnets = new ArrayList<>();
        Sonnet sonnet = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse( new File(file));
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("sonnet");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) node;
                    Author author = new Author(eElement.getAttribute("lastName"),eElement.getAttribute("firstName"),
                            eElement.getAttribute("nationality"),Integer.parseInt(eElement.getAttribute("yearOfBirth")),
                          Integer.parseInt( eElement.getAttribute("yearOfDeath")));
                    String title= eElement.getAttribute("title");
                    List <String> lines = new ArrayList<>();
                            lines.add(eElement.getAttribute("line"));
                    sonnets.add(new Sonnet(author, title, lines));
                }
            }
        }  catch (Exception e){
            e.printStackTrace();
        }
        return sonnets;
    }
}
