package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffectTemplate;
import com.tplink.libtpnetwork.Utils.i;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class LightingEffectTemplateProcessor
{
  private final a templateProcessor;
  
  public LightingEffectTemplateProcessor(a parama)
  {
    this.templateProcessor = parama;
  }
  
  private final String compileTemplate(String paramString, PredefinedEffectsTemplateInput paramPredefinedEffectsTemplateInput)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("colors", paramPredefinedEffectsTemplateInput.getColors());
    localHashMap.put("speed", paramPredefinedEffectsTemplateInput.getSpeed());
    return this.templateProcessor.a(paramString, localHashMap);
  }
  
  public final CustomizedEffect compileEffect(PredefinedEffectTemplate paramPredefinedEffectTemplate, PredefinedEffectsTemplateInput paramPredefinedEffectsTemplateInput)
  {
    j.e(paramPredefinedEffectTemplate, "effectTemplate");
    j.e(paramPredefinedEffectsTemplateInput, "input");
    paramPredefinedEffectTemplate = PredefinedEffectTemplateExtKt.decodeTemplate(paramPredefinedEffectTemplate);
    if (paramPredefinedEffectTemplate != null) {
      return compileEffect(paramPredefinedEffectTemplate, paramPredefinedEffectsTemplateInput);
    }
    return null;
  }
  
  public final CustomizedEffect compileEffect(String paramString, PredefinedEffectsTemplateInput paramPredefinedEffectsTemplateInput)
  {
    j.e(paramString, "templateStr");
    j.e(paramPredefinedEffectsTemplateInput, "input");
    return (CustomizedEffect)i.d(compileTemplate(paramString, paramPredefinedEffectsTemplateInput), CustomizedEffect.class);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\template\LightingEffectTemplateProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */