package kuroneko.fun.netty.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class NettyClientDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(NettyClientDemoApplication.class, args);

  }

  @Slf4j
  @Service
  @RocketMQMessageListener(topic = "server",consumerGroup = "netty")
 public static class ClientConsumer implements RocketMQListener<String>{

   @Override
   public void onMessage(String s) {
     log.info("success:{}",s);
   }
 }
}
