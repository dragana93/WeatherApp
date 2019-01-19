package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import reader.XMLItem;
import reader.ReadTest;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parm = (String) request.getParameter("parm");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		if(("sendData").equals(parm)){
			
			String lat = (String)request.getParameter("latitude");
			String lon = (String)request.getParameter("longitude");
			
			double latitude = Double.parseDouble(lat);
			double longitude = Double.parseDouble(lon);
			
			response.addCookie(new Cookie("latitudeDep", lat));
			response.addCookie(new Cookie("longitudeDep", lon));
			
			processing(latitude, longitude, response);
				
		}else if(("sendDataDest").equals(parm)){
			
			String lat = (String)request.getParameter("latitudeDest");
			String lon = (String)request.getParameter("longitudeDest");
			System.out.println(lat + "" + lon);
			
			double latitude = Double.parseDouble(lat);
			double longitude = Double.parseDouble(lon);
			
			response.addCookie(new Cookie("latitudeDest", lat));
			response.addCookie(new Cookie("longitudeDest", lon));
			
			processing(latitude, longitude, response);
				
		}
			
	}
	
	
	private HashMap<String, String> getMap(){
		HashMap<String, String> map = new HashMap<String, String>();
		String path = getServletContext().getRealPath("/");
		String pathPictures = path + "/pictures";
		//Citanje sadrzaja foldera slike
		String [] pics = new File(pathPictures).list();
		
		for(int i = 0; i < pics.length; i++){
			System.out.println("Kljuc: " + pics[i] + ", vrijednost: " + pics[i]);
			map.put(pics[i], pics[i]);
		}
		return map;
	}
	
	private void processing(double x, double y, HttpServletResponse response) throws IOException{
		PrintWriter pw = response.getWriter();
		ReadTest rt = new ReadTest();	
		XMLItem feedItem = rt.getFeedItem(x, y);
		
		String dewPoint = feedItem.getDewpointTemperature();
		String humidity = feedItem.getHumidity();
		String temperature = feedItem.getTemperature();
		
		double fog = Double.parseDouble(feedItem.getFog());
		double lowClouds = Double.parseDouble(feedItem.getLowClouds());
		double mediumCluods = Double.parseDouble(feedItem.getMediumClouds());
		double highClouds = Double.parseDouble(feedItem.getHighClouds());
		
		HashMap<String, String> map = getMap();
		
		String pictureFog = "";
		String pictureLow = "";
		String pictureMedium = "";
		String pictureHigh = "";
		
		if(fog < 20.0){
			pictureFog = map.get("fog20.png");
		}else if(fog > 20.0 && fog < 50.0){
			pictureFog= map.get("fog20do50.png");
		}else if(fog > 50.0){
			pictureFog = map.get("fog50plus.png");
		}
		
		if(lowClouds < 20.0){
			pictureLow = map.get("low20.png");
		}else if(lowClouds > 20.0 && lowClouds < 50.0){
			pictureLow = map.get("low20do50.png");
		}else if(lowClouds > 50.0){
			pictureLow = map.get("low50plus.png");
		}
		
		if(mediumCluods < 20.0){
			pictureMedium = map.get("medium20.png");
		}else if(mediumCluods > 20.0 && mediumCluods < 50.0){
			pictureMedium = map.get("medium20do50.png");
		}else if(mediumCluods > 50.0){
			pictureMedium = map.get("medium50plus.png");
		}
		
		if(highClouds < 20.0){
			pictureHigh = map.get("high20.png");
		}else if(highClouds > 20.0 && highClouds < 50.0){
			pictureHigh = map.get("high20do50.png");
		}else if(highClouds > 50.0){
			pictureHigh = map.get("high50plus.png");
		}
		
		JSONObject json = new JSONObject();
		try {
			json.put("dewPoint", dewPoint);
			json.put("humidity", humidity);
			json.put("temperature", temperature);
			json.put("fog", fog);
			json.put("lowClouds", lowClouds);
			json.put("mediumCluods", mediumCluods);
			json.put("highClouds", highClouds);
			json.put("pictureFog", pictureFog);
			json.put("pictureLow", pictureLow);
			json.put("pictureMedium", pictureMedium);
			json.put("pictureHigh", pictureHigh);
			
		} catch (JSONException e) {

			e.printStackTrace();
		}	
		
		pw.println(json);
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
