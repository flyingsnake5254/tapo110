package com.tplink.libtpmediamanager.g;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpstreamclientmanager.TPStreamConnectionManager;

public class d
{
  public static <T extends b> T a(@NonNull TPMediaDeviceContext paramTPMediaDeviceContext, @NonNull Class<T> paramClass)
  {
    return d(paramTPMediaDeviceContext).a(paramTPMediaDeviceContext, paramClass);
  }
  
  public static <T extends b> T b(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    return a(TPStreamConnectionManager.b(paramString), paramClass);
  }
  
  public static void c(TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    if ((paramTPMediaDeviceContext instanceof f)) {
      ((f)paramTPMediaDeviceContext).a().a();
    }
    a.c(paramTPMediaDeviceContext);
  }
  
  public static c d(@NonNull TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    return new c(new c.b(), g.a(paramTPMediaDeviceContext));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */