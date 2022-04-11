package com.tplink.libtpinappmessaging.model;

public class d
  extends c
{
  private String e;
  private String f;
  
  public d()
  {
    this.a = "browser's webUrl";
  }
  
  public String g()
  {
    return this.f;
  }
  
  public String h()
  {
    return this.e;
  }
  
  public void i(String paramString)
  {
    this.f = paramString;
  }
  
  public void j(String paramString)
  {
    this.e = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SplashMessage{webUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filePath='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", description='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpinappmessaging\model\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */