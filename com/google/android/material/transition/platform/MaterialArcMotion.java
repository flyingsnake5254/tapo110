package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class MaterialArcMotion
  extends PathMotion
{
  private static PointF getControlPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat2 > paramFloat4) {
      return new PointF(paramFloat3, paramFloat2);
    }
    return new PointF(paramFloat1, paramFloat4);
  }
  
  @NonNull
  public Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat2);
    PointF localPointF = getControlPoint(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    localPath.quadTo(localPointF.x, localPointF.y, paramFloat3, paramFloat4);
    return localPath;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\platform\MaterialArcMotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */