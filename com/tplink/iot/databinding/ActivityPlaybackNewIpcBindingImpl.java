package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;

public class ActivityPlaybackNewIpcBindingImpl
  extends ActivityPlaybackNewIpcBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts x;
  @Nullable
  private static final SparseIntArray y;
  private long z = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    y = localSparseIntArray;
    localSparseIntArray.put(2131364248, 1);
    localSparseIntArray.put(2131364767, 2);
    localSparseIntArray.put(2131362333, 3);
  }
  
  public ActivityPlaybackNewIpcBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, x, y));
  }
  
  private ActivityPlaybackNewIpcBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (FrameLayout)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[0], (TipsBar)paramArrayOfObject[1], (FrameLayout)paramArrayOfObject[2]);
    this.d.setTag(null);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPlaybackNewIpcBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */