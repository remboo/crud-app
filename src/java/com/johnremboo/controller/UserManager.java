package com.johnremboo.controller;

import com.johnremboo.dao.BaseDao;
import com.johnremboo.model.User;
import com.johnremboo.utils.DbConnector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class UserManager {
	private static final String ADD_ACTION_FORWARD = "/addUser.jsp";
	private static final String LIST_ACTION_FORWARD = "/listUsers.jsp";
	private static final String EDIT_ACTION_FORWARD = "/editUser.jsp";
	private static final String UPDATE_ACTION_FORWARD = "/manageUser?action=list";
	private static final String ERROR_ACTION_FORWARD = "/errors.jsp";
	private static final String SUCCESS_ACTION_FORWARD = "/success.jsp";

	private static BaseDao<User> userDao;
	
	public static void displayUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Map<String, Object> model = new HashMap<>();
			model.put("users", userDao.getAll());
			userDao.closeConnection();
			request.setAttribute("model", model);
		} catch (SQLException e) {
			error(request, response, null, e);
		}
		request.getRequestDispatcher(LIST_ACTION_FORWARD).forward(request, response);
	}
	
	public static void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userId = request.getParameter("id");
			User user = userDao.getById(Integer.parseInt(userId));
			
			userDao.closeConnection();
			request.setAttribute("user", user);
			request.getRequestDispatcher(EDIT_ACTION_FORWARD).forward(request, response);
		} catch (Exception e) {
			error(request, response, null, e);
		}
	}
	
	public static void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userId = request.getParameter("id");
			User user = userDao.getById(Integer.parseInt(userId));
			
			if (user != null) {
				user.setName(request.getParameter("name"));
				user.setSurname(request.getParameter("surname"));
				user.setYear(Integer.parseInt(request.getParameter("year")));
				userDao.update(user);
				
				userDao.closeConnection();
			} else {
				userDao.closeConnection();
				error(request, response, "User doesn't exist", null);
			}
			
			request.getRequestDispatcher(UPDATE_ACTION_FORWARD).forward(request, response);
		} catch (Exception e) {
			error(request, response, null, e);
		}
	}

	public static void fillInUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher(ADD_ACTION_FORWARD).forward(request, response);
		} catch (Exception e) {
			error(request, response, null, e);
		}

	}

	public static void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		try {
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setSurname(request.getParameter("surname"));
			user.setYear(Integer.parseInt(request.getParameter("year")));
			if (userDao.add(user))
                request.getRequestDispatcher(SUCCESS_ACTION_FORWARD).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String initAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			userDao = DbConnector.getUserDAO();
		} catch (Exception e) {
			error(request, response, null, e);
		}
		return action;
	}
	
	public static void error(HttpServletRequest request, HttpServletResponse response, String msg, Exception e) throws ServletException, IOException {
		if (msg == null) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
		} else {
			request.setAttribute("message", "User doesn't exist");
		}
		request.getRequestDispatcher(ERROR_ACTION_FORWARD).forward(request, response);
	}
}