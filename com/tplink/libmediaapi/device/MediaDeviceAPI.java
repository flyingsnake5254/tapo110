package com.tplink.libmediaapi.device;

import android.annotation.SuppressLint;
import b.d.d.b.e;
import b.d.d.c.a;
import com.tplink.libmediaapi.device.apibean.MediaDevice;
import com.tplink.libmediaapi.device.apicallback.MediaDeviceListCallBack;
import com.tplink.libmediaapi.device.repo.MediaDeviceListRepository;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaDeviceAPI
{
  @SuppressLint({"CheckResult"})
  public static void refreshDeviceList(List<MediaDevice> paramList, MediaDeviceListCallBack paramMediaDeviceListCallBack)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MediaDevice localMediaDevice = (MediaDevice)localIterator.next();
        if (localMediaDevice != null)
        {
          paramList = new TPMediaDevice();
          paramList.setDeviceId(localMediaDevice.getDeviceId());
          paramList.setDeviceLocal(localMediaDevice.isDeviceLocal());
          paramList.setLocalIp(localMediaDevice.getLocalIp());
          paramList.setHttpPort(localMediaDevice.getHttpPort());
          paramList.setDeviceMac(localMediaDevice.getDeviceMac());
          paramList.setModel(localMediaDevice.getModel());
          paramList.setDeviceRemoteOnline(localMediaDevice.isDeviceRemoteOnline());
          paramList.setForceMainStream(localMediaDevice.isForceMainStream());
          paramList.setP2PAvailable(localMediaDevice.isP2PAvailable());
          paramList.setUserRoleTypeDevice(localMediaDevice.isUserRoleTypeDevice());
          paramList.setUserShareUsername(localMediaDevice.getUserShareUsername());
          paramList.setUserSharePassword(localMediaDevice.getUserSharePassword());
          paramList.setAppServerUrl(localMediaDevice.getAppServerUrl());
          paramList.setSupportIoTCloud(localMediaDevice.isSupportIoTCloud());
          paramList.setIotThingUrl(localMediaDevice.getIotThingUrl());
          localArrayList.add(paramList);
        }
      }
    }
    ((MediaDeviceListRepository)e.a(a.b(), MediaDeviceListRepository.class)).refreshDeviceList(localArrayList).H0(new g()new g
    {
      public void accept(Boolean paramAnonymousBoolean)
        throws Exception
      {
        MediaDeviceListCallBack localMediaDeviceListCallBack = MediaDeviceAPI.this;
        if (localMediaDeviceListCallBack != null) {
          localMediaDeviceListCallBack.onResult(paramAnonymousBoolean);
        }
      }
    }, new g()
    {
      public void accept(Throwable paramAnonymousThrowable)
        throws Exception
      {
        paramAnonymousThrowable = MediaDeviceAPI.this;
        if (paramAnonymousThrowable != null) {
          paramAnonymousThrowable.onError(null);
        }
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\device\MediaDeviceAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */