// @Reabaln
// THis the Servlet that will manage all requests. it has two methods:
//(1) doGet() that will return the Student information once the user clicks the link for that user. 
//(2) doPost() that will store the submitted form info to the database and then forward the user
// to the appropriate page. 
package mvc;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
//@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idValue = request.getParameter("value");
		StudentBean student1= StudentDao.retriveData(idValue);
		 request.getSession().setAttribute("StudentBean", student1);

		if (student1.getStudentID()!=null) {
			 RequestDispatcher rd = request.getRequestDispatcher(" StudentJSP.jsp");
		        rd.forward(request, response);
		}
		 RequestDispatcher rd = request.getRequestDispatcher("NoSuchStudentJSP.jsp");
	        rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Getting all the fields values
		String studentID = request.getParameter("StudentID");
		String  username= request.getParameter("Username");
		String  street= request.getParameter("Address");	
		String  zip= request.getParameter("ZIP");
		String  city= request.getParameter("city");
		String  state= request.getParameter("state");
		String  phoneNumber= request.getParameter("Tnumber");
		String  email= request.getParameter("email");
		String  website= request.getParameter("url");
		String  surveyDate= request.getParameter("surveyDate");
		String  interest[]= request.getParameterValues("interest[]");
		String  howInterest= request.getParameter("Howinterest[]");
		String  gradMonth= request.getParameter("months");
		String  gradYear= request.getParameter("year");
		String  recommendation= request.getParameter("recommendation");
		String  comment= request.getParameter("comment");
		String  datafield= request.getParameter("AvgData");
		// Creating object that store the fields
		StudentBean studentBean = new StudentBean();
		studentBean.setStudentID(studentID);
		studentBean.setUsername(username);
		studentBean.setStreet(street);
		studentBean.setZip(Integer.valueOf(zip));
		studentBean.setCity(city);
		studentBean.setState(state);
		studentBean.setPhone(phoneNumber);
		studentBean.setEmail(email);
		studentBean.setWebsite(website);
		studentBean.setSurverydate(surveyDate);
		studentBean.setInterest(interest);
		studentBean.setHowInterest(howInterest);
		studentBean.setGradMonth(gradMonth);
		studentBean.setGradYear(gradYear);
		studentBean.setRecommendation(recommendation);
		studentBean.setComments(comment);
		studentBean.setNumberSet(datafield);
		 
		//Storing the data int the database by calling the StudentDao.storeData()
		StudentDao.storeData(studentBean);
		//key values pairs (session) 
		 request.getSession().setAttribute("StudentBean", studentBean);

		 
		
		//Calling the DataProcessor to compute the Mean/StandardDeviation:
		
		//Preparing the data field to be calculated. 
		String [] myarray = studentBean.getNumberSet().split(",");
		int[] intarray = new int [10];
		for (int i=0 ; i<myarray.length ; i++) {
			
			intarray[i]= Integer.parseInt(myarray[i]);
			System.out.println(intarray[i]);
 
		}
		
		DataProcessor db = new DataProcessor (intarray);
		//Call to DataProcessor compute method() that returns a DataBean object with Mean/SDev
		DataBean data = db.compute();
		//Storing the bean in session: 
		 request.getSession().setAttribute("DataBean", data);
		//End of DataProcessor method call 
		 
		   
	        //List of ID:          
	        IdBean id = new IdBean();
	        ArrayList <String>list = new ArrayList<String>() ;
	        list= StudentDao.allID();
	        id.setIdList(list);
			request.getSession().setAttribute("IdBean", id);
		 
		 //Check the Mean value and forward accordingly to appropriate JSP: 
		 if (data.getMean()>=90) {
			 
			 RequestDispatcher rd = request.getRequestDispatcher("WinnerAcknowledgement.jsp");
		        rd.forward(request, response);
			 
		 }
		 RequestDispatcher rd = request.getRequestDispatcher("SimpleAcknowledgement.jsp");
	        rd.forward(request, response);
	   
		 

	}
	
	
}