package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MapChangeRegistry
  extends CallbackRegistry<ObservableMap.OnMapChangedCallback, ObservableMap, Object>
{
  private static CallbackRegistry.NotifierCallback<ObservableMap.OnMapChangedCallback, ObservableMap, Object> NOTIFIER_CALLBACK = new CallbackRegistry.NotifierCallback()
  {
    public void onNotifyCallback(ObservableMap.OnMapChangedCallback paramAnonymousOnMapChangedCallback, ObservableMap paramAnonymousObservableMap, int paramAnonymousInt, Object paramAnonymousObject)
    {
      paramAnonymousOnMapChangedCallback.onMapChanged(paramAnonymousObservableMap, paramAnonymousObject);
    }
  };
  
  public MapChangeRegistry()
  {
    super(NOTIFIER_CALLBACK);
  }
  
  public void notifyChange(@NonNull ObservableMap paramObservableMap, @Nullable Object paramObject)
  {
    notifyCallbacks(paramObservableMap, 0, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\MapChangeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */