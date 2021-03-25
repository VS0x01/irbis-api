package ua.edu.kneu.irbisapi.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.arsmagna.IrbisConnection;
import ua.edu.kneu.irbisapi.Databases;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DBChooser implements HandlerInterceptor {
    IrbisConnection connection;

    public DBChooser(IrbisConnection connection) {
        this.connection = connection;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        connection.pushDatabase(Databases.valueOf(request.getRequestURI().split("/")[1].toUpperCase()).getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        connection.popDatabase();
    }
}
