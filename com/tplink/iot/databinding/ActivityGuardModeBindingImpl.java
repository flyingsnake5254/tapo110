package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;

public class ActivityGuardModeBindingImpl
  extends ActivityGuardModeBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final LinearLayout p1;
  private long p2 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131362923, 1);
    localSparseIntArray.put(2131361978, 2);
    localSparseIntArray.put(2131362890, 3);
    localSparseIntArray.put(2131361974, 4);
    localSparseIntArray.put(2131362965, 5);
    localSparseIntArray.put(2131361982, 6);
  }
  
  public ActivityGuardModeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, z, p0));
  }
  
  private ActivityGuardModeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[6], (RelativeLayout)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[5]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityGuardModeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */