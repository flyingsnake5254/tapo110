package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.viewmodel.SummaryPlayViewModel;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout.b;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import java.util.ArrayList;
import java.util.LinkedList;

public class ActivitySummaryPlayBindingLandImpl
  extends ActivitySummaryPlayBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts n4;
  @Nullable
  private static final SparseIntArray o4;
  @NonNull
  private final ConstraintLayout p4;
  @NonNull
  private final ConstraintLayout q4;
  @Nullable
  private final View.OnClickListener r4;
  private long s4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    o4 = localSparseIntArray;
    localSparseIntArray.put(2131362130, 19);
    localSparseIntArray.put(2131362133, 20);
    localSparseIntArray.put(2131362137, 21);
    localSparseIntArray.put(2131362131, 22);
    localSparseIntArray.put(2131363203, 23);
    localSparseIntArray.put(2131362113, 24);
    localSparseIntArray.put(2131364818, 25);
    localSparseIntArray.put(2131363204, 26);
    localSparseIntArray.put(2131362126, 27);
    localSparseIntArray.put(2131363141, 28);
    localSparseIntArray.put(2131364663, 29);
    localSparseIntArray.put(2131363097, 30);
    localSparseIntArray.put(2131362089, 31);
  }
  
  public ActivitySummaryPlayBindingLandImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 32, n4, o4));
  }
  
  private ActivitySummaryPlayBindingLandImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 18, (LottieAnimationView)paramArrayOfObject[14], (TextView)paramArrayOfObject[18], (TextView)paramArrayOfObject[31], null, (ImageView)paramArrayOfObject[24], null, (ImageView)paramArrayOfObject[9], (TextView)paramArrayOfObject[10], (CardView)paramArrayOfObject[12], (ImageView)paramArrayOfObject[27], null, (ImageView)paramArrayOfObject[19], (ImageView)paramArrayOfObject[22], null, (ImageView)paramArrayOfObject[20], null, (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[21], (ConstraintLayout)paramArrayOfObject[15], (TextView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[30], null, (ImageView)paramArrayOfObject[28], (ConstraintLayout)paramArrayOfObject[7], null, (ConstraintLayout)paramArrayOfObject[23], (ScrollCalendar)paramArrayOfObject[26], null, null, (ConstraintLayout)paramArrayOfObject[1], (ConstraintLayout)paramArrayOfObject[0], null, (SummaryTimeAxisLayout)paramArrayOfObject[6], (PlayerView)paramArrayOfObject[13], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[17], null, (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[29], (WeekdayView)paramArrayOfObject[25]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.M3.setTag(null);
    this.N3.setTag(null);
    this.P3.setTag(null);
    this.Q3.setTag(null);
    this.U3.setTag(null);
    this.a4.setTag(null);
    this.b4.setTag(null);
    this.d4.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[11];
    this.p4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[16];
    this.q4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.e4.setTag(null);
    this.f4.setTag(null);
    this.g4.setTag(null);
    this.i4.setTag(null);
    setRootTag(paramView);
    this.r4 = new com.tplink.iot.generated.callback.a(this, 1);
    invalidateAll();
  }
  
  private boolean A(MutableLiveData<Long> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean B(MutableLiveData<com.tplink.iot.dailysummary.model.b> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x20000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean C(MutableLiveData<LinkedList<com.tplink.iot.dailysummary.model.c>> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x200;
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
        this.s4 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(MutableLiveData<String> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x1000;
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
        this.s4 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(MutableLiveData<d> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x800;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(MutableLiveData<Long> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x4000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean t(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x400;
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
        this.s4 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean v(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x2000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean w(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x8000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean x(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean y(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean z(MutableLiveData<ArrayList<Long>> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.s4 |= 0x10000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    paramView = this.l4;
    if (paramView != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramView.b0();
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.s4;
      this.s4 = 0L;
      SummaryTimeAxisLayout.b localb = this.m4;
      SummaryPlayViewModel localSummaryPlayViewModel = this.l4;
      Object localObject1 = null;
      Object localObject2;
      label95:
      Object localObject4;
      boolean bool4;
      Object localObject5;
      Object localObject6;
      float f;
      boolean bool5;
      label649:
      Object localObject7;
      boolean bool6;
      label771:
      boolean bool7;
      Object localObject8;
      Object localObject9;
      label1028:
      boolean bool8;
      Object localObject10;
      label1090:
      Object localObject11;
      long l3;
      int k;
      label1218:
      Object localObject12;
      Object localObject13;
      boolean bool9;
      label1429:
      int i2;
      int i3;
      int i4;
      int i5;
      int i6;
      Object localObject14;
      boolean bool10;
      boolean bool12;
      if ((0x1BFFFF & l1) != 0L)
      {
        if ((l1 & 0x180001) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject2 = localSummaryPlayViewModel.l0();
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(0, (LiveData)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((LiveData)localObject2).getValue();
            break label95;
          }
        }
        localObject2 = null;
        boolean bool1 = (l1 & 0x180002) < 0L;
        if (bool1)
        {
          if (localSummaryPlayViewModel != null) {
            localObject4 = localSummaryPlayViewModel.t0();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject4);
          if (localObject4 != null) {
            localObject4 = (Boolean)((LiveData)localObject4).getValue();
          } else {
            localObject4 = null;
          }
          bool4 = ViewDataBinding.safeUnbox((Boolean)localObject4);
          l2 = l1;
          if (bool1)
          {
            if (bool4) {
              l2 = 17179869184L;
            } else {
              l2 = 8589934592L;
            }
            l2 = l1 | l2;
          }
          localObject4 = this.M3.getContext();
          int i;
          if (bool4) {
            i = 2131231581;
          } else {
            i = 2131231585;
          }
          localObject4 = AppCompatResources.getDrawable((Context)localObject4, i);
          l1 = l2;
        }
        else
        {
          localObject4 = null;
        }
        boolean bool2 = (l1 & 0x180004) < 0L;
        if (bool2)
        {
          if (localSummaryPlayViewModel != null) {
            localObject5 = localSummaryPlayViewModel.u0();
          } else {
            localObject5 = null;
          }
          updateLiveDataRegistration(2, (LiveData)localObject5);
          if (localObject5 != null) {
            localObject5 = (Boolean)((LiveData)localObject5).getValue();
          } else {
            localObject5 = null;
          }
          bool4 = ViewDataBinding.safeUnbox((Boolean)localObject5);
          l2 = l1;
          if (bool2)
          {
            if (bool4) {
              l2 = 1099511627776L;
            } else {
              l2 = 549755813888L;
            }
            l2 = l1 | l2;
          }
          int j;
          if (bool4)
          {
            localObject5 = this.N3.getContext();
            j = 2131231582;
          }
          else
          {
            localObject5 = this.N3.getContext();
            j = 2131231583;
          }
          localObject5 = AppCompatResources.getDrawable((Context)localObject5, j);
          l1 = l2;
        }
        else
        {
          localObject5 = null;
        }
        boolean bool3 = (l1 & 0x180008) < 0L;
        if (bool3)
        {
          if (localSummaryPlayViewModel != null) {
            localObject6 = localSummaryPlayViewModel.f0();
          } else {
            localObject6 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject6);
          if (localObject6 != null) {
            localObject6 = (Boolean)((LiveData)localObject6).getValue();
          } else {
            localObject6 = null;
          }
          bool4 = ViewDataBinding.safeUnbox((Boolean)localObject6);
          l2 = l1;
          if (bool3)
          {
            if (bool4) {
              l2 = 1073741824L;
            } else {
              l2 = 536870912L;
            }
            l2 = l1 | l2;
          }
          if (bool4) {
            f = 1.0F;
          } else {
            f = 0.3F;
          }
          l1 = l2;
        }
        else
        {
          bool4 = false;
          f = 0.0F;
        }
        if ((l1 & 0x180010) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject6 = localSummaryPlayViewModel.D0();
          } else {
            localObject6 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject6);
          if (localObject6 != null) {
            localObject6 = (Boolean)((LiveData)localObject6).getValue();
          } else {
            localObject6 = null;
          }
          bool5 = ViewDataBinding.safeUnbox((Boolean)localObject6);
        }
        else
        {
          bool5 = false;
        }
        if ((l1 & 0x180020) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject6 = localSummaryPlayViewModel.I0();
          } else {
            localObject6 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (Long)((LiveData)localObject6).getValue();
            break label649;
          }
        }
        localObject6 = null;
        bool3 = (l1 & 0x180040) < 0L;
        l2 = l1;
        if (bool3)
        {
          if (localSummaryPlayViewModel != null) {
            localObject7 = localSummaryPlayViewModel.s0();
          } else {
            localObject7 = null;
          }
          updateLiveDataRegistration(6, (LiveData)localObject7);
          if (localObject7 != null) {
            localObject7 = (Boolean)((LiveData)localObject7).getValue();
          } else {
            localObject7 = null;
          }
          bool6 = ViewDataBinding.safeUnbox((Boolean)localObject7);
          l2 = l1;
          if (bool3)
          {
            if (bool6) {
              l2 = 16777216L;
            } else {
              l2 = 8388608L;
            }
            l2 = l1 | l2;
          }
          if (!bool6)
          {
            i1 = 8;
            break label771;
          }
        }
        i1 = 0;
        bool3 = (l2 & 0x1A0180) < 0L;
        if (bool3)
        {
          if (localSummaryPlayViewModel != null) {
            localObject7 = localSummaryPlayViewModel.x0();
          } else {
            localObject7 = null;
          }
          updateLiveDataRegistration(7, (LiveData)localObject7);
          if (localObject7 != null) {
            localObject7 = (Boolean)((LiveData)localObject7).getValue();
          } else {
            localObject7 = null;
          }
          bool6 = ViewDataBinding.safeUnbox((Boolean)localObject7);
          l1 = l2;
          bool7 = bool6;
          if (bool3) {
            if (bool6)
            {
              l1 = l2 | 0x400000000000;
              bool7 = bool6;
            }
            else
            {
              l1 = l2 | 0x200000000000;
              bool7 = bool6;
            }
          }
        }
        else
        {
          bool7 = false;
          l1 = l2;
        }
        if ((l1 & 0x180100) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject8 = localSummaryPlayViewModel.F0();
          } else {
            localObject8 = null;
          }
          updateLiveDataRegistration(8, (LiveData)localObject8);
          if (localObject8 != null) {
            localObject7 = (Boolean)((LiveData)localObject8).getValue();
          } else {
            localObject7 = null;
          }
          bool6 = ViewDataBinding.safeUnbox((Boolean)localObject7);
        }
        else
        {
          localObject8 = null;
          localObject7 = localObject8;
          bool6 = false;
        }
        if ((l1 & 0x180200) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject9 = localSummaryPlayViewModel.L0();
          } else {
            localObject9 = null;
          }
          updateLiveDataRegistration(9, (LiveData)localObject9);
          if (localObject9 != null)
          {
            localObject9 = (LinkedList)((LiveData)localObject9).getValue();
            break label1028;
          }
        }
        localObject9 = null;
        bool8 = bool7;
        if ((l1 & 0x181000) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject10 = localSummaryPlayViewModel.g0();
          } else {
            localObject10 = null;
          }
          updateLiveDataRegistration(12, (LiveData)localObject10);
          if (localObject10 != null)
          {
            localObject10 = (String)((LiveData)localObject10).getValue();
            break label1090;
          }
        }
        localObject10 = null;
        bool3 = (l1 & 0x182000) < 0L;
        if (bool3)
        {
          if (localSummaryPlayViewModel != null) {
            localObject11 = localSummaryPlayViewModel.B0();
          } else {
            localObject11 = null;
          }
          updateLiveDataRegistration(13, (LiveData)localObject11);
          if (localObject11 != null) {
            localObject11 = (Boolean)((LiveData)localObject11).getValue();
          } else {
            localObject11 = null;
          }
          bool7 = ViewDataBinding.safeUnbox((Boolean)localObject11);
          l3 = l1;
          if (bool3)
          {
            if (bool7) {
              l2 = 67108864L;
            } else {
              l2 = 33554432L;
            }
            l3 = l1 | l2;
          }
          if (bool7)
          {
            l1 = l3;
          }
          else
          {
            k = 8;
            break label1218;
          }
        }
        else
        {
          bool7 = false;
        }
        k = 0;
        l3 = l1;
        localObject12 = localObject8;
        localObject13 = localObject10;
        if ((l3 & 0x184000) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject8 = localSummaryPlayViewModel.q0();
          } else {
            localObject8 = null;
          }
          updateLiveDataRegistration(14, (LiveData)localObject8);
          if (localObject8 != null) {
            localObject8 = (Long)((LiveData)localObject8).getValue();
          } else {
            localObject8 = null;
          }
          l2 = ViewDataBinding.safeUnbox((Long)localObject8);
        }
        else
        {
          l2 = 0L;
        }
        if ((l3 & 0x188000) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject8 = localSummaryPlayViewModel.C0();
          } else {
            localObject8 = null;
          }
          updateLiveDataRegistration(15, (LiveData)localObject8);
          if (localObject8 != null) {
            localObject8 = (Boolean)((LiveData)localObject8).getValue();
          } else {
            localObject8 = null;
          }
          bool9 = ViewDataBinding.safeUnbox((Boolean)localObject8);
        }
        else
        {
          bool9 = false;
        }
        if ((l3 & 0x190000) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject8 = localSummaryPlayViewModel.H0();
          } else {
            localObject8 = null;
          }
          updateLiveDataRegistration(16, (LiveData)localObject8);
          if (localObject8 != null)
          {
            localObject8 = (ArrayList)((LiveData)localObject8).getValue();
            break label1429;
          }
        }
        localObject8 = null;
        boolean bool11;
        Object localObject15;
        Object localObject16;
        if ((l3 & 0x1A0C00) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject10 = localSummaryPlayViewModel.J0();
          } else {
            localObject10 = null;
          }
          updateLiveDataRegistration(17, (LiveData)localObject10);
          if (localObject10 != null) {
            localObject11 = (com.tplink.iot.dailysummary.model.b)((LiveData)localObject10).getValue();
          } else {
            localObject11 = null;
          }
          i2 = (l3 & 0x1A0400) < 0L;
          if (i2 != 0)
          {
            if (localObject11 != null) {
              i3 = ((com.tplink.iot.dailysummary.model.b)localObject11).j();
            } else {
              i3 = 0;
            }
            if (i3 == 2) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            l1 = l3;
            i5 = i3;
            i6 = i4;
            if (i2 != 0) {
              if (i4 != 0)
              {
                l1 = l3 | 0x10000000;
                i5 = i3;
                i6 = i4;
              }
              else
              {
                l1 = l3 | 0x8000000;
                i5 = i3;
                i6 = i4;
              }
            }
          }
          else
          {
            i5 = 0;
            i6 = 0;
            l1 = l3;
          }
          localObject14 = localObject10;
          if (((l1 & 0x1A0000) != 0L) && (localObject11 != null))
          {
            i3 = ((com.tplink.iot.dailysummary.model.b)localObject11).h();
            i4 = ((com.tplink.iot.dailysummary.model.b)localObject11).i();
          }
          else
          {
            i3 = 0;
            i4 = 0;
          }
          i2 = (l1 & 0x1A0800) < 0L;
          if (i2 != 0)
          {
            if (localObject11 != null) {
              bool10 = ((com.tplink.iot.dailysummary.model.b)localObject11).b();
            } else {
              bool10 = false;
            }
            l3 = l1;
            if (i2 != 0) {
              if (bool10) {
                l3 = l1 | 0x100000000000;
              } else {
                l3 = l1 | 0x80000000000;
              }
            }
            l1 = l3;
          }
          else
          {
            bool10 = false;
          }
          localObject10 = localObject11;
          i2 = i5;
          i5 = i1;
          i1 = i6;
          bool11 = bool9;
          bool12 = bool6;
          localObject15 = localObject5;
          bool9 = bool5;
          bool5 = bool7;
          localObject5 = localObject2;
          localObject2 = localObject7;
          localObject11 = localObject8;
          localObject16 = localObject9;
          i6 = i5;
          bool6 = bool11;
          bool7 = bool4;
          l3 = l2;
          l2 = l1;
          localObject7 = localObject4;
          i5 = k;
          localObject8 = localObject15;
          localObject4 = localObject10;
          k = i2;
          localObject9 = localObject5;
          bool4 = bool12;
          localObject10 = localObject16;
          localObject5 = localObject14;
        }
        else
        {
          localObject14 = null;
          bool12 = bool9;
          i7 = 0;
          bool11 = false;
          i3 = 0;
          i4 = 0;
          bool10 = bool6;
          localObject15 = localObject5;
          bool9 = bool5;
          l1 = l3;
          localObject10 = localObject14;
          bool5 = bool7;
          localObject5 = localObject7;
          localObject11 = localObject8;
          localObject16 = localObject9;
          i2 = 0;
          i6 = i1;
          bool6 = bool12;
          bool7 = bool4;
          l3 = l2;
          l2 = l1;
          localObject7 = localObject4;
          i5 = k;
          localObject8 = localObject15;
          localObject4 = localObject10;
          k = i7;
          i1 = i2;
          localObject9 = localObject2;
          localObject2 = localObject5;
          bool4 = bool10;
          localObject10 = localObject16;
          localObject5 = localObject14;
          bool10 = bool11;
        }
      }
      else
      {
        localObject14 = null;
        localObject7 = localObject14;
        localObject8 = localObject7;
        localObject4 = localObject8;
        localObject6 = localObject4;
        localObject12 = localObject6;
        localObject9 = localObject12;
        localObject2 = localObject9;
        localObject10 = localObject2;
        localObject11 = localObject10;
        localObject5 = localObject11;
        f = 0.0F;
        bool5 = false;
        i6 = 0;
        bool6 = false;
        bool7 = false;
        l3 = 0L;
        bool9 = false;
        i5 = 0;
        k = 0;
        bool8 = false;
        i1 = 0;
        bool4 = false;
        bool10 = false;
        i3 = 0;
        i4 = 0;
        localObject13 = localObject6;
        l2 = l1;
        localObject6 = localObject14;
      }
      if ((l2 & 0x100000000000) != 0L)
      {
        if (localSummaryPlayViewModel != null) {
          localObject14 = localSummaryPlayViewModel.p0();
        } else {
          localObject14 = null;
        }
        updateLiveDataRegistration(11, (LiveData)localObject14);
        if (localObject14 != null) {
          localObject14 = (d)((LiveData)localObject14).getValue();
        } else {
          localObject14 = null;
        }
        if (localObject14 != null) {
          bool12 = ((d)localObject14).b();
        } else {
          bool12 = false;
        }
        i2 = bool12 ^ true;
      }
      else
      {
        i2 = 0;
      }
      if ((l2 & 0x400000000000) != 0L)
      {
        if (localSummaryPlayViewModel != null) {
          localObject5 = localSummaryPlayViewModel.J0();
        }
        updateLiveDataRegistration(17, (LiveData)localObject5);
        if (localObject5 != null) {
          localObject4 = (com.tplink.iot.dailysummary.model.b)((LiveData)localObject5).getValue();
        }
        if (localObject4 != null) {
          k = ((com.tplink.iot.dailysummary.model.b)localObject4).j();
        }
        if (k == 2) {
          k = 1;
        } else {
          k = 0;
        }
        l1 = l2;
        i1 = k;
        if ((l2 & 0x1A0400) != 0L) {
          if (k != 0)
          {
            l1 = l2 | 0x10000000;
            i1 = k;
          }
          else
          {
            l1 = l2 | 0x8000000;
            i1 = k;
          }
        }
      }
      else
      {
        l1 = l2;
      }
      int m = (l1 & 0x1A0800) < 0L;
      long l2 = l1;
      if (m != 0)
      {
        if (!bool10) {
          i2 = 0;
        }
        l2 = l1;
        if (m != 0)
        {
          if (i2 != 0) {
            l2 = 274877906944L;
          } else {
            l2 = 137438953472L;
          }
          l2 = l1 | l2;
        }
        if (i2 == 0)
        {
          i7 = 8;
          l1 = l2;
          break label2358;
        }
      }
      int i7 = 0;
      l1 = l2;
      label2358:
      if ((l1 & 0x1A0180) != 0L)
      {
        if (bool8) {
          m = i1;
        } else {
          m = 0;
        }
        l2 = l1;
        if ((l1 & 0x1A0080) != 0L)
        {
          if (m != 0) {
            l2 = 68719476736L;
          } else {
            l2 = 34359738368L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0x1A0180) != 0L) {
          if (m != 0) {
            l1 = l2 | 0x40000000000;
          } else {
            l1 = l2 | 0x20000000000;
          }
        }
        i2 = m;
        l2 = l1;
        if ((l1 & 0x1A0080) != 0L) {
          if (m != 0)
          {
            i2 = m;
            l2 = l1;
          }
          else
          {
            i8 = 8;
            i2 = m;
            m = i8;
            break label2515;
          }
        }
      }
      else
      {
        i2 = 0;
        l2 = l1;
      }
      m = 0;
      l1 = l2;
      label2515:
      if ((l1 & 0x40000000000) != 0L)
      {
        if (localSummaryPlayViewModel != null) {
          localObject12 = localSummaryPlayViewModel.F0();
        }
        updateLiveDataRegistration(8, (LiveData)localObject12);
        if (localObject12 != null) {
          localObject2 = (Boolean)((LiveData)localObject12).getValue();
        }
        bool4 = ViewDataBinding.safeUnbox((Boolean)localObject2);
      }
      int i8 = m;
      if ((l1 & 0x10000000) != 0L)
      {
        if (localSummaryPlayViewModel != null) {
          localObject2 = localSummaryPlayViewModel.v0();
        } else {
          localObject2 = null;
        }
        updateLiveDataRegistration(10, (LiveData)localObject2);
        localObject4 = localObject1;
        if (localObject2 != null) {
          localObject4 = (Boolean)((LiveData)localObject2).getValue();
        }
        bool10 = ViewDataBinding.safeUnbox((Boolean)localObject4);
      }
      else
      {
        bool10 = false;
      }
      m = (l1 & 0x1A0400) < 0L;
      l2 = l1;
      if (m != 0)
      {
        if (i1 == 0) {
          bool10 = false;
        }
        l2 = l1;
        if (m != 0)
        {
          if (bool10) {
            l2 = 4194304L;
          } else {
            l2 = 2097152L;
          }
          l2 = l1 | l2;
        }
        if (!bool10)
        {
          i1 = 8;
          l1 = l2;
          break label2728;
        }
      }
      int i1 = 0;
      l1 = l2;
      label2728:
      m = (l1 & 0x1A0180) < 0L;
      int n;
      if (m != 0)
      {
        if (i2 != 0) {
          bool10 = bool4;
        } else {
          bool10 = false;
        }
        l2 = l1;
        if (m != 0)
        {
          if (bool10) {
            l2 = 4294967296L;
          } else {
            l2 = 2147483648L;
          }
          l2 = l1 | l2;
        }
        if (bool10) {
          m = 0;
        } else {
          n = 8;
        }
        l1 = l2;
      }
      else
      {
        n = 0;
      }
      if ((l1 & 0x180040) != 0L) {
        this.c.setVisibility(i6);
      }
      if ((l1 & 0x1A0800) != 0L) {
        this.d.setVisibility(i7);
      }
      if ((l1 & 0x100000) != 0L) {
        this.d.setOnClickListener(this.r4);
      }
      if ((l1 & 0x180008) != 0L)
      {
        this.z.setClickable(bool7);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.z.setAlpha(f);
        }
      }
      if ((l1 & 0x182000) != 0L)
      {
        this.p0.setVisibility(i5);
        com.tplink.iot.Utils.extension.a.h(this.U3, bool5);
      }
      if ((0x188000 & l1) != 0L) {
        com.tplink.iot.Utils.extension.a.h(this.p1, bool6);
      }
      if ((l1 & 0x180002) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.M3, (Drawable)localObject7);
      }
      if ((l1 & 0x180004) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.N3, (Drawable)localObject8);
      }
      if ((l1 & 0x1A0400) != 0L) {
        this.P3.setVisibility(i1);
      }
      if ((l1 & 0x1A0180) != 0L) {
        this.Q3.setVisibility(n);
      }
      if ((0x180010 & l1) != 0L) {
        com.tplink.iot.Utils.extension.a.h(this.a4, bool9);
      }
      if ((0x184000 & l1) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.d(this.d4, l3);
      }
      if ((0x180020 & l1) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.e(this.d4, (Long)localObject6);
      }
      if ((0x180200 & l1) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.c(this.d4, (LinkedList)localObject10);
      }
      if ((0x190000 & l1) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.a(this.d4, (ArrayList)localObject11);
      }
      if ((0x180100 & l1) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.b(this.d4, bool4);
      }
      if ((0x140000 & l1) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.f(this.d4, localb);
      }
      if ((l1 & 0x1A0080) != 0L)
      {
        this.p4.setVisibility(i8);
        this.e4.setVisibility(i8);
      }
      if ((0x1A0000 & l1) != 0L)
      {
        this.q4.setVisibility(i3);
        com.tplink.iot.dailysummary.view.adapter.b.c(this.g4, i4);
      }
      if ((l1 & 0x180001) != 0L) {
        TextViewBindingAdapter.setText(this.f4, (CharSequence)localObject9);
      }
      if ((0x181000 & l1) != 0L) {
        TextViewBindingAdapter.setText(this.i4, (CharSequence)localObject13);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable SummaryTimeAxisLayout.b paramb)
  {
    this.m4 = paramb;
    try
    {
      this.s4 |= 0x40000;
      notifyPropertyChanged(72);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.s4 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable SummaryPlayViewModel paramSummaryPlayViewModel)
  {
    this.l4 = paramSummaryPlayViewModel;
    try
    {
      this.s4 |= 0x80000;
      notifyPropertyChanged(105);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.s4 = 1048576L;
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
    case 17: 
      return B((MutableLiveData)paramObject, paramInt2);
    case 16: 
      return z((MutableLiveData)paramObject, paramInt2);
    case 15: 
      return w((MutableLiveData)paramObject, paramInt2);
    case 14: 
      return p((MutableLiveData)paramObject, paramInt2);
    case 13: 
      return v((MutableLiveData)paramObject, paramInt2);
    case 12: 
      return m((MutableLiveData)paramObject, paramInt2);
    case 11: 
      return o((MutableLiveData)paramObject, paramInt2);
    case 10: 
      return t((MutableLiveData)paramObject, paramInt2);
    case 9: 
      return C((MutableLiveData)paramObject, paramInt2);
    case 8: 
      return y((MutableLiveData)paramObject, paramInt2);
    case 7: 
      return u((MutableLiveData)paramObject, paramInt2);
    case 6: 
      return q((MutableLiveData)paramObject, paramInt2);
    case 5: 
      return A((MutableLiveData)paramObject, paramInt2);
    case 4: 
      return x((MutableLiveData)paramObject, paramInt2);
    case 3: 
      return l((MutableLiveData)paramObject, paramInt2);
    case 2: 
      return s((MutableLiveData)paramObject, paramInt2);
    case 1: 
      return r((MutableLiveData)paramObject, paramInt2);
    }
    return n((LiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (72 == paramInt)
    {
      h((SummaryTimeAxisLayout.b)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label36;
      }
      i((SummaryPlayViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySummaryPlayBindingLandImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */