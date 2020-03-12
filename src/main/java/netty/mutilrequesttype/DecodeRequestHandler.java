package netty.mutilrequesttype;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.commons.lang3.SerializationUtils;

import java.util.List;

public class DecodeRequestHandler extends ByteToMessageDecoder{
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println("netty.mutilrequesttype.DecodeRequestHandler ------> ");

        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        IRequest iRequest = SerializationUtils.deserialize(bytes);
        list.add(iRequest);
    }
}
