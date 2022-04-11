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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSaveSettingViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;

public class FragmentCameraV2SaveSettingBindingImpl
  extends FragmentCameraV2SaveSettingBinding
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
  private final RelativeLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p2 = localSparseIntArray;
    localSparseIntArray.put(2131362823, 2);
    localSparseIntArray.put(2131363731, 3);
    localSparseIntArray.put(2131363727, 4);
    localSparseIntArray.put(2131363739, 5);
  }
  
  public FragmentCameraV2SaveSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p1, p2));
  }
  
  private FragmentCameraV2SaveSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[4], (TPRippleBackground)paramArrayOfObject[3], (TextView)paramArrayOfObject[5]);
    this.d.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
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
      if ((l & 0x8) != 0L) {
        this.d.setOnClickListener(this.H3);
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
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.p0 = paramg;
    try
    {
      this.I3 |= 1L;
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
      this.I3 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable CameraSaveSettingViewModel paramCameraSaveSettingViewModel)
  {
    this.y = paramCameraSaveSettingViewModel;
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
      l((CameraSaveSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2SaveSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */