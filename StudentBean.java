// @Reabaln
//This to store the Student info 
package mvc;

import java.sql.Date;

public class StudentBean {
	
	private String studentID;
    private String username;
    private String street;
    private Integer zip;
    public boolean valid;
    private String city;
    private String state;
    private String phone;
    private String email;
    private String website;
    private String surverydate;
    private String[] interest;
    private String howInterest;
    private String gradMonth;
    private String gradYear;
    private String recommendation;
    private String comments;
    private String numberSet;
    private String interestt;
    
    public String getInterestt() {
		return interestt;
	}


	public StudentBean() {}

				
    public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID2) {
		this.studentID = studentID2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getSurverydate() {
		return surverydate;
	}

	public void setSurverydate(String surverydate) {
		this.surverydate = surverydate;
	}

	public String[] getInterest() {
		return interest;
	}
	

	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	


	public String getHowInterest() {
		return howInterest;
	}

	public void setHowInterest(String howInterest) {
		this.howInterest = howInterest;
	}

	public String getGradMonth() {
		return gradMonth;
	}

	public void setGradMonth(String gradMonth) {
		this.gradMonth = gradMonth;
	}

	public String getGradYear() {
		return gradYear;
	}

	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getNumberSet() {
		return numberSet;
	}

	public void setNumberSet(String numberSet) {
		this.numberSet = numberSet;
	}

	public boolean isValid() {
       return valid;
	}

    public void setValid(boolean newValid) {
       valid = newValid;
	}


	public void setInterest(String interest2) {
		this.interestt=		interest2;
	}	

}