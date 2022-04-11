package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

public class FragmentCloudPasswordCheckBindingImpl
  extends FragmentCloudPasswordCheckBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p0;
  @Nullable
  private static final SparseIntArray p1;
  @NonNull
  private final FrameLayout p2;
  private long p3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p1 = localSparseIntArray;
    localSparseIntArray.put(2131364275, 3);
    localSparseIntArray.put(2131362687, 4);
    localSparseIntArray.put(2131363619, 5);
  }
  
  public FragmentCloudPasswordCheckBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 6, p0, p1));
  }
  
  private FragmentCloudPasswordCheckBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[4], (MaterialEditText)paramArrayOfObject[5], (Button)paramArrayOfObject[2], (Toolbar)paramArrayOfObject[3], (TextView)paramArrayOfObject[1]);
    paramDataBindingComponent = (FrameLayout)paramArrayOfObject[0];
    this.p2 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    this.f.setTag(null);
    this.x.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean l(ObservableField<String> paramObservableField, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.p3 |= 1L;
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
      long l = this.p3;
      this.p3 = 0L;
      View.OnClickListener localOnClickListener = this.z;
      Object localObject1 = this.y;
      Object localObject2 = null;
      boolean bool = (l & 0xD) < 0L;
      Object localObject3 = localObject2;
      if (bool)
      {
        if (localObject1 != null) {
          localObject1 = ((PasswordSettingViewModel)localObject1).d;
        } else {
          localObject1 = null;
        }
        updateRegistration(0, (Observable)localObject1);
        localObject3 = localObject2;
        if (localObject1 != null) {
          localObject3 = (String)((ObservableField)localObject1).get();
        }
      }
      if ((0xA & l) != 0L) {
        this.f.setOnClickListener(localOnClickListener);
      }
      if (bool) {
        TextViewBindingAdapter.setText(this.x, (CharSequence)localObject3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.z = paramOnClickListener;
    try
    {
      this.p3 |= 0x2;
      notifyPropertyChanged(2);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.p3 != 0L;
    }
    finally {}
  }
  
  public void i(@Nullable PasswordSettingViewModel paramPasswordSettingViewModel)
  {
    this.y = paramPasswordSettingViewModel;
    try
    {
      this.p3 |= 0x4;
      notifyPropertyChanged(105);
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.p3 = 8L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return l((ObservableField)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    if (2 == paramInt)
    {
      h((View.OnClickListener)paramObject);
    }
    else
    {
      if (105 != paramInt) {
        break label35;
      }
      i((PasswordSettingViewModel)paramObject);
    }
    boolean bool = true;
    return bool;
    label35:
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCloudPasswordCheckBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */