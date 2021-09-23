package ua.edu.kneu.irbisapi.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dal.util.FormatRecordsFactory;
import ua.edu.kneu.irbisapi.dal.util.RecordFormats;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class FormatChooser implements HandlerInterceptor {
    private final RecordDAO recordDAO;

    public FormatChooser(RecordDAO recordDAO) {
        this.recordDAO = recordDAO;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        final Optional<String> format = Optional.ofNullable(request.getParameter("format"));
        // TODO: replace this with better solution
        recordDAO.setFormat(FormatRecordsFactory.getConverter(RecordFormats.valueOf(format.orElse("All").toUpperCase())));
        return true;
    }

}