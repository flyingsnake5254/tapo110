package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.d0;

public final class n
{
  public final int a;
  public final int b;
  public final String c;
  
  private n(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
  }
  
  @Nullable
  public static n a(d0 paramd0)
  {
    paramd0.Q(2);
    int i = paramd0.D();
    int j = i >> 1;
    i = paramd0.D() >> 3 & 0x1F | (i & 0x1) << 5;
    if ((j != 4) && (j != 5) && (j != 7))
    {
      if (j == 8) {
        paramd0 = "hev1";
      } else if (j == 9) {
        paramd0 = "avc3";
      } else {
        return null;
      }
    }
    else {
      paramd0 = "dvhe";
    }
    String str;
    if (i < 10) {
      str = ".0";
    } else {
      str = ".";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramd0.length() + 24 + str.length());
    localStringBuilder.append(paramd0);
    localStringBuilder.append(".0");
    localStringBuilder.append(j);
    localStringBuilder.append(str);
    localStringBuilder.append(i);
    return new n(j, i, localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */