package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LifecycleService
  extends Service
  implements LifecycleOwner
{
  private final ServiceLifecycleDispatcher mDispatcher = new ServiceLifecycleDispatcher(this);
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.mDispatcher.getLifecycle();
  }
  
  @CallSuper
  @Nullable
  public IBinder onBind(@NonNull Intent paramIntent)
  {
    this.mDispatcher.onServicePreSuperOnBind();
    return null;
  }
  
  @CallSuper
  public void onCreate()
  {
    this.mDispatcher.onServicePreSuperOnCreate();
    super.onCreate();
  }
  
  @CallSuper
  public void onDestroy()
  {
    this.mDispatcher.onServicePreSuperOnDestroy();
    super.onDestroy();
  }
  
  @CallSuper
  public void onStart(@Nullable Intent paramIntent, int paramInt)
  {
    this.mDispatcher.onServicePreSuperOnStart();
    super.onStart(paramIntent, paramInt);
  }
  
  @CallSuper
  public int onStartCommand(@Nullable Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\LifecycleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */