package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;

public final class HalfKt
{
  @RequiresApi(26)
  public static final Half toHalf(double paramDouble)
  {
    Half localHalf = Half.valueOf((float)paramDouble);
    j.b(localHalf, "Half.valueOf(this)");
    return localHalf;
  }
  
  @RequiresApi(26)
  public static final Half toHalf(float paramFloat)
  {
    Half localHalf = Half.valueOf(paramFloat);
    j.b(localHalf, "Half.valueOf(this)");
    return localHalf;
  }
  
  @RequiresApi(26)
  public static final Half toHalf(String paramString)
  {
    j.f(paramString, "$this$toHalf");
    paramString = Half.valueOf(paramString);
    j.b(paramString, "Half.valueOf(this)");
    return paramString;
  }
  
  @RequiresApi(26)
  public static final Half toHalf(short paramShort)
  {
    Half localHalf = Half.valueOf(paramShort);
    j.b(localHalf, "Half.valueOf(this)");
    return localHalf;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\HalfKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */