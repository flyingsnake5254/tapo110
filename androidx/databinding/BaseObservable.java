package androidx.databinding;

import androidx.annotation.NonNull;

public class BaseObservable
  implements Observable
{
  private transient PropertyChangeRegistry mCallbacks;
  
  public void addOnPropertyChangedCallback(@NonNull Observable.OnPropertyChangedCallback paramOnPropertyChangedCallback)
  {
    try
    {
      if (this.mCallbacks == null)
      {
        PropertyChangeRegistry localPropertyChangeRegistry = new androidx/databinding/PropertyChangeRegistry;
        localPropertyChangeRegistry.<init>();
        this.mCallbacks = localPropertyChangeRegistry;
      }
      this.mCallbacks.add(paramOnPropertyChangedCallback);
      return;
    }
    finally {}
  }
  
  public void notifyChange()
  {
    try
    {
      PropertyChangeRegistry localPropertyChangeRegistry = this.mCallbacks;
      if (localPropertyChangeRegistry == null) {
        return;
      }
      localPropertyChangeRegistry.notifyCallbacks(this, 0, null);
      return;
    }
    finally {}
  }
  
  public void notifyPropertyChanged(int paramInt)
  {
    try
    {
      PropertyChangeRegistry localPropertyChangeRegistry = this.mCallbacks;
      if (localPropertyChangeRegistry == null) {
        return;
      }
      localPropertyChangeRegistry.notifyCallbacks(this, paramInt, null);
      return;
    }
    finally {}
  }
  
  public void removeOnPropertyChangedCallback(@NonNull Observable.OnPropertyChangedCallback paramOnPropertyChangedCallback)
  {
    try
    {
      PropertyChangeRegistry localPropertyChangeRegistry = this.mCallbacks;
      if (localPropertyChangeRegistry == null) {
        return;
      }
      localPropertyChangeRegistry.remove(paramOnPropertyChangedCallback);
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\BaseObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */