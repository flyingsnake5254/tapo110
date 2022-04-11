package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.util.g;
import com.google.common.base.o;

final class x0
{
  public static void c(c.b paramb)
  {
    paramb.b();
    if ((paramb.e() instanceof Spanned))
    {
      if (!(paramb.e() instanceof Spannable)) {
        paramb.o(SpannableString.valueOf(paramb.e()));
      }
      e((Spannable)g.e(paramb.e()), b0.c);
    }
    d(paramb);
  }
  
  public static void d(c.b paramb)
  {
    paramb.q(-3.4028235E38F, Integer.MIN_VALUE);
    if ((paramb.e() instanceof Spanned))
    {
      if (!(paramb.e() instanceof Spannable)) {
        paramb.o(SpannableString.valueOf(paramb.e()));
      }
      e((Spannable)g.e(paramb.e()), c0.c);
    }
  }
  
  private static void e(Spannable paramSpannable, o<Object> paramo)
  {
    int i = paramSpannable.length();
    int j = 0;
    Object[] arrayOfObject = paramSpannable.getSpans(0, i, Object.class);
    i = arrayOfObject.length;
    while (j < i)
    {
      Object localObject = arrayOfObject[j];
      if (paramo.apply(localObject)) {
        paramSpannable.removeSpan(localObject);
      }
      j++;
    }
  }
  
  public static float f(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if (paramFloat == -3.4028235E38F) {
      return -3.4028235E38F;
    }
    if (paramInt1 != 0) {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return -3.4028235E38F;
        }
        return paramFloat;
      }
    }
    for (float f = paramInt2;; f = paramInt3) {
      return paramFloat * f;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\x0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */