package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public class LayoutMultiLiveToolbarBottomBindingImpl
  extends LayoutMultiLiveToolbarBottomBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts N3;
  @Nullable
  private static final SparseIntArray O3;
  @NonNull
  private final ConstraintLayout P3;
  @Nullable
  private final View.OnClickListener Q3;
  @Nullable
  private final View.OnClickListener R3;
  @Nullable
  private final View.OnClickListener S3;
  @Nullable
  private final View.OnClickListener T3;
  @Nullable
  private final View.OnClickListener U3;
  @Nullable
  private final View.OnClickListener V3;
  @Nullable
  private final View.OnClickListener W3;
  private long X3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    O3 = localSparseIntArray;
    localSparseIntArray.put(2131362741, 8);
    localSparseIntArray.put(2131362742, 9);
    localSparseIntArray.put(2131362743, 10);
    localSparseIntArray.put(2131362744, 11);
    localSparseIntArray.put(2131362745, 12);
    localSparseIntArray.put(2131362746, 13);
  }
  
  public LayoutMultiLiveToolbarBottomBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 14, N3, O3));
  }
  
  private LayoutMultiLiveToolbarBottomBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 10, (Guideline)paramArrayOfObject[8], (Guideline)paramArrayOfObject[9], (Guideline)paramArrayOfObject[10], (Guideline)paramArrayOfObject[11], (Guideline)paramArrayOfObject[12], (Guideline)paramArrayOfObject[13], (TextView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[7], (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[6], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[1]);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.P3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.p3.setTag(null);
    this.H3.setTag(null);
    this.I3.setTag(null);
    setRootTag(paramView);
    this.Q3 = new a(this, 2);
    this.R3 = new a(this, 5);
    this.S3 = new a(this, 3);
    this.T3 = new a(this, 7);
    this.U3 = new a(this, 6);
    this.V3 = new a(this, 4);
    this.W3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.X3 |= 0x8;
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
        this.X3 |= 0x40;
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
        this.X3 |= 0x100;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.X3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableField<VideoDisplayMode> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.X3 |= 0x20;
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
        this.X3 |= 0x200;
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
        this.X3 |= 0x4;
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
        this.X3 |= 0x2;
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
        this.X3 |= 1L;
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
        this.X3 |= 0x80;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    int i = 1;
    int j = 1;
    int k = 1;
    int m = 1;
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    g localg;
    switch (paramInt)
    {
    default: 
      break;
    case 7: 
      localg = this.J3;
      if (localg != null) {
        paramInt = i2;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 6: 
      localg = this.J3;
      if (localg != null) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 5: 
      localg = this.J3;
      if (localg != null) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 4: 
      localg = this.J3;
      if (localg != null) {
        paramInt = k;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 3: 
      localg = this.J3;
      if (localg != null) {
        paramInt = m;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 2: 
      localg = this.J3;
      if (localg != null) {
        paramInt = n;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    case 1: 
      localg = this.J3;
      if (localg != null) {
        paramInt = i1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        localg.onClick(paramView);
      }
      break;
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.X3;
      this.X3 = 0L;
      VideoPlayViewModel localVideoPlayViewModel = this.K3;
      Object localObject1 = this.L3;
      Object localObject2 = this.M3;
      int i;
      boolean bool1;
      boolean bool8;
      if ((0x4624 & l1) != 0L)
      {
        i = (l1 & 0x4420) < 0L;
        int j;
        if (i != 0)
        {
          if (localVideoPlayViewModel != null) {
            localObject3 = localVideoPlayViewModel.F;
          } else {
            localObject3 = null;
          }
          updateRegistration(5, (Observable)localObject3);
          if (localObject3 != null) {
            localObject3 = (VideoDisplayMode)((ObservableField)localObject3).get();
          } else {
            localObject3 = null;
          }
          if (localObject3 == VideoDisplayMode.PLAY_BACK) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (localObject3 == VideoDisplayMode.LIVE_STREAM) {
            j = 1;
          } else {
            j = 0;
          }
          l2 = l1;
          if (i != 0)
          {
            if (j != 0) {
              l2 = 16777216L;
            } else {
              l2 = 8388608L;
            }
            l2 = l1 | l2;
          }
          if (j != 0)
          {
            j = 0;
            l1 = l2;
          }
          else
          {
            j = 8;
            l1 = l2;
          }
        }
        else
        {
          j = 0;
          bool1 = false;
        }
        bool7 = (l1 & 0x4604) < 0L;
        l2 = l1;
        i = j;
        bool8 = bool1;
        if (bool7)
        {
          if (localVideoPlayViewModel != null) {
            localObject3 = localVideoPlayViewModel.r;
          } else {
            localObject3 = null;
          }
          updateRegistration(9, (Observable)localObject3);
          if (localObject3 != null) {
            bool8 = ((ObservableBoolean)localObject3).get();
          } else {
            bool8 = false;
          }
          l2 = l1;
          i = j;
          bool9 = bool1;
          bool10 = bool8;
          if (!bool7) {
            break label349;
          }
          if (bool8)
          {
            l2 = l1 | 0x100000;
            i = j;
            bool9 = bool1;
            bool10 = bool8;
            break label349;
          }
          l2 = l1 | 0x80000;
          i = j;
          bool9 = bool1;
          bool10 = bool8;
          break label349;
        }
      }
      else
      {
        i = 0;
        bool8 = false;
        l2 = l1;
      }
      boolean bool10 = false;
      boolean bool9 = bool8;
      label349:
      Object localObject5;
      Object localObject6;
      label558:
      Object localObject7;
      boolean bool11;
      Object localObject8;
      if ((l2 & 0x5158) != 0L)
      {
        boolean bool2 = (l2 & 0x5008) < 0L;
        if (bool2)
        {
          if (localObject1 != null) {
            localObject3 = ((MultiLiveVideoViewModel)localObject1).p0;
          } else {
            localObject3 = null;
          }
          updateRegistration(3, (Observable)localObject3);
          if (localObject3 != null) {
            bool1 = ((ObservableBoolean)localObject3).get();
          } else {
            bool1 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool1) {
              l1 = 65536L;
            } else {
              l1 = 32768L;
            }
            l1 = l2 | l1;
          }
          int k;
          if (bool1)
          {
            localObject3 = this.I3.getContext();
            k = 2131231663;
          }
          else
          {
            localObject3 = this.I3.getContext();
            k = 2131231664;
          }
          localObject3 = AppCompatResources.getDrawable((Context)localObject3, k);
          l2 = l1;
        }
        else
        {
          localObject3 = null;
        }
        if ((l2 & 0x5010) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((MultiLiveVideoViewModel)localObject1).f4;
          } else {
            localObject5 = null;
          }
          updateRegistration(4, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject6 = (String)((ObservableField)localObject5).get();
            break label558;
          }
        }
        localObject6 = null;
        boolean bool3 = (l2 & 0x5040) < 0L;
        if (bool3)
        {
          if (localObject1 != null) {
            localObject5 = ((MultiLiveVideoViewModel)localObject1).e4;
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
          if (bool3)
          {
            if (bool1) {
              l1 = 1073741824L;
            } else {
              l1 = 536870912L;
            }
            l1 = l2 | l1;
          }
          localObject5 = this.H3.getContext();
          int m;
          if (bool1) {
            m = 2131231632;
          } else {
            m = 2131231631;
          }
          localObject7 = AppCompatResources.getDrawable((Context)localObject5, m);
          l2 = l1;
        }
        else
        {
          bool1 = false;
          localObject7 = null;
        }
        boolean bool4 = (l2 & 0x5100) < 0L;
        if (bool4)
        {
          if (localObject1 != null) {
            localObject5 = ((MultiLiveVideoViewModel)localObject1).j4;
          } else {
            localObject5 = null;
          }
          updateRegistration(8, (Observable)localObject5);
          if (localObject5 != null) {
            bool8 = ((ObservableBoolean)localObject5).get();
          } else {
            bool8 = false;
          }
          l1 = l2;
          if (bool4)
          {
            if (bool8) {
              l1 = 268435456L;
            } else {
              l1 = 134217728L;
            }
            l1 = l2 | l1;
          }
          int n;
          if (bool8)
          {
            localObject5 = this.p2.getContext();
            n = 2131231630;
          }
          else
          {
            localObject5 = this.p2.getContext();
            n = 2131231624;
          }
          localObject5 = AppCompatResources.getDrawable((Context)localObject5, n);
          bool11 = bool1;
          localObject1 = localObject7;
          localObject8 = localObject3;
          localObject7 = localObject6;
        }
        else
        {
          localObject5 = null;
          l1 = l2;
          bool11 = bool1;
          localObject1 = localObject7;
          localObject8 = localObject3;
          localObject7 = localObject6;
        }
      }
      else
      {
        localObject5 = null;
        bool11 = false;
        localObject1 = null;
        localObject8 = null;
        localObject7 = null;
        l1 = l2;
      }
      if ((0x6083 & l1) != 0L)
      {
        boolean bool5 = (l1 & 0x6003) < 0L;
        if (bool5)
        {
          if (localObject2 != null) {
            localObject3 = ((TalkViewModel)localObject2).t;
          } else {
            localObject3 = null;
          }
          updateRegistration(0, (Observable)localObject3);
          if (localObject3 != null) {
            bool8 = ((ObservableBoolean)localObject3).get();
          } else {
            bool8 = false;
          }
          l2 = l1;
          bool1 = bool8;
          if (bool5) {
            if (bool8)
            {
              l2 = l1 | 0x400000;
              bool1 = bool8;
            }
            else
            {
              l2 = l1 | 0x200000;
              bool1 = bool8;
            }
          }
        }
        else
        {
          bool1 = false;
          l2 = l1;
        }
        l1 = l2;
        bool8 = bool1;
        if ((l2 & 0x6080) != 0L)
        {
          if (localObject2 != null) {
            localObject3 = ((TalkViewModel)localObject2).k;
          } else {
            localObject3 = null;
          }
          updateRegistration(7, (Observable)localObject3);
          l1 = l2;
          bool8 = bool1;
          if (localObject3 != null)
          {
            bool12 = ((ObservableBoolean)localObject3).get();
            bool8 = bool1;
            break label1090;
          }
        }
      }
      else
      {
        bool8 = false;
      }
      boolean bool12 = false;
      long l2 = l1;
      label1090:
      if ((l2 & 0x600000) != 0L)
      {
        if (localObject2 != null) {
          localObject3 = ((TalkViewModel)localObject2).e;
        } else {
          localObject3 = null;
        }
        updateRegistration(1, (Observable)localObject3);
        int i1;
        if (localObject3 != null) {
          i1 = ((ObservableInt)localObject3).get();
        } else {
          i1 = 0;
        }
        if (i1 == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        l1 = l2;
        if ((l2 & 0x400000) != 0L)
        {
          if (i1 != 0) {
            l1 = 262144L;
          } else {
            l1 = 131072L;
          }
          l1 = l2 | l1;
        }
        l2 = l1;
        if ((l1 & 0x200000) != 0L)
        {
          if (i1 != 0) {
            l2 = 67108864L;
          } else {
            l2 = 33554432L;
          }
          l2 = l1 | l2;
        }
        if ((l2 & 0x400000) != 0L)
        {
          if (i1 != 0) {
            localObject3 = AppCompatResources.getDrawable(this.p3.getContext(), 2131231627);
          } else {
            localObject3 = AppCompatResources.getDrawable(this.p3.getContext(), 2131231629);
          }
        }
        else {
          localObject3 = null;
        }
        l1 = l2;
        localObject6 = localObject3;
        if ((l2 & 0x200000) != 0L)
        {
          localObject6 = this.p3.getContext();
          if (i1 != 0) {
            i1 = 2131231626;
          } else {
            i1 = 2131231625;
          }
          localObject2 = AppCompatResources.getDrawable((Context)localObject6, i1);
          localObject6 = localObject3;
          localObject3 = localObject2;
          break label1363;
        }
      }
      else
      {
        localObject6 = null;
        l1 = l2;
      }
      Object localObject3 = null;
      l2 = l1;
      label1363:
      if ((l2 & 0x80000) != 0L)
      {
        if (localVideoPlayViewModel != null) {
          localObject2 = localVideoPlayViewModel.D;
        } else {
          localObject2 = null;
        }
        updateRegistration(2, (Observable)localObject2);
        if (localObject2 != null) {
          bool1 = ((ObservableBoolean)localObject2).get();
        } else {
          bool1 = false;
        }
        bool1 ^= true;
      }
      else
      {
        bool1 = false;
      }
      boolean bool13 = true;
      boolean bool6 = (l2 & 0x4604) < 0L;
      if (bool6)
      {
        if (bool10) {
          bool1 = bool13;
        }
      }
      else {
        bool1 = false;
      }
      boolean bool7 = (l2 & 0x6003) < 0L;
      if (bool7)
      {
        if (!bool8) {
          localObject6 = localObject3;
        }
      }
      else {
        localObject6 = null;
      }
      if ((l2 & 0x4000) != 0L)
      {
        this.z.setOnClickListener(this.R3);
        this.p0.setOnClickListener(this.T3);
        this.p1.setOnClickListener(this.S3);
        this.p2.setOnClickListener(this.Q3);
        this.p3.setOnClickListener(this.U3);
        this.H3.setOnClickListener(this.V3);
        this.I3.setOnClickListener(this.W3);
      }
      if ((l2 & 0x5010) != 0L) {
        TextViewBindingAdapter.setText(this.z, (CharSequence)localObject7);
      }
      if ((l2 & 0x5040) != 0L)
      {
        b.Q(this.z, bool11);
        ImageViewBindingAdapter.setImageDrawable(this.H3, (Drawable)localObject1);
      }
      if ((0x4600 & l2) != 0L) {
        b.c(this.p0, Boolean.valueOf(bool10), null);
      }
      if (bool6)
      {
        b.c(this.p1, Boolean.valueOf(bool1), null);
        b.c(this.p2, Boolean.valueOf(bool1), null);
        b.c(this.p3, Boolean.valueOf(bool1), null);
        b.c(this.H3, Boolean.valueOf(bool1), null);
      }
      if ((l2 & 0x5100) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.p2, (Drawable)localObject5);
      }
      if ((0x4420 & l2) != 0L)
      {
        b.Q(this.p2, bool9);
        this.I3.setVisibility(i);
      }
      if (bool7) {
        ImageViewBindingAdapter.setImageDrawable(this.p3, (Drawable)localObject6);
      }
      if ((l2 & 0x5008) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.I3, (Drawable)localObject8);
      }
      if ((l2 & 0x6080) != 0L) {
        b.c(this.I3, Boolean.valueOf(bool12), null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel)
  {
    this.L3 = paramMultiLiveVideoViewModel;
    try
    {
      this.X3 |= 0x1000;
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
      return this.X3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel)
  {
    this.K3 = paramVideoPlayViewModel;
    try
    {
      this.X3 |= 0x400;
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
      this.X3 = 16384L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable g paramg)
  {
    this.J3 = paramg;
    try
    {
      this.X3 |= 0x800;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable TalkViewModel paramTalkViewModel)
  {
    this.M3 = paramTalkViewModel;
    try
    {
      this.X3 |= 0x2000;
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
    case 9: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 8: 
      return p((ObservableBoolean)paramObject, paramInt2);
    case 7: 
      return w((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return o((ObservableBoolean)paramObject, paramInt2);
    case 5: 
      return r((ObservableField)paramObject, paramInt2);
    case 4: 
      return q((ObservableField)paramObject, paramInt2);
    case 3: 
      return n((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return t((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return u((ObservableInt)paramObject, paramInt2);
    }
    return v((ObservableBoolean)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutMultiLiveToolbarBottomBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */