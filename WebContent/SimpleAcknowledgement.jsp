<!-- @Reabaln-->
<!-- This will be rendered when the mean is <90 to acknowledge the receipt of info -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acknowledgement</title>

<style>
div {
  height: 260px;
  width: 75%;
  background-color: #e1f2e7;
  padding: 30px;
  border-style: groove;

}

p {
font-weight: bold;
}
</style>

</head>
<body>
<div>
<h1> Thank you! your submission has been received successfully</h1>
<P>The median for the 10 numbers: </P>
 ${DataBean.getMean()}
 <P>The standard deviation for the 10 numbers: </P>
  ${DataBean.getStandardDev()}
  	<br>
  	<br>
    <br>
    <br>
    <br>
    <br>
    <br>
      <P> List of ID in Database:</P>
   		<c:forEach var="String" items="${IdBean.getIdList()}">
    	   <li><a href="Controller?value=${String}">${String}</a></li> 
    	</c:forEach>

 

</div>
</body>
</html>