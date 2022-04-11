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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTapoCareIntroduceViewModel;

public class FragmentCameraV2IntroduceTapoCareBindingImpl
  extends FragmentCameraV2IntroduceTapoCareBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final LinearLayout K3;
  @Nullable
  private final View.OnClickListener L3;
  @Nullable
  private final View.OnClickListener M3;
  @Nullable
  private final View.OnClickListener N3;
  @Nullable
  private final View.OnClickListener O3;
  private long P3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    J3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 5);
    localSparseIntArray.put(2131363277, 6);
    localSparseIntArray.put(2131364688, 7);
    localSparseIntArray.put(2131364684, 8);
    localSparseIntArray.put(2131362820, 9);
  }
  
  public FragmentCameraV2IntroduceTapoCareBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, I3, J3));
  }
  
  private FragmentCameraV2IntroduceTapoCareBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[2], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[9], (LinearLayout)paramArrayOfObject[6], (Toolbar)paramArrayOfObject[5], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[7]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.L3 = new a(this, 3);
    this.M3 = new a(this, 4);
    this.N3 = new a(this, 1);
    this.O3 = new a(this, 2);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            localg = this.H3;
            paramInt = m;
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
          localg = this.H3;
          paramInt = i;
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
        localg = this.H3;
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
      localg = this.H3;
      paramInt = k;
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
      if ((l & 0x8) != 0L)
      {
        this.c.setOnClickListener(this.O3);
        this.d.setOnClickListener(this.M3);
        this.f.setOnClickListener(this.N3);
        this.q.setOnClickListener(this.L3);
      }
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
      return this.P3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.H3 = paramg;
    try
    {
      this.P3 |= 1L;
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
      this.P3 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable CameraTapoCareIntroduceViewModel paramCameraTapoCareIntroduceViewModel)
  {
    this.p2 = paramCameraTapoCareIntroduceViewModel;
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
      l((CameraTapoCareIntroduceViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2IntroduceTapoCareBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */