package kuroneko.fun.netty.client.utils;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import kuroneko.fun.netty.client.handler.ClientInitializer;
import kuroneko.fun.netty.client.proto.MessageBase;
import kuroneko.fun.netty.client.proto.MessageBase.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientBootStrap {

  private final NioEventLoopGroup group = new NioEventLoopGroup();
  private Channel channel;

  public ChannelFuture start(String host, int port) {
    ChannelFuture channelFuture = null;
    try {
      Bootstrap bootstrap = new Bootstrap().group(group).channel(NioSocketChannel.class)
          .handler(new ClientInitializer()).option(
              ChannelOption.TCP_NODELAY, true);
      channelFuture = bootstrap.connect(host, port).sync();
      channel = channelFuture.channel();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (channelFuture != null && channelFuture.isSuccess()) {
        log.info("client start");
        log.info("client listening " + host + " on port " + port + " and ready for connections...");
      } else {
        log.error("client start up Error!");
      }
    }
    return channelFuture;
  }
  public void sendMsg(MessageBase.Message msg) {
    channel.writeAndFlush(msg);
  }

  /** 停止服务 */
  public void destroy() {
    log.info("Shutdown Netty Client...");
    if (channel != null) {
      channel.close();
    }
    group.shutdownGracefully();
    log.info("Shutdown Netty Client Success!");
  }
}
