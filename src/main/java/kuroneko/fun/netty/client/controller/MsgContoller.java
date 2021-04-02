package kuroneko.fun.netty.client.controller;

import javax.annotation.Resource;
import kuroneko.fun.netty.client.proto.MessageBase;
import kuroneko.fun.netty.client.utils.ClientBootStrap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgContoller {

  @Resource
  ClientBootStrap clientBootStrap;

  @GetMapping("send/{msg}")
  public String send(@PathVariable("msg") String msg)  {
    MessageBase.Message build = MessageBase.Message.newBuilder().setContent(msg).build();
    clientBootStrap.sendMsg(build);
    return "ok";
  }

}
