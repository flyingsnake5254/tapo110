package com.tplink.libtpnetwork.IoTNetwork.transport.http;

import com.tplink.libtpnetwork.IoTNetwork.y.b;

public class c
  extends b
{
  private String a;
  private int b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public c(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
  }
  
  public String a()
  {
    return this.f;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public String e()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */