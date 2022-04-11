package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.internal.LongHashMap;

public class IdentityScopeLong<T>
  implements IdentityScope<Long, T>
{
  private final ReentrantLock lock = new ReentrantLock();
  private final LongHashMap<Reference<T>> map = new LongHashMap();
  
  public void clear()
  {
    this.lock.lock();
    try
    {
      this.map.clear();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  /* Error */
  public boolean detach(Long paramLong, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	org/greenrobot/greendao/identityscope/IdentityScopeLong:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 30	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 41	org/greenrobot/greendao/identityscope/IdentityScopeLong:get	(Ljava/lang/Long;)Ljava/lang/Object;
    //   12: aload_2
    //   13: if_acmpne +23 -> 36
    //   16: aload_2
    //   17: ifnull +19 -> 36
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 45	org/greenrobot/greendao/identityscope/IdentityScopeLong:remove	(Ljava/lang/Long;)V
    //   25: iconst_1
    //   26: istore_3
    //   27: aload_0
    //   28: getfield 26	org/greenrobot/greendao/identityscope/IdentityScopeLong:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   31: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   34: iload_3
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_3
    //   38: goto -11 -> 27
    //   41: astore_1
    //   42: aload_0
    //   43: getfield 26	org/greenrobot/greendao/identityscope/IdentityScopeLong:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   46: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	IdentityScopeLong
    //   0	51	1	paramLong	Long
    //   0	51	2	paramT	T
    //   26	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	16	41	finally
    //   20	25	41	finally
  }
  
  public T get(Long paramLong)
  {
    return (T)get2(paramLong.longValue());
  }
  
  public T get2(long paramLong)
  {
    this.lock.lock();
    try
    {
      Reference localReference = (Reference)this.map.get(paramLong);
      this.lock.unlock();
      if (localReference != null) {
        return (T)localReference.get();
      }
      return null;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public T get2NoLock(long paramLong)
  {
    Reference localReference = (Reference)this.map.get(paramLong);
    if (localReference != null) {
      return (T)localReference.get();
    }
    return null;
  }
  
  public T getNoLock(Long paramLong)
  {
    return (T)get2NoLock(paramLong.longValue());
  }
  
  public void lock()
  {
    this.lock.lock();
  }
  
  public void put(Long paramLong, T paramT)
  {
    put2(paramLong.longValue(), paramT);
  }
  
  public void put2(long paramLong, T paramT)
  {
    this.lock.lock();
    try
    {
      LongHashMap localLongHashMap = this.map;
      WeakReference localWeakReference = new java/lang/ref/WeakReference;
      localWeakReference.<init>(paramT);
      localLongHashMap.put(paramLong, localWeakReference);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void put2NoLock(long paramLong, T paramT)
  {
    this.map.put(paramLong, new WeakReference(paramT));
  }
  
  public void putNoLock(Long paramLong, T paramT)
  {
    put2NoLock(paramLong.longValue(), paramT);
  }
  
  public void remove(Iterable<Long> paramIterable)
  {
    this.lock.lock();
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Long localLong = (Long)paramIterable.next();
        this.map.remove(localLong.longValue());
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void remove(Long paramLong)
  {
    this.lock.lock();
    try
    {
      this.map.remove(paramLong.longValue());
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void reserveRoom(int paramInt)
  {
    this.map.reserveRoom(paramInt);
  }
  
  public void unlock()
  {
    this.lock.unlock();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\identityscope\IdentityScopeLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */