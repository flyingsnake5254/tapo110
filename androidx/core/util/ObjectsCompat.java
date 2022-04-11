package androidx.core.util;

import android.os.Build.VERSION;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;

public class ObjectsCompat
{
  public static boolean equals(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Objects.equals(paramObject1, paramObject2);
    }
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static int hash(@Nullable Object... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Objects.hash(paramVarArgs);
    }
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static int hashCode(@Nullable Object paramObject)
  {
    int i;
    if (paramObject != null) {
      i = paramObject.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\ObjectsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */