package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallPreviewViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import com.tplink.iot.widget.cameralive.y;
import io.reactivex.m0.d;

public class FragmentCameraV2InstallPreviewBindingImpl
  extends FragmentCameraV2InstallPreviewBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts J3;
  @Nullable
  private static final SparseIntArray K3;
  @NonNull
  private final LinearLayout L3;
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
    K3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 5);
    localSparseIntArray.put(2131363277, 6);
    localSparseIntArray.put(2131364688, 7);
    localSparseIntArray.put(2131364676, 8);
  }
  
  public FragmentCameraV2InstallPreviewBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, J3, K3));
  }
  
  private FragmentCameraV2InstallPreviewBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[3], (LinearLayout)paramArrayOfObject[6], (ImageView)paramArrayOfObject[1], (Toolbar)paramArrayOfObject[5], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[7], (VideoSurfaceViewLayout)paramArrayOfObject[2]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.p0.setTag(null);
    setRootTag(paramView);
    this.M3 = new a(this, 2);
    this.N3 = new a(this, 3);
    this.O3 = new a(this, 1);
    invalidateAll();
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          localg = this.p3;
          paramInt = k;
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
        localg = this.p3;
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
      localg = this.p3;
      paramInt = j;
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
      d locald = this.H3;
      String str = this.I3;
      if ((l & 0x20) != 0L)
      {
        this.c.setOnClickListener(this.N3);
        this.d.setOnClickListener(this.M3);
        this.q.setOnClickListener(this.O3);
      }
      if ((0x21 & l) != 0L) {
        y.f(this.p0, locald);
      }
      if ((0x24 & l) != 0L) {
        y.g(this.p0, str);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable d<Integer> paramd)
  {
    this.H3 = paramd;
    try
    {
      this.P3 |= 1L;
      notifyPropertyChanged(86);
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
  
  public void i(@Nullable String paramString)
  {
    this.I3 = paramString;
    try
    {
      this.P3 |= 0x4;
      notifyPropertyChanged(101);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.P3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p2 = paramCameraOnBoardingViewModel;
  }
  
  public void m(@Nullable g paramg)
  {
    this.p3 = paramg;
    try
    {
      this.P3 |= 0x2;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable CameraInstallPreviewViewModel paramCameraInstallPreviewViewModel)
  {
    this.p1 = paramCameraInstallPreviewViewModel;
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (86 == paramInt)
    {
      h((d)paramObject);
    }
    else if (79 == paramInt)
    {
      m((g)paramObject);
    }
    else if (101 == paramInt)
    {
      i((String)paramObject);
    }
    else if (68 == paramInt)
    {
      l((CameraOnBoardingViewModel)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label87;
      }
      n((CameraInstallPreviewViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label87:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstallPreviewBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */