<%-- 
    Document   : phrase
    Created on : Feb 11, 2020, 2:38:06 PM
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
         
        <form method="POST" action="/CPRG-352PracticeExam1/part1">
            Enter a motivational phrase: <input type="text" name="phrase"><br/>  <br/>
        
        <input type="submit" value="set phrase"  name ="getPhrase"    /> <br/>
        ${message}
        <br/>
        </br>
         <a href="/CPRG-352PracticeExam1/part2?getPhrase">part2</a>
       
        </form>
    </body>
</html>
