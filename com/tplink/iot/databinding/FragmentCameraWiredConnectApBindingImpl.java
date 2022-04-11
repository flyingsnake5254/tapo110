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
import com.tplink.libtpcontrols.TPRippleBackground;

public class FragmentCameraWiredConnectApBindingImpl
  extends FragmentCameraWiredConnectApBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  @NonNull
  private final RelativeLayout p1;
  @Nullable
  private final View.OnClickListener p2;
  private long p3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131362823, 2);
    localSparseIntArray.put(2131363731, 3);
    localSparseIntArray.put(2131363727, 4);
    localSparseIntArray.put(2131363739, 5);
  }
  
  public FragmentCameraWiredConnectApBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, z, p0));
  }
  
  private FragmentCameraWiredConnectApBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[4], (TPRippleBackground)paramArrayOfObject[3], (TextView)paramArrayOfObject[5]);
    this.d.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.p2 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.y;
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
      long l = this.p3;
      this.p3 = 0L;
      if ((l & 0x2) != 0L) {
        this.d.setOnClickListener(this.p2);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.y = paramg;
    try
    {
      this.p3 |= 1L;
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
      return this.p3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 2L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraWiredConnectApBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */