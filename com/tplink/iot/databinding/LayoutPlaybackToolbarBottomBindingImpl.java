package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public class LayoutPlaybackToolbarBottomBindingImpl
  extends LayoutPlaybackToolbarBottomBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts K3;
  @Nullable
  private static final SparseIntArray L3;
  @NonNull
  private final ConstraintLayout M3;
  @Nullable
  private final View.OnClickListener N3;
  @Nullable
  private final View.OnClickListener O3;
  @Nullable
  private final View.OnClickListener P3;
  @Nullable
  private final View.OnClickListener Q3;
  @Nullable
  private final View.OnClickListener R3;
  private long S3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    L3 = localSparseIntArray;
    localSparseIntArray.put(2131362741, 6);
    localSparseIntArray.put(2131362742, 7);
    localSparseIntArray.put(2131362743, 8);
    localSparseIntArray.put(2131362744, 9);
    localSparseIntArray.put(2131362745, 10);
    localSparseIntArray.put(2131362746, 11);
  }
  
  public LayoutPlaybackToolbarBottomBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 12, K3, L3));
  }
  
  private LayoutPlaybackToolbarBottomBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (Guideline)paramArrayOfObject[6], (Guideline)paramArrayOfObject[7], (Guideline)paramArrayOfObject[8], (Guideline)paramArrayOfObject[9], (Guideline)paramArrayOfObject[10], (Guideline)paramArrayOfObject[11], (ImageView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[4], (ImageView)paramArrayOfObject[3]);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    this.p3.setTag(null);
    setRootTag(paramView);
    this.N3 = new a(this, 5);
    this.O3 = new a(this, 3);
    this.P3 = new a(this, 1);
    this.Q3 = new a(this, 4);
    this.R3 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean m(ObservableField<VideoDisplayMode> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.S3 |= 0x4;
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
        this.S3 |= 1L;
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
        this.S3 |= 0x8;
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
        this.S3 |= 0x2;
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
              localg = this.H3;
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
            localg = this.H3;
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
          localg = this.H3;
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
        localg = this.H3;
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
      localg = this.H3;
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
      long l1 = this.S3;
      this.S3 = 0L;
      Object localObject1 = this.J3;
      VodViewModel localVodViewModel = this.I3;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5;
      boolean bool2;
      long l2;
      boolean bool3;
      Object localObject7;
      if ((0xA5 & l1) != 0L)
      {
        boolean bool1 = (l1 & 0xA1) < 0L;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject5 = ((PlaybackMainViewModel)localObject1).h;
          } else {
            localObject5 = null;
          }
          updateRegistration(0, (Observable)localObject5);
          if (localObject5 != null) {
            bool2 = ((ObservableBoolean)localObject5).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 32768L;
            } else {
              l2 = 16384L;
            }
            l2 = l1 | l2;
          }
          if (bool2)
          {
            localObject5 = this.p2.getContext();
            i = 2131231626;
          }
          else
          {
            localObject5 = this.p2.getContext();
            i = 2131231625;
          }
          localObject5 = AppCompatResources.getDrawable((Context)localObject5, i);
          l1 = l2;
        }
        else
        {
          localObject5 = null;
        }
        bool3 = (l1 & 0xA4) < 0L;
        l2 = l1;
        localObject7 = localObject5;
        if (bool3)
        {
          if (localObject1 != null) {
            localObject7 = ((PlaybackMainViewModel)localObject1).p;
          } else {
            localObject7 = null;
          }
          updateRegistration(2, (Observable)localObject7);
          if (localObject7 != null) {
            localObject7 = (VideoDisplayMode)((ObservableField)localObject7).get();
          } else {
            localObject7 = null;
          }
          if (localObject7 == VideoDisplayMode.PLAY_BACK) {
            i = 1;
          } else {
            i = 0;
          }
          l2 = l1;
          if (bool3)
          {
            if (i != 0) {
              l2 = 512L;
            } else {
              l2 = 256L;
            }
            l2 = l1 | l2;
          }
          if (i != 0)
          {
            localObject7 = localObject5;
          }
          else
          {
            i = 8;
            l1 = l2;
            localObject1 = localObject5;
            break label339;
          }
        }
      }
      else
      {
        localObject7 = null;
        l2 = l1;
      }
      int i = 0;
      localObject1 = localObject7;
      l1 = l2;
      label339:
      if ((l1 & 0xCA) != 0L)
      {
        bool3 = (l1 & 0xC2) < 0L;
        if (bool3)
        {
          if (localVodViewModel != null) {
            localObject5 = localVodViewModel.R3;
          } else {
            localObject5 = null;
          }
          updateRegistration(1, (Observable)localObject5);
          if (localObject5 != null) {
            bool2 = ((ObservableBoolean)localObject5).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool3)
          {
            if (bool2) {
              l2 = 2048L;
            } else {
              l2 = 1024L;
            }
            l2 = l1 | l2;
          }
          localObject5 = this.p1.getContext();
          int j;
          if (bool2) {
            j = 2131231630;
          } else {
            j = 2131231624;
          }
          localObject5 = AppCompatResources.getDrawable((Context)localObject5, j);
          l1 = l2;
        }
        else
        {
          localObject5 = null;
        }
        boolean bool4 = (l1 & 0xC8) < 0L;
        l2 = l1;
        localObject7 = localObject2;
        if (bool4)
        {
          localObject7 = localObject4;
          if (localVodViewModel != null) {
            localObject7 = localVodViewModel.N3;
          }
          updateRegistration(3, (Observable)localObject7);
          if (localObject7 != null) {
            bool2 = ((ObservableBoolean)localObject7).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool4)
          {
            if (bool2) {
              l2 = 8192L;
            } else {
              l2 = 4096L;
            }
            l2 = l1 | l2;
          }
          localObject7 = this.p3.getContext();
          int k;
          if (bool2) {
            k = 2131231632;
          } else {
            k = 2131231631;
          }
          localObject7 = AppCompatResources.getDrawable((Context)localObject7, k);
        }
        l1 = l2;
      }
      else
      {
        localObject7 = null;
        localObject5 = localObject3;
      }
      if ((0x80 & l1) != 0L)
      {
        this.z.setOnClickListener(this.N3);
        this.p0.setOnClickListener(this.R3);
        this.p1.setOnClickListener(this.P3);
        this.p2.setOnClickListener(this.Q3);
        this.p3.setOnClickListener(this.O3);
      }
      if ((l1 & 0xC2) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.p1, (Drawable)localObject5);
      }
      if ((l1 & 0xA4) != 0L) {
        this.p1.setVisibility(i);
      }
      if ((l1 & 0xA1) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.p2, (Drawable)localObject1);
      }
      if ((l1 & 0xC8) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.p3, (Drawable)localObject7);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.H3 = paramg;
    try
    {
      this.S3 |= 0x10;
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
      return this.S3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel)
  {
    this.J3 = paramPlaybackMainViewModel;
    try
    {
      this.S3 |= 0x20;
      notifyPropertyChanged(100);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.S3 = 128L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable VodViewModel paramVodViewModel)
  {
    this.I3 = paramVodViewModel;
    try
    {
      this.S3 |= 0x40;
      notifyPropertyChanged(107);
      super.requestRebind();
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
          return o((ObservableBoolean)paramObject, paramInt2);
        }
        return m((ObservableField)paramObject, paramInt2);
      }
      return p((ObservableBoolean)paramObject, paramInt2);
    }
    return n((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      h((g)paramObject);
    }
    else if (100 == paramInt)
    {
      i((PlaybackMainViewModel)paramObject);
    }
    else
    {
      if (107 != paramInt) {
        break label53;
      }
      l((VodViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlaybackToolbarBottomBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */