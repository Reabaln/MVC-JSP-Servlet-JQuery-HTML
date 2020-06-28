// @Reabaln
// This class communicate with the Database to store and retrieve info.  
package mvc;
import java.text.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;

public class StudentDao {
	
	 static Connection currentCon = null;
     static ResultSet rs = null; 
	
	
     public static void storeData(StudentBean bean) {
	
        //preparing some objects for connection 
        PreparedStatement stmt = null;    
	
    	String studentID =bean.getStudentID();
        String username= bean.getUsername();
        String street= bean.getStreet();
        Integer zip=bean.getZip();
        String city= bean.getCity();
        String state=bean.getState();
        String phone=bean.getPhone();
        String email= bean.getEmail();
        String website= bean.getWebsite();
        String surverydate= bean.getSurverydate();
        String[] interest= bean.getInterest();
        String howInterest= bean.getHowInterest();
        String gradMonth =bean.getGradMonth();
        String gradYear= bean.getGradYear();
        String recommendation= bean.getRecommendation();
        String comments = bean.getComments();
        String numberSet= bean.getNumberSet();
	    System.out.println("1"+ studentID+username+ street+ zip+ city+ state+ phone+ email+ website+surverydate+ interest[0]+howInterest+ gradMonth+ gradYear+ recommendation + comments+ numberSet);
        String storeQuery ="insert into STUDENTS "+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

     // "System.out.println" prints in the console; Normally used to trace the process
     System.out.println("Your user Student ID is " + studentID);          
     System.out.println("Query: "+storeQuery);
	     
     try 
     {
        //connect to DB 
        currentCon = DBConnection.getConnection();
        stmt=currentCon.prepareStatement(storeQuery);
        stmt.setString(1, studentID);
        stmt.setString(2, username);
        stmt.setString(3, street);
        stmt.setInt(4, zip);
        stmt.setString(5, city);
        stmt.setString(6, state);
        stmt.setString(7, phone);
        stmt.setString(8, email);
        stmt.setString(9, website);
        stmt.setString(10, surverydate);
        
        //Special case handling for array:
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < interest.length; i++) {
            // push each hobby into a string builder at the end
            if (i == (interest.length - 1)) {
                // do not append a semicolon after the last hobby
                sb.append(interest[i]);
            } else {
                // append the hobby and a semicolon
                sb.append(interest[i]);
                sb.append(";");
            }
        }
        //End
        stmt.setString(11, sb.toString());
        stmt.setString(12, howInterest);
        stmt.setString(13, gradMonth);
        stmt.setString(14, gradYear);
        stmt.setString(15, recommendation);
        stmt.setString(16, comments);
        stmt.setString(17, numberSet);
        //Execute the update:
        stmt.executeUpdate();

       
     } 

     catch (Exception ex) 
     {
        System.out.println("failed to store data: An Exception has occurred! " + ex);
        ex.printStackTrace(System.out);

     } 
	    
 

	
     }	
     
     public static StudentBean retriveData (String ID) {
    	 //preparing some objects for connection 
         PreparedStatement stmt = null;    
    	 String searchQuery ="select * from STUDENTS where STUDENTID=" + ID;     
    	 StudentBean studentBean = new StudentBean();
    	 try 
         {
            //connect to DB 
            currentCon = DBConnection.getConnection();
            stmt=currentCon.prepareStatement(searchQuery);
            ResultSet rs;
            rs = stmt.executeQuery();
            while(rs.next()){
            	String studentID =rs.getString(1);
                String username = rs.getString(2);
                String street=rs.getString(3);
                Integer zip=rs.getInt(4);
                String city= rs.getString(5);
                String state=rs.getString(6);
                String phone= rs.getString(7);
                String email = rs.getString(8);
                String website = rs.getString(9);
                String surveyDate = rs.getString(10);
                String interest= rs.getString(11);
                String howInterest= rs.getString(12);
                String gradMonth= rs.getString(13);
                String gradYear= rs.getString(14);
                String recommendation= rs.getString(15);
                String comments= rs.getString(16);
                String numberSet= rs.getString(17);
                //populating the StudenBean object
                studentBean.setStudentID(studentID);
        		studentBean.setUsername(username);
        		studentBean.setStreet(street);
        		studentBean.setZip(Integer.valueOf(zip));
        		studentBean.setCity(city);
        		studentBean.setState(state);
        		studentBean.setPhone(phone);
        		studentBean.setEmail(email);
        		studentBean.setWebsite(website);
        		studentBean.setSurverydate(surveyDate);
        		studentBean.setInterest(interest);
        		studentBean.setHowInterest(howInterest);
        		studentBean.setGradMonth(gradMonth);
        		studentBean.setGradYear(gradYear);
        		studentBean.setRecommendation(recommendation);
        		studentBean.setComments(comments);
        		studentBean.setNumberSet(numberSet);
            	
            }
            
     

         }
         catch (Exception ex) 
         {
            System.out.println("failed to store data: An Exception has occurred! " + ex);
            ex.printStackTrace(System.out);

         } 
    	         
				return studentBean;

     }
     
     //Retrive all ID in DB
     public static ArrayList <String>allID () {
    	  PreparedStatement stmt = null;    
     	 String searchQuery ="select STUDENTID from STUDENTS ";   
     	 int counter = 0;
         ArrayList<String> IdList= new ArrayList<String>();
     	 try 
          {
             //connect to DB 
             currentCon = DBConnection.getConnection();
             stmt=currentCon.prepareStatement(searchQuery);
             ResultSet rs;
             rs = stmt.executeQuery();
        	// System.out.println(rs.getRow());
             while(rs.next()){
            	 counter++;
            	 IdList.add(rs.getString(1));
            	 
             }


     }
     	 catch (Exception ex) 
         {
            System.out.println("failed to retrive  ID data: An Exception has occurred! " + ex);
            ex.printStackTrace(System.out);

         } 
     	 return IdList;
     
     
     
     }
     
     
	public static void main(String[] args) {
		
		allID();
	}
}
