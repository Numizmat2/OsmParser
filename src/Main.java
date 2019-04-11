import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        parse();
    }

    private static void parse() {
        try {

            File fXmlFile = new File("/map.osm"); //change path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            List<Point> pointList = new ArrayList<>();


            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("node");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    var id = eElement.getAttribute("id");
                    var lat = eElement.getAttribute("lat");
                    var lon = eElement.getAttribute("lon");

                    System.out.println("id : " + id);
                    System.out.println("lat : " + lat);
                    System.out.println("lon : " + lon + "\n");

                    pointList.add(new Point(id, lat, lon));
                }
            }

            NodeList nList2 = doc.getElementsByTagName("way");

            System.out.println("----------------------------");

            List<Line> wayList = new ArrayList<>();
            for (int temp = 0; temp < nList2.getLength(); temp++) {

                Node nNode2 = nList2.item(temp);

                if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement2 = (Element) nNode2;

                    var id = eElement2.getAttribute("id");
                    System.out.println("id : " + id);

                    NodeList list = eElement2.getElementsByTagName("nd");
                    List<Point> points = new ArrayList<>();
                    for (int i = 0; i<list.getLength(); i++) {
                        Node node = list.item(i);

                        Element elem = (Element) node;

                        var ref = elem.getAttribute("ref");
                        System.out.println("ref: " + ref);
                    }
                    System.out.println("\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
