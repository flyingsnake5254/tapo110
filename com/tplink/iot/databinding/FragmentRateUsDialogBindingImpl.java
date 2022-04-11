package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.tplink.iot.view.ipcamera.base.g;

public class FragmentRateUsDialogBindingImpl
  extends FragmentRateUsDialogBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final LinearLayout I3;
  private a J3;
  private long K3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131364252, 7);
    localSparseIntArray.put(2131364105, 8);
  }
  
  public FragmentRateUsDialogBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, p3, H3));
  }
  
  private FragmentRateUsDialogBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (ImageButton)paramArrayOfObject[1], (ImageButton)paramArrayOfObject[2], (ImageButton)paramArrayOfObject[3], (ImageButton)paramArrayOfObject[4], (ImageButton)paramArrayOfObject[5], (ImageButton)paramArrayOfObject[6], (LinearLayout)paramArrayOfObject[8], (TextView)paramArrayOfObject[7]);
    this.c.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.d.setTag(null);
    this.f.setTag(null);
    this.q.setTag(null);
    this.x.setTag(null);
    this.y.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean h(ObservableInt paramObservableInt, int paramInt)
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
  
  protected void executeBindings()
  {
    try
    {
      long l1 = this.K3;
      this.K3 = 0L;
      Object localObject1 = this.p2;
      Object localObject2 = this.p1;
      Object localObject3 = null;
      Object localObject4;
      Object localObject5;
      a locala;
      if (((l1 & 0x6) != 0L) && (localObject1 != null))
      {
        localObject4 = this.J3;
        localObject5 = localObject4;
        if (localObject4 == null)
        {
          localObject5 = new a();
          this.J3 = ((a)localObject5);
        }
        locala = ((a)localObject5).a((g)localObject1);
      }
      else
      {
        locala = null;
      }
      boolean bool = (l1 & 0x5) < 0L;
      long l2;
      Object localObject7;
      Object localObject8;
      if (bool)
      {
        int i;
        if (localObject2 != null) {
          i = ((ObservableInt)localObject2).get();
        } else {
          i = 0;
        }
        int j;
        if (i >= 1) {
          j = 1;
        } else {
          j = 0;
        }
        int k;
        if (i >= 3) {
          k = 1;
        } else {
          k = 0;
        }
        int m;
        if (i >= 2) {
          m = 1;
        } else {
          m = 0;
        }
        int n;
        if (i >= 4) {
          n = 1;
        } else {
          n = 0;
        }
        if (i >= 5) {
          i = 1;
        } else {
          i = 0;
        }
        l2 = l1;
        if (bool)
        {
          if (j != 0) {
            l2 = 64L;
          } else {
            l2 = 32L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0x5) != 0L)
        {
          if (k != 0) {
            l1 = 4096L;
          } else {
            l1 = 2048L;
          }
          l1 = l2 | l1;
        }
        l2 = l1;
        if ((l1 & 0x5) != 0L)
        {
          if (m != 0) {
            l2 = 256L;
          } else {
            l2 = 128L;
          }
          l2 = l1 | l2;
        }
        l1 = l2;
        if ((l2 & 0x5) != 0L)
        {
          if (n != 0) {
            l1 = 1024L;
          } else {
            l1 = 512L;
          }
          l1 = l2 | l1;
        }
        l2 = l1;
        if ((l1 & 0x5) != 0L)
        {
          if (i != 0) {
            l2 = 16L;
          } else {
            l2 = 8L;
          }
          l2 = l1 | l2;
        }
        localObject5 = this.d.getContext();
        if (j != 0) {
          localObject4 = AppCompatResources.getDrawable((Context)localObject5, 2131231568);
        } else {
          localObject4 = AppCompatResources.getDrawable((Context)localObject5, 2131231567);
        }
        localObject5 = this.q.getContext();
        if (k != 0) {
          localObject5 = AppCompatResources.getDrawable((Context)localObject5, 2131231568);
        } else {
          localObject5 = AppCompatResources.getDrawable((Context)localObject5, 2131231567);
        }
        if (m != 0) {
          localObject3 = AppCompatResources.getDrawable(this.f.getContext(), 2131231568);
        } else {
          localObject3 = AppCompatResources.getDrawable(this.f.getContext(), 2131231567);
        }
        if (n != 0) {
          localObject2 = AppCompatResources.getDrawable(this.x.getContext(), 2131231568);
        } else {
          localObject2 = AppCompatResources.getDrawable(this.x.getContext(), 2131231567);
        }
        if (i != 0) {
          localObject1 = AppCompatResources.getDrawable(this.y.getContext(), 2131231568);
        } else {
          localObject1 = AppCompatResources.getDrawable(this.y.getContext(), 2131231567);
        }
        localObject7 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject7;
        localObject8 = localObject2;
        localObject2 = localObject5;
      }
      else
      {
        localObject7 = null;
        localObject5 = localObject7;
        localObject4 = localObject5;
        localObject2 = localObject4;
        localObject8 = localObject4;
        localObject1 = localObject5;
        localObject4 = localObject7;
        l2 = l1;
      }
      if ((0x6 & l2) != 0L)
      {
        this.c.setOnClickListener(locala);
        this.d.setOnClickListener(locala);
        this.f.setOnClickListener(locala);
        this.q.setOnClickListener(locala);
        this.x.setOnClickListener(locala);
        this.y.setOnClickListener(locala);
      }
      if ((l2 & 0x5) != 0L)
      {
        ImageViewBindingAdapter.setImageDrawable(this.d, (Drawable)localObject3);
        ImageViewBindingAdapter.setImageDrawable(this.f, (Drawable)localObject4);
        ImageViewBindingAdapter.setImageDrawable(this.q, (Drawable)localObject2);
        ImageViewBindingAdapter.setImageDrawable(this.x, (Drawable)localObject8);
        ImageViewBindingAdapter.setImageDrawable(this.y, (Drawable)localObject1);
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
  
  public void i(@Nullable g paramg)
  {
    this.p2 = paramg;
    try
    {
      this.K3 |= 0x2;
      notifyPropertyChanged(78);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.K3 = 4L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  public void l(@Nullable ObservableInt paramObservableInt)
  {
    updateRegistration(0, paramObservableInt);
    this.p1 = paramObservableInt;
    try
    {
      this.K3 |= 1L;
      notifyPropertyChanged(82);
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
    return h((ObservableInt)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (78 == paramInt)
    {
      i((g)paramObject);
    }
    else
    {
      if (82 != paramInt) {
        break label36;
      }
      l((ObservableInt)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
  
  public static class a
    implements View.OnClickListener
  {
    private g c;
    
    public a a(g paramg)
    {
      this.c = paramg;
      if (paramg == null) {
        paramg = null;
      } else {
        paramg = this;
      }
      return paramg;
    }
    
    public void onClick(View paramView)
    {
      this.c.onClick(paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentRateUsDialogBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */