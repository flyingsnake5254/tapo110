package com.tplink.iot.viewmodel.ipcamera.setting;

import java.util.HashMap;
import java.util.Map;

public class l9
{
  private static Map<String, m9> a;
  
  private l9()
  {
    a = new HashMap();
  }
  
  public static l9 a()
  {
    return b.a();
  }
  
  public m9 b(String paramString)
  {
    m9 localm91 = (m9)a.get(paramString);
    m9 localm92 = localm91;
    if (localm91 == null)
    {
      localm92 = new m9(paramString);
      a.put(paramString, localm92);
    }
    return localm92;
  }
  
  private static class b
  {
    private static l9 a = new l9(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\l9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */