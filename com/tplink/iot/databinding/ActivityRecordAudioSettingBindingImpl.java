package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordAudioSettingViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

public class ActivityRecordAudioSettingBindingImpl
  extends ActivityRecordAudioSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  @NonNull
  private final ConstraintLayout p2;
  private long p3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p1 = localSparseIntArray;
    localSparseIntArray.put(2131364034, 3);
    localSparseIntArray.put(2131364192, 4);
    localSparseIntArray.put(2131364193, 5);
  }
  
  public ActivityRecordAudioSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p0, p1));
  }
  
  private ActivityRecordAudioSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (NoninteractiveCheckBox)paramArrayOfObject[1], (CameraLoadingView)paramArrayOfObject[2], (View)paramArrayOfObject[3], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(LiveData<Boolean> paramLiveData, int paramInt)
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
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p3;
      this.p3 = 0L;
      RecordAudioSettingViewModel localRecordAudioSettingViewModel = this.y;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool4;
      if ((0x1E & l) != 0L)
      {
        Object localObject1 = null;
        Object localObject2;
        boolean bool3;
        if ((l & 0x1A) != 0L)
        {
          if (localRecordAudioSettingViewModel != null) {
            localObject2 = localRecordAudioSettingViewModel.b;
          } else {
            localObject2 = null;
          }
          updateRegistration(1, (Observable)localObject2);
          if (localObject2 != null) {
            bool3 = ((ObservableBoolean)localObject2).get();
          } else {
            bool3 = false;
          }
          bool3 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool3));
        }
        else
        {
          bool3 = false;
        }
        bool4 = bool3;
        if ((l & 0x1C) != 0L)
        {
          localObject2 = localObject1;
          if (localRecordAudioSettingViewModel != null) {
            localObject2 = localRecordAudioSettingViewModel.a;
          }
          updateRegistration(2, (Observable)localObject2);
          bool4 = bool2;
          if (localObject2 != null) {
            bool4 = ((ObservableBoolean)localObject2).get();
          }
          bool1 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool4));
          bool4 = bool3;
        }
      }
      else
      {
        bool4 = false;
      }
      if ((0x1C & l) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.c, bool1);
      }
      if ((l & 0x1A) != 0L) {
        b.K(this.d, Boolean.valueOf(bool4));
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable RecordAudioSettingViewModel paramRecordAudioSettingViewModel)
  {
    this.y = paramRecordAudioSettingViewModel;
    try
    {
      this.p3 |= 0x8;
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
      this.p3 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable LiveData<Boolean> paramLiveData)
  {
    this.z = paramLiveData;
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
        return m((ObservableBoolean)paramObject, paramInt2);
      }
      return l((ObservableBoolean)paramObject, paramInt2);
    }
    return i((LiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (57 == paramInt)
    {
      n((LiveData)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      h((RecordAudioSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityRecordAudioSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */