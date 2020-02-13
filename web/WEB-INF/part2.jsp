<%-- 
    Document   : part2
    Created on : Feb 11, 2020, 2:45:06 PM
    Author     : 787900
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <h2>${mess}</h2>
         
        <form method="POST" action="/CPRG-352PracticeExam1/part2">
           Name: <input type="text" name="name"><br/> 
           Age: <input type="text" name="age"><br/><br/>
        
        <input type="submit" value="Add"  name ="add"    /> <br/>
        ${add}
        The average are: ${average}
        <br/>
        </br>
        
       
        </form>
    </body>
</html>
