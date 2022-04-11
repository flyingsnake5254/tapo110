package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.InputPwdViewModel;
import com.tplink.iot.widget.DrawableEditText;

public class FragmentCameraV2InputPwdBindingImpl
  extends FragmentCameraV2InputPwdBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts J3;
  @Nullable
  private static final SparseIntArray K3;
  @NonNull
  private final LinearLayout L3;
  @Nullable
  private final View.OnClickListener M3;
  @Nullable
  private final View.OnClickListener N3;
  private InverseBindingListener O3 = new a();
  private InverseBindingListener P3 = new b();
  private long Q3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    K3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 6);
    localSparseIntArray.put(2131363880, 7);
    localSparseIntArray.put(2131364688, 8);
    localSparseIntArray.put(2131364386, 9);
    localSparseIntArray.put(2131364674, 10);
  }
  
  public FragmentCameraV2InputPwdBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 11, J3, K3));
  }
  
  private FragmentCameraV2InputPwdBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 4, (Button)paramArrayOfObject[5], (CheckBox)paramArrayOfObject[4], (DrawableEditText)paramArrayOfObject[3], (LinearLayout)paramArrayOfObject[7], (Toolbar)paramArrayOfObject[6], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[1], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[10], (TextView)paramArrayOfObject[8]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.z.setTag(null);
    this.p0.setTag(null);
    setRootTag(paramView);
    this.M3 = new a(this, 2);
    this.N3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean h(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Q3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean i(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Q3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean l(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.Q3 |= 1L;
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
        this.Q3 |= 0x4;
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
    g localg;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localg = this.I3;
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
      localg = this.I3;
      paramInt = i;
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
      long l = this.Q3;
      this.Q3 = 0L;
      Object localObject1 = this.H3;
      InputPwdViewModel localInputPwdViewModel = this.p3;
      label90:
      label145:
      Object localObject5;
      Object localObject6;
      if ((0xAB & l) != 0L)
      {
        if ((l & 0xA1) != 0L)
        {
          if (localObject1 != null) {
            localObject2 = ((CameraOnBoardingViewModel)localObject1).a;
          } else {
            localObject2 = null;
          }
          updateRegistration(0, (Observable)localObject2);
          if (localObject2 != null)
          {
            localObject2 = (String)((ObservableField)localObject2).get();
            break label90;
          }
        }
        localObject2 = null;
        if ((l & 0xA2) != 0L)
        {
          if (localObject1 != null) {
            localObject4 = ((CameraOnBoardingViewModel)localObject1).b;
          } else {
            localObject4 = null;
          }
          updateRegistration(1, (Observable)localObject4);
          if (localObject4 != null)
          {
            localObject4 = (String)((ObservableField)localObject4).get();
            break label145;
          }
        }
        localObject4 = null;
        localObject5 = localObject2;
        localObject6 = localObject4;
        if ((l & 0xA8) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((CameraOnBoardingViewModel)localObject1).e;
          } else {
            localObject1 = null;
          }
          updateRegistration(3, (Observable)localObject1);
          localObject5 = localObject2;
          localObject6 = localObject4;
          if (localObject1 != null)
          {
            bool1 = ((ObservableBoolean)localObject1).get();
            break label223;
          }
        }
      }
      else
      {
        localObject5 = null;
        localObject6 = localObject5;
      }
      boolean bool1 = false;
      Object localObject4 = localObject6;
      Object localObject2 = localObject5;
      label223:
      boolean bool2 = (l & 0xC4) < 0L;
      if (bool2)
      {
        if (localInputPwdViewModel != null) {
          localObject6 = localInputPwdViewModel.a;
        } else {
          localObject6 = null;
        }
        updateRegistration(2, (Observable)localObject6);
        if (localObject6 != null)
        {
          bool3 = ((ObservableBoolean)localObject6).get();
          break label281;
        }
      }
      boolean bool3 = false;
      label281:
      if (bool2) {
        this.c.setEnabled(bool3);
      }
      if ((l & 0x80) != 0L)
      {
        this.c.setOnClickListener(this.M3);
        CompoundButtonBindingAdapter.setListeners(this.d, null, this.O3);
        b.I(this.f, null, null, null, this.P3);
        this.p0.setOnClickListener(this.N3);
      }
      if ((0xA8 & l) != 0L) {
        CompoundButtonBindingAdapter.setChecked(this.d, bool1);
      }
      if ((l & 0xA2) != 0L) {
        b.J(this.f, (String)localObject4);
      }
      if ((l & 0xA1) != 0L) {
        TextViewBindingAdapter.setText(this.z, (CharSequence)localObject2);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.Q3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.Q3 = 128L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.H3 = paramCameraOnBoardingViewModel;
    try
    {
      this.Q3 |= 0x20;
      notifyPropertyChanged(68);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void o(@Nullable g paramg)
  {
    this.I3 = paramg;
    try
    {
      this.Q3 |= 0x10;
      notifyPropertyChanged(79);
      super.requestRebind();
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
          return h((ObservableBoolean)paramObject, paramInt2);
        }
        return m((ObservableBoolean)paramObject, paramInt2);
      }
      return i((ObservableField)paramObject, paramInt2);
    }
    return l((ObservableField)paramObject, paramInt2);
  }
  
  public void p(@Nullable InputPwdViewModel paramInputPwdViewModel)
  {
    this.p3 = paramInputPwdViewModel;
    try
    {
      this.Q3 |= 0x40;
      notifyPropertyChanged(103);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      o((g)paramObject);
    }
    else if (68 == paramInt)
    {
      n((CameraOnBoardingViewModel)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      p((InputPwdViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label53:
    bool = false;
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      boolean bool = FragmentCameraV2InputPwdBindingImpl.this.d.isChecked();
      Object localObject = FragmentCameraV2InputPwdBindingImpl.this.H3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((CameraOnBoardingViewModel)localObject).e;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableBoolean)localObject).set(bool);
        }
      }
    }
  }
  
  class b
    implements InverseBindingListener
  {
    b() {}
    
    public void onChange()
    {
      String str = b.d(FragmentCameraV2InputPwdBindingImpl.this.f);
      Object localObject = FragmentCameraV2InputPwdBindingImpl.this.H3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((CameraOnBoardingViewModel)localObject).b;
        if (localObject != null) {
          j = i;
        } else {
          j = 0;
        }
        if (j != 0) {
          ((ObservableField)localObject).set(str);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InputPwdBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */