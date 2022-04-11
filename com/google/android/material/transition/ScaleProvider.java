package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ScaleProvider
  implements VisibilityAnimatorProvider
{
  private boolean growing;
  private float incomingEndScale = 1.0F;
  private float incomingStartScale = 0.8F;
  private float outgoingEndScale = 1.1F;
  private float outgoingStartScale = 1.0F;
  private boolean scaleOnDisappear = true;
  
  public ScaleProvider()
  {
    this(true);
  }
  
  public ScaleProvider(boolean paramBoolean)
  {
    this.growing = paramBoolean;
  }
  
  private static Animator createScaleAnimator(View paramView, float paramFloat1, float paramFloat2)
  {
    return ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.SCALE_X, new float[] { paramFloat1, paramFloat2 }), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[] { paramFloat1, paramFloat2 }) });
  }
  
  @Nullable
  public Animator createAppear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    if (this.growing) {
      return createScaleAnimator(paramView, this.incomingStartScale, this.incomingEndScale);
    }
    return createScaleAnimator(paramView, this.outgoingEndScale, this.outgoingStartScale);
  }
  
  @Nullable
  public Animator createDisappear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    if (!this.scaleOnDisappear) {
      return null;
    }
    if (this.growing) {
      return createScaleAnimator(paramView, this.outgoingStartScale, this.outgoingEndScale);
    }
    return createScaleAnimator(paramView, this.incomingEndScale, this.incomingStartScale);
  }
  
  public float getIncomingEndScale()
  {
    return this.incomingEndScale;
  }
  
  public float getIncomingStartScale()
  {
    return this.incomingStartScale;
  }
  
  public float getOutgoingEndScale()
  {
    return this.outgoingEndScale;
  }
  
  public float getOutgoingStartScale()
  {
    return this.outgoingStartScale;
  }
  
  public boolean isGrowing()
  {
    return this.growing;
  }
  
  public boolean isScaleOnDisappear()
  {
    return this.scaleOnDisappear;
  }
  
  public void setGrowing(boolean paramBoolean)
  {
    this.growing = paramBoolean;
  }
  
  public void setIncomingEndScale(float paramFloat)
  {
    this.incomingEndScale = paramFloat;
  }
  
  public void setIncomingStartScale(float paramFloat)
  {
    this.incomingStartScale = paramFloat;
  }
  
  public void setOutgoingEndScale(float paramFloat)
  {
    this.outgoingEndScale = paramFloat;
  }
  
  public void setOutgoingStartScale(float paramFloat)
  {
    this.outgoingStartScale = paramFloat;
  }
  
  public void setScaleOnDisappear(boolean paramBoolean)
  {
    this.scaleOnDisappear = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\ScaleProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */