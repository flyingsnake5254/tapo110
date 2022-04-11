package com.tplink.libtpnetwork.Utils;

import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.jvm.internal.j;
import kotlin.n;

public final class q
{
  private static final Map<String, ComponentType> a = b0.f(new Pair[] { n.a("Babycry", ComponentType.BABY_CRYING_DETECTION), n.a("PersonDetected", ComponentType.PERSON_DETECTION) });
  
  public static final boolean a(String paramString1, String paramString2)
  {
    j.e(paramString1, "triggerId");
    j.e(paramString2, "deviceIdMD5");
    boolean bool1 = d.d(paramString2);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramString1 = b(paramString1);
    bool1 = bool2;
    if (paramString1 != null) {
      if (!d.a(paramString1, paramString2))
      {
        bool1 = bool2;
        if (!d.e(paramString2)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final ComponentType b(String paramString)
  {
    j.e(paramString, "triggerId");
    return (ComponentType)a.get(paramString);
  }
  
  public static final boolean c(String paramString)
  {
    j.e(paramString, "triggerId");
    return a.containsKey(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */