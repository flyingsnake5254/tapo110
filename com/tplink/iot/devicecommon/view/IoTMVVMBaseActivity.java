package com.tplink.iot.devicecommon.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.base.BaseActivity;
import kotlin.jvm.internal.j;

public abstract class IoTMVVMBaseActivity<VDB extends ViewDataBinding>
  extends BaseActivity
{
  protected VDB y;
  private String z = "";
  
  private final void i1()
  {
    ViewDataBinding localViewDataBinding = DataBindingUtil.setContentView(this, e1());
    j.d(localViewDataBinding, "DataBindingUtil.setConte…View(this, getLayoutId())");
    this.y = localViewDataBinding;
    if (localViewDataBinding == null) {
      j.t("mBinding");
    }
    localViewDataBinding.setLifecycleOwner(this);
    l1();
  }
  
  @LayoutRes
  public abstract int e1();
  
  protected final VDB f1()
  {
    ViewDataBinding localViewDataBinding = this.y;
    if (localViewDataBinding == null) {
      j.t("mBinding");
    }
    return localViewDataBinding;
  }
  
  protected final String g1()
  {
    return this.z;
  }
  
  @CallSuper
  public void h1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("device_id_md5");
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.z = ((String)localObject);
  }
  
  public abstract void j1();
  
  public void k1() {}
  
  public void l1() {}
  
  public void m1() {}
  
  @CallSuper
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h1();
    i1();
    j1();
    m1();
    k1();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\view\IoTMVVMBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */