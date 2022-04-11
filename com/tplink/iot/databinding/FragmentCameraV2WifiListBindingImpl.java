package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWifiListViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import java.util.List;

public class FragmentCameraV2WifiListBindingImpl
  extends FragmentCameraV2WifiListBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts J3;
  @Nullable
  private static final SparseIntArray K3;
  @NonNull
  private final RelativeLayout L3;
  @NonNull
  private final RelativeLayout M3;
  @NonNull
  private final RelativeLayout N3;
  @Nullable
  private final View.OnClickListener O3;
  @Nullable
  private final View.OnClickListener P3;
  @Nullable
  private final View.OnClickListener Q3;
  @Nullable
  private final View.OnClickListener R3;
  @Nullable
  private final View.OnClickListener S3;
  private long T3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    K3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 9);
    localSparseIntArray.put(2131364688, 10);
    localSparseIntArray.put(2131364674, 11);
    localSparseIntArray.put(2131363277, 12);
  }
  
  public FragmentCameraV2WifiListBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 13, J3, K3));
  }
  
  private FragmentCameraV2WifiListBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (Button)paramArrayOfObject[6], (Button)paramArrayOfObject[7], (LinearLayout)paramArrayOfObject[12], (RecyclerView)paramArrayOfObject[4], (Toolbar)paramArrayOfObject[9], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[11], (TextView)paramArrayOfObject[10]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[2];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[5];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    setRootTag(paramView);
    this.O3 = new a(this, 3);
    this.P3 = new a(this, 1);
    this.Q3 = new a(this, 5);
    this.R3 = new a(this, 4);
    this.S3 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean h(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean i(ObservableList<Wifi> paramObservableList, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x2;
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
    int m = 0;
    int n = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5)
            {
              localg = this.I3;
              paramInt = n;
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
            localg = this.I3;
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
          localg = this.I3;
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
        localg = this.I3;
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
      localg = this.I3;
      paramInt = m;
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
      long l1 = this.T3;
      this.T3 = 0L;
      CameraOnBoardingViewModel localCameraOnBoardingViewModel = this.H3;
      ObservableList localObservableList = null;
      ObservableBoolean localObservableBoolean = null;
      int i = 0;
      int j = 0;
      int k;
      boolean bool1;
      int m;
      long l2;
      if ((l1 & 0x2B) != 0L)
      {
        if (localCameraOnBoardingViewModel != null)
        {
          localObservableBoolean = localCameraOnBoardingViewModel.k;
          localObservableList = localCameraOnBoardingViewModel.i;
        }
        else
        {
          localObservableList = null;
        }
        updateRegistration(0, localObservableBoolean);
        k = 1;
        updateRegistration(1, localObservableList);
        if (localObservableBoolean != null) {
          bool1 = localObservableBoolean.get();
        } else {
          bool1 = false;
        }
        boolean bool2 = (l1 & 0x2A) < 0L;
        if (bool2)
        {
          if (localObservableList != null) {
            m = localObservableList.size();
          } else {
            m = 0;
          }
          if (m != 0) {
            k = 0;
          }
          l2 = l1;
          if (bool2)
          {
            if (k != 0)
            {
              l2 = l1 | 0x80;
              l1 = 512L;
            }
            else
            {
              l2 = l1 | 0x40;
              l1 = 256L;
            }
            l2 |= l1;
          }
          if (k != 0) {
            m = 8;
          } else {
            m = 0;
          }
          if (k != 0) {
            k = j;
          } else {
            k = 8;
          }
          j = m;
          m = k;
          k = j;
        }
        else
        {
          m = 0;
          l2 = l1;
          k = i;
        }
      }
      else
      {
        m = 0;
        bool1 = false;
        k = i;
        l2 = l1;
      }
      if ((0x20 & l2) != 0L)
      {
        this.c.setOnClickListener(this.O3);
        this.d.setOnClickListener(this.R3);
        this.y.setOnClickListener(this.Q3);
        this.z.setOnClickListener(this.S3);
        this.p0.setOnClickListener(this.P3);
      }
      if ((0x2A & l2) != 0L)
      {
        this.M3.setVisibility(k);
        this.N3.setVisibility(m);
      }
      if ((l2 & 0x2B) != 0L) {
        b.r(this.q, localObservableList, bool1);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.T3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.T3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.H3 = paramCameraOnBoardingViewModel;
    try
    {
      this.T3 |= 0x8;
      notifyPropertyChanged(68);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable g paramg)
  {
    this.I3 = paramg;
    try
    {
      this.T3 |= 0x4;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable CameraWifiListViewModel paramCameraWifiListViewModel)
  {
    this.p3 = paramCameraWifiListViewModel;
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return false;
      }
      return i((ObservableList)paramObject, paramInt2);
    }
    return h((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      m((g)paramObject);
    }
    else if (68 == paramInt)
    {
      l((CameraOnBoardingViewModel)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      n((CameraWifiListViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2WifiListBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */