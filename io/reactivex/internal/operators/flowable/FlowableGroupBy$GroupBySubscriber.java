package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.g0.j;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableGroupBy$GroupBySubscriber<T, K, V>
  extends BasicIntQueueSubscription<io.reactivex.f0.a<K, V>>
  implements k<T>
{
  static final Object NULL_KEY = new Object();
  private static final long serialVersionUID = -3688291656102519502L;
  final int bufferSize;
  final AtomicBoolean cancelled = new AtomicBoolean();
  final boolean delayError;
  boolean done;
  final e.b.b<? super io.reactivex.f0.a<K, V>> downstream;
  Throwable error;
  final Queue<n<K, V>> evictedGroups;
  volatile boolean finished;
  final AtomicInteger groupCount = new AtomicInteger(1);
  final Map<Object, n<K, V>> groups;
  final j<? super T, ? extends K> keySelector;
  boolean outputFused;
  final io.reactivex.internal.queue.b<io.reactivex.f0.a<K, V>> queue;
  final AtomicLong requested = new AtomicLong();
  c upstream;
  final j<? super T, ? extends V> valueSelector;
  
  public FlowableGroupBy$GroupBySubscriber(e.b.b<? super io.reactivex.f0.a<K, V>> paramb, j<? super T, ? extends K> paramj, j<? super T, ? extends V> paramj1, int paramInt, boolean paramBoolean, Map<Object, n<K, V>> paramMap, Queue<n<K, V>> paramQueue)
  {
    this.downstream = paramb;
    this.keySelector = paramj;
    this.valueSelector = paramj1;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
    this.groups = paramMap;
    this.evictedGroups = paramQueue;
    this.queue = new io.reactivex.internal.queue.b(paramInt);
  }
  
  private void completeEvictions()
  {
    if (this.evictedGroups != null)
    {
      for (int i = 0;; i++)
      {
        n localn = (n)this.evictedGroups.poll();
        if (localn == null) {
          break;
        }
        localn.onComplete();
      }
      if (i != 0) {
        this.groupCount.addAndGet(-i);
      }
    }
  }
  
  public void cancel()
  {
    if (this.cancelled.compareAndSet(false, true))
    {
      completeEvictions();
      if (this.groupCount.decrementAndGet() == 0) {
        this.upstream.cancel();
      }
    }
  }
  
  public void cancel(K paramK)
  {
    if (paramK == null) {
      paramK = NULL_KEY;
    }
    this.groups.remove(paramK);
    if (this.groupCount.decrementAndGet() == 0)
    {
      this.upstream.cancel();
      if ((!this.outputFused) && (getAndIncrement() == 0)) {
        this.queue.clear();
      }
    }
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, e.b.b<?> paramb, io.reactivex.internal.queue.b<?> paramb1)
  {
    if (this.cancelled.get())
    {
      paramb1.clear();
      return true;
    }
    if (this.delayError)
    {
      if ((paramBoolean1) && (paramBoolean2))
      {
        paramb1 = this.error;
        if (paramb1 != null) {
          paramb.onError(paramb1);
        } else {
          paramb.onComplete();
        }
        return true;
      }
    }
    else if (paramBoolean1)
    {
      Throwable localThrowable = this.error;
      if (localThrowable != null)
      {
        paramb1.clear();
        paramb.onError(localThrowable);
        return true;
      }
      if (paramBoolean2)
      {
        paramb.onComplete();
        return true;
      }
    }
    return false;
  }
  
  public void clear()
  {
    this.queue.clear();
  }
  
  void drain()
  {
    if (getAndIncrement() != 0) {
      return;
    }
    if (this.outputFused) {
      drainFused();
    } else {
      drainNormal();
    }
  }
  
  void drainFused()
  {
    Object localObject = this.queue;
    e.b.b localb = this.downstream;
    int i = 1;
    int j;
    do
    {
      if (this.cancelled.get()) {
        return;
      }
      boolean bool = this.finished;
      if ((bool) && (!this.delayError))
      {
        Throwable localThrowable = this.error;
        if (localThrowable != null)
        {
          ((io.reactivex.internal.queue.b)localObject).clear();
          localb.onError(localThrowable);
          return;
        }
      }
      localb.onNext(null);
      if (bool)
      {
        localObject = this.error;
        if (localObject != null) {
          localb.onError((Throwable)localObject);
        } else {
          localb.onComplete();
        }
        return;
      }
      j = addAndGet(-i);
      i = j;
    } while (j != 0);
  }
  
  void drainNormal()
  {
    io.reactivex.internal.queue.b localb = this.queue;
    e.b.b localb1 = this.downstream;
    int i = 1;
    int j;
    do
    {
      long l1 = this.requested.get();
      boolean bool1;
      for (long l2 = 0L;; l2 += 1L)
      {
        bool1 = l2 < l1;
        if (!bool1) {
          break;
        }
        boolean bool2 = this.finished;
        io.reactivex.f0.a locala = (io.reactivex.f0.a)localb.poll();
        boolean bool3;
        if (locala == null) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        if (checkTerminated(bool2, bool3, localb1, localb)) {
          return;
        }
        if (bool3) {
          break;
        }
        localb1.onNext(locala);
      }
      if ((!bool1) && (checkTerminated(this.finished, localb.isEmpty(), localb1, localb))) {
        return;
      }
      if (l2 != 0L)
      {
        if (l1 != Long.MAX_VALUE) {
          this.requested.addAndGet(-l2);
        }
        this.upstream.request(l2);
      }
      j = addAndGet(-i);
      i = j;
    } while (j != 0);
  }
  
  public boolean isEmpty()
  {
    return this.queue.isEmpty();
  }
  
  public void onComplete()
  {
    if (!this.done)
    {
      Object localObject = this.groups.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((n)((Iterator)localObject).next()).onComplete();
      }
      this.groups.clear();
      localObject = this.evictedGroups;
      if (localObject != null) {
        ((Queue)localObject).clear();
      }
      this.done = true;
      this.finished = true;
      drain();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.done)
    {
      io.reactivex.j0.a.r(paramThrowable);
      return;
    }
    this.done = true;
    Object localObject = this.groups.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((n)((Iterator)localObject).next()).onError(paramThrowable);
    }
    this.groups.clear();
    localObject = this.evictedGroups;
    if (localObject != null) {
      ((Queue)localObject).clear();
    }
    this.error = paramThrowable;
    this.finished = true;
    drain();
  }
  
  public void onNext(T paramT)
  {
    if (this.done) {
      return;
    }
    io.reactivex.internal.queue.b localb = this.queue;
    try
    {
      Object localObject1 = this.keySelector.apply(paramT);
      int i = 0;
      Object localObject2;
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = NULL_KEY;
      }
      n localn1 = (n)this.groups.get(localObject2);
      n localn2 = localn1;
      if (localn1 == null)
      {
        if (this.cancelled.get()) {
          return;
        }
        localn2 = n.M(localObject1, this.bufferSize, this, this.delayError);
        this.groups.put(localObject2, localn2);
        this.groupCount.getAndIncrement();
        i = 1;
      }
      try
      {
        paramT = io.reactivex.h0.a.b.e(this.valueSelector.apply(paramT), "The valueSelector returned null");
        localn2.onNext(paramT);
        completeEvictions();
        if (i != 0)
        {
          localb.offer(localn2);
          drain();
        }
        return;
      }
      finally {}
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(paramT);
      this.upstream.cancel();
      onError(paramT);
    }
  }
  
  public void onSubscribe(c paramc)
  {
    if (SubscriptionHelper.validate(this.upstream, paramc))
    {
      this.upstream = paramc;
      this.downstream.onSubscribe(this);
      paramc.request(this.bufferSize);
    }
  }
  
  public io.reactivex.f0.a<K, V> poll()
  {
    return (io.reactivex.f0.a)this.queue.poll();
  }
  
  public void request(long paramLong)
  {
    if (SubscriptionHelper.validate(paramLong))
    {
      io.reactivex.internal.util.b.a(this.requested, paramLong);
      drain();
    }
  }
  
  public int requestFusion(int paramInt)
  {
    if ((paramInt & 0x2) != 0)
    {
      this.outputFused = true;
      return 2;
    }
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\FlowableGroupBy$GroupBySubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */