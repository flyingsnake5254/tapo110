package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion
{
  public PathMotion() {}
  
  public PathMotion(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public abstract Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\PathMotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */