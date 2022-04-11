package com.tplink.iot.databinding;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker.a;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodPlayRate;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public class FragmentPlayBackVideoBindingImpl
  extends FragmentPlayBackVideoBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts X3;
  @Nullable
  private static final SparseIntArray Y3;
  @NonNull
  private final FrameLayout Z3;
  @NonNull
  private final RelativeLayout a4;
  @NonNull
  private final RelativeLayout b4;
  @NonNull
  private final TextView c4;
  @NonNull
  private final ScrollPlayRatePicker d4;
  @NonNull
  private final RelativeLayout e4;
  @NonNull
  private final ScrollPlayRatePicker f4;
  @Nullable
  private final View.OnClickListener g4;
  @Nullable
  private final View.OnClickListener h4;
  private long i4 = -1L;
  private long j4 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(25);
    X3 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(1, new String[] { "layout_playback_toolbar_top", "layout_playback_toolbar_bottom", "layout_playback_toolbar_popup", "layout_palyback_full_bottom", "layout_play_back_fullscreen_filter", "layout_play_back_fullscreen_calendar" }, new int[] { 15, 16, 17, 18, 19, 20 }, new int[] { 2131559200, 2131559198, 2131559199, 2131559190, 2131559194, 2131559193 });
    localObject = new SparseIntArray();
    Y3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131363253, 21);
    ((SparseIntArray)localObject).put(2131363552, 22);
    ((SparseIntArray)localObject).put(2131363251, 23);
    ((SparseIntArray)localObject).put(2131364152, 24);
  }
  
  public FragmentPlayBackVideoBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 25, X3, Y3));
  }
  
  private FragmentPlayBackVideoBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 23, (ImageView)paramArrayOfObject[12], (RelativeLayout)paramArrayOfObject[2], (View)paramArrayOfObject[23], (FrameLayout)paramArrayOfObject[21], (ImageView)paramArrayOfObject[22], (ConstraintLayout)paramArrayOfObject[3], (TextView)paramArrayOfObject[8], (ImageView)paramArrayOfObject[7], (FrameLayout)paramArrayOfObject[6], (ImageView)paramArrayOfObject[24], (TextView)paramArrayOfObject[4], (LayoutPalybackFullBottomBinding)paramArrayOfObject[18], (LayoutPlayBackFullscreenCalendarBinding)paramArrayOfObject[20], (LayoutPlayBackFullscreenFilterBinding)paramArrayOfObject[19], (LayoutPlaybackToolbarBottomBinding)paramArrayOfObject[16], (LayoutPlaybackToolbarTopBinding)paramArrayOfObject[15], (LayoutPlaybackToolbarPopupBinding)paramArrayOfObject[17], (TouchListenerRelativeLayout)paramArrayOfObject[1]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.Z3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[10];
    this.a4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[11];
    this.b4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[13];
    this.c4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ScrollPlayRatePicker)paramArrayOfObject[14];
    this.d4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[5];
    this.e4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ScrollPlayRatePicker)paramArrayOfObject[9];
    this.f4 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p3.setTag(null);
    setContainedBinding(this.H3);
    setContainedBinding(this.I3);
    setContainedBinding(this.J3);
    setContainedBinding(this.K3);
    setContainedBinding(this.L3);
    setContainedBinding(this.M3);
    this.N3.setTag(null);
    setRootTag(paramView);
    this.g4 = new com.tplink.iot.generated.callback.a(this, 1);
    this.h4 = new com.tplink.iot.generated.callback.a(this, 2);
    invalidateAll();
  }
  
  private boolean A(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x1000;
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
        this.i4 |= 0x100000;
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
        this.i4 |= 0x40;
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
        this.i4 |= 0x800;
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
        this.i4 |= 0x4000;
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
        this.i4 |= 0x2;
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
        this.i4 |= 0x20;
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
        this.i4 |= 0x200000;
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
        this.i4 |= 0x40000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean J(ObservableField<VodPlayRate> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x10000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean K(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean L(ObservableField<Drawable> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 1L;
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
        this.i4 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean N(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x8000;
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
        this.i4 |= 0x20000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean s(LayoutPalybackFullBottomBinding paramLayoutPalybackFullBottomBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean t(LayoutPlayBackFullscreenCalendarBinding paramLayoutPlayBackFullscreenCalendarBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x2000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean u(LayoutPlayBackFullscreenFilterBinding paramLayoutPlayBackFullscreenFilterBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x400;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean v(LayoutPlaybackToolbarBottomBinding paramLayoutPlaybackToolbarBottomBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean w(LayoutPlaybackToolbarTopBinding paramLayoutPlaybackToolbarTopBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x200;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean x(LayoutPlaybackToolbarPopupBinding paramLayoutPlaybackToolbarPopupBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.i4 |= 0x80000;
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
        this.i4 |= 0x4;
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
        this.i4 |= 0x400000;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 0;
    int j = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localg = this.O3;
        paramInt = j;
        if (localg != null) {
          paramInt = 1;
        }
        if (paramInt != 0) {
          localg.onClick(paramView);
        }
      }
    }
    else
    {
      localg = this.O3;
      paramInt = i;
      if (localg != null) {
        paramInt = 1;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.i4;
      this.i4 = 0L;
      long l2 = this.j4;
      this.j4 = 0L;
      c localc = this.W3;
      g localg = this.O3;
      com.tplink.iot.view.ipcamera.widget.calendar.b localb = this.U3;
      VodViewModel localVodViewModel = this.Q3;
      TimeAxisLayout.b localb1 = this.V3;
      PlaybackMainViewModel localPlaybackMainViewModel = this.P3;
      ScrollPlayRatePicker.a locala = this.T3;
      PlayBackControlViewModel localPlayBackControlViewModel = this.R3;
      Object localObject1;
      label139:
      Object localObject3;
      label251:
      label310:
      Object localObject4;
      label369:
      Object localObject5;
      label428:
      Object localObject6;
      label484:
      boolean bool6;
      boolean bool8;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      int n;
      Object localObject10;
      if ((0x1146781C1 & l1) != 0L)
      {
        if ((0x104000001 & l1) != 0L)
        {
          if (localVodViewModel != null) {
            localObject1 = localVodViewModel.H3;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (Drawable)((ObservableField)localObject1).get();
            break label139;
          }
        }
        localObject1 = null;
        boolean bool1 = (l1 & 0x104000080) < 0L;
        l3 = l1;
        if (bool1)
        {
          if (localVodViewModel != null) {
            localObject3 = localVodViewModel.J3;
          } else {
            localObject3 = null;
          }
          updateRegistration(7, (Observable)localObject3);
          if (localObject3 != null) {
            bool4 = ((ObservableBoolean)localObject3).get();
          } else {
            bool4 = false;
          }
          l3 = l1;
          if (bool1)
          {
            if (bool4) {
              l3 = 18014398509481984L;
            } else {
              l3 = 9007199254740992L;
            }
            l3 = l1 | l3;
          }
          if (!bool4)
          {
            i = 8;
            break label251;
          }
        }
        int i = 0;
        if ((l3 & 0x104000100) != 0L)
        {
          if (localVodViewModel != null) {
            localObject3 = localVodViewModel.O3;
          } else {
            localObject3 = null;
          }
          updateRegistration(8, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label310;
          }
        }
        localObject3 = null;
        if ((l3 & 0x104008000) != 0L)
        {
          if (localVodViewModel != null) {
            localObject4 = localVodViewModel.I3;
          } else {
            localObject4 = null;
          }
          updateRegistration(15, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label369;
          }
        }
        localObject4 = null;
        if ((l3 & 0x114210040) != 0L)
        {
          if (localVodViewModel != null) {
            localObject5 = localVodViewModel.T3;
          } else {
            localObject5 = null;
          }
          updateRegistration(16, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (VodPlayRate)((ObservableField)localObject5).get();
            break label428;
          }
        }
        localObject5 = null;
        if ((l3 & 0x104020000) != 0L)
        {
          if (localVodViewModel != null) {
            localObject6 = localVodViewModel.K3;
          } else {
            localObject6 = null;
          }
          updateRegistration(17, (Observable)localObject6);
          if (localObject6 != null)
          {
            bool4 = ((ObservableBoolean)localObject6).get();
            break label484;
          }
        }
        bool4 = false;
        boolean bool5 = (l3 & 0x114440000) < 0L;
        bool6 = bool4;
        if (bool5)
        {
          if (localVodViewModel != null) {
            localObject6 = localVodViewModel.N3;
          } else {
            localObject6 = null;
          }
          updateRegistration(18, (Observable)localObject6);
          if (localObject6 != null) {
            bool7 = ((ObservableBoolean)localObject6).get();
          } else {
            bool7 = false;
          }
          bool4 = bool7;
          l4 = l2;
          if (bool5)
          {
            if (bool7) {
              l4 = 16L;
            } else {
              l4 = 8L;
            }
            l4 = l2 | l4;
            bool4 = bool7;
          }
        }
        else
        {
          bool4 = false;
          l4 = l2;
        }
        bool5 = (l3 & 0x104210000) < 0L;
        if (bool5)
        {
          if (localVodViewModel != null) {
            localObject6 = localVodViewModel.S3;
          } else {
            localObject6 = null;
          }
          updateRegistration(21, (Observable)localObject6);
          if (localObject6 != null) {
            bool7 = ((ObservableBoolean)localObject6).get();
          } else {
            bool7 = false;
          }
          l1 = l3;
          if (bool5)
          {
            if (bool7) {
              l1 = 4398046511104L;
            } else {
              l1 = 2199023255552L;
            }
            l1 = l3 | l1;
          }
          bool8 = bool7 ^ true;
          localObject7 = localObject1;
          localObject1 = localObject6;
          l3 = l1;
          bool9 = bool4;
          localObject6 = localObject3;
          localObject8 = localObject5;
          localObject9 = localObject4;
          n = i;
          bool4 = bool7;
        }
        else
        {
          bool7 = false;
          bool8 = false;
          localObject10 = null;
          bool9 = bool4;
          localObject6 = localObject3;
          localObject8 = localObject5;
          localObject9 = localObject4;
          localObject7 = localObject1;
          n = i;
          bool4 = bool7;
          localObject1 = localObject10;
        }
      }
      else
      {
        l4 = l2;
        bool8 = false;
        bool9 = false;
        localObject6 = null;
        localObject8 = null;
        localObject9 = null;
        localObject7 = null;
        n = 0;
        bool4 = false;
        bool6 = false;
        localObject1 = null;
        l3 = l1;
      }
      boolean bool10;
      label876:
      int i1;
      label988:
      boolean bool12;
      int k;
      label1360:
      boolean bool13;
      int m;
      int i2;
      label1701:
      boolean bool16;
      boolean bool17;
      if ((l3 & 0x114715866) != 0L)
      {
        if ((l3 & 0x110000002) != 0L)
        {
          if (localPlaybackMainViewModel != null) {
            localObject3 = localPlaybackMainViewModel.m;
          } else {
            localObject3 = null;
          }
          updateRegistration(1, (Observable)localObject3);
          if (localObject3 != null)
          {
            bool10 = ((ObservableBoolean)localObject3).get();
            break label876;
          }
        }
        bool10 = false;
        boolean bool2 = (l3 & 0x110000004) < 0L;
        if (bool2)
        {
          if (localPlaybackMainViewModel != null) {
            localObject3 = localPlaybackMainViewModel.q;
          } else {
            localObject3 = null;
          }
          updateRegistration(2, (Observable)localObject3);
          if (localObject3 != null) {
            bool7 = ((ObservableBoolean)localObject3).get();
          } else {
            bool7 = false;
          }
          l1 = l4;
          if (bool2)
          {
            if (bool7) {
              l1 = 4L;
            } else {
              l1 = 2L;
            }
            l1 = l4 | l1;
          }
          if (bool7)
          {
            l4 = l1;
          }
          else
          {
            i1 = 8;
            l4 = l1;
            break label988;
          }
        }
        i1 = 0;
        bool2 = (l3 & 0x110000020) < 0L;
        if (bool2)
        {
          if (localPlaybackMainViewModel != null) {
            localObject3 = localPlaybackMainViewModel.n;
          } else {
            localObject3 = null;
          }
          updateRegistration(5, (Observable)localObject3);
          if (localObject3 != null) {
            bool7 = ((ObservableBoolean)localObject3).get();
          } else {
            bool7 = false;
          }
          l1 = l3;
          if (bool2)
          {
            if (bool7) {
              l1 = 1152921504606846976L;
            } else {
              l1 = 576460752303423488L;
            }
            l1 = l3 | l1;
          }
          int j;
          if (bool7)
          {
            localObject3 = this.p3.getResources();
            j = 2131952033;
          }
          else
          {
            localObject3 = this.p3.getResources();
            j = 2131953313;
          }
          localObject5 = ((Resources)localObject3).getString(j);
          l3 = l1;
        }
        else
        {
          localObject5 = null;
        }
        boolean bool3 = (l3 & 0x114010040) < 0L;
        if (bool3)
        {
          if (localPlaybackMainViewModel != null) {
            localObject3 = localPlaybackMainViewModel.s;
          } else {
            localObject3 = null;
          }
          updateRegistration(6, (Observable)localObject3);
          if (localObject3 != null) {
            bool7 = ((ObservableBoolean)localObject3).get();
          } else {
            bool7 = false;
          }
          l1 = l3;
          if (bool3)
          {
            if (bool7) {
              l1 = 72057594037927936L;
            } else {
              l1 = 36028797018963968L;
            }
            l1 = l3 | l1;
          }
          bool11 = bool7 ^ true;
        }
        else
        {
          bool7 = false;
          bool11 = false;
          localObject3 = null;
          l1 = l3;
        }
        bool3 = (l1 & 0x110004000) < 0L;
        bool12 = bool7;
        if (bool3)
        {
          if (localPlaybackMainViewModel != null) {
            localObject4 = localPlaybackMainViewModel.l;
          } else {
            localObject4 = null;
          }
          updateRegistration(14, (Observable)localObject4);
          if (localObject4 != null) {
            bool7 = ((ObservableBoolean)localObject4).get();
          } else {
            bool7 = false;
          }
          l3 = l1;
          if (bool3) {
            if (bool7) {
              l3 = l1 | 0x4000000000000;
            } else {
              l3 = l1 | 0x2000000000000;
            }
          }
          if (!bool7)
          {
            k = 8;
            break label1360;
          }
        }
        else
        {
          localObject4 = null;
          bool7 = false;
          l3 = l1;
        }
        k = 0;
        Object localObject11 = localObject4;
        if ((l3 & 0x114705840) != 0L)
        {
          if (localPlaybackMainViewModel != null) {
            localObject4 = localPlaybackMainViewModel.r;
          } else {
            localObject4 = null;
          }
          bool13 = bool7;
          updateRegistration(22, (Observable)localObject4);
          if (localObject4 != null) {
            bool7 = ((ObservableBoolean)localObject4).get();
          } else {
            bool7 = false;
          }
          l1 = l3;
          if ((l3 & 0x110400000) != 0L)
          {
            if (bool7)
            {
              l1 = l3 | 0x1000000000;
              l3 = 281474976710656L;
            }
            else
            {
              l1 = l3 | 0x800000000;
              l3 = 140737488355328L;
            }
            l1 |= l3;
          }
          l3 = l1;
          if ((l1 & 0x110401000) != 0L) {
            if (bool7) {
              l3 = l1 | 0x10000000000;
            } else {
              l3 = l1 | 0x8000000000;
            }
          }
          l1 = l3;
          if ((l3 & 0x110500000) != 0L)
          {
            if (bool7) {
              l1 = 70368744177664L;
            } else {
              l1 = 35184372088832L;
            }
            l1 = l3 | l1;
          }
          l3 = l1;
          if ((l1 & 0x110404000) != 0L)
          {
            if (bool7) {
              l3 = 4503599627370496L;
            } else {
              l3 = 2251799813685248L;
            }
            l3 = l1 | l3;
          }
          l1 = l4;
          if ((l3 & 0x110404040) != 0L) {
            if (bool7) {
              l1 = l4 | 0x40;
            } else {
              l1 = l4 | 0x20;
            }
          }
          l4 = l1;
          if ((l3 & 0x110400800) != 0L) {
            if (bool7) {
              l4 = l1 | 0x400;
            } else {
              l4 = l1 | 0x200;
            }
          }
          if ((l3 & 0x110400000) != 0L)
          {
            if (bool7) {
              m = 8;
            } else {
              m = 0;
            }
            if (!bool7)
            {
              i2 = 8;
              break label1701;
            }
          }
          else
          {
            m = 0;
          }
          i2 = 0;
          i3 = (l3 & 0x114604000) < 0L;
          if (i3 != 0)
          {
            bool14 = bool7 ^ true;
            l1 = l3;
            if (i3 != 0)
            {
              if (bool14) {
                l1 = 17179869184L;
              } else {
                l1 = 8589934592L;
              }
              l1 = l3 | l1;
            }
            l3 = l1;
          }
          else
          {
            bool14 = false;
          }
          i3 = m;
          localObject10 = localObject5;
          m = k;
          bool16 = bool11;
          k = i1;
          bool17 = bool10;
          bool10 = bool7;
          localObject5 = localObject4;
          localObject4 = localObject3;
          bool11 = bool12;
          localObject3 = localObject11;
          bool7 = bool13;
          i1 = i3;
        }
        else
        {
          bool14 = false;
          i3 = 0;
          i2 = 0;
          localObject10 = localObject5;
          m = k;
          bool13 = false;
          localObject5 = null;
          bool16 = bool11;
          k = i1;
          bool17 = bool10;
          bool10 = bool13;
          localObject4 = localObject3;
          bool11 = bool12;
          localObject3 = localObject11;
          i1 = i3;
        }
      }
      else
      {
        bool16 = false;
        k = 0;
        bool17 = false;
        m = 0;
        bool10 = false;
        localObject5 = null;
        localObject10 = null;
        localObject4 = null;
        bool11 = false;
        localObject3 = null;
        bool7 = false;
        bool14 = false;
        i1 = 0;
        i2 = 0;
      }
      if ((l3 & 0x400000000) != 0L)
      {
        if (localVodViewModel != null) {
          localObject1 = localVodViewModel.S3;
        }
        updateRegistration(21, (Observable)localObject1);
        bool12 = bool4;
        if (localObject1 != null) {
          bool12 = ((ObservableBoolean)localObject1).get();
        }
        l1 = l3;
        bool4 = bool12;
        if ((l3 & 0x104210000) != 0L)
        {
          if (bool12) {
            l1 = 4398046511104L;
          } else {
            l1 = 2199023255552L;
          }
          l1 = l3 | l1;
          bool4 = bool12;
        }
      }
      else
      {
        l1 = l3;
      }
      if ((l4 & 0x10) != 0L)
      {
        if (localPlaybackMainViewModel != null) {
          localObject1 = localPlaybackMainViewModel.r;
        } else {
          localObject1 = localObject5;
        }
        updateRegistration(22, (Observable)localObject1);
        bool12 = bool10;
        if (localObject1 != null) {
          bool12 = ((ObservableBoolean)localObject1).get();
        }
        l2 = l1;
        if ((l1 & 0x110400000) != 0L)
        {
          if (bool12)
          {
            l1 |= 0x1000000000;
            l3 = 281474976710656L;
          }
          else
          {
            l1 |= 0x800000000;
            l3 = 140737488355328L;
          }
          l2 = l1 | l3;
        }
        l3 = l2;
        if ((l2 & 0x110401000) != 0L) {
          if (bool12) {
            l3 = l2 | 0x10000000000;
          } else {
            l3 = l2 | 0x8000000000;
          }
        }
        l1 = l3;
        if ((l3 & 0x110500000) != 0L)
        {
          if (bool12) {
            l1 = 70368744177664L;
          } else {
            l1 = 35184372088832L;
          }
          l1 = l3 | l1;
        }
        l2 = l1;
        if ((l1 & 0x110404000) != 0L)
        {
          if (bool12) {
            l3 = 4503599627370496L;
          } else {
            l3 = 2251799813685248L;
          }
          l2 = l1 | l3;
        }
        l1 = l4;
        if ((l2 & 0x110404040) != 0L) {
          if (bool12) {
            l1 = l4 | 0x40;
          } else {
            l1 = l4 | 0x20;
          }
        }
        l4 = l2;
        bool10 = bool12;
        l3 = l1;
        if ((l2 & 0x110400800) != 0L) {
          if (bool12)
          {
            l3 = l1 | 0x400;
            l4 = l2;
            bool10 = bool12;
          }
          else
          {
            l3 = l1 | 0x200;
            l4 = l2;
            bool10 = bool12;
          }
        }
      }
      else
      {
        l3 = l4;
        l4 = l1;
      }
      int i3 = (l4 & 0x114604000) < 0L;
      if (i3 != 0)
      {
        if (!bool14) {
          bool4 = false;
        }
        l2 = l4;
        bool13 = bool4;
        if (i3 != 0)
        {
          if (bool4) {
            l1 = 4611686018427387904L;
          } else {
            l1 = 2305843009213693952L;
          }
          l2 = l4 | l1;
          bool13 = bool4;
        }
      }
      else
      {
        bool13 = false;
        l2 = l4;
      }
      if (((l2 & 0x114440000) != 0L) && (bool9)) {
        bool12 = bool10;
      } else {
        bool12 = false;
      }
      l1 = l2;
      boolean bool9 = bool11;
      if ((l3 & 0x40) != 0L)
      {
        if (localPlaybackMainViewModel != null) {
          localObject1 = localPlaybackMainViewModel.s;
        } else {
          localObject1 = localObject4;
        }
        updateRegistration(6, (Observable)localObject1);
        if (localObject1 != null) {
          bool11 = ((ObservableBoolean)localObject1).get();
        }
        l1 = l2;
        bool9 = bool11;
        if ((l2 & 0x114010040) != 0L)
        {
          if (bool11) {
            l4 = 72057594037927936L;
          } else {
            l4 = 36028797018963968L;
          }
          l1 = l2 | l4;
          bool9 = bool11;
        }
      }
      if ((l3 & 0x400) != 0L)
      {
        if (localPlaybackMainViewModel != null) {
          localObject1 = localPlaybackMainViewModel.v;
        } else {
          localObject1 = null;
        }
        updateRegistration(11, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool4 = ((ObservableBoolean)localObject1).get();
          break label2576;
        }
      }
      boolean bool4 = false;
      label2576:
      if ((l1 & 0x10000000000) != 0L)
      {
        if (localPlaybackMainViewModel != null) {
          localObject1 = localPlaybackMainViewModel.u;
        } else {
          localObject1 = null;
        }
        updateRegistration(12, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool11 = ((ObservableBoolean)localObject1).get();
          break label2631;
        }
      }
      boolean bool11 = false;
      label2631:
      boolean bool18 = bool4;
      if ((l1 & 0x4010000000000000) != 0L)
      {
        if (localPlaybackMainViewModel != null) {
          localObject1 = localPlaybackMainViewModel.l;
        } else {
          localObject1 = localObject3;
        }
        updateRegistration(14, (Observable)localObject1);
        bool4 = bool7;
        if (localObject1 != null) {
          bool4 = ((ObservableBoolean)localObject1).get();
        }
        l4 = l1;
        if ((l1 & 0x110004000) != 0L) {
          if (bool4) {
            l4 = l1 | 0x4000000000000;
          } else {
            l4 = l1 | 0x2000000000000;
          }
        }
        if ((l4 & 0x4000000000000000) != 0L)
        {
          bool7 = bool4 ^ true;
          break label2761;
        }
      }
      else
      {
        bool4 = bool7;
        localObject1 = localObject3;
        l4 = l1;
      }
      boolean bool7 = false;
      label2761:
      boolean bool19 = bool11;
      if ((l4 & 0x400000000000) != 0L)
      {
        if (localPlaybackMainViewModel != null) {
          localObject3 = localPlaybackMainViewModel.t;
        } else {
          localObject3 = null;
        }
        updateRegistration(20, (Observable)localObject3);
        if (localObject3 != null)
        {
          bool11 = ((ObservableBoolean)localObject3).get();
          break label2821;
        }
      }
      bool11 = false;
      label2821:
      boolean bool14 = (l4 & 0x110401000) < 0L;
      l1 = l4;
      if (bool14)
      {
        if (!bool10) {
          bool19 = false;
        }
        l1 = l4;
        if (bool14)
        {
          if (bool19) {
            l1 = 274877906944L;
          } else {
            l1 = 137438953472L;
          }
          l1 = l4 | l1;
        }
        if (!bool19)
        {
          i5 = 8;
          break label2897;
        }
      }
      int i5 = 0;
      label2897:
      bool14 = (l1 & 0x110500000) < 0L;
      l2 = l1;
      long l4 = l3;
      if (bool14)
      {
        if (!bool10) {
          bool11 = false;
        }
        l2 = l1;
        l4 = l3;
        if (bool14) {
          if (bool11)
          {
            l4 = l3 | 1L;
            l2 = l1;
          }
          else
          {
            l2 = l1 | 0x8000000000000000;
            l4 = l3;
          }
        }
        if (!bool11)
        {
          i8 = 8;
          l3 = l2;
          break label2989;
        }
      }
      int i8 = 0;
      long l3 = l2;
      label2989:
      bool14 = (l3 & 0x110404000) < 0L;
      int i9;
      if (bool14)
      {
        if (bool10) {
          bool11 = bool4;
        } else {
          bool11 = false;
        }
        l1 = l3;
        if (bool14)
        {
          if (bool11) {
            l1 = 17592186044416L;
          } else {
            l1 = 8796093022208L;
          }
          l1 = l3 | l1;
        }
        int i6;
        if (bool11) {
          bool14 = false;
        } else {
          i6 = 8;
        }
        l3 = l1;
        i9 = i6;
      }
      else
      {
        i9 = 0;
      }
      if ((l3 & 0x114604000) != 0L)
      {
        if (bool13) {
          bool11 = bool7;
        } else {
          bool11 = false;
        }
      }
      else {
        bool11 = false;
      }
      boolean bool15 = (l3 & 0x110404040) < 0L;
      if (bool15)
      {
        if (!bool10) {
          bool9 = false;
        }
        bool13 = bool9;
        l1 = l4;
        if (bool15)
        {
          if (bool9) {
            l1 = 256L;
          } else {
            l1 = 128L;
          }
          l1 = l4 | l1;
          bool13 = bool9;
        }
      }
      else
      {
        bool13 = false;
        l1 = l4;
      }
      bool15 = (l3 & 0x110400800) < 0L;
      int i7;
      if (bool15)
      {
        if (!bool10) {
          bool18 = false;
        }
        l4 = l3;
        if (bool15)
        {
          if (bool18) {
            l4 = 288230376151711744L;
          } else {
            l4 = 144115188075855872L;
          }
          l4 = l3 | l4;
        }
        if (bool18) {
          bool15 = false;
        } else {
          i7 = 8;
        }
        l3 = l4;
      }
      else
      {
        i7 = 0;
      }
      if ((l1 & 0x100) != 0L)
      {
        if (localPlaybackMainViewModel != null) {
          localObject1 = localPlaybackMainViewModel.l;
        }
        updateRegistration(14, (Observable)localObject1);
        if (localObject1 != null) {
          bool4 = ((ObservableBoolean)localObject1).get();
        }
        l4 = l3;
        if ((l3 & 0x110004000) != 0L) {
          if (bool4) {
            l4 = l3 | 0x4000000000000;
          } else {
            l4 = l3 | 0x2000000000000;
          }
        }
        bool7 = bool4 ^ true;
        l3 = l4;
      }
      boolean bool20 = (l3 & 0x110404040) < 0L;
      if (bool20)
      {
        if (!bool13) {
          bool7 = false;
        }
        bool4 = bool7;
      }
      else
      {
        bool4 = false;
      }
      if ((l3 & 0x100000000) != 0L)
      {
        this.c.setOnClickListener(this.h4);
        this.y.setOnClickListener(this.g4);
      }
      if ((l3 & 0x110000004) != 0L) {
        this.d.setVisibility(k);
      }
      if ((l3 & 0x110404000) != 0L) {
        this.a4.setVisibility(i9);
      }
      if ((l3 & 0x110400800) != 0L)
      {
        this.b4.setVisibility(i7);
        this.H3.getRoot().setVisibility(i7);
      }
      if ((0x104000100 & l3) != 0L) {
        TextViewBindingAdapter.setText(this.c4, (CharSequence)localObject6);
      }
      if ((l3 & 0x114440000) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.Q(this.c4, bool12);
      }
      if ((0x120000000 & l3) != 0L)
      {
        com.tplink.iot.view.ipcamera.base.b.m(this.d4, locala);
        com.tplink.iot.view.ipcamera.base.b.m(this.f4, locala);
      }
      if (bool20) {
        com.tplink.iot.view.ipcamera.base.b.Q(this.d4, bool4);
      }
      if ((l3 & 0x114010040) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.o(this.d4, bool16, (VodPlayRate)localObject8);
      }
      if ((l3 & 0x110004000) != 0L) {
        this.e4.setVisibility(m);
      }
      if ((l3 & 0x114604000) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.Q(this.f4, bool11);
      }
      if ((l3 & 0x104210000) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.o(this.f4, bool8, (VodPlayRate)localObject8);
      }
      if ((0x110000002 & l3) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.Q(this.y, bool17);
      }
      if ((0x104008000 & l3) != 0L) {
        TextViewBindingAdapter.setText(this.z, (CharSequence)localObject9);
      }
      if ((0x104000001 & l3) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.p0, (Drawable)localObject7);
      }
      if ((0x104000080 & l3) != 0L) {
        this.p1.setVisibility(n);
      }
      if ((0x104020000 & l3) != 0L) {
        com.tplink.iot.view.ipcamera.base.b.b(this.p1, Boolean.valueOf(bool6), null);
      }
      if ((0x110000020 & l3) != 0L) {
        TextViewBindingAdapter.setText(this.p3, (CharSequence)localObject10);
      }
      if ((0x101000000 & l3) != 0L)
      {
        this.H3.i(localg);
        this.I3.l(localg);
        this.J3.h(localg);
        this.K3.h(localg);
        this.L3.h(localg);
        this.M3.h(localg);
      }
      if ((0x104000000 & l3) != 0L)
      {
        this.H3.n(localVodViewModel);
        this.K3.l(localVodViewModel);
        this.L3.l(localVodViewModel);
        this.M3.l(localVodViewModel);
      }
      if ((0x110000000 & l3) != 0L)
      {
        this.H3.m(localPlaybackMainViewModel);
        this.K3.i(localPlaybackMainViewModel);
        this.L3.i(localPlaybackMainViewModel);
        this.M3.i(localPlaybackMainViewModel);
      }
      if ((0x140000000 & l3) != 0L)
      {
        this.H3.h(localPlayBackControlViewModel);
        this.I3.m(localPlayBackControlViewModel);
        this.J3.i(localPlayBackControlViewModel);
      }
      if ((0x108000000 & l3) != 0L) {
        this.H3.l(localb1);
      }
      if ((0x102000000 & l3) != 0L) {
        this.I3.h(localb);
      }
      if ((0x100800000 & l3) != 0L) {
        this.I3.i(localc);
      }
      if ((l3 & 0x110401000) != 0L) {
        this.I3.getRoot().setVisibility(i5);
      }
      if ((l3 & 0x110500000) != 0L) {
        this.J3.getRoot().setVisibility(i8);
      }
      if ((l3 & 0x110400000) != 0L)
      {
        this.K3.getRoot().setVisibility(i1);
        this.L3.getRoot().setVisibility(i1);
        this.M3.getRoot().setVisibility(i2);
      }
      ViewDataBinding.executeBindingsOn(this.L3);
      ViewDataBinding.executeBindingsOn(this.K3);
      ViewDataBinding.executeBindingsOn(this.M3);
      ViewDataBinding.executeBindingsOn(this.H3);
      ViewDataBinding.executeBindingsOn(this.J3);
      ViewDataBinding.executeBindingsOn(this.I3);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable com.tplink.iot.view.ipcamera.widget.a.a parama)
  {
    this.S3 = parama;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      if ((this.i4 == 0L) && (this.j4 == 0L))
      {
        if (this.L3.hasPendingBindings()) {
          return true;
        }
        if (this.K3.hasPendingBindings()) {
          return true;
        }
        if (this.M3.hasPendingBindings()) {
          return true;
        }
        if (this.H3.hasPendingBindings()) {
          return true;
        }
        if (this.J3.hasPendingBindings()) {
          return true;
        }
        return this.I3.hasPendingBindings();
      }
      return true;
    }
    finally {}
  }
  
  public void i(@Nullable com.tplink.iot.view.ipcamera.widget.calendar.b paramb)
  {
    this.U3 = paramb;
    try
    {
      this.i4 |= 0x2000000;
      notifyPropertyChanged(63);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.i4 = 4294967296L;
      this.j4 = 0L;
      this.L3.invalidateAll();
      this.K3.invalidateAll();
      this.M3.invalidateAll();
      this.H3.invalidateAll();
      this.J3.invalidateAll();
      this.I3.invalidateAll();
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable c paramc)
  {
    this.W3 = paramc;
    try
    {
      this.i4 |= 0x800000;
      notifyPropertyChanged(64);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable ScrollPlayRatePicker.a parama)
  {
    this.T3 = parama;
    try
    {
      this.i4 |= 0x20000000;
      notifyPropertyChanged(70);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.R3 = paramPlayBackControlViewModel;
    try
    {
      this.i4 |= 0x40000000;
      notifyPropertyChanged(75);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void o(@Nullable g paramg)
  {
    this.O3 = paramg;
    try
    {
      this.i4 |= 0x1000000;
      notifyPropertyChanged(79);
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
    case 22: 
      return z((ObservableBoolean)paramObject, paramInt2);
    case 21: 
      return H((ObservableBoolean)paramObject, paramInt2);
    case 20: 
      return B((ObservableBoolean)paramObject, paramInt2);
    case 19: 
      return x((LayoutPlaybackToolbarPopupBinding)paramObject, paramInt2);
    case 18: 
      return I((ObservableBoolean)paramObject, paramInt2);
    case 17: 
      return O((ObservableBoolean)paramObject, paramInt2);
    case 16: 
      return J((ObservableField)paramObject, paramInt2);
    case 15: 
      return N((ObservableField)paramObject, paramInt2);
    case 14: 
      return E((ObservableBoolean)paramObject, paramInt2);
    case 13: 
      return t((LayoutPlayBackFullscreenCalendarBinding)paramObject, paramInt2);
    case 12: 
      return A((ObservableBoolean)paramObject, paramInt2);
    case 11: 
      return D((ObservableBoolean)paramObject, paramInt2);
    case 10: 
      return u((LayoutPlayBackFullscreenFilterBinding)paramObject, paramInt2);
    case 9: 
      return w((LayoutPlaybackToolbarTopBinding)paramObject, paramInt2);
    case 8: 
      return K((ObservableField)paramObject, paramInt2);
    case 7: 
      return M((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return C((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return G((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return v((LayoutPlaybackToolbarBottomBinding)paramObject, paramInt2);
    case 3: 
      return s((LayoutPalybackFullBottomBinding)paramObject, paramInt2);
    case 2: 
      return y((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return F((ObservableBoolean)paramObject, paramInt2);
    }
    return L((ObservableField)paramObject, paramInt2);
  }
  
  public void p(@Nullable TimeAxisLayout.b paramb)
  {
    this.V3 = paramb;
    try
    {
      this.i4 |= 0x8000000;
      notifyPropertyChanged(99);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void q(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel)
  {
    this.P3 = paramPlaybackMainViewModel;
    try
    {
      this.i4 |= 0x10000000;
      notifyPropertyChanged(100);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void r(@Nullable VodViewModel paramVodViewModel)
  {
    this.Q3 = paramVodViewModel;
    try
    {
      this.i4 |= 0x4000000;
      notifyPropertyChanged(107);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.L3.setLifecycleOwner(paramLifecycleOwner);
    this.K3.setLifecycleOwner(paramLifecycleOwner);
    this.M3.setLifecycleOwner(paramLifecycleOwner);
    this.H3.setLifecycleOwner(paramLifecycleOwner);
    this.J3.setLifecycleOwner(paramLifecycleOwner);
    this.I3.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (64 == paramInt)
    {
      l((c)paramObject);
    }
    else if (79 == paramInt)
    {
      o((g)paramObject);
    }
    else if (63 == paramInt)
    {
      i((com.tplink.iot.view.ipcamera.widget.calendar.b)paramObject);
    }
    else if (107 == paramInt)
    {
      r((VodViewModel)paramObject);
    }
    else if (99 == paramInt)
    {
      p((TimeAxisLayout.b)paramObject);
    }
    else if (100 == paramInt)
    {
      q((PlaybackMainViewModel)paramObject);
    }
    else if (70 == paramInt)
    {
      m((ScrollPlayRatePicker.a)paramObject);
    }
    else if (75 == paramInt)
    {
      n((PlayBackControlViewModel)paramObject);
    }
    else
    {
      if (19 != paramInt) {
        break label155;
      }
      h((com.tplink.iot.view.ipcamera.widget.a.a)paramObject);
    }
    boolean bool = true;
    return bool;
    label155:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentPlayBackVideoBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */