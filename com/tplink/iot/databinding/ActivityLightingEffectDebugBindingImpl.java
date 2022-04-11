package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.AbsSpinnerBindingAdapter;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.ChipGroup;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devices.lightstrip.view.effects.LightingEffectDebugViewModel;
import com.tplink.iot.devices.lightstrip.view.effects.b;

public class ActivityLightingEffectDebugBindingImpl
  extends ActivityLightingEffectDebugBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts U3;
  @Nullable
  private static final SparseIntArray V3;
  @NonNull
  private final LinearLayout A4;
  @NonNull
  private final Button B4;
  @NonNull
  private final TextView C4;
  @NonNull
  private final Button D4;
  @NonNull
  private final TextView E4;
  @NonNull
  private final LinearLayout F4;
  @NonNull
  private final Button G4;
  @NonNull
  private final Button H4;
  @NonNull
  private final TextView I4;
  @NonNull
  private final TextView J4;
  @NonNull
  private final TextView K4;
  @NonNull
  private final TextView L4;
  private OnStopTrackingTouchImpl M4;
  private InverseBindingListener N4 = new c();
  private InverseBindingListener O4 = new d();
  private InverseBindingListener P4 = new e();
  private InverseBindingListener Q4 = new f();
  private InverseBindingListener R4 = new g();
  private InverseBindingListener S4 = new h();
  private InverseBindingListener T4 = new i();
  private InverseBindingListener U4 = new j();
  private InverseBindingListener V4 = new k();
  @NonNull
  private final LinearLayout W3;
  private InverseBindingListener W4 = new a();
  @NonNull
  private final TextView X3;
  private InverseBindingListener X4 = new b();
  @NonNull
  private final TextView Y3;
  private long Y4 = -1L;
  @NonNull
  private final TextView Z3;
  @NonNull
  private final TextView a4;
  @NonNull
  private final TextView b4;
  @NonNull
  private final TextView c4;
  @NonNull
  private final TextView d4;
  @NonNull
  private final TextView e4;
  @NonNull
  private final TextView f4;
  @NonNull
  private final TextView g4;
  @NonNull
  private final TextView h4;
  @NonNull
  private final LinearLayout i4;
  @NonNull
  private final Button j4;
  @NonNull
  private final Button k4;
  @NonNull
  private final LinearLayout l4;
  @NonNull
  private final LinearLayout m4;
  @NonNull
  private final TextView n4;
  @NonNull
  private final TextView o4;
  @NonNull
  private final TextView p4;
  @NonNull
  private final TextView q4;
  @NonNull
  private final TextView r4;
  @NonNull
  private final TextView s4;
  @NonNull
  private final TextView t4;
  @NonNull
  private final SeekBar u4;
  @NonNull
  private final TextView v4;
  @NonNull
  private final LinearLayout w4;
  @NonNull
  private final Button x4;
  @NonNull
  private final Button y4;
  @NonNull
  private final TextView z4;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    V3 = localSparseIntArray;
    localSparseIntArray.put(2131363945, 61);
    localSparseIntArray.put(2131364460, 62);
    localSparseIntArray.put(2131362240, 63);
  }
  
  public ActivityLightingEffectDebugBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 64, U3, V3));
  }
  
  private ActivityLightingEffectDebugBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 34, (Button)paramArrayOfObject[56], (Button)paramArrayOfObject[46], (Button)paramArrayOfObject[38], (Button)paramArrayOfObject[60], (Button)paramArrayOfObject[20], (Button)paramArrayOfObject[51], (ChipGroup)paramArrayOfObject[63], (RecyclerView)paramArrayOfObject[37], (RecyclerView)paramArrayOfObject[59], (RecyclerView)paramArrayOfObject[61], (RecyclerView)paramArrayOfObject[19], (SeekBar)paramArrayOfObject[16], (SeekBar)paramArrayOfObject[34], (SeekBar)paramArrayOfObject[6], (SeekBar)paramArrayOfObject[23], (SeekBar)paramArrayOfObject[13], (SeekBar)paramArrayOfObject[31], (SeekBar)paramArrayOfObject[29], (AppCompatSpinner)paramArrayOfObject[8], (AppCompatSpinner)paramArrayOfObject[3], (AppCompatSpinner)paramArrayOfObject[10], (TextView)paramArrayOfObject[62]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.W3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[1];
    this.X3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[11];
    this.Y3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[12];
    this.Z3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[14];
    this.a4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[15];
    this.b4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[17];
    this.c4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[18];
    this.d4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[2];
    this.e4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[21];
    this.f4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[22];
    this.g4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[24];
    this.h4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[25];
    this.i4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (Button)paramArrayOfObject[26];
    this.j4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (Button)paramArrayOfObject[27];
    this.k4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[28];
    this.l4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[30];
    this.m4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[32];
    this.n4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[33];
    this.o4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[35];
    this.p4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[36];
    this.q4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[39];
    this.r4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[4];
    this.s4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[40];
    this.t4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (SeekBar)paramArrayOfObject[41];
    this.u4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[42];
    this.v4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[43];
    this.w4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (Button)paramArrayOfObject[44];
    this.x4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (Button)paramArrayOfObject[45];
    this.y4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[47];
    this.z4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[48];
    this.A4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (Button)paramArrayOfObject[49];
    this.B4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[5];
    this.C4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (Button)paramArrayOfObject[50];
    this.D4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[52];
    this.E4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[53];
    this.F4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (Button)paramArrayOfObject[54];
    this.G4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (Button)paramArrayOfObject[55];
    this.H4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[57];
    this.I4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[58];
    this.J4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[7];
    this.K4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[9];
    this.L4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    this.I3.setTag(null);
    this.J3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.M3.setTag(null);
    this.N3.setTag(null);
    this.O3.setTag(null);
    this.P3.setTag(null);
    this.Q3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean A(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean B(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x1000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean C(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean D(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x4000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean E(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x8000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean F(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x100000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean G(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean H(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x200000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean I(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x80000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean J(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean K(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x800;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean L(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x10000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean M(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x200000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean N(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x400;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean O(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x20000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean P(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x80000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean Q(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x100000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean R(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x2000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean S(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x8000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean T(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x4000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x200;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x40000;
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
        this.Y4 |= 0x800000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x20000;
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
        this.Y4 |= 0x40000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean u(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean v(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x1000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean w(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x400000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean x(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x2000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean y(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 0x10000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean z(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Y4 |= 1L;
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
      long l = this.Y4;
      this.Y4 = 0L;
      View.OnClickListener localOnClickListener = this.S3;
      Object localObject1 = this.T3;
      Object localObject2;
      int i;
      Object localObject4;
      int j;
      String str;
      Object localObject5;
      Object localObject6;
      boolean bool1;
      label379:
      Object localObject7;
      boolean bool2;
      label500:
      boolean bool3;
      label555:
      boolean bool4;
      label610:
      boolean bool5;
      label672:
      Object localObject8;
      label727:
      boolean bool6;
      Object localObject9;
      int k;
      boolean bool7;
      int m;
      Object localObject10;
      label933:
      Object localObject11;
      int n;
      Object localObject12;
      int i1;
      label1169:
      Object localObject13;
      label1228:
      boolean bool8;
      boolean bool9;
      label1392:
      Object localObject14;
      label1451:
      int i2;
      boolean bool10;
      label1585:
      Object localObject15;
      int i3;
      label1648:
      boolean bool11;
      label1707:
      boolean bool12;
      boolean bool13;
      label1838:
      Object localObject16;
      label1897:
      int i5;
      label1956:
      boolean bool14;
      label2015:
      boolean bool15;
      label2074:
      label2133:
      int i6;
      boolean bool18;
      Object localObject17;
      int i7;
      if ((0x1BFFFFFFFF & l) != 0L)
      {
        if ((l & 0x1800000001) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((LightingEffectDebugViewModel)localObject1).y();
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null) {
            i = ((ObservableInt)localObject2).get();
          } else {
            i = 0;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" ms");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          i = 0;
          localObject2 = null;
        }
        if ((l & 0x1800000002) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((LightingEffectDebugViewModel)localObject1).B();
          } else {
            localObject4 = null;
          }
          updateRegistration(1, (Observable)localObject4);
          if (localObject4 != null) {
            j = ((ObservableInt)localObject4).get();
          } else {
            j = 0;
          }
          str = String.valueOf(j);
        }
        else
        {
          str = null;
        }
        if ((l & 0x1800000004) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((LightingEffectDebugViewModel)localObject1).L();
          } else {
            localObject4 = null;
          }
          updateRegistration(2, (Observable)localObject4);
          if (localObject4 != null) {
            j = ((ObservableInt)localObject4).get();
          } else {
            j = 0;
          }
          localObject4 = String.valueOf(j);
        }
        else
        {
          localObject4 = null;
        }
        if (((l & 0x1800000000) != 0L) && (localObject1 != null))
        {
          localObject5 = this.M4;
          localObject6 = localObject5;
          if (localObject5 == null)
          {
            localObject6 = new OnStopTrackingTouchImpl();
            this.M4 = ((OnStopTrackingTouchImpl)localObject6);
          }
          localObject6 = ((OnStopTrackingTouchImpl)localObject6).a((LightingEffectDebugViewModel)localObject1);
        }
        else
        {
          localObject6 = null;
        }
        if ((l & 0x1800000008) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((LightingEffectDebugViewModel)localObject1).V();
          } else {
            localObject5 = null;
          }
          updateRegistration(3, (Observable)localObject5);
          if (localObject5 != null)
          {
            bool1 = ((ObservableBoolean)localObject5).get();
            break label379;
          }
        }
        bool1 = false;
        if ((l & 0x1800000010) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((LightingEffectDebugViewModel)localObject1).m();
          } else {
            localObject5 = null;
          }
          updateRegistration(4, (Observable)localObject5);
          if (localObject5 != null) {
            j = ((ObservableInt)localObject5).get();
          } else {
            j = 0;
          }
          localObject5 = String.valueOf(j);
        }
        else
        {
          localObject5 = null;
        }
        if ((l & 0x1800000020) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((LightingEffectDebugViewModel)localObject1).k();
          } else {
            localObject7 = null;
          }
          updateRegistration(5, (Observable)localObject7);
          if (localObject7 != null)
          {
            bool2 = ((ObservableBoolean)localObject7).get();
            break label500;
          }
        }
        bool2 = false;
        if ((l & 0x1800000040) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((LightingEffectDebugViewModel)localObject1).z();
          } else {
            localObject7 = null;
          }
          updateRegistration(6, (Observable)localObject7);
          if (localObject7 != null)
          {
            bool3 = ((ObservableBoolean)localObject7).get();
            break label555;
          }
        }
        bool3 = false;
        if ((l & 0x1800000080) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((LightingEffectDebugViewModel)localObject1).I();
          } else {
            localObject7 = null;
          }
          updateRegistration(7, (Observable)localObject7);
          if (localObject7 != null)
          {
            bool4 = ((ObservableBoolean)localObject7).get();
            break label610;
          }
        }
        bool4 = false;
        bool5 = bool2;
        if ((l & 0x1800000100) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((LightingEffectDebugViewModel)localObject1).t();
          } else {
            localObject7 = null;
          }
          updateRegistration(8, (Observable)localObject7);
          if (localObject7 != null)
          {
            localObject7 = (String)((ObservableField)localObject7).get();
            break label672;
          }
        }
        localObject7 = null;
        if ((l & 0x1800000200) != 0L)
        {
          if (localObject1 != null) {
            localObject8 = ((LightingEffectDebugViewModel)localObject1).n();
          } else {
            localObject8 = null;
          }
          updateRegistration(9, (Observable)localObject8);
          if (localObject8 != null)
          {
            bool2 = ((ObservableBoolean)localObject8).get();
            break label727;
          }
        }
        bool2 = false;
        if ((l & 0x1800000400) != 0L)
        {
          if (localObject1 != null) {
            localObject8 = ((LightingEffectDebugViewModel)localObject1).P();
          } else {
            localObject8 = null;
          }
          updateRegistration(10, (Observable)localObject8);
          if (localObject8 != null) {
            j = ((ObservableInt)localObject8).get();
          } else {
            j = 0;
          }
          localObject8 = String.valueOf(j);
        }
        else
        {
          j = 0;
          localObject8 = null;
        }
        bool6 = bool2;
        if ((l & 0x1800000800) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).M();
          } else {
            localObject9 = null;
          }
          updateRegistration(11, (Observable)localObject9);
          if (localObject9 != null) {
            k = ((ObservableInt)localObject9).get();
          } else {
            k = 0;
          }
          localObject9 = String.valueOf(k);
        }
        else
        {
          localObject9 = null;
        }
        bool7 = bool3;
        m = j;
        if ((l & 0x1800001000) != 0L)
        {
          if (localObject1 != null) {
            localObject10 = ((LightingEffectDebugViewModel)localObject1).u();
          } else {
            localObject10 = null;
          }
          updateRegistration(12, (Observable)localObject10);
          if (localObject10 != null)
          {
            j = ((ObservableInt)localObject10).get();
            break label933;
          }
        }
        j = 0;
        localObject11 = localObject9;
        if ((l & 0x1800002000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).T();
          } else {
            localObject9 = null;
          }
          updateRegistration(13, (Observable)localObject9);
          if (localObject9 != null) {
            k = ((ObservableInt)localObject9).get();
          } else {
            k = 0;
          }
          localObject9 = new StringBuilder();
          ((StringBuilder)localObject9).append(k);
          ((StringBuilder)localObject9).append(" ms");
          localObject9 = ((StringBuilder)localObject9).toString();
        }
        else
        {
          k = 0;
          localObject9 = null;
        }
        n = j;
        if ((l & 0x1800004000) != 0L)
        {
          if (localObject1 != null) {
            localObject10 = ((LightingEffectDebugViewModel)localObject1).l();
          } else {
            localObject10 = null;
          }
          updateRegistration(14, (Observable)localObject10);
          if (localObject10 != null) {
            j = ((ObservableInt)localObject10).get();
          } else {
            j = 0;
          }
          localObject10 = String.valueOf(j);
        }
        else
        {
          localObject10 = null;
        }
        localObject12 = localObject9;
        i1 = k;
        if ((l & 0x1800008000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).U();
          } else {
            localObject9 = null;
          }
          updateRegistration(15, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool3 = ((ObservableBoolean)localObject9).get();
            break label1169;
          }
        }
        bool3 = false;
        localObject13 = localObject10;
        if ((l & 0x1800010000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).x();
          } else {
            localObject9 = null;
          }
          updateRegistration(16, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool2 = ((ObservableBoolean)localObject9).get();
            break label1228;
          }
        }
        bool2 = false;
        bool8 = bool3;
        if ((l & 0x1800020000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).r();
          } else {
            localObject9 = null;
          }
          updateRegistration(17, (Observable)localObject9);
          if (localObject9 != null) {
            j = ((ObservableInt)localObject9).get();
          } else {
            j = 0;
          }
          localObject9 = new StringBuilder();
          ((StringBuilder)localObject9).append(j);
          ((StringBuilder)localObject9).append(" ms");
          localObject9 = ((StringBuilder)localObject9).toString();
          k = j;
        }
        else
        {
          k = 0;
          localObject9 = null;
        }
        bool9 = bool2;
        if ((l & 0x1800040000) != 0L)
        {
          if (localObject1 != null) {
            localObject10 = ((LightingEffectDebugViewModel)localObject1).o();
          } else {
            localObject10 = null;
          }
          updateRegistration(18, (Observable)localObject10);
          if (localObject10 != null)
          {
            j = ((ObservableInt)localObject10).get();
            break label1392;
          }
        }
        j = 0;
        localObject14 = localObject9;
        if ((l & 0x1800080000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).K();
          } else {
            localObject9 = null;
          }
          updateRegistration(19, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool3 = ((ObservableBoolean)localObject9).get();
            break label1451;
          }
        }
        bool3 = false;
        i2 = j;
        if ((l & 0x1800100000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).H();
          } else {
            localObject9 = null;
          }
          updateRegistration(20, (Observable)localObject9);
          if (localObject9 != null) {
            j = ((ObservableInt)localObject9).get();
          } else {
            j = 0;
          }
          localObject9 = String.valueOf(j);
        }
        else
        {
          j = 0;
          localObject9 = null;
        }
        bool10 = bool3;
        if ((l & 0x1800200000) != 0L)
        {
          if (localObject1 != null) {
            localObject10 = ((LightingEffectDebugViewModel)localObject1).O();
          } else {
            localObject10 = null;
          }
          updateRegistration(21, (Observable)localObject10);
          if (localObject10 != null)
          {
            bool2 = ((ObservableBoolean)localObject10).get();
            break label1585;
          }
        }
        bool2 = false;
        localObject15 = localObject9;
        i3 = j;
        if ((l & 0x1800400000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).v();
          } else {
            localObject9 = null;
          }
          updateRegistration(22, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool3 = ((ObservableBoolean)localObject9).get();
            break label1648;
          }
        }
        bool3 = false;
        bool11 = bool2;
        if ((l & 0x1800800000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).p();
          } else {
            localObject9 = null;
          }
          updateRegistration(23, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool2 = ((ObservableBoolean)localObject9).get();
            break label1707;
          }
        }
        bool2 = false;
        bool12 = bool3;
        if ((l & 0x1801000000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).A();
          } else {
            localObject9 = null;
          }
          updateRegistration(24, (Observable)localObject9);
          if (localObject9 != null) {
            j = ((ObservableInt)localObject9).get();
          } else {
            j = 0;
          }
          localObject9 = String.valueOf(j);
        }
        else
        {
          localObject9 = null;
        }
        bool13 = bool2;
        if ((l & 0x1802000000) != 0L)
        {
          if (localObject1 != null) {
            localObject10 = ((LightingEffectDebugViewModel)localObject1).w();
          } else {
            localObject10 = null;
          }
          updateRegistration(25, (Observable)localObject10);
          if (localObject10 != null)
          {
            j = ((ObservableInt)localObject10).get();
            break label1838;
          }
        }
        j = 0;
        localObject16 = localObject9;
        if ((l & 0x1804000000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).C();
          } else {
            localObject9 = null;
          }
          updateRegistration(26, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool2 = ((ObservableBoolean)localObject9).get();
            break label1897;
          }
        }
        bool2 = false;
        i5 = j;
        if ((l & 0x1808000000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).D();
          } else {
            localObject9 = null;
          }
          updateRegistration(27, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool3 = ((ObservableBoolean)localObject9).get();
            break label1956;
          }
        }
        bool3 = false;
        bool14 = bool2;
        if ((l & 0x1810000000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).N();
          } else {
            localObject9 = null;
          }
          updateRegistration(28, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool2 = ((ObservableBoolean)localObject9).get();
            break label2015;
          }
        }
        bool2 = false;
        bool15 = bool3;
        if ((l & 0x1820000000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).Q();
          } else {
            localObject9 = null;
          }
          updateRegistration(29, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool3 = ((ObservableBoolean)localObject9).get();
            break label2074;
          }
        }
        bool3 = false;
        boolean bool16 = bool2;
        if ((l & 0x1840000000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).s();
          } else {
            localObject9 = null;
          }
          updateRegistration(30, (Observable)localObject9);
          if (localObject9 != null)
          {
            bool2 = ((ObservableBoolean)localObject9).get();
            break label2133;
          }
        }
        bool2 = false;
        boolean bool17 = bool3;
        if ((l & 0x1880000000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).R();
          } else {
            localObject9 = null;
          }
          updateRegistration(31, (Observable)localObject9);
          if (localObject9 != null) {
            j = ((ObservableInt)localObject9).get();
          } else {
            j = 0;
          }
          localObject9 = new StringBuilder();
          ((StringBuilder)localObject9).append(j);
          ((StringBuilder)localObject9).append(" ms");
          localObject9 = ((StringBuilder)localObject9).toString();
          i6 = j;
        }
        else
        {
          i6 = 0;
          localObject9 = null;
        }
        bool18 = bool2;
        if ((l & 0x1900000000) != 0L)
        {
          if (localObject1 != null) {
            localObject10 = ((LightingEffectDebugViewModel)localObject1).S();
          } else {
            localObject10 = null;
          }
          updateRegistration(32, (Observable)localObject10);
          if (localObject10 != null) {
            j = ((ObservableInt)localObject10).get();
          } else {
            j = 0;
          }
          localObject10 = new StringBuilder();
          ((StringBuilder)localObject10).append(j);
          ((StringBuilder)localObject10).append(" ms");
          localObject10 = ((StringBuilder)localObject10).toString();
        }
        else
        {
          j = 0;
          localObject10 = null;
        }
        localObject17 = localObject9;
        i7 = i6;
        if ((l & 0x1A00000000) != 0L)
        {
          if (localObject1 != null) {
            localObject9 = ((LightingEffectDebugViewModel)localObject1).J();
          } else {
            localObject9 = null;
          }
          updateRegistration(33, (Observable)localObject9);
          if (localObject9 != null) {
            i6 = ((ObservableInt)localObject9).get();
          } else {
            i6 = 0;
          }
          i8 = i6;
          localObject9 = String.valueOf(i6);
          i6 = j;
          j = i8;
        }
        else
        {
          i6 = j;
          localObject9 = null;
          j = 0;
        }
        bool3 = bool9;
        bool2 = bool13;
        bool9 = bool16;
        bool13 = bool14;
        int i8 = i1;
        int i9 = m;
        bool16 = bool8;
        localObject1 = localObject5;
        Object localObject18 = localObject13;
        Object localObject19 = localObject6;
        m = i7;
        bool8 = bool12;
        localObject6 = localObject14;
        localObject13 = localObject17;
        localObject5 = localObject7;
        i1 = k;
        bool12 = bool1;
        bool14 = bool15;
        bool15 = bool18;
        bool1 = bool5;
        bool18 = bool11;
        localObject17 = localObject19;
        localObject7 = localObject18;
        localObject14 = localObject1;
        bool5 = bool16;
        k = i9;
        bool11 = bool17;
        i7 = i8;
      }
      else
      {
        localObject13 = null;
        localObject6 = null;
        bool8 = false;
        m = 0;
        localObject5 = null;
        i1 = 0;
        bool12 = false;
        bool14 = false;
        bool15 = false;
        bool1 = false;
        bool18 = false;
        localObject17 = null;
        localObject7 = null;
        localObject14 = null;
        localObject4 = null;
        localObject9 = null;
        localObject11 = null;
        localObject16 = null;
        localObject2 = null;
        bool5 = false;
        k = 0;
        bool11 = false;
        i7 = 0;
        i6 = 0;
        bool7 = false;
        i = 0;
        bool4 = false;
        bool10 = false;
        i3 = 0;
        bool13 = false;
        str = null;
        bool9 = false;
        j = 0;
        bool6 = false;
        bool2 = false;
        bool3 = false;
        i2 = 0;
        n = 0;
        i5 = 0;
        localObject8 = null;
        localObject12 = null;
        localObject10 = null;
        localObject15 = null;
      }
      if ((0x1400000000 & l) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
      }
      if ((l & 0x1800000020) != 0L)
      {
        a.h(this.f, bool1);
        a.h(this.p4, bool1);
        a.h(this.q4, bool1);
        a.h(this.p0, bool1);
      }
      if ((l & 0x1808000000) != 0L)
      {
        a.h(this.q, bool14);
        a.h(this.I4, bool14);
        a.h(this.J4, bool14);
        a.h(this.p1, bool14);
      }
      if ((l & 0x1800200000) != 0L)
      {
        a.h(this.x, bool18);
        a.h(this.c4, bool18);
        a.h(this.d4, bool18);
        a.h(this.p3, bool18);
      }
      if ((l & 0x1800000100) != 0L) {
        TextViewBindingAdapter.setText(this.X3, (CharSequence)localObject5);
      }
      if ((l & 0x1800000008) != 0L)
      {
        a.h(this.Y3, bool12);
        a.h(this.Z3, bool12);
        a.h(this.L3, bool12);
      }
      if ((l & 0x1880000000) != 0L)
      {
        TextViewBindingAdapter.setText(this.Z3, (CharSequence)localObject13);
        SeekBarBindingAdapter.setProgress(this.L3, m);
      }
      if ((l & 0x1840000000) != 0L)
      {
        a.h(this.a4, bool15);
        a.h(this.b4, bool15);
        a.h(this.H3, bool15);
      }
      if ((l & 0x1800020000) != 0L)
      {
        TextViewBindingAdapter.setText(this.b4, (CharSequence)localObject6);
        SeekBarBindingAdapter.setProgress(this.H3, i1);
      }
      if ((l & 0x1800400000) != 0L)
      {
        a.h(this.e4, bool8);
        a.h(this.P3, bool8);
      }
      if ((0x1820000000 & l) != 0L)
      {
        a.h(this.f4, bool11);
        a.h(this.g4, bool11);
        a.h(this.K3, bool11);
      }
      if ((0x1800000400 & l) != 0L)
      {
        TextViewBindingAdapter.setText(this.g4, (CharSequence)localObject8);
        SeekBarBindingAdapter.setProgress(this.K3, k);
      }
      if ((0x1800008000 & l) != 0L)
      {
        a.h(this.h4, bool5);
        a.h(this.i4, bool5);
        a.h(this.l4, bool5);
        a.h(this.m4, bool5);
      }
      if ((0x1800002000 & l) != 0L)
      {
        TextViewBindingAdapter.setText(this.j4, (CharSequence)localObject12);
        SeekBarBindingAdapter.setProgress(this.N3, i7);
      }
      if ((0x1900000000 & l) != 0L)
      {
        TextViewBindingAdapter.setText(this.k4, (CharSequence)localObject10);
        SeekBarBindingAdapter.setProgress(this.M3, i6);
      }
      if ((l & 0x1800000040) != 0L)
      {
        a.h(this.n4, bool7);
        a.h(this.o4, bool7);
        a.h(this.I3, bool7);
      }
      if ((l & 0x1800000001) != 0L)
      {
        TextViewBindingAdapter.setText(this.o4, (CharSequence)localObject2);
        SeekBarBindingAdapter.setProgress(this.I3, i);
      }
      if ((l & 0x1800000080) != 0L)
      {
        a.h(this.r4, bool4);
        a.h(this.t4, bool4);
        a.h(this.u4, bool4);
      }
      if ((0x1800080000 & l) != 0L)
      {
        a.h(this.s4, bool10);
        a.h(this.C4, bool10);
        a.h(this.J3, bool10);
      }
      if ((0x1800100000 & l) != 0L)
      {
        TextViewBindingAdapter.setText(this.t4, (CharSequence)localObject15);
        SeekBarBindingAdapter.setProgress(this.u4, i3);
      }
      if ((0x1000000000 & l) != 0L)
      {
        this.u4.setMax(100);
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.u4, null, null, null, this.N4);
        this.H3.setMax(1000);
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.H3, null, null, null, this.O4);
        this.I3.setMax(1000);
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.I3, null, null, null, this.P4);
        this.J3.setMax(100);
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.J3, null, null, null, this.Q4);
        this.K3.setMax(10);
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.K3, null, null, null, this.R4);
        this.L3.setMax(60000);
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.L3, null, null, null, this.S4);
        this.M3.setMax(3000);
        this.N3.setMax(3000);
        AbsSpinnerBindingAdapter.setEntries(this.O3, b.b);
        AdapterViewBindingAdapter.setOnItemSelectedListener(this.O3, null, null, this.V4);
        AbsSpinnerBindingAdapter.setEntries(this.P3, b.a);
        AdapterViewBindingAdapter.setOnItemSelectedListener(this.P3, null, null, this.W4);
        AbsSpinnerBindingAdapter.setEntries(this.Q3, b.c);
        AdapterViewBindingAdapter.setOnItemSelectedListener(this.Q3, null, null, this.X4);
      }
      if ((0x1804000000 & l) != 0L)
      {
        a.h(this.v4, bool13);
        a.h(this.w4, bool13);
      }
      if ((l & 0x1800000002) != 0L) {
        TextViewBindingAdapter.setText(this.x4, str);
      }
      if ((0x1801000000 & l) != 0L) {
        TextViewBindingAdapter.setText(this.y4, (CharSequence)localObject16);
      }
      if ((0x1810000000 & l) != 0L)
      {
        a.h(this.z4, bool9);
        a.h(this.A4, bool9);
      }
      if ((0x1800000800 & l) != 0L) {
        TextViewBindingAdapter.setText(this.B4, (CharSequence)localObject11);
      }
      if ((0x1A00000000 & l) != 0L)
      {
        TextViewBindingAdapter.setText(this.C4, (CharSequence)localObject9);
        SeekBarBindingAdapter.setProgress(this.J3, j);
      }
      if ((l & 0x1800000004) != 0L) {
        TextViewBindingAdapter.setText(this.D4, (CharSequence)localObject4);
      }
      if ((0x1800000200 & l) != 0L)
      {
        a.h(this.E4, bool6);
        a.h(this.F4, bool6);
      }
      if ((l & 0x1800000010) != 0L) {
        TextViewBindingAdapter.setText(this.G4, (CharSequence)localObject14);
      }
      if ((0x1800004000 & l) != 0L) {
        TextViewBindingAdapter.setText(this.H4, (CharSequence)localObject7);
      }
      if ((0x1800800000 & l) != 0L)
      {
        a.h(this.K4, bool2);
        a.h(this.O3, bool2);
      }
      if ((0x1800010000 & l) != 0L)
      {
        a.h(this.L4, bool3);
        a.h(this.Q3, bool3);
      }
      if ((l & 0x1800000000) != 0L)
      {
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.M3, null, (SeekBarBindingAdapter.OnStopTrackingTouch)localObject17, null, this.T4);
        SeekBarBindingAdapter.setOnSeekBarChangeListener(this.N3, null, (SeekBarBindingAdapter.OnStopTrackingTouch)localObject17, null, this.U4);
      }
      if ((0x1800040000 & l) != 0L) {
        AdapterViewBindingAdapter.setSelectedItemPosition(this.O3, i2);
      }
      if ((0x1800001000 & l) != 0L) {
        AdapterViewBindingAdapter.setSelectedItemPosition(this.P3, n);
      }
      if ((l & 0x1802000000) != 0L) {
        AdapterViewBindingAdapter.setSelectedItemPosition(this.Q3, i5);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.S3 = paramOnClickListener;
    try
    {
      this.Y4 |= 0x400000000;
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
      return this.Y4 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable LightingEffectDebugViewModel paramLightingEffectDebugViewModel)
  {
    this.T3 = paramLightingEffectDebugViewModel;
    try
    {
      this.Y4 |= 0x800000000;
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
      this.Y4 = 68719476736L;
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
    case 33: 
      return H((ObservableInt)paramObject, paramInt2);
    case 32: 
      return Q((ObservableInt)paramObject, paramInt2);
    case 31: 
      return P((ObservableInt)paramObject, paramInt2);
    case 30: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 29: 
      return O((ObservableBoolean)paramObject, paramInt2);
    case 28: 
      return L((ObservableBoolean)paramObject, paramInt2);
    case 27: 
      return E((ObservableBoolean)paramObject, paramInt2);
    case 26: 
      return D((ObservableBoolean)paramObject, paramInt2);
    case 25: 
      return x((ObservableInt)paramObject, paramInt2);
    case 24: 
      return B((ObservableInt)paramObject, paramInt2);
    case 23: 
      return r((ObservableBoolean)paramObject, paramInt2);
    case 22: 
      return w((ObservableBoolean)paramObject, paramInt2);
    case 21: 
      return M((ObservableBoolean)paramObject, paramInt2);
    case 20: 
      return F((ObservableInt)paramObject, paramInt2);
    case 19: 
      return I((ObservableBoolean)paramObject, paramInt2);
    case 18: 
      return q((ObservableInt)paramObject, paramInt2);
    case 17: 
      return s((ObservableInt)paramObject, paramInt2);
    case 16: 
      return y((ObservableBoolean)paramObject, paramInt2);
    case 15: 
      return S((ObservableBoolean)paramObject, paramInt2);
    case 14: 
      return n((ObservableInt)paramObject, paramInt2);
    case 13: 
      return R((ObservableInt)paramObject, paramInt2);
    case 12: 
      return v((ObservableInt)paramObject, paramInt2);
    case 11: 
      return K((ObservableInt)paramObject, paramInt2);
    case 10: 
      return N((ObservableInt)paramObject, paramInt2);
    case 9: 
      return p((ObservableBoolean)paramObject, paramInt2);
    case 8: 
      return u((ObservableField)paramObject, paramInt2);
    case 7: 
      return G((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return A((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return m((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return o((ObservableInt)paramObject, paramInt2);
    case 3: 
      return T((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return J((ObservableInt)paramObject, paramInt2);
    case 1: 
      return C((ObservableInt)paramObject, paramInt2);
    }
    return z((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (69 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      i((LightingEffectDebugViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
  
  public static class OnStopTrackingTouchImpl
    implements SeekBarBindingAdapter.OnStopTrackingTouch
  {
    private LightingEffectDebugViewModel c;
    
    public OnStopTrackingTouchImpl a(LightingEffectDebugViewModel paramLightingEffectDebugViewModel)
    {
      this.c = paramLightingEffectDebugViewModel;
      if (paramLightingEffectDebugViewModel == null) {
        paramLightingEffectDebugViewModel = null;
      } else {
        paramLightingEffectDebugViewModel = this;
      }
      return paramLightingEffectDebugViewModel;
    }
    
    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      this.c.W(paramSeekBar);
    }
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.P3.getSelectedItemPosition();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).u();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class b
    implements InverseBindingListener
  {
    b() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.Q3.getSelectedItemPosition();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).w();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class c
    implements InverseBindingListener
  {
    c() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.l(ActivityLightingEffectDebugBindingImpl.this).getProgress();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).H();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class d
    implements InverseBindingListener
  {
    d() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.H3.getProgress();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).r();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class e
    implements InverseBindingListener
  {
    e() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.I3.getProgress();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).y();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class f
    implements InverseBindingListener
  {
    f() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.J3.getProgress();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).J();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class g
    implements InverseBindingListener
  {
    g() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.K3.getProgress();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).P();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class h
    implements InverseBindingListener
  {
    h() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.L3.getProgress();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).R();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class i
    implements InverseBindingListener
  {
    i() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.M3.getProgress();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).S();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class j
    implements InverseBindingListener
  {
    j() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.N3.getProgress();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).T();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
  
  class k
    implements InverseBindingListener
  {
    k() {}
    
    public void onChange()
    {
      int i = ActivityLightingEffectDebugBindingImpl.this.O3.getSelectedItemPosition();
      Object localObject = ActivityLightingEffectDebugBindingImpl.this.T3;
      int j = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject = ((LightingEffectDebugViewModel)localObject).o();
        if (localObject != null) {
          k = j;
        } else {
          k = 0;
        }
        if (k != 0) {
          ((ObservableInt)localObject).set(i);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightingEffectDebugBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */