package androidx.databinding;

abstract class BaseObservableField
  extends BaseObservable
{
  public BaseObservableField() {}
  
  public BaseObservableField(Observable... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      DependencyCallback localDependencyCallback = new DependencyCallback();
      for (int i = 0; i < paramVarArgs.length; i++) {
        paramVarArgs[i].addOnPropertyChangedCallback(localDependencyCallback);
      }
    }
  }
  
  class DependencyCallback
    extends Observable.OnPropertyChangedCallback
  {
    DependencyCallback() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      BaseObservableField.this.notifyChange();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\BaseObservableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */