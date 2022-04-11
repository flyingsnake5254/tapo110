package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.aidetection.AIDetectionViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

public class ActivityAiDetectionBindingImpl
  extends ActivityAiDetectionBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts J3;
  @Nullable
  private static final SparseIntArray K3;
  @NonNull
  private final LinearLayout L3;
  @NonNull
  private final View M3;
  @NonNull
  private final RelativeLayout N3;
  @NonNull
  private final TextView O3;
  @NonNull
  private final View P3;
  @NonNull
  private final RelativeLayout Q3;
  @NonNull
  private final RelativeLayout R3;
  private long S3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    K3 = localSparseIntArray;
    localSparseIntArray.put(2131364154, 16);
  }
  
  public ActivityAiDetectionBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 17, J3, K3));
  }
  
  private ActivityAiDetectionBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 9, (TextView)paramArrayOfObject[8], (NoninteractiveCheckBox)paramArrayOfObject[7], (NoninteractiveCheckBox)paramArrayOfObject[4], (CameraLoadingView)paramArrayOfObject[15], (LinearLayout)paramArrayOfObject[1], (SeekBar)paramArrayOfObject[13], (TextView)paramArrayOfObject[12], (TextView)paramArrayOfObject[10], (TextView)paramArrayOfObject[11], (TextView)paramArrayOfObject[16]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[14];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[2];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[5];
    this.P3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[6];
    this.Q3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[9];
    this.R3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean m(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(MutableLiveData<Integer> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(MutableLiveData<String> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean t(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean u(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x2;
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
      long l1 = this.S3;
      this.S3 = 0L;
      SeekBarBindingAdapter.OnStopTrackingTouch localOnStopTrackingTouch = this.I3;
      View.OnClickListener localOnClickListener = this.H3;
      AIDetectionViewModel localAIDetectionViewModel = this.p3;
      float f1 = 0.0F;
      Object localObject1;
      boolean bool1;
      boolean bool2;
      Object localObject3;
      boolean bool3;
      label266:
      boolean bool4;
      long l3;
      boolean bool5;
      float f2;
      int i;
      int j;
      int k;
      int m;
      int i2;
      Object localObject4;
      Object localObject5;
      boolean bool9;
      if ((0x19FF & l1) != 0L)
      {
        if ((l1 & 0x1801) != 0L)
        {
          if (localAIDetectionViewModel != null) {
            localObject1 = localAIDetectionViewModel.t();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool1 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool1 = false;
        }
        if ((l1 & 0x1802) != 0L)
        {
          if (localAIDetectionViewModel != null) {
            localObject1 = localAIDetectionViewModel.L();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool2 = false;
        }
        if ((l1 & 0x1804) != 0L)
        {
          if (localAIDetectionViewModel != null) {
            localObject1 = localAIDetectionViewModel.u();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (String)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          localObject3 = localObject1;
          if (localObject1 != null)
          {
            bool3 = true;
            break label266;
          }
        }
        else
        {
          localObject3 = null;
        }
        bool3 = false;
        localObject1 = localObject3;
        if ((l1 & 0x1888) != 0L)
        {
          if (localAIDetectionViewModel != null) {
            localObject3 = localAIDetectionViewModel.n();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject3);
          if (localObject3 != null) {
            localObject3 = (Boolean)((LiveData)localObject3).getValue();
          } else {
            localObject3 = null;
          }
          bool4 = ViewDataBinding.safeUnbox((Boolean)localObject3);
          long l2 = l1;
          if ((l1 & 0x1808) != 0L)
          {
            if (bool4) {
              l3 = 16384L;
            } else {
              l3 = 8192L;
            }
            l2 = l1 | l3;
          }
          l3 = l2;
          if ((l2 & 0x1888) != 0L) {
            if (bool4) {
              l3 = l2 | 0x40000;
            } else {
              l3 = l2 | 0x20000;
            }
          }
          l1 = l3;
          bool5 = bool4;
          f2 = f1;
          if ((l3 & 0x1808) != 0L)
          {
            l1 = l3;
            bool5 = bool4;
            f2 = f1;
            if (bool4)
            {
              f2 = 20.0F;
              l1 = l3;
              bool5 = bool4;
            }
          }
        }
        else
        {
          bool5 = false;
          f2 = f1;
        }
        boolean bool6 = (l1 & 0x1900) < 0L;
        if (bool6)
        {
          if (localAIDetectionViewModel != null)
          {
            i = localAIDetectionViewModel.w();
            j = localAIDetectionViewModel.y();
            k = localAIDetectionViewModel.x();
            localObject3 = localAIDetectionViewModel.p();
          }
          else
          {
            localObject3 = null;
            i = 0;
            j = 0;
            k = 0;
          }
          updateLiveDataRegistration(8, (LiveData)localObject3);
          if (localObject3 != null) {
            localObject3 = (Integer)((LiveData)localObject3).getValue();
          } else {
            localObject3 = null;
          }
          m = ViewDataBinding.safeUnbox((Integer)localObject3);
          int n = ViewDataBinding.safeUnbox((Integer)localObject3);
          if (m == k) {
            k = 1;
          } else {
            k = 0;
          }
          if (m == j) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (m == i) {
            m = 1;
          } else {
            m = 0;
          }
          l3 = l1;
          if (bool6)
          {
            if (k != 0) {
              l3 = 65536L;
            } else {
              l3 = 32768L;
            }
            l3 = l1 | l3;
          }
          l1 = l3;
          if ((l3 & 0x1900) != 0L)
          {
            if (i2 != 0) {
              l1 = 1048576L;
            } else {
              l1 = 524288L;
            }
            l1 = l3 | l1;
          }
          l3 = l1;
          if ((l1 & 0x1900) != 0L)
          {
            if (m != 0) {
              l3 = 16777216L;
            } else {
              l3 = 8388608L;
            }
            l3 = l1 | l3;
          }
          if (k != 0) {
            j = ViewDataBinding.getColorFromResource(this.p0, 2131100201);
          } else {
            j = ViewDataBinding.getColorFromResource(this.p0, 2131099799);
          }
          if (i2 != 0) {
            k = ViewDataBinding.getColorFromResource(this.p1, 2131100201);
          } else {
            k = ViewDataBinding.getColorFromResource(this.p1, 2131099799);
          }
          if (m != 0) {
            m = ViewDataBinding.getColorFromResource(this.z, 2131100201);
          } else {
            m = ViewDataBinding.getColorFromResource(this.z, 2131099799);
          }
          i2 = n;
        }
        else
        {
          m = 0;
          i2 = 0;
          i = 0;
          k = 0;
          j = 0;
          l3 = l1;
        }
        i1 = (l3 & 0x1870) < 0L;
        if (i1 != 0)
        {
          if (localAIDetectionViewModel != null) {
            localObject3 = localAIDetectionViewModel.H();
          } else {
            localObject3 = null;
          }
          updateRegistration(6, (Observable)localObject3);
          if (localObject3 != null) {
            bool7 = ((ObservableBoolean)localObject3).get();
          } else {
            bool7 = false;
          }
          l1 = l3;
          bool4 = bool7;
          if (i1 != 0) {
            if (bool7)
            {
              l1 = l3 | 0x400000;
              bool4 = bool7;
            }
            else
            {
              l1 = l3 | 0x200000;
              bool4 = bool7;
            }
          }
        }
        else
        {
          bool4 = false;
          l1 = l3;
        }
        if ((l1 & 0x1880) != 0L)
        {
          if (localAIDetectionViewModel != null) {
            localObject3 = localAIDetectionViewModel.o();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(7, (LiveData)localObject3);
          if (localObject3 != null) {
            localObject4 = (Boolean)((LiveData)localObject3).getValue();
          } else {
            localObject4 = null;
          }
          bool8 = ViewDataBinding.safeUnbox((Boolean)localObject4);
          localObject5 = localObject4;
          bool7 = bool3;
          bool3 = bool1;
          bool9 = bool2;
          i1 = m;
          bool1 = bool5;
          m = k;
          k = j;
          bool5 = bool7;
          bool7 = bool4;
          j = i1;
          bool2 = bool3;
          bool3 = bool9;
          bool4 = bool1;
          localObject4 = localObject1;
          localObject1 = localObject5;
          bool1 = bool8;
        }
        else
        {
          localObject5 = null;
          bool8 = bool2;
          bool9 = false;
          localObject3 = null;
          bool7 = bool4;
          bool4 = bool5;
          i1 = k;
          k = j;
          bool5 = bool3;
          j = m;
          m = i1;
          bool2 = bool1;
          bool3 = bool8;
          localObject4 = localObject1;
          localObject1 = localObject5;
          bool1 = bool9;
        }
      }
      else
      {
        k = 0;
        bool5 = false;
        i = 0;
        bool7 = false;
        j = 0;
        m = 0;
        i2 = 0;
        bool2 = false;
        bool3 = false;
        bool4 = false;
        localObject4 = null;
        localObject1 = null;
        bool1 = false;
        localObject3 = null;
        f2 = 0.0F;
      }
      if ((l1 & 0x200000) != 0L)
      {
        if (localAIDetectionViewModel != null) {
          localObject5 = localAIDetectionViewModel.J();
        } else {
          localObject5 = null;
        }
        updateRegistration(4, (Observable)localObject5);
        if (localObject5 != null)
        {
          bool8 = ((ObservableBoolean)localObject5).get();
          break label1254;
        }
      }
      boolean bool8 = false;
      label1254:
      if ((l1 & 0x40000) != 0L)
      {
        if (localAIDetectionViewModel != null) {
          localObject3 = localAIDetectionViewModel.o();
        }
        updateLiveDataRegistration(7, (LiveData)localObject3);
        if (localObject3 != null) {
          localObject1 = (Boolean)((LiveData)localObject3).getValue();
        }
        bool1 = ViewDataBinding.safeUnbox((Boolean)localObject1);
      }
      if (((l1 & 0x1888) != 0L) && (bool4)) {
        bool9 = bool1;
      } else {
        bool9 = false;
      }
      int i1 = (l1 & 0x1870) < 0L;
      boolean bool10;
      if (i1 != 0)
      {
        if (bool7) {
          bool8 = true;
        }
        l3 = l1;
        bool10 = bool8;
        if (i1 != 0) {
          if (bool8)
          {
            l3 = l1 | 0x4000000;
            bool10 = bool8;
          }
          else
          {
            l3 = l1 | 0x2000000;
            bool10 = bool8;
          }
        }
      }
      else
      {
        bool10 = false;
        l3 = l1;
      }
      if ((l3 & 0x2000000) != 0L)
      {
        if (localAIDetectionViewModel != null) {
          localObject1 = localAIDetectionViewModel.G();
        } else {
          localObject1 = null;
        }
        updateRegistration(5, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool7 = ((ObservableBoolean)localObject1).get();
          break label1466;
        }
      }
      boolean bool7 = false;
      label1466:
      i1 = (l3 & 0x1870) < 0L;
      if (i1 != 0)
      {
        if (bool10) {
          bool7 = true;
        }
      }
      else {
        bool7 = false;
      }
      if ((l3 & 0x1888) != 0L)
      {
        b.Q(this.c, bool9);
        b.Q(this.M3, bool9);
        b.Q(this.R3, bool9);
      }
      if ((0x1880 & l3) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.d, bool1);
      }
      if ((0x1400 & l3) != 0L)
      {
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p0.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
      }
      if ((l3 & 0x1801) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.f, bool2);
      }
      if ((0x1802 & l3) != 0L) {
        b.K(this.q, Boolean.valueOf(bool3));
      }
      if (i1 != 0) {
        b.Q(this.x, bool7);
      }
      if ((0x1804 & l3) != 0L)
      {
        b.Q(this.N3, bool5);
        TextViewBindingAdapter.setText(this.O3, (CharSequence)localObject4);
      }
      if ((l3 & 0x1808) != 0L)
      {
        b.y(this.P3, Float.valueOf(f2));
        b.Q(this.Q3, bool4);
      }
      if ((0x1800 & l3) != 0L) {
        this.y.setMax(i);
      }
      if ((l3 & 0x1900) != 0L)
      {
        SeekBarBindingAdapter.setProgress(this.y, i2);
        this.z.setTextColor(j);
        this.p0.setTextColor(k);
        this.p1.setTextColor(m);
      }
      if ((l3 & 0x1200) != 0L) {
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.y, null, localOnStopTrackingTouch, null, null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.H3 = paramOnClickListener;
    try
    {
      this.S3 |= 0x400;
      notifyPropertyChanged(69);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.S3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch paramOnStopTrackingTouch)
  {
    this.I3 = paramOnStopTrackingTouch;
    try
    {
      this.S3 |= 0x200;
      notifyPropertyChanged(93);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.S3 = 4096L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable AIDetectionViewModel paramAIDetectionViewModel)
  {
    this.p3 = paramAIDetectionViewModel;
    try
    {
      this.S3 |= 0x800;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 8: 
      return o((MutableLiveData)paramObject, paramInt2);
    case 7: 
      return n((MutableLiveData)paramObject, paramInt2);
    case 6: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return r((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return m((MutableLiveData)paramObject, paramInt2);
    case 2: 
      return q((MutableLiveData)paramObject, paramInt2);
    case 1: 
      return u((MutableLiveData)paramObject, paramInt2);
    }
    return p((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (93 == paramInt)
    {
      i((SeekBarBindingAdapter.OnStopTrackingTouch)paramObject);
    }
    else if (69 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      l((AIDetectionViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAiDetectionBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */