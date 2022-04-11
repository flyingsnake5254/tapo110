package com.tplink.iot.model.home;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

public class k
  extends e
{
  private BaseALIoTDevice b;
  private HomeCacheBean c;
  
  public k(HomeCacheBean paramHomeCacheBean)
  {
    z(paramHomeCacheBean);
  }
  
  public k(BaseALIoTDevice paramBaseALIoTDevice)
  {
    B(true);
    y(System.currentTimeMillis());
    A(paramBaseALIoTDevice.getDeviceIdMD5());
    x(paramBaseALIoTDevice);
  }
  
  private void o()
  {
    if (this.c == null) {
      this.c = new HomeCacheBean();
    }
  }
  
  public void A(String paramString)
  {
    o();
    this.c.setDeviceIdMD5(paramString);
  }
  
  public void B(boolean paramBoolean)
  {
    o();
    this.c.setNewDevice(paramBoolean);
  }
  
  public void C(int paramInt)
  {
    o();
    this.c.setSortValue(paramInt);
  }
  
  @NonNull
  public String d()
  {
    String str1 = h();
    String str2 = str1;
    if (str1 == null) {
      str2 = "";
    }
    return str2;
  }
  
  public String e()
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject2 = ((BaseALIoTDevice)localObject1).getDeviceIdMD5();
    } else {
      localObject2 = null;
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      HomeCacheBean localHomeCacheBean = this.c;
      localObject1 = localObject2;
      if (localHomeCacheBean != null) {
        localObject1 = localHomeCacheBean.getDeviceIdMD5();
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return (String)localObject2;
  }
  
  @NonNull
  public String f()
  {
    return l.c(AppContext.c, this.b);
  }
  
  public BaseALIoTDevice g()
  {
    return this.b;
  }
  
  public String h()
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((BaseALIoTDevice)localObject).getDeviceId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String i()
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((BaseALIoTDevice)localObject).getFamilyId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public long j()
  {
    o();
    return this.c.getFirstDiscoverTime();
  }
  
  public HomeCacheBean k()
  {
    return this.c;
  }
  
  public String l()
  {
    o();
    return this.c.getDeviceIdMD5();
  }
  
  public int m()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.b;
    if (localBaseALIoTDevice != null) {
      return localBaseALIoTDevice.getOnBoardingTime();
    }
    return 0;
  }
  
  public int n()
  {
    o();
    return this.c.getSortValue();
  }
  
  public boolean p()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.b;
    boolean bool;
    if (localBaseALIoTDevice != null) {
      bool = localBaseALIoTDevice.isCamera();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean q()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.b;
    if (localBaseALIoTDevice != null) {
      return localBaseALIoTDevice.isCommonDevice();
    }
    return true;
  }
  
  public boolean r()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.b;
    boolean bool;
    if (localBaseALIoTDevice != null) {
      bool = localBaseALIoTDevice.isFirmwareSupportIoTCloud();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean s()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.b;
    boolean bool;
    if (localBaseALIoTDevice != null) {
      bool = localBaseALIoTDevice.isHub();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean t()
  {
    o();
    boolean bool;
    if ((this.c.isNewDevice()) && (o0.j(System.currentTimeMillis()) - j() < 259200000L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalDeviceBean{alIoTDevice=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", homeCacheBean=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public boolean u()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.b;
    boolean bool;
    if (localBaseALIoTDevice != null) {
      bool = localBaseALIoTDevice.isSupportIoTCloud();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean v()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.b;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isSupportDeviceShare())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean w()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.b;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void x(BaseALIoTDevice paramBaseALIoTDevice)
  {
    this.b = paramBaseALIoTDevice;
  }
  
  public void y(long paramLong)
  {
    o();
    this.c.setFirstDiscoverTime(o0.j(paramLong));
  }
  
  public void z(HomeCacheBean paramHomeCacheBean)
  {
    this.c = paramHomeCacheBean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\home\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */