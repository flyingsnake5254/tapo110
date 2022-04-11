package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleSchedule;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.RuleRemoveParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.ScheduleRuleParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AntiTheftRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CountdownRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import io.reactivex.a;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IoTCommonFeatureRepository
  extends ThingBaseRepository
{
  private MutableLiveData<List<ThingRuleSchedule>> p = new MutableLiveData();
  private Map<String, ThingRuleSchedule> q = new LinkedHashMap();
  private int r = 20;
  private MutableLiveData<ThingRuleAwayMode> s = new MutableLiveData();
  private MutableLiveData<ThingRuleTimer> t = new MutableLiveData();
  private MutableLiveData<Integer> u = new MutableLiveData();
  private MutableLiveData<LedInfoBean> v = new MutableLiveData();
  private LedInfoBean w;
  
  public IoTCommonFeatureRepository(ThingContext paramThingContext)
  {
    super(paramThingContext);
  }
  
  private q<List<ThingRuleSchedule>> U0(ScheduleRuleParams paramScheduleRuleParams)
  {
    ArrayList localArrayList = new ArrayList();
    return g1(paramScheduleRuleParams).g0(new z7(this, localArrayList, paramScheduleRuleParams)).w0(n7.c);
  }
  
  private q<List<ThingRuleSchedule>> V0(ScheduleRuleParams paramScheduleRuleParams)
  {
    ArrayList localArrayList = new ArrayList();
    return h1(paramScheduleRuleParams).g0(new a8(this, localArrayList, paramScheduleRuleParams)).w0(d7.c);
  }
  
  private q<ScheduleRuleResult> g1(ScheduleRuleParams paramScheduleRuleParams)
  {
    return y0("get_schedule_rules", paramScheduleRuleParams, ScheduleRuleResult.class);
  }
  
  private q<ThingRuleListResult<ThingRuleSchedule>> h1(ScheduleRuleParams paramScheduleRuleParams)
  {
    return q.f0(paramScheduleRuleParams).N(new l7(this, paramScheduleRuleParams));
  }
  
  public q<ThingRuleUpdateResult> O0(ThingRuleAwayMode paramThingRuleAwayMode)
  {
    return y0("add_antitheft_rule", paramThingRuleAwayMode, ThingRuleUpdateResult.class).o0(new k7(this, paramThingRuleAwayMode)).E(new e8(this, paramThingRuleAwayMode));
  }
  
  public q<ThingRuleUpdateResult> P0(ThingRuleTimer paramThingRuleTimer)
  {
    return y0("add_countdown_rule", paramThingRuleTimer, ThingRuleUpdateResult.class).o0(new j7(this, paramThingRuleTimer)).E(new b8(this, paramThingRuleTimer));
  }
  
  public q<ThingRuleUpdateResult> Q0(ThingRuleSchedule paramThingRuleSchedule)
  {
    return y0("add_schedule_rule", paramThingRuleSchedule, ThingRuleUpdateResult.class).o0(new q7(this, paramThingRuleSchedule)).E(new y7(this, paramThingRuleSchedule));
  }
  
  public q<ThingRuleUpdateResult> R0(ThingRuleAwayMode paramThingRuleAwayMode)
  {
    return y0("edit_antitheft_rule", paramThingRuleAwayMode, ThingRuleUpdateResult.class).o0(new c7(this, paramThingRuleAwayMode)).E(new c8(this, paramThingRuleAwayMode));
  }
  
  public q<Boolean> S0(ThingRuleTimer paramThingRuleTimer)
  {
    return y0("edit_countdown_rule", paramThingRuleTimer, Boolean.class).o0(new h7(this, paramThingRuleTimer)).E(new w7(this, paramThingRuleTimer));
  }
  
  public q<ThingRuleUpdateResult> T0(ThingRuleSchedule paramThingRuleSchedule)
  {
    return y0("edit_schedule_rule", paramThingRuleSchedule, ThingRuleUpdateResult.class).o0(new o7(this, paramThingRuleSchedule)).E(new u7(this, paramThingRuleSchedule)).C(new s7(this));
  }
  
  public LiveData<ThingRuleAwayMode> W0()
  {
    return this.s;
  }
  
  public q<AntiTheftRuleResult> X0()
  {
    return x0("get_antitheft_rules", AntiTheftRuleResult.class).o0(new e7(this)).E(new d8(this));
  }
  
  public LiveData<ThingRuleTimer> Y0()
  {
    return this.t;
  }
  
  public q<CountdownRuleResult> Z0()
  {
    return x0("get_countdown_rules", CountdownRuleResult.class).o0(new t7(this)).E(new p7(this));
  }
  
  public q<LedInfoBean> a1()
  {
    return b1().g0(new b()).E(new a());
  }
  
  protected q<com.google.gson.i> b1()
  {
    return y0("get_led_info", null, com.google.gson.i.class).o0(new a7(this));
  }
  
  public LiveData<LedInfoBean> c1()
  {
    return this.v;
  }
  
  public int d1()
  {
    return this.r;
  }
  
  public LiveData<List<ThingRuleSchedule>> e1()
  {
    return this.p;
  }
  
  public q<List<ThingRuleSchedule>> f1()
  {
    return U0(new ScheduleRuleParams(0)).o0(new i7(this)).E(new r7(this));
  }
  
  public LiveData<Integer> i1()
  {
    return this.u;
  }
  
  public boolean j1()
  {
    boolean bool;
    if ((this.s.getValue() != null) && (((ThingRuleAwayMode)this.s.getValue()).isEnable())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean k1()
  {
    ThingRuleTimer localThingRuleTimer = (ThingRuleTimer)this.t.getValue();
    Integer localInteger = (Integer)this.u.getValue();
    boolean bool;
    if ((localThingRuleTimer != null) && (localThingRuleTimer.isEnable()) && (localInteger != null) && (localInteger.intValue() > System.currentTimeMillis() / 1000L)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public a w2(boolean paramBoolean, List<String> paramList)
  {
    return y0("remove_schedule_rules", new RuleRemoveParams(paramBoolean, paramList), Boolean.class).Z().u(new g7(this, paramBoolean, paramList)).i(new f7(this, paramList)).j(new b7(this));
  }
  
  public q<Boolean> x2(LedInfoBean paramLedInfoBean)
  {
    return y2(paramLedInfoBean).g0(new m7(this, paramLedInfoBean)).C(new y6(this)).F(new x7(this, paramLedInfoBean));
  }
  
  protected <T> q<com.google.gson.i> y2(T paramT)
  {
    return y0("set_led_info", paramT, com.google.gson.i.class).o0(new z6(this, paramT));
  }
  
  class a
    implements g<LedInfoBean>
  {
    a() {}
    
    public void a(LedInfoBean paramLedInfoBean)
      throws Exception
    {
      IoTCommonFeatureRepository.N0(IoTCommonFeatureRepository.this).postValue(paramLedInfoBean);
    }
  }
  
  class b
    implements j<com.google.gson.i, LedInfoBean>
  {
    b() {}
    
    public LedInfoBean a(com.google.gson.i parami)
      throws Exception
    {
      return (LedInfoBean)com.tplink.libtpnetwork.Utils.i.a(parami, LedInfoBean.class);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\IoTCommonFeatureRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */