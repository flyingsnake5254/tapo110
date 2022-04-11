package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class TaskExecutor
{
  public abstract void executeOnDiskIO(@NonNull Runnable paramRunnable);
  
  public void executeOnMainThread(@NonNull Runnable paramRunnable)
  {
    if (isMainThread()) {
      paramRunnable.run();
    } else {
      postToMainThread(paramRunnable);
    }
  }
  
  public abstract boolean isMainThread();
  
  public abstract void postToMainThread(@NonNull Runnable paramRunnable);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\arch\core\executor\TaskExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */