package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.core.graphics.drawable.DrawableCompat;

public class NextEventBulbTintView
  extends RelativeLayout
{
  private ImageView c;
  private Drawable d;
  
  public NextEventBulbTintView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NextEventBulbTintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NextEventBulbTintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = new ImageView(paramContext);
    paramAttributeSet = new ImageView(paramContext);
    this.c.setImageResource(2131689798);
    paramAttributeSet.setImageResource(2131689797);
    addView(this.c, new RelativeLayout.LayoutParams(-2, -2));
    addView(paramAttributeSet, new RelativeLayout.LayoutParams(-2, -2));
    if (Build.VERSION.SDK_INT < 21) {
      paramContext = getResources().getDrawable(2131689795);
    } else {
      paramContext = getResources().getDrawable(2131689795, paramContext.getTheme());
    }
    this.d = DrawableCompat.wrap(paramContext.mutate());
  }
  
  public void setTintColor(int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE)
    {
      setVisibility(8);
    }
    else
    {
      setVisibility(0);
      if (paramInt == 0)
      {
        this.c.setImageResource(2131689796);
      }
      else if (paramInt == -2147483647)
      {
        this.c.setImageResource(2131689798);
      }
      else
      {
        DrawableCompat.setTint(this.d, paramInt);
        this.c.setImageDrawable(this.d);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\NextEventBulbTintView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */