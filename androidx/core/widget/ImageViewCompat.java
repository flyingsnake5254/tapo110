package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageViewCompat
{
  @Nullable
  public static ColorStateList getImageTintList(@NonNull ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramImageView.getImageTintList();
    }
    if ((paramImageView instanceof TintableImageSourceView)) {
      paramImageView = ((TintableImageSourceView)paramImageView).getSupportImageTintList();
    } else {
      paramImageView = null;
    }
    return paramImageView;
  }
  
  @Nullable
  public static PorterDuff.Mode getImageTintMode(@NonNull ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramImageView.getImageTintMode();
    }
    if ((paramImageView instanceof TintableImageSourceView)) {
      paramImageView = ((TintableImageSourceView)paramImageView).getSupportImageTintMode();
    } else {
      paramImageView = null;
    }
    return paramImageView;
  }
  
  public static void setImageTintList(@NonNull ImageView paramImageView, @Nullable ColorStateList paramColorStateList)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (i == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        if ((paramColorStateList != null) && (paramImageView.getImageTintList() != null))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
      }
    }
    else if ((paramImageView instanceof TintableImageSourceView))
    {
      ((TintableImageSourceView)paramImageView).setSupportImageTintList(paramColorStateList);
    }
  }
  
  public static void setImageTintMode(@NonNull ImageView paramImageView, @Nullable PorterDuff.Mode paramMode)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      paramImageView.setImageTintMode(paramMode);
      if (i == 21)
      {
        paramMode = paramImageView.getDrawable();
        if ((paramMode != null) && (paramImageView.getImageTintList() != null))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramMode);
        }
      }
    }
    else if ((paramImageView instanceof TintableImageSourceView))
    {
      ((TintableImageSourceView)paramImageView).setSupportImageTintMode(paramMode);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\ImageViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */