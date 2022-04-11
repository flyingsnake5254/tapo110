package com.google.android.material.slider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.attr;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider
  extends BaseSlider<RangeSlider, OnChangeListener, OnSliderTouchListener>
{
  public RangeSlider(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RangeSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public RangeSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { R.attr.values });
    if (paramContext.hasValue(0))
    {
      paramInt = paramContext.getResourceId(0, 0);
      setValues(convertToFloat(paramContext.getResources().obtainTypedArray(paramInt)));
    }
    paramContext.recycle();
  }
  
  private static List<Float> convertToFloat(TypedArray paramTypedArray)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramTypedArray.length(); i++) {
      localArrayList.add(Float.valueOf(paramTypedArray.getFloat(i, -1.0F)));
    }
    return localArrayList;
  }
  
  @NonNull
  public List<Float> getValues()
  {
    return super.getValues();
  }
  
  public void setValues(@NonNull List<Float> paramList)
  {
    super.setValues(paramList);
  }
  
  public void setValues(@NonNull Float... paramVarArgs)
  {
    super.setValues(paramVarArgs);
  }
  
  public static abstract interface OnChangeListener
    extends BaseOnChangeListener<RangeSlider>
  {}
  
  public static abstract interface OnSliderTouchListener
    extends BaseOnSliderTouchListener<RangeSlider>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\slider\RangeSlider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */