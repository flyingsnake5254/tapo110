package com.tplink.iot.model.billing;

public class h0
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public h0() {}
  
  public h0(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("purchaseToken: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" accountId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" packageName: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" sku: ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\billing\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */