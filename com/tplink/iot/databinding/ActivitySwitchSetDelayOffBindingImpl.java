package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDelayOffViewModel;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public class ActivitySwitchSetDelayOffBindingImpl
  extends ActivitySwitchSetDelayOffBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts x;
  @Nullable
  private static final SparseIntArray y;
  private InverseBindingListener p0 = new a();
  private long p1 = -1L;
  @NonNull
  private final LinearLayout z;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    y = localSparseIntArray;
    localSparseIntArray.put(2131363935, 3);
  }
  
  public ActivitySwitchSetDelayOffBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, x, y));
  }
  
  private ActivitySwitchSetDelayOffBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (LinearLayout)paramArrayOfObject[2], (RecyclerView)paramArrayOfObject[3], (TPSwitchCompat)paramArrayOfObject[1]);
    this.c.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.z = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 1L;
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
      long l = this.p1;
      this.p1 = 0L;
      ObservableBoolean localObservableBoolean = null;
      SwitchSetDelayOffViewModel localSwitchSetDelayOffViewModel = this.q;
      boolean bool1 = false;
      boolean bool2 = (0x7 & l) < 0L;
      boolean bool3 = bool1;
      if (bool2)
      {
        if (localSwitchSetDelayOffViewModel != null) {
          localObservableBoolean = localSwitchSetDelayOffViewModel.j();
        }
        updateRegistration(0, localObservableBoolean);
        bool3 = bool1;
        if (localObservableBoolean != null) {
          bool3 = localObservableBoolean.get();
        }
      }
      if (bool2)
      {
        b.Q(this.c, bool3);
        a.g(this.f, bool3);
      }
      if ((l & 0x4) != 0L) {
        a.b(this.f, this.p0);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SwitchSetDelayOffViewModel paramSwitchSetDelayOffViewModel)
  {
    this.q = paramSwitchSetDelayOffViewModel;
    try
    {
      this.p1 |= 0x2;
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
      return this.p1 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p1 = 4L;
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
    if (103 == paramInt)
    {
      h((SwitchSetDelayOffViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      boolean bool = a.a(ActivitySwitchSetDelayOffBindingImpl.this.f);
      Object localObject = ActivitySwitchSetDelayOffBindingImpl.this.q;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((SwitchSetDelayOffViewModel)localObject).j();
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySwitchSetDelayOffBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */