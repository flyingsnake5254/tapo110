package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;

public class ActivityWhiteLampConfigBindingImpl
  extends ActivityWhiteLampConfigBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final ConstraintLayout H3;
  private long I3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131363902, 1);
    localSparseIntArray.put(2131363301, 2);
    localSparseIntArray.put(2131362871, 3);
    localSparseIntArray.put(2131362873, 4);
    localSparseIntArray.put(2131362872, 5);
    localSparseIntArray.put(2131362870, 6);
    localSparseIntArray.put(2131362869, 7);
    localSparseIntArray.put(2131362868, 8);
    localSparseIntArray.put(2131363250, 9);
  }
  
  public ActivityWhiteLampConfigBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, p2, p3));
  }
  
  private ActivityWhiteLampConfigBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (SeekBar)paramArrayOfObject[8], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[4], (CameraLoadingView)paramArrayOfObject[9], (LinearLayout)paramArrayOfObject[2], (RelativeLayout)paramArrayOfObject[1]);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.I3 = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 1L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityWhiteLampConfigBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */