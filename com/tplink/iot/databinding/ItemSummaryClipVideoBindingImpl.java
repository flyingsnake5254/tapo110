package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.dailysummary.model.SummaryClipItem;

public class ItemSummaryClipVideoBindingImpl
  extends ItemSummaryClipVideoBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final ConstraintLayout p0;
  @NonNull
  private final View p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    z = localSparseIntArray;
    localSparseIntArray.put(2131363091, 5);
  }
  
  public ItemSummaryClipVideoBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, y, z));
  }
  
  private ItemSummaryClipVideoBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[1], (TextView)paramArrayOfObject[4]);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[2];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p2;
      this.p2 = 0L;
      boolean bool1 = false;
      SummaryClipItem localSummaryClipItem = this.x;
      Object localObject1 = null;
      boolean bool2 = (l & 0x3) < 0L;
      boolean bool3 = bool1;
      Object localObject2 = localObject1;
      if (bool2)
      {
        bool3 = bool1;
        localObject2 = localObject1;
        if (localSummaryClipItem != null)
        {
          bool3 = localSummaryClipItem.getChoosed();
          localObject2 = localSummaryClipItem.getDurationString();
        }
      }
      if (bool2)
      {
        com.tplink.iot.Utils.extension.a.h(this.d, bool3);
        com.tplink.iot.dailysummary.view.adapter.a.a(this.f, localSummaryClipItem);
        com.tplink.iot.Utils.extension.a.h(this.p1, bool3);
        TextViewBindingAdapter.setText(this.q, (CharSequence)localObject2);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SummaryClipItem paramSummaryClipItem)
  {
    this.x = paramSummaryClipItem;
    try
    {
      this.p2 |= 1L;
      notifyPropertyChanged(10);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p2 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 2L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (10 == paramInt)
    {
      h((SummaryClipItem)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemSummaryClipVideoBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */