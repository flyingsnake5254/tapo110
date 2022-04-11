package com.tplink.iot.databinding;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
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
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.ModeDetectionSettingsViewModel;

public class ActivityModeDetectSettingBindingImpl
  extends ActivityModeDetectSettingBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts P3;
  @Nullable
  private static final SparseIntArray Q3;
  @NonNull
  private final RelativeLayout R3;
  @NonNull
  private final TextView S3;
  @NonNull
  private final View T3;
  @NonNull
  private final TextView U3;
  @NonNull
  private final TextView V3;
  @NonNull
  private final ImageView W3;
  @NonNull
  private final View X3;
  @NonNull
  private final TextView Y3;
  @NonNull
  private final View Z3;
  @NonNull
  private final TextView a4;
  @NonNull
  private final TextView b4;
  @NonNull
  private final View c4;
  @NonNull
  private final TextView d4;
  @NonNull
  private final View e4;
  private InverseBindingListener f4 = new a();
  private long g4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    Q3 = localSparseIntArray;
    localSparseIntArray.put(2131363484, 26);
    localSparseIntArray.put(2131364252, 27);
    localSparseIntArray.put(2131361953, 28);
    localSparseIntArray.put(2131364163, 29);
  }
  
  public ActivityModeDetectSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 30, P3, Q3));
  }
  
  private ActivityModeDetectSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 22, (LinearLayout)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[19], (TextView)paramArrayOfObject[20], (TextView)paramArrayOfObject[28], (CameraLoadingView)paramArrayOfObject[25], (LinearLayout)paramArrayOfObject[9], (LinearLayout)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[12], (Toolbar)paramArrayOfObject[26], (LinearLayout)paramArrayOfObject[14], (CheckBox)paramArrayOfObject[16], (RelativeLayout)paramArrayOfObject[22], (TextView)paramArrayOfObject[23], (TextView)paramArrayOfObject[29], (TextView)paramArrayOfObject[27]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.R3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[10];
    this.S3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[11];
    this.T3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[13];
    this.U3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[15];
    this.V3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[17];
    this.W3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[18];
    this.X3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[2];
    this.Y3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[21];
    this.Z3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[24];
    this.a4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[4];
    this.b4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[5];
    this.c4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[7];
    this.d4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[8];
    this.e4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    this.I3.setTag(null);
    this.J3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean A(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.g4 |= 0x800;
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
        this.g4 |= 0x100000;
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
        this.g4 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean D(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.g4 |= 0x100;
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
        this.g4 |= 0x1000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean F(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.g4 |= 0x8000;
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
        this.g4 |= 0x40;
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
        this.g4 |= 0x10;
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
        this.g4 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.g4 |= 0x2;
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
        this.g4 |= 0x4000;
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
        this.g4 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.g4 |= 0x200000;
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
        this.g4 |= 0x400;
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
        this.g4 |= 0x10000;
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
        this.g4 |= 0x200;
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
        this.g4 |= 0x80000;
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
        this.g4 |= 0x20000;
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
        this.g4 |= 0x2000;
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
        this.g4 |= 0x20;
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
        this.g4 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean z(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.g4 |= 0x40000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public void H(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch paramOnStopTrackingTouch)
  {
    this.O3 = paramOnStopTrackingTouch;
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.g4;
      this.g4 = 0L;
      View.OnClickListener localOnClickListener = this.N3;
      ModeDetectionSettingsViewModel localModeDetectionSettingsViewModel = this.M3;
      Object localObject1;
      label92:
      Object localObject3;
      label149:
      Object localObject4;
      long l2;
      int i;
      boolean bool3;
      label271:
      int j;
      label394:
      label452:
      Object localObject5;
      int k;
      Object localObject6;
      Object localObject7;
      label654:
      label713:
      Object localObject8;
      int i1;
      label1001:
      Object localObject9;
      boolean bool8;
      boolean bool9;
      boolean bool10;
      boolean bool11;
      boolean bool12;
      int m;
      label1434:
      label1496:
      Object localObject10;
      label1551:
      Object localObject12;
      boolean bool14;
      boolean bool15;
      boolean bool16;
      if ((0x33FFFFF & l1) != 0L)
      {
        if ((l1 & 0x3000001) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject1 = localModeDetectionSettingsViewModel.B;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (String)((ObservableField)localObject1).get();
            break label92;
          }
        }
        localObject1 = null;
        if ((l1 & 0x3000002) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject3 = localModeDetectionSettingsViewModel.E;
          } else {
            localObject3 = null;
          }
          updateRegistration(1, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label149;
          }
        }
        localObject3 = null;
        boolean bool1 = (l1 & 0x3000004) < 0L;
        if (bool1)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject4 = localModeDetectionSettingsViewModel.p;
          } else {
            localObject4 = null;
          }
          updateRegistration(2, (Observable)localObject4);
          if (localObject4 != null) {
            bool2 = ((ObservableBoolean)localObject4).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 562949953421312L;
            } else {
              l2 = 281474976710656L;
            }
            l2 = l1 | l2;
          }
          if (!bool2)
          {
            i = 8;
            bool3 = bool2;
            break label271;
          }
        }
        else
        {
          bool2 = false;
          l2 = l1;
        }
        i = 0;
        bool3 = bool2;
        boolean bool4 = (l2 & 0x3000008) < 0L;
        if (bool4)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject4 = localModeDetectionSettingsViewModel.n;
          } else {
            localObject4 = null;
          }
          updateRegistration(3, (Observable)localObject4);
          if (localObject4 != null) {
            bool2 = ((ObservableBoolean)localObject4).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool4)
          {
            if (bool2) {
              l1 = 8796093022208L;
            } else {
              l1 = 4398046511104L;
            }
            l1 = l2 | l1;
          }
          if (bool2)
          {
            l2 = l1;
          }
          else
          {
            j = 8;
            l2 = l1;
            bool5 = bool2;
            break label394;
          }
        }
        else
        {
          bool2 = false;
        }
        j = 0;
        bool5 = bool2;
        if ((l2 & 0x3000010) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject4 = localModeDetectionSettingsViewModel.y;
          } else {
            localObject4 = null;
          }
          updateRegistration(4, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label452;
          }
        }
        localObject4 = null;
        boolean bool6 = (l2 & 0x3000040) < 0L;
        if (bool6)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject5 = localModeDetectionSettingsViewModel.r;
          } else {
            localObject5 = null;
          }
          updateRegistration(6, (Observable)localObject5);
          if (localObject5 != null) {
            bool2 = ((ObservableBoolean)localObject5).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool6)
          {
            if (bool2) {
              l1 = 8589934592L;
            } else {
              l1 = 4294967296L;
            }
            l1 = l2 | l1;
          }
          if (bool2)
          {
            localObject5 = getRoot().getContext();
            k = 2131954119;
          }
          else
          {
            localObject5 = getRoot().getContext();
            k = 2131954118;
          }
          localObject6 = ((Context)localObject5).getText(k);
          l2 = l1;
        }
        else
        {
          localObject6 = null;
        }
        if ((l2 & 0x3000100) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject5 = localModeDetectionSettingsViewModel.D;
          } else {
            localObject5 = null;
          }
          updateRegistration(8, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject7 = (String)((ObservableField)localObject5).get();
            break label654;
          }
        }
        localObject7 = null;
        if ((0x3000800 & l2) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject5 = localModeDetectionSettingsViewModel.x;
          } else {
            localObject5 = null;
          }
          updateRegistration(11, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((ObservableField)localObject5).get();
            break label713;
          }
        }
        localObject5 = null;
        if ((l2 & 0x3001080) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject8 = localModeDetectionSettingsViewModel.v;
          } else {
            localObject8 = null;
          }
          updateRegistration(12, (Observable)localObject8);
          if (localObject8 != null) {
            bool2 = ((ObservableBoolean)localObject8).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if ((l2 & 0x3001000) != 0L)
          {
            if (bool2)
            {
              l2 |= 0x20000000000;
              l1 = 2251799813685248L;
            }
            else
            {
              l2 |= 0x10000000000;
              l1 = 1125899906842624L;
            }
            l1 = l2 | l1;
          }
          l2 = l1;
          if ((l1 & 0x3001080) != 0L) {
            if (bool2) {
              l2 = l1 | 0x800000000000;
            } else {
              l2 = l1 | 0x400000000000;
            }
          }
          bool7 = (l2 & 0x3001000) < 0L;
          if (bool7)
          {
            n = bool2 ^ true;
            if (bool2) {
              i1 = 0;
            } else {
              i1 = 8;
            }
            if (bool2)
            {
              localObject8 = this.V3.getResources();
              k = 2131951770;
            }
            else
            {
              localObject8 = this.V3.getResources();
              k = 2131953234;
            }
            localObject8 = ((Resources)localObject8).getString(k);
            l1 = l2;
            if (bool7)
            {
              if (n != 0) {
                l1 = 549755813888L;
              } else {
                l1 = 274877906944L;
              }
              l1 = l2 | l1;
            }
            if (n != 0) {
              k = 0;
            } else {
              k = 8;
            }
            l2 = l1;
            break label1001;
          }
        }
        else
        {
          bool2 = false;
        }
        localObject8 = null;
        k = 0;
        i1 = 0;
        localObject9 = localObject6;
        if ((l2 & 0x3002000) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject6 = localModeDetectionSettingsViewModel.b;
          } else {
            localObject6 = null;
          }
          updateRegistration(13, (Observable)localObject6);
          if (localObject6 != null) {
            bool8 = ((ObservableBoolean)localObject6).get();
          } else {
            bool8 = false;
          }
          bool8 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool8));
        }
        else
        {
          bool8 = false;
        }
        bool9 = bool2;
        boolean bool7 = (l2 & 0x32A4600) < 0L;
        bool10 = bool8;
        if (bool7)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject6 = localModeDetectionSettingsViewModel.l;
          } else {
            localObject6 = null;
          }
          updateRegistration(14, (Observable)localObject6);
          if (localObject6 != null) {
            bool8 = ((ObservableBoolean)localObject6).get();
          } else {
            bool8 = false;
          }
          l1 = l2;
          bool2 = bool8;
          if (bool7) {
            if (bool8)
            {
              l1 = l2 | 0x80000000;
              bool2 = bool8;
            }
            else
            {
              l1 = l2 | 0x40000000;
              bool2 = bool8;
            }
          }
        }
        else
        {
          bool2 = false;
          l1 = l2;
        }
        bool7 = (l1 & 0x3008220) < 0L;
        if (bool7)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject6 = localModeDetectionSettingsViewModel.s;
          } else {
            localObject6 = null;
          }
          updateRegistration(15, (Observable)localObject6);
          if (localObject6 != null) {
            bool11 = ((ObservableBoolean)localObject6).get();
          } else {
            bool11 = false;
          }
          l2 = l1;
          bool8 = bool11;
          if (bool7) {
            if (bool11)
            {
              l2 = l1 | 0x800000000;
              bool8 = bool11;
            }
            else
            {
              l2 = l1 | 0x400000000;
              bool8 = bool11;
            }
          }
        }
        else
        {
          bool8 = false;
          l2 = l1;
        }
        bool12 = bool2;
        bool7 = (l2 & 0x3010000) < 0L;
        if (bool7)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject6 = localModeDetectionSettingsViewModel.o;
          } else {
            localObject6 = null;
          }
          updateRegistration(16, (Observable)localObject6);
          if (localObject6 != null) {
            bool2 = ((ObservableBoolean)localObject6).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool7)
          {
            if (bool2) {
              l1 = 137438953472L;
            } else {
              l1 = 68719476736L;
            }
            l1 = l2 | l1;
          }
          if (bool2)
          {
            l2 = l1;
          }
          else
          {
            m = 8;
            bool11 = bool2;
            break label1434;
          }
        }
        else
        {
          bool2 = false;
        }
        m = 0;
        bool11 = bool2;
        l1 = l2;
        bool13 = bool8;
        if ((l1 & 0x3040000) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject6 = localModeDetectionSettingsViewModel.F;
          } else {
            localObject6 = null;
          }
          updateRegistration(18, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (String)((ObservableField)localObject6).get();
            break label1496;
          }
        }
        localObject6 = null;
        if ((l1 & 0x3100000) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject10 = localModeDetectionSettingsViewModel.w;
          } else {
            localObject10 = null;
          }
          updateRegistration(20, (Observable)localObject10);
          if (localObject10 != null)
          {
            bool2 = ((ObservableBoolean)localObject10).get();
            break label1551;
          }
        }
        bool2 = false;
        Object localObject11 = localObject5;
        n = i;
        i = m;
        m = j;
        j = i1;
        localObject5 = localObject4;
        localObject12 = localObject7;
        localObject10 = localObject8;
        localObject7 = localObject1;
        localObject4 = localObject3;
        bool14 = bool3;
        i1 = n;
        bool15 = bool5;
        localObject8 = localObject9;
        bool16 = bool2;
        localObject9 = localObject11;
        bool8 = bool10;
        bool10 = bool13;
      }
      else
      {
        j = 0;
        bool11 = false;
        m = 0;
        localObject12 = null;
        localObject10 = null;
        i = 0;
        localObject7 = null;
        localObject4 = null;
        bool14 = false;
        i1 = 0;
        bool15 = false;
        localObject8 = null;
        bool16 = false;
        bool9 = false;
        localObject6 = null;
        localObject5 = null;
        localObject9 = null;
        bool8 = false;
        k = 0;
        bool12 = false;
        bool10 = false;
      }
      if ((l1 & 0x400840000000) != 0L)
      {
        if ((l1 & 0x400000000000) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject1 = localModeDetectionSettingsViewModel.z;
          } else {
            localObject1 = null;
          }
          updateRegistration(7, (Observable)localObject1);
          if (localObject1 != null)
          {
            bool2 = ((ObservableBoolean)localObject1).get();
            break label1754;
          }
        }
        bool2 = false;
        label1754:
        n = (l1 & 0x800000000) < 0L;
        bool5 = bool2;
        if (n != 0)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject3 = localModeDetectionSettingsViewModel.I;
          } else {
            localObject3 = null;
          }
          updateRegistration(9, (Observable)localObject3);
          if (localObject3 != null) {
            bool3 = ((ObservableBoolean)localObject3).get();
          } else {
            bool3 = false;
          }
          l2 = l1;
          localObject1 = localObject3;
          bool2 = bool3;
          if (n != 0) {
            if (bool3)
            {
              l2 = l1 | 0x80000000000000;
              localObject1 = localObject3;
              bool2 = bool3;
            }
            else
            {
              l2 = l1 | 0x40000000000000;
              localObject1 = localObject3;
              bool2 = bool3;
            }
          }
        }
        else
        {
          localObject1 = null;
          bool2 = false;
          l2 = l1;
        }
        if ((l2 & 0x40000000) != 0L)
        {
          if (localModeDetectionSettingsViewModel != null) {
            localObject3 = localModeDetectionSettingsViewModel.k;
          } else {
            localObject3 = null;
          }
          updateRegistration(10, (Observable)localObject3);
          if (localObject3 != null)
          {
            bool3 = ((ObservableBoolean)localObject3).get();
            l1 = l2;
            break label1960;
          }
        }
        bool3 = false;
        l1 = l2;
      }
      else
      {
        bool3 = false;
        localObject1 = null;
        bool2 = false;
        bool5 = false;
      }
      label1960:
      int n = (l1 & 0x32A4600) < 0L;
      if (n != 0)
      {
        if (bool12) {
          bool3 = true;
        }
        l2 = l1;
        bool12 = bool3;
        if (n != 0) {
          if (bool3)
          {
            l2 = l1 | 0x8000000;
            bool12 = bool3;
          }
          else
          {
            l2 = l1 | 0x4000000;
            bool12 = bool3;
          }
        }
      }
      else
      {
        bool12 = false;
        l2 = l1;
      }
      if ((l2 & 0x3001080) != 0L)
      {
        if (bool9) {
          bool5 = true;
        }
        bool3 = bool5;
      }
      else
      {
        bool3 = false;
      }
      if ((l2 & 0x4000000) != 0L)
      {
        if (localModeDetectionSettingsViewModel != null) {
          localObject3 = localModeDetectionSettingsViewModel.m;
        } else {
          localObject3 = null;
        }
        updateRegistration(21, (Observable)localObject3);
        if (localObject3 != null)
        {
          bool5 = ((ObservableBoolean)localObject3).get();
          break label2118;
        }
      }
      boolean bool5 = false;
      label2118:
      boolean bool13 = bool3;
      n = (l2 & 0x32A4600) < 0L;
      if (n != 0)
      {
        if (bool12) {
          bool5 = true;
        }
        l1 = l2;
        bool9 = bool5;
        if (n != 0) {
          if (bool5)
          {
            l1 = l2 | 0x200000000000;
            bool9 = bool5;
          }
          else
          {
            l1 = l2 | 0x100000000000;
            bool9 = bool5;
          }
        }
      }
      else
      {
        bool9 = false;
        l1 = l2;
      }
      if ((l1 & 0x200000000000) != 0L)
      {
        if (localModeDetectionSettingsViewModel != null) {
          localObject1 = localModeDetectionSettingsViewModel.I;
        }
        updateRegistration(9, (Observable)localObject1);
        if (localObject1 != null) {
          bool2 = ((ObservableBoolean)localObject1).get();
        }
        l2 = l1;
        bool3 = bool2;
        if ((l1 & 0x800000000) != 0L) {
          if (bool2)
          {
            l2 = l1 | 0x80000000000000;
            bool3 = bool2;
          }
          else
          {
            l2 = l1 | 0x40000000000000;
            bool3 = bool2;
          }
        }
      }
      else
      {
        bool3 = bool2;
        l2 = l1;
      }
      n = (l2 & 0x32A4600) < 0L;
      if (n != 0)
      {
        if (bool9) {
          bool2 = bool3;
        } else {
          bool2 = false;
        }
        l1 = l2;
        bool9 = bool2;
        if (n != 0)
        {
          if (bool2) {
            l1 = 9007199254740992L;
          } else {
            l1 = 4503599627370496L;
          }
          l1 = l2 | l1;
          bool9 = bool2;
        }
      }
      else
      {
        bool9 = false;
        l1 = l2;
      }
      if ((l1 & 0x40000000000000) != 0L)
      {
        if (localModeDetectionSettingsViewModel != null) {
          localObject1 = localModeDetectionSettingsViewModel.L;
        } else {
          localObject1 = null;
        }
        updateRegistration(5, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool2 = ((ObservableBoolean)localObject1).get();
          break label2432;
        }
      }
      boolean bool2 = false;
      label2432:
      if ((l1 & 0x10000000000000) != 0L)
      {
        if (localModeDetectionSettingsViewModel != null) {
          localObject1 = localModeDetectionSettingsViewModel.J;
        } else {
          localObject1 = null;
        }
        updateRegistration(17, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool5 = ((ObservableBoolean)localObject1).get();
          break label2487;
        }
      }
      bool5 = false;
      label2487:
      n = (l1 & 0x32A4600) < 0L;
      if (n != 0)
      {
        if (bool9) {
          bool5 = true;
        }
        l2 = l1;
        bool9 = bool5;
        if (n != 0)
        {
          if (bool5) {
            l2 = 536870912L;
          } else {
            l2 = 268435456L;
          }
          l2 = l1 | l2;
          bool9 = bool5;
        }
      }
      else
      {
        bool9 = false;
        l2 = l1;
      }
      if ((l2 & 0x800000000) != 0L)
      {
        if (bool3) {
          bool2 = true;
        }
      }
      else {
        bool2 = false;
      }
      boolean bool17 = (0x3008220 & l2) < 0L;
      if (bool17)
      {
        if (!bool10) {
          bool2 = false;
        }
        bool3 = bool2;
      }
      else
      {
        bool3 = false;
      }
      if ((l2 & 0x10000000) != 0L)
      {
        if (localModeDetectionSettingsViewModel != null) {
          localObject1 = localModeDetectionSettingsViewModel.K;
        } else {
          localObject1 = null;
        }
        updateRegistration(19, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool2 = ((ObservableBoolean)localObject1).get();
          break label2675;
        }
      }
      bool2 = false;
      label2675:
      n = (l2 & 0x32A4600) < 0L;
      if (n != 0)
      {
        if (bool9) {
          bool2 = true;
        }
      }
      else {
        bool2 = false;
      }
      if ((l2 & 0x2400000) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
        this.p0.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
        this.p3.setOnClickListener(localOnClickListener);
        this.I3.setOnClickListener(localOnClickListener);
      }
      if (n != 0)
      {
        b.Q(this.c, bool2);
        b.Q(this.c4, bool2);
      }
      if ((l2 & 0x3000001) != 0L) {
        TextViewBindingAdapter.setText(this.f, (CharSequence)localObject7);
      }
      if ((l2 & 0x3002000) != 0L) {
        b.K(this.x, Boolean.valueOf(bool8));
      }
      if ((l2 & 0x3010000) != 0L)
      {
        b.Q(this.y, bool11);
        this.S3.setVisibility(i);
        this.T3.setVisibility(i);
      }
      if ((l2 & 0x3000004) != 0L)
      {
        b.Q(this.z, bool14);
        this.d4.setVisibility(i1);
        this.e4.setVisibility(i1);
      }
      if ((0x3000008 & l2) != 0L)
      {
        b.Q(this.p1, bool15);
        this.U3.setVisibility(m);
      }
      if ((l2 & 0x3000002) != 0L) {
        TextViewBindingAdapter.setText(this.S3, (CharSequence)localObject4);
      }
      if ((0x3000100 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.U3, (CharSequence)localObject12);
      }
      if ((l2 & 0x3001000) != 0L)
      {
        TextViewBindingAdapter.setText(this.V3, (CharSequence)localObject10);
        this.W3.setVisibility(j);
        this.H3.setVisibility(k);
      }
      if ((l2 & 0x3001080) != 0L)
      {
        b.Q(this.X3, bool13);
        b.Q(this.p3, bool13);
      }
      if ((0x3000800 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.Y3, (CharSequence)localObject9);
      }
      if (bool17)
      {
        b.Q(this.Z3, bool3);
        b.Q(this.a4, bool3);
        b.Q(this.I3, bool3);
      }
      if ((0x3000010 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.b4, (CharSequence)localObject5);
      }
      if ((0x3040000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.d4, (CharSequence)localObject6);
      }
      if ((0x3100000 & l2) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.H3, bool16);
      }
      if ((0x2000000 & l2) != 0L) {
        CompoundButtonBindingAdapter.setListeners(this.H3, null, this.f4);
      }
      if ((l2 & 0x3000040) != 0L) {
        TextViewBindingAdapter.setText(this.J3, (CharSequence)localObject8);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.N3 = paramOnClickListener;
    try
    {
      this.g4 |= 0x400000;
      notifyPropertyChanged(55);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.g4 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable ModeDetectionSettingsViewModel paramModeDetectionSettingsViewModel)
  {
    this.M3 = paramModeDetectionSettingsViewModel;
    try
    {
      this.g4 |= 0x1000000;
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
      this.g4 = 33554432L;
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
    case 21: 
      return q((ObservableBoolean)paramObject, paramInt2);
    case 20: 
      return B((ObservableBoolean)paramObject, paramInt2);
    case 19: 
      return u((ObservableBoolean)paramObject, paramInt2);
    case 18: 
      return z((ObservableField)paramObject, paramInt2);
    case 17: 
      return v((ObservableBoolean)paramObject, paramInt2);
    case 16: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 15: 
      return F((ObservableBoolean)paramObject, paramInt2);
    case 14: 
      return o((ObservableBoolean)paramObject, paramInt2);
    case 13: 
      return w((ObservableBoolean)paramObject, paramInt2);
    case 12: 
      return E((ObservableBoolean)paramObject, paramInt2);
    case 11: 
      return A((ObservableField)paramObject, paramInt2);
    case 10: 
      return r((ObservableBoolean)paramObject, paramInt2);
    case 9: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 8: 
      return D((ObservableField)paramObject, paramInt2);
    case 7: 
      return p((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return G((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return x((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return l((ObservableField)paramObject, paramInt2);
    case 3: 
      return C((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return y((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return n((ObservableField)paramObject, paramInt2);
    }
    return m((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (55 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else if (93 == paramInt)
    {
      H((SeekBarBindingAdapter.OnStopTrackingTouch)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      i((ModeDetectionSettingsViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      boolean bool = ActivityModeDetectSettingBindingImpl.this.H3.isChecked();
      Object localObject = ActivityModeDetectSettingBindingImpl.this.M3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((ModeDetectionSettingsViewModel)localObject).w;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityModeDetectSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */