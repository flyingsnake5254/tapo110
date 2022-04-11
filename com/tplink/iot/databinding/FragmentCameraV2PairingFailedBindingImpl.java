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
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.PairingFailedViewModel;
import com.tplink.iot.widget.PointTextView;

public class FragmentCameraV2PairingFailedBindingImpl
  extends FragmentCameraV2PairingFailedBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts H3;
  @Nullable
  private static final SparseIntArray I3;
  @NonNull
  private final LinearLayout J3;
  @Nullable
  private final View.OnClickListener K3;
  private long L3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    I3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 2);
    localSparseIntArray.put(2131363277, 3);
    localSparseIntArray.put(2131362827, 4);
    localSparseIntArray.put(2131363678, 5);
    localSparseIntArray.put(2131363679, 6);
    localSparseIntArray.put(2131363680, 7);
    localSparseIntArray.put(2131364385, 8);
  }
  
  public FragmentCameraV2PairingFailedBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, H3, I3));
  }
  
  private FragmentCameraV2PairingFailedBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[1], (ImageView)paramArrayOfObject[4], (LinearLayout)paramArrayOfObject[3], (PointTextView)paramArrayOfObject[5], (PointTextView)paramArrayOfObject[6], (PointTextView)paramArrayOfObject[7], (Toolbar)paramArrayOfObject[2], (TextView)paramArrayOfObject[8]);
    this.c.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.K3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.p3;
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
      long l = this.L3;
      this.L3 = 0L;
      if ((l & 0x8) != 0L) {
        this.c.setOnClickListener(this.K3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p2 = paramCameraOnBoardingViewModel;
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
    this.p3 = paramg;
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
  
  public void l(@Nullable PairingFailedViewModel paramPairingFailedViewModel)
  {
    this.p1 = paramPairingFailedViewModel;
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
      l((PairingFailedViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2PairingFailedBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */