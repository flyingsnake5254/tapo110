package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Objects;

public class ObjectUtils
{
  public static final Null a = new Null();
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 != null) && (paramObject2 != null)) {
      return paramObject1.equals(paramObject2);
    }
    return false;
  }
  
  public static int b(Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    return i;
  }
  
  public static void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    Objects.requireNonNull(paramObject, "Cannot get the toString of a null identity");
    paramStringBuffer.append(paramObject.getClass().getName());
    paramStringBuffer.append('@');
    paramStringBuffer.append(Integer.toHexString(System.identityHashCode(paramObject)));
  }
  
  public static boolean d(Object paramObject1, Object paramObject2)
  {
    return a(paramObject1, paramObject2) ^ true;
  }
  
  public static class Null
    implements Serializable
  {
    private static final long serialVersionUID = 7092611880189329093L;
    
    private Object readResolve()
    {
      return ObjectUtils.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\ObjectUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */