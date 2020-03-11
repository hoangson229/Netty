import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception {
//        LoginRequest msg = new LoginRequest("hoangson", "123abc");
//        ctx.writeAndFlush(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        IResponse iResponse = (IResponse) msg;
        if(iResponse instanceof LoginResponse) {
            System.out.println("LoginResponse ----->" + ((LoginResponse) iResponse).getResult());
        }

        if(iResponse instanceof GetDataResponse) {
            System.out.println("GetDataResponse getCommand ----->" + ((GetDataResponse) iResponse).getCommand());
            System.out.println("GetDataResponse getResultData ----->" + ((GetDataResponse) iResponse).getResultData());
        }

        ctx.close();
    }
}
