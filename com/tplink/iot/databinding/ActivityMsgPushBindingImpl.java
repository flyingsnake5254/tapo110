package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.ScheduleWeekdayTextView;
import com.tplink.iot.viewmodel.ipcamera.setting.MsgPushViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

public class ActivityMsgPushBindingImpl
  extends ActivityMsgPushBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts L3;
  @Nullable
  private static final SparseIntArray M3;
  @NonNull
  private final RelativeLayout N3;
  @NonNull
  private final LinearLayout O3;
  private long P3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    M3 = localSparseIntArray;
    localSparseIntArray.put(2131364278, 11);
    localSparseIntArray.put(2131363562, 12);
    localSparseIntArray.put(2131363963, 13);
    localSparseIntArray.put(2131364241, 14);
  }
  
  public ActivityMsgPushBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 15, L3, M3));
  }
  
  private ActivityMsgPushBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 9, (RadioButton)paramArrayOfObject[4], (RadioButton)paramArrayOfObject[5], (RelativeLayout)paramArrayOfObject[6], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[7], (LinearLayout)paramArrayOfObject[12], (CheckBox)paramArrayOfObject[1], (NoninteractiveCheckBox)paramArrayOfObject[3], (RadioGroup)paramArrayOfObject[13], (LinearLayout)paramArrayOfObject[14], (View)paramArrayOfObject[11], (ScheduleWeekdayTextView)paramArrayOfObject[10]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[2];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.p0.setTag(null);
    this.p1.setTag(null);
    this.I3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableInt paramObservableInt, int paramInt)
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
        this.P3 |= 0x20;
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
        this.P3 |= 0x8;
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
        this.P3 |= 0x10;
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
        this.P3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean r(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean s(ObservableBoolean paramObservableBoolean, int paramInt)
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
  
  private boolean t(ObservableField<String> paramObservableField, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.P3;
      this.P3 = 0L;
      View.OnClickListener localOnClickListener = this.J3;
      MsgPushViewModel localMsgPushViewModel = this.K3;
      Object localObject1;
      label92:
      Object localObject3;
      boolean bool1;
      long l2;
      int i;
      label273:
      boolean bool4;
      int j;
      boolean bool6;
      boolean bool7;
      label577:
      Object localObject4;
      int k;
      label633:
      boolean bool8;
      if ((0xFFF & l1) != 0L)
      {
        if ((l1 & 0xC01) != 0L)
        {
          if (localMsgPushViewModel != null) {
            localObject1 = localMsgPushViewModel.k;
          } else {
            localObject1 = null;
          }
          updateRegistration(0, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (String)((ObservableField)localObject1).get();
            break label92;
          }
        }
        localObject1 = null;
        if ((l1 & 0xC02) != 0L)
        {
          if (localMsgPushViewModel != null) {
            localObject3 = localMsgPushViewModel.e;
          } else {
            localObject3 = null;
          }
          updateRegistration(1, (Observable)localObject3);
          if (localObject3 != null) {
            bool1 = ((ObservableBoolean)localObject3).get();
          } else {
            bool1 = false;
          }
          bool2 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool1));
        }
        else
        {
          bool2 = false;
        }
        boolean bool3 = (l1 & 0xC04) < 0L;
        l2 = l1;
        if (bool3)
        {
          if (localMsgPushViewModel != null) {
            localObject3 = localMsgPushViewModel.n;
          } else {
            localObject3 = null;
          }
          updateRegistration(2, (Observable)localObject3);
          if (localObject3 != null) {
            bool1 = ((ObservableBoolean)localObject3).get();
          } else {
            bool1 = false;
          }
          l2 = l1;
          if (bool3)
          {
            if (bool1) {
              l2 = 131072L;
            } else {
              l2 = 65536L;
            }
            l2 = l1 | l2;
          }
          if (!bool1)
          {
            i = 8;
            break label273;
          }
        }
        i = 0;
        if ((l2 & 0xE10) != 0L)
        {
          if (localMsgPushViewModel != null) {
            localObject3 = localMsgPushViewModel.g;
          } else {
            localObject3 = null;
          }
          updateRegistration(4, (Observable)localObject3);
          if (localObject3 != null) {
            bool4 = ((ObservableBoolean)localObject3).get();
          } else {
            bool4 = false;
          }
          l1 = l2;
          if ((l2 & 0xC10) != 0L)
          {
            if (bool4) {
              l1 = 8192L;
            } else {
              l1 = 4096L;
            }
            l1 = l2 | l1;
          }
          if (((l1 & 0xC10) == 0L) || (bool4)) {
            j = 0;
          } else {
            j = 8;
          }
          bool1 = bool4 ^ true;
        }
        else
        {
          bool4 = false;
          j = 0;
          bool1 = false;
          l1 = l2;
        }
        boolean bool5 = (l1 & 0xC28) < 0L;
        if (bool5)
        {
          if (localMsgPushViewModel != null) {
            localObject3 = localMsgPushViewModel.c;
          } else {
            localObject3 = null;
          }
          updateRegistration(5, (Observable)localObject3);
          if (localObject3 != null) {
            bool6 = ((ObservableBoolean)localObject3).get();
          } else {
            bool6 = false;
          }
          l2 = l1;
          bool7 = bool6;
          if (bool5) {
            if (bool6)
            {
              l2 = l1 | 0x8000;
              bool7 = bool6;
            }
            else
            {
              l2 = l1 | 0x4000;
              bool7 = bool6;
            }
          }
        }
        else
        {
          bool7 = false;
          l2 = l1;
        }
        if ((l2 & 0xC40) != 0L)
        {
          if (localMsgPushViewModel != null) {
            localObject3 = localMsgPushViewModel.l;
          } else {
            localObject3 = null;
          }
          updateRegistration(6, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label577;
          }
        }
        localObject3 = null;
        if ((l2 & 0xC80) != 0L)
        {
          if (localMsgPushViewModel != null) {
            localObject4 = localMsgPushViewModel.m;
          } else {
            localObject4 = null;
          }
          updateRegistration(7, (Observable)localObject4);
          if (localObject4 != null)
          {
            k = ((ObservableInt)localObject4).get();
            break label633;
          }
        }
        k = 0;
        if ((l2 & 0xD00) != 0L)
        {
          if (localMsgPushViewModel != null) {
            localObject4 = localMsgPushViewModel.f;
          } else {
            localObject4 = null;
          }
          updateRegistration(8, (Observable)localObject4);
          if (localObject4 != null) {
            bool6 = ((ObservableBoolean)localObject4).get();
          } else {
            bool6 = false;
          }
          bool8 = ViewDataBinding.safeUnbox(Boolean.valueOf(bool6));
          bool6 = bool1;
          bool1 = bool8;
          bool8 = bool2;
        }
        else
        {
          bool6 = bool1;
          bool1 = false;
          bool8 = bool2;
        }
      }
      else
      {
        bool1 = false;
        bool6 = false;
        localObject1 = null;
        bool8 = false;
        i = 0;
        bool4 = false;
        bool7 = false;
        localObject3 = null;
        k = 0;
        j = 0;
        l2 = l1;
      }
      if ((l2 & 0x4000) != 0L)
      {
        if (localMsgPushViewModel != null) {
          localObject4 = localMsgPushViewModel.d;
        } else {
          localObject4 = null;
        }
        updateRegistration(3, (Observable)localObject4);
        if (localObject4 != null)
        {
          bool2 = ((ObservableBoolean)localObject4).get();
          break label816;
        }
      }
      boolean bool2 = false;
      label816:
      boolean bool9 = (l2 & 0xC28) < 0L;
      if (bool9)
      {
        if (bool7) {
          bool2 = true;
        }
      }
      else {
        bool2 = false;
      }
      if ((l2 & 0xC10) != 0L)
      {
        CompoundButtonBindingAdapter.setChecked(this.c, bool6);
        CompoundButtonBindingAdapter.setChecked(this.d, bool4);
        this.f.setVisibility(j);
      }
      if ((0xE10 & l2) != 0L)
      {
        ViewBindingAdapter.setOnClick(this.c, localOnClickListener, bool4);
        ViewBindingAdapter.setOnClick(this.d, localOnClickListener, bool6);
      }
      if ((0xA00 & l2) != 0L)
      {
        this.f.setOnClickListener(localOnClickListener);
        this.p0.setOnClickListener(localOnClickListener);
        this.p1.setOnClickListener(localOnClickListener);
      }
      if ((0xC40 & l2) != 0L) {
        TextViewBindingAdapter.setText(this.q, (CharSequence)localObject3);
      }
      if ((l2 & 0xC04) != 0L) {
        this.x.setVisibility(i);
      }
      if ((l2 & 0xC01) != 0L) {
        TextViewBindingAdapter.setText(this.y, (CharSequence)localObject1);
      }
      if (bool9) {
        b.Q(this.O3, bool2);
      }
      if ((l2 & 0xC02) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.p0, bool8);
      }
      if ((0xD00 & l2) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.p1, bool1);
      }
      if ((l2 & 0xC80) != 0L) {
        ScheduleWeekdayTextView.b(this.I3, k);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.J3 = paramOnClickListener;
    try
    {
      this.P3 |= 0x200;
      notifyPropertyChanged(55);
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
  
  public void i(@Nullable MsgPushViewModel paramMsgPushViewModel)
  {
    this.K3 = paramMsgPushViewModel;
    try
    {
      this.P3 |= 0x400;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.P3 = 2048L;
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
    case 8: 
      return r((ObservableBoolean)paramObject, paramInt2);
    case 7: 
      return l((ObservableInt)paramObject, paramInt2);
    case 6: 
      return m((ObservableField)paramObject, paramInt2);
    case 5: 
      return n((ObservableBoolean)paramObject, paramInt2);
    case 4: 
      return p((ObservableBoolean)paramObject, paramInt2);
    case 3: 
      return o((ObservableBoolean)paramObject, paramInt2);
    case 2: 
      return s((ObservableBoolean)paramObject, paramInt2);
    case 1: 
      return q((ObservableBoolean)paramObject, paramInt2);
    }
    return t((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (55 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      i((MsgPushViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMsgPushBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */