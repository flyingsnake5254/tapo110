package io.netty.handler.ssl;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DecoderException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import javax.net.ssl.SSLException;

public abstract class ApplicationProtocolNegotiationHandler
  extends ChannelInboundHandlerAdapter
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ApplicationProtocolNegotiationHandler.class);
  private final String fallbackProtocol;
  
  protected ApplicationProtocolNegotiationHandler(String paramString)
  {
    this.fallbackProtocol = ((String)ObjectUtil.checkNotNull(paramString, "fallbackProtocol"));
  }
  
  private void removeSelfIfPresent(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.pipeline();
    if (paramChannelHandlerContext.context(this) != null) {
      paramChannelHandlerContext.remove(this);
    }
  }
  
  protected abstract void configurePipeline(ChannelHandlerContext paramChannelHandlerContext, String paramString)
    throws Exception;
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if ((paramThrowable instanceof DecoderException))
    {
      Throwable localThrowable = paramThrowable.getCause();
      if ((localThrowable instanceof SSLException)) {
        try
        {
          handshakeFailure(paramChannelHandlerContext, localThrowable);
          return;
        }
        finally
        {
          removeSelfIfPresent(paramChannelHandlerContext);
        }
      }
    }
    logger.warn("{} Failed to select the application-level protocol:", paramChannelHandlerContext.channel(), paramThrowable);
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
    paramChannelHandlerContext.close();
  }
  
  protected void handshakeFailure(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    logger.warn("{} TLS handshake failed:", paramChannelHandlerContext.channel(), paramThrowable);
    paramChannelHandlerContext.close();
  }
  
  /* Error */
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 102
    //   4: ifeq +133 -> 137
    //   7: aload_2
    //   8: checkcast 102	io/netty/handler/ssl/SslHandshakeCompletionEvent
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 108	io/netty/handler/ssl/SslCompletionEvent:isSuccess	()Z
    //   16: ifeq +72 -> 88
    //   19: aload_1
    //   20: invokeinterface 42 1 0
    //   25: ldc 110
    //   27: invokeinterface 114 2 0
    //   32: checkcast 110	io/netty/handler/ssl/SslHandler
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +34 -> 73
    //   42: aload 4
    //   44: invokevirtual 118	io/netty/handler/ssl/SslHandler:applicationProtocol	()Ljava/lang/String;
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull +6 -> 57
    //   54: goto +9 -> 63
    //   57: aload_0
    //   58: getfield 34	io/netty/handler/ssl/ApplicationProtocolNegotiationHandler:fallbackProtocol	Ljava/lang/String;
    //   61: astore 4
    //   63: aload_0
    //   64: aload_1
    //   65: aload 4
    //   67: invokevirtual 120	io/netty/handler/ssl/ApplicationProtocolNegotiationHandler:configurePipeline	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/String;)V
    //   70: goto +18 -> 88
    //   73: new 122	java/lang/IllegalStateException
    //   76: astore 4
    //   78: aload 4
    //   80: ldc 124
    //   82: invokespecial 126	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   85: aload 4
    //   87: athrow
    //   88: aload_3
    //   89: invokevirtual 108	io/netty/handler/ssl/SslCompletionEvent:isSuccess	()Z
    //   92: ifeq +45 -> 137
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 73	io/netty/handler/ssl/ApplicationProtocolNegotiationHandler:removeSelfIfPresent	(Lio/netty/channel/ChannelHandlerContext;)V
    //   100: goto +37 -> 137
    //   103: astore 4
    //   105: aload_0
    //   106: aload_1
    //   107: aload 4
    //   109: invokevirtual 128	io/netty/handler/ssl/ApplicationProtocolNegotiationHandler:exceptionCaught	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Throwable;)V
    //   112: aload_3
    //   113: invokevirtual 108	io/netty/handler/ssl/SslCompletionEvent:isSuccess	()Z
    //   116: ifeq +21 -> 137
    //   119: goto -24 -> 95
    //   122: astore_2
    //   123: aload_3
    //   124: invokevirtual 108	io/netty/handler/ssl/SslCompletionEvent:isSuccess	()Z
    //   127: ifeq +8 -> 135
    //   130: aload_0
    //   131: aload_1
    //   132: invokespecial 73	io/netty/handler/ssl/ApplicationProtocolNegotiationHandler:removeSelfIfPresent	(Lio/netty/channel/ChannelHandlerContext;)V
    //   135: aload_2
    //   136: athrow
    //   137: aload_1
    //   138: aload_2
    //   139: invokeinterface 132 2 0
    //   144: pop
    //   145: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	ApplicationProtocolNegotiationHandler
    //   0	146	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	146	2	paramObject	Object
    //   11	113	3	localSslHandshakeCompletionEvent	SslHandshakeCompletionEvent
    //   35	51	4	localObject	Object
    //   103	5	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   12	37	103	finally
    //   42	49	103	finally
    //   57	63	103	finally
    //   63	70	103	finally
    //   73	88	103	finally
    //   105	112	122	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ApplicationProtocolNegotiationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */