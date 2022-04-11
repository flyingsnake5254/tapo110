package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public class FragmentSubGHubListBindingImpl
  extends FragmentSubGHubListBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p1;
  @Nullable
  private static final SparseIntArray p2;
  @Nullable
  private final View.OnClickListener H3;
  private long I3 = -1L;
  @NonNull
  private final LinearLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p2 = localSparseIntArray;
    localSparseIntArray.put(2131363597, 2);
    localSparseIntArray.put(2131364514, 3);
    localSparseIntArray.put(2131363315, 4);
    localSparseIntArray.put(2131363573, 5);
    localSparseIntArray.put(2131362676, 6);
  }
  
  public FragmentSubGHubListBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p1, p2));
  }
  
  private FragmentSubGHubListBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (FrameLayout)paramArrayOfObject[6], (ImageView)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[4], (RecyclerView)paramArrayOfObject[5], (RecyclerView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.H3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.p0;
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
      long l = this.I3;
      this.I3 = 0L;
      if ((l & 0x4) != 0L) {
        this.d.setOnClickListener(this.H3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.p0 = paramg;
    try
    {
      this.I3 |= 0x2;
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
  
  public void i(@Nullable SubGViewModel paramSubGViewModel)
  {
    this.z = paramSubGViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 4L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGHubListBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */