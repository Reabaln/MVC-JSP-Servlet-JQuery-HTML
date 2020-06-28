// @Reabaln
//This calculate the mean and standard deviation for the data field numbers.
package mvc;

public class DataProcessor {
	
	
	private int[] data;
	private  float sum;
	private  float mean; 
	private double standardDev; 
	
	public DataProcessor (int[] data) {
		this.data=data;
	} 

	
	public DataBean compute()  {
		sum=0;
		 for(int i = 0; i <data.length; i++) {
	         sum+=data[i];
	      }
		 mean = sum/data.length;	
		 for(double num: data) {
				standardDev += Math.pow(num - mean, 2);
	        }
		 standardDev = Math.sqrt(standardDev/data.length);
		 return new DataBean(mean,standardDev);
		
	}
	
	
	
	


}
