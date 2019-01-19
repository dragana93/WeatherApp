package reader;

public class XMLItem {

	private String time;
	private String location;
	private String temperature;
	private String windDirection;
	private String windSpeed;
	private String humidity;
	private String pressure;
	private String cloudiness;
	private String fog;
	private String lowClouds;
	private String mediumClouds;
	private String highClouds;
	private String dewpointTemperature;
	private String precipitation;
	private String symbol;
	private String minTemperature;
	private String maxTemperature;

	public XMLItem() {
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getCloudiness() {
		return cloudiness;
	}

	public void setCloudiness(String cloudiness) {
		this.cloudiness = cloudiness;
	}

	public String getFog() {
		return fog;
	}

	public void setFog(String fog) {
		this.fog = fog;
	}

	public String getLowClouds() {
		return lowClouds;
	}

	public void setLowClouds(String lowClouds) {
		this.lowClouds = lowClouds;
	}

	public String getMediumClouds() {
		return mediumClouds;
	}

	public void setMediumClouds(String mediumClouds) {
		this.mediumClouds = mediumClouds;
	}

	public String getHighClouds() {
		return highClouds;
	}

	public void setHighClouds(String highClouds) {
		this.highClouds = highClouds;
	}

	public String getDewpointTemperature() {
		return dewpointTemperature;
	}

	public void setDewpointTemperature(String dewpointTemperature) {
		this.dewpointTemperature = dewpointTemperature;
	}

	public String getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(String minTemperature) {
		this.minTemperature = minTemperature;
	}

	public String getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(String maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	@Override
	public String toString() {
		return "FeedItem [time=" + time + ", location=" + location + ", temperature=" + temperature + ", windDirection="
				+ windDirection + ", windSpeed=" + windSpeed + ", humidity=" + humidity + ", pressure=" + pressure
				+ ", cloudiness=" + cloudiness + ", fog=" + fog + ", lowClouds=" + lowClouds + ", mediumClouds="
				+ mediumClouds + ", highClouds=" + highClouds + ", dewpointTemperature=" + dewpointTemperature
				+ ", precipitation=" + precipitation + ", symbol=" + symbol + ", minTemperature=" + minTemperature
				+ ", maxTemperature=" + maxTemperature + "]";
	}
	
	
	


}
