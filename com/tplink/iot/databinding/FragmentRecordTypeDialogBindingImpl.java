package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.RadioGroupBindingAdapter;

public class FragmentRecordTypeDialogBindingImpl
  extends FragmentRecordTypeDialogBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final RelativeLayout H3;
  private long I3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131364246, 4);
    localSparseIntArray.put(2131362470, 5);
    localSparseIntArray.put(2131362979, 6);
    localSparseIntArray.put(2131362935, 7);
  }
  
  public FragmentRecordTypeDialogBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 8, p2, p3));
  }
  
  private FragmentRecordTypeDialogBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 0, (Button)paramArrayOfObject[2], (View)paramArrayOfObject[5], (AppCompatRadioButton)paramArrayOfObject[7], (AppCompatRadioButton)paramArrayOfObject[6], (Button)paramArrayOfObject[3], (TextView)paramArrayOfObject[4], (RadioGroup)paramArrayOfObject[1]);
    this.c.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.x.setTag(null);
    this.z.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.I3;
      this.I3 = 0L;
      View.OnClickListener localOnClickListener = this.p0;
      RadioGroup.OnCheckedChangeListener localOnCheckedChangeListener = this.p1;
      if ((0x5 & l) != 0L)
      {
        this.c.setOnClickListener(localOnClickListener);
        this.x.setOnClickListener(localOnClickListener);
      }
      if ((l & 0x6) != 0L) {
        RadioGroupBindingAdapter.setListeners(this.z, localOnCheckedChangeListener, null);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.p1 = paramOnCheckedChangeListener;
    try
    {
      this.I3 |= 0x2;
      notifyPropertyChanged(8);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.I3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.p0 = paramOnClickListener;
    try
    {
      this.I3 |= 1L;
      notifyPropertyChanged(9);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.I3 = 4L;
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
    if (9 == paramInt)
    {
      i((View.OnClickListener)paramObject);
    }
    else
    {
      if (8 != paramInt) {
        break label36;
      }
      h((RadioGroup.OnCheckedChangeListener)paramObject);
    }
    boolean bool = true;
    return bool;
    label36:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentRecordTypeDialogBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */