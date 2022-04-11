package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredCompleteViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class FragmentCameraWiredCompleteBindingImpl
  extends FragmentCameraWiredCompleteBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final RelativeLayout I3;
  @Nullable
  private final View.OnClickListener J3;
  @Nullable
  private final View.OnClickListener K3;
  private long L3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 3);
    localSparseIntArray.put(2131363166, 4);
    localSparseIntArray.put(2131364252, 5);
    localSparseIntArray.put(2131362770, 6);
    localSparseIntArray.put(2131362315, 7);
  }
  
  public FragmentCameraWiredCompleteBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p3, H3));
  }
  
  private FragmentCameraWiredCompleteBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (TPRefreshableButton)paramArrayOfObject[1], (Button)paramArrayOfObject[2], (ImageView)paramArrayOfObject[7], (TextView)paramArrayOfObject[6], (RelativeLayout)paramArrayOfObject[4], (TextView)paramArrayOfObject[5], (Toolbar)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
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
      if ((l & 0x8) != 0L)
      {
        this.c.setOnClickListener(this.K3);
        this.d.setOnClickListener(this.J3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p1 = paramCameraOnBoardingViewModel;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.L3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.p2 = paramg;
    try
    {
      this.L3 |= 1L;
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
      this.L3 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable CameraWiredCompleteViewModel paramCameraWiredCompleteViewModel)
  {
    this.p0 = paramCameraWiredCompleteViewModel;
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      i((g)paramObject);
    }
    else if (68 == paramInt)
    {
      h((CameraOnBoardingViewModel)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      l((CameraWiredCompleteViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraWiredCompleteBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */