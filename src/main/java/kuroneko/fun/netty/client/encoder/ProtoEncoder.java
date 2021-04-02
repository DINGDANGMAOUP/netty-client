//package kuroneko.fun.netty.client.encoder;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.MessageToByteEncoder;
//
//public class ProtoEncoder extends MessageToByteEncoder<MessageProto.Message> {
//
//  @Override
//  protected void encode(ChannelHandlerContext channelHandlerContext, Message msg,
//      ByteBuf out) throws Exception {
//    out.writeBytes(msg.getMsg().getBytes());
//  }
//}
