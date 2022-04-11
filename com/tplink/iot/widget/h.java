package com.tplink.iot.widget;

import android.content.Context;
import java.text.DateFormatSymbols;
import java.util.Locale;

public class h
{
  public static String[] a()
  {
    String[] arrayOfString = new String[12];
    int j;
    for (int i = 0; i < 12; i = j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      j = i + 1;
      localStringBuilder.append(j);
      localStringBuilder.append("");
      arrayOfString[i] = localStringBuilder.toString();
    }
    return arrayOfString;
  }
  
  public static String[] b()
  {
    String[] arrayOfString = new String[24];
    for (int i = 0; i < 24; i++)
    {
      StringBuilder localStringBuilder;
      if (i < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0");
        localStringBuilder.append(i);
        arrayOfString[i] = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        arrayOfString[i] = localStringBuilder.toString();
      }
    }
    return arrayOfString;
  }
  
  public static String[] c()
  {
    return DateFormatSymbols.getInstance(Locale.getDefault()).getAmPmStrings();
  }
  
  public static String[] d()
  {
    String[] arrayOfString = new String[24];
    for (int i = 0; i < 24; i++)
    {
      String str1 = "AM";
      String str2;
      if (i < 12) {
        str2 = "AM";
      } else {
        str2 = "PM";
      }
      int j = i + 2;
      if (j % 24 >= 12) {
        str1 = "PM";
      }
      arrayOfString[i] = String.format("%s %s - %s %s", new Object[] { h(i * 60), str2, h(j * 60), str1 });
    }
    return arrayOfString;
  }
  
  public static String[] e()
  {
    String[] arrayOfString = new String[3];
    int j;
    for (int i = 0; i < 3; i = j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      j = i + 1;
      localStringBuilder.append(j);
      localStringBuilder.append("");
      arrayOfString[i] = localStringBuilder.toString();
    }
    return arrayOfString;
  }
  
  public static String[] f()
  {
    String[] arrayOfString = new String[60];
    for (int i = 0; i < 60; i++)
    {
      StringBuilder localStringBuilder;
      if (i < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0");
        localStringBuilder.append(i);
        arrayOfString[i] = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        arrayOfString[i] = localStringBuilder.toString();
      }
    }
    return arrayOfString;
  }
  
  public static String[] g()
  {
    String[] arrayOfString = new String[48];
    for (int i = 0; i < 48; i++)
    {
      String str1 = "AM";
      String str2;
      String str3;
      if (i < 24)
      {
        str2 = h(i * 30);
        str3 = h((i + 1) * 30);
        if (i == 23) {
          str1 = "PM";
        }
        arrayOfString[i] = String.format("%s %s - %s %s", new Object[] { str2, "AM", str3, str1 });
      }
      else
      {
        str2 = h(i * 30);
        str3 = h((i + 1) * 30);
        if (i != 47) {
          str1 = "PM";
        }
        arrayOfString[i] = String.format("%s %s - %s %s", new Object[] { str2, "PM", str3, str1 });
      }
    }
    return arrayOfString;
  }
  
  private static String h(int paramInt)
  {
    int i = paramInt / 60;
    int j = 12;
    i = i % 24 % 12;
    if (i != 0) {
      j = i;
    }
    paramInt %= 60;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append(":");
    Object localObject;
    if (paramInt < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = Integer.valueOf(paramInt);
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
  
  public static String[] i()
  {
    return f();
  }
  
  public static String[] j()
  {
    String[] arrayOfString = new String[6];
    for (int i = 0; i < 6; i++)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      arrayOfString[i] = localStringBuilder.toString();
    }
    return arrayOfString;
  }
  
  public static String[] k(Context paramContext)
  {
    return new String[] { paramContext.getString(2131951837), paramContext.getString(2131951782) };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */