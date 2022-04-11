package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class FragmentSwitchReplaceBatteryBindingImpl
  extends FragmentSwitchReplaceBatteryBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts f;
  @Nullable
  private static final SparseIntArray q;
  @NonNull
  private final LinearLayoutCompat x;
  private long y = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    q = localSparseIntArray;
    localSparseIntArray.put(2131362831, 1);
    localSparseIntArray.put(2131363107, 2);
  }
  
  public FragmentSwitchReplaceBatteryBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, f, q));
  }
  
  private FragmentSwitchReplaceBatteryBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[2]);
    paramDataBindingComponent = (LinearLayoutCompat)paramArrayOfObject[0];
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSwitchReplaceBatteryBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */