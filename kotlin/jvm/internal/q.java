package kotlin.jvm.internal;

import java.util.Map;
import kotlin.jvm.b.b;
import kotlin.jvm.b.d;
import kotlin.jvm.b.e;
import kotlin.jvm.b.f;
import kotlin.jvm.b.g;
import kotlin.jvm.b.i;
import kotlin.jvm.b.k;
import kotlin.jvm.b.l;
import kotlin.jvm.b.m;
import kotlin.jvm.b.n;
import kotlin.jvm.b.o;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.b.s;
import kotlin.jvm.b.t;
import kotlin.jvm.b.u;
import kotlin.jvm.b.v;
import kotlin.jvm.b.w;

public class q
{
  public static Map a(Object paramObject)
  {
    if ((paramObject instanceof kotlin.jvm.internal.r.a)) {
      h(paramObject, "kotlin.collections.MutableMap");
    }
    return c(paramObject);
  }
  
  public static Object b(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && (!e(paramObject, paramInt)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kotlin.jvm.functions.Function");
      localStringBuilder.append(paramInt);
      h(paramObject, localStringBuilder.toString());
    }
    return paramObject;
  }
  
  public static Map c(Object paramObject)
  {
    try
    {
      paramObject = (Map)paramObject;
      return (Map)paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw g((ClassCastException)paramObject);
    }
  }
  
  public static int d(Object paramObject)
  {
    if ((paramObject instanceof h)) {
      return ((h)paramObject).getArity();
    }
    if ((paramObject instanceof kotlin.jvm.b.a)) {
      return 0;
    }
    if ((paramObject instanceof l)) {
      return 1;
    }
    if ((paramObject instanceof p)) {
      return 2;
    }
    if ((paramObject instanceof kotlin.jvm.b.q)) {
      return 3;
    }
    if ((paramObject instanceof r)) {
      return 4;
    }
    if ((paramObject instanceof s)) {
      return 5;
    }
    if ((paramObject instanceof t)) {
      return 6;
    }
    if ((paramObject instanceof u)) {
      return 7;
    }
    if ((paramObject instanceof v)) {
      return 8;
    }
    if ((paramObject instanceof w)) {
      return 9;
    }
    if ((paramObject instanceof b)) {
      return 10;
    }
    if ((paramObject instanceof kotlin.jvm.b.c)) {
      return 11;
    }
    if ((paramObject instanceof d)) {
      return 12;
    }
    if ((paramObject instanceof e)) {
      return 13;
    }
    if ((paramObject instanceof f)) {
      return 14;
    }
    if ((paramObject instanceof g)) {
      return 15;
    }
    if ((paramObject instanceof kotlin.jvm.b.h)) {
      return 16;
    }
    if ((paramObject instanceof i)) {
      return 17;
    }
    if ((paramObject instanceof kotlin.jvm.b.j)) {
      return 18;
    }
    if ((paramObject instanceof k)) {
      return 19;
    }
    if ((paramObject instanceof m)) {
      return 20;
    }
    if ((paramObject instanceof n)) {
      return 21;
    }
    if ((paramObject instanceof o)) {
      return 22;
    }
    return -1;
  }
  
  public static boolean e(Object paramObject, int paramInt)
  {
    boolean bool;
    if (((paramObject instanceof kotlin.c)) && (d(paramObject) == paramInt)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static <T extends Throwable> T f(T paramT)
  {
    return j.l(paramT, q.class.getName());
  }
  
  public static ClassCastException g(ClassCastException paramClassCastException)
  {
    throw ((ClassCastException)f(paramClassCastException));
  }
  
  public static void h(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      paramObject = "null";
    } else {
      paramObject = paramObject.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)paramObject);
    localStringBuilder.append(" cannot be cast to ");
    localStringBuilder.append(paramString);
    i(localStringBuilder.toString());
  }
  
  public static void i(String paramString)
  {
    throw g(new ClassCastException(paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */