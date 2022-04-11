package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.basic.RegionEditViewModel;

public class ActivityPrivacyMaskZonesBindingLandImpl
  extends ActivityPrivacyMaskZonesBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts V3;
  @Nullable
  private static final SparseIntArray W3;
  private long X3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    W3 = localSparseIntArray;
    localSparseIntArray.put(2131364030, 9);
    localSparseIntArray.put(2131364032, 10);
    localSparseIntArray.put(2131361911, 11);
    localSparseIntArray.put(2131362391, 12);
  }
  
  public ActivityPrivacyMaskZonesBindingLandImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 13, V3, W3));
  }
  
  private ActivityPrivacyMaskZonesBindingLandImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (View)paramArrayOfObject[11], null, (View)paramArrayOfObject[5], null, (ImageView)paramArrayOfObject[4], null, (ImageView)paramArrayOfObject[3], null, (View)paramArrayOfObject[2], (ImageView)paramArrayOfObject[6], null, (ImageView)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[12], (ImageView)paramArrayOfObject[7], (CameraLoadingView)paramArrayOfObject[8], null, (View)paramArrayOfObject[0], (FrameLayout)paramArrayOfObject[9], null, (ImageView)paramArrayOfObject[10], null, null, null);
    this.f.setTag(null);
    this.x.setTag(null);
    this.z.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.H3.setTag(null);
    this.J3.setTag(null);
    this.K3.setTag(null);
    this.M3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.X3 |= 0x2;
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
        this.X3 |= 1L;
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
        this.X3 |= 0x4;
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
      long l1 = this.X3;
      this.X3 = 0L;
      View.OnClickListener localOnClickListener = this.U3;
      RegionEditViewModel localRegionEditViewModel = this.T3;
      int i;
      int j;
      if ((0x37 & l1) != 0L)
      {
        i = 8;
        boolean bool1 = (l1 & 0x31) < 0L;
        long l2 = l1;
        ObservableBoolean localObservableBoolean;
        if (bool1)
        {
          if (localRegionEditViewModel != null) {
            localObservableBoolean = localRegionEditViewModel.b;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(0, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l3 = l1;
          if (bool1)
          {
            if (bool2) {
              l3 = 512L;
            } else {
              l3 = 256L;
            }
            l3 = l1 | l3;
          }
          l2 = l3;
          if (bool2)
          {
            j = 8;
            break label155;
          }
        }
        j = 0;
        long l3 = l2;
        label155:
        boolean bool3 = (l3 & 0x32) < 0L;
        l2 = l3;
        if (bool3)
        {
          if (localRegionEditViewModel != null) {
            localObservableBoolean = localRegionEditViewModel.a;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l1 = l3;
          if (bool3)
          {
            if (bool2) {
              l1 = 128L;
            } else {
              l1 = 64L;
            }
            l1 = l3 | l1;
          }
          l2 = l1;
          if (bool2) {}
        }
        else
        {
          i = 0;
          l1 = l2;
        }
        if ((l1 & 0x34) != 0L)
        {
          if (localRegionEditViewModel != null) {
            localObservableBoolean = localRegionEditViewModel.d;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          boolean bool4 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
          bool5 = bool2;
          bool2 = bool4;
          break label354;
        }
      }
      else
      {
        j = 0;
        i = 0;
      }
      boolean bool2 = false;
      boolean bool5 = false;
      label354:
      if ((l1 & 0x32) != 0L) {
        this.f.setVisibility(i);
      }
      if ((0x28 & l1) != 0L)
      {
        this.x.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p2.setOnClickListener(localOnClickListener);
        this.H3.setOnClickListener(localOnClickListener);
        this.J3.setOnClickListener(localOnClickListener);
      }
      if ((0x31 & l1) != 0L) {
        this.p1.setVisibility(j);
      }
      if ((l1 & 0x34) != 0L)
      {
        b.c(this.J3, Boolean.valueOf(bool5), null);
        b.K(this.K3, Boolean.valueOf(bool2));
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.U3 = paramOnClickListener;
    try
    {
      this.X3 |= 0x8;
      notifyPropertyChanged(55);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.X3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable RegionEditViewModel paramRegionEditViewModel)
  {
    this.T3 = paramRegionEditViewModel;
    try
    {
      this.X3 |= 0x10;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.X3 = 32L;
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
        if (paramInt1 != 2) {
          return false;
        }
        return n((ObservableBoolean)paramObject, paramInt2);
      }
      return l((ObservableBoolean)paramObject, paramInt2);
    }
    return m((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (55 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      i((RegionEditViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPrivacyMaskZonesBindingLandImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */