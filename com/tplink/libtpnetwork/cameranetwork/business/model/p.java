package com.tplink.libtpnetwork.cameranetwork.business.model;

import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;

public class p
{
  private boolean a;
  private String b;
  private String c;
  
  public p a()
  {
    p localp = new p();
    localp.c = this.c;
    localp.a = this.a;
    localp.b = this.b;
    return localp;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  public void e(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void f(String paramString)
  {
    this.b = paramString;
  }
  
  public TamperDetectConfig g()
  {
    Integer.valueOf("2").intValue();
    String str1 = this.c;
    String str2;
    if (this.a) {
      str2 = "on";
    } else {
      str2 = "off";
    }
    return new TamperDetectConfig(str1, str2, this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TamperSetting{enabled=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", sensitivity='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", digitalSensitivity=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */