package loadBalancer;




import connection.DatabaseConnection;
import connection.Image;
import connection.Request;
import connection.User;
import ec2_device_manager.AddInstances;

public class AntColonyOptimizer {
	
	
	// Resource Allocation is done by Ant Colony Algorithm
	// run an ant on the trial
	public  synchronized void antColonyRequestProcesor(Request request) {
		
		
		
		String selectedImageId = null;
		String location = null;
		
		Image[] resources = null;
		
		DatabaseConnection db = new DatabaseConnection();
		User user = db.getUser(request.getUserId());
		
		System.out.println("user id + "+ user.getfirstName());
		
//		System.out.println("userId :::::::"+ request.getUserId());
//		System.out.println("distance1==== "+ user.getDistancefromCloud1());
//		System.out.println("distance2==== "+ user.getDistancefromCloud2());
//		System.out.println("distance3==== "+ user.getDistancefromCloud3());
		
	    // if the new rout is better than the current best,replace it	
		if(user.getDistancefromCloud1()< user.getDistancefromCloud2() && user.getDistancefromCloud1()<user.getDistancefromCloud3()){
			
				resources = db.getImagesFromCloud1();
				location = "Oregon";
				System.out.println("Cloud 1");
			
		}
		
		// if the new rout is better than the current best,replace it
		if(user.getDistancefromCloud2()< user.getDistancefromCloud1() && user.getDistancefromCloud2()<user.getDistancefromCloud3()){
			
			resources = db.getImagesFromCloud2();
			location = "N.Virginia";
			System.out.println("Cloud 2");
		
	    }
		
		// if the new rout is better than the current best,replace it
		if(user.getDistancefromCloud3()< user.getDistancefromCloud2() && user.getDistancefromCloud3()<user.getDistancefromCloud1()){
			
			resources = db.getImagesFromCloud3();
			location = "N.California";
			System.out.println("Cloud 3");
		
	    }
		
		while ((request.isAllocated() == false)) {
			
			for (int i = 0; i < resources.length; i++) {
				System.out.println("length:;"+ resources.length);
				String resourceImageName = resources[i].getImageName();
				System.out.println("resourceImageName:"+ resourceImageName);
				System.out.println("request.getOs():"+ request.getOs());
				
				
				 if(resourceImageName.equals(request.getOs())){
					  selectedImageId = resources[i].getImageId();
							      
								// Set the request allocated to true
								request.setAllocated(true);
							
					}
					if (request.isAllocated() == true) {
						System.out.println("Request ID: "
								+ request.getRequestId() + " is Allocated");
						break;
					}

				}
				// break;
			}
		
		 AddInstances a = new AddInstances();
		 try {
			a.addInstances(selectedImageId, location,request.getImageType(),request.getVolume(),request.getDuration(),request.getRequestId());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("ImageId::::;"+ selectedImageId);
		}
	
//   public static void main(String[] args) throws Exception{
//	
//	Request r = new Request("1","Amazon Linux AMI 2015.03 (HVM)","typet2.micro",1,23,1,false);
//    
//	antColonyRequestProcesor(r);
//	}
		
	
}
