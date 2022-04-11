package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

public class SmallBulbTintView
  extends RelativeLayout
{
  private ImageView c;
  private Drawable d;
  
  public SmallBulbTintView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmallBulbTintView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmallBulbTintView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559439, this, true);
    this.c = ((ImageView)findViewById(2131363004));
    if (Build.VERSION.SDK_INT < 21) {
      paramContext = getResources().getDrawable(2131690374);
    } else {
      paramContext = getResources().getDrawable(2131690374, paramContext.getTheme());
    }
    this.d = DrawableCompat.wrap(paramContext.mutate());
  }
  
  public void setTintColor(int paramInt)
  {
    if (paramInt == 0)
    {
      this.c.setImageResource(2131689964);
    }
    else if (paramInt == -2147483647)
    {
      this.c.setImageResource(2131690372);
    }
    else
    {
      DrawableCompat.setTint(this.d, paramInt);
      this.c.setImageDrawable(this.d);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\SmallBulbTintView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */