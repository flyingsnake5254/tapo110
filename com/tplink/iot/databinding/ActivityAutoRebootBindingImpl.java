package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.AutoRebootSettingViewModel;
import com.tplink.iot.widget.NumberPickerView;

public class ActivityAutoRebootBindingImpl
  extends ActivityAutoRebootBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  @NonNull
  private final LinearLayout p2;
  private long p3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p1 = localSparseIntArray;
    localSparseIntArray.put(2131361990, 2);
    localSparseIntArray.put(2131363190, 3);
    localSparseIntArray.put(2131362947, 4);
    localSparseIntArray.put(2131363778, 5);
    localSparseIntArray.put(2131364240, 6);
  }
  
  public ActivityAutoRebootBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p0, p1));
  }
  
  private ActivityAutoRebootBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (CheckBox)paramArrayOfObject[2], (RelativeLayout)paramArrayOfObject[4], (LinearLayout)paramArrayOfObject[3], (CameraLoadingView)paramArrayOfObject[1], (TextView)paramArrayOfObject[5], (NumberPickerView)paramArrayOfObject[6]);
    this.q.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p3;
      this.p3 = 0L;
      ObservableBoolean localObservableBoolean = null;
      AutoRebootSettingViewModel localAutoRebootSettingViewModel = this.z;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = (l & 0x7) < 0L;
      if (bool3)
      {
        if (localAutoRebootSettingViewModel != null) {
          localObservableBoolean = localAutoRebootSettingViewModel.c;
        }
        updateRegistration(0, localObservableBoolean);
        bool1 = bool2;
        if (localObservableBoolean != null) {
          bool1 = localObservableBoolean.get();
        }
        bool1 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool1));
      }
      if (bool3) {
        b.K(this.q, Boolean.valueOf(bool1));
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable AutoRebootSettingViewModel paramAutoRebootSettingViewModel)
  {
    this.z = paramAutoRebootSettingViewModel;
    try
    {
      this.p3 |= 0x2;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 4L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return i((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((AutoRebootSettingViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAutoRebootBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */