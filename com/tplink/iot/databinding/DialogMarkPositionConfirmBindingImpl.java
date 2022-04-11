package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.MultiOperationInputLayout;
import com.tplink.libtpnetwork.Utils.j;

public class DialogMarkPositionConfirmBindingImpl
  extends DialogMarkPositionConfirmBinding
{
  @Nullable
  private static final ViewDataBinding.IncludedLayouts p2;
  @Nullable
  private static final SparseIntArray p3;
  @NonNull
  private final RelativeLayout H3;
  private InverseBindingListener I3 = new a();
  private long J3 = -1L;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    p3 = localSparseIntArray;
    localSparseIntArray.put(2131363684, 3);
    localSparseIntArray.put(2131364189, 4);
    localSparseIntArray.put(2131363382, 5);
    localSparseIntArray.put(2131364782, 6);
    localSparseIntArray.put(2131363955, 7);
    localSparseIntArray.put(2131362188, 8);
  }
  
  public DialogMarkPositionConfirmBindingImpl(@Nullable DataBindingComponent paramDataBindingComponent, @NonNull View paramView)
  {
    this(paramDataBindingComponent, paramView, ViewDataBinding.mapBindings(paramDataBindingComponent, paramView, 9, p2, p3));
  }
  
  private DialogMarkPositionConfirmBindingImpl(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject)
  {
    super(paramDataBindingComponent, paramView, 1, (TextView)paramArrayOfObject[8], (EditText)paramArrayOfObject[1], (ImageView)paramArrayOfObject[2], (MultiOperationInputLayout)paramArrayOfObject[5], (ImageView)paramArrayOfObject[3], (TextView)paramArrayOfObject[7], (TextView)paramArrayOfObject[4], (View)paramArrayOfObject[6]);
    this.d.setTag(null);
    this.f.setTag(null);
    paramDataBindingComponent = (RelativeLayout)paramArrayOfObject[0];
    this.H3 = paramDataBindingComponent;
    paramDataBindingComponent.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  private boolean i(MutableLiveData<String> paramMutableLiveData, int paramInt)
  {
    if (paramInt == 0) {
      try
      {
        this.J3 |= 1L;
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
      long l = this.J3;
      this.J3 = 0L;
      MutableLiveData localMutableLiveData = this.p1;
      boolean bool1 = (0x3 & l) < 0L;
      String str;
      boolean bool2;
      if (bool1)
      {
        if (localMutableLiveData != null) {
          str = (String)localMutableLiveData.getValue();
        } else {
          str = null;
        }
        bool2 = j.f(localMutableLiveData) ^ true;
      }
      else
      {
        str = null;
        bool2 = false;
      }
      if (bool1)
      {
        TextViewBindingAdapter.setText(this.d, str);
        b.Q(this.f, bool2);
      }
      if ((l & 0x2) != 0L) {
        TextViewBindingAdapter.setTextWatcher(this.d, null, null, null, this.I3);
      }
      return;
    }
    finally {}
  }
  
  public void h(@Nullable MutableLiveData<String> paramMutableLiveData)
  {
    updateLiveDataRegistration(0, paramMutableLiveData);
    this.p1 = paramMutableLiveData;
    try
    {
      this.J3 |= 1L;
      notifyPropertyChanged(77);
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
    if (paramInt1 != 0) {
      return false;
    }
    return i((MutableLiveData)paramObject, paramInt2);
  }
  
  public boolean setVariable(int paramInt, @Nullable Object paramObject)
  {
    boolean bool;
    if (77 == paramInt)
    {
      h((MutableLiveData)paramObject);
      bool = true;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  class a
    implements InverseBindingListener
  {
    a() {}
    
    public void onChange()
    {
      String str = TextViewBindingAdapter.getTextString(DialogMarkPositionConfirmBindingImpl.this.d);
      MutableLiveData localMutableLiveData = DialogMarkPositionConfirmBindingImpl.this.p1;
      int i;
      if (localMutableLiveData != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localMutableLiveData.setValue(str);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMarkPositionConfirmBindingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */