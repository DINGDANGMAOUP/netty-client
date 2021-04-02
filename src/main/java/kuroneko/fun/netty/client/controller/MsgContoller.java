package kuroneko.fun.netty.client.controller;

import javax.annotation.Resource;
import kuroneko.fun.netty.client.proto.MessageBase;
import kuroneko.fun.netty.client.utils.ClientBootStrap;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MsgContoller {

  @Resource
  ClientBootStrap clientBootStrap;
  @Resource
  RocketMQTemplate rocketMQTemplate;
  @GetMapping("send/{msg}")
  public String send(@PathVariable("msg") String msg)  {
    MessageBase.Message build = MessageBase.Message.newBuilder().setContent(msg).build();
    clientBootStrap.sendMsg(build);
    return "ok";
  }
  @GetMapping("ok")
  public void mq(){
    rocketMQTemplate.convertAndSend("TopicTest", "Hello, World!");
    rocketMQTemplate.send("TopicTest", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
     log.info("ok");
  }
}
