package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public class LayoutLightStripSettingsFeatureExtBindingImpl
  extends LayoutLightStripSettingsFeatureExtBinding
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
    localSparseIntArray.put(2131362926, 5);
  }
  
  public LayoutLightStripSettingsFeatureExtBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p0, p1));
  }
  
  private LayoutLightStripSettingsFeatureExtBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (ItemSettingLayout)paramArrayOfObject[1], (TextView)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[2], (ItemInfoLayout)paramArrayOfObject[4], (TPSwitchCompat)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean h(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 0x2;
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
        this.p3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(LiveData<Boolean> paramLiveData, int paramInt)
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
      long l1 = this.p3;
      this.p3 = 0L;
      LightStripSettingsViewModel localLightStripSettingsViewModel = this.z;
      View.OnClickListener localOnClickListener = this.y;
      boolean bool1;
      boolean bool2;
      boolean bool4;
      float f;
      if ((0x2F & l1) != 0L)
      {
        Boolean localBoolean = null;
        Object localObject1;
        if ((l1 & 0x29) != 0L)
        {
          if (localLightStripSettingsViewModel != null) {
            localObject1 = localLightStripSettingsViewModel.G();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool1 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool1 = false;
        }
        if ((l1 & 0x2A) != 0L)
        {
          if (localLightStripSettingsViewModel != null) {
            localObject1 = localLightStripSettingsViewModel.F();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool2 = false;
        }
        boolean bool3 = (l1 & 0x2C) < 0L;
        if (bool3)
        {
          if (localLightStripSettingsViewModel != null) {
            localObject1 = localLightStripSettingsViewModel.x();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject1);
          if (localObject1 != null) {
            localBoolean = (Boolean)((LiveData)localObject1).getValue();
          }
          bool4 = ViewDataBinding.safeUnbox(localBoolean);
          long l2 = l1;
          if (bool3)
          {
            if (bool4) {
              l2 = 128L;
            } else {
              l2 = 64L;
            }
            l2 = l1 | l2;
          }
          if (bool4) {
            f = 0.5F;
          } else {
            f = 1.0F;
          }
          boolean bool5 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool4 ^ true));
          l1 = l2;
          bool4 = bool2;
          bool2 = bool5;
        }
        else
        {
          f = 0.0F;
          bool4 = bool2;
          bool2 = false;
        }
      }
      else
      {
        bool2 = false;
        bool4 = false;
        bool1 = false;
        f = 0.0F;
      }
      if ((l1 & 0x2C) != 0L)
      {
        this.c.setEnabled(bool2);
        this.f.setEnabled(bool2);
        this.q.setEnabled(bool2);
        this.x.setEnabled(bool2);
        if (ViewDataBinding.getBuildSdkInt() >= 11)
        {
          this.c.setAlpha(f);
          this.f.setAlpha(f);
          this.q.setAlpha(f);
          this.x.setAlpha(f);
        }
      }
      if ((l1 & 0x30) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
      }
      if ((l1 & 0x29) != 0L) {
        a.h(this.f, bool1);
      }
      if ((l1 & 0x2A) != 0L) {
        a.g(this.x, bool4);
      }
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
      this.p3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.y = paramOnClickListener;
    try
    {
      this.p3 |= 0x10;
      notifyPropertyChanged(69);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable LightStripSettingsViewModel paramLightStripSettingsViewModel)
  {
    this.z = paramLightStripSettingsViewModel;
    try
    {
      this.p3 |= 0x8;
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
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return false;
        }
        return i((LiveData)paramObject, paramInt2);
      }
      return h((LiveData)paramObject, paramInt2);
    }
    return l((LiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (89 == paramInt)
    {
      n((LightStripSettingsViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      m((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripSettingsFeatureExtBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */