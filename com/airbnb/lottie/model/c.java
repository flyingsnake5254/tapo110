package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.j;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class c
{
  private final List<j> a;
  private final char b;
  private final double c;
  private final double d;
  private final String e;
  private final String f;
  
  public c(List<j> paramList, char paramChar, double paramDouble1, double paramDouble2, String paramString1, String paramString2)
  {
    this.a = paramList;
    this.b = ((char)paramChar);
    this.c = paramDouble1;
    this.d = paramDouble2;
    this.e = paramString1;
    this.f = paramString2;
  }
  
  public static int c(char paramChar, String paramString1, String paramString2)
  {
    return (('\000' + paramChar) * 31 + paramString1.hashCode()) * 31 + paramString2.hashCode();
  }
  
  public List<j> a()
  {
    return this.a;
  }
  
  public double b()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return c(this.b, this.f, this.e);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */