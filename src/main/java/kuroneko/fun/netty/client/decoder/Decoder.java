package kuroneko.fun.netty.client.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import kuroneko.fun.netty.client.proto.MessageBase.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Decoder extends ByteToMessageDecoder {

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in,
      List<Object> out) throws Exception {
    if (in.readableBytes() < 4) {
      return;
    }
    in.markReaderIndex();
    int dataLength = in.readInt();
    if (in.readableBytes() < dataLength) {
      in.resetReaderIndex();
      return;
    }
    byte[] data = new byte[dataLength];
    in.readBytes(data);
    out.add(Message.parseFrom(data));
  }
  }

