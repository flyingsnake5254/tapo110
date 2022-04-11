package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.concurrent.EventExecutor;

public abstract interface ChannelHandlerContext
  extends AttributeMap, ChannelInboundInvoker, ChannelOutboundInvoker
{
  public abstract ByteBufAllocator alloc();
  
  @Deprecated
  public abstract <T> Attribute<T> attr(AttributeKey<T> paramAttributeKey);
  
  public abstract Channel channel();
  
  public abstract EventExecutor executor();
  
  public abstract ChannelHandlerContext fireChannelActive();
  
  public abstract ChannelHandlerContext fireChannelInactive();
  
  public abstract ChannelHandlerContext fireChannelRead(Object paramObject);
  
  public abstract ChannelHandlerContext fireChannelReadComplete();
  
  public abstract ChannelHandlerContext fireChannelRegistered();
  
  public abstract ChannelHandlerContext fireChannelUnregistered();
  
  public abstract ChannelHandlerContext fireChannelWritabilityChanged();
  
  public abstract ChannelHandlerContext fireExceptionCaught(Throwable paramThrowable);
  
  public abstract ChannelHandlerContext fireUserEventTriggered(Object paramObject);
  
  public abstract ChannelHandlerContext flush();
  
  public abstract ChannelHandler handler();
  
  @Deprecated
  public abstract <T> boolean hasAttr(AttributeKey<T> paramAttributeKey);
  
  public abstract boolean isRemoved();
  
  public abstract String name();
  
  public abstract ChannelPipeline pipeline();
  
  public abstract ChannelHandlerContext read();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelHandlerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */