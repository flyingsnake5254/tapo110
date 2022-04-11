package com.tplink.libmediaapi.device.repo;

import b.d.d.b.c;
import b.d.d.b.e;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpmediamanager.TPMediaManager;
import io.reactivex.q;
import java.util.List;

public class MediaDeviceListRepository
  extends b.d.d.b.a
{
  public MediaDeviceListRepository(c paramc)
  {
    super(paramc);
  }
  
  public q<Boolean> refreshDeviceList(List<TPMediaDevice> paramList)
  {
    return ((TPMediaManager)e.a(b.d.d.c.a.b(), TPMediaManager.class)).refreshDeviceList(paramList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\device\repo\MediaDeviceListRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */