package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class ActivitySoftApCommonGuideBindingImpl
  extends ActivitySoftApCommonGuideBinding
{
  @Nullable
  private static final SparseIntArray H3;
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p3;
  @NonNull
  private final LinearLayout I3;
  private long J3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    H3 = localSparseIntArray;
    localSparseIntArray.put(2131364474, 3);
    localSparseIntArray.put(2131364472, 4);
    localSparseIntArray.put(2131364473, 5);
    localSparseIntArray.put(2131362669, 6);
    localSparseIntArray.put(2131362817, 7);
    localSparseIntArray.put(2131363388, 8);
    localSparseIntArray.put(2131364354, 9);
  }
  
  public ActivitySoftApCommonGuideBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 10, p3, H3));
  }
  
  private ActivitySoftApCommonGuideBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (TPRefreshableButton)paramArrayOfObject[2], (FrameLayout)paramArrayOfObject[6], (ImageView)paramArrayOfObject[7], (ImageView)paramArrayOfObject[1], (LottieAnimationView)paramArrayOfObject[8], (TextView)paramArrayOfObject[9], (TextView)paramArrayOfObject[4], (TextView)paramArrayOfObject[5], (TextView)paramArrayOfObject[3]);
    this.c.setTag(null);
    this.q.setTag(null);
    paramDataBindingComponent = (LinearLayout)paramArrayOfObject[0];
    this.I3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.J3;
      this.J3 = 0L;
      View.OnClickListener localOnClickListener = this.p2;
      if ((l & 0x3) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.q.setOnClickListener(localOnClickListener);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p2 = paramOnClickListener;
    try
    {
      this.J3 |= 1L;
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
      return this.J3 != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.J3 = 2L;
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
    boolean bool;
    if (55 == paramInt)
    {
      h((View.OnClickListener)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySoftApCommonGuideBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */