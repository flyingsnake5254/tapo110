package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.b;

public class LayoutCameraMenuSettingsBindingImpl
  extends LayoutCameraMenuSettingsBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts q;
  @Nullable
  private static final SparseIntArray x;
  @NonNull
  private final RelativeLayout y;
  private long z = -1L;
  
  public LayoutCameraMenuSettingsBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, q, x));
  }
  
  private LayoutCameraMenuSettingsBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ImageView)paramArrayOfObject[1], (View)paramArrayOfObject[2]);
    this.c.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.y = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.d.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.z |= 1L;
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
      long l = this.z;
      this.z = 0L;
      ObservableBoolean localObservableBoolean = this.f;
      boolean bool1 = false;
      boolean bool2 = (0x3 & l) < 0L;
      boolean bool3 = bool1;
      if (bool2)
      {
        bool3 = bool1;
        if (localObservableBoolean != null) {
          bool3 = localObservableBoolean.get();
        }
      }
      if ((l & 0x2) != 0L) {
        b.q(this.c, Boolean.TRUE, null);
      }
      if (bool2) {
        b.Q(this.d, bool3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(0, paramObservableBoolean);
    this.f = paramObservableBoolean;
    try
    {
      this.z |= 1L;
      notifyPropertyChanged(23);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.z != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.z = 2L;
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
    return i((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (23 == paramInt)
    {
      h((ObservableBoolean)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutCameraMenuSettingsBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */