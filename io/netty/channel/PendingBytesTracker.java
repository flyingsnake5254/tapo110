package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

abstract class PendingBytesTracker
  implements MessageSizeEstimator.Handle
{
  private final MessageSizeEstimator.Handle estimatorHandle;
  
  private PendingBytesTracker(MessageSizeEstimator.Handle paramHandle)
  {
    this.estimatorHandle = ((MessageSizeEstimator.Handle)ObjectUtil.checkNotNull(paramHandle, "estimatorHandle"));
  }
  
  static PendingBytesTracker newTracker(Channel paramChannel)
  {
    if ((paramChannel.pipeline() instanceof DefaultChannelPipeline)) {
      return new DefaultChannelPipelinePendingBytesTracker((DefaultChannelPipeline)paramChannel.pipeline());
    }
    ChannelOutboundBuffer localChannelOutboundBuffer = paramChannel.unsafe().outboundBuffer();
    paramChannel = paramChannel.config().getMessageSizeEstimator().newHandle();
    if (localChannelOutboundBuffer == null) {
      paramChannel = new NoopPendingBytesTracker(paramChannel);
    } else {
      paramChannel = new ChannelOutboundBufferPendingBytesTracker(localChannelOutboundBuffer, paramChannel);
    }
    return paramChannel;
  }
  
  public abstract void decrementPendingOutboundBytes(long paramLong);
  
  public abstract void incrementPendingOutboundBytes(long paramLong);
  
  public final int size(Object paramObject)
  {
    return this.estimatorHandle.size(paramObject);
  }
  
  private static final class ChannelOutboundBufferPendingBytesTracker
    extends PendingBytesTracker
  {
    private final ChannelOutboundBuffer buffer;
    
    ChannelOutboundBufferPendingBytesTracker(ChannelOutboundBuffer paramChannelOutboundBuffer, MessageSizeEstimator.Handle paramHandle)
    {
      super(null);
      this.buffer = paramChannelOutboundBuffer;
    }
    
    public void decrementPendingOutboundBytes(long paramLong)
    {
      this.buffer.decrementPendingOutboundBytes(paramLong);
    }
    
    public void incrementPendingOutboundBytes(long paramLong)
    {
      this.buffer.incrementPendingOutboundBytes(paramLong);
    }
  }
  
  private static final class DefaultChannelPipelinePendingBytesTracker
    extends PendingBytesTracker
  {
    private final DefaultChannelPipeline pipeline;
    
    DefaultChannelPipelinePendingBytesTracker(DefaultChannelPipeline paramDefaultChannelPipeline)
    {
      super(null);
      this.pipeline = paramDefaultChannelPipeline;
    }
    
    public void decrementPendingOutboundBytes(long paramLong)
    {
      this.pipeline.decrementPendingOutboundBytes(paramLong);
    }
    
    public void incrementPendingOutboundBytes(long paramLong)
    {
      this.pipeline.incrementPendingOutboundBytes(paramLong);
    }
  }
  
  private static final class NoopPendingBytesTracker
    extends PendingBytesTracker
  {
    NoopPendingBytesTracker(MessageSizeEstimator.Handle paramHandle)
    {
      super(null);
    }
    
    public void decrementPendingOutboundBytes(long paramLong) {}
    
    public void incrementPendingOutboundBytes(long paramLong) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\PendingBytesTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */