package kotlin.jvm;

import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

public final class a
{
  public static final <T> Class<T> a(kotlin.reflect.c<T> paramc)
  {
    j.e(paramc, "$this$java");
    paramc = ((kotlin.jvm.internal.c)paramc).a();
    Objects.requireNonNull(paramc, "null cannot be cast to non-null type java.lang.Class<T>");
    return paramc;
  }
  
  public static final <T> Class<T> b(kotlin.reflect.c<T> paramc)
  {
    j.e(paramc, "$this$javaObjectType");
    paramc = ((kotlin.jvm.internal.c)paramc).a();
    if (!paramc.isPrimitive()) {
      return paramc;
    }
    String str = paramc.getName();
    switch (str.hashCode())
    {
    default: 
      break;
    case 109413500: 
      if (str.equals("short")) {
        paramc = Short.class;
      }
      break;
    case 97526364: 
      if (str.equals("float")) {
        paramc = Float.class;
      }
      break;
    case 64711720: 
      if (str.equals("boolean")) {
        paramc = Boolean.class;
      }
      break;
    case 3625364: 
      if (str.equals("void")) {
        paramc = Void.class;
      }
      break;
    case 3327612: 
      if (str.equals("long")) {
        paramc = Long.class;
      }
      break;
    case 3052374: 
      if (str.equals("char")) {
        paramc = Character.class;
      }
      break;
    case 3039496: 
      if (str.equals("byte")) {
        paramc = Byte.class;
      }
      break;
    case 104431: 
      if (str.equals("int")) {
        paramc = Integer.class;
      }
      break;
    case -1325958191: 
      if (str.equals("double")) {
        paramc = Double.class;
      }
      break;
    }
    return paramc;
  }
  
  public static final <T> kotlin.reflect.c<T> c(Class<T> paramClass)
  {
    j.e(paramClass, "$this$kotlin");
    return m.b(paramClass);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */