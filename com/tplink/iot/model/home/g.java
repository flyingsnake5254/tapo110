package com.tplink.iot.model.home;

import androidx.annotation.NonNull;
import b.d.w.h.a;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;

public class g
  extends e
{
  private GroupBean b;
  
  public g(GroupBean paramGroupBean)
  {
    k(paramGroupBean);
  }
  
  @NonNull
  public String d()
  {
    return i();
  }
  
  public String e()
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = a.g(((GroupBean)localObject1).getGroupId());
    } else {
      localObject1 = null;
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
    GroupBean localGroupBean = this.b;
    if (localGroupBean != null) {
      return localGroupBean.getName();
    }
    return "";
  }
  
  public String g()
  {
    GroupBean localGroupBean = this.b;
    if (localGroupBean != null) {
      return localGroupBean.getFamilyId();
    }
    return null;
  }
  
  public GroupBean h()
  {
    return this.b;
  }
  
  public String i()
  {
    GroupBean localGroupBean = this.b;
    if (localGroupBean != null) {
      return localGroupBean.getGroupId();
    }
    return "";
  }
  
  public boolean j()
  {
    GroupBean localGroupBean = this.b;
    if (localGroupBean != null) {
      return localGroupBean.isCommon();
    }
    return false;
  }
  
  public void k(GroupBean paramGroupBean)
  {
    this.b = paramGroupBean;
  }
  
  public void l(GroupInfo paramGroupInfo)
  {
    GroupBean localGroupBean = this.b;
    if (localGroupBean == null) {
      this.b = new GroupBean(paramGroupInfo);
    } else {
      localGroupBean.setGroupInfo(paramGroupInfo);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\home\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */