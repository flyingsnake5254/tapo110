package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

class ImageViewUtils
{
  private static Field sDrawMatrixField;
  private static boolean sDrawMatrixFieldFetched = false;
  private static boolean sTryHiddenAnimateTransform = true;
  
  static void animateTransform(@NonNull ImageView paramImageView, @Nullable Matrix paramMatrix)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29)
    {
      paramImageView.animateTransform(paramMatrix);
    }
    else if (paramMatrix == null)
    {
      paramMatrix = paramImageView.getDrawable();
      if (paramMatrix != null)
      {
        paramMatrix.setBounds(0, 0, paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight(), paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom());
        paramImageView.invalidate();
      }
    }
    else if (i >= 21)
    {
      hiddenAnimateTransform(paramImageView, paramMatrix);
    }
    else
    {
      localObject1 = paramImageView.getDrawable();
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        localObject1 = null;
        Matrix localMatrix = null;
        fetchDrawMatrixField();
        Object localObject2 = sDrawMatrixField;
        if (localObject2 != null)
        {
          localObject1 = localMatrix;
          label174:
          try
          {
            localObject2 = (Matrix)((Field)localObject2).get(paramImageView);
            if (localObject2 != null) {}
          }
          catch (IllegalAccessException localIllegalAccessException2) {}
        }
      }
    }
    try
    {
      localMatrix = new android/graphics/Matrix;
      localMatrix.<init>();
      localObject1 = localMatrix;
      sDrawMatrixField.set(paramImageView, localMatrix);
      localObject1 = localMatrix;
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      break label174;
    }
    Object localObject1 = localObject2;
    if (localObject1 != null) {
      ((Matrix)localObject1).set(paramMatrix);
    }
    paramImageView.invalidate();
  }
  
  private static void fetchDrawMatrixField()
  {
    if (!sDrawMatrixFieldFetched) {}
    try
    {
      Field localField = ImageView.class.getDeclaredField("mDrawMatrix");
      sDrawMatrixField = localField;
      localField.setAccessible(true);
      sDrawMatrixFieldFetched = true;
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
  
  @SuppressLint({"NewApi"})
  @RequiresApi(21)
  private static void hiddenAnimateTransform(@NonNull ImageView paramImageView, @Nullable Matrix paramMatrix)
  {
    if (sTryHiddenAnimateTransform) {
      try
      {
        paramImageView.animateTransform(paramMatrix);
      }
      catch (NoSuchMethodError paramImageView)
      {
        sTryHiddenAnimateTransform = false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\ImageViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */