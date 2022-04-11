package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public class FragmentCameraV2InstallGuideWaterproofLayoutBindingImpl
  extends FragmentCameraV2InstallGuideWaterproofLayoutBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  private long I3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131362865, 1);
    localSparseIntArray.put(2131362172, 2);
    localSparseIntArray.put(2131363354, 3);
    localSparseIntArray.put(2131363263, 4);
    localSparseIntArray.put(2131363355, 5);
    localSparseIntArray.put(2131363264, 6);
  }
  
  public FragmentCameraV2InstallGuideWaterproofLayoutBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p3, H3));
  }
  
  private FragmentCameraV2InstallGuideWaterproofLayoutBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[4], (LinearLayout)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[0], (LinearLayout)paramArrayOfObject[3], (LinearLayout)paramArrayOfObject[5]);
    this.x.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.I3 = 0L;
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
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.p2 = paramg;
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
  
  public void l(@Nullable CameraInstallGuideViewModel paramCameraInstallGuideViewModel)
  {
    this.p0 = paramCameraInstallGuideViewModel;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstallGuideWaterproofLayoutBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */