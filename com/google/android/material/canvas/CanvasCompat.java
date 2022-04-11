package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat
{
  public static int saveLayerAlpha(@NonNull Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (Build.VERSION.SDK_INT > 21) {
      return paramCanvas.saveLayerAlpha(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt);
    }
    return paramCanvas.saveLayerAlpha(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 31);
  }
  
  public static int saveLayerAlpha(@NonNull Canvas paramCanvas, @Nullable RectF paramRectF, int paramInt)
  {
    if (Build.VERSION.SDK_INT > 21) {
      return paramCanvas.saveLayerAlpha(paramRectF, paramInt);
    }
    return paramCanvas.saveLayerAlpha(paramRectF, paramInt, 31);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\canvas\CanvasCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */