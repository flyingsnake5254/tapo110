package com.google.common.collect;

import com.google.common.base.n;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

public final class HashMultimap<K, V>
  extends x0<K, V>
{
  private static final int DEFAULT_VALUES_PER_KEY = 2;
  private static final long serialVersionUID = 0L;
  transient int expectedValuesPerKey = 2;
  
  private HashMultimap()
  {
    this(12, 2);
  }
  
  private HashMultimap(int paramInt1, int paramInt2)
  {
    super(c2.c(paramInt1));
    boolean bool;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    n.d(bool);
    this.expectedValuesPerKey = paramInt2;
  }
  
  private HashMultimap(r1<? extends K, ? extends V> paramr1)
  {
    super(c2.c(paramr1.keySet().size()));
    putAll(paramr1);
  }
  
  public static <K, V> HashMultimap<K, V> create()
  {
    return new HashMultimap();
  }
  
  public static <K, V> HashMultimap<K, V> create(int paramInt1, int paramInt2)
  {
    return new HashMultimap(paramInt1, paramInt2);
  }
  
  public static <K, V> HashMultimap<K, V> create(r1<? extends K, ? extends V> paramr1)
  {
    return new HashMultimap(paramr1);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.expectedValuesPerKey = 2;
    int i = r2.h(paramObjectInputStream);
    setMap(c2.c(12));
    r2.e(this, paramObjectInputStream, i);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    r2.j(this, paramObjectOutputStream);
  }
  
  Set<V> createCollection()
  {
    return c2.d(this.expectedValuesPerKey);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\HashMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */