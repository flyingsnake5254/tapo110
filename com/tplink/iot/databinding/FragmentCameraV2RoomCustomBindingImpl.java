package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRoomCustomViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;

public class FragmentCameraV2RoomCustomBindingImpl
  extends FragmentCameraV2RoomCustomBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final LinearLayout H3;
  @Nullable
  private final View.OnClickListener I3;
  private long J3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 2);
    localSparseIntArray.put(2131364688, 3);
    localSparseIntArray.put(2131362493, 4);
    localSparseIntArray.put(2131362682, 5);
    localSparseIntArray.put(2131362022, 6);
  }
  
  public FragmentCameraV2RoomCustomBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p2, p3));
  }
  
  private FragmentCameraV2RoomCustomBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (RelativeLayout)paramArrayOfObject[6], (DrawableEditText)paramArrayOfObject[4], (FlowTagLayout)paramArrayOfObject[5], (Button)paramArrayOfObject[1], (Toolbar)paramArrayOfObject[2], (TextView)paramArrayOfObject[3]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    this.I3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.p1;
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
      long l = this.J3;
      this.J3 = 0L;
      if ((l & 0x8) != 0L) {
        this.q.setOnClickListener(this.I3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p0 = paramCameraOnBoardingViewModel;
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
    this.p1 = paramg;
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
  
  public void l(@Nullable CameraRoomCustomViewModel paramCameraRoomCustomViewModel)
  {
    this.z = paramCameraRoomCustomViewModel;
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
      l((CameraRoomCustomViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2RoomCustomBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */