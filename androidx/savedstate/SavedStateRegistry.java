package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.Map.Entry;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry
{
  private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
  boolean mAllowingSavingState = true;
  private SafeIterableMap<String, SavedStateProvider> mComponents = new SafeIterableMap();
  private Recreator.SavedStateProvider mRecreatorProvider;
  private boolean mRestored;
  @Nullable
  private Bundle mRestoredState;
  
  @MainThread
  @Nullable
  public Bundle consumeRestoredStateForKey(@NonNull String paramString)
  {
    if (this.mRestored)
    {
      Bundle localBundle = this.mRestoredState;
      if (localBundle != null)
      {
        localBundle = localBundle.getBundle(paramString);
        this.mRestoredState.remove(paramString);
        if (this.mRestoredState.isEmpty()) {
          this.mRestoredState = null;
        }
        return localBundle;
      }
      return null;
    }
    throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
  }
  
  @MainThread
  public boolean isRestored()
  {
    return this.mRestored;
  }
  
  @MainThread
  void performRestore(@NonNull Lifecycle paramLifecycle, @Nullable Bundle paramBundle)
  {
    if (!this.mRestored)
    {
      if (paramBundle != null) {
        this.mRestoredState = paramBundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
      }
      paramLifecycle.addObserver(new GenericLifecycleObserver()
      {
        public void onStateChanged(LifecycleOwner paramAnonymousLifecycleOwner, Lifecycle.Event paramAnonymousEvent)
        {
          if (paramAnonymousEvent == Lifecycle.Event.ON_START) {
            SavedStateRegistry.this.mAllowingSavingState = true;
          } else if (paramAnonymousEvent == Lifecycle.Event.ON_STOP) {
            SavedStateRegistry.this.mAllowingSavingState = false;
          }
        }
      });
      this.mRestored = true;
      return;
    }
    throw new IllegalStateException("SavedStateRegistry was already restored.");
  }
  
  @MainThread
  void performSave(@NonNull Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Object localObject = this.mRestoredState;
    if (localObject != null) {
      localBundle.putAll((Bundle)localObject);
    }
    SafeIterableMap.IteratorWithAdditions localIteratorWithAdditions = this.mComponents.iteratorWithAdditions();
    while (localIteratorWithAdditions.hasNext())
    {
      localObject = (Map.Entry)localIteratorWithAdditions.next();
      localBundle.putBundle((String)((Map.Entry)localObject).getKey(), ((SavedStateProvider)((Map.Entry)localObject).getValue()).saveState());
    }
    paramBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", localBundle);
  }
  
  @MainThread
  public void registerSavedStateProvider(@NonNull String paramString, @NonNull SavedStateProvider paramSavedStateProvider)
  {
    if ((SavedStateProvider)this.mComponents.putIfAbsent(paramString, paramSavedStateProvider) == null) {
      return;
    }
    throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
  }
  
  @MainThread
  public void runOnNextRecreation(@NonNull Class<? extends AutoRecreated> paramClass)
  {
    if (this.mAllowingSavingState)
    {
      if (this.mRecreatorProvider == null) {
        this.mRecreatorProvider = new Recreator.SavedStateProvider(this);
      }
      try
      {
        paramClass.getDeclaredConstructor(new Class[0]);
        this.mRecreatorProvider.add(paramClass.getName());
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Class");
        localStringBuilder.append(paramClass.getSimpleName());
        localStringBuilder.append(" must have default constructor in order to be automatically recreated");
        throw new IllegalArgumentException(localStringBuilder.toString(), localNoSuchMethodException);
      }
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  @MainThread
  public void unregisterSavedStateProvider(@NonNull String paramString)
  {
    this.mComponents.remove(paramString);
  }
  
  public static abstract interface AutoRecreated
  {
    public abstract void onRecreated(@NonNull SavedStateRegistryOwner paramSavedStateRegistryOwner);
  }
  
  public static abstract interface SavedStateProvider
  {
    @NonNull
    public abstract Bundle saveState();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\savedstate\SavedStateRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */