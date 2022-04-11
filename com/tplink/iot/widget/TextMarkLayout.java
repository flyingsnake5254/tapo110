package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import net.lucode.hackware.magicindicator.g.b;

public class TextMarkLayout
  extends LinearLayout
{
  private String[] c = { getContext().getString(2131954112), getContext().getString(2131952382), getContext().getString(2131952379) };
  
  public TextMarkLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextMarkLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextMarkLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    for (int i = 0; i < this.c.length; i++)
    {
      View localView = LayoutInflater.from(paramContext).inflate(2131559412, null);
      ((TextView)localView.findViewById(2131364525)).setText(this.c[i]);
      addView(localView, new LinearLayout.LayoutParams(-2, -2));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    paramInt4 = getPaddingLeft();
    paramInt3 = getMeasuredWidth();
    int j = getPaddingRight();
    for (paramInt1 = 0; paramInt1 < i; paramInt1++)
    {
      View localView = getChildAt(paramInt1);
      if (paramInt1 == 0) {
        paramInt2 = b.a(getContext(), 12.0D);
      } else {
        paramInt2 = b.a(getContext(), 60.0D) * (paramInt1 + 1);
      }
      localView.layout(paramInt4, paramInt2, paramInt3 - j, localView.getMeasuredHeight() + paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getChildCount();
    int j = 0;
    if (i > 0) {
      j = getChildAt(0).getMeasuredHeight();
    }
    setMeasuredDimension(paramInt1, LinearLayout.resolveSize(getPaddingTop() + getPaddingBottom() + b.a(getContext(), 240.0D) + j, paramInt2));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\TextMarkLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */