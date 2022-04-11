package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import android.text.TextUtils;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.x;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.a;
import io.reactivex.q;

public class b
  extends c<ThingContext>
{
  protected x c;
  
  public b(ThingContext paramThingContext)
  {
    super(paramThingContext);
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).isSubDevice()) && (!TextUtils.isEmpty(((ALIoTDevice)paramThingContext.getIoTDevice()).getParentDeviceIDMD5()))) {
      this.c = this.b.Y1(((ALIoTDevice)paramThingContext.getIoTDevice()).getParentDeviceIDMD5());
    } else {
      this.c = this.b.Y1(paramThingContext.getDeviceIdMD5());
    }
    if (this.c == null) {
      this.c = new x();
    }
  }
  
  protected void c() {}
  
  public q<Boolean> d()
  {
    return q.f0(Boolean.FALSE);
  }
  
  protected void e() {}
  
  public q<Boolean> f()
  {
    return q.f0(Boolean.FALSE);
  }
  
  public q<Boolean> g()
  {
    return q.f0(Boolean.FALSE);
  }
  
  public a i(boolean paramBoolean)
  {
    return a.e();
  }
  
  public q<Boolean> j()
  {
    return q.f0(Boolean.FALSE);
  }
  
  public a k()
  {
    return a.e();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\kb\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */