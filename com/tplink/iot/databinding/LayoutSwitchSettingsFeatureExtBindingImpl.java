package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.iot.devices.switches.viewmodel.SwitchSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

public class LayoutSwitchSettingsFeatureExtBindingImpl
  extends LayoutSwitchSettingsFeatureExtBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final LinearLayout p0;
  private long p1 = -1L;
  
  public LayoutSwitchSettingsFeatureExtBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, y, z));
  }
  
  private LayoutSwitchSettingsFeatureExtBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (ItemSettingLayout)paramArrayOfObject[2], (ItemSettingLayout)paramArrayOfObject[3], (ItemSettingLayout)paramArrayOfObject[1]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean h(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean i(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 0x2;
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
      long l1 = this.p1;
      this.p1 = 0L;
      float f1 = 0.0F;
      Object localObject1 = this.x;
      View.OnClickListener localOnClickListener = this.q;
      boolean bool1 = false;
      Object localObject2 = null;
      Boolean localBoolean = null;
      float f2 = f1;
      long l2 = l1;
      boolean bool2 = bool1;
      if ((0x17 & l1) != 0L)
      {
        if ((l1 & 0x15) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((SwitchSettingsViewModel)localObject1).D();
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((LiveData)localObject2).getValue();
            break label114;
          }
        }
        localObject2 = null;
        label114:
        boolean bool3 = (l1 & 0x16) < 0L;
        if (bool3)
        {
          if (localObject1 != null) {
            localObject1 = ((IoTSettingsBaseViewModel)localObject1).x();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localBoolean = (Boolean)((LiveData)localObject1).getValue();
          }
          bool2 = ViewDataBinding.safeUnbox(localBoolean);
          l2 = l1;
          if (bool3)
          {
            if (bool2) {
              l2 = 64L;
            } else {
              l2 = 32L;
            }
            l2 = l1 | l2;
          }
          if (bool2) {
            f2 = 0.5F;
          } else {
            f2 = 1.0F;
          }
          bool2 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2 ^ true));
        }
        else
        {
          bool2 = bool1;
          l2 = l1;
          f2 = f1;
        }
      }
      if ((l2 & 0x16) != 0L)
      {
        this.c.setEnabled(bool2);
        this.d.setEnabled(bool2);
        this.f.setEnabled(bool2);
        if (ViewDataBinding.getBuildSdkInt() >= 11)
        {
          this.c.setAlpha(f2);
          this.d.setAlpha(f2);
          this.f.setAlpha(f2);
        }
      }
      if ((0x18 & l2) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x15) != 0L) {
        a.f(this.d, (String)localObject2);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p1 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p1 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.q = paramOnClickListener;
    try
    {
      this.p1 |= 0x8;
      notifyPropertyChanged(69);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable SwitchSettingsViewModel paramSwitchSettingsViewModel)
  {
    this.x = paramSwitchSettingsViewModel;
    try
    {
      this.p1 |= 0x4;
      notifyPropertyChanged(89);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return false;
      }
      return i((LiveData)paramObject, paramInt2);
    }
    return h((LiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (89 == paramInt)
    {
      m((SwitchSettingsViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      l((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutSwitchSettingsFeatureExtBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */