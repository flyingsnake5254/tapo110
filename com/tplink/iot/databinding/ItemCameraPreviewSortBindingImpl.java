package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.adapter.databinding.f;
import com.tplink.iot.generated.callback.c;
import com.tplink.iot.generated.callback.c.a;
import com.tplink.iot.view.ipcamera.base.b;

public class ItemCameraPreviewSortBindingImpl
  extends ItemCameraPreviewSortBinding
  implements c.a
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final ConstraintLayout I3;
  @Nullable
  private final View.OnTouchListener J3;
  private long K3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131362797, 4);
  }
  
  public ItemCameraPreviewSortBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 5, p3, H3));
  }
  
  private ItemCameraPreviewSortBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[4], (TextView)paramArrayOfObject[2], (TextView)paramArrayOfObject[1], (ImageView)paramArrayOfObject[3]);
    this.d.setTag(null);
    paramDataBindingComponent = (ConstraintLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    setRootTag(paramView);
    this.J3 = new c(this, 1);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.K3;
      this.K3 = 0L;
      String str1 = this.p0;
      String str2 = this.z;
      if ((0x41 & l) != 0L) {
        TextViewBindingAdapter.setText(this.d, str1);
      }
      if ((0x60 & l) != 0L) {
        TextViewBindingAdapter.setText(this.f, str2);
      }
      if ((l & 0x40) != 0L) {
        b.A(this.q, this.J3);
      }
      return;
    }
    finally {}
  }
  
  public final boolean f(int paramInt, View paramView, MotionEvent paramMotionEvent)
  {
    RecyclerView.ViewHolder localViewHolder = this.p1;
    f localf = this.p2;
    boolean bool = false;
    if (localf != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      bool = localf.a(paramView, paramMotionEvent, localViewHolder);
    }
    return bool;
  }
  
  public void h(@Nullable String paramString)
  {
    this.y = paramString;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.K3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable String paramString)
  {
    this.p0 = paramString;
    try
    {
      this.K3 |= 1L;
      notifyPropertyChanged(4);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.K3 = 64L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable String paramString)
  {
    this.z = paramString;
    try
    {
      this.K3 |= 0x20;
      notifyPropertyChanged(5);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable f paramf)
  {
    this.p2 = paramf;
    try
    {
      this.K3 |= 0x10;
      notifyPropertyChanged(65);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable Integer paramInteger)
  {
    this.x = paramInteger;
  }
  
  public void o(@Nullable RecyclerView.ViewHolder paramViewHolder)
  {
    this.p1 = paramViewHolder;
    try
    {
      this.K3 |= 0x8;
      notifyPropertyChanged(102);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (4 == paramInt)
    {
      i((String)paramObject);
    }
    else if (76 == paramInt)
    {
      n((Integer)paramObject);
    }
    else if (3 == paramInt)
    {
      h((String)paramObject);
    }
    else if (102 == paramInt)
    {
      o((RecyclerView.ViewHolder)paramObject);
    }
    else if (65 == paramInt)
    {
      m((f)paramObject);
    }
    else
    {
      if (5 != paramInt) {
        break label101;
      }
      l((String)paramObject);
    }
    boolean bool = true;
    return bool;
    label101:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraPreviewSortBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */