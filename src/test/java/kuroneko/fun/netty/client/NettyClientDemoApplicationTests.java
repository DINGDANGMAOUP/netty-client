//package kuroneko.fun.netty.client;
//
//import javax.annotation.Resource;
//import kuroneko.fun.netty.client.config.ClientConfig;
//import kuroneko.fun.netty.client.proto.MessageProto.Message;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@Slf4j
//@SpringBootTest
//class NettyClientDemoApplicationTests {
//
//    @Resource
//    ClientConfig clientConfig;
//    @Test
//    void contextLoads() {
//        byte[] bytes = Message.newBuilder().setMsg("this is the server").build().toByteArray();
//        log.info("len:<"+bytes.length);
//    }
//
//}
