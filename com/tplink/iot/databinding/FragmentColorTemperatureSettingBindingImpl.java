package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.colorbulb.ColorTempWrapView;

public class FragmentColorTemperatureSettingBindingImpl
  extends FragmentColorTemperatureSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts f;
  @Nullable
  private static final SparseIntArray q;
  @NonNull
  private final NestedScrollView x;
  private long y = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    q = localSparseIntArray;
    localSparseIntArray.put(2131362294, 1);
    localSparseIntArray.put(2131362027, 2);
  }
  
  public FragmentColorTemperatureSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, f, q));
  }
  
  private FragmentColorTemperatureSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (BrightnessSeekBar)paramArrayOfObject[2], (ColorTempWrapView)paramArrayOfObject[1]);
    paramDataBindingComponent = (NestedScrollView)paramArrayOfObject[0];
    this.x = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.y = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.y != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.y = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentColorTemperatureSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */