package org.apache.commons.lang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.text.b;

public class d
{
  public static final String a = String.valueOf('.');
  public static final String b = String.valueOf('$');
  private static final Map c;
  private static final Map d;
  private static final Map e;
  private static final Map f;
  
  static
  {
    Object localObject1 = new HashMap();
    c = (Map)localObject1;
    Class localClass = Boolean.TYPE;
    Object localObject2 = g;
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = b("java.lang.Boolean");
      g = (Class)localObject3;
    }
    ((Map)localObject1).put(localClass, localObject3);
    localClass = Byte.TYPE;
    localObject2 = h;
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = b("java.lang.Byte");
      h = (Class)localObject3;
    }
    ((Map)localObject1).put(localClass, localObject3);
    localClass = Character.TYPE;
    localObject2 = i;
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = b("java.lang.Character");
      i = (Class)localObject3;
    }
    ((Map)localObject1).put(localClass, localObject3);
    localClass = Short.TYPE;
    localObject2 = j;
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = b("java.lang.Short");
      j = (Class)localObject3;
    }
    ((Map)localObject1).put(localClass, localObject3);
    localClass = Integer.TYPE;
    localObject2 = k;
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = b("java.lang.Integer");
      k = (Class)localObject3;
    }
    ((Map)localObject1).put(localClass, localObject3);
    localClass = Long.TYPE;
    localObject2 = l;
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = b("java.lang.Long");
      l = (Class)localObject3;
    }
    ((Map)localObject1).put(localClass, localObject3);
    localClass = Double.TYPE;
    localObject2 = m;
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = b("java.lang.Double");
      m = (Class)localObject3;
    }
    ((Map)localObject1).put(localClass, localObject3);
    localClass = Float.TYPE;
    localObject2 = n;
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = b("java.lang.Float");
      n = (Class)localObject3;
    }
    ((Map)localObject1).put(localClass, localObject3);
    localObject3 = Void.TYPE;
    ((Map)localObject1).put(localObject3, localObject3);
    d = new HashMap();
    localObject2 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Class)((Iterator)localObject2).next();
      localObject1 = (Class)c.get(localObject3);
      if (!localObject3.equals(localObject1)) {
        d.put(localObject1, localObject3);
      }
    }
    e = new HashMap();
    f = new HashMap();
    a("int", "I");
    a("boolean", "Z");
    a("float", "F");
    a("long", "J");
    a("short", "S");
    a("byte", "B");
    a("double", "D");
    a("char", "C");
  }
  
  private static void a(String paramString1, String paramString2)
  {
    e.put(paramString1, paramString2);
    f.put(paramString2, paramString1);
  }
  
  public static String c(Class paramClass)
  {
    if (paramClass == null) {
      return "";
    }
    return d(paramClass.getName());
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    b localb = new b();
    boolean bool = paramString.startsWith("[");
    int i1 = 0;
    Object localObject = paramString;
    if (bool)
    {
      while (paramString.charAt(0) == '[')
      {
        paramString = paramString.substring(1);
        localb.f("[]");
      }
      localObject = paramString;
      if (paramString.charAt(0) == 'L')
      {
        localObject = paramString;
        if (paramString.charAt(paramString.length() - 1) == ';') {
          localObject = paramString.substring(1, paramString.length() - 1);
        }
      }
    }
    Map localMap = f;
    paramString = (String)localObject;
    if (localMap.containsKey(localObject)) {
      paramString = (String)localMap.get(localObject);
    }
    int i2 = paramString.lastIndexOf('.');
    if (i2 != -1) {
      i1 = i2 + 1;
    }
    i1 = paramString.indexOf('$', i1);
    localObject = paramString.substring(i2 + 1);
    paramString = (String)localObject;
    if (i1 != -1) {
      paramString = ((String)localObject).replace('$', '.');
    }
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(paramString);
    ((StringBuffer)localObject).append(localb);
    return ((StringBuffer)localObject).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */