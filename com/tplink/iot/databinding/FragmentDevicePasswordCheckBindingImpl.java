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
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

public class FragmentDevicePasswordCheckBindingImpl
  extends FragmentDevicePasswordCheckBinding
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
    localSparseIntArray.put(2131364275, 5);
    localSparseIntArray.put(2131363619, 6);
  }
  
  public FragmentDevicePasswordCheckBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p1, p2));
  }
  
  private FragmentDevicePasswordCheckBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (TextView)paramArrayOfObject[2], (CameraLoadingView)paramArrayOfObject[4], (MaterialEditText)paramArrayOfObject[6], (Button)paramArrayOfObject[3], (Toolbar)paramArrayOfObject[5], (TextView)paramArrayOfObject[1]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean m(ObservableField<String> paramObservableField, int paramInt)
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
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      Object localObject1 = null;
      ObservableBoolean localObservableBoolean = null;
      if ((0x1B & l) != 0L)
      {
        if ((l & 0x19) != 0L)
        {
          if (localPasswordSettingViewModel != null) {
            localObject1 = localPasswordSettingViewModel.b;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (String)((ObservableField)localObject1).get();
            break label107;
          }
        }
        localObject1 = null;
        label107:
        bool2 = bool1;
        if ((l & 0x1A) != 0L)
        {
          if (localPasswordSettingViewModel != null) {
            localObservableBoolean = localPasswordSettingViewModel.a;
          }
          updateRegistration(1, localObservableBoolean);
          bool2 = bool3;
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          }
          bool2 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
        }
      }
      if ((0x14 & l) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
      }
      if ((l & 0x1A) != 0L) {
        b.K(this.d, Boolean.valueOf(bool2));
      }
      if ((l & 0x19) != 0L) {
        TextViewBindingAdapter.setText(this.y, (CharSequence)localObject1);
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
      this.H3 |= 0x4;
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
      this.H3 |= 0x8;
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
      this.H3 = 16L;
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
      return l((ObservableBoolean)paramObject, paramInt2);
    }
    return m((ObservableField)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentDevicePasswordCheckBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */