package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.widget.RoundImageView;
import com.tplink.iot.widget.camerapreview.e;

public class ViewPreviewDisplayBindingImpl
  extends ViewPreviewDisplayBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts O3;
  @Nullable
  private static final SparseIntArray P3;
  @NonNull
  private final ConstraintLayout Q3;
  @NonNull
  private final ImageView R3;
  @NonNull
  private final View S3;
  @NonNull
  private final ImageView T3;
  private long U3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    P3 = localSparseIntArray;
    localSparseIntArray.put(2131363253, 9);
    localSparseIntArray.put(2131363691, 10);
    localSparseIntArray.put(2131363147, 11);
    localSparseIntArray.put(2131362178, 12);
    localSparseIntArray.put(2131364694, 13);
    localSparseIntArray.put(2131363574, 14);
    localSparseIntArray.put(2131362177, 15);
    localSparseIntArray.put(2131362407, 16);
  }
  
  public ViewPreviewDisplayBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 17, O3, P3));
  }
  
  private ViewPreviewDisplayBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 3, (LinearLayout)paramArrayOfObject[2], (RoundImageView)paramArrayOfObject[15], (ImageView)paramArrayOfObject[12], (TextView)paramArrayOfObject[3], (TextView)paramArrayOfObject[16], (TextView)paramArrayOfObject[7], (RoundImageView)paramArrayOfObject[11], (FrameLayout)paramArrayOfObject[9], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[14], (View)paramArrayOfObject[10], (ImageView)paramArrayOfObject[4], (TextView)paramArrayOfObject[13]);
    this.c.setTag(null);
    this.q.setTag(null);
    this.y.setTag(null);
    this.p1.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.Q3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[1];
    this.R3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (View)paramArrayOfObject[6];
    this.S3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[8];
    this.T3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.H3.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean o(MutableLiveData<String> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.U3 |= 0x2;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean p(MutableLiveData<Boolean> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.U3 |= 1L;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  private boolean q(MutableLiveData<e> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.U3 |= 0x4;
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
      long l1 = this.U3;
      this.U3 = 0L;
      Object localObject1 = this.N3;
      Object localObject3 = this.M3;
      Object localObject4 = this.J3;
      Boolean localBoolean1 = this.L3;
      Boolean localBoolean2 = this.K3;
      boolean bool1;
      if ((l1 & 0x21) != 0L)
      {
        if (localObject1 != null) {
          localObject1 = (Boolean)((LiveData)localObject1).getValue();
        } else {
          localObject1 = null;
        }
        bool1 = ViewDataBinding.safeUnbox((Boolean)localObject1);
      }
      else
      {
        bool1 = false;
      }
      String str1;
      if (((l1 & 0x22) != 0L) && (localObject3 != null)) {
        str1 = (String)((LiveData)localObject3).getValue();
      } else {
        str1 = null;
      }
      boolean bool2 = true;
      boolean bool4;
      boolean bool5;
      boolean bool8;
      if ((l1 & 0x3C) != 0L)
      {
        if (localObject4 != null) {
          localObject1 = (e)((LiveData)localObject4).getValue();
        } else {
          localObject1 = null;
        }
        bool3 = (l1 & 0x24) < 0L;
        Object localObject5;
        long l2;
        if (bool3)
        {
          String str2;
          if (localObject1 != null)
          {
            str2 = ((e)localObject1).p();
            localObject5 = ((e)localObject1).y();
            localObject4 = ((e)localObject1).x();
            localObject3 = ((e)localObject1).u();
          }
          else
          {
            str2 = null;
            localObject5 = str2;
            localObject4 = localObject5;
            localObject3 = localObject4;
          }
          bool4 = ViewDataBinding.safeUnbox((Boolean)localObject4);
          bool5 = ViewDataBinding.safeUnbox((Boolean)localObject3);
          bool6 = bool4 ^ true;
          l2 = l1;
          localObject3 = str2;
          localObject4 = localObject5;
          bool7 = bool6;
          bool4 = bool5;
          if (bool3) {
            if (bool6)
            {
              l2 = l1 | 0x200;
              localObject3 = str2;
              localObject4 = localObject5;
              bool7 = bool6;
              bool4 = bool5;
            }
            else
            {
              l2 = l1 | 0x100;
              localObject3 = str2;
              localObject4 = localObject5;
              bool7 = bool6;
              bool4 = bool5;
            }
          }
        }
        else
        {
          localObject3 = null;
          localObject4 = localObject3;
          bool7 = false;
          bool4 = false;
          l2 = l1;
        }
        bool6 = (l2 & 0x34) < 0L;
        if (bool6)
        {
          if (localObject1 != null) {
            localObject5 = ((e)localObject1).w();
          } else {
            localObject5 = null;
          }
          bool8 = ViewDataBinding.safeUnbox((Boolean)localObject5);
          l1 = l2;
          bool5 = bool8;
          if (bool6) {
            if (bool8)
            {
              l1 = l2 | 0x800;
              bool5 = bool8;
            }
            else
            {
              l1 = l2 | 0x400;
              bool5 = bool8;
            }
          }
        }
        else
        {
          bool5 = false;
          l1 = l2;
        }
        bool6 = (l1 & 0x2C) < 0L;
        if (bool6)
        {
          if (localObject1 != null) {
            localObject5 = ((e)localObject1).x();
          } else {
            localObject5 = null;
          }
          bool9 = ViewDataBinding.safeUnbox((Boolean)localObject5);
          l2 = l1;
          if (bool6) {
            if (bool9) {
              l2 = l1 | 0x80;
            } else {
              l2 = l1 | 0x40;
            }
          }
          l1 = l2;
          bool10 = bool4;
          bool11 = bool5;
          break label524;
        }
      }
      else
      {
        localObject1 = null;
        localObject4 = localObject1;
        localObject3 = localObject4;
        bool7 = false;
        bool4 = false;
        bool5 = false;
      }
      boolean bool9 = false;
      boolean bool11 = bool5;
      boolean bool10 = bool4;
      label524:
      if ((l1 & 0x100) != 0L)
      {
        if (localObject1 != null) {
          localObject1 = ((e)localObject1).s();
        } else {
          localObject1 = null;
        }
        bool5 = ViewDataBinding.safeUnbox((Boolean)localObject1);
      }
      else
      {
        bool5 = false;
      }
      if ((l1 & 0x80) != 0L) {
        bool8 = ViewDataBinding.safeUnbox(localBoolean1);
      } else {
        bool8 = false;
      }
      if ((l1 & 0x800) != 0L) {
        bool4 = ViewDataBinding.safeUnbox(localBoolean2);
      } else {
        bool4 = false;
      }
      boolean bool6 = (l1 & 0x2C) < 0L;
      if ((!bool6) || (!bool9)) {
        bool8 = false;
      }
      boolean bool3 = (l1 & 0x24) < 0L;
      if (bool3)
      {
        if (bool7) {
          bool5 = bool2;
        }
      }
      else {
        bool5 = false;
      }
      boolean bool7 = (l1 & 0x34) < 0L;
      if (bool7)
      {
        if (!bool11) {
          bool4 = false;
        }
      }
      else {
        bool4 = false;
      }
      if (bool7) {
        b.Q(this.c, bool4);
      }
      if (bool3)
      {
        TextViewBindingAdapter.setText(this.q, (CharSequence)localObject4);
        TextViewBindingAdapter.setText(this.y, (CharSequence)localObject3);
        b.Q(this.y, bool5);
        b.Q(this.S3, bool11);
        b.p(this.T3, bool10);
        b.Q(this.T3, bool10);
      }
      if (bool6) {
        b.Q(this.q, bool8);
      }
      if ((0x20 & l1) != 0L)
      {
        localObject4 = this.p1;
        localObject1 = Boolean.TRUE;
        b.q((View)localObject4, (Boolean)localObject1, null);
        b.q(this.H3, (Boolean)localObject1, null);
      }
      if ((0x22 & l1) != 0L) {
        b.D(this.R3, str1);
      }
      if ((l1 & 0x21) != 0L) {
        b.Q(this.R3, bool1);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable Boolean paramBoolean)
  {
    this.K3 = paramBoolean;
    try
    {
      this.U3 |= 0x10;
      notifyPropertyChanged(56);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.U3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable MutableLiveData<String> paramMutableLiveData)
  {
    updateLiveDataRegistration(1, paramMutableLiveData);
    this.M3 = paramMutableLiveData;
    try
    {
      this.U3 |= 0x2;
      notifyPropertyChanged(80);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.U3 = 32L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable MutableLiveData<Boolean> paramMutableLiveData)
  {
    updateLiveDataRegistration(0, paramMutableLiveData);
    this.N3 = paramMutableLiveData;
    try
    {
      this.U3 |= 1L;
      notifyPropertyChanged(81);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable Boolean paramBoolean)
  {
    this.L3 = paramBoolean;
    try
    {
      this.U3 |= 0x8;
      notifyPropertyChanged(91);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable MutableLiveData<e> paramMutableLiveData)
  {
    updateLiveDataRegistration(2, paramMutableLiveData);
    this.J3 = paramMutableLiveData;
    try
    {
      this.U3 |= 0x4;
      notifyPropertyChanged(104);
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
        return q((MutableLiveData)paramObject, paramInt2);
      }
      return o((MutableLiveData)paramObject, paramInt2);
    }
    return p((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (81 == paramInt)
    {
      l((MutableLiveData)paramObject);
    }
    else if (80 == paramInt)
    {
      i((MutableLiveData)paramObject);
    }
    else if (104 == paramInt)
    {
      n((MutableLiveData)paramObject);
    }
    else if (91 == paramInt)
    {
      m((Boolean)paramObject);
    }
    else
    {
      if (56 != paramInt) {
        break label87;
      }
      h((Boolean)paramObject);
    }
    boolean bool = true;
    return bool;
    label87:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ViewPreviewDisplayBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */