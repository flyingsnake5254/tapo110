package com.tplink.iot.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceSettingNewViewModel;

public class ActivityDeviceSettingNewIpcBindingImpl
  extends ActivityDeviceSettingNewIpcBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts A4;
  @Nullable
  private static final SparseIntArray B4;
  @NonNull
  private final FrameLayout C4;
  @NonNull
  private final LinearLayout D4;
  @NonNull
  private final LinearLayout E4;
  @NonNull
  private final FrameLayout F4;
  @NonNull
  private final View G4;
  @NonNull
  private final FrameLayout H4;
  @NonNull
  private final View I4;
  @NonNull
  private final FrameLayout J4;
  @NonNull
  private final View K4;
  @NonNull
  private final View L4;
  @NonNull
  private final View M4;
  @NonNull
  private final ImageView N4;
  private InverseBindingListener O4 = new a();
  private InverseBindingListener P4 = new b();
  private InverseBindingListener Q4 = new c();
  private long R4 = -1L;
  private long S4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    B4 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 52);
    localSparseIntArray.put(2131364252, 53);
    localSparseIntArray.put(2131363690, 54);
    localSparseIntArray.put(2131361969, 55);
    localSparseIntArray.put(2131364245, 56);
    localSparseIntArray.put(2131364309, 57);
    localSparseIntArray.put(2131363546, 58);
    localSparseIntArray.put(2131363089, 59);
    localSparseIntArray.put(2131363569, 60);
    localSparseIntArray.put(2131363093, 61);
    localSparseIntArray.put(2131362400, 62);
    localSparseIntArray.put(2131363981, 63);
    localSparseIntArray.put(2131364778, 64);
    localSparseIntArray.put(2131361991, 65);
  }
  
  public ActivityDeviceSettingNewIpcBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 66, A4, B4));
  }
  
  private ActivityDeviceSettingNewIpcBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 42, (FrameLayout)paramArrayOfObject[43], (ImageView)paramArrayOfObject[55], (RelativeLayout)paramArrayOfObject[46], (TextView)paramArrayOfObject[47], (TextView)paramArrayOfObject[65], (FrameLayout)paramArrayOfObject[20], (ImageView)paramArrayOfObject[2], (TextView)paramArrayOfObject[33], (TextView)paramArrayOfObject[62], (RelativeLayout)paramArrayOfObject[32], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[59], (ImageView)paramArrayOfObject[61], (CheckBox)paramArrayOfObject[27], (CameraLoadingView)paramArrayOfObject[51], (RelativeLayout)paramArrayOfObject[7], (RelativeLayout)paramArrayOfObject[11], (RelativeLayout)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[29], (TextView)paramArrayOfObject[30], (TextView)paramArrayOfObject[58], (RelativeLayout)paramArrayOfObject[31], (TextView)paramArrayOfObject[60], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[50], (TextView)paramArrayOfObject[13], (TextView)paramArrayOfObject[12], (ImageView)paramArrayOfObject[54], (FrameLayout)paramArrayOfObject[22], (FrameLayout)paramArrayOfObject[36], (CheckBox)paramArrayOfObject[37], (FrameLayout)paramArrayOfObject[40], (TextView)paramArrayOfObject[48], (CheckBox)paramArrayOfObject[24], (RelativeLayout)paramArrayOfObject[34], (TextView)paramArrayOfObject[35], (TextView)paramArrayOfObject[63], (FrameLayout)paramArrayOfObject[45], (RelativeLayout)paramArrayOfObject[14], (TextView)paramArrayOfObject[15], (TextView)paramArrayOfObject[56], (TextView)paramArrayOfObject[53], (Toolbar)paramArrayOfObject[52], (RelativeLayout)paramArrayOfObject[17], (TextView)paramArrayOfObject[18], (CheckBox)paramArrayOfObject[19], (TextView)paramArrayOfObject[57], (TextView)paramArrayOfObject[16], (TextView)paramArrayOfObject[49], (RelativeLayout)paramArrayOfObject[41], (TextView)paramArrayOfObject[42], (TextView)paramArrayOfObject[64]);
    this.c.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p2.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.M3.setTag(null);
    this.N3.setTag(null);
    this.O3.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.C4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[10];
    this.D4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[21];
    this.E4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[23];
    this.F4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[25];
    this.G4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[26];
    this.H4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[28];
    this.I4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[3];
    this.J4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[38];
    this.K4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[39];
    this.L4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[44];
    this.M4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[6];
    this.N4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.P3.setTag(null);
    this.Q3.setTag(null);
    this.S3.setTag(null);
    this.U3.setTag(null);
    this.V3.setTag(null);
    this.W3.setTag(null);
    this.X3.setTag(null);
    this.Y3.setTag(null);
    this.a4.setTag(null);
    this.b4.setTag(null);
    this.c4.setTag(null);
    this.d4.setTag(null);
    this.e4.setTag(null);
    this.f4.setTag(null);
    this.g4.setTag(null);
    this.h4.setTag(null);
    this.j4.setTag(null);
    this.k4.setTag(null);
    this.l4.setTag(null);
    this.p4.setTag(null);
    this.q4.setTag(null);
    this.r4.setTag(null);
    this.t4.setTag(null);
    this.u4.setTag(null);
    this.v4.setTag(null);
    this.w4.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean A(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x200000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean B(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x400000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean C(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x10000000;
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
        this.R4 |= 0x80000000;
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
        this.R4 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean F(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x2000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean G(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x200000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean H(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x800000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean I(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x40000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean J(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x4000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean K(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x80000;
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
        this.R4 |= 0x20000;
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
        this.R4 |= 0x40000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean N(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x100000;
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
        this.R4 |= 0x2000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean P(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x8000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean Q(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x1000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean R(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x100;
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
        this.R4 |= 0x20000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean T(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x1000000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean U(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x800;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean V(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean W(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x4000000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean X(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean Y(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean Z(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean a0(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x400000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x20000000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x4000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x100000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x10000;
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
        this.R4 |= 0x400;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x10000000000;
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
        this.R4 |= 0x4;
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
        this.R4 |= 0x10;
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
        this.R4 |= 0x8000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean u(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x2000000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean v(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x200;
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
        this.R4 |= 0x800000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean x(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x2;
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
        this.R4 |= 0x8000000000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean z(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R4 |= 0x1000000;
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
      long l1 = this.R4;
      this.R4 = 0L;
      long l2 = this.S4;
      this.S4 = 0L;
      View.OnClickListener localOnClickListener = this.z4;
      DeviceSettingNewViewModel localDeviceSettingNewViewModel = this.y4;
      Object localObject1;
      long l3;
      boolean bool7;
      Object localObject3;
      boolean bool8;
      Object localObject4;
      Object localObject5;
      boolean bool9;
      label599:
      boolean bool10;
      label653:
      label710:
      int i4;
      Object localObject6;
      boolean bool11;
      label769:
      Object localObject7;
      label859:
      int i5;
      int i6;
      label982:
      boolean bool16;
      label1169:
      label1281:
      boolean bool17;
      label1398:
      int i10;
      int i9;
      label1515:
      int i11;
      label1575:
      label1688:
      boolean bool19;
      int i14;
      Object localObject8;
      boolean bool20;
      int i15;
      int i13;
      label2040:
      Object localObject9;
      label2103:
      int i1;
      label2270:
      Object localObject10;
      label2333:
      boolean bool26;
      Object localObject11;
      label2396:
      Object localObject12;
      label2459:
      Object localObject13;
      label2585:
      int i23;
      boolean bool27;
      int i24;
      label2759:
      Object localObject14;
      label2814:
      boolean bool28;
      Object localObject15;
      boolean bool29;
      Object localObject16;
      label3072:
      boolean bool30;
      label3200:
      int i25;
      int i18;
      label3317:
      int i26;
      label3380:
      int i22;
      label3490:
      int i28;
      int i27;
      label3674:
      label3807:
      label3871:
      boolean bool34;
      Object localObject21;
      boolean bool37;
      boolean bool38;
      if ((0x1FFFFFFFFFFF & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x180000080001) < 0L;
        if (bool1)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject1 = localDeviceSettingNewViewModel.o;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null) {
            bool6 = ((ObservableBoolean)localObject1).get();
          } else {
            bool6 = false;
          }
          l3 = l1;
          bool7 = bool6;
          if (bool1) {
            if (bool6)
            {
              l3 = l1 | 0x4000000000000000;
              bool7 = bool6;
            }
            else
            {
              l3 = l1 | 0x2000000000000000;
              bool7 = bool6;
            }
          }
        }
        else
        {
          bool7 = false;
          l3 = l1;
        }
        bool1 = (l3 & 0x180000000002) < 0L;
        if (bool1)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject3 = localDeviceSettingNewViewModel.b;
          } else {
            localObject3 = null;
          }
          updateRegistration(1, (Observable)localObject3);
          if (localObject3 != null) {
            bool8 = ((ObservableBoolean)localObject3).get();
          } else {
            bool8 = false;
          }
          l1 = l3;
          if (bool1)
          {
            if (bool8)
            {
              l4 = l3 | 0x40000000000000;
              l3 = 72057594037927936L;
            }
            else
            {
              l4 = l3 | 0x20000000000000;
              l3 = 36028797018963968L;
            }
            l1 = l4 | l3;
          }
          l4 = l2;
          if ((l2 & 0x20) != 0L) {
            if (bool8) {
              l4 = l2 | 0x10000;
            } else {
              l4 = l2 | 0x8000;
            }
          }
          localObject1 = this.Y3.getResources();
          int i;
          if (bool8) {
            i = 2131952561;
          } else {
            i = 2131951891;
          }
          localObject4 = ((Resources)localObject1).getString(i);
          if (bool8)
          {
            localObject1 = this.V3.getResources().getString(2131951891);
            l2 = l1;
          }
          else
          {
            localObject1 = this.V3.getResources().getString(2131952561);
            l2 = l1;
          }
        }
        else
        {
          localObject4 = null;
          localObject1 = null;
          localObject3 = null;
          bool8 = false;
          l4 = l2;
          l2 = l3;
        }
        boolean bool2 = (l2 & 0x180000000004) < 0L;
        int j;
        if (bool2)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.J;
          } else {
            localObject5 = null;
          }
          updateRegistration(2, (Observable)localObject5);
          if (localObject5 != null) {
            bool6 = ((ObservableBoolean)localObject5).get();
          } else {
            bool6 = false;
          }
          l3 = l4;
          if (bool2)
          {
            if (bool6)
            {
              l3 = l4 | 0x4000;
              l4 = 68719476736L;
            }
            else
            {
              l3 = l4 | 0x2000;
              l4 = 34359738368L;
            }
            l3 |= l4;
          }
          if (bool6) {
            i3 = 0;
          } else {
            i3 = 4;
          }
          if (bool6) {
            j = 4;
          } else {
            j = 0;
          }
        }
        else
        {
          j = 0;
          i3 = 0;
          l3 = l4;
        }
        if ((l2 & 0x180000000008) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.a0;
          } else {
            localObject5 = null;
          }
          updateRegistration(3, (Observable)localObject5);
          if (localObject5 != null)
          {
            bool9 = ((ObservableBoolean)localObject5).get();
            break label599;
          }
        }
        bool9 = false;
        if ((0x1C0000000010 & l2) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.y;
          } else {
            localObject5 = null;
          }
          updateRegistration(4, (Observable)localObject5);
          if (localObject5 != null)
          {
            bool10 = ((ObservableBoolean)localObject5).get();
            break label653;
          }
        }
        bool10 = false;
        if ((l2 & 0x180000000020) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.A;
          } else {
            localObject5 = null;
          }
          updateRegistration(5, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((ObservableField)localObject5).get();
            break label710;
          }
        }
        localObject5 = null;
        i4 = j;
        if ((l2 & 0x180000000040) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject6 = localDeviceSettingNewViewModel.i;
          } else {
            localObject6 = null;
          }
          updateRegistration(6, (Observable)localObject6);
          if (localObject6 != null)
          {
            bool11 = ((ObservableBoolean)localObject6).get();
            break label769;
          }
        }
        bool11 = false;
        localObject7 = localObject5;
        if (((l2 & 0x180000000000) != 0L) && (localDeviceSettingNewViewModel != null)) {
          bool12 = localDeviceSettingNewViewModel.i0;
        } else {
          bool12 = false;
        }
        if ((l2 & 0x180000000080) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.h;
          } else {
            localObject5 = null;
          }
          updateRegistration(7, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject6 = (String)((ObservableField)localObject5).get();
            break label859;
          }
        }
        localObject6 = null;
        i5 = i3;
        int k = (l2 & 0x180000000100) < 0L;
        if (k != 0)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.R;
          } else {
            localObject5 = null;
          }
          updateRegistration(8, (Observable)localObject5);
          if (localObject5 != null) {
            bool6 = ((ObservableBoolean)localObject5).get();
          } else {
            bool6 = false;
          }
          l4 = l3;
          if (k != 0)
          {
            if (bool6) {
              l4 = 4L;
            } else {
              l4 = 2L;
            }
            l4 = l3 | l4;
          }
          if (bool6)
          {
            l3 = l4;
          }
          else
          {
            i6 = 8;
            l3 = l4;
            break label982;
          }
        }
        i6 = 0;
        if ((l2 & 0x180000401402) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.z;
          } else {
            localObject5 = null;
          }
          updateRegistration(10, (Observable)localObject5);
          if (localObject5 != null) {
            bool6 = ((ObservableBoolean)localObject5).get();
          } else {
            bool6 = false;
          }
          l4 = l3;
          if ((l2 & 0x180000400402) != 0L) {
            if (bool6) {
              l4 = l3 | 0x40;
            } else {
              l4 = l3 | 0x20;
            }
          }
          boolean bool14 = (l2 & 0x180000001400) < 0L;
          bool16 = bool6;
          l3 = l4;
          if (bool14)
          {
            k = bool6 ^ true;
            bool16 = bool6;
            l3 = l4;
            i3 = k;
            if (!bool14) {
              break label1169;
            }
            if (k != 0)
            {
              l3 = l4 | 0x4000000;
              bool16 = bool6;
              i3 = k;
              break label1169;
            }
            l3 = l4 | 0x2000000;
            bool16 = bool6;
            i3 = k;
            break label1169;
          }
        }
        else
        {
          bool16 = false;
        }
        i3 = 0;
        k = (l2 & 0x180000000800) < 0L;
        if (k != 0)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.S;
          } else {
            localObject5 = null;
          }
          updateRegistration(11, (Observable)localObject5);
          if (localObject5 != null) {
            bool6 = ((ObservableBoolean)localObject5).get();
          } else {
            bool6 = false;
          }
          l4 = l2;
          if (k != 0)
          {
            if (bool6) {
              l4 = 1125899906842624L;
            } else {
              l4 = 562949953421312L;
            }
            l4 = l2 | l4;
          }
          if (!bool6)
          {
            i8 = 8;
            break label1281;
          }
        }
        else
        {
          l4 = l2;
        }
        int i8 = 0;
        bool17 = bool16;
        k = (l4 & 0x180000002000) < 0L;
        if (k != 0)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.L;
          } else {
            localObject5 = null;
          }
          updateRegistration(13, (Observable)localObject5);
          if (localObject5 != null) {
            bool6 = ((ObservableBoolean)localObject5).get();
          } else {
            bool6 = false;
          }
          l2 = l3;
          if (k != 0)
          {
            if (bool6) {
              l2 = 4096L;
            } else {
              l2 = 2048L;
            }
            l2 = l3 | l2;
          }
          if (bool6)
          {
            l3 = l2;
          }
          else
          {
            m = 8;
            l3 = l2;
            break label1398;
          }
        }
        int m = 0;
        i10 = i8;
        boolean bool15 = (l4 & 0x180000004000) < 0L;
        if (bool15)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.t;
          } else {
            localObject5 = null;
          }
          updateRegistration(14, (Observable)localObject5);
          if (localObject5 != null) {
            bool6 = ((ObservableBoolean)localObject5).get();
          } else {
            bool6 = false;
          }
          l2 = l3;
          if (bool15)
          {
            if (bool6) {
              l2 = 1073741824L;
            } else {
              l2 = 536870912L;
            }
            l2 = l3 | l2;
          }
          if (bool6)
          {
            l3 = l2;
          }
          else
          {
            i9 = 8;
            l3 = l2;
            break label1515;
          }
        }
        i9 = 0;
        i11 = m;
        if ((l4 & 0x180000008000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.j;
          } else {
            localObject5 = null;
          }
          updateRegistration(15, (Observable)localObject5);
          if (localObject5 != null)
          {
            bool6 = ((ObservableBoolean)localObject5).get();
            break label1575;
          }
        }
        bool6 = false;
        boolean bool3 = (l4 & 0x180000010000) < 0L;
        if (bool3)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.O;
          } else {
            localObject5 = null;
          }
          updateRegistration(16, (Observable)localObject5);
          if (localObject5 != null) {
            bool16 = ((ObservableBoolean)localObject5).get();
          } else {
            bool16 = false;
          }
          l2 = l3;
          if (bool3)
          {
            if (bool16) {
              l2 = 4194304L;
            } else {
              l2 = 2097152L;
            }
            l2 = l3 | l2;
          }
          if (bool16)
          {
            l3 = l2;
          }
          else
          {
            i12 = 8;
            l3 = l2;
            break label1688;
          }
        }
        int i12 = 0;
        bool19 = bool6;
        bool3 = (l4 & 0x180000020000) < 0L;
        int n;
        if (bool3)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.M;
          } else {
            localObject5 = null;
          }
          updateRegistration(17, (Observable)localObject5);
          if (localObject5 != null) {
            bool16 = ((ObservableBoolean)localObject5).get();
          } else {
            bool16 = false;
          }
          l2 = l3;
          if (bool3)
          {
            if (bool16) {
              l2 = 16777216L;
            } else {
              l2 = 8388608L;
            }
            l2 = l3 | l2;
          }
          if (bool16) {
            bool3 = false;
          } else {
            n = 8;
          }
        }
        else
        {
          bool16 = false;
          n = 0;
          localObject5 = null;
          l2 = l3;
        }
        i14 = i12;
        boolean bool18 = (l4 & 0x180000060000) < 0L;
        if (bool18)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject8 = localDeviceSettingNewViewModel.l;
          } else {
            localObject8 = null;
          }
          updateRegistration(18, (Observable)localObject8);
          if (localObject8 != null) {
            bool6 = ((ObservableBoolean)localObject8).get();
          } else {
            bool6 = false;
          }
          bool20 = bool6;
          l3 = l2;
          if (bool18) {
            if (bool6)
            {
              l3 = l2 | 0x100000;
              bool20 = bool6;
            }
            else
            {
              l3 = l2 | 0x80000;
              bool20 = bool6;
            }
          }
        }
        else
        {
          bool20 = false;
          l3 = l2;
        }
        i15 = n;
        boolean bool4 = (l4 & 0x180000100000) < 0L;
        if (bool4)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject8 = localDeviceSettingNewViewModel.p;
          } else {
            localObject8 = null;
          }
          updateRegistration(20, (Observable)localObject8);
          if (localObject8 != null) {
            bool6 = ((ObservableBoolean)localObject8).get();
          } else {
            bool6 = false;
          }
          l2 = l3;
          if (bool4)
          {
            if (bool6) {
              l2 = 1024L;
            } else {
              l2 = 512L;
            }
            l2 = l3 | l2;
          }
          l3 = l2;
          if (bool6)
          {
            i13 = 8;
            break label2040;
          }
        }
        i13 = 0;
        l2 = l3;
        localObject9 = localObject5;
        if ((l4 & 0x180000200000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.e;
          } else {
            localObject5 = null;
          }
          updateRegistration(21, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject8 = (String)((ObservableField)localObject5).get();
            break label2103;
          }
        }
        localObject8 = null;
        bool4 = (l4 & 0x180001000000) < 0L;
        int i16;
        if (bool4)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.I;
          } else {
            localObject5 = null;
          }
          updateRegistration(24, (Observable)localObject5);
          if (localObject5 != null) {
            bool6 = ((ObservableBoolean)localObject5).get();
          } else {
            bool6 = false;
          }
          l3 = l2;
          if (bool4)
          {
            if (bool6)
            {
              l3 = l2 | 0x100000000;
              l2 = 17179869184L;
            }
            else
            {
              l3 = l2 | 0x80000000;
              l2 = 8589934592L;
            }
            l3 |= l2;
          }
          if (bool6) {
            i1 = 8;
          } else {
            i1 = 0;
          }
          if (bool6)
          {
            i16 = i1;
          }
          else
          {
            int i19 = 8;
            l2 = l3;
            i16 = i1;
            i1 = i19;
            break label2270;
          }
        }
        else
        {
          localObject5 = null;
          bool6 = false;
          i16 = 0;
          l3 = l2;
        }
        i1 = 0;
        l2 = l3;
        localObject10 = localObject5;
        if ((l4 & 0x180002000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.f;
          } else {
            localObject5 = null;
          }
          updateRegistration(25, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((ObservableField)localObject5).get();
            break label2333;
          }
        }
        localObject5 = null;
        bool26 = bool6;
        if ((l4 & 0x180004000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.m;
          } else {
            localObject11 = null;
          }
          updateRegistration(26, (Observable)localObject11);
          if (localObject11 != null)
          {
            localObject11 = (String)((ObservableField)localObject11).get();
            break label2396;
          }
        }
        localObject11 = null;
        localObject12 = localObject5;
        if ((l4 & 0x180008000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.x;
          } else {
            localObject5 = null;
          }
          updateRegistration(27, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((ObservableField)localObject5).get();
            break label2459;
          }
        }
        localObject5 = null;
        localObject13 = localObject11;
        boolean bool23 = (l4 & 0x180010000000) < 0L;
        if (bool23)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.N;
          } else {
            localObject11 = null;
          }
          updateRegistration(28, (Observable)localObject11);
          if (localObject11 != null) {
            bool6 = ((ObservableBoolean)localObject11).get();
          } else {
            bool6 = false;
          }
          l3 = l4;
          if (bool23)
          {
            if (bool6) {
              l3 = 281474976710656L;
            } else {
              l3 = 140737488355328L;
            }
            l3 = l4 | l3;
          }
          if (!bool6)
          {
            i20 = 8;
            l1 = l3;
            break label2585;
          }
        }
        else
        {
          l3 = l4;
        }
        int i20 = 0;
        l1 = l3;
        i23 = i16;
        boolean bool21 = (l1 & 0x180021000000) < 0L;
        if (bool21)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.K;
          } else {
            localObject11 = null;
          }
          updateRegistration(29, (Observable)localObject11);
          if (localObject11 != null) {
            bool27 = ((ObservableBoolean)localObject11).get();
          } else {
            bool27 = false;
          }
          bool6 = bool27;
          l4 = l2;
          if (bool21)
          {
            if (bool27) {
              l3 = 274877906944L;
            } else {
              l3 = 137438953472L;
            }
            l4 = l2 | l3;
            bool6 = bool27;
          }
        }
        else
        {
          bool6 = false;
          l4 = l2;
        }
        i24 = i20;
        if ((l1 & 0x180040000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.w;
          } else {
            localObject11 = null;
          }
          updateRegistration(30, (Observable)localObject11);
          if (localObject11 != null)
          {
            localObject11 = (String)((ObservableField)localObject11).get();
            break label2759;
          }
        }
        localObject11 = null;
        if ((l1 & 0x180080000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject14 = localDeviceSettingNewViewModel.k;
          } else {
            localObject14 = null;
          }
          updateRegistration(31, (Observable)localObject14);
          if (localObject14 != null)
          {
            bool27 = ((ObservableBoolean)localObject14).get();
            break label2814;
          }
        }
        bool27 = false;
        bool28 = bool6;
        bool21 = (l1 & 0x180100800200) < 0L;
        if (bool21)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject15 = localDeviceSettingNewViewModel.V;
          } else {
            localObject15 = null;
          }
          updateRegistration(32, (Observable)localObject15);
          if (localObject15 != null) {
            bool29 = ((ObservableBoolean)localObject15).get();
          } else {
            bool29 = false;
          }
          if (!bool21)
          {
            l3 = l1;
            localObject14 = localObject15;
            bool6 = bool29;
            if ((l4 & 0x20000) == 0L) {}
          }
          else if (bool29)
          {
            l3 = l1 | 0x10000000000000;
            localObject14 = localObject15;
            bool6 = bool29;
          }
          else
          {
            l3 = l1 | 0x8000000000000;
            localObject14 = localObject15;
            bool6 = bool29;
          }
        }
        else
        {
          localObject14 = null;
          bool6 = false;
          l3 = l1;
        }
        localObject16 = localObject11;
        bool21 = (l3 & 0x180200000000) < 0L;
        localObject15 = localObject14;
        if (bool21)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.u;
          } else {
            localObject11 = null;
          }
          updateRegistration(33, (Observable)localObject11);
          if (localObject11 != null) {
            bool29 = ((ObservableBoolean)localObject11).get();
          } else {
            bool29 = false;
          }
          l2 = l4;
          if (bool21)
          {
            if (bool29) {
              l2 = 16L;
            } else {
              l2 = 8L;
            }
            l2 = l4 | l2;
          }
          l4 = l2;
          if (bool29)
          {
            i17 = 8;
            break label3072;
          }
        }
        int i17 = 0;
        l2 = l4;
        bool30 = bool6;
        boolean bool24 = (l3 & 0x180400000000) < 0L;
        if (bool24)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.U;
          } else {
            localObject11 = null;
          }
          updateRegistration(34, (Observable)localObject11);
          if (localObject11 != null) {
            bool6 = ((ObservableBoolean)localObject11).get();
          } else {
            bool6 = false;
          }
          l1 = l3;
          l4 = l2;
          if (bool24) {
            if (bool6)
            {
              l4 = l2 | 1L;
              l1 = l3;
            }
            else
            {
              l1 = l3 | 0x8000000000000000;
              l4 = l2;
            }
          }
          if (bool6)
          {
            l3 = l1;
          }
          else
          {
            i21 = 8;
            l3 = l1;
            break label3200;
          }
        }
        else
        {
          l4 = l2;
        }
        int i21 = 0;
        i25 = i17;
        boolean bool22 = (l3 & 0x180800000000) < 0L;
        if (bool22)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.Q;
          } else {
            localObject11 = null;
          }
          updateRegistration(35, (Observable)localObject11);
          if (localObject11 != null) {
            bool6 = ((ObservableBoolean)localObject11).get();
          } else {
            bool6 = false;
          }
          l2 = l4;
          if (bool22)
          {
            if (bool6) {
              l2 = 4398046511104L;
            } else {
              l2 = 2199023255552L;
            }
            l2 = l4 | l2;
          }
          if (bool6)
          {
            l4 = l2;
          }
          else
          {
            i18 = 8;
            l4 = l2;
            break label3317;
          }
        }
        i18 = 0;
        i26 = i21;
        if ((l3 & 0x181000000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.g;
          } else {
            localObject11 = null;
          }
          updateRegistration(36, (Observable)localObject11);
          if (localObject11 != null)
          {
            localObject11 = (String)((ObservableField)localObject11).get();
            break label3380;
          }
        }
        localObject11 = null;
        boolean bool25 = (l3 & 0x182000000000) < 0L;
        if (bool25)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject14 = localDeviceSettingNewViewModel.n;
          } else {
            localObject14 = null;
          }
          updateRegistration(37, (Observable)localObject14);
          if (localObject14 != null) {
            bool6 = ((ObservableBoolean)localObject14).get();
          } else {
            bool6 = false;
          }
          l2 = l3;
          if (bool25)
          {
            if (bool6) {
              l2 = 288230376151711744L;
            } else {
              l2 = 144115188075855872L;
            }
            l2 = l3 | l2;
          }
          l3 = l2;
          if (bool6)
          {
            i22 = 8;
            break label3490;
          }
        }
        i22 = 0;
        l2 = l3;
        Object localObject17 = localObject11;
        boolean bool32 = (l2 & 0x184100800200) < 0L;
        if (bool32)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.b0;
          } else {
            localObject11 = null;
          }
          updateRegistration(38, (Observable)localObject11);
          if (localObject11 != null) {
            bool6 = ((ObservableBoolean)localObject11).get();
          } else {
            bool6 = false;
          }
          i28 = (l2 & 0x184000000000) < 0L;
          l1 = l4;
          if (i28 != 0)
          {
            if (bool6) {
              l3 = 256L;
            } else {
              l3 = 128L;
            }
            l1 = l4 | l3;
          }
          l3 = l1;
          if (bool32) {
            if (bool6) {
              l3 = l1 | 0x40000;
            } else {
              l3 = l1 | 0x20000;
            }
          }
          bool29 = bool6;
          l4 = l3;
          if (i28 != 0) {
            if (bool6)
            {
              bool29 = bool6;
              l4 = l3;
            }
            else
            {
              i27 = 8;
              break label3674;
            }
          }
        }
        else
        {
          bool29 = false;
        }
        i27 = 0;
        l3 = l4;
        bool6 = bool29;
        if ((l2 & 0x188000000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.c0;
          } else {
            localObject11 = null;
          }
          updateRegistration(39, (Observable)localObject11);
          if (localObject11 != null) {
            bool29 = ((ObservableBoolean)localObject11).get();
          } else {
            bool29 = false;
          }
          bool29 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool29));
        }
        else
        {
          bool29 = false;
        }
        boolean bool33 = bool6;
        if ((l2 & 0x190000000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.d;
          } else {
            localObject11 = null;
          }
          updateRegistration(40, (Observable)localObject11);
          if (localObject11 != null)
          {
            localObject14 = (String)((ObservableField)localObject11).get();
            break label3807;
          }
        }
        localObject14 = null;
        if ((l2 & 0x1A0000000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject11 = localDeviceSettingNewViewModel.v;
          } else {
            localObject11 = null;
          }
          updateRegistration(41, (Observable)localObject11);
          if (localObject11 != null)
          {
            localObject11 = (String)((ObservableField)localObject11).get();
            l4 = l2;
            break label3871;
          }
        }
        l4 = l2;
        localObject11 = null;
        bool34 = bool10;
        boolean bool35 = bool9;
        Object localObject18 = localObject1;
        Object localObject19 = localObject4;
        int i29 = i27;
        Object localObject20 = localObject7;
        i31 = i10;
        localObject21 = localObject5;
        Object localObject22 = localObject12;
        bool9 = bool8;
        i28 = i22;
        int i32 = i24;
        i27 = i25;
        l2 = l3;
        bool8 = bool16;
        localObject12 = localObject13;
        bool16 = bool27;
        i10 = i14;
        i25 = i3;
        l3 = l4;
        i24 = i5;
        bool37 = bool20;
        i3 = i1;
        localObject7 = localObject14;
        i1 = i23;
        i23 = i18;
        bool38 = bool7;
        l4 = l2;
        i18 = i9;
        bool20 = bool12;
        localObject4 = localObject3;
        i22 = i13;
        i5 = i32;
        i9 = i28;
        localObject3 = localObject9;
        localObject5 = localObject10;
        bool7 = bool26;
        localObject1 = localObject15;
        bool6 = bool30;
        bool30 = bool33;
        i28 = i6;
        localObject10 = localObject22;
        i14 = i11;
        i13 = i31;
        localObject13 = localObject6;
        bool10 = bool11;
        localObject15 = localObject20;
        localObject9 = localObject16;
        i11 = i15;
        bool26 = bool19;
        localObject16 = localObject17;
        i15 = i29;
        localObject6 = localObject19;
        localObject14 = localObject18;
        bool19 = bool35;
        bool27 = bool34;
      }
      else
      {
        l4 = l2;
        i24 = 0;
        bool37 = false;
        i4 = 0;
        i10 = 0;
        bool16 = false;
        i3 = 0;
        localObject7 = null;
        localObject8 = null;
        localObject11 = null;
        localObject12 = null;
        i1 = 0;
        bool8 = false;
        i23 = 0;
        bool38 = false;
        i18 = 0;
        bool20 = false;
        localObject4 = null;
        i22 = 0;
        bool17 = false;
        i27 = 0;
        i5 = 0;
        i9 = 0;
        bool9 = false;
        i25 = 0;
        i26 = 0;
        localObject3 = null;
        localObject5 = null;
        bool7 = false;
        bool28 = false;
        localObject1 = null;
        bool6 = false;
        bool30 = false;
        bool29 = false;
        i28 = 0;
        localObject10 = null;
        i14 = 0;
        localObject21 = null;
        i13 = 0;
        localObject13 = null;
        bool10 = false;
        localObject15 = null;
        localObject9 = null;
        i11 = 0;
        bool26 = false;
        localObject16 = null;
        i15 = 0;
        localObject6 = null;
        localObject14 = null;
        bool19 = false;
        bool27 = false;
        l3 = l1;
      }
      boolean bool13;
      if (((l3 & 0x4000000000000000) == 0L) && ((l4 & 0x4004120020) == 0L))
      {
        i6 = 0;
        bool11 = false;
        l2 = l3;
        l3 = l4;
        bool12 = bool7;
        bool34 = bool6;
      }
      else
      {
        bool13 = (l4 & 0x20) < 0L;
        if (bool13)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject4 = localDeviceSettingNewViewModel.b;
          }
          updateRegistration(1, (Observable)localObject4);
          bool12 = bool9;
          if (localObject4 != null) {
            bool12 = ((ObservableBoolean)localObject4).get();
          }
          l1 = l3;
          if ((l3 & 0x180000000002) != 0L)
          {
            if (bool12)
            {
              l3 |= 0x40000000000000;
              l2 = 72057594037927936L;
            }
            else
            {
              l3 |= 0x20000000000000;
              l2 = 36028797018963968L;
            }
            l1 = l3 | l2;
          }
          l3 = l1;
          l2 = l4;
          bool9 = bool12;
          if (bool13) {
            if (bool12)
            {
              l2 = l4 | 0x10000;
              l3 = l1;
              bool9 = bool12;
            }
            else
            {
              l2 = l4 | 0x8000;
              l3 = l1;
              bool9 = bool12;
            }
          }
        }
        else
        {
          l2 = l4;
        }
        if ((l2 & 0x4000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject4 = localDeviceSettingNewViewModel.Z;
          } else {
            localObject4 = null;
          }
          updateRegistration(12, (Observable)localObject4);
          if (localObject4 != null)
          {
            bool12 = ((ObservableBoolean)localObject4).get();
            break label4518;
          }
        }
        bool12 = false;
        label4518:
        if ((l2 & 0x100000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject3 = localDeviceSettingNewViewModel.M;
          }
          updateRegistration(17, (Observable)localObject3);
          bool11 = bool8;
          if (localObject3 != null) {
            bool11 = ((ObservableBoolean)localObject3).get();
          }
          bool8 = bool11;
          l1 = l2;
          if ((l3 & 0x180000020000) != 0L)
          {
            if (bool11) {
              l4 = 16777216L;
            } else {
              l4 = 8388608L;
            }
            l1 = l2 | l4;
            bool8 = bool11;
          }
        }
        else
        {
          l1 = l2;
        }
        bool11 = bool12;
        if ((l3 & 0x4000000000000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject3 = localDeviceSettingNewViewModel.r;
          } else {
            localObject3 = null;
          }
          updateRegistration(19, (Observable)localObject3);
          if (localObject3 != null) {
            bool12 = ((ObservableBoolean)localObject3).get();
          } else {
            bool12 = false;
          }
          bool13 = bool12 ^ true;
        }
        else
        {
          bool13 = false;
        }
        if ((l1 & 0x4000000000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject5 = localDeviceSettingNewViewModel.I;
          }
          updateRegistration(24, (Observable)localObject5);
          bool12 = bool7;
          if (localObject5 != null) {
            bool12 = ((ObservableBoolean)localObject5).get();
          }
          l4 = l1;
          bool7 = bool12;
          if ((l3 & 0x180001000000) != 0L)
          {
            if (bool12)
            {
              l2 = l1 | 0x100000000;
              l4 = 17179869184L;
            }
            else
            {
              l2 = l1 | 0x80000000;
              l4 = 8589934592L;
            }
            l4 = l2 | l4;
            bool7 = bool12;
          }
        }
        else
        {
          l4 = l1;
        }
        i30 = (l4 & 0x20000) < 0L;
        if (i30 != 0)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject1 = localDeviceSettingNewViewModel.V;
          }
          updateRegistration(32, (Observable)localObject1);
          bool12 = bool6;
          if (localObject1 != null) {
            bool12 = ((ObservableBoolean)localObject1).get();
          }
          if ((l3 & 0x180100800200) == 0L)
          {
            l2 = l3;
            bool6 = bool12;
            if (i30 == 0) {}
          }
          else if (bool12)
          {
            l2 = l3 | 0x10000000000000;
            bool6 = bool12;
          }
          else
          {
            l2 = l3 | 0x8000000000000;
            bool6 = bool12;
          }
        }
        else
        {
          l2 = l3;
        }
        bool34 = bool6;
        bool12 = bool7;
        l3 = l4;
      }
      int i30 = i3;
      int i31 = i1;
      boolean bool5 = (l2 & 0x180000080001) < 0L;
      l1 = l2;
      if (bool5)
      {
        if (!bool38) {
          bool13 = false;
        }
        l4 = l2;
        if (bool5)
        {
          if (bool13) {
            l4 = 1152921504606846976L;
          } else {
            l4 = 576460752303423488L;
          }
          l4 = l2 | l4;
        }
        l1 = l4;
        if (bool13)
        {
          i3 = 8;
          break label5017;
        }
      }
      int i3 = 0;
      long l4 = l1;
      label5017:
      bool5 = (l4 & 0x180000060000) < 0L;
      l2 = l4;
      if (bool5)
      {
        if (!bool37) {
          bool8 = false;
        }
        l2 = l4;
        if (bool5)
        {
          if (bool8) {
            l2 = 70368744177664L;
          } else {
            l2 = 35184372088832L;
          }
          l2 = l4 | l2;
        }
        if (!bool8)
        {
          i7 = 8;
          break label5093;
        }
      }
      int i7 = 0;
      label5093:
      boolean bool36 = (l2 & 0x180000001400) < 0L;
      if (bool36)
      {
        if (i25 == 0) {
          bool11 = false;
        }
        bool7 = bool11;
      }
      else
      {
        bool7 = false;
      }
      boolean bool31 = (l2 & 0x180021000000) < 0L;
      int i2;
      if (bool31)
      {
        if (!bool28) {
          bool12 = false;
        }
        l4 = l3;
        if (bool31)
        {
          if (bool12) {
            l4 = 268435456L;
          } else {
            l4 = 134217728L;
          }
          l4 = l3 | l4;
        }
        if (bool12) {
          bool5 = false;
        } else {
          i2 = 8;
        }
        l3 = l4;
      }
      else
      {
        i2 = 0;
      }
      boolean bool39 = (l2 & 0x10000000000000) < 0L;
      if ((!bool39) && ((l3 & 0x10000) == 0L))
      {
        bool6 = false;
        bool8 = false;
      }
      else
      {
        if (bool39)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject1 = localDeviceSettingNewViewModel.X;
          } else {
            localObject1 = null;
          }
          updateRegistration(9, (Observable)localObject1);
          if (localObject1 != null) {
            bool8 = ((ObservableBoolean)localObject1).get();
          } else {
            bool8 = false;
          }
          bool6 = bool8;
          l4 = l3;
          if (bool39)
          {
            if (bool8) {
              l4 = 1099511627776L;
            } else {
              l4 = 549755813888L;
            }
            l4 = l3 | l4;
            bool6 = bool8;
          }
        }
        else
        {
          bool6 = false;
          l4 = l3;
        }
        if ((l4 & 0x10000) != 0L)
        {
          if (localDeviceSettingNewViewModel != null) {
            localObject1 = localDeviceSettingNewViewModel.c;
          } else {
            localObject1 = null;
          }
          bool8 = bool6;
          updateRegistration(22, (Observable)localObject1);
          if (localObject1 != null) {
            bool6 = ((ObservableBoolean)localObject1).get();
          } else {
            bool6 = false;
          }
          bool6 ^= true;
          l3 = l4;
        }
        else
        {
          bool12 = false;
          l3 = l4;
          bool8 = bool6;
          bool6 = bool12;
        }
      }
      boolean bool12 = bool7;
      if (((l3 & 0x20) == 0L) || (!bool9)) {
        bool6 = false;
      }
      boolean bool40 = (l2 & 0x180000400402) < 0L;
      if (bool40)
      {
        bool7 = bool6;
        if (bool17) {
          bool7 = true;
        }
      }
      else
      {
        bool7 = false;
      }
      if ((l3 & 0x8000000000) != 0L)
      {
        if (localDeviceSettingNewViewModel != null) {
          localObject1 = localDeviceSettingNewViewModel.Y;
        } else {
          localObject1 = null;
        }
        updateRegistration(23, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool6 = ((ObservableBoolean)localObject1).get();
          break label5553;
        }
      }
      boolean bool6 = false;
      label5553:
      if (bool39)
      {
        if (bool8) {
          bool6 = true;
        }
      }
      else {
        bool6 = false;
      }
      boolean bool41 = (l2 & 0x180100800200) < 0L;
      if ((!bool41) && ((l3 & 0x20000) == 0L)) {}
      while (!bool34)
      {
        bool6 = false;
        break;
      }
      bool39 = (l2 & 0x184100800200) < 0L;
      if (bool39)
      {
        if (bool30) {
          bool8 = true;
        } else {
          bool8 = bool6;
        }
      }
      else {
        bool8 = false;
      }
      if ((l2 & 0x140000000000) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.p2.setOnClickListener(localOnClickListener);
        this.M3.setOnClickListener(localOnClickListener);
        this.N3.setOnClickListener(localOnClickListener);
        this.O3.setOnClickListener(localOnClickListener);
        this.P3.setOnClickListener(localOnClickListener);
        this.S3.setOnClickListener(localOnClickListener);
        this.W3.setOnClickListener(localOnClickListener);
        this.a4.setOnClickListener(localOnClickListener);
        this.d4.setOnClickListener(localOnClickListener);
        this.e4.setOnClickListener(localOnClickListener);
        this.j4.setOnClickListener(localOnClickListener);
        this.k4.setOnClickListener(localOnClickListener);
        this.u4.setOnClickListener(localOnClickListener);
        this.v4.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x180000000400) != 0L)
      {
        b.n(this.c, Boolean.valueOf(bool17), null);
        b.n(this.f, Boolean.valueOf(bool17), null);
        b.n(this.y, Boolean.valueOf(bool17), null);
        b.n(this.p2, Boolean.valueOf(bool17), null);
        b.n(this.F4, Boolean.valueOf(bool17), null);
        b.n(this.H4, Boolean.valueOf(bool17), null);
        b.n(this.P3, Boolean.valueOf(bool17), null);
        b.n(this.S3, Boolean.valueOf(bool17), null);
        b.n(this.a4, Boolean.valueOf(bool17), null);
        b.n(this.b4, Boolean.valueOf(bool17), null);
        b.n(this.d4, Boolean.valueOf(bool17), null);
        b.n(this.e4, Boolean.valueOf(bool17), null);
        b.n(this.g4, Boolean.valueOf(bool17), null);
        b.n(this.k4, Boolean.valueOf(bool17), null);
        b.n(this.p4, Boolean.valueOf(bool17), null);
        b.n(this.v4, Boolean.valueOf(bool17), null);
      }
      if ((l2 & 0x180004000000) != 0L) {
        TextViewBindingAdapter.setText(this.q, (CharSequence)localObject12);
      }
      if ((l2 & 0x180000000004) != 0L)
      {
        this.z.setVisibility(i24);
        this.J4.setVisibility(i4);
      }
      if ((0x1A0000000000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.p0, (CharSequence)localObject11);
      }
      if ((0x180000010000 & l2) != 0L) {
        this.p2.setVisibility(i10);
      }
      if ((0x180000200000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.p3, (CharSequence)localObject8);
      }
      if ((0x190000000000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.H3, (CharSequence)localObject7);
      }
      if ((0x180080000000 & l2) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.K3, bool16);
      }
      if ((0x100000000000 & l2) != 0L)
      {
        CompoundButtonBindingAdapter.setListeners(this.K3, null, this.O4);
        CompoundButtonBindingAdapter.setListeners(this.c4, null, this.P4);
        CompoundButtonBindingAdapter.setListeners(this.f4, null, this.Q4);
      }
      if ((0x188000000000 & l2) != 0L) {
        b.K(this.L3, Boolean.valueOf(bool29));
      }
      if ((l2 & 0x180001000000) != 0L)
      {
        this.M3.setVisibility(i31);
        this.N3.setVisibility(i30);
        this.D4.setVisibility(i30);
        this.W3.setVisibility(i31);
        this.u4.setVisibility(i30);
      }
      if (bool40)
      {
        b.n(this.M3, Boolean.valueOf(bool7), null);
        b.n(this.N3, Boolean.valueOf(bool7), null);
      }
      if (bool41) {
        b.Q(this.E4, bool6);
      }
      if ((0x180400000000 & l2) != 0L) {
        this.F4.setVisibility(i26);
      }
      if ((0x182000000000 & l2) != 0L) {
        this.G4.setVisibility(i9);
      }
      if ((0x180010000000 & l2) != 0L) {
        this.H4.setVisibility(i5);
      }
      if ((l2 & 0x180000080001) != 0L) {
        this.I4.setVisibility(i3);
      }
      if ((0x180200000000 & l2) != 0L) {
        this.K4.setVisibility(i27);
      }
      if ((0x180000100000 & l2) != 0L) {
        this.L4.setVisibility(i22);
      }
      if (bool36)
      {
        b.Q(this.M4, bool12);
        b.Q(this.j4, bool12);
      }
      if ((0x180000004000 & l2) != 0L) {
        this.N4.setVisibility(i18);
      }
      if ((0x180800000000 & l2) != 0L) {
        this.P3.setVisibility(i23);
      }
      if ((0x180040000000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.Q3, (CharSequence)localObject9);
      }
      if ((0x180000000100 & l2) != 0L) {
        this.S3.setVisibility(i28);
      }
      if ((0x180002000000 & l2) != 0L)
      {
        TextViewBindingAdapter.setText(this.U3, (CharSequence)localObject10);
        TextViewBindingAdapter.setText(this.X3, (CharSequence)localObject10);
      }
      if ((l2 & 0x180000000002) != 0L)
      {
        TextViewBindingAdapter.setText(this.V3, (CharSequence)localObject14);
        TextViewBindingAdapter.setText(this.Y3, (CharSequence)localObject6);
      }
      if ((l2 & 0x180000020000) != 0L) {
        this.b4.setVisibility(i11);
      }
      if ((0x180000040000 & l2) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.c4, bool37);
      }
      if ((l2 & 0x180000060000) != 0L) {
        this.d4.setVisibility(i7);
      }
      if (bool31) {
        this.e4.setVisibility(i2);
      }
      if ((0x180000008000 & l2) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.f4, bool26);
      }
      if ((0x180000002000 & l2) != 0L) {
        this.g4.setVisibility(i14);
      }
      if ((0x1C0000000010 & l2) != 0L) {
        ViewBindingAdapter.setOnClick(this.g4, localOnClickListener, bool27);
      }
      if ((0x180008000000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.h4, (CharSequence)localObject21);
      }
      if ((0x180000000000 & l2) != 0L) {
        b.c(this.j4, Boolean.valueOf(bool20), null);
      }
      if ((0x180000000800 & l2) != 0L) {
        this.k4.setVisibility(i13);
      }
      if ((0x181000000000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.l4, (CharSequence)localObject16);
      }
      if ((0x184000000000 & l2) != 0L) {
        this.p4.setVisibility(i15);
      }
      if ((0x180000000080 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.q4, (CharSequence)localObject13);
      }
      if ((0x180000000040 & l2) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.r4, bool10);
      }
      if (bool39) {
        b.Q(this.t4, bool8);
      }
      if ((0x180000000008 & l2) != 0L) {
        b.Q(this.v4, bool19);
      }
      if ((l2 & 0x180000000020) != 0L) {
        TextViewBindingAdapter.setText(this.w4, (CharSequence)localObject15);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.z4 = paramOnClickListener;
    try
    {
      this.R4 |= 0x40000000000;
      notifyPropertyChanged(2);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return (this.R4 != 0L) || (this.S4 != 0L);
    }
    finally {}
  }
  
  public void i(@Nullable DeviceSettingNewViewModel paramDeviceSettingNewViewModel)
  {
    this.y4 = paramDeviceSettingNewViewModel;
    try
    {
      this.R4 |= 0x80000000000;
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
      this.R4 = 17592186044416L;
      this.S4 = 0L;
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
    case 41: 
      return l((ObservableField)paramObject, paramInt2);
    case 40: 
      return q((ObservableField)paramObject, paramInt2);
    case 39: 
      return y((ObservableBoolean)paramObject, paramInt2);
    case 38: 
      return W((ObservableBoolean)paramObject, paramInt2);
    case 37: 
      return u((ObservableBoolean)paramObject, paramInt2);
    case 36: 
      return T((ObservableField)paramObject, paramInt2);
    case 35: 
      return H((ObservableBoolean)paramObject, paramInt2);
    case 34: 
      return a0((ObservableBoolean)paramObject, paramInt2);
    case 33: 
      return A((ObservableBoolean)paramObject, paramInt2);
    case 32: 
      return n((ObservableBoolean)paramObject, paramInt2);
    case 31: 
      return D((ObservableBoolean)paramObject, paramInt2);
    case 30: 
      return I((ObservableField)paramObject, paramInt2);
    case 29: 
      return S((ObservableBoolean)paramObject, paramInt2);
    case 28: 
      return C((ObservableBoolean)paramObject, paramInt2);
    case 27: 
      return P((ObservableField)paramObject, paramInt2);
    case 26: 
      return m((ObservableField)paramObject, paramInt2);
    case 25: 
      return F((ObservableField)paramObject, paramInt2);
    case 24: 
      return z((ObservableBoolean)paramObject, paramInt2);
    case 23: 
      return w((ObservableBoolean)paramObject, paramInt2);
    case 22: 
      return B((ObservableBoolean)paramObject, paramInt2);
    case 21: 
      return G((ObservableField)paramObject, paramInt2);
    case 20: 
      return N((ObservableBoolean)paramObject, paramInt2);
    case 19: 
      return K((ObservableBoolean)paramObject, paramInt2);
    case 18: 
      return M((ObservableBoolean)paramObject, paramInt2);
    case 17: 
      return L((ObservableBoolean)paramObject, paramInt2);
    case 16: 
      return o((ObservableBoolean)paramObject, paramInt2);
    case 15: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 14: 
      return J((ObservableBoolean)paramObject, paramInt2);
    case 13: 
      return O((ObservableBoolean)paramObject, paramInt2);
    case 12: 
      return Q((ObservableBoolean)paramObject, paramInt2);
    case 11: 
      return U((ObservableBoolean)paramObject, paramInt2);
    case 10: 
      return p((ObservableBoolean)paramObject, paramInt2);
    case 9: 
      return v((ObservableBoolean)paramObject, paramInt2);
    case 8: 
      return R((ObservableBoolean)paramObject, paramInt2);
    case 7: 
      return X((ObservableField)paramObject, paramInt2);
    case 6: 
      return V((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return Y((ObservableField)paramObject, paramInt2);
    case 4: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return Z((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return r((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return x((ObservableBoolean)paramObject, paramInt2);
    }
    return E((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label35;
      }
      i((DeviceSettingNewViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      boolean bool = ActivityDeviceSettingNewIpcBindingImpl.this.K3.isChecked();
      Object localObject = ActivityDeviceSettingNewIpcBindingImpl.this.y4;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((DeviceSettingNewViewModel)localObject).k;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
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
      boolean bool = ActivityDeviceSettingNewIpcBindingImpl.this.c4.isChecked();
      Object localObject = ActivityDeviceSettingNewIpcBindingImpl.this.y4;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((DeviceSettingNewViewModel)localObject).l;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
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
      boolean bool = ActivityDeviceSettingNewIpcBindingImpl.this.f4.isChecked();
      Object localObject = ActivityDeviceSettingNewIpcBindingImpl.this.y4;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((DeviceSettingNewViewModel)localObject).j;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDeviceSettingNewIpcBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */