package cloudwatch;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;

import ec2_device_manager.AddInstances;

public class Monitor {

	
	//private static String metric = "CPUUtilization";
	
	


	public  static java.util.List<Datapoint> monitorInstances(String instanceId,String location,String metric) {
		
		System.out.println("instanceId::::"+ instanceId);
		System.out.println("location::::"+ location);
		System.out.println("metric::::"+ metric);
		
		AWSCredentials credentials = null;
		try {
			credentials = new PropertiesCredentials(
					AddInstances.class
							.getResourceAsStream("AwsCredentials.properties"));
		} catch (IOException e1) {
			System.out.println("Wrong Credentials");
			System.out.println(e1.getMessage());
			System.exit(-1);
		}

		AmazonCloudWatchClient cloudWatch = new AmazonCloudWatchClient(credentials);
		
		
		if (location.equals("Oregon")) {
			Region usWest2 = Region.getRegion(Regions.US_WEST_2);
			cloudWatch.setRegion(usWest2);
			

		}

		if (location.equals("N.California")) {
			Region usWest1 = Region.getRegion(Regions.US_WEST_1);
			cloudWatch.setRegion(usWest1);
			
		}
		if (location.equals("N.Virginia")) {
			Region usEast1 = Region.getRegion(Regions.US_EAST_1);
			cloudWatch.setRegion(usEast1);
			
		}
		
		
		
		System.out.println("::Service Name::" + cloudWatch.getServiceName());
		System.out.println("::getRequestMetricsCollector::"
				+ cloudWatch.getRequestMetricsCollector());
		
		//metric
		GetMetricStatisticsRequest getMetricStatisticsRequest = new GetMetricStatisticsRequest();
		//getMetricStatisticsRequest.setMetricName("CPUUtilization");
		getMetricStatisticsRequest.setMetricName(metric);
		
		
		//end time
		Calendar cal = Calendar.getInstance();
//			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//			format1.format(cal.getTime());
		getMetricStatisticsRequest.setEndTime(cal.getTime());
		System.out.println("end time" + cal.getTime());
		
		
		
		//start time
		cal.setTime(cal.getTime());
		cal.add(Calendar.MINUTE, -60);
		getMetricStatisticsRequest.setStartTime(cal.getTime());
		System.out.println("start time" + cal.getTime());
		
		
		getMetricStatisticsRequest.setNamespace("AWS/EC2");
		getMetricStatisticsRequest.setPeriod(60);

		Dimension instanceDimension = new Dimension();
		instanceDimension.setName("InstanceId");
		instanceDimension.setValue(instanceId);
		System.out.println("instanceId = "
				+ instanceId);
		getMetricStatisticsRequest.setDimensions(Arrays
				.asList(instanceDimension));

		Collection<String> statistics = new ArrayList<String>();
		statistics.add("Average");
		statistics.add("Maximum");
		statistics.add("Minimum");

		getMetricStatisticsRequest.setStatistics(statistics);
		// getMetricStatisticsRequest.setUnit(StandardUnit.Count);

		GetMetricStatisticsResult getMetricStatisticsResult = cloudWatch
				.getMetricStatistics(getMetricStatisticsRequest);
		System.out.println("label = "
				+ getMetricStatisticsResult.getLabel());
		System.out.println("getMetricStatisticsResult = "
				+ getMetricStatisticsResult);
		
		List<Datapoint> listData = getMetricStatisticsResult
				.getDatapoints();
		
//			Collections.sort(listData, new CompData());
		System.out.println("getMetricStatisticsResult.getDatapoints() = "
				+ listData);
		return listData;
		

	}

	public static void main(String args[]) {

		//monitorInstances("i-e2947915","Oregon","CPUUtilization");
		
	}

}