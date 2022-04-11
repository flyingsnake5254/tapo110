package com.tplink.libtpcontrols;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ScrollView;

public class TPMaxHeightScrollView
  extends ScrollView
{
  private Context c;
  
  public TPMaxHeightScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPMaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPMaxHeightScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      Display localDisplay = ((Activity)this.c).getWindowManager().getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new android/util/DisplayMetrics;
      localDisplayMetrics.<init>();
      localDisplay.getMetrics(localDisplayMetrics);
      int i = View.MeasureSpec.makeMeasureSpec(localDisplayMetrics.heightPixels / 2, Integer.MIN_VALUE);
      paramInt2 = i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPMaxHeightScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */