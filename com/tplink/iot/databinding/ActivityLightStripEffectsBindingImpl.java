package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class ActivityLightStripEffectsBindingImpl
  extends ActivityLightStripEffectsBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts d;
  @Nullable
  private static final SparseIntArray f;
  @NonNull
  private final LinearLayout q;
  private long x = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    f = localSparseIntArray;
    localSparseIntArray.put(2131362690, 1);
  }
  
  public ActivityLightStripEffectsBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 2, d, f));
  }
  
  private ActivityLightStripEffectsBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (FrameLayout)paramArrayOfObject[1]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.q = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.x = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.x != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.x = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightStripEffectsBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */