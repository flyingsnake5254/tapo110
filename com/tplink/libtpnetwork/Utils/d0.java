package com.tplink.libtpnetwork.Utils;

public class d0
{
  public static <T> boolean a(T paramT1, T paramT2)
  {
    if ((paramT1 == null) && (paramT2 == null)) {
      return true;
    }
    if ((paramT1 != null) && (paramT2 != null)) {
      return paramT1.equals(paramT2);
    }
    return false;
  }
  
  public static <T> T b(T paramT1, T paramT2)
  {
    if (paramT1 == null) {
      return paramT2;
    }
    return paramT1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */