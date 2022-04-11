package com.tplink.cloud.context;

import b.d.b.e.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Logger;

public class a
{
  private static volatile HttpLoggingInterceptor a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private k p;
  private HttpLoggingInterceptor.Logger q;
  private List<String> r;
  private Map<String, Object> s = new HashMap();
  
  public static HttpLoggingInterceptor k()
  {
    return a;
  }
  
  public void A(String paramString)
  {
    this.j = paramString;
  }
  
  public void B(String paramString)
  {
    this.g = paramString;
  }
  
  public void C(String paramString)
  {
    this.e = paramString;
  }
  
  public void D(String paramString)
  {
    this.d = paramString;
  }
  
  public void E(String paramString)
  {
    this.l = paramString;
  }
  
  public void F(String paramString)
  {
    this.k = paramString;
  }
  
  public String a()
  {
    return this.m;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.o;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.i;
  }
  
  public List<String> f()
  {
    return this.r;
  }
  
  public Map<String, Object> g()
  {
    return this.s;
  }
  
  public HttpLoggingInterceptor.Logger h()
  {
    return this.q;
  }
  
  public k i()
  {
    return this.p;
  }
  
  public String j()
  {
    return this.b;
  }
  
  public String l()
  {
    return this.h;
  }
  
  public String m()
  {
    return this.j;
  }
  
  public String n()
  {
    return this.g;
  }
  
  public String o()
  {
    return this.e;
  }
  
  public String p()
  {
    return this.n;
  }
  
  public String q()
  {
    return this.d;
  }
  
  public String r()
  {
    return this.l;
  }
  
  public String s()
  {
    return this.k;
  }
  
  public void t(String paramString)
  {
    this.c = paramString;
  }
  
  public void u(String paramString)
  {
    this.o = paramString;
  }
  
  public void v(String paramString)
  {
    this.f = paramString;
  }
  
  public void w(String paramString, Object paramObject)
  {
    this.s.put(paramString, paramObject);
  }
  
  public void x(HttpLoggingInterceptor.Logger paramLogger)
  {
    this.q = paramLogger;
  }
  
  public void y(String paramString)
  {
    this.b = paramString;
  }
  
  public void z(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\context\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */