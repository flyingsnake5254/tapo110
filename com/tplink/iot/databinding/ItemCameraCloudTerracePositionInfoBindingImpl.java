package com.tplink.iot.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.generated.callback.a.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.viewmodel.ipcamera.play.e3;

public class ItemCameraCloudTerracePositionInfoBindingImpl
  extends ItemCameraCloudTerracePositionInfoBinding
  implements a.a
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p1;
  @Nullable
  private static final SparseIntArray p2;
  @NonNull
  private final ImageView H3;
  @NonNull
  private final ImageView I3;
  @NonNull
  private final TextView J3;
  @Nullable
  private final View.OnClickListener K3;
  @Nullable
  private final View.OnClickListener L3;
  private a M3;
  private long N3 = -1L;
  @NonNull
  private final RelativeLayout p3;
  
  public ItemCameraCloudTerracePositionInfoBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 4, p1, p2));
  }
  
  private ItemCameraCloudTerracePositionInfoBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.p3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[1];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (ImageView)paramArrayOfObject[2];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    paramDataBindingComponent = (TextView)paramArrayOfObject[3];
    this.J3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    this.K3 = new a(this, 1);
    this.L3 = new a(this, 2);
    invalidateAll();
  }
  
  private boolean h(LiveData<Boolean> paramLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.N3 |= 1L;
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
    Object localObject;
    String str;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localObject = this.y;
        paramView = this.f;
        str = this.d;
        paramInt = j;
        if (localObject != null) {
          paramInt = 1;
        }
        if (paramInt != 0) {
          ((e3)localObject).a(str, paramView);
        }
      }
    }
    else
    {
      localObject = this.f;
      paramView = this.x;
      str = this.d;
      paramInt = i;
      if (paramView != null) {
        paramInt = 1;
      }
      if (paramInt != 0) {
        paramView.a(str, (Integer)localObject);
      }
    }
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.N3;
      this.N3 = 0L;
      Object localObject1 = this.p0;
      View.OnLongClickListener localOnLongClickListener = this.z;
      String str = this.d;
      Object localObject2 = this.q;
      Boolean localBoolean = null;
      Object localObject3 = null;
      boolean bool1 = false;
      boolean bool2 = (0x103 & l) < 0L;
      boolean bool3;
      boolean bool4;
      if (bool2)
      {
        if (localObject1 != null) {
          localBoolean = (Boolean)((LiveData)localObject1).getValue();
        } else {
          localBoolean = null;
        }
        if (localOnLongClickListener != null)
        {
          localObject1 = this.M3;
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = new a();
            this.M3 = ((a)localObject3);
          }
          localObject3 = ((a)localObject3).a(localOnLongClickListener);
        }
        bool3 = ViewDataBinding.safeUnbox(localBoolean);
        bool4 = bool3 ^ true;
      }
      else
      {
        bool3 = false;
        bool4 = false;
        localObject3 = localBoolean;
      }
      boolean bool5 = (0x110 & l) < 0L;
      if (bool5) {
        bool1 = TextUtils.isEmpty(str) ^ true;
      }
      if ((0x100 & l) != 0L)
      {
        this.H3.setOnClickListener(this.K3);
        this.I3.setOnClickListener(this.L3);
      }
      if ((0x120 & l) != 0L) {
        b.F(this.H3, localObject2);
      }
      if (bool2) {
        ViewBindingAdapter.setOnLongClick(this.H3, (View.OnLongClickListener)localObject3, bool4);
      }
      if ((l & 0x101) != 0L) {
        b.Q(this.I3, bool3);
      }
      if (bool5)
      {
        TextViewBindingAdapter.setText(this.J3, str);
        b.Q(this.J3, bool1);
      }
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.N3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable e3 parame3)
  {
    this.y = parame3;
    try
    {
      this.N3 |= 0x40;
      notifyPropertyChanged(14);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.N3 = 256L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable Object paramObject)
  {
    this.q = paramObject;
    try
    {
      this.N3 |= 0x20;
      notifyPropertyChanged(22);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void m(@Nullable e3 parame3)
  {
    this.x = parame3;
    try
    {
      this.N3 |= 0x8;
      notifyPropertyChanged(26);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void n(@Nullable Integer paramInteger)
  {
    this.f = paramInteger;
    try
    {
      this.N3 |= 0x80;
      notifyPropertyChanged(28);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void o(@Nullable LiveData<Boolean> paramLiveData)
  {
    updateLiveDataRegistration(0, paramLiveData);
    this.p0 = paramLiveData;
    try
    {
      this.N3 |= 1L;
      notifyPropertyChanged(29);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return h((LiveData)paramObject, paramInt2);
  }
  
  public void p(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.z = paramOnLongClickListener;
    try
    {
      this.N3 |= 0x2;
      notifyPropertyChanged(59);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void q(@Nullable String paramString)
  {
    this.d = paramString;
    try
    {
      this.N3 |= 0x10;
      notifyPropertyChanged(67);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void r(@Nullable Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (29 == paramInt)
    {
      o((LiveData)paramObject);
    }
    else if (59 == paramInt)
    {
      p((View.OnLongClickListener)paramObject);
    }
    else if (76 == paramInt)
    {
      r((Integer)paramObject);
    }
    else if (26 == paramInt)
    {
      m((e3)paramObject);
    }
    else if (67 == paramInt)
    {
      q((String)paramObject);
    }
    else if (22 == paramInt)
    {
      l(paramObject);
    }
    else if (14 == paramInt)
    {
      i((e3)paramObject);
    }
    else
    {
      if (28 != paramInt) {
        break label135;
      }
      n((Integer)paramObject);
    }
    boolean bool = true;
    return bool;
    label135:
    bool = false;
    return bool;
  }
  
  public static class a
    implements View.OnLongClickListener
  {
    private View.OnLongClickListener c;
    
    public a a(View.OnLongClickListener paramOnLongClickListener)
    {
      this.c = paramOnLongClickListener;
      if (paramOnLongClickListener == null) {
        paramOnLongClickListener = null;
      } else {
        paramOnLongClickListener = this;
      }
      return paramOnLongClickListener;
    }
    
    public boolean onLongClick(View paramView)
    {
      return this.c.onLongClick(paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraCloudTerracePositionInfoBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */