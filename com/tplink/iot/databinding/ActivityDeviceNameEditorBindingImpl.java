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
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceNameEditorViewModel;
import com.tplink.iot.widget.DrawableEditText;

public class ActivityDeviceNameEditorBindingImpl
  extends ActivityDeviceNameEditorBinding
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
    localSparseIntArray.put(2131364275, 4);
    localSparseIntArray.put(2131362524, 5);
    localSparseIntArray.put(2131362523, 6);
    localSparseIntArray.put(2131362526, 7);
  }
  
  public ActivityDeviceNameEditorBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p2, p3));
  }
  
  private ActivityDeviceNameEditorBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[7], (CameraLoadingView)paramArrayOfObject[3], (DrawableEditText)paramArrayOfObject[1], (Button)paramArrayOfObject[2], (Toolbar)paramArrayOfObject[4]);
    this.q.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
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
      View.OnClickListener localOnClickListener = this.p1;
      DeviceNameEditorViewModel localDeviceNameEditorViewModel = this.p0;
      Object localObject1 = null;
      ObservableBoolean localObservableBoolean = null;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      if ((0x1B & l) != 0L)
      {
        if ((l & 0x19) != 0L)
        {
          if (localDeviceNameEditorViewModel != null) {
            localObject1 = localDeviceNameEditorViewModel.b;
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
          if (localDeviceNameEditorViewModel != null) {
            localObservableBoolean = localDeviceNameEditorViewModel.a;
          }
          updateRegistration(1, localObservableBoolean);
          bool2 = bool3;
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          }
          bool2 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
        }
      }
      if ((l & 0x1A) != 0L) {
        b.K(this.q, Boolean.valueOf(bool2));
      }
      if ((l & 0x19) != 0L) {
        this.x.setText((CharSequence)localObject1);
      }
      if ((0x14 & l) != 0L) {
        this.y.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p1 = paramOnClickListener;
    try
    {
      this.I3 |= 0x4;
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
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable DeviceNameEditorViewModel paramDeviceNameEditorViewModel)
  {
    this.p0 = paramDeviceNameEditorViewModel;
    try
    {
      this.I3 |= 0x8;
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
      this.I3 = 16L;
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
      return m((ObservableBoolean)paramObject, paramInt2);
    }
    return l((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label35;
      }
      i((DeviceNameEditorViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDeviceNameEditorBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */