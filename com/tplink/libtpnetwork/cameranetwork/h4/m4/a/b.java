package com.tplink.libtpnetwork.cameranetwork.h4.m4.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class b
  implements Interceptor
{
  @NonNull
  private final String a;
  private a b;
  private String c;
  
  public b(@NonNull String paramString1, @NonNull a parama, @NonNull String paramString2)
  {
    this.a = paramString1;
    this.b = parama;
    this.c = paramString2;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Object localObject1 = paramChain.request();
    Request.Builder localBuilder = ((Request)localObject1).newBuilder().addHeader("Referer", this.a).addHeader("Accept", "application/json").addHeader("Accept-Encoding", "gzip, deflate").addHeader("User-Agent", "Tapo CameraClient Android").addHeader("Connection", "Keep-Alive").addHeader("requestByApp", "true");
    Object localObject2 = this.b;
    if (localObject2 != null)
    {
      Object localObject3 = ((a)localObject2).b(this.c);
      Object localObject4 = this.b.a(this.c);
      StringBuilder localStringBuilder = new StringBuilder();
      HttpUrl localHttpUrl = ((Request)localObject1).url();
      if (localHttpUrl.querySize() > 0) {
        localObject1 = Character.valueOf('&');
      } else {
        localObject1 = Character.valueOf('?');
      }
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          Object localObject5 = (Map.Entry)((Iterator)localObject3).next();
          localObject2 = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (String)((Map.Entry)localObject5).getValue();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
          {
            localStringBuilder.append(localObject1);
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("=");
            localStringBuilder.append((String)localObject5);
            localObject1 = Character.valueOf('&');
          }
        }
      }
      if (localObject4 != null)
      {
        localObject1 = ((Map)localObject4).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject4 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (String)((Map.Entry)localObject3).getValue();
          if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
          {
            localStringBuilder.append(localObject2);
            localStringBuilder.append((String)localObject4);
            localStringBuilder.append("=");
            localStringBuilder.append((String)localObject3);
            localObject2 = Character.valueOf('&');
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localHttpUrl);
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      localBuilder.url(((StringBuilder)localObject1).toString());
    }
    return paramChain.proceed(localBuilder.build());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\m4\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */