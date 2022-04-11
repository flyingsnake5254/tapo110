package com.tplink.iot.Utils;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class e0
{
  public static e0 d()
  {
    return g.a();
  }
  
  public SpannableString a(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, int paramInt3, final f paramf)
  {
    int i = paramContext.getString(paramInt1, new Object[] { "deco_m6_divider-span-symbol" }).indexOf("deco_m6_divider-span-symbol");
    int j = paramString1.length() + i;
    paramContext = new SpannableString(paramContext.getString(paramInt1, new Object[] { paramString1 }));
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.setSpan(new TypefaceSpan(paramString2), i, j, 33);
    }
    if (paramf != null) {
      paramContext.setSpan(new d(paramInt2, paramInt3, paramBoolean, paramf), i, j, 33);
    } else if (paramBoolean) {
      paramContext.setSpan(new UnderlineSpan(), i, j, 33);
    }
    return paramContext;
  }
  
  public SpannableString b(Context paramContext, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3, final f paramf)
  {
    int i = paramContext.getString(paramInt1, new Object[] { "deco_m6_divider-span-symbol" }).indexOf("deco_m6_divider-span-symbol");
    int j = paramString.length() + i;
    paramContext = new SpannableString(paramContext.getString(paramInt1, new Object[] { paramString }));
    if (paramf != null) {
      paramContext.setSpan(new a(paramInt2, paramInt3, paramBoolean, paramf), i, j, 33);
    } else if (paramBoolean) {
      paramContext.setSpan(new UnderlineSpan(), i, j, 33);
    }
    return paramContext;
  }
  
  public SpannableString c(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, int paramInt3, final f paramf)
  {
    paramContext = paramContext.getString(paramInt1, new Object[] { paramString1, paramString2 });
    int i = paramContext.indexOf(paramString1);
    paramInt1 = paramString1.length() + i;
    int j = paramContext.indexOf(paramString2);
    int k = paramString2.length() + j;
    paramContext = new SpannableString(paramContext);
    if (paramf != null)
    {
      paramContext.setSpan(new b(paramInt2, paramInt3, paramBoolean, paramf), i, paramInt1, 33);
      paramContext.setSpan(new c(paramInt2, paramInt3, paramBoolean, paramf), j, k, 33);
    }
    else if (paramBoolean)
    {
      paramContext.setSpan(new UnderlineSpan(), i, paramInt1, 33);
      paramContext.setSpan(new UnderlineSpan(), j, k, 33);
    }
    return paramContext;
  }
  
  public LinkMovementMethod e()
  {
    return new e();
  }
  
  class a
    extends e0.h
  {
    a(int paramInt1, int paramInt2, boolean paramBoolean, e0.f paramf)
    {
      super(paramInt1, paramInt2, paramBoolean);
    }
    
    public void onClick(View paramView)
    {
      paramf.b(paramView);
    }
  }
  
  class b
    extends e0.h
  {
    b(int paramInt1, int paramInt2, boolean paramBoolean, e0.f paramf)
    {
      super(paramInt1, paramInt2, paramBoolean);
    }
    
    public void onClick(View paramView)
    {
      paramf.b(paramView);
    }
  }
  
  class c
    extends e0.h
  {
    c(int paramInt1, int paramInt2, boolean paramBoolean, e0.f paramf)
    {
      super(paramInt1, paramInt2, paramBoolean);
    }
    
    public void onClick(View paramView)
    {
      paramf.a(paramView);
    }
  }
  
  class d
    extends e0.h
  {
    d(int paramInt1, int paramInt2, boolean paramBoolean, e0.f paramf)
    {
      super(paramInt1, paramInt2, paramBoolean);
    }
    
    public void onClick(View paramView)
    {
      paramf.b(paramView);
    }
  }
  
  public class e
    extends LinkMovementMethod
  {
    private e0.h a;
    
    public e() {}
    
    public e0.h a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramTextView.getTotalPaddingLeft();
      int m = paramTextView.getTotalPaddingTop();
      int n = paramTextView.getScrollX();
      int i1 = paramTextView.getScrollY();
      paramTextView = paramTextView.getLayout();
      i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
      paramTextView = (e0.h[])paramSpannable.getSpans(i, i, e0.h.class);
      if (paramTextView.length > 0) {
        paramTextView = paramTextView[0];
      } else {
        paramTextView = null;
      }
      return paramTextView;
    }
    
    public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
        this.a = paramTextView;
        if (paramTextView != null)
        {
          paramTextView.a(true);
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.a), paramSpannable.getSpanEnd(this.a));
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        paramMotionEvent = a(paramTextView, paramSpannable, paramMotionEvent);
        paramTextView = this.a;
        if ((paramTextView != null) && (paramMotionEvent != paramTextView))
        {
          paramTextView.a(false);
          this.a = null;
          Selection.removeSelection(paramSpannable);
        }
      }
      else
      {
        e0.h localh = this.a;
        if (localh != null)
        {
          localh.a(false);
          super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
        }
        this.a = null;
        Selection.removeSelection(paramSpannable);
      }
      return true;
    }
  }
  
  public static abstract interface f
  {
    public abstract void a(View paramView);
    
    public abstract void b(View paramView);
  }
  
  private static class g
  {
    private static final e0 a = new e0();
  }
  
  public abstract class h
    extends ClickableSpan
  {
    private boolean c;
    private boolean d;
    private int f;
    private int q;
    
    public h(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.f = paramInt1;
      this.q = paramInt2;
      this.d = paramBoolean;
    }
    
    public void a(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      int i;
      if (this.c) {
        i = this.q;
      } else {
        i = this.f;
      }
      paramTextPaint.setColor(i);
      paramTextPaint.setUnderlineText(this.d);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */