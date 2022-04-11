package com.tplink.iot.model.deviceshare;

import android.text.TextUtils;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ShareBlacklistCacheBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceShareManager
  extends b.d.b.f.a
{
  private List<TCDeviceUserInfoBean> c = new ArrayList();
  private List<ShareBlacklistCacheBean> d = new ArrayList();
  
  public DeviceShareManager(b paramb)
  {
    super(paramb);
    f();
    g();
  }
  
  private void f()
  {
    Object localObject1 = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Object localObject2;
    try
    {
      localObject1 = b.d.w.d.a.c((String)localObject1, "device_share_user_record_list", "device_share_user_record_list", TCDeviceUserInfoBean.class);
    }
    catch (Exception localException)
    {
      localObject2 = new ArrayList();
    }
    this.c.clear();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TCDeviceUserInfoBean)localIterator.next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((TCDeviceUserInfoBean)localObject2).getCloudUserName()))) {
          this.c.add(localObject2);
        }
      }
    }
  }
  
  private void g()
  {
    Object localObject = b.d.w.h.a.g(this.b.c().getCloudUserName());
    ArrayList localArrayList;
    try
    {
      localObject = b.d.w.d.a.c((String)localObject, "device_share_blacklist_record_list", "device_share_blacklist_record_list", ShareBlacklistCacheBean.class);
    }
    catch (Exception localException)
    {
      localArrayList = new ArrayList();
    }
    this.d.clear();
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.d.addAll(localArrayList);
    }
  }
  
  public List<TCDeviceUserInfoBean> d()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; (i < 10) && (i < this.c.size()); i++)
    {
      TCDeviceUserInfoBean localTCDeviceUserInfoBean = (TCDeviceUserInfoBean)this.c.get(i);
      if ((localTCDeviceUserInfoBean != null) && (!TextUtils.isEmpty(localTCDeviceUserInfoBean.getCloudUserName()))) {
        localArrayList.add(localTCDeviceUserInfoBean);
      }
    }
    return localArrayList;
  }
  
  public List<ShareBlacklistCacheBean> e()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; (i < 10) && (i < this.d.size()); i++) {
      localArrayList.add(this.d.get(i));
    }
    return localArrayList;
  }
  
  public void h(TCDeviceUserInfoBean paramTCDeviceUserInfoBean)
  {
    if ((paramTCDeviceUserInfoBean != null) && (!TextUtils.isEmpty(paramTCDeviceUserInfoBean.getCloudUserName())))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localObject = (TCDeviceUserInfoBean)localIterator.next();
        if (TextUtils.equals(((TCDeviceUserInfoBean)localObject).getCloudUserName(), paramTCDeviceUserInfoBean.getCloudUserName()))
        {
          if (TextUtils.isEmpty(paramTCDeviceUserInfoBean.getAvatarUrl()))
          {
            paramTCDeviceUserInfoBean.setAvatarUrl(((TCDeviceUserInfoBean)localObject).getAvatarUrl());
            paramTCDeviceUserInfoBean.setNickname(((TCDeviceUserInfoBean)localObject).getNickname());
          }
          localIterator.remove();
        }
      }
      Object localObject = this.c;
      int i = 0;
      ((List)localObject).add(0, paramTCDeviceUserInfoBean);
      paramTCDeviceUserInfoBean = new ArrayList();
      while ((i < 10) && (i < this.c.size()))
      {
        paramTCDeviceUserInfoBean.add(this.c.get(i));
        i++;
      }
      b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), paramTCDeviceUserInfoBean, "device_share_user_record_list", "device_share_user_record_list");
    }
  }
  
  public void i(List<ShareBlacklistCacheBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.d.clear();
      this.d.addAll(paramList);
      paramList = new ArrayList();
      for (int i = 0; (i < 10) && (i < this.d.size()); i++) {
        paramList.add(this.d.get(i));
      }
      b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), paramList, "device_share_blacklist_record_list", "device_share_blacklist_record_list");
    }
  }
  
  public void j(List<ShareBlacklistItemResult> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (!this.d.isEmpty()))
    {
      Iterator localIterator1 = this.d.iterator();
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label146;
        }
        ShareBlacklistCacheBean localShareBlacklistCacheBean = (ShareBlacklistCacheBean)localIterator1.next();
        Iterator localIterator2 = paramList.iterator();
        if (localIterator2.hasNext())
        {
          ShareBlacklistItemResult localShareBlacklistItemResult = (ShareBlacklistItemResult)localIterator2.next();
          if ((!TextUtils.isEmpty(localShareBlacklistCacheBean.getAvatarUrl())) || (!TextUtils.equals(localShareBlacklistCacheBean.getEmail(), localShareBlacklistItemResult.getEmail()))) {
            break;
          }
          localShareBlacklistCacheBean.setAvatarUrl(localShareBlacklistItemResult.getAvatarUrl());
          localShareBlacklistCacheBean.setNickname(localShareBlacklistItemResult.getNickname());
          j = 1;
        }
      }
      label146:
      if (j != 0)
      {
        paramList = new ArrayList();
        for (j = i; (j < 10) && (j < this.d.size()); j++) {
          paramList.add(this.d.get(j));
        }
        b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), paramList, "device_share_blacklist_record_list", "device_share_blacklist_record_list");
      }
    }
  }
  
  public void k(List<TCDeviceUserInfoBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (!this.c.isEmpty()))
    {
      int i = 0;
      int j = 0;
      int m;
      for (int k = 0; j < this.c.size(); k = m)
      {
        TCDeviceUserInfoBean localTCDeviceUserInfoBean1 = (TCDeviceUserInfoBean)this.c.get(j);
        m = k;
        if (TextUtils.isEmpty(localTCDeviceUserInfoBean1.getAvatarUrl()))
        {
          Iterator localIterator = paramList.iterator();
          TCDeviceUserInfoBean localTCDeviceUserInfoBean2;
          do
          {
            m = k;
            if (!localIterator.hasNext()) {
              break;
            }
            localTCDeviceUserInfoBean2 = (TCDeviceUserInfoBean)localIterator.next();
          } while (!TextUtils.equals(localTCDeviceUserInfoBean1.getCloudUserName(), localTCDeviceUserInfoBean2.getCloudUserName()));
          localTCDeviceUserInfoBean1.setAvatarUrl(localTCDeviceUserInfoBean2.getAvatarUrl());
          localTCDeviceUserInfoBean1.setNickname(localTCDeviceUserInfoBean2.getNickname());
          m = 1;
        }
        j++;
      }
      if (k != 0)
      {
        paramList = new ArrayList();
        for (j = i; (j < 10) && (j < this.c.size()); j++) {
          paramList.add(this.c.get(j));
        }
        b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), paramList, "device_share_user_record_list", "device_share_user_record_list");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\deviceshare\DeviceShareManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */