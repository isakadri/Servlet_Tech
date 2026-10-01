package isa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/isa")
public class DemoServlets extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Employee Registration</title>");

        pw.println("<style>");
        pw.println("""
                body {
                    font-family: Arial;
                    background-color: #f2f2f2;
                }

                .container {
                    width: 500px;
                    margin: 40px auto;
                    background: white;
                    padding: 25px;
                    border-radius: 10px;
                    box-shadow: 0 0 10px gray;
                }

                h1 {
                    text-align: center;
                }

                label {
                    display: block;
                    margin-top: 12px;
                    font-weight: bold;
                }

                input, select {
                    width: 100%;
                    padding: 9px;
                    margin-top: 5px;
                    box-sizing: border-box;
                }

                input[type="submit"] {
                    margin-top: 20px;
                    background-color: #007bff;
                    color: white;
                    border: none;
                    cursor: pointer;
                    border-radius: 5px;
                }
                """);
        pw.println("</style>");

        pw.println("</head>");
        pw.println("<body>");

        pw.println("<div class='container'>");

        pw.println("<h1>Employee Registration</h1>");

        pw.println("<form action='isa' method='post'>");

        
        pw.println("<label>Employee ID</label>");
        pw.println("<input type='number' name='empId' required>");

  
        pw.println("<label>Full Name</label>");
        pw.println("<input type='text' name='name' required>");


        pw.println("<label>Email</label>");
        pw.println("<input type='email' name='email' required>");


        pw.println("<label>Phone Number</label>");
        pw.println("<input type='tel' name='phone' required>");


        pw.println("<label>Date of Birth</label>");
        pw.println("<input type='date' name='dob' required>");

        // 6
        pw.println("<label>Gender</label>");
        pw.println("<select name='gender' required>");
        pw.println("<option value=''>Select Gender</option>");
        pw.println("<option value='Male'>Male</option>");
        pw.println("<option value='Female'>Female</option>");
        pw.println("<option value='Other'>Other</option>");
        pw.println("</select>");

        // 7
        pw.println("<label>Department</label>");
        pw.println("<select name='department' required>");
        pw.println("<option value=''>Select Department</option>");
        pw.println("<option value='IT'>IT</option>");
        pw.println("<option value='HR'>HR</option>");
        pw.println("<option value='Finance'>Finance</option>");
        pw.println("<option value='Marketing'>Marketing</option>");
        pw.println("</select>");


        pw.println("<label>Designation</label>");
        pw.println("<input type='text' name='designation' required>");


        pw.println("<label>Salary</label>");
        pw.println("<input type='number' name='salary' required>");


        pw.println("<label>Joining Date</label>");
        pw.println("<input type='date' name='joiningDate' required>");

        pw.println("<input type='submit' value='Register Employee'>");

        pw.println("</form>");

        pw.println("</div>");
        pw.println("</body>");
        pw.println("</html>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();

        // Getting values from form
        String empId = request.getParameter("empId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");
        String salary = request.getParameter("salary");
        String joiningDate = request.getParameter("joiningDate");

        pw.println("<html>");
        pw.println("<head><title>Employee Details</title></head>");
        pw.println("<body>");

        pw.println("<h1>Employee Registered Successfully</h1>");

        pw.println("<h2>Employee Details</h2>");

        pw.println("<p><b>Employee ID:</b> " + empId + "</p>");
        pw.println("<p><b>Name:</b> " + name + "</p>");
        pw.println("<p><b>Email:</b> " + email + "</p>");
        pw.println("<p><b>Phone:</b> " + phone + "</p>");
        pw.println("<p><b>Date of Birth:</b> " + dob + "</p>");
        pw.println("<p><b>Gender:</b> " + gender + "</p>");
        pw.println("<p><b>Department:</b> " + department + "</p>");
        pw.println("<p><b>Designation:</b> " + designation + "</p>");
        pw.println("<p><b>Salary:</b> ₹" + salary + "</p>");
        pw.println("<p><b>Joining Date:</b> " + joiningDate + "</p>");

        pw.println("</body>");
        pw.println("</html>");
    }
}