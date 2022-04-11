package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import kotlin.jvm.internal.j;

public final class LightStripTintView
  extends FrameLayout
{
  private final ImageView c;
  private final ImageView d;
  
  public LightStripTintView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightStripTintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightStripTintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559430, this, true);
    paramContext = findViewById(2131363145);
    j.d(paramContext, "findViewById(R.id.iv_tint_bottom)");
    this.c = ((ImageView)paramContext);
    paramContext = findViewById(2131363146);
    j.d(paramContext, "findViewById(R.id.iv_tint_top)");
    this.d = ((ImageView)paramContext);
  }
  
  public final void setTintColor(int paramInt)
  {
    ImageViewCompat.setImageTintList(this.d, ColorStateList.valueOf(paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightStripTintView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */