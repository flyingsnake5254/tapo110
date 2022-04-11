package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

public class FragmentDevicePasswordSettingBindingImpl
  extends FragmentDevicePasswordSettingBinding
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
    localSparseIntArray.put(2131364275, 3);
    localSparseIntArray.put(2131364252, 4);
    localSparseIntArray.put(2131364754, 5);
    localSparseIntArray.put(2131363619, 6);
  }
  
  public FragmentDevicePasswordSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p1, p2));
  }
  
  private FragmentDevicePasswordSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (CameraLoadingView)paramArrayOfObject[2], (MaterialEditText)paramArrayOfObject[6], (Button)paramArrayOfObject[1], (TextView)paramArrayOfObject[4], (Toolbar)paramArrayOfObject[3], (MaterialEditText)paramArrayOfObject[5]);
    this.c.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
      View.OnClickListener localOnClickListener = this.p0;
      PasswordSettingViewModel localPasswordSettingViewModel = this.z;
      ObservableBoolean localObservableBoolean = null;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = (l & 0xD) < 0L;
      if (bool3)
      {
        if (localPasswordSettingViewModel != null) {
          localObservableBoolean = localPasswordSettingViewModel.a;
        }
        updateRegistration(0, localObservableBoolean);
        bool1 = bool2;
        if (localObservableBoolean != null) {
          bool1 = localObservableBoolean.get();
        }
        bool1 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool1));
      }
      if (bool3) {
        b.K(this.c, Boolean.valueOf(bool1));
      }
      if ((0xA & l) != 0L) {
        this.f.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p0 = paramOnClickListener;
    try
    {
      this.H3 |= 0x2;
      notifyPropertyChanged(2);
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
  
  public void i(@Nullable PasswordSettingViewModel paramPasswordSettingViewModel)
  {
    this.z = paramPasswordSettingViewModel;
    try
    {
      this.H3 |= 0x4;
      notifyPropertyChanged(105);
      super.requestRebind();
      return;
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
    if (paramInt1 != 0) {
      return false;
    }
    return l((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label35;
      }
      i((PasswordSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentDevicePasswordSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */