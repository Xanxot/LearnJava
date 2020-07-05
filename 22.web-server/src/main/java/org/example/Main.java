package org.example;

import com.google.gson.Gson;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.filter.AuthFilter;
import org.example.servlet.LoginServlet;
import org.example.servlet.UserServlet;
import org.example.user.InMemoryUserDao;
import org.example.user.UserService;

/*
 * 1) Написать сервлет, который на GET запрос возвращает сущность User в формате JSON.
 * Имя пользователя передается в параметре name. Если параметр не передан - возвращать всех пользователей
 *
 * 2) Написать сервлет, который на PUT запрос создает User.
 * Данные приходят в формате JSON.
 *
 * 3) Написать сервлет, который на PUT запрос изменяет User. Ключ - name.
 *
 * 4) Написать сервлет, который на DELETE запрос удаляет User. Ключ - name.
 *
 * */


/*
 *
 * 1) Реализовать сервлет, который на /login будет проводить аутентификацию пользователя
 *
 * */

/*
 *
 * 1) Написать Filter для авторизации на /user.
 * Редактировать и удалять существующего пользователя могут только авторизованные пользователи
 *
 * 2) Максимальное время жизни неактивной сессии 30 сек
 *
 * 3) Хранить в cookie имя пользователя. Cookie живут столько же, сколько сессия.
 *
 * 4)* Пользователь может менять только свой пароль
 *
 * */

public class Main {
    private final static int PORT = 8080;

    public static void main(String[] args) throws Exception {
        new org.example.Main().start();
    }

    private void start() throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new UserServlet()), "/user");
        context.addServlet(new ServletHolder(new LoginServlet()),"/login");
        context.addFilter(new FilterHolder(new AuthFilter()),"/user",null);


        Server server = new Server(PORT);
        server.setHandler(new HandlerList(context));


        server.start();
        server.join();
    }

    private UserService userService() {
        return new UserService(userDao());
    }


    private InMemoryUserDao userDao() {
        return new InMemoryUserDao();
    }

    private Gson gson() {
        return new Gson();
    }

}
