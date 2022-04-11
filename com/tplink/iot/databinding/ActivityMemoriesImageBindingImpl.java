package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import uk.co.senab.photoview.PhotoView;

public class ActivityMemoriesImageBindingImpl
  extends ActivityMemoriesImageBinding
  implements a.a
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final ConstraintLayout I3;
  @NonNull
  private final TextView J3;
  @NonNull
  private final FrameLayout K3;
  @NonNull
  private final RelativeLayout L3;
  @Nullable
  private final DialogMemorySlideOperationBinding M3;
  @NonNull
  private final TextView N3;
  @Nullable
  private final View.OnClickListener O3;
  private long P3 = -1L;
  
  static
  {
    Object localObject = new ViewDataBinding.IncludedLayouts(14);
    p3 = (ViewDataBinding.IncludedLayouts)localObject;
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(0, new String[] { "dialog_memory_bottom_operation" }, new int[] { 11 }, new int[] { 2131558806 });
    ((ViewDataBinding.IncludedLayouts)localObject).setIncludes(6, new String[] { "dialog_memory_slide_operation" }, new int[] { 10 }, new int[] { 2131558808 });
    localObject = new SparseIntArray();
    H3 = (SparseIntArray)localObject;
    ((SparseIntArray)localObject).put(2131364275, 12);
    ((SparseIntArray)localObject).put(2131364065, 13);
  }
  
  public ActivityMemoriesImageBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 14, p3, H3));
  }
  
  private ActivityMemoriesImageBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 6, (ImageView)paramArrayOfObject[7], (CameraLoadingView)paramArrayOfObject[9], (PhotoView)paramArrayOfObject[13], (PhotoView)paramArrayOfObject[4], (Toolbar)paramArrayOfObject[12], (AppBarLayout)paramArrayOfObject[1], (TextView)paramArrayOfObject[2], (DialogMemoryBottomOperationBinding)paramArrayOfObject[11]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[5];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[6];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (DialogMemorySlideOperationBinding)paramArrayOfObject[10];
    this.M3 = paramDataBindingComponent;
    setContainedBinding(paramDataBindingComponent);
    paramDataBindingComponent = (TextView)paramArrayOfObject[8];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.z.setTag(null);
    setContainedBinding(this.p0);
    setRootTag(paramView);
    this.O3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean l(ObservableField<CharSequence> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x2;
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
        this.P3 |= 0x8;
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
        this.P3 |= 1L;
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
        this.P3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(DialogMemoryBottomOperationBinding paramDialogMemoryBottomOperationBinding, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.p1;
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
      long l1 = this.P3;
      this.P3 = 0L;
      MemoriesViewModel localMemoriesViewModel = this.p2;
      g localg = this.p1;
      Object localObject1 = null;
      CharSequence localCharSequence = null;
      long l2;
      boolean bool3;
      label202:
      Object localObject3;
      label413:
      label416:
      int m;
      boolean bool7;
      int n;
      boolean bool8;
      int i1;
      int i2;
      if ((0x15F & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x141) < 0L;
        if (bool1)
        {
          if (localMemoriesViewModel != null) {
            localObject1 = localMemoriesViewModel.o;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          bool3 = bool2;
          if (bool1)
          {
            if (bool2) {
              l2 = 16384L;
            } else {
              l2 = 8192L;
            }
            l2 = l1 | l2;
            bool3 = bool2;
          }
        }
        else
        {
          bool3 = false;
          l2 = l1;
        }
        if ((l2 & 0x142) != 0L)
        {
          if (localMemoriesViewModel != null) {
            localObject1 = localMemoriesViewModel.k;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (String)((ObservableField)localObject1).get();
            break label202;
          }
        }
        localObject1 = null;
        boolean bool4;
        if ((l2 & 0x14C) != 0L)
        {
          if (localMemoriesViewModel != null) {
            localObject3 = localMemoriesViewModel.l;
          } else {
            localObject3 = null;
          }
          updateRegistration(2, (Observable)localObject3);
          if (localObject3 != null) {
            bool2 = ((ObservableBoolean)localObject3).get();
          } else {
            bool2 = false;
          }
          l1 = l2;
          if ((l2 & 0x144) != 0L)
          {
            if (bool2)
            {
              l2 |= 0x400;
              l1 = 65536L;
            }
            else
            {
              l2 |= 0x200;
              l1 = 32768L;
            }
            l1 = l2 | l1;
          }
          l2 = l1;
          if ((l1 & 0x14C) != 0L) {
            if (bool2) {
              l2 = l1 | 0x40000 | 0x100000;
            } else {
              l2 = l1 | 0x20000 | 0x80000;
            }
          }
          l1 = l2;
          bool4 = bool2;
          if ((l2 & 0x144) != 0L)
          {
            if (bool2) {
              i = 8;
            } else {
              i = 0;
            }
            if (bool2) {
              break label413;
            }
            j = 8;
            break label416;
          }
        }
        else
        {
          bool4 = false;
          l1 = l2;
        }
        i = 0;
        bool2 = bool4;
        l2 = l1;
        int j = 0;
        boolean bool6 = (l2 & 0x148) < 0L;
        if (bool6)
        {
          if (localMemoriesViewModel != null) {
            localObject3 = localMemoriesViewModel.m;
          } else {
            localObject3 = null;
          }
          updateRegistration(3, (Observable)localObject3);
          if (localObject3 != null) {
            bool4 = ((ObservableBoolean)localObject3).get();
          } else {
            bool4 = false;
          }
          l1 = l2;
          if (bool6) {
            if (bool4) {
              l1 = l2 | 0x4000000;
            } else {
              l1 = l2 | 0x2000000;
            }
          }
          localObject4 = this.I3;
          if (bool4) {
            m = 2131099799;
          } else {
            m = 2131100140;
          }
          m = ViewDataBinding.getColorFromResource((View)localObject4, m);
          l2 = l1;
        }
        else
        {
          localObject3 = null;
          m = 0;
          bool4 = false;
        }
        if ((l2 & 0x150) != 0L)
        {
          if (localMemoriesViewModel != null) {
            localObject4 = localMemoriesViewModel.j;
          } else {
            localObject4 = null;
          }
          updateRegistration(4, (Observable)localObject4);
          if (localObject4 != null) {
            localCharSequence = (CharSequence)((ObservableField)localObject4).get();
          }
        }
        Object localObject4 = localObject3;
        bool7 = bool3;
        n = m;
        localObject3 = localObject1;
        bool8 = bool2;
        i1 = i;
        i2 = j;
        bool2 = bool4;
        localObject1 = localObject4;
      }
      else
      {
        localCharSequence = null;
        localObject3 = localCharSequence;
        bool7 = false;
        n = 0;
        bool8 = false;
        i1 = 0;
        i2 = 0;
        bool2 = false;
        l2 = l1;
      }
      if ((l2 & 0x120000) != 0L)
      {
        if (localMemoriesViewModel != null) {
          localObject1 = localMemoriesViewModel.m;
        }
        updateRegistration(3, (Observable)localObject1);
        if (localObject1 != null) {
          bool2 = ((ObservableBoolean)localObject1).get();
        }
        l1 = l2;
        if ((l2 & 0x148) != 0L)
        {
          if (bool2) {
            l1 = 67108864L;
          } else {
            l1 = 33554432L;
          }
          l1 = l2 | l1;
        }
        l2 = l1;
        bool3 = bool2;
        if ((0x100000 & l1) != 0L)
        {
          i = bool2 ^ true;
          break label790;
        }
      }
      else
      {
        bool3 = bool2;
      }
      int i = 0;
      boolean bool2 = bool3;
      l1 = l2;
      label790:
      boolean bool5 = (l1 & 0x14C) < 0L;
      int k;
      if (bool5)
      {
        if (bool8) {
          bool2 = true;
        }
        if (bool8) {
          m = i;
        } else {
          m = 0;
        }
        l2 = l1;
        if (bool5)
        {
          if (bool2)
          {
            l1 |= 0x1000;
            l2 = 4194304L;
          }
          else
          {
            l1 |= 0x800;
            l2 = 2097152L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0x14C) != 0L)
        {
          if (m != 0) {
            l1 = 16777216L;
          } else {
            l1 = 8388608L;
          }
          l1 = l2 | l1;
        }
        if (bool2) {
          i = 4;
        } else {
          i = 0;
        }
        if (bool2) {
          k = 8;
        } else {
          k = 0;
        }
        if (m != 0) {
          m = 0;
        } else {
          m = 8;
        }
      }
      else
      {
        m = 0;
        k = 0;
        i = 0;
      }
      if ((l1 & 0x100) != 0L) {
        this.c.setOnClickListener(this.O3);
      }
      if ((l1 & 0x141) != 0L) {
        b.K(this.d, Boolean.valueOf(bool7));
      }
      if ((l1 & 0x148) != 0L) {
        ViewBindingAdapter.setBackground(this.I3, Converters.convertColorToDrawable(n));
      }
      if ((l1 & 0x142) != 0L) {
        TextViewBindingAdapter.setText(this.J3, (CharSequence)localObject3);
      }
      if ((l1 & 0x14C) != 0L)
      {
        this.J3.setVisibility(k);
        this.L3.setVisibility(m);
        this.y.setVisibility(i);
        this.p0.getRoot().setVisibility(k);
      }
      if ((l1 & 0x144) != 0L)
      {
        this.K3.setVisibility(i2);
        this.q.setVisibility(i1);
      }
      if ((0x180 & l1) != 0L)
      {
        this.M3.i(localg);
        this.p0.i(localg);
      }
      if ((0x140 & l1) != 0L)
      {
        this.M3.h(localMemoriesViewModel);
        this.p0.h(localMemoriesViewModel);
      }
      if ((l1 & 0x150) != 0L)
      {
        TextViewBindingAdapter.setText(this.N3, localCharSequence);
        TextViewBindingAdapter.setText(this.z, localCharSequence);
      }
      ViewDataBinding.executeBindingsOn(this.M3);
      ViewDataBinding.executeBindingsOn(this.p0);
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MemoriesViewModel paramMemoriesViewModel)
  {
    this.p2 = paramMemoriesViewModel;
    try
    {
      this.P3 |= 0x40;
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
      if (this.P3 != 0L) {
        return true;
      }
      if (this.M3.hasPendingBindings()) {
        return true;
      }
      return this.p0.hasPendingBindings();
    }
    finally {}
  }
  
  public void i(@Nullable g paramg)
  {
    this.p1 = paramg;
    try
    {
      this.P3 |= 0x80;
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
      this.P3 = 256L;
      this.M3.invalidateAll();
      this.p0.invalidateAll();
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
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if (paramInt1 != 5) {
                return false;
              }
              return q((DialogMemoryBottomOperationBinding)paramObject, paramInt2);
            }
            return l((ObservableField)paramObject, paramInt2);
          }
          return n((ObservableBoolean)paramObject, paramInt2);
        }
        return p((ObservableBoolean)paramObject, paramInt2);
      }
      return m((ObservableField)paramObject, paramInt2);
    }
    return o((ObservableBoolean)paramObject, paramInt2);
  }
  
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.setLifecycleOwner(paramLifecycleOwner);
    this.M3.setLifecycleOwner(paramLifecycleOwner);
    this.p0.setLifecycleOwner(paramLifecycleOwner);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMemoriesImageBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */