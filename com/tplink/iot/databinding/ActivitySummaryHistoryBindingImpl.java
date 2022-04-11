package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.view.adapter.b;
import com.tplink.iot.dailysummary.viewmodel.BaseSummaryListViewModel;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

public class ActivitySummaryHistoryBindingImpl
  extends ActivitySummaryHistoryBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts K3;
  @Nullable
  private static final SparseIntArray L3;
  @NonNull
  private final ConstraintLayout M3;
  @NonNull
  private final ConstraintLayout N3;
  @NonNull
  private final View O3;
  private long P3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    L3 = localSparseIntArray;
    localSparseIntArray.put(2131362120, 11);
    localSparseIntArray.put(2131364289, 12);
    localSparseIntArray.put(2131362118, 13);
    localSparseIntArray.put(2131363829, 14);
    localSparseIntArray.put(2131362049, 15);
  }
  
  public ActivitySummaryHistoryBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 16, K3, L3));
  }
  
  private ActivitySummaryHistoryBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 7, (CardView)paramArrayOfObject[15], (TextView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[13], (ImageView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[11], (ImageView)paramArrayOfObject[9], (RecyclerView)paramArrayOfObject[7], (TPSmartRefreshLayout)paramArrayOfObject[14], (ConstraintLayout)paramArrayOfObject[3], (TextView)paramArrayOfObject[4], (ConstraintLayout)paramArrayOfObject[1], (TextView)paramArrayOfObject[12], (TextView)paramArrayOfObject[6]);
    this.d.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[10];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[8];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.z.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.p3.setTag(null);
    this.I3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x8;
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
        this.P3 |= 0x40;
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
        this.P3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(MutableLiveData<d> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean p(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(MutableLiveData<Integer> paramMutableLiveData, int paramInt)
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
      SummaryHistoryViewModel localSummaryHistoryViewModel = this.J3;
      Boolean localBoolean = null;
      boolean bool1 = false;
      Object localObject1;
      int j;
      int k;
      long l2;
      int i;
      label177:
      boolean bool4;
      int n;
      int m;
      label525:
      label539:
      Object localObject3;
      if ((0x1FF & l1) != 0L)
      {
        boolean bool2 = (l1 & 0x182) < 0L;
        if (bool2)
        {
          if (localSummaryHistoryViewModel != null) {
            localObject1 = localSummaryHistoryViewModel.V();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Integer)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          j = ViewDataBinding.safeUnbox((Integer)localObject1);
          if (j > 0) {
            k = 1;
          } else {
            k = 0;
          }
          l2 = l1;
          if (bool2)
          {
            if (k != 0) {
              l2 = 4096L;
            } else {
              l2 = 2048L;
            }
            l2 = l1 | l2;
          }
          if (k == 0)
          {
            i = 8;
            l1 = l2;
            break label177;
          }
        }
        else
        {
          j = 0;
          l2 = l1;
        }
        i = 0;
        l1 = l2;
        boolean bool3 = (l1 & 0x18C) < 0L;
        if (bool3)
        {
          if (localSummaryHistoryViewModel != null) {
            localObject1 = localSummaryHistoryViewModel.S();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (d)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          if (localObject1 != null) {
            bool4 = ((d)localObject1).b();
          } else {
            bool4 = false;
          }
          n = bool4 ^ true;
          l2 = l1;
          k = n;
          if (bool3) {
            if (n != 0)
            {
              l2 = l1 | 0x4000;
              k = n;
            }
            else
            {
              l2 = l1 | 0x2000;
              k = n;
            }
          }
        }
        else
        {
          k = 0;
          l2 = l1;
        }
        if ((l2 & 0x191) != 0L)
        {
          if (localSummaryHistoryViewModel != null) {
            localObject1 = localSummaryHistoryViewModel.Q();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool4 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l1 = l2;
          if ((l2 & 0x190) != 0L)
          {
            if (bool4)
            {
              l1 = l2 | 0x100000;
              l2 = 67108864L;
            }
            else
            {
              l1 = l2 | 0x80000;
              l2 = 33554432L;
            }
            l1 |= l2;
          }
          l2 = l1;
          if ((l1 & 0x191) != 0L) {
            if (bool4) {
              l2 = l1 | 0x1000000;
            } else {
              l2 = l1 | 0x800000;
            }
          }
          l1 = l2;
          bool5 = bool4;
          if ((l2 & 0x190) != 0L)
          {
            if (bool4) {
              n = 0;
            } else {
              n = 8;
            }
            l1 = l2;
            bool5 = bool4;
            i1 = n;
            if (!bool4) {
              break label525;
            }
            m = 8;
            break label539;
          }
        }
        else
        {
          bool5 = false;
          l1 = l2;
        }
        int i1 = 0;
        m = 0;
        n = i1;
        bool4 = bool5;
        l2 = l1;
        boolean bool6 = (l2 & 0x1A0) < 0L;
        if (bool6)
        {
          if (localSummaryHistoryViewModel != null) {
            localObject1 = localSummaryHistoryViewModel.U();
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (Boolean)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          bool5 = ViewDataBinding.safeUnbox((Boolean)localObject1);
          l1 = l2;
          if (bool6)
          {
            if (bool5) {
              l1 = 4194304L;
            } else {
              l1 = 2097152L;
            }
            l1 = l2 | l1;
          }
          int i2;
          if (bool5)
          {
            localObject1 = this.q.getContext();
            i2 = 2131231383;
          }
          else
          {
            localObject1 = this.q.getContext();
            i2 = 2131231381;
          }
          localObject1 = AppCompatResources.getDrawable((Context)localObject1, i2);
          l2 = l1;
        }
        else
        {
          localObject1 = null;
        }
        boolean bool7 = (l2 & 0x1C0) < 0L;
        if (bool7)
        {
          if (localSummaryHistoryViewModel != null) {
            localObject3 = localSummaryHistoryViewModel.P();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(6, (LiveData)localObject3);
          if (localObject3 != null) {
            localObject3 = (Boolean)((LiveData)localObject3).getValue();
          } else {
            localObject3 = null;
          }
          bool5 = ViewDataBinding.safeUnbox((Boolean)localObject3);
          l1 = l2;
          if (bool7)
          {
            if (bool5)
            {
              l2 |= 0x400;
              l1 = 65536L;
            }
            else
            {
              l2 |= 0x200;
              l1 = 32768L;
            }
            l1 = l2 | l1;
          }
          if (bool5) {
            i3 = 4;
          } else {
            i3 = 0;
          }
          if (bool5) {
            i4 = 0;
          } else {
            i4 = 8;
          }
          l2 = l1;
          bool8 = bool4;
          break label876;
        }
      }
      else
      {
        localObject1 = null;
        j = 0;
        i = 0;
        m = 0;
        bool4 = false;
        n = 0;
        k = 0;
        l2 = l1;
      }
      int i4 = 0;
      int i3 = 0;
      boolean bool8 = bool4;
      label876:
      if ((l2 & 0x1000000) != 0L)
      {
        if (localSummaryHistoryViewModel != null) {
          localObject3 = localSummaryHistoryViewModel.T();
        } else {
          localObject3 = null;
        }
        updateLiveDataRegistration(0, (LiveData)localObject3);
        if (localObject3 != null) {
          localObject3 = (Boolean)((LiveData)localObject3).getValue();
        } else {
          localObject3 = null;
        }
        bool4 = ViewDataBinding.safeUnbox((Boolean)localObject3) ^ true;
      }
      else
      {
        bool4 = false;
      }
      if ((l2 & 0x4000) != 0L)
      {
        if (localSummaryHistoryViewModel != null) {
          localObject3 = localSummaryHistoryViewModel.n();
        } else {
          localObject3 = null;
        }
        updateLiveDataRegistration(3, (LiveData)localObject3);
        if (localObject3 != null) {
          localBoolean = (Boolean)((LiveData)localObject3).getValue();
        }
        bool5 = ViewDataBinding.safeUnbox(localBoolean);
      }
      else
      {
        bool5 = false;
      }
      boolean bool9 = (l2 & 0x18C) < 0L;
      if (bool9)
      {
        if (k == 0) {
          bool5 = false;
        }
        l1 = l2;
        if (bool9)
        {
          if (bool5) {
            l1 = 262144L;
          } else {
            l1 = 131072L;
          }
          l1 = l2 | l1;
        }
        if (bool5) {
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
      bool9 = (l2 & 0x191) < 0L;
      boolean bool5 = bool1;
      if (bool9)
      {
        bool5 = bool1;
        if (bool8) {
          bool5 = bool4;
        }
      }
      if (bool9) {
        this.d.setEnabled(bool5);
      }
      if ((0x1A0 & l2) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.q, (Drawable)localObject1);
      }
      if ((l2 & 0x190) != 0L)
      {
        this.y.setVisibility(m);
        this.z.setVisibility(n);
      }
      if ((0x182 & l2) != 0L)
      {
        this.N3.setVisibility(i);
        this.O3.setVisibility(i);
        b.a(this.p2, j);
      }
      if ((0x1C0 & l2) != 0L)
      {
        this.p1.setVisibility(i4);
        this.p3.setVisibility(i3);
      }
      if ((l2 & 0x18C) != 0L) {
        this.I3.setVisibility(k);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SummaryHistoryViewModel paramSummaryHistoryViewModel)
  {
    this.J3 = paramSummaryHistoryViewModel;
    try
    {
      this.P3 |= 0x80;
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
      return this.P3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.P3 = 256L;
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
      return l((MutableLiveData)paramObject, paramInt2);
    case 5: 
      return p((MutableLiveData)paramObject, paramInt2);
    case 4: 
      return m((LiveData)paramObject, paramInt2);
    case 3: 
      return i((MutableLiveData)paramObject, paramInt2);
    case 2: 
      return n((MutableLiveData)paramObject, paramInt2);
    case 1: 
      return q((MutableLiveData)paramObject, paramInt2);
    }
    return o((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (103 == paramInt)
    {
      h((SummaryHistoryViewModel)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySummaryHistoryBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */