package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<VH>
{
  final AsyncListDiffer<T> mDiffer;
  private final AsyncListDiffer.ListListener<T> mListener;
  
  protected ListAdapter(@NonNull AsyncDifferConfig<T> paramAsyncDifferConfig)
  {
    AsyncListDiffer.ListListener local1 = new AsyncListDiffer.ListListener()
    {
      public void onCurrentListChanged(@NonNull List<T> paramAnonymousList1, @NonNull List<T> paramAnonymousList2)
      {
        ListAdapter.this.onCurrentListChanged(paramAnonymousList1, paramAnonymousList2);
      }
    };
    this.mListener = local1;
    paramAsyncDifferConfig = new AsyncListDiffer(new AdapterListUpdateCallback(this), paramAsyncDifferConfig);
    this.mDiffer = paramAsyncDifferConfig;
    paramAsyncDifferConfig.addListListener(local1);
  }
  
  protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    AsyncListDiffer.ListListener local1 = new AsyncListDiffer.ListListener()
    {
      public void onCurrentListChanged(@NonNull List<T> paramAnonymousList1, @NonNull List<T> paramAnonymousList2)
      {
        ListAdapter.this.onCurrentListChanged(paramAnonymousList1, paramAnonymousList2);
      }
    };
    this.mListener = local1;
    paramItemCallback = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(paramItemCallback).build());
    this.mDiffer = paramItemCallback;
    paramItemCallback.addListListener(local1);
  }
  
  @NonNull
  public List<T> getCurrentList()
  {
    return this.mDiffer.getCurrentList();
  }
  
  protected T getItem(int paramInt)
  {
    return (T)this.mDiffer.getCurrentList().get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mDiffer.getCurrentList().size();
  }
  
  public void onCurrentListChanged(@NonNull List<T> paramList1, @NonNull List<T> paramList2) {}
  
  public void submitList(@Nullable List<T> paramList)
  {
    this.mDiffer.submitList(paramList);
  }
  
  public void submitList(@Nullable List<T> paramList, @Nullable Runnable paramRunnable)
  {
    this.mDiffer.submitList(paramList, paramRunnable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\ListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */