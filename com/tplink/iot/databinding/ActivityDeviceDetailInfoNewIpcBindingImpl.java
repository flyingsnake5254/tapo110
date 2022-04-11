package com.tplink.iot.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
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
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceDetailInfoViewModel;

public class ActivityDeviceDetailInfoNewIpcBindingImpl
  extends ActivityDeviceDetailInfoNewIpcBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts b4;
  @Nullable
  private static final SparseIntArray c4;
  @NonNull
  private final FrameLayout d4;
  @NonNull
  private final View e4;
  @NonNull
  private final RelativeLayout f4;
  @NonNull
  private final TextView g4;
  @NonNull
  private final ImageView h4;
  @NonNull
  private final View i4;
  @NonNull
  private final FrameLayout j4;
  @NonNull
  private final ImageView k4;
  @NonNull
  private final TextView l4;
  @NonNull
  private final View m4;
  @NonNull
  private final LinearLayout n4;
  private long o4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    c4 = localSparseIntArray;
    localSparseIntArray.put(2131362323, 28);
    localSparseIntArray.put(2131364275, 29);
    localSparseIntArray.put(2131363399, 30);
    localSparseIntArray.put(2131362802, 31);
    localSparseIntArray.put(2131362837, 32);
    localSparseIntArray.put(2131363528, 33);
    localSparseIntArray.put(2131364862, 34);
    localSparseIntArray.put(2131362883, 35);
    localSparseIntArray.put(2131363396, 36);
    localSparseIntArray.put(2131362757, 37);
    localSparseIntArray.put(2131362644, 38);
    localSparseIntArray.put(2131362643, 39);
  }
  
  public ActivityDeviceDetailInfoNewIpcBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 40, b4, c4));
  }
  
  private ActivityDeviceDetailInfoNewIpcBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 18, (RelativeLayout)paramArrayOfObject[4], (RelativeLayout)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[28], (ImageView)paramArrayOfObject[1], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[24], (ImageView)paramArrayOfObject[39], (TextView)paramArrayOfObject[38], (RelativeLayout)paramArrayOfObject[23], (TextView)paramArrayOfObject[22], (TextView)paramArrayOfObject[37], (RelativeLayout)paramArrayOfObject[21], (TextView)paramArrayOfObject[31], (ImageView)paramArrayOfObject[32], (RelativeLayout)paramArrayOfObject[17], (TextView)paramArrayOfObject[18], (TextView)paramArrayOfObject[35], (CameraLoadingView)paramArrayOfObject[27], (RelativeLayout)paramArrayOfObject[19], (TextView)paramArrayOfObject[20], (TextView)paramArrayOfObject[36], (LinearLayout)paramArrayOfObject[30], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[33], (FrameLayout)paramArrayOfObject[13], (Toolbar)paramArrayOfObject[29], (TextView)paramArrayOfObject[10], (RelativeLayout)paramArrayOfObject[9], (TextView)paramArrayOfObject[34]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.H3.setTag(null);
    this.K3.setTag(null);
    this.L3.setTag(null);
    this.N3.setTag(null);
    this.O3.setTag(null);
    this.P3.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.d4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[11];
    this.e4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[12];
    this.f4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[14];
    this.g4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[15];
    this.h4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[16];
    this.i4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[2];
    this.j4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[25];
    this.k4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[26];
    this.l4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[5];
    this.m4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[8];
    this.n4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.S3.setTag(null);
    this.U3.setTag(null);
    this.W3.setTag(null);
    this.X3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean A(ObservableField<Drawable> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean B(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean C(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 0x800;
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
        this.o4 |= 0x4000;
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
        this.o4 |= 0x400;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 0x8;
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
        this.o4 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 0x200;
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
        this.o4 |= 0x4;
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
        this.o4 |= 0x2000;
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
        this.o4 |= 0x40;
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
        this.o4 |= 0x8000;
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
        this.o4 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean x(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 0x1000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean y(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.o4 |= 0x10000;
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
        this.o4 |= 0x20000;
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
      long l1 = this.o4;
      this.o4 = 0L;
      View.OnClickListener localOnClickListener = this.a4;
      Object localObject1 = this.Z3;
      Object localObject2;
      label92:
      Object localObject4;
      label149:
      long l2;
      Object localObject5;
      boolean bool2;
      int j;
      label260:
      label318:
      Object localObject6;
      int i;
      int i2;
      label528:
      Object localObject7;
      int i3;
      label644:
      label703:
      Object localObject8;
      int i5;
      label912:
      int i6;
      Object localObject9;
      label1029:
      Object localObject10;
      label1118:
      int i7;
      label1181:
      boolean bool7;
      Object localObject11;
      label1320:
      boolean bool8;
      Object localObject12;
      label1380:
      label1443:
      int i1;
      if ((0x1BFFFF & l1) != 0L)
      {
        if ((l1 & 0x180001) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((DeviceDetailInfoViewModel)localObject1).c;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (Drawable)((ObservableField)localObject2).get();
            break label92;
          }
        }
        localObject2 = null;
        if ((l1 & 0x180002) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((DeviceDetailInfoViewModel)localObject1).l;
          } else {
            localObject4 = null;
          }
          updateRegistration(1, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label149;
          }
        }
        localObject4 = null;
        boolean bool1 = (l1 & 0x180004) < 0L;
        l2 = l1;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject5 = ((DeviceDetailInfoViewModel)localObject1).p;
          } else {
            localObject5 = null;
          }
          updateRegistration(2, (Observable)localObject5);
          if (localObject5 != null) {
            bool2 = ((ObservableBoolean)localObject5).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 4194304L;
            } else {
              l2 = 2097152L;
            }
            l2 = l1 | l2;
          }
          if (!bool2)
          {
            j = 8;
            break label260;
          }
        }
        j = 0;
        if ((l2 & 0x180008) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((DeviceDetailInfoViewModel)localObject1).k;
          } else {
            localObject5 = null;
          }
          updateRegistration(3, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((ObservableField)localObject5).get();
            break label318;
          }
        }
        localObject5 = null;
        boolean bool3 = (l2 & 0x180010) < 0L;
        if (bool3)
        {
          if (localObject1 != null) {
            localObject6 = ((DeviceDetailInfoViewModel)localObject1).m;
          } else {
            localObject6 = null;
          }
          i = 4;
          updateRegistration(4, (Observable)localObject6);
          if (localObject6 != null) {
            bool2 = ((ObservableBoolean)localObject6).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool3)
          {
            if (bool2)
            {
              l2 |= 0x100000000;
              l1 = 68719476736L;
            }
            else
            {
              l2 |= 0x80000000;
              l1 = 34359738368L;
            }
            l1 = l2 | l1;
          }
          int k;
          if (bool2) {
            k = 4;
          } else {
            k = 0;
          }
          l2 = l1;
          i2 = k;
          if (bool2)
          {
            i = 0;
            l2 = l1;
            i2 = k;
          }
        }
        else
        {
          i = 0;
          i2 = 0;
        }
        if ((l2 & 0x180020) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((DeviceDetailInfoViewModel)localObject1).h;
          } else {
            localObject6 = null;
          }
          updateRegistration(5, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (String)((ObservableField)localObject6).get();
            break label528;
          }
        }
        localObject6 = null;
        boolean bool4 = (l2 & 0x180040) < 0L;
        l1 = l2;
        if (bool4)
        {
          if (localObject1 != null) {
            localObject7 = ((DeviceDetailInfoViewModel)localObject1).o;
          } else {
            localObject7 = null;
          }
          updateRegistration(6, (Observable)localObject7);
          if (localObject7 != null) {
            bool2 = ((ObservableBoolean)localObject7).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool4)
          {
            if (bool2) {
              l1 = 1073741824L;
            } else {
              l1 = 536870912L;
            }
            l1 = l2 | l1;
          }
          if (!bool2)
          {
            i3 = 8;
            l2 = l1;
            break label644;
          }
        }
        i3 = 0;
        l2 = l1;
        if ((l2 & 0x180080) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((DeviceDetailInfoViewModel)localObject1).d;
          } else {
            localObject7 = null;
          }
          updateRegistration(7, (Observable)localObject7);
          if (localObject7 != null)
          {
            localObject7 = (String)((ObservableField)localObject7).get();
            break label703;
          }
        }
        localObject7 = null;
        bool4 = (l2 & 0x180100) < 0L;
        int m;
        if (bool4)
        {
          if (localObject1 != null) {
            localObject8 = ((DeviceDetailInfoViewModel)localObject1).e;
          } else {
            localObject8 = null;
          }
          updateRegistration(8, (Observable)localObject8);
          if (localObject8 != null) {
            bool2 = ((ObservableBoolean)localObject8).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool4)
          {
            if (bool2)
            {
              l2 |= 0x4000000;
              l1 = 268435456L;
            }
            else
            {
              l2 |= 0x2000000;
              l1 = 134217728L;
            }
            l1 = l2 | l1;
          }
          if (bool2) {
            i5 = 8;
          } else {
            i5 = 0;
          }
          if (bool2)
          {
            bool4 = false;
            l2 = l1;
          }
          else
          {
            m = 8;
            l2 = l1;
          }
        }
        else
        {
          m = 0;
          i5 = 0;
        }
        if ((l2 & 0x180200) != 0L)
        {
          if (localObject1 != null) {
            localObject8 = ((DeviceDetailInfoViewModel)localObject1).i;
          } else {
            localObject8 = null;
          }
          updateRegistration(9, (Observable)localObject8);
          if (localObject8 != null)
          {
            localObject8 = (String)((ObservableField)localObject8).get();
            break label912;
          }
        }
        localObject8 = null;
        i6 = m;
        boolean bool5 = (l2 & 0x180400) < 0L;
        if (bool5)
        {
          if (localObject1 != null) {
            localObject9 = ((DeviceDetailInfoViewModel)localObject1).r;
          } else {
            localObject9 = null;
          }
          updateRegistration(10, (Observable)localObject9);
          if (localObject9 != null) {
            bool2 = ((ObservableBoolean)localObject9).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool5)
          {
            if (bool2) {
              l1 = 16777216L;
            } else {
              l1 = 8388608L;
            }
            l1 = l2 | l1;
          }
          if (bool2)
          {
            l2 = l1;
          }
          else
          {
            n = 8;
            l2 = l1;
            break label1029;
          }
        }
        int n = 0;
        localObject10 = localObject2;
        if (((l2 & 0x180000) != 0L) && (localObject1 != null)) {
          localObject9 = ((DeviceDetailInfoViewModel)localObject1).n;
        } else {
          localObject9 = null;
        }
        if ((l2 & 0x180800) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((DeviceDetailInfoViewModel)localObject1).s;
          } else {
            localObject2 = null;
          }
          updateRegistration(11, (Observable)localObject2);
          if (localObject2 != null)
          {
            bool2 = ((ObservableBoolean)localObject2).get();
            break label1118;
          }
        }
        bool2 = false;
        i7 = n;
        if ((l2 & 0x181000) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((DeviceDetailInfoViewModel)localObject1).j;
          } else {
            localObject2 = null;
          }
          updateRegistration(12, (Observable)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((ObservableField)localObject2).get();
            break label1181;
          }
        }
        localObject2 = null;
        bool7 = bool2;
        if ((l2 & 0x182000) != 0L)
        {
          if (localObject1 != null) {
            localObject11 = ((DeviceDetailInfoViewModel)localObject1).u;
          } else {
            localObject11 = null;
          }
          updateRegistration(13, (Observable)localObject11);
          if (localObject11 != null) {
            bool2 = ((ObservableBoolean)localObject11).get();
          } else {
            bool2 = false;
          }
          bool2 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
        }
        else
        {
          bool2 = false;
        }
        localObject11 = localObject2;
        if ((l2 & 0x184000) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((DeviceDetailInfoViewModel)localObject1).a;
          } else {
            localObject2 = null;
          }
          updateRegistration(14, (Observable)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((ObservableField)localObject2).get();
            break label1320;
          }
        }
        localObject2 = null;
        bool8 = bool2;
        if ((l2 & 0x188000) != 0L)
        {
          if (localObject1 != null) {
            localObject12 = ((DeviceDetailInfoViewModel)localObject1).t;
          } else {
            localObject12 = null;
          }
          updateRegistration(15, (Observable)localObject12);
          if (localObject12 != null)
          {
            bool2 = ((ObservableBoolean)localObject12).get();
            break label1380;
          }
        }
        bool2 = false;
        localObject12 = localObject2;
        if ((l2 & 0x190000) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((DeviceDetailInfoViewModel)localObject1).g;
          } else {
            localObject2 = null;
          }
          updateRegistration(16, (Observable)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((ObservableField)localObject2).get();
            break label1443;
          }
        }
        localObject2 = null;
        boolean bool6 = (l2 & 0x1A0000) < 0L;
        if (bool6)
        {
          if (localObject1 != null) {
            localObject1 = ((DeviceDetailInfoViewModel)localObject1).b;
          } else {
            localObject1 = null;
          }
          updateRegistration(17, (Observable)localObject1);
          boolean bool9;
          if (localObject1 != null) {
            bool9 = ((ObservableBoolean)localObject1).get();
          } else {
            bool9 = false;
          }
          l1 = l2;
          if (bool6)
          {
            if (bool9) {
              l1 = 17179869184L;
            } else {
              l1 = 8589934592L;
            }
            l1 = l2 | l1;
          }
          if (bool9) {
            bool6 = false;
          } else {
            i1 = 8;
          }
          l2 = l1;
        }
        else
        {
          i1 = 0;
        }
        int i8 = i7;
        i7 = i5;
        localObject1 = localObject6;
        localObject6 = localObject5;
        i5 = i2;
        localObject5 = localObject2;
        localObject2 = localObject7;
        i2 = i7;
        localObject7 = localObject4;
        i7 = j;
        j = i8;
        localObject4 = localObject1;
      }
      else
      {
        localObject5 = null;
        localObject8 = null;
        localObject11 = null;
        localObject2 = null;
        i2 = 0;
        localObject6 = null;
        localObject7 = null;
        bool2 = false;
        i7 = 0;
        i5 = 0;
        j = 0;
        i = 0;
        localObject4 = null;
        localObject12 = null;
        localObject9 = null;
        localObject10 = null;
        i6 = 0;
        bool7 = false;
        bool8 = false;
        i1 = 0;
        i3 = 0;
        l2 = l1;
      }
      if ((l2 & 0x140000) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.d.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
        this.H3.setOnClickListener(localOnClickListener);
        this.K3.setOnClickListener(localOnClickListener);
        this.O3.setOnClickListener(localOnClickListener);
        this.U3.setOnClickListener(localOnClickListener);
        this.X3.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x180004) != 0L)
      {
        this.c.setVisibility(i7);
        this.m4.setVisibility(i7);
      }
      if ((l2 & 0x180800) != 0L)
      {
        b.n(this.c, Boolean.valueOf(bool7), null);
        b.n(this.d, Boolean.valueOf(bool7), null);
        b.n(this.p1, Boolean.valueOf(bool7), null);
      }
      if ((l2 & 0x180010) != 0L)
      {
        this.q.setVisibility(i);
        this.j4.setVisibility(i5);
      }
      if ((l2 & 0x190000) != 0L) {
        TextViewBindingAdapter.setText(this.x, (CharSequence)localObject5);
      }
      if ((l2 & 0x180002) != 0L) {
        TextViewBindingAdapter.setText(this.y, (CharSequence)localObject7);
      }
      if ((l2 & 0x180400) != 0L) {
        this.p1.setVisibility(j);
      }
      if ((l2 & 0x180008) != 0L) {
        TextViewBindingAdapter.setText(this.p2, (CharSequence)localObject6);
      }
      if ((l2 & 0x180200) != 0L) {
        TextViewBindingAdapter.setText(this.L3, (CharSequence)localObject8);
      }
      if ((0x182000 & l2) != 0L) {
        b.K(this.N3, Boolean.valueOf(bool8));
      }
      if ((0x181000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.P3, (CharSequence)localObject11);
      }
      if ((0x188000 & l2) != 0L)
      {
        b.Q(this.e4, bool2);
        b.Q(this.f4, bool2);
        b.Q(this.i4, bool2);
        b.Q(this.X3, bool2);
      }
      if ((l2 & 0x180080) != 0L) {
        TextViewBindingAdapter.setText(this.g4, (CharSequence)localObject2);
      }
      if ((l2 & 0x180100) != 0L)
      {
        this.g4.setVisibility(i2);
        this.h4.setVisibility(i6);
      }
      if ((l2 & 0x180001) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.h4, (Drawable)localObject10);
      }
      if ((0x1A0000 & l2) != 0L) {
        this.k4.setVisibility(i1);
      }
      if ((0x180000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.l4, (CharSequence)localObject9);
      }
      if ((l2 & 0x180040) != 0L) {
        this.n4.setVisibility(i3);
      }
      if ((0x184000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.S3, (CharSequence)localObject12);
      }
      if ((l2 & 0x180020) != 0L) {
        TextViewBindingAdapter.setText(this.W3, (CharSequence)localObject4);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.a4 = paramOnClickListener;
    try
    {
      this.o4 |= 0x40000;
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
      return this.o4 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable DeviceDetailInfoViewModel paramDeviceDetailInfoViewModel)
  {
    this.Z3 = paramDeviceDetailInfoViewModel;
    try
    {
      this.o4 |= 0x80000;
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
      this.o4 = 1048576L;
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
      return z((ObservableBoolean)paramObject, paramInt2);
    case 16: 
      return y((ObservableField)paramObject, paramInt2);
    case 15: 
      return v((ObservableBoolean)paramObject, paramInt2);
    case 14: 
      return m((ObservableField)paramObject, paramInt2);
    case 13: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 12: 
      return x((ObservableField)paramObject, paramInt2);
    case 11: 
      return l((ObservableBoolean)paramObject, paramInt2);
    case 10: 
      return n((ObservableBoolean)paramObject, paramInt2);
    case 9: 
      return r((ObservableField)paramObject, paramInt2);
    case 8: 
      return w((ObservableBoolean)paramObject, paramInt2);
    case 7: 
      return B((ObservableField)paramObject, paramInt2);
    case 6: 
      return u((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return C((ObservableField)paramObject, paramInt2);
    case 4: 
      return q((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return p((ObservableField)paramObject, paramInt2);
    case 2: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return o((ObservableField)paramObject, paramInt2);
    }
    return A((ObservableField)paramObject, paramInt2);
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
      i((DeviceDetailInfoViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDeviceDetailInfoNewIpcBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */