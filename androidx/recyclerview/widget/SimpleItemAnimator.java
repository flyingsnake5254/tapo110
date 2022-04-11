package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class SimpleItemAnimator
  extends RecyclerView.ItemAnimator
{
  private static final boolean DEBUG = false;
  private static final String TAG = "SimpleItemAnimator";
  boolean mSupportsChangeAnimations = true;
  
  public abstract boolean animateAdd(RecyclerView.ViewHolder paramViewHolder);
  
  public boolean animateAppearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    if (paramItemHolderInfo1 != null)
    {
      int i = paramItemHolderInfo1.left;
      int j = paramItemHolderInfo2.left;
      if ((i != j) || (paramItemHolderInfo1.top != paramItemHolderInfo2.top)) {
        return animateMove(paramViewHolder, i, paramItemHolderInfo1.top, j, paramItemHolderInfo2.top);
      }
    }
    return animateAdd(paramViewHolder);
  }
  
  public abstract boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean animateChange(@NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    int i = paramItemHolderInfo1.left;
    int j = paramItemHolderInfo1.top;
    int k;
    int m;
    if (paramViewHolder2.shouldIgnore())
    {
      k = paramItemHolderInfo1.left;
      m = paramItemHolderInfo1.top;
    }
    else
    {
      k = paramItemHolderInfo2.left;
      m = paramItemHolderInfo2.top;
    }
    return animateChange(paramViewHolder1, paramViewHolder2, i, j, k, m);
  }
  
  public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    int i = paramItemHolderInfo1.left;
    int j = paramItemHolderInfo1.top;
    paramItemHolderInfo1 = paramViewHolder.itemView;
    int k;
    if (paramItemHolderInfo2 == null) {
      k = paramItemHolderInfo1.getLeft();
    } else {
      k = paramItemHolderInfo2.left;
    }
    int m;
    if (paramItemHolderInfo2 == null) {
      m = paramItemHolderInfo1.getTop();
    } else {
      m = paramItemHolderInfo2.top;
    }
    if ((!paramViewHolder.isRemoved()) && ((i != k) || (j != m)))
    {
      paramItemHolderInfo1.layout(k, m, paramItemHolderInfo1.getWidth() + k, paramItemHolderInfo1.getHeight() + m);
      return animateMove(paramViewHolder, i, j, k, m);
    }
    return animateRemove(paramViewHolder);
  }
  
  public abstract boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean animatePersistence(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    int i = paramItemHolderInfo1.left;
    int j = paramItemHolderInfo2.left;
    if ((i == j) && (paramItemHolderInfo1.top == paramItemHolderInfo2.top))
    {
      dispatchMoveFinished(paramViewHolder);
      return false;
    }
    return animateMove(paramViewHolder, i, paramItemHolderInfo1.top, j, paramItemHolderInfo2.top);
  }
  
  public abstract boolean animateRemove(RecyclerView.ViewHolder paramViewHolder);
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool;
    if ((this.mSupportsChangeAnimations) && (!paramViewHolder.isInvalid())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final void dispatchAddFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    onAddFinished(paramViewHolder);
    dispatchAnimationFinished(paramViewHolder);
  }
  
  public final void dispatchAddStarting(RecyclerView.ViewHolder paramViewHolder)
  {
    onAddStarting(paramViewHolder);
  }
  
  public final void dispatchChangeFinished(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    onChangeFinished(paramViewHolder, paramBoolean);
    dispatchAnimationFinished(paramViewHolder);
  }
  
  public final void dispatchChangeStarting(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    onChangeStarting(paramViewHolder, paramBoolean);
  }
  
  public final void dispatchMoveFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    onMoveFinished(paramViewHolder);
    dispatchAnimationFinished(paramViewHolder);
  }
  
  public final void dispatchMoveStarting(RecyclerView.ViewHolder paramViewHolder)
  {
    onMoveStarting(paramViewHolder);
  }
  
  public final void dispatchRemoveFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    onRemoveFinished(paramViewHolder);
    dispatchAnimationFinished(paramViewHolder);
  }
  
  public final void dispatchRemoveStarting(RecyclerView.ViewHolder paramViewHolder)
  {
    onRemoveStarting(paramViewHolder);
  }
  
  public boolean getSupportsChangeAnimations()
  {
    return this.mSupportsChangeAnimations;
  }
  
  public void onAddFinished(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onAddStarting(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onChangeFinished(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void onChangeStarting(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void onMoveFinished(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onMoveStarting(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onRemoveFinished(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onRemoveStarting(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void setSupportsChangeAnimations(boolean paramBoolean)
  {
    this.mSupportsChangeAnimations = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\SimpleItemAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */