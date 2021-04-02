//package kuroneko.fun.netty.client.decoder;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.ByteToMessageDecoder;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class ProtoDecoder extends ByteToMessageDecoder {
//
//
//  @Override
//  protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in,
//      List<Object> out) throws Exception {
//    byte[] length = Message.newBuilder().setMsg("this is the client").getMsgBytes()
//        .toByteArray();
//
//    if (in.readableBytes() < length.length) {
//      return;
//    }
//    CharSequence charSequence = in.readCharSequence(length.length,StandardCharsets.UTF_8);
//    out.add(charSequence);
//    log.info("charSequence:"+charSequence);
//    log.info("in:"+in);
//  }
//}
