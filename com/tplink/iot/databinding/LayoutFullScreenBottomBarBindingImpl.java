package com.tplink.iot.databinding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public class LayoutFullScreenBottomBarBindingImpl
  extends LayoutFullScreenBottomBarBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final LinearLayout H3;
  @Nullable
  private final View.OnClickListener I3;
  @Nullable
  private final View.OnClickListener J3;
  @Nullable
  private final View.OnClickListener K3;
  @Nullable
  private final View.OnClickListener L3;
  @Nullable
  private final View.OnClickListener M3;
  private long N3 = -1L;
  
  public LayoutFullScreenBottomBarBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p2, p3));
  }
  
  private LayoutFullScreenBottomBarBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 14, (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.I3 = new a(this, 3);
    this.J3 = new a(this, 4);
    this.K3 = new a(this, 5);
    this.L3 = new a(this, 2);
    this.M3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean A(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.N3 |= 0x80;
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
        this.N3 |= 1L;
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
        this.N3 |= 0x20;
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
        this.N3 |= 0x100;
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
        this.N3 |= 0x40;
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
        this.N3 |= 0x10;
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
        this.N3 |= 0x2000;
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
        this.N3 |= 0x200;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean u(MutableLiveData<String> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.N3 |= 0x400;
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
        this.N3 |= 0x1000;
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
        this.N3 |= 0x8;
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
        this.N3 |= 0x800;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean y(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.N3 |= 0x4;
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
        this.N3 |= 0x2;
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
    int k = 0;
    int m = 0;
    int n = 0;
    g localg;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5)
            {
              localg = this.y;
              paramInt = n;
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
            localg = this.y;
            paramInt = i;
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
          localg = this.y;
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
        localg = this.y;
        paramInt = k;
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
      localg = this.y;
      paramInt = m;
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
      long l1 = this.N3;
      this.N3 = 0L;
      VideoPlayViewModel localVideoPlayViewModel = this.p0;
      MultiLiveVideoViewModel localMultiLiveVideoViewModel = this.z;
      TalkViewModel localTalkViewModel = this.p1;
      boolean bool1;
      long l2;
      boolean bool3;
      if ((0x65C88 & l1) != 0L)
      {
        if ((0x64C80 & l1) != 0L)
        {
          if (localVideoPlayViewModel != null) {
            localObject1 = localVideoPlayViewModel.k;
          } else {
            localObject1 = null;
          }
          updateLiveDataRegistration(10, (LiveData)localObject1);
          if (localObject1 != null) {
            localObject1 = (String)((LiveData)localObject1).getValue();
          } else {
            localObject1 = null;
          }
          if (localObject1 != null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          l2 = l1;
          if ((l1 & 0x64480) != 0L)
          {
            if (bool1)
            {
              l1 |= 0x10000000;
              l2 = 4294967296L;
            }
            else
            {
              l1 |= 0x8000000;
              l2 = 2147483648L;
            }
            l2 = l1 | l2;
          }
          l1 = l2;
          bool2 = bool1;
          if ((l2 & 0x44C00) != 0L)
          {
            if (bool1) {
              l1 = 17179869184L;
            } else {
              l1 = 8589934592L;
            }
            l1 = l2 | l1;
            bool2 = bool1;
          }
        }
        else
        {
          bool2 = false;
        }
        bool3 = (l1 & 0x45008) < 0L;
        l2 = l1;
        bool1 = bool2;
        if (bool3)
        {
          if (localVideoPlayViewModel != null) {
            localObject1 = localVideoPlayViewModel.r;
          } else {
            localObject1 = null;
          }
          updateRegistration(12, (Observable)localObject1);
          if (localObject1 != null) {
            bool1 = ((ObservableBoolean)localObject1).get();
          } else {
            bool1 = false;
          }
          l2 = l1;
          bool5 = bool2;
          bool6 = bool1;
          if (!bool3) {
            break label337;
          }
          if (bool1) {
            l2 = 68719476736L;
          } else {
            l2 = 34359738368L;
          }
          l2 = l1 | l2;
          bool5 = bool2;
          bool6 = bool1;
          break label337;
        }
      }
      else
      {
        bool1 = false;
        l2 = l1;
      }
      boolean bool6 = false;
      boolean bool5 = bool1;
      label337:
      long l3;
      Object localObject3;
      label475:
      Object localObject5;
      int j;
      Object localObject6;
      int m;
      Object localObject7;
      Object localObject8;
      boolean bool10;
      if ((l2 & 0x52371) != 0L)
      {
        bool3 = (l2 & 0x50001) < 0L;
        l3 = l2;
        if (bool3)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject1 = localMultiLiveVideoViewModel.N3;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool3)
          {
            if (bool2) {
              l1 = 17592186044416L;
            } else {
              l1 = 8796093022208L;
            }
            l1 = l2 | l1;
          }
          l3 = l1;
          if (bool2)
          {
            localObject3 = this.c.getResources().getString(2131954407);
            l2 = l1;
            break label475;
          }
        }
        localObject3 = null;
        l2 = l3;
        bool3 = (l2 & 0x50010) < 0L;
        if (bool3)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject1 = localMultiLiveVideoViewModel.p0;
          } else {
            localObject1 = null;
          }
          updateRegistration(4, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool3)
          {
            if (bool2) {
              l1 = 18014398509481984L;
            } else {
              l1 = 9007199254740992L;
            }
            l1 = l2 | l1;
          }
          int i;
          if (bool2)
          {
            localObject1 = this.q.getContext();
            i = 2131231663;
          }
          else
          {
            localObject1 = this.q.getContext();
            i = 2131231664;
          }
          localObject4 = AppCompatResources.getDrawable((Context)localObject1, i);
        }
        else
        {
          localObject4 = null;
          l1 = l2;
        }
        boolean bool4 = (0x52060 & l1) < 0L;
        if (bool4)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject1 = localMultiLiveVideoViewModel.P3;
          } else {
            localObject1 = null;
          }
          updateRegistration(5, (Observable)localObject1);
          if (localObject1 != null) {
            bool1 = ((ObservableBoolean)localObject1).get();
          } else {
            bool1 = false;
          }
          l2 = l1;
          bool2 = bool1;
          if (bool4) {
            if (bool1)
            {
              l2 = l1 | 0x400000;
              bool2 = bool1;
            }
            else
            {
              l2 = l1 | 0x200000;
              bool2 = bool1;
            }
          }
        }
        else
        {
          bool2 = false;
          l2 = l1;
        }
        if ((l2 & 0x50040) != 0L)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject5 = localMultiLiveVideoViewModel.Q3;
          } else {
            localObject5 = null;
          }
          updateRegistration(6, (Observable)localObject5);
          if (localObject5 != null) {
            bool1 = ((ObservableBoolean)localObject5).get();
          } else {
            bool1 = false;
          }
          l1 = l2;
          if ((l2 & 0x100000) != 0L) {
            if (bool1) {
              l1 = l2 | 0x40000000000;
            } else {
              l1 = l2 | 0x20000000000;
            }
          }
          l2 = l1;
          if ((l1 & 0x50040) != 0L) {
            if (bool1) {
              l2 = l1 | 0x1000000000000;
            } else {
              l2 = l1 | 0x800000000000;
            }
          }
          l1 = l2;
          if ((l2 & 0x400000) != 0L) {
            if (bool1) {
              l1 = l2 | 0x10000000000000;
            } else {
              l1 = l2 | 0x8000000000000;
            }
          }
          if (bool1)
          {
            j = ViewDataBinding.getColorFromResource(this.c, 2131099706);
            l2 = l1;
          }
          else
          {
            j = ViewDataBinding.getColorFromResource(this.c, 2131099862);
            l2 = l1;
          }
        }
        else
        {
          j = 0;
          localObject5 = null;
          bool1 = false;
        }
        boolean bool7 = (l2 & 0x50100) < 0L;
        if (bool7)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject1 = localMultiLiveVideoViewModel.X3;
          } else {
            localObject1 = null;
          }
          updateRegistration(8, (Observable)localObject1);
          if (localObject1 != null) {
            bool9 = ((ObservableBoolean)localObject1).get();
          } else {
            bool9 = false;
          }
          l1 = l2;
          if (bool7)
          {
            if (bool9) {
              l1 = 1073741824L;
            } else {
              l1 = 536870912L;
            }
            l1 = l2 | l1;
          }
          int k;
          if (bool9)
          {
            localObject1 = this.d.getResources();
            k = 2131954409;
          }
          else
          {
            localObject1 = this.d.getResources();
            k = 2131954410;
          }
          localObject1 = ((Resources)localObject1).getString(k);
          l2 = l1;
        }
        else
        {
          localObject1 = null;
        }
        boolean bool8 = (l2 & 0x50200) < 0L;
        if (bool8)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject6 = localMultiLiveVideoViewModel.a4;
          } else {
            localObject6 = null;
          }
          updateRegistration(9, (Observable)localObject6);
          if (localObject6 != null) {
            bool9 = ((ObservableBoolean)localObject6).get();
          } else {
            bool9 = false;
          }
          l1 = l2;
          if (bool8)
          {
            if (bool9) {
              l1 = 1099511627776L;
            } else {
              l1 = 549755813888L;
            }
            l1 = l2 | l1;
          }
          if (bool9)
          {
            localObject6 = this.d;
            m = 2131099706;
          }
          else
          {
            localObject6 = this.d;
            m = 2131099862;
          }
          m = ViewDataBinding.getColorFromResource((View)localObject6, m);
          l2 = l1;
          localObject6 = localObject1;
          localObject7 = localObject3;
          localObject8 = localObject4;
          bool10 = bool2;
          localObject3 = localObject5;
        }
        else
        {
          m = 0;
          localObject6 = localObject1;
          localObject7 = localObject3;
          localObject8 = localObject4;
          bool10 = bool2;
          localObject3 = localObject5;
        }
      }
      else
      {
        j = 0;
        localObject6 = null;
        m = 0;
        localObject7 = null;
        localObject8 = null;
        bool10 = false;
        localObject3 = null;
        bool1 = false;
      }
      if ((l2 & 0x60086) != 0L)
      {
        if ((l2 & 0x60006) != 0L)
        {
          if (localTalkViewModel != null) {
            localObject1 = localTalkViewModel.t;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if ((l2 & 0x60002) != 0L)
          {
            if (bool2) {
              l1 = 274877906944L;
            } else {
              l1 = 137438953472L;
            }
            l1 = l2 | l1;
          }
          l2 = l1;
          if ((l1 & 0x60006) != 0L) {
            if (bool2) {
              l2 = l1 | 0x4000000000000;
            } else {
              l2 = l1 | 0x2000000000000;
            }
          }
          if ((l2 & 0x60002) != 0L)
          {
            if (bool2) {
              localObject1 = AppCompatResources.getDrawable(this.x.getContext(), 2131231618);
            } else {
              localObject1 = AppCompatResources.getDrawable(this.x.getContext(), 2131231617);
            }
          }
          else {
            localObject1 = null;
          }
        }
        else
        {
          localObject1 = null;
          bool2 = false;
        }
        boolean bool11 = (l2 & 0x60080) < 0L;
        if (bool11)
        {
          if (localTalkViewModel != null) {
            localObject4 = localTalkViewModel.k;
          } else {
            localObject4 = null;
          }
          bool12 = bool2;
          updateRegistration(7, (Observable)localObject4);
          if (localObject4 != null) {
            bool2 = ((ObservableBoolean)localObject4).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if (bool11)
          {
            if (bool2) {
              l1 = 67108864L;
            } else {
              l1 = 33554432L;
            }
            l1 = l2 | l1;
          }
          if (bool2) {
            n = 8;
          } else {
            n = 0;
          }
          l2 = l1;
          localObject9 = localObject1;
          break label1634;
        }
      }
      else
      {
        localObject1 = null;
        bool2 = false;
      }
      boolean bool9 = false;
      int n = 0;
      Object localObject4 = null;
      boolean bool12 = bool2;
      boolean bool2 = bool9;
      Object localObject9 = localObject1;
      label1634:
      Object localObject1 = localObject3;
      if ((l2 & 0x800000000) != 0L)
      {
        if (localVideoPlayViewModel != null) {
          localObject3 = localVideoPlayViewModel.D;
        } else {
          localObject3 = null;
        }
        updateRegistration(3, (Observable)localObject3);
        if (localObject3 != null) {
          bool9 = ((ObservableBoolean)localObject3).get();
        } else {
          bool9 = false;
        }
        bool13 = bool9 ^ true;
      }
      else
      {
        bool13 = false;
      }
      boolean bool17;
      if ((l2 & 0x600000) != 0L)
      {
        if ((l2 & 0x400000) != 0L)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject1 = localMultiLiveVideoViewModel.Q3;
          }
          updateRegistration(6, (Observable)localObject1);
          if (localObject1 != null) {
            bool1 = ((ObservableBoolean)localObject1).get();
          }
          l1 = l2;
          if ((l2 & 0x100000) != 0L) {
            if (bool1) {
              l1 = l2 | 0x40000000000;
            } else {
              l1 = l2 | 0x20000000000;
            }
          }
          l2 = l1;
          if ((l1 & 0x50040) != 0L) {
            if (bool1) {
              l2 = l1 | 0x1000000000000;
            } else {
              l2 = l1 | 0x800000000000;
            }
          }
          l1 = l2;
          if ((l2 & 0x400000) != 0L) {
            if (bool1) {
              l1 = l2 | 0x10000000000000;
            } else {
              l1 = l2 | 0x8000000000000;
            }
          }
          if (bool1) {
            localObject3 = AppCompatResources.getDrawable(this.c.getContext(), 2131231350);
          } else {
            localObject3 = AppCompatResources.getDrawable(this.c.getContext(), 2131231349);
          }
          l2 = l1;
        }
        else
        {
          localObject3 = null;
        }
        boolean bool14 = (l2 & 0x200000) < 0L;
        localObject5 = localObject3;
        if (bool14)
        {
          if (localMultiLiveVideoViewModel != null) {
            localObject3 = localMultiLiveVideoViewModel.O3;
          } else {
            localObject3 = null;
          }
          updateRegistration(13, (Observable)localObject3);
          if (localObject3 != null) {
            bool9 = ((ObservableBoolean)localObject3).get();
          } else {
            bool9 = false;
          }
          l1 = l2;
          if (bool14) {
            if (bool9) {
              l1 = l2 | 0x100000;
            } else {
              l1 = l2 | 0x80000;
            }
          }
          l2 = l1;
          localObject3 = localObject1;
          bool17 = bool1;
        }
        else
        {
          bool9 = false;
          localObject3 = localObject1;
          bool17 = bool1;
        }
      }
      else
      {
        bool9 = false;
        localObject5 = null;
        bool17 = bool1;
        localObject3 = localObject1;
      }
      boolean bool18 = bool13;
      Object localObject10;
      if ((l2 & 0x6000110000000) != 0L)
      {
        if ((l2 & 0x6000000000000) != 0L)
        {
          if (localTalkViewModel != null) {
            localObject1 = localTalkViewModel.e;
          } else {
            localObject1 = null;
          }
          updateRegistration(2, (Observable)localObject1);
          int i1;
          if (localObject1 != null) {
            i1 = ((ObservableInt)localObject1).get();
          } else {
            i1 = 0;
          }
          if (i1 == 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          l1 = l2;
          if ((l2 & 0x2000000000000) != 0L)
          {
            if (i1 != 0) {
              l1 = 16777216L;
            } else {
              l1 = 8388608L;
            }
            l1 = l2 | l1;
          }
          l2 = l1;
          if ((l1 & 0x4000000000000) != 0L)
          {
            if (i1 != 0) {
              l2 = 70368744177664L;
            } else {
              l2 = 35184372088832L;
            }
            l2 = l1 | l2;
          }
          if ((l2 & 0x2000000000000) != 0L)
          {
            if (i1 != 0) {
              localObject1 = AppCompatResources.getDrawable(this.f.getContext(), 2131231626);
            } else {
              localObject1 = AppCompatResources.getDrawable(this.f.getContext(), 2131231625);
            }
          }
          else {
            localObject1 = null;
          }
          l1 = l2;
          localObject10 = localObject1;
          if ((l2 & 0x4000000000000) != 0L)
          {
            if (i1 != 0)
            {
              localObject10 = this.f.getContext();
              i1 = 2131231627;
            }
            else
            {
              localObject10 = this.f.getContext();
              i1 = 2131231629;
            }
            Drawable localDrawable = AppCompatResources.getDrawable((Context)localObject10, i1);
            localObject10 = localObject1;
            localObject1 = localDrawable;
            break label2348;
          }
        }
        else
        {
          localObject10 = null;
          l1 = l2;
        }
        localObject1 = null;
        l2 = l1;
        label2348:
        l3 = l2;
        bool13 = bool2;
        if ((l2 & 0x110000000) != 0L)
        {
          if (localTalkViewModel != null) {
            localObject4 = localTalkViewModel.k;
          }
          updateRegistration(7, (Observable)localObject4);
          bool1 = bool2;
          if (localObject4 != null) {
            bool1 = ((ObservableBoolean)localObject4).get();
          }
          l1 = l2;
          if ((l2 & 0x60080) != 0L)
          {
            if (bool1) {
              l1 = 67108864L;
            } else {
              l1 = 33554432L;
            }
            l1 = l2 | l1;
          }
          l3 = l1;
          bool13 = bool1;
          if ((l1 & 0x100000000) != 0L)
          {
            bool2 = bool1 ^ true;
            l2 = l1;
            localObject4 = localObject1;
            break label2510;
          }
        }
        bool2 = false;
        l2 = l3;
        localObject4 = localObject1;
        bool1 = bool13;
      }
      else
      {
        bool13 = false;
        localObject10 = null;
        localObject4 = null;
        bool1 = bool2;
        bool2 = bool13;
      }
      label2510:
      if ((l2 & 0x400000000) != 0L)
      {
        if (localVideoPlayViewModel != null) {
          localObject1 = localVideoPlayViewModel.N;
        } else {
          localObject1 = null;
        }
        updateRegistration(11, (Observable)localObject1);
        if (localObject1 != null)
        {
          bool13 = ((ObservableBoolean)localObject1).get();
          break label2564;
        }
      }
      boolean bool13 = false;
      label2564:
      boolean bool19;
      if ((l2 & 0x64480) != 0L)
      {
        if (!bool5) {
          bool1 = false;
        }
        if (!bool5) {
          bool2 = false;
        }
        bool19 = bool2;
      }
      else
      {
        bool19 = false;
        bool1 = false;
      }
      if (((l2 & 0x44C00) == 0L) || (!bool5)) {
        bool13 = false;
      }
      if ((l2 & 0x45008) != 0L)
      {
        bool2 = bool18;
        if (bool6) {
          bool2 = true;
        }
      }
      else
      {
        bool2 = false;
      }
      if ((l2 & 0x60006) != 0L)
      {
        localObject1 = localObject10;
        if (bool12) {
          localObject1 = localObject4;
        }
      }
      else
      {
        localObject1 = null;
      }
      boolean bool15 = (l2 & 0x100000) < 0L;
      if (bool15)
      {
        if (localMultiLiveVideoViewModel != null) {
          localObject3 = localMultiLiveVideoViewModel.Q3;
        }
        updateRegistration(6, (Observable)localObject3);
        if (localObject3 != null) {
          bool17 = ((ObservableBoolean)localObject3).get();
        }
        l1 = l2;
        if (bool15) {
          if (bool17) {
            l1 = l2 | 0x40000000000;
          } else {
            l1 = l2 | 0x20000000000;
          }
        }
        l2 = l1;
        if ((l1 & 0x50040) != 0L) {
          if (bool17) {
            l2 = l1 | 0x1000000000000;
          } else {
            l2 = l1 | 0x800000000000;
          }
        }
        l1 = l2;
        if ((l2 & 0x400000) != 0L) {
          if (bool17) {
            l1 = l2 | 0x10000000000000;
          } else {
            l1 = l2 | 0x8000000000000;
          }
        }
        localObject3 = this.c.getContext();
        int i2;
        if (bool17) {
          i2 = 2131231352;
        } else {
          i2 = 2131231351;
        }
        localObject3 = AppCompatResources.getDrawable((Context)localObject3, i2);
        l2 = l1;
      }
      else
      {
        localObject3 = null;
      }
      if (((l2 & 0x200000) == 0L) || (!bool9)) {
        localObject3 = null;
      }
      boolean bool16 = (l2 & 0x52060) < 0L;
      if (bool16)
      {
        if (!bool10) {
          localObject5 = localObject3;
        }
      }
      else {
        localObject5 = null;
      }
      if (bool16) {
        TextViewBindingAdapter.setDrawableStart(this.c, (Drawable)localObject5);
      }
      if ((0x40000 & l2) != 0L)
      {
        this.c.setOnClickListener(this.L3);
        this.d.setOnClickListener(this.M3);
        this.f.setOnClickListener(this.I3);
        this.q.setOnClickListener(this.J3);
        this.x.setOnClickListener(this.K3);
      }
      if ((0x50001 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.c, (CharSequence)localObject7);
      }
      if ((l2 & 0x50040) != 0L) {
        this.c.setTextColor(j);
      }
      if ((0x44400 & l2) != 0L) {
        b.Q(this.c, bool5);
      }
      if ((0x45008 & l2) != 0L)
      {
        b.c(this.c, Boolean.valueOf(bool2), null);
        b.c(this.d, Boolean.valueOf(bool2), null);
        b.c(this.f, Boolean.valueOf(bool2), null);
        b.c(this.x, Boolean.valueOf(bool2), null);
      }
      if ((0x50100 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject6);
      }
      if ((0x50200 & l2) != 0L) {
        this.d.setTextColor(m);
      }
      if ((0x44C00 & l2) != 0L) {
        b.Q(this.d, bool13);
      }
      if ((l2 & 0x60006) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.f, (Drawable)localObject1);
      }
      if ((0x64480 & l2) != 0L)
      {
        b.Q(this.f, bool19);
        b.Q(this.x, bool1);
      }
      if ((0x50010 & l2) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.q, (Drawable)localObject8);
      }
      if ((l2 & 0x60080) != 0L) {
        this.q.setVisibility(n);
      }
      if ((l2 & 0x60002) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.x, (Drawable)localObject9);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel)
  {
    this.z = paramMultiLiveVideoViewModel;
    try
    {
      this.N3 |= 0x10000;
      notifyPropertyChanged(66);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.N3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.p0 = paramVideoPlayViewModel;
    try
    {
      this.N3 |= 0x4000;
      notifyPropertyChanged(74);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.N3 = 262144L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable g paramg)
  {
    this.y = paramg;
    try
    {
      this.N3 |= 0x8000;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable TalkViewModel paramTalkViewModel)
  {
    this.p1 = paramTalkViewModel;
    try
    {
      this.N3 |= 0x20000;
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
    case 13: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 12: 
      return v((ObservableBoolean)paramObject, paramInt2);
    case 11: 
      return x((ObservableBoolean)paramObject, paramInt2);
    case 10: 
      return u((MutableLiveData)paramObject, paramInt2);
    case 9: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 8: 
      return p((ObservableBoolean)paramObject, paramInt2);
    case 7: 
      return A((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return q((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return o((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return r((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return w((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return y((ObservableInt)paramObject, paramInt2);
    case 1: 
      return z((ObservableBoolean)paramObject, paramInt2);
    }
    return n((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (74 == paramInt)
    {
      i((VideoPlayViewModel)paramObject);
    }
    else if (79 == paramInt)
    {
      l((g)paramObject);
    }
    else if (66 == paramInt)
    {
      h((MultiLiveVideoViewModel)paramObject);
    }
    else
    {
      if (96 != paramInt) {
        break label70;
      }
      m((TalkViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label70:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutFullScreenBottomBarBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */