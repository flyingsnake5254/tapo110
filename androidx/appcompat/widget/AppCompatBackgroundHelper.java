package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.styleable;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper
{
  private int mBackgroundResId = -1;
  private TintInfo mBackgroundTint;
  private final AppCompatDrawableManager mDrawableManager;
  private TintInfo mInternalBackgroundTint;
  private TintInfo mTmpInfo;
  @NonNull
  private final View mView;
  
  AppCompatBackgroundHelper(@NonNull View paramView)
  {
    this.mView = paramView;
    this.mDrawableManager = AppCompatDrawableManager.get();
  }
  
  private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable paramDrawable)
  {
    if (this.mTmpInfo == null) {
      this.mTmpInfo = new TintInfo();
    }
    TintInfo localTintInfo = this.mTmpInfo;
    localTintInfo.clear();
    Object localObject = ViewCompat.getBackgroundTintList(this.mView);
    if (localObject != null)
    {
      localTintInfo.mHasTintList = true;
      localTintInfo.mTintList = ((ColorStateList)localObject);
    }
    localObject = ViewCompat.getBackgroundTintMode(this.mView);
    if (localObject != null)
    {
      localTintInfo.mHasTintMode = true;
      localTintInfo.mTintMode = ((PorterDuff.Mode)localObject);
    }
    if ((!localTintInfo.mHasTintList) && (!localTintInfo.mHasTintMode)) {
      return false;
    }
    AppCompatDrawableManager.tintDrawable(paramDrawable, localTintInfo, this.mView.getDrawableState());
    return true;
  }
  
  private boolean shouldApplyFrameworkTintUsingColorFilter()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i > 21)
    {
      if (this.mInternalBackgroundTint == null) {
        bool = false;
      }
      return bool;
    }
    return i == 21;
  }
  
  void applySupportBackgroundTint()
  {
    Drawable localDrawable = this.mView.getBackground();
    if (localDrawable != null)
    {
      if ((shouldApplyFrameworkTintUsingColorFilter()) && (applyFrameworkTintUsingColorFilter(localDrawable))) {
        return;
      }
      TintInfo localTintInfo = this.mBackgroundTint;
      if (localTintInfo != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, this.mView.getDrawableState());
      }
      else
      {
        localTintInfo = this.mInternalBackgroundTint;
        if (localTintInfo != null) {
          AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, this.mView.getDrawableState());
        }
      }
    }
  }
  
  ColorStateList getSupportBackgroundTintList()
  {
    Object localObject = this.mBackgroundTint;
    if (localObject != null) {
      localObject = ((TintInfo)localObject).mTintList;
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  PorterDuff.Mode getSupportBackgroundTintMode()
  {
    Object localObject = this.mBackgroundTint;
    if (localObject != null) {
      localObject = ((TintInfo)localObject).mTintMode;
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  void loadFromAttributes(@Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject = this.mView.getContext();
    int[] arrayOfInt = R.styleable.ViewBackgroundHelper;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    View localView = this.mView;
    ViewCompat.saveAttributeDataForStyleable(localView, localView.getContext(), arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getWrappedTypeArray(), paramInt, 0);
    try
    {
      paramInt = R.styleable.ViewBackgroundHelper_android_background;
      if (((TintTypedArray)localObject).hasValue(paramInt))
      {
        this.mBackgroundResId = ((TintTypedArray)localObject).getResourceId(paramInt, -1);
        paramAttributeSet = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
        if (paramAttributeSet != null) {
          setInternalBackgroundTint(paramAttributeSet);
        }
      }
      paramInt = R.styleable.ViewBackgroundHelper_backgroundTint;
      if (((TintTypedArray)localObject).hasValue(paramInt)) {
        ViewCompat.setBackgroundTintList(this.mView, ((TintTypedArray)localObject).getColorStateList(paramInt));
      }
      paramInt = R.styleable.ViewBackgroundHelper_backgroundTintMode;
      if (((TintTypedArray)localObject).hasValue(paramInt)) {
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(((TintTypedArray)localObject).getInt(paramInt, -1), null));
      }
      return;
    }
    finally
    {
      ((TintTypedArray)localObject).recycle();
    }
  }
  
  void onSetBackgroundDrawable(Drawable paramDrawable)
  {
    this.mBackgroundResId = -1;
    setInternalBackgroundTint(null);
    applySupportBackgroundTint();
  }
  
  void onSetBackgroundResource(int paramInt)
  {
    this.mBackgroundResId = paramInt;
    Object localObject = this.mDrawableManager;
    if (localObject != null) {
      localObject = ((AppCompatDrawableManager)localObject).getTintList(this.mView.getContext(), paramInt);
    } else {
      localObject = null;
    }
    setInternalBackgroundTint((ColorStateList)localObject);
    applySupportBackgroundTint();
  }
  
  void setInternalBackgroundTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.mInternalBackgroundTint == null) {
        this.mInternalBackgroundTint = new TintInfo();
      }
      TintInfo localTintInfo = this.mInternalBackgroundTint;
      localTintInfo.mTintList = paramColorStateList;
      localTintInfo.mHasTintList = true;
    }
    else
    {
      this.mInternalBackgroundTint = null;
    }
    applySupportBackgroundTint();
  }
  
  void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTint == null) {
      this.mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mBackgroundTint;
    localTintInfo.mTintList = paramColorStateList;
    localTintInfo.mHasTintList = true;
    applySupportBackgroundTint();
  }
  
  void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTint == null) {
      this.mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mBackgroundTint;
    localTintInfo.mTintMode = paramMode;
    localTintInfo.mHasTintMode = true;
    applySupportBackgroundTint();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatBackgroundHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */