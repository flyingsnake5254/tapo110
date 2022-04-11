package com.google.android.exoplayer2.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;

public final class f0
{
  public static final f0 a = new f0(-1, -16777216, 0, 0, -1, null);
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  @Nullable
  public final Typeface g;
  
  public f0(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @Nullable Typeface paramTypeface)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramTypeface;
  }
  
  @RequiresApi(19)
  public static f0 a(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    if (o0.a >= 21) {
      return c(paramCaptionStyle);
    }
    return b(paramCaptionStyle);
  }
  
  @RequiresApi(19)
  private static f0 b(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    return new f0(paramCaptionStyle.foregroundColor, paramCaptionStyle.backgroundColor, 0, paramCaptionStyle.edgeType, paramCaptionStyle.edgeColor, paramCaptionStyle.getTypeface());
  }
  
  @RequiresApi(21)
  private static f0 c(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    int i;
    if (paramCaptionStyle.hasForegroundColor()) {
      i = paramCaptionStyle.foregroundColor;
    } else {
      i = a.b;
    }
    int j;
    if (paramCaptionStyle.hasBackgroundColor()) {
      j = paramCaptionStyle.backgroundColor;
    } else {
      j = a.c;
    }
    int k;
    if (paramCaptionStyle.hasWindowColor()) {
      k = paramCaptionStyle.windowColor;
    } else {
      k = a.d;
    }
    int m;
    if (paramCaptionStyle.hasEdgeType()) {
      m = paramCaptionStyle.edgeType;
    } else {
      m = a.e;
    }
    int n;
    if (paramCaptionStyle.hasEdgeColor()) {
      n = paramCaptionStyle.edgeColor;
    } else {
      n = a.f;
    }
    return new f0(i, j, k, m, n, paramCaptionStyle.getTypeface());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */