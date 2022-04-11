package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

public class ActivityBaseIotDeviceSettingsBindingImpl
  extends ActivityBaseIotDeviceSettingsBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts N3;
  @Nullable
  private static final SparseIntArray O3;
  @NonNull
  private final LinearLayout P3;
  private long Q3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    O3 = localSparseIntArray;
    localSparseIntArray.put(2131363277, 8);
    localSparseIntArray.put(2131362925, 9);
    localSparseIntArray.put(2131363863, 10);
    localSparseIntArray.put(2131362628, 11);
    localSparseIntArray.put(2131362662, 12);
    localSparseIntArray.put(2131363865, 13);
    localSparseIntArray.put(2131363608, 14);
    localSparseIntArray.put(2131362671, 15);
  }
  
  public ActivityBaseIotDeviceSettingsBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 16, N3, O3));
  }
  
  private ActivityBaseIotDeviceSettingsBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 6, (Button)paramArrayOfObject[7], (View)paramArrayOfObject[11], (FrameLayout)paramArrayOfObject[12], (FrameLayout)paramArrayOfObject[15], (ConstraintLayout)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[5], (ItemSettingLayout)paramArrayOfObject[6], (TextView)paramArrayOfObject[9], (ItemSettingLayout)paramArrayOfObject[4], (ItemSettingLayout)paramArrayOfObject[3], (LinearLayout)paramArrayOfObject[8], (View)paramArrayOfObject[14], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[10], (ImageView)paramArrayOfObject[13]);
    this.c.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.P3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.I3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<Integer> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Q3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Q3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Q3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Q3 |= 0x4;
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
        this.Q3 |= 1L;
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
        this.Q3 |= 0x10;
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
      long l1 = this.Q3;
      this.Q3 = 0L;
      Object localObject1 = this.M3;
      View.OnClickListener localOnClickListener = this.L3;
      Boolean localBoolean = null;
      Object localObject2;
      label93:
      Object localObject4;
      int i;
      boolean bool1;
      label284:
      Object localObject5;
      label339:
      boolean bool3;
      long l2;
      float f;
      if ((0x17F & l1) != 0L)
      {
        if ((l1 & 0x141) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((IoTSettingsBaseViewModel)localObject1).t();
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((LiveData)localObject2).getValue();
            break label93;
          }
        }
        localObject2 = null;
        if ((l1 & 0x142) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((IoTSettingsBaseViewModel)localObject1).k();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject4);
          if (localObject4 != null) {
            localObject4 = (Integer)((LiveData)localObject4).getValue();
          } else {
            localObject4 = null;
          }
          i = ViewDataBinding.safeUnbox((Integer)localObject4);
        }
        else
        {
          i = 0;
        }
        if ((l1 & 0x144) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((IoTSettingsBaseViewModel)localObject1).y();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject4);
          if (localObject4 != null) {
            localObject4 = (Boolean)((LiveData)localObject4).getValue();
          } else {
            localObject4 = null;
          }
          bool1 = ViewDataBinding.safeUnbox((Boolean)localObject4);
        }
        else
        {
          bool1 = false;
        }
        if ((l1 & 0x148) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((IoTSettingsBaseViewModel)localObject1).r();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((LiveData)localObject4).getValue();
            break label284;
          }
        }
        localObject4 = null;
        if ((l1 & 0x150) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((IoTSettingsBaseViewModel)localObject1).u();
          } else {
            localObject5 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((LiveData)localObject5).getValue();
            break label339;
          }
        }
        localObject5 = null;
        boolean bool2 = (l1 & 0x160) < 0L;
        if (bool2)
        {
          if (localObject1 != null) {
            localObject1 = ((IoTSettingsBaseViewModel)localObject1).x();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject1);
          if (localObject1 != null) {
            localBoolean = (Boolean)((LiveData)localObject1).getValue();
          }
          bool3 = ViewDataBinding.safeUnbox(localBoolean);
          l2 = l1;
          if (bool2)
          {
            if (bool3) {
              l2 = 1024L;
            } else {
              l2 = 512L;
            }
            l2 = l1 | l2;
          }
          if (bool3) {
            f = 0.5F;
          } else {
            f = 1.0F;
          }
          bool3 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool3 ^ true));
        }
        else
        {
          f = 0.0F;
          bool3 = false;
          l2 = l1;
        }
      }
      else
      {
        localObject5 = null;
        localObject2 = localObject5;
        localObject4 = localObject2;
        f = 0.0F;
        bool3 = false;
        i = 0;
        bool1 = false;
        l2 = l1;
      }
      if ((l2 & 0x180) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
        this.p2.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x160) != 0L)
      {
        this.x.setEnabled(bool3);
        this.z.setEnabled(bool3);
        this.p1.setEnabled(bool3);
        this.p2.setEnabled(bool3);
        if (ViewDataBinding.getBuildSdkInt() >= 11)
        {
          this.x.setAlpha(f);
          this.z.setAlpha(f);
          this.p1.setAlpha(f);
          this.p2.setAlpha(f);
        }
      }
      if ((0x144 & l2) != 0L) {
        a.h(this.z, bool1);
      }
      if ((l2 & 0x148) != 0L) {
        a.f(this.z, (String)localObject4);
      }
      if ((0x150 & l2) != 0L) {
        a.f(this.p1, (String)localObject5);
      }
      if ((l2 & 0x141) != 0L) {
        a.f(this.p2, (String)localObject2);
      }
      if ((l2 & 0x142) != 0L) {
        this.I3.setImageResource(i);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.L3 = paramOnClickListener;
    try
    {
      this.Q3 |= 0x80;
      notifyPropertyChanged(69);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.Q3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable IoTSettingsBaseViewModel paramIoTSettingsBaseViewModel)
  {
    this.M3 = paramIoTSettingsBaseViewModel;
    try
    {
      this.Q3 |= 0x40;
      notifyPropertyChanged(89);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.Q3 = 256L;
      requestRebind();
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
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if (paramInt1 != 5) {
                return false;
              }
              return n((LiveData)paramObject, paramInt2);
            }
            return q((LiveData)paramObject, paramInt2);
          }
          return m((LiveData)paramObject, paramInt2);
        }
        return o((LiveData)paramObject, paramInt2);
      }
      return l((LiveData)paramObject, paramInt2);
    }
    return p((LiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (89 == paramInt)
    {
      i((IoTSettingsBaseViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      h((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityBaseIotDeviceSettingsBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */