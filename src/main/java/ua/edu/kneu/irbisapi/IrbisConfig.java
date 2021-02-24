package ua.edu.kneu.irbisapi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.arsmagna.IrbisConnection;
import ru.arsmagna.IrbisException;

import java.io.IOException;

@Configuration
@ConfigurationProperties("irbis")
@EnableScheduling
public class IrbisConfig {
    private String host;
    private int port;
    private String user;
    private String password;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bean(destroyMethod = "disconnect")
    public IrbisConnection getConnection() {
        var connection = new IrbisConnection();
        connection.host = host;
        connection.port = port;
        connection.username = user;
        connection.password = password;
        try {
            connection.connect();
            return connection;
        } catch (IrbisException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public IFormatRecordsConverter getFormatRecordsConverter() {
        return new AllFormatRecordsConverter();
    }

}
