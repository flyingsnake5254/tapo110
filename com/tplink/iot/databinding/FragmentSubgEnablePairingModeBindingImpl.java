package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public class FragmentSubgEnablePairingModeBindingImpl
  extends FragmentSubgEnablePairingModeBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final LinearLayout I3;
  @Nullable
  private final View.OnClickListener J3;
  @Nullable
  private final View.OnClickListener K3;
  private long L3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131363166, 3);
    localSparseIntArray.put(2131363292, 4);
    localSparseIntArray.put(2131364688, 5);
    localSparseIntArray.put(2131364674, 6);
    localSparseIntArray.put(2131363045, 7);
    localSparseIntArray.put(2131364354, 8);
  }
  
  public FragmentSubgEnablePairingModeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, p3, H3));
  }
  
  private FragmentSubgEnablePairingModeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (VariousImageViewLayout)paramArrayOfObject[7], (RelativeLayout)paramArrayOfObject[3], (LinearLayout)paramArrayOfObject[4], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.J3 = new a(this, 2);
    this.K3 = new a(this, 1);
    invalidateAll();
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
        localg = this.p2;
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
      localg = this.p2;
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
      long l = this.L3;
      this.L3 = 0L;
      if ((l & 0x4) != 0L)
      {
        this.c.setOnClickListener(this.J3);
        this.d.setOnClickListener(this.K3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.p2 = paramg;
    try
    {
      this.L3 |= 0x2;
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
      return this.L3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable SubGViewModel paramSubGViewModel)
  {
    this.p1 = paramSubGViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.L3 = 4L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (94 == paramInt)
    {
      i((SubGViewModel)paramObject);
    }
    else
    {
      if (79 != paramInt) {
        break label36;
      }
      h((g)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubgEnablePairingModeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */