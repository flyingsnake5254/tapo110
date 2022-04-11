package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.widget.ScheduleWeekdayTextView;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;

public class ActivityAlarmSettingBindingImpl
  extends ActivityAlarmSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts Q3;
  @Nullable
  private static final SparseIntArray R3;
  @NonNull
  private final LinearLayout S3;
  @NonNull
  private final LinearLayout T3;
  private InverseBindingListener U3 = new a();
  private long V3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    R3 = localSparseIntArray;
    localSparseIntArray.put(2131364278, 14);
    localSparseIntArray.put(2131364732, 15);
    localSparseIntArray.put(2131364077, 16);
    localSparseIntArray.put(2131363963, 17);
    localSparseIntArray.put(2131361957, 18);
    localSparseIntArray.put(2131364241, 19);
  }
  
  public ActivityAlarmSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 20, Q3, R3));
  }
  
  private ActivityAlarmSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 8, (CheckBox)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[3], (TextView)paramArrayOfObject[18], (RadioButton)paramArrayOfObject[7], (RadioButton)paramArrayOfObject[8], (RelativeLayout)paramArrayOfObject[9], (TextView)paramArrayOfObject[11], (TextView)paramArrayOfObject[12], (TextView)paramArrayOfObject[10], (RadioGroup)paramArrayOfObject[17], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[16], (RelativeLayout)paramArrayOfObject[5], (LinearLayout)paramArrayOfObject[19], (View)paramArrayOfObject[14], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[15], (ScheduleWeekdayTextView)paramArrayOfObject[13]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.S3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[2];
    this.T3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p3.setTag(null);
    this.I3.setTag(null);
    this.L3.setTag(null);
    this.N3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 1L;
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
      long l1 = this.V3;
      this.V3 = 0L;
      View.OnClickListener localOnClickListener = this.O3;
      AlarmSettingViewModel localAlarmSettingViewModel = this.P3;
      Object localObject1;
      String str;
      label92:
      long l2;
      boolean bool2;
      int j;
      label203:
      label261:
      Object localObject3;
      int i;
      label437:
      Object localObject4;
      label495:
      int k;
      label551:
      int m;
      if ((0x6FF & l1) != 0L)
      {
        if ((l1 & 0x601) != 0L)
        {
          if (localAlarmSettingViewModel != null) {
            localObject1 = localAlarmSettingViewModel.h;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null)
          {
            str = (String)((ObservableField)localObject1).get();
            break label92;
          }
        }
        str = null;
        boolean bool1 = (l1 & 0x602) < 0L;
        l2 = l1;
        if (bool1)
        {
          if (localAlarmSettingViewModel != null) {
            localObject1 = localAlarmSettingViewModel.k;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 16384L;
            } else {
              l2 = 8192L;
            }
            l2 = l1 | l2;
          }
          if (!bool2)
          {
            j = 8;
            break label203;
          }
        }
        j = 0;
        if ((l2 & 0x604) != 0L)
        {
          if (localAlarmSettingViewModel != null) {
            localObject1 = localAlarmSettingViewModel.g;
          } else {
            localObject1 = null;
          }
          updateRegistration(2, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (String)((ObservableField)localObject1).get();
            break label261;
          }
        }
        localObject1 = null;
        bool1 = (l2 & 0x608) < 0L;
        if (bool1)
        {
          if (localAlarmSettingViewModel != null) {
            localObject3 = localAlarmSettingViewModel.d;
          } else {
            localObject3 = null;
          }
          updateRegistration(3, (Observable)localObject3);
          if (localObject3 != null) {
            bool2 = ((ObservableBoolean)localObject3).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool1)
          {
            if (bool2) {
              l1 = 65536L;
            } else {
              l1 = 32768L;
            }
            l1 = l2 | l1;
          }
          if (bool2)
          {
            bool1 = false;
            l2 = l1;
          }
          else
          {
            i = 8;
            l2 = l1;
          }
        }
        else
        {
          i = 0;
          bool2 = false;
        }
        if ((l2 & 0x610) != 0L)
        {
          if (localAlarmSettingViewModel != null) {
            localObject3 = localAlarmSettingViewModel.i;
          } else {
            localObject3 = null;
          }
          updateRegistration(4, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label437;
          }
        }
        localObject3 = null;
        if ((l2 & 0x620) != 0L)
        {
          if (localAlarmSettingViewModel != null) {
            localObject4 = localAlarmSettingViewModel.f;
          } else {
            localObject4 = null;
          }
          updateRegistration(5, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label495;
          }
        }
        localObject4 = null;
        Object localObject5;
        if ((l2 & 0x640) != 0L)
        {
          if (localAlarmSettingViewModel != null) {
            localObject5 = localAlarmSettingViewModel.j;
          } else {
            localObject5 = null;
          }
          updateRegistration(6, (Observable)localObject5);
          if (localObject5 != null)
          {
            k = ((ObservableInt)localObject5).get();
            break label551;
          }
        }
        k = 0;
        boolean bool3 = (l2 & 0x680) < 0L;
        if (bool3)
        {
          if (localAlarmSettingViewModel != null) {
            localObject5 = localAlarmSettingViewModel.l;
          } else {
            localObject5 = null;
          }
          updateRegistration(7, (Observable)localObject5);
          boolean bool4;
          if (localObject5 != null) {
            bool4 = ((ObservableBoolean)localObject5).get();
          } else {
            bool4 = false;
          }
          l1 = l2;
          if (bool3)
          {
            if (bool4) {
              l1 = 4096L;
            } else {
              l1 = 2048L;
            }
            l1 = l2 | l1;
          }
          if (bool4) {
            bool3 = false;
          } else {
            m = 8;
          }
          l2 = l1;
        }
        else
        {
          m = 0;
        }
      }
      else
      {
        localObject1 = null;
        m = 0;
        str = null;
        j = 0;
        bool2 = false;
        i = 0;
        localObject3 = null;
        localObject4 = null;
        k = 0;
        l2 = l1;
      }
      if ((l2 & 0x608) != 0L)
      {
        CompoundButtonBindingAdapter.setChecked(this.c, bool2);
        this.T3.setVisibility(i);
      }
      if ((0x500 & l2) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.I3.setOnClickListener(localOnClickListener);
      }
      if ((0x400 & l2) != 0L) {
        CompoundButtonBindingAdapter.setListeners(this.c, null, this.U3);
      }
      if ((0x610 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.z, (CharSequence)localObject3);
      }
      if ((l2 & 0x602) != 0L) {
        this.p0.setVisibility(j);
      }
      if ((l2 & 0x601) != 0L) {
        TextViewBindingAdapter.setText(this.p1, str);
      }
      if ((l2 & 0x604) != 0L) {
        TextViewBindingAdapter.setText(this.p3, (CharSequence)localObject1);
      }
      if ((0x680 & l2) != 0L) {
        this.I3.setVisibility(m);
      }
      if ((0x620 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.L3, (CharSequence)localObject4);
      }
      if ((l2 & 0x640) != 0L) {
        ScheduleWeekdayTextView.b(this.N3, k);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.O3 = paramOnClickListener;
    try
    {
      this.V3 |= 0x100;
      notifyPropertyChanged(55);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.V3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable AlarmSettingViewModel paramAlarmSettingViewModel)
  {
    this.P3 = paramAlarmSettingViewModel;
    try
    {
      this.V3 |= 0x200;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.V3 = 1024L;
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
    case 7: 
      return l((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return o((ObservableInt)paramObject, paramInt2);
    case 5: 
      return n((ObservableField)paramObject, paramInt2);
    case 4: 
      return p((ObservableField)paramObject, paramInt2);
    case 3: 
      return m((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return r((ObservableField)paramObject, paramInt2);
    case 1: 
      return q((ObservableBoolean)paramObject, paramInt2);
    }
    return s((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (55 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      i((AlarmSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      boolean bool = ActivityAlarmSettingBindingImpl.this.c.isChecked();
      Object localObject = ActivityAlarmSettingBindingImpl.this.P3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((AlarmSettingViewModel)localObject).d;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAlarmSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */