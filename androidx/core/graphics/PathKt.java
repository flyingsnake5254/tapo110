package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.Path.Op;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;

public final class PathKt
{
  @RequiresApi(19)
  public static final Path and(Path paramPath1, Path paramPath2)
  {
    j.f(paramPath1, "$this$and");
    j.f(paramPath2, "p");
    Path localPath = new Path();
    localPath.op(paramPath1, paramPath2, Path.Op.INTERSECT);
    return localPath;
  }
  
  @RequiresApi(26)
  public static final Iterable<PathSegment> flatten(Path paramPath, float paramFloat)
  {
    j.f(paramPath, "$this$flatten");
    paramPath = PathUtils.flatten(paramPath, paramFloat);
    j.b(paramPath, "PathUtils.flatten(this, error)");
    return paramPath;
  }
  
  @RequiresApi(19)
  public static final Path minus(Path paramPath1, Path paramPath2)
  {
    j.f(paramPath1, "$this$minus");
    j.f(paramPath2, "p");
    paramPath1 = new Path(paramPath1);
    paramPath1.op(paramPath2, Path.Op.DIFFERENCE);
    return paramPath1;
  }
  
  @RequiresApi(19)
  public static final Path or(Path paramPath1, Path paramPath2)
  {
    j.f(paramPath1, "$this$or");
    j.f(paramPath2, "p");
    paramPath1 = new Path(paramPath1);
    paramPath1.op(paramPath2, Path.Op.UNION);
    return paramPath1;
  }
  
  @RequiresApi(19)
  public static final Path plus(Path paramPath1, Path paramPath2)
  {
    j.f(paramPath1, "$this$plus");
    j.f(paramPath2, "p");
    paramPath1 = new Path(paramPath1);
    paramPath1.op(paramPath2, Path.Op.UNION);
    return paramPath1;
  }
  
  @RequiresApi(19)
  public static final Path xor(Path paramPath1, Path paramPath2)
  {
    j.f(paramPath1, "$this$xor");
    j.f(paramPath2, "p");
    paramPath1 = new Path(paramPath1);
    paramPath1.op(paramPath2, Path.Op.XOR);
    return paramPath1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\PathKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */