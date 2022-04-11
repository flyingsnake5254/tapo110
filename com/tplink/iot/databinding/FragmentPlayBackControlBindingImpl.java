package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public class FragmentPlayBackControlBindingImpl
  extends FragmentPlayBackControlBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  private long K3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(7);
    I3 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(0, new String[] { "play_back_top_bar", "play_back_ruler_layout", "play_back_date_selector" }, new int[] { 4, 5, 6 }, new int[] { 2131559331, 2131559329, 2131559328 });
    localObject = new SparseIntArray();
    J3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131364068, 2);
    ((SparseIntArray)localObject).put(2131363796, 3);
  }
  
  public FragmentPlayBackControlBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, I3, J3));
  }
  
  private FragmentPlayBackControlBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 7, (CameraLoadingView)paramArrayOfObject[1], (PlayBackDateSelectorBinding)paramArrayOfObject[6], (PlayBackRulerLayoutBinding)paramArrayOfObject[5], (PlayBackTopBarBinding)paramArrayOfObject[4], (View)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[0], (View)paramArrayOfObject[2]);
    this.c.setTag(null);
    setContainedBinding(this.d);
    setContainedBinding(this.f);
    setContainedBinding(this.q);
    this.y.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean o(PlayBackDateSelectorBinding paramPlayBackDateSelectorBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(PlayBackRulerLayoutBinding paramPlayBackRulerLayoutBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(PlayBackTopBarBinding paramPlayBackTopBarBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x10;
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
        this.K3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean t(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean u(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 0x20;
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
      long l1 = this.K3;
      this.K3 = 0L;
      c localc = this.H3;
      g localg = this.p0;
      com.tplink.iot.view.ipcamera.widget.calendar.b localb = this.p1;
      TimeAxisLayout.b localb1 = this.p3;
      PlayBackControlViewModel localPlayBackControlViewModel = this.p2;
      int i = 8;
      ObservableBoolean localObservableBoolean;
      long l2;
      boolean bool3;
      label249:
      label360:
      int n;
      int i1;
      if ((0x182E & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x1822) < 0L;
        if (bool1)
        {
          if (localPlayBackControlViewModel != null) {
            localObservableBoolean = localPlayBackControlViewModel.V3;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2)
            {
              l2 = l1 | 0x4000;
              l1 = 1048576L;
            }
            else
            {
              l2 = l1 | 0x2000;
              l1 = 524288L;
            }
            l2 |= l1;
          }
          l1 = l2;
          if ((l2 & 0x1802) != 0L)
          {
            if (bool2) {
              l1 = 262144L;
            } else {
              l1 = 131072L;
            }
            l1 = l2 | l1;
          }
          l2 = l1;
          bool3 = bool2;
          if ((l1 & 0x1802) != 0L) {
            if (bool2)
            {
              l2 = l1;
              bool3 = bool2;
            }
            else
            {
              j = 8;
              break label249;
            }
          }
        }
        else
        {
          bool3 = false;
          l2 = l1;
        }
        j = 0;
        bool2 = bool3;
        l1 = l2;
        boolean bool4 = (l1 & 0x1804) < 0L;
        l2 = l1;
        if (bool4)
        {
          if (localPlayBackControlViewModel != null) {
            localObservableBoolean = localPlayBackControlViewModel.U3;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool3 = localObservableBoolean.get();
          } else {
            bool3 = false;
          }
          l2 = l1;
          if (bool4)
          {
            if (bool3) {
              l2 = 4194304L;
            } else {
              l2 = 2097152L;
            }
            l2 = l1 | l2;
          }
          if (!bool3)
          {
            k = 8;
            break label360;
          }
        }
        int k = 0;
        boolean bool5 = (l2 & 0x1808) < 0L;
        l1 = l2;
        bool3 = bool2;
        n = j;
        i1 = k;
        if (bool5)
        {
          if (localPlayBackControlViewModel != null) {
            localObservableBoolean = localPlayBackControlViewModel.Z3;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(3, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool3 = localObservableBoolean.get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          bool6 = bool2;
          n = j;
          i1 = k;
          bool7 = bool3;
          if (!bool5) {
            break label514;
          }
          if (bool3) {
            l1 = 16777216L;
          } else {
            l1 = 8388608L;
          }
          l1 = l2 | l1;
          bool6 = bool2;
          n = j;
          i1 = k;
          bool7 = bool3;
          break label514;
        }
      }
      else
      {
        bool3 = false;
        n = 0;
        i1 = 0;
      }
      boolean bool7 = false;
      boolean bool6 = bool3;
      label514:
      if ((l1 & 0x104000) != 0L)
      {
        if (localPlayBackControlViewModel != null) {
          localObservableBoolean = localPlayBackControlViewModel.X3;
        } else {
          localObservableBoolean = null;
        }
        updateRegistration(5, localObservableBoolean);
        if (localObservableBoolean != null) {
          bool2 = localObservableBoolean.get();
        } else {
          bool2 = false;
        }
        bool3 = bool2;
        if ((l1 & 0x4000) != 0L)
        {
          j = bool2 ^ true;
          break label601;
        }
      }
      else
      {
        bool3 = false;
      }
      int j = 0;
      boolean bool2 = bool3;
      label601:
      int m = (l1 & 0x1822) < 0L;
      if (m != 0)
      {
        if (!bool6) {
          j = 0;
        }
        if (!bool6) {
          bool2 = false;
        }
        l2 = l1;
        if (m != 0)
        {
          if (j != 0) {
            l2 = 67108864L;
          } else {
            l2 = 33554432L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0x1822) != 0L)
        {
          if (bool2) {
            l1 = 65536L;
          } else {
            l1 = 32768L;
          }
          l1 = l2 | l1;
        }
        if (j != 0) {
          j = 0;
        } else {
          j = 8;
        }
        m = i;
        if (bool2) {
          m = 0;
        }
      }
      else
      {
        j = 0;
        m = 0;
      }
      if ((l1 & 0x1808) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.K(this.c, Boolean.valueOf(bool7));
      }
      if ((0x1800 & l1) != 0L)
      {
        this.d.l(localPlayBackControlViewModel);
        this.f.l(localPlayBackControlViewModel);
        this.q.i(localPlayBackControlViewModel);
      }
      if ((0x1200 & l1) != 0L) {
        this.d.h(localb);
      }
      if ((0x1080 & l1) != 0L) {
        this.d.i(localc);
      }
      if ((l1 & 0x1804) != 0L) {
        this.d.getRoot().setVisibility(i1);
      }
      if ((0x1100 & l1) != 0L)
      {
        this.f.h(localg);
        this.q.h(localg);
      }
      if ((0x1400 & l1) != 0L) {
        this.f.i(localb1);
      }
      if ((l1 & 0x1802) != 0L) {
        this.f.getRoot().setVisibility(n);
      }
      if ((l1 & 0x1822) != 0L)
      {
        this.x.setVisibility(j);
        this.z.setVisibility(m);
      }
      ViewDataBinding.executeBindingsOn(this.q);
      ViewDataBinding.executeBindingsOn(this.f);
      ViewDataBinding.executeBindingsOn(this.d);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable com.tplink.iot.view.ipcamera.widget.calendar.b paramb)
  {
    this.p1 = paramb;
    try
    {
      this.K3 |= 0x200;
      notifyPropertyChanged(63);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      if (this.K3 != 0L) {
        return true;
      }
      if (this.q.hasPendingBindings()) {
        return true;
      }
      if (this.f.hasPendingBindings()) {
        return true;
      }
      return this.d.hasPendingBindings();
    }
    finally {}
  }
  
  public void i(@Nullable c paramc)
  {
    this.H3 = paramc;
    try
    {
      this.K3 |= 0x80;
      notifyPropertyChanged(64);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.K3 = 4096L;
      this.q.invalidateAll();
      this.f.invalidateAll();
      this.d.invalidateAll();
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable g paramg)
  {
    this.p0 = paramg;
    try
    {
      this.K3 |= 0x100;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable TimeAxisLayout.b paramb)
  {
    this.p3 = paramb;
    try
    {
      this.K3 |= 0x400;
      notifyPropertyChanged(99);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.p2 = paramPlayBackControlViewModel;
    try
    {
      this.K3 |= 0x800;
      notifyPropertyChanged(105);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 6: 
      return o((PlayBackDateSelectorBinding)paramObject, paramInt2);
    case 5: 
      return u((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return q((PlayBackTopBarBinding)paramObject, paramInt2);
    case 3: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return r((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return t((ObservableBoolean)paramObject, paramInt2);
    }
    return p((PlayBackRulerLayoutBinding)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.q.setLifecycleOwner(paramLifecycleOwner);
    this.f.setLifecycleOwner(paramLifecycleOwner);
    this.d.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (64 == paramInt)
    {
      i((c)paramObject);
    }
    else if (79 == paramInt)
    {
      l((g)paramObject);
    }
    else if (63 == paramInt)
    {
      h((com.tplink.iot.view.ipcamera.widget.calendar.b)paramObject);
    }
    else if (99 == paramInt)
    {
      m((TimeAxisLayout.b)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label87;
      }
      n((PlayBackControlViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label87:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentPlayBackControlBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */