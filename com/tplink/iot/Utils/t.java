package com.tplink.iot.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class t
{
  @DrawableRes
  public static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return 2131689742;
      }
      return 2131689842;
    }
    return 2131689834;
  }
  
  private static String b(Context paramContext, long paramLong, String paramString)
  {
    Object localObject = Calendar.getInstance(p0.d(paramString));
    paramLong *= 1000L;
    ((Calendar)localObject).setTime(new Date(paramLong));
    int i = ((Calendar)localObject).get(11);
    int j = ((Calendar)localObject).get(12);
    if (paramLong > f()) {
      localObject = l.l(paramContext, ((Calendar)localObject).get(7));
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(p0.a(paramContext, i * 60 + j));
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramContext = new StringBuilder();
      paramContext.append(" ");
      paramContext.append((String)localObject);
      localObject = paramContext.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(p0.e(paramString));
    return localStringBuilder.toString();
  }
  
  public static int c(NextEvent paramNextEvent)
  {
    if (paramNextEvent == null) {
      return Integer.MAX_VALUE;
    }
    int i = paramNextEvent.getType();
    if ((i == 1) || (i == 2))
    {
      Object localObject = paramNextEvent.getDesiredStates();
      if (localObject != null)
      {
        DesiredStatesBean localDesiredStatesBean = (DesiredStatesBean)com.tplink.libtpnetwork.Utils.i.a(com.tplink.libtpnetwork.Utils.i.i(localObject), DesiredStatesBean.class);
        if (localDesiredStatesBean.isOn())
        {
          if (localDesiredStatesBean.isAuto()) {
            return 0;
          }
          paramNextEvent = ((Map)localObject).get("color_temp");
          localObject = ((Map)localObject).get("hue");
          if ((paramNextEvent != null) || (localObject != null))
          {
            if (localDesiredStatesBean.getColorTemp() == 0) {
              return com.tplink.iot.Utils.z0.i.a(localDesiredStatesBean.getHue(), localDesiredStatesBean.getSaturation());
            }
            return -2147483647;
          }
        }
      }
    }
    return Integer.MAX_VALUE;
  }
  
  public static String d(Context paramContext, NextEvent paramNextEvent, String paramString)
  {
    String str = "";
    Object localObject1 = str;
    if (paramContext != null) {
      if (paramNextEvent == null)
      {
        localObject1 = str;
      }
      else
      {
        int i = paramNextEvent.getType();
        int j;
        if ((i == 3) && (paramNextEvent.getStartTime() < System.currentTimeMillis() / 1000L)) {
          j = 1;
        } else {
          j = 0;
        }
        if ((i != 1) && (i != 2))
        {
          localObject1 = str;
          if (i == 3)
          {
            localObject1 = paramContext.getResources();
            if (j != 0) {
              i = 2131954282;
            } else {
              i = 2131954283;
            }
            localObject1 = ((Resources)localObject1).getString(i);
            if (j != 0) {
              j = paramNextEvent.getEndTime();
            } else {
              j = paramNextEvent.getStartTime();
            }
            localObject1 = String.format((String)localObject1, new Object[] { b(paramContext, j, paramString) });
          }
        }
        else
        {
          Map localMap = paramNextEvent.getDesiredStates();
          if (localMap != null) {
            localObject1 = localMap.get("on");
          } else {
            localObject1 = null;
          }
          boolean bool;
          if ((localObject1 instanceof Boolean)) {
            bool = ((Boolean)localObject1).booleanValue();
          } else {
            bool = false;
          }
          Object localObject2;
          if (localMap != null)
          {
            localObject1 = (DesiredStatesBean)com.tplink.libtpnetwork.Utils.i.a(com.tplink.libtpnetwork.Utils.i.i(localMap), DesiredStatesBean.class);
            if ((((DesiredStatesBean)localObject1).isAuto()) && (((DesiredStatesBean)localObject1).isOn()))
            {
              localObject2 = new StringBuilder();
              if (i == 1) {
                paramNextEvent = b(paramContext, paramNextEvent.getStartTime(), paramString);
              } else {
                paramNextEvent = o0.e(paramNextEvent.getEndTime());
              }
              ((StringBuilder)localObject2).append(paramNextEvent);
              ((StringBuilder)localObject2).append(" ");
              ((StringBuilder)localObject2).append(com.tplink.iot.Utils.z0.i.b(paramContext, ((DesiredStatesBean)localObject1).getAutoMode()));
              return ((StringBuilder)localObject2).toString();
            }
          }
          if (i == 1)
          {
            localObject1 = paramContext.getResources();
            if (bool) {
              j = 2131954285;
            } else {
              j = 2131954284;
            }
            localObject2 = String.format(((Resources)localObject1).getString(j), new Object[] { b(paramContext, paramNextEvent.getStartTime(), paramString) });
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(o0.e(paramNextEvent.getEndTime()));
            ((StringBuilder)localObject2).append(" ");
            localObject1 = paramContext.getResources();
            if (bool) {
              j = 2131954365;
            } else {
              j = 2131954364;
            }
            ((StringBuilder)localObject2).append(((Resources)localObject1).getString(j));
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          if ((localMap != null) && (bool))
          {
            paramContext = localMap.get("brightness");
            paramNextEvent = localMap.get("color_temp");
            paramString = LightingEffectData.resolveObject(localMap.get("lighting_effect"));
            if ((paramString != null) && (paramString.brightness != null))
            {
              paramContext = new StringBuilder();
              paramContext.append((String)localObject2);
              paramContext.append(" ");
              paramContext.append(paramString.brightness);
              paramContext.append("%");
              localObject1 = paramContext.toString();
            }
            else
            {
              localObject1 = localObject2;
              if (paramContext != null)
              {
                if (paramNextEvent != null) {
                  str = com.tplink.iot.Utils.z0.i.e(((DesiredStatesBean)com.tplink.libtpnetwork.Utils.i.a(com.tplink.libtpnetwork.Utils.i.i(localMap), DesiredStatesBean.class)).getColorTemp());
                }
                paramNextEvent = new StringBuilder();
                paramNextEvent.append((String)localObject2);
                paramNextEvent.append(" ");
                paramNextEvent.append(paramContext);
                paramNextEvent.append("%");
                paramNextEvent.append(str);
                localObject1 = paramNextEvent.toString();
              }
            }
          }
          else
          {
            localObject1 = localObject2;
            if (localMap != null)
            {
              localObject1 = localObject2;
              if (localMap.containsKey("frost_protection_on")) {
                localObject1 = e(paramContext, paramNextEvent, (DesiredStatesBean)com.tplink.libtpnetwork.Utils.i.a(com.tplink.libtpnetwork.Utils.i.i(localMap), DesiredStatesBean.class), paramString);
              }
            }
          }
        }
      }
    }
    return (String)localObject1;
  }
  
  private static String e(Context paramContext, NextEvent paramNextEvent, DesiredStatesBean paramDesiredStatesBean, String paramString)
  {
    int i = paramNextEvent.getType();
    if (i == 1)
    {
      paramNextEvent = b(paramContext, paramNextEvent.getStartTime(), paramString);
      if (!paramDesiredStatesBean.isFrostProtectionOn()) {
        return paramContext.getString(2131954341, new Object[] { b.e(paramDesiredStatesBean.getTargetTemp(), paramDesiredStatesBean.getTempUnit()), paramNextEvent });
      }
      return paramContext.getString(2131954284, new Object[] { paramNextEvent });
    }
    if (i == 2)
    {
      paramNextEvent = o0.e(paramNextEvent.getEndTime());
      if (!paramDesiredStatesBean.isFrostProtectionOn()) {
        paramContext = paramContext.getString(2131953998, new Object[] { b.e(paramDesiredStatesBean.getTargetTemp(), paramDesiredStatesBean.getTempUnit()) });
      } else {
        paramContext = paramContext.getString(2131953962);
      }
      paramDesiredStatesBean = new StringBuilder();
      paramDesiredStatesBean.append(paramNextEvent);
      paramDesiredStatesBean.append(" ");
      paramDesiredStatesBean.append(paramContext);
      return paramDesiredStatesBean.toString();
    }
    return "";
  }
  
  private static long f()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5), 23, 59, 59);
    return localCalendar.getTimeInMillis();
  }
  
  public static boolean g(@Nullable NextEvent paramNextEvent)
  {
    boolean bool1 = false;
    if (paramNextEvent == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (paramNextEvent.getDesiredStates() != null)
    {
      bool2 = bool1;
      if (paramNextEvent.getDesiredStates().get("lighting_effect") != null) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static boolean h(int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 1) || (paramInt > 3)) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean i(ThingNextEvent paramThingNextEvent, String paramString)
  {
    if ((paramThingNextEvent != null) && (paramThingNextEvent.getNextEvent() != null) && (h(paramThingNextEvent.getNextEvent().getType())))
    {
      paramThingNextEvent = paramThingNextEvent.getNextEvent();
      long l;
      if (paramThingNextEvent.getType() == 3) {
        l = o0.k(paramThingNextEvent.getEndTime(), paramString);
      } else {
        l = o0.k(paramThingNextEvent.getStartTime(), paramString);
      }
      if (l > System.currentTimeMillis()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */