package com.tplink.iot.Utils;

import com.tplink.iot.model.home.HomeCacheBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class s
{
  public static List<HomeCacheBean> a(List<HomeCacheBean> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HomeCacheBean localHomeCacheBean1 = (HomeCacheBean)paramList.next();
      HomeCacheBean localHomeCacheBean2 = new HomeCacheBean();
      localHomeCacheBean2.cloneHomeCacheBean(localHomeCacheBean1);
      localArrayList.add(localHomeCacheBean2);
    }
    return localArrayList;
  }
  
  public static boolean b(List paramList)
  {
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */