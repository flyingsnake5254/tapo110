package io.reactivex.internal.subscribers;

import e.b.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicLong;

public abstract class SinglePostCompleteSubscriber<T, R>
  extends AtomicLong
  implements k<T>, c
{
  static final long COMPLETE_MASK = Long.MIN_VALUE;
  static final long REQUEST_MASK = Long.MAX_VALUE;
  private static final long serialVersionUID = 7917814472626990048L;
  protected final e.b.b<? super R> downstream;
  protected long produced;
  protected c upstream;
  protected R value;
  
  public SinglePostCompleteSubscriber(e.b.b<? super R> paramb)
  {
    this.downstream = paramb;
  }
  
  public void cancel()
  {
    this.upstream.cancel();
  }
  
  protected final void complete(R paramR)
  {
    long l = this.produced;
    if (l != 0L) {
      io.reactivex.internal.util.b.c(this, l);
    }
    for (;;)
    {
      l = get();
      if ((l & 0x8000000000000000) != 0L)
      {
        onDrop(paramR);
        return;
      }
      if ((l & 0x7FFFFFFFFFFFFFFF) != 0L)
      {
        lazySet(-9223372036854775807L);
        this.downstream.onNext(paramR);
        this.downstream.onComplete();
        return;
      }
      this.value = paramR;
      if (compareAndSet(0L, Long.MIN_VALUE)) {
        return;
      }
      this.value = null;
    }
  }
  
  protected void onDrop(R paramR) {}
  
  public void onSubscribe(c paramc)
  {
    if (SubscriptionHelper.validate(this.upstream, paramc))
    {
      this.upstream = paramc;
      this.downstream.onSubscribe(this);
    }
  }
  
  public final void request(long paramLong)
  {
    if (SubscriptionHelper.validate(paramLong))
    {
      long l;
      do
      {
        l = get();
        if ((l & 0x8000000000000000) != 0L)
        {
          if (!compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
            break;
          }
          this.downstream.onNext(this.value);
          this.downstream.onComplete();
          break;
        }
      } while (!compareAndSet(l, io.reactivex.internal.util.b.b(l, paramLong)));
      this.upstream.request(paramLong);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\SinglePostCompleteSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */