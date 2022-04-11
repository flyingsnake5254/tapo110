package io.netty.handler.proxy;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest;
import io.netty.handler.codec.socksx.v4.Socks4ClientDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ClientEncoder;
import io.netty.handler.codec.socksx.v4.Socks4CommandResponse;
import io.netty.handler.codec.socksx.v4.Socks4CommandStatus;
import io.netty.handler.codec.socksx.v4.Socks4CommandType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class Socks4ProxyHandler
  extends ProxyHandler
{
  private static final String AUTH_USERNAME = "username";
  private static final String PROTOCOL = "socks4";
  private String decoderName;
  private String encoderName;
  private final String username;
  
  public Socks4ProxyHandler(SocketAddress paramSocketAddress)
  {
    this(paramSocketAddress, null);
  }
  
  public Socks4ProxyHandler(SocketAddress paramSocketAddress, String paramString)
  {
    super(paramSocketAddress);
    paramSocketAddress = paramString;
    if (paramString != null)
    {
      paramSocketAddress = paramString;
      if (paramString.isEmpty()) {
        paramSocketAddress = null;
      }
    }
    this.username = paramSocketAddress;
  }
  
  protected void addCodec(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    ChannelPipeline localChannelPipeline = paramChannelHandlerContext.pipeline();
    paramChannelHandlerContext = paramChannelHandlerContext.name();
    Object localObject = new Socks4ClientDecoder();
    localChannelPipeline.addBefore(paramChannelHandlerContext, null, (ChannelHandler)localObject);
    this.decoderName = localChannelPipeline.context((ChannelHandler)localObject).name();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.decoderName);
    ((StringBuilder)localObject).append(".encoder");
    localObject = ((StringBuilder)localObject).toString();
    this.encoderName = ((String)localObject);
    localChannelPipeline.addBefore(paramChannelHandlerContext, (String)localObject, Socks4ClientEncoder.INSTANCE);
  }
  
  public String authScheme()
  {
    String str;
    if (this.username != null) {
      str = "username";
    } else {
      str = "none";
    }
    return str;
  }
  
  protected boolean handleResponse(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    paramChannelHandlerContext = ((Socks4CommandResponse)paramObject).status();
    if (paramChannelHandlerContext == Socks4CommandStatus.SUCCESS) {
      return true;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("status: ");
    ((StringBuilder)paramObject).append(paramChannelHandlerContext);
    throw new ProxyConnectException(exceptionMessage(((StringBuilder)paramObject).toString()));
  }
  
  protected Object newInitialMessage(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Object localObject = (InetSocketAddress)destinationAddress();
    if (((InetSocketAddress)localObject).isUnresolved()) {
      paramChannelHandlerContext = ((InetSocketAddress)localObject).getHostString();
    } else {
      paramChannelHandlerContext = ((InetSocketAddress)localObject).getAddress().getHostAddress();
    }
    Socks4CommandType localSocks4CommandType = Socks4CommandType.CONNECT;
    int i = ((InetSocketAddress)localObject).getPort();
    localObject = this.username;
    if (localObject == null) {
      localObject = "";
    }
    return new DefaultSocks4CommandRequest(localSocks4CommandType, paramChannelHandlerContext, i, (String)localObject);
  }
  
  public String protocol()
  {
    return "socks4";
  }
  
  protected void removeDecoder(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.pipeline().remove(this.decoderName);
  }
  
  protected void removeEncoder(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.pipeline().remove(this.encoderName);
  }
  
  public String username()
  {
    return this.username;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\proxy\Socks4ProxyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */