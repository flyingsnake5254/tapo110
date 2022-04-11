package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.RadioGroupBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.setting.RecordCustomSettingView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordPlanViewModel;

public class ActivityScheduleSettingBindingImpl
  extends ActivityScheduleSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts P3;
  @Nullable
  private static final SparseIntArray Q3;
  @NonNull
  private final ConstraintLayout R3;
  @NonNull
  private final RadioGroup S3;
  private long T3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    Q3 = localSparseIntArray;
    localSparseIntArray.put(2131364284, 9);
    localSparseIntArray.put(2131364275, 10);
    localSparseIntArray.put(2131363790, 11);
    localSparseIntArray.put(2131363793, 12);
    localSparseIntArray.put(2131363787, 13);
    localSparseIntArray.put(2131363785, 14);
    localSparseIntArray.put(2131363786, 15);
    localSparseIntArray.put(2131362979, 16);
    localSparseIntArray.put(2131362935, 17);
  }
  
  public ActivityScheduleSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 18, P3, Q3));
  }
  
  private ActivityScheduleSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (TextView)paramArrayOfObject[2], (AppCompatRadioButton)paramArrayOfObject[17], (AppCompatRadioButton)paramArrayOfObject[16], (CameraLoadingView)paramArrayOfObject[8], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[14], (TextView)paramArrayOfObject[15], (TextView)paramArrayOfObject[13], (RecordCustomSettingView)paramArrayOfObject[11], (LinearLayout)paramArrayOfObject[3], (LinearLayout)paramArrayOfObject[4], (LinearLayout)paramArrayOfObject[12], (AppCompatImageView)paramArrayOfObject[1], (Toolbar)paramArrayOfObject[10], (AppBarLayout)paramArrayOfObject[9]);
    this.c.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.R3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RadioGroup)paramArrayOfObject[5];
    this.S3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    this.J3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.T3;
      this.T3 = 0L;
      RadioGroup.OnCheckedChangeListener localOnCheckedChangeListener = this.O3;
      View.OnClickListener localOnClickListener = this.N3;
      RecordPlanViewModel localRecordPlanViewModel = this.M3;
      boolean bool1;
      long l2;
      boolean bool4;
      int i;
      int j;
      if ((0x3B & l1) != 0L)
      {
        ObservableBoolean localObservableBoolean;
        if ((l1 & 0x39) != 0L)
        {
          if (localRecordPlanViewModel != null) {
            localObservableBoolean = localRecordPlanViewModel.c;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(0, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool1 = localObservableBoolean.get();
          } else {
            bool1 = false;
          }
          l2 = l1;
          if ((l1 & 0x31) != 0L)
          {
            if (bool1)
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
          boolean bool2 = bool1 ^ true;
          l1 = l2;
          bool3 = bool1;
          bool4 = bool2;
          if ((l2 & 0x31) != 0L)
          {
            i = 8;
            if (bool1) {
              j = 0;
            } else {
              j = 8;
            }
            if (bool1)
            {
              bool4 = bool2;
              break label232;
            }
            i = 0;
            bool4 = bool2;
            break label232;
          }
        }
        else
        {
          bool3 = false;
          bool4 = false;
        }
        i = 0;
        j = 0;
        bool1 = bool3;
        l2 = l1;
        label232:
        if ((l2 & 0x32) != 0L)
        {
          if (localRecordPlanViewModel != null) {
            localObservableBoolean = localRecordPlanViewModel.a;
          } else {
            localObservableBoolean = null;
          }
          updateRegistration(1, localObservableBoolean);
          if (localObservableBoolean != null) {
            bool3 = localObservableBoolean.get();
          } else {
            bool3 = false;
          }
          bool3 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool3));
          k = j;
          j = i;
          break label345;
        }
        k = i;
        i = j;
        j = k;
      }
      else
      {
        i = 0;
        j = 0;
        bool1 = false;
        bool4 = false;
        l2 = l1;
      }
      boolean bool3 = false;
      int k = i;
      label345:
      if ((0x31 & l2) != 0L)
      {
        this.c.setVisibility(j);
        this.p3.setVisibility(j);
        this.H3.setVisibility(k);
        this.J3.setVisibility(k);
      }
      if ((0x39 & l2) != 0L)
      {
        ViewBindingAdapter.setOnClick(this.c, localOnClickListener, bool4);
        ViewBindingAdapter.setOnClick(this.J3, localOnClickListener, bool1);
      }
      if ((l2 & 0x32) != 0L) {
        b.K(this.q, Boolean.valueOf(bool3));
      }
      if ((0x24 & l2) != 0L) {
        RadioGroupBindingAdapter.setListeners(this.S3, localOnCheckedChangeListener, null);
      }
      if ((l2 & 0x28) != 0L)
      {
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.O3 = paramOnCheckedChangeListener;
    try
    {
      this.T3 |= 0x4;
      notifyPropertyChanged(7);
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
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.N3 = paramOnClickListener;
    try
    {
      this.T3 |= 0x8;
      notifyPropertyChanged(55);
      super.requestRebind();
      return;
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
  
  public void l(@Nullable RecordPlanViewModel paramRecordPlanViewModel)
  {
    this.M3 = paramRecordPlanViewModel;
    try
    {
      this.T3 |= 0x10;
      notifyPropertyChanged(103);
      super.requestRebind();
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
      return n((ObservableBoolean)paramObject, paramInt2);
    }
    return m((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (7 == paramInt)
    {
      h((RadioGroup.OnCheckedChangeListener)paramObject);
    }
    else if (55 == paramInt)
    {
      i((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      l((RecordPlanViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityScheduleSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */