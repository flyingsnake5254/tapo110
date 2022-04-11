package com.tplink.iot.viewmodel.home;

import android.text.TextUtils;
import b.d.w.h.a;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.model.home.HomeCacheBean;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class s
{
  static void a(Map<String, k> paramMap, List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramMap.isEmpty())
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramList = (BaseALIoTDevice)((Iterator)localObject).next();
          paramMap.put(paramList.getDeviceIdMD5(), new k(paramList));
        }
        return;
      }
      Object localObject = new HashSet(paramMap.keySet());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
        k localk = (k)paramMap.get(localBaseALIoTDevice.getDeviceIdMD5());
        if (localk != null)
        {
          localk.x(localBaseALIoTDevice);
        }
        else
        {
          localk = new k(localBaseALIoTDevice);
          localk.C(Integer.MIN_VALUE);
          paramMap.put(localBaseALIoTDevice.getDeviceIdMD5(), localk);
        }
        ((Set)localObject).remove(localBaseALIoTDevice.getDeviceIdMD5());
      }
      paramList = ((Set)localObject).iterator();
      while (paramList.hasNext()) {
        paramMap.remove((String)paramList.next());
      }
      return;
    }
    paramMap.clear();
  }
  
  static void b(Map<String, g> paramMap, List<GroupInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1;
      if (paramMap.isEmpty())
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (GroupInfo)((Iterator)localObject1).next();
          paramList = a.g(((GroupInfo)localObject2).getId());
          if (!TextUtils.isEmpty(paramList)) {
            paramMap.put(paramList, new g(new GroupBean((GroupInfo)localObject2)));
          }
        }
        return;
      }
      Object localObject2 = new HashSet(paramMap.keySet());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupInfo localGroupInfo = (GroupInfo)paramList.next();
        String str = a.g(localGroupInfo.getId());
        localObject1 = (g)paramMap.get(str);
        if (localObject1 != null) {
          ((g)localObject1).l(localGroupInfo);
        } else {
          paramMap.put(str, new g(new GroupBean(localGroupInfo)));
        }
        ((Set)localObject2).remove(str);
      }
      paramList = ((Set)localObject2).iterator();
      while (paramList.hasNext()) {
        paramMap.remove((String)paramList.next());
      }
      return;
    }
    paramMap.clear();
  }
  
  static void c(Map<String, k> paramMap, List<HomeCacheBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramMap.isEmpty())
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (HomeCacheBean)paramList.next();
          paramMap.put(((HomeCacheBean)localObject).getDeviceIdMD5(), new k((HomeCacheBean)localObject));
        }
        return;
      }
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (HomeCacheBean)((Iterator)localObject).next();
        k localk = (k)paramMap.get(paramList.getDeviceIdMD5());
        if (localk != null)
        {
          localk.z(paramList);
        }
        else
        {
          localk = new k(paramList);
          paramMap.put(paramList.getDeviceIdMD5(), localk);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */