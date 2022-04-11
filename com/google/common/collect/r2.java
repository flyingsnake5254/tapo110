package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class r2
{
  static <T> b<T> a(Class<T> paramClass, String paramString)
  {
    try
    {
      paramClass = new b(paramClass.getDeclaredField(paramString), null);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new AssertionError(paramClass);
    }
  }
  
  static <K, V> void b(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    c(paramMap, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <K, V> void c(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    for (int i = 0; i < paramInt; i++) {
      paramMap.put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
    }
  }
  
  static <K, V> void d(r1<K, V> paramr1, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    e(paramr1, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <K, V> void e(r1<K, V> paramr1, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    for (int i = 0; i < paramInt; i++)
    {
      Collection localCollection = paramr1.get(paramObjectInputStream.readObject());
      int j = paramObjectInputStream.readInt();
      for (int k = 0; k < j; k++) {
        localCollection.add(paramObjectInputStream.readObject());
      }
    }
  }
  
  static <E> void f(u1<E> paramu1, ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    g(paramu1, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <E> void g(u1<E> paramu1, ObjectInputStream paramObjectInputStream, int paramInt)
    throws IOException, ClassNotFoundException
  {
    for (int i = 0; i < paramInt; i++) {
      paramu1.add(paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
    }
  }
  
  static int h(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    return paramObjectInputStream.readInt();
  }
  
  static <K, V> void i(Map<K, V> paramMap, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  static <K, V> void j(r1<K, V> paramr1, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramr1.asMap().size());
    paramr1 = paramr1.asMap().entrySet().iterator();
    while (paramr1.hasNext())
    {
      Object localObject = (Map.Entry)paramr1.next();
      paramObjectOutputStream.writeObject(((Map.Entry)localObject).getKey());
      paramObjectOutputStream.writeInt(((Collection)((Map.Entry)localObject).getValue()).size());
      localObject = ((Collection)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramObjectOutputStream.writeObject(((Iterator)localObject).next());
      }
    }
  }
  
  static <E> void k(u1<E> paramu1, ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(paramu1.entrySet().size());
    paramu1 = paramu1.entrySet().iterator();
    while (paramu1.hasNext())
    {
      u1.a locala = (u1.a)paramu1.next();
      paramObjectOutputStream.writeObject(locala.a());
      paramObjectOutputStream.writeInt(locala.getCount());
    }
  }
  
  static final class b<T>
  {
    private final Field a;
    
    private b(Field paramField)
    {
      this.a = paramField;
      paramField.setAccessible(true);
    }
    
    void a(T paramT, int paramInt)
    {
      try
      {
        this.a.set(paramT, Integer.valueOf(paramInt));
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError(paramT);
      }
    }
    
    void b(T paramT, Object paramObject)
    {
      try
      {
        this.a.set(paramT, paramObject);
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError(paramT);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\r2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */