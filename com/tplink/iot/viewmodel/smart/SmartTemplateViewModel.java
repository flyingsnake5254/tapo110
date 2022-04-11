package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.google.gson.Gson;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.model.about.d;
import com.tplink.iot.model.smart.SmartTemplateBaseBean;
import com.tplink.iot.model.smart.SmartTemplateEntityBean;
import com.tplink.iot.model.smart.SmartTemplateTitleBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import io.reactivex.q;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmartTemplateViewModel
  extends AndroidViewModel
{
  private SmartRepository a;
  private List<SmartTemplate> b = new ArrayList();
  private MediatorLiveData<List<SmartTemplateBaseBean>> c = new MediatorLiveData();
  private List<SmartTemplateBaseBean> d = new ArrayList();
  
  public SmartTemplateViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = (SmartRepository)b.a(b.d.s.a.a.f(), SmartRepository.class);
    this.a = paramApplication;
    this.c.addSource(paramApplication.m0(), new o(this));
    this.c.addSource(this.a.W(), new n(this));
  }
  
  private List<SmartTemplate> i()
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      Object localObject2 = getApplication().getAssets().open("smart_template_list.json");
      Object localObject3 = new java/io/BufferedReader;
      InputStreamReader localInputStreamReader = new java/io/InputStreamReader;
      localInputStreamReader.<init>((InputStream)localObject2);
      ((BufferedReader)localObject3).<init>(localInputStreamReader);
      for (;;)
      {
        localObject2 = ((BufferedReader)localObject3).readLine();
        if (localObject2 == null) {
          break;
        }
        ((StringBuilder)localObject1).append((String)localObject2);
      }
      localObject3 = new com/google/gson/Gson;
      ((Gson)localObject3).<init>();
      localObject2 = new com/tplink/iot/viewmodel/smart/SmartTemplateViewModel$a;
      ((a)localObject2).<init>(this);
      localObject2 = ((com.google.gson.r.a)localObject2).getType();
      localObject1 = (List)((Map)((Gson)localObject3).m(((StringBuilder)localObject1).toString(), (Type)localObject2)).get("templates");
      if (localObject1 != null) {
        localArrayList.addAll((Collection)localObject1);
      }
      localObject2 = getApplication().getResources().getStringArray(2130903051);
      localObject1 = getApplication().getResources().getStringArray(2130903052);
      localObject3 = getApplication().getResources().getStringArray(2130903050);
      for (int i = 0; (i < localArrayList.size()) && (i < localObject2.length) && (i < localObject1.length) && (i < localObject3.length); i++)
      {
        ((SmartTemplate)localArrayList.get(i)).setName(localObject2[i]);
        ((SmartTemplate)localArrayList.get(i)).setTitle(localObject1[i]);
        ((SmartTemplate)localArrayList.get(i)).setSubTitle(localObject3[i]);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void o(List<SmartTemplate> paramList)
  {
    this.d.clear();
    this.b.clear();
    Object localObject1;
    if (paramList != null)
    {
      localObject1 = paramList;
      if (!paramList.isEmpty()) {}
    }
    else
    {
      localObject1 = i();
    }
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (SmartTemplate)((Iterator)localObject2).next();
      if (((SmartTemplate)localObject1).getTriggerSetting() != null) {
        if (((SmartTemplate)localObject1).getTriggerSetting().isManual()) {
          localArrayList.add(new SmartTemplateEntityBean((SmartTemplate)localObject1));
        } else {
          paramList.add(new SmartTemplateEntityBean((SmartTemplate)localObject1));
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SmartTemplateBaseBean)((Iterator)localObject1).next();
        this.b.add(((SmartTemplateEntityBean)localObject2).getEntity());
      }
    }
    if (!paramList.isEmpty())
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SmartTemplateBaseBean)((Iterator)localObject1).next();
        this.b.add(((SmartTemplateEntityBean)localObject2).getEntity());
      }
    }
    if (!localArrayList.isEmpty()) {
      localArrayList.add(0, new SmartTemplateTitleBean(getApplication().getString(2131954059).toUpperCase()));
    }
    if (!paramList.isEmpty()) {
      paramList.add(0, new SmartTemplateTitleBean(getApplication().getString(2131954028).toUpperCase()));
    }
    this.d.addAll(localArrayList);
    this.d.addAll(paramList);
    this.c.postValue(this.d);
  }
  
  public void f()
  {
    this.a.Q().F0();
  }
  
  public void g()
  {
    this.a.U(d.f()).F0();
  }
  
  public MutableLiveData<List<ThingInfo>> h()
  {
    return this.a.W();
  }
  
  public List<SmartTemplate> j()
  {
    return this.b;
  }
  
  public LiveData<List<SmartTemplateBaseBean>> k()
  {
    return this.c;
  }
  
  class a
    extends com.google.gson.r.a<Map<String, List<SmartTemplate>>>
  {
    a() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\SmartTemplateViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */