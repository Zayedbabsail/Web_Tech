import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.Scanner;
public class read {
    public static void main(String a[]) throws Exception{
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Build Document
        Document document = builder.parse(new File("/Users/rahul/Documents/6-sem/WT-LAB/xml/e.xml"));
        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();
        //Here comes the root node
        
        //Get all employees
        Node nList = document.getElementsByTagName("employee");
        System.out.println("enter employee id:");
        Scanner s=new Scanner(System.in);
        String id=s.next();
        for (int temp = 0; temp <nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                if(eElement.getAttribute("id").equals(id)){
                    System.out.println("First Name : "+
                    eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Last Name:" +
                    eElement.getElementsByTagName("lastName").item(0).getTextContent());
                    System.out.println("Location:" +eElement.getElementsByTagName("location").item(0).getTextContent());
                }
            }
        }
    }
}