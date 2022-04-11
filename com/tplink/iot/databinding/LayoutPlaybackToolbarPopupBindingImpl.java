package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public class LayoutPlaybackToolbarPopupBindingImpl
  extends LayoutPlaybackToolbarPopupBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z;
  @NonNull
  private final LinearLayout p0;
  @Nullable
  private final View.OnClickListener p1;
  @Nullable
  private final View.OnClickListener p2;
  private long p3 = -1L;
  
  public LayoutPlaybackToolbarPopupBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, y, z));
  }
  
  private LayoutPlaybackToolbarPopupBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[2]);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.c.setTag(null);
    this.d.setTag(null);
    setRootTag(paramView);
    this.p1 = new a(this, 1);
    this.p2 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 1L;
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
        localg = this.f;
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
      localg = this.f;
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
      long l1 = this.p3;
      this.p3 = 0L;
      VodViewModel localVodViewModel = this.q;
      Object localObject1 = null;
      Object localObject3 = null;
      boolean bool1 = (l1 & 0x19) < 0L;
      long l2 = l1;
      if (bool1)
      {
        localObject1 = localObject3;
        if (localVodViewModel != null) {
          localObject1 = localVodViewModel.N3;
        }
        boolean bool2 = false;
        updateRegistration(0, (Observable)localObject1);
        if (localObject1 != null) {
          bool2 = ((ObservableBoolean)localObject1).get();
        }
        l2 = l1;
        if (bool1)
        {
          if (bool2) {
            l2 = 64L;
          } else {
            l2 = 32L;
          }
          l2 = l1 | l2;
        }
        int i;
        if (bool2)
        {
          localObject1 = this.d.getContext();
          i = 2131231632;
        }
        else
        {
          localObject1 = this.d.getContext();
          i = 2131231631;
        }
        localObject1 = AppCompatResources.getDrawable((Context)localObject1, i);
      }
      if ((0x10 & l2) != 0L)
      {
        this.c.setOnClickListener(this.p1);
        this.d.setOnClickListener(this.p2);
      }
      if ((l2 & 0x19) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.d, (Drawable)localObject1);
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
      this.p3 |= 0x4;
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
      return this.p3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel)
  {
    this.x = paramPlaybackMainViewModel;
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 16L;
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
      this.p3 |= 0x8;
      notifyPropertyChanged(107);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return m((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (100 == paramInt)
    {
      i((PlaybackMainViewModel)paramObject);
    }
    else if (79 == paramInt)
    {
      h((g)paramObject);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlaybackToolbarPopupBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */