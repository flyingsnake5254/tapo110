package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentLightStripLightEffectsBindingImpl
  extends FragmentLightStripLightEffectsBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final NestedScrollView p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131364378, 1);
    localSparseIntArray.put(2131363931, 2);
    localSparseIntArray.put(2131364374, 3);
    localSparseIntArray.put(2131363930, 4);
    localSparseIntArray.put(2131363934, 5);
    localSparseIntArray.put(2131363945, 6);
  }
  
  public FragmentLightStripLightEffectsBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, z, p0));
  }
  
  private FragmentLightStripLightEffectsBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (RecyclerView)paramArrayOfObject[4], (RecyclerView)paramArrayOfObject[2], (RecyclerView)paramArrayOfObject[5], (RecyclerView)paramArrayOfObject[6], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[1]);
    paramDataBindingComponent = (NestedScrollView)paramArrayOfObject[0];
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentLightStripLightEffectsBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */