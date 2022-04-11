package androidx.lifecycle;

import androidx.annotation.NonNull;

class ReflectiveGenericLifecycleObserver
  implements LifecycleEventObserver
{
  private final ClassesInfoCache.CallbackInfo mInfo;
  private final Object mWrapped;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.mWrapped = paramObject;
    this.mInfo = ClassesInfoCache.sInstance.getInfo(paramObject.getClass());
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    this.mInfo.invokeCallbacks(paramLifecycleOwner, paramEvent, this.mWrapped);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\ReflectiveGenericLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */