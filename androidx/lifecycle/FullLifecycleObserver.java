package androidx.lifecycle;

abstract interface FullLifecycleObserver
  extends LifecycleObserver
{
  public abstract void onCreate(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onDestroy(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onPause(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onResume(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onStart(LifecycleOwner paramLifecycleOwner);
  
  public abstract void onStop(LifecycleOwner paramLifecycleOwner);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\FullLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */