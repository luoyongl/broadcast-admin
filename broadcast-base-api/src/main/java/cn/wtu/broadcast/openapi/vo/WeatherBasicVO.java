package cn.wtu.broadcast.openapi.vo;

public class WeatherBasicVO implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 11565213L;
	
	private Integer cid;

    private String lat;

    private String lon;

    private String env;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	

}
