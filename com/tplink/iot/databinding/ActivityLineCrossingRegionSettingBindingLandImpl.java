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
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingViewModel;

public class ActivityLineCrossingRegionSettingBindingLandImpl
  extends ActivityLineCrossingRegionSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts Y3;
  @Nullable
  private static final SparseIntArray Z3;
  private long a4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    Z3 = localSparseIntArray;
    localSparseIntArray.put(2131364030, 10);
    localSparseIntArray.put(2131364032, 11);
    localSparseIntArray.put(2131361911, 12);
    localSparseIntArray.put(2131362391, 13);
  }
  
  public ActivityLineCrossingRegionSettingBindingLandImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 14, Y3, Z3));
  }
  
  private ActivityLineCrossingRegionSettingBindingLandImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (View)paramArrayOfObject[12], null, (View)paramArrayOfObject[7], null, (ImageView)paramArrayOfObject[6], null, (ImageView)paramArrayOfObject[4], null, null, (ImageView)paramArrayOfObject[5], null, (View)paramArrayOfObject[2], (ImageView)paramArrayOfObject[8], null, (ImageView)paramArrayOfObject[3], null, null, (ImageView)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[13], (ImageView)paramArrayOfObject[9], null, (View)paramArrayOfObject[0], (FrameLayout)paramArrayOfObject[10], (ImageView)paramArrayOfObject[11], null, null);
    this.f.setTag(null);
    this.x.setTag(null);
    this.z.setTag(null);
    this.p2.setTag(null);
    this.H3.setTag(null);
    this.I3.setTag(null);
    this.K3.setTag(null);
    this.N3.setTag(null);
    this.P3.setTag(null);
    this.R3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.a4 |= 0x2;
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
        this.a4 |= 1L;
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
      long l1 = this.a4;
      this.a4 = 0L;
      View.OnClickListener localOnClickListener = this.X3;
      LineCrossingViewModel localLineCrossingViewModel = this.W3;
      int i = 0;
      long l2;
      label157:
      int k;
      int m;
      if ((0x1B & l1) != 0L)
      {
        Object localObject1 = null;
        boolean bool1 = (l1 & 0x19) < 0L;
        l2 = l1;
        Object localObject2;
        boolean bool2;
        if (bool1)
        {
          if (localLineCrossingViewModel != null) {
            localObject2 = localLineCrossingViewModel.j;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null) {
            bool2 = ((ObservableBoolean)localObject2).get();
          } else {
            bool2 = false;
          }
          l3 = l1;
          if (bool1)
          {
            if (bool2) {
              l3 = 256L;
            } else {
              l3 = 128L;
            }
            l3 = l1 | l3;
          }
          l2 = l3;
          if (bool2)
          {
            j = 8;
            break label157;
          }
        }
        int j = 0;
        long l3 = l2;
        boolean bool3 = (l3 & 0x1A) < 0L;
        l2 = l3;
        k = j;
        m = i;
        if (bool3)
        {
          localObject2 = localObject1;
          if (localLineCrossingViewModel != null) {
            localObject2 = localLineCrossingViewModel.i;
          }
          updateRegistration(1, (Observable)localObject2);
          if (localObject2 != null) {
            bool2 = ((ObservableBoolean)localObject2).get();
          } else {
            bool2 = false;
          }
          l1 = l3;
          if (bool3)
          {
            if (bool2) {
              l1 = 64L;
            } else {
              l1 = 32L;
            }
            l1 = l3 | l1;
          }
          l2 = l1;
          k = j;
          m = i;
          if (bool2)
          {
            m = 8;
            l2 = l1;
            k = j;
          }
        }
      }
      else
      {
        k = 0;
        m = i;
        l2 = l1;
      }
      if ((0x14 & l2) != 0L)
      {
        this.f.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p2.setOnClickListener(localOnClickListener);
        this.I3.setOnClickListener(localOnClickListener);
        this.K3.setOnClickListener(localOnClickListener);
        this.N3.setOnClickListener(localOnClickListener);
        this.P3.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x1A) != 0L) {
        this.f.setVisibility(m);
      }
      if ((l2 & 0x19) != 0L) {
        this.H3.setVisibility(k);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.X3 = paramOnClickListener;
    try
    {
      this.a4 |= 0x4;
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
      return this.a4 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable LineCrossingViewModel paramLineCrossingViewModel)
  {
    this.W3 = paramLineCrossingViewModel;
    try
    {
      this.a4 |= 0x8;
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
      this.a4 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return false;
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
      i((LineCrossingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLineCrossingRegionSettingBindingLandImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */