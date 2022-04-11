package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a;

import com.samskivert.mustache.f;
import com.samskivert.mustache.f.f;
import com.samskivert.mustache.g;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class b
  implements a
{
  public static final a a = new a(null);
  private final f.f b;
  private final List<com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.a> c;
  private final List<com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a> d;
  
  public b(f.f paramf, List<? extends com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.a> paramList, List<? extends com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a> paramList1)
  {
    this.b = paramf;
    this.c = paramList;
    this.d = paramList1;
  }
  
  private final g b(String paramString)
  {
    paramString = this.b.b(paramString);
    j.d(paramString, "mustache.compile(template)");
    return paramString;
  }
  
  private final String c(g paramg, Map<String, Object> paramMap)
  {
    Iterator localIterator = this.c.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.a)localIterator.next();
      paramMap.put(((com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.a)localObject).getId(), localObject);
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a)localIterator.next();
      paramMap.put(((com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.a)localObject).getId(), localObject);
    }
    paramg = paramg.c(paramMap);
    j.d(paramg, "template.execute(input)");
    return paramg;
  }
  
  public String a(String paramString, Map<String, Object> paramMap)
  {
    j.e(paramString, "template");
    j.e(paramMap, "input");
    return c(b(paramString), paramMap);
  }
  
  public static final class a
  {
    public final b a()
    {
      f.f localf = f.b();
      j.d(localf, "Mustache.compiler()");
      return new b(localf, new ArrayList(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.d.b.a.a().values()), new ArrayList(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.f.a.c.b.a.a().values()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\fromkasa\f\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */