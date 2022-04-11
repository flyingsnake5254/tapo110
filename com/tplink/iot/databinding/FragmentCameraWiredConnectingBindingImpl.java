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
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;

public class FragmentCameraWiredConnectingBindingImpl
  extends FragmentCameraWiredConnectingBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts M3;
  @Nullable
  private static final SparseIntArray N3;
  @Nullable
  private final View.OnClickListener O3;
  private long P3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    N3 = localSparseIntArray;
    localSparseIntArray.put(2131362823, 2);
    localSparseIntArray.put(2131361979, 3);
    localSparseIntArray.put(2131362814, 4);
    localSparseIntArray.put(2131362815, 5);
    localSparseIntArray.put(2131363732, 6);
    localSparseIntArray.put(2131363730, 7);
    localSparseIntArray.put(2131363733, 8);
    localSparseIntArray.put(2131363734, 9);
    localSparseIntArray.put(2131363737, 10);
    localSparseIntArray.put(2131363736, 11);
    localSparseIntArray.put(2131362781, 12);
    localSparseIntArray.put(2131362780, 13);
    localSparseIntArray.put(2131363739, 14);
  }
  
  public FragmentCameraWiredConnectingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 15, M3, N3));
  }
  
  private FragmentCameraWiredConnectingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[3], (TPHookView)paramArrayOfObject[13], (TPHookView)paramArrayOfObject[12], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[7], (TPRippleBackground)paramArrayOfObject[6], (TPRippleBackground)paramArrayOfObject[8], (ImageView)paramArrayOfObject[9], (ImageView)paramArrayOfObject[11], (ImageView)paramArrayOfObject[10], (TextView)paramArrayOfObject[14], (RelativeLayout)paramArrayOfObject[0]);
    this.z.setTag(null);
    this.K3.setTag(null);
    setRootTag(paramView);
    this.O3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.L3;
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
      long l = this.P3;
      this.P3 = 0L;
      if ((l & 0x2) != 0L) {
        this.z.setOnClickListener(this.O3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.L3 = paramg;
    try
    {
      this.P3 |= 1L;
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
      return this.P3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.P3 = 2L;
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
    boolean bool;
    if (79 == paramInt)
    {
      h((g)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraWiredConnectingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */