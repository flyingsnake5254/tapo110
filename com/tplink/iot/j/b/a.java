package com.tplink.iot.j.b;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class a
{
  private String a = "";
  private String b = "";
  private boolean c = false;
  
  public a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
  }
  
  public static String e(String paramString)
  {
    return Normalizer.normalize(paramString, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\j\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */