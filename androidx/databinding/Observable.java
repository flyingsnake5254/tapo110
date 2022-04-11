package androidx.databinding;

public abstract interface Observable
{
  public abstract void addOnPropertyChangedCallback(OnPropertyChangedCallback paramOnPropertyChangedCallback);
  
  public abstract void removeOnPropertyChangedCallback(OnPropertyChangedCallback paramOnPropertyChangedCallback);
  
  public static abstract class OnPropertyChangedCallback
  {
    public abstract void onPropertyChanged(Observable paramObservable, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\Observable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */