package io.netty.channel;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract interface ChannelHandler
{
  @Deprecated
  public abstract void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception;
  
  public abstract void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception;
  
  public abstract void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception;
  
  @Documented
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */