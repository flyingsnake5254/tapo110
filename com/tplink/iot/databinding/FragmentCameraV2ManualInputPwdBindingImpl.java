package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraManualInputPwdViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.DrawableEditText;

public class FragmentCameraV2ManualInputPwdBindingImpl
  extends FragmentCameraV2ManualInputPwdBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts I3;
  @Nullable
  private static final SparseIntArray J3;
  @NonNull
  private final LinearLayout K3;
  @Nullable
  private final View.OnClickListener L3;
  private InverseBindingListener M3 = new a();
  private InverseBindingListener N3 = new b();
  private long O3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    J3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 4);
    localSparseIntArray.put(2131363880, 5);
    localSparseIntArray.put(2131364688, 6);
    localSparseIntArray.put(2131364682, 7);
    localSparseIntArray.put(2131364683, 8);
    localSparseIntArray.put(2131364568, 9);
  }
  
  public FragmentCameraV2ManualInputPwdBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, I3, J3));
  }
  
  private FragmentCameraV2ManualInputPwdBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (Button)paramArrayOfObject[3], (DrawableEditText)paramArrayOfObject[1], (DrawableEditText)paramArrayOfObject[2], (RelativeLayout)paramArrayOfObject[5], (Toolbar)paramArrayOfObject[4], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[8], (TextView)paramArrayOfObject[6]);
    this.c.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.L3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean h(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean i(ObservableField<String> paramObservableField, int paramInt)
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
  
  private boolean l(ObservableBoolean paramObservableBoolean, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.O3 |= 0x4;
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
      Object localObject1 = this.p3;
      float f = 0.0F;
      Object localObject2 = this.p2;
      boolean bool1 = false;
      boolean bool2 = false;
      Object localObject3;
      if ((0x53 & l1) != 0L)
      {
        if ((l1 & 0x51) != 0L)
        {
          if (localObject1 != null) {
            localObject3 = ((CameraOnBoardingViewModel)localObject1).a;
          } else {
            localObject3 = null;
          }
          updateRegistration(0, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label99;
          }
        }
        localObject3 = null;
        label99:
        if ((l1 & 0x52) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((CameraOnBoardingViewModel)localObject1).b;
          } else {
            localObject1 = null;
          }
          updateRegistration(1, (Observable)localObject1);
          if (localObject1 != null)
          {
            localObject1 = (String)((ObservableField)localObject1).get();
            break label155;
          }
        }
        localObject1 = null;
      }
      else
      {
        localObject1 = null;
        localObject3 = localObject1;
      }
      label155:
      boolean bool3 = (l1 & 0x64) < 0L;
      long l2 = l1;
      if (bool3)
      {
        if (localObject2 != null) {
          localObject2 = ((CameraManualInputPwdViewModel)localObject2).b;
        } else {
          localObject2 = null;
        }
        updateRegistration(2, (Observable)localObject2);
        bool1 = bool2;
        if (localObject2 != null) {
          bool1 = ((ObservableBoolean)localObject2).get();
        }
        l2 = l1;
        if (bool3)
        {
          if (bool1) {
            l2 = 256L;
          } else {
            l2 = 128L;
          }
          l2 = l1 | l2;
        }
        if (bool1) {
          f = 1.0F;
        } else {
          f = 0.3F;
        }
      }
      if ((l2 & 0x64) != 0L)
      {
        if (ViewDataBinding.getBuildSdkInt() >= 11) {
          this.c.setAlpha(f);
        }
        this.c.setEnabled(bool1);
      }
      if ((0x40 & l2) != 0L)
      {
        this.c.setOnClickListener(this.L3);
        b.I(this.d, null, null, null, this.M3);
        b.I(this.f, null, null, null, this.N3);
      }
      if ((l2 & 0x51) != 0L) {
        b.J(this.d, (String)localObject3);
      }
      if ((l2 & 0x52) != 0L) {
        b.J(this.f, (String)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.O3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.O3 = 64L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p3 = paramCameraOnBoardingViewModel;
    try
    {
      this.O3 |= 0x10;
      notifyPropertyChanged(68);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable g paramg)
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
  
  public void o(@Nullable CameraManualInputPwdViewModel paramCameraManualInputPwdViewModel)
  {
    this.p2 = paramCameraManualInputPwdViewModel;
    try
    {
      this.O3 |= 0x20;
      notifyPropertyChanged(103);
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
        if (paramInt1 != 2) {
          return false;
        }
        return l((ObservableBoolean)paramObject, paramInt2);
      }
      return h((ObservableField)paramObject, paramInt2);
    }
    return i((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      n((g)paramObject);
    }
    else if (68 == paramInt)
    {
      m((CameraOnBoardingViewModel)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      o((CameraManualInputPwdViewModel)paramObject);
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
      String str = b.d(FragmentCameraV2ManualInputPwdBindingImpl.this.d);
      Object localObject = FragmentCameraV2ManualInputPwdBindingImpl.this.p3;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((CameraOnBoardingViewModel)localObject).a;
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
  
  class b
    implements InverseBindingListener
  {
    b() {}
    
    public void onChange()
    {
      String str = b.d(FragmentCameraV2ManualInputPwdBindingImpl.this.f);
      Object localObject = FragmentCameraV2ManualInputPwdBindingImpl.this.p3;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2ManualInputPwdBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */