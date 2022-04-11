package com.tplink.iot.Utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.widget.PointTextView;

public class d0
{
  public static void a(TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    if (paramTextView != null)
    {
      int i = paramString1.indexOf(paramString2);
      int j = paramString1.indexOf(paramString2) + paramString2.length();
      paramString1 = new SpannableString(paramString1);
      if ((i >= 0) && (i < j)) {
        paramString1.setSpan(new ForegroundColorSpan(paramInt), i, j, 33);
      }
      paramTextView.setText(paramString1);
    }
  }
  
  public static void b(PointTextView paramPointTextView, String paramString1, String paramString2, int paramInt)
  {
    if (paramPointTextView != null)
    {
      int i = paramString1.indexOf(paramString2);
      int j = paramString1.indexOf(paramString2) + paramString2.length();
      paramString1 = new SpannableString(paramString1);
      if ((i >= 0) && (i < j)) {
        paramString1.setSpan(new ForegroundColorSpan(paramInt), i, j, 33);
      }
      paramPointTextView.setContent(paramString1);
    }
  }
  
  public static void c(TextView paramTextView, String paramString1, String paramString2, int paramInt, g paramg)
  {
    if (paramTextView != null)
    {
      int i = paramString1.indexOf(paramString2);
      int j = paramString1.indexOf(paramString2) + paramString2.length();
      int k = i;
      if (i == -1)
      {
        k = 0;
        j = paramString1.length();
      }
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new c(paramg), k, j, 33);
      paramString1.setSpan(new ForegroundColorSpan(paramInt), k, j, 33);
      paramTextView.setText(paramString1);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public static void d(Context paramContext, TextView paramTextView, int paramInt, String paramString, g paramg)
  {
    if (paramTextView != null)
    {
      paramTextView.setText(e0.d().b(paramContext, paramInt, paramString, true, ContextCompat.getColor(paramContext, 2131099811), ContextCompat.getColor(paramContext, 2131099811), new d(paramg)));
      paramTextView.setClickable(true);
      paramTextView.setMovementMethod(e0.d().e());
    }
  }
  
  public static void e(TextView paramTextView, String paramString1, String paramString2, int paramInt, g paramg)
  {
    if (paramTextView != null)
    {
      int i = 0;
      paramString1 = String.format(paramString1, new Object[] { paramString2 });
      SpannableString localSpannableString = new SpannableString(paramString1);
      int j = paramString1.indexOf(paramString2);
      int k = paramString1.indexOf(paramString2) + paramString2.length();
      if (j == -1) {
        k = paramString1.length();
      } else {
        i = j;
      }
      localSpannableString.setSpan(new a(paramg), i, k, 33);
      localSpannableString.setSpan(new UnderlineSpan(), i, k, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(paramInt), i, k, 33);
      paramTextView.setText(localSpannableString);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public static void f(Context paramContext, TextView paramTextView, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, g paramg, final f paramf)
  {
    if (paramTextView != null)
    {
      paramTextView.setText(e0.d().c(paramContext, paramInt1, paramString1, paramString2, true, paramInt2, paramInt3, new e(paramg, paramf)));
      paramTextView.setClickable(true);
      paramTextView.setMovementMethod(e0.d().e());
    }
  }
  
  public static void g(Context paramContext, TextView paramTextView, int paramInt, String paramString1, String paramString2, g paramg, f paramf)
  {
    if ((paramContext != null) && (paramTextView != null)) {
      f(paramContext, paramTextView, paramInt, paramString1, paramString2, ContextCompat.getColor(paramContext, 2131100138), ContextCompat.getColor(paramContext, 2131099854), paramg, paramf);
    }
  }
  
  public static void h(TextView paramTextView, String paramString, final int paramInt, g paramg)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString)))
    {
      SpannableString localSpannableString = new SpannableString(paramString);
      localSpannableString.setSpan(new b(paramg, paramInt), 0, paramString.length(), 33);
      paramTextView.setHighlightColor(0);
      paramTextView.setText(localSpannableString);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  static final class a
    extends ClickableSpan
  {
    a(d0.g paramg) {}
    
    public void onClick(View paramView)
    {
      paramView = this.c;
      if (paramView != null) {
        paramView.a();
      }
    }
  }
  
  static final class b
    extends ClickableSpan
  {
    b(d0.g paramg, int paramInt) {}
    
    public void onClick(View paramView)
    {
      paramView = this.c;
      if (paramView != null) {
        paramView.a();
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setColor(paramInt);
      paramTextPaint.setUnderlineText(true);
    }
  }
  
  static final class c
    extends ClickableSpan
  {
    c(d0.g paramg) {}
    
    public void onClick(View paramView)
    {
      paramView = this.c;
      if (paramView != null) {
        paramView.a();
      }
    }
  }
  
  static final class d
    implements e0.f
  {
    d(d0.g paramg) {}
    
    public void a(View paramView)
    {
      paramView = this.a;
      if (paramView != null) {
        paramView.a();
      }
    }
    
    public void b(View paramView)
    {
      paramView = this.a;
      if (paramView != null) {
        paramView.a();
      }
    }
  }
  
  static final class e
    implements e0.f
  {
    e(d0.g paramg, d0.f paramf) {}
    
    public void a(View paramView)
    {
      paramView = paramf;
      if (paramView != null) {
        paramView.a();
      }
    }
    
    public void b(View paramView)
    {
      paramView = this.a;
      if (paramView != null) {
        paramView.a();
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void a();
  }
  
  public static abstract interface g
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */