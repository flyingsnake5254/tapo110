package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;

public class FragmentSubGSearchingDeviceBindingImpl
  extends FragmentSubGSearchingDeviceBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts L3;
  @Nullable
  private static final SparseIntArray M3;
  @Nullable
  private final View.OnClickListener N3;
  private long O3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    M3 = localSparseIntArray;
    localSparseIntArray.put(2131362823, 2);
    localSparseIntArray.put(2131361979, 3);
    localSparseIntArray.put(2131362814, 4);
    localSparseIntArray.put(2131362815, 5);
    localSparseIntArray.put(2131363732, 6);
    localSparseIntArray.put(2131363730, 7);
    localSparseIntArray.put(2131363729, 8);
    localSparseIntArray.put(2131363733, 9);
    localSparseIntArray.put(2131363737, 10);
    localSparseIntArray.put(2131363738, 11);
    localSparseIntArray.put(2131363739, 12);
  }
  
  public FragmentSubGSearchingDeviceBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 13, L3, M3));
  }
  
  private FragmentSubGSearchingDeviceBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[8], (ImageView)paramArrayOfObject[7], (TPRippleBackground)paramArrayOfObject[6], (TPRippleBackground)paramArrayOfObject[9], (ImageView)paramArrayOfObject[10], (ImageView)paramArrayOfObject[11], (TextView)paramArrayOfObject[12], (RelativeLayout)paramArrayOfObject[0]);
    this.x.setTag(null);
    this.I3.setTag(null);
    setRootTag(paramView);
    this.N3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.K3;
    if (localg != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      localg.onClick(paramView);
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.O3;
      this.O3 = 0L;
      if ((l & 0x4) != 0L) {
        this.x.setOnClickListener(this.N3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.K3 = paramg;
    try
    {
      this.O3 |= 0x2;
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
      return this.O3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable SubGViewModel paramSubGViewModel)
  {
    this.J3 = paramSubGViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.O3 = 4L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGSearchingDeviceBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */