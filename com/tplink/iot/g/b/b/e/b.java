package com.tplink.iot.g.b.b.e;

import com.tplink.iot.g.b.b.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import kotlin.jvm.internal.j;

public final class b
{
  public static final String a(a parama)
  {
    j.e(parama, "$this$resolveItemId");
    if ((parama instanceof c))
    {
      parama = ((c)parama).c();
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.a))
    {
      parama = ((com.tplink.iot.g.b.b.a)parama).e();
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.b))
    {
      parama = ((com.tplink.iot.g.b.b.b)parama).e();
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.d))
    {
      parama = (com.tplink.iot.g.b.b.d)parama;
      if (parama.i()) {
        parama = "PredefinedEffect_Daylight";
      } else {
        parama = parama.f();
      }
    }
    else
    {
      parama = null;
    }
    return parama;
  }
  
  public static final LightStateBean b(a parama, boolean paramBoolean)
  {
    j.e(parama, "$this$resolveLightState");
    boolean bool = parama instanceof c;
    Object localObject1 = null;
    Object localObject2;
    if (bool)
    {
      localObject2 = ((c)parama).e();
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.a))
    {
      parama = ((com.tplink.iot.g.b.b.a)parama).d();
      if (parama != null)
      {
        parama = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.B(parama);
        if (parama != null)
        {
          localObject2 = new LightStateBean();
          ((LightStateBean)localObject2).setLightingEffectData(parama);
          break label225;
        }
      }
      return null;
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.b))
    {
      parama = ((com.tplink.iot.g.b.b.b)parama).d();
      if (parama != null) {
        parama = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.a(parama, paramBoolean);
      } else {
        parama = null;
      }
      if (parama != null)
      {
        parama = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.B(parama);
        if (parama != null)
        {
          localObject2 = new LightStateBean();
          ((LightStateBean)localObject2).setLightingEffectData(parama);
          break label225;
        }
      }
      return null;
    }
    else
    {
      localObject2 = localObject1;
      if ((parama instanceof com.tplink.iot.g.b.b.d))
      {
        parama = (com.tplink.iot.g.b.b.d)parama;
        if (parama.i())
        {
          localObject2 = parama.c();
        }
        else
        {
          parama = parama.e();
          if (parama != null) {
            parama = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.c(parama, paramBoolean);
          } else {
            parama = null;
          }
          localObject2 = localObject1;
          if (parama != null)
          {
            parama = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.C(parama);
            localObject2 = localObject1;
            if (parama != null)
            {
              localObject2 = new LightStateBean();
              ((LightStateBean)localObject2).setLightingEffectData(parama);
            }
          }
        }
      }
    }
    label225:
    return (LightStateBean)localObject2;
  }
  
  public static final LightStateBean c(a parama)
  {
    j.e(parama, "$this$resolveLightStateFromPreset");
    boolean bool = parama instanceof c;
    Object localObject1 = null;
    Object localObject2;
    if (bool)
    {
      localObject2 = ((c)parama).e();
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.a))
    {
      parama = ((com.tplink.iot.g.b.b.a)parama).g();
      if (parama != null)
      {
        localObject2 = new LightStateBean();
        ((LightStateBean)localObject2).setLightingEffectData(parama);
      }
      else
      {
        return null;
      }
    }
    else if ((parama instanceof com.tplink.iot.g.b.b.b))
    {
      parama = ((com.tplink.iot.g.b.b.b)parama).f();
      if (parama != null)
      {
        localObject2 = new LightStateBean();
        ((LightStateBean)localObject2).setLightingEffectData(parama);
      }
      else
      {
        return null;
      }
    }
    else
    {
      localObject2 = localObject1;
      if ((parama instanceof com.tplink.iot.g.b.b.d))
      {
        parama = ((com.tplink.iot.g.b.b.d)parama).g();
        localObject2 = localObject1;
        if (parama != null)
        {
          localObject2 = new LightStateBean();
          ((LightStateBean)localObject2).setLightingEffectData(parama);
        }
      }
    }
    return (LightStateBean)localObject2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\b\b\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */