package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.login.RegionListNewAdapter.c;

public class ItemRegionListContentBindingImpl
  extends ItemRegionListContentBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts f;
  @Nullable
  private static final SparseIntArray q;
  @Nullable
  private final View.OnClickListener p0;
  private long p1 = -1L;
  @NonNull
  private final LinearLayout x;
  @NonNull
  private final ToggleButton y;
  @NonNull
  private final TextView z;
  
  public ItemRegionListContentBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, f, q));
  }
  
  private ItemRegionListContentBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.x = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ToggleButton)paramArrayOfObject[1];
    this.y = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[2];
    this.z = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.p0 = new com.tplink.iot.generated.callback.a(this, 1);
    invalidateAll();
  }
  
  private boolean l(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p1 |= 0x2;
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
        this.p1 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    paramView = this.d;
    Object localObject1 = this.c;
    int i = 1;
    if (paramView != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      if (localObject1 != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        Object localObject2 = ((com.tplink.iot.viewmodel.login.a)localObject1).a;
        if (localObject2 != null) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          localObject2 = (String)((ObservableField)localObject2).get();
          localObject1 = ((com.tplink.iot.viewmodel.login.a)localObject1).b;
          if (localObject1 != null) {
            paramInt = i;
          } else {
            paramInt = 0;
          }
          if (paramInt != 0) {
            paramView.a((String)localObject2, (String)((ObservableField)localObject1).get());
          }
        }
      }
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.p1;
      this.p1 = 0L;
      Object localObject1 = this.c;
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject2 = null;
      Object localObject3 = localObject2;
      if ((0x1B & l) != 0L)
      {
        boolean bool3 = bool2;
        if ((l & 0x19) != 0L)
        {
          if (localObject1 != null) {
            localObject3 = ((com.tplink.iot.viewmodel.login.a)localObject1).c;
          } else {
            localObject3 = null;
          }
          updateRegistration(0, (Observable)localObject3);
          bool3 = bool2;
          if (localObject3 != null) {
            bool3 = ((ObservableBoolean)localObject3).get();
          }
        }
        bool1 = bool3;
        localObject3 = localObject2;
        if ((l & 0x1A) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((com.tplink.iot.viewmodel.login.a)localObject1).a;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          bool1 = bool3;
          localObject3 = localObject2;
          if (localObject1 != null)
          {
            localObject3 = (String)((ObservableField)localObject1).get();
            bool1 = bool3;
          }
        }
      }
      if ((0x10 & l) != 0L) {
        this.x.setOnClickListener(this.p0);
      }
      if ((l & 0x19) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.y, bool1);
      }
      if ((l & 0x1A) != 0L) {
        TextViewBindingAdapter.setText(this.z, (CharSequence)localObject3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable RegionListNewAdapter.c paramc)
  {
    this.d = paramc;
    try
    {
      this.p1 |= 0x4;
      notifyPropertyChanged(2);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p1 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable com.tplink.iot.viewmodel.login.a parama)
  {
    this.c = parama;
    try
    {
      this.p1 |= 0x8;
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
      this.p1 = 16L;
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
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      h((RegionListNewAdapter.c)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label35;
      }
      i((com.tplink.iot.viewmodel.login.a)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemRegionListContentBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */