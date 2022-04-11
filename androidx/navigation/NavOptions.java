package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

public final class NavOptions
{
  @AnimRes
  @AnimatorRes
  private int mEnterAnim;
  @AnimRes
  @AnimatorRes
  private int mExitAnim;
  @AnimRes
  @AnimatorRes
  private int mPopEnterAnim;
  @AnimRes
  @AnimatorRes
  private int mPopExitAnim;
  @IdRes
  private int mPopUpTo;
  private boolean mPopUpToInclusive;
  private boolean mSingleTop;
  
  NavOptions(boolean paramBoolean1, @IdRes int paramInt1, boolean paramBoolean2, @AnimRes @AnimatorRes int paramInt2, @AnimRes @AnimatorRes int paramInt3, @AnimRes @AnimatorRes int paramInt4, @AnimRes @AnimatorRes int paramInt5)
  {
    this.mSingleTop = paramBoolean1;
    this.mPopUpTo = paramInt1;
    this.mPopUpToInclusive = paramBoolean2;
    this.mEnterAnim = paramInt2;
    this.mExitAnim = paramInt3;
    this.mPopEnterAnim = paramInt4;
    this.mPopExitAnim = paramInt5;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (NavOptions.class == paramObject.getClass()))
    {
      paramObject = (NavOptions)paramObject;
      if ((this.mSingleTop != ((NavOptions)paramObject).mSingleTop) || (this.mPopUpTo != ((NavOptions)paramObject).mPopUpTo) || (this.mPopUpToInclusive != ((NavOptions)paramObject).mPopUpToInclusive) || (this.mEnterAnim != ((NavOptions)paramObject).mEnterAnim) || (this.mExitAnim != ((NavOptions)paramObject).mExitAnim) || (this.mPopEnterAnim != ((NavOptions)paramObject).mPopEnterAnim) || (this.mPopExitAnim != ((NavOptions)paramObject).mPopExitAnim)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @AnimRes
  @AnimatorRes
  public int getEnterAnim()
  {
    return this.mEnterAnim;
  }
  
  @AnimRes
  @AnimatorRes
  public int getExitAnim()
  {
    return this.mExitAnim;
  }
  
  @AnimRes
  @AnimatorRes
  public int getPopEnterAnim()
  {
    return this.mPopEnterAnim;
  }
  
  @AnimRes
  @AnimatorRes
  public int getPopExitAnim()
  {
    return this.mPopExitAnim;
  }
  
  @IdRes
  public int getPopUpTo()
  {
    return this.mPopUpTo;
  }
  
  public int hashCode()
  {
    return (((((shouldLaunchSingleTop() * true + getPopUpTo()) * 31 + isPopUpToInclusive()) * 31 + getEnterAnim()) * 31 + getExitAnim()) * 31 + getPopEnterAnim()) * 31 + getPopExitAnim();
  }
  
  public boolean isPopUpToInclusive()
  {
    return this.mPopUpToInclusive;
  }
  
  public boolean shouldLaunchSingleTop()
  {
    return this.mSingleTop;
  }
  
  public static final class Builder
  {
    @AnimRes
    @AnimatorRes
    int mEnterAnim = -1;
    @AnimRes
    @AnimatorRes
    int mExitAnim = -1;
    @AnimRes
    @AnimatorRes
    int mPopEnterAnim = -1;
    @AnimRes
    @AnimatorRes
    int mPopExitAnim = -1;
    @IdRes
    int mPopUpTo = -1;
    boolean mPopUpToInclusive;
    boolean mSingleTop;
    
    @NonNull
    public NavOptions build()
    {
      return new NavOptions(this.mSingleTop, this.mPopUpTo, this.mPopUpToInclusive, this.mEnterAnim, this.mExitAnim, this.mPopEnterAnim, this.mPopExitAnim);
    }
    
    @NonNull
    public Builder setEnterAnim(@AnimRes @AnimatorRes int paramInt)
    {
      this.mEnterAnim = paramInt;
      return this;
    }
    
    @NonNull
    public Builder setExitAnim(@AnimRes @AnimatorRes int paramInt)
    {
      this.mExitAnim = paramInt;
      return this;
    }
    
    @NonNull
    public Builder setLaunchSingleTop(boolean paramBoolean)
    {
      this.mSingleTop = paramBoolean;
      return this;
    }
    
    @NonNull
    public Builder setPopEnterAnim(@AnimRes @AnimatorRes int paramInt)
    {
      this.mPopEnterAnim = paramInt;
      return this;
    }
    
    @NonNull
    public Builder setPopExitAnim(@AnimRes @AnimatorRes int paramInt)
    {
      this.mPopExitAnim = paramInt;
      return this;
    }
    
    @NonNull
    public Builder setPopUpTo(@IdRes int paramInt, boolean paramBoolean)
    {
      this.mPopUpTo = paramInt;
      this.mPopUpToInclusive = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */