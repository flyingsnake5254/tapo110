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
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;

public class ActivityMotionRegionSettingBindingLandImpl
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
    localSparseIntArray.put(2131364030, 8);
    localSparseIntArray.put(2131364032, 9);
    localSparseIntArray.put(2131361911, 10);
    localSparseIntArray.put(2131362391, 11);
  }
  
  public ActivityMotionRegionSettingBindingLandImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 12, U3, V3));
  }
  
  private ActivityMotionRegionSettingBindingLandImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (View)paramArrayOfObject[10], null, (View)paramArrayOfObject[5], null, (ImageView)paramArrayOfObject[4], null, (ImageView)paramArrayOfObject[3], null, (View)paramArrayOfObject[2], (ImageView)paramArrayOfObject[6], null, (ImageView)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[11], (ImageView)paramArrayOfObject[7], null, (View)paramArrayOfObject[0], (FrameLayout)paramArrayOfObject[8], null, (ImageView)paramArrayOfObject[9], null, null, null);
    this.f.setTag(null);
    this.x.setTag(null);
    this.z.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.H3.setTag(null);
    this.J3.setTag(null);
    this.L3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.W3;
      this.W3 = 0L;
      View.OnClickListener localOnClickListener = this.T3;
      MotionDetectionViewModel localMotionDetectionViewModel = this.S3;
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
          if (localMotionDetectionViewModel != null) {
            localObject2 = localMotionDetectionViewModel.h;
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
          if (localMotionDetectionViewModel != null) {
            localObject2 = localMotionDetectionViewModel.g;
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
      if ((0x1A & l2) != 0L) {
        this.f.setVisibility(m);
      }
      if ((0x14 & l2) != 0L)
      {
        this.x.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p2.setOnClickListener(localOnClickListener);
        this.H3.setOnClickListener(localOnClickListener);
        this.J3.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x19) != 0L) {
        this.p1.setVisibility(k);
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
      this.W3 |= 0x4;
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
      this.W3 |= 0x8;
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
      this.W3 = 16L;
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
      i((MotionDetectionViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMotionRegionSettingBindingLandImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */