package com.tplink.libtpanalytics.utils;

public class f
{
  public static boolean a = false;
  
  public static boolean a()
  {
    boolean bool1 = a;
    boolean bool2 = true;
    boolean bool3 = bool2;
    if (bool1)
    {
      Object localObject = Runtime.getRuntime();
      long l1 = ((Runtime)localObject).maxMemory();
      long l2 = ((Runtime)localObject).totalMemory();
      long l3 = ((Runtime)localObject).freeMemory();
      float f = (float)l2 / (float)l1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("maxMemory:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" totalMemory:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(" usedMemory:");
      ((StringBuilder)localObject).append(l2 - l3);
      ((StringBuilder)localObject).append(" proportion:");
      ((StringBuilder)localObject).append(f);
      i.a(((StringBuilder)localObject).toString());
      if (f < 0.8D) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
    }
    return bool3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */