package com.tplink.iot.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import java.util.List;

public class ActivitySensorDetailContentBindingImpl
  extends ActivitySensorDetailContentBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts O3;
  @Nullable
  private static final SparseIntArray P3;
  @NonNull
  private final RelativeLayout Q3;
  @NonNull
  private final TextView R3;
  private long S3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    P3 = localSparseIntArray;
    localSparseIntArray.put(2131363261, 11);
    localSparseIntArray.put(2131363353, 12);
    localSparseIntArray.put(2131363121, 13);
    localSparseIntArray.put(2131362677, 14);
    localSparseIntArray.put(2131362196, 15);
    localSparseIntArray.put(2131363828, 16);
    localSparseIntArray.put(2131363951, 17);
  }
  
  public ActivitySensorDetailContentBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 18, O3, P3));
  }
  
  private ActivitySensorDetailContentBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 7, (CardView)paramArrayOfObject[6], (CardView)paramArrayOfObject[15], (FrameLayout)paramArrayOfObject[3], (FrameLayout)paramArrayOfObject[14], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[13], (ImageView)paramArrayOfObject[7], (LinearLayout)paramArrayOfObject[11], (LinearLayout)paramArrayOfObject[12], (TPSmartRefreshLayout)paramArrayOfObject[16], (RecyclerView)paramArrayOfObject[17], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[8]);
    this.c.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.p0.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.Q3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[10];
    this.R3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.I3.setTag(null);
    this.J3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(LiveData<String> paramLiveData, int paramInt)
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
  
  private boolean m(LiveData<Boolean> paramLiveData, int paramInt)
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
  
  private boolean n(LiveData<String> paramLiveData, int paramInt)
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
  
  private boolean o(LiveData<Boolean> paramLiveData, int paramInt)
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
  
  private boolean p(LiveData<Integer> paramLiveData, int paramInt)
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
  
  private boolean q(MediatorLiveData<Boolean> paramMediatorLiveData, int paramInt)
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
  
  private boolean r(LiveData<List<com.tplink.iot.adapter.iotsensor.a>> paramLiveData, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.S3;
      this.S3 = 0L;
      SensorDetailViewModel localSensorDetailViewModel = this.N3;
      View.OnClickListener localOnClickListener = this.M3;
      Object localObject1 = null;
      Boolean localBoolean = null;
      int i;
      Object localObject3;
      label164:
      boolean bool2;
      long l2;
      Object localObject4;
      int k;
      int j;
      Object localObject5;
      label420:
      boolean bool3;
      Object localObject6;
      boolean bool6;
      boolean bool7;
      if ((0x2FF & l1) != 0L)
      {
        if ((l1 & 0x281) != 0L)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.C();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Integer)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          i = ViewDataBinding.safeUnbox((Integer)localObject1);
        }
        else
        {
          i = 0;
        }
        if ((l1 & 0x282) != 0L)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.t();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null)
          {
            localObject3 = (String)((LiveData)localObject1).getValue();
            break label164;
          }
        }
        localObject3 = null;
        boolean bool1 = (l1 & 0x284) < 0L;
        if (bool1)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.I();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool2 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l2 = l1;
          if (bool1)
          {
            if (bool2)
            {
              l2 = l1 | 0x800 | 0x2000;
              l1 = 32768L;
            }
            else
            {
              l2 = l1 | 0x400 | 0x1000;
              l1 = 16384L;
            }
            l2 |= l1;
          }
          if (bool2) {
            localObject4 = this.L3.getResources().getString(2131954189);
          } else {
            localObject4 = this.L3.getResources().getString(2131953762);
          }
          if (bool2) {
            k = 0;
          } else {
            k = 4;
          }
          if (bool2)
          {
            j = 2131231287;
            l1 = l2;
          }
          else
          {
            j = -1;
            l1 = l2;
          }
        }
        else
        {
          localObject4 = null;
          j = 0;
          k = 0;
        }
        if ((l1 & 0x288) != 0L)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.w();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject1);
          if (localObject1 != null)
          {
            localObject5 = (String)((LiveData)localObject1).getValue();
            break label420;
          }
        }
        localObject5 = null;
        if ((l1 & 0x290) != 0L)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.u();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool3 = ViewDataBinding.safeUnbox((Boolean)localObject1);
        }
        else
        {
          bool3 = false;
        }
        boolean bool4 = (l1 & 0x2A0) < 0L;
        if (bool4)
        {
          if (localSensorDetailViewModel != null) {
            localObject1 = localSensorDetailViewModel.F();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject6 = (List)((LiveData)localObject1).getValue();
          } else {
            localObject6 = null;
          }
          if (localObject6 == null) {
            bool5 = true;
          } else {
            bool5 = false;
          }
          l2 = l1;
          localObject1 = localObject6;
          bool6 = bool5;
          if (bool4) {
            if (bool5)
            {
              l2 = l1 | 0x20000;
              localObject1 = localObject6;
              bool6 = bool5;
            }
            else
            {
              l2 = l1 | 0x10000;
              localObject1 = localObject6;
              bool6 = bool5;
            }
          }
        }
        else
        {
          localObject1 = null;
          bool6 = false;
          l2 = l1;
        }
        if ((l2 & 0x2C0) != 0L)
        {
          if (localSensorDetailViewModel != null) {
            localObject6 = localSensorDetailViewModel.D();
          } else {
            localObject6 = null;
          }
          updateLiveDataRegistration(6, (LiveData)localObject6);
          if (localObject6 != null) {
            localBoolean = (Boolean)((LiveData)localObject6).getValue();
          }
          bool2 = ViewDataBinding.safeUnbox(localBoolean);
          bool7 = bool3;
        }
        else
        {
          bool2 = false;
          bool7 = bool3;
        }
      }
      else
      {
        localObject6 = null;
        localObject3 = localObject6;
        localObject5 = localObject3;
        bool2 = false;
        bool6 = false;
        i = 0;
        bool7 = false;
        j = 0;
        k = 0;
        localObject4 = localObject3;
        localObject3 = localObject6;
        l2 = l1;
      }
      if (((l2 & 0x10000) != 0L) && (localObject1 != null)) {
        bool3 = ((List)localObject1).isEmpty();
      } else {
        bool3 = false;
      }
      boolean bool5 = (l2 & 0x2A0) < 0L;
      if (bool5)
      {
        if (bool6) {
          bool3 = true;
        }
      }
      else {
        bool3 = false;
      }
      if ((l2 & 0x300) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
      }
      if ((0x2C0 & l2) != 0L) {
        com.tplink.iot.Utils.extension.a.h(this.y, bool2);
      }
      if ((l2 & 0x281) != 0L) {
        this.p0.setImageResource(i);
      }
      if (bool5) {
        com.tplink.iot.Utils.extension.a.h(this.R3, bool3);
      }
      if ((0x290 & l2) != 0L) {
        com.tplink.iot.Utils.extension.a.h(this.I3, bool7);
      }
      if ((l2 & 0x282) != 0L) {
        TextViewBindingAdapter.setText(this.I3, (CharSequence)localObject3);
      }
      if ((0x284 & l2) != 0L)
      {
        this.J3.setVisibility(k);
        TextViewBindingAdapter.setText(this.L3, (CharSequence)localObject4);
        com.tplink.iot.Utils.extension.a.d(this.L3, j);
      }
      if ((l2 & 0x288) != 0L) {
        TextViewBindingAdapter.setText(this.K3, (CharSequence)localObject5);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SensorDetailViewModel paramSensorDetailViewModel)
  {
    this.N3 = paramSensorDetailViewModel;
    try
    {
      this.S3 |= 0x80;
      notifyPropertyChanged(15);
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
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.M3 = paramOnClickListener;
    try
    {
      this.S3 |= 0x100;
      notifyPropertyChanged(69);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.S3 = 512L;
      requestRebind();
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
    case 6: 
      return q((MediatorLiveData)paramObject, paramInt2);
    case 5: 
      return r((LiveData)paramObject, paramInt2);
    case 4: 
      return m((LiveData)paramObject, paramInt2);
    case 3: 
      return n((LiveData)paramObject, paramInt2);
    case 2: 
      return o((LiveData)paramObject, paramInt2);
    case 1: 
      return l((LiveData)paramObject, paramInt2);
    }
    return p((LiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (15 == paramInt)
    {
      h((SensorDetailViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      i((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorDetailContentBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */