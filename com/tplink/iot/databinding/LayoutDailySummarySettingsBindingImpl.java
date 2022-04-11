package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.view.adapter.b;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;

public class LayoutDailySummarySettingsBindingImpl
  extends LayoutDailySummarySettingsBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts Y3;
  @Nullable
  private static final SparseIntArray Z3;
  @NonNull
  private final ImageView a4;
  @NonNull
  private final ImageView b4;
  private long c4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    Z3 = localSparseIntArray;
    localSparseIntArray.put(2131363211, 9);
    localSparseIntArray.put(2131364660, 10);
    localSparseIntArray.put(2131362127, 11);
    localSparseIntArray.put(2131364346, 12);
    localSparseIntArray.put(2131362461, 13);
    localSparseIntArray.put(2131362462, 14);
    localSparseIntArray.put(2131364558, 15);
    localSparseIntArray.put(2131362463, 16);
    localSparseIntArray.put(2131362464, 17);
    localSparseIntArray.put(2131362458, 18);
    localSparseIntArray.put(2131364717, 19);
    localSparseIntArray.put(2131362465, 20);
    localSparseIntArray.put(2131364716, 21);
    localSparseIntArray.put(2131362151, 22);
    localSparseIntArray.put(2131362466, 23);
    localSparseIntArray.put(2131364715, 24);
    localSparseIntArray.put(2131362150, 25);
    localSparseIntArray.put(2131362467, 26);
    localSparseIntArray.put(2131362752, 27);
    localSparseIntArray.put(2131362748, 28);
  }
  
  public LayoutDailySummarySettingsBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 29, Y3, Z3));
  }
  
  private LayoutDailySummarySettingsBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (TextView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[11], (View)paramArrayOfObject[25], (View)paramArrayOfObject[22], (View)paramArrayOfObject[18], (View)paramArrayOfObject[13], (View)paramArrayOfObject[14], (View)paramArrayOfObject[16], (View)paramArrayOfObject[17], (View)paramArrayOfObject[20], (View)paramArrayOfObject[23], (View)paramArrayOfObject[26], (Guideline)paramArrayOfObject[28], (Guideline)paramArrayOfObject[27], (ConstraintLayout)paramArrayOfObject[9], (ConstraintLayout)paramArrayOfObject[0], (SwitchCompat)paramArrayOfObject[2], (SwitchCompat)paramArrayOfObject[4], (TextView)paramArrayOfObject[12], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[15], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[10], (TextView)paramArrayOfObject[24], (TextView)paramArrayOfObject[21], (TextView)paramArrayOfObject[19], (TextView)paramArrayOfObject[8]);
    this.c.setTag(null);
    this.L3.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[6];
    this.a4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[7];
    this.b4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.M3.setTag(null);
    this.N3.setTag(null);
    this.P3.setTag(null);
    this.R3.setTag(null);
    this.W3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.c4 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(MutableLiveData<d> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.c4 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.c4 |= 0x4;
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
      long l1 = this.c4;
      this.c4 = 0L;
      DailySummaryViewModel localDailySummaryViewModel = this.X3;
      int j;
      boolean bool2;
      boolean bool3;
      boolean bool4;
      int k;
      int m;
      int n;
      int i;
      int i1;
      if ((0x1F & l1) != 0L)
      {
        Boolean localBoolean = null;
        boolean bool1 = (l1 & 0x19) < 0L;
        Object localObject1;
        long l2;
        if (bool1)
        {
          if (localDailySummaryViewModel != null) {
            localObject1 = localDailySummaryViewModel.e0();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (d)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            j = ((d)localObject1).c();
            bool2 = ((d)localObject1).b();
            bool3 = ((d)localObject1).f();
            bool4 = ((d)localObject1).e();
            k = ((d)localObject1).g();
            m = ((d)localObject1).d();
          }
          else
          {
            m = 0;
            j = 0;
            bool2 = false;
            bool3 = false;
            bool4 = false;
            k = 0;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool3)
            {
              l1 |= 0x100;
              l2 = 1024L;
            }
            else
            {
              l1 |= 0x80;
              l2 = 512L;
            }
            l2 = l1 | l2;
          }
          if (bool3) {
            n = 0;
          } else {
            n = 8;
          }
          if (bool3) {
            i = 8;
          } else {
            i = 0;
          }
        }
        else
        {
          m = 0;
          j = 0;
          n = 0;
          bool2 = false;
          i = 0;
          bool4 = false;
          k = 0;
          l2 = l1;
        }
        boolean bool5 = (l2 & 0x1A) < 0L;
        l1 = l2;
        if (bool5)
        {
          if (localDailySummaryViewModel != null) {
            localObject1 = localDailySummaryViewModel.b0();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool3 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l1 = l2;
          if (bool5)
          {
            if (bool3) {
              l1 = 64L;
            } else {
              l1 = 32L;
            }
            l1 = l2 | l1;
          }
          if (!bool3)
          {
            i1 = 8;
            break label377;
          }
        }
        i1 = 0;
        label377:
        boolean bool6;
        int i2;
        if ((l1 & 0x1C) != 0L)
        {
          if (localDailySummaryViewModel != null) {
            localObject1 = localDailySummaryViewModel.f0();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject1);
          if (localObject1 != null) {
            localBoolean = (Boolean)((LiveData)localObject1).getValue();
          }
          bool6 = ViewDataBinding.safeUnbox(localBoolean);
          bool3 = bool4;
          i2 = k;
          k = n;
          bool4 = bool2;
          bool2 = bool6;
          n = j;
          j = m;
          m = i2;
        }
        else
        {
          bool3 = bool4;
          i2 = k;
          bool6 = false;
          k = n;
          bool4 = bool2;
          bool2 = bool6;
          n = j;
          j = m;
          m = i2;
        }
      }
      else
      {
        i = 0;
        k = 0;
        bool4 = false;
        bool2 = false;
        i1 = 0;
        bool3 = false;
        n = 0;
        j = 0;
        m = 0;
      }
      if ((0x1C & l1) != 0L) {
        this.c.setEnabled(bool2);
      }
      if ((0x1A & l1) != 0L) {
        this.L3.setVisibility(i1);
      }
      if ((l1 & 0x19) != 0L)
      {
        this.a4.setVisibility(i);
        this.b4.setVisibility(k);
        CompoundButtonBindingAdapter.setChecked(this.M3, bool4);
        CompoundButtonBindingAdapter.setChecked(this.N3, bool3);
        b.c(this.P3, n);
        b.c(this.R3, j);
        b.c(this.W3, m);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable DailySummaryViewModel paramDailySummaryViewModel)
  {
    this.X3 = paramDailySummaryViewModel;
    try
    {
      this.c4 |= 0x8;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.c4 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.c4 = 16L;
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
        return m((MutableLiveData)paramObject, paramInt2);
      }
      return i((MutableLiveData)paramObject, paramInt2);
    }
    return l((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((DailySummaryViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutDailySummarySettingsBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */