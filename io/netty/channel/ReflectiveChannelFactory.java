package io.netty.channel;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;

public class ReflectiveChannelFactory<T extends Channel>
  implements ChannelFactory<T>
{
  private final Constructor<? extends T> constructor;
  
  public ReflectiveChannelFactory(Class<? extends T> paramClass)
  {
    ObjectUtil.checkNotNull(paramClass, "clazz");
    try
    {
      this.constructor = paramClass.getConstructor(new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Class ");
      localStringBuilder.append(StringUtil.simpleClassName(paramClass));
      localStringBuilder.append(" does not have a public non-arg constructor");
      throw new IllegalArgumentException(localStringBuilder.toString(), localNoSuchMethodException);
    }
  }
  
  public T newChannel()
  {
    StringBuilder localStringBuilder;
    try
    {
      Channel localChannel = (Channel)this.constructor.newInstance(new Object[0]);
      return localChannel;
    }
    finally
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to create Channel from class ");
      localStringBuilder.append(this.constructor.getDeclaringClass());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(ReflectiveChannelFactory.class));
    localStringBuilder.append('(');
    localStringBuilder.append(StringUtil.simpleClassName(this.constructor.getDeclaringClass()));
    localStringBuilder.append(".class)");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ReflectiveChannelFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */