package com.tplink.libtpinappmessaging.model;

public class e
  extends c
{
  private String e;
  
  public e()
  {
    this.a = "inner web's url";
  }
  
  public String g()
  {
    return this.e;
  }
  
  public void h(String paramString)
  {
    this.e = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebMessage{webUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", description='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpinappmessaging\model\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */