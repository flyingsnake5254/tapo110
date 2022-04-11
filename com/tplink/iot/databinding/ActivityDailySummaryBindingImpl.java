package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.view.adapter.a;
import com.tplink.iot.dailysummary.viewmodel.BaseSummaryListViewModel;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

public class ActivityDailySummaryBindingImpl
  extends ActivityDailySummaryBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts S3;
  @Nullable
  private static final SparseIntArray T3;
  @NonNull
  private final ConstraintLayout U3;
  @NonNull
  private final TextView V3;
  private long W3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(23);
    S3 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(0, new String[] { "layout_daily_summary_settings" }, new int[] { 17 }, new int[] { 2131559119 });
    localObject = new SparseIntArray();
    T3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131364276, 18);
    ((SparseIntArray)localObject).put(2131362045, 19);
    ((SparseIntArray)localObject).put(2131364277, 20);
    ((SparseIntArray)localObject).put(2131363830, 21);
    ((SparseIntArray)localObject).put(2131362749, 22);
  }
  
  public ActivityDailySummaryBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 23, S3, T3));
  }
  
  private ActivityDailySummaryBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 8, (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[10], (ImageView)paramArrayOfObject[19], (ImageView)paramArrayOfObject[6], (TextView)paramArrayOfObject[13], (ImageView)paramArrayOfObject[1], (CardView)paramArrayOfObject[2], (Guideline)paramArrayOfObject[22], (LayoutDailySummarySettingsBinding)paramArrayOfObject[17], (ImageView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[15], (ConstraintLayout)paramArrayOfObject[12], (RecyclerView)paramArrayOfObject[14], (TPSmartRefreshLayout)paramArrayOfObject[21], (ConstraintLayout)paramArrayOfObject[18], (TextView)paramArrayOfObject[20], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[11], (TextView)paramArrayOfObject[16]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    setContainedBinding(this.p1);
    this.p2.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    this.I3.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.U3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[4];
    this.V3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.J3.setTag(null);
    this.N3.setTag(null);
    this.O3.setTag(null);
    this.P3.setTag(null);
    this.Q3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(LayoutDailySummarySettingsBinding paramLayoutDailySummarySettingsBinding, int paramInt)
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
  
  private boolean l(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x40;
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
        this.W3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x80;
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
        this.W3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(MutableLiveData<d> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(LiveData<com.tplink.iot.dailysummary.model.b> paramLiveData, int paramInt)
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
  
  private boolean r(LiveData<String> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.W3 |= 0x20;
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
      DailySummaryViewModel localDailySummaryViewModel = this.R3;
      d locald = null;
      Object localObject1;
      Object localObject3;
      int i;
      int j;
      int n;
      int i1;
      int i2;
      int i4;
      int i5;
      int i8;
      boolean bool5;
      int i11;
      boolean bool6;
      boolean bool7;
      label640:
      label650:
      int i7;
      label769:
      label825:
      MutableLiveData localMutableLiveData;
      Object localObject4;
      int i10;
      Object localObject5;
      boolean bool8;
      int m;
      if ((0x3FE & l1) != 0L)
      {
        int i6;
        if ((l1 & 0x312) != 0L)
        {
          if (localDailySummaryViewModel != null) {
            localObject1 = localDailySummaryViewModel.h0();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject3 = (com.tplink.iot.dailysummary.model.b)((LiveData)localObject1).getValue();
          } else {
            localObject3 = null;
          }
          i = (l1 & 0x302) < 0L;
          int k;
          int i9;
          if (i != 0)
          {
            if (localObject3 != null)
            {
              j = ((com.tplink.iot.dailysummary.model.b)localObject3).e();
              localObject1 = ((com.tplink.iot.dailysummary.model.b)localObject3).k();
              k = ((com.tplink.iot.dailysummary.model.b)localObject3).h();
              n = ((com.tplink.iot.dailysummary.model.b)localObject3).i();
              i1 = ((com.tplink.iot.dailysummary.model.b)localObject3).m();
              i2 = ((com.tplink.iot.dailysummary.model.b)localObject3).a();
            }
            else
            {
              localObject1 = null;
              j = 0;
              k = 0;
              n = 0;
              i1 = 0;
              i2 = 0;
            }
            if (localObject1 == null) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            l2 = l1;
            if (i != 0)
            {
              if (i4 != 0) {
                l2 = 8192L;
              } else {
                l2 = 4096L;
              }
              l2 = l1 | l2;
            }
            if (i4 != 0)
            {
              i5 = 0;
              i6 = n;
              i8 = i1;
              i9 = i2;
            }
            else
            {
              i5 = 8;
              i6 = n;
              i8 = i1;
              i9 = i2;
            }
          }
          else
          {
            i5 = 0;
            j = 0;
            k = 0;
            i6 = 0;
            i8 = 0;
            i9 = 0;
            l2 = l1;
          }
          if (localObject3 != null) {
            bool5 = ((com.tplink.iot.dailysummary.model.b)localObject3).b();
          } else {
            bool5 = false;
          }
          l1 = l2;
          localObject1 = localObject3;
          i11 = i5;
          i = j;
          bool6 = bool5;
          i4 = k;
          n = i6;
          i1 = i8;
          i2 = i9;
          if ((l2 & 0x312) != 0L)
          {
            if (bool5) {
              l1 = 524288L;
            } else {
              l1 = 262144L;
            }
            l1 = l2 | l1;
            localObject1 = localObject3;
            i11 = i5;
            i = j;
            bool6 = bool5;
            i4 = k;
            n = i6;
            i1 = i8;
            i2 = i9;
          }
        }
        else
        {
          localObject1 = null;
          i11 = 0;
          i = 0;
          bool6 = false;
          i4 = 0;
          n = 0;
          i1 = 0;
          i2 = 0;
        }
        if ((l1 & 0x354) != 0L)
        {
          if (localDailySummaryViewModel != null) {
            localObject3 = localDailySummaryViewModel.Y();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject3);
          if (localObject3 != null) {
            localObject3 = (Boolean)((LiveData)localObject3).getValue();
          } else {
            localObject3 = null;
          }
          bool5 = ViewDataBinding.safeUnbox((Boolean)localObject3);
          l2 = l1;
          if ((l1 & 0x304) != 0L)
          {
            if (bool5)
            {
              l1 |= 0x8000;
              l2 = 33554432L;
            }
            else
            {
              l1 |= 0x4000;
              l2 = 16777216L;
            }
            l2 = l1 | l2;
          }
          l1 = l2;
          if ((l2 & 0x354) != 0L)
          {
            if (bool5) {
              l1 = 2147483648L;
            } else {
              l1 = 1073741824L;
            }
            l1 = l2 | l1;
          }
          l2 = l1;
          bool7 = bool5;
          if ((l1 & 0x304) != 0L)
          {
            if (bool5) {
              i5 = 0;
            } else {
              i5 = 8;
            }
            l2 = l1;
            bool7 = bool5;
            j = i5;
            if (!bool5) {
              break label640;
            }
            i6 = 8;
            j = i5;
            i5 = i6;
            break label650;
          }
        }
        else
        {
          bool7 = false;
          l2 = l1;
        }
        j = 0;
        i5 = 0;
        bool5 = bool7;
        l1 = l2;
        boolean bool3 = (l1 & 0x308) < 0L;
        l2 = l1;
        if (bool3)
        {
          if (localDailySummaryViewModel != null) {
            localObject3 = localDailySummaryViewModel.W();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject3);
          if (localObject3 != null) {
            localObject3 = (Boolean)((LiveData)localObject3).getValue();
          } else {
            localObject3 = null;
          }
          bool7 = ViewDataBinding.safeUnbox((Boolean)localObject3);
          l2 = l1;
          if (bool3)
          {
            if (bool7) {
              l2 = 134217728L;
            } else {
              l2 = 67108864L;
            }
            l2 = l1 | l2;
          }
          if (!bool7)
          {
            i7 = 8;
            break label769;
          }
        }
        i7 = 0;
        if ((l2 & 0x320) != 0L)
        {
          if (localDailySummaryViewModel != null) {
            localObject3 = localDailySummaryViewModel.i0();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((LiveData)localObject3).getValue();
            break label825;
          }
        }
        localObject3 = null;
        boolean bool4 = (l2 & 0x340) < 0L;
        if (bool4)
        {
          if (localDailySummaryViewModel != null) {
            localMutableLiveData = localDailySummaryViewModel.n();
          } else {
            localMutableLiveData = null;
          }
          updateLiveDataRegistration(6, localMutableLiveData);
          if (localMutableLiveData != null) {
            localObject4 = (Boolean)localMutableLiveData.getValue();
          } else {
            localObject4 = null;
          }
          bool7 = ViewDataBinding.safeUnbox((Boolean)localObject4);
          l1 = l2;
          if (bool4) {
            if (bool7) {
              l1 = l2 | 0x20000000;
            } else {
              l1 = l2 | 0x10000000;
            }
          }
          if (bool7) {
            bool4 = false;
          } else {
            i10 = 8;
          }
        }
        else
        {
          localMutableLiveData = null;
          localObject4 = localMutableLiveData;
          i10 = 0;
          bool7 = false;
          l1 = l2;
        }
        boolean bool1 = (l1 & 0x380) < 0L;
        int i13;
        if (bool1)
        {
          if (localDailySummaryViewModel != null) {
            localObject5 = localDailySummaryViewModel.X();
          } else {
            localObject5 = null;
          }
          updateLiveDataRegistration(7, (LiveData)localObject5);
          if (localObject5 != null) {
            localObject5 = (Boolean)((LiveData)localObject5).getValue();
          } else {
            localObject5 = null;
          }
          bool8 = ViewDataBinding.safeUnbox((Boolean)localObject5);
          l2 = l1;
          if (bool1)
          {
            if (bool8) {
              l2 = 8388608L;
            } else {
              l2 = 4194304L;
            }
            l2 = l1 | l2;
          }
          if (bool8) {
            bool1 = false;
          } else {
            m = 8;
          }
          int i12 = i5;
          i13 = i4;
          i5 = n;
          i14 = i1;
          l1 = l2;
          i8 = i11;
          i1 = m;
          n = i12;
          m = i7;
          i7 = j;
          bool8 = bool6;
          bool6 = bool7;
          i4 = i;
          i = i13;
          i11 = i14;
          j = i2;
        }
        else
        {
          m = i5;
          i5 = i;
          i = i4;
          i13 = n;
          i14 = i1;
          i1 = 0;
          i8 = i11;
          n = m;
          m = i7;
          i7 = j;
          bool8 = bool6;
          bool6 = bool7;
          i4 = i5;
          i5 = i13;
          i11 = i14;
          j = i2;
        }
      }
      else
      {
        localMutableLiveData = null;
        localObject4 = localMutableLiveData;
        localObject1 = localObject4;
        localObject3 = localObject1;
        i8 = 0;
        i1 = 0;
        n = 0;
        m = 0;
        i10 = 0;
        bool5 = false;
        i7 = 0;
        bool8 = false;
        bool6 = false;
        i4 = 0;
        i = 0;
        i5 = 0;
        i11 = 0;
        j = 0;
      }
      if ((l1 & 0x80080000) != 0L)
      {
        if (localDailySummaryViewModel != null) {
          localObject5 = localDailySummaryViewModel.Z();
        } else {
          localObject5 = null;
        }
        updateLiveDataRegistration(4, (LiveData)localObject5);
        if (localObject5 != null) {
          locald = (d)((LiveData)localObject5).getValue();
        }
        if (locald != null) {
          bool7 = locald.b();
        } else {
          bool7 = false;
        }
        i2 = bool7 ^ true;
      }
      else
      {
        i2 = 0;
      }
      boolean bool10 = (l1 & 0x312) < 0L;
      long l2 = l1;
      if (bool10)
      {
        if (bool8) {
          i14 = i2;
        } else {
          i14 = 0;
        }
        l2 = l1;
        if (bool10)
        {
          if (i14 != 0) {
            l2 = 2048L;
          } else {
            l2 = 1024L;
          }
          l2 = l1 | l2;
        }
        if (i14 == 0)
        {
          i14 = 8;
          l1 = l2;
          break label1427;
        }
      }
      int i14 = 0;
      l1 = l2;
      label1427:
      boolean bool9 = (l1 & 0x354) < 0L;
      if (bool9)
      {
        if (!bool5) {
          i2 = 0;
        }
        l2 = l1;
        bool10 = i2;
        if (bool9) {
          if (i2 != 0)
          {
            l2 = l1 | 0x200000;
            bool10 = i2;
          }
          else
          {
            l2 = l1 | 0x100000;
            bool10 = i2;
          }
        }
      }
      else
      {
        bool10 = false;
        l2 = l1;
      }
      if ((l2 & 0x200000) != 0L)
      {
        if (localDailySummaryViewModel != null) {
          localMutableLiveData = localDailySummaryViewModel.n();
        }
        updateLiveDataRegistration(6, localMutableLiveData);
        if (localMutableLiveData != null) {
          localObject4 = (Boolean)localMutableLiveData.getValue();
        }
        bool5 = ViewDataBinding.safeUnbox((Boolean)localObject4);
        l1 = l2;
        bool6 = bool5;
        if ((l2 & 0x340) != 0L)
        {
          if (bool5) {
            l1 = 536870912L;
          } else {
            l1 = 268435456L;
          }
          l1 = l2 | l1;
          bool6 = bool5;
        }
      }
      else
      {
        l1 = l2;
      }
      boolean bool2 = (l1 & 0x354) < 0L;
      int i3;
      if (bool2)
      {
        if (!bool10) {
          bool6 = false;
        }
        l2 = l1;
        if (bool2)
        {
          if (bool6) {
            l2 = 131072L;
          } else {
            l2 = 65536L;
          }
          l2 = l1 | l2;
        }
        if (bool6) {
          bool2 = false;
        } else {
          i3 = 8;
        }
        l1 = l2;
      }
      else
      {
        i3 = 0;
      }
      if ((0x302 & l1) != 0L)
      {
        this.c.setVisibility(j);
        this.q.setVisibility(i11);
        this.p2.setVisibility(i11);
        a.b(this.p2, (com.tplink.iot.dailysummary.model.b)localObject1);
        this.p3.setVisibility(i8);
        com.tplink.iot.dailysummary.view.adapter.b.c(this.V3, i5);
        this.V3.setVisibility(i);
        com.tplink.iot.dailysummary.view.adapter.b.b(this.N3, i4);
      }
      if ((l1 & 0x312) != 0L) {
        this.d.setVisibility(i14);
      }
      if ((0x380 & l1) != 0L) {
        this.x.setVisibility(i1);
      }
      if ((l1 & 0x340) != 0L) {
        this.y.setVisibility(i10);
      }
      if ((l1 & 0x304) != 0L)
      {
        this.z.setVisibility(i7);
        this.H3.setVisibility(n);
        this.Q3.setVisibility(n);
      }
      if ((0x300 & l1) != 0L) {
        this.p1.h(localDailySummaryViewModel);
      }
      if ((l1 & 0x308) != 0L)
      {
        this.I3.setVisibility(m);
        this.J3.setVisibility(m);
      }
      if ((l1 & 0x320) != 0L) {
        TextViewBindingAdapter.setText(this.O3, (CharSequence)localObject3);
      }
      if ((l1 & 0x354) != 0L) {
        this.P3.setVisibility(i3);
      }
      ViewDataBinding.executeBindingsOn(this.p1);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable DailySummaryViewModel paramDailySummaryViewModel)
  {
    this.R3 = paramDailySummaryViewModel;
    try
    {
      this.W3 |= 0x100;
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
      if (this.W3 != 0L) {
        return true;
      }
      return this.p1.hasPendingBindings();
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.W3 = 512L;
      this.p1.invalidateAll();
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
    case 7: 
      return n((LiveData)paramObject, paramInt2);
    case 6: 
      return l((MutableLiveData)paramObject, paramInt2);
    case 5: 
      return r((LiveData)paramObject, paramInt2);
    case 4: 
      return p((MutableLiveData)paramObject, paramInt2);
    case 3: 
      return m((LiveData)paramObject, paramInt2);
    case 2: 
      return o((LiveData)paramObject, paramInt2);
    case 1: 
      return q((LiveData)paramObject, paramInt2);
    }
    return i((LayoutDailySummarySettingsBinding)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.p1.setLifecycleOwner(paramLifecycleOwner);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDailySummaryBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */