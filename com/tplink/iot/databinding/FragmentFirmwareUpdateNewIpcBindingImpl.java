package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
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
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareUpdateViewModel;

public class FragmentFirmwareUpdateNewIpcBindingImpl
  extends FragmentFirmwareUpdateNewIpcBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts H3;
  @Nullable
  private static final SparseIntArray I3;
  @NonNull
  private final LinearLayout J3;
  @NonNull
  private final TextView K3;
  @NonNull
  private final TextView L3;
  @NonNull
  private final TextView M3;
  @NonNull
  private final View N3;
  @NonNull
  private final FrameLayout O3;
  private long P3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    I3 = localSparseIntArray;
    localSparseIntArray.put(2131362716, 11);
    localSparseIntArray.put(2131362715, 12);
    localSparseIntArray.put(2131361991, 13);
    localSparseIntArray.put(2131362798, 14);
  }
  
  public FragmentFirmwareUpdateNewIpcBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 15, H3, I3));
  }
  
  private FragmentFirmwareUpdateNewIpcBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 7, (TextView)paramArrayOfObject[13], (TextView)paramArrayOfObject[8], (Button)paramArrayOfObject[10], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[12], (TextView)paramArrayOfObject[11], (ImageView)paramArrayOfObject[14], (ImageView)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[7]);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[4];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[5];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[6];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[9];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean m(ObservableField<String> paramObservableField, int paramInt)
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
        this.P3 |= 0x4;
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
        this.P3 |= 0x10;
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
        this.P3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableField<String> paramObservableField, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.P3;
      this.P3 = 0L;
      View.OnClickListener localOnClickListener = this.p3;
      Object localObject1 = this.p2;
      Object localObject2 = null;
      Object localObject3;
      label95:
      Object localObject5;
      label152:
      Object localObject6;
      boolean bool1;
      int i;
      int j;
      float f;
      int k;
      label464:
      Object localObject7;
      label521:
      label578:
      Object localObject8;
      if ((0x3FF & l1) != 0L)
      {
        if ((l1 & 0x301) != 0L)
        {
          if (localObject1 != null) {
            localObject3 = ((FirmwareUpdateViewModel)localObject1).h;
          } else {
            localObject3 = null;
          }
          updateRegistration(0, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label95;
          }
        }
        localObject3 = null;
        if ((l1 & 0x302) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((FirmwareUpdateViewModel)localObject1).f;
          } else {
            localObject5 = null;
          }
          updateRegistration(1, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((ObservableField)localObject5).get();
            break label152;
          }
        }
        localObject5 = null;
        long l2;
        if ((l1 & 0x384) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((FirmwareUpdateViewModel)localObject1).b;
          } else {
            localObject6 = null;
          }
          updateRegistration(2, (Observable)localObject6);
          if (localObject6 != null) {
            bool1 = ((ObservableBoolean)localObject6).get();
          } else {
            bool1 = false;
          }
          l2 = l1;
          if ((l1 & 0x304) != 0L)
          {
            if (bool1)
            {
              l1 = l1 | 0x800 | 0x2000;
              l2 = 131072L;
            }
            else
            {
              l1 = l1 | 0x400 | 0x1000;
              l2 = 65536L;
            }
            l2 = l1 | l2;
          }
          if ((l2 & 0x304) != 0L)
          {
            if (bool1) {
              i = 0;
            } else {
              i = 8;
            }
            if (bool1) {
              j = 8;
            } else {
              j = 0;
            }
            if (bool1) {
              f = 0.5F;
            } else {
              f = 1.0F;
            }
          }
          else
          {
            i = 0;
            j = 0;
            f = 0.0F;
          }
          bool1 ^= true;
        }
        else
        {
          bool1 = false;
          i = 0;
          j = 0;
          f = 0.0F;
          l2 = l1;
        }
        boolean bool2 = (l2 & 0x308) < 0L;
        l1 = l2;
        if (bool2)
        {
          if (localObject1 != null) {
            localObject6 = ((FirmwareUpdateViewModel)localObject1).g;
          } else {
            localObject6 = null;
          }
          updateRegistration(3, (Observable)localObject6);
          boolean bool3;
          if (localObject6 != null) {
            bool3 = ((ObservableBoolean)localObject6).get();
          } else {
            bool3 = false;
          }
          l1 = l2;
          if (bool2)
          {
            if (bool3) {
              l1 = 32768L;
            } else {
              l1 = 16384L;
            }
            l1 = l2 | l1;
          }
          if (!bool3)
          {
            k = 8;
            break label464;
          }
        }
        k = 0;
        if ((l1 & 0x310) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((FirmwareUpdateViewModel)localObject1).e;
          } else {
            localObject6 = null;
          }
          updateRegistration(4, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject7 = (String)((ObservableField)localObject6).get();
            break label521;
          }
        }
        localObject7 = null;
        if ((l1 & 0x320) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((FirmwareUpdateViewModel)localObject1).d;
          } else {
            localObject6 = null;
          }
          updateRegistration(5, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (String)((ObservableField)localObject6).get();
            break label578;
          }
        }
        localObject6 = null;
        localObject8 = localObject2;
        if ((l1 & 0x340) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((FirmwareUpdateViewModel)localObject1).c;
          } else {
            localObject1 = null;
          }
          updateRegistration(6, (Observable)localObject1);
          localObject8 = localObject2;
          if (localObject1 != null) {
            localObject8 = (String)((ObservableField)localObject1).get();
          }
        }
        localObject1 = localObject8;
        localObject8 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject7;
        localObject7 = localObject5;
      }
      else
      {
        localObject8 = null;
        localObject3 = localObject8;
        localObject5 = localObject3;
        localObject6 = localObject5;
        localObject7 = localObject6;
        j = 0;
        f = 0.0F;
        k = 0;
        i = 0;
        bool1 = false;
        localObject1 = localObject6;
        localObject6 = localObject5;
      }
      if ((l1 & 0x301) != 0L) {
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject8);
      }
      if ((0x280 & l1) != 0L)
      {
        this.f.setOnClickListener(localOnClickListener);
        this.p0.setOnClickListener(localOnClickListener);
      }
      if ((l1 & 0x304) != 0L)
      {
        this.f.setVisibility(j);
        this.O3.setVisibility(i);
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.p1.setAlpha(f);
        }
      }
      if ((l1 & 0x340) != 0L) {
        TextViewBindingAdapter.setText(this.q, (CharSequence)localObject3);
      }
      if ((l1 & 0x308) != 0L)
      {
        this.p1.setVisibility(k);
        this.N3.setVisibility(k);
      }
      if ((0x384 & l1) != 0L) {
        ViewBindingAdapter.setOnClick(this.p1, localOnClickListener, bool1);
      }
      if ((0x320 & l1) != 0L) {
        TextViewBindingAdapter.setText(this.K3, (CharSequence)localObject6);
      }
      if ((0x310 & l1) != 0L) {
        TextViewBindingAdapter.setText(this.L3, (CharSequence)localObject1);
      }
      if ((l1 & 0x302) != 0L) {
        TextViewBindingAdapter.setText(this.M3, (CharSequence)localObject7);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p3 = paramOnClickListener;
    try
    {
      this.P3 |= 0x80;
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
  
  public void i(@Nullable FirmwareUpdateViewModel paramFirmwareUpdateViewModel)
  {
    this.p2 = paramFirmwareUpdateViewModel;
    try
    {
      this.P3 |= 0x100;
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
      this.P3 = 512L;
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
    case 6: 
      return m((ObservableField)paramObject, paramInt2);
    case 5: 
      return q((ObservableField)paramObject, paramInt2);
    case 4: 
      return p((ObservableField)paramObject, paramInt2);
    case 3: 
      return n((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return o((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return r((ObservableField)paramObject, paramInt2);
    }
    return l((ObservableField)paramObject, paramInt2);
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
      i((FirmwareUpdateViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentFirmwareUpdateNewIpcBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */