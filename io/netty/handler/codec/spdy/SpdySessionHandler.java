package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SpdySessionHandler
  extends ChannelDuplexHandler
{
  private static final int DEFAULT_MAX_CONCURRENT_STREAMS = Integer.MAX_VALUE;
  private static final int DEFAULT_WINDOW_SIZE = 65536;
  private static final SpdyProtocolException PROTOCOL_EXCEPTION = (SpdyProtocolException)ThrowableUtil.unknownStackTrace(SpdyProtocolException.newStatic(null), SpdySessionHandler.class, "handleOutboundMessage(...)");
  private static final SpdyProtocolException STREAM_CLOSED = (SpdyProtocolException)ThrowableUtil.unknownStackTrace(SpdyProtocolException.newStatic("Stream closed"), SpdySessionHandler.class, "removeStream(...)");
  private ChannelFutureListener closeSessionFutureListener;
  private int initialReceiveWindowSize = 65536;
  private int initialSendWindowSize = 65536;
  private volatile int initialSessionReceiveWindowSize = 65536;
  private int lastGoodStreamId;
  private int localConcurrentStreams = Integer.MAX_VALUE;
  private final int minorVersion;
  private final AtomicInteger pings = new AtomicInteger();
  private boolean receivedGoAwayFrame;
  private int remoteConcurrentStreams = Integer.MAX_VALUE;
  private boolean sentGoAwayFrame;
  private final boolean server;
  private final SpdySession spdySession = new SpdySession(this.initialSendWindowSize, this.initialReceiveWindowSize);
  
  public SpdySessionHandler(SpdyVersion paramSpdyVersion, boolean paramBoolean)
  {
    this.minorVersion = ((SpdyVersion)ObjectUtil.checkNotNull(paramSpdyVersion, "version")).getMinorVersion();
    this.server = paramBoolean;
  }
  
  private boolean acceptStream(int paramInt, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.receivedGoAwayFrame) && (!this.sentGoAwayFrame))
    {
      boolean bool = isRemoteInitiatedId(paramInt);
      int i;
      if (bool) {
        i = this.localConcurrentStreams;
      } else {
        i = this.remoteConcurrentStreams;
      }
      if (this.spdySession.numActiveStreams(bool) >= i) {
        return false;
      }
      this.spdySession.acceptStream(paramInt, paramByte, paramBoolean1, paramBoolean2, this.initialSendWindowSize, this.initialReceiveWindowSize, bool);
      if (bool) {
        this.lastGoodStreamId = paramInt;
      }
      return true;
    }
    return false;
  }
  
  private void halfCloseStream(int paramInt, boolean paramBoolean, ChannelFuture paramChannelFuture)
  {
    if (paramBoolean) {
      this.spdySession.closeRemoteSide(paramInt, isRemoteInitiatedId(paramInt));
    } else {
      this.spdySession.closeLocalSide(paramInt, isRemoteInitiatedId(paramInt));
    }
    if ((this.closeSessionFutureListener != null) && (this.spdySession.noActiveStreams())) {
      paramChannelFuture.addListener(this.closeSessionFutureListener);
    }
  }
  
  private void handleOutboundMessage(final ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    Object localObject;
    int i;
    if ((paramObject instanceof SpdyDataFrame))
    {
      localObject = (SpdyDataFrame)paramObject;
      i = ((SpdyStreamFrame)localObject).streamId();
      if (this.spdySession.isLocalSideClosed(i))
      {
        ((ReferenceCounted)localObject).release();
        paramChannelPromise.setFailure(PROTOCOL_EXCEPTION);
        return;
      }
      int j = ((SpdyDataFrame)localObject).content().readableBytes();
      int k = Math.min(this.spdySession.getSendWindowSize(i), this.spdySession.getSendWindowSize(0));
      if (k <= 0)
      {
        this.spdySession.putPendingWrite(i, new SpdySession.PendingWrite((SpdyDataFrame)localObject, paramChannelPromise));
        return;
      }
      if (k < j)
      {
        paramObject = this.spdySession;
        j = k * -1;
        ((SpdySession)paramObject).updateSendWindowSize(i, j);
        this.spdySession.updateSendWindowSize(0, j);
        paramObject = new DefaultSpdyDataFrame(i, ((SpdyDataFrame)localObject).content().readRetainedSlice(k));
        this.spdySession.putPendingWrite(i, new SpdySession.PendingWrite((SpdyDataFrame)localObject, paramChannelPromise));
        paramChannelHandlerContext.write(paramObject).addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            throws Exception
          {
            if (!paramAnonymousChannelFuture.isSuccess()) {
              SpdySessionHandler.this.issueSessionError(paramChannelHandlerContext, SpdySessionStatus.INTERNAL_ERROR);
            }
          }
        });
        return;
      }
      SpdySession localSpdySession = this.spdySession;
      k = j * -1;
      localSpdySession.updateSendWindowSize(i, k);
      this.spdySession.updateSendWindowSize(0, k);
      paramChannelPromise.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          if (!paramAnonymousChannelFuture.isSuccess()) {
            SpdySessionHandler.this.issueSessionError(paramChannelHandlerContext, SpdySessionStatus.INTERNAL_ERROR);
          }
        }
      });
      if (((SpdyStreamFrame)localObject).isLast()) {
        halfCloseStream(i, false, paramChannelPromise);
      }
    }
    else if ((paramObject instanceof SpdySynStreamFrame))
    {
      localObject = (SpdySynStreamFrame)paramObject;
      i = ((SpdyStreamFrame)localObject).streamId();
      if (isRemoteInitiatedId(i))
      {
        paramChannelPromise.setFailure(PROTOCOL_EXCEPTION);
        return;
      }
      if (!acceptStream(i, ((SpdySynStreamFrame)localObject).priority(), ((SpdySynStreamFrame)localObject).isUnidirectional(), ((SpdyStreamFrame)localObject).isLast())) {
        paramChannelPromise.setFailure(PROTOCOL_EXCEPTION);
      }
    }
    else if ((paramObject instanceof SpdySynReplyFrame))
    {
      localObject = (SpdySynReplyFrame)paramObject;
      i = ((SpdyStreamFrame)localObject).streamId();
      if ((isRemoteInitiatedId(i)) && (!this.spdySession.isLocalSideClosed(i)))
      {
        if (((SpdyStreamFrame)localObject).isLast()) {
          halfCloseStream(i, false, paramChannelPromise);
        }
      }
      else {
        paramChannelPromise.setFailure(PROTOCOL_EXCEPTION);
      }
    }
    else if ((paramObject instanceof SpdyRstStreamFrame))
    {
      removeStream(((SpdyRstStreamFrame)paramObject).streamId(), paramChannelPromise);
    }
    else if ((paramObject instanceof SpdySettingsFrame))
    {
      localObject = (SpdySettingsFrame)paramObject;
      i = ((SpdySettingsFrame)localObject).getValue(0);
      if ((i >= 0) && (i != this.minorVersion))
      {
        paramChannelPromise.setFailure(PROTOCOL_EXCEPTION);
        return;
      }
      i = ((SpdySettingsFrame)localObject).getValue(4);
      if (i >= 0) {
        this.localConcurrentStreams = i;
      }
      if (((SpdySettingsFrame)localObject).isPersisted(7)) {
        ((SpdySettingsFrame)localObject).removeValue(7);
      }
      ((SpdySettingsFrame)localObject).setPersistValue(7, false);
      i = ((SpdySettingsFrame)localObject).getValue(7);
      if (i >= 0) {
        updateInitialReceiveWindowSize(i);
      }
    }
    else if ((paramObject instanceof SpdyPingFrame))
    {
      localObject = (SpdyPingFrame)paramObject;
      if (isRemoteInitiatedId(((SpdyPingFrame)localObject).id()))
      {
        paramObject = new StringBuilder();
        ((StringBuilder)paramObject).append("invalid PING ID: ");
        ((StringBuilder)paramObject).append(((SpdyPingFrame)localObject).id());
        paramChannelHandlerContext.fireExceptionCaught(new IllegalArgumentException(((StringBuilder)paramObject).toString()));
        return;
      }
      this.pings.getAndIncrement();
    }
    else
    {
      if ((paramObject instanceof SpdyGoAwayFrame))
      {
        paramChannelPromise.setFailure(PROTOCOL_EXCEPTION);
        return;
      }
      if ((paramObject instanceof SpdyHeadersFrame))
      {
        localObject = (SpdyHeadersFrame)paramObject;
        i = ((SpdyStreamFrame)localObject).streamId();
        if (this.spdySession.isLocalSideClosed(i))
        {
          paramChannelPromise.setFailure(PROTOCOL_EXCEPTION);
          return;
        }
        if (((SpdyStreamFrame)localObject).isLast()) {
          halfCloseStream(i, false, paramChannelPromise);
        }
      }
      else if ((paramObject instanceof SpdyWindowUpdateFrame))
      {
        paramChannelPromise.setFailure(PROTOCOL_EXCEPTION);
        return;
      }
    }
    paramChannelHandlerContext.write(paramObject, paramChannelPromise);
  }
  
  private boolean isRemoteInitiatedId(int paramInt)
  {
    boolean bool1 = SpdyCodecUtil.isServerId(paramInt);
    boolean bool2 = this.server;
    if (((bool2) && (!bool1)) || ((!bool2) && (bool1))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  private void issueSessionError(ChannelHandlerContext paramChannelHandlerContext, SpdySessionStatus paramSpdySessionStatus)
  {
    sendGoAwayFrame(paramChannelHandlerContext, paramSpdySessionStatus).addListener(new ClosingChannelFutureListener(paramChannelHandlerContext, paramChannelHandlerContext.newPromise()));
  }
  
  private void issueStreamError(ChannelHandlerContext paramChannelHandlerContext, int paramInt, SpdyStreamStatus paramSpdyStreamStatus)
  {
    boolean bool = this.spdySession.isRemoteSideClosed(paramInt);
    ChannelPromise localChannelPromise = paramChannelHandlerContext.newPromise();
    removeStream(paramInt, localChannelPromise);
    paramSpdyStreamStatus = new DefaultSpdyRstStreamFrame(paramInt, paramSpdyStreamStatus);
    paramChannelHandlerContext.writeAndFlush(paramSpdyStreamStatus, localChannelPromise);
    if ((bool ^ true)) {
      paramChannelHandlerContext.fireChannelRead(paramSpdyStreamStatus);
    }
  }
  
  private void removeStream(int paramInt, ChannelFuture paramChannelFuture)
  {
    this.spdySession.removeStream(paramInt, STREAM_CLOSED, isRemoteInitiatedId(paramInt));
    if ((this.closeSessionFutureListener != null) && (this.spdySession.noActiveStreams())) {
      paramChannelFuture.addListener(this.closeSessionFutureListener);
    }
  }
  
  private ChannelFuture sendGoAwayFrame(ChannelHandlerContext paramChannelHandlerContext, SpdySessionStatus paramSpdySessionStatus)
  {
    if (!this.sentGoAwayFrame)
    {
      this.sentGoAwayFrame = true;
      return paramChannelHandlerContext.writeAndFlush(new DefaultSpdyGoAwayFrame(this.lastGoodStreamId, paramSpdySessionStatus));
    }
    return paramChannelHandlerContext.newSucceededFuture();
  }
  
  private void sendGoAwayFrame(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    if (!paramChannelHandlerContext.channel().isActive())
    {
      paramChannelHandlerContext.close(paramChannelPromise);
      return;
    }
    ChannelFuture localChannelFuture = sendGoAwayFrame(paramChannelHandlerContext, SpdySessionStatus.OK);
    if (this.spdySession.noActiveStreams()) {
      localChannelFuture.addListener(new ClosingChannelFutureListener(paramChannelHandlerContext, paramChannelPromise));
    } else {
      this.closeSessionFutureListener = new ClosingChannelFutureListener(paramChannelHandlerContext, paramChannelPromise);
    }
  }
  
  private void updateInitialReceiveWindowSize(int paramInt)
  {
    int i = this.initialReceiveWindowSize;
    this.initialReceiveWindowSize = paramInt;
    this.spdySession.updateAllReceiveWindowSizes(paramInt - i);
  }
  
  private void updateInitialSendWindowSize(int paramInt)
  {
    int i = this.initialSendWindowSize;
    this.initialSendWindowSize = paramInt;
    this.spdySession.updateAllSendWindowSizes(paramInt - i);
  }
  
  private void updateSendWindowSize(final ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2)
  {
    this.spdySession.updateSendWindowSize(paramInt1, paramInt2);
    for (;;)
    {
      Object localObject = this.spdySession.getPendingWrite(paramInt1);
      if (localObject == null) {
        return;
      }
      SpdyDataFrame localSpdyDataFrame = ((SpdySession.PendingWrite)localObject).spdyDataFrame;
      int i = localSpdyDataFrame.content().readableBytes();
      paramInt2 = localSpdyDataFrame.streamId();
      int j = Math.min(this.spdySession.getSendWindowSize(paramInt2), this.spdySession.getSendWindowSize(0));
      if (j <= 0) {
        return;
      }
      if (j < i)
      {
        localObject = this.spdySession;
        i = j * -1;
        ((SpdySession)localObject).updateSendWindowSize(paramInt2, i);
        this.spdySession.updateSendWindowSize(0, i);
        paramChannelHandlerContext.writeAndFlush(new DefaultSpdyDataFrame(paramInt2, localSpdyDataFrame.content().readRetainedSlice(j))).addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            throws Exception
          {
            if (!paramAnonymousChannelFuture.isSuccess()) {
              SpdySessionHandler.this.issueSessionError(paramChannelHandlerContext, SpdySessionStatus.INTERNAL_ERROR);
            }
          }
        });
      }
      else
      {
        this.spdySession.removePendingWrite(paramInt2);
        SpdySession localSpdySession = this.spdySession;
        j = i * -1;
        localSpdySession.updateSendWindowSize(paramInt2, j);
        this.spdySession.updateSendWindowSize(0, j);
        if (localSpdyDataFrame.isLast()) {
          halfCloseStream(paramInt2, false, ((SpdySession.PendingWrite)localObject).promise);
        }
        paramChannelHandlerContext.writeAndFlush(localSpdyDataFrame, ((SpdySession.PendingWrite)localObject).promise).addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            throws Exception
          {
            if (!paramAnonymousChannelFuture.isSuccess()) {
              SpdySessionHandler.this.issueSessionError(paramChannelHandlerContext, SpdySessionStatus.INTERNAL_ERROR);
            }
          }
        });
      }
    }
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Iterator localIterator = this.spdySession.activeStreams().keySet().iterator();
    while (localIterator.hasNext()) {
      removeStream(((Integer)localIterator.next()).intValue(), paramChannelHandlerContext.newSucceededFuture());
    }
    paramChannelHandlerContext.fireChannelInactive();
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    Object localObject;
    int i;
    int j;
    if ((paramObject instanceof SpdyDataFrame))
    {
      localObject = (SpdyDataFrame)paramObject;
      i = ((SpdyStreamFrame)localObject).streamId();
      j = ((SpdyDataFrame)localObject).content().readableBytes() * -1;
      int k = this.spdySession.updateReceiveWindowSize(0, j);
      if (k < 0)
      {
        issueSessionError(paramChannelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
        return;
      }
      if (k <= this.initialSessionReceiveWindowSize / 2)
      {
        k = this.initialSessionReceiveWindowSize - k;
        this.spdySession.updateReceiveWindowSize(0, k);
        paramChannelHandlerContext.writeAndFlush(new DefaultSpdyWindowUpdateFrame(0, k));
      }
      if (!this.spdySession.isActiveStream(i))
      {
        ((ReferenceCounted)localObject).release();
        if (i <= this.lastGoodStreamId) {
          issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.PROTOCOL_ERROR);
        } else if (!this.sentGoAwayFrame) {
          issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.INVALID_STREAM);
        }
        return;
      }
      if (this.spdySession.isRemoteSideClosed(i))
      {
        ((ReferenceCounted)localObject).release();
        issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.STREAM_ALREADY_CLOSED);
        return;
      }
      if ((!isRemoteInitiatedId(i)) && (!this.spdySession.hasReceivedReply(i)))
      {
        ((ReferenceCounted)localObject).release();
        issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.PROTOCOL_ERROR);
        return;
      }
      j = this.spdySession.updateReceiveWindowSize(i, j);
      if (j < this.spdySession.getReceiveWindowSizeLowerBound(i))
      {
        ((ReferenceCounted)localObject).release();
        issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.FLOW_CONTROL_ERROR);
        return;
      }
      if (j < 0) {
        while (((SpdyDataFrame)localObject).content().readableBytes() > this.initialReceiveWindowSize) {
          paramChannelHandlerContext.writeAndFlush(new DefaultSpdyDataFrame(i, ((SpdyDataFrame)localObject).content().readRetainedSlice(this.initialReceiveWindowSize)));
        }
      }
      if ((j <= this.initialReceiveWindowSize / 2) && (!((SpdyStreamFrame)localObject).isLast()))
      {
        j = this.initialReceiveWindowSize - j;
        this.spdySession.updateReceiveWindowSize(i, j);
        paramChannelHandlerContext.writeAndFlush(new DefaultSpdyWindowUpdateFrame(i, j));
      }
      if (((SpdyStreamFrame)localObject).isLast()) {
        halfCloseStream(i, true, paramChannelHandlerContext.newSucceededFuture());
      }
    }
    else if ((paramObject instanceof SpdySynStreamFrame))
    {
      localObject = (SpdySynStreamFrame)paramObject;
      i = ((SpdyStreamFrame)localObject).streamId();
      if ((!((SpdyHeadersFrame)localObject).isInvalid()) && (isRemoteInitiatedId(i)) && (!this.spdySession.isActiveStream(i)))
      {
        if (i <= this.lastGoodStreamId)
        {
          issueSessionError(paramChannelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
          return;
        }
        if (!acceptStream(i, ((SpdySynStreamFrame)localObject).priority(), ((SpdyStreamFrame)localObject).isLast(), ((SpdySynStreamFrame)localObject).isUnidirectional())) {
          issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.REFUSED_STREAM);
        }
      }
      else
      {
        issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.PROTOCOL_ERROR);
      }
    }
    else if ((paramObject instanceof SpdySynReplyFrame))
    {
      localObject = (SpdySynReplyFrame)paramObject;
      i = ((SpdyStreamFrame)localObject).streamId();
      if ((!((SpdyHeadersFrame)localObject).isInvalid()) && (!isRemoteInitiatedId(i)) && (!this.spdySession.isRemoteSideClosed(i)))
      {
        if (this.spdySession.hasReceivedReply(i))
        {
          issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.STREAM_IN_USE);
          return;
        }
        this.spdySession.receivedReply(i);
        if (((SpdyStreamFrame)localObject).isLast()) {
          halfCloseStream(i, true, paramChannelHandlerContext.newSucceededFuture());
        }
      }
      else
      {
        issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.INVALID_STREAM);
      }
    }
    else if ((paramObject instanceof SpdyRstStreamFrame))
    {
      removeStream(((SpdyRstStreamFrame)paramObject).streamId(), paramChannelHandlerContext.newSucceededFuture());
    }
    else if ((paramObject instanceof SpdySettingsFrame))
    {
      localObject = (SpdySettingsFrame)paramObject;
      i = ((SpdySettingsFrame)localObject).getValue(0);
      if ((i >= 0) && (i != this.minorVersion))
      {
        issueSessionError(paramChannelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
        return;
      }
      i = ((SpdySettingsFrame)localObject).getValue(4);
      if (i >= 0) {
        this.remoteConcurrentStreams = i;
      }
      if (((SpdySettingsFrame)localObject).isPersisted(7)) {
        ((SpdySettingsFrame)localObject).removeValue(7);
      }
      ((SpdySettingsFrame)localObject).setPersistValue(7, false);
      i = ((SpdySettingsFrame)localObject).getValue(7);
      if (i >= 0) {
        updateInitialSendWindowSize(i);
      }
    }
    else if ((paramObject instanceof SpdyPingFrame))
    {
      localObject = (SpdyPingFrame)paramObject;
      if (isRemoteInitiatedId(((SpdyPingFrame)localObject).id()))
      {
        paramChannelHandlerContext.writeAndFlush(localObject);
        return;
      }
      if (this.pings.get() == 0) {
        return;
      }
      this.pings.getAndDecrement();
    }
    else if ((paramObject instanceof SpdyGoAwayFrame))
    {
      this.receivedGoAwayFrame = true;
    }
    else if ((paramObject instanceof SpdyHeadersFrame))
    {
      localObject = (SpdyHeadersFrame)paramObject;
      i = ((SpdyStreamFrame)localObject).streamId();
      if (((SpdyHeadersFrame)localObject).isInvalid())
      {
        issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.PROTOCOL_ERROR);
        return;
      }
      if (this.spdySession.isRemoteSideClosed(i))
      {
        issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.INVALID_STREAM);
        return;
      }
      if (((SpdyStreamFrame)localObject).isLast()) {
        halfCloseStream(i, true, paramChannelHandlerContext.newSucceededFuture());
      }
    }
    else if ((paramObject instanceof SpdyWindowUpdateFrame))
    {
      localObject = (SpdyWindowUpdateFrame)paramObject;
      i = ((SpdyWindowUpdateFrame)localObject).streamId();
      j = ((SpdyWindowUpdateFrame)localObject).deltaWindowSize();
      if ((i != 0) && (this.spdySession.isLocalSideClosed(i))) {
        return;
      }
      if (this.spdySession.getSendWindowSize(i) > Integer.MAX_VALUE - j)
      {
        if (i == 0) {
          issueSessionError(paramChannelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
        } else {
          issueStreamError(paramChannelHandlerContext, i, SpdyStreamStatus.FLOW_CONTROL_ERROR);
        }
        return;
      }
      updateSendWindowSize(paramChannelHandlerContext, i, j);
    }
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    sendGoAwayFrame(paramChannelHandlerContext, paramChannelPromise);
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if ((paramThrowable instanceof SpdyProtocolException)) {
      issueSessionError(paramChannelHandlerContext, SpdySessionStatus.PROTOCOL_ERROR);
    }
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
  }
  
  public void setSessionReceiveWindowSize(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "sessionReceiveWindowSize");
    this.initialSessionReceiveWindowSize = paramInt;
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if ((!(paramObject instanceof SpdyDataFrame)) && (!(paramObject instanceof SpdySynStreamFrame)) && (!(paramObject instanceof SpdySynReplyFrame)) && (!(paramObject instanceof SpdyRstStreamFrame)) && (!(paramObject instanceof SpdySettingsFrame)) && (!(paramObject instanceof SpdyPingFrame)) && (!(paramObject instanceof SpdyGoAwayFrame)) && (!(paramObject instanceof SpdyHeadersFrame)) && (!(paramObject instanceof SpdyWindowUpdateFrame))) {
      paramChannelHandlerContext.write(paramObject, paramChannelPromise);
    } else {
      handleOutboundMessage(paramChannelHandlerContext, paramObject, paramChannelPromise);
    }
  }
  
  private static final class ClosingChannelFutureListener
    implements ChannelFutureListener
  {
    private final ChannelHandlerContext ctx;
    private final ChannelPromise promise;
    
    ClosingChannelFutureListener(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    {
      this.ctx = paramChannelHandlerContext;
      this.promise = paramChannelPromise;
    }
    
    public void operationComplete(ChannelFuture paramChannelFuture)
      throws Exception
    {
      this.ctx.close(this.promise);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdySessionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */