package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.math.MathUtils;

public abstract interface CircularRevealWidget
  extends CircularRevealHelper.Delegate
{
  public abstract void buildCircularRevealCache();
  
  public abstract void destroyCircularRevealCache();
  
  public abstract void draw(Canvas paramCanvas);
  
  @Nullable
  public abstract Drawable getCircularRevealOverlayDrawable();
  
  @ColorInt
  public abstract int getCircularRevealScrimColor();
  
  @Nullable
  public abstract RevealInfo getRevealInfo();
  
  public abstract boolean isOpaque();
  
  public abstract void setCircularRevealOverlayDrawable(@Nullable Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(@ColorInt int paramInt);
  
  public abstract void setRevealInfo(@Nullable RevealInfo paramRevealInfo);
  
  public static class CircularRevealEvaluator
    implements TypeEvaluator<CircularRevealWidget.RevealInfo>
  {
    public static final TypeEvaluator<CircularRevealWidget.RevealInfo> CIRCULAR_REVEAL = new CircularRevealEvaluator();
    private final CircularRevealWidget.RevealInfo revealInfo = new CircularRevealWidget.RevealInfo(null);
    
    @NonNull
    public CircularRevealWidget.RevealInfo evaluate(float paramFloat, @NonNull CircularRevealWidget.RevealInfo paramRevealInfo1, @NonNull CircularRevealWidget.RevealInfo paramRevealInfo2)
    {
      this.revealInfo.set(MathUtils.lerp(paramRevealInfo1.centerX, paramRevealInfo2.centerX, paramFloat), MathUtils.lerp(paramRevealInfo1.centerY, paramRevealInfo2.centerY, paramFloat), MathUtils.lerp(paramRevealInfo1.radius, paramRevealInfo2.radius, paramFloat));
      return this.revealInfo;
    }
  }
  
  public static class CircularRevealProperty
    extends Property<CircularRevealWidget, CircularRevealWidget.RevealInfo>
  {
    public static final Property<CircularRevealWidget, CircularRevealWidget.RevealInfo> CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
    
    private CircularRevealProperty(String paramString)
    {
      super(paramString);
    }
    
    @Nullable
    public CircularRevealWidget.RevealInfo get(@NonNull CircularRevealWidget paramCircularRevealWidget)
    {
      return paramCircularRevealWidget.getRevealInfo();
    }
    
    public void set(@NonNull CircularRevealWidget paramCircularRevealWidget, @Nullable CircularRevealWidget.RevealInfo paramRevealInfo)
    {
      paramCircularRevealWidget.setRevealInfo(paramRevealInfo);
    }
  }
  
  public static class CircularRevealScrimColorProperty
    extends Property<CircularRevealWidget, Integer>
  {
    public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
    
    private CircularRevealScrimColorProperty(String paramString)
    {
      super(paramString);
    }
    
    @NonNull
    public Integer get(@NonNull CircularRevealWidget paramCircularRevealWidget)
    {
      return Integer.valueOf(paramCircularRevealWidget.getCircularRevealScrimColor());
    }
    
    public void set(@NonNull CircularRevealWidget paramCircularRevealWidget, @NonNull Integer paramInteger)
    {
      paramCircularRevealWidget.setCircularRevealScrimColor(paramInteger.intValue());
    }
  }
  
  public static class RevealInfo
  {
    public static final float INVALID_RADIUS = Float.MAX_VALUE;
    public float centerX;
    public float centerY;
    public float radius;
    
    private RevealInfo() {}
    
    public RevealInfo(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
      this.radius = paramFloat3;
    }
    
    public RevealInfo(@NonNull RevealInfo paramRevealInfo)
    {
      this(paramRevealInfo.centerX, paramRevealInfo.centerY, paramRevealInfo.radius);
    }
    
    public boolean isInvalid()
    {
      boolean bool;
      if (this.radius == Float.MAX_VALUE) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void set(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
      this.radius = paramFloat3;
    }
    
    public void set(@NonNull RevealInfo paramRevealInfo)
    {
      set(paramRevealInfo.centerX, paramRevealInfo.centerY, paramRevealInfo.radius);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\circularreveal\CircularRevealWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */