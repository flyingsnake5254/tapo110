package com.google.android.exoplayer2.text.p;

import android.text.Spannable;

public final class d
{
  public static void a(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    for (Object localObject : paramSpannable.getSpans(paramInt1, paramInt2, paramObject.getClass())) {
      if ((paramSpannable.getSpanStart(localObject) == paramInt1) && (paramSpannable.getSpanEnd(localObject) == paramInt2) && (paramSpannable.getSpanFlags(localObject) == paramInt3)) {
        paramSpannable.removeSpan(localObject);
      }
    }
    paramSpannable.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\p\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */