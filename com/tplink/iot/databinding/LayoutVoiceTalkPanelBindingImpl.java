package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.liveViewSettingButton.RippleLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public class LayoutVoiceTalkPanelBindingImpl
  extends LayoutVoiceTalkPanelBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  @Nullable
  private final View.OnClickListener H3;
  @Nullable
  private final View.OnClickListener I3;
  @Nullable
  private final View.OnClickListener J3;
  @Nullable
  private final View.OnClickListener K3;
  private long L3 = -1L;
  @NonNull
  private final RelativeLayout p2;
  @Nullable
  private final View.OnClickListener p3;
  
  public LayoutVoiceTalkPanelBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p0, p1));
  }
  
  private LayoutVoiceTalkPanelBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[5], (RippleLayout)paramArrayOfObject[2], (ImageView)paramArrayOfObject[4], (ImageButton)paramArrayOfObject[3]);
    this.c.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    this.p3 = new a(this, 5);
    this.H3 = new a(this, 3);
    this.I3 = new a(this, 1);
    this.J3 = new a(this, 4);
    this.K3 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.L3 |= 1L;
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
        this.L3 |= 0x8;
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
        this.L3 |= 0x2;
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
        this.L3 |= 0x4;
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
              localg = this.z;
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
            localg = this.z;
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
          localg = this.z;
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
        localg = this.z;
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
      localg = this.z;
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
      long l1 = this.L3;
      this.L3 = 0L;
      TalkViewModel localTalkViewModel = this.y;
      Object localObject1 = null;
      Object localObject2;
      boolean bool3;
      float f;
      boolean bool4;
      Object localObject4;
      int j;
      int n;
      if ((0x6F & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x61) < 0L;
        if (bool1)
        {
          if (localTalkViewModel != null) {
            localObject2 = localTalkViewModel.j;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null) {
            bool3 = ((ObservableBoolean)localObject2).get();
          } else {
            bool3 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool3) {
              l2 = 65536L;
            } else {
              l2 = 32768L;
            }
            l2 = l1 | l2;
          }
          if (bool3) {
            f = 1.0F;
          } else {
            f = 0.3F;
          }
          l1 = l2;
        }
        else
        {
          bool3 = false;
          f = 0.0F;
        }
        bool1 = (l1 & 0x62) < 0L;
        if (bool1)
        {
          if (localTalkViewModel != null) {
            localObject2 = localTalkViewModel.h;
          } else {
            localObject2 = null;
          }
          updateRegistration(1, (Observable)localObject2);
          if (localObject2 != null) {
            bool4 = ((ObservableBoolean)localObject2).get();
          } else {
            bool4 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool4) {
              l2 = 256L;
            } else {
              l2 = 128L;
            }
            l2 = l1 | l2;
          }
          int i;
          if (bool4)
          {
            localObject2 = this.d.getContext();
            i = 2131231224;
          }
          else
          {
            localObject2 = this.d.getContext();
            i = 2131231225;
          }
          localObject2 = AppCompatResources.getDrawable((Context)localObject2, i);
          l1 = l2;
        }
        else
        {
          localObject2 = null;
        }
        boolean bool2 = (l1 & 0x64) < 0L;
        boolean bool5;
        if (bool2)
        {
          if (localTalkViewModel != null) {
            localObject4 = localTalkViewModel.m;
          } else {
            localObject4 = null;
          }
          updateRegistration(2, (Observable)localObject4);
          if (localObject4 != null) {
            bool5 = ((ObservableBoolean)localObject4).get();
          } else {
            bool5 = false;
          }
          l2 = l1;
          if (bool2)
          {
            if (bool5)
            {
              l1 |= 0x400;
              l2 = 4096L;
            }
            else
            {
              l1 |= 0x200;
              l2 = 2048L;
            }
            l2 = l1 | l2;
          }
          j = 8;
          int k;
          if (bool5) {
            k = 8;
          } else {
            k = 0;
          }
          l1 = l2;
          bool4 = bool5;
          n = k;
          if (bool5)
          {
            j = 0;
            l1 = l2;
            bool4 = bool5;
            n = k;
          }
        }
        else
        {
          j = 0;
          bool4 = false;
          n = 0;
        }
        boolean bool6 = (l1 & 0x68) < 0L;
        long l2 = l1;
        localObject4 = localObject1;
        if (bool6)
        {
          if (localTalkViewModel != null) {
            localObject4 = localTalkViewModel.i;
          } else {
            localObject4 = null;
          }
          updateRegistration(3, (Observable)localObject4);
          if (localObject4 != null) {
            bool5 = ((ObservableBoolean)localObject4).get();
          } else {
            bool5 = false;
          }
          l2 = l1;
          if (bool6)
          {
            if (bool5) {
              l2 = 16384L;
            } else {
              l2 = 8192L;
            }
            l2 = l1 | l2;
          }
          int m;
          if (bool5)
          {
            localObject4 = this.q.getContext();
            m = 2131231226;
          }
          else
          {
            localObject4 = this.q.getContext();
            m = 2131231227;
          }
          localObject4 = AppCompatResources.getDrawable((Context)localObject4, m);
        }
        l1 = l2;
      }
      else
      {
        localObject2 = null;
        localObject4 = localObject2;
        f = 0.0F;
        j = 0;
        bool3 = false;
        bool4 = false;
        n = 0;
      }
      if ((l1 & 0x40) != 0L)
      {
        this.c.setOnClickListener(this.I3);
        this.d.setOnClickListener(this.p3);
        this.f.setOnClickListener(this.K3);
        this.q.setOnClickListener(this.J3);
        this.x.setOnClickListener(this.H3);
      }
      if ((l1 & 0x64) != 0L)
      {
        this.c.setVisibility(j);
        b.Q(this.d, bool4);
        this.f.setVisibility(n);
        b.u(this.q, bool4);
      }
      if ((0x62 & l1) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.d, (Drawable)localObject2);
      }
      if ((0x68 & l1) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.q, (Drawable)localObject4);
      }
      if ((l1 & 0x61) != 0L)
      {
        this.x.setEnabled(bool3);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.x.setAlpha(f);
        }
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.z = paramg;
    try
    {
      this.L3 |= 0x10;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.L3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable TalkViewModel paramTalkViewModel)
  {
    this.y = paramTalkViewModel;
    try
    {
      this.L3 |= 0x20;
      notifyPropertyChanged(96);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.L3 = 64L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            return false;
          }
          return m((ObservableBoolean)paramObject, paramInt2);
        }
        return o((ObservableBoolean)paramObject, paramInt2);
      }
      return n((ObservableBoolean)paramObject, paramInt2);
    }
    return l((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      h((g)paramObject);
    }
    else
    {
      if (96 != paramInt) {
        break label36;
      }
      i((TalkViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutVoiceTalkPanelBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */