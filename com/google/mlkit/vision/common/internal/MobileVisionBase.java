package com.google.mlkit.vision.common.internal;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import b.b.a.a.a.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.l;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
public class MobileVisionBase<DetectionResultT>
  implements LifecycleObserver, Closeable
{
  private static final GmsLogger c = new GmsLogger("MobileVisionBase", "");
  private final AtomicBoolean d = new AtomicBoolean(false);
  private final com.google.mlkit.common.sdkinternal.g<DetectionResultT, a> f;
  private final CancellationTokenSource q;
  private final Executor x;
  
  @KeepForSdk
  public MobileVisionBase(@NonNull com.google.mlkit.common.sdkinternal.g<DetectionResultT, a> paramg, @NonNull Executor paramExecutor)
  {
    this.f = paramg;
    CancellationTokenSource localCancellationTokenSource = new CancellationTokenSource();
    this.q = localCancellationTokenSource;
    this.x = paramExecutor;
    paramg.c();
    paramg.a(paramExecutor, f.c, localCancellationTokenSource.getToken()).addOnFailureListener(h.a);
  }
  
  @KeepForSdk
  public Task<DetectionResultT> a(@NonNull a parama)
  {
    try
    {
      Preconditions.checkNotNull(parama, "InputImage can not be null");
      if (this.d.get())
      {
        parama = new com/google/mlkit/common/MlKitException;
        parama.<init>("This detector is already closed!", 14);
        parama = Tasks.forException(parama);
        return parama;
      }
      if ((parama.h() >= 32) && (parama.e() >= 32))
      {
        com.google.mlkit.common.sdkinternal.g localg = this.f;
        Executor localExecutor = this.x;
        g localg1 = new com/google/mlkit/vision/common/internal/g;
        localg1.<init>(this, parama);
        parama = localg.a(localExecutor, localg1, this.q.getToken());
        return parama;
      }
      parama = new com/google/mlkit/common/MlKitException;
      parama.<init>("InputImage width and height should be at least 32!", 3);
      parama = Tasks.forException(parama);
      return parama;
    }
    finally {}
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void close()
  {
    try
    {
      if (!this.d.getAndSet(true))
      {
        this.q.cancel();
        this.f.e(this.x);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\common\internal\MobileVisionBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */