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
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public class FragmentCameraV2InstallGuideBindingImpl
  extends FragmentCameraV2InstallGuideBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p1;
  @Nullable
  private static final SparseIntArray p2;
  @Nullable
  private final View.OnClickListener H3;
  @Nullable
  private final View.OnClickListener I3;
  private long J3 = -1L;
  @NonNull
  private final RelativeLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p2 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 3);
    localSparseIntArray.put(2131363277, 4);
    localSparseIntArray.put(2131362867, 5);
  }
  
  public FragmentCameraV2InstallGuideBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p1, p2));
  }
  
  private FragmentCameraV2InstallGuideBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (TextView)paramArrayOfObject[5], (LinearLayout)paramArrayOfObject[4], (ImageView)paramArrayOfObject[1], (Toolbar)paramArrayOfObject[3], (Button)paramArrayOfObject[2]);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    this.H3 = new a(this, 1);
    this.I3 = new a(this, 2);
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
        localg = this.p0;
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
      localg = this.p0;
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
      long l = this.J3;
      this.J3 = 0L;
      if ((l & 0x8) != 0L)
      {
        this.f.setOnClickListener(this.H3);
        this.x.setOnClickListener(this.I3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.z = paramCameraOnBoardingViewModel;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.J3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.p0 = paramg;
    try
    {
      this.J3 |= 1L;
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
      this.J3 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable CameraInstallGuideViewModel paramCameraInstallGuideViewModel)
  {
    this.y = paramCameraInstallGuideViewModel;
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
      l((CameraInstallGuideViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstallGuideBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */