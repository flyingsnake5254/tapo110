package com.tplink.iot.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.setting.c5;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.StoreManageViewModel;
import com.tplink.iot.widget.camerasetting.SimpleProcessBarNewIpc;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;

public class ActivityStoreManageBindingImpl
  extends ActivityStoreManageBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final RelativeLayout H3;
  @NonNull
  private final ImageView I3;
  @NonNull
  private final View J3;
  @NonNull
  private final LinearLayout K3;
  @NonNull
  private final LinearLayout L3;
  @NonNull
  private final TextView M3;
  @NonNull
  private final TextView N3;
  @NonNull
  private final View O3;
  private long P3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 14);
  }
  
  public ActivityStoreManageBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 15, p2, p3));
  }
  
  private ActivityStoreManageBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 10, (TextView)paramArrayOfObject[12], (CameraLoadingView)paramArrayOfObject[13], (CheckBox)paramArrayOfObject[10], (SimpleProcessBarNewIpc)paramArrayOfObject[7], (TextView)paramArrayOfObject[9], (Toolbar)paramArrayOfObject[14], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[1];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[11];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[2];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[4];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[5];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[6];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[8];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.z.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean m(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x80;
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
        this.P3 |= 0x2;
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
        this.P3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x200;
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
        this.P3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableField<SdCardStatus> paramObservableField, int paramInt)
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
  
  private boolean s(ObservableField<Drawable> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x40;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean t(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean u(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.P3 |= 0x100;
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
      long l1 = this.P3;
      this.P3 = 0L;
      View.OnClickListener localOnClickListener = this.p1;
      Object localObject1 = this.p0;
      Object localObject2;
      label92:
      Object localObject4;
      boolean bool2;
      long l3;
      int i;
      label208:
      label266:
      Object localObject5;
      label324:
      Object localObject6;
      boolean bool3;
      boolean bool4;
      boolean bool5;
      label524:
      Object localObject7;
      int j;
      boolean bool7;
      label648:
      int k;
      if ((0x1BFF & l1) != 0L)
      {
        if ((l1 & 0x1801) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((StoreManageViewModel)localObject1).p;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (SdCardStatus)((ObservableField)localObject2).get();
            break label92;
          }
        }
        localObject2 = null;
        boolean bool1 = (l1 & 0x1802) < 0L;
        long l2 = l1;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject4 = ((StoreManageViewModel)localObject1).q;
          } else {
            localObject4 = null;
          }
          updateRegistration(1, (Observable)localObject4);
          if (localObject4 != null) {
            bool2 = ((ObservableBoolean)localObject4).get();
          } else {
            bool2 = false;
          }
          l3 = l1;
          if (bool1)
          {
            if (bool2) {
              l3 = 16384L;
            } else {
              l3 = 8192L;
            }
            l3 = l1 | l3;
          }
          l2 = l3;
          if (bool2)
          {
            i = 8;
            break label208;
          }
        }
        i = 0;
        l3 = l2;
        if ((l3 & 0x1804) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((StoreManageViewModel)localObject1).h;
          } else {
            localObject4 = null;
          }
          updateRegistration(2, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label266;
          }
        }
        localObject4 = null;
        if ((l3 & 0x1808) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((StoreManageViewModel)localObject1).k;
          } else {
            localObject5 = null;
          }
          updateRegistration(3, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((ObservableField)localObject5).get();
            break label324;
          }
        }
        localObject5 = null;
        if ((l3 & 0x1810) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((StoreManageViewModel)localObject1).r;
          } else {
            localObject6 = null;
          }
          updateRegistration(4, (Observable)localObject6);
          if (localObject6 != null) {
            bool3 = ((ObservableBoolean)localObject6).get();
          } else {
            bool3 = false;
          }
          bool4 = bool3 ^ true;
        }
        else
        {
          bool3 = false;
          bool4 = false;
        }
        if ((l3 & 0x1820) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((StoreManageViewModel)localObject1).a;
          } else {
            localObject6 = null;
          }
          updateRegistration(5, (Observable)localObject6);
          if (localObject6 != null) {
            bool2 = ((ObservableBoolean)localObject6).get();
          } else {
            bool2 = false;
          }
          bool5 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool2));
        }
        else
        {
          bool5 = false;
        }
        if ((l3 & 0x1840) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((StoreManageViewModel)localObject1).o;
          } else {
            localObject6 = null;
          }
          updateRegistration(6, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (Drawable)((ObservableField)localObject6).get();
            break label524;
          }
        }
        localObject6 = null;
        boolean bool6 = (l3 & 0x1880) < 0L;
        if (bool6)
        {
          if (localObject1 != null) {
            localObject7 = ((StoreManageViewModel)localObject1).m;
          } else {
            localObject7 = null;
          }
          updateRegistration(7, (Observable)localObject7);
          if (localObject7 != null) {
            bool2 = ((ObservableBoolean)localObject7).get();
          } else {
            bool2 = false;
          }
          l1 = l3;
          if (bool6)
          {
            if (bool2) {
              l1 = 65536L;
            } else {
              l1 = 32768L;
            }
            l1 = l3 | l1;
          }
          if (bool2)
          {
            l3 = l1;
          }
          else
          {
            j = 8;
            bool7 = bool2;
            break label648;
          }
        }
        else
        {
          bool2 = false;
        }
        j = 0;
        bool7 = bool2;
        l1 = l3;
        if ((l1 & 0x1900) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((StoreManageViewModel)localObject1).i;
          } else {
            localObject7 = null;
          }
          updateRegistration(8, (Observable)localObject7);
          if (localObject7 != null) {
            localObject7 = (String)((ObservableField)localObject7).get();
          } else {
            localObject7 = null;
          }
          bool2 = TextUtils.isEmpty((CharSequence)localObject7) ^ true;
        }
        else
        {
          localObject7 = null;
          bool2 = false;
        }
        if ((l1 & 0x1A00) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((StoreManageViewModel)localObject1).j;
          } else {
            localObject1 = null;
          }
          updateRegistration(9, (Observable)localObject1);
          if (localObject1 != null)
          {
            k = ((ObservableInt)localObject1).get();
            l3 = l1;
            break label785;
          }
        }
        l3 = l1;
        k = 0;
      }
      else
      {
        label785:
        bool7 = false;
        j = 0;
        k = 0;
        localObject7 = null;
        localObject4 = null;
        bool5 = false;
        i = 0;
        localObject2 = null;
        localObject6 = null;
        bool3 = false;
        bool4 = false;
        bool2 = false;
        localObject5 = null;
        l3 = l1;
      }
      if ((l3 & 0x1400) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.z.setOnClickListener(localOnClickListener);
      }
      if ((l3 & 0x1820) != 0L) {
        b.K(this.d, Boolean.valueOf(bool5));
      }
      if ((l3 & 0x1880) != 0L)
      {
        CompoundButtonBindingAdapter.setChecked(this.f, bool7);
        this.O3.setVisibility(j);
      }
      if ((l3 & 0x1840) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.I3, (Drawable)localObject6);
      }
      if ((l3 & 0x1802) != 0L) {
        this.J3.setVisibility(i);
      }
      if ((0x1810 & l3) != 0L)
      {
        b.Q(this.K3, bool3);
        b.Q(this.L3, bool4);
      }
      if ((l3 & 0x1804) != 0L) {
        TextViewBindingAdapter.setText(this.M3, (CharSequence)localObject4);
      }
      if ((0x1900 & l3) != 0L)
      {
        TextViewBindingAdapter.setText(this.N3, (CharSequence)localObject7);
        b.Q(this.N3, bool2);
      }
      if ((0x1A00 & l3) != 0L) {
        c5.a(this.q, k);
      }
      if ((l3 & 0x1801) != 0L) {
        c5.b(this.q, (SdCardStatus)localObject2);
      }
      if ((l3 & 0x1808) != 0L) {
        TextViewBindingAdapter.setText(this.x, (CharSequence)localObject5);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p1 = paramOnClickListener;
    try
    {
      this.P3 |= 0x400;
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
      return this.P3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable StoreManageViewModel paramStoreManageViewModel)
  {
    this.p0 = paramStoreManageViewModel;
    try
    {
      this.P3 |= 0x800;
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
      this.P3 = 4096L;
      requestRebind();
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
      return p((ObservableInt)paramObject, paramInt2);
    case 8: 
      return u((ObservableField)paramObject, paramInt2);
    case 7: 
      return m((ObservableBoolean)paramObject, paramInt2);
    case 6: 
      return s((ObservableField)paramObject, paramInt2);
    case 5: 
      return l((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return o((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return q((ObservableField)paramObject, paramInt2);
    case 2: 
      return t((ObservableField)paramObject, paramInt2);
    case 1: 
      return n((ObservableBoolean)paramObject, paramInt2);
    }
    return r((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label35;
      }
      i((StoreManageViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityStoreManageBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */