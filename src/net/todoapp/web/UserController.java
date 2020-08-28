package net.todoapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.todoapp.dao.UserDao;
import net.todoapp.model.User;

@WebServlet("/register")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		register(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect("register/register.jsp");
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//get data form request
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		//set data to  User Bean
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(userName);
		user.setPassword(password);

		//set data to DB
		try{
			int result = userDao.registerUser(user);
			if (result == 1){
				req.setAttribute("NOTIFICATION", "User register success.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		//pass data to register.jsp
		RequestDispatcher dispatcher = req.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(req, resp);
	}

}
