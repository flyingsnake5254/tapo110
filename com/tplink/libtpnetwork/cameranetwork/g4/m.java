package com.tplink.libtpnetwork.cameranetwork.g4;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.u;

public final class m
{
  public static <T> u<Response<T>, T> a()
  {
    return b(null);
  }
  
  public static <T> u<Response<T>, T> b(@Nullable Request paramRequest)
  {
    return new h(paramRequest);
  }
  
  public static <T> u<Response<T>, Response<T>> c(@Nullable Request paramRequest)
  {
    return new j(paramRequest);
  }
  
  public static <T> u<Response<T>, Response<T>> d()
  {
    return e(null);
  }
  
  public static <T> u<Response<T>, Response<T>> e(@Nullable Request paramRequest)
  {
    return new g(paramRequest);
  }
  
  private static CameraException f(@Nullable Request paramRequest, @NonNull Response paramResponse)
  {
    Object localObject1 = paramResponse.getMethod();
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (paramRequest != null) {
        localObject2 = paramRequest.getMethod();
      }
    }
    localObject1 = new StringBuilder();
    if (paramRequest != null) {
      ((StringBuilder)localObject1).append(paramRequest.toString());
    }
    ((StringBuilder)localObject1).append(paramResponse.toString());
    return new CameraException(paramResponse.getErrorCode(), (String)localObject2, ((StringBuilder)localObject1).toString());
  }
  
  public static u<Response, Boolean> g()
  {
    return h(null);
  }
  
  public static u<Response, Boolean> h(@Nullable Request paramRequest)
  {
    return new e(paramRequest);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\g4\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */