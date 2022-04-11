package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.view.adapter.a;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;

public class ItemSummaryHomeBindingImpl
  extends ItemSummaryHomeBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts H3;
  @Nullable
  private static final SparseIntArray I3;
  @NonNull
  private final CardView J3;
  @NonNull
  private final ImageView K3;
  @NonNull
  private final CardView L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    I3 = localSparseIntArray;
    localSparseIntArray.put(2131362191, 10);
    localSparseIntArray.put(2131362753, 11);
  }
  
  public ItemSummaryHomeBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 12, H3, I3));
  }
  
  private ItemSummaryHomeBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[8], (CardView)paramArrayOfObject[10], (Guideline)paramArrayOfObject[11], (ImageView)paramArrayOfObject[1], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[9]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.y.setTag(null);
    paramDataBindingComponent = (CardView)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[2];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (CardView)paramArrayOfObject[3];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(MutableLiveData<d> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 1L;
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
      long l1 = this.M3;
      this.M3 = 0L;
      com.tplink.iot.dailysummary.model.b localb = this.p3;
      DailySummaryViewModel localDailySummaryViewModel = this.p2;
      d locald = null;
      int j;
      int k;
      int m;
      int n;
      Object localObject1;
      int i1;
      Object localObject2;
      int i2;
      int i3;
      int i4;
      long l2;
      int i;
      int i5;
      boolean bool3;
      if ((l1 & 0xF) != 0L)
      {
        boolean bool1 = (l1 & 0xA) < 0L;
        if (bool1)
        {
          if (localb != null)
          {
            j = localb.g();
            k = localb.a();
            m = localb.f();
            n = localb.m();
            localObject1 = localb.k();
            i1 = localb.e();
            localObject2 = localb.d();
            i2 = localb.h();
            i3 = localb.j();
          }
          else
          {
            localObject1 = null;
            localObject2 = localObject1;
            j = 0;
            k = 0;
            i3 = 0;
            m = 0;
            n = 0;
            i1 = 0;
            i2 = 0;
          }
          if (localObject1 == null) {
            i4 = 1;
          } else {
            i4 = 0;
          }
          if (i3 == 1) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          l2 = l1;
          if (bool1)
          {
            if (i4 != 0)
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
          l1 = l2;
          if ((l2 & 0xA) != 0L)
          {
            if (i3 != 0) {
              l1 = 8192L;
            } else {
              l1 = 4096L;
            }
            l1 = l2 | l1;
          }
          if (i4 != 0) {
            i = 8;
          } else {
            i = 0;
          }
          if (i4 != 0) {
            i5 = 0;
          } else {
            i5 = 8;
          }
          if (i3 != 0)
          {
            i6 = 0;
            l2 = l1;
            i4 = j;
            i3 = k;
            k = i6;
            j = i;
            i = m;
            m = n;
            n = i5;
          }
          else
          {
            i6 = 8;
            l2 = l1;
            i4 = j;
            i3 = k;
            k = i6;
            j = i;
            i = m;
            m = n;
            n = i5;
          }
        }
        else
        {
          localObject2 = null;
          i4 = 0;
          i3 = 0;
          k = 0;
          j = 0;
          i = 0;
          m = 0;
          n = 0;
          i1 = 0;
          i2 = 0;
          l2 = l1;
        }
        if (localb != null) {
          bool3 = localb.b();
        } else {
          bool3 = false;
        }
        if ((l2 & 0xF) != 0L) {
          if (bool3) {
            l2 |= 0x800;
          } else {
            l2 |= 0x400;
          }
        }
        int i6 = i;
        int i7 = m;
        i = i1;
        int i8 = i2;
        i5 = i3;
        i2 = k;
        m = i6;
        i1 = i7;
        i3 = n;
        n = i8;
      }
      else
      {
        localObject2 = null;
        i4 = 0;
        i5 = 0;
        i2 = 0;
        j = 0;
        bool3 = false;
        m = 0;
        i1 = 0;
        i3 = 0;
        i = 0;
        n = 0;
        l2 = l1;
      }
      if ((l2 & 0x800) != 0L)
      {
        if (localDailySummaryViewModel != null) {
          localObject1 = localDailySummaryViewModel.Z();
        } else {
          localObject1 = null;
        }
        updateLiveDataRegistration(0, (LiveData)localObject1);
        if (localObject1 != null) {
          locald = (d)((LiveData)localObject1).getValue();
        }
        boolean bool4;
        if (locald != null) {
          bool4 = locald.b();
        } else {
          bool4 = false;
        }
        k = bool4 ^ true;
      }
      else
      {
        k = 0;
      }
      boolean bool2 = (l2 & 0xF) < 0L;
      if (bool2)
      {
        if (!bool3) {
          k = 0;
        }
        l1 = l2;
        if (bool2)
        {
          if (k != 0) {
            l1 = 32L;
          } else {
            l1 = 16L;
          }
          l1 = l2 | l1;
        }
        if (k != 0) {
          k = 0;
        } else {
          k = 8;
        }
        l2 = l1;
      }
      else
      {
        k = 0;
      }
      if ((0xA & l2) != 0L)
      {
        this.c.setVisibility(i5);
        this.f.setVisibility(i1);
        a.b(this.y, localb);
        this.y.setVisibility(j);
        this.K3.setVisibility(i3);
        this.L3.setVisibility(i2);
        TextViewBindingAdapter.setText(this.z, (CharSequence)localObject2);
        com.tplink.iot.dailysummary.view.adapter.b.b(this.p0, i);
        this.p0.setVisibility(m);
        com.tplink.iot.dailysummary.view.adapter.b.c(this.p1, i4);
        this.p1.setVisibility(n);
      }
      if ((l2 & 0xF) != 0L) {
        this.d.setVisibility(k);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable com.tplink.iot.dailysummary.model.b paramb)
  {
    this.p3 = paramb;
    try
    {
      this.M3 |= 0x2;
      notifyPropertyChanged(95);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.M3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable DailySummaryViewModel paramDailySummaryViewModel)
  {
    this.p2 = paramDailySummaryViewModel;
    try
    {
      this.M3 |= 0x4;
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
      this.M3 = 8L;
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
    return l((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (95 == paramInt)
    {
      h((com.tplink.iot.dailysummary.model.b)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      i((DailySummaryViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemSummaryHomeBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */