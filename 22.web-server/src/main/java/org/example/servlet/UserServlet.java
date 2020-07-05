package org.example.servlet;

import com.google.gson.Gson;
import org.example.user.InMemoryUserDao;
import org.example.user.User;
import org.example.user.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    UserDao userDao = new InMemoryUserDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] valuesForName = req.getParameterValues("name");
        if (valuesForName[0] == null) {
            resp.setStatus(404);
        } else {
            User user = userDao.findByName(valuesForName[0]);
            Gson gson = new Gson();
            String userJson = gson.toJson(user);
            resp.setStatus(200);
            resp.getOutputStream().print(userJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String valueForName = req.getParameterValues("name")[0];
        String password = req.getParameterValues("password")[0];
        User user = new User(valueForName,password);
        userDao.save(user);
        resp.setStatus(201);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String valueForName = req.getParameterValues("name")[0];
        String password = req.getParameterValues("password")[0];
        
    }
}
