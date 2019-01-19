package reader;

public class ReadTest {

	public XMLItem getFeedItem(double lat, double lon) {
		XMLParser parser = new XMLParser("https://api.met.no/weatherapi/locationforecast/1.9/?lat=" + lat + ";lon=" + lon);
		XMLItem feedItem = parser.readFeed();
		System.out.println(feedItem);
		return feedItem;
	}

	public static void main(String[] args) {
		/*
		  XMLParser parser=new XMLParser("https://api.met.no/weatherapi/locationforecast/1.9/?lat=11.43;lon=12.12"); 
		  FeedItem feedItem = parser.readFeed();
		  System.out.println(feedItem); 
		  getFeedItem(11.43, 12.12);	 
		 */
	}

}
