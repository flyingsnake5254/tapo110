package androidx.lifecycle;

import androidx.annotation.NonNull;

class CompositeGeneratedAdaptersObserver
  implements LifecycleEventObserver
{
  private final GeneratedAdapter[] mGeneratedAdapters;
  
  CompositeGeneratedAdaptersObserver(GeneratedAdapter[] paramArrayOfGeneratedAdapter)
  {
    this.mGeneratedAdapters = paramArrayOfGeneratedAdapter;
  }
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    MethodCallsLogger localMethodCallsLogger = new MethodCallsLogger();
    GeneratedAdapter[] arrayOfGeneratedAdapter = this.mGeneratedAdapters;
    int i = arrayOfGeneratedAdapter.length;
    int j = 0;
    for (int k = 0; k < i; k++) {
      arrayOfGeneratedAdapter[k].callMethods(paramLifecycleOwner, paramEvent, false, localMethodCallsLogger);
    }
    arrayOfGeneratedAdapter = this.mGeneratedAdapters;
    i = arrayOfGeneratedAdapter.length;
    for (k = j; k < i; k++) {
      arrayOfGeneratedAdapter[k].callMethods(paramLifecycleOwner, paramEvent, true, localMethodCallsLogger);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\CompositeGeneratedAdaptersObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */