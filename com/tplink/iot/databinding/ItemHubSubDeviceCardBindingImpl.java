package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.iot.widget.trv.MarqueeTextView;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

public class ItemHubSubDeviceCardBindingImpl
  extends ItemHubSubDeviceCardBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts L3;
  @Nullable
  private static final SparseIntArray M3;
  private long N3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    M3 = localSparseIntArray;
    localSparseIntArray.put(2131364409, 1);
    localSparseIntArray.put(2131364408, 2);
    localSparseIntArray.put(2131363882, 3);
    localSparseIntArray.put(2131363027, 4);
    localSparseIntArray.put(2131363123, 5);
    localSparseIntArray.put(2131364561, 6);
    localSparseIntArray.put(2131363888, 7);
    localSparseIntArray.put(2131364700, 8);
    localSparseIntArray.put(2131364522, 9);
    localSparseIntArray.put(2131364704, 10);
    localSparseIntArray.put(2131364702, 11);
    localSparseIntArray.put(2131363898, 12);
    localSparseIntArray.put(2131362213, 13);
    localSparseIntArray.put(2131363033, 14);
  }
  
  public ItemHubSubDeviceCardBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 15, L3, M3));
  }
  
  private ItemHubSubDeviceCardBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (RippleCardView)paramArrayOfObject[0], (TPCheckboxCompat)paramArrayOfObject[13], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[14], (ImageView)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[7], (RelativeLayout)paramArrayOfObject[12], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[8], (MarqueeTextView)paramArrayOfObject[11], (MarqueeTextView)paramArrayOfObject[10]);
    this.c.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.N3 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.N3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.N3 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemHubSubDeviceCardBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */