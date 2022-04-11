package com.tplink.iab;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class b
{
  private static final Pattern a = Pattern.compile("P(?:([0-9]+)Y)?(?:([0-9]+)M)?(?:([0-9]+)W)?(?:([0-9]+)D)?", 2);
  private static final DecimalFormat b = new DecimalFormat("0.00");
  
  public static double a(double paramDouble)
  {
    return Math.round(paramDouble * 100.0D) / 100.0D;
  }
  
  public static int b(String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    if (!paramString.equals("P3M"))
    {
      if (!paramString.equals("P6M")) {
        return 1;
      }
      return 6;
    }
    return 3;
  }
  
  public static int c(String paramString)
  {
    if (paramString == null) {
      return 2;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 78631: 
      if (paramString.equals("P6M")) {
        i = 3;
      }
      break;
    case 78538: 
      if (paramString.equals("P3M")) {
        i = 2;
      }
      break;
    case 78486: 
      if (paramString.equals("P1W")) {
        i = 1;
      }
      break;
    case 78476: 
      if (paramString.equals("P1M")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return 3;
    case 1: 
      return 5;
    }
    return 2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iab\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */