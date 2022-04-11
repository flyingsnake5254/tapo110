package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public class ExoPlaybackControlViewBindingImpl
  extends ExoPlaybackControlViewBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts J3;
  @Nullable
  private static final SparseIntArray K3;
  @Nullable
  private final DialogMemorySlideOperationBinding L3;
  @NonNull
  private final TextView M3;
  @Nullable
  private final View.OnClickListener N3;
  private long O3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(13);
    J3 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(1, new String[] { "dialog_memory_slide_operation" }, new int[] { 6 }, new int[] { 2131558808 });
    localObject = new SparseIntArray();
    K3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131362572, 7);
    ((SparseIntArray)localObject).put(2131364761, 8);
    ((SparseIntArray)localObject).put(2131362592, 9);
    ((SparseIntArray)localObject).put(2131362591, 10);
    ((SparseIntArray)localObject).put(2131362595, 11);
    ((SparseIntArray)localObject).put(2131362597, 12);
  }
  
  public ExoPlaybackControlViewBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 13, J3, K3));
  }
  
  private ExoPlaybackControlViewBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (ImageView)paramArrayOfObject[2], (RelativeLayout)paramArrayOfObject[7], (LinearLayout)paramArrayOfObject[0], (TextView)paramArrayOfObject[5], (ImageView)paramArrayOfObject[10], (ImageView)paramArrayOfObject[9], (TextView)paramArrayOfObject[11], (DefaultTimeBar)paramArrayOfObject[12], (RelativeLayout)paramArrayOfObject[4], (RelativeLayout)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[8]);
    this.c.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (DialogMemorySlideOperationBinding)paramArrayOfObject[6];
    this.L3 = paramDataBindingComponent;
    setContainedBinding(paramDataBindingComponent);
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p1.setTag(null);
    this.p2.setTag(null);
    setRootTag(paramView);
    this.N3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean l(ObservableField<CharSequence> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.O3 |= 0x2;
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
        this.O3 |= 1L;
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
      long l1 = this.O3;
      this.O3 = 0L;
      MemoriesViewModel localMemoriesViewModel = this.I3;
      g localg = this.H3;
      int i = 0;
      int j = 0;
      boolean bool1 = false;
      Object localObject1;
      long l2;
      int k;
      if ((0x17 & l1) != 0L)
      {
        boolean bool2 = (l1 & 0x15) < 0L;
        if (bool2)
        {
          if (localMemoriesViewModel != null) {
            localObject1 = localMemoriesViewModel.l;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null) {
            bool1 = ((ObservableBoolean)localObject1).get();
          }
          bool1 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool1));
          l2 = l1;
          if (bool2)
          {
            if (bool1)
            {
              l1 = l1 | 0x40 | 0x100;
              l2 = 1024L;
            }
            else
            {
              l1 = l1 | 0x20 | 0x80;
              l2 = 512L;
            }
            l2 = l1 | l2;
          }
          if (bool1) {
            k = 10;
          } else {
            k = 6;
          }
          if (bool1) {
            i = 30;
          } else {
            i = 14;
          }
          if (bool1) {
            j = 16;
          } else {
            j = 12;
          }
          int m = j;
          j = i;
          i = k;
          k = m;
        }
        else
        {
          j = 0;
          k = 0;
          l2 = l1;
        }
        if ((l2 & 0x16) != 0L)
        {
          if (localMemoriesViewModel != null) {
            localObject1 = localMemoriesViewModel.j;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (CharSequence)((ObservableField)localObject1).get();
            break label288;
          }
        }
        localObject1 = null;
      }
      else
      {
        label288:
        i = 0;
        k = 0;
        localObject1 = null;
        l2 = l1;
      }
      if ((0x10 & l2) != 0L) {
        this.c.setOnClickListener(this.N3);
      }
      if ((l2 & 0x15) != 0L)
      {
        b.x(this.q, Integer.valueOf(j));
        b.x(this.p1, Integer.valueOf(i));
        b.y(this.p1, Integer.valueOf(k));
      }
      if ((0x14 & l2) != 0L) {
        this.L3.h(localMemoriesViewModel);
      }
      if ((0x18 & l2) != 0L) {
        this.L3.i(localg);
      }
      if ((l2 & 0x16) != 0L) {
        TextViewBindingAdapter.setText(this.M3, (CharSequence)localObject1);
      }
      ViewDataBinding.executeBindingsOn(this.L3);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MemoriesViewModel paramMemoriesViewModel)
  {
    this.I3 = paramMemoriesViewModel;
    try
    {
      this.O3 |= 0x4;
      notifyPropertyChanged(62);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      if (this.O3 != 0L) {
        return true;
      }
      return this.L3.hasPendingBindings();
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.H3 = paramg;
    try
    {
      this.O3 |= 0x8;
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
      this.O3 = 16L;
      this.L3.invalidateAll();
      requestRebind();
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
      return l((ObservableField)paramObject, paramInt2);
    }
    return m((ObservableBoolean)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.L3.setLifecycleOwner(paramLifecycleOwner);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (62 == paramInt)
    {
      h((MemoriesViewModel)paramObject);
    }
    else
    {
      if (79 != paramInt) {
        break label36;
      }
      i((g)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ExoPlaybackControlViewBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */