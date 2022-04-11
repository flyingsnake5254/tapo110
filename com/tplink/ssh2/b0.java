package com.tplink.ssh2;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.reactivex.q;
import io.reactivex.t;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class b0
  implements w
{
  private String a;
  private int b;
  private Bootstrap c;
  private EventLoopGroup d;
  private Channel e;
  private boolean f;
  private w g;
  
  b0(String paramString, int paramInt, w paramw)
  {
    this.a = paramString;
    this.b = paramInt;
    this.g = paramw;
  }
  
  private a0 e()
  {
    Object localObject = new InetSocketAddress(this.a, this.b);
    localObject = this.c.connect((SocketAddress)localObject);
    ((ChannelFuture)localObject).awaitUninterruptibly();
    localObject = ((ChannelFuture)localObject).channel();
    this.e = ((Channel)localObject);
    ((Channel)localObject).config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(10240));
    return new a0(0);
  }
  
  private Bootstrap f()
  {
    this.d = new NioEventLoopGroup();
    Bootstrap localBootstrap = (Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group(this.d)).channel(NioSocketChannel.class)).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, Integer.valueOf(10000))).option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(10240))).handler(new a());
    this.c = localBootstrap;
    return localBootstrap;
  }
  
  q<a0> a()
  {
    return q.X(new d(this)).p0(h.c).E(new g(this));
  }
  
  t<a0> b()
  {
    return q.X(new i(this)).g0(new e(this)).q0(new a0(5, "nio socket address connect fail")).g0(new j(this));
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    w localw = this.g;
    if (localw != null) {
      localw.c(paramArrayOfByte);
    }
  }
  
  public void d(a0 parama0, EnumSSH2Status paramEnumSSH2Status)
  {
    w localw = this.g;
    if (localw != null) {
      localw.d(parama0, paramEnumSSH2Status);
    }
  }
  
  t<a0> s(byte[] paramArrayOfByte)
  {
    return q.f0(paramArrayOfByte).g0(new f(this));
  }
  
  class a
    extends ChannelInitializer<SocketChannel>
  {
    a() {}
    
    protected void a(SocketChannel paramSocketChannel)
      throws Exception
    {
      paramSocketChannel.pipeline().addLast(new ChannelHandler[] { new y() }).addLast(new ChannelHandler[] { new z() }).addLast(new ChannelHandler[] { new c0(b0.this) });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */