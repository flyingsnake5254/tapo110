package com.tplink.libtpnetwork.Utils;

import android.os.Build.VERSION;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class l
{
  public static final void a(a<String> parama)
  {
    j.e(parama, "msg");
  }
  
  public static final String b(IoTLightStripDevice paramIoTLightStripDevice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n        {\n            \"on\": ");
    Object localObject1 = null;
    if (paramIoTLightStripDevice != null) {
      localObject2 = Boolean.valueOf(paramIoTLightStripDevice.isDeviceOn());
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"hue\": ");
    if (paramIoTLightStripDevice != null) {
      localObject2 = Integer.valueOf(paramIoTLightStripDevice.getHue());
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"saturation\": ");
    if (paramIoTLightStripDevice != null) {
      localObject2 = Integer.valueOf(paramIoTLightStripDevice.getSaturation());
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"brightness\": ");
    if (paramIoTLightStripDevice != null) {
      localObject2 = Integer.valueOf(paramIoTLightStripDevice.getBrightness());
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"colorTemp\": ");
    if (paramIoTLightStripDevice != null) {
      localObject2 = Integer.valueOf(paramIoTLightStripDevice.getColorTemp());
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"lighting_effect\": ");
    Object localObject2 = localObject1;
    if (paramIoTLightStripDevice != null)
    {
      paramIoTLightStripDevice = paramIoTLightStripDevice.getLightingEffectData();
      localObject2 = localObject1;
      if (paramIoTLightStripDevice != null) {
        localObject2 = c(paramIoTLightStripDevice);
      }
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("\n        }\n    ");
    return m.f(localStringBuilder.toString());
  }
  
  public static final String c(LightingEffectData paramLightingEffectData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n        {\n            \"id\": ");
    Object localObject1 = null;
    if (paramLightingEffectData != null) {
      localObject2 = paramLightingEffectData.id;
    } else {
      localObject2 = null;
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(",\n            \"type\": ");
    if (paramLightingEffectData != null) {
      localObject2 = paramLightingEffectData.type;
    } else {
      localObject2 = null;
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(",\n            \"name\": ");
    if (paramLightingEffectData != null) {
      localObject2 = paramLightingEffectData.name;
    } else {
      localObject2 = null;
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(",\n            \"custom\": ");
    if (paramLightingEffectData != null) {
      localObject2 = paramLightingEffectData.custom;
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"enable\": ");
    if (paramLightingEffectData != null) {
      localObject2 = paramLightingEffectData.enable;
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"brightness\": ");
    if (paramLightingEffectData != null) {
      localObject2 = paramLightingEffectData.brightness;
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"bAdjusted\": ");
    if (paramLightingEffectData != null) {
      localObject2 = paramLightingEffectData.bAdjusted;
    } else {
      localObject2 = null;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(",\n            \"display_colors\": ");
    if (paramLightingEffectData != null)
    {
      localObject2 = paramLightingEffectData.display_colors;
      if (localObject2 != null)
      {
        localObject2 = e(localObject2);
        break label229;
      }
    }
    Object localObject2 = null;
    label229:
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(",\n            \"sequence\": ");
    localObject2 = localObject1;
    if (paramLightingEffectData != null)
    {
      paramLightingEffectData = paramLightingEffectData.sequence;
      localObject2 = localObject1;
      if (paramLightingEffectData != null) {
        localObject2 = e(paramLightingEffectData);
      }
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("\n        }\n    ");
    return m.f(localStringBuilder.toString());
  }
  
  public static final String d(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    paramLocalIoTBaseDevice = i.j(paramLocalIoTBaseDevice);
    j.d(paramLocalIoTBaseDevice, "GsonUtils.toPrettyJson(this)");
    return paramLocalIoTBaseDevice;
  }
  
  public static final String e(Object paramObject)
  {
    paramObject = i.f(paramObject);
    j.d(paramObject, "GsonUtils.toJson(this)");
    return (String)paramObject;
  }
  
  public static final String f(WebResourceError paramWebResourceError)
  {
    if (paramWebResourceError != null)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\n            {\n                \"errorCode\": ");
        localStringBuilder.append(paramWebResourceError.getErrorCode());
        localStringBuilder.append(",\n                \"description\": ");
        localStringBuilder.append(paramWebResourceError.getDescription());
        localStringBuilder.append("\n            }\n        ");
        paramWebResourceError = m.f(localStringBuilder.toString());
      }
      else
      {
        paramWebResourceError = "Android SDK VERSION < 23";
      }
      return paramWebResourceError;
    }
    return "null WebResourceError";
  }
  
  public static final String g(WebResourceRequest paramWebResourceRequest)
  {
    if (paramWebResourceRequest != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n        {\n            \"url\": ");
      localStringBuilder.append(paramWebResourceRequest.getUrl());
      localStringBuilder.append(",\n            \"method\": ");
      localStringBuilder.append(paramWebResourceRequest.getMethod());
      localStringBuilder.append(",\n            \"headers\": ");
      localStringBuilder.append(e(paramWebResourceRequest.getRequestHeaders()));
      localStringBuilder.append("\n        }\n    ");
      return m.f(localStringBuilder.toString());
    }
    return "null WebResourceRequest";
  }
  
  public static final String h(Object paramObject)
  {
    paramObject = i.j(paramObject);
    j.d(paramObject, "GsonUtils.toPrettyJson(this)");
    return (String)paramObject;
  }
  
  public static final String i(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    if (paramLocalIoTBaseDevice != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLocalIoTBaseDevice.getClass().getSimpleName());
      localStringBuilder.append("{name=");
      localStringBuilder.append(paramLocalIoTBaseDevice.getNickname());
      localStringBuilder.append(" icon=");
      localStringBuilder.append(paramLocalIoTBaseDevice.getAvatar());
      localStringBuilder.append(" location=");
      localStringBuilder.append(paramLocalIoTBaseDevice.getLocation());
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    return "Null LocalIoTBaseDevice";
  }
  
  public static final String j(IoTSubDevice paramIoTSubDevice)
  {
    if (paramIoTSubDevice != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n        {\n            \"device_id\": ");
      localStringBuilder.append(paramIoTSubDevice.getDeviceId());
      localStringBuilder.append("\n            \"trv_states\": ");
      localStringBuilder.append(e(paramIoTSubDevice.getTrvStates()));
      localStringBuilder.append(",\n            \"temp_offset\": ");
      localStringBuilder.append(paramIoTSubDevice.getTempOffset());
      localStringBuilder.append(",\n            \"current_temp\": ");
      localStringBuilder.append(paramIoTSubDevice.getCurrentTemp());
      localStringBuilder.append(",\n            \"max_control_temp\": ");
      localStringBuilder.append(paramIoTSubDevice.getMaxControlTemp());
      localStringBuilder.append(",\n            \"min_control_temp\": ");
      localStringBuilder.append(paramIoTSubDevice.getMinControlTemp());
      localStringBuilder.append(",\n            \"target_temp\": ");
      localStringBuilder.append(paramIoTSubDevice.getTargetTemp());
      localStringBuilder.append(",\n            \"frost_protection_on\": ");
      localStringBuilder.append(paramIoTSubDevice.isFrostProtectionOn());
      localStringBuilder.append(",\n            \"temp_unit\": ");
      localStringBuilder.append(paramIoTSubDevice.getTempUnit());
      localStringBuilder.append("\n        }\n    ");
      return m.f(localStringBuilder.toString());
    }
    return "null trv";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */