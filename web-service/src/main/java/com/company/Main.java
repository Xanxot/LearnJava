package com.company;

import com.company.dbService.DbServiceHibernate;
import com.company.web.UserServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    private final static Integer PORT = 8080;

    public static void main(String[] args) throws Exception {
        new Main().start();
    }

    private void start() throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new UserServlet(new DbServiceHibernate())), "/user");


        Server server = new Server(PORT);
        server.setHandler(new HandlerList(context));


        server.start();
        server.join();
    }
}
