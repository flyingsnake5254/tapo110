package androidx.navigation;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import kotlin.reflect.c;

public final class NavArgsLazyKt
{
  private static final ArrayMap<c<? extends NavArgs>, Method> methodMap = new ArrayMap();
  private static final Class<Bundle>[] methodSignature = { Bundle.class };
  
  public static final ArrayMap<c<? extends NavArgs>, Method> getMethodMap()
  {
    return methodMap;
  }
  
  public static final Class<Bundle>[] getMethodSignature()
  {
    return methodSignature;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavArgsLazyKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */