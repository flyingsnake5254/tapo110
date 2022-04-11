package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.widget.ItemSettingLayout;

public class ActivityIotDeviceInfoBindingImpl
  extends ActivityIotDeviceInfoBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  @NonNull
  private final LinearLayout p2;
  private long p3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p1 = localSparseIntArray;
    localSparseIntArray.put(2131362982, 1);
    localSparseIntArray.put(2131362990, 2);
    localSparseIntArray.put(2131362934, 3);
    localSparseIntArray.put(2131362927, 4);
    localSparseIntArray.put(2131362931, 5);
    localSparseIntArray.put(2131362921, 6);
    localSparseIntArray.put(2131362917, 7);
  }
  
  public ActivityIotDeviceInfoBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p0, p1));
  }
  
  private ActivityIotDeviceInfoBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ItemSettingLayout)paramArrayOfObject[7], (ItemSettingLayout)paramArrayOfObject[6], (ItemSettingLayout)paramArrayOfObject[4], (ItemSettingLayout)paramArrayOfObject[5], (ItemSettingLayout)paramArrayOfObject[3], (ItemSettingLayout)paramArrayOfObject[1], (ItemSettingLayout)paramArrayOfObject[2]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.p3 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityIotDeviceInfoBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */