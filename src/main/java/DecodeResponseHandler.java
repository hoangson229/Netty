import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.commons.lang3.SerializationUtils;

import java.util.List;

public class DecodeResponseHandler extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {


        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        IResponse iResponse = SerializationUtils.deserialize(bytes);
        list.add(iResponse);
        System.out.println("DecodeResponseHandler ------> " + iResponse);
    }
}

