package com.tplink.iot.Utils.z0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.group.detail.GroupDetailColorBulbActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.Iterator;
import java.util.List;

public class o
{
  public static String a(GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo == null) {
      return "";
    }
    return c(paramGroupInfo.getFamilyId(), paramGroupInfo.getRoomId());
  }
  
  public static String b(GroupBean paramGroupBean)
  {
    if (paramGroupBean == null) {
      return "";
    }
    return c(paramGroupBean.getFamilyId(), paramGroupBean.getRoomId());
  }
  
  private static String c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = ((FamilyManagerRepository)b.a(b.d.s.a.a.f(), FamilyManagerRepository.class)).f0(paramString1, paramString2);
      if (TextUtils.isEmpty(paramString1)) {
        return "";
      }
      return paramString1;
    }
    return "";
  }
  
  public static String d(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramContext == null) {
      return "";
    }
    return paramContext.getString(2131952777);
  }
  
  public static void e(Activity paramActivity, GroupInfo paramGroupInfo)
  {
    List localList = paramGroupInfo.getThingNames();
    if ((localList != null) && (!localList.isEmpty())) {
      GroupDetailColorBulbActivity.z1(paramActivity, paramGroupInfo.getId());
    }
  }
  
  public static boolean f(GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo == null) {
      return false;
    }
    Object localObject1 = paramGroupInfo.getThingNames();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      paramGroupInfo = (TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = paramGroupInfo.Z1(b.d.w.h.a.g((String)((Iterator)localObject1).next()));
        if ((localObject2 instanceof ALIoTDevice))
        {
          localObject2 = (ALIoTDevice)localObject2;
          if ((((BaseALIoTDevice)localObject2).isBulb()) && (!((ALIoTDevice)localObject2).isSupportColorAndColorTemp())) {
            return false;
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public static void g(GroupInfo paramGroupInfo, ImageView paramImageView)
  {
    i(paramGroupInfo, paramImageView);
  }
  
  public static void h(GroupBean paramGroupBean, ImageView paramImageView)
  {
    if (paramGroupBean == null) {
      i(null, paramImageView);
    } else {
      i(paramGroupBean.getGroupInfo(), paramImageView);
    }
  }
  
  private static void i(GroupInfo paramGroupInfo, ImageView paramImageView)
  {
    if (paramGroupInfo != null) {
      paramGroupInfo = EnumBulbAvatarType.fromString(paramGroupInfo.getAvatarUrl());
    } else {
      paramGroupInfo = null;
    }
    paramImageView.setImageResource(g.c(paramGroupInfo));
  }
  
  public static void j(GroupInfo paramGroupInfo, ImageView paramImageView)
  {
    k(paramGroupInfo, paramImageView);
  }
  
  private static void k(GroupInfo paramGroupInfo, ImageView paramImageView)
  {
    if (paramGroupInfo != null) {
      paramGroupInfo = EnumBulbAvatarType.fromString(paramGroupInfo.getAvatarUrl());
    } else {
      paramGroupInfo = null;
    }
    paramImageView.setImageResource(g.d(paramGroupInfo));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */