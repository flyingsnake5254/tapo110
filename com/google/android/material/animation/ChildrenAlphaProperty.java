package com.google.android.material.animation;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R.id;

public class ChildrenAlphaProperty
  extends Property<ViewGroup, Float>
{
  public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");
  
  private ChildrenAlphaProperty(String paramString)
  {
    super(Float.class, paramString);
  }
  
  @NonNull
  public Float get(@NonNull ViewGroup paramViewGroup)
  {
    paramViewGroup = (Float)paramViewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
    if (paramViewGroup != null) {
      return paramViewGroup;
    }
    return Float.valueOf(1.0F);
  }
  
  public void set(@NonNull ViewGroup paramViewGroup, @NonNull Float paramFloat)
  {
    float f = paramFloat.floatValue();
    paramViewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(f));
    int i = paramViewGroup.getChildCount();
    for (int j = 0; j < i; j++) {
      paramViewGroup.getChildAt(j).setAlpha(f);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\animation\ChildrenAlphaProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */