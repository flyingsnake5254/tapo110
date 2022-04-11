package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripDetailViewModel;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.viewgroup.MultiFeaturesGridView;

public class LayoutLightStripDetailBottomExtBindingImpl
  extends LayoutLightStripDetailBottomExtBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final LinearLayout p0;
  private long p1 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    z = localSparseIntArray;
    localSparseIntArray.put(2131363507, 1);
    localSparseIntArray.put(2131364208, 2);
    localSparseIntArray.put(2131364209, 3);
  }
  
  public LayoutLightStripDetailBottomExtBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, y, z));
  }
  
  private LayoutLightStripDetailBottomExtBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (MultiFeaturesGridView)paramArrayOfObject[1], (ThingNextEventView)paramArrayOfObject[2], (ThingUsageView)paramArrayOfObject[3]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.p1 = 0L;
      return;
    }
    finally {}
  }
  
  public void h(@Nullable LightStripDetailViewModel paramLightStripDetailViewModel)
  {
    this.x = paramLightStripDetailViewModel;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p1 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.q = paramOnClickListener;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p1 = 4L;
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
    if (15 == paramInt)
    {
      h((LightStripDetailViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      i((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripDetailBottomExtBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */