package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import com.google.android.exoplayer2.util.o0;

final class h0
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 5 + String.valueOf(paramString).length());
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",.");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" *");
    return localStringBuilder.toString();
  }
  
  public static String b(@ColorInt int paramInt)
  {
    return o0.A("rgba(%d,%d,%d,%.3f)", new Object[] { Integer.valueOf(Color.red(paramInt)), Integer.valueOf(Color.green(paramInt)), Integer.valueOf(Color.blue(paramInt)), Double.valueOf(Color.alpha(paramInt) / 255.0D) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */