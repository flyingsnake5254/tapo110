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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.targettrack.TargetTrackViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

public class ActivityTargetTrackBindingImpl
  extends ActivityTargetTrackBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  private long H3 = -1L;
  @NonNull
  private final LinearLayout p2;
  @NonNull
  private final CameraLoadingView p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p1 = localSparseIntArray;
    localSparseIntArray.put(2131364192, 3);
    localSparseIntArray.put(2131364162, 4);
    localSparseIntArray.put(2131364158, 5);
    localSparseIntArray.put(2131364157, 6);
    localSparseIntArray.put(2131364160, 7);
  }
  
  public ActivityTargetTrackBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p0, p1));
  }
  
  private ActivityTargetTrackBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (RelativeLayout)paramArrayOfObject[6], (TextView)paramArrayOfObject[5], (CheckBox)paramArrayOfObject[7], (NoninteractiveCheckBox)paramArrayOfObject[1], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[3]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (CameraLoadingView)paramArrayOfObject[2];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean l(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l = this.H3;
      this.H3 = 0L;
      TargetTrackViewModel localTargetTrackViewModel = this.z;
      boolean bool1 = false;
      boolean bool3;
      if ((0xF & l) != 0L)
      {
        Boolean localBoolean = null;
        Object localObject1;
        boolean bool2;
        if ((l & 0xD) != 0L)
        {
          if (localTargetTrackViewModel != null) {
            localObject1 = localTargetTrackViewModel.r();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject1);
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
        bool3 = bool2;
        if ((l & 0xE) != 0L)
        {
          if (localTargetTrackViewModel != null) {
            localObject1 = localTargetTrackViewModel.w();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localBoolean = (Boolean)((LiveData)localObject1).getValue();
          }
          bool1 = ViewDataBinding.safeUnbox(localBoolean);
          bool3 = bool2;
        }
      }
      else
      {
        bool3 = false;
      }
      if ((0xE & l) != 0L) {
        b.K(this.p3, Boolean.valueOf(bool1));
      }
      if ((l & 0xD) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.q, bool3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable TargetTrackViewModel paramTargetTrackViewModel)
  {
    this.z = paramTargetTrackViewModel;
    try
    {
      this.H3 |= 0x4;
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
      this.H3 = 8L;
      requestRebind();
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
      return i((MutableLiveData)paramObject, paramInt2);
    }
    return l((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((TargetTrackViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTargetTrackBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */