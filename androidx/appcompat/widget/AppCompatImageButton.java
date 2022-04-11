package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

public class AppCompatImageButton
  extends ImageButton
  implements TintableBackgroundView, TintableImageSourceView
{
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  private final AppCompatImageHelper mImageHelper;
  
  public AppCompatImageButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatImageButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public AppCompatImageButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(this, getContext());
    paramContext = new AppCompatBackgroundHelper(this);
    this.mBackgroundTintHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
    paramContext = new AppCompatImageHelper(this);
    this.mImageHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.mBackgroundTintHelper;
    if (localObject != null) {
      ((AppCompatBackgroundHelper)localObject).applySupportBackgroundTint();
    }
    localObject = this.mImageHelper;
    if (localObject != null) {
      ((AppCompatImageHelper)localObject).applySupportImageTint();
    }
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
  public ColorStateList getSupportImageTintList()
  {
    Object localObject = this.mImageHelper;
    if (localObject != null) {
      localObject = ((AppCompatImageHelper)localObject).getSupportImageTintList();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PorterDuff.Mode getSupportImageTintMode()
  {
    Object localObject = this.mImageHelper;
    if (localObject != null) {
      localObject = ((AppCompatImageHelper)localObject).getSupportImageTintMode();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public boolean hasOverlappingRendering()
  {
    boolean bool;
    if ((this.mImageHelper.hasOverlappingRendering()) && (super.hasOverlappingRendering())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
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
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    paramBitmap = this.mImageHelper;
    if (paramBitmap != null) {
      paramBitmap.applySupportImageTint();
    }
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.mImageHelper;
    if (paramDrawable != null) {
      paramDrawable.applySupportImageTint();
    }
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    this.mImageHelper.setImageResource(paramInt);
  }
  
  public void setImageURI(@Nullable Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.mImageHelper;
    if (paramUri != null) {
      paramUri.applySupportImageTint();
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
  public void setSupportImageTintList(@Nullable ColorStateList paramColorStateList)
  {
    AppCompatImageHelper localAppCompatImageHelper = this.mImageHelper;
    if (localAppCompatImageHelper != null) {
      localAppCompatImageHelper.setSupportImageTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportImageTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    AppCompatImageHelper localAppCompatImageHelper = this.mImageHelper;
    if (localAppCompatImageHelper != null) {
      localAppCompatImageHelper.setSupportImageTintMode(paramMode);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */