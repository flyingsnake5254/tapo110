package com.tplink.iot.Utils;

import android.text.TextUtils;
import b.d.n.i.g;
import b.d.s.a.a;
import com.tplink.cloud.bean.push.params.UnsubscribeMsgParams;
import com.tplink.libtpinappmessaging.model.c;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.Utils.o;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

public class p
{
  private static final List<String> a = new ArrayList();
  private static final b.d.n.i.b b = new a();
  
  public static void b(List<String> paramList)
  {
    List localList = a;
    localList.clear();
    if (!s.b(paramList)) {
      localList.addAll(paramList);
    }
    g(paramList);
  }
  
  public static void c()
  {
    a.clear();
    b.d.n.f.b.l().c();
    g(null);
  }
  
  private static List<String> d()
  {
    Object localObject = o.h0().f("sp_iac_last_account_filters", null);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = i.e((String)localObject, String.class);
      return (List<String>)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return new ArrayList();
  }
  
  public static void e()
  {
    b.d.n.f.b.l().c();
    b.d.n.f.b.l().g(b);
    b(d());
  }
  
  public static void f()
  {
    boolean bool = o.h0().c0();
    ArrayList localArrayList = new ArrayList();
    if (!bool) {
      localArrayList.add("marketPromotion");
    }
    b(localArrayList);
    UnsubscribeMsgParams localUnsubscribeMsgParams = new UnsubscribeMsgParams();
    localUnsubscribeMsgParams.setMsgTypes(localArrayList);
    ((TCMessagePushRepository)b.d.b.f.b.a(a.f(), TCMessagePushRepository.class)).T(localUnsubscribeMsgParams).F0();
  }
  
  private static void g(List<String> paramList)
  {
    o localo = o.h0();
    if (paramList == null) {
      paramList = null;
    } else {
      paramList = i.h(paramList);
    }
    localo.k("sp_iac_last_account_filters", paramList);
  }
  
  static final class a
    implements b.d.n.i.b
  {
    public boolean a(c paramc)
    {
      return (paramc != null) && (p.a().contains(paramc.a()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */