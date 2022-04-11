package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;

public final class SizeKt
{
  @RequiresApi(21)
  public static final float component1(SizeF paramSizeF)
  {
    j.f(paramSizeF, "$this$component1");
    return paramSizeF.getWidth();
  }
  
  @RequiresApi(21)
  public static final int component1(Size paramSize)
  {
    j.f(paramSize, "$this$component1");
    return paramSize.getWidth();
  }
  
  @RequiresApi(21)
  public static final float component2(SizeF paramSizeF)
  {
    j.f(paramSizeF, "$this$component2");
    return paramSizeF.getHeight();
  }
  
  @RequiresApi(21)
  public static final int component2(Size paramSize)
  {
    j.f(paramSize, "$this$component2");
    return paramSize.getHeight();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\SizeKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */