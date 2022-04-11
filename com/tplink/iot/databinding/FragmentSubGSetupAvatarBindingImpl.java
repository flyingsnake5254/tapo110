package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class FragmentSubGSetupAvatarBindingImpl
  extends FragmentSubGSetupAvatarBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final RelativeLayout H3;
  @Nullable
  private final View.OnClickListener I3;
  @Nullable
  private final View.OnClickListener J3;
  @Nullable
  private final View.OnClickListener K3;
  @Nullable
  private final View.OnClickListener L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131364618, 5);
    localSparseIntArray.put(2131363263, 6);
    localSparseIntArray.put(2131362800, 7);
  }
  
  public FragmentSubGSetupAvatarBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p2, p3));
  }
  
  private FragmentSubGSetupAvatarBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TPRefreshableButton)paramArrayOfObject[2], (RecyclerView)paramArrayOfObject[7], (ImageView)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[6], (View)paramArrayOfObject[4], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.y.setTag(null);
    setRootTag(paramView);
    this.I3 = new a(this, 3);
    this.J3 = new a(this, 4);
    this.K3 = new a(this, 1);
    this.L3 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean h(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 1L;
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
    int k = 0;
    int m = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            localg = this.p1;
            paramInt = m;
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
          localg = this.p1;
          paramInt = i;
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
        localg = this.p1;
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
      localg = this.p1;
      paramInt = k;
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
      long l = this.M3;
      this.M3 = 0L;
      SubGViewModel localSubGViewModel = this.p0;
      ObservableInt localObservableInt = null;
      boolean bool1 = false;
      boolean bool2 = (0xB & l) < 0L;
      boolean bool3 = bool1;
      if (bool2)
      {
        if (localSubGViewModel != null) {
          localObservableInt = localSubGViewModel.q;
        }
        updateRegistration(0, localObservableInt);
        int i;
        if (localObservableInt != null) {
          i = localObservableInt.get();
        } else {
          i = 0;
        }
        bool3 = bool1;
        if (i > 0) {
          bool3 = true;
        }
      }
      if ((l & 0x8) != 0L)
      {
        this.c.setOnClickListener(this.L3);
        this.f.setOnClickListener(this.K3);
        this.x.setOnClickListener(this.J3);
        this.y.setOnClickListener(this.I3);
      }
      if (bool2) {
        b.Q(this.y, bool3);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.M3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.p1 = paramg;
    try
    {
      this.M3 |= 0x4;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.M3 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable SubGViewModel paramSubGViewModel)
  {
    this.p0 = paramSubGViewModel;
    try
    {
      this.M3 |= 0x2;
      notifyPropertyChanged(94);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return h((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (94 == paramInt)
    {
      l((SubGViewModel)paramObject);
    }
    else
    {
      if (79 != paramInt) {
        break label36;
      }
      i((g)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGSetupAvatarBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */