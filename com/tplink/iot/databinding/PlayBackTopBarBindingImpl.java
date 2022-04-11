package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
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
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public class PlayBackTopBarBindingImpl
  extends PlayBackTopBarBinding
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
  
  public PlayBackTopBarBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p0, p1));
  }
  
  private PlayBackTopBarBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (TextView)paramArrayOfObject[2], (ImageView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[3], (ImageView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.p3 = new a(this, 4);
    this.H3 = new a(this, 2);
    this.I3 = new a(this, 3);
    this.J3 = new a(this, 1);
    this.K3 = new a(this, 5);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean m(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean n(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean o(ObservableBoolean paramObservableBoolean, int paramInt)
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
      long l1 = this.L3;
      this.L3 = 0L;
      PlayBackControlViewModel localPlayBackControlViewModel = this.z;
      Object localObject1 = null;
      Object localObject2;
      boolean bool3;
      Object localObject4;
      label234:
      Object localObject5;
      int j;
      if ((0x6F & l1) != 0L)
      {
        boolean bool1 = (l1 & 0x61) < 0L;
        if (bool1)
        {
          if (localPlayBackControlViewModel != null) {
            localObject2 = localPlayBackControlViewModel.T3;
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
            if (bool3)
            {
              l2 = l1 | 0x400;
              l1 = 16384L;
            }
            else
            {
              l2 = l1 | 0x200;
              l1 = 8192L;
            }
            l2 |= l1;
          }
          localObject2 = this.q.getContext();
          int i;
          if (bool3) {
            i = 2131231282;
          } else {
            i = 2131231283;
          }
          localObject2 = AppCompatResources.getDrawable((Context)localObject2, i);
        }
        else
        {
          localObject2 = null;
          bool3 = false;
          l2 = l1;
        }
        if ((l2 & 0x62) != 0L)
        {
          if (localPlayBackControlViewModel != null) {
            localObject4 = localPlayBackControlViewModel.Q3;
          } else {
            localObject4 = null;
          }
          updateRegistration(1, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label234;
          }
        }
        localObject4 = null;
        boolean bool2 = (l2 & 0x64) < 0L;
        long l3 = l2;
        boolean bool4;
        if (bool2)
        {
          if (localPlayBackControlViewModel != null) {
            localObject5 = localPlayBackControlViewModel.R3;
          } else {
            localObject5 = null;
          }
          updateRegistration(2, (Observable)localObject5);
          if (localObject5 != null) {
            bool4 = ((ObservableBoolean)localObject5).get();
          } else {
            bool4 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool4) {
              l1 = 4096L;
            } else {
              l1 = 2048L;
            }
            l1 = l2 | l1;
          }
          l3 = l1;
          if (bool4)
          {
            j = 8;
            l2 = l1;
            break label349;
          }
        }
        j = 0;
        long l2 = l3;
        label349:
        boolean bool5 = (l2 & 0x68) < 0L;
        l1 = l2;
        localObject5 = localObject1;
        if (bool5)
        {
          if (localPlayBackControlViewModel != null) {
            localObject5 = localPlayBackControlViewModel.U3;
          } else {
            localObject5 = null;
          }
          updateRegistration(3, (Observable)localObject5);
          if (localObject5 != null) {
            bool4 = ((ObservableBoolean)localObject5).get();
          } else {
            bool4 = false;
          }
          l1 = l2;
          if (bool5)
          {
            if (bool4) {
              l1 = 256L;
            } else {
              l1 = 128L;
            }
            l1 = l2 | l1;
          }
          int k;
          if (bool4)
          {
            localObject5 = this.d.getContext();
            k = 2131231115;
          }
          else
          {
            localObject5 = this.d.getContext();
            k = 2131231114;
          }
          localObject5 = AppCompatResources.getDrawable((Context)localObject5, k);
        }
        localObject1 = localObject4;
        localObject4 = localObject5;
        localObject5 = localObject1;
        localObject1 = localObject2;
      }
      else
      {
        localObject5 = null;
        localObject2 = localObject5;
        localObject1 = localObject2;
        j = 0;
        bool3 = false;
        localObject4 = localObject2;
      }
      if ((0x62 & l1) != 0L) {
        TextViewBindingAdapter.setText(this.c, (CharSequence)localObject5);
      }
      if ((0x40 & l1) != 0L)
      {
        this.c.setOnClickListener(this.H3);
        this.d.setOnClickListener(this.J3);
        this.f.setOnClickListener(this.I3);
        this.x.setOnClickListener(this.K3);
      }
      if ((0x68 & l1) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.d, (Drawable)localObject4);
      }
      if ((l1 & 0x61) != 0L)
      {
        ImageViewBindingAdapter.setImageDrawable(this.q, (Drawable)localObject1);
        ViewBindingAdapter.setOnClick(this.q, this.p3, bool3);
      }
      if ((l1 & 0x64) != 0L) {
        this.x.setVisibility(j);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable g paramg)
  {
    this.y = paramg;
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
  
  public void i(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.z = paramPlayBackControlViewModel;
    try
    {
      this.L3 |= 0x20;
      notifyPropertyChanged(105);
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
          return l((ObservableBoolean)paramObject, paramInt2);
        }
        return n((ObservableBoolean)paramObject, paramInt2);
      }
      return m((ObservableField)paramObject, paramInt2);
    }
    return o((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      h((g)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label36;
      }
      i((PlayBackControlViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackTopBarBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */