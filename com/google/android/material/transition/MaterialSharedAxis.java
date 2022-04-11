package com.google.android.material.transition;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialSharedAxis
  extends MaterialVisibility<VisibilityAnimatorProvider>
{
  public static final int X = 0;
  public static final int Y = 1;
  public static final int Z = 2;
  private final int axis;
  private final boolean forward;
  
  public MaterialSharedAxis(int paramInt, boolean paramBoolean)
  {
    super(createPrimaryAnimatorProvider(paramInt, paramBoolean), createSecondaryAnimatorProvider());
    this.axis = paramInt;
    this.forward = paramBoolean;
  }
  
  private static VisibilityAnimatorProvider createPrimaryAnimatorProvider(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return new ScaleProvider(paramBoolean);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid axis: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      if (paramBoolean) {
        paramInt = 80;
      } else {
        paramInt = 48;
      }
      return new SlideDistanceProvider(paramInt);
    }
    if (paramBoolean) {
      paramInt = 8388613;
    } else {
      paramInt = 8388611;
    }
    return new SlideDistanceProvider(paramInt);
  }
  
  private static VisibilityAnimatorProvider createSecondaryAnimatorProvider()
  {
    return new FadeThroughProvider();
  }
  
  public int getAxis()
  {
    return this.axis;
  }
  
  public boolean isForward()
  {
    return this.forward;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Axis {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\MaterialSharedAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */