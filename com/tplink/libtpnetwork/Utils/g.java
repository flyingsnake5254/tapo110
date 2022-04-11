package com.tplink.libtpnetwork.Utils;

import android.graphics.Color;
import android.text.TextUtils;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.BulbPresetDefine;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupPresetBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumGroupState;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class g
{
  public static int a(int paramInt1, int paramInt2)
  {
    return Color.HSVToColor(new float[] { (float)(paramInt1 * 1.0D), (float)(paramInt2 * 1.0D / 100.0D), 1.0F });
  }
  
  public static int b(GroupInfo paramGroupInfo)
  {
    int i = 1;
    if (paramGroupInfo == null) {
      return 1;
    }
    paramGroupInfo = paramGroupInfo.getStateDesired();
    if (paramGroupInfo != null)
    {
      paramGroupInfo = paramGroupInfo.get("brightness");
      if ((paramGroupInfo instanceof Number))
      {
        j = ((Number)paramGroupInfo).intValue();
        break label46;
      }
    }
    int j = 1;
    label46:
    if (j < 1) {
      j = i;
    }
    i = j;
    if (j > 100) {
      i = 100;
    }
    return i;
  }
  
  public static List<Integer> c(GroupInfo paramGroupInfo)
  {
    paramGroupInfo = paramGroupInfo.getPresets();
    if (paramGroupInfo != null) {
      try
      {
        paramGroupInfo = (GroupPresetBean)i.a(paramGroupInfo, GroupPresetBean.class);
      }
      catch (Exception paramGroupInfo)
      {
        b.d.w.c.a.a("BrightnessPresets Exception");
      }
    } else {
      paramGroupInfo = null;
    }
    return d(paramGroupInfo);
  }
  
  private static List<Integer> d(GroupPresetBean paramGroupPresetBean)
  {
    if (paramGroupPresetBean != null)
    {
      paramGroupPresetBean = paramGroupPresetBean.getBrightness();
      if ((paramGroupPresetBean != null) && (!paramGroupPresetBean.isEmpty())) {
        return new ArrayList(paramGroupPresetBean);
      }
    }
    return Arrays.asList(BulbPresetDefine.DEFAULT_BRIGHTNESS_PRESETS);
  }
  
  public static int e(GroupInfo paramGroupInfo)
  {
    int i = -1;
    if (paramGroupInfo == null) {
      return -1;
    }
    paramGroupInfo = paramGroupInfo.getStateDesired();
    int j = 0;
    int k;
    int n;
    if (paramGroupInfo != null)
    {
      Object localObject = paramGroupInfo.get("color_temp");
      if ((localObject instanceof Number)) {
        j = ((Number)localObject).intValue();
      } else {
        j = 0;
      }
      localObject = paramGroupInfo.get("hue");
      if ((localObject instanceof Number)) {
        k = ((Number)localObject).intValue();
      } else {
        k = 0;
      }
      paramGroupInfo = paramGroupInfo.get("saturation");
      int m;
      if ((paramGroupInfo instanceof Number))
      {
        m = ((Number)paramGroupInfo).intValue();
        n = k;
        k = m;
      }
      else
      {
        m = 0;
        n = k;
        k = m;
      }
    }
    else
    {
      k = 0;
      n = 0;
    }
    if (j == 0) {
      i = a(n, k);
    }
    return i;
  }
  
  public static List<LightStateBean> f(GroupInfo paramGroupInfo)
  {
    paramGroupInfo = paramGroupInfo.getPresets();
    if (paramGroupInfo != null) {
      try
      {
        paramGroupInfo = (GroupPresetBean)i.a(paramGroupInfo, GroupPresetBean.class);
      }
      catch (Exception paramGroupInfo)
      {
        b.d.w.c.a.a("ColorPresets Exception");
      }
    } else {
      paramGroupInfo = null;
    }
    return g(paramGroupInfo);
  }
  
  private static List<LightStateBean> g(GroupPresetBean paramGroupPresetBean)
  {
    if (paramGroupPresetBean != null)
    {
      paramGroupPresetBean = paramGroupPresetBean.getStates();
      if ((paramGroupPresetBean != null) && (!paramGroupPresetBean.isEmpty())) {
        return new ArrayList(paramGroupPresetBean);
      }
    }
    return Arrays.asList(BulbPresetDefine.DEFAULT_LIGHT_STATE_PRESETS);
  }
  
  public static String h(GroupInfo paramGroupInfo)
  {
    String str = "light_track";
    if (paramGroupInfo == null) {
      return "light_track";
    }
    Object localObject1 = paramGroupInfo.getStateDesired();
    Object localObject2 = null;
    paramGroupInfo = (GroupInfo)localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).get("auto_mode");
      paramGroupInfo = (GroupInfo)localObject2;
      if ((localObject1 instanceof String)) {
        paramGroupInfo = (String)localObject1;
      }
    }
    if (TextUtils.isEmpty(paramGroupInfo)) {
      paramGroupInfo = str;
    }
    return paramGroupInfo;
  }
  
  private static EnumGroupState i(GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo == null) {
      return EnumGroupState.OFFLINE;
    }
    Object localObject1 = paramGroupInfo.getThingNames();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      paramGroupInfo = (TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      int j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = paramGroupInfo.Z1(b.d.w.h.a.g((String)((Iterator)localObject1).next()));
        if (localObject2 != null)
        {
          localObject2 = ((BaseALIoTDevice)localObject2).getDeviceState();
          if (localObject2 == EnumIoTDeviceState.LOADING) {
            return EnumGroupState.LOADING;
          }
          if (localObject2 == EnumIoTDeviceState.ONLINE) {
            i = 1;
          } else {
            j = 1;
          }
        }
      }
      if (i != 0)
      {
        if (j != 0) {
          return EnumGroupState.PART_OFFLINE;
        }
        return EnumGroupState.ONLINE;
      }
      if (j != 0) {
        return EnumGroupState.OFFLINE;
      }
      return EnumGroupState.EMPTY;
    }
    return EnumGroupState.EMPTY;
  }
  
  public static EnumGroupState j(GroupBean paramGroupBean)
  {
    if (paramGroupBean == null) {
      return EnumGroupState.OFFLINE;
    }
    return i(paramGroupBean.getGroupInfo());
  }
  
  public static boolean k(GroupInfo paramGroupInfo)
  {
    boolean bool1 = false;
    if (paramGroupInfo == null) {
      return false;
    }
    paramGroupInfo = paramGroupInfo.getStateDesired();
    boolean bool2 = bool1;
    if (paramGroupInfo != null)
    {
      paramGroupInfo = paramGroupInfo.get("on");
      bool2 = bool1;
      if ((paramGroupInfo instanceof Boolean)) {
        bool2 = ((Boolean)paramGroupInfo).booleanValue();
      }
    }
    return bool2;
  }
  
  public static boolean l(GroupInfo paramGroupInfo)
  {
    boolean bool;
    if (i(paramGroupInfo) == EnumGroupState.PART_OFFLINE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */