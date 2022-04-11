package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentTaskHubControlBindingImpl
  extends FragmentTaskHubControlBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final FrameLayout K3;
  private long L3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    J3 = localSparseIntArray;
    localSparseIntArray.put(2131363936, 1);
    localSparseIntArray.put(2131363256, 2);
    localSparseIntArray.put(2131362305, 3);
    localSparseIntArray.put(2131364336, 4);
    localSparseIntArray.put(2131361972, 5);
    localSparseIntArray.put(2131362306, 6);
    localSparseIntArray.put(2131364337, 7);
    localSparseIntArray.put(2131361973, 8);
    localSparseIntArray.put(2131362304, 9);
    localSparseIntArray.put(2131364335, 10);
    localSparseIntArray.put(2131361971, 11);
    localSparseIntArray.put(2131362690, 12);
  }
  
  public FragmentTaskHubControlBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 13, I3, J3));
  }
  
  private FragmentTaskHubControlBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[11], (ImageView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[8], (RelativeLayout)paramArrayOfObject[9], (RelativeLayout)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[6], (FrameLayout)paramArrayOfObject[12], (LinearLayout)paramArrayOfObject[2], (RecyclerView)paramArrayOfObject[1], (TextView)paramArrayOfObject[10], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[7]);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.L3 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.L3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.L3 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentTaskHubControlBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */