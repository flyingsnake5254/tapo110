package com.google.common.base;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class k
  extends g
{
  public static boolean a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static int b(@NullableDecl Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */