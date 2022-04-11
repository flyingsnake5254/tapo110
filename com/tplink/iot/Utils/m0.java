package com.tplink.iot.Utils;

import android.text.TextPaint;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import androidx.annotation.IdRes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;

public final class m0
{
  public static final void a(final boolean paramBoolean, final int paramInt1, final View paramView, @IdRes int paramInt2, @IdRes int... paramVarArgs)
  {
    j.e(paramView, "parent");
    j.e(paramVarArgs, "otherTextViewIds");
    final TextView localTextView = (TextView)paramView.findViewById(paramInt2);
    localTextView.addOnLayoutChangeListener(new a(paramVarArgs, paramView, localTextView, paramBoolean, paramInt1));
  }
  
  public static final void b(boolean paramBoolean, View paramView, @IdRes int paramInt, @IdRes int... paramVarArgs)
  {
    c(paramBoolean, 0, paramView, paramInt, paramVarArgs, 2, null);
  }
  
  public static final void d(boolean paramBoolean, int paramInt, TextView... paramVarArgs)
  {
    j.e(paramVarArgs, "textViews");
    float f1 = paramVarArgs[0].getTextSize();
    int i = paramVarArgs.length;
    float f2 = f1;
    int j = 0;
    while (j < i)
    {
      float f3 = e(paramBoolean, paramInt, paramVarArgs[j]);
      float f4 = f2;
      if (f3 < f2) {
        f4 = f3;
      }
      j++;
      f2 = f4;
    }
    if (f2 == f1) {
      return;
    }
    j = paramVarArgs.length;
    for (paramInt = 0; paramInt < j; paramInt++) {
      paramVarArgs[paramInt].setTextSize(0, f2);
    }
  }
  
  private static final float e(boolean paramBoolean, int paramInt, TextView paramTextView)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    j.d(localTextPaint, "paint");
    float f1 = localTextPaint.getTextSize();
    if (paramTextView.getLineCount() <= paramInt) {
      return f1;
    }
    int i = paramTextView.getWidth();
    int j = paramTextView.getTotalPaddingStart();
    int k = paramTextView.getTotalPaddingEnd();
    String str = paramTextView.getText().toString();
    paramTextView = str;
    if (paramBoolean)
    {
      Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
      paramTextView = str.toUpperCase();
      j.d(paramTextView, "(this as java.lang.String).toUpperCase()");
    }
    float f2 = localTextPaint.measureText(paramTextView);
    float f3 = f1;
    while (f2 > (i - j - k) * paramInt)
    {
      if (f3 < 10) {
        return f1;
      }
      f3 -= 1.0F;
      localTextPaint.setTextSize(f3);
      f2 = localTextPaint.measureText(paramTextView);
    }
    return f3 - 1.0F;
  }
  
  public static final class a
    implements View.OnLayoutChangeListener
  {
    a(int[] paramArrayOfInt, View paramView, TextView paramTextView, boolean paramBoolean, int paramInt) {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      j.e(paramView, "v");
      paramView = this.c;
      Object localObject = new ArrayList(paramView.length);
      paramInt3 = paramView.length;
      paramInt2 = 0;
      for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++)
      {
        paramInt4 = paramView[paramInt1];
        ((Collection)localObject).add((TextView)paramView.findViewById(paramInt4));
      }
      paramView = new o(2);
      paramView.a(localTextView);
      localObject = ((Collection)localObject).toArray(new TextView[0]);
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.Array<T>");
      paramView.b(localObject);
      paramView = (TextView[])paramView.d(new TextView[paramView.c()]);
      paramInt3 = this.c.length;
      for (paramInt1 = paramInt2; paramInt1 < paramInt3; paramInt1++) {
        paramView[paramInt1] = ((TextView)paramView.findViewById(this.c[paramInt1]));
      }
      m0.d(paramBoolean, paramInt1, (TextView[])Arrays.copyOf(paramView, paramView.length));
      localTextView.removeOnLayoutChangeListener(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\m0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */