package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Pair;
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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;
import java.util.ArrayList;
import java.util.List;

public class LayoutPalybackFullBottomBindingImpl
  extends LayoutPalybackFullBottomBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts L3;
  @Nullable
  private static final SparseIntArray M3;
  @NonNull
  private final TextView N3;
  @Nullable
  private final View.OnClickListener O3;
  @Nullable
  private final View.OnClickListener P3;
  @Nullable
  private final View.OnClickListener Q3;
  @Nullable
  private final View.OnClickListener R3;
  @Nullable
  private final View.OnClickListener S3;
  private long T3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    M3 = localSparseIntArray;
    localSparseIntArray.put(2131363659, 9);
    localSparseIntArray.put(2131363653, 10);
  }
  
  public LayoutPalybackFullBottomBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 11, L3, M3));
  }
  
  private LayoutPalybackFullBottomBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 13, (ImageView)paramArrayOfObject[10], (TextView)paramArrayOfObject[7], (ConstraintLayout)paramArrayOfObject[0], (TimeAxisLayout)paramArrayOfObject[6], (RelativeLayout)paramArrayOfObject[9], (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[1], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[2]);
    paramDataBindingComponent = (TextView)paramArrayOfObject[8];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    setRootTag(paramView);
    this.O3 = new a(this, 4);
    this.P3 = new a(this, 1);
    this.Q3 = new a(this, 5);
    this.R3 = new a(this, 2);
    this.S3 = new a(this, 3);
    invalidateAll();
  }
  
  private boolean A(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean o(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean p(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean q(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean r(ObservableInt paramObservableInt, int paramInt)
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
  
  private boolean s(ObservableField<List<ArrayList<int[]>>> paramObservableField, int paramInt)
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
  
  private boolean t(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean u(ObservableInt paramObservableInt, int paramInt)
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
  
  private boolean v(ObservableInt paramObservableInt, int paramInt)
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
  
  private boolean w(ObservableField<Pair<ArrayList<int[]>, ArrayList<int[]>>> paramObservableField, int paramInt)
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
  
  private boolean x(ObservableFloat paramObservableFloat, int paramInt)
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
  
  private boolean y(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean z(ObservableBoolean paramObservableBoolean, int paramInt)
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
              localg = this.p3;
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
            localg = this.p3;
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
          localg = this.p3;
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
        localg = this.p3;
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
      localg = this.p3;
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
      long l1 = this.T3;
      this.T3 = 0L;
      TimeAxisLayout.b localb = this.K3;
      Object localObject1 = this.I3;
      Object localObject3 = this.H3;
      PlayBackControlViewModel localPlayBackControlViewModel = this.J3;
      boolean bool1 = (l1 & 0x48040) < 0L;
      long l2;
      Drawable localDrawable;
      if (bool1)
      {
        if (localObject1 != null) {
          localObject1 = ((PlaybackMainViewModel)localObject1).h;
        } else {
          localObject1 = null;
        }
        updateRegistration(6, (Observable)localObject1);
        if (localObject1 != null) {
          bool3 = ((ObservableBoolean)localObject1).get();
        } else {
          bool3 = false;
        }
        l2 = l1;
        if (bool1)
        {
          if (bool3) {
            l2 = 16777216L;
          } else {
            l2 = 8388608L;
          }
          l2 = l1 | l2;
        }
        int i;
        if (bool3)
        {
          localObject1 = this.p2.getContext();
          i = 2131231626;
        }
        else
        {
          localObject1 = this.p2.getContext();
          i = 2131231625;
        }
        localDrawable = AppCompatResources.getDrawable((Context)localObject1, i);
      }
      else
      {
        localDrawable = null;
        l2 = l1;
      }
      int j;
      Object localObject4;
      if ((0x50018 & l2) != 0L)
      {
        boolean bool2 = (l2 & 0x50008) < 0L;
        if (bool2)
        {
          if (localObject3 != null) {
            localObject1 = ((VodViewModel)localObject3).R3;
          } else {
            localObject1 = null;
          }
          updateRegistration(3, (Observable)localObject1);
          if (localObject1 != null) {
            bool3 = ((ObservableBoolean)localObject1).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool3) {
              l1 = 4194304L;
            } else {
              l1 = 2097152L;
            }
            l1 = l2 | l1;
          }
          if (bool3)
          {
            localObject1 = this.z.getContext();
            j = 2131231630;
          }
          else
          {
            localObject1 = this.z.getContext();
            j = 2131231624;
          }
          localObject1 = AppCompatResources.getDrawable((Context)localObject1, j);
          l2 = l1;
        }
        else
        {
          localObject1 = null;
        }
        if ((l2 & 0x50010) != 0L)
        {
          if (localObject3 != null) {
            localObject3 = ((VodViewModel)localObject3).U3;
          } else {
            localObject3 = null;
          }
          updateRegistration(4, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            l1 = l2;
            localObject4 = localObject1;
            break label415;
          }
        }
        localObject3 = null;
        l1 = l2;
        localObject4 = localObject1;
      }
      else
      {
        localObject3 = null;
        localObject4 = null;
        l1 = l2;
      }
      label415:
      boolean bool4;
      int k;
      label590:
      Object localObject5;
      label648:
      Object localObject6;
      label707:
      Object localObject7;
      int m;
      int i1;
      label942:
      float f;
      label997:
      label1059:
      Object localObject8;
      if ((l1 & 0x61FA7) != 0L)
      {
        if ((l1 & 0x61103) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject1 = localPlayBackControlViewModel.n4;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null) {
            bool4 = ((ObservableBoolean)localObject1).get();
          } else {
            bool4 = false;
          }
          l2 = l1;
          bool3 = bool4;
          if ((l1 & 0x60003) != 0L) {
            if (bool4)
            {
              l2 = l1 | 0x100000;
              bool3 = bool4;
            }
            else
            {
              l2 = l1 | 0x80000;
              bool3 = bool4;
            }
          }
        }
        else
        {
          bool3 = false;
          l2 = l1;
        }
        if ((l2 & 0x60004) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject1 = localPlayBackControlViewModel.k4;
          } else {
            localObject1 = null;
          }
          updateRegistration(2, (Observable)localObject1);
          if (localObject1 != null)
          {
            k = ((ObservableInt)localObject1).get();
            break label590;
          }
        }
        k = 0;
        if ((l2 & 0x60020) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject1 = localPlayBackControlViewModel.Q3;
          } else {
            localObject1 = null;
          }
          updateRegistration(5, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject5 = (String)((ObservableField)localObject1).get();
            break label648;
          }
        }
        localObject5 = null;
        if ((l2 & 0x60080) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject1 = localPlayBackControlViewModel.l4;
          } else {
            localObject1 = null;
          }
          updateRegistration(7, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject6 = (Pair)((ObservableField)localObject1).get();
            break label707;
          }
        }
        localObject6 = null;
        if ((l2 & 0x61101) != 0L)
        {
          if (localPlayBackControlViewModel != null)
          {
            localObject7 = localPlayBackControlViewModel.o4;
            localObject1 = localPlayBackControlViewModel.p4;
          }
          else
          {
            localObject1 = null;
            localObject7 = null;
          }
          updateRegistration(8, (Observable)localObject7);
          updateRegistration(12, (Observable)localObject1);
          if (localObject7 != null) {
            m = ((ObservableInt)localObject7).get();
          } else {
            m = 0;
          }
          if (localObject1 != null) {
            j = ((ObservableInt)localObject1).get();
          } else {
            j = 0;
          }
        }
        else
        {
          j = 0;
          m = 0;
        }
        n = (l2 & 0x60200) < 0L;
        if (n != 0)
        {
          if (localPlayBackControlViewModel != null) {
            localObject1 = localPlayBackControlViewModel.O3;
          } else {
            localObject1 = null;
          }
          updateRegistration(9, (Observable)localObject1);
          if (localObject1 != null) {
            localObject1 = (String)((ObservableField)localObject1).get();
          } else {
            localObject1 = null;
          }
          if (localObject1 != null) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          l1 = l2;
          if (n != 0)
          {
            if (i1 != 0) {
              l1 = 67108864L;
            } else {
              l1 = 33554432L;
            }
            l1 = l2 | l1;
          }
          if (i1 != 0)
          {
            l2 = l1;
          }
          else
          {
            i1 = 8;
            break label942;
          }
        }
        else
        {
          localObject1 = null;
        }
        i1 = 0;
        l1 = l2;
        if ((l1 & 0x60400) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject7 = localPlayBackControlViewModel.j4;
          } else {
            localObject7 = null;
          }
          updateRegistration(10, (Observable)localObject7);
          if (localObject7 != null)
          {
            f = ((ObservableFloat)localObject7).get();
            break label997;
          }
        }
        f = 0.0F;
        localObject7 = localObject1;
        if ((l1 & 0x60800) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject1 = localPlayBackControlViewModel.m4;
          } else {
            localObject1 = null;
          }
          updateRegistration(11, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (List)((ObservableField)localObject1).get();
            break label1059;
          }
        }
        localObject1 = null;
        localObject8 = localObject5;
        localObject5 = localObject7;
        n = k;
        Object localObject9 = localObject6;
        localObject6 = localObject1;
        k = i1;
        i1 = m;
        bool4 = bool3;
        localObject7 = localObject8;
        localObject1 = localObject9;
        m = n;
      }
      else
      {
        localObject5 = null;
        localObject6 = null;
        k = 0;
        i1 = 0;
        bool4 = false;
        f = 0.0F;
        localObject7 = null;
        localObject1 = null;
        m = 0;
        j = 0;
      }
      if ((l1 & 0x100000) != 0L)
      {
        if (localPlayBackControlViewModel != null) {
          localObject8 = localPlayBackControlViewModel.q4;
        } else {
          localObject8 = null;
        }
        updateRegistration(1, (Observable)localObject8);
        if (localObject8 != null)
        {
          bool3 = ((ObservableBoolean)localObject8).get();
          break label1190;
        }
      }
      boolean bool3 = false;
      label1190:
      int n = (l1 & 0x60003) < 0L;
      if (n != 0)
      {
        if (!bool4) {
          bool3 = false;
        }
      }
      else {
        bool3 = false;
      }
      if (n != 0) {
        b.Q(this.N3, bool3);
      }
      if ((l1 & 0x60200) != 0L)
      {
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject5);
        this.d.setVisibility(k);
      }
      if ((0x44000 & l1) != 0L) {
        b.N(this.q, localb);
      }
      if ((l1 & 0x60400) != 0L) {
        b.P(this.q, f);
      }
      if ((l1 & 0x60004) != 0L) {
        b.L(this.q, m);
      }
      if ((l1 & 0x60080) != 0L) {
        b.O(this.q, (Pair)localObject1);
      }
      if ((l1 & 0x60800) != 0L) {
        b.M(this.q, (List)localObject6);
      }
      if ((l1 & 0x61101) != 0L) {
        b.t(this.q, Boolean.valueOf(bool4), Integer.valueOf(i1), Integer.valueOf(j));
      }
      if ((0x40000 & l1) != 0L)
      {
        this.y.setOnClickListener(this.S3);
        this.z.setOnClickListener(this.P3);
        this.p0.setOnClickListener(this.Q3);
        this.p1.setOnClickListener(this.O3);
        this.p2.setOnClickListener(this.R3);
      }
      if ((l1 & 0x50008) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.z, (Drawable)localObject4);
      }
      if ((l1 & 0x60020) != 0L) {
        TextViewBindingAdapter.setText(this.p0, (CharSequence)localObject7);
      }
      if ((l1 & 0x50010) != 0L) {
        TextViewBindingAdapter.setText(this.p1, (CharSequence)localObject3);
      }
      if ((l1 & 0x48040) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.p2, localDrawable);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.J3 = paramPlayBackControlViewModel;
    try
    {
      this.T3 |= 0x20000;
      notifyPropertyChanged(75);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.T3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.p3 = paramg;
    try
    {
      this.T3 |= 0x2000;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.T3 = 262144L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable TimeAxisLayout.b paramb)
  {
    this.K3 = paramb;
    try
    {
      this.T3 |= 0x4000;
      notifyPropertyChanged(99);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel)
  {
    this.I3 = paramPlaybackMainViewModel;
    try
    {
      this.T3 |= 0x8000;
      notifyPropertyChanged(100);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable VodViewModel paramVodViewModel)
  {
    this.H3 = paramVodViewModel;
    try
    {
      this.T3 |= 0x10000;
      notifyPropertyChanged(107);
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
    case 12: 
      return v((ObservableInt)paramObject, paramInt2);
    case 11: 
      return s((ObservableField)paramObject, paramInt2);
    case 10: 
      return x((ObservableFloat)paramObject, paramInt2);
    case 9: 
      return p((ObservableField)paramObject, paramInt2);
    case 8: 
      return u((ObservableInt)paramObject, paramInt2);
    case 7: 
      return w((ObservableField)paramObject, paramInt2);
    case 6: 
      return y((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return o((ObservableField)paramObject, paramInt2);
    case 4: 
      return A((ObservableField)paramObject, paramInt2);
    case 3: 
      return z((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return r((ObservableInt)paramObject, paramInt2);
    case 1: 
      return q((ObservableBoolean)paramObject, paramInt2);
    }
    return t((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      i((g)paramObject);
    }
    else if (99 == paramInt)
    {
      l((TimeAxisLayout.b)paramObject);
    }
    else if (100 == paramInt)
    {
      m((PlaybackMainViewModel)paramObject);
    }
    else if (107 == paramInt)
    {
      n((VodViewModel)paramObject);
    }
    else
    {
      if (75 != paramInt) {
        break label87;
      }
      h((PlayBackControlViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label87:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPalybackFullBottomBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */