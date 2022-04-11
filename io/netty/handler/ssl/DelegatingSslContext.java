package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

public abstract class DelegatingSslContext
  extends SslContext
{
  private final SslContext ctx;
  
  protected DelegatingSslContext(SslContext paramSslContext)
  {
    this.ctx = ((SslContext)ObjectUtil.checkNotNull(paramSslContext, "ctx"));
  }
  
  public final ApplicationProtocolNegotiator applicationProtocolNegotiator()
  {
    return this.ctx.applicationProtocolNegotiator();
  }
  
  public final List<String> cipherSuites()
  {
    return this.ctx.cipherSuites();
  }
  
  protected abstract void initEngine(SSLEngine paramSSLEngine);
  
  protected void initHandler(SslHandler paramSslHandler)
  {
    initEngine(paramSslHandler.engine());
  }
  
  public final boolean isClient()
  {
    return this.ctx.isClient();
  }
  
  public final SSLEngine newEngine(ByteBufAllocator paramByteBufAllocator)
  {
    paramByteBufAllocator = this.ctx.newEngine(paramByteBufAllocator);
    initEngine(paramByteBufAllocator);
    return paramByteBufAllocator;
  }
  
  public final SSLEngine newEngine(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt)
  {
    paramByteBufAllocator = this.ctx.newEngine(paramByteBufAllocator, paramString, paramInt);
    initEngine(paramByteBufAllocator);
    return paramByteBufAllocator;
  }
  
  protected final SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean)
  {
    paramByteBufAllocator = this.ctx.newHandler(paramByteBufAllocator, paramString, paramInt, paramBoolean);
    initHandler(paramByteBufAllocator);
    return paramByteBufAllocator;
  }
  
  protected SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, String paramString, int paramInt, boolean paramBoolean, Executor paramExecutor)
  {
    paramByteBufAllocator = this.ctx.newHandler(paramByteBufAllocator, paramString, paramInt, paramBoolean, paramExecutor);
    initHandler(paramByteBufAllocator);
    return paramByteBufAllocator;
  }
  
  protected final SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean)
  {
    paramByteBufAllocator = this.ctx.newHandler(paramByteBufAllocator, paramBoolean);
    initHandler(paramByteBufAllocator);
    return paramByteBufAllocator;
  }
  
  protected SslHandler newHandler(ByteBufAllocator paramByteBufAllocator, boolean paramBoolean, Executor paramExecutor)
  {
    paramByteBufAllocator = this.ctx.newHandler(paramByteBufAllocator, paramBoolean, paramExecutor);
    initHandler(paramByteBufAllocator);
    return paramByteBufAllocator;
  }
  
  public final long sessionCacheSize()
  {
    return this.ctx.sessionCacheSize();
  }
  
  public final SSLSessionContext sessionContext()
  {
    return this.ctx.sessionContext();
  }
  
  public final long sessionTimeout()
  {
    return this.ctx.sessionTimeout();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\DelegatingSslContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */