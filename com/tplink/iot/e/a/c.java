package com.tplink.iot.e.a;

import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;

public final class c
{
  private static String a = "";
  private static d b;
  private static int c;
  private static boolean d;
  private static final HashMap<String, String> e = new HashMap();
  private static boolean f;
  private static boolean g;
  private static final HashMap<String, Integer> h = new HashMap();
  private static List<? extends SummaryClip> i;
  private static final HashMap<String, Boolean> j = new HashMap();
  public static final c k = new c();
  
  public final int a()
  {
    int m = c;
    c = m + 1;
    return m;
  }
  
  public final String b()
  {
    return a;
  }
  
  public final int c()
  {
    return c;
  }
  
  public final boolean d()
  {
    return g;
  }
  
  public final HashMap<String, Boolean> e()
  {
    return j;
  }
  
  public final HashMap<String, String> f()
  {
    return e;
  }
  
  public final boolean g()
  {
    return d;
  }
  
  public final List<SummaryClip> h()
  {
    return i;
  }
  
  public final boolean i()
  {
    return f;
  }
  
  public final d j()
  {
    return b;
  }
  
  public final HashMap<String, Integer> k()
  {
    return h;
  }
  
  public final void l()
  {
    d = false;
    c = 0;
    h.clear();
    e.clear();
    i = null;
  }
  
  public final void m(String paramString)
  {
    j.e(paramString, "deviceId");
    a = paramString;
  }
  
  public final void n(int paramInt)
  {
    c = paramInt;
  }
  
  public final void o(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public final void p(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public final void q(List<? extends SummaryClip> paramList)
  {
    j.e(paramList, "clipList");
    i = paramList;
  }
  
  public final void r(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  public final void s(d paramd)
  {
    j.e(paramd, "summarySetting");
    b = paramd;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */