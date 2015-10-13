package connection;

//import java.math.BigDecimal;

import java.sql.*;
import java.util.ArrayList;








import exception.SignInException;

public class DatabaseConnection {

	Connection con;

	// Database configuration
	public static String url = "jdbc:mysql://localhost:3306/aws_mtaas";
	public static String dbdriver = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "2730";

	Statement stmt = null;

	public DatabaseConnection() {
		try {

			Class.forName(dbdriver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			System.err.println("Couldn't open connection to database: " + ex);

		}
	}



	public User signIn(String email, String password) throws SignInException {

		ArrayList<User> users = new ArrayList<User>();
		
		User selectedUser = null;

		try {
			String sql = "select * from users";

			PreparedStatement prepStmt = con.prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				User p = new User(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5));

				users.add(p);

			}

			
			for (int i = 0; i < users.size(); i++) {

				

				if ((email.equals(users.get(i).getEmail()))
						&& (password.equals(users.get(i).getPassword()))) {
					selectedUser = users.get(i);
				}
			}

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			
            
		}
		return selectedUser;

		

	}

	public User getUser(int userId){
		User p = null;
		try {
			String selectStatement = "select * from users where id = ?";
			
			
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			prepStmt.setInt(1,userId);
			
			
			ResultSet rs = prepStmt.executeQuery();

//			System.out.println("cloud 1"+ rs.next());
//			System.out.println("cloud 2"+ rs.getInt(8));
//			System.out.println("cloud 3"+ rs.getInt(9));
			
			while (rs.next()) {
				p = new User(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));

			}
				
		

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			
            
		}
		

		return p;

	}



	public Instance[] getInstancesforBilling() {

		ArrayList<Instance> instances = new ArrayList<Instance>();
		try {
			String selectStatement = "select * from my_instances";
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			

			ResultSet rs = prepStmt.executeQuery();
			
			
			while (rs.next()) {
				
				Instance bd = new Instance(rs.getString(1), rs.getString(2),
						rs.getInt(3),rs.getInt(4),rs.getDouble("total_amount"),rs.getString("location"));
				instances.add(bd);

			}
			

			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}
		System.out.println("instances in dao"+ instances);
		 for( int i = 0; i< instances.size();i++){
		
			 System.out.println(instances.get(i).getTotalAmount());
		 }
		Instance[] i = instances.toArray(new Instance[instances.size()]);
		
		
		return i;
	}
	
	public Instance[] getInstances() {

		ArrayList<Instance> instances = new ArrayList<Instance>();
		try {
			String selectStatement = "select * from my_instances ";
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			

			ResultSet rs = prepStmt.executeQuery();
			
			
			while (rs.next()) {
				Instance bd = new Instance(rs.getString(1), rs.getString(2),
						rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString("location"));
				instances.add(bd);

			}

			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}

		Instance[] i = instances.toArray(new Instance[instances.size()]);
		return i;
	}
	
	
	public Request[] getRequests() {

		ArrayList<Request> requests = new ArrayList<Request>();
		try {
			String selectStatement = "select * from requests ";
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			

			ResultSet rs = prepStmt.executeQuery();
			
			
			while (rs.next()) {
				Request bd = new Request(rs.getString(1), rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getInt(5),rs.getInt(6));
				requests.add(bd);

			}

			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}

		Request[] i = requests.toArray(new Request[requests.size()]);
		return i;
	}
	
	public Cloud[] getClouds() {

		ArrayList<Cloud> clouds = new ArrayList<Cloud>();
		try {
			String selectStatement = "select * from clouds ";
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			

			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				Cloud bd = new Cloud(rs.getInt(1), rs.getString(2),
						rs.getInt(3));
				clouds.add(bd);

			}

			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}

		Cloud[] c = clouds.toArray(new Cloud[clouds.size()]);
		return c;
	}
	
	public Image[] getImage() {

		ArrayList<Image> images = new ArrayList<Image>();
		try {
			String selectStatement = "select * from images ";
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			

			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				Image bd = new Image(rs.getString(1), rs.getString(2),
						rs.getInt(3),rs.getDouble(4));
				images.add(bd);

			}

			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}

		Image[] c = images.toArray(new Image[images.size()]);
		return c;
	}
	
	public Image[] getImagesFromCloud1() {

		ArrayList<Image> images = new ArrayList<Image>();
		try {
			String selectStatement = "select * from images where clouds_cloud_id = 1 ";
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			

			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				Image bd = new Image(rs.getString(1), rs.getString(2),
						rs.getInt(3),rs.getDouble(4));
				images.add(bd);

			}

			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}

		Image[] c = images.toArray(new Image[images.size()]);
		return c;
	}
	
	public Image[] getImagesFromCloud2() {

		ArrayList<Image> images = new ArrayList<Image>();
		try {
			String selectStatement = "select * from images where clouds_cloud_id = 2";
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			

			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				Image bd = new Image(rs.getString(1), rs.getString(2),
						rs.getInt(3),rs.getDouble(4));
				images.add(bd);

			}

			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}

		Image[] c = images.toArray(new Image[images.size()]);
		return c;
	}
	
	public Image[] getImagesFromCloud3() {

		ArrayList<Image> images = new ArrayList<Image>();
		try {
			String selectStatement = "select * from images where clouds_cloud_id = 3";
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			

			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				Image bd = new Image(rs.getString(1), rs.getString(2),
						rs.getInt(3),rs.getDouble(4));
				images.add(bd);

			}

			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}

		Image[] c = images.toArray(new Image[images.size()]);
		return c;
	}
	
	public void addRequest(Request[] r){
		for(int i=0;i<r.length;i++){
		try {
			String sql = "INSERT INTO requests (request_id,resource_name,resource_type,volume,duration,users_id) VALUES(?,?,?,?,?)";

			PreparedStatement prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, r[i].getRequestId());
			prepStmt.setString(2, r[i].getOs());
			prepStmt.setString(3, r[i].getImageType());
			prepStmt.setInt(4, r[i].getVolume());
			prepStmt.setInt(5, r[i].getDuration());
			prepStmt.setInt(6, r[i].getUserId());
			prepStmt.executeUpdate();
			
			prepStmt.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			
		}
		}
	}
	
	public double getTotalCost(String imageId,int duration){
		
		Double totalCost = 0.0;
		Double cost = 0.0;
		try {
			String selectStatement = "select cost from images where image_id=?";
			
			
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			prepStmt.setString(1,imageId);
			
			System.out.println("sql::" + prepStmt);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
			cost = rs.getDouble("cost");
			}
			System.out.println("cost::" + cost);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			
            
		}
		
        totalCost = cost * (double)duration;
		return totalCost;

	}
	
	public void addInstance(String instanceId, String instanceType, int volume,
		int duration,String imageId,String location) {
 
		String status= "running";
		Double totalCost = getTotalCost(imageId,duration);
	
		try {
			String sql = "INSERT INTO my_instances (instance_id,instance_type,volume,duration,status,users_id,total_amount,location) VALUES(?,?,?,?,?,?,?,?)";

			PreparedStatement prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, instanceId);
			prepStmt.setString(2, instanceType);
			prepStmt.setInt(3, volume);
			prepStmt.setInt(4, duration);
			prepStmt.setString(5, status);
			prepStmt.setInt(6,1);
			prepStmt.setDouble(7,totalCost);
			prepStmt.setString(8,location);

			System.out.println("sql::" + prepStmt);

			prepStmt.executeUpdate();



		} catch (Exception ex) {
			System.err.println(ex.getMessage());

		}

	}


	public void updateInstanceStatus(String instanceId,String status) {
		System.out.println("update instance status");
		try {
			String sql = "update my_instances set status=? where instance_id=?";
			PreparedStatement prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1,status);
			prepStmt.setString(2,instanceId);
			prepStmt.executeUpdate();
			prepStmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}
	
	public void deleteInstance(String instanceId) {
		System.out.println("delete instance");
		try {
			
			String sql = "delete from  my_instances where instance_id=?";
			PreparedStatement prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1,instanceId);
			
			prepStmt.executeUpdate();
			prepStmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}
	
	public void updateCloudAvailability(String imageId){
		
		try {
			int cloudId = 0;
            String selectStatement = "select clouds_cloud_id from images where image_id = ?";
			
			
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			prepStmt.setString(1,imageId);
			
			
			ResultSet rs = prepStmt.executeQuery();
			
			while (rs.next()) {
				cloudId = rs.getInt("clouds_cloud_id");
				} 
			
			String sql = "update clouds set used_instances = used_instances + 1, available_instances = available_instances - 1  where cloud_id = ?";
			PreparedStatement prepStmt1 = con.prepareStatement(sql);
			prepStmt1.setInt(1,cloudId);
			
			prepStmt1.executeUpdate();
			prepStmt1.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

}
