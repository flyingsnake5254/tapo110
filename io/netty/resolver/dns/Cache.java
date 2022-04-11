package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.c;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

abstract class Cache<E>
{
  private static final ScheduledFuture<?> CANCELLED = new ScheduledFuture()
  {
    public boolean cancel(boolean paramAnonymousBoolean)
    {
      return false;
    }
    
    public int compareTo(Delayed paramAnonymousDelayed)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object get()
    {
      throw new UnsupportedOperationException();
    }
    
    public Object get(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
    {
      throw new UnsupportedOperationException();
    }
    
    public long getDelay(TimeUnit paramAnonymousTimeUnit)
    {
      return Long.MIN_VALUE;
    }
    
    public boolean isCancelled()
    {
      return true;
    }
    
    public boolean isDone()
    {
      return true;
    }
  };
  private static final AtomicReferenceFieldUpdater<Entries, ScheduledFuture> FUTURE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(Entries.class, ScheduledFuture.class, "expirationFuture");
  static final int MAX_SUPPORTED_TTL_SECS = (int)TimeUnit.DAYS.toSeconds(730L);
  private final ConcurrentMap<String, Cache<E>.Entries> resolveCache = PlatformDependent.newConcurrentHashMap();
  
  final void cache(String paramString, E paramE, int paramInt, EventLoop paramEventLoop)
  {
    Entries localEntries = (Entries)this.resolveCache.get(paramString);
    Object localObject = localEntries;
    if (localEntries == null)
    {
      localObject = new Entries(paramString);
      paramString = (Entries)this.resolveCache.putIfAbsent(paramString, localObject);
      if (paramString != null) {
        localObject = paramString;
      }
    }
    ((Entries)localObject).add(paramE, paramInt, paramEventLoop);
  }
  
  final void clear()
  {
    if (!this.resolveCache.isEmpty())
    {
      Iterator localIterator = this.resolveCache.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localIterator.remove();
        ((Entries)localEntry.getValue()).clearAndCancel();
      }
    }
  }
  
  final boolean clear(String paramString)
  {
    paramString = (Entries)this.resolveCache.remove(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.clearAndCancel())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected abstract boolean equals(E paramE1, E paramE2);
  
  final List<? extends E> get(String paramString)
  {
    paramString = (Entries)this.resolveCache.get(paramString);
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = (List)paramString.get();
    }
    return paramString;
  }
  
  protected abstract boolean shouldReplaceAll(E paramE);
  
  final int size()
  {
    return this.resolveCache.size();
  }
  
  protected void sortEntries(String paramString, List<E> paramList) {}
  
  private final class Entries
    extends AtomicReference<List<E>>
    implements Runnable
  {
    volatile ScheduledFuture<?> expirationFuture;
    private final String hostname;
    
    Entries(String paramString)
    {
      super();
      this.hostname = paramString;
    }
    
    private void scheduleCacheExpirationIfNeeded(int paramInt, EventLoop paramEventLoop)
    {
      for (;;)
      {
        ScheduledFuture localScheduledFuture = (ScheduledFuture)Cache.FUTURE_UPDATER.get(this);
        c localc;
        if ((localScheduledFuture == null) || (localScheduledFuture.getDelay(TimeUnit.SECONDS) > paramInt))
        {
          localc = paramEventLoop.schedule(this, paramInt, TimeUnit.SECONDS);
          if (!Cache.FUTURE_UPDATER.compareAndSet(this, localScheduledFuture, localc)) {
            break label70;
          }
          if (localScheduledFuture != null) {
            localScheduledFuture.cancel(true);
          }
        }
        return;
        label70:
        localc.cancel(true);
      }
    }
    
    void add(E paramE, int paramInt, EventLoop paramEventLoop)
    {
      if (!Cache.this.shouldReplaceAll(paramE))
      {
        List localList;
        label203:
        label251:
        do
        {
          ArrayList localArrayList;
          do
          {
            int i;
            do
            {
              localList = (List)get();
              if (localList.isEmpty()) {
                break label251;
              }
              i = 0;
              localObject1 = localList.get(0);
              if (!Cache.this.shouldReplaceAll(localObject1)) {
                break;
              }
            } while (!compareAndSet(localList, Collections.singletonList(paramE)));
            scheduleCacheExpirationIfNeeded(paramInt, paramEventLoop);
            return;
            localArrayList = new ArrayList(localList.size() + 1);
            Object localObject2 = null;
            int j;
            do
            {
              localObject1 = localList.get(i);
              if (Cache.this.equals(paramE, localObject1)) {
                break;
              }
              localArrayList.add(localObject1);
              j = i + 1;
              i = j;
            } while (j < localList.size());
            Object localObject1 = localObject2;
            break label203;
            localArrayList.add(paramE);
            for (;;)
            {
              i++;
              if (i >= localList.size()) {
                break;
              }
              localArrayList.add(localList.get(i));
            }
            if (localObject1 == null) {
              localArrayList.add(paramE);
            }
            Cache.this.sortEntries(this.hostname, localArrayList);
          } while (!compareAndSet(localList, Collections.unmodifiableList(localArrayList)));
          scheduleCacheExpirationIfNeeded(paramInt, paramEventLoop);
          return;
        } while (!compareAndSet(localList, Collections.singletonList(paramE)));
        scheduleCacheExpirationIfNeeded(paramInt, paramEventLoop);
        return;
      }
      set(Collections.singletonList(paramE));
      scheduleCacheExpirationIfNeeded(paramInt, paramEventLoop);
    }
    
    boolean clearAndCancel()
    {
      if (((List)getAndSet(Collections.emptyList())).isEmpty()) {
        return false;
      }
      ScheduledFuture localScheduledFuture = (ScheduledFuture)Cache.FUTURE_UPDATER.getAndSet(this, Cache.CANCELLED);
      if (localScheduledFuture != null) {
        localScheduledFuture.cancel(false);
      }
      return true;
    }
    
    public void run()
    {
      Cache.this.resolveCache.remove(this.hostname, this);
      clearAndCancel();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */