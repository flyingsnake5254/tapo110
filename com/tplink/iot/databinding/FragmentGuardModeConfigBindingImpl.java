package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class FragmentGuardModeConfigBindingImpl
  extends FragmentGuardModeConfigBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts J3;
  @Nullable
  private static final SparseIntArray K3;
  @NonNull
  private final LinearLayout L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    K3 = localSparseIntArray;
    localSparseIntArray.put(2131364401, 1);
    localSparseIntArray.put(2131362311, 2);
    localSparseIntArray.put(2131364699, 3);
    localSparseIntArray.put(2131361981, 4);
    localSparseIntArray.put(2131362305, 5);
    localSparseIntArray.put(2131364336, 6);
    localSparseIntArray.put(2131361972, 7);
    localSparseIntArray.put(2131362306, 8);
    localSparseIntArray.put(2131364337, 9);
    localSparseIntArray.put(2131361973, 10);
    localSparseIntArray.put(2131362304, 11);
    localSparseIntArray.put(2131364335, 12);
    localSparseIntArray.put(2131361971, 13);
  }
  
  public FragmentGuardModeConfigBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 14, J3, K3));
  }
  
  private FragmentGuardModeConfigBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[13], (ImageView)paramArrayOfObject[7], (ImageView)paramArrayOfObject[10], (ImageView)paramArrayOfObject[4], (RelativeLayout)paramArrayOfObject[11], (RelativeLayout)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[8], (RelativeLayout)paramArrayOfObject[2], (TextView)paramArrayOfObject[12], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[3]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.M3 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.M3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.M3 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentGuardModeConfigBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */