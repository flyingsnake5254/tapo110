package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.view.adapter.a;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;

public class ItemSummaryHistoryBindingImpl
  extends ItemSummaryHistoryBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final ConstraintLayout K3;
  @NonNull
  private final ImageView L3;
  @NonNull
  private final CardView M3;
  @NonNull
  private final ImageView N3;
  private long O3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    J3 = localSparseIntArray;
    localSparseIntArray.put(2131364120, 11);
    localSparseIntArray.put(2131362191, 12);
    localSparseIntArray.put(2131362753, 13);
  }
  
  public ItemSummaryHistoryBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 14, I3, J3));
  }
  
  private ItemSummaryHistoryBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[9], (CardView)paramArrayOfObject[12], (Guideline)paramArrayOfObject[13], (ImageView)paramArrayOfObject[1], (CardView)paramArrayOfObject[11], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[10]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.y.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[2];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (CardView)paramArrayOfObject[3];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[4];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(MutableLiveData<d> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.O3 |= 1L;
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
      long l1 = this.O3;
      this.O3 = 0L;
      com.tplink.iot.dailysummary.model.b localb = this.H3;
      Object localObject1 = this.p3;
      d locald = null;
      int j;
      int k;
      Object localObject2;
      boolean bool2;
      Object localObject3;
      int m;
      int n;
      int i1;
      int i2;
      boolean bool3;
      int i3;
      long l2;
      int i4;
      int i;
      int i5;
      int i6;
      if ((l1 & 0xF) != 0L)
      {
        boolean bool1 = (l1 & 0xA) < 0L;
        if (bool1)
        {
          if (localb != null)
          {
            j = localb.f();
            k = localb.m();
            localObject2 = localb.k();
            bool2 = localb.o();
            localObject3 = localb.d();
            m = localb.h();
            n = localb.g();
            i1 = localb.a();
            i2 = localb.e();
            bool3 = localb.n();
            i3 = localb.j();
          }
          else
          {
            localObject2 = null;
            localObject3 = localObject2;
            j = 0;
            k = 0;
            i3 = 0;
            bool2 = false;
            m = 0;
            n = 0;
            i1 = 0;
            i2 = 0;
            bool3 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 128L;
            } else {
              l2 = 64L;
            }
            l2 = l1 | l2;
          }
          l1 = l2;
          if ((l2 & 0xA) != 0L)
          {
            if (bool3) {
              l1 = 512L;
            } else {
              l1 = 256L;
            }
            l1 = l2 | l1;
          }
          if (localObject2 == null) {
            i4 = 1;
          } else {
            i4 = 0;
          }
          if (bool2) {
            bool1 = false;
          } else {
            i = 8;
          }
          localObject2 = this.N3.getContext();
          if (bool3) {
            i5 = 2131231588;
          } else {
            i5 = 2131231574;
          }
          localObject2 = AppCompatResources.getDrawable((Context)localObject2, i5);
          if (i3 == 1) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          l2 = l1;
          if ((l1 & 0xA) != 0L)
          {
            if (i4 != 0)
            {
              l1 |= 0x20;
              l2 = 8192L;
            }
            else
            {
              l1 |= 0x10;
              l2 = 4096L;
            }
            l2 = l1 | l2;
          }
          l1 = l2;
          if ((l2 & 0xA) != 0L)
          {
            if (i3 != 0) {
              l1 = 131072L;
            } else {
              l1 = 65536L;
            }
            l1 = l2 | l1;
          }
          if (i4 != 0) {
            i5 = 8;
          } else {
            i5 = 0;
          }
          if (i4 != 0) {
            i6 = 0;
          } else {
            i6 = 8;
          }
          if (i3 != 0)
          {
            i7 = 0;
            l2 = l1;
            i4 = j;
            i3 = k;
            k = i7;
            j = i5;
            i5 = i6;
          }
          else
          {
            i7 = 8;
            l2 = l1;
            i4 = j;
            i3 = k;
            k = i7;
            j = i5;
            i5 = i6;
          }
        }
        else
        {
          localObject2 = null;
          localObject3 = localObject2;
          i4 = 0;
          i3 = 0;
          k = 0;
          j = 0;
          i5 = 0;
          i = 0;
          m = 0;
          n = 0;
          i1 = 0;
          i2 = 0;
          l2 = l1;
        }
        if (localb != null) {
          bool2 = localb.b();
        } else {
          bool2 = false;
        }
        if ((l2 & 0xF) != 0L) {
          if (bool2) {
            l2 |= 0x8000;
          } else {
            l2 |= 0x4000;
          }
        }
        i7 = i5;
        i8 = i;
        int i9 = n;
        i = i1;
        n = i2;
        i6 = i3;
        i5 = k;
        i1 = i7;
        i2 = i8;
        i3 = m;
        m = i9;
      }
      else
      {
        localObject2 = null;
        localObject3 = localObject2;
        i4 = 0;
        i6 = 0;
        i5 = 0;
        j = 0;
        bool2 = false;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        m = 0;
        i = 0;
        n = 0;
        l2 = l1;
      }
      if ((l2 & 0x8000) != 0L)
      {
        if (localObject1 != null) {
          localObject1 = ((SummaryHistoryViewModel)localObject1).S();
        } else {
          localObject1 = null;
        }
        updateLiveDataRegistration(0, (LiveData)localObject1);
        if (localObject1 != null) {
          locald = (d)((LiveData)localObject1).getValue();
        }
        if (locald != null) {
          bool3 = locald.b();
        } else {
          bool3 = false;
        }
        k = bool3 ^ true;
      }
      else
      {
        k = 0;
      }
      int i8 = 0;
      boolean bool4 = (l2 & 0xF) < 0L;
      l1 = l2;
      int i7 = i8;
      if (bool4)
      {
        if (!bool2) {
          k = 0;
        }
        l1 = l2;
        if (bool4)
        {
          if (k != 0) {
            l1 = 2048L;
          } else {
            l1 = 1024L;
          }
          l1 = l2 | l1;
        }
        if (k != 0) {
          i7 = i8;
        } else {
          i7 = 8;
        }
      }
      if ((l1 & 0xA) != 0L)
      {
        this.c.setVisibility(i);
        this.f.setVisibility(i6);
        a.b(this.y, localb);
        this.y.setVisibility(j);
        this.L3.setVisibility(i1);
        this.M3.setVisibility(i5);
        this.N3.setVisibility(i2);
        ImageViewBindingAdapter.setImageDrawable(this.N3, (Drawable)localObject2);
        TextViewBindingAdapter.setText(this.p0, (CharSequence)localObject3);
        com.tplink.iot.dailysummary.view.adapter.b.b(this.p1, n);
        this.p1.setVisibility(i4);
        com.tplink.iot.dailysummary.view.adapter.b.c(this.p2, m);
        this.p2.setVisibility(i3);
      }
      if ((l1 & 0xF) != 0L) {
        this.d.setVisibility(i7);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable com.tplink.iot.dailysummary.model.b paramb)
  {
    this.H3 = paramb;
    try
    {
      this.O3 |= 0x2;
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
      return this.O3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable SummaryHistoryViewModel paramSummaryHistoryViewModel)
  {
    this.p3 = paramSummaryHistoryViewModel;
    try
    {
      this.O3 |= 0x4;
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
      this.O3 = 8L;
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
      i((SummaryHistoryViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemSummaryHistoryBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */