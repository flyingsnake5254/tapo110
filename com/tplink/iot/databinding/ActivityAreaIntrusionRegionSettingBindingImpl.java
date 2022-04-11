package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionViewModel;

public class ActivityAreaIntrusionRegionSettingBindingImpl
  extends ActivityAreaIntrusionRegionSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts T3;
  @Nullable
  private static final SparseIntArray U3;
  private long V3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    U3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 8);
    localSparseIntArray.put(2131364252, 9);
    localSparseIntArray.put(2131364030, 10);
    localSparseIntArray.put(2131364032, 11);
    localSparseIntArray.put(2131361911, 12);
  }
  
  public ActivityAreaIntrusionRegionSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 13, T3, U3));
  }
  
  private ActivityAreaIntrusionRegionSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (View)paramArrayOfObject[12], (View)paramArrayOfObject[6], null, (FrameLayout)paramArrayOfObject[5], null, (FrameLayout)paramArrayOfObject[4], null, (View)paramArrayOfObject[3], null, null, (FrameLayout)paramArrayOfObject[2], null, null, null, (ImageView)paramArrayOfObject[1], (View)paramArrayOfObject[0], (FrameLayout)paramArrayOfObject[10], (ImageView)paramArrayOfObject[11], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[9], (Toolbar)paramArrayOfObject[8]);
    this.d.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.p0.setTag(null);
    this.p3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.O3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.V3 |= 0x4;
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
        this.V3 |= 1L;
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
        this.V3 |= 0x2;
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
      long l1 = this.V3;
      this.V3 = 0L;
      View.OnClickListener localOnClickListener = this.S3;
      AreaIntrusionViewModel localAreaIntrusionViewModel = this.R3;
      label151:
      label274:
      int k;
      int m;
      if ((0x37 & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x31) < 0L;
        l2 = l1;
        ObservableBoolean localObservableBoolean;
        boolean bool2;
        if (bool1)
        {
          if (localAreaIntrusionViewModel != null) {
            localObservableBoolean = localAreaIntrusionViewModel.j;
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
            i = 8;
            break label151;
          }
        }
        i = 0;
        long l3 = l2;
        boolean bool3 = (l3 & 0x32) < 0L;
        l2 = l3;
        if (bool3)
        {
          if (localAreaIntrusionViewModel != null) {
            localObservableBoolean = localAreaIntrusionViewModel.k;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l2 = l3;
          if (bool3)
          {
            if (bool2) {
              l2 = 2048L;
            } else {
              l2 = 1024L;
            }
            l2 = l3 | l2;
          }
          if (!bool2)
          {
            j = 8;
            l3 = l2;
            break label274;
          }
        }
        j = 0;
        l3 = l2;
        boolean bool4 = (l3 & 0x34) < 0L;
        l1 = l3;
        k = i;
        m = j;
        if (bool4)
        {
          if (localAreaIntrusionViewModel != null) {
            localObservableBoolean = localAreaIntrusionViewModel.i;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(2, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool2 = localObservableBoolean.get();
          } else {
            bool2 = false;
          }
          l2 = l3;
          if (bool4)
          {
            if (bool2) {
              l2 = 128L;
            } else {
              l2 = 64L;
            }
            l2 = l3 | l2;
          }
          l1 = l2;
          k = i;
          m = j;
          if (bool2)
          {
            m = 8;
            k = i;
            i = m;
            break label425;
          }
        }
      }
      else
      {
        k = 0;
        m = 0;
      }
      int i = 0;
      int j = m;
      long l2 = l1;
      label425:
      if ((0x28 & l2) != 0L)
      {
        this.d.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.p3.setOnClickListener(localOnClickListener);
        this.K3.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x34) != 0L) {
        this.d.setVisibility(i);
      }
      if ((l2 & 0x31) != 0L) {
        this.p0.setVisibility(k);
      }
      if ((l2 & 0x32) != 0L) {
        this.O3.setVisibility(j);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.S3 = paramOnClickListener;
    try
    {
      this.V3 |= 0x8;
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
      return this.V3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable AreaIntrusionViewModel paramAreaIntrusionViewModel)
  {
    this.R3 = paramAreaIntrusionViewModel;
    try
    {
      this.V3 |= 0x10;
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
      this.V3 = 32L;
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
      i((AreaIntrusionViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAreaIntrusionRegionSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */