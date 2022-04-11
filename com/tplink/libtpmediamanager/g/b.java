package com.tplink.libtpmediamanager.g;

import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;

public abstract class b
{
  protected TPMediaDeviceContext deviceContext;
  
  public b(TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    this.deviceContext = paramTPMediaDeviceContext;
  }
  
  public abstract void loadCacheData();
  
  public abstract void onCleared();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */