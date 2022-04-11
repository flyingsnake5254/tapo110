package com.airbnb.lottie.model;

public class g
{
  private static String a = "\r";
  private final String b;
  public final float c;
  public final float d;
  
  public g(String paramString, float paramFloat1, float paramFloat2)
  {
    this.b = paramString;
    this.d = paramFloat2;
    this.c = paramFloat1;
  }
  
  public boolean a(String paramString)
  {
    if (this.b.equalsIgnoreCase(paramString)) {
      return true;
    }
    if (this.b.endsWith(a))
    {
      String str = this.b;
      if (str.substring(0, str.length() - 1).equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */