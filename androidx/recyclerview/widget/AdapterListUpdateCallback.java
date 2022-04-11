package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

public final class AdapterListUpdateCallback
  implements ListUpdateCallback
{
  @NonNull
  private final RecyclerView.Adapter mAdapter;
  
  public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter paramAdapter)
  {
    this.mAdapter = paramAdapter;
  }
  
  public void onChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.mAdapter.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }
  
  public void onInserted(int paramInt1, int paramInt2)
  {
    this.mAdapter.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void onMoved(int paramInt1, int paramInt2)
  {
    this.mAdapter.notifyItemMoved(paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2)
  {
    this.mAdapter.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\AdapterListUpdateCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */