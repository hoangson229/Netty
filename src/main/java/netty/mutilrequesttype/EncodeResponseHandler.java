package netty.mutilrequesttype;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.commons.lang3.SerializationUtils;

public class EncodeResponseHandler extends MessageToByteEncoder<IResponse> {


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, IResponse iResponse, ByteBuf byteBuf) throws Exception {
        System.out.println("netty.mutilrequesttype.EncodeResponseHandler  ---->");
        byte[] data = SerializationUtils.serialize(iResponse);
        byteBuf.writeBytes(data);
    }
}
