package io.netty.channel;

import io.netty.util.internal.InternalThreadLocalMap;
import java.util.Map;

public abstract class ChannelHandlerAdapter
  implements ChannelHandler
{
  boolean added;
  
  protected void ensureNotSharable()
  {
    if (!isSharable()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannelHandler ");
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" is not allowed to be shared");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  @ChannelHandlerMask.a
  @Deprecated
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {}
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {}
  
  public boolean isSharable()
  {
    Class localClass = getClass();
    Map localMap = InternalThreadLocalMap.get().handlerSharableCache();
    Boolean localBoolean1 = (Boolean)localMap.get(localClass);
    Boolean localBoolean2 = localBoolean1;
    if (localBoolean1 == null)
    {
      localBoolean2 = Boolean.valueOf(localClass.isAnnotationPresent(ChannelHandler.a.class));
      localMap.put(localClass, localBoolean2);
    }
    return localBoolean2.booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelHandlerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */