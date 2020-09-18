package com.company.web;

import com.company.dbService.DbService;
import com.company.entyties.User;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private static final String APPLICATION_JSON = "application/json;charset=UTF-8";
    private final DbService<User> dbService;

    public UserServlet(DbService<User> dbService) {
        this.dbService = dbService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String id = req.getParameter("id");

        User user = dbService.load(Long.parseLong(id), User.class);
        resp.setContentType(APPLICATION_JSON);

        if (user == null) {
            resp.setStatus(HttpStatus.NOT_FOUND_404);
        }else {

            ServletOutputStream out = resp.getOutputStream();
            out.print(gson.toJson(user));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        if (StringUtils.isBlank(name) || StringUtils.isBlank(age)){
            throw new RuntimeException("Не указаны обязательные параметры");
        }
        User newUser = new User();
        newUser.setName(name);
        newUser.setAge(Integer.parseInt(age));
        dbService.save(newUser);

        resp.setStatus(HttpStatus.OK_200);
        resp.setContentType(APPLICATION_JSON);


    }

}
