package com.tplink.libtpmediamanager;

import b.d.d.b.e;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpstreamclientmanager.TPStreamConnectionManager;
import io.reactivex.q;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TPMediaManager
  extends b.d.d.b.a
{
  private final Map<String, ?> a = new ConcurrentHashMap();
  
  public TPMediaManager(b.d.d.b.c paramc)
  {
    super(paramc);
  }
  
  public q<Boolean> refreshDeviceList(List<TPMediaDevice> paramList)
  {
    return ((TPStreamConnectionManager)e.a(b.d.d.c.a.b(), TPStreamConnectionManager.class)).refreshDeviceList(paramList).E(new c(this)).g0(b.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\TPMediaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */