package org.example.servlet;

import org.example.user.InMemoryUserDao;
import org.example.user.UserDao;
import org.example.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserDao userDao = new InMemoryUserDao();

    UserService userService = new UserService(userDao);
    HttpSession session;
    Cookie cookie;
    int lifeTime = 30;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String valueForName = req.getParameterValues("name")[0];
        String password = req.getParameterValues("password")[0];

        boolean validAuth = userService.authenticate(valueForName, password);

        if (validAuth) {
            req.getSession(true);
            session = req.getSession();
            session.setMaxInactiveInterval(lifeTime);
            cookie = new Cookie("user",valueForName);
            cookie.setMaxAge(lifeTime);
            resp.addCookie(cookie);
        } else {
            resp.getOutputStream().print("Wrong password!");
        }


    }
}
