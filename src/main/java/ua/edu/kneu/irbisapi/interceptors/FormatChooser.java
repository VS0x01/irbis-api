package ua.edu.kneu.irbisapi.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ua.edu.kneu.irbisapi.dal.RecordDAO;
import ua.edu.kneu.irbisapi.dal.utils.FormatRecordsFabric;
import ua.edu.kneu.irbisapi.dal.utils.RecordFormats;

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
        recordDAO.setFormat(FormatRecordsFabric.getConverter(RecordFormats.valueOf(format.orElse("All").toUpperCase())));
        return true;
    }

}