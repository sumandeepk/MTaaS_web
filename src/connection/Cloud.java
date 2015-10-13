package connection;


public class Cloud {
	
	private int cloudId = 0;
    private String location = null;
    private int totalInstances = 0;
   
    public Cloud() {
    }

    public Cloud(int cloudId,String location, int totalInstances) {
    	this.cloudId = cloudId;
    	this.location = location;
    	this.totalInstances = totalInstances;
        
        
    }

    
    
    public int getCloudId() {
        return this.cloudId;
    }
    
    public String getLocation() {
        return this.location;
    }
    
    public int getTotalInstances() {
        return this.totalInstances;
    }
   
    
   
    
    public void setCloudId(int cloudId) {
        this.cloudId = cloudId;
    }
    
    public void setTotalInstances(int totalInstances) {
        this.totalInstances = totalInstances;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
   

}
