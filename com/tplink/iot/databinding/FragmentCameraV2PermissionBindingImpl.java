package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraPermissionViewModel;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

public class FragmentCameraV2PermissionBindingImpl
  extends FragmentCameraV2PermissionBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final ScrollView K3;
  private long L3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    J3 = localSparseIntArray;
    localSparseIntArray.put(2131364674, 1);
    localSparseIntArray.put(2131362678, 2);
    localSparseIntArray.put(2131363711, 3);
    localSparseIntArray.put(2131362851, 4);
    localSparseIntArray.put(2131363259, 5);
    localSparseIntArray.put(2131362841, 6);
    localSparseIntArray.put(2131363377, 7);
    localSparseIntArray.put(2131364571, 8);
    localSparseIntArray.put(2131362845, 9);
  }
  
  public FragmentCameraV2PermissionBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, I3, J3));
  }
  
  private FragmentCameraV2PermissionBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (FrameLayout)paramArrayOfObject[2], (ImageView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[9], (ImageView)paramArrayOfObject[4], (LinearLayout)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[7], (TPCircleProgressBar)paramArrayOfObject[3], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[1]);
    paramDataBindingComponent = (ScrollView)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.L3 = 0L;
      return;
    }
    finally {}
  }
  
  public void h(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p3 = paramCameraOnBoardingViewModel;
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
    this.H3 = paramg;
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
  
  public void l(@Nullable CameraPermissionViewModel paramCameraPermissionViewModel)
  {
    this.p2 = paramCameraPermissionViewModel;
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
      l((CameraPermissionViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2PermissionBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */