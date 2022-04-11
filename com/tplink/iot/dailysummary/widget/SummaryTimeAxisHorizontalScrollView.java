package com.tplink.iot.dailysummary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import kotlin.jvm.internal.j;

public final class SummaryTimeAxisHorizontalScrollView
  extends HorizontalScrollView
{
  private a c;
  
  public SummaryTimeAxisHorizontalScrollView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public SummaryTimeAxisHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public SummaryTimeAxisHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a locala = this.c;
    if (locala != null) {
      locala.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final void setScrollViewListener(a parama)
  {
    j.e(parama, "onScrollViewListener");
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\widget\SummaryTimeAxisHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */