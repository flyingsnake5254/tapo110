package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class j
{
  static void a(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (!Modifier.isInterface(i))
    {
      if (!Modifier.isAbstract(i)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Abstract class can't be instantiated! Class name: ");
      localStringBuilder.append(paramClass.getName());
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Interface can't be instantiated! Interface name: ");
    localStringBuilder.append(paramClass.getName());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public static j b()
  {
    try
    {
      Object localObject1 = Class.forName("sun.misc.Unsafe");
      final Object localObject4 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject4).setAccessible(true);
      localObject4 = ((Field)localObject4).get(null);
      localObject1 = new a(((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class }), localObject4);
      return (j)localObject1;
    }
    catch (Exception localException1)
    {
      try
      {
        Object localObject2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
        ((Method)localObject2).setAccessible(true);
        final int i = ((Integer)((Method)localObject2).invoke(null, new Object[] { Object.class })).intValue();
        localObject2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
        ((Method)localObject2).setAccessible(true);
        localObject2 = new b((Method)localObject2, i);
        return (j)localObject2;
      }
      catch (Exception localException2)
      {
        try
        {
          Object localObject3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
          ((Method)localObject3).setAccessible(true);
          localObject3 = new c((Method)localObject3);
          return (j)localObject3;
        }
        catch (Exception localException3) {}
      }
    }
    return new d();
  }
  
  public abstract <T> T c(Class<T> paramClass)
    throws Exception;
  
  class a
    extends j
  {
    a(Object paramObject) {}
    
    public <T> T c(Class<T> paramClass)
      throws Exception
    {
      j.a(paramClass);
      return (T)j.this.invoke(localObject4, new Object[] { paramClass });
    }
  }
  
  class b
    extends j
  {
    b(int paramInt) {}
    
    public <T> T c(Class<T> paramClass)
      throws Exception
    {
      j.a(paramClass);
      return (T)j.this.invoke(null, new Object[] { paramClass, Integer.valueOf(i) });
    }
  }
  
  class c
    extends j
  {
    c() {}
    
    public <T> T c(Class<T> paramClass)
      throws Exception
    {
      j.a(paramClass);
      return (T)j.this.invoke(null, new Object[] { paramClass, Object.class });
    }
  }
  
  class d
    extends j
  {
    public <T> T c(Class<T> paramClass)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot allocate ");
      localStringBuilder.append(paramClass);
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */