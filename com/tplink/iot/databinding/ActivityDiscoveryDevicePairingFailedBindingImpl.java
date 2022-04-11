package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class ActivityDiscoveryDevicePairingFailedBindingImpl
  extends ActivityDiscoveryDevicePairingFailedBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts q;
  @Nullable
  private static final SparseIntArray x;
  @NonNull
  private final LinearLayout y;
  private long z = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    x = localSparseIntArray;
    localSparseIntArray.put(2131362831, 1);
    localSparseIntArray.put(2131363277, 2);
    localSparseIntArray.put(2131362037, 3);
  }
  
  public ActivityDiscoveryDevicePairingFailedBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, q, x));
  }
  
  private ActivityDiscoveryDevicePairingFailedBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[3], (ImageView)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[2]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.y = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.z = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.z != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.z = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDiscoveryDevicePairingFailedBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */