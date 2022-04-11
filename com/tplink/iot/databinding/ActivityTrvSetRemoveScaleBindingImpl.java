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
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

public class ActivityTrvSetRemoveScaleBindingImpl
  extends ActivityTrvSetRemoveScaleBinding
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
    localSparseIntArray.put(2131363907, 1);
    localSparseIntArray.put(2131364688, 2);
    localSparseIntArray.put(2131364126, 3);
    localSparseIntArray.put(2131364674, 4);
    localSparseIntArray.put(2131363327, 5);
    localSparseIntArray.put(2131362478, 6);
    localSparseIntArray.put(2131363328, 7);
    localSparseIntArray.put(2131362244, 8);
    localSparseIntArray.put(2131364600, 9);
  }
  
  public ActivityTrvSetRemoveScaleBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, p2, p3));
  }
  
  private ActivityTrvSetRemoveScaleBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (TPCircleProgressBar)paramArrayOfObject[8], (View)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[5], (LinearLayout)paramArrayOfObject[7], (RelativeLayout)paramArrayOfObject[1], (TPSwitchCompat)paramArrayOfObject[3], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[2]);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetRemoveScaleBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */