package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.airbnb.lottie.LottieAnimationView;

public class LayoutVariousImageViewBindingImpl
  extends LayoutVariousImageViewBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts f;
  @Nullable
  private static final SparseIntArray q;
  @NonNull
  private final FrameLayout x;
  private long y = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    q = localSparseIntArray;
    localSparseIntArray.put(2131362824, 1);
    localSparseIntArray.put(2131363388, 2);
  }
  
  public LayoutVariousImageViewBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 3, f, q));
  }
  
  private LayoutVariousImageViewBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (ImageView)paramArrayOfObject[1], (LottieAnimationView)paramArrayOfObject[2]);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.x = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      this.y = 0L;
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.y != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.y = 1L;
      requestRebind();
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
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutVariousImageViewBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */