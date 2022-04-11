package com.tplink.iot.Utils.v0;

import b.d.b.f.b;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import java.util.Iterator;
import java.util.List;

public class d
{
  public static boolean a()
  {
    return ((CloudVideoRepository)b.a(b.d.s.a.a.f(), CloudVideoRepository.class)).h0();
  }
  
  public static boolean b(List<OrderInfo> paramList, String paramString)
  {
    if ((paramList != null) && (paramString != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString = (OrderInfo)paramList.next();
        if ((paramString != null) && (paramString.getTrial() == 0) && ("active".equals(paramString.getStatus()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean c(String paramString)
  {
    return com.tplink.libtpnetwork.Utils.d.d(paramString);
  }
  
  public static boolean d()
  {
    Object localObject = (CloudVideoRepository)b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
    boolean bool;
    if ((((CloudVideoRepository)localObject).h0()) && (((CloudVideoRepository)localObject).j0())) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("有设备支持TapoCare：");
    ((StringBuilder)localObject).append(bool);
    b.d.w.c.a.d(((StringBuilder)localObject).toString());
    return bool;
  }
  
  public static boolean e(String paramString)
  {
    return com.tplink.libtpnetwork.Utils.d.e(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\v0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */