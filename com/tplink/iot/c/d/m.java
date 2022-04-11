package com.tplink.iot.c.d;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class m
  implements Interceptor
{
  private final p.a a;
  
  public m(p.a parama)
  {
    this.a = parama;
  }
  
  private void a(Request paramRequest, String paramString1, Request.Builder paramBuilder, String paramString2)
  {
    if ((paramString2 != null) && (paramRequest.header(paramString1) == null)) {
      paramBuilder.addHeader(paramString1, paramString2);
    }
  }
  
  @NonNull
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    Request.Builder localBuilder = localRequest.newBuilder();
    Object localObject = localRequest.header("Authorization-Required");
    if (((localObject == null) || (!((String)localObject).equals("false"))) && (this.a.e() != null) && (localRequest.header("Authorization") == null)) {
      localBuilder.addHeader("Authorization", this.a.e());
    }
    a(localRequest, "app-cid", localBuilder, this.a.g());
    a(localRequest, "x-app-name", localBuilder, this.a.i());
    a(localRequest, "x-app-version", localBuilder, this.a.a());
    a(localRequest, "x-term-id", localBuilder, this.a.j());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Android ");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    a(localRequest, "x-ospf", localBuilder, ((StringBuilder)localObject).toString());
    a(localRequest, "x-net-type", localBuilder, this.a.b());
    String str = this.a.c();
    localObject = str;
    if (str == null) {
      localObject = Locale.getDefault().toString();
    }
    a(localRequest, "x-locale", localBuilder, (String)localObject);
    a(localRequest, "User-Agent", localBuilder, this.a.getUserAgent());
    if ((localRequest.body() != null) && (localRequest.header("Content-Type") == null)) {
      localBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
    }
    return paramChain.proceed(localBuilder.build());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\d\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */