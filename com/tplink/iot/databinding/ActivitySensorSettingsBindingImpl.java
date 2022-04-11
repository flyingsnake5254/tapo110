package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.tplink.iot.viewmodel.iotsensor.SensorSettingViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

public class ActivitySensorSettingsBindingImpl
  extends ActivitySensorSettingsBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts N3;
  @Nullable
  private static final SparseIntArray O3;
  @NonNull
  private final LinearLayout P3;
  @NonNull
  private final View Q3;
  private long R3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    O3 = localSparseIntArray;
    localSparseIntArray.put(2131363277, 11);
    localSparseIntArray.put(2131362925, 12);
    localSparseIntArray.put(2131363863, 13);
    localSparseIntArray.put(2131363865, 14);
    localSparseIntArray.put(2131362948, 15);
    localSparseIntArray.put(2131363867, 16);
  }
  
  public ActivitySensorSettingsBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 17, N3, O3));
  }
  
  private ActivitySensorSettingsBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 9, (Button)paramArrayOfObject[10], (ConstraintLayout)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[8], (ItemSettingLayout)paramArrayOfObject[9], (TextView)paramArrayOfObject[12], (ItemSettingLayout)paramArrayOfObject[4], (ItemSettingLayout)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[15], (ItemSettingLayout)paramArrayOfObject[7], (ItemSettingLayout)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[11], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[13], (ImageView)paramArrayOfObject[14], (ImageView)paramArrayOfObject[16]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.P3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[5];
    this.Q3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.H3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<Integer> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 0x10;
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
        this.R3 |= 0x80;
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
        this.R3 |= 0x20;
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
        this.R3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(LiveData<Integer> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean t(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 0x2;
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
      long l1 = this.R3;
      this.R3 = 0L;
      Object localObject1 = this.M3;
      View.OnClickListener localOnClickListener = this.L3;
      Boolean localBoolean = null;
      Object localObject2;
      boolean bool1;
      label90:
      label145:
      Object localObject4;
      boolean bool2;
      label268:
      Object localObject5;
      int i;
      label391:
      Object localObject6;
      label447:
      Object localObject7;
      label503:
      boolean bool4;
      long l2;
      float f;
      if ((0xBFF & l1) != 0L)
      {
        if ((l1 & 0xA01) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((SensorSettingViewModel)localObject1).A();
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null)
          {
            bool1 = ((ObservableBoolean)localObject2).get();
            break label90;
          }
        }
        bool1 = false;
        if ((l1 & 0xA02) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((SensorSettingViewModel)localObject1).x();
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((LiveData)localObject2).getValue();
            break label145;
          }
        }
        localObject2 = null;
        if ((l1 & 0xA04) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((SensorSettingViewModel)localObject1).C();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject4);
          if (localObject4 != null) {
            localObject4 = (Boolean)((LiveData)localObject4).getValue();
          } else {
            localObject4 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject4);
        }
        else
        {
          bool2 = false;
        }
        if ((l1 & 0xA08) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((SensorSettingViewModel)localObject1).u();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((LiveData)localObject4).getValue();
            break label268;
          }
        }
        localObject4 = null;
        if ((l1 & 0xA10) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((SensorSettingViewModel)localObject1).m();
          } else {
            localObject5 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject5);
          if (localObject5 != null) {
            localObject5 = (Integer)((LiveData)localObject5).getValue();
          } else {
            localObject5 = null;
          }
          i = ViewDataBinding.safeUnbox((Integer)localObject5);
        }
        else
        {
          i = 0;
        }
        if ((l1 & 0xA20) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((SensorSettingViewModel)localObject1).o();
          } else {
            localObject5 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((LiveData)localObject5).getValue();
            break label391;
          }
        }
        localObject5 = null;
        if ((l1 & 0xA40) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((SensorSettingViewModel)localObject1).v();
          } else {
            localObject6 = null;
          }
          updateLiveDataRegistration(6, (LiveData)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (Integer)((LiveData)localObject6).getValue();
            break label447;
          }
        }
        localObject6 = null;
        if ((l1 & 0xA80) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((SensorSettingViewModel)localObject1).n();
          } else {
            localObject7 = null;
          }
          updateLiveDataRegistration(7, (LiveData)localObject7);
          if (localObject7 != null)
          {
            localObject7 = (String)((LiveData)localObject7).getValue();
            break label503;
          }
        }
        localObject7 = null;
        boolean bool3 = (l1 & 0xB00) < 0L;
        if (bool3)
        {
          if (localObject1 != null) {
            localObject1 = ((SensorSettingViewModel)localObject1).B();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(8, (LiveData)localObject1);
          if (localObject1 != null) {
            localBoolean = (Boolean)((LiveData)localObject1).getValue();
          }
          bool4 = ViewDataBinding.safeUnbox(localBoolean);
          l2 = l1;
          if (bool3)
          {
            if (bool4) {
              l2 = 8192L;
            } else {
              l2 = 4096L;
            }
            l2 = l1 | l2;
          }
          if (bool4) {
            f = 0.5F;
          } else {
            f = 1.0F;
          }
          bool4 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool4 ^ true));
          localObject1 = localObject7;
          localObject7 = localObject4;
        }
        else
        {
          f = 0.0F;
          bool4 = false;
          l2 = l1;
          localObject1 = localObject7;
          localObject7 = localObject4;
        }
      }
      else
      {
        localBoolean = null;
        localObject2 = localBoolean;
        localObject4 = localObject2;
        localObject5 = localObject4;
        localObject7 = localObject5;
        f = 0.0F;
        bool4 = false;
        bool1 = false;
        bool2 = false;
        i = 0;
        localObject1 = localObject5;
        localObject6 = localObject4;
        localObject5 = localObject2;
        localObject2 = localBoolean;
        l2 = l1;
      }
      if ((l2 & 0xC00) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
        this.p2.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0xB00) != 0L)
      {
        this.d.setEnabled(bool4);
        this.q.setEnabled(bool4);
        this.y.setEnabled(bool4);
        this.z.setEnabled(bool4);
        this.p1.setEnabled(bool4);
        this.p2.setEnabled(bool4);
        if (ViewDataBinding.getBuildSdkInt() >= 11)
        {
          this.d.setAlpha(f);
          this.q.setAlpha(f);
          this.y.setAlpha(f);
          this.z.setAlpha(f);
          this.p1.setAlpha(f);
          this.p2.setAlpha(f);
        }
      }
      if ((l2 & 0xA04) != 0L) {
        com.tplink.iot.Utils.extension.a.h(this.q, bool2);
      }
      if ((l2 & 0xA08) != 0L) {
        com.tplink.iot.Utils.extension.a.f(this.q, (String)localObject7);
      }
      if ((0xA80 & l2) != 0L) {
        com.tplink.iot.Utils.extension.a.f(this.y, (String)localObject1);
      }
      if ((0xA20 & l2) != 0L) {
        com.tplink.iot.Utils.extension.a.f(this.z, (String)localObject5);
      }
      if ((l2 & 0xA01) != 0L)
      {
        com.tplink.iot.Utils.extension.a.h(this.p1, bool1);
        com.tplink.iot.Utils.extension.a.h(this.p2, bool1);
        com.tplink.iot.Utils.extension.a.h(this.Q3, bool1);
      }
      if ((0xA40 & l2) != 0L) {
        com.tplink.iot.view.iotsensor.a.a.a(this.p1, (Integer)localObject6);
      }
      if ((l2 & 0xA02) != 0L) {
        com.tplink.iot.view.iotsensor.a.a.c(this.p2, (String)localObject2);
      }
      if ((l2 & 0xA10) != 0L) {
        this.H3.setImageResource(i);
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
      this.R3 |= 0x400;
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
      return this.R3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable SensorSettingViewModel paramSensorSettingViewModel)
  {
    this.M3 = paramSensorSettingViewModel;
    try
    {
      this.R3 |= 0x200;
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
      this.R3 = 2048L;
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
      return q((LiveData)paramObject, paramInt2);
    case 7: 
      return m((LiveData)paramObject, paramInt2);
    case 6: 
      return s((LiveData)paramObject, paramInt2);
    case 5: 
      return n((LiveData)paramObject, paramInt2);
    case 4: 
      return l((LiveData)paramObject, paramInt2);
    case 3: 
      return o((LiveData)paramObject, paramInt2);
    case 2: 
      return r((LiveData)paramObject, paramInt2);
    case 1: 
      return t((LiveData)paramObject, paramInt2);
    }
    return p((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (89 == paramInt)
    {
      i((SensorSettingViewModel)paramObject);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorSettingsBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */