// @Reabaln
//Stores the mean and Standard deviation
package mvc;

public class DataBean {
	
	private double mean; 
	private double standardDev; 
	
	public DataBean(float mean, double standardDev) {
		this.mean=mean;
		this.standardDev=standardDev; 
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) { 
		this.mean = mean;
	}
	public double getStandardDev() {
		return standardDev;
	}
	public void setStandardDev(double standardDev) {
		this.standardDev = standardDev;
	}


}
