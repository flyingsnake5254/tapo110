package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

public abstract class SimpleChannelInboundHandler<I>
  extends ChannelInboundHandlerAdapter
{
  private final boolean autoRelease;
  private final TypeParameterMatcher matcher;
  
  protected SimpleChannelInboundHandler()
  {
    this(true);
  }
  
  protected SimpleChannelInboundHandler(Class<? extends I> paramClass)
  {
    this(paramClass, true);
  }
  
  protected SimpleChannelInboundHandler(Class<? extends I> paramClass, boolean paramBoolean)
  {
    this.matcher = TypeParameterMatcher.get(paramClass);
    this.autoRelease = paramBoolean;
  }
  
  protected SimpleChannelInboundHandler(boolean paramBoolean)
  {
    this.matcher = TypeParameterMatcher.find(this, SimpleChannelInboundHandler.class, "I");
    this.autoRelease = paramBoolean;
  }
  
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    return this.matcher.match(paramObject);
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    int i = 1;
    int j = 1;
    int k = i;
    try
    {
      if (acceptInboundMessage(paramObject))
      {
        k = i;
        channelRead0(paramChannelHandlerContext, paramObject);
        k = j;
      }
      else
      {
        k = 0;
        j = 0;
        paramChannelHandlerContext.fireChannelRead(paramObject);
        k = j;
      }
      return;
    }
    finally
    {
      if ((this.autoRelease) && (k != 0)) {
        ReferenceCountUtil.release(paramObject);
      }
    }
  }
  
  protected abstract void channelRead0(ChannelHandlerContext paramChannelHandlerContext, I paramI)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\SimpleChannelInboundHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */