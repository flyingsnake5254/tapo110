package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;

public class AppCompatCheckBox
  extends CheckBox
  implements TintableCompoundButton, TintableBackgroundView
{
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  private final AppCompatCompoundButtonHelper mCompoundButtonHelper;
  private final AppCompatTextHelper mTextHelper;
  
  public AppCompatCheckBox(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatCheckBox(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.checkboxStyle);
  }
  
  public AppCompatCheckBox(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(this, getContext());
    paramContext = new AppCompatCompoundButtonHelper(this);
    this.mCompoundButtonHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
    paramContext = new AppCompatBackgroundHelper(this);
    this.mBackgroundTintHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
    paramContext = new AppCompatTextHelper(this);
    this.mTextHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.mBackgroundTintHelper;
    if (localObject != null) {
      ((AppCompatBackgroundHelper)localObject).applySupportBackgroundTint();
    }
    localObject = this.mTextHelper;
    if (localObject != null) {
      ((AppCompatTextHelper)localObject).applyCompoundDrawablesTints();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int i = super.getCompoundPaddingLeft();
    AppCompatCompoundButtonHelper localAppCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    int j = i;
    if (localAppCompatCompoundButtonHelper != null) {
      j = localAppCompatCompoundButtonHelper.getCompoundPaddingLeft(i);
    }
    return j;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ColorStateList getSupportBackgroundTintList()
  {
    Object localObject = this.mBackgroundTintHelper;
    if (localObject != null) {
      localObject = ((AppCompatBackgroundHelper)localObject).getSupportBackgroundTintList();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    Object localObject = this.mBackgroundTintHelper;
    if (localObject != null) {
      localObject = ((AppCompatBackgroundHelper)localObject).getSupportBackgroundTintMode();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ColorStateList getSupportButtonTintList()
  {
    Object localObject = this.mCompoundButtonHelper;
    if (localObject != null) {
      localObject = ((AppCompatCompoundButtonHelper)localObject).getSupportButtonTintList();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    Object localObject = this.mCompoundButtonHelper;
    if (localObject != null) {
      localObject = ((AppCompatCompoundButtonHelper)localObject).getSupportButtonTintMode();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setButtonDrawable(@DrawableRes int paramInt)
  {
    setButtonDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    paramDrawable = this.mCompoundButtonHelper;
    if (paramDrawable != null) {
      paramDrawable.onSetButtonDrawable();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportButtonTintList(@Nullable ColorStateList paramColorStateList)
  {
    AppCompatCompoundButtonHelper localAppCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    if (localAppCompatCompoundButtonHelper != null) {
      localAppCompatCompoundButtonHelper.setSupportButtonTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    AppCompatCompoundButtonHelper localAppCompatCompoundButtonHelper = this.mCompoundButtonHelper;
    if (localAppCompatCompoundButtonHelper != null) {
      localAppCompatCompoundButtonHelper.setSupportButtonTintMode(paramMode);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */