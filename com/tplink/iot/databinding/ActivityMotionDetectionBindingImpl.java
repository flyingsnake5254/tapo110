package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;

public class ActivityMotionDetectionBindingImpl
  extends ActivityMotionDetectionBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts Q3;
  @Nullable
  private static final SparseIntArray R3;
  @NonNull
  private final NestedScrollView S3;
  private long T3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    R3 = localSparseIntArray;
    localSparseIntArray.put(2131363484, 5);
    localSparseIntArray.put(2131364252, 6);
    localSparseIntArray.put(2131363367, 7);
    localSparseIntArray.put(2131364770, 8);
    localSparseIntArray.put(2131362470, 9);
    localSparseIntArray.put(2131363185, 10);
    localSparseIntArray.put(2131364033, 11);
    localSparseIntArray.put(2131364030, 12);
    localSparseIntArray.put(2131364032, 13);
    localSparseIntArray.put(2131363550, 14);
    localSparseIntArray.put(2131363325, 15);
    localSparseIntArray.put(2131362471, 16);
    localSparseIntArray.put(2131364024, 17);
    localSparseIntArray.put(2131363903, 18);
  }
  
  public ActivityMotionDetectionBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 19, Q3, R3));
  }
  
  private ActivityMotionDetectionBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[16], (ConstraintLayout)paramArrayOfObject[10], (LinearLayout)paramArrayOfObject[15], (LinearLayout)paramArrayOfObject[7], (Toolbar)paramArrayOfObject[5], (TextView)paramArrayOfObject[14], (RelativeLayout)paramArrayOfObject[18], (SeekBar)paramArrayOfObject[4], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[17], (FrameLayout)paramArrayOfObject[12], (ImageView)paramArrayOfObject[13], (LinearLayout)paramArrayOfObject[11], (TextView)paramArrayOfObject[6], (CheckBox)paramArrayOfObject[8]);
    paramDataBindingComponent = (NestedScrollView)paramArrayOfObject[0];
    this.S3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableInt paramObservableInt, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.T3;
      this.T3 = 0L;
      SeekBarBindingAdapter.OnStopTrackingTouch localOnStopTrackingTouch = this.P3;
      Object localObject1 = this.O3;
      int i = 0;
      int j = 0;
      boolean bool = (l1 & 0xD) < 0L;
      int k;
      int m;
      long l2;
      if (bool)
      {
        if (localObject1 != null) {
          localObject1 = ((MotionDetectionViewModel)localObject1).c;
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        if (localObject1 != null) {
          i = ((ObservableInt)localObject1).get();
        } else {
          i = 0;
        }
        if (i == 30) {
          k = 1;
        } else {
          k = 0;
        }
        if (i == 60) {
          m = 1;
        } else {
          m = 0;
        }
        int n = ViewDataBinding.safeUnbox(Integer.valueOf(i));
        if (i == 0) {
          j = 1;
        }
        l2 = l1;
        if (bool)
        {
          if (k != 0) {
            l2 = 512L;
          } else {
            l2 = 256L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0xD) != 0L)
        {
          if (m != 0) {
            l1 = 32L;
          } else {
            l1 = 16L;
          }
          l1 = l2 | l1;
        }
        l2 = l1;
        if ((l1 & 0xD) != 0L)
        {
          if (j != 0) {
            l2 = 128L;
          } else {
            l2 = 64L;
          }
          l2 = l1 | l2;
        }
        if (k != 0) {
          i = ViewDataBinding.getColorFromResource(this.H3, 2131100201);
        } else {
          i = ViewDataBinding.getColorFromResource(this.H3, 2131099799);
        }
        localObject1 = this.p2;
        if (m != 0) {
          m = ViewDataBinding.getColorFromResource((View)localObject1, 2131100201);
        } else {
          m = ViewDataBinding.getColorFromResource((View)localObject1, 2131099799);
        }
        if (j != 0) {
          j = ViewDataBinding.getColorFromResource(this.p3, 2131100201);
        } else {
          j = ViewDataBinding.getColorFromResource(this.p3, 2131099799);
        }
        k = i;
        i = n;
      }
      else
      {
        j = 0;
        k = 0;
        m = 0;
        l2 = l1;
      }
      if ((0x8 & l2) != 0L) {
        this.p1.setMax(60);
      }
      if ((0xD & l2) != 0L)
      {
        SeekBarBindingAdapter.setProgress(this.p1, i);
        this.p2.setTextColor(m);
        this.p3.setTextColor(j);
        this.H3.setTextColor(k);
      }
      if ((l2 & 0xA) != 0L) {
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.p1, null, localOnStopTrackingTouch, null, null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch paramOnStopTrackingTouch)
  {
    this.P3 = paramOnStopTrackingTouch;
    try
    {
      this.T3 |= 0x2;
      notifyPropertyChanged(93);
      super.requestRebind();
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
  
  public void i(@Nullable MotionDetectionViewModel paramMotionDetectionViewModel)
  {
    this.O3 = paramMotionDetectionViewModel;
    try
    {
      this.T3 |= 0x4;
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
      this.T3 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return l((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (93 == paramInt)
    {
      h((SeekBarBindingAdapter.OnStopTrackingTouch)paramObject);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMotionDetectionBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */