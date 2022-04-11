package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tplink.iot.b;

public class DiffuseCircleView
  extends View
{
  private int c = getResources().getColor(2131100206);
  
  public DiffuseCircleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DiffuseCircleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DiffuseCircleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext.obtainStyledAttributes(paramAttributeSet, b.DiffuseCircleView, paramInt, 0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\DiffuseCircleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */