package netty.mutilrequesttype;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
      IRequest iRequest = (IRequest) msg;
      if(iRequest instanceof LoginRequest) {
          //Add logic check login
          System.out.println("netty.mutilrequesttype.ServerHandler --> " + ((LoginRequest) iRequest).getUsername());
          LoginResponse loginResponse = new LoginResponse("Login Success");
          ChannelFuture future  = ctx.writeAndFlush(loginResponse);
          future.addListener(ChannelFutureListener.CLOSE);
          ctx.close();
      }

      if(iRequest instanceof GetDataRequest) {
          String command = ((GetDataRequest) iRequest).getCommand();
          System.out.println("netty.mutilrequesttype.ServerHandler netty.mutilrequesttype.GetDataRequest --> " + command);
          GetDataResponse getDataResponse = new GetDataResponse(command, "resultData");
          ChannelFuture future  = ctx.writeAndFlush(getDataResponse);
          future.addListener(ChannelFutureListener.CLOSE);
          ctx.close();
      }
    }
}
