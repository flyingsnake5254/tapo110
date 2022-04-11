package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.jvm.b.b;
import kotlin.jvm.b.e;
import kotlin.jvm.b.f;
import kotlin.jvm.b.g;
import kotlin.jvm.b.h;
import kotlin.jvm.b.i;
import kotlin.jvm.b.k;
import kotlin.jvm.b.o;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.b.r;
import kotlin.jvm.b.s;
import kotlin.jvm.b.t;
import kotlin.jvm.b.u;
import kotlin.jvm.b.v;
import kotlin.jvm.b.w;

public final class d
  implements kotlin.reflect.c<Object>, c
{
  private static final Map<Class<? extends kotlin.c<?>>, Integer> c;
  private static final HashMap<String, String> d;
  private static final HashMap<String, String> f;
  private static final HashMap<String, String> q;
  private static final Map<String, String> x;
  public static final a y = new a(null);
  private final Class<?> z;
  
  static
  {
    int i = 0;
    Object localObject1 = kotlin.collections.l.g(new Class[] { kotlin.jvm.b.a.class, kotlin.jvm.b.l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, b.class, kotlin.jvm.b.c.class, kotlin.jvm.b.d.class, e.class, f.class, g.class, h.class, i.class, kotlin.jvm.b.j.class, k.class, kotlin.jvm.b.m.class, kotlin.jvm.b.n.class, o.class });
    Object localObject2 = new ArrayList(kotlin.collections.l.l((Iterable)localObject1, 10));
    Object localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        kotlin.collections.l.k();
      }
      ((Collection)localObject2).add(kotlin.n.a((Class)localObject1, Integer.valueOf(i)));
      i++;
    }
    c = b0.k((Iterable)localObject2);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("char", "kotlin.Char");
    ((HashMap)localObject1).put("byte", "kotlin.Byte");
    ((HashMap)localObject1).put("short", "kotlin.Short");
    ((HashMap)localObject1).put("int", "kotlin.Int");
    ((HashMap)localObject1).put("float", "kotlin.Float");
    ((HashMap)localObject1).put("long", "kotlin.Long");
    ((HashMap)localObject1).put("double", "kotlin.Double");
    d = (HashMap)localObject1;
    localObject3 = new HashMap();
    ((HashMap)localObject3).put("java.lang.Boolean", "kotlin.Boolean");
    ((HashMap)localObject3).put("java.lang.Character", "kotlin.Char");
    ((HashMap)localObject3).put("java.lang.Byte", "kotlin.Byte");
    ((HashMap)localObject3).put("java.lang.Short", "kotlin.Short");
    ((HashMap)localObject3).put("java.lang.Integer", "kotlin.Int");
    ((HashMap)localObject3).put("java.lang.Float", "kotlin.Float");
    ((HashMap)localObject3).put("java.lang.Long", "kotlin.Long");
    ((HashMap)localObject3).put("java.lang.Double", "kotlin.Double");
    f = (HashMap)localObject3;
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("java.lang.Object", "kotlin.Any");
    ((HashMap)localObject2).put("java.lang.String", "kotlin.String");
    ((HashMap)localObject2).put("java.lang.CharSequence", "kotlin.CharSequence");
    ((HashMap)localObject2).put("java.lang.Throwable", "kotlin.Throwable");
    ((HashMap)localObject2).put("java.lang.Cloneable", "kotlin.Cloneable");
    ((HashMap)localObject2).put("java.lang.Number", "kotlin.Number");
    ((HashMap)localObject2).put("java.lang.Comparable", "kotlin.Comparable");
    ((HashMap)localObject2).put("java.lang.Enum", "kotlin.Enum");
    ((HashMap)localObject2).put("java.lang.annotation.Annotation", "kotlin.Annotation");
    ((HashMap)localObject2).put("java.lang.Iterable", "kotlin.collections.Iterable");
    ((HashMap)localObject2).put("java.util.Iterator", "kotlin.collections.Iterator");
    ((HashMap)localObject2).put("java.util.Collection", "kotlin.collections.Collection");
    ((HashMap)localObject2).put("java.util.List", "kotlin.collections.List");
    ((HashMap)localObject2).put("java.util.Set", "kotlin.collections.Set");
    ((HashMap)localObject2).put("java.util.ListIterator", "kotlin.collections.ListIterator");
    ((HashMap)localObject2).put("java.util.Map", "kotlin.collections.Map");
    ((HashMap)localObject2).put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
    ((HashMap)localObject2).put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
    ((HashMap)localObject2).put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
    ((HashMap)localObject2).putAll((Map)localObject1);
    ((HashMap)localObject2).putAll((Map)localObject3);
    localObject1 = ((HashMap)localObject1).values();
    j.d(localObject1, "primitiveFqNames.values");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject4;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("kotlin.jvm.internal.");
      j.d(localObject3, "kotlinName");
      ((StringBuilder)localObject4).append(kotlin.text.m.o0((String)localObject3, '.', null, 2, null));
      ((StringBuilder)localObject4).append("CompanionObject");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(".Companion");
      localObject3 = kotlin.n.a(localObject4, localStringBuilder.toString());
      ((Map)localObject2).put(((Pair)localObject3).getFirst(), ((Pair)localObject3).getSecond());
    }
    localObject1 = c.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Class)((Map.Entry)localObject4).getKey();
      i = ((Number)((Map.Entry)localObject4).getValue()).intValue();
      localObject4 = ((Class)localObject3).getName();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("kotlin.Function");
      ((StringBuilder)localObject3).append(i);
      ((HashMap)localObject2).put(localObject4, ((StringBuilder)localObject3).toString());
    }
    q = (HashMap)localObject2;
    localObject1 = new LinkedHashMap(b0.a(((Map)localObject2).size()));
    localObject3 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
      ((Map)localObject1).put(((Map.Entry)localObject2).getKey(), kotlin.text.m.o0((String)((Map.Entry)localObject2).getValue(), '.', null, 2, null));
    }
    x = (Map)localObject1;
  }
  
  public d(Class<?> paramClass)
  {
    this.z = paramClass;
  }
  
  public Class<?> a()
  {
    return this.z;
  }
  
  public String b()
  {
    return y.a(a());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof d)) && (j.a(kotlin.jvm.a.b(this), kotlin.jvm.a.b((kotlin.reflect.c)paramObject)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return kotlin.jvm.a.b(this).hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a().toString());
    localStringBuilder.append(" (Kotlin reflection is not available)");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final String a(Class<?> paramClass)
    {
      j.e(paramClass, "jClass");
      boolean bool = paramClass.isAnonymousClass();
      String str = "Array";
      StringBuilder localStringBuilder = null;
      Object localObject = null;
      if (bool) {}
      for (;;)
      {
        return (Class<?>)localObject;
        if (paramClass.isLocalClass())
        {
          str = paramClass.getSimpleName();
          localObject = paramClass.getEnclosingMethod();
          if (localObject != null)
          {
            j.d(str, "name");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(((Method)localObject).getName());
            localStringBuilder.append("$");
            localObject = kotlin.text.m.m0(str, localStringBuilder.toString(), null, 2, null);
            if (localObject != null)
            {
              paramClass = (Class<?>)localObject;
              break label172;
            }
          }
          paramClass = paramClass.getEnclosingConstructor();
          if (paramClass != null)
          {
            j.d(str, "name");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramClass.getName());
            ((StringBuilder)localObject).append("$");
            paramClass = kotlin.text.m.m0(str, ((StringBuilder)localObject).toString(), null, 2, null);
          }
          else
          {
            paramClass = null;
          }
          label172:
          if (paramClass != null) {
            return paramClass;
          }
          j.d(str, "name");
          return kotlin.text.m.l0(str, '$', null, 2, null);
        }
        if (!paramClass.isArray()) {
          break;
        }
        paramClass = paramClass.getComponentType();
        j.d(paramClass, "componentType");
        localObject = localStringBuilder;
        if (paramClass.isPrimitive())
        {
          paramClass = (String)d.c().get(paramClass.getName());
          localObject = localStringBuilder;
          if (paramClass != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramClass);
            ((StringBuilder)localObject).append("Array");
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        paramClass = str;
        if (localObject == null) {
          return paramClass;
        }
      }
      localObject = (String)d.c().get(paramClass.getName());
      if (localObject != null) {
        paramClass = (Class<?>)localObject;
      } else {
        paramClass = paramClass.getSimpleName();
      }
      return paramClass;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */