package com.google.gson.internal;

public final class d
{
  private static final int a = ;
  
  private static int a()
  {
    return d(System.getProperty("java.version"));
  }
  
  private static int b(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      for (int i = 0; i < paramString.length(); i++)
      {
        char c = paramString.charAt(i);
        if (!Character.isDigit(c)) {
          break;
        }
        localStringBuilder.append(c);
      }
      i = Integer.parseInt(localStringBuilder.toString());
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  public static int c()
  {
    return a;
  }
  
  static int d(String paramString)
  {
    int i = f(paramString);
    int j = i;
    if (i == -1) {
      j = b(paramString);
    }
    if (j == -1) {
      return 6;
    }
    return j;
  }
  
  public static boolean e()
  {
    boolean bool;
    if (a >= 9) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static int f(String paramString)
  {
    try
    {
      paramString = paramString.split("[._]");
      int i = Integer.parseInt(paramString[0]);
      if ((i == 1) && (paramString.length > 1))
      {
        i = Integer.parseInt(paramString[1]);
        return i;
      }
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */