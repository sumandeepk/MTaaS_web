package connection;

public class Request {

	private String requestId;
	private String geolocation;
	private String os;
	private String imageType;
	private int volume;
	private int duration;
	private int userId;
	private boolean isAllocated;
	
	public Request() {
    }

    public Request(String requestId, String os, String imageType,int volume,int duration,int userId, boolean isAllocated) {
    	this.requestId = requestId;
    	this.os = os;
    	this.imageType = imageType;
    	this.volume = volume;
    	this.duration = duration;
    	this.userId = userId;
    	this.isAllocated = isAllocated;
        
        
    }
    
    public Request(String requestId, String os, String imageType,int volume,int duration,int userId) {
    	this.requestId = requestId;
    	this.os = os;
    	this.imageType = imageType;
    	this.volume = volume;
    	this.duration = duration;
    	this.userId = userId;
    	
        
        
    }


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	public boolean isAllocated() {
		return isAllocated;
	}

	public void setAllocated(boolean isAllocated) {
		this.isAllocated = isAllocated;
	}


	
}