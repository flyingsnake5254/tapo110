package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.core.util.Pools.SynchronizedPool;

public class ListChangeRegistry
  extends CallbackRegistry<ObservableList.OnListChangedCallback, ObservableList, ListChanges>
{
  private static final int ALL = 0;
  private static final int CHANGED = 1;
  private static final int INSERTED = 2;
  private static final int MOVED = 3;
  private static final CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges> NOTIFIER_CALLBACK = new CallbackRegistry.NotifierCallback()
  {
    public void onNotifyCallback(ObservableList.OnListChangedCallback paramAnonymousOnListChangedCallback, ObservableList paramAnonymousObservableList, int paramAnonymousInt, ListChangeRegistry.ListChanges paramAnonymousListChanges)
    {
      if (paramAnonymousInt != 1)
      {
        if (paramAnonymousInt != 2)
        {
          if (paramAnonymousInt != 3)
          {
            if (paramAnonymousInt != 4) {
              paramAnonymousOnListChangedCallback.onChanged(paramAnonymousObservableList);
            } else {
              paramAnonymousOnListChangedCallback.onItemRangeRemoved(paramAnonymousObservableList, paramAnonymousListChanges.start, paramAnonymousListChanges.count);
            }
          }
          else {
            paramAnonymousOnListChangedCallback.onItemRangeMoved(paramAnonymousObservableList, paramAnonymousListChanges.start, paramAnonymousListChanges.to, paramAnonymousListChanges.count);
          }
        }
        else {
          paramAnonymousOnListChangedCallback.onItemRangeInserted(paramAnonymousObservableList, paramAnonymousListChanges.start, paramAnonymousListChanges.count);
        }
      }
      else {
        paramAnonymousOnListChangedCallback.onItemRangeChanged(paramAnonymousObservableList, paramAnonymousListChanges.start, paramAnonymousListChanges.count);
      }
    }
  };
  private static final int REMOVED = 4;
  private static final Pools.SynchronizedPool<ListChanges> sListChanges = new Pools.SynchronizedPool(10);
  
  public ListChangeRegistry()
  {
    super(NOTIFIER_CALLBACK);
  }
  
  private static ListChanges acquire(int paramInt1, int paramInt2, int paramInt3)
  {
    ListChanges localListChanges1 = (ListChanges)sListChanges.acquire();
    ListChanges localListChanges2 = localListChanges1;
    if (localListChanges1 == null) {
      localListChanges2 = new ListChanges();
    }
    localListChanges2.start = paramInt1;
    localListChanges2.to = paramInt2;
    localListChanges2.count = paramInt3;
    return localListChanges2;
  }
  
  public void notifyCallbacks(@NonNull ObservableList paramObservableList, int paramInt, ListChanges paramListChanges)
  {
    try
    {
      super.notifyCallbacks(paramObservableList, paramInt, paramListChanges);
      if (paramListChanges != null) {
        sListChanges.release(paramListChanges);
      }
      return;
    }
    finally {}
  }
  
  public void notifyChanged(@NonNull ObservableList paramObservableList)
  {
    notifyCallbacks(paramObservableList, 0, null);
  }
  
  public void notifyChanged(@NonNull ObservableList paramObservableList, int paramInt1, int paramInt2)
  {
    notifyCallbacks(paramObservableList, 1, acquire(paramInt1, 0, paramInt2));
  }
  
  public void notifyInserted(@NonNull ObservableList paramObservableList, int paramInt1, int paramInt2)
  {
    notifyCallbacks(paramObservableList, 2, acquire(paramInt1, 0, paramInt2));
  }
  
  public void notifyMoved(@NonNull ObservableList paramObservableList, int paramInt1, int paramInt2, int paramInt3)
  {
    notifyCallbacks(paramObservableList, 3, acquire(paramInt1, paramInt2, paramInt3));
  }
  
  public void notifyRemoved(@NonNull ObservableList paramObservableList, int paramInt1, int paramInt2)
  {
    notifyCallbacks(paramObservableList, 4, acquire(paramInt1, 0, paramInt2));
  }
  
  static class ListChanges
  {
    public int count;
    public int start;
    public int to;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\ListChangeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */