package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jdbc.PersonConnection;
import model.PersonInfo;


/**
 * Servlet implementation class Submit
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		try {
			connection = PersonConnection.getConnection();
			System.out.println("Connection established");

		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("Connection not established");
		}

		PreparedStatement statement = null;

		String fullName = "";

		try {
			statement = connection.prepareStatement("insert into personinfo(name, email, password, phone, gender) values(?, ?, ?, ?, ?)");
			fullName = request.getParameter("fname") + " " + request.getParameter("lname");

			String email = request.getParameter("email");
			String phone = request.getParameter("phone");

			String password = (request.getParameter("password"));
			String gender = request.getParameter("gender");

			PersonInfo p = new PersonInfo(email, password);

			statement.setString(1, fullName);
			statement.setString(2, p.getEmail());
			statement.setString(3, p.getPassword());
			statement.setString(4, phone);
			statement.setString(5, gender);

			statement.executeQuery();
		} catch (SQLException e) {	
			e.printStackTrace();
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("submitPage.html");
		//requestDispatcher.include(request, response);

		out.println("<h2 class='text-center'>"+ fullName+ " has been added to the database</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
