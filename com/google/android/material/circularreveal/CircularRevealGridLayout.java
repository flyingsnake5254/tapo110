package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CircularRevealGridLayout
  extends GridLayout
  implements CircularRevealWidget
{
  @NonNull
  private final CircularRevealHelper helper = new CircularRevealHelper(this);
  
  public CircularRevealGridLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularRevealGridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void actualDraw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public boolean actualIsOpaque()
  {
    return super.isOpaque();
  }
  
  public void buildCircularRevealCache()
  {
    this.helper.buildCircularRevealCache();
  }
  
  public void destroyCircularRevealCache()
  {
    this.helper.destroyCircularRevealCache();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    CircularRevealHelper localCircularRevealHelper = this.helper;
    if (localCircularRevealHelper != null) {
      localCircularRevealHelper.draw(paramCanvas);
    } else {
      super.draw(paramCanvas);
    }
  }
  
  @Nullable
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.helper.getCircularRevealOverlayDrawable();
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.helper.getCircularRevealScrimColor();
  }
  
  @Nullable
  public CircularRevealWidget.RevealInfo getRevealInfo()
  {
    return this.helper.getRevealInfo();
  }
  
  public boolean isOpaque()
  {
    CircularRevealHelper localCircularRevealHelper = this.helper;
    if (localCircularRevealHelper != null) {
      return localCircularRevealHelper.isOpaque();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(@Nullable Drawable paramDrawable)
  {
    this.helper.setCircularRevealOverlayDrawable(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(@ColorInt int paramInt)
  {
    this.helper.setCircularRevealScrimColor(paramInt);
  }
  
  public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    this.helper.setRevealInfo(paramRevealInfo);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\circularreveal\CircularRevealGridLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */