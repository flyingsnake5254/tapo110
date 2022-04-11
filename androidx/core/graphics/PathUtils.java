package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class PathUtils
{
  @NonNull
  @RequiresApi(26)
  public static Collection<PathSegment> flatten(@NonNull Path paramPath)
  {
    return flatten(paramPath, 0.5F);
  }
  
  @NonNull
  @RequiresApi(26)
  public static Collection<PathSegment> flatten(@NonNull Path paramPath, @FloatRange(from=0.0D) float paramFloat)
  {
    paramPath = paramPath.approximate(paramFloat);
    int i = paramPath.length / 3;
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 1; j < i; j++)
    {
      int k = j * 3;
      int m = (j - 1) * 3;
      float f1 = paramPath[k];
      float f2 = paramPath[(k + 1)];
      paramFloat = paramPath[(k + 2)];
      float f3 = paramPath[m];
      float f4 = paramPath[(m + 1)];
      float f5 = paramPath[(m + 2)];
      if ((f1 != f3) && ((f2 != f4) || (paramFloat != f5))) {
        localArrayList.add(new PathSegment(new PointF(f4, f5), f3, new PointF(f2, paramFloat), f1));
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\PathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */