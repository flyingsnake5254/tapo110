package com.tplink.libtpmediamanager.live;

import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtplivemedia.a.t;
import com.tplink.libtpmediamanager.f;
import com.tplink.libtpmediamanager.g.b;

public abstract class LiveMediaBaseRepository
  extends b
{
  public LiveMediaBaseRepository(TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    super(paramTPMediaDeviceContext);
  }
  
  protected t getClient()
  {
    return f.j().l(this.deviceContext.getDeviceIdMd5());
  }
  
  public void onCleared() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\live\LiveMediaBaseRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */