package com.tplink.iot.view.iotsensor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public abstract class SensorBaseActivity<T extends ViewModel>
  extends BaseActivity
{
  private String y = "";
  private final f z;
  
  public SensorBaseActivity(final Class<T> paramClass)
  {
    this.z = h.b(new a(this, paramClass));
  }
  
  protected final String e1()
  {
    return this.y;
  }
  
  protected final T f1()
  {
    return (ViewModel)this.z.getValue();
  }
  
  @CallSuper
  protected void g1()
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
    this.y = ((String)localObject);
  }
  
  public abstract void h1();
  
  public void i1() {}
  
  public abstract void j1();
  
  @CallSuper
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g1();
    h1();
    j1();
    i1();
  }
  
  static final class a
    extends Lambda
    implements a<T>
  {
    a(SensorBaseActivity paramSensorBaseActivity, Class paramClass)
    {
      super();
    }
    
    public final T a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, ((SensorBaseActivity)localObject).e1())).get(paramClass);
      j.d(localObject, "ViewModelProvider(this, …mDeviceIdMD5)).get(vmClz)");
      return (T)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\SensorBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */