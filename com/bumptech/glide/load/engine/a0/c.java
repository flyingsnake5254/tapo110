package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.util.i;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c
{
  private final Map<String, a> a = new HashMap();
  private final b b = new b();
  
  void a(String paramString)
  {
    try
    {
      a locala1 = (a)this.a.get(paramString);
      a locala2 = locala1;
      if (locala1 == null)
      {
        locala2 = this.b.a();
        this.a.put(paramString, locala2);
      }
      locala2.b += 1;
      locala2.a.lock();
      return;
    }
    finally {}
  }
  
  void b(String paramString)
  {
    try
    {
      a locala = (a)i.d(this.a.get(paramString));
      int i = locala.b;
      if (i >= 1)
      {
        i--;
        locala.b = i;
        if (i == 0)
        {
          localObject1 = (a)this.a.remove(paramString);
          if (localObject1.equals(locala))
          {
            this.b.b((a)localObject1);
          }
          else
          {
            IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            ((StringBuilder)localObject2).append("Removed the wrong lock, expected to remove: ");
            ((StringBuilder)localObject2).append(locala);
            ((StringBuilder)localObject2).append(", but actually removed: ");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append(", safeKey: ");
            ((StringBuilder)localObject2).append(paramString);
            localIllegalStateException.<init>(((StringBuilder)localObject2).toString());
            throw localIllegalStateException;
          }
        }
        locala.a.unlock();
        return;
      }
      Object localObject2 = new java/lang/IllegalStateException;
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("Cannot release a lock that is not held, safeKey: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", interestedThreads: ");
      ((StringBuilder)localObject1).append(locala.b);
      ((IllegalStateException)localObject2).<init>(((StringBuilder)localObject1).toString());
      throw ((Throwable)localObject2);
    }
    finally {}
  }
  
  private static class a
  {
    final Lock a = new ReentrantLock();
    int b;
  }
  
  private static class b
  {
    private final Queue<c.a> a = new ArrayDeque();
    
    c.a a()
    {
      synchronized (this.a)
      {
        c.a locala = (c.a)this.a.poll();
        ??? = locala;
        if (locala == null) {
          ??? = new c.a();
        }
        return (c.a)???;
      }
    }
    
    void b(c.a parama)
    {
      synchronized (this.a)
      {
        if (this.a.size() < 10) {
          this.a.offer(parama);
        }
        return;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */