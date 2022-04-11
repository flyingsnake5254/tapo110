package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public class ActivityTrvSetWindowOpenBindingImpl
  extends ActivityTrvSetWindowOpenBinding
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
    localSparseIntArray.put(2131363907, 1);
    localSparseIntArray.put(2131364688, 2);
    localSparseIntArray.put(2131364126, 3);
    localSparseIntArray.put(2131364674, 4);
    localSparseIntArray.put(2131363336, 5);
    localSparseIntArray.put(2131362963, 6);
    localSparseIntArray.put(2131364629, 7);
  }
  
  public ActivityTrvSetWindowOpenBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p0, p1));
  }
  
  private ActivityTrvSetWindowOpenBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ItemSettingLayout)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[1], (TPSwitchCompat)paramArrayOfObject[3], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[2]);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetWindowOpenBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */