package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;

public class e
{
  public static <T extends c> T a(@NonNull ThingContext paramThingContext, @NonNull Class<T> paramClass)
  {
    return f(paramThingContext).a(paramThingContext, paramClass);
  }
  
  public static <T extends c> T b(@NonNull TPCameraDeviceContext paramTPCameraDeviceContext, @NonNull Class<T> paramClass)
  {
    return f(paramTPCameraDeviceContext).a(paramTPCameraDeviceContext, paramClass);
  }
  
  public static <T extends c> T c(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    return b(TPIoTClientManager.K1(paramString), paramClass);
  }
  
  public static <T extends c> T d(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    return a(TPIoTClientManager.k2(paramString), paramClass);
  }
  
  public static void e(TPBaseDeviceContext paramTPBaseDeviceContext)
  {
    if ((paramTPBaseDeviceContext instanceof g)) {
      ((g)paramTPBaseDeviceContext).a().a();
    }
    a.c(paramTPBaseDeviceContext);
  }
  
  public static d f(@NonNull TPBaseDeviceContext paramTPBaseDeviceContext)
  {
    return new d(new d.b(), h.a(paramTPBaseDeviceContext));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\kb\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */