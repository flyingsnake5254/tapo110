package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class FragmentSubGCompleteBindingImpl
  extends FragmentSubGCompleteBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final ScrollView H3;
  @Nullable
  private final View.OnClickListener I3;
  @Nullable
  private final View.OnClickListener J3;
  private long K3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131363277, 3);
    localSparseIntArray.put(2131364688, 4);
    localSparseIntArray.put(2131364676, 5);
    localSparseIntArray.put(2131362818, 6);
    localSparseIntArray.put(2131364681, 7);
  }
  
  public FragmentSubGCompleteBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p2, p3));
  }
  
  private FragmentSubGCompleteBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[2], (ImageView)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[3], (TPRefreshableButton)paramArrayOfObject[1], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[4]);
    this.c.setTag(null);
    paramDataBindingComponent = (ScrollView)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    this.I3 = new a(this, 2);
    this.J3 = new a(this, 1);
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
      long l = this.K3;
      this.K3 = 0L;
      if ((l & 0x4) != 0L)
      {
        this.c.setOnClickListener(this.I3);
        this.q.setOnClickListener(this.J3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.p1 = paramg;
    try
    {
      this.K3 |= 0x2;
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
      return this.K3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable SubGViewModel paramSubGViewModel)
  {
    this.p0 = paramSubGViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.K3 = 4L;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGCompleteBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */