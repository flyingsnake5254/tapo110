package com.google.android.material.slider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.attr;
import java.util.List;

public class Slider
  extends BaseSlider<Slider, OnChangeListener, OnSliderTouchListener>
{
  public Slider(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Slider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public Slider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842788 });
    if (paramContext.hasValue(0)) {
      setValue(paramContext.getFloat(0, 0.0F));
    }
    paramContext.recycle();
  }
  
  public float getValue()
  {
    return ((Float)getValues().get(0)).floatValue();
  }
  
  protected boolean pickActiveThumb()
  {
    if (getActiveThumbIndex() != -1) {
      return true;
    }
    setActiveThumbIndex(0);
    return true;
  }
  
  public void setValue(float paramFloat)
  {
    setValues(new Float[] { Float.valueOf(paramFloat) });
  }
  
  public static abstract interface OnChangeListener
    extends BaseOnChangeListener<Slider>
  {}
  
  public static abstract interface OnSliderTouchListener
    extends BaseOnSliderTouchListener<Slider>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\slider\Slider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */