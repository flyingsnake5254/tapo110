package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;

public abstract interface Http2RemoteFlowController
  extends Http2FlowController
{
  public abstract void addFlowControlled(Http2Stream paramHttp2Stream, FlowControlled paramFlowControlled);
  
  public abstract ChannelHandlerContext channelHandlerContext();
  
  public abstract void channelWritabilityChanged()
    throws Http2Exception;
  
  public abstract boolean hasFlowControlled(Http2Stream paramHttp2Stream);
  
  public abstract boolean isWritable(Http2Stream paramHttp2Stream);
  
  public abstract void listener(Listener paramListener);
  
  public abstract void updateDependencyTree(int paramInt1, int paramInt2, short paramShort, boolean paramBoolean);
  
  public abstract void writePendingBytes()
    throws Http2Exception;
  
  public static abstract interface FlowControlled
  {
    public abstract void error(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable);
    
    public abstract boolean merge(ChannelHandlerContext paramChannelHandlerContext, FlowControlled paramFlowControlled);
    
    public abstract int size();
    
    public abstract void write(ChannelHandlerContext paramChannelHandlerContext, int paramInt);
    
    public abstract void writeComplete();
  }
  
  public static abstract interface Listener
  {
    public abstract void writabilityChanged(Http2Stream paramHttp2Stream);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2RemoteFlowController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */