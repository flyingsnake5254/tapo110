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
import com.tplink.iot.viewmodel.ipcamera.setting.detection.DetectionSettingsViewModel;

public class ActivityDetectSettingBindingImpl
  extends ActivityDetectSettingBinding
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
  
  public ActivityDetectSettingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 30, P3, Q3));
  }
  
  private ActivityDetectSettingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
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
        this.g4 |= 0x1000;
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
        this.g4 |= 0x20;
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
        this.g4 |= 0x100000;
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
        this.g4 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean E(ObservableField<String> paramObservableField, int paramInt)
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
        this.g4 |= 0x80;
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
        this.g4 |= 0x100;
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
        this.g4 |= 0x800;
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
        this.g4 |= 0x400;
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
        this.g4 |= 0x40;
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
      DetectionSettingsViewModel localDetectionSettingsViewModel = this.M3;
      Object localObject1;
      Object localObject3;
      label92:
      label149:
      Object localObject4;
      long l2;
      int k;
      label271:
      int m;
      label394:
      Object localObject5;
      label452:
      boolean bool7;
      int i1;
      label744:
      boolean bool8;
      Object localObject6;
      int n;
      Object localObject7;
      label954:
      Object localObject8;
      label1017:
      Object localObject9;
      boolean bool10;
      boolean bool11;
      boolean bool12;
      int j;
      label1438:
      label1500:
      Object localObject10;
      label1559:
      boolean bool14;
      Object localObject12;
      boolean bool15;
      if ((0x33FFFFF & l1) != 0L)
      {
        if ((l1 & 0x3000001) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject1 = localDetectionSettingsViewModel.t;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject3 = (String)((ObservableField)localObject1).get();
            break label92;
          }
        }
        localObject3 = null;
        if ((l1 & 0x3000002) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject1 = localDetectionSettingsViewModel.w;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (String)((ObservableField)localObject1).get();
            break label149;
          }
        }
        localObject1 = null;
        boolean bool1 = (l1 & 0x3000004) < 0L;
        if (bool1)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject4 = localDetectionSettingsViewModel.e;
          } else {
            localObject4 = null;
          }
          updateRegistration(2, (Observable)localObject4);
          if (localObject4 != null) {
            bool3 = ((ObservableBoolean)localObject4).get();
          } else {
            bool3 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool3) {
              l2 = 2251799813685248L;
            } else {
              l2 = 1125899906842624L;
            }
            l2 = l1 | l2;
          }
          if (!bool3)
          {
            k = 8;
            bool4 = bool3;
            break label271;
          }
        }
        else
        {
          bool3 = false;
          l2 = l1;
        }
        k = 0;
        bool4 = bool3;
        bool1 = (l2 & 0x3000008) < 0L;
        if (bool1)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject4 = localDetectionSettingsViewModel.c;
          } else {
            localObject4 = null;
          }
          updateRegistration(3, (Observable)localObject4);
          if (localObject4 != null) {
            bool3 = ((ObservableBoolean)localObject4).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool1)
          {
            if (bool3) {
              l1 = 8796093022208L;
            } else {
              l1 = 4398046511104L;
            }
            l1 = l2 | l1;
          }
          if (bool3)
          {
            l2 = l1;
          }
          else
          {
            m = 8;
            l2 = l1;
            bool5 = bool3;
            break label394;
          }
        }
        else
        {
          bool3 = false;
        }
        m = 0;
        bool5 = bool3;
        if ((l2 & 0x3000010) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject4 = localDetectionSettingsViewModel.s;
          } else {
            localObject4 = null;
          }
          updateRegistration(4, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject5 = (String)((ObservableField)localObject4).get();
            break label452;
          }
        }
        localObject5 = null;
        bool1 = (l2 & 0x3000120) < 0L;
        if (bool1)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject4 = localDetectionSettingsViewModel.n;
          } else {
            localObject4 = null;
          }
          updateRegistration(5, (Observable)localObject4);
          if (localObject4 != null) {
            bool3 = ((ObservableBoolean)localObject4).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool1) {
            if (bool3) {
              l1 = l2 | 0x80000000;
            } else {
              l1 = l2 | 0x40000000;
            }
          }
          l2 = l1;
          if ((l1 & 0x3000020) != 0L)
          {
            if (bool3)
            {
              l1 |= 0x20000000000;
              l2 = 140737488355328L;
            }
            else
            {
              l1 |= 0x10000000000;
              l2 = 70368744177664L;
            }
            l2 = l1 | l2;
          }
          bool6 = (l2 & 0x3000020) < 0L;
          l1 = l2;
          bool7 = bool3;
          if (bool6)
          {
            localObject4 = this.V3.getResources();
            if (bool3) {
              i = 2131951770;
            } else {
              i = 2131953234;
            }
            localObject4 = ((Resources)localObject4).getString(i);
            if (bool3) {
              i1 = 0;
            } else {
              i1 = 8;
            }
            i = bool3 ^ true;
            l1 = l2;
            if (bool6)
            {
              if (i != 0) {
                l1 = 35184372088832L;
              } else {
                l1 = 17592186044416L;
              }
              l1 = l2 | l1;
            }
            if (i != 0)
            {
              i = 0;
              l2 = l1;
              break label744;
            }
            i = 8;
            l2 = l1;
            break label744;
          }
        }
        else
        {
          bool7 = false;
          l1 = l2;
        }
        int i = 0;
        localObject4 = null;
        i1 = 0;
        bool3 = bool7;
        l2 = l1;
        boolean bool6 = (l2 & 0x3000080) < 0L;
        bool8 = bool3;
        if (bool6)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject6 = localDetectionSettingsViewModel.l;
          } else {
            localObject6 = null;
          }
          updateRegistration(7, (Observable)localObject6);
          if (localObject6 != null) {
            bool3 = ((ObservableBoolean)localObject6).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool6)
          {
            if (bool3) {
              l1 = 34359738368L;
            } else {
              l1 = 17179869184L;
            }
            l1 = l2 | l1;
          }
          if (bool3)
          {
            localObject6 = getRoot().getContext();
            n = 2131954119;
          }
          else
          {
            localObject6 = getRoot().getContext();
            n = 2131954118;
          }
          localObject7 = ((Context)localObject6).getText(n);
          l2 = l1;
        }
        else
        {
          localObject7 = null;
        }
        int i2 = i;
        if ((l2 & 0x3000200) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject6 = localDetectionSettingsViewModel.v;
          } else {
            localObject6 = null;
          }
          updateRegistration(9, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (String)((ObservableField)localObject6).get();
            break label954;
          }
        }
        localObject6 = null;
        localObject8 = localObject7;
        if ((l2 & 0x3001000) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject7 = localDetectionSettingsViewModel.r;
          } else {
            localObject7 = null;
          }
          updateRegistration(12, (Observable)localObject7);
          if (localObject7 != null)
          {
            localObject7 = (String)((ObservableField)localObject7).get();
            break label1017;
          }
        }
        localObject7 = null;
        if ((l2 & 0x3002000) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject9 = localDetectionSettingsViewModel.b;
          } else {
            localObject9 = null;
          }
          updateRegistration(13, (Observable)localObject9);
          if (localObject9 != null) {
            bool3 = ((ObservableBoolean)localObject9).get();
          } else {
            bool3 = false;
          }
          bool3 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool3));
        }
        else
        {
          bool3 = false;
        }
        boolean bool2 = (l2 & 0x32A4C00) < 0L;
        bool10 = bool3;
        if (bool2)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject9 = localDetectionSettingsViewModel.h;
          } else {
            localObject9 = null;
          }
          updateRegistration(14, (Observable)localObject9);
          if (localObject9 != null) {
            bool7 = ((ObservableBoolean)localObject9).get();
          } else {
            bool7 = false;
          }
          l1 = l2;
          bool3 = bool7;
          if (bool2) {
            if (bool7)
            {
              l1 = l2 | 0x200000000;
              bool3 = bool7;
            }
            else
            {
              l1 = l2 | 0x100000000;
              bool3 = bool7;
            }
          }
        }
        else
        {
          bool3 = false;
          l1 = l2;
        }
        localObject9 = localObject3;
        bool2 = (l1 & 0x3008440) < 0L;
        if (bool2)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject3 = localDetectionSettingsViewModel.m;
          } else {
            localObject3 = null;
          }
          updateRegistration(15, (Observable)localObject3);
          if (localObject3 != null) {
            bool11 = ((ObservableBoolean)localObject3).get();
          } else {
            bool11 = false;
          }
          l2 = l1;
          bool7 = bool11;
          if (bool2) {
            if (bool11)
            {
              l2 = l1 | 0x2000000000;
              bool7 = bool11;
            }
            else
            {
              l2 = l1 | 0x1000000000;
              bool7 = bool11;
            }
          }
        }
        else
        {
          bool7 = false;
          l2 = l1;
        }
        bool12 = bool3;
        bool2 = (l2 & 0x3010000) < 0L;
        if (bool2)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject3 = localDetectionSettingsViewModel.d;
          } else {
            localObject3 = null;
          }
          updateRegistration(16, (Observable)localObject3);
          if (localObject3 != null) {
            bool3 = ((ObservableBoolean)localObject3).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool3) {
              l1 = 549755813888L;
            } else {
              l1 = 274877906944L;
            }
            l1 = l2 | l1;
          }
          if (bool3)
          {
            l2 = l1;
          }
          else
          {
            j = 8;
            break label1438;
          }
        }
        else
        {
          bool3 = false;
        }
        j = 0;
        l1 = l2;
        bool13 = bool7;
        if ((l1 & 0x3040000) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject3 = localDetectionSettingsViewModel.x;
          } else {
            localObject3 = null;
          }
          updateRegistration(18, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label1500;
          }
        }
        localObject3 = null;
        bool7 = bool3;
        if ((l1 & 0x3100000) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject10 = localDetectionSettingsViewModel.o;
          } else {
            localObject10 = null;
          }
          updateRegistration(20, (Observable)localObject10);
          if (localObject10 != null)
          {
            bool3 = ((ObservableBoolean)localObject10).get();
            break label1559;
          }
        }
        bool3 = false;
        Object localObject11 = localObject7;
        localObject10 = localObject3;
        localObject3 = localObject8;
        localObject8 = localObject9;
        n = j;
        j = i1;
        localObject7 = localObject6;
        localObject9 = localObject4;
        bool14 = bool4;
        i1 = k;
        localObject6 = localObject8;
        localObject12 = localObject1;
        bool15 = bool5;
        bool16 = bool8;
        bool11 = bool3;
        localObject8 = localObject10;
        localObject10 = localObject5;
        bool8 = bool10;
        localObject5 = localObject11;
        bool10 = bool13;
        k = i2;
      }
      else
      {
        m = 0;
        bool7 = false;
        localObject7 = null;
        j = 0;
        localObject9 = null;
        bool14 = false;
        n = 0;
        i1 = 0;
        localObject6 = null;
        localObject12 = null;
        bool15 = false;
        bool16 = false;
        localObject3 = null;
        bool11 = false;
        localObject8 = null;
        localObject10 = null;
        bool8 = false;
        localObject5 = null;
        bool12 = false;
        bool10 = false;
        k = 0;
      }
      if ((l1 & 0x2140000000) != 0L)
      {
        if ((l1 & 0x40000000) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject1 = localDetectionSettingsViewModel.p;
          } else {
            localObject1 = null;
          }
          updateRegistration(8, (Observable)localObject1);
          if (localObject1 != null)
          {
            bool4 = ((ObservableBoolean)localObject1).get();
            break label1774;
          }
        }
        bool4 = false;
        label1774:
        bool9 = (l1 & 0x2000000000) < 0L;
        if (bool9)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject4 = localDetectionSettingsViewModel.B;
          } else {
            localObject4 = null;
          }
          updateRegistration(10, (Observable)localObject4);
          if (localObject4 != null) {
            bool5 = ((ObservableBoolean)localObject4).get();
          } else {
            bool5 = false;
          }
          l2 = l1;
          bool3 = bool5;
          localObject1 = localObject4;
          if (bool9) {
            if (bool5)
            {
              l2 = l1 | 0x80000000000000;
              bool3 = bool5;
              localObject1 = localObject4;
            }
            else
            {
              l2 = l1 | 0x40000000000000;
              bool3 = bool5;
              localObject1 = localObject4;
            }
          }
        }
        else
        {
          bool3 = false;
          localObject1 = null;
          l2 = l1;
        }
        bool5 = bool4;
        if ((l2 & 0x100000000) != 0L)
        {
          if (localDetectionSettingsViewModel != null) {
            localObject4 = localDetectionSettingsViewModel.g;
          } else {
            localObject4 = null;
          }
          updateRegistration(11, (Observable)localObject4);
          if (localObject4 != null)
          {
            bool4 = ((ObservableBoolean)localObject4).get();
            l1 = l2;
            break label1980;
          }
        }
        bool4 = false;
        l1 = l2;
      }
      else
      {
        bool4 = false;
        bool3 = false;
        localObject1 = null;
        bool5 = false;
      }
      label1980:
      if ((l1 & 0x3000120) != 0L)
      {
        if (bool16) {
          bool5 = true;
        }
      }
      else {
        bool5 = false;
      }
      boolean bool9 = (l1 & 0x32A4C00) < 0L;
      if (bool9)
      {
        if (bool12) {
          bool4 = true;
        }
        l2 = l1;
        bool12 = bool4;
        if (bool9) {
          if (bool4)
          {
            l2 = l1 | 0x8000000;
            bool12 = bool4;
          }
          else
          {
            l2 = l1 | 0x4000000;
            bool12 = bool4;
          }
        }
      }
      else
      {
        bool12 = false;
        l2 = l1;
      }
      if ((l2 & 0x4000000) != 0L)
      {
        if (localDetectionSettingsViewModel != null) {
          localObject4 = localDetectionSettingsViewModel.i;
        } else {
          localObject4 = null;
        }
        updateRegistration(21, (Observable)localObject4);
        if (localObject4 != null)
        {
          bool4 = ((ObservableBoolean)localObject4).get();
          break label2133;
        }
      }
      boolean bool4 = false;
      label2133:
      bool9 = (l2 & 0x32A4C00) < 0L;
      if (bool9)
      {
        if (bool12) {
          bool4 = true;
        }
        l1 = l2;
        bool12 = bool4;
        if (bool9) {
          if (bool4)
          {
            l1 = l2 | 0x2000000000000;
            bool12 = bool4;
          }
          else
          {
            l1 = l2 | 0x1000000000000;
            bool12 = bool4;
          }
        }
      }
      else
      {
        bool12 = false;
        l1 = l2;
      }
      if ((l1 & 0x2000000000000) != 0L)
      {
        if (localDetectionSettingsViewModel != null) {
          localObject1 = localDetectionSettingsViewModel.B;
        }
        updateRegistration(10, (Observable)localObject1);
        if (localObject1 != null) {
          bool3 = ((ObservableBoolean)localObject1).get();
        }
        l2 = l1;
        bool4 = bool3;
        if ((l1 & 0x2000000000) != 0L) {
          if (bool3)
          {
            l2 = l1 | 0x80000000000000;
            bool4 = bool3;
          }
          else
          {
            l2 = l1 | 0x40000000000000;
            bool4 = bool3;
          }
        }
      }
      else
      {
        bool4 = bool3;
        l2 = l1;
      }
      boolean bool13 = bool5;
      bool9 = (l2 & 0x32A4C00) < 0L;
      if (bool9)
      {
        if (bool12) {
          bool3 = bool4;
        } else {
          bool3 = false;
        }
        l1 = l2;
        bool12 = bool3;
        if (bool9)
        {
          if (bool3) {
            l1 = 9007199254740992L;
          } else {
            l1 = 4503599627370496L;
          }
          l1 = l2 | l1;
          bool12 = bool3;
        }
      }
      else
      {
        bool12 = false;
        l1 = l2;
      }
      if ((l1 & 0x40000000000000) != 0L)
      {
        if (localDetectionSettingsViewModel != null) {
          localObject1 = localDetectionSettingsViewModel.C;
        } else {
          localObject1 = null;
        }
        updateRegistration(6, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool3 = ((ObservableBoolean)localObject1).get();
          break label2445;
        }
      }
      boolean bool3 = false;
      label2445:
      if ((l1 & 0x10000000000000) != 0L)
      {
        if (localDetectionSettingsViewModel != null) {
          localObject1 = localDetectionSettingsViewModel.j;
        } else {
          localObject1 = null;
        }
        updateRegistration(17, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool5 = ((ObservableBoolean)localObject1).get();
          break label2500;
        }
      }
      boolean bool5 = false;
      label2500:
      boolean bool16 = bool3;
      bool9 = (l1 & 0x32A4C00) < 0L;
      if (bool9)
      {
        bool3 = bool5;
        if (bool12) {
          bool3 = true;
        }
        l2 = l1;
        bool5 = bool3;
        if (bool9)
        {
          if (bool3) {
            l2 = 536870912L;
          } else {
            l2 = 268435456L;
          }
          l2 = l1 | l2;
          bool5 = bool3;
        }
      }
      else
      {
        bool5 = false;
        l2 = l1;
      }
      if ((l2 & 0x2000000000) != 0L)
      {
        bool3 = bool16;
        if (bool4) {
          bool3 = true;
        }
      }
      else
      {
        bool3 = false;
      }
      bool9 = (0x3008440 & l2) < 0L;
      if (bool9)
      {
        if (!bool10) {
          bool3 = false;
        }
        bool4 = bool3;
      }
      else
      {
        bool4 = false;
      }
      if ((l2 & 0x10000000) != 0L)
      {
        if (localDetectionSettingsViewModel != null) {
          localObject1 = localDetectionSettingsViewModel.k;
        } else {
          localObject1 = null;
        }
        updateRegistration(19, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool3 = ((ObservableBoolean)localObject1).get();
          break label2700;
        }
      }
      bool3 = false;
      label2700:
      boolean bool17 = (l2 & 0x32A4C00) < 0L;
      if (bool17)
      {
        if (bool5) {
          bool3 = true;
        }
      }
      else {
        bool3 = false;
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
      if (bool17)
      {
        b.Q(this.c, bool3);
        b.Q(this.c4, bool3);
      }
      if ((l2 & 0x3000001) != 0L) {
        TextViewBindingAdapter.setText(this.f, (CharSequence)localObject6);
      }
      if ((0x3002000 & l2) != 0L) {
        b.K(this.x, Boolean.valueOf(bool8));
      }
      if ((0x3010000 & l2) != 0L)
      {
        b.Q(this.y, bool7);
        this.S3.setVisibility(n);
        this.T3.setVisibility(n);
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
        TextViewBindingAdapter.setText(this.S3, (CharSequence)localObject12);
      }
      if ((0x3000200 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.U3, (CharSequence)localObject7);
      }
      if ((l2 & 0x3000020) != 0L)
      {
        TextViewBindingAdapter.setText(this.V3, (CharSequence)localObject9);
        this.W3.setVisibility(j);
        this.H3.setVisibility(k);
      }
      if ((l2 & 0x3000120) != 0L)
      {
        b.Q(this.X3, bool13);
        b.Q(this.p3, bool13);
      }
      if ((0x3001000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.Y3, (CharSequence)localObject5);
      }
      if (bool9)
      {
        b.Q(this.Z3, bool4);
        b.Q(this.a4, bool4);
        b.Q(this.I3, bool4);
      }
      if ((0x3000010 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.b4, (CharSequence)localObject10);
      }
      if ((0x3040000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.d4, (CharSequence)localObject8);
      }
      if ((0x3100000 & l2) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.H3, bool11);
      }
      if ((0x2000000 & l2) != 0L) {
        CompoundButtonBindingAdapter.setListeners(this.H3, null, this.f4);
      }
      if ((l2 & 0x3000080) != 0L) {
        TextViewBindingAdapter.setText(this.J3, (CharSequence)localObject3);
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
  
  public void i(@Nullable DetectionSettingsViewModel paramDetectionSettingsViewModel)
  {
    this.M3 = paramDetectionSettingsViewModel;
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
      return C((ObservableBoolean)paramObject, paramInt2);
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
      return A((ObservableField)paramObject, paramInt2);
    case 11: 
      return r((ObservableBoolean)paramObject, paramInt2);
    case 10: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 9: 
      return E((ObservableField)paramObject, paramInt2);
    case 8: 
      return p((ObservableBoolean)paramObject, paramInt2);
    case 7: 
      return G((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return x((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return B((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return l((ObservableField)paramObject, paramInt2);
    case 3: 
      return D((ObservableBoolean)paramObject, paramInt2);
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
      i((DetectionSettingsViewModel)paramObject);
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
      boolean bool = ActivityDetectSettingBindingImpl.this.H3.isChecked();
      Object localObject = ActivityDetectSettingBindingImpl.this.M3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((DetectionSettingsViewModel)localObject).o;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDetectSettingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */