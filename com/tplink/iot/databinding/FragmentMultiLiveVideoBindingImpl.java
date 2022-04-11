package com.tplink.iot.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public class FragmentMultiLiveVideoBindingImpl
  extends FragmentMultiLiveVideoBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts M3;
  @Nullable
  private static final SparseIntArray N3;
  @NonNull
  private final RelativeLayout O3;
  @NonNull
  private final View P3;
  @NonNull
  private final TextView Q3;
  @NonNull
  private final RelativeLayout R3;
  @Nullable
  private final View.OnClickListener S3;
  private long T3 = -1L;
  private long U3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(15);
    M3 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(0, new String[] { "layout_multi_live_toolbar_bottom", "layout_full_screen_control", "layout_day_night_mode", "layout_full_screen_quality", "layout_full_screen_bottom_bar", "layout_voice_talk_panel" }, new int[] { 7, 8, 9, 10, 11, 12 }, new int[] { 2131559181, 2131559155, 2131559120, 2131559156, 2131559154, 2131559244 });
    localObject = new SparseIntArray();
    N3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131363252, 13);
    ((SparseIntArray)localObject).put(2131364248, 14);
  }
  
  public FragmentMultiLiveVideoBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 15, M3, N3));
  }
  
  private FragmentMultiLiveVideoBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 20, (ImageView)paramArrayOfObject[5], (LayoutFullScreenBottomBarBinding)paramArrayOfObject[11], (LayoutFullScreenControlBinding)paramArrayOfObject[8], (LayoutDayNightModeBinding)paramArrayOfObject[9], (LayoutFullScreenQualityBinding)paramArrayOfObject[10], (LayoutVoiceTalkPanelBinding)paramArrayOfObject[12], (RecyclerView)paramArrayOfObject[13], (TextView)paramArrayOfObject[1], (CloudTerraceControlPanel)paramArrayOfObject[6], (TipsBar)paramArrayOfObject[14], (LayoutMultiLiveToolbarBottomBinding)paramArrayOfObject[7]);
    this.c.setTag(null);
    setContainedBinding(this.d);
    setContainedBinding(this.f);
    setContainedBinding(this.q);
    setContainedBinding(this.x);
    setContainedBinding(this.y);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[2];
    this.P3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.Q3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[4];
    this.R3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    setContainedBinding(this.p3);
    setRootTag(paramView);
    this.S3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean A(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x2;
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
        this.T3 |= 1L;
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
        this.T3 |= 0x4000;
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
        this.T3 |= 0x40;
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
        this.T3 |= 0x800;
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
        this.T3 |= 0x40000;
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
        this.T3 |= 0x200;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean H(LayoutMultiLiveToolbarBottomBinding paramLayoutMultiLiveToolbarBottomBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x10000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(LayoutFullScreenBottomBarBinding paramLayoutFullScreenBottomBarBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x80000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(LayoutFullScreenControlBinding paramLayoutFullScreenControlBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x1000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(LayoutDayNightModeBinding paramLayoutDayNightModeBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(LayoutFullScreenQualityBinding paramLayoutFullScreenQualityBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x2000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(LayoutVoiceTalkPanelBinding paramLayoutVoiceTalkPanelBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x400;
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
        this.T3 |= 0x80;
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
        this.T3 |= 0x8000;
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
        this.T3 |= 0x8;
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
        this.T3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean x(MutableLiveData<String> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.T3 |= 0x20000;
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
        this.T3 |= 0x10;
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
        this.T3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.H3;
    if (localg != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      localg.onClick(paramView);
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.T3;
      this.T3 = 0L;
      long l2 = this.U3;
      this.U3 = 0L;
      VideoPlayViewModel localVideoPlayViewModel = this.I3;
      g localg = this.H3;
      TalkViewModel localTalkViewModel = this.J3;
      MultiLiveVideoViewModel localMultiLiveVideoViewModel = this.K3;
      boolean bool4;
      Object localObject3;
      long l5;
      int m;
      label284:
      label293:
      Object localObject4;
      boolean bool8;
      label431:
      int i2;
      boolean bool9;
      Object localObject5;
      boolean bool10;
      if ((0x2D288BF & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x290001A) < 0L;
        long l4;
        if (bool1)
        {
          if (localVideoPlayViewModel != null) {
            localObject1 = localVideoPlayViewModel.G;
          } else {
            localObject1 = null;
          }
          updateRegistration(4, (Observable)localObject1);
          if (localObject1 != null) {
            bool4 = ((ObservableBoolean)localObject1).get();
          } else {
            bool4 = false;
          }
          l3 = l1;
          if (bool1) {
            if (bool4) {
              l3 = l1 | 0x800000000;
            } else {
              l3 = l1 | 0x400000000;
            }
          }
          bool1 = (l3 & 0x2100010) < 0L;
          l1 = l2;
          if (bool1) {
            if (bool4) {
              l1 = l2 | 0x2 | 0x8000;
            } else {
              l1 = l2 | 1L | 0x4000;
            }
          }
          l4 = l3;
          l2 = l1;
          localObject3 = localObject1;
          bool5 = bool4;
          if (bool1)
          {
            int i;
            if (bool4) {
              i = 14;
            } else {
              i = 12;
            }
            l2 = l3;
            l5 = l1;
            localObject3 = localObject1;
            bool5 = bool4;
            m = i;
            if (!bool4) {
              break label284;
            }
            n = 8;
            localObject3 = localObject1;
            bool5 = bool4;
            m = i;
            break label293;
          }
        }
        else
        {
          localObject3 = null;
          bool5 = false;
          l4 = l1;
        }
        m = 0;
        l5 = l2;
        l2 = l4;
        int n = 0;
        l1 = l5;
        l3 = l2;
        bool2 = (l3 & 0x2500830) < 0L;
        if (bool2)
        {
          if (localVideoPlayViewModel != null) {
            localObject1 = localVideoPlayViewModel.D;
          } else {
            localObject1 = null;
          }
          updateRegistration(5, (Observable)localObject1);
          if (localObject1 != null) {
            bool4 = ((ObservableBoolean)localObject1).get();
          } else {
            bool4 = false;
          }
          l2 = l3;
          if (bool2)
          {
            if (bool4) {
              l2 = 134217728L;
            } else {
              l2 = 67108864L;
            }
            l2 = l3 | l2;
          }
          l3 = l2;
          localObject4 = localObject1;
          bool7 = bool4;
          if ((l2 & 0x2100020) != 0L)
          {
            bool8 = bool4 ^ true;
            l3 = l2;
            bool7 = bool4;
            break label431;
          }
        }
        else
        {
          localObject4 = null;
          bool7 = false;
        }
        bool8 = false;
        localObject1 = localObject4;
        if ((l3 & 0x2D28095) != 0L)
        {
          if (localVideoPlayViewModel != null) {
            localObject4 = localVideoPlayViewModel.k;
          } else {
            localObject4 = null;
          }
          updateLiveDataRegistration(17, (LiveData)localObject4);
          if (localObject4 != null) {
            localObject4 = (String)((LiveData)localObject4).getValue();
          } else {
            localObject4 = null;
          }
          i2 = (l3 & 0x2D28091) < 0L;
          if (i2 != 0)
          {
            if (localObject4 != null) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            l2 = l1;
            bool9 = bool2;
            if (i2 != 0)
            {
              if (bool2) {
                l2 = 2048L;
              } else {
                l2 = 1024L;
              }
              l2 = l1 | l2;
              bool9 = bool2;
            }
          }
          else
          {
            bool9 = false;
            l2 = l1;
          }
          i2 = (l3 & 0x2920014) < 0L;
          if (i2 != 0)
          {
            if (localObject4 == null) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            l1 = l3;
            if (i2 != 0)
            {
              if (bool2) {
                l1 = 2199023255552L;
              } else {
                l1 = 1099511627776L;
              }
              l1 = l3 | l1;
            }
            l3 = l1;
            l1 = l2;
          }
          else
          {
            bool2 = false;
            l1 = l2;
          }
        }
        else
        {
          bool2 = false;
          bool9 = false;
        }
        l2 = l3;
        l3 = l1;
        i2 = n;
        bool4 = bool5;
        localObject5 = localObject1;
        bool10 = bool8;
        localObject1 = localObject3;
      }
      else
      {
        bool2 = false;
        m = 0;
        i2 = 0;
        bool4 = false;
        bool9 = false;
        localObject5 = null;
        bool7 = false;
        bool10 = false;
        localObject1 = null;
        l3 = l2;
        l2 = l1;
      }
      if ((l2 & 0x2544A50) != 0L)
      {
        bool6 = (l2 & 0x2500810) < 0L;
        if (bool6)
        {
          if (localTalkViewModel != null) {
            localObject4 = localTalkViewModel.k;
          } else {
            localObject4 = null;
          }
          updateRegistration(11, (Observable)localObject4);
          if (localObject4 != null) {
            bool5 = ((ObservableBoolean)localObject4).get();
          } else {
            bool5 = false;
          }
          l1 = l2;
          localObject3 = localObject4;
          bool11 = bool5;
          if (bool6)
          {
            if (bool5) {
              l1 = 576460752303423488L;
            } else {
              l1 = 288230376151711744L;
            }
            l1 = l2 | l1;
            localObject3 = localObject4;
            bool11 = bool5;
          }
        }
        else
        {
          localObject3 = null;
          bool11 = false;
          l1 = l2;
        }
        bool6 = (l1 & 0x2444240) < 0L;
        if (bool6)
        {
          if (localTalkViewModel != null) {
            localObject4 = localTalkViewModel.j;
          } else {
            localObject4 = null;
          }
          updateRegistration(14, (Observable)localObject4);
          if (localObject4 != null) {
            bool5 = ((ObservableBoolean)localObject4).get();
          } else {
            bool5 = false;
          }
          l2 = l3;
          if (bool6)
          {
            if (bool5) {
              l2 = 8L;
            } else {
              l2 = 4L;
            }
            l2 = l3 | l2;
          }
          l3 = l1;
          l1 = l2;
          bool8 = bool5;
        }
        else
        {
          l2 = l3;
          bool8 = false;
          l3 = l1;
          l1 = l2;
        }
      }
      else
      {
        bool8 = false;
        localObject3 = null;
        bool11 = false;
        l1 = l3;
        l3 = l2;
      }
      boolean bool6 = (l3 & 0x29080B4) < 0L;
      boolean bool12;
      if (bool6)
      {
        if (localMultiLiveVideoViewModel != null) {
          localObject6 = localMultiLiveVideoViewModel.J3;
        } else {
          localObject6 = null;
        }
        updateRegistration(2, (Observable)localObject6);
        if (localObject6 != null) {
          bool12 = ((ObservableBoolean)localObject6).get();
        } else {
          bool12 = false;
        }
        l2 = l3;
        if (bool6)
        {
          if (bool12) {
            l2 = 144115188075855872L;
          } else {
            l2 = 72057594037927936L;
          }
          l2 = l3 | l2;
        }
        l3 = l2;
        localObject4 = localObject6;
        bool5 = bool12;
        l5 = l1;
        if ((l2 & 0x2900014) != 0L)
        {
          if (bool12) {
            l3 = 128L;
          } else {
            l3 = 64L;
          }
          l5 = l1 | l3;
          l3 = l2;
          localObject4 = localObject6;
          bool5 = bool12;
        }
      }
      else
      {
        localObject4 = null;
        bool5 = false;
        l5 = l1;
      }
      if ((l5 & 0x800) != 0L)
      {
        if (localVideoPlayViewModel != null) {
          localObject6 = localVideoPlayViewModel.G;
        } else {
          localObject6 = localObject1;
        }
        updateRegistration(4, (Observable)localObject6);
        if (localObject6 != null) {
          bool12 = ((ObservableBoolean)localObject6).get();
        } else {
          bool12 = bool4;
        }
        l2 = l3;
        if ((l3 & 0x290001A) != 0L) {
          if (bool12) {
            l2 = l3 | 0x800000000;
          } else {
            l2 = l3 | 0x400000000;
          }
        }
        l3 = l2;
        localObject1 = localObject6;
        bool4 = bool12;
        l1 = l5;
        if ((l2 & 0x2100010) != 0L) {
          if (bool12)
          {
            l1 = l5 | 0x2 | 0x8000;
            l3 = l2;
            localObject1 = localObject6;
            bool4 = bool12;
          }
          else
          {
            l1 = l5 | 1L | 0x4000;
            l3 = l2;
            localObject1 = localObject6;
            bool4 = bool12;
          }
        }
      }
      else
      {
        l1 = l5;
      }
      bool6 = (l1 & 0x8) < 0L;
      boolean bool13;
      if (bool6)
      {
        if (localTalkViewModel != null) {
          localObject6 = localTalkViewModel.m;
        } else {
          localObject6 = null;
        }
        updateRegistration(18, (Observable)localObject6);
        if (localObject6 != null) {
          bool12 = ((ObservableBoolean)localObject6).get();
        } else {
          bool12 = false;
        }
        bool13 = bool12;
        l5 = l1;
        if (bool6)
        {
          if (bool12) {
            l2 = 32L;
          } else {
            l2 = 16L;
          }
          l5 = l1 | l2;
          bool13 = bool12;
        }
      }
      else
      {
        bool13 = false;
        l5 = l1;
      }
      if ((l3 & 0x10000000000) != 0L)
      {
        if (localMultiLiveVideoViewModel != null) {
          localObject4 = localMultiLiveVideoViewModel.J3;
        }
        updateRegistration(2, (Observable)localObject4);
        if (localObject4 != null) {
          bool12 = ((ObservableBoolean)localObject4).get();
        } else {
          bool12 = bool5;
        }
        l1 = l3;
        if ((l3 & 0x29080B4) != 0L)
        {
          if (bool12) {
            l1 = 144115188075855872L;
          } else {
            l1 = 72057594037927936L;
          }
          l1 = l3 | l1;
        }
        l3 = l1;
        bool5 = bool12;
        l2 = l5;
        if ((l1 & 0x2900014) != 0L)
        {
          if (bool12) {
            l3 = 128L;
          } else {
            l3 = 64L;
          }
          l2 = l5 | l3;
          l3 = l1;
          bool5 = bool12;
        }
      }
      else
      {
        l2 = l5;
      }
      bool6 = (l3 & 0x2920014) < 0L;
      if (bool6)
      {
        if (bool2) {
          bool12 = true;
        } else {
          bool12 = bool5;
        }
        l5 = l3;
        bool14 = bool12;
        if (bool6)
        {
          if (bool12) {
            l1 = 8589934592L;
          } else {
            l1 = 4294967296L;
          }
          l5 = l3 | l1;
          bool14 = bool12;
        }
      }
      else
      {
        bool14 = false;
        l5 = l3;
      }
      boolean bool2 = (l5 & 0x2D28091) < 0L;
      boolean bool15;
      if (bool2)
      {
        if (bool9) {
          bool12 = bool4;
        } else {
          bool12 = false;
        }
        l1 = l5;
        bool15 = bool12;
        if (bool2)
        {
          if (bool12) {
            l3 = 36028797018963968L;
          } else {
            l3 = 18014398509481984L;
          }
          l1 = l5 | l3;
          bool15 = bool12;
        }
      }
      else
      {
        bool15 = false;
        l1 = l5;
      }
      if (((l1 & 0x200000000) == 0L) && ((l2 & 0x80) == 0L))
      {
        l5 = l1;
        localObject4 = localObject1;
        l1 = l2;
      }
      else
      {
        if (localVideoPlayViewModel != null) {
          localObject1 = localVideoPlayViewModel.G;
        }
        updateRegistration(4, (Observable)localObject1);
        if (localObject1 != null) {
          bool12 = ((ObservableBoolean)localObject1).get();
        } else {
          bool12 = bool4;
        }
        l3 = l1;
        if ((l1 & 0x290001A) != 0L) {
          if (bool12) {
            l3 = l1 | 0x800000000;
          } else {
            l3 = l1 | 0x400000000;
          }
        }
        l5 = l3;
        localObject4 = localObject1;
        bool4 = bool12;
        l1 = l2;
        if ((l3 & 0x2100010) != 0L) {
          if (bool12)
          {
            l1 = l2 | 0x2 | 0x8000;
            l5 = l3;
            localObject4 = localObject1;
            bool4 = bool12;
          }
          else
          {
            l1 = l2 | 1L | 0x4000;
            bool4 = bool12;
            localObject4 = localObject1;
            l5 = l3;
          }
        }
      }
      if ((l5 & 0x200000000000000) != 0L)
      {
        if (localVideoPlayViewModel != null) {
          localObject1 = localVideoPlayViewModel.D;
        } else {
          localObject1 = localObject5;
        }
        updateRegistration(5, (Observable)localObject1);
        if (localObject1 != null) {
          bool7 = ((ObservableBoolean)localObject1).get();
        }
        l3 = l5;
        bool12 = bool7;
        if ((l5 & 0x2500830) != 0L)
        {
          if (bool7) {
            l3 = 134217728L;
          } else {
            l3 = 67108864L;
          }
          l3 = l5 | l3;
          bool12 = bool7;
        }
      }
      else
      {
        bool12 = bool7;
        l3 = l5;
      }
      if ((l1 & 0x30) != 0L)
      {
        bool2 = (l1 & 0x10) < 0L;
        if (bool2)
        {
          if (localTalkViewModel != null) {
            localObject1 = localTalkViewModel.l;
          } else {
            localObject1 = null;
          }
          updateRegistration(6, (Observable)localObject1);
          if (localObject1 != null) {
            bool7 = ((ObservableBoolean)localObject1).get();
          } else {
            bool7 = false;
          }
          l2 = l3;
          if (bool2)
          {
            if (bool7) {
              l2 = 9007199254740992L;
            } else {
              l2 = 4503599627370496L;
            }
            l2 = l3 | l2;
          }
          if (bool7)
          {
            localObject1 = this.Q3.getResources();
            j = 2131954452;
          }
          else
          {
            localObject1 = this.Q3.getResources();
            j = 2131954451;
          }
          localObject1 = ((Resources)localObject1).getString(j);
          l3 = l2;
        }
        else
        {
          localObject1 = null;
        }
        l2 = l3;
        localObject5 = localObject1;
        if ((l1 & 0x20) != 0L)
        {
          if (localTalkViewModel != null) {
            localObject6 = localTalkViewModel.g;
          } else {
            localObject6 = null;
          }
          updateRegistration(9, (Observable)localObject6);
          l2 = l3;
          localObject5 = localObject1;
          if (localObject6 != null)
          {
            localObject6 = (String)((ObservableField)localObject6).get();
            break label2231;
          }
        }
      }
      else
      {
        localObject5 = null;
        l2 = l3;
      }
      Object localObject6 = null;
      Object localObject1 = localObject5;
      long l3 = l2;
      label2231:
      if ((l3 & 0x80000000000000) != 0L)
      {
        if (localMultiLiveVideoViewModel != null) {
          localObject5 = localMultiLiveVideoViewModel.Q3;
        } else {
          localObject5 = null;
        }
        updateRegistration(7, (Observable)localObject5);
        if (localObject5 != null) {
          bool7 = ((ObservableBoolean)localObject5).get();
        } else {
          bool7 = false;
        }
        j = bool7 ^ true;
      }
      else
      {
        bool7 = false;
        localObject5 = null;
        j = 0;
      }
      bool6 = (l3 & 0x2920014) < 0L;
      l2 = l3;
      if (bool6)
      {
        if (bool14) {
          bool14 = bool4;
        } else {
          bool14 = false;
        }
        l2 = l3;
        if (bool6)
        {
          if (bool14) {
            l2 = 536870912L;
          } else {
            l2 = 268435456L;
          }
          l2 = l3 | l2;
        }
        if (!bool14)
        {
          i3 = 8;
          break label2385;
        }
      }
      int i3 = 0;
      label2385:
      boolean bool16 = (l2 & 0x2D28091) < 0L;
      if (bool16)
      {
        if (!bool15) {
          j = 0;
        }
        l3 = l2;
        bool6 = j;
        if (bool16)
        {
          if (j != 0) {
            l3 = 35184372088832L;
          } else {
            l3 = 17592186044416L;
          }
          l3 = l2 | l3;
          bool6 = j;
        }
      }
      else
      {
        bool6 = false;
        l3 = l2;
      }
      if ((l3 & 0x29080B4) != 0L)
      {
        if (bool5) {
          bool14 = bool12;
        } else {
          bool14 = false;
        }
        l2 = l3;
        if ((l3 & 0x2908034) != 0L)
        {
          if (bool14) {
            l2 = 8796093022208L;
          } else {
            l2 = 4398046511104L;
          }
          l2 = l3 | l2;
        }
        l3 = l2;
        bool15 = bool14;
        if ((l2 & 0x29000B4) != 0L)
        {
          if (bool14) {
            l3 = 2251799813685248L;
          } else {
            l3 = 1125899906842624L;
          }
          l3 = l2 | l3;
          bool15 = bool14;
        }
      }
      else
      {
        bool15 = false;
      }
      if ((l1 & 0x8) != 0L)
      {
        if (bool13) {
          localObject1 = localObject6;
        }
      }
      else {
        localObject1 = null;
      }
      if (((l3 & 0x2900014) != 0L) && (bool5)) {
        bool13 = bool4;
      } else {
        bool13 = false;
      }
      if ((l3 & 0x2444240) != 0L)
      {
        if (!bool8) {
          localObject1 = this.Q3.getResources().getString(2131954116);
        }
      }
      else {
        localObject1 = null;
      }
      if ((l3 & 0x8000000) != 0L)
      {
        if (localTalkViewModel != null) {
          localObject3 = localTalkViewModel.k;
        }
        updateRegistration(11, (Observable)localObject3);
        if (localObject3 != null) {
          bool5 = ((ObservableBoolean)localObject3).get();
        } else {
          bool5 = bool11;
        }
        l2 = l3;
        bool8 = bool5;
        if ((l3 & 0x2500810) != 0L)
        {
          if (bool5) {
            l2 = 576460752303423488L;
          } else {
            l2 = 288230376151711744L;
          }
          l2 = l3 | l2;
          bool8 = bool5;
        }
      }
      else
      {
        bool8 = bool11;
        l2 = l3;
      }
      boolean bool5 = bool7;
      if ((l2 & 0x8280000000000) != 0L)
      {
        bool5 = bool7;
        if ((l2 & 0x8000000000000) != 0L)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject5 = localMultiLiveVideoViewModel.Q3;
          }
          updateRegistration(7, (Observable)localObject5);
          bool5 = bool7;
          if (localObject5 != null) {
            bool5 = ((ObservableBoolean)localObject5).get();
          }
        }
        if ((0x280000000000 & l2) != 0L)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject3 = localMultiLiveVideoViewModel.a4;
          } else {
            localObject3 = null;
          }
          updateRegistration(15, (Observable)localObject3);
          if (localObject3 != null) {
            bool7 = ((ObservableBoolean)localObject3).get();
          } else {
            bool7 = false;
          }
          bool11 = bool5;
          bool14 = bool7;
          if ((l2 & 0x200000000000) == 0L) {
            break label2923;
          }
          j = bool7 ^ true;
          break label2934;
        }
      }
      boolean bool14 = false;
      boolean bool11 = bool5;
      label2923:
      int j = 0;
      boolean bool7 = bool14;
      bool5 = bool11;
      label2934:
      bool16 = (l2 & 0x2500830) < 0L;
      if (bool16)
      {
        if (bool12) {
          bool11 = bool8;
        } else {
          bool11 = false;
        }
        l3 = l2;
        bool12 = bool11;
        if (bool16)
        {
          if (bool11) {
            l3 = 562949953421312L;
          } else {
            l3 = 281474976710656L;
          }
          l3 = l2 | l3;
          bool12 = bool11;
        }
      }
      else
      {
        bool12 = false;
        l3 = l2;
      }
      bool16 = (l3 & 0x2908034) < 0L;
      if (bool16)
      {
        if (!bool15) {
          bool7 = false;
        }
        bool11 = bool7;
        l5 = l1;
        if (bool16)
        {
          if (bool7) {
            l2 = 512L;
          } else {
            l2 = 256L;
          }
          l5 = l1 | l2;
          bool11 = bool7;
        }
      }
      else
      {
        bool11 = false;
        l5 = l1;
      }
      bool16 = (l3 & 0x2D28091) < 0L;
      if (bool16)
      {
        if (!bool6) {
          j = 0;
        }
        l2 = l3;
        bool6 = j;
        if (bool16)
        {
          if (j != 0) {
            l1 = 549755813888L;
          } else {
            l1 = 274877906944L;
          }
          l2 = l3 | l1;
          bool6 = j;
        }
      }
      else
      {
        bool6 = false;
        l2 = l3;
      }
      boolean bool3 = (l2 & 0x29000B4) < 0L;
      if (bool3)
      {
        if (!bool15) {
          bool5 = false;
        }
        l1 = l2;
        bool7 = bool5;
        if (bool3)
        {
          if (bool5) {
            l3 = 137438953472L;
          } else {
            l3 = 68719476736L;
          }
          l1 = l2 | l3;
          bool7 = bool5;
        }
      }
      else
      {
        bool7 = false;
        l1 = l2;
      }
      if (((l1 & 0x802002000000000) == 0L) && ((l5 & 0x200) == 0L)) {
        l3 = l5;
      }
      for (;;)
      {
        break;
        if (localVideoPlayViewModel != null) {
          localObject3 = localVideoPlayViewModel.G;
        } else {
          localObject3 = localObject4;
        }
        updateRegistration(4, (Observable)localObject3);
        bool5 = bool4;
        if (localObject3 != null) {
          bool5 = ((ObservableBoolean)localObject3).get();
        }
        l2 = l1;
        if ((l1 & 0x290001A) != 0L) {
          if (bool5) {
            l2 = l1 | 0x800000000;
          } else {
            l2 = l1 | 0x400000000;
          }
        }
        l1 = l2;
        bool4 = bool5;
        l3 = l5;
        if ((l2 & 0x2100010) != 0L) {
          if (bool5)
          {
            l3 = l5 | 0x2 | 0x8000;
            l1 = l2;
            bool4 = bool5;
          }
          else
          {
            l3 = l5 | 1L | 0x4000;
            l1 = l2;
            bool4 = bool5;
          }
        }
      }
      if ((l1 & 0x8000000000) != 0L)
      {
        if (localTalkViewModel != null) {
          localObject3 = localTalkViewModel.t;
        } else {
          localObject3 = null;
        }
        updateRegistration(0, (Observable)localObject3);
        if (localObject3 != null) {
          bool5 = ((ObservableBoolean)localObject3).get();
        } else {
          bool5 = false;
        }
        bool3 = bool5 ^ true;
      }
      else
      {
        bool3 = false;
      }
      bool16 = (l1 & 0x29000B4) < 0L;
      l2 = l1;
      if (bool16)
      {
        if (bool7) {
          bool5 = bool4;
        } else {
          bool5 = false;
        }
        l2 = l1;
        if (bool16)
        {
          if (bool5) {
            l2 = 2305843009213693952L;
          } else {
            l2 = 1152921504606846976L;
          }
          l2 = l1 | l2;
        }
        if (!bool5)
        {
          i4 = 8;
          l1 = l2;
          break label3544;
        }
      }
      int i4 = 0;
      l1 = l2;
      label3544:
      boolean bool17 = (l1 & 0x2D28091) < 0L;
      l2 = l1;
      if (bool17)
      {
        if (!bool6) {
          bool3 = false;
        }
        l2 = l1;
        if (bool17)
        {
          if (bool3) {
            l2 = 140737488355328L;
          } else {
            l2 = 70368744177664L;
          }
          l2 = l1 | l2;
        }
        if (!bool3)
        {
          i5 = 8;
          l1 = l2;
          break label3620;
        }
      }
      int i5 = 0;
      l1 = l2;
      label3620:
      bool3 = (l1 & 0x2500830) < 0L;
      int k;
      if (bool3)
      {
        if (bool12) {
          bool5 = bool4;
        } else {
          bool5 = false;
        }
        l2 = l1;
        if (bool3)
        {
          if (bool5) {
            l2 = Long.MIN_VALUE;
          } else {
            l2 = 4611686018427387904L;
          }
          l2 = l1 | l2;
        }
        if (bool5)
        {
          bool3 = false;
          l1 = l2;
          bool7 = bool5;
        }
        else
        {
          k = 8;
          l1 = l2;
          bool7 = bool5;
        }
      }
      else
      {
        k = 0;
        bool7 = false;
      }
      if ((l1 & 0x2500810) != 0L)
      {
        if (bool8) {
          bool5 = bool4;
        } else {
          bool5 = false;
        }
        bool8 = bool5 ^ true;
      }
      else
      {
        bool8 = false;
      }
      bool6 = (l1 & 0x2908034) < 0L;
      int i1;
      if (bool6)
      {
        if (bool11) {
          bool5 = bool4;
        } else {
          bool5 = false;
        }
        l2 = l1;
        if (bool6)
        {
          if (bool5) {
            l2 = 2147483648L;
          } else {
            l2 = 1073741824L;
          }
          l2 = l1 | l2;
        }
        if (bool5) {
          bool6 = false;
        } else {
          i1 = 8;
        }
        l1 = l2;
      }
      else
      {
        i1 = 0;
      }
      if ((l1 & 0x800000000) != 0L)
      {
        if (localVideoPlayViewModel != null) {
          localObject3 = localVideoPlayViewModel.I;
        } else {
          localObject3 = null;
        }
        updateRegistration(1, (Observable)localObject3);
        if (localObject3 != null)
        {
          bool5 = ((ObservableBoolean)localObject3).get();
          break label3882;
        }
      }
      bool5 = false;
      label3882:
      boolean bool18 = (l1 & 0x290001A) < 0L;
      if (bool18)
      {
        if (!bool4) {
          bool5 = false;
        }
        bool11 = bool5;
        l2 = l3;
        if (bool18)
        {
          if (bool5) {
            l2 = 8192L;
          } else {
            l2 = 4096L;
          }
          l2 = l3 | l2;
          bool11 = bool5;
        }
      }
      else
      {
        bool11 = false;
        l2 = l3;
      }
      if ((l2 & 0x2000) != 0L)
      {
        if (localMultiLiveVideoViewModel != null) {
          localObject3 = localMultiLiveVideoViewModel.I3;
        } else {
          localObject3 = null;
        }
        updateRegistration(3, (Observable)localObject3);
        if (localObject3 != null)
        {
          bool5 = ((ObservableBoolean)localObject3).get();
          break label4007;
        }
      }
      bool5 = false;
      label4007:
      if ((!bool18) || (!bool11)) {
        bool5 = false;
      }
      if ((l1 & 0x2000000) != 0L) {
        this.c.setOnClickListener(this.S3);
      }
      if ((l1 & 0x2920014) != 0L)
      {
        this.d.getRoot().setVisibility(i3);
        this.R3.setVisibility(i3);
      }
      if ((l1 & 0x2800000) != 0L)
      {
        this.d.h(localMultiLiveVideoViewModel);
        this.f.h(localMultiLiveVideoViewModel);
        this.q.l(localMultiLiveVideoViewModel);
        this.x.l(localMultiLiveVideoViewModel);
        this.p3.h(localMultiLiveVideoViewModel);
      }
      if ((l1 & 0x2100000) != 0L)
      {
        this.d.i(localVideoPlayViewModel);
        this.f.i(localVideoPlayViewModel);
        this.q.i(localVideoPlayViewModel);
        this.x.i(localVideoPlayViewModel);
        this.p3.i(localVideoPlayViewModel);
      }
      if ((l1 & 0x2200000) != 0L)
      {
        this.d.l(localg);
        this.f.l(localg);
        this.q.h(localg);
        this.x.h(localg);
        this.y.h(localg);
        this.p3.l(localg);
      }
      if ((0x2400000 & l1) != 0L)
      {
        this.d.m(localTalkViewModel);
        this.f.m(localTalkViewModel);
        this.y.i(localTalkViewModel);
        this.p3.m(localTalkViewModel);
      }
      if ((l1 & 0x2D28091) != 0L) {
        this.f.getRoot().setVisibility(i5);
      }
      if ((l1 & 0x29000B4) != 0L) {
        this.q.getRoot().setVisibility(i4);
      }
      if ((l1 & 0x2908034) != 0L) {
        this.x.getRoot().setVisibility(i1);
      }
      if ((l1 & 0x2500830) != 0L)
      {
        this.y.getRoot().setVisibility(k);
        b.Q(this.Q3, bool7);
      }
      if ((l1 & 0x2900014) != 0L) {
        b.Q(this.P3, bool13);
      }
      if ((0x2444240 & l1) != 0L) {
        TextViewBindingAdapter.setText(this.Q3, (CharSequence)localObject1);
      }
      if ((l1 & 0x2100010) != 0L)
      {
        b.w(this.p0, bool4);
        b.H(this.p0, m);
        this.p3.getRoot().setVisibility(i2);
      }
      if ((l1 & 0x2500810) != 0L) {
        b.Q(this.p0, bool8);
      }
      if (bool18) {
        b.Q(this.p1, bool5);
      }
      if ((l1 & 0x2100020) != 0L) {
        b.c(this.p1, Boolean.valueOf(bool10), null);
      }
      ViewDataBinding.executeBindingsOn(this.p3);
      ViewDataBinding.executeBindingsOn(this.f);
      ViewDataBinding.executeBindingsOn(this.q);
      ViewDataBinding.executeBindingsOn(this.x);
      ViewDataBinding.executeBindingsOn(this.d);
      ViewDataBinding.executeBindingsOn(this.y);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable CloudTerraceControlViewModel paramCloudTerraceControlViewModel)
  {
    this.L3 = paramCloudTerraceControlViewModel;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      if ((this.T3 == 0L) && (this.U3 == 0L))
      {
        if (this.p3.hasPendingBindings()) {
          return true;
        }
        if (this.f.hasPendingBindings()) {
          return true;
        }
        if (this.q.hasPendingBindings()) {
          return true;
        }
        if (this.x.hasPendingBindings()) {
          return true;
        }
        if (this.d.hasPendingBindings()) {
          return true;
        }
        return this.y.hasPendingBindings();
      }
      return true;
    }
    finally {}
  }
  
  public void i(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel)
  {
    this.K3 = paramMultiLiveVideoViewModel;
    try
    {
      this.T3 |= 0x800000;
      notifyPropertyChanged(66);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.T3 = 33554432L;
      this.U3 = 0L;
      this.p3.invalidateAll();
      this.f.invalidateAll();
      this.q.invalidateAll();
      this.x.invalidateAll();
      this.d.invalidateAll();
      this.y.invalidateAll();
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.I3 = paramVideoPlayViewModel;
    try
    {
      this.T3 |= 0x100000;
      notifyPropertyChanged(74);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable g paramg)
  {
    this.H3 = paramg;
    try
    {
      this.T3 |= 0x200000;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable TalkViewModel paramTalkViewModel)
  {
    this.J3 = paramTalkViewModel;
    try
    {
      this.T3 |= 0x400000;
      notifyPropertyChanged(96);
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
    case 19: 
      return o((LayoutFullScreenBottomBarBinding)paramObject, paramInt2);
    case 18: 
      return F((ObservableBoolean)paramObject, paramInt2);
    case 17: 
      return x((MutableLiveData)paramObject, paramInt2);
    case 16: 
      return H((LayoutMultiLiveToolbarBottomBinding)paramObject, paramInt2);
    case 15: 
      return u((ObservableBoolean)paramObject, paramInt2);
    case 14: 
      return C((ObservableBoolean)paramObject, paramInt2);
    case 13: 
      return r((LayoutFullScreenQualityBinding)paramObject, paramInt2);
    case 12: 
      return p((LayoutFullScreenControlBinding)paramObject, paramInt2);
    case 11: 
      return E((ObservableBoolean)paramObject, paramInt2);
    case 10: 
      return s((LayoutVoiceTalkPanelBinding)paramObject, paramInt2);
    case 9: 
      return G((ObservableField)paramObject, paramInt2);
    case 8: 
      return q((LayoutDayNightModeBinding)paramObject, paramInt2);
    case 7: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return D((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return z((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return y((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return v((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return w((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return A((ObservableBoolean)paramObject, paramInt2);
    }
    return B((ObservableBoolean)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.p3.setLifecycleOwner(paramLifecycleOwner);
    this.f.setLifecycleOwner(paramLifecycleOwner);
    this.q.setLifecycleOwner(paramLifecycleOwner);
    this.x.setLifecycleOwner(paramLifecycleOwner);
    this.d.setLifecycleOwner(paramLifecycleOwner);
    this.y.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (74 == paramInt)
    {
      l((VideoPlayViewModel)paramObject);
    }
    else if (79 == paramInt)
    {
      m((g)paramObject);
    }
    else if (96 == paramInt)
    {
      n((TalkViewModel)paramObject);
    }
    else if (66 == paramInt)
    {
      i((MultiLiveVideoViewModel)paramObject);
    }
    else
    {
      if (11 != paramInt) {
        break label87;
      }
      h((CloudTerraceControlViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label87:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentMultiLiveVideoBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */