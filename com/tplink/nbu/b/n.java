package com.tplink.nbu.b;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class n
  implements Interceptor
{
  private final a a;
  
  n(a parama)
  {
    this.a = parama;
  }
  
  public Response intercept(@NonNull Interceptor.Chain paramChain)
    throws IOException
  {
    Object localObject1 = paramChain.request();
    Request.Builder localBuilder = ((Request)localObject1).newBuilder();
    if (((Request)localObject1).header("Content-Type") == null) {
      localBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
    }
    if (((Request)localObject1).header("Platform") == null) {
      localBuilder.addHeader("Platform", "Android");
    }
    if (((Request)localObject1).header("X-App-Os") == null) {
      localBuilder.addHeader("X-App-Os", "android");
    }
    if ((((Request)localObject1).header("App-Type") == null) && (this.a.i() != null)) {
      localBuilder.addHeader("App-Type", this.a.i());
    }
    if ((((Request)localObject1).header("X-App-Type") == null) && (this.a.E() != null)) {
      localBuilder.addHeader("X-App-Type", this.a.E());
    }
    if ((((Request)localObject1).header("x-app-name") == null) && (this.a.i() != null)) {
      localBuilder.addHeader("x-app-name", this.a.i());
    }
    if ((((Request)localObject1).header("AppVer") == null) && (this.a.a() != null)) {
      localBuilder.addHeader("AppVer", this.a.a());
    }
    if ((((Request)localObject1).header("X-App-Ver") == null) && (this.a.a() != null)) {
      localBuilder.addHeader("X-App-Ver", this.a.a());
    }
    if ((((Request)localObject1).header("x-app-version") == null) && (this.a.a() != null)) {
      localBuilder.addHeader("x-app-version", this.a.a());
    }
    if (((Request)localObject1).header("OsVer") == null) {
      localBuilder.addHeader("OsVer", Build.VERSION.RELEASE);
    }
    if (((Request)localObject1).header("x-ospf") == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Android ");
      ((StringBuilder)localObject2).append(Build.VERSION.RELEASE);
      localBuilder.addHeader("x-ospf", ((StringBuilder)localObject2).toString());
    }
    if ((((Request)localObject1).header("x-net-type") == null) && (this.a.b() != null)) {
      localBuilder.addHeader("x-net-type", this.a.b());
    }
    if ((((Request)localObject1).header("UUID") == null) && (this.a.d() != null)) {
      localBuilder.addHeader("UUID", this.a.d());
    }
    if ((((Request)localObject1).header("x-term-id") == null) && (this.a.d() != null)) {
      localBuilder.addHeader("x-term-id", this.a.d());
    }
    if ((this.a.g() != null) && (((Request)localObject1).header("app-cid") == null)) {
      localBuilder.addHeader("app-cid", this.a.g());
    }
    Object localObject3;
    if (((Request)localObject1).header("Locale") == null)
    {
      localObject3 = Locale.getDefault();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((Locale)localObject3).getLanguage());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(((Locale)localObject3).getCountry());
      localBuilder.addHeader("Locale", ((StringBuilder)localObject2).toString());
    }
    if (((Request)localObject1).header("x-locale") == null)
    {
      localObject2 = Locale.getDefault();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((Locale)localObject2).getLanguage());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(((Locale)localObject2).getCountry());
      localBuilder.addHeader("x-locale", ((StringBuilder)localObject3).toString());
    }
    if (((Request)localObject1).header("Accept-Language") == null)
    {
      localObject2 = Locale.getDefault();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((Locale)localObject2).getLanguage());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(((Locale)localObject2).getCountry());
      localBuilder.addHeader("Accept-Language", ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = ((Request)localObject1).header("Authorization-Required");
    if (((localObject2 == null) || (!((String)localObject2).equals("false"))) && (((Request)localObject1).header("Authorization") == null))
    {
      localObject1 = ((Request)localObject1).header("Authorization-Format");
      if (localObject1 == null) {
        localObject1 = this.a.e();
      } else {
        localObject1 = String.format((String)localObject1, new Object[] { this.a.e() });
      }
      if (localObject1 != null) {
        localBuilder.addHeader("Authorization", (String)localObject1);
      }
    }
    localBuilder.removeHeader("Authorization-Required");
    localBuilder.removeHeader("Authorization-Format");
    return paramChain.proceed(localBuilder.build());
  }
  
  public static abstract interface a
  {
    public abstract String E();
    
    public abstract String a();
    
    public abstract String b();
    
    public abstract String d();
    
    public abstract String e();
    
    public abstract String g();
    
    public abstract String i();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */