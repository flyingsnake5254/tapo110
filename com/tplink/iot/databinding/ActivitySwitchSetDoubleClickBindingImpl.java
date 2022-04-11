package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDoubleClickViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

public class ActivitySwitchSetDoubleClickBindingImpl
  extends ActivitySwitchSetDoubleClickBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts q;
  @Nullable
  private static final SparseIntArray x;
  @NonNull
  private final TextView p0;
  private InverseBindingListener p1 = new a();
  private long p2 = -1L;
  @NonNull
  private final LinearLayout y;
  @NonNull
  private final LinearLayout z;
  
  public ActivitySwitchSetDoubleClickBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, q, x));
  }
  
  private ActivitySwitchSetDoubleClickBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (SeekBar)paramArrayOfObject[4], (TPSwitchCompat)paramArrayOfObject[1]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.y = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[2];
    this.z = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.c.setTag(null);
    this.d.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 1L;
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
      long l1 = this.p2;
      this.p2 = 0L;
      SwitchSetDoubleClickViewModel localSwitchSetDoubleClickViewModel = this.f;
      Object localObject1;
      long l2;
      boolean bool3;
      int i;
      if ((0xF & l1) != 0L)
      {
        boolean bool1 = (l1 & 0xD) < 0L;
        if (bool1)
        {
          if (localSwitchSetDoubleClickViewModel != null) {
            localObject1 = localSwitchSetDoubleClickViewModel.k();
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          boolean bool2;
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          bool3 = bool2;
          if (bool1)
          {
            if (bool2) {
              l2 = 32L;
            } else {
              l2 = 16L;
            }
            l2 = l1 | l2;
            bool3 = bool2;
          }
        }
        else
        {
          bool3 = false;
          l2 = l1;
        }
        if ((l2 & 0xE) != 0L)
        {
          if (localSwitchSetDoubleClickViewModel != null) {
            localObject1 = localSwitchSetDoubleClickViewModel.i();
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null) {
            i = ((ObservableInt)localObject1).get();
          } else {
            i = 0;
          }
          localObject1 = String.valueOf(i + 100);
        }
        else
        {
          localObject1 = null;
          i = 0;
        }
      }
      else
      {
        localObject1 = null;
        i = 0;
        bool3 = false;
        l2 = l1;
      }
      if ((0xD & l2) != 0L)
      {
        a.h(this.z, false);
        a.g(this.d, bool3);
      }
      if ((0xE & l2) != 0L)
      {
        TextViewBindingAdapter.setText(this.p0, (CharSequence)localObject1);
        SeekBarBindingAdapter.setProgress(this.c, i);
      }
      if ((l2 & 0x8) != 0L) {
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.c, null, null, null, this.p1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SwitchSetDoubleClickViewModel paramSwitchSetDoubleClickViewModel)
  {
    this.f = paramSwitchSetDoubleClickViewModel;
    try
    {
      this.p2 |= 0x4;
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
      return this.p2 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 8L;
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
      return i((ObservableInt)paramObject, paramInt2);
    }
    return l((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((SwitchSetDoubleClickViewModel)paramObject);
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
      int i = ActivitySwitchSetDoubleClickBindingImpl.this.c.getProgress();
      Object localObject = ActivitySwitchSetDoubleClickBindingImpl.this.f;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((SwitchSetDoubleClickViewModel)localObject).i();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySwitchSetDoubleClickBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */