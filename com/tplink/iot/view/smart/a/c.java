package com.tplink.iot.view.smart.a;

import android.app.Application;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode.a;
import java.util.Arrays;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class c
{
  public static final c a = new c();
  
  private static final String a(int paramInt)
  {
    String str = AppContext.c.getString(paramInt);
    j.d(str, "AppContext.instance.getString(resId)");
    return str;
  }
  
  private static final String b(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = AppContext.c.getString(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    j.d(paramVarArgs, "AppContext.instance.getString(resId, *formatArgs)");
    return paramVarArgs;
  }
  
  public static final String c(SmartThingAction paramSmartThingAction, BaseALIoTDevice<?> paramBaseALIoTDevice, a parama)
  {
    j.e(parama, "options");
    if ((parama.d()) && ((paramSmartThingAction == null) || (paramBaseALIoTDevice == null) || (!paramBaseALIoTDevice.isOnline())))
    {
      paramSmartThingAction = AppContext.c.getString(2131954296);
      j.d(paramSmartThingAction, "AppContext.instance.getS…tring.tip_device_offline)");
      return paramSmartThingAction;
    }
    ThingServiceParams localThingServiceParams = null;
    if (paramSmartThingAction != null) {
      paramBaseALIoTDevice = paramSmartThingAction.getStateDesired();
    } else {
      paramBaseALIoTDevice = null;
    }
    if (paramSmartThingAction != null) {
      localThingServiceParams = paramSmartThingAction.getService();
    }
    if (paramBaseALIoTDevice != null) {
      paramSmartThingAction = e(paramBaseALIoTDevice, parama);
    } else if (localThingServiceParams != null) {
      paramSmartThingAction = d(localThingServiceParams, parama);
    } else {
      paramSmartThingAction = "";
    }
    return paramSmartThingAction;
  }
  
  private static final String d(ThingServiceParams paramThingServiceParams, a parama)
  {
    paramThingServiceParams = paramThingServiceParams.getServiceId();
    if (paramThingServiceParams != null) {
      switch (paramThingServiceParams.hashCode())
      {
      default: 
        break;
      case 1702616436: 
        if (paramThingServiceParams.equals("reverseStatus")) {
          paramThingServiceParams = a(2131953965);
        }
        break;
      case 754435698: 
        if (paramThingServiceParams.equals("increaseCCT")) {
          paramThingServiceParams = a(2131953986);
        }
        break;
      case 666952591: 
        if (paramThingServiceParams.equals("decreaseBrightness")) {
          paramThingServiceParams = a(2131953956);
        }
        break;
      case 3500592: 
        if (paramThingServiceParams.equals("ring")) {
          paramThingServiceParams = a(2131954009);
        }
        break;
      case -725558176: 
        if (paramThingServiceParams.equals("randomColor")) {
          paramThingServiceParams = a(2131953992);
        }
        break;
      case -728556493: 
        if (paramThingServiceParams.equals("increaseBrightness")) {
          paramThingServiceParams = a(2131953985);
        }
        break;
      case -1377087850: 
        if (paramThingServiceParams.equals("decreaseCCT")) {
          paramThingServiceParams = a(2131953957);
        }
        break;
      }
    }
    paramThingServiceParams = "";
    return paramThingServiceParams;
  }
  
  private static final String e(Map<String, ? extends Object> paramMap, a parama)
  {
    Object localObject1 = paramMap.get("on");
    boolean bool1 = localObject1 instanceof Boolean;
    Object localObject2 = null;
    if (!bool1) {
      localObject1 = null;
    }
    localObject1 = (Boolean)localObject1;
    if (localObject1 != null) {
      bool1 = ((Boolean)localObject1).booleanValue();
    } else {
      bool1 = false;
    }
    Object localObject3 = paramMap.get("auto");
    localObject1 = localObject3;
    if (!(localObject3 instanceof Boolean)) {
      localObject1 = null;
    }
    localObject1 = (Boolean)localObject1;
    boolean bool2;
    if (localObject1 != null) {
      bool2 = ((Boolean)localObject1).booleanValue();
    } else {
      bool2 = false;
    }
    localObject1 = a(2131953962);
    if ((bool1) && (bool2)) {
      localObject1 = a(2131954045);
    } else if (bool1) {
      localObject1 = a(2131953963);
    }
    Object localObject4 = paramMap.get("brightness");
    localObject3 = localObject1;
    if (parama.c())
    {
      localObject3 = localObject1;
      if (bool1)
      {
        localObject3 = localObject1;
        if (!bool2)
        {
          localObject3 = localObject1;
          if (localObject4 != null) {
            if (parama.b())
            {
              parama = new StringBuilder();
              parama.append((String)localObject1);
              parama.append(" | ");
              parama.append(b(2131953961, new Object[] { localObject4 }));
              localObject3 = parama.toString();
            }
            else
            {
              parama = new StringBuilder();
              parama.append((String)localObject1);
              parama.append(", ");
              parama.append(b(2131953960, new Object[] { localObject4 }));
              localObject3 = parama.toString();
            }
          }
        }
      }
    }
    bool1 = paramMap.containsKey("guard_on");
    localObject1 = "";
    int i;
    if (bool1)
    {
      localObject3 = paramMap.get("guard_on");
      parama = (a)localObject3;
      if (!(localObject3 instanceof Boolean)) {
        parama = null;
      }
      parama = (Boolean)parama;
      if (parama != null) {
        bool1 = parama.booleanValue();
      } else {
        bool1 = false;
      }
      if (bool1)
      {
        localObject4 = EnumGuardMode.Companion;
        localObject3 = paramMap.get("guard_mode");
        parama = (a)localObject3;
        if (!(localObject3 instanceof String)) {
          parama = null;
        }
        parama = (String)parama;
        if (parama == null) {
          parama = "";
        }
        parama = ((EnumGuardMode.a)localObject4).a(parama);
        i = d.a[parama.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              parama = a(2131954020);
            } else {
              throw new NoWhenBranchMatchedException();
            }
          }
          else {
            parama = a(2131954015);
          }
        }
        else {
          parama = a(2131954019);
        }
        localObject3 = parama;
      }
      else
      {
        localObject3 = a(2131952795);
      }
    }
    parama = (a)localObject3;
    if (paramMap.get("lighting_effect") != null)
    {
      parama = new StringBuilder();
      parama.append((String)localObject3);
      parama.append(" | ");
      parama.append(a(2131953996));
      parama = parama.toString();
    }
    if (paramMap.containsKey("frost_protection_on"))
    {
      localObject3 = paramMap.get("frost_protection_on");
      parama = (a)localObject3;
      if (!(localObject3 instanceof Boolean)) {
        parama = null;
      }
      parama = (Boolean)parama;
      if (parama != null) {
        bool1 = parama.booleanValue();
      } else {
        bool1 = false;
      }
      if (bool1) {
        parama = a(2131952440);
      }
      for (;;)
      {
        break;
        localObject3 = paramMap.get("target_temp");
        parama = (a)localObject3;
        if (!(localObject3 instanceof Number)) {
          parama = null;
        }
        parama = (Number)parama;
        if (parama != null)
        {
          i = parama.intValue();
          localObject3 = paramMap.get("temp_unit");
          parama = (a)localObject3;
          if (!(localObject3 instanceof String)) {
            parama = null;
          }
          parama = (String)parama;
          if (parama != null)
          {
            parama = b(2131953998, new Object[] { b.e(i, parama) });
            continue;
          }
        }
        return "";
      }
    }
    if (paramMap.containsKey("lensMask"))
    {
      paramMap = paramMap.get("lensMask");
      if (!(paramMap instanceof String)) {
        paramMap = (Map<String, ? extends Object>)localObject2;
      }
      parama = (String)paramMap;
      if (parama == null)
      {
        paramMap = (Map<String, ? extends Object>)localObject1;
      }
      else
      {
        i = parama.hashCode();
        if (i != 3551)
        {
          if (i != 109935)
          {
            paramMap = (Map<String, ? extends Object>)localObject1;
          }
          else
          {
            paramMap = (Map<String, ? extends Object>)localObject1;
            if (parama.equals("off")) {
              paramMap = a(2131954036);
            }
          }
        }
        else
        {
          paramMap = (Map<String, ? extends Object>)localObject1;
          if (parama.equals("on")) {
            paramMap = a(2131954039);
          }
        }
      }
      parama = paramMap;
    }
    return parama;
  }
  
  public static final class a
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    
    public final boolean a()
    {
      return this.c;
    }
    
    public final boolean b()
    {
      return this.d;
    }
    
    public final boolean c()
    {
      return this.b;
    }
    
    public final boolean d()
    {
      return this.a;
    }
    
    public final a e(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }
    
    public final a f(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
    
    public final a g(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }
    
    public final a h(boolean paramBoolean)
    {
      this.a = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */