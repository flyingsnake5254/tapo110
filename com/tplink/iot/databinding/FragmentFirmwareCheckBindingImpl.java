package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareCheckViewModel;

public class FragmentFirmwareCheckBindingImpl
  extends FragmentFirmwareCheckBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final FrameLayout H3;
  @NonNull
  private final TextView I3;
  @NonNull
  private final TextView J3;
  @NonNull
  private final View K3;
  @NonNull
  private final FrameLayout L3;
  private long M3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 8);
    localSparseIntArray.put(2131363012, 9);
    localSparseIntArray.put(2131361991, 10);
    localSparseIntArray.put(2131362798, 11);
  }
  
  public FragmentFirmwareCheckBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 12, p2, p3));
  }
  
  private FragmentFirmwareCheckBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 6, (TextView)paramArrayOfObject[10], (TextView)paramArrayOfObject[5], (Button)paramArrayOfObject[7], (ImageView)paramArrayOfObject[11], (RelativeLayout)paramArrayOfObject[4], (ImageView)paramArrayOfObject[9], (Toolbar)paramArrayOfObject[8]);
    this.d.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[1];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[2];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[3];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[6];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x2;
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
        this.M3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableInt paramObservableInt, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean o(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x8;
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
        this.M3 |= 0x10;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.M3 |= 0x20;
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
      long l1 = this.M3;
      this.M3 = 0L;
      View.OnClickListener localOnClickListener = this.p0;
      Object localObject1 = this.p1;
      Object localObject2;
      label92:
      int i;
      Object localObject4;
      label152:
      Object localObject5;
      int k;
      label372:
      Object localObject6;
      label429:
      int j;
      if ((0x1BF & l1) != 0L)
      {
        if ((l1 & 0x181) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((FirmwareCheckViewModel)localObject1).c;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((ObservableField)localObject2).get();
            break label92;
          }
        }
        localObject2 = null;
        i = 1;
        if ((l1 & 0x182) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((FirmwareCheckViewModel)localObject1).f;
          } else {
            localObject4 = null;
          }
          updateRegistration(1, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label152;
          }
        }
        localObject4 = null;
        boolean bool1 = (l1 & 0x184) < 0L;
        long l2;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject5 = ((FirmwareCheckViewModel)localObject1).d;
          } else {
            localObject5 = null;
          }
          updateRegistration(2, (Observable)localObject5);
          if (localObject5 != null) {
            k = ((ObservableInt)localObject5).get();
          } else {
            k = 0;
          }
          if (k == 1) {
            k = i;
          } else {
            k = 0;
          }
          l2 = l1;
          if (bool1)
          {
            if (k != 0)
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
          if (k != 0) {
            i = 0;
          } else {
            i = 8;
          }
          if (k != 0)
          {
            k = 8;
            l1 = l2;
          }
          else
          {
            k = 0;
            l1 = l2;
          }
        }
        else
        {
          k = 0;
          i = 0;
        }
        if ((l1 & 0x188) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((FirmwareCheckViewModel)localObject1).b;
          } else {
            localObject5 = null;
          }
          updateRegistration(3, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (String)((ObservableField)localObject5).get();
            break label372;
          }
        }
        localObject5 = null;
        if ((l1 & 0x190) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((FirmwareCheckViewModel)localObject1).a;
          } else {
            localObject6 = null;
          }
          updateRegistration(4, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (String)((ObservableField)localObject6).get();
            break label429;
          }
        }
        localObject6 = null;
        bool1 = (l1 & 0x1A0) < 0L;
        int m;
        if (bool1)
        {
          if (localObject1 != null) {
            localObject1 = ((FirmwareCheckViewModel)localObject1).e;
          } else {
            localObject1 = null;
          }
          updateRegistration(5, (Observable)localObject1);
          boolean bool2;
          if (localObject1 != null) {
            bool2 = ((ObservableBoolean)localObject1).get();
          } else {
            bool2 = false;
          }
          l2 = l1;
          if (bool1)
          {
            if (bool2) {
              l2 = 4096L;
            } else {
              l2 = 2048L;
            }
            l2 = l1 | l2;
          }
          if (bool2) {
            bool1 = false;
          } else {
            j = 8;
          }
          m = k;
          l1 = l2;
          k = i;
          i = j;
          j = m;
          localObject1 = localObject4;
          localObject4 = localObject5;
        }
        else
        {
          j = k;
          m = 0;
          k = i;
          i = m;
          localObject1 = localObject4;
          localObject4 = localObject5;
        }
      }
      else
      {
        localObject5 = null;
        localObject2 = localObject5;
        localObject4 = localObject2;
        localObject6 = localObject4;
        k = 0;
        i = 0;
        j = 0;
        localObject1 = localObject2;
        localObject2 = localObject5;
      }
      if ((l1 & 0x182) != 0L) {
        TextViewBindingAdapter.setText(this.d, (CharSequence)localObject1);
      }
      if ((0x140 & l1) != 0L)
      {
        this.f.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
      }
      if ((l1 & 0x181) != 0L) {
        TextViewBindingAdapter.setText(this.f, (CharSequence)localObject2);
      }
      if ((0x184 & l1) != 0L)
      {
        this.f.setVisibility(j);
        this.L3.setVisibility(k);
      }
      if ((0x1A0 & l1) != 0L)
      {
        this.x.setVisibility(i);
        this.K3.setVisibility(i);
      }
      if ((0x188 & l1) != 0L) {
        TextViewBindingAdapter.setText(this.I3, (CharSequence)localObject4);
      }
      if ((l1 & 0x190) != 0L) {
        TextViewBindingAdapter.setText(this.J3, (CharSequence)localObject6);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p0 = paramOnClickListener;
    try
    {
      this.M3 |= 0x40;
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
      return this.M3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable FirmwareCheckViewModel paramFirmwareCheckViewModel)
  {
    this.p1 = paramFirmwareCheckViewModel;
    try
    {
      this.M3 |= 0x80;
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
      this.M3 = 256L;
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
              return q((ObservableBoolean)paramObject, paramInt2);
            }
            return p((ObservableField)paramObject, paramInt2);
          }
          return o((ObservableField)paramObject, paramInt2);
        }
        return n((ObservableInt)paramObject, paramInt2);
      }
      return l((ObservableField)paramObject, paramInt2);
    }
    return m((ObservableField)paramObject, paramInt2);
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
      i((FirmwareCheckViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentFirmwareCheckBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */