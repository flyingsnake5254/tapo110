package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ArrayListMultimap<K, V>
  extends r<K, V>
{
  private static final int DEFAULT_VALUES_PER_KEY = 3;
  private static final long serialVersionUID = 0L;
  transient int expectedValuesPerKey;
  
  private ArrayListMultimap()
  {
    this(12, 3);
  }
  
  private ArrayListMultimap(int paramInt1, int paramInt2)
  {
    super(c2.c(paramInt1));
    v.b(paramInt2, "expectedValuesPerKey");
    this.expectedValuesPerKey = paramInt2;
  }
  
  private ArrayListMultimap(r1<? extends K, ? extends V> paramr1)
  {
    this(i, j);
    putAll(paramr1);
  }
  
  public static <K, V> ArrayListMultimap<K, V> create()
  {
    return new ArrayListMultimap();
  }
  
  public static <K, V> ArrayListMultimap<K, V> create(int paramInt1, int paramInt2)
  {
    return new ArrayListMultimap(paramInt1, paramInt2);
  }
  
  public static <K, V> ArrayListMultimap<K, V> create(r1<? extends K, ? extends V> paramr1)
  {
    return new ArrayListMultimap(paramr1);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.expectedValuesPerKey = 3;
    int i = r2.h(paramObjectInputStream);
    setMap(x.h());
    r2.e(this, paramObjectInputStream, i);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    r2.j(this, paramObjectOutputStream);
  }
  
  List<V> createCollection()
  {
    return new ArrayList(this.expectedValuesPerKey);
  }
  
  @Deprecated
  public void trimToSize()
  {
    Iterator localIterator = backingMap().values().iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localIterator.next()).trimToSize();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\ArrayListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */