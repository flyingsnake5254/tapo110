package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper
{
  private TintInfo mImageTint;
  private TintInfo mInternalImageTint;
  private TintInfo mTmpInfo;
  @NonNull
  private final ImageView mView;
  
  public AppCompatImageHelper(@NonNull ImageView paramImageView)
  {
    this.mView = paramImageView;
  }
  
  private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable paramDrawable)
  {
    if (this.mTmpInfo == null) {
      this.mTmpInfo = new TintInfo();
    }
    TintInfo localTintInfo = this.mTmpInfo;
    localTintInfo.clear();
    Object localObject = ImageViewCompat.getImageTintList(this.mView);
    if (localObject != null)
    {
      localTintInfo.mHasTintList = true;
      localTintInfo.mTintList = ((ColorStateList)localObject);
    }
    localObject = ImageViewCompat.getImageTintMode(this.mView);
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
      if (this.mInternalImageTint == null) {
        bool = false;
      }
      return bool;
    }
    return i == 21;
  }
  
  void applySupportImageTint()
  {
    Drawable localDrawable = this.mView.getDrawable();
    if (localDrawable != null) {
      DrawableUtils.fixDrawable(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((shouldApplyFrameworkTintUsingColorFilter()) && (applyFrameworkTintUsingColorFilter(localDrawable))) {
        return;
      }
      TintInfo localTintInfo = this.mImageTint;
      if (localTintInfo != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, this.mView.getDrawableState());
      }
      else
      {
        localTintInfo = this.mInternalImageTint;
        if (localTintInfo != null) {
          AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, this.mView.getDrawableState());
        }
      }
    }
  }
  
  ColorStateList getSupportImageTintList()
  {
    Object localObject = this.mImageTint;
    if (localObject != null) {
      localObject = ((TintInfo)localObject).mTintList;
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  PorterDuff.Mode getSupportImageTintMode()
  {
    Object localObject = this.mImageTint;
    if (localObject != null) {
      localObject = ((TintInfo)localObject).mTintMode;
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.mView.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject1 = this.mView.getContext();
    Object localObject2 = R.styleable.AppCompatImageView;
    localObject1 = TintTypedArray.obtainStyledAttributes((Context)localObject1, paramAttributeSet, (int[])localObject2, paramInt, 0);
    ImageView localImageView = this.mView;
    ViewCompat.saveAttributeDataForStyleable(localImageView, localImageView.getContext(), (int[])localObject2, paramAttributeSet, ((TintTypedArray)localObject1).getWrappedTypeArray(), paramInt, 0);
    try
    {
      localObject2 = this.mView.getDrawable();
      paramAttributeSet = (AttributeSet)localObject2;
      if (localObject2 == null)
      {
        paramInt = ((TintTypedArray)localObject1).getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = (AttributeSet)localObject2;
        if (paramInt != -1)
        {
          localObject2 = AppCompatResources.getDrawable(this.mView.getContext(), paramInt);
          paramAttributeSet = (AttributeSet)localObject2;
          if (localObject2 != null)
          {
            this.mView.setImageDrawable((Drawable)localObject2);
            paramAttributeSet = (AttributeSet)localObject2;
          }
        }
      }
      if (paramAttributeSet != null) {
        DrawableUtils.fixDrawable(paramAttributeSet);
      }
      paramInt = R.styleable.AppCompatImageView_tint;
      if (((TintTypedArray)localObject1).hasValue(paramInt)) {
        ImageViewCompat.setImageTintList(this.mView, ((TintTypedArray)localObject1).getColorStateList(paramInt));
      }
      paramInt = R.styleable.AppCompatImageView_tintMode;
      if (((TintTypedArray)localObject1).hasValue(paramInt)) {
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(((TintTypedArray)localObject1).getInt(paramInt, -1), null));
      }
      return;
    }
    finally
    {
      ((TintTypedArray)localObject1).recycle();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = AppCompatResources.getDrawable(this.mView.getContext(), paramInt);
      if (localDrawable != null) {
        DrawableUtils.fixDrawable(localDrawable);
      }
      this.mView.setImageDrawable(localDrawable);
    }
    else
    {
      this.mView.setImageDrawable(null);
    }
    applySupportImageTint();
  }
  
  void setInternalImageTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.mInternalImageTint == null) {
        this.mInternalImageTint = new TintInfo();
      }
      TintInfo localTintInfo = this.mInternalImageTint;
      localTintInfo.mTintList = paramColorStateList;
      localTintInfo.mHasTintList = true;
    }
    else
    {
      this.mInternalImageTint = null;
    }
    applySupportImageTint();
  }
  
  void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.mImageTint == null) {
      this.mImageTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mImageTint;
    localTintInfo.mTintList = paramColorStateList;
    localTintInfo.mHasTintList = true;
    applySupportImageTint();
  }
  
  void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mImageTint == null) {
      this.mImageTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mImageTint;
    localTintInfo.mTintMode = paramMode;
    localTintInfo.mHasTintMode = true;
    applySupportImageTint();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatImageHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */