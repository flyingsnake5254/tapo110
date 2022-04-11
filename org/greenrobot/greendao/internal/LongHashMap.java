package org.greenrobot.greendao.internal;

import java.util.Arrays;
import org.greenrobot.greendao.DaoLog;

public final class LongHashMap<T>
{
  private int capacity;
  private int size;
  private Entry<T>[] table;
  private int threshold;
  
  public LongHashMap()
  {
    this(16);
  }
  
  public LongHashMap(int paramInt)
  {
    this.capacity = paramInt;
    this.threshold = (paramInt * 4 / 3);
    this.table = new Entry[paramInt];
  }
  
  public void clear()
  {
    this.size = 0;
    Arrays.fill(this.table, null);
  }
  
  public boolean containsKey(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    int k = this.capacity;
    for (Entry localEntry = this.table[(((j ^ i) & 0x7FFFFFFF) % k)]; localEntry != null; localEntry = localEntry.next) {
      if (localEntry.key == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public T get(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    int k = this.capacity;
    for (Entry localEntry = this.table[(((j ^ i) & 0x7FFFFFFF) % k)]; localEntry != null; localEntry = localEntry.next) {
      if (localEntry.key == paramLong) {
        return (T)localEntry.value;
      }
    }
    return null;
  }
  
  public void logStats()
  {
    Entry[] arrayOfEntry = this.table;
    int i = arrayOfEntry.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      localObject = arrayOfEntry[j];
      while (localObject != null)
      {
        localObject = ((Entry)localObject).next;
        if (localObject == null) {
          break;
        }
        k++;
      }
      j++;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load: ");
    ((StringBuilder)localObject).append(this.size / this.capacity);
    ((StringBuilder)localObject).append(", size: ");
    ((StringBuilder)localObject).append(this.size);
    ((StringBuilder)localObject).append(", capa: ");
    ((StringBuilder)localObject).append(this.capacity);
    ((StringBuilder)localObject).append(", collisions: ");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(", collision ratio: ");
    ((StringBuilder)localObject).append(k / this.size);
    DaoLog.d(((StringBuilder)localObject).toString());
  }
  
  public T put(long paramLong, T paramT)
  {
    int i = (int)(paramLong >>> 32);
    i = (((int)paramLong ^ i) & 0x7FFFFFFF) % this.capacity;
    Object localObject1 = this.table[i];
    for (Object localObject2 = localObject1; localObject2 != null; localObject2 = ((Entry)localObject2).next) {
      if (((Entry)localObject2).key == paramLong)
      {
        localObject1 = ((Entry)localObject2).value;
        ((Entry)localObject2).value = paramT;
        return (T)localObject1;
      }
    }
    this.table[i] = new Entry(paramLong, paramT, (Entry)localObject1);
    i = this.size + 1;
    this.size = i;
    if (i > this.threshold) {
      setCapacity(this.capacity * 2);
    }
    return null;
  }
  
  public T remove(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    i = (((int)paramLong ^ i) & 0x7FFFFFFF) % this.capacity;
    Object localObject1 = this.table[i];
    Object localObject2 = null;
    while (localObject1 != null)
    {
      Entry localEntry = ((Entry)localObject1).next;
      if (((Entry)localObject1).key == paramLong)
      {
        if (localObject2 == null) {
          this.table[i] = localEntry;
        } else {
          ((Entry)localObject2).next = localEntry;
        }
        this.size -= 1;
        return (T)((Entry)localObject1).value;
      }
      localObject2 = localObject1;
      localObject1 = localEntry;
    }
    return null;
  }
  
  public void reserveRoom(int paramInt)
  {
    setCapacity(paramInt * 5 / 3);
  }
  
  public void setCapacity(int paramInt)
  {
    Entry[] arrayOfEntry = new Entry[paramInt];
    int i = this.table.length;
    for (int j = 0; j < i; j++)
    {
      Entry localEntry;
      for (Object localObject = this.table[j]; localObject != null; localObject = localEntry)
      {
        long l = ((Entry)localObject).key;
        int k = (((int)(l >>> 32) ^ (int)l) & 0x7FFFFFFF) % paramInt;
        localEntry = ((Entry)localObject).next;
        ((Entry)localObject).next = arrayOfEntry[k];
        arrayOfEntry[k] = localObject;
      }
    }
    this.table = arrayOfEntry;
    this.capacity = paramInt;
    this.threshold = (paramInt * 4 / 3);
  }
  
  public int size()
  {
    return this.size;
  }
  
  static final class Entry<T>
  {
    final long key;
    Entry<T> next;
    T value;
    
    Entry(long paramLong, T paramT, Entry<T> paramEntry)
    {
      this.key = paramLong;
      this.value = paramT;
      this.next = paramEntry;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\internal\LongHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */