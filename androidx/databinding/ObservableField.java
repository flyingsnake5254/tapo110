package androidx.databinding;

import androidx.annotation.Nullable;
import java.io.Serializable;

public class ObservableField<T>
  extends BaseObservableField
  implements Serializable
{
  static final long serialVersionUID = 1L;
  private T mValue;
  
  public ObservableField() {}
  
  public ObservableField(T paramT)
  {
    this.mValue = paramT;
  }
  
  public ObservableField(Observable... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  @Nullable
  public T get()
  {
    return (T)this.mValue;
  }
  
  public void set(T paramT)
  {
    if (paramT != this.mValue)
    {
      this.mValue = paramT;
      notifyChange();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\ObservableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */