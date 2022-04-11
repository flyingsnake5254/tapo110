package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.basic.RegionEditViewModel;

public class ActivityPrivacyMaskZonesBindingImpl
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
    localSparseIntArray.put(2131364275, 9);
    localSparseIntArray.put(2131364252, 10);
    localSparseIntArray.put(2131364031, 11);
    localSparseIntArray.put(2131364030, 12);
    localSparseIntArray.put(2131364032, 13);
    localSparseIntArray.put(2131361911, 14);
  }
  
  public ActivityPrivacyMaskZonesBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 15, V3, W3));
  }
  
  private ActivityPrivacyMaskZonesBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (View)paramArrayOfObject[14], (View)paramArrayOfObject[6], null, (FrameLayout)paramArrayOfObject[5], null, (FrameLayout)paramArrayOfObject[4], null, (View)paramArrayOfObject[3], null, null, (FrameLayout)paramArrayOfObject[2], null, null, null, (CameraLoadingView)paramArrayOfObject[8], (ImageView)paramArrayOfObject[1], (View)paramArrayOfObject[0], (FrameLayout)paramArrayOfObject[12], (TextView)paramArrayOfObject[11], (ImageView)paramArrayOfObject[13], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[10], (Toolbar)paramArrayOfObject[9]);
    this.d.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.p0.setTag(null);
    this.p3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.M3.setTag(null);
    this.Q3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
        this.X3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.X3 |= 0x8;
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
      long l3;
      int j;
      label155:
      int k;
      if ((0x6F & l1) != 0L)
      {
        i = 8;
        boolean bool1 = (l1 & 0x61) < 0L;
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
              l3 = 1024L;
            } else {
              l3 = 512L;
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
        l3 = l2;
        boolean bool3 = (l3 & 0x62) < 0L;
        l1 = l3;
        if (bool3)
        {
          if (localRegionEditViewModel != null) {
            localObservableBoolean = localRegionEditViewModel.c;
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
              l1 = 4096L;
            } else {
              l1 = 2048L;
            }
            l1 = l3 | l1;
          }
          if (!bool2)
          {
            k = 8;
            l3 = l1;
            break label270;
          }
        }
        k = 0;
        l3 = l1;
        label270:
        boolean bool4 = (l3 & 0x64) < 0L;
        if (bool4)
        {
          if (localRegionEditViewModel != null) {
            localObservableBoolean = localRegionEditViewModel.a;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l1 = l3;
          if (bool4)
          {
            if (bool2) {
              l1 = 256L;
            } else {
              l1 = 128L;
            }
            l1 = l3 | l1;
          }
          if (!bool2) {
            i = 0;
          }
          l3 = l1;
        }
        else
        {
          i = 0;
        }
        if ((l3 & 0x68) != 0L)
        {
          if (localRegionEditViewModel != null) {
            localObservableBoolean = localRegionEditViewModel.d;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(3, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          bool5 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
          break label467;
        }
      }
      else
      {
        j = 0;
        k = 0;
        i = 0;
        l3 = l1;
      }
      boolean bool2 = false;
      boolean bool5 = false;
      label467:
      if ((l3 & 0x64) != 0L) {
        this.d.setVisibility(i);
      }
      if ((0x50 & l3) != 0L)
      {
        this.q.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.p3.setOnClickListener(localOnClickListener);
        this.L3.setOnClickListener(localOnClickListener);
      }
      if ((l3 & 0x61) != 0L) {
        this.p0.setVisibility(j);
      }
      if ((0x68 & l3) != 0L)
      {
        b.K(this.K3, Boolean.valueOf(bool5));
        b.c(this.L3, Boolean.valueOf(bool2), null);
      }
      if ((l3 & 0x62) != 0L) {
        this.Q3.setVisibility(k);
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
      this.X3 |= 0x10;
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
      this.X3 |= 0x20;
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
      this.X3 = 64L;
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
          return o((ObservableBoolean)paramObject, paramInt2);
        }
        return l((ObservableBoolean)paramObject, paramInt2);
      }
      return n((ObservableBoolean)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPrivacyMaskZonesBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */