package kuroneko.fun.netty.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "netty.client.config")
@Configuration
@Data
public class ClientConfig {
    private String ip;
    private Integer port;
}
