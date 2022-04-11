package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public class LayoutPlaybackToolbarTopBindingImpl
  extends LayoutPlaybackToolbarTopBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final RelativeLayout p0;
  @Nullable
  private final View.OnClickListener p1;
  private long p2 = -1L;
  
  public LayoutPlaybackToolbarTopBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, y, z));
  }
  
  private LayoutPlaybackToolbarTopBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 5, (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[1]);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.c.setTag(null);
    this.d.setTag(null);
    setRootTag(paramView);
    this.p1 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean m(ObservableField<VideoDisplayMode> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p2 |= 1L;
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
        this.p2 |= 0x2;
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
        this.p2 |= 0x8;
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
        this.p2 |= 0x10;
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
        this.p2 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.f;
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
      long l1 = this.p2;
      this.p2 = 0L;
      Object localObject1 = this.x;
      VodViewModel localVodViewModel = this.q;
      boolean bool1 = (l1 & 0x141) < 0L;
      long l2 = l1;
      boolean bool2;
      if (bool1)
      {
        if (localObject1 != null) {
          localObject1 = ((PlaybackMainViewModel)localObject1).p;
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        if (localObject1 != null) {
          localObject1 = (VideoDisplayMode)((ObservableField)localObject1).get();
        } else {
          localObject1 = null;
        }
        if (localObject1 == VideoDisplayMode.PLAY_BACK) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        l2 = l1;
        if (bool1)
        {
          if (bool2) {
            l2 = 1024L;
          } else {
            l2 = 512L;
          }
          l2 = l1 | l2;
        }
        if (!bool2)
        {
          i = 8;
          break label146;
        }
      }
      int i = 0;
      label146:
      boolean bool3;
      int j;
      Object localObject3;
      label394:
      Object localObject4;
      if ((0x19E & l2) != 0L)
      {
        bool2 = (l2 & 0x182) < 0L;
        if (bool2)
        {
          if (localVodViewModel != null) {
            localObject1 = localVodViewModel.S3;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null) {
            bool3 = ((ObservableBoolean)localObject1).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool3)
            {
              l1 = l2 | 0x1000;
              l2 = 16384L;
            }
            else
            {
              l1 = l2 | 0x800;
              l2 = 8192L;
            }
            l1 |= l2;
          }
          localObject1 = this.c.getContext();
          if (bool3) {
            j = 2131231400;
          } else {
            j = 2131231231;
          }
          localObject3 = AppCompatResources.getDrawable((Context)localObject1, j);
          if (bool3)
          {
            localObject1 = this.c;
            j = 2131099808;
          }
          else
          {
            localObject1 = this.c;
            j = 2131099740;
          }
          j = ViewDataBinding.getColorFromResource((View)localObject1, j);
          l2 = l1;
          localObject1 = localObject3;
        }
        else
        {
          j = 0;
          localObject1 = null;
        }
        if ((l2 & 0x184) != 0L)
        {
          if (localVodViewModel != null) {
            localObject3 = localVodViewModel.O3;
          } else {
            localObject3 = null;
          }
          updateRegistration(2, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label394;
          }
        }
        localObject3 = null;
        if ((l2 & 0x188) != 0L)
        {
          if (localVodViewModel != null) {
            localObject4 = localVodViewModel.N3;
          } else {
            localObject4 = null;
          }
          updateRegistration(3, (Observable)localObject4);
          if (localObject4 != null)
          {
            bool3 = ((ObservableBoolean)localObject4).get();
            break label449;
          }
        }
        bool3 = false;
        label449:
        if ((l2 & 0x190) != 0L)
        {
          if (localVodViewModel != null) {
            localObject4 = localVodViewModel.U3;
          } else {
            localObject4 = null;
          }
          updateRegistration(4, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label507;
          }
        }
        localObject4 = null;
      }
      else
      {
        label507:
        bool3 = false;
        localObject1 = null;
        localObject3 = null;
        j = 0;
        localObject4 = null;
      }
      if ((l2 & 0x190) != 0L) {
        TextViewBindingAdapter.setText(this.c, (CharSequence)localObject4);
      }
      if ((l2 & 0x182) != 0L)
      {
        ViewBindingAdapter.setBackground(this.c, (Drawable)localObject1);
        this.c.setTextColor(j);
      }
      if ((0x100 & l2) != 0L) {
        this.c.setOnClickListener(this.p1);
      }
      if ((0x141 & l2) != 0L) {
        this.c.setVisibility(i);
      }
      if ((l2 & 0x184) != 0L) {
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject3);
      }
      if ((l2 & 0x188) != 0L) {
        b.Q(this.d, bool3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.f = paramg;
    try
    {
      this.p2 |= 0x20;
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
      return this.p2 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel)
  {
    this.x = paramPlaybackMainViewModel;
    try
    {
      this.p2 |= 0x40;
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
      this.p2 = 256L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable VodViewModel paramVodViewModel)
  {
    this.q = paramVodViewModel;
    try
    {
      this.p2 |= 0x80;
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
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4) {
              return false;
            }
            return p((ObservableField)paramObject, paramInt2);
          }
          return o((ObservableBoolean)paramObject, paramInt2);
        }
        return q((ObservableField)paramObject, paramInt2);
      }
      return n((ObservableBoolean)paramObject, paramInt2);
    }
    return m((ObservableField)paramObject, paramInt2);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlaybackToolbarTopBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */