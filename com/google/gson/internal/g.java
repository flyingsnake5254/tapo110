package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class g
{
  private static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return "M/d/yy";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown DateFormat style: ");
          localStringBuilder.append(paramInt);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return "MMM d, yyyy";
      }
      return "MMMM d, yyyy";
    }
    return "EEEE, MMMM d, yyyy";
  }
  
  private static String b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          return "h:mm a";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown DateFormat style: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return "h:mm:ss a";
    }
    return "h:mm:ss a z";
  }
  
  public static DateFormat c(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt1));
    localStringBuilder.append(" ");
    localStringBuilder.append(b(paramInt2));
    return new SimpleDateFormat(localStringBuilder.toString(), Locale.US);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */