package io.netty.handler.proxy;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.socksx.v5.DefaultSocks5CommandRequest;
import io.netty.handler.codec.socksx.v5.DefaultSocks5InitialRequest;
import io.netty.handler.codec.socksx.v5.DefaultSocks5PasswordAuthRequest;
import io.netty.handler.codec.socksx.v5.Socks5AddressType;
import io.netty.handler.codec.socksx.v5.Socks5AuthMethod;
import io.netty.handler.codec.socksx.v5.Socks5ClientEncoder;
import io.netty.handler.codec.socksx.v5.Socks5CommandResponse;
import io.netty.handler.codec.socksx.v5.Socks5CommandResponseDecoder;
import io.netty.handler.codec.socksx.v5.Socks5CommandStatus;
import io.netty.handler.codec.socksx.v5.Socks5CommandType;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequest;
import io.netty.handler.codec.socksx.v5.Socks5InitialResponse;
import io.netty.handler.codec.socksx.v5.Socks5InitialResponseDecoder;
import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponse;
import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponseDecoder;
import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthStatus;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Collections;

public final class Socks5ProxyHandler
  extends ProxyHandler
{
  private static final String AUTH_PASSWORD = "password";
  private static final Socks5InitialRequest INIT_REQUEST_NO_AUTH;
  private static final Socks5InitialRequest INIT_REQUEST_PASSWORD;
  private static final String PROTOCOL = "socks5";
  private String decoderName;
  private String encoderName;
  private final String password;
  private final String username;
  
  static
  {
    Socks5AuthMethod localSocks5AuthMethod = Socks5AuthMethod.NO_AUTH;
    INIT_REQUEST_NO_AUTH = new DefaultSocks5InitialRequest(Collections.singletonList(localSocks5AuthMethod));
    INIT_REQUEST_PASSWORD = new DefaultSocks5InitialRequest(Arrays.asList(new Socks5AuthMethod[] { localSocks5AuthMethod, Socks5AuthMethod.PASSWORD }));
  }
  
  public Socks5ProxyHandler(SocketAddress paramSocketAddress)
  {
    this(paramSocketAddress, null, null);
  }
  
  public Socks5ProxyHandler(SocketAddress paramSocketAddress, String paramString1, String paramString2)
  {
    super(paramSocketAddress);
    paramSocketAddress = paramString1;
    if (paramString1 != null)
    {
      paramSocketAddress = paramString1;
      if (paramString1.isEmpty()) {
        paramSocketAddress = null;
      }
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.isEmpty()) {
        paramString1 = null;
      }
    }
    this.username = paramSocketAddress;
    this.password = paramString1;
  }
  
  private void sendConnectCommand(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    InetSocketAddress localInetSocketAddress = (InetSocketAddress)destinationAddress();
    Socks5AddressType localSocks5AddressType;
    String str;
    if (localInetSocketAddress.isUnresolved())
    {
      localSocks5AddressType = Socks5AddressType.DOMAIN;
      str = localInetSocketAddress.getHostString();
    }
    else
    {
      str = localInetSocketAddress.getAddress().getHostAddress();
      if (NetUtil.isValidIpV4Address(str))
      {
        localSocks5AddressType = Socks5AddressType.IPv4;
      }
      else
      {
        if (!NetUtil.isValidIpV6Address(str)) {
          break label116;
        }
        localSocks5AddressType = Socks5AddressType.IPv6;
      }
    }
    ChannelPipeline localChannelPipeline = paramChannelHandlerContext.pipeline();
    paramChannelHandlerContext = this.decoderName;
    localChannelPipeline.replace(paramChannelHandlerContext, paramChannelHandlerContext, new Socks5CommandResponseDecoder());
    sendToProxyServer(new DefaultSocks5CommandRequest(Socks5CommandType.CONNECT, localSocks5AddressType, str, localInetSocketAddress.getPort()));
    return;
    label116:
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("unknown address type: ");
    paramChannelHandlerContext.append(StringUtil.simpleClassName(str));
    throw new ProxyConnectException(exceptionMessage(paramChannelHandlerContext.toString()));
  }
  
  private Socks5AuthMethod socksAuthMethod()
  {
    Socks5AuthMethod localSocks5AuthMethod;
    if ((this.username == null) && (this.password == null)) {
      localSocks5AuthMethod = Socks5AuthMethod.NO_AUTH;
    } else {
      localSocks5AuthMethod = Socks5AuthMethod.PASSWORD;
    }
    return localSocks5AuthMethod;
  }
  
  protected void addCodec(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    ChannelPipeline localChannelPipeline = paramChannelHandlerContext.pipeline();
    paramChannelHandlerContext = paramChannelHandlerContext.name();
    Object localObject = new Socks5InitialResponseDecoder();
    localChannelPipeline.addBefore(paramChannelHandlerContext, null, (ChannelHandler)localObject);
    this.decoderName = localChannelPipeline.context((ChannelHandler)localObject).name();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.decoderName);
    ((StringBuilder)localObject).append(".encoder");
    localObject = ((StringBuilder)localObject).toString();
    this.encoderName = ((String)localObject);
    localChannelPipeline.addBefore(paramChannelHandlerContext, (String)localObject, Socks5ClientEncoder.DEFAULT);
  }
  
  public String authScheme()
  {
    String str;
    if (socksAuthMethod() == Socks5AuthMethod.PASSWORD) {
      str = "password";
    } else {
      str = "none";
    }
    return str;
  }
  
  protected boolean handleResponse(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof Socks5InitialResponse))
    {
      paramObject = (Socks5InitialResponse)paramObject;
      Socks5AuthMethod localSocks5AuthMethod1 = socksAuthMethod();
      Object localObject = ((Socks5InitialResponse)paramObject).authMethod();
      Socks5AuthMethod localSocks5AuthMethod2 = Socks5AuthMethod.NO_AUTH;
      if ((localObject != localSocks5AuthMethod2) && (((Socks5InitialResponse)paramObject).authMethod() != localSocks5AuthMethod1))
      {
        paramChannelHandlerContext = new StringBuilder();
        paramChannelHandlerContext.append("unexpected authMethod: ");
        paramChannelHandlerContext.append(((Socks5InitialResponse)paramObject).authMethod());
        throw new ProxyConnectException(exceptionMessage(paramChannelHandlerContext.toString()));
      }
      if (localSocks5AuthMethod1 == localSocks5AuthMethod2)
      {
        sendConnectCommand(paramChannelHandlerContext);
      }
      else
      {
        if (localSocks5AuthMethod1 != Socks5AuthMethod.PASSWORD) {
          break label188;
        }
        paramChannelHandlerContext = paramChannelHandlerContext.pipeline();
        paramObject = this.decoderName;
        paramChannelHandlerContext.replace((String)paramObject, (String)paramObject, new Socks5PasswordAuthResponseDecoder());
        paramChannelHandlerContext = this.username;
        paramObject = "";
        if (paramChannelHandlerContext == null) {
          paramChannelHandlerContext = "";
        }
        localObject = this.password;
        if (localObject != null) {
          paramObject = localObject;
        }
        sendToProxyServer(new DefaultSocks5PasswordAuthRequest(paramChannelHandlerContext, (String)paramObject));
      }
      return false;
      label188:
      throw new Error();
    }
    if ((paramObject instanceof Socks5PasswordAuthResponse))
    {
      paramObject = (Socks5PasswordAuthResponse)paramObject;
      if (((Socks5PasswordAuthResponse)paramObject).status() == Socks5PasswordAuthStatus.SUCCESS)
      {
        sendConnectCommand(paramChannelHandlerContext);
        return false;
      }
      paramChannelHandlerContext = new StringBuilder();
      paramChannelHandlerContext.append("authStatus: ");
      paramChannelHandlerContext.append(((Socks5PasswordAuthResponse)paramObject).status());
      throw new ProxyConnectException(exceptionMessage(paramChannelHandlerContext.toString()));
    }
    paramChannelHandlerContext = (Socks5CommandResponse)paramObject;
    if (paramChannelHandlerContext.status() == Socks5CommandStatus.SUCCESS) {
      return true;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("status: ");
    ((StringBuilder)paramObject).append(paramChannelHandlerContext.status());
    throw new ProxyConnectException(exceptionMessage(((StringBuilder)paramObject).toString()));
  }
  
  protected Object newInitialMessage(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (socksAuthMethod() == Socks5AuthMethod.PASSWORD) {
      paramChannelHandlerContext = INIT_REQUEST_PASSWORD;
    } else {
      paramChannelHandlerContext = INIT_REQUEST_NO_AUTH;
    }
    return paramChannelHandlerContext;
  }
  
  public String password()
  {
    return this.password;
  }
  
  public String protocol()
  {
    return "socks5";
  }
  
  protected void removeDecoder(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext = paramChannelHandlerContext.pipeline();
    if (paramChannelHandlerContext.context(this.decoderName) != null) {
      paramChannelHandlerContext.remove(this.decoderName);
    }
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\proxy\Socks5ProxyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */