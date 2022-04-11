package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.tplink.iot.widget.PointTextView;

public class FragmentSubGNoFoundBindingImpl
  extends FragmentSubGNoFoundBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts K3;
  @Nullable
  private static final SparseIntArray L3;
  @NonNull
  private final LinearLayout M3;
  @Nullable
  private final View.OnClickListener N3;
  @Nullable
  private final View.OnClickListener O3;
  private long P3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    L3 = localSparseIntArray;
    localSparseIntArray.put(2131363277, 3);
    localSparseIntArray.put(2131362827, 4);
    localSparseIntArray.put(2131364675, 5);
    localSparseIntArray.put(2131364676, 6);
    localSparseIntArray.put(2131364677, 7);
    localSparseIntArray.put(2131364679, 8);
    localSparseIntArray.put(2131364680, 9);
    localSparseIntArray.put(2131364606, 10);
    localSparseIntArray.put(2131363108, 11);
    localSparseIntArray.put(2131364385, 12);
  }
  
  public FragmentSubGNoFoundBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 13, K3, L3));
  }
  
  private FragmentSubGNoFoundBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[2], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[1], (VariousImageViewLayout)paramArrayOfObject[11], (LinearLayout)paramArrayOfObject[3], (TextView)paramArrayOfObject[12], (TextView)paramArrayOfObject[10], (PointTextView)paramArrayOfObject[5], (PointTextView)paramArrayOfObject[6], (PointTextView)paramArrayOfObject[7], (PointTextView)paramArrayOfObject[8], (PointTextView)paramArrayOfObject[9]);
    this.c.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.N3 = new a(this, 1);
    this.O3 = new a(this, 2);
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
        localg = this.J3;
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
      localg = this.J3;
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
      long l = this.P3;
      this.P3 = 0L;
      if ((l & 0x4) != 0L)
      {
        this.c.setOnClickListener(this.O3);
        this.f.setOnClickListener(this.N3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.J3 = paramg;
    try
    {
      this.P3 |= 0x2;
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
  
  public void i(@Nullable SubGViewModel paramSubGViewModel)
  {
    this.I3 = paramSubGViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.P3 = 4L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGNoFoundBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */