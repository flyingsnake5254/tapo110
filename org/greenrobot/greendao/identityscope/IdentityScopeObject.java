package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class IdentityScopeObject<K, T>
  implements IdentityScope<K, T>
{
  private final ReentrantLock lock = new ReentrantLock();
  private final HashMap<K, Reference<T>> map = new HashMap();
  
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
  public boolean detach(K paramK, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	org/greenrobot/greendao/identityscope/IdentityScopeObject:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 30	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 41	org/greenrobot/greendao/identityscope/IdentityScopeObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: aload_2
    //   13: if_acmpne +23 -> 36
    //   16: aload_2
    //   17: ifnull +19 -> 36
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 45	org/greenrobot/greendao/identityscope/IdentityScopeObject:remove	(Ljava/lang/Object;)V
    //   25: iconst_1
    //   26: istore_3
    //   27: aload_0
    //   28: getfield 26	org/greenrobot/greendao/identityscope/IdentityScopeObject:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   31: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   34: iload_3
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_3
    //   38: goto -11 -> 27
    //   41: astore_1
    //   42: aload_0
    //   43: getfield 26	org/greenrobot/greendao/identityscope/IdentityScopeObject:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   46: invokevirtual 35	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	IdentityScopeObject
    //   0	51	1	paramK	K
    //   0	51	2	paramT	T
    //   26	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	16	41	finally
    //   20	25	41	finally
  }
  
  public T get(K paramK)
  {
    this.lock.lock();
    try
    {
      paramK = (Reference)this.map.get(paramK);
      this.lock.unlock();
      if (paramK != null) {
        return (T)paramK.get();
      }
      return null;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public T getNoLock(K paramK)
  {
    paramK = (Reference)this.map.get(paramK);
    if (paramK != null) {
      return (T)paramK.get();
    }
    return null;
  }
  
  public void lock()
  {
    this.lock.lock();
  }
  
  public void put(K paramK, T paramT)
  {
    this.lock.lock();
    try
    {
      HashMap localHashMap = this.map;
      WeakReference localWeakReference = new java/lang/ref/WeakReference;
      localWeakReference.<init>(paramT);
      localHashMap.put(paramK, localWeakReference);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void putNoLock(K paramK, T paramT)
  {
    this.map.put(paramK, new WeakReference(paramT));
  }
  
  public void remove(Iterable<K> paramIterable)
  {
    this.lock.lock();
    try
    {
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        paramIterable = localIterator.next();
        this.map.remove(paramIterable);
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void remove(K paramK)
  {
    this.lock.lock();
    try
    {
      this.map.remove(paramK);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void reserveRoom(int paramInt) {}
  
  public void unlock()
  {
    this.lock.unlock();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\identityscope\IdentityScopeObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */