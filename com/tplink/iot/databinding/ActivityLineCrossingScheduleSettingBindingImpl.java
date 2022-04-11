package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.setting.RecordCustomSettingView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingScheduleViewModel;

public class ActivityLineCrossingScheduleSettingBindingImpl
  extends ActivityLineCrossingScheduleSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts M3;
  @Nullable
  private static final SparseIntArray N3;
  @NonNull
  private final ConstraintLayout O3;
  private long P3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    N3 = localSparseIntArray;
    localSparseIntArray.put(2131364284, 8);
    localSparseIntArray.put(2131364275, 9);
    localSparseIntArray.put(2131363790, 10);
    localSparseIntArray.put(2131363793, 11);
    localSparseIntArray.put(2131363787, 12);
    localSparseIntArray.put(2131363786, 13);
  }
  
  public ActivityLineCrossingScheduleSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 14, M3, N3));
  }
  
  private ActivityLineCrossingScheduleSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (TextView)paramArrayOfObject[2], (CameraLoadingView)paramArrayOfObject[7], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[13], (TextView)paramArrayOfObject[12], (RecordCustomSettingView)paramArrayOfObject[10], (LinearLayout)paramArrayOfObject[3], (LinearLayout)paramArrayOfObject[4], (LinearLayout)paramArrayOfObject[11], (AppCompatImageView)paramArrayOfObject[1], (Toolbar)paramArrayOfObject[9], (AppBarLayout)paramArrayOfObject[8]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 1L;
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
        this.P3 |= 0x2;
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
      long l1 = this.P3;
      this.P3 = 0L;
      View.OnClickListener localOnClickListener = this.K3;
      LineCrossingScheduleViewModel localLineCrossingScheduleViewModel = this.J3;
      int i = 0;
      boolean bool1 = false;
      boolean bool2;
      long l2;
      boolean bool4;
      boolean bool5;
      int j;
      if ((0x3B & l1) != 0L)
      {
        Object localObject1 = null;
        Object localObject2;
        if ((l1 & 0x39) != 0L)
        {
          if (localLineCrossingScheduleViewModel != null) {
            localObject2 = localLineCrossingScheduleViewModel.g;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null) {
            bool2 = ((ObservableBoolean)localObject2).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if ((l1 & 0x31) != 0L)
          {
            if (bool2)
            {
              l1 |= 0x80;
              l2 = 512L;
            }
            else
            {
              l1 |= 0x40;
              l2 = 256L;
            }
            l2 = l1 | l2;
          }
          boolean bool3 = bool2 ^ true;
          l1 = l2;
          bool4 = bool2;
          bool5 = bool3;
          if ((l2 & 0x31) != 0L)
          {
            j = 8;
            if (bool2) {
              i = 0;
            } else {
              i = 8;
            }
            if (bool2)
            {
              bool4 = bool2;
              bool2 = bool3;
              break label243;
            }
            j = 0;
            bool4 = bool2;
            bool2 = bool3;
            break label243;
          }
        }
        else
        {
          bool4 = false;
          bool5 = false;
        }
        j = 0;
        i = 0;
        bool2 = bool5;
        l2 = l1;
        label243:
        int k;
        if ((l2 & 0x32) != 0L)
        {
          localObject2 = localObject1;
          if (localLineCrossingScheduleViewModel != null) {
            localObject2 = localLineCrossingScheduleViewModel.c;
          }
          updateRegistration(1, (Observable)localObject2);
          bool5 = bool1;
          if (localObject2 != null) {
            bool5 = ((ObservableBoolean)localObject2).get();
          }
          bool5 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool5));
          k = j;
          j = i;
          i = k;
        }
        else
        {
          k = j;
          j = i;
          bool5 = false;
          i = k;
        }
      }
      else
      {
        j = 0;
        bool5 = false;
        bool4 = false;
        bool2 = false;
        l2 = l1;
      }
      if ((0x31 & l2) != 0L)
      {
        this.c.setVisibility(i);
        this.p0.setVisibility(i);
        this.p1.setVisibility(j);
        this.p3.setVisibility(j);
      }
      if ((0x39 & l2) != 0L)
      {
        ViewBindingAdapter.setOnClick(this.c, localOnClickListener, bool2);
        ViewBindingAdapter.setOnClick(this.p3, localOnClickListener, bool4);
      }
      if ((l2 & 0x32) != 0L) {
        b.K(this.d, Boolean.valueOf(bool5));
      }
      if ((l2 & 0x28) != 0L)
      {
        this.f.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.K3 = paramOnClickListener;
    try
    {
      this.P3 |= 0x8;
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
      return this.P3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable LineCrossingScheduleViewModel paramLineCrossingScheduleViewModel)
  {
    this.J3 = paramLineCrossingScheduleViewModel;
    try
    {
      this.P3 |= 0x10;
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
      this.P3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.L3 = paramOnCheckedChangeListener;
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return false;
      }
      return m((ObservableBoolean)paramObject, paramInt2);
    }
    return l((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (7 == paramInt)
    {
      n((RadioGroup.OnCheckedChangeListener)paramObject);
    }
    else if (55 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      i((LineCrossingScheduleViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLineCrossingScheduleSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */