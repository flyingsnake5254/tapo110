package com.tplink.iot.Utils;

import android.content.Context;
import java.text.DateFormatSymbols;
import java.util.Locale;

public class c0
{
  public static String a(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, false);
  }
  
  public static String b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      if (paramBoolean) {
        return paramContext.getString(2131953731);
      }
      return paramContext.getString(2131953393);
    }
    if (paramInt == 127) {
      return paramContext.getString(2131953728);
    }
    if (paramInt == 62) {
      return paramContext.getString(2131953729);
    }
    if (paramInt == 65) {
      return paramContext.getString(2131953730);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = DateFormatSymbols.getInstance(Locale.getDefault()).getShortWeekdays();
    int i = 1;
    int j = 1;
    while (i < paramContext.length)
    {
      if ((paramInt & j) == j)
      {
        localStringBuilder.append(paramContext[i]);
        localStringBuilder.append(" ");
      }
      j <<= 1;
      i++;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */