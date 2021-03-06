package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig<T>
{
  @NonNull
  private final Executor mBackgroundThreadExecutor;
  @NonNull
  private final DiffUtil.ItemCallback<T> mDiffCallback;
  @Nullable
  private final Executor mMainThreadExecutor;
  
  AsyncDifferConfig(@Nullable Executor paramExecutor1, @NonNull Executor paramExecutor2, @NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    this.mMainThreadExecutor = paramExecutor1;
    this.mBackgroundThreadExecutor = paramExecutor2;
    this.mDiffCallback = paramItemCallback;
  }
  
  @NonNull
  public Executor getBackgroundThreadExecutor()
  {
    return this.mBackgroundThreadExecutor;
  }
  
  @NonNull
  public DiffUtil.ItemCallback<T> getDiffCallback()
  {
    return this.mDiffCallback;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public Executor getMainThreadExecutor()
  {
    return this.mMainThreadExecutor;
  }
  
  public static final class Builder<T>
  {
    private static Executor sDiffExecutor;
    private static final Object sExecutorLock = new Object();
    private Executor mBackgroundThreadExecutor;
    private final DiffUtil.ItemCallback<T> mDiffCallback;
    @Nullable
    private Executor mMainThreadExecutor;
    
    public Builder(@NonNull DiffUtil.ItemCallback<T> paramItemCallback)
    {
      this.mDiffCallback = paramItemCallback;
    }
    
    @NonNull
    public AsyncDifferConfig<T> build()
    {
      if (this.mBackgroundThreadExecutor == null) {
        synchronized (sExecutorLock)
        {
          if (sDiffExecutor == null) {
            sDiffExecutor = Executors.newFixedThreadPool(2);
          }
          this.mBackgroundThreadExecutor = sDiffExecutor;
        }
      }
      return new AsyncDifferConfig(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
    }
    
    @NonNull
    public Builder<T> setBackgroundThreadExecutor(Executor paramExecutor)
    {
      this.mBackgroundThreadExecutor = paramExecutor;
      return this;
    }
    
    @NonNull
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public Builder<T> setMainThreadExecutor(Executor paramExecutor)
    {
      this.mMainThreadExecutor = paramExecutor;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\AsyncDifferConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */