package com.tplink.libtpmediamanager.g;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class c
{
  private static final String a;
  private final a b;
  private final e c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.class.getSimpleName());
    localStringBuilder.append(".DefaultKey");
    a = localStringBuilder.toString();
  }
  
  public c(@NonNull a parama, @NonNull e parame)
  {
    this.b = parama;
    this.c = parame;
  }
  
  @NonNull
  public <T extends b> T a(@NonNull TPMediaDeviceContext paramTPMediaDeviceContext, @NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(":");
      localStringBuilder.append(str);
      return b(localStringBuilder.toString(), paramTPMediaDeviceContext, paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @NonNull
  public <T extends b> T b(@NonNull String paramString, @NonNull TPMediaDeviceContext paramTPMediaDeviceContext, @NonNull Class<T> paramClass)
  {
    b localb = this.c.b(paramString);
    if (paramClass.isInstance(localb)) {
      return localb;
    }
    paramTPMediaDeviceContext = this.b.a(paramTPMediaDeviceContext, paramClass);
    this.c.c(paramString, paramTPMediaDeviceContext);
    return paramTPMediaDeviceContext;
  }
  
  public static abstract interface a
  {
    @NonNull
    public abstract <T extends b> T a(@NonNull TPMediaDeviceContext paramTPMediaDeviceContext, @NonNull Class<T> paramClass);
  }
  
  public static class b
    implements c.a
  {
    @NonNull
    public <T extends b> T a(@NonNull TPMediaDeviceContext paramTPMediaDeviceContext, @NonNull Class<T> paramClass)
    {
      try
      {
        localObject = paramClass.getDeclaredConstructor(new Class[] { paramTPMediaDeviceContext.getClass() });
        ((Constructor)localObject).setAccessible(true);
        paramTPMediaDeviceContext = (b)((Constructor)localObject).newInstance(new Object[] { paramTPMediaDeviceContext });
        paramTPMediaDeviceContext.loadCacheData();
        return paramTPMediaDeviceContext;
      }
      catch (NoSuchMethodException paramTPMediaDeviceContext)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot create an instance of ");
        ((StringBuilder)localObject).append(paramClass);
        throw new RuntimeException(((StringBuilder)localObject).toString(), paramTPMediaDeviceContext);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        paramTPMediaDeviceContext = new StringBuilder();
        paramTPMediaDeviceContext.append("Cannot create an instance of ");
        paramTPMediaDeviceContext.append(paramClass);
        throw new RuntimeException(paramTPMediaDeviceContext.toString(), localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        paramTPMediaDeviceContext = new StringBuilder();
        paramTPMediaDeviceContext.append("Cannot create an instance of ");
        paramTPMediaDeviceContext.append(paramClass);
        throw new RuntimeException(paramTPMediaDeviceContext.toString(), localIllegalAccessException);
      }
      catch (InstantiationException paramTPMediaDeviceContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot create an instance of ");
        localStringBuilder.append(paramClass);
        throw new RuntimeException(localStringBuilder.toString(), paramTPMediaDeviceContext);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */