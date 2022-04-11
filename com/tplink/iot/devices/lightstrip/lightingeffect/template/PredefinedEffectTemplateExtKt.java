package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import b.d.w.h.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffectTemplate;
import kotlin.jvm.internal.j;

public final class PredefinedEffectTemplateExtKt
{
  public static final String decodeTemplate(PredefinedEffectTemplate paramPredefinedEffectTemplate)
  {
    j.e(paramPredefinedEffectTemplate, "$this$decodeTemplate");
    return a.a(paramPredefinedEffectTemplate.getTemplate());
  }
  
  public static final String encodeTemplate(PredefinedEffectTemplate paramPredefinedEffectTemplate, String paramString)
  {
    j.e(paramPredefinedEffectTemplate, "$this$encodeTemplate");
    j.e(paramString, "rawString");
    paramPredefinedEffectTemplate.setTemplate(a.b(paramString));
    return paramPredefinedEffectTemplate.getTemplate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\template\PredefinedEffectTemplateExtKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */