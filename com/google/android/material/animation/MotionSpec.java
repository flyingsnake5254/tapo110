package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec
{
  private static final String TAG = "MotionSpec";
  private final SimpleArrayMap<String, PropertyValuesHolder[]> propertyValues = new SimpleArrayMap();
  private final SimpleArrayMap<String, MotionTiming> timings = new SimpleArrayMap();
  
  private static void addInfoFromAnimator(@NonNull MotionSpec paramMotionSpec, Animator paramAnimator)
  {
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      paramMotionSpec.setPropertyValues(paramAnimator.getPropertyName(), paramAnimator.getValues());
      paramMotionSpec.setTiming(paramAnimator.getPropertyName(), MotionTiming.createFromAnimator(paramAnimator));
      return;
    }
    paramMotionSpec = new StringBuilder();
    paramMotionSpec.append("Animator must be an ObjectAnimator: ");
    paramMotionSpec.append(paramAnimator);
    throw new IllegalArgumentException(paramMotionSpec.toString());
  }
  
  @NonNull
  private PropertyValuesHolder[] clonePropertyValuesHolder(@NonNull PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[paramArrayOfPropertyValuesHolder.length];
    for (int i = 0; i < paramArrayOfPropertyValuesHolder.length; i++) {
      arrayOfPropertyValuesHolder[i] = paramArrayOfPropertyValuesHolder[i].clone();
    }
    return arrayOfPropertyValuesHolder;
  }
  
  @Nullable
  public static MotionSpec createFromAttribute(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return createFromResource(paramContext, paramInt);
      }
    }
    return null;
  }
  
  @Nullable
  public static MotionSpec createFromResource(@NonNull Context paramContext, @AnimatorRes int paramInt)
  {
    try
    {
      Animator localAnimator = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((localAnimator instanceof AnimatorSet)) {
        return createSpecFromAnimators(((AnimatorSet)localAnimator).getChildAnimations());
      }
      if (localAnimator != null)
      {
        paramContext = new java/util/ArrayList;
        paramContext.<init>();
        paramContext.add(localAnimator);
        paramContext = createSpecFromAnimators(paramContext);
        return paramContext;
      }
      return null;
    }
    catch (Exception localException)
    {
      paramContext = new StringBuilder();
      paramContext.append("Can't load animation resource ID #0x");
      paramContext.append(Integer.toHexString(paramInt));
      Log.w("MotionSpec", paramContext.toString(), localException);
    }
    return null;
  }
  
  @NonNull
  private static MotionSpec createSpecFromAnimators(@NonNull List<Animator> paramList)
  {
    MotionSpec localMotionSpec = new MotionSpec();
    int i = paramList.size();
    for (int j = 0; j < i; j++) {
      addInfoFromAnimator(localMotionSpec, (Animator)paramList.get(j));
    }
    return localMotionSpec;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MotionSpec)) {
      return false;
    }
    paramObject = (MotionSpec)paramObject;
    return this.timings.equals(((MotionSpec)paramObject).timings);
  }
  
  @NonNull
  public <T> ObjectAnimator getAnimator(@NonNull String paramString, @NonNull T paramT, @NonNull Property<T, ?> paramProperty)
  {
    paramT = ObjectAnimator.ofPropertyValuesHolder(paramT, getPropertyValues(paramString));
    paramT.setProperty(paramProperty);
    getTiming(paramString).apply(paramT);
    return paramT;
  }
  
  @NonNull
  public PropertyValuesHolder[] getPropertyValues(String paramString)
  {
    if (hasPropertyValues(paramString)) {
      return clonePropertyValuesHolder((PropertyValuesHolder[])this.propertyValues.get(paramString));
    }
    throw new IllegalArgumentException();
  }
  
  public MotionTiming getTiming(String paramString)
  {
    if (hasTiming(paramString)) {
      return (MotionTiming)this.timings.get(paramString);
    }
    throw new IllegalArgumentException();
  }
  
  public long getTotalDuration()
  {
    int i = this.timings.size();
    long l = 0L;
    for (int j = 0; j < i; j++)
    {
      MotionTiming localMotionTiming = (MotionTiming)this.timings.valueAt(j);
      l = Math.max(l, localMotionTiming.getDelay() + localMotionTiming.getDuration());
    }
    return l;
  }
  
  public boolean hasPropertyValues(String paramString)
  {
    boolean bool;
    if (this.propertyValues.get(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean hasTiming(String paramString)
  {
    boolean bool;
    if (this.timings.get(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.timings.hashCode();
  }
  
  public void setPropertyValues(String paramString, PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    this.propertyValues.put(paramString, paramArrayOfPropertyValuesHolder);
  }
  
  public void setTiming(String paramString, @Nullable MotionTiming paramMotionTiming)
  {
    this.timings.put(paramString, paramMotionTiming);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" timings: ");
    localStringBuilder.append(this.timings);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\animation\MotionSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */