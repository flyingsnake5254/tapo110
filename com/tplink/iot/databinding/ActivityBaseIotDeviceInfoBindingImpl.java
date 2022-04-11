package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.widget.ItemSettingLayout;

public class ActivityBaseIotDeviceInfoBindingImpl
  extends ActivityBaseIotDeviceInfoBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final LinearLayout H3;
  private long I3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131362974, 1);
    localSparseIntArray.put(2131362982, 2);
    localSparseIntArray.put(2131362990, 3);
    localSparseIntArray.put(2131362934, 4);
    localSparseIntArray.put(2131362927, 5);
    localSparseIntArray.put(2131362931, 6);
    localSparseIntArray.put(2131362459, 7);
    localSparseIntArray.put(2131362921, 8);
    localSparseIntArray.put(2131362917, 9);
  }
  
  public ActivityBaseIotDeviceInfoBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, p2, p3));
  }
  
  private ActivityBaseIotDeviceInfoBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (View)paramArrayOfObject[7], (ItemSettingLayout)paramArrayOfObject[9], (ItemSettingLayout)paramArrayOfObject[8], (ItemSettingLayout)paramArrayOfObject[5], (ItemSettingLayout)paramArrayOfObject[6], (ItemSettingLayout)paramArrayOfObject[4], (ImageView)paramArrayOfObject[1], (ItemSettingLayout)paramArrayOfObject[2], (ItemSettingLayout)paramArrayOfObject[3]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.I3 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityBaseIotDeviceInfoBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */