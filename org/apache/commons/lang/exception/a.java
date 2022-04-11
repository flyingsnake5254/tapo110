package org.apache.commons.lang.exception;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang.f;

public class a
{
  private static final Object a = new Object();
  private static String[] b = { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
  private static final Method c;
  private static final Method d;
  
  static
  {
    localObject1 = null;
    Object localObject2;
    Object localObject4;
    try
    {
      localObject2 = e;
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = a("java.lang.Throwable");
        e = (Class)localObject3;
      }
      localObject3 = ((Class)localObject3).getMethod("getCause", null);
    }
    catch (Exception localException1)
    {
      localObject4 = null;
    }
    c = (Method)localObject4;
    try
    {
      localObject2 = e;
      localObject4 = localObject2;
      if (localObject2 == null)
      {
        localObject4 = a("java.lang.Throwable");
        e = (Class)localObject4;
      }
      Class localClass = e;
      localObject2 = localClass;
      if (localClass == null)
      {
        localObject2 = a("java.lang.Throwable");
        e = (Class)localObject2;
      }
      localObject4 = ((Class)localObject4).getMethod("initCause", new Class[] { localObject2 });
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject5 = localObject1;
      }
    }
    d = (Method)localObject4;
  }
  
  public static Throwable b(Throwable paramThrowable)
  {
    synchronized (a)
    {
      paramThrowable = c(paramThrowable, b);
      return paramThrowable;
    }
  }
  
  public static Throwable c(Throwable paramThrowable, String[] arg1)
  {
    if (paramThrowable == null) {
      return null;
    }
    Throwable localThrowable = f(paramThrowable);
    Object localObject = localThrowable;
    if (localThrowable == null)
    {
      String[] arrayOfString = ???;
      if (??? == null) {
        synchronized (a)
        {
          arrayOfString = b;
        }
      }
      int i = 0;
      localObject = localThrowable;
      for (;;)
      {
        ??? = (String[])localObject;
        if (i >= arrayOfString.length) {
          break;
        }
        ??? = arrayOfString[i];
        if (??? != null)
        {
          ??? = e(paramThrowable, ???);
          localObject = ???;
          if (??? != null) {
            break;
          }
        }
        i++;
      }
      localObject = ???;
      if (??? == null) {
        localObject = d(paramThrowable, "detail");
      }
    }
    return (Throwable)localObject;
  }
  
  private static Throwable d(Throwable paramThrowable, String paramString)
  {
    try
    {
      paramString = paramThrowable.getClass().getField(paramString);
    }
    catch (NoSuchFieldException|SecurityException paramString)
    {
      paramString = null;
    }
    if (paramString != null)
    {
      Class localClass1 = e;
      Class localClass2 = localClass1;
      if (localClass1 == null)
      {
        localClass2 = a("java.lang.Throwable");
        e = localClass2;
      }
      if (!localClass2.isAssignableFrom(paramString.getType())) {}
    }
    try
    {
      paramThrowable = (Throwable)paramString.get(paramThrowable);
      return paramThrowable;
    }
    catch (IllegalAccessException|IllegalArgumentException paramThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Throwable e(Throwable paramThrowable, String paramString)
  {
    try
    {
      paramString = paramThrowable.getClass().getMethod(paramString, null);
    }
    catch (NoSuchMethodException|SecurityException paramString)
    {
      paramString = null;
    }
    if (paramString != null)
    {
      Class localClass1 = e;
      Class localClass2 = localClass1;
      if (localClass1 == null)
      {
        localClass2 = a("java.lang.Throwable");
        e = localClass2;
      }
      if (!localClass2.isAssignableFrom(paramString.getReturnType())) {}
    }
    try
    {
      paramThrowable = (Throwable)paramString.invoke(paramThrowable, org.apache.commons.lang.a.a);
      return paramThrowable;
    }
    catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException paramThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Throwable f(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof b)) {
      return ((b)paramThrowable).getCause();
    }
    if ((paramThrowable instanceof SQLException)) {
      return ((SQLException)paramThrowable).getNextException();
    }
    if ((paramThrowable instanceof InvocationTargetException)) {
      return ((InvocationTargetException)paramThrowable).getTargetException();
    }
    return null;
  }
  
  static String[] g(String paramString)
  {
    paramString = new StringTokenizer(paramString, f.F);
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    return m(localArrayList);
  }
  
  public static int h(Throwable paramThrowable)
  {
    return i(paramThrowable).size();
  }
  
  public static List i(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    while ((paramThrowable != null) && (!localArrayList.contains(paramThrowable)))
    {
      localArrayList.add(paramThrowable);
      paramThrowable = b(paramThrowable);
    }
    return localArrayList;
  }
  
  public static Throwable[] j(Throwable paramThrowable)
  {
    paramThrowable = i(paramThrowable);
    return (Throwable[])paramThrowable.toArray(new Throwable[paramThrowable.size()]);
  }
  
  public static boolean k()
  {
    boolean bool;
    if (c != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void l(List paramList1, List paramList2)
  {
    if ((paramList1 != null) && (paramList2 != null))
    {
      int i = paramList1.size() - 1;
      for (int j = paramList2.size() - 1; (i >= 0) && (j >= 0); j--)
      {
        if (((String)paramList1.get(i)).equals((String)paramList2.get(j))) {
          paramList1.remove(i);
        }
        i--;
      }
      return;
    }
    throw new IllegalArgumentException("The List must not be null");
  }
  
  private static String[] m(List paramList)
  {
    return (String[])paramList.toArray(new String[paramList.size()]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\exception\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */