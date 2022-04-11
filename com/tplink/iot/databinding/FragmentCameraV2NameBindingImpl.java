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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSetNameViewModel;
import com.tplink.iot.widget.DrawableEditText;

public class FragmentCameraV2NameBindingImpl
  extends FragmentCameraV2NameBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final LinearLayout H3;
  @Nullable
  private final View.OnClickListener I3;
  private InverseBindingListener J3 = new a();
  private long K3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 3);
    localSparseIntArray.put(2131363880, 4);
    localSparseIntArray.put(2131364688, 5);
    localSparseIntArray.put(2131364674, 6);
  }
  
  public FragmentCameraV2NameBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 7, p2, p3));
  }
  
  private FragmentCameraV2NameBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 2, (Button)paramArrayOfObject[2], (DrawableEditText)paramArrayOfObject[1], (RelativeLayout)paramArrayOfObject[4], (Toolbar)paramArrayOfObject[3], (TextView)paramArrayOfObject[6], (TextView)paramArrayOfObject[5]);
    this.c.setTag(null);
    this.d.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.I3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean h(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.K3 |= 1L;
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
        this.K3 |= 0x2;
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
      long l = this.K3;
      this.K3 = 0L;
      Object localObject1 = this.p0;
      Object localObject3 = this.z;
      boolean bool1 = false;
      boolean bool2 = (0x29 & l) < 0L;
      if (bool2)
      {
        if (localObject1 != null) {
          localObject1 = ((CameraOnBoardingViewModel)localObject1).c;
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        if (localObject1 != null)
        {
          localObject1 = (String)((ObservableField)localObject1).get();
          break label80;
        }
      }
      localObject1 = null;
      label80:
      boolean bool3 = (0x32 & l) < 0L;
      boolean bool4 = bool1;
      if (bool3)
      {
        if (localObject3 != null) {
          localObject3 = ((CameraSetNameViewModel)localObject3).a;
        } else {
          localObject3 = null;
        }
        updateRegistration(1, (Observable)localObject3);
        bool4 = bool1;
        if (localObject3 != null) {
          bool4 = ((ObservableBoolean)localObject3).get();
        }
      }
      if (bool3) {
        this.c.setEnabled(bool4);
      }
      if ((l & 0x20) != 0L)
      {
        this.c.setOnClickListener(this.I3);
        b.I(this.d, null, null, null, this.J3);
      }
      if (bool2) {
        b.J(this.d, (String)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.K3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.K3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.p0 = paramCameraOnBoardingViewModel;
    try
    {
      this.K3 |= 0x8;
      notifyPropertyChanged(68);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable g paramg)
  {
    this.p1 = paramg;
    try
    {
      this.K3 |= 0x4;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable CameraSetNameViewModel paramCameraSetNameViewModel)
  {
    this.z = paramCameraSetNameViewModel;
    try
    {
      this.K3 |= 0x10;
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
      if (paramInt1 != 1) {
        return false;
      }
      return i((ObservableBoolean)paramObject, paramInt2);
    }
    return h((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (79 == paramInt)
    {
      m((g)paramObject);
    }
    else if (68 == paramInt)
    {
      l((CameraOnBoardingViewModel)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label53;
      }
      n((CameraSetNameViewModel)paramObject);
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
      String str = b.d(FragmentCameraV2NameBindingImpl.this.d);
      Object localObject = FragmentCameraV2NameBindingImpl.this.p0;
      int i = 1;
      int j;
      if (localObject != null) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = ((CameraOnBoardingViewModel)localObject).c;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2NameBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */