package org.apache.commons.lang.enum;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang.d;
import org.apache.commons.lang.e;

public abstract class Enum
  implements Comparable, Serializable
{
  private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
  private static Map cEnumClasses = new WeakHashMap();
  private static final long serialVersionUID = -487045951170455942L;
  private final transient int iHashCode;
  private final String iName;
  protected transient String iToString = null;
  
  protected Enum(String paramString)
  {
    init(paramString);
    this.iName = paramString;
    this.iHashCode = (getEnumClass().hashCode() + 7 + paramString.hashCode() * 3);
  }
  
  private static a createEntry(Class paramClass)
  {
    a locala = new a();
    for (paramClass = paramClass.getSuperclass(); paramClass != null; paramClass = paramClass.getSuperclass())
    {
      Class localClass = class$org$apache$commons$lang$enum$Enum;
      Object localObject = localClass;
      if (localClass == null)
      {
        localObject = class$("org.apache.commons.lang.enum.Enum");
        class$org$apache$commons$lang$enum$Enum = (Class)localObject;
      }
      if (paramClass == localObject) {
        break;
      }
      localClass = class$org$apache$commons$lang$enum$ValuedEnum;
      localObject = localClass;
      if (localClass == null)
      {
        localObject = class$("org.apache.commons.lang.enum.ValuedEnum");
        class$org$apache$commons$lang$enum$ValuedEnum = (Class)localObject;
      }
      if (paramClass == localObject) {
        break;
      }
      localObject = (a)cEnumClasses.get(paramClass);
      if (localObject != null)
      {
        locala.c.addAll(((a)localObject).c);
        locala.a.putAll(((a)localObject).a);
        break;
      }
    }
    return locala;
  }
  
  private static a getEntry(Class paramClass)
  {
    Object localObject1;
    Object localObject2;
    if (paramClass != null)
    {
      localObject1 = class$org$apache$commons$lang$enum$Enum;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = class$("org.apache.commons.lang.enum.Enum");
        class$org$apache$commons$lang$enum$Enum = (Class)localObject2;
      }
      if (((Class)localObject2).isAssignableFrom(paramClass))
      {
        localObject1 = (a)cEnumClasses.get(paramClass);
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
    }
    try
    {
      Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
      localObject2 = (a)cEnumClasses.get(paramClass);
      return (a)localObject2;
      throw new IllegalArgumentException("The Class must be a subclass of Enum");
      throw new IllegalArgumentException("The Enum Class must not be null");
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
  }
  
  protected static Enum getEnum(Class paramClass, String paramString)
  {
    paramClass = getEntry(paramClass);
    if (paramClass == null) {
      return null;
    }
    return (Enum)paramClass.a.get(paramString);
  }
  
  protected static List getEnumList(Class paramClass)
  {
    paramClass = getEntry(paramClass);
    if (paramClass == null) {
      return Collections.EMPTY_LIST;
    }
    return paramClass.d;
  }
  
  protected static Map getEnumMap(Class paramClass)
  {
    paramClass = getEntry(paramClass);
    if (paramClass == null) {
      return EMPTY_MAP;
    }
    return paramClass.b;
  }
  
  private String getNameInOtherClassLoader(Object paramObject)
  {
    try
    {
      paramObject = (String)paramObject.getClass().getMethod("getName", null).invoke(paramObject, null);
      return (String)paramObject;
    }
    catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramObject)
    {
      throw new IllegalStateException("This should not happen");
    }
  }
  
  private void init(String paramString)
  {
    if (!e.a(paramString))
    {
      Class localClass = getEnumClass();
      if (localClass != null)
      {
        Object localObject1 = getClass();
        int i = 0;
        int j;
        Object localObject2;
        Object localObject3;
        for (;;)
        {
          j = i;
          if (localObject1 == null) {
            break;
          }
          localObject2 = class$org$apache$commons$lang$enum$Enum;
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = class$("org.apache.commons.lang.enum.Enum");
            class$org$apache$commons$lang$enum$Enum = (Class)localObject3;
          }
          j = i;
          if (localObject1 == localObject3) {
            break;
          }
          localObject2 = class$org$apache$commons$lang$enum$ValuedEnum;
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = class$("org.apache.commons.lang.enum.ValuedEnum");
            class$org$apache$commons$lang$enum$ValuedEnum = (Class)localObject3;
          }
          j = i;
          if (localObject1 == localObject3) {
            break;
          }
          if (localObject1 == localClass)
          {
            j = 1;
            break;
          }
          localObject1 = ((Class)localObject1).getSuperclass();
        }
        if (j != 0)
        {
          localObject3 = class$org$apache$commons$lang$enum$Enum;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = class$("org.apache.commons.lang.enum.Enum");
            class$org$apache$commons$lang$enum$Enum = (Class)localObject1;
          }
          try
          {
            localObject2 = (a)cEnumClasses.get(localClass);
            localObject3 = localObject2;
            if (localObject2 == null)
            {
              localObject3 = createEntry(localClass);
              localObject2 = new java/util/WeakHashMap;
              ((WeakHashMap)localObject2).<init>();
              ((Map)localObject2).putAll(cEnumClasses);
              ((Map)localObject2).put(localClass, localObject3);
              cEnumClasses = (Map)localObject2;
            }
            if (!((a)localObject3).a.containsKey(paramString))
            {
              ((a)localObject3).a.put(paramString, this);
              ((a)localObject3).c.add(this);
              return;
            }
            localObject1 = new StringBuffer();
            ((StringBuffer)localObject1).append("The Enum name must be unique, '");
            ((StringBuffer)localObject1).append(paramString);
            ((StringBuffer)localObject1).append("' has already been added");
            throw new IllegalArgumentException(((StringBuffer)localObject1).toString());
          }
          finally {}
        }
        throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
      }
      throw new IllegalArgumentException("getEnumClass() must not be null");
    }
    throw new IllegalArgumentException("The Enum name must not be empty or null");
  }
  
  protected static Iterator iterator(Class paramClass)
  {
    return getEnumList(paramClass).iterator();
  }
  
  public int compareTo(Object paramObject)
  {
    if (paramObject == this) {
      return 0;
    }
    if (paramObject.getClass() != getClass())
    {
      if (paramObject.getClass().getName().equals(getClass().getName())) {
        return this.iName.compareTo(getNameInOtherClassLoader(paramObject));
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Different enum class '");
      localStringBuffer.append(d.c(paramObject.getClass()));
      localStringBuffer.append("'");
      throw new ClassCastException(localStringBuffer.toString());
    }
    return this.iName.compareTo(((Enum)paramObject).iName);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (paramObject.getClass() == getClass()) {
      return this.iName.equals(((Enum)paramObject).iName);
    }
    if (!paramObject.getClass().getName().equals(getClass().getName())) {
      return false;
    }
    return this.iName.equals(getNameInOtherClassLoader(paramObject));
  }
  
  public Class getEnumClass()
  {
    return getClass();
  }
  
  public final String getName()
  {
    return this.iName;
  }
  
  public final int hashCode()
  {
    return this.iHashCode;
  }
  
  protected Object readResolve()
  {
    a locala = (a)cEnumClasses.get(getEnumClass());
    if (locala == null) {
      return null;
    }
    return locala.a.get(getName());
  }
  
  public String toString()
  {
    if (this.iToString == null)
    {
      String str = d.c(getEnumClass());
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str);
      localStringBuffer.append("[");
      localStringBuffer.append(getName());
      localStringBuffer.append("]");
      this.iToString = localStringBuffer.toString();
    }
    return this.iToString;
  }
  
  private static class a
  {
    final Map a;
    final Map b;
    final List c;
    final List d;
    
    protected a()
    {
      Object localObject = new HashMap();
      this.a = ((Map)localObject);
      this.b = Collections.unmodifiableMap((Map)localObject);
      localObject = new ArrayList(25);
      this.c = ((List)localObject);
      this.d = Collections.unmodifiableList((List)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\enum\Enum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */