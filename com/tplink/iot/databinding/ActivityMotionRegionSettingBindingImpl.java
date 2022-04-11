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
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;

public class ActivityMotionRegionSettingBindingImpl
  extends ActivityMotionRegionSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts U3;
  @Nullable
  private static final SparseIntArray V3;
  private long W3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    V3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 8);
    localSparseIntArray.put(2131364252, 9);
    localSparseIntArray.put(2131364031, 10);
    localSparseIntArray.put(2131364030, 11);
    localSparseIntArray.put(2131364032, 12);
    localSparseIntArray.put(2131361911, 13);
  }
  
  public ActivityMotionRegionSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 14, U3, V3));
  }
  
  private ActivityMotionRegionSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (View)paramArrayOfObject[13], (View)paramArrayOfObject[6], null, (FrameLayout)paramArrayOfObject[5], null, (FrameLayout)paramArrayOfObject[4], null, (View)paramArrayOfObject[3], null, null, (FrameLayout)paramArrayOfObject[2], null, null, null, (ImageView)paramArrayOfObject[1], (View)paramArrayOfObject[0], (FrameLayout)paramArrayOfObject[11], (TextView)paramArrayOfObject[10], (ImageView)paramArrayOfObject[12], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[9], (Toolbar)paramArrayOfObject[8]);
    this.d.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.p0.setTag(null);
    this.p3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.P3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x4;
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
        this.W3 |= 1L;
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
        this.W3 |= 0x2;
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
      long l1 = this.W3;
      this.W3 = 0L;
      View.OnClickListener localOnClickListener = this.T3;
      MotionDetectionViewModel localMotionDetectionViewModel = this.S3;
      label151:
      label274:
      int m;
      int n;
      if ((0x37 & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x31) < 0L;
        l2 = l1;
        ObservableBoolean localObservableBoolean;
        boolean bool2;
        if (bool1)
        {
          if (localMotionDetectionViewModel != null) {
            localObservableBoolean = localMotionDetectionViewModel.h;
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
          if (localMotionDetectionViewModel != null) {
            localObservableBoolean = localMotionDetectionViewModel.i;
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
        m = i;
        n = j;
        if (bool4)
        {
          if (localMotionDetectionViewModel != null) {
            localObservableBoolean = localMotionDetectionViewModel.g;
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
          m = i;
          n = j;
          if (bool2)
          {
            k = 8;
            break label421;
          }
        }
      }
      else
      {
        m = 0;
        n = 0;
      }
      int k = 0;
      int j = n;
      int i = m;
      long l2 = l1;
      label421:
      if ((l2 & 0x34) != 0L) {
        this.d.setVisibility(k);
      }
      if ((0x28 & l2) != 0L)
      {
        this.q.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.p3.setOnClickListener(localOnClickListener);
        this.K3.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x31) != 0L) {
        this.p0.setVisibility(i);
      }
      if ((l2 & 0x32) != 0L) {
        this.P3.setVisibility(j);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.T3 = paramOnClickListener;
    try
    {
      this.W3 |= 0x8;
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
      return this.W3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable MotionDetectionViewModel paramMotionDetectionViewModel)
  {
    this.S3 = paramMotionDetectionViewModel;
    try
    {
      this.W3 |= 0x10;
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
      this.W3 = 32L;
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
      i((MotionDetectionViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMotionRegionSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */