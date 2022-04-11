package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public class ActivityVideoPlayNewIpcBindingImpl
  extends ActivityVideoPlayNewIpcBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts J3;
  @Nullable
  private static final SparseIntArray K3;
  @NonNull
  private final CameraLoadingView L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    K3 = localSparseIntArray;
    localSparseIntArray.put(2131364250, 5);
    localSparseIntArray.put(2131364249, 6);
    localSparseIntArray.put(2131364275, 7);
    localSparseIntArray.put(2131364251, 8);
    localSparseIntArray.put(2131364767, 9);
    localSparseIntArray.put(2131363740, 10);
    localSparseIntArray.put(2131362333, 11);
    localSparseIntArray.put(2131362658, 12);
  }
  
  public ActivityVideoPlayNewIpcBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 13, J3, K3));
  }
  
  private ActivityVideoPlayNewIpcBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (FrameLayout)paramArrayOfObject[11], (FrameLayout)paramArrayOfObject[12], (FrameLayout)paramArrayOfObject[4], (TipsBar)paramArrayOfObject[10], (RelativeLayout)paramArrayOfObject[0], (ConstraintLayout)paramArrayOfObject[1], (ImageView)paramArrayOfObject[6], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[8], (Toolbar)paramArrayOfObject[7], (View)paramArrayOfObject[2], (FrameLayout)paramArrayOfObject[9]);
    this.f.setTag(null);
    paramDataBindingComponent = (CameraLoadingView)paramArrayOfObject[3];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.p3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.M3;
      this.M3 = 0L;
      VideoPlayViewModel localVideoPlayViewModel = this.I3;
      boolean bool1;
      label81:
      boolean bool2;
      label133:
      boolean bool3;
      label185:
      long l2;
      int i;
      if ((0x3F & l1) != 0L)
      {
        ObservableBoolean localObservableBoolean;
        if ((l1 & 0x31) != 0L)
        {
          if (localVideoPlayViewModel != null) {
            localObservableBoolean = localVideoPlayViewModel.g;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(0, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool1 = localObservableBoolean.get();
            break label81;
          }
        }
        bool1 = false;
        if ((l1 & 0x32) != 0L)
        {
          if (localVideoPlayViewModel != null) {
            localObservableBoolean = localVideoPlayViewModel.q;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool2 = localObservableBoolean.get();
            break label133;
          }
        }
        bool2 = false;
        if ((l1 & 0x34) != 0L)
        {
          if (localVideoPlayViewModel != null) {
            localObservableBoolean = localVideoPlayViewModel.r;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null)
          {
            bool3 = localObservableBoolean.get();
            break label185;
          }
        }
        bool3 = false;
        boolean bool4 = (l1 & 0x38) < 0L;
        l2 = l1;
        if (bool4)
        {
          if (localVideoPlayViewModel != null) {
            localObservableBoolean = localVideoPlayViewModel.u;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(3, localObservableBoolean);
          boolean bool5;
          if (localObservableBoolean != null) {
            bool5 = localObservableBoolean.get();
          } else {
            bool5 = false;
          }
          l2 = l1;
          if (bool4)
          {
            if (bool5) {
              l2 = 128L;
            } else {
              l2 = 64L;
            }
            l2 = l1 | l2;
          }
          if (!bool5)
          {
            i = 4;
            break label311;
          }
        }
        i = 0;
      }
      else
      {
        i = 0;
        bool1 = false;
        bool2 = false;
        bool3 = false;
        l2 = l1;
      }
      label311:
      if ((l2 & 0x34) != 0L) {
        b.Q(this.f, bool3);
      }
      if ((l2 & 0x32) != 0L) {
        b.K(this.L3, Boolean.valueOf(bool2));
      }
      if ((0x31 & l2) != 0L) {
        b.Q(this.y, bool1);
      }
      if ((l2 & 0x38) != 0L) {
        this.p3.setVisibility(i);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.I3 = paramVideoPlayViewModel;
    try
    {
      this.M3 |= 0x10;
      notifyPropertyChanged(74);
      super.requestRebind();
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
  
  public void invalidateAll()
  {
    try
    {
      this.M3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            return false;
          }
          return i((ObservableBoolean)paramObject, paramInt2);
        }
        return l((ObservableBoolean)paramObject, paramInt2);
      }
      return n((ObservableBoolean)paramObject, paramInt2);
    }
    return m((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (74 == paramInt)
    {
      h((VideoPlayViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityVideoPlayNewIpcBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */