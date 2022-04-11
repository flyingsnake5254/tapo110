package androidx.databinding;

public abstract class OnRebindCallback<T extends ViewDataBinding>
{
  public void onBound(T paramT) {}
  
  public void onCanceled(T paramT) {}
  
  public boolean onPreBind(T paramT)
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\OnRebindCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */