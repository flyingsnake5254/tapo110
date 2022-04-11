package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.AsyncMapping;
import io.netty.util.DomainNameMapping;
import io.netty.util.Mapping;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;

public class SniHandler
  extends AbstractSniHandler<SslContext>
{
  private static final Selection EMPTY_SELECTION = new Selection(null, null);
  protected final AsyncMapping<String, SslContext> mapping;
  private volatile Selection selection = EMPTY_SELECTION;
  
  public SniHandler(AsyncMapping<? super String, ? extends SslContext> paramAsyncMapping)
  {
    this.mapping = ((AsyncMapping)ObjectUtil.checkNotNull(paramAsyncMapping, "mapping"));
  }
  
  public SniHandler(DomainNameMapping<? extends SslContext> paramDomainNameMapping)
  {
    this(paramDomainNameMapping);
  }
  
  public SniHandler(Mapping<? super String, ? extends SslContext> paramMapping)
  {
    this(new AsyncMappingAdapter(paramMapping, null));
  }
  
  public String hostname()
  {
    return this.selection.hostname;
  }
  
  protected Future<SslContext> lookup(ChannelHandlerContext paramChannelHandlerContext, String paramString)
    throws Exception
  {
    return this.mapping.map(paramString, paramChannelHandlerContext.executor().newPromise());
  }
  
  protected SslHandler newSslHandler(SslContext paramSslContext, ByteBufAllocator paramByteBufAllocator)
  {
    return paramSslContext.newHandler(paramByteBufAllocator);
  }
  
  /* Error */
  protected final void onLookupComplete(ChannelHandlerContext paramChannelHandlerContext, String paramString, Future<SslContext> paramFuture)
    throws Exception
  {
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface 100 1 0
    //   6: ifne +56 -> 62
    //   9: aload_3
    //   10: invokeinterface 104 1 0
    //   15: astore_3
    //   16: aload_3
    //   17: instanceof 106
    //   20: ifeq +8 -> 28
    //   23: aload_3
    //   24: checkcast 106	java/lang/Error
    //   27: athrow
    //   28: new 108	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   35: astore_1
    //   36: aload_1
    //   37: ldc 111
    //   39: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: new 117	io/netty/handler/codec/DecoderException
    //   52: dup
    //   53: aload_1
    //   54: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: aload_3
    //   58: invokespecial 123	io/netty/handler/codec/DecoderException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   61: athrow
    //   62: aload_3
    //   63: invokeinterface 127 1 0
    //   68: checkcast 88	io/netty/handler/ssl/SslContext
    //   71: astore_3
    //   72: aload_0
    //   73: new 10	io/netty/handler/ssl/SniHandler$Selection
    //   76: dup
    //   77: aload_3
    //   78: aload_2
    //   79: invokespecial 25	io/netty/handler/ssl/SniHandler$Selection:<init>	(Lio/netty/handler/ssl/SslContext;Ljava/lang/String;)V
    //   82: putfield 33	io/netty/handler/ssl/SniHandler:selection	Lio/netty/handler/ssl/SniHandler$Selection;
    //   85: aload_0
    //   86: aload_1
    //   87: aload_2
    //   88: aload_3
    //   89: invokevirtual 131	io/netty/handler/ssl/SniHandler:replaceHandler	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/String;Lio/netty/handler/ssl/SslContext;)V
    //   92: goto +15 -> 107
    //   95: astore_1
    //   96: aload_0
    //   97: getstatic 27	io/netty/handler/ssl/SniHandler:EMPTY_SELECTION	Lio/netty/handler/ssl/SniHandler$Selection;
    //   100: putfield 33	io/netty/handler/ssl/SniHandler:selection	Lio/netty/handler/ssl/SniHandler$Selection;
    //   103: aload_1
    //   104: invokestatic 137	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   107: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	SniHandler
    //   0	108	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	108	2	paramString	String
    //   0	108	3	paramFuture	Future<SslContext>
    // Exception table:
    //   from	to	target	type
    //   85	92	95	finally
  }
  
  protected void replaceHandler(ChannelHandlerContext paramChannelHandlerContext, String paramString, SslContext paramSslContext)
    throws Exception
  {
    paramString = null;
    try
    {
      paramSslContext = newSslHandler(paramSslContext, paramChannelHandlerContext.alloc());
      paramString = paramSslContext;
      paramChannelHandlerContext.pipeline().replace(this, SslHandler.class.getName(), paramSslContext);
      return;
    }
    finally
    {
      if (paramString != null) {
        ReferenceCountUtil.safeRelease(paramString.engine());
      }
    }
  }
  
  public SslContext sslContext()
  {
    return this.selection.context;
  }
  
  private static final class AsyncMappingAdapter
    implements AsyncMapping<String, SslContext>
  {
    private final Mapping<? super String, ? extends SslContext> mapping;
    
    private AsyncMappingAdapter(Mapping<? super String, ? extends SslContext> paramMapping)
    {
      this.mapping = ((Mapping)ObjectUtil.checkNotNull(paramMapping, "mapping"));
    }
    
    public Future<SslContext> map(String paramString, Promise<SslContext> paramPromise)
    {
      try
      {
        paramString = (SslContext)this.mapping.map(paramString);
        return paramPromise.setSuccess(paramString);
      }
      finally {}
      return paramPromise.setFailure(paramString);
    }
  }
  
  private static final class Selection
  {
    final SslContext context;
    final String hostname;
    
    Selection(SslContext paramSslContext, String paramString)
    {
      this.context = paramSslContext;
      this.hostname = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SniHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */