package androidx.lifecycle;

public class MutableLiveData<T>
  extends LiveData<T>
{
  public MutableLiveData() {}
  
  public MutableLiveData(T paramT)
  {
    super(paramT);
  }
  
  public void postValue(T paramT)
  {
    super.postValue(paramT);
  }
  
  public void setValue(T paramT)
  {
    super.setValue(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\MutableLiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */