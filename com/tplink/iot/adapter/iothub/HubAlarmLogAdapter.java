package com.tplink.iot.adapter.iothub;

import android.content.Context;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter.GeneralVH;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.n;

public final class HubAlarmLogAdapter
  extends GeneralAdapter<a>
{
  private final f d = h.b(new a(this));
  
  public HubAlarmLogAdapter(Context paramContext, List<a> paramList)
  {
    super(paramContext, paramList);
  }
  
  private final Map<EnumGuardMode, String> C()
  {
    return (Map)this.d.getValue();
  }
  
  public void B(GeneralAdapter.GeneralVH paramGeneralVH, a parama, int paramInt)
  {
    j.e(paramGeneralVH, "holder");
    j.e(parama, "data");
    boolean bool = parama.c();
    Object localObject1 = "";
    if (bool)
    {
      parama = parama.a();
      if (parama != null) {
        localObject1 = parama;
      }
      paramGeneralVH.d(2131362366, (String)localObject1);
    }
    else
    {
      Object localObject2 = parama.b();
      if (localObject2 != null)
      {
        paramGeneralVH.d(2131364241, ((a.b)localObject2).c());
        parama = ((a.b)localObject2).a();
        if (parama.length() > 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt == 0) {
          parama = null;
        }
        if (parama == null)
        {
          parama = r().getString(2131952465);
          j.d(parama, "mContext.getString(R.string.common_unknown_device)");
        }
        Object localObject3 = ((a.b)localObject2).b();
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject3 = (String)C().get(localObject3);
          localObject2 = localObject1;
          if (localObject3 != null) {
            localObject2 = localObject3;
          }
        }
        paramGeneralVH.d(2131362329, r().getString(2131951793, new Object[] { localObject2, parama }));
      }
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((a)s().get(paramInt)).c()) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    return paramInt;
  }
  
  public int p(int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 2131559044;
    } else {
      paramInt = 2131559043;
    }
    return paramInt;
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.a<Map<EnumGuardMode, ? extends String>>
  {
    a(HubAlarmLogAdapter paramHubAlarmLogAdapter)
    {
      super();
    }
    
    public final Map<EnumGuardMode, String> a()
    {
      return b0.f(new Pair[] { n.a(EnumGuardMode.HOME, HubAlarmLogAdapter.A(this.c).getString(2131951888)), n.a(EnumGuardMode.AWAY, HubAlarmLogAdapter.A(this.c).getString(2131951868)), n.a(EnumGuardMode.SLEEP, HubAlarmLogAdapter.A(this.c).getString(2131952805)) });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iothub\HubAlarmLogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */