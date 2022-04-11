package com.tplink.iot.databinding;

import android.graphics.drawable.Drawable;
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
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTroubleShootingViewModel;

public class FragmentCameraV2TroubleShootingBindingImpl
  extends FragmentCameraV2TroubleShootingBinding
  implements a.a
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
  private final ImageView M3;
  @NonNull
  private final TextView N3;
  @NonNull
  private final TextView O3;
  @NonNull
  private final ImageView P3;
  @Nullable
  private final View.OnClickListener Q3;
  private long R3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    I3 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 8);
    localSparseIntArray.put(2131363299, 9);
    localSparseIntArray.put(2131364252, 10);
    localSparseIntArray.put(2131364247, 11);
    localSparseIntArray.put(2131362472, 12);
    localSparseIntArray.put(2131364111, 13);
    localSparseIntArray.put(2131362473, 14);
    localSparseIntArray.put(2131364112, 15);
  }
  
  public FragmentCameraV2TroubleShootingBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 16, H3, I3));
  }
  
  private FragmentCameraV2TroubleShootingBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 6, (Button)paramArrayOfObject[7], (FrameLayout)paramArrayOfObject[12], (FrameLayout)paramArrayOfObject[14], (RelativeLayout)paramArrayOfObject[9], (LinearLayout)paramArrayOfObject[13], (LinearLayout)paramArrayOfObject[15], (TextView)paramArrayOfObject[11], (TextView)paramArrayOfObject[10], (Toolbar)paramArrayOfObject[8]);
    this.c.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[1];
    this.K3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[2];
    this.L3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[3];
    this.M3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[4];
    this.N3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[5];
    this.O3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[6];
    this.P3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.Q3 = new a(this, 1);
    invalidateAll();
  }
  
  private boolean h(ObservableField<Drawable> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 0x2;
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
        this.R3 |= 1L;
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
        this.R3 |= 0x8;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean m(ObservableField<Drawable> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 0x20;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean n(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.R3 |= 0x10;
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
        this.R3 |= 0x4;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public final void d(int paramInt, View paramView)
  {
    g localg = this.p3;
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
      long l = this.R3;
      this.R3 = 0L;
      Object localObject1 = this.p2;
      Object localObject2 = null;
      Object localObject3;
      label87:
      Object localObject5;
      label142:
      Object localObject6;
      label197:
      Object localObject7;
      label252:
      Object localObject8;
      label307:
      Object localObject9;
      if ((0x1BF & l) != 0L)
      {
        if ((l & 0x181) != 0L)
        {
          if (localObject1 != null) {
            localObject3 = ((CameraTroubleShootingViewModel)localObject1).b;
          } else {
            localObject3 = null;
          }
          updateRegistration(0, (Observable)localObject3);
          if (localObject3 != null)
          {
            localObject3 = (String)((ObservableField)localObject3).get();
            break label87;
          }
        }
        localObject3 = null;
        if ((l & 0x182) != 0L)
        {
          if (localObject1 != null) {
            localObject5 = ((CameraTroubleShootingViewModel)localObject1).c;
          } else {
            localObject5 = null;
          }
          updateRegistration(1, (Observable)localObject5);
          if (localObject5 != null)
          {
            localObject5 = (Drawable)((ObservableField)localObject5).get();
            break label142;
          }
        }
        localObject5 = null;
        if ((l & 0x184) != 0L)
        {
          if (localObject1 != null) {
            localObject6 = ((CameraTroubleShootingViewModel)localObject1).d;
          } else {
            localObject6 = null;
          }
          updateRegistration(2, (Observable)localObject6);
          if (localObject6 != null)
          {
            localObject6 = (String)((ObservableField)localObject6).get();
            break label197;
          }
        }
        localObject6 = null;
        if ((l & 0x188) != 0L)
        {
          if (localObject1 != null) {
            localObject7 = ((CameraTroubleShootingViewModel)localObject1).a;
          } else {
            localObject7 = null;
          }
          updateRegistration(3, (Observable)localObject7);
          if (localObject7 != null)
          {
            localObject7 = (String)((ObservableField)localObject7).get();
            break label252;
          }
        }
        localObject7 = null;
        if ((l & 0x190) != 0L)
        {
          if (localObject1 != null) {
            localObject8 = ((CameraTroubleShootingViewModel)localObject1).e;
          } else {
            localObject8 = null;
          }
          updateRegistration(4, (Observable)localObject8);
          if (localObject8 != null)
          {
            localObject8 = (String)((ObservableField)localObject8).get();
            break label307;
          }
        }
        localObject8 = null;
        localObject9 = localObject2;
        if ((l & 0x1A0) != 0L)
        {
          if (localObject1 != null) {
            localObject1 = ((CameraTroubleShootingViewModel)localObject1).f;
          } else {
            localObject1 = null;
          }
          updateRegistration(5, (Observable)localObject1);
          localObject9 = localObject2;
          if (localObject1 != null) {
            localObject9 = (Drawable)((ObservableField)localObject1).get();
          }
        }
        localObject1 = localObject7;
        localObject7 = localObject8;
        localObject8 = localObject6;
      }
      else
      {
        localObject9 = null;
        localObject3 = localObject9;
        localObject5 = localObject3;
        localObject6 = localObject5;
        localObject7 = localObject6;
        localObject8 = localObject7;
        localObject1 = localObject6;
      }
      if ((l & 0x100) != 0L) {
        this.c.setOnClickListener(this.Q3);
      }
      if ((l & 0x188) != 0L) {
        TextViewBindingAdapter.setText(this.K3, (CharSequence)localObject1);
      }
      if ((l & 0x181) != 0L) {
        TextViewBindingAdapter.setText(this.L3, (CharSequence)localObject3);
      }
      if ((0x182 & l) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.M3, (Drawable)localObject5);
      }
      if ((0x184 & l) != 0L) {
        TextViewBindingAdapter.setText(this.N3, (CharSequence)localObject8);
      }
      if ((l & 0x190) != 0L) {
        TextViewBindingAdapter.setText(this.O3, (CharSequence)localObject7);
      }
      if ((l & 0x1A0) != 0L) {
        ImageViewBindingAdapter.setImageDrawable(this.P3, (Drawable)localObject9);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.R3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.R3 = 256L;
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
              return m((ObservableField)paramObject, paramInt2);
            }
            return n((ObservableField)paramObject, paramInt2);
          }
          return l((ObservableField)paramObject, paramInt2);
        }
        return o((ObservableField)paramObject, paramInt2);
      }
      return h((ObservableField)paramObject, paramInt2);
    }
    return i((ObservableField)paramObject, paramInt2);
  }
  
  public void p(@Nullable g paramg)
  {
    this.p3 = paramg;
    try
    {
      this.R3 |= 0x40;
      notifyPropertyChanged(79);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void q(@Nullable CameraTroubleShootingViewModel paramCameraTroubleShootingViewModel)
  {
    this.p2 = paramCameraTroubleShootingViewModel;
    try
    {
      this.R3 |= 0x80;
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
      p((g)paramObject);
    }
    else
    {
      if (103 != paramInt) {
        break label36;
      }
      q((CameraTroubleShootingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2TroubleShootingBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */