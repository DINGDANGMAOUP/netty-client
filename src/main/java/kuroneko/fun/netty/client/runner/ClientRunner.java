package kuroneko.fun.netty.client.runner;

import io.netty.channel.ChannelFuture;
import javax.annotation.Resource;
import kuroneko.fun.netty.client.config.ClientConfig;
import kuroneko.fun.netty.client.utils.ClientBootStrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientRunner implements ApplicationRunner {

  @Resource
  ClientConfig clientConfig;
  @Resource
  ClientBootStrap clientBootStrap;
  @Override
  public void run(ApplicationArguments args) {
    ChannelFuture future = clientBootStrap.start(clientConfig.getIp(), clientConfig.getPort());
    Runtime.getRuntime().addShutdownHook(new Thread(){
      @Override
      public void run(){
        clientBootStrap.destroy();
      }
    });
    future.channel().closeFuture().syncUninterruptibly();
  }
}
