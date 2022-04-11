package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public class LayoutPlayBackFullscreenFilterBindingImpl
  extends LayoutPlayBackFullscreenFilterBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  private InverseBindingListener H3 = new b();
  private long I3 = -1L;
  @NonNull
  private final LinearLayout p0;
  @Nullable
  private final View.OnClickListener p1;
  @Nullable
  private final View.OnClickListener p2;
  private InverseBindingListener p3 = new a();
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    z = localSparseIntArray;
    localSparseIntArray.put(2131364252, 3);
  }
  
  public LayoutPlayBackFullscreenFilterBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, y, z));
  }
  
  private LayoutPlayBackFullscreenFilterBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (CheckBox)paramArrayOfObject[1], (CheckBox)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.p1 = new a(this, 2);
    this.p2 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean o(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 0;
    int j = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localg = this.q;
        paramInt = j;
        if (localg != null) {
          paramInt = 1;
        }
        if (paramInt != 0) {
          localg.onClick(paramView);
        }
      }
    }
    else
    {
      localg = this.q;
      paramInt = i;
      if (localg != null) {
        paramInt = 1;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.I3;
      this.I3 = 0L;
      PlayBackControlViewModel localPlayBackControlViewModel = this.x;
      label81:
      label133:
      label185:
      boolean bool4;
      boolean bool5;
      boolean bool6;
      if ((0x6F & l) != 0L)
      {
        ObservableBoolean localObservableBoolean;
        if ((l & 0x61) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObservableBoolean = localPlayBackControlViewModel.b4;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(0, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool1 = localObservableBoolean.get();
            break label81;
          }
        }
        bool1 = false;
        if ((l & 0x62) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObservableBoolean = localPlayBackControlViewModel.c4;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool2 = localObservableBoolean.get();
            break label133;
          }
        }
        bool2 = false;
        if ((l & 0x64) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObservableBoolean = localPlayBackControlViewModel.d4;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool3 = localObservableBoolean.get();
            break label185;
          }
        }
        bool3 = false;
        bool4 = bool1;
        bool5 = bool2;
        bool6 = bool3;
        if ((l & 0x68) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObservableBoolean = localPlayBackControlViewModel.a4;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(3, localObservableBoolean);
          bool4 = bool1;
          bool5 = bool2;
          bool6 = bool3;
          if (localObservableBoolean != null)
          {
            bool6 = localObservableBoolean.get();
            bool4 = bool1;
            bool1 = bool6;
            break label286;
          }
        }
      }
      else
      {
        bool4 = false;
        bool5 = false;
        bool6 = false;
      }
      boolean bool1 = false;
      boolean bool3 = bool6;
      boolean bool2 = bool5;
      label286:
      if ((l & 0x40) != 0L)
      {
        this.c.setOnClickListener(this.p2);
        CompoundButtonBindingAdapter.setListeners(this.c, null, this.p3);
        this.d.setOnClickListener(this.p1);
        CompoundButtonBindingAdapter.setListeners(this.d, null, this.H3);
      }
      if ((l & 0x68) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.c, bool1);
      }
      if ((l & 0x61) != 0L) {
        this.c.setEnabled(bool4);
      }
      if ((l & 0x62) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.d, bool2);
      }
      if ((l & 0x64) != 0L) {
        this.d.setEnabled(bool3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.q = paramg;
    try
    {
      this.I3 |= 0x10;
      notifyPropertyChanged(79);
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
  
  public void i(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.x = paramPlayBackControlViewModel;
    try
    {
      this.I3 |= 0x20;
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
      this.I3 = 64L;
      requestRebind();
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
          if (paramInt1 != 3) {
            return false;
          }
          return o((ObservableBoolean)paramObject, paramInt2);
        }
        return m((ObservableBoolean)paramObject, paramInt2);
      }
      return l((ObservableBoolean)paramObject, paramInt2);
    }
    return n((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      h((g)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label36;
      }
      i((PlayBackControlViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      boolean bool = LayoutPlayBackFullscreenFilterBindingImpl.this.c.isChecked();
      Object localObject = LayoutPlayBackFullscreenFilterBindingImpl.this.x;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((PlayBackControlViewModel)localObject).a4;
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
  
  class b
    implements InverseBindingListener
  {
    b() {}
    
    public void onChange()
    {
      boolean bool = LayoutPlayBackFullscreenFilterBindingImpl.this.d.isChecked();
      Object localObject = LayoutPlayBackFullscreenFilterBindingImpl.this.x;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((PlayBackControlViewModel)localObject).c4;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlayBackFullscreenFilterBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */