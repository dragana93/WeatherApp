package reader;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLParser {

	static final String TEMPERATURE = "temperature";
	static final String HUMIDITY = "humidity";
	static final String FOG = "fog";
	static final String LOW_CLOUDS = "lowClouds";
	static final String MEDIUM_CLOUDS = "mediumClouds";
	static final String HIGH_CLOUDS = "highClouds";
	static final String DEWPOINT_TEMPERATURE = "dewpointTemperature";

	private URL url;

	public XMLParser(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public XMLItem readFeed() {
		XMLItem feedItem = null;
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new InputSource(url.openStream()));
			doc.getDocumentElement().normalize();

			// Root node
			Element root = doc.getDocumentElement();
			System.out.println(root.getNodeName());

			NodeList nList = doc.getElementsByTagName("time");
			System.out.println("============================");
			
			feedItem = new XMLItem();
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node node = nList.item(temp);
				System.out.println(" TIME"); // Just a separator
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element timeElement = (Element) node;
					NodeList nListLocation = timeElement.getElementsByTagName("location");
					for (int locationItem = 0; locationItem < nListLocation.getLength(); locationItem++) {
						Node nodeNested = nListLocation.item(locationItem);
						System.out.println("LOCATION"); // Just a separator
						if (nodeNested.getNodeType() == Node.ELEMENT_NODE) {
							Element locationElement = (Element) nodeNested;
							System.out.println("Temperature : " + ((Element)locationElement.getElementsByTagName(TEMPERATURE).item(0)).getAttribute("value"));
							System.out.println("Humidity : " + ((Element)locationElement.getElementsByTagName(HUMIDITY).item(0)).getAttribute("value"));
							System.out.println("Dew point : " + ((Element)locationElement.getElementsByTagName(DEWPOINT_TEMPERATURE).item(0)).getAttribute("value"));
							System.out.println("Fog : " + ((Element)locationElement.getElementsByTagName(FOG).item(0)).getAttribute("percent"));
							System.out.println("lowClouds  : " + ((Element)locationElement.getElementsByTagName(LOW_CLOUDS).item(0)).getAttribute("percent"));
							System.out.println("mediumClouds : " + ((Element)locationElement.getElementsByTagName(MEDIUM_CLOUDS).item(0)).getAttribute("percent"));
							System.out.println("highClouds  : " + ((Element)locationElement.getElementsByTagName(HIGH_CLOUDS).item(0)).getAttribute("percent"));
							
							/**********************************************************/
							
							feedItem.setTemperature(((Element)locationElement.getElementsByTagName(TEMPERATURE).item(0)).getAttribute("value"));
							feedItem.setHumidity(((Element)locationElement.getElementsByTagName(HUMIDITY).item(0)).getAttribute("value"));
							feedItem.setDewpointTemperature(((Element)locationElement.getElementsByTagName(DEWPOINT_TEMPERATURE).item(0)).getAttribute("value"));
							feedItem.setFog(((Element)locationElement.getElementsByTagName(FOG).item(0)).getAttribute("percent"));
							feedItem.setLowClouds(((Element)locationElement.getElementsByTagName(LOW_CLOUDS).item(0)).getAttribute("percent"));
							feedItem.setMediumClouds(((Element)locationElement.getElementsByTagName(MEDIUM_CLOUDS).item(0)).getAttribute("percent"));
							feedItem.setHighClouds(((Element)locationElement.getElementsByTagName(HIGH_CLOUDS).item(0)).getAttribute("percent"));
						}
					}
				}
				break;
			}
			
			System.out.println("============================");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return feedItem;
	}


}
