package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper
{
  private ColorStateList mButtonTintList = null;
  private PorterDuff.Mode mButtonTintMode = null;
  private boolean mHasButtonTint = false;
  private boolean mHasButtonTintMode = false;
  private boolean mSkipNextApply;
  @NonNull
  private final CompoundButton mView;
  
  AppCompatCompoundButtonHelper(@NonNull CompoundButton paramCompoundButton)
  {
    this.mView = paramCompoundButton;
  }
  
  void applyButtonTint()
  {
    Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
    if ((localDrawable != null) && ((this.mHasButtonTint) || (this.mHasButtonTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      if (this.mHasButtonTint) {
        DrawableCompat.setTintList(localDrawable, this.mButtonTintList);
      }
      if (this.mHasButtonTintMode) {
        DrawableCompat.setTintMode(localDrawable, this.mButtonTintMode);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.mView.getDrawableState());
      }
      this.mView.setButtonDrawable(localDrawable);
    }
  }
  
  int getCompoundPaddingLeft(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  ColorStateList getSupportButtonTintList()
  {
    return this.mButtonTintList;
  }
  
  PorterDuff.Mode getSupportButtonTintMode()
  {
    return this.mButtonTintMode;
  }
  
  void loadFromAttributes(@Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    localObject = this.mView.getContext();
    int[] arrayOfInt = R.styleable.CompoundButton;
    localObject = TintTypedArray.obtainStyledAttributes((Context)localObject, paramAttributeSet, arrayOfInt, paramInt, 0);
    CompoundButton localCompoundButton = this.mView;
    ViewCompat.saveAttributeDataForStyleable(localCompoundButton, localCompoundButton.getContext(), arrayOfInt, paramAttributeSet, ((TintTypedArray)localObject).getWrappedTypeArray(), paramInt, 0);
    for (;;)
    {
      try
      {
        paramInt = R.styleable.CompoundButton_buttonCompat;
        if (((TintTypedArray)localObject).hasValue(paramInt))
        {
          paramInt = ((TintTypedArray)localObject).getResourceId(paramInt, 0);
          if (paramInt == 0) {}
        }
      }
      finally
      {
        ((TintTypedArray)localObject).recycle();
      }
      try
      {
        paramAttributeSet = this.mView;
        paramAttributeSet.setButtonDrawable(AppCompatResources.getDrawable(paramAttributeSet.getContext(), paramInt));
        paramInt = 1;
      }
      catch (Resources.NotFoundException paramAttributeSet) {}
    }
    paramInt = 0;
    if (paramInt == 0)
    {
      paramInt = R.styleable.CompoundButton_android_button;
      if (((TintTypedArray)localObject).hasValue(paramInt))
      {
        paramInt = ((TintTypedArray)localObject).getResourceId(paramInt, 0);
        if (paramInt != 0)
        {
          paramAttributeSet = this.mView;
          paramAttributeSet.setButtonDrawable(AppCompatResources.getDrawable(paramAttributeSet.getContext(), paramInt));
        }
      }
    }
    paramInt = R.styleable.CompoundButton_buttonTint;
    if (((TintTypedArray)localObject).hasValue(paramInt)) {
      CompoundButtonCompat.setButtonTintList(this.mView, ((TintTypedArray)localObject).getColorStateList(paramInt));
    }
    paramInt = R.styleable.CompoundButton_buttonTintMode;
    if (((TintTypedArray)localObject).hasValue(paramInt)) {
      CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(((TintTypedArray)localObject).getInt(paramInt, -1), null));
    }
    ((TintTypedArray)localObject).recycle();
  }
  
  void onSetButtonDrawable()
  {
    if (this.mSkipNextApply)
    {
      this.mSkipNextApply = false;
      return;
    }
    this.mSkipNextApply = true;
    applyButtonTint();
  }
  
  void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.mButtonTintList = paramColorStateList;
    this.mHasButtonTint = true;
    applyButtonTint();
  }
  
  void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mButtonTintMode = paramMode;
    this.mHasButtonTintMode = true;
    applyButtonTint();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatCompoundButtonHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */