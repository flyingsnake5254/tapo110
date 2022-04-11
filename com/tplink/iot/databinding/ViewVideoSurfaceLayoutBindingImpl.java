package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.view.ipcamera.base.b;

public class ViewVideoSurfaceLayoutBindingImpl
  extends ViewVideoSurfaceLayoutBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts W3;
  @Nullable
  private static final SparseIntArray X3;
  @NonNull
  private final ConstraintLayout Y3;
  @NonNull
  private final LinearLayout Z3;
  @NonNull
  private final TextView a4;
  @NonNull
  private final TextView b4;
  private long c4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    X3 = localSparseIntArray;
    localSparseIntArray.put(2131363253, 15);
    localSparseIntArray.put(2131364296, 16);
    localSparseIntArray.put(2131363538, 17);
  }
  
  public ViewVideoSurfaceLayoutBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 18, W3, X3));
  }
  
  private ViewVideoSurfaceLayoutBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 11, (View)paramArrayOfObject[13], (ImageView)paramArrayOfObject[3], (View)paramArrayOfObject[5], (FrameLayout)paramArrayOfObject[15], (LinearLayout)paramArrayOfObject[14], (LottieAnimationView)paramArrayOfObject[4], (View)paramArrayOfObject[8], (TextView)paramArrayOfObject[17], (TextView)paramArrayOfObject[10], (ImageView)paramArrayOfObject[11], (ImageView)paramArrayOfObject[6], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[9], (View)paramArrayOfObject[16]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.Y3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[1];
    this.Z3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[12];
    this.a4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[2];
    this.b4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    this.I3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean A(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.c4 |= 0x20;
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
        this.c4 |= 0x10;
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
        this.c4 |= 0x200;
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
        this.c4 |= 0x40;
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
        this.c4 |= 0x8;
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
        this.c4 |= 0x100;
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
        this.c4 |= 0x400;
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
        this.c4 |= 0x2;
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
        this.c4 |= 0x4;
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
        this.c4 |= 1L;
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
        this.c4 |= 0x80;
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
      long l1 = this.c4;
      this.c4 = 0L;
      ObservableBoolean localObservableBoolean1 = this.K3;
      Object localObject1 = this.V3;
      ObservableBoolean localObservableBoolean2 = this.T3;
      ObservableBoolean localObservableBoolean3 = this.Q3;
      ObservableBoolean localObservableBoolean4 = this.M3;
      ObservableBoolean localObservableBoolean5 = this.N3;
      ObservableBoolean localObservableBoolean6 = this.S3;
      ObservableBoolean localObservableBoolean7 = this.L3;
      ObservableField localObservableField = this.R3;
      ObservableBoolean localObservableBoolean8 = this.P3;
      ObservableBoolean localObservableBoolean9 = this.O3;
      Boolean localBoolean = this.U3;
      boolean bool1 = false;
      boolean bool2;
      if (((l1 & 0x1002) != 0L) && (localObject1 != null)) {
        bool2 = ((ObservableBoolean)localObject1).get();
      } else {
        bool2 = false;
      }
      boolean bool3 = (l1 & 0x1028) < 0L;
      boolean bool6;
      if (bool3)
      {
        if (localObservableBoolean3 != null) {
          bool5 = localObservableBoolean3.get();
        } else {
          bool5 = false;
        }
        l2 = l1;
        bool6 = bool5;
        if (bool3)
        {
          if (bool5) {
            l2 = 4294967296L;
          } else {
            l2 = 2147483648L;
          }
          l2 = l1 | l2;
          bool6 = bool5;
        }
      }
      else
      {
        bool6 = false;
        l2 = l1;
      }
      int j;
      if ((l2 & 0x1090) != 0L)
      {
        if (localObservableBoolean4 != null) {
          bool5 = localObservableBoolean4.get();
        } else {
          bool5 = false;
        }
        l1 = l2;
        if ((l2 & 0x1010) != 0L) {
          if (bool5) {
            l1 = l2 | 0x400000;
          } else {
            l1 = l2 | 0x200000;
          }
        }
        int i;
        if ((l1 & 0x1010) != 0L)
        {
          if (bool5) {
            i = 3;
          } else {
            i = 7;
          }
        }
        else {
          i = 0;
        }
        bool7 = bool5 ^ true;
        l2 = l1;
        bool8 = bool5;
        j = i;
        bool9 = bool7;
        if ((l1 & 0x1090) != 0L) {
          if (bool7)
          {
            l2 = l1 | 0x1000000000;
            bool8 = bool5;
            j = i;
            bool9 = bool7;
          }
          else
          {
            l2 = l1 | 0x800000000;
            bool8 = bool5;
            j = i;
            bool9 = bool7;
          }
        }
      }
      else
      {
        bool8 = false;
        j = 0;
        bool9 = false;
      }
      if ((l2 & 0x1038) != 0L)
      {
        if (localObservableBoolean5 != null) {
          bool5 = localObservableBoolean5.get();
        } else {
          bool5 = false;
        }
        l1 = l2;
        if ((l2 & 0x1028) != 0L) {
          if (bool5) {
            l1 = l2 | 0x100000;
          } else {
            l1 = l2 | 0x80000;
          }
        }
        l2 = l1;
        bool10 = bool5;
        if ((l1 & 0x1030) != 0L) {
          if (bool5)
          {
            l2 = l1 | 0x10000000 | 0x4000000000;
            bool10 = bool5;
          }
          else
          {
            l2 = l1 | 0x8000000 | 0x2000000000;
            bool10 = bool5;
          }
        }
      }
      else
      {
        bool10 = false;
      }
      boolean bool4 = (l2 & 0x1044) < 0L;
      if (bool4)
      {
        if (localObservableBoolean6 != null) {
          bool5 = localObservableBoolean6.get();
        } else {
          bool5 = false;
        }
        l1 = l2;
        bool11 = bool5;
        if (bool4)
        {
          if (bool5) {
            l1 = 16777216L;
          } else {
            l1 = 8388608L;
          }
          l1 = l2 | l1;
          bool11 = bool5;
        }
      }
      else
      {
        bool11 = false;
        l1 = l2;
      }
      boolean bool12 = (l1 & 0x1081) < 0L;
      if (bool12)
      {
        if (localObservableBoolean7 != null) {
          bool7 = localObservableBoolean7.get();
        } else {
          bool7 = false;
        }
        bool13 = bool7 ^ true;
        l3 = l1;
        bool5 = bool7;
        bool4 = bool13;
        if (bool12)
        {
          if (bool13) {
            l2 = 16384L;
          } else {
            l2 = 8192L;
          }
          l3 = l1 | l2;
          bool5 = bool7;
          bool4 = bool13;
        }
      }
      else
      {
        bool5 = false;
        bool4 = false;
        l3 = l1;
      }
      if (((l3 & 0x1100) != 0L) && (localObservableField != null)) {
        localObject1 = (String)localObservableField.get();
      } else {
        localObject1 = null;
      }
      boolean bool13 = (l3 & 0x1600) < 0L;
      boolean bool14;
      if (bool13)
      {
        if (localObservableBoolean9 != null) {
          bool7 = localObservableBoolean9.get();
        } else {
          bool7 = false;
        }
        l2 = l3;
        bool14 = bool7;
        if (bool13)
        {
          if (bool7) {
            l2 = 65536L;
          } else {
            l2 = 32768L;
          }
          l2 = l3 | l2;
          bool14 = bool7;
        }
      }
      else
      {
        bool14 = false;
        l2 = l3;
      }
      bool13 = (l2 & 0x18B1) < 0L;
      boolean bool15;
      if (bool13)
      {
        bool7 = ViewDataBinding.safeUnbox(localBoolean);
        l1 = l2;
        bool15 = bool7;
        if (bool13)
        {
          if (bool7) {
            l1 = 262144L;
          } else {
            l1 = 131072L;
          }
          l1 = l2 | l1;
          bool15 = bool7;
        }
      }
      else
      {
        bool15 = false;
        l1 = l2;
      }
      boolean bool16;
      if (((l1 & 0x1000000) != 0L) && (localObservableBoolean2 != null)) {
        bool16 = localObservableBoolean2.get();
      } else {
        bool16 = false;
      }
      long l2 = l1;
      boolean bool7 = bool8;
      boolean bool17;
      if ((l1 & 0x40000) != 0L)
      {
        if (localObservableBoolean4 != null) {
          bool8 = localObservableBoolean4.get();
        }
        l3 = l1;
        if ((l1 & 0x1010) != 0L) {
          if (bool8) {
            l3 = l1 | 0x400000;
          } else {
            l3 = l1 | 0x200000;
          }
        }
        bool17 = bool8 ^ true;
        l2 = l3;
        bool7 = bool8;
        bool9 = bool17;
        if ((l3 & 0x1090) != 0L) {
          if (bool17)
          {
            l2 = l3 | 0x1000000000;
            bool7 = bool8;
            bool9 = bool17;
          }
          else
          {
            l2 = l3 | 0x800000000;
            bool9 = bool17;
            bool7 = bool8;
          }
        }
      }
      if ((l2 & 0x100000000) != 0L)
      {
        if (localObservableBoolean5 != null) {
          bool10 = localObservableBoolean5.get();
        }
        l1 = l2;
        if ((l2 & 0x1028) != 0L) {
          if (bool10) {
            l1 = l2 | 0x100000;
          } else {
            l1 = l2 | 0x80000;
          }
        }
        l2 = l1;
        if ((l1 & 0x1030) != 0L) {
          if (bool10) {
            l2 = l1 | 0x10000000 | 0x4000000000;
          } else {
            l2 = l1 | 0x8000000 | 0x2000000000;
          }
        }
        bool8 = bool10 ^ true;
        l1 = l2;
      }
      else
      {
        bool8 = false;
        l1 = l2;
      }
      if (((l1 & 0x10000) != 0L) && (localObservableBoolean8 != null)) {
        bool17 = localObservableBoolean8.get();
      } else {
        bool17 = false;
      }
      if (((l1 & 0x1600) != 0L) && (bool14)) {
        bool14 = bool17;
      } else {
        bool14 = false;
      }
      bool13 = (l1 & 0x18B1) < 0L;
      if (bool13)
      {
        if (bool15) {
          bool17 = bool9;
        } else {
          bool17 = false;
        }
        l2 = l1;
        bool15 = bool17;
        if (bool13)
        {
          if (bool17) {
            l2 = 17179869184L;
          } else {
            l2 = 8589934592L;
          }
          l2 = l1 | l2;
          bool15 = bool17;
        }
      }
      else
      {
        bool15 = false;
        l2 = l1;
      }
      if (((l2 & 0x1044) == 0L) || (!bool11)) {
        bool16 = false;
      }
      bool13 = (l2 & 0x1028) < 0L;
      if ((bool13) && (bool6)) {
        bool17 = bool8;
      } else {
        bool17 = false;
      }
      long l3 = l2;
      boolean bool11 = bool10;
      if ((l2 & 0x400000000) != 0L)
      {
        if (localObservableBoolean5 != null) {
          bool10 = localObservableBoolean5.get();
        }
        l1 = l2;
        if (bool13) {
          if (bool10) {
            l1 = l2 | 0x100000;
          } else {
            l1 = l2 | 0x80000;
          }
        }
        l2 = l1;
        if ((l1 & 0x1030) != 0L) {
          if (bool10) {
            l2 = l1 | 0x10000000 | 0x4000000000;
          } else {
            l2 = l1 | 0x8000000 | 0x2000000000;
          }
        }
        bool8 = bool10 ^ true;
        bool11 = bool10;
        l3 = l2;
      }
      bool13 = (l3 & 0x18B1) < 0L;
      if (bool13)
      {
        if (!bool15) {
          bool8 = false;
        }
        l1 = l3;
        bool15 = bool8;
        if (bool13)
        {
          if (bool8) {
            l2 = 67108864L;
          } else {
            l2 = 33554432L;
          }
          l1 = l3 | l2;
          bool15 = bool8;
        }
      }
      else
      {
        bool15 = false;
        l1 = l3;
      }
      if ((l1 & 0x1028) != 0L)
      {
        if (bool11) {
          bool6 = true;
        }
      }
      else {
        bool6 = false;
      }
      l2 = l1;
      boolean bool10 = bool7;
      boolean bool8 = bool9;
      if ((l1 & 0x4010000000) != 0L)
      {
        if (localObservableBoolean4 != null) {
          bool7 = localObservableBoolean4.get();
        }
        l3 = l1;
        if ((l1 & 0x1010) != 0L) {
          if (bool7) {
            l3 = l1 | 0x400000;
          } else {
            l3 = l1 | 0x200000;
          }
        }
        l2 = l3;
        bool10 = bool7;
        bool8 = bool9;
        if ((l3 & 0x4000000000) != 0L)
        {
          bool9 = bool7 ^ true;
          l2 = l3;
          bool10 = bool7;
          bool8 = bool9;
          if ((l3 & 0x1090) != 0L) {
            if (bool9)
            {
              l2 = l3 | 0x1000000000;
              bool10 = bool7;
              bool8 = bool9;
            }
            else
            {
              l2 = l3 | 0x800000000;
              bool8 = bool9;
              bool10 = bool7;
            }
          }
        }
      }
      l1 = l2;
      boolean bool9 = bool5;
      if ((0x4000000 & l2) != 0L)
      {
        if (localObservableBoolean7 != null) {
          bool5 = localObservableBoolean7.get();
        }
        bool13 = bool5 ^ true;
        l1 = l2;
        bool9 = bool5;
        bool4 = bool13;
        if ((l2 & 0x1081) != 0L)
        {
          if (bool13) {
            l1 = 16384L;
          } else {
            l1 = 8192L;
          }
          l1 = l2 | l1;
          bool4 = bool13;
          bool9 = bool5;
        }
      }
      boolean bool18 = (l1 & 0x18B1) < 0L;
      if (bool18)
      {
        if (bool15) {
          bool13 = bool4;
        } else {
          bool13 = false;
        }
        l2 = l1;
        bool12 = bool13;
        if (bool18)
        {
          if (bool13) {
            l2 = 1073741824L;
          } else {
            l2 = 536870912L;
          }
          l2 = l1 | l2;
          bool12 = bool13;
        }
      }
      else
      {
        bool12 = false;
        l2 = l1;
      }
      bool13 = (l2 & 0x1030) < 0L;
      if (bool13)
      {
        if (!bool11) {
          bool10 = false;
        }
        if (bool11) {
          bool5 = bool8;
        } else {
          bool5 = false;
        }
        bool15 = bool5;
        bool11 = bool10;
      }
      else
      {
        bool15 = false;
        bool11 = false;
      }
      if ((l2 & 0x40004000) != 0L)
      {
        if (localObservableBoolean1 != null) {
          bool5 = localObservableBoolean1.get();
        } else {
          bool5 = false;
        }
        bool10 = bool5;
        if ((l2 & 0x40000000) != 0L)
        {
          bool7 = bool5 ^ true;
          bool10 = bool5;
          break label1995;
        }
      }
      else
      {
        bool10 = false;
      }
      bool7 = false;
      label1995:
      boolean bool5 = bool9;
      if ((l2 & 0x1000000000) != 0L)
      {
        bool5 = bool9;
        if (localObservableBoolean7 != null) {
          bool5 = localObservableBoolean7.get();
        }
      }
      bool18 = (l2 & 0x1081) < 0L;
      if ((!bool18) || (!bool4)) {
        bool10 = false;
      }
      bool4 = (l2 & 0x18B1) < 0L;
      if (bool4)
      {
        if (!bool12) {
          bool7 = false;
        }
        bool9 = bool7;
      }
      else
      {
        bool9 = false;
      }
      bool12 = (l2 & 0x1090) < 0L;
      bool7 = bool1;
      if (bool12)
      {
        bool7 = bool1;
        if (bool8) {
          bool7 = bool5;
        }
      }
      if ((l2 & 0x1600) != 0L) {
        b.Q(this.c, bool14);
      }
      if (bool18)
      {
        b.Q(this.d, bool10);
        b.s(this.y, Boolean.valueOf(bool10));
      }
      if ((l2 & 0x1080) != 0L)
      {
        b.Q(this.f, bool5);
        b.Q(this.p3, bool5);
      }
      if ((l2 & 0x1002) != 0L) {
        b.Q(this.x, bool2);
      }
      if ((l2 & 0x1028) != 0L)
      {
        b.Q(this.z, bool6);
        b.Q(this.a4, bool17);
      }
      if (bool4) {
        b.Q(this.Z3, bool9);
      }
      if ((0x1100 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.b4, (CharSequence)localObject1);
      }
      if ((l2 & 0x1010) != 0L)
      {
        b.B(this.b4, Integer.valueOf(j));
        b.C(this.b4, Integer.valueOf(j));
      }
      if ((l2 & 0x1044) != 0L) {
        b.Q(this.b4, bool16);
      }
      if (bool13)
      {
        b.Q(this.p1, bool15);
        b.Q(this.p2, bool11);
        b.Q(this.I3, bool15);
      }
      if (bool12) {
        b.Q(this.H3, bool7);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(10, paramObservableBoolean);
    this.O3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x400;
      notifyPropertyChanged(30);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.c4 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(1, paramObservableBoolean);
    this.V3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x2;
      notifyPropertyChanged(33);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.c4 = 4096L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(2, paramObservableBoolean);
    this.T3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x4;
      notifyPropertyChanged(38);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(0, paramObservableBoolean);
    this.K3 = paramObservableBoolean;
    try
    {
      this.c4 |= 1L;
      notifyPropertyChanged(41);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(7, paramObservableBoolean);
    this.L3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x80;
      notifyPropertyChanged(42);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void o(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(5, paramObservableBoolean);
    this.N3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x20;
      notifyPropertyChanged(44);
      super.requestRebind();
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
    case 10: 
      return v((ObservableBoolean)paramObject, paramInt2);
    case 9: 
      return C((ObservableBoolean)paramObject, paramInt2);
    case 8: 
      return F((ObservableField)paramObject, paramInt2);
    case 7: 
      return z((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return D((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return A((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return B((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return E((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return x((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return w((ObservableBoolean)paramObject, paramInt2);
    }
    return y((ObservableBoolean)paramObject, paramInt2);
  }
  
  public void p(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(4, paramObservableBoolean);
    this.M3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x10;
      notifyPropertyChanged(45);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void q(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(9, paramObservableBoolean);
    this.P3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x200;
      notifyPropertyChanged(49);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void r(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(6, paramObservableBoolean);
    this.S3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x40;
      notifyPropertyChanged(50);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void s(@Nullable ObservableBoolean paramObservableBoolean)
  {
    updateRegistration(3, paramObservableBoolean);
    this.Q3 = paramObservableBoolean;
    try
    {
      this.c4 |= 0x8;
      notifyPropertyChanged(52);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (41 == paramInt)
    {
      m((ObservableBoolean)paramObject);
    }
    else if (33 == paramInt)
    {
      i((ObservableBoolean)paramObject);
    }
    else if (38 == paramInt)
    {
      l((ObservableBoolean)paramObject);
    }
    else if (52 == paramInt)
    {
      s((ObservableBoolean)paramObject);
    }
    else if (45 == paramInt)
    {
      p((ObservableBoolean)paramObject);
    }
    else if (44 == paramInt)
    {
      o((ObservableBoolean)paramObject);
    }
    else if (50 == paramInt)
    {
      r((ObservableBoolean)paramObject);
    }
    else if (42 == paramInt)
    {
      n((ObservableBoolean)paramObject);
    }
    else if (85 == paramInt)
    {
      u((ObservableField)paramObject);
    }
    else if (49 == paramInt)
    {
      q((ObservableBoolean)paramObject);
    }
    else if (30 == paramInt)
    {
      h((ObservableBoolean)paramObject);
    }
    else
    {
      if (56 != paramInt) {
        break label206;
      }
      t((Boolean)paramObject);
    }
    boolean bool = true;
    return bool;
    label206:
    bool = false;
    return bool;
  }
  
  public void t(@Nullable Boolean paramBoolean)
  {
    this.U3 = paramBoolean;
    try
    {
      this.c4 |= 0x800;
      notifyPropertyChanged(56);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void u(@Nullable ObservableField<String> paramObservableField)
  {
    updateRegistration(8, paramObservableField);
    this.R3 = paramObservableField;
    try
    {
      this.c4 |= 0x100;
      notifyPropertyChanged(85);
      super.requestRebind();
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ViewVideoSurfaceLayoutBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */