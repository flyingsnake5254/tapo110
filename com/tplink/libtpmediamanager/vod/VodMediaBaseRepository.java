package com.tplink.libtpmediamanager.vod;

import b.d.b0.a.t;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpmediamanager.e;
import com.tplink.libtpmediamanager.g.b;

public abstract class VodMediaBaseRepository
  extends b
{
  public VodMediaBaseRepository(TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    super(paramTPMediaDeviceContext);
  }
  
  protected t getClient()
  {
    return e.k().l(this.deviceContext.getDeviceIdMd5());
  }
  
  public void onCleared() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\vod\VodMediaBaseRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */