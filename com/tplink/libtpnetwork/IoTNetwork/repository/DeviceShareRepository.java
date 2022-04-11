package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.c.b.h;
import com.tplink.iot.cloud.bean.share.common.LaunchFailBean;
import com.tplink.iot.cloud.bean.share.device.DeviceOwnerInfoResult;
import com.tplink.iot.cloud.bean.share.device.DeviceUserInfoResult;
import com.tplink.iot.cloud.bean.share.device.DeviceUserListResult;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUsersParams;
import com.tplink.iot.cloud.bean.share.result.DeviceShareActionHandleListResult;
import com.tplink.iot.cloud.bean.share.result.DeviceShareLaunchResult;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceListResult;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ICEDataFromCloudPCResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingListPageParams;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceOwnerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceShareRepository
  extends AbstractIoTCloudRepository
{
  private h h;
  
  public DeviceShareRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.h = ((h)parama.k().R1(h.class));
  }
  
  private q<List<ShareDeviceResult>> E(ThingListPageParams paramThingListPageParams, String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    return J(paramThingListPageParams.getPage(), paramThingListPageParams.getPageSize(), paramString1, paramString2, paramString3).g0(new k5(localArrayList, paramThingListPageParams)).w0(j5.c);
  }
  
  private BaseALIoTDevice F(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return TPIoTClientManager.I1(b.d.w.h.a.g(paramString));
  }
  
  private q<ShareDeviceListResult> J(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final String paramString3)
  {
    return d().N(new c(paramInt1, paramInt2, paramString1, paramString2, paramString3));
  }
  
  private void U()
  {
    ((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).L3();
  }
  
  private void V(String paramString, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramString != null) && (!paramString.isEmpty()))
    {
      paramString = F(paramString);
      if (paramString != null)
      {
        paramString = paramString.getDeviceManagerInfo();
        if ((paramString != null) && (paramString.getUserInfo() != null) && (!paramString.getUserInfo().isEmpty()))
        {
          Iterator localIterator = paramString.getUserInfo().iterator();
          while (localIterator.hasNext())
          {
            paramString = (TCDeviceUserInfoBean)localIterator.next();
            if ((paramString != null) && (paramList.contains(paramString.getCloudUserName()))) {
              localIterator.remove();
            }
          }
          U();
        }
      }
    }
  }
  
  private void W(String paramString, DeviceOwnerInfoResult paramDeviceOwnerInfoResult)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    BaseALIoTDevice localBaseALIoTDevice = F(paramString);
    if (localBaseALIoTDevice != null)
    {
      DeviceManagerInfoBean localDeviceManagerInfoBean = localBaseALIoTDevice.getDeviceManagerInfo();
      paramString = localDeviceManagerInfoBean;
      if (localDeviceManagerInfoBean == null)
      {
        paramString = new DeviceManagerInfoBean();
        localBaseALIoTDevice.setDeviceManagerInfo(paramString);
      }
      paramString.setOwnerInfo(new TCDeviceOwnerInfoBean(paramDeviceOwnerInfoResult));
      U();
    }
  }
  
  private void X(String paramString, DeviceUserListResult paramDeviceUserListResult)
  {
    ArrayList localArrayList = new ArrayList();
    paramDeviceUserListResult = paramDeviceUserListResult.getUserList().iterator();
    while (paramDeviceUserListResult.hasNext()) {
      localArrayList.add(new TCDeviceUserInfoBean((DeviceUserInfoResult)paramDeviceUserListResult.next()));
    }
    Object localObject = F(paramString);
    if (localObject != null)
    {
      paramDeviceUserListResult = ((BaseALIoTDevice)localObject).getDeviceManagerInfo();
      paramString = paramDeviceUserListResult;
      if (paramDeviceUserListResult == null)
      {
        paramString = new DeviceManagerInfoBean();
        ((BaseALIoTDevice)localObject).setDeviceManagerInfo(paramString);
      }
      localObject = paramString.getUserInfo();
      paramDeviceUserListResult = (DeviceUserListResult)localObject;
      if (localObject == null)
      {
        paramDeviceUserListResult = new ArrayList();
        paramString.setUserInfo(paramDeviceUserListResult);
      }
      paramDeviceUserListResult.clear();
      paramDeviceUserListResult.addAll(localArrayList);
      U();
    }
  }
  
  public io.reactivex.a A(String paramString, DeviceUsersParams paramDeviceUsersParams)
  {
    return d().g0(new l5(this, paramString, paramDeviceUsersParams)).Z();
  }
  
  public io.reactivex.a B(DeviceUserRoleListParams paramDeviceUserRoleListParams)
  {
    return d().g0(new m5(this, paramDeviceUserRoleListParams)).Z();
  }
  
  public q<Boolean> C()
  {
    Object localObject = (List)((TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class)).C1().getValue();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Iterator)localObject).next();
      if (localBaseALIoTDevice.isHasThingOrCloudDevice()) {
        localArrayList.add(localBaseALIoTDevice);
      }
    }
    return I(localArrayList);
  }
  
  public q<List<ShareDeviceResult>> D(String paramString1, String paramString2, String paramString3)
  {
    return E(new ThingListPageParams(0, 20), paramString1, paramString2, paramString3);
  }
  
  public q<DeviceOwnerInfoResult> G(final String paramString, final boolean paramBoolean)
  {
    return d().N(new e(paramString, paramBoolean));
  }
  
  public q<DeviceUserListResult> H(final String paramString, final boolean paramBoolean)
  {
    return d().N(new d(paramString, paramBoolean));
  }
  
  public q<Boolean> I(List<BaseALIoTDevice> paramList)
  {
    return q.f0(paramList).N(new g()).N(new f());
  }
  
  public q<DeviceShareActionHandleListResult> K(final DeviceShareActionListParams paramDeviceShareActionListParams)
  {
    return d().N(new b(paramDeviceShareActionListParams));
  }
  
  public q<Integer> T(final DeviceShareListParams paramDeviceShareListParams)
  {
    return d().N(new a(paramDeviceShareListParams));
  }
  
  public io.reactivex.a w(List<DeviceUserRoleParams> paramList)
  {
    String str1 = this.b.c().getEmail();
    String str2;
    if (str1 != null)
    {
      str2 = str1;
      if (!str1.isEmpty()) {}
    }
    else
    {
      str2 = this.b.c().getCloudUserName();
    }
    return B(new DeviceUserRoleListParams(str2, paramList));
  }
  
  class a
    implements j<String, t<Integer>>
  {
    a(DeviceShareListParams paramDeviceShareListParams) {}
    
    public t<Integer> a(String paramString)
      throws Exception
    {
      return DeviceShareRepository.x(DeviceShareRepository.this).k(paramString, paramDeviceShareListParams).L0(io.reactivex.l0.a.c()).g0(new a()).q0(Integer.valueOf(-1));
    }
    
    class a
      implements j<DeviceShareLaunchResult, Integer>
    {
      a() {}
      
      public Integer a(DeviceShareLaunchResult paramDeviceShareLaunchResult)
        throws Exception
      {
        int i;
        if ((paramDeviceShareLaunchResult != null) && (paramDeviceShareLaunchResult.getFailList() != null) && (paramDeviceShareLaunchResult.getFailList().size() > 0))
        {
          paramDeviceShareLaunchResult = paramDeviceShareLaunchResult.getFailList().iterator();
          while (paramDeviceShareLaunchResult.hasNext())
          {
            Object localObject = (LaunchFailBean)paramDeviceShareLaunchResult.next();
            if (((LaunchFailBean)localObject).getCode() == 12301)
            {
              localObject = (ICEDataFromCloudPCResult)i.a(((LaunchFailBean)localObject).getData(), ICEDataFromCloudPCResult.class);
              if (localObject != null)
              {
                i = ((ICEDataFromCloudPCResult)localObject).getCodeFromPC();
                if (i == 44918) {
                  return Integer.valueOf(44918);
                }
                if (i == 45028) {
                  return Integer.valueOf(45028);
                }
              }
            }
          }
          i = 0;
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          return Integer.valueOf(0);
        }
        return Integer.valueOf(-1);
      }
    }
  }
  
  class b
    implements j<String, t<DeviceShareActionHandleListResult>>
  {
    b(DeviceShareActionListParams paramDeviceShareActionListParams) {}
    
    public t<DeviceShareActionHandleListResult> a(String paramString)
      throws Exception
    {
      return DeviceShareRepository.x(DeviceShareRepository.this).u(paramString, paramDeviceShareActionListParams).L0(io.reactivex.l0.a.c());
    }
  }
  
  class c
    implements j<String, t<ShareDeviceListResult>>
  {
    c(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {}
    
    public t<ShareDeviceListResult> a(String paramString)
      throws Exception
    {
      return DeviceShareRepository.x(DeviceShareRepository.this).b0(paramString, paramInt1, paramInt2, paramString1, paramString2, paramString3).L0(io.reactivex.l0.a.c());
    }
  }
  
  class d
    implements j<String, t<DeviceUserListResult>>
  {
    d(String paramString, boolean paramBoolean) {}
    
    public t<DeviceUserListResult> a(String paramString)
      throws Exception
    {
      return DeviceShareRepository.x(DeviceShareRepository.this).z1(paramString, paramString, paramBoolean).L0(io.reactivex.l0.a.c()).E(new a());
    }
    
    class a
      implements g<DeviceUserListResult>
    {
      a() {}
      
      public void a(DeviceUserListResult paramDeviceUserListResult)
        throws Exception
      {
        DeviceShareRepository.d locald = DeviceShareRepository.d.this;
        DeviceShareRepository.y(locald.f, locald.c, paramDeviceUserListResult);
      }
    }
  }
  
  class e
    implements j<String, t<DeviceOwnerInfoResult>>
  {
    e(String paramString, boolean paramBoolean) {}
    
    public t<DeviceOwnerInfoResult> a(String paramString)
      throws Exception
    {
      return DeviceShareRepository.x(DeviceShareRepository.this).F0(paramString, paramString, paramBoolean).L0(io.reactivex.l0.a.c()).E(new a());
    }
    
    class a
      implements g<DeviceOwnerInfoResult>
    {
      a() {}
      
      public void a(DeviceOwnerInfoResult paramDeviceOwnerInfoResult)
        throws Exception
      {
        DeviceShareRepository.e locale = DeviceShareRepository.e.this;
        DeviceShareRepository.z(locale.f, locale.c, paramDeviceOwnerInfoResult);
      }
    }
  }
  
  class f
    implements j<BaseALIoTDevice, t<Boolean>>
  {
    f() {}
    
    public t<Boolean> a(BaseALIoTDevice paramBaseALIoTDevice)
      throws Exception
    {
      if (paramBaseALIoTDevice.isUserRoleTypeDevice()) {
        DeviceShareRepository.this.G(paramBaseALIoTDevice.getDeviceId(), paramBaseALIoTDevice.isSubDevice()).F0();
      } else {
        DeviceShareRepository.this.H(paramBaseALIoTDevice.getDeviceId(), paramBaseALIoTDevice.isSubDevice()).F0();
      }
      return q.f0(Boolean.TRUE);
    }
  }
  
  class g
    implements j<List<BaseALIoTDevice>, t<BaseALIoTDevice>>
  {
    g() {}
    
    public t<BaseALIoTDevice> a(List<BaseALIoTDevice> paramList)
      throws Exception
    {
      return q.Y(paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\DeviceShareRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */