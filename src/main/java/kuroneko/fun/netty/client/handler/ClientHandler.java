package kuroneko.fun.netty.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.UUID;
import kuroneko.fun.netty.client.proto.MessageBase;
import kuroneko.fun.netty.client.proto.MessageBase.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Sharable
public class ClientHandler extends SimpleChannelInboundHandler<Message> {


  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    MessageBase.Message message = MessageBase.Message.newBuilder().setContent("this is the client").build();
    ctx.channel().writeAndFlush(message);
    log.info("client active...");
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    log.info("client inactive...");
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      MessageBase.Message messageProto) throws Exception {
    log.info("收到消息：{}",messageProto.toString());
//    MessageBase.Message message = MessageBase.Message.newBuilder().setContent("收到").build();
//    ctx.channel().writeAndFlush(message);
  }

//  @Override
//  protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//    log.info("收到消息：{}",msg.toString());
//    ctx.channel().writeAndFlush("收到");
//  }
}
