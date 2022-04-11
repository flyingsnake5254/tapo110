package io.netty.handler.codec.socksx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ServerDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ServerEncoder;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder;
import io.netty.handler.codec.socksx.v5.Socks5ServerEncoder;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

public class SocksPortUnificationServerHandler
  extends ByteToMessageDecoder
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(SocksPortUnificationServerHandler.class);
  private final Socks5ServerEncoder socks5encoder;
  
  public SocksPortUnificationServerHandler()
  {
    this(Socks5ServerEncoder.DEFAULT);
  }
  
  public SocksPortUnificationServerHandler(Socks5ServerEncoder paramSocks5ServerEncoder)
  {
    this.socks5encoder = ((Socks5ServerEncoder)ObjectUtil.checkNotNull(paramSocks5ServerEncoder, "socks5encoder"));
  }
  
  private static void logKnownVersion(ChannelHandlerContext paramChannelHandlerContext, SocksVersion paramSocksVersion)
  {
    logger.debug("{} Protocol version: {}({})", paramChannelHandlerContext.channel(), paramSocksVersion);
  }
  
  private static void logUnknownVersion(ChannelHandlerContext paramChannelHandlerContext, byte paramByte)
  {
    InternalLogger localInternalLogger = logger;
    if (localInternalLogger.isDebugEnabled()) {
      localInternalLogger.debug("{} Unknown protocol version: {}", paramChannelHandlerContext.channel(), Integer.valueOf(paramByte & 0xFF));
    }
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = paramByteBuf.readerIndex();
    if (paramByteBuf.writerIndex() == i) {
      return;
    }
    ChannelPipeline localChannelPipeline = paramChannelHandlerContext.pipeline();
    byte b = paramByteBuf.getByte(i);
    paramList = SocksVersion.valueOf(b);
    i = 1.$SwitchMap$io$netty$handler$codec$socksx$SocksVersion[paramList.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        logUnknownVersion(paramChannelHandlerContext, b);
        paramByteBuf.skipBytes(paramByteBuf.readableBytes());
        paramChannelHandlerContext.close();
        return;
      }
      logKnownVersion(paramChannelHandlerContext, paramList);
      localChannelPipeline.addAfter(paramChannelHandlerContext.name(), null, this.socks5encoder);
      localChannelPipeline.addAfter(paramChannelHandlerContext.name(), null, new Socks5InitialRequestDecoder());
    }
    else
    {
      logKnownVersion(paramChannelHandlerContext, paramList);
      localChannelPipeline.addAfter(paramChannelHandlerContext.name(), null, Socks4ServerEncoder.INSTANCE);
      localChannelPipeline.addAfter(paramChannelHandlerContext.name(), null, new Socks4ServerDecoder());
    }
    localChannelPipeline.remove(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\SocksPortUnificationServerHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */