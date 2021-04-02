package kuroneko.fun.netty.client.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import kuroneko.fun.netty.client.decoder.Decoder;
import kuroneko.fun.netty.client.encoder.Encoder;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {

//  @Override
//  protected void initChannel(SocketChannel ch) throws Exception {
//    ch.pipeline().addLast(new ClientDecoder());
//    ch.pipeline().addLast(new StringEncoder());
////    ch.pipeline().addLast(new ClientEncoder());
//    ch.pipeline().addLast(new ClientHandler());
//  }
  @Override
  protected void initChannel(SocketChannel ch) throws Exception {

    ch.pipeline().addLast(new Encoder());
    ch.pipeline().addLast(new Decoder());
    ch.pipeline().addLast(new ClientHandler());
  }
}
