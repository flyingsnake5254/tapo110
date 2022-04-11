package com.tplink.iot.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devices.switches.viewmodel.SwitchDetailViewModel;
import com.tplink.iot.widget.DiffuseViewV2;

public class LayoutSwitchDetailContentExtBindingImpl
  extends LayoutSwitchDetailContentExtBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p1;
  @Nullable
  private static final SparseIntArray p2;
  @NonNull
  private final TextView H3;
  private long I3 = -1L;
  @NonNull
  private final FrameLayout p3;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p2 = localSparseIntArray;
    localSparseIntArray.put(2131362450, 7);
  }
  
  public LayoutSwitchDetailContentExtBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p1, p2));
  }
  
  private LayoutSwitchDetailContentExtBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (DiffuseViewV2)paramArrayOfObject[7], (ImageView)paramArrayOfObject[1], (LinearLayout)paramArrayOfObject[2], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[6]);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[5];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean h(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean i(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.I3 |= 1L;
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
      long l1 = this.I3;
      this.I3 = 0L;
      SwitchDetailViewModel localSwitchDetailViewModel = this.z;
      View.OnClickListener localOnClickListener = this.p0;
      boolean bool1 = false;
      boolean bool2 = false;
      String str = null;
      Boolean localBoolean = null;
      Object localObject1;
      if ((0x17 & l1) != 0L)
      {
        boolean bool3 = (l1 & 0x15) < 0L;
        Object localObject3;
        if (bool3)
        {
          if (localSwitchDetailViewModel != null) {
            localObject1 = localSwitchDetailViewModel.X();
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null) {
            bool1 = ((ObservableBoolean)localObject1).get();
          } else {
            bool1 = false;
          }
          long l2 = l1;
          if (bool3)
          {
            if (bool1)
            {
              l1 |= 0x40;
              l2 = 256L;
            }
            else
            {
              l1 |= 0x20;
              l2 = 128L;
            }
            l2 = l1 | l2;
          }
          localObject1 = this.x.getResources();
          int i;
          if (bool1) {
            i = 2131954216;
          } else {
            i = 2131954217;
          }
          localObject3 = ((Resources)localObject1).getString(i);
          if (bool1)
          {
            localObject1 = this.q.getResources();
            i = 2131952442;
          }
          else
          {
            localObject1 = this.q.getResources();
            i = 2131952440;
          }
          str = ((Resources)localObject1).getString(i);
          l1 = l2;
          localObject1 = localObject3;
        }
        else
        {
          str = null;
          localObject1 = str;
        }
        bool1 = bool2;
        if ((l1 & 0x16) != 0L)
        {
          if (localSwitchDetailViewModel != null) {
            localObject3 = localSwitchDetailViewModel.W();
          } else {
            localObject3 = null;
          }
          updateLiveDataRegistration(1, (LiveData)localObject3);
          if (localObject3 != null) {
            localBoolean = (Boolean)((LiveData)localObject3).getValue();
          }
          bool1 = ViewDataBinding.safeUnbox(localBoolean);
        }
      }
      else
      {
        localObject1 = null;
      }
      if ((0x18 & l1) != 0L)
      {
        this.d.setOnClickListener(localOnClickListener);
        this.f.setOnClickListener(localOnClickListener);
      }
      if ((l1 & 0x16) != 0L)
      {
        a.h(this.H3, bool1);
        a.h(this.y, bool1);
      }
      if ((l1 & 0x15) != 0L)
      {
        TextViewBindingAdapter.setText(this.q, str);
        TextViewBindingAdapter.setText(this.x, (CharSequence)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 16L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable SwitchDetailViewModel paramSwitchDetailViewModel)
  {
    this.z = paramSwitchDetailViewModel;
    try
    {
      this.I3 |= 0x4;
      notifyPropertyChanged(15);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p0 = paramOnClickListener;
    try
    {
      this.I3 |= 0x8;
      notifyPropertyChanged(69);
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
      return h((LiveData)paramObject, paramInt2);
    }
    return i((ObservableBoolean)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (15 == paramInt)
    {
      l((SwitchDetailViewModel)paramObject);
    }
    else
    {
      if (69 != paramInt) {
        break label36;
      }
      m((View.OnClickListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutSwitchDetailContentExtBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */