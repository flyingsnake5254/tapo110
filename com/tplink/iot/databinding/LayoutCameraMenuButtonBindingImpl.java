package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;

public class LayoutCameraMenuButtonBindingImpl
  extends LayoutCameraMenuButtonBinding
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final LinearLayout p1;
  private long p2 = -1L;
  
  public LayoutCameraMenuButtonBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 2, z, p0));
  }
  
  private LayoutCameraMenuButtonBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 5, (TextView)paramArrayOfObject[1]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.c.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean n(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean p(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean q(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 0x10;
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
      ObservableBoolean localObservableBoolean1 = this.q;
      float f = 0.0F;
      ObservableBoolean localObservableBoolean2 = this.y;
      Boolean localBoolean = null;
      ObservableBoolean localObservableBoolean3 = this.f;
      MutableLiveData localMutableLiveData = this.d;
      ObservableBoolean localObservableBoolean4 = this.x;
      boolean bool1 = false;
      boolean bool2 = (l1 & 0x2F) < 0L;
      boolean bool3;
      boolean bool4;
      if (bool2)
      {
        if (localObservableBoolean2 != null) {
          bool3 = localObservableBoolean2.get();
        } else {
          bool3 = false;
        }
        bool4 = bool3 ^ true;
        l2 = l1;
        bool5 = bool4;
        if (bool2) {
          if (bool4)
          {
            l2 = l1 | 0x200;
            bool5 = bool4;
          }
          else
          {
            l2 = l1 | 0x100;
            bool5 = bool4;
          }
        }
      }
      else
      {
        bool5 = false;
        l2 = l1;
      }
      boolean bool6;
      if (((l2 & 0x30) != 0L) && (localObservableBoolean4 != null)) {
        bool6 = localObservableBoolean4.get();
      } else {
        bool6 = false;
      }
      if (((l2 & 0x200) != 0L) && (localObservableBoolean3 != null)) {
        bool3 = localObservableBoolean3.get();
      } else {
        bool3 = false;
      }
      boolean bool7;
      if ((l2 & 0x2F) != 0L)
      {
        if (!bool5) {
          bool3 = false;
        }
        l1 = l2;
        if ((l2 & 0x27) != 0L) {
          if (bool3) {
            l1 = l2 | 0x2000;
          } else {
            l1 = l2 | 0x1000;
          }
        }
        l2 = l1;
        bool7 = bool3;
        if ((l1 & 0x2F) != 0L) {
          if (bool3)
          {
            l2 = l1 | 0x8000;
            bool7 = bool3;
          }
          else
          {
            l2 = l1 | 0x4000;
            bool7 = bool3;
          }
        }
      }
      else
      {
        bool7 = false;
      }
      boolean bool8;
      if ((l2 & 0x2000) != 0L)
      {
        if (localObservableBoolean1 != null) {
          bool8 = localObservableBoolean1.get();
        } else {
          bool8 = false;
        }
        bool3 = bool8 ^ true;
      }
      else
      {
        bool8 = false;
        bool3 = false;
      }
      if ((l2 & 0x8000) != 0L)
      {
        if (localMutableLiveData != null) {
          localBoolean = (Boolean)localMutableLiveData.getValue();
        }
        bool5 = ViewDataBinding.safeUnbox(localBoolean) ^ true;
      }
      else
      {
        bool5 = false;
      }
      boolean bool9;
      if (((l2 & 0x27) != 0L) && (bool7)) {
        bool9 = bool3;
      } else {
        bool9 = false;
      }
      bool2 = (l2 & 0x2F) < 0L;
      if (bool2)
      {
        if (!bool7) {
          bool5 = false;
        }
        l1 = l2;
        bool4 = bool5;
        if (bool2) {
          if (bool5)
          {
            l1 = l2 | 0x800;
            bool4 = bool5;
          }
          else
          {
            l1 = l2 | 0x400;
            bool4 = bool5;
          }
        }
      }
      else
      {
        bool4 = false;
        l1 = l2;
      }
      if ((l1 & 0x800) != 0L)
      {
        if (localObservableBoolean1 != null) {
          bool8 = localObservableBoolean1.get();
        }
        bool3 = bool8 ^ true;
      }
      boolean bool5 = (l1 & 0x2F) < 0L;
      long l2 = l1;
      if (bool5)
      {
        bool8 = bool1;
        if (bool4) {
          bool8 = bool3;
        }
        l2 = l1;
        if (bool5)
        {
          if (bool8) {
            l2 = 128L;
          } else {
            l2 = 64L;
          }
          l2 = l1 | l2;
        }
        if (bool8) {
          f = 1.0F;
        } else {
          f = 0.4F;
        }
      }
      if (((l2 & 0x2F) != 0L) && (ViewDataBinding.getBuildSdkInt() >= 11)) {
        this.c.setAlpha(f);
      }
      if ((l2 & 0x27) != 0L) {
        this.c.setEnabled(bool9);
      }
      if ((l2 & 0x30) != 0L) {
        b.Q(this.c, bool6);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(1, paramObservableBoolean);
    this.y = paramObservableBoolean;
    try
    {
      this.p2 |= 0x2;
      notifyPropertyChanged(33);
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
  
  public void i(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(0, paramObservableBoolean);
    this.q = paramObservableBoolean;
    try
    {
      this.p2 |= 1L;
      notifyPropertyChanged(57);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(2, paramObservableBoolean);
    this.f = paramObservableBoolean;
    try
    {
      this.p2 |= 0x4;
      notifyPropertyChanged(73);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(4, paramObservableBoolean);
    this.x = paramObservableBoolean;
    try
    {
      this.p2 |= 0x10;
      notifyPropertyChanged(106);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4) {
              return false;
            }
            return r((ObservableBoolean)paramObject, paramInt2);
          }
          return n((MutableLiveData)paramObject, paramInt2);
        }
        return q((ObservableBoolean)paramObject, paramInt2);
      }
      return o((ObservableBoolean)paramObject, paramInt2);
    }
    return p((ObservableBoolean)paramObject, paramInt2);
  }
  
  public void s(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(3, paramMutableLiveData);
    this.d = paramMutableLiveData;
    try
    {
      this.p2 |= 0x8;
      notifyPropertyChanged(17);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (57 == paramInt)
    {
      i((ObservableBoolean)paramObject);
    }
    else if (33 == paramInt)
    {
      h((ObservableBoolean)paramObject);
    }
    else if (73 == paramInt)
    {
      l((ObservableBoolean)paramObject);
    }
    else if (17 == paramInt)
    {
      s((MutableLiveData)paramObject);
    }
    else
    {
      if (106 != paramInt) {
        break label87;
      }
      m((ObservableBoolean)paramObject);
    }
    boolean bool = true;
    return bool;
    label87:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutCameraMenuButtonBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */