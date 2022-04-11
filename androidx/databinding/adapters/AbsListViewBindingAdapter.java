package androidx.databinding.adapters;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:listSelector", method="setSelector", type=AbsListView.class), @androidx.databinding.BindingMethod(attribute="android:scrollingCache", method="setScrollingCacheEnabled", type=AbsListView.class), @androidx.databinding.BindingMethod(attribute="android:smoothScrollbar", method="setSmoothScrollbarEnabled", type=AbsListView.class), @androidx.databinding.BindingMethod(attribute="android:onMovedToScrapHeap", method="setRecyclerListener", type=AbsListView.class)})
public class AbsListViewBindingAdapter
{
  @BindingAdapter(requireAll=false, value={"android:onScroll", "android:onScrollStateChanged"})
  public static void setOnScroll(AbsListView paramAbsListView, final OnScroll paramOnScroll, OnScrollStateChanged paramOnScrollStateChanged)
  {
    paramAbsListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AbsListViewBindingAdapter.OnScroll localOnScroll = paramOnScroll;
        if (localOnScroll != null) {
          localOnScroll.onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AbsListViewBindingAdapter.OnScrollStateChanged localOnScrollStateChanged = this.val$scrollStateListener;
        if (localOnScrollStateChanged != null) {
          localOnScrollStateChanged.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
        }
      }
    });
  }
  
  public static abstract interface OnScroll
  {
    public abstract void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static abstract interface OnScrollStateChanged
  {
    public abstract void onScrollStateChanged(AbsListView paramAbsListView, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\AbsListViewBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */