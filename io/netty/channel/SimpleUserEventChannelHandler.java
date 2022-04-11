package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

public abstract class SimpleUserEventChannelHandler<I>
  extends ChannelInboundHandlerAdapter
{
  private final boolean autoRelease;
  private final TypeParameterMatcher matcher;
  
  protected SimpleUserEventChannelHandler()
  {
    this(true);
  }
  
  protected SimpleUserEventChannelHandler(Class<? extends I> paramClass)
  {
    this(paramClass, true);
  }
  
  protected SimpleUserEventChannelHandler(Class<? extends I> paramClass, boolean paramBoolean)
  {
    this.matcher = TypeParameterMatcher.get(paramClass);
    this.autoRelease = paramBoolean;
  }
  
  protected SimpleUserEventChannelHandler(boolean paramBoolean)
  {
    this.matcher = TypeParameterMatcher.find(this, SimpleUserEventChannelHandler.class, "I");
    this.autoRelease = paramBoolean;
  }
  
  protected boolean acceptEvent(Object paramObject)
    throws Exception
  {
    return this.matcher.match(paramObject);
  }
  
  protected abstract void eventReceived(ChannelHandlerContext paramChannelHandlerContext, I paramI)
    throws Exception;
  
  public final void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    int i = 1;
    int j = 1;
    int k = i;
    try
    {
      if (acceptEvent(paramObject))
      {
        k = i;
        eventReceived(paramChannelHandlerContext, paramObject);
        k = j;
      }
      else
      {
        k = 0;
        j = 0;
        paramChannelHandlerContext.fireUserEventTriggered(paramObject);
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\SimpleUserEventChannelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */