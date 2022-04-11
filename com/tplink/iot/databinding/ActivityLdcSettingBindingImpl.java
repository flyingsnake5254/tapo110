package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.LdcSettingViewModel;

public class ActivityLdcSettingBindingImpl
  extends ActivityLdcSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  private long H3 = -1L;
  @NonNull
  private final ConstraintLayout p2;
  @NonNull
  private final ImageView p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p1 = localSparseIntArray;
    localSparseIntArray.put(2131363218, 4);
    localSparseIntArray.put(2131364192, 5);
    localSparseIntArray.put(2131364193, 6);
  }
  
  public ActivityLdcSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p0, p1));
  }
  
  private ActivityLdcSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (View)paramArrayOfObject[4], (CheckBox)paramArrayOfObject[1], (CameraLoadingView)paramArrayOfObject[3], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[6]);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[2];
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
      long l1 = this.H3;
      this.H3 = 0L;
      LdcSettingViewModel localLdcSettingViewModel = this.y;
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject1 = null;
      ObservableBoolean localObservableBoolean = null;
      long l2 = l1;
      if ((0x1E & l1) != 0L)
      {
        boolean bool3 = (l1 & 0x1A) < 0L;
        if (bool3)
        {
          if (localLdcSettingViewModel != null) {
            localObject1 = localLdcSettingViewModel.a;
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool1 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l2 = l1;
          if (bool3)
          {
            if (bool1) {
              l2 = 64L;
            } else {
              l2 = 32L;
            }
            l2 = l1 | l2;
          }
          localObject1 = this.p3.getContext();
          int i;
          if (bool1) {
            i = 2131231302;
          } else {
            i = 2131231301;
          }
          localObject1 = AppCompatResources.getDrawable((Context)localObject1, i);
          l1 = l2;
        }
        else
        {
          localObject1 = null;
          bool1 = false;
        }
        if ((l1 & 0x1C) != 0L)
        {
          if (localLdcSettingViewModel != null) {
            localObservableBoolean = localLdcSettingViewModel.b;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          }
          bool2 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
        }
        else
        {
          l2 = l1;
        }
      }
      else
      {
        bool2 = false;
        l1 = l2;
      }
      if ((l1 & 0x1A) != 0L)
      {
        CompoundButtonBindingAdapter.setChecked(this.d, bool1);
        ImageViewBindingAdapter.setImageDrawable(this.p3, (Drawable)localObject1);
      }
      if ((l1 & 0x1C) != 0L) {
        b.K(this.f, Boolean.valueOf(bool2));
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable LdcSettingViewModel paramLdcSettingViewModel)
  {
    this.y = paramLdcSettingViewModel;
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
      h((LdcSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLdcSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */