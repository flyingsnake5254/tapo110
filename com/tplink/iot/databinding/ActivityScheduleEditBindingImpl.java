package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.setting.ScheduleWeekView;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;

public class ActivityScheduleEditBindingImpl
  extends ActivityScheduleEditBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final RelativeLayout H3;
  private long I3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 3);
    localSparseIntArray.put(2131363954, 4);
    localSparseIntArray.put(2131362953, 5);
    localSparseIntArray.put(2131363962, 6);
    localSparseIntArray.put(2131364106, 7);
  }
  
  public ActivityScheduleEditBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p2, p3));
  }
  
  private ActivityScheduleEditBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[4], (ScheduleWeekView)paramArrayOfObject[6], (Button)paramArrayOfObject[7], (TextView)paramArrayOfObject[1], (Toolbar)paramArrayOfObject[3]);
    this.c.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.y.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 0x2;
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
      long l = this.I3;
      this.I3 = 0L;
      Object localObject1 = this.p0;
      Object localObject2 = null;
      Object localObject4 = null;
      label90:
      Object localObject5;
      if ((0x1B & l) != 0L)
      {
        if ((l & 0x19) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((AlarmSettingViewModel)localObject1).i;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((ObservableField)localObject2).get();
            break label90;
          }
        }
        localObject2 = null;
        localObject5 = localObject4;
        if ((l & 0x1A) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((AlarmSettingViewModel)localObject1).h;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          localObject5 = localObject4;
          if (localObject1 != null) {
            localObject5 = (String)((ObservableField)localObject1).get();
          }
        }
      }
      else
      {
        localObject5 = null;
      }
      if ((l & 0x19) != 0L) {
        TextViewBindingAdapter.setText(this.c, (CharSequence)localObject2);
      }
      if ((l & 0x1A) != 0L) {
        TextViewBindingAdapter.setText(this.y, (CharSequence)localObject5);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable AlarmSettingViewModel paramAlarmSettingViewModel)
  {
    this.p0 = paramAlarmSettingViewModel;
    try
    {
      this.I3 |= 0x8;
      notifyPropertyChanged(105);
      super.requestRebind();
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
      this.I3 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p1 = paramOnClickListener;
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return false;
      }
      return l((ObservableField)paramObject, paramInt2);
    }
    return i((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      m((View.OnClickListener)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label35;
      }
      h((AlarmSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityScheduleEditBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */