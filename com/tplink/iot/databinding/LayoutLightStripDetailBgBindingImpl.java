package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.devices.lightstrip.widget.LightStripDetailBgView;
import com.tplink.iot.devices.lightstrip.widget.RippleRevealFrameLayout;

public class LayoutLightStripDetailBgBindingImpl
  extends LayoutLightStripDetailBgBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts x;
  @Nullable
  private static final SparseIntArray y;
  private long p0 = -1L;
  @NonNull
  private final FrameLayout z;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    y = localSparseIntArray;
    localSparseIntArray.put(2131362010, 1);
    localSparseIntArray.put(2131362009, 2);
    localSparseIntArray.put(2131363231, 3);
    localSparseIntArray.put(2131363409, 4);
  }
  
  public LayoutLightStripDetailBgBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, x, y));
  }
  
  private LayoutLightStripDetailBgBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (RippleRevealFrameLayout)paramArrayOfObject[2], (View)paramArrayOfObject[1], (LightStripDetailBgView)paramArrayOfObject[3], (View)paramArrayOfObject[4]);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.z = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.p0 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p0 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p0 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripDetailBgBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */