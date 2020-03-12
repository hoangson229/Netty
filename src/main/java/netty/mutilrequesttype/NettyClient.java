package netty.mutilrequesttype;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int port = 8080;
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                public void initChannel(SocketChannel ch)
                        throws Exception {
                    ch.pipeline().addLast(new EncodeRequestHandler(),
                            new DecodeResponseHandler(), new ClientHandler());
                }
            });

            Channel f1 = b.connect(host, port).sync().channel();
            LoginRequest msg = new LoginRequest("hoangson", "123abc");
            f1.writeAndFlush(msg);
            f1.closeFuture().sync();

            Channel f2 = b.connect(host, port).sync().channel();
            GetDataRequest getDataRequest = new GetDataRequest("Command1");
            f2.writeAndFlush(getDataRequest);
            f2.closeFuture().sync();


        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
