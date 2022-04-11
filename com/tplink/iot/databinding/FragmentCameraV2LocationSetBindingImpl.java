package com.tplink.iot.databinding;

import android.content.res.Resources;
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
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraLocationSetViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public class FragmentCameraV2LocationSetBindingImpl
  extends FragmentCameraV2LocationSetBinding
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
  @Nullable
  private final View.OnClickListener L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    I3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 3);
    localSparseIntArray.put(2131363379, 4);
    localSparseIntArray.put(2131363378, 5);
    localSparseIntArray.put(2131362022, 6);
    localSparseIntArray.put(2131363373, 7);
    localSparseIntArray.put(2131361931, 8);
  }
  
  public FragmentCameraV2LocationSetBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, H3, I3));
  }
  
  private FragmentCameraV2LocationSetBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ImageView)paramArrayOfObject[8], (RelativeLayout)paramArrayOfObject[6], (TextView)paramArrayOfObject[2], (RecyclerView)paramArrayOfObject[7], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[4], (Button)paramArrayOfObject[1], (Toolbar)paramArrayOfObject[3]);
    this.f.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.z.setTag(null);
    setRootTag(paramView);
    this.K3 = new a(this, 2);
    this.L3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean h(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 1L;
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
    g localg;
    if (paramInt != 1)
    {
      if (paramInt == 2)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.M3;
      this.M3 = 0L;
      CameraOnBoardingViewModel localCameraOnBoardingViewModel = this.p2;
      Object localObject1 = null;
      Object localObject3 = null;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = (l1 & 0x15) < 0L;
      long l2 = l1;
      if (bool3)
      {
        localObject1 = localObject3;
        if (localCameraOnBoardingViewModel != null) {
          localObject1 = localCameraOnBoardingViewModel.f;
        }
        updateRegistration(0, (Observable)localObject1);
        int i;
        if (localObject1 != null) {
          i = ((ObservableInt)localObject1).get();
        } else {
          i = 0;
        }
        bool1 = bool2;
        if (i > 0) {
          bool1 = true;
        }
        l2 = l1;
        if (bool3)
        {
          if (bool1) {
            l2 = 64L;
          } else {
            l2 = 32L;
          }
          l2 = l1 | l2;
        }
        localObject1 = this.z.getResources();
        if (bool1) {
          i = 2131952454;
        } else {
          i = 2131953843;
        }
        localObject1 = ((Resources)localObject1).getString(i);
      }
      if ((0x10 & l2) != 0L)
      {
        this.f.setOnClickListener(this.K3);
        this.z.setOnClickListener(this.L3);
      }
      if ((l2 & 0x15) != 0L)
      {
        b.Q(this.f, bool1);
        TextViewBindingAdapter.setText(this.z, (CharSequence)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.M3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p2 = paramCameraOnBoardingViewModel;
    try
    {
      this.M3 |= 0x4;
      notifyPropertyChanged(68);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.M3 = 16L;
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
      this.M3 |= 0x2;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable CameraLocationSetViewModel paramCameraLocationSetViewModel)
  {
    this.p1 = paramCameraLocationSetViewModel;
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return h((ObservableInt)paramObject, paramInt2);
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
      m((CameraLocationSetViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2LocationSetBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */