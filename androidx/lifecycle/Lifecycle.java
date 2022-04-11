package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle
{
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  AtomicReference<Object> mInternalScopeRef = new AtomicReference();
  
  @MainThread
  public abstract void addObserver(@NonNull LifecycleObserver paramLifecycleObserver);
  
  @MainThread
  @NonNull
  public abstract State getCurrentState();
  
  @MainThread
  public abstract void removeObserver(@NonNull LifecycleObserver paramLifecycleObserver);
  
  public static enum Event
  {
    static
    {
      Event localEvent1 = new Event("ON_CREATE", 0);
      ON_CREATE = localEvent1;
      Event localEvent2 = new Event("ON_START", 1);
      ON_START = localEvent2;
      Event localEvent3 = new Event("ON_RESUME", 2);
      ON_RESUME = localEvent3;
      Event localEvent4 = new Event("ON_PAUSE", 3);
      ON_PAUSE = localEvent4;
      Event localEvent5 = new Event("ON_STOP", 4);
      ON_STOP = localEvent5;
      Event localEvent6 = new Event("ON_DESTROY", 5);
      ON_DESTROY = localEvent6;
      Event localEvent7 = new Event("ON_ANY", 6);
      ON_ANY = localEvent7;
      $VALUES = new Event[] { localEvent1, localEvent2, localEvent3, localEvent4, localEvent5, localEvent6, localEvent7 };
    }
  }
  
  public static enum State
  {
    static
    {
      State localState1 = new State("DESTROYED", 0);
      DESTROYED = localState1;
      State localState2 = new State("INITIALIZED", 1);
      INITIALIZED = localState2;
      State localState3 = new State("CREATED", 2);
      CREATED = localState3;
      State localState4 = new State("STARTED", 3);
      STARTED = localState4;
      State localState5 = new State("RESUMED", 4);
      RESUMED = localState5;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5 };
    }
    
    public boolean isAtLeast(@NonNull State paramState)
    {
      boolean bool;
      if (compareTo(paramState) >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\Lifecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */