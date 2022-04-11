package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.dailysummary.viewmodel.SummaryClipListViewModel;

public class ActivitySummaryClipListBindingImpl
  extends ActivitySummaryClipListBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final ConstraintLayout I3;
  private long J3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131363199, 2);
    localSparseIntArray.put(2131362144, 3);
    localSparseIntArray.put(2131363197, 4);
    localSparseIntArray.put(2131363672, 5);
    localSparseIntArray.put(2131363207, 6);
    localSparseIntArray.put(2131363009, 7);
    localSparseIntArray.put(2131363136, 8);
    localSparseIntArray.put(2131363809, 9);
  }
  
  public ActivitySummaryClipListBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, p3, H3));
  }
  
  private ActivitySummaryClipListBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[7], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[8], (ConstraintLayout)paramArrayOfObject[4], (ConstraintLayout)paramArrayOfObject[2], (LinearLayout)paramArrayOfObject[6], (PlayerView)paramArrayOfObject[5], (RecyclerView)paramArrayOfObject[9]);
    this.f.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.J3;
      this.J3 = 0L;
      SummaryClipListViewModel localSummaryClipListViewModel = this.p2;
      Object localObject1 = null;
      Boolean localBoolean = null;
      boolean bool1 = (l1 & 0x7) < 0L;
      long l2 = l1;
      if (bool1)
      {
        if (localSummaryClipListViewModel != null) {
          localObject1 = localSummaryClipListViewModel.u();
        } else {
          localObject1 = null;
        }
        updateLiveDataRegistration(0, (LiveData)localObject1);
        if (localObject1 != null) {
          localBoolean = (Boolean)((LiveData)localObject1).getValue();
        }
        boolean bool2 = ViewDataBinding.safeUnbox(localBoolean);
        l2 = l1;
        if (bool1)
        {
          if (bool2) {
            l2 = 16L;
          } else {
            l2 = 8L;
          }
          l2 = l1 | l2;
        }
        int i;
        if (bool2)
        {
          localObject1 = this.f.getContext();
          i = 2131231585;
        }
        else
        {
          localObject1 = this.f.getContext();
          i = 2131231581;
        }
        localObject1 = AppCompatResources.getDrawable((Context)localObject1, i);
      }
      if ((l2 & 0x7) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.f, (Drawable)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SummaryClipListViewModel paramSummaryClipListViewModel)
  {
    this.p2 = paramSummaryClipListViewModel;
    try
    {
      this.J3 |= 0x2;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.J3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.J3 = 4L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return i((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((SummaryClipListViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySummaryClipListBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */