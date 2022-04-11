package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
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
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;

public class LayoutTrvSettingsFeatureExtBindingImpl
  extends LayoutTrvSettingsFeatureExtBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts H3;
  @Nullable
  private static final SparseIntArray I3;
  @NonNull
  private final LinearLayout J3;
  private long K3 = -1L;
  
  public LayoutTrvSettingsFeatureExtBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, H3, I3));
  }
  
  private LayoutTrvSettingsFeatureExtBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 9, (ItemSettingLayout)paramArrayOfObject[2], (ItemSettingLayout)paramArrayOfObject[1], (ItemInfoLayout)paramArrayOfObject[9], (ItemInfoLayout)paramArrayOfObject[7], (ItemSettingLayout)paramArrayOfObject[8], (ItemSettingLayout)paramArrayOfObject[5], (ItemSettingLayout)paramArrayOfObject[4], (ItemSettingLayout)paramArrayOfObject[3], (ItemSettingLayout)paramArrayOfObject[6]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean h(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean i(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x80;
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
        this.K3 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x40;
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
      long l1 = this.K3;
      this.K3 = 0L;
      Object localObject1 = this.p3;
      View.OnClickListener localOnClickListener = this.p2;
      Object localObject2;
      boolean bool2;
      float f1;
      label227:
      Object localObject4;
      Object localObject5;
      label282:
      label337:
      Object localObject6;
      label392:
      Object localObject7;
      String str;
      label447:
      label503:
      Object localObject8;
      label559:
      boolean bool3;
      float f2;
      if ((0xBFF & l1) != 0L)
      {
        boolean bool1 = (l1 & 0xA01) < 0L;
        long l2;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject2 = ((TRVSettingsViewModel)localObject1).k0();
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject2);
          if (localObject2 != null) {
            localObject2 = (Boolean)((LiveData)localObject2).getValue();
          } else {
            localObject2 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject2);
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 8192L;
            } else {
              l2 = 4096L;
            }
            l2 = l1 | l2;
          }
          if (bool2) {
            f1 = 0.5F;
          } else {
            f1 = 1.0F;
          }
          bool2 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2 ^ true));
          l1 = l2;
        }
        else
        {
          bool2 = false;
          f1 = 0.0F;
        }
        if ((l1 & 0xA02) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((TRVSettingsViewModel)localObject1).Z();
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((LiveData)localObject2).getValue();
            break label227;
          }
        }
        localObject2 = null;
        if ((l1 & 0xA04) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((TRVSettingsViewModel)localObject1).Y();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject4);
          if (localObject4 != null)
          {
            localObject5 = (String)((LiveData)localObject4).getValue();
            break label282;
          }
        }
        localObject5 = null;
        if ((l1 & 0xA08) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((TRVSettingsViewModel)localObject1).X();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((LiveData)localObject4).getValue();
            break label337;
          }
        }
        localObject4 = null;
        if ((l1 & 0xA10) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((TRVSettingsViewModel)localObject1).a0();
          } else {
            localObject6 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (String)((LiveData)localObject6).getValue();
            break label392;
          }
        }
        localObject6 = null;
        if ((l1 & 0xA20) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((TRVSettingsViewModel)localObject1).I();
          } else {
            localObject7 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject7);
          if (localObject7 != null)
          {
            str = (String)((LiveData)localObject7).getValue();
            break label447;
          }
        }
        str = null;
        if ((l1 & 0xA40) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((TRVSettingsViewModel)localObject1).e0();
          } else {
            localObject7 = null;
          }
          updateLiveDataRegistration(6, (LiveData)localObject7);
          if (localObject7 != null)
          {
            localObject7 = (String)((LiveData)localObject7).getValue();
            break label503;
          }
        }
        localObject7 = null;
        if ((l1 & 0xA80) != 0L)
        {
          if (localObject1 != null) {
            localObject8 = ((TRVSettingsViewModel)localObject1).N();
          } else {
            localObject8 = null;
          }
          updateLiveDataRegistration(7, (LiveData)localObject8);
          if (localObject8 != null)
          {
            localObject8 = (String)((LiveData)localObject8).getValue();
            break label559;
          }
        }
        localObject8 = null;
        bool1 = (l1 & 0xB00) < 0L;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject1 = ((IoTSettingsBaseViewModel)localObject1).x();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(8, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool3 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l2 = l1;
          if (bool1)
          {
            if (bool3) {
              l2 = 32768L;
            } else {
              l2 = 16384L;
            }
            l2 = l1 | l2;
          }
          if (bool3) {
            f2 = 0.5F;
          } else {
            f2 = 1.0F;
          }
          bool3 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool3 ^ true));
          l1 = l2;
        }
        else
        {
          bool3 = false;
          f2 = 0.0F;
        }
        localObject1 = localObject5;
        localObject5 = localObject2;
        localObject2 = localObject1;
      }
      else
      {
        bool3 = false;
        localObject8 = null;
        localObject2 = null;
        localObject5 = null;
        f1 = 0.0F;
        localObject4 = null;
        localObject6 = null;
        bool2 = false;
        str = null;
        f2 = 0.0F;
        localObject7 = null;
      }
      if ((0xC00 & l1) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p0.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
      }
      if ((l1 & 0xA01) != 0L)
      {
        this.c.setEnabled(bool2);
        this.d.setEnabled(bool2);
        this.f.setEnabled(bool2);
        this.x.setEnabled(bool2);
        this.y.setEnabled(bool2);
        this.p1.setEnabled(bool2);
        if (ViewDataBinding.getBuildSdkInt() >= 11)
        {
          this.c.setAlpha(f1);
          this.d.setAlpha(f1);
          this.f.setAlpha(f1);
          this.x.setAlpha(f1);
          this.y.setAlpha(f1);
          this.p1.setAlpha(f1);
        }
      }
      if ((l1 & 0xA20) != 0L) {
        a.f(this.c, str);
      }
      if ((0xA80 & l1) != 0L) {
        a.f(this.d, (String)localObject8);
      }
      if ((0xB00 & l1) != 0L)
      {
        this.q.setEnabled(bool3);
        this.z.setEnabled(bool3);
        this.p0.setEnabled(bool3);
        if (ViewDataBinding.getBuildSdkInt() >= 11)
        {
          this.q.setAlpha(f2);
          this.z.setAlpha(f2);
          this.p0.setAlpha(f2);
        }
      }
      if ((l1 & 0xA08) != 0L) {
        a.f(this.x, (String)localObject4);
      }
      if ((l1 & 0xA04) != 0L) {
        a.f(this.y, (String)localObject2);
      }
      if ((l1 & 0xA02) != 0L) {
        a.f(this.z, (String)localObject5);
      }
      if ((0xA10 & l1) != 0L) {
        a.f(this.p0, (String)localObject6);
      }
      if ((l1 & 0xA40) != 0L) {
        a.f(this.p1, (String)localObject7);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.K3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.K3 = 2048L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 8: 
      return l((LiveData)paramObject, paramInt2);
    case 7: 
      return i((LiveData)paramObject, paramInt2);
    case 6: 
      return r((LiveData)paramObject, paramInt2);
    case 5: 
      return h((LiveData)paramObject, paramInt2);
    case 4: 
      return q((LiveData)paramObject, paramInt2);
    case 3: 
      return n((LiveData)paramObject, paramInt2);
    case 2: 
      return o((LiveData)paramObject, paramInt2);
    case 1: 
      return p((LiveData)paramObject, paramInt2);
    }
    return m((LiveData)paramObject, paramInt2);
  }
  
  public void s(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p2 = paramOnClickListener;
    try
    {
      this.K3 |= 0x400;
      notifyPropertyChanged(69);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (89 == paramInt)
    {
      t((TRVSettingsViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      s((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
  
  public void t(@Nullable TRVSettingsViewModel paramTRVSettingsViewModel)
  {
    this.p3 = paramTRVSettingsViewModel;
    try
    {
      this.K3 |= 0x200;
      notifyPropertyChanged(89);
      super.requestRebind();
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutTrvSettingsFeatureExtBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */