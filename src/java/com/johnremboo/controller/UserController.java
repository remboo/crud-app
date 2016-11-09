package com.johnremboo.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = UserManager.initAction(request, response);

        switch (action) {
            case "list":
                UserManager.displayUserList(request, response);
                break;
            case "edit":
                UserManager.editUser(request, response);
                break;
            case "add":
                UserManager.fillInUserForm(request, response);
                break;
            default:
                UserManager.error(request, response, "Unknown request", null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = UserManager.initAction(request, response);

        switch (action) {
            case "update":
                UserManager.updateUser(request, response);
                break;
            case "list":
                UserManager.displayUserList(request, response);
                break;
            case "delete":
                //todo realize
                break;
            case "add":
                try {
                    UserManager.addUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                UserManager.error(request, response, "Unknown request", null);
        }
    }
}