package connection;

public class Instance {

	private String instanceId = null;
	private String instanceType = null;
	private int volume = 0;
	private int duration = 0;
	private String status = null;
	private double totalAmount = 0.0;
	private int userId = 0;
	private String location = null;

	public Instance() {
	}

	public Instance(String instanceId, String instanceType, int volume, int duration,
			String status,String location) {
		this.instanceId = instanceId;
		this.instanceType = instanceType;
		this.volume = volume;
		this.duration = duration;
		this.status = status;
		this.location = location;
	}
	
	public Instance(String instanceId, String instanceType, int volume, int duration,
			Double totalAmount,String location) {
		this.instanceId = instanceId;
		this.instanceType = instanceType;
		this.volume = volume;
		this.duration = duration;
		this.totalAmount = totalAmount;
		this.location = location;
		

	}

	public String getInstanceId() {
		return this.instanceId;
	}

	public String getInstanceType() {
		return this.instanceType;
	}

	public int getVolume() {
		return this.volume;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public Double getTotalAmount() {
		return this.totalAmount;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getLocation() {
		return this.location;
	}

	
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

}
