package connection;

import java.util.Calendar;
import java.util.Date;

public class User {
	
	private int personId = 0;
    private String firstName = null;
    private String lastName = null;
    private String email = null;
    private String password = null;
    private String location = null;
    private int distancefromCloud1 = 0;
    private int distancefromCloud2 = 0;
    private int distancefromCloud3 = 0;
    
    public User() {
    }

    public User(int personId,String firstName, String lastName,String email, String password,String location,int distancefromCloud1,int distancefromCloud2,int distancefromCloud3) {
    	this.personId = personId;
    	this.firstName = firstName;
    	this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.location = location;
        this.distancefromCloud1 =distancefromCloud1;
        this.distancefromCloud2 = distancefromCloud2;
        this.distancefromCloud3 = distancefromCloud3;
      
        
    }
    
    public User(int personId,String firstName, String lastName,String email, String password) {
    	this.personId = personId;
    	this.firstName = firstName;
    	this.lastName = lastName;
        this.email = email;
        this.password = password;
        
      
        
    }

    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getfirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public int getPersonId() {
        return this.personId;
    }
    
    public String getlocation() {
        return this.location;
    }
    
    public int getDistancefromCloud1() {
        return this.distancefromCloud1;
    }
    
    public int getDistancefromCloud2() {
        return this.distancefromCloud2;
    }
    
    public int getDistancefromCloud3() {
        return this.distancefromCloud3;
    }
   
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName ) {
        this.lastName = lastName;
    }
    
   
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setDistancefromCloud1(int distancefromCloud1) {
        this.distancefromCloud1 = distancefromCloud1;
    }
    
    public void setDistancefromCloud2(int distancefromCloud2) {
        this.distancefromCloud2 = distancefromCloud2;
    }
    
    public void setDistancefromCloud3(int distancefromCloud3) {
        this.distancefromCloud3 = distancefromCloud3;
    }
}
