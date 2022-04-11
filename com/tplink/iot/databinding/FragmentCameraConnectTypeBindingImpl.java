package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectTypeViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class FragmentCameraConnectTypeBindingImpl
  extends FragmentCameraConnectTypeBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts H3;
  @Nullable
  private static final SparseIntArray I3;
  @NonNull
  private final RelativeLayout J3;
  @NonNull
  private final ImageView K3;
  @NonNull
  private final ImageView L3;
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
    I3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 6);
    localSparseIntArray.put(2131363166, 7);
    localSparseIntArray.put(2131364252, 8);
    localSparseIntArray.put(2131362770, 9);
    localSparseIntArray.put(2131363277, 10);
  }
  
  public FragmentCameraConnectTypeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 11, H3, I3));
  }
  
  private FragmentCameraConnectTypeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[9], (RelativeLayout)paramArrayOfObject[7], (LinearLayout)paramArrayOfObject[10], (TPRefreshableButton)paramArrayOfObject[5], (TextView)paramArrayOfObject[8], (Toolbar)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[3]);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[2];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[4];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    setRootTag(paramView);
    this.M3 = new a(this, 2);
    this.N3 = new a(this, 3);
    this.O3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean h(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
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
      long l1 = this.P3;
      this.P3 = 0L;
      Object localObject1 = this.p1;
      Object localObject2 = null;
      Object localObject3 = null;
      boolean bool1 = (l1 & 0x19) < 0L;
      long l2;
      Object localObject5;
      if (bool1)
      {
        if (localObject1 != null) {
          localObject3 = ((CameraConnectTypeViewModel)localObject1).a;
        }
        boolean bool2 = false;
        updateRegistration(0, (Observable)localObject3);
        if (localObject3 != null) {
          bool2 = ((ObservableBoolean)localObject3).get();
        }
        l2 = l1;
        if (bool1)
        {
          if (bool2)
          {
            l2 = l1 | 0x40 | 0x100 | 0x400;
            l1 = 4096L;
          }
          else
          {
            l2 = l1 | 0x20 | 0x80 | 0x200;
            l1 = 2048L;
          }
          l2 |= l1;
        }
        localObject3 = this.z.getContext();
        if (bool2) {
          localObject3 = AppCompatResources.getDrawable((Context)localObject3, 2131230866);
        } else {
          localObject3 = AppCompatResources.getDrawable((Context)localObject3, 2131230867);
        }
        localObject2 = this.K3.getContext();
        int i;
        if (bool2) {
          i = 2131231654;
        } else {
          i = 2131231655;
        }
        localObject1 = AppCompatResources.getDrawable((Context)localObject2, i);
        localObject2 = this.L3.getContext();
        if (bool2) {
          i = 2131231657;
        } else {
          i = 2131231656;
        }
        Drawable localDrawable = AppCompatResources.getDrawable((Context)localObject2, i);
        if (bool2) {
          localObject2 = AppCompatResources.getDrawable(this.p0.getContext(), 2131230867);
        } else {
          localObject2 = AppCompatResources.getDrawable(this.p0.getContext(), 2131230866);
        }
        localObject5 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localDrawable;
      }
      else
      {
        localObject5 = null;
        localObject3 = localObject5;
        localObject1 = localObject3;
        l2 = l1;
      }
      if ((0x19 & l2) != 0L)
      {
        ImageViewBindingAdapter.setImageDrawable(this.K3, (Drawable)localObject2);
        ImageViewBindingAdapter.setImageDrawable(this.L3, (Drawable)localObject1);
        ViewBindingAdapter.setBackground(this.z, (Drawable)localObject5);
        ViewBindingAdapter.setBackground(this.p0, (Drawable)localObject3);
      }
      if ((l2 & 0x10) != 0L)
      {
        this.q.setOnClickListener(this.N3);
        this.z.setOnClickListener(this.O3);
        this.p0.setOnClickListener(this.M3);
      }
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
  
  public void i(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p2 = paramCameraOnBoardingViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.P3 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable g paramg)
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
  
  public void m(@Nullable CameraConnectTypeViewModel paramCameraConnectTypeViewModel)
  {
    this.p1 = paramCameraConnectTypeViewModel;
    try
    {
      this.P3 |= 0x8;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return h((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      l((g)paramObject);
    }
    else if (68 == paramInt)
    {
      i((CameraOnBoardingViewModel)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      m((CameraConnectTypeViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraConnectTypeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */