package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;

public final class CompoundButtonCompat
{
  private static final String TAG = "CompoundButtonCompat";
  private static Field sButtonDrawableField;
  private static boolean sButtonDrawableFieldFetched;
  
  @Nullable
  public static Drawable getButtonDrawable(@NonNull CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramCompoundButton.getButtonDrawable();
    }
    if (!sButtonDrawableFieldFetched)
    {
      try
      {
        Field localField1 = CompoundButton.class.getDeclaredField("mButtonDrawable");
        sButtonDrawableField = localField1;
        localField1.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", localNoSuchFieldException);
      }
      sButtonDrawableFieldFetched = true;
    }
    Field localField2 = sButtonDrawableField;
    if (localField2 != null) {
      try
      {
        paramCompoundButton = (Drawable)localField2.get(paramCompoundButton);
        return paramCompoundButton;
      }
      catch (IllegalAccessException paramCompoundButton)
      {
        Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", paramCompoundButton);
        sButtonDrawableField = null;
      }
    }
    return null;
  }
  
  @Nullable
  public static ColorStateList getButtonTintList(@NonNull CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramCompoundButton.getButtonTintList();
    }
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList();
    }
    return null;
  }
  
  @Nullable
  public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramCompoundButton.getButtonTintMode();
    }
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode();
    }
    return null;
  }
  
  public static void setButtonTintList(@NonNull CompoundButton paramCompoundButton, @Nullable ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintList(paramColorStateList);
    } else if ((paramCompoundButton instanceof TintableCompoundButton)) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
    }
  }
  
  public static void setButtonTintMode(@NonNull CompoundButton paramCompoundButton, @Nullable PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramCompoundButton.setButtonTintMode(paramMode);
    } else if ((paramCompoundButton instanceof TintableCompoundButton)) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\widget\CompoundButtonCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */