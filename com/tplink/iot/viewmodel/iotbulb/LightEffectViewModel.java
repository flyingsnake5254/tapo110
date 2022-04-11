package com.tplink.iot.viewmodel.iotbulb;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightEffectEnableBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightEffectRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.BulbPresetDefine;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.enumerate.RuleLightEffectChangeMode;
import io.reactivex.e0.b;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LightEffectViewModel
  extends AndroidViewModel
{
  public MutableLiveData<Boolean> a = new MutableLiveData();
  public MutableLiveData<Boolean> b = new MutableLiveData();
  public MutableLiveData<Boolean> c = new MutableLiveData();
  public MutableLiveData<Boolean> d = new MutableLiveData();
  private BulbRepository e;
  private b f = new b();
  
  public LightEffectViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.e = ((BulbRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, BulbRepository.class));
  }
  
  private LightEffectRuleBean f(String paramString)
  {
    LightEffectRuleBean localLightEffectRuleBean = new LightEffectRuleBean();
    if ("L2".equals(paramString))
    {
      localLightEffectRuleBean.setId("L2");
      localLightEffectRuleBean.setChangeMode(RuleLightEffectChangeMode.MODE_BLN.getName());
      paramString = Arrays.asList(BulbPresetDefine.LIGHT_EFFECT_L2_PRESETS);
    }
    else
    {
      localLightEffectRuleBean.setId("L1");
      localLightEffectRuleBean.setChangeMode(RuleLightEffectChangeMode.MODE_DIRECT.getName());
      paramString = Arrays.asList(BulbPresetDefine.LIGHT_EFFECT_L1_PRESETS);
    }
    localLightEffectRuleBean.setChangeTime(1000L);
    localLightEffectRuleBean.setStatusList(paramString);
    return localLightEffectRuleBean;
  }
  
  private String h(String paramString)
  {
    if ("L2".equals(paramString)) {
      return AppContext.c.getString(2131953706);
    }
    return AppContext.c.getString(2131953707);
  }
  
  public void g(LightEffectRuleBean paramLightEffectRuleBean)
  {
    paramLightEffectRuleBean = this.e.i5(paramLightEffectRuleBean).F(new h(this)).y(new d(this)).H0(new g(this), new f(this));
    this.f.b(paramLightEffectRuleBean);
  }
  
  public LightEffectRuleBean i(String paramString)
  {
    ThingRuleLightEffect localThingRuleLightEffect = this.e.s5(paramString);
    if (localThingRuleLightEffect != null) {
      return new LightEffectRuleBean(localThingRuleLightEffect);
    }
    return f(paramString);
  }
  
  public String j(String paramString)
  {
    LightEffectRuleBean localLightEffectRuleBean = i(paramString);
    if (TextUtils.isEmpty(localLightEffectRuleBean.getSceneName())) {
      return h(paramString);
    }
    return localLightEffectRuleBean.getSceneName();
  }
  
  public void k()
  {
    this.e.t5().E(new c()).C(new b()).F0();
  }
  
  public LiveData<List<LightEffectRuleBean>> l()
  {
    return Transformations.map(this.e.w5(), new a());
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.f.dispose();
  }
  
  public void z(String paramString, boolean paramBoolean)
  {
    LightEffectEnableBean localLightEffectEnableBean = new LightEffectEnableBean();
    localLightEffectEnableBean.setEnable(paramBoolean);
    localLightEffectEnableBean.setId(paramString);
    this.e.a6(localLightEffectEnableBean).l(new e(this)).h(new c(this)).i(new e()).j(new d()).y();
  }
  
  class a
    implements Function<List<ThingRuleLightEffect>, List<LightEffectRuleBean>>
  {
    a() {}
    
    public List<LightEffectRuleBean> a(List<ThingRuleLightEffect> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localArrayList.add(new LightEffectRuleBean((ThingRuleLightEffect)paramList.next()));
        }
      }
      return localArrayList;
    }
  }
  
  class b
    implements io.reactivex.g0.g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable.printStackTrace();
    }
  }
  
  class c
    implements io.reactivex.g0.g<List<ThingRuleLightEffect>>
  {
    c() {}
    
    public void a(List<ThingRuleLightEffect> paramList)
      throws Exception
    {}
  }
  
  class d
    implements io.reactivex.g0.g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      LightEffectViewModel.this.b.postValue(Boolean.TRUE);
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e() {}
    
    public void run()
      throws Exception
    {
      b.d.w.c.a.a("setLightEffectEnable success");
      LightEffectViewModel.this.d.postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotbulb\LightEffectViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */