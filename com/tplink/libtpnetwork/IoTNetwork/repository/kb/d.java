package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class d
{
  private static final String a;
  private final a b;
  private final f c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d.class.getSimpleName());
    localStringBuilder.append(".DefaultKey");
    a = localStringBuilder.toString();
  }
  
  public d(@NonNull a parama, @NonNull f paramf)
  {
    this.b = parama;
    this.c = paramf;
  }
  
  @NonNull
  public <T extends c> T a(@NonNull TPBaseDeviceContext paramTPBaseDeviceContext, @NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(":");
      localStringBuilder.append(str);
      return b(localStringBuilder.toString(), paramTPBaseDeviceContext, paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @NonNull
  public <T extends c> T b(@NonNull String paramString, @NonNull TPBaseDeviceContext paramTPBaseDeviceContext, @NonNull Class<T> paramClass)
  {
    c localc = this.c.b(paramString);
    if (paramClass.isInstance(localc)) {
      return localc;
    }
    paramTPBaseDeviceContext = this.b.a(paramTPBaseDeviceContext, paramClass);
    this.c.c(paramString, paramTPBaseDeviceContext);
    return paramTPBaseDeviceContext;
  }
  
  public static abstract interface a
  {
    @NonNull
    public abstract <T extends c> T a(@NonNull TPBaseDeviceContext paramTPBaseDeviceContext, @NonNull Class<T> paramClass);
  }
  
  public static class b
    implements d.a
  {
    @NonNull
    public <T extends c> T a(@NonNull TPBaseDeviceContext paramTPBaseDeviceContext, @NonNull Class<T> paramClass)
    {
      try
      {
        Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[] { paramTPBaseDeviceContext.getClass() });
        localConstructor.setAccessible(true);
        paramTPBaseDeviceContext = (c)localConstructor.newInstance(new Object[] { paramTPBaseDeviceContext });
        paramTPBaseDeviceContext.c();
        return paramTPBaseDeviceContext;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        paramTPBaseDeviceContext = new StringBuilder();
        paramTPBaseDeviceContext.append("Cannot create an instance of ");
        paramTPBaseDeviceContext.append(paramClass);
        throw new RuntimeException(paramTPBaseDeviceContext.toString(), localNoSuchMethodException);
      }
      catch (InvocationTargetException paramTPBaseDeviceContext)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), paramTPBaseDeviceContext);
      }
      catch (IllegalAccessException paramTPBaseDeviceContext)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), paramTPBaseDeviceContext);
      }
      catch (InstantiationException paramTPBaseDeviceContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), paramTPBaseDeviceContext);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\kb\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */