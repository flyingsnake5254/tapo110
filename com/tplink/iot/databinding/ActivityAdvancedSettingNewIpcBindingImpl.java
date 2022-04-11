package com.tplink.iot.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
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
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.AdvancedSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.LdcSettingViewModel;

public class ActivityAdvancedSettingNewIpcBindingImpl
  extends ActivityAdvancedSettingNewIpcBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts d4;
  @Nullable
  private static final SparseIntArray e4;
  @NonNull
  private final RelativeLayout f4;
  @NonNull
  private final LinearLayout g4;
  @NonNull
  private final View h4;
  @NonNull
  private final View i4;
  private long j4 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    e4 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 21);
    localSparseIntArray.put(2131364252, 22);
    localSparseIntArray.put(2131361865, 23);
    localSparseIntArray.put(2131363220, 24);
    localSparseIntArray.put(2131363782, 25);
    localSparseIntArray.put(2131363604, 26);
    localSparseIntArray.put(2131363710, 27);
    localSparseIntArray.put(2131363234, 28);
    localSparseIntArray.put(2131364752, 29);
    localSparseIntArray.put(2131362426, 30);
  }
  
  public ActivityAdvancedSettingNewIpcBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 31, d4, e4));
  }
  
  private ActivityAdvancedSettingNewIpcBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 18, (TextView)paramArrayOfObject[23], (RelativeLayout)paramArrayOfObject[18], (TextView)paramArrayOfObject[19], (CameraLoadingView)paramArrayOfObject[20], (TextView)paramArrayOfObject[16], (RelativeLayout)paramArrayOfObject[15], (TextView)paramArrayOfObject[30], (TextView)paramArrayOfObject[3], (RelativeLayout)paramArrayOfObject[2], (TextView)paramArrayOfObject[24], (TextView)paramArrayOfObject[12], (RelativeLayout)paramArrayOfObject[11], (TextView)paramArrayOfObject[28], (FrameLayout)paramArrayOfObject[7], (TextView)paramArrayOfObject[26], (FrameLayout)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[9], (TextView)paramArrayOfObject[10], (TextView)paramArrayOfObject[27], (RelativeLayout)paramArrayOfObject[4], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[25], (TextView)paramArrayOfObject[22], (Toolbar)paramArrayOfObject[21], (TextView)paramArrayOfObject[14], (RelativeLayout)paramArrayOfObject[13], (TextView)paramArrayOfObject[29]);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.f4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[17];
    this.g4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[6];
    this.h4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[8];
    this.i4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.J3.setTag(null);
    this.L3.setTag(null);
    this.M3.setTag(null);
    this.N3.setTag(null);
    this.P3.setTag(null);
    this.Q3.setTag(null);
    this.U3.setTag(null);
    this.V3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean A(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.j4 |= 0x800;
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
        this.j4 |= 0x2;
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
        this.j4 |= 0x400;
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
        this.j4 |= 0x8;
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
        this.j4 |= 0x200;
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
        this.j4 |= 1L;
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
        this.j4 |= 0x10;
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
        this.j4 |= 0x1000;
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
        this.j4 |= 0x4000;
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
        this.j4 |= 0x8000;
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
        this.j4 |= 0x4;
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
        this.j4 |= 0x2000;
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
        this.j4 |= 0x80;
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
        this.j4 |= 0x40;
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
        this.j4 |= 0x20;
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
        this.j4 |= 0x100;
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
        this.j4 |= 0x10000;
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
        this.j4 |= 0x20000;
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
      long l1 = this.j4;
      this.j4 = 0L;
      View.OnClickListener localOnClickListener = this.c4;
      Object localObject1 = this.Y3;
      Object localObject2 = this.a4;
      LensMaskViewModel localLensMaskViewModel = this.Z3;
      Object localObject3 = this.X3;
      DiagnoseSettingViewModel localDiagnoseSettingViewModel = this.b4;
      Boolean localBoolean = null;
      boolean bool1 = (l1 & 0x1081000) < 0L;
      Object localObject4;
      boolean bool3;
      float f2;
      if (bool1)
      {
        if (localObject1 != null) {
          localObject4 = ((CloudTerraceControlViewModel)localObject1).M3;
        } else {
          localObject4 = null;
        }
        updateLiveDataRegistration(12, (LiveData)localObject4);
        if (localObject4 != null) {
          localObject4 = (Boolean)((LiveData)localObject4).getValue();
        } else {
          localObject4 = null;
        }
        bool3 = ViewDataBinding.safeUnbox((Boolean)localObject4);
        l2 = l1;
        if (bool1)
        {
          if (bool3)
          {
            l2 = l1 | 0x40000000;
            l1 = 68719476736L;
          }
          else
          {
            l2 = l1 | 0x20000000;
            l1 = 34359738368L;
          }
          l2 |= l1;
        }
        if (bool3) {
          f1 = 0.4F;
        } else {
          f1 = 1.0F;
        }
        int i;
        if (bool3)
        {
          localObject4 = this.f.getResources();
          i = 2131952356;
        }
        else
        {
          localObject4 = this.f.getResources();
          i = 2131952351;
        }
        localObject6 = ((Resources)localObject4).getString(i);
        l1 = l2;
        f2 = f1;
        localObject4 = localObject6;
        if ((l2 & 0x1080000) != 0L)
        {
          if (localObject1 != null) {
            bool3 = ((CloudTerraceControlViewModel)localObject1).y();
          } else {
            bool3 = false;
          }
          bool4 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool3)) ^ true;
          break label301;
        }
      }
      else
      {
        localObject4 = null;
        f2 = 0.0F;
      }
      boolean bool4 = false;
      Object localObject6 = localObject4;
      float f1 = f2;
      long l2 = l1;
      label301:
      boolean bool2 = (l2 & 0x1100004) < 0L;
      if (bool2)
      {
        if (localObject2 != null) {
          localObject4 = ((LdcSettingViewModel)localObject2).a;
        } else {
          localObject4 = null;
        }
        updateLiveDataRegistration(2, (LiveData)localObject4);
        if (localObject4 != null) {
          localObject4 = (Boolean)((LiveData)localObject4).getValue();
        } else {
          localObject4 = null;
        }
        bool3 = ViewDataBinding.safeUnbox((Boolean)localObject4);
        l1 = l2;
        if (bool2)
        {
          if (bool3) {
            l1 = 4294967296L;
          } else {
            l1 = 2147483648L;
          }
          l1 = l2 | l1;
        }
        if (bool3)
        {
          localObject4 = this.p0.getResources().getString(2131953847);
          l2 = l1;
        }
        else
        {
          localObject4 = this.p0.getResources().getString(2131953846);
          l2 = l1;
        }
      }
      else
      {
        localObject4 = null;
      }
      bool2 = (l2 & 0x1202000) < 0L;
      if (bool2)
      {
        if (localLensMaskViewModel != null) {
          localObject2 = localLensMaskViewModel.c;
        } else {
          localObject2 = null;
        }
        updateLiveDataRegistration(13, (LiveData)localObject2);
        if (localObject2 != null) {
          localObject2 = (Boolean)((LiveData)localObject2).getValue();
        } else {
          localObject2 = null;
        }
        bool3 = ViewDataBinding.safeUnbox((Boolean)localObject2);
        l1 = l2;
        if (bool2)
        {
          if (bool3) {
            l1 = 1099511627776L;
          } else {
            l1 = 549755813888L;
          }
          l1 = l2 | l1;
        }
        localObject2 = this.N3.getResources();
        if (bool3)
        {
          localObject2 = ((Resources)localObject2).getString(2131953847);
          l2 = l1;
        }
        else
        {
          localObject2 = ((Resources)localObject2).getString(2131953846);
          l2 = l1;
        }
      }
      else
      {
        localObject2 = null;
      }
      Object localObject7;
      label666:
      Object localObject8;
      int j;
      label778:
      label836:
      Object localObject9;
      int k;
      label948:
      int m;
      label1060:
      label1173:
      boolean bool10;
      int i3;
      int i2;
      label1400:
      int i1;
      label1513:
      int i5;
      label1626:
      int i6;
      if ((l2 & 0x16B4FFB) != 0L)
      {
        if ((l2 & 0x1400001) != 0L)
        {
          if (localObject3 != null) {
            localObject7 = ((AdvancedSettingViewModel)localObject3).b;
          } else {
            localObject7 = null;
          }
          updateRegistration(0, (Observable)localObject7);
          if (localObject7 != null)
          {
            localObject7 = (String)((ObservableField)localObject7).get();
            break label666;
          }
        }
        localObject7 = null;
        bool2 = (l2 & 0x1400002) < 0L;
        if (bool2)
        {
          if (localObject3 != null) {
            localObject8 = ((AdvancedSettingViewModel)localObject3).g;
          } else {
            localObject8 = null;
          }
          updateRegistration(1, (Observable)localObject8);
          if (localObject8 != null) {
            bool3 = ((ObservableBoolean)localObject8).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool3) {
              l1 = 70368744177664L;
            } else {
              l1 = 35184372088832L;
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
            l2 = l1;
            break label778;
          }
        }
        j = 0;
        if ((l2 & 0x1400008) != 0L)
        {
          if (localObject3 != null) {
            localObject8 = ((AdvancedSettingViewModel)localObject3).c;
          } else {
            localObject8 = null;
          }
          updateRegistration(3, (Observable)localObject8);
          if (localObject8 != null)
          {
            localObject8 = (String)((ObservableField)localObject8).get();
            break label836;
          }
        }
        localObject8 = null;
        boolean bool5 = (l2 & 0x1400010) < 0L;
        if (bool5)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).i;
          } else {
            localObject9 = null;
          }
          updateRegistration(4, (Observable)localObject9);
          if (localObject9 != null) {
            bool3 = ((ObservableBoolean)localObject9).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool5)
          {
            if (bool3) {
              l1 = 18014398509481984L;
            } else {
              l1 = 9007199254740992L;
            }
            l1 = l2 | l1;
          }
          if (bool3)
          {
            l2 = l1;
          }
          else
          {
            k = 8;
            l2 = l1;
            break label948;
          }
        }
        k = 0;
        boolean bool6 = (l2 & 0x1400020) < 0L;
        if (bool6)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).l;
          } else {
            localObject9 = null;
          }
          updateRegistration(5, (Observable)localObject9);
          if (localObject9 != null) {
            bool3 = ((ObservableBoolean)localObject9).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool6)
          {
            if (bool3) {
              l1 = 17592186044416L;
            } else {
              l1 = 8796093022208L;
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
            break label1060;
          }
        }
        m = 0;
        boolean bool7 = (l2 & 0x1400040) < 0L;
        if (bool7)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).f;
          } else {
            localObject9 = null;
          }
          updateRegistration(6, (Observable)localObject9);
          if (localObject9 != null) {
            bool3 = ((ObservableBoolean)localObject9).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool7)
          {
            if (bool3) {
              l1 = 4398046511104L;
            } else {
              l1 = 2199023255552L;
            }
            l1 = l2 | l1;
          }
          if (bool3)
          {
            l2 = l1;
          }
          else
          {
            n = 8;
            break label1173;
          }
        }
        int n = 0;
        l1 = l2;
        boolean bool9 = (l1 & 0x1684180) < 0L;
        if (bool9)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).e;
          } else {
            localObject9 = null;
          }
          updateRegistration(8, (Observable)localObject9);
          if (localObject9 != null) {
            bool10 = ((ObservableBoolean)localObject9).get();
          } else {
            bool10 = false;
          }
          l2 = l1;
          bool3 = bool10;
          if (bool9) {
            if (bool10)
            {
              l2 = l1 | 0x1000000000000;
              bool3 = bool10;
            }
            else
            {
              l2 = l1 | 0x800000000000;
              bool3 = bool10;
            }
          }
        }
        else
        {
          bool3 = false;
          l2 = l1;
        }
        i3 = n;
        boolean bool8 = (l2 & 0x1400200) < 0L;
        if (bool8)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).m;
          } else {
            localObject9 = null;
          }
          updateRegistration(9, (Observable)localObject9);
          if (localObject9 != null) {
            bool10 = ((ObservableBoolean)localObject9).get();
          } else {
            bool10 = false;
          }
          l1 = l2;
          if (bool8)
          {
            if (bool10) {
              l1 = 268435456L;
            } else {
              l1 = 134217728L;
            }
            l1 = l2 | l1;
          }
          if (bool10)
          {
            l2 = l1;
          }
          else
          {
            i2 = 8;
            l2 = l1;
            break label1400;
          }
        }
        i2 = 0;
        bool8 = (l2 & 0x1400400) < 0L;
        if (bool8)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).j;
          } else {
            localObject9 = null;
          }
          updateRegistration(10, (Observable)localObject9);
          if (localObject9 != null) {
            bool10 = ((ObservableBoolean)localObject9).get();
          } else {
            bool10 = false;
          }
          l1 = l2;
          if (bool8)
          {
            if (bool10) {
              l1 = 67108864L;
            } else {
              l1 = 33554432L;
            }
            l1 = l2 | l1;
          }
          if (bool10)
          {
            l2 = l1;
          }
          else
          {
            i1 = 8;
            l2 = l1;
            break label1513;
          }
        }
        i1 = 0;
        boolean bool11 = (l2 & 0x1400800) < 0L;
        if (bool11)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).h;
          } else {
            localObject9 = null;
          }
          updateRegistration(11, (Observable)localObject9);
          if (localObject9 != null) {
            bool10 = ((ObservableBoolean)localObject9).get();
          } else {
            bool10 = false;
          }
          l1 = l2;
          if (bool11)
          {
            if (bool10) {
              l1 = 17179869184L;
            } else {
              l1 = 8589934592L;
            }
            l1 = l2 | l1;
          }
          if (bool10)
          {
            l2 = l1;
          }
          else
          {
            i5 = 8;
            l2 = l1;
            break label1626;
          }
        }
        i5 = 0;
        boolean bool12 = (l2 & 0x1410000) < 0L;
        if (bool12)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).k;
          } else {
            localObject9 = null;
          }
          updateRegistration(16, (Observable)localObject9);
          if (localObject9 != null) {
            bool10 = ((ObservableBoolean)localObject9).get();
          } else {
            bool10 = false;
          }
          l1 = l2;
          if (bool12)
          {
            if (bool10) {
              l1 = 274877906944L;
            } else {
              l1 = 137438953472L;
            }
            l1 = l2 | l1;
          }
          if (bool10)
          {
            l2 = l1;
          }
          else
          {
            i6 = 8;
            l2 = l1;
            break label1739;
          }
        }
        i6 = 0;
        label1739:
        if ((0x1420000 & l2) != 0L)
        {
          if (localObject3 != null) {
            localObject9 = ((AdvancedSettingViewModel)localObject3).a;
          } else {
            localObject9 = null;
          }
          updateRegistration(17, (Observable)localObject9);
          if (localObject9 != null)
          {
            localObject9 = (String)((ObservableField)localObject9).get();
            break label1798;
          }
        }
        localObject9 = null;
        label1798:
        int i7 = j;
        localObject3 = localObject7;
        j = k;
        k = m;
        int i9 = i2;
        i2 = i5;
        m = i6;
        i5 = k;
        k = i2;
        i2 = i1;
        i1 = i9;
        bool10 = bool3;
        i6 = i7;
        localObject7 = localObject8;
        localObject8 = localObject3;
      }
      else
      {
        localObject9 = null;
        localObject7 = localObject9;
        localObject8 = localObject7;
        m = 0;
        i5 = 0;
        k = 0;
        i2 = 0;
        i1 = 0;
        bool10 = false;
        i6 = 0;
        i3 = 0;
        j = 0;
      }
      boolean bool13 = (l2 & 0x1808000) < 0L;
      if (bool13)
      {
        if (localDiagnoseSettingViewModel != null) {
          localObject3 = localDiagnoseSettingViewModel.a;
        } else {
          localObject3 = null;
        }
        updateLiveDataRegistration(15, (LiveData)localObject3);
        if (localObject3 != null) {
          localObject3 = (Boolean)((LiveData)localObject3).getValue();
        } else {
          localObject3 = null;
        }
        bool3 = ViewDataBinding.safeUnbox((Boolean)localObject3);
        l1 = l2;
        if (bool13)
        {
          if (bool3) {
            l1 = 1125899906842624L;
          } else {
            l1 = 562949953421312L;
          }
          l1 = l2 | l1;
        }
        int i8;
        if (bool3)
        {
          localObject3 = this.x.getResources();
          i8 = 2131953847;
        }
        else
        {
          localObject3 = this.x.getResources();
          i8 = 2131953846;
        }
        localObject3 = ((Resources)localObject3).getString(i8);
      }
      else
      {
        localObject3 = null;
        l1 = l2;
      }
      if ((l1 & 0x800000000000) != 0L)
      {
        if (localObject1 != null) {
          localObject1 = ((CloudTerraceControlViewModel)localObject1).P3;
        } else {
          localObject1 = null;
        }
        updateLiveDataRegistration(14, (LiveData)localObject1);
        if (localObject1 != null) {
          localObject1 = (Boolean)((LiveData)localObject1).getValue();
        } else {
          localObject1 = null;
        }
        bool3 = ViewDataBinding.safeUnbox((Boolean)localObject1);
      }
      else
      {
        bool3 = false;
      }
      boolean bool14 = (l1 & 0x1684180) < 0L;
      if (bool14)
      {
        if (bool10) {
          bool3 = true;
        }
        l2 = l1;
        bool10 = bool3;
        if (bool14) {
          if (bool3)
          {
            l2 = l1 | 0x10000000000000;
            bool10 = bool3;
          }
          else
          {
            l2 = l1 | 0x8000000000000;
            bool10 = bool3;
          }
        }
      }
      else
      {
        bool10 = false;
        l2 = l1;
      }
      if ((l2 & 0x8000000000000) != 0L)
      {
        if (localLensMaskViewModel != null) {
          localObject1 = localLensMaskViewModel.d;
        } else {
          localObject1 = null;
        }
        updateLiveDataRegistration(7, (LiveData)localObject1);
        if (localObject1 != null) {
          localBoolean = (Boolean)((LiveData)localObject1).getValue();
        }
        bool3 = ViewDataBinding.safeUnbox(localBoolean);
      }
      else
      {
        bool3 = false;
      }
      bool14 = (l2 & 0x1684180) < 0L;
      if (bool14)
      {
        if (bool10) {
          bool3 = true;
        }
      }
      else {
        bool3 = false;
      }
      if ((l2 & 0x1040000) != 0L)
      {
        this.d.setOnClickListener(localOnClickListener);
        this.y.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
        this.H3.setOnClickListener(localOnClickListener);
        this.J3.setOnClickListener(localOnClickListener);
        this.L3.setOnClickListener(localOnClickListener);
        this.M3.setOnClickListener(localOnClickListener);
        this.P3.setOnClickListener(localOnClickListener);
        this.V3.setOnClickListener(localOnClickListener);
      }
      if ((l2 & 0x1080000) != 0L) {
        this.d.setEnabled(bool4);
      }
      if ((0x1081000 & l2) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.f.setAlpha(f1);
        }
        TextViewBindingAdapter.setText(this.f, (CharSequence)localObject6);
      }
      if (bool14) {
        b.K(this.q, Boolean.valueOf(bool3));
      }
      if ((l2 & 0x1808000) != 0L) {
        TextViewBindingAdapter.setText(this.x, (CharSequence)localObject3);
      }
      if ((l2 & 0x1400020) != 0L) {
        this.y.setVisibility(i5);
      }
      if ((l2 & 0x1100004) != 0L) {
        TextViewBindingAdapter.setText(this.p0, (CharSequence)localObject4);
      }
      if ((0x1410000 & l2) != 0L) {
        this.p1.setVisibility(m);
      }
      if ((0x1420000 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.p3, (CharSequence)localObject9);
      }
      if ((0x1400800 & l2) != 0L) {
        this.H3.setVisibility(k);
      }
      if ((0x1400400 & l2) != 0L) {
        this.g4.setVisibility(i2);
      }
      if ((l2 & 0x1400200) != 0L)
      {
        this.h4.setVisibility(i1);
        this.P3.setVisibility(i1);
      }
      if ((l2 & 0x1400002) != 0L)
      {
        this.i4.setVisibility(i6);
        this.J3.setVisibility(i6);
      }
      if ((l2 & 0x1400040) != 0L) {
        this.L3.setVisibility(i3);
      }
      if ((l2 & 0x1202000) != 0L) {
        TextViewBindingAdapter.setText(this.N3, (CharSequence)localObject2);
      }
      if ((l2 & 0x1400008) != 0L) {
        TextViewBindingAdapter.setText(this.Q3, (CharSequence)localObject7);
      }
      if ((l2 & 0x1400001) != 0L) {
        TextViewBindingAdapter.setText(this.U3, (CharSequence)localObject8);
      }
      if ((l2 & 0x1400010) != 0L) {
        this.V3.setVisibility(j);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.c4 = paramOnClickListener;
    try
    {
      this.j4 |= 0x40000;
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
      return this.j4 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable CloudTerraceControlViewModel paramCloudTerraceControlViewModel)
  {
    this.Y3 = paramCloudTerraceControlViewModel;
    try
    {
      this.j4 |= 0x80000;
      notifyPropertyChanged(11);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.j4 = 16777216L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable DiagnoseSettingViewModel paramDiagnoseSettingViewModel)
  {
    this.b4 = paramDiagnoseSettingViewModel;
    try
    {
      this.j4 |= 0x800000;
      notifyPropertyChanged(18);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable LdcSettingViewModel paramLdcSettingViewModel)
  {
    this.a4 = paramLdcSettingViewModel;
    try
    {
      this.j4 |= 0x100000;
      notifyPropertyChanged(53);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable LensMaskViewModel paramLensMaskViewModel)
  {
    this.Z3 = paramLensMaskViewModel;
    try
    {
      this.j4 |= 0x200000;
      notifyPropertyChanged(54);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void o(@Nullable AdvancedSettingViewModel paramAdvancedSettingViewModel)
  {
    this.X3 = paramAdvancedSettingViewModel;
    try
    {
      this.j4 |= 0x400000;
      notifyPropertyChanged(90);
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
    case 17: 
      return z((ObservableField)paramObject, paramInt2);
    case 16: 
      return y((ObservableBoolean)paramObject, paramInt2);
    case 15: 
      return r((MutableLiveData)paramObject, paramInt2);
    case 14: 
      return q((MutableLiveData)paramObject, paramInt2);
    case 13: 
      return t((MutableLiveData)paramObject, paramInt2);
    case 12: 
      return p((MutableLiveData)paramObject, paramInt2);
    case 11: 
      return A((ObservableBoolean)paramObject, paramInt2);
    case 10: 
      return C((ObservableBoolean)paramObject, paramInt2);
    case 9: 
      return E((ObservableBoolean)paramObject, paramInt2);
    case 8: 
      return x((ObservableBoolean)paramObject, paramInt2);
    case 7: 
      return u((MutableLiveData)paramObject, paramInt2);
    case 6: 
      return v((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return w((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return G((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return D((ObservableField)paramObject, paramInt2);
    case 2: 
      return s((MutableLiveData)paramObject, paramInt2);
    case 1: 
      return B((ObservableBoolean)paramObject, paramInt2);
    }
    return F((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else if (11 == paramInt)
    {
      i((CloudTerraceControlViewModel)paramObject);
    }
    else if (53 == paramInt)
    {
      m((LdcSettingViewModel)paramObject);
    }
    else if (54 == paramInt)
    {
      n((LensMaskViewModel)paramObject);
    }
    else if (90 == paramInt)
    {
      o((AdvancedSettingViewModel)paramObject);
    }
    else
    {
      if (18 != paramInt) {
        break label103;
      }
      l((DiagnoseSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label103:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAdvancedSettingNewIpcBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */