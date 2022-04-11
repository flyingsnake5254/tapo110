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
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;

public class ActivityDiagnoseStatusBindingImpl
  extends ActivityDiagnoseStatusBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p1;
  @Nullable
  private static final SparseIntArray p2;
  private long H3 = -1L;
  @NonNull
  private final ConstraintLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p2 = localSparseIntArray;
    localSparseIntArray.put(2131362424, 3);
    localSparseIntArray.put(2131364192, 4);
    localSparseIntArray.put(2131364193, 5);
    localSparseIntArray.put(2131364184, 6);
  }
  
  public ActivityDiagnoseStatusBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p1, p2));
  }
  
  private ActivityDiagnoseStatusBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (View)paramArrayOfObject[3], (CheckBox)paramArrayOfObject[1], (CameraLoadingView)paramArrayOfObject[2], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.H3 |= 0x2;
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
        this.H3 |= 0x4;
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
      long l = this.H3;
      this.H3 = 0L;
      DiagnoseSettingViewModel localDiagnoseSettingViewModel = this.z;
      boolean bool1 = false;
      boolean bool2 = false;
      if ((0x1E & l) != 0L)
      {
        Object localObject1 = null;
        Object localObject2;
        if ((l & 0x1A) != 0L)
        {
          if (localDiagnoseSettingViewModel != null) {
            localObject2 = localDiagnoseSettingViewModel.a;
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject2);
          if (localObject2 != null) {
            localObject2 = (Boolean)((LiveData)localObject2).getValue();
          } else {
            localObject2 = null;
          }
          bool1 = ViewDataBinding.safeUnbox((Boolean)localObject2);
        }
        else
        {
          bool1 = false;
        }
        if ((l & 0x1C) != 0L)
        {
          localObject2 = localObject1;
          if (localDiagnoseSettingViewModel != null) {
            localObject2 = localDiagnoseSettingViewModel.b;
          }
          updateRegistration(2, (Observable)localObject2);
          if (localObject2 != null) {
            bool2 = ((ObservableBoolean)localObject2).get();
          }
          bool2 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
          break label166;
        }
      }
      bool2 = false;
      label166:
      if ((l & 0x1A) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.d, bool1);
      }
      if ((l & 0x1C) != 0L) {
        b.K(this.f, Boolean.valueOf(bool2));
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable DiagnoseSettingViewModel paramDiagnoseSettingViewModel)
  {
    this.z = paramDiagnoseSettingViewModel;
    try
    {
      this.H3 |= 0x8;
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
      return this.H3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.H3 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable LiveData<Boolean> paramLiveData)
  {
    this.p0 = paramLiveData;
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
      return l((MutableLiveData)paramObject, paramInt2);
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
      h((DiagnoseSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDiagnoseStatusBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */