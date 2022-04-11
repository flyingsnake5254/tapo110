package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.LightFrequencyViewModel;

public class ActivityLightAdjustBindingImpl
  extends ActivityLightAdjustBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p1;
  @Nullable
  private static final SparseIntArray p2;
  private long H3 = -1L;
  @NonNull
  private final FrameLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p2 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 2);
    localSparseIntArray.put(2131363746, 3);
    localSparseIntArray.put(2131361986, 4);
    localSparseIntArray.put(2131362792, 5);
    localSparseIntArray.put(2131362793, 6);
  }
  
  public ActivityLightAdjustBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p1, p2));
  }
  
  private ActivityLightAdjustBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (RadioButton)paramArrayOfObject[4], (RadioButton)paramArrayOfObject[5], (RadioButton)paramArrayOfObject[6], (CameraLoadingView)paramArrayOfObject[1], (RadioGroup)paramArrayOfObject[3], (Toolbar)paramArrayOfObject[2]);
    this.q.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableBoolean paramObservableBoolean, int paramInt)
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
      LightFrequencyViewModel localLightFrequencyViewModel = this.z;
      ObservableBoolean localObservableBoolean = null;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = (l & 0xD) < 0L;
      if (bool3)
      {
        if (localLightFrequencyViewModel != null) {
          localObservableBoolean = localLightFrequencyViewModel.b;
        }
        updateRegistration(0, localObservableBoolean);
        bool1 = bool2;
        if (localObservableBoolean != null) {
          bool1 = localObservableBoolean.get();
        }
        bool1 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool1));
      }
      if (bool3) {
        b.K(this.q, Boolean.valueOf(bool1));
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable LightFrequencyViewModel paramLightFrequencyViewModel)
  {
    this.z = paramLightFrequencyViewModel;
    try
    {
      this.H3 |= 0x4;
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
  
  public void l(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p0 = paramOnClickListener;
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return i((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      l((View.OnClickListener)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label35;
      }
      h((LightFrequencyViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightAdjustBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */