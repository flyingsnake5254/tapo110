package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.view.iotplug.energymonitor.chart.PowerLineChart;

public class ActivityPlugPowerStatisticBindingImpl
  extends ActivityPlugPowerStatisticBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final LinearLayout p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131363642, 1);
    localSparseIntArray.put(2131363627, 2);
    localSparseIntArray.put(2131363639, 3);
    localSparseIntArray.put(2131364581, 4);
    localSparseIntArray.put(2131364670, 5);
    localSparseIntArray.put(2131363636, 6);
  }
  
  public ActivityPlugPowerStatisticBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, z, p0));
  }
  
  private ActivityPlugPowerStatisticBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (LinearLayout)paramArrayOfObject[2], (PowerLineChart)paramArrayOfObject[6], (CardView)paramArrayOfObject[3], (TabLayout)paramArrayOfObject[1], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.p2 = 0L;
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
      this.p2 = 1L;
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
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPlugPowerStatisticBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */