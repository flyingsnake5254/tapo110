package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.greendao.AbstractDao;

abstract class AbstractQueryData<T, Q extends AbstractQuery<T>>
{
  final AbstractDao<T, ?> dao;
  final String[] initialValues;
  final Map<Long, WeakReference<Q>> queriesForThreads;
  final String sql;
  
  AbstractQueryData(AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    this.dao = paramAbstractDao;
    this.sql = paramString;
    this.initialValues = paramArrayOfString;
    this.queriesForThreads = new HashMap();
  }
  
  protected abstract Q createQuery();
  
  Q forCurrentThread()
  {
    long l = Thread.currentThread().getId();
    synchronized (this.queriesForThreads)
    {
      Object localObject1 = (WeakReference)this.queriesForThreads.get(Long.valueOf(l));
      if (localObject1 != null) {
        localObject1 = (AbstractQuery)((WeakReference)localObject1).get();
      } else {
        localObject1 = null;
      }
      Object localObject3;
      if (localObject1 == null)
      {
        gc();
        localObject1 = createQuery();
        localObject3 = this.queriesForThreads;
        WeakReference localWeakReference = new java/lang/ref/WeakReference;
        localWeakReference.<init>(localObject1);
        ((Map)localObject3).put(Long.valueOf(l), localWeakReference);
      }
      else
      {
        localObject3 = this.initialValues;
        System.arraycopy(localObject3, 0, ((AbstractQuery)localObject1).parameters, 0, localObject3.length);
      }
      return (Q)localObject1;
    }
  }
  
  Q forCurrentThread(Q paramQ)
  {
    if (Thread.currentThread() == paramQ.ownerThread)
    {
      String[] arrayOfString = this.initialValues;
      System.arraycopy(arrayOfString, 0, paramQ.parameters, 0, arrayOfString.length);
      return paramQ;
    }
    return forCurrentThread();
  }
  
  void gc()
  {
    synchronized (this.queriesForThreads)
    {
      Iterator localIterator = this.queriesForThreads.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)((Map.Entry)localIterator.next()).getValue()).get() == null) {
          localIterator.remove();
        }
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\AbstractQueryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */