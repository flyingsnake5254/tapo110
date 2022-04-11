package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public class PlayBackRulerLayoutBindingImpl
  extends PlayBackRulerLayoutBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts y;
  @Nullable
  private static final SparseIntArray z = null;
  @NonNull
  private final ScrollView p0;
  @NonNull
  private final RelativeLayout p1;
  private long p2 = -1L;
  
  static
  {
    ViewDataBinding.IncludedLayouts localIncludedLayouts = new ViewDataBinding.IncludedLayouts(4);
    y = localIncludedLayouts;
    localIncludedLayouts.setIncludes(1, new String[] { "play_back_time_ruler", "play_back_bottom_bar" }, new int[] { 2, 3 }, new int[] { 2131559330, 2131559327 });
  }
  
  public PlayBackRulerLayoutBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, y, z));
  }
  
  private PlayBackRulerLayoutBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (PlayBackTimeRulerBinding)paramArrayOfObject[2], (PlayBackBottomBarBinding)paramArrayOfObject[3]);
    paramDataBindingComponent = (ScrollView)paramArrayOfObject[0];
    this.p0 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[1];
    this.p1 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setContainedBinding(this.c);
    setContainedBinding(this.d);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean m(PlayBackTimeRulerBinding paramPlayBackTimeRulerBinding, int paramInt)
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
  
  private boolean n(PlayBackBottomBarBinding paramPlayBackBottomBarBinding, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p2;
      this.p2 = 0L;
      g localg = this.q;
      TimeAxisLayout.b localb = this.x;
      PlayBackControlViewModel localPlayBackControlViewModel = this.f;
      if ((0x24 & l) != 0L)
      {
        this.c.h(localg);
        this.d.h(localg);
      }
      if ((l & 0x30) != 0L)
      {
        this.c.l(localPlayBackControlViewModel);
        this.d.i(localPlayBackControlViewModel);
      }
      if ((0x28 & l) != 0L) {
        this.c.i(localb);
      }
      ViewDataBinding.executeBindingsOn(this.c);
      ViewDataBinding.executeBindingsOn(this.d);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.q = paramg;
    try
    {
      this.p2 |= 0x4;
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
      if (this.p2 != 0L) {
        return true;
      }
      if (this.c.hasPendingBindings()) {
        return true;
      }
      return this.d.hasPendingBindings();
    }
    finally {}
  }
  
  public void i(@Nullable TimeAxisLayout.b paramb)
  {
    this.x = paramb;
    try
    {
      this.p2 |= 0x8;
      notifyPropertyChanged(99);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p2 = 32L;
      this.c.invalidateAll();
      this.d.invalidateAll();
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.f = paramPlayBackControlViewModel;
    try
    {
      this.p2 |= 0x10;
      notifyPropertyChanged(105);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return false;
      }
      return n((PlayBackBottomBarBinding)paramObject, paramInt2);
    }
    return m((PlayBackTimeRulerBinding)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.c.setLifecycleOwner(paramLifecycleOwner);
    this.d.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      h((g)paramObject);
    }
    else if (99 == paramInt)
    {
      i((TimeAxisLayout.b)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label53;
      }
      l((PlayBackControlViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackRulerLayoutBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */