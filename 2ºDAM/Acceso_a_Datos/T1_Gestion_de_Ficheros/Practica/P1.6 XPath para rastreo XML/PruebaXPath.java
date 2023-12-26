package xpath;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PruebaXPath {
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException{
		//La expresion xpath de busqueda
		//En este apartado, se definen todas las expresiones XPath. Muestran donde se quieren encontrar la informacion en concreto
		//La primera expresion pretende encontrar al satelite que tenga como atributo nombre a 'Luna'
		String xPathExpression="//satelite[@nombre='Luna']";
		//La segunda expresion pretende encontrar los nombres de planetas a partir de la raiz de etiquetas
		String xPathExpression2="/espacio/galaxia/estrella/planeta[@nombre]";
		//La tercera expresion muestra todas las etiquetas por debajo de galaxia
		String xPathExpression3="/espacio/galaxia/*";
		//La cuarta expresion muestra o estrellas por debajo de galaxia o estrellas por debajo de sistema_estelar
		String xPathExpression4="/espacio/galaxia/estrella | /espacio/galaxia/sistema_estelar/estrella";
		//La quinta expresion pretende encontrar todas las etiquetas que no tengan como nombre a 'Luna'
		String xPathExpression5="//*[@nombre!='Luna']";
		//Carga del documento xml
		//Para cargar el documento espacio.xml, se crea un objeto de la clase DocumentBuilderFactory, del cual se crea una
		//nueva instancia y se carga en otro objeto de la clase DocumentBuilder
		//hecho esto, se parsea este objeto en un objeto de la clase Document, con la ruta de almacenamiento de espacio.xml
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document documento=builder.parse(new File("C:\\Users\\jimen\\Downloads\\espacio.xml"));
		//Preparacion de xpath
		//Se crea el XPath
		XPath xpath=XPathFactory.newInstance().newXPath();
		//Consultas
		//Se crean todas las consultas a partir de NodeList, donde el objeto xpath evalua la expresion del documento
		NodeList nodos=(NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
		NodeList nodos2=(NodeList) xpath.evaluate(xPathExpression2, documento, XPathConstants.NODESET);
		NodeList nodos3=(NodeList) xpath.evaluate(xPathExpression3, documento, XPathConstants.NODESET);
		NodeList nodos4=(NodeList) xpath.evaluate(xPathExpression4, documento, XPathConstants.NODESET);
		NodeList nodos5=(NodeList) xpath.evaluate(xPathExpression5, documento, XPathConstants.NODESET);
		//Se hace un for por cada carga de nodos, sacando por pantalla la informacion requerida en las expresiones path
		System.out.println("EXPRESION 1:");
		for(int i=0;i<nodos.getLength();i++) {
			System.out.println(nodos.item(i).getNodeName()+":"+nodos.item(i).getAttributes().getNamedItem("nombre"));
		}
		System.out.println("EXPRESION 2:");
		for(int i=0;i<nodos2.getLength();i++) {
			System.out.println(nodos2.item(i).getNodeName()+":"+nodos2.item(i).getAttributes().getNamedItem("nombre"));
		}
		System.out.println("EXPRESION 3:");
		for(int i=0;i<nodos3.getLength();i++) {
			System.out.println(nodos3.item(i).getNodeName()+":"+nodos3.item(i).getAttributes().getNamedItem("nombre"));
		}
		System.out.println("EXPRESION 4:");
		for(int i=0;i<nodos4.getLength();i++) {
			System.out.println(nodos4.item(i).getNodeName()+":"+nodos4.item(i).getAttributes().getNamedItem("nombre"));
		}
		System.out.println("EXPRESION 5:");
		for(int i=0;i<nodos5.getLength();i++) {
			System.out.println(nodos5.item(i).getNodeName()+":"+nodos5.item(i).getAttributes().getNamedItem("nombre"));
		}
	}
}