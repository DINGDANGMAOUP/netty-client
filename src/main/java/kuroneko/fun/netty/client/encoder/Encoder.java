package kuroneko.fun.netty.client.encoder;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite.Builder;
import com.google.protobuf.MessageOrBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import kuroneko.fun.netty.client.proto.MessageBase.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Encoder extends MessageToByteEncoder<Message> {



  @Override
  protected void encode(ChannelHandlerContext channelHandlerContext, Message msg,
      ByteBuf out) throws Exception {
    byte[] data = msg.toByteArray();
    out.writeInt(data.length);
    out.writeBytes(data);
  }
}
