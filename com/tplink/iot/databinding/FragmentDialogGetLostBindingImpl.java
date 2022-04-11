package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
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

public class FragmentDialogGetLostBindingImpl
  extends FragmentDialogGetLostBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray p0;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts z;
  private long H3 = -1L;
  @NonNull
  private final RelativeLayout p1;
  @Nullable
  private final View.OnClickListener p2;
  @Nullable
  private final View.OnClickListener p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p0 = localSparseIntArray;
    localSparseIntArray.put(2131363586, 3);
    localSparseIntArray.put(2131363588, 4);
    localSparseIntArray.put(2131363589, 5);
  }
  
  public FragmentDialogGetLostBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, z, p0));
  }
  
  private FragmentDialogGetLostBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.c.setTag(null);
    this.f.setTag(null);
    setRootTag(paramView);
    this.p2 = new a(this, 2);
    this.p3 = new a(this, 1);
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
        localg = this.y;
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
      localg = this.y;
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
      long l = this.H3;
      this.H3 = 0L;
      if ((l & 0x2) != 0L)
      {
        this.c.setOnClickListener(this.p2);
        this.f.setOnClickListener(this.p3);
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
      this.H3 |= 1L;
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
      return this.H3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.H3 = 2L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentDialogGetLostBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */