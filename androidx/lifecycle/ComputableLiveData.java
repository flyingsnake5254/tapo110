package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T>
{
  final AtomicBoolean mComputing = new AtomicBoolean(false);
  final Executor mExecutor;
  final AtomicBoolean mInvalid = new AtomicBoolean(true);
  @VisibleForTesting
  final Runnable mInvalidationRunnable = new Runnable()
  {
    @MainThread
    public void run()
    {
      boolean bool = ComputableLiveData.this.mLiveData.hasActiveObservers();
      if ((ComputableLiveData.this.mInvalid.compareAndSet(false, true)) && (bool))
      {
        ComputableLiveData localComputableLiveData = ComputableLiveData.this;
        localComputableLiveData.mExecutor.execute(localComputableLiveData.mRefreshRunnable);
      }
    }
  };
  final LiveData<T> mLiveData;
  @VisibleForTesting
  final Runnable mRefreshRunnable = new Runnable()
  {
    @WorkerThread
    public void run()
    {
      int i;
      do
      {
        Object localObject1 = ComputableLiveData.this.mComputing;
        i = 0;
        if (((AtomicBoolean)localObject1).compareAndSet(false, true))
        {
          localObject1 = null;
          i = 0;
          try
          {
            while (ComputableLiveData.this.mInvalid.compareAndSet(true, false))
            {
              localObject1 = ComputableLiveData.this.compute();
              i = 1;
            }
            if (i != 0) {
              ComputableLiveData.this.mLiveData.postValue(localObject1);
            }
          }
          finally
          {
            ComputableLiveData.this.mComputing.set(false);
          }
        }
      } while ((i != 0) && (ComputableLiveData.this.mInvalid.get()));
    }
  };
  
  public ComputableLiveData()
  {
    this(ArchTaskExecutor.getIOThreadExecutor());
  }
  
  public ComputableLiveData(@NonNull Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
    this.mLiveData = new LiveData()
    {
      protected void onActive()
      {
        ComputableLiveData localComputableLiveData = ComputableLiveData.this;
        localComputableLiveData.mExecutor.execute(localComputableLiveData.mRefreshRunnable);
      }
    };
  }
  
  @WorkerThread
  protected abstract T compute();
  
  @NonNull
  public LiveData<T> getLiveData()
  {
    return this.mLiveData;
  }
  
  public void invalidate()
  {
    ArchTaskExecutor.getInstance().executeOnMainThread(this.mInvalidationRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\ComputableLiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */