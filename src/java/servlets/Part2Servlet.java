package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import person.Person;

/**
 *
 * @author 787900
 */
public class Part2Servlet extends HttpServlet {

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Part2Servlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Part2Servlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sum=0;
        ArrayList<Person> list = new ArrayList<>();
      //  processRequest(request, response);
       String path;
            path = getServletContext().getRealPath("/WEB-INF/list.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line ;  
            while((line = br.readLine())!= null)       
        { 
           String userMember[] = new String[2];
           userMember = line.split(",");
           Person oldPerson = new Person(userMember[0],Integer.parseInt(userMember[1]));
           list.add(oldPerson); 
           
             }
            for(Person person: list)
            {
               sum += person.getAge();
            }
            double avg2 =(double) sum/list.size();
          
       
            HttpSession session = request.getSession();
       String getVaPhrase = (String) session.getAttribute("phrase");
        request.setAttribute("average", String.format("%.2f", avg2));
       request.setAttribute("mess", getVaPhrase);
       getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
      ArrayList<Person> list = new ArrayList<>();
       String name = request.getParameter("name");
       String getAge = request.getParameter("age");
       int age = Integer.parseInt(getAge);
       int sum=0;
      if(name.equals("")||getAge.equals(""))
        {
            request.setAttribute("add", "Nothing Adding");
            getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
        }
        else
        {    
            Person newPerson = new Person(name,age);
            list.add(newPerson);
            
            String path;
            path = getServletContext().getRealPath("/WEB-INF/list.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line ;  
            while((line = br.readLine())!= null)       
        { 
           String userMember[] = new String[2];
           userMember = line.split(",");
           Person oldPerson = new Person(userMember[0],Integer.parseInt(userMember[1]));
           list.add(oldPerson); 
           
             }
            
            for(Person person: list)
            {
                System.out.println(person.getAge());
               sum += person.getAge();
               
            }
            double avg = (double)sum / list.size();
            System.out.println(avg);
           request.setAttribute("average", String.format("%.2f", avg));
            System.out.println("play list are:" +list);
            
           
//                request.setAttribute("name", name);
//                request.setAttribute("age", age);  
//                getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
//          
//                HttpSession session = request.getSession();
//                session.setAttribute("name", name);
//                session.setAttribute("age", age);
              //  response.sendRedirect("home");
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true))); 
             pw.print(name);
             pw.print(",");
             pw.println(age);
             pw.close();
             getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response); 
            }
        }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
