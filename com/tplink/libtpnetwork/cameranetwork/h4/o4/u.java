package com.tplink.libtpnetwork.cameranetwork.h4.o4;

import com.tplink.libtpnetwork.cameranetwork.h4.i4;

public class u
  extends i4
{
  private String a;
  private int b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public u(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
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
    return this.e;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public void e(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\o4\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */