<!--@Reabaln -->
<!-- This page will be after clicking the Student ID url and will display the student record. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
div {
  height: 100%;
  width: 75%;
  background-color: #e1f2e7;
  padding: 30px;
  border-style: groove;

}

p {
font-weight: bold;
}

h2 {
  text-align: center;
  color: green;

}

	table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  text-align: left;
  padding: 10px;
}


input {
  width: 100%;
  padding: 12px 8px;
  margin: 8px 8px;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
</style>
</head>
<body>

<div>
 
  
  
  <form name="student_survey" id="student_survey" >
  
  <h2> Student Information ID#    ${StudentBean.getStudentID()}</h2> 
	<table>
   <tr>
    <th></th>
    <th></th>
    <th></th>
  </tr>
  <tr>
	<td><p>Student ID: </p></td>
    <td><p>Username:</p></td>
	<td><p> Street address: </p></td> 
  </tr>
  
  <tr>
  	<td> <input type="text" id="StudentID" name="StudentID"  style= "width: 80%" readonly value= ${StudentBean.getStudentID()} ></td>
    <td><input type="text" name="Username" id="Username"  style= "width: 80%" readonly value= ${StudentBean.getUsername()}></td>
	<td><input type="text" name="Address" placeholder="Street" style= "width: 80%" readonly value= ${StudentBean.getStreet()}></td>
  </tr>
  
  <tr>
  	<td> <p>ZIP: </p></td> 
    <td><p>City</p></td>
    <td><p>State</p></td>
  </tr>
  
  
   <tr>
   	<td><input type="text" id="ZIP" name="ZIP"  style= "width: 80%" readonly value= ${StudentBean.getZip()} ></td>
    <td><input type="text" id="city" name="city" style= "width: 80%" readonly value= ${StudentBean.getCity()}> </td>
    <td><input type="text" id="state" name="state"style= "width: 80%" readonly value= ${StudentBean.getState()}> </td>
  </tr>
  
   <tr>
    <td><p>Phone number:</p></td>
   	<td><p>Email:</p></td>
    <td><p>Website:</p></td>
  </tr>
  
   <tr>
    <td><input type="number" name="Tnumber"  style= "width: 80%" readonly value=  ${StudentBean.getPhone()}></td>
   	<td><input type="text" name="email" style= "width: 80%" readonly value=  ${StudentBean.getEmail()}></td>
    <td><input type="text" name="url" style= "width:80%" readonly value=  ${StudentBean.getWebsite()} ></td>
  </tr>
  
  <tr> 
  	<td><p>Date of Survey:</p></td>
  	<td><p> What did you like the most about Gcampus?</p></td>
    <td><p> How did you become interested ?</p></td>
  
  </tr>
  
  <tr>
  	<td> <input type="text" id="datepicker" name="surveyDate"  style= "width:80%" readonly value=  ${StudentBean.getSurverydate()} ></td>
  	<td>	
		<input type="text" id="students" name="interest[]" style= "width:80%" readonly value= ${StudentBean.getInterestt()} >
	 </td>
	
	<td> 
		<input type="text" id="friends" name="Howinterest[]" style= "width:80%" readonly value=  ${StudentBean.getHowInterest()}>
	</td>
   </tr>
  <tr>
  
  
   <td><p>Graduation Month</p></td>
   <td><p>Graduation Year:</p></td>
   <td><p> How Likely are you going to recommend the school to others?</p> </td>
   </tr>
   
   
  <tr> 
  
  <td>
  	  <input type="text" name="months" style= "width:80%" readonly value=  ${StudentBean.getGradMonth()} >
	 
  </td>
  <td>
  <input type="text" name="year" placeholder="Year" style= "width:80%" readonly value=  ${StudentBean.getGradYear()}>
  </td>
  <td>
    <input type="text" style= "width:80%" readonly value=  ${StudentBean.getRecommendation()}>
  </td>
  
  </tr>
  
  <tr>
	  <td><p>Do you have any comments?</p></td>

	  
  </tr>
  <tr>
	  <td>  <textarea rows="3" readonly="readonly" style= "width:80%">${StudentBean.getComments()}</textarea>
	  </td>
  </tr>
  
</table>

	




</form>
  
  </div>
 
</body>
</html>
