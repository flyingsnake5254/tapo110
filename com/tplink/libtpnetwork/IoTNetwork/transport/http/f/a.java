package com.tplink.libtpnetwork.IoTNetwork.transport.http.f;

import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class a
  implements Interceptor
{
  private final String a;
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  @NonNull
  public Response intercept(@NonNull Interceptor.Chain paramChain)
    throws IOException
  {
    return paramChain.proceed(paramChain.request().newBuilder().addHeader("Referer", this.a).addHeader("Accept", "application/json").addHeader("requestByApp", "true").build());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */