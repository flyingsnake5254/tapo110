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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;

public class ActivityPrivacyModeBindingImpl
  extends ActivityPrivacyModeBinding
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
    localSparseIntArray.put(2131363703, 3);
    localSparseIntArray.put(2131364192, 4);
    localSparseIntArray.put(2131364193, 5);
  }
  
  public ActivityPrivacyModeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p1, p2));
  }
  
  private ActivityPrivacyModeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (CameraLoadingView)paramArrayOfObject[2], (View)paramArrayOfObject[3], (CheckBox)paramArrayOfObject[1], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<Boolean> paramLiveData, int paramInt)
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
  
  private boolean m(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean n(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
      LensMaskViewModel localLensMaskViewModel = this.y;
      boolean bool1 = false;
      boolean bool3;
      if ((0x36 & l) != 0L)
      {
        Boolean localBoolean = null;
        Object localObject1;
        boolean bool2;
        if ((l & 0x32) != 0L)
        {
          if (localLensMaskViewModel != null) {
            localObject1 = localLensMaskViewModel.c;
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
        bool3 = bool2;
        if ((l & 0x34) != 0L)
        {
          if (localLensMaskViewModel != null) {
            localObject1 = localLensMaskViewModel.d;
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject1);
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
      if ((0x34 & l) != 0L) {
        b.K(this.c, Boolean.valueOf(bool1));
      }
      if ((l & 0x32) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.f, bool3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable String paramString)
  {
    this.p0 = paramString;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.H3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable LensMaskViewModel paramLensMaskViewModel)
  {
    this.y = paramLensMaskViewModel;
    try
    {
      this.H3 |= 0x10;
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
      this.H3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void o(@Nullable LiveData<Boolean> paramLiveData)
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
        return n((MutableLiveData)paramObject, paramInt2);
      }
      return m((MutableLiveData)paramObject, paramInt2);
    }
    return l((LiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (57 == paramInt)
    {
      o((LiveData)paramObject);
    }
    else if (60 == paramInt)
    {
      h((String)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      i((LensMaskViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPrivacyModeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */