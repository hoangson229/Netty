import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class EncodeRequestHandler extends MessageToByteEncoder<IRequest> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, IRequest iRequest, ByteBuf byteBuf) throws Exception {
        System.out.println("EncodeRequestHandler iRequest--> " + iRequest);
        byte[] data = SerializationUtils.serialize(iRequest);
        byteBuf.writeBytes(data);
    }
}
