package io.netty.handler.codec.http2;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

final class Http2ControlFrameLimitEncoder
  extends DecoratingHttp2ConnectionEncoder
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2ControlFrameLimitEncoder.class);
  private Http2LifecycleManager lifecycleManager;
  private boolean limitReached;
  private final int maxOutstandingControlFrames;
  private int outstandingControlFrames;
  private final ChannelFutureListener outstandingControlFramesListener = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
    {
      Http2ControlFrameLimitEncoder.access$010(Http2ControlFrameLimitEncoder.this);
    }
  };
  
  Http2ControlFrameLimitEncoder(Http2ConnectionEncoder paramHttp2ConnectionEncoder, int paramInt)
  {
    super(paramHttp2ConnectionEncoder);
    this.maxOutstandingControlFrames = ObjectUtil.checkPositive(paramInt, "maxOutstandingControlFrames");
  }
  
  private ChannelPromise handleOutstandingControlFrames(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    if (!this.limitReached)
    {
      if (this.outstandingControlFrames == this.maxOutstandingControlFrames) {
        paramChannelHandlerContext.flush();
      }
      int i = this.outstandingControlFrames;
      int j = this.maxOutstandingControlFrames;
      if (i == j)
      {
        this.limitReached = true;
        Http2Exception localHttp2Exception = Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Maximum number %d of outstanding control frames reached", new Object[] { Integer.valueOf(j) });
        logger.info("Maximum number {} of outstanding control frames reached. Closing channel {}", new Object[] { Integer.valueOf(this.maxOutstandingControlFrames), paramChannelHandlerContext.channel(), localHttp2Exception });
        this.lifecycleManager.onError(paramChannelHandlerContext, true, localHttp2Exception);
        paramChannelHandlerContext.close();
      }
      this.outstandingControlFrames += 1;
      return paramChannelPromise.unvoid().addListener(this.outstandingControlFramesListener);
    }
    return paramChannelPromise;
  }
  
  public void lifecycleManager(Http2LifecycleManager paramHttp2LifecycleManager)
  {
    this.lifecycleManager = paramHttp2LifecycleManager;
    super.lifecycleManager(paramHttp2LifecycleManager);
  }
  
  public ChannelFuture writePing(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, long paramLong, ChannelPromise paramChannelPromise)
  {
    if (paramBoolean)
    {
      ChannelPromise localChannelPromise = handleOutstandingControlFrames(paramChannelHandlerContext, paramChannelPromise);
      if (localChannelPromise == null) {
        return paramChannelPromise;
      }
      return super.writePing(paramChannelHandlerContext, paramBoolean, paramLong, localChannelPromise);
    }
    return super.writePing(paramChannelHandlerContext, paramBoolean, paramLong, paramChannelPromise);
  }
  
  public ChannelFuture writeRstStream(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
  {
    ChannelPromise localChannelPromise = handleOutstandingControlFrames(paramChannelHandlerContext, paramChannelPromise);
    if (localChannelPromise == null) {
      return paramChannelPromise;
    }
    return super.writeRstStream(paramChannelHandlerContext, paramInt, paramLong, localChannelPromise);
  }
  
  public ChannelFuture writeSettingsAck(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    ChannelPromise localChannelPromise = handleOutstandingControlFrames(paramChannelHandlerContext, paramChannelPromise);
    if (localChannelPromise == null) {
      return paramChannelPromise;
    }
    return super.writeSettingsAck(paramChannelHandlerContext, localChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2ControlFrameLimitEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */