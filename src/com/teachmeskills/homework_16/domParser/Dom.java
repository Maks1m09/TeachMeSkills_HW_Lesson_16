package com.teachmeskills.homework_16.domParser;

import com.teachmeskills.homework_16.iParser.Parser;
import com.teachmeskills.homework_16.model.Author;
import com.teachmeskills.homework_16.model.Sonnet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dom implements Parser {
    @Override
    public List<Sonnet> process(String file) {
        List<Sonnet> sonnets = new ArrayList<>();
        Sonnet sonnet = new Sonnet();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(file));
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("sonnet");
            getType(nodeList);
            NodeList nodeList1 = document.getDocumentElement().getElementsByTagName("title");
            sonnet.setTitle(getTitle(nodeList1));
            NodeList nodeList2 = document.getDocumentElement().getElementsByTagName("author");
            sonnet.setAuthor(getAuthor(nodeList2));
            NodeList nodeList3 = document.getDocumentElement().getElementsByTagName("lines");
            sonnet.setLines(getList(nodeList3, document));
            sonnets.add(sonnet);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sonnets;
    }
    private static void getType(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String title = eElement.getAttribute("type");
                System.out.println(title);
            }
        }
    }

    private static String getTitle(NodeList nodeList) {
        String title = "";
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node1 = nodeList.item(i);
            if (node1.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement1 = (Element) node1;
                title = eElement1.getTextContent();
            }
        }
        return title;
    }

    private static Author getAuthor(NodeList nodeList) {
        Author author = new Author();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;
                Node node1 = elem.getElementsByTagName("firstName").item(0);
                if (node1 != null) {
                    String firstName = node1.getTextContent();
                    author.setFirstName(firstName);
                }
                Node node2 = elem.getElementsByTagName("lastName").item(0);
                if (node2 != null) {
                    String lastName = node2.getTextContent();
                    author.setLastName(lastName);
                }
                Node node3 = elem.getElementsByTagName("nationality").item(0);
                if (node3 != null) {
                    String nationality = node3.getTextContent();
                    author.setNationality(nationality);
                }
                Node node4 = elem.getElementsByTagName("yearOfBirth").item(0);
                if (node4 != null) {
                    int yearOfBirth = Integer.parseInt(node4.getTextContent());
                    author.setYearOfBirth(yearOfBirth);
                }
                Node node5 = elem.getElementsByTagName("yearOfDeath").item(0);
                if (node5 != null) {
                    int yearOfDeath = Integer.parseInt(node5.getTextContent());
                    author.setYearOfDeath(yearOfDeath);
                }
            }
        }
        return author;
    }

    private static List getList(NodeList nodeList, Document document) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                NodeList nodeList1 = document.getDocumentElement().getElementsByTagName("line");
                for (int j = 0; j < nodeList1.getLength(); j++) {
                    Node nNode1 = nodeList1.item(j);
                    Element elem = (Element) nNode1;
                    String line = elem.getTextContent();
                    strings.add(elem.getNodeName() + " " + line + "\n");
                }
            }
        }
        return strings;
    }
}
