package connection;


public class Image {
	
	private String imageId = null;
    private String imageName = null;
    private int cloudId = 0;
    private double cost = 0;
    
   
    public Image() {
    }

    public Image(String imageId,String imageName,int cloudId,double cost) {
    	this.imageId = imageId;
    	this.imageName = imageName;
    	this.cloudId = cloudId;
    	this.cost = cost;
        
    }

    
    
    public int getCloudId() {
        return this.cloudId;
    }
    
    public String getImageName() {
        return this.imageName;
    }
    
    public String getImageId() {
        return this.imageId;
    }
    
    public Double getCost() {
        return this.cost;
    }
   
    
   
    
    public void setCloudId(int cloudId) {
        this.cloudId = cloudId;
    }
    
    public void setInstanceId(String imageId) {
        this.imageId = imageId;
    }
    
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    public void setCost(Double cost) {
        this.cost = cost;
    }
   

}
