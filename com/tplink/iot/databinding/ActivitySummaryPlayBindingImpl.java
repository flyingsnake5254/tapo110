package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
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
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import java.util.ArrayList;
import java.util.LinkedList;

public class ActivitySummaryPlayBindingImpl
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
    localSparseIntArray.put(2131363210, 25);
    localSparseIntArray.put(2131362129, 26);
    localSparseIntArray.put(2131363207, 27);
    localSparseIntArray.put(2131363206, 28);
    localSparseIntArray.put(2131363097, 29);
    localSparseIntArray.put(2131363202, 30);
    localSparseIntArray.put(2131362112, 31);
    localSparseIntArray.put(2131362113, 32);
    localSparseIntArray.put(2131364818, 33);
    localSparseIntArray.put(2131363204, 34);
  }
  
  public ActivitySummaryPlayBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 35, n4, o4));
  }
  
  private ActivitySummaryPlayBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 18, (LottieAnimationView)paramArrayOfObject[8], (TextView)paramArrayOfObject[14], null, (ImageView)paramArrayOfObject[31], (ImageView)paramArrayOfObject[32], (ImageView)paramArrayOfObject[16], (ImageView)paramArrayOfObject[19], (TextView)paramArrayOfObject[20], null, null, (ImageView)paramArrayOfObject[26], null, null, (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[5], (ConstraintLayout)paramArrayOfObject[9], (TextView)paramArrayOfObject[24], (ImageView)paramArrayOfObject[29], (ImageView)paramArrayOfObject[22], (ImageView)paramArrayOfObject[10], null, (ConstraintLayout)paramArrayOfObject[30], (ConstraintLayout)paramArrayOfObject[17], (ScrollCalendar)paramArrayOfObject[34], (ConstraintLayout)paramArrayOfObject[28], (LinearLayout)paramArrayOfObject[27], null, null, (ConstraintLayout)paramArrayOfObject[25], (SummaryTimeAxisLayout)paramArrayOfObject[23], (PlayerView)paramArrayOfObject[7], (TextView)paramArrayOfObject[21], (TextView)paramArrayOfObject[13], (TextView)paramArrayOfObject[15], (TextView)paramArrayOfObject[18], (TextView)paramArrayOfObject[11], (WeekdayView)paramArrayOfObject[33]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.J3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.M3.setTag(null);
    this.N3.setTag(null);
    this.O3.setTag(null);
    this.P3.setTag(null);
    this.Q3.setTag(null);
    this.S3.setTag(null);
    this.T3.setTag(null);
    this.W3.setTag(null);
    this.d4.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.p4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[12];
    this.q4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.e4.setTag(null);
    this.f4.setTag(null);
    this.g4.setTag(null);
    this.h4.setTag(null);
    this.i4.setTag(null);
    this.j4.setTag(null);
    setRootTag(paramView);
    this.r4 = new a(this, 1);
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
        this.s4 |= 0x800;
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
        this.s4 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(MutableLiveData<String> paramMutableLiveData, int paramInt)
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
  
  private boolean o(MutableLiveData<String> paramMutableLiveData, int paramInt)
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
  
  private boolean p(LiveData<String> paramLiveData, int paramInt)
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
  
  private boolean q(MutableLiveData<d> paramMutableLiveData, int paramInt)
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
  
  private boolean r(MutableLiveData<Long> paramMutableLiveData, int paramInt)
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
  
  private boolean s(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean t(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean u(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean v(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean w(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
  
  private boolean x(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
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
      float f1 = 0.0F;
      Object localObject1 = null;
      Object localObject2;
      Object localObject4;
      label98:
      boolean bool7;
      Object localObject5;
      Object localObject6;
      boolean bool8;
      float f2;
      Object localObject7;
      label576:
      label633:
      Object localObject8;
      int i2;
      label755:
      Object localObject9;
      boolean bool10;
      Object localObject10;
      label1075:
      int i4;
      Object localObject11;
      Object localObject12;
      boolean bool12;
      Object localObject13;
      int i6;
      boolean bool13;
      Object localObject14;
      label1420:
      boolean bool14;
      long l3;
      int n;
      label1545:
      Object localObject15;
      label1684:
      Object localObject16;
      int i7;
      int i8;
      int i9;
      int i10;
      int i11;
      boolean bool15;
      Object localObject19;
      Object localObject20;
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
            localObject4 = (String)((LiveData)localObject2).getValue();
            break label98;
          }
        }
        localObject4 = null;
        boolean bool1 = (l1 & 0x180002) < 0L;
        if (bool1)
        {
          if (localSummaryPlayViewModel != null) {
            localObject2 = localSummaryPlayViewModel.t0();
          } else {
            localObject2 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject2);
          if (localObject2 != null) {
            localObject2 = (Boolean)((LiveData)localObject2).getValue();
          } else {
            localObject2 = null;
          }
          bool7 = ViewDataBinding.safeUnbox((Boolean)localObject2);
          l2 = l1;
          if (bool1)
          {
            if (bool7) {
              l2 = 274877906944L;
            } else {
              l2 = 137438953472L;
            }
            l2 = l1 | l2;
          }
          localObject2 = this.M3.getContext();
          int i;
          if (bool7) {
            i = 2131231581;
          } else {
            i = 2131231585;
          }
          localObject2 = AppCompatResources.getDrawable((Context)localObject2, i);
          l1 = l2;
        }
        else
        {
          localObject2 = null;
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
          bool7 = ViewDataBinding.safeUnbox((Boolean)localObject5);
          l2 = l1;
          if (bool2)
          {
            if (bool7) {
              l2 = 17592186044416L;
            } else {
              l2 = 8796093022208L;
            }
            l2 = l1 | l2;
          }
          localObject5 = this.N3.getContext();
          int j;
          if (bool7) {
            j = 2131231582;
          } else {
            j = 2131231583;
          }
          localObject6 = AppCompatResources.getDrawable((Context)localObject5, j);
          l1 = l2;
        }
        else
        {
          localObject6 = null;
        }
        boolean bool3 = (l1 & 0x180008) < 0L;
        if (bool3)
        {
          if (localSummaryPlayViewModel != null) {
            localObject5 = localSummaryPlayViewModel.f0();
          } else {
            localObject5 = null;
          }
          updateLiveDataRegistration(3, (LiveData)localObject5);
          if (localObject5 != null) {
            localObject5 = (Boolean)((LiveData)localObject5).getValue();
          } else {
            localObject5 = null;
          }
          bool8 = ViewDataBinding.safeUnbox((Boolean)localObject5);
          l2 = l1;
          if (bool3)
          {
            if (bool8) {
              l2 = 4294967296L;
            } else {
              l2 = 2147483648L;
            }
            l2 = l1 | l2;
          }
          if (bool8)
          {
            f2 = 1.0F;
            l1 = l2;
          }
          else
          {
            f2 = 0.3F;
            l1 = l2;
          }
        }
        else
        {
          f2 = 0.0F;
          bool8 = false;
        }
        if ((0x180010 & l1) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject5 = localSummaryPlayViewModel.i0();
          } else {
            localObject5 = null;
          }
          updateLiveDataRegistration(4, (LiveData)localObject5);
          if (localObject5 != null)
          {
            localObject7 = (String)((LiveData)localObject5).getValue();
            break label576;
          }
        }
        localObject7 = null;
        if ((l1 & 0x180020) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject5 = localSummaryPlayViewModel.I0();
          } else {
            localObject5 = null;
          }
          updateLiveDataRegistration(5, (LiveData)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (Long)((LiveData)localObject5).getValue();
            break label633;
          }
        }
        localObject5 = null;
        bool3 = (l1 & 0x180040) < 0L;
        l2 = l1;
        if (bool3)
        {
          if (localSummaryPlayViewModel != null) {
            localObject8 = localSummaryPlayViewModel.s0();
          } else {
            localObject8 = null;
          }
          updateLiveDataRegistration(6, (LiveData)localObject8);
          if (localObject8 != null) {
            localObject8 = (Boolean)((LiveData)localObject8).getValue();
          } else {
            localObject8 = null;
          }
          bool7 = ViewDataBinding.safeUnbox((Boolean)localObject8);
          l2 = l1;
          if (bool3)
          {
            if (bool7) {
              l2 = 16777216L;
            } else {
              l2 = 8388608L;
            }
            l2 = l1 | l2;
          }
          if (!bool7)
          {
            i2 = 8;
            break label755;
          }
        }
        i2 = 0;
        bool3 = (l2 & 0x1A0180) < 0L;
        int k;
        if (bool3)
        {
          if (localSummaryPlayViewModel != null) {
            localObject8 = localSummaryPlayViewModel.x0();
          } else {
            localObject8 = null;
          }
          updateLiveDataRegistration(7, (LiveData)localObject8);
          if (localObject8 != null) {
            localObject8 = (Boolean)((LiveData)localObject8).getValue();
          } else {
            localObject8 = null;
          }
          bool7 = ViewDataBinding.safeUnbox((Boolean)localObject8);
          l1 = l2;
          if (bool3) {
            if (bool7) {
              l1 = l2 | 0x4000000000000;
            } else {
              l1 = l2 | 0x2000000000000;
            }
          }
          l2 = l1;
          if ((l1 & 0x180080) != 0L)
          {
            if (bool7) {
              l2 = 4503599627370496L;
            } else {
              l2 = 2251799813685248L;
            }
            l2 = l1 | l2;
          }
          if (((l2 & 0x180080) != 0L) && (!bool7))
          {
            k = 8;
            l1 = l2;
          }
          else
          {
            k = 0;
            l1 = l2;
          }
        }
        else
        {
          k = 0;
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
            localObject9 = (Boolean)((LiveData)localObject8).getValue();
          } else {
            localObject9 = null;
          }
          bool10 = ViewDataBinding.safeUnbox((Boolean)localObject9);
        }
        else
        {
          localObject9 = null;
          localObject8 = localObject9;
          bool10 = false;
        }
        if ((l1 & 0x180200) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject10 = localSummaryPlayViewModel.L0();
          } else {
            localObject10 = null;
          }
          updateLiveDataRegistration(9, (LiveData)localObject10);
          if (localObject10 != null)
          {
            localObject10 = (LinkedList)((LiveData)localObject10).getValue();
            break label1075;
          }
        }
        localObject10 = null;
        i4 = k;
        localObject11 = localObject9;
        boolean bool4 = (l1 & 0x180400) < 0L;
        int m;
        if (bool4)
        {
          if (localSummaryPlayViewModel != null) {
            localObject12 = localSummaryPlayViewModel.v0();
          } else {
            localObject12 = null;
          }
          updateLiveDataRegistration(10, (LiveData)localObject12);
          if (localObject12 != null) {
            localObject9 = (Boolean)((LiveData)localObject12).getValue();
          } else {
            localObject9 = null;
          }
          bool12 = ViewDataBinding.safeUnbox((Boolean)localObject9);
          l2 = l1;
          if (bool4)
          {
            if (bool12) {
              l2 = 268435456L;
            } else {
              l2 = 134217728L;
            }
            l2 = l1 | l2;
          }
          if (bool12)
          {
            bool4 = false;
            l1 = l2;
          }
          else
          {
            m = 8;
            l1 = l2;
          }
        }
        else
        {
          localObject12 = null;
          localObject9 = localObject12;
          m = 0;
          bool12 = false;
        }
        localObject13 = localObject4;
        i6 = (l1 & 0x180800) < 0L;
        if (i6 != 0)
        {
          if (localSummaryPlayViewModel != null) {
            localObject4 = localSummaryPlayViewModel.e0();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(11, (LiveData)localObject4);
          if (localObject4 != null) {
            localObject4 = (Boolean)((LiveData)localObject4).getValue();
          } else {
            localObject4 = null;
          }
          bool13 = ViewDataBinding.safeUnbox((Boolean)localObject4);
          l2 = l1;
          if (i6 != 0)
          {
            if (bool13) {
              l2 = 68719476736L;
            } else {
              l2 = 34359738368L;
            }
            l2 = l1 | l2;
          }
          if (bool13)
          {
            f1 = 1.0F;
            l1 = l2;
          }
          else
          {
            f1 = 0.3F;
            l1 = l2;
          }
        }
        else
        {
          bool13 = false;
        }
        i6 = m;
        localObject14 = localObject12;
        if ((l1 & 0x182000) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject4 = localSummaryPlayViewModel.g0();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(13, (LiveData)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((LiveData)localObject4).getValue();
            break label1420;
          }
        }
        localObject4 = null;
        boolean bool5 = (l1 & 0x184000) < 0L;
        if (bool5)
        {
          if (localSummaryPlayViewModel != null) {
            localObject12 = localSummaryPlayViewModel.B0();
          } else {
            localObject12 = null;
          }
          updateLiveDataRegistration(14, (LiveData)localObject12);
          if (localObject12 != null) {
            localObject12 = (Boolean)((LiveData)localObject12).getValue();
          } else {
            localObject12 = null;
          }
          bool14 = ViewDataBinding.safeUnbox((Boolean)localObject12);
          l3 = l1;
          if (bool5)
          {
            if (bool14) {
              l2 = 67108864L;
            } else {
              l2 = 33554432L;
            }
            l3 = l1 | l2;
          }
          if (bool14)
          {
            l1 = l3;
          }
          else
          {
            n = 8;
            break label1545;
          }
        }
        n = 0;
        l3 = l1;
        localObject15 = localObject9;
        localObject9 = localObject4;
        if ((l3 & 0x188000) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject4 = localSummaryPlayViewModel.q0();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(15, (LiveData)localObject4);
          if (localObject4 != null) {
            localObject4 = (Long)((LiveData)localObject4).getValue();
          } else {
            localObject4 = null;
          }
          l2 = ViewDataBinding.safeUnbox((Long)localObject4);
        }
        else
        {
          l2 = 0L;
        }
        if ((l3 & 0x190000) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject4 = localSummaryPlayViewModel.H0();
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(16, (LiveData)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (ArrayList)((LiveData)localObject4).getValue();
            break label1684;
          }
        }
        localObject4 = null;
        Object localObject18;
        float f3;
        boolean bool16;
        if ((l3 & 0x1A1400) != 0L)
        {
          if (localSummaryPlayViewModel != null) {
            localObject16 = localSummaryPlayViewModel.J0();
          } else {
            localObject16 = null;
          }
          updateLiveDataRegistration(17, (LiveData)localObject16);
          if (localObject16 != null) {
            localObject12 = (com.tplink.iot.dailysummary.model.b)((LiveData)localObject16).getValue();
          } else {
            localObject12 = null;
          }
          i7 = (l3 & 0x1A0400) < 0L;
          if (i7 != 0)
          {
            if (localObject12 != null) {
              i8 = ((com.tplink.iot.dailysummary.model.b)localObject12).j();
            } else {
              i8 = 0;
            }
            if (i8 == 2) {
              i9 = 1;
            } else {
              i9 = 0;
            }
            l1 = l3;
            i10 = i8;
            i11 = i9;
            if (i7 != 0) {
              if (i9 != 0)
              {
                l1 = l3 | 0x40000000;
                i10 = i8;
                i11 = i9;
              }
              else
              {
                l1 = l3 | 0x20000000;
                i10 = i8;
                i11 = i9;
              }
            }
          }
          else
          {
            i10 = 0;
            i11 = 0;
            l1 = l3;
          }
          Object localObject17 = localObject16;
          if (((l1 & 0x1A0000) != 0L) && (localObject12 != null))
          {
            i8 = ((com.tplink.iot.dailysummary.model.b)localObject12).h();
            i9 = ((com.tplink.iot.dailysummary.model.b)localObject12).i();
          }
          else
          {
            i8 = 0;
            i9 = 0;
          }
          i7 = (l1 & 0x1A1000) < 0L;
          if (i7 != 0)
          {
            if (localObject12 != null) {
              bool14 = ((com.tplink.iot.dailysummary.model.b)localObject12).b();
            } else {
              bool14 = false;
            }
            l3 = l1;
            if (i7 != 0) {
              if (bool14) {
                l3 = l1 | 0x1000000000000;
              } else {
                l3 = l1 | 0x800000000000;
              }
            }
            l1 = l3;
          }
          else
          {
            bool14 = false;
          }
          localObject18 = localObject7;
          f3 = f2;
          bool15 = bool12;
          localObject16 = localObject9;
          localObject7 = localObject8;
          bool16 = bool10;
          i7 = i11;
          i11 = i2;
          localObject8 = localObject10;
          i2 = i10;
          bool12 = bool13;
          localObject9 = localObject4;
          i10 = n;
          f2 = f1;
          n = i6;
          bool10 = bool8;
          i6 = i11;
          localObject19 = localObject6;
          localObject4 = localObject2;
          i11 = i4;
          f1 = f3;
          localObject6 = localObject5;
          localObject5 = localObject12;
          i4 = i2;
          i2 = i7;
          localObject10 = localObject16;
          bool13 = bool7;
          localObject20 = localObject13;
          localObject2 = localObject7;
          localObject13 = localObject14;
          bool8 = bool16;
          localObject16 = localObject15;
          bool7 = bool15;
          localObject7 = localObject17;
          localObject12 = localObject18;
          l3 = l2;
        }
        else
        {
          localObject12 = localObject7;
          localObject7 = null;
          i10 = i2;
          i2 = i6;
          localObject16 = localObject4;
          i7 = 0;
          bool16 = false;
          i8 = 0;
          i9 = 0;
          f3 = f2;
          f2 = f1;
          localObject18 = localObject7;
          bool14 = bool12;
          localObject20 = localObject9;
          localObject9 = localObject8;
          bool15 = bool10;
          i12 = 0;
          localObject8 = localObject10;
          l1 = l3;
          bool10 = bool8;
          bool12 = bool13;
          i6 = i10;
          i10 = n;
          localObject19 = localObject6;
          localObject4 = localObject2;
          i11 = i4;
          n = i2;
          f1 = f3;
          localObject6 = localObject5;
          localObject5 = localObject18;
          i4 = i7;
          i2 = i12;
          localObject10 = localObject20;
          bool13 = bool7;
          localObject20 = localObject13;
          localObject2 = localObject9;
          localObject13 = localObject14;
          localObject9 = localObject16;
          bool8 = bool15;
          localObject16 = localObject15;
          bool7 = bool14;
          bool14 = bool16;
          l3 = l2;
        }
      }
      else
      {
        localObject15 = null;
        localObject8 = localObject15;
        localObject4 = localObject8;
        localObject6 = localObject4;
        localObject5 = localObject6;
        localObject11 = localObject5;
        localObject10 = localObject11;
        localObject14 = localObject10;
        localObject2 = localObject14;
        localObject13 = localObject2;
        localObject9 = localObject13;
        localObject16 = localObject9;
        localObject7 = localObject16;
        localObject12 = localObject7;
        f2 = 0.0F;
        bool10 = false;
        bool12 = false;
        i6 = 0;
        i10 = 0;
        i11 = 0;
        n = 0;
        f1 = 0.0F;
        i4 = 0;
        i2 = 0;
        bool13 = false;
        bool8 = false;
        bool7 = false;
        bool14 = false;
        l3 = 0L;
        i8 = 0;
        i9 = 0;
        localObject20 = localObject14;
        localObject19 = localObject8;
        localObject8 = localObject15;
      }
      if ((l1 & 0x1000000000000) != 0L)
      {
        if (localSummaryPlayViewModel != null) {
          localObject14 = localSummaryPlayViewModel.p0();
        } else {
          localObject14 = null;
        }
        updateLiveDataRegistration(12, (LiveData)localObject14);
        localObject15 = localObject1;
        if (localObject14 != null) {
          localObject15 = (d)((LiveData)localObject14).getValue();
        }
        if (localObject15 != null) {
          bool15 = ((d)localObject15).b();
        } else {
          bool15 = false;
        }
        i7 = bool15 ^ true;
      }
      else
      {
        i7 = 0;
      }
      if ((l1 & 0x4000000000000) != 0L)
      {
        if (localSummaryPlayViewModel != null) {
          localObject7 = localSummaryPlayViewModel.J0();
        }
        updateLiveDataRegistration(17, (LiveData)localObject7);
        if (localObject7 != null) {
          localObject5 = (com.tplink.iot.dailysummary.model.b)((LiveData)localObject7).getValue();
        }
        if (localObject5 != null) {
          i4 = ((com.tplink.iot.dailysummary.model.b)localObject5).j();
        }
        if (i4 == 2) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        l2 = l1;
        if ((l1 & 0x1A0400) != 0L) {
          if (i4 != 0) {
            l2 = l1 | 0x40000000;
          } else {
            l2 = l1 | 0x20000000;
          }
        }
        l1 = l2;
      }
      else
      {
        i4 = i2;
      }
      boolean bool9 = (l1 & 0x1A1000) < 0L;
      long l2 = l1;
      if (bool9)
      {
        if (!bool14) {
          i7 = 0;
        }
        l2 = l1;
        if (bool9)
        {
          if (i7 != 0) {
            l2 = 4398046511104L;
          } else {
            l2 = 2199023255552L;
          }
          l2 = l1 | l2;
        }
        if (i7 == 0)
        {
          i12 = 8;
          l1 = l2;
          break label2694;
        }
      }
      int i12 = 0;
      l1 = l2;
      label2694:
      int i3;
      if ((l1 & 0x1A0180) != 0L)
      {
        if (bool13) {
          i7 = i4;
        } else {
          i7 = 0;
        }
        l2 = l1;
        if ((l1 & 0x1A0080) != 0L)
        {
          if (i7 != 0) {
            l2 = 1099511627776L;
          } else {
            l2 = 549755813888L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0x1A0180) != 0L)
        {
          if (i7 != 0) {
            l1 = 70368744177664L;
          } else {
            l1 = 35184372088832L;
          }
          l1 = l2 | l1;
        }
        if ((l1 & 0x1A0080) != 0L)
        {
          if (i7 != 0) {
            bool9 = false;
          } else {
            i3 = 8;
          }
          l2 = l1;
        }
        else
        {
          i3 = 0;
          l2 = l1;
        }
      }
      else
      {
        i3 = 0;
        i7 = 0;
        l2 = l1;
      }
      int i13 = n;
      if ((l2 & 0x400000000000) != 0L)
      {
        if (localSummaryPlayViewModel != null) {
          localObject2 = localSummaryPlayViewModel.F0();
        }
        updateLiveDataRegistration(8, (LiveData)localObject2);
        if (localObject2 != null) {
          localObject11 = (Boolean)((LiveData)localObject2).getValue();
        }
        bool8 = ViewDataBinding.safeUnbox((Boolean)localObject11);
      }
      l1 = l2;
      if ((l2 & 0x40000000) != 0L)
      {
        if (localSummaryPlayViewModel != null) {
          localObject13 = localSummaryPlayViewModel.v0();
        }
        updateLiveDataRegistration(10, (LiveData)localObject13);
        if (localObject13 != null) {
          localObject16 = (Boolean)((LiveData)localObject13).getValue();
        }
        bool13 = ViewDataBinding.safeUnbox((Boolean)localObject16);
        l1 = l2;
        bool7 = bool13;
        if ((l2 & 0x180400) != 0L)
        {
          if (bool13) {
            l1 = 268435456L;
          } else {
            l1 = 134217728L;
          }
          l1 = l2 | l1;
          bool7 = bool13;
        }
      }
      boolean bool6 = (l1 & 0x1A0400) < 0L;
      l2 = l1;
      if (bool6)
      {
        if (i4 == 0) {
          bool7 = false;
        }
        l2 = l1;
        if (bool6)
        {
          if (bool7) {
            l2 = 4194304L;
          } else {
            l2 = 2097152L;
          }
          l2 = l1 | l2;
        }
        if (!bool7)
        {
          i1 = 8;
          l1 = l2;
          break label3085;
        }
      }
      int i1 = 0;
      l1 = l2;
      label3085:
      boolean bool11 = (l1 & 0x1A0180) < 0L;
      l2 = l1;
      if (bool11)
      {
        if (i7 != 0) {
          bool7 = bool8;
        } else {
          bool7 = false;
        }
        l2 = l1;
        if (bool11)
        {
          if (bool7) {
            l2 = 17179869184L;
          } else {
            l2 = 8589934592L;
          }
          l2 = l1 | l2;
        }
        if (!bool7)
        {
          i5 = 8;
          break label3167;
        }
      }
      int i5 = 0;
      label3167:
      if ((0x180040 & l2) != 0L) {
        this.c.setVisibility(i6);
      }
      if ((l2 & 0x1A1000) != 0L) {
        this.d.setVisibility(i12);
      }
      if ((0x100000 & l2) != 0L) {
        this.d.setOnClickListener(this.r4);
      }
      if ((0x180800 & l2) != 0L)
      {
        this.y.setClickable(bool12);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.y.setAlpha(f2);
        }
      }
      if ((0x180008 & l2) != 0L)
      {
        this.z.setClickable(bool10);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.z.setAlpha(f1);
        }
      }
      if ((0x184000 & l2) != 0L)
      {
        this.p0.setVisibility(i10);
        this.W3.setVisibility(i10);
      }
      if ((l2 & 0x1A0080) != 0L)
      {
        this.J3.setVisibility(i3);
        this.L3.setVisibility(i3);
        this.M3.setVisibility(i3);
        this.N3.setVisibility(i3);
        this.O3.setVisibility(i3);
        this.S3.setVisibility(i3);
        this.d4.setVisibility(i3);
        this.e4.setVisibility(i3);
        this.f4.setVisibility(i3);
      }
      if ((l2 & 0x180080) != 0L) {
        this.K3.setVisibility(i11);
      }
      if ((0x180002 & l2) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.M3, (Drawable)localObject4);
      }
      if ((0x180004 & l2) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.N3, (Drawable)localObject19);
      }
      if ((l2 & 0x1A0400) != 0L) {
        this.P3.setVisibility(i1);
      }
      if ((l2 & 0x1A0180) != 0L) {
        this.Q3.setVisibility(i5);
      }
      if ((l2 & 0x180400) != 0L)
      {
        this.T3.setVisibility(i13);
        this.j4.setVisibility(i13);
      }
      if ((0x188000 & l2) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.d(this.d4, l3);
      }
      if ((0x180020 & l2) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.e(this.d4, (Long)localObject6);
      }
      if ((0x180200 & l2) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.c(this.d4, (LinkedList)localObject8);
      }
      if ((0x190000 & l2) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.a(this.d4, (ArrayList)localObject9);
      }
      if ((0x180100 & l2) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.b(this.d4, bool8);
      }
      if ((0x140000 & l2) != 0L) {
        com.tplink.iot.dailysummary.view.adapter.c.f(this.d4, localb);
      }
      if ((0x1A0000 & l2) != 0L)
      {
        this.q4.setVisibility(i8);
        com.tplink.iot.dailysummary.view.adapter.b.c(this.g4, i9);
      }
      if ((l2 & 0x180001) != 0L) {
        TextViewBindingAdapter.setText(this.f4, (CharSequence)localObject20);
      }
      if ((0x180010 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.h4, (CharSequence)localObject12);
      }
      if ((l2 & 0x182000) != 0L) {
        TextViewBindingAdapter.setText(this.i4, (CharSequence)localObject10);
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
      return r((MutableLiveData)paramObject, paramInt2);
    case 14: 
      return x((MutableLiveData)paramObject, paramInt2);
    case 13: 
      return n((MutableLiveData)paramObject, paramInt2);
    case 12: 
      return q((MutableLiveData)paramObject, paramInt2);
    case 11: 
      return l((MutableLiveData)paramObject, paramInt2);
    case 10: 
      return v((MutableLiveData)paramObject, paramInt2);
    case 9: 
      return C((MutableLiveData)paramObject, paramInt2);
    case 8: 
      return y((MutableLiveData)paramObject, paramInt2);
    case 7: 
      return w((MutableLiveData)paramObject, paramInt2);
    case 6: 
      return s((MutableLiveData)paramObject, paramInt2);
    case 5: 
      return A((MutableLiveData)paramObject, paramInt2);
    case 4: 
      return o((MutableLiveData)paramObject, paramInt2);
    case 3: 
      return m((MutableLiveData)paramObject, paramInt2);
    case 2: 
      return u((MutableLiveData)paramObject, paramInt2);
    case 1: 
      return t((MutableLiveData)paramObject, paramInt2);
    }
    return p((LiveData)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySummaryPlayBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */