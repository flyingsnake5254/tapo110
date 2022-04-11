package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.i;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.c.b.f;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.group.params.GroupThingGroupListParams;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.ListParams;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.Utils.m;
import com.tplink.libtpnetwork.exception.IoTException;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository
  extends AbstractIoTCloudRepository
{
  private f h;
  private Map<String, GroupInfo> i = new LinkedHashMap();
  private MutableLiveData<List<GroupInfo>> j = new MutableLiveData();
  
  public GroupRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.h = ((f)parama.k().R1(f.class));
  }
  
  private void C(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ((FamilyManagerRepository)b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class)).N0(Collections.singletonList(paramString));
    }
  }
  
  private io.reactivex.a D(GroupThingGroupListParams paramGroupThingGroupListParams)
  {
    return d().R(new p5(this, paramGroupThingGroupListParams));
  }
  
  private io.reactivex.a F0(final String paramString, final Map<String, Object> paramMap)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.setStateDesired(paramMap);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return z0(localArrayList, localGroupInfo).i(new n(paramString, paramMap));
  }
  
  private boolean G(GroupInfo paramGroupInfo)
  {
    boolean bool;
    if ((paramGroupInfo != null) && (!TextUtils.isEmpty(paramGroupInfo.getId()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean H(String paramString)
  {
    return TextUtils.isEmpty(paramString) ^ true;
  }
  
  private String N()
  {
    return m.a(8);
  }
  
  private q<List<GroupInfo>> Q(final ListParams paramListParams)
  {
    final ArrayList localArrayList = new ArrayList();
    return V(paramListParams).g0(new g(localArrayList, paramListParams)).w0(new f());
  }
  
  private q<PageListResult<GroupInfo>> V(final ListParams paramListParams)
  {
    return d().N(new h(paramListParams));
  }
  
  private io.reactivex.a j0(String paramString, List<String> paramList)
  {
    return d().R(new r5(this, paramString, paramList));
  }
  
  private void k0(@Nullable List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      ((FamilyManagerRepository)b.d.b.f.b.a(b.d.s.a.a.f(), FamilyManagerRepository.class)).M0();
    }
  }
  
  private void m0()
  {
    ArrayList localArrayList = new ArrayList(this.i.values());
    b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), localArrayList, "all_group_list_key", "all_group_list_key");
  }
  
  private void n0()
  {
    this.j.postValue(new ArrayList(this.i.values()));
  }
  
  private void q0(GroupInfo paramGroupInfo, AutoLightBean paramAutoLightBean)
  {
    paramGroupInfo = paramGroupInfo.getThingNames();
    if ((paramGroupInfo != null) && (!paramGroupInfo.isEmpty()))
    {
      Iterator localIterator = paramGroupInfo.iterator();
      while (localIterator.hasNext())
      {
        String str = b.d.w.h.a.g((String)localIterator.next());
        paramGroupInfo = TPIoTClientManager.I1(str);
        if ((paramGroupInfo != null) && (paramGroupInfo.isOnline())) {
          ((BulbRepository)e.d(str, BulbRepository.class)).W5(paramAutoLightBean).y();
        }
      }
    }
  }
  
  private void r0(GroupInfo paramGroupInfo, int paramInt)
  {
    paramGroupInfo = paramGroupInfo.getThingNames();
    if ((paramGroupInfo != null) && (!paramGroupInfo.isEmpty()))
    {
      Iterator localIterator = paramGroupInfo.iterator();
      while (localIterator.hasNext())
      {
        String str = b.d.w.h.a.g((String)localIterator.next());
        paramGroupInfo = TPIoTClientManager.I1(str);
        if ((paramGroupInfo != null) && (paramGroupInfo.isOnline())) {
          ((BulbRepository)e.d(str, BulbRepository.class)).X5(paramInt).y();
        }
      }
    }
  }
  
  private void s0(GroupInfo paramGroupInfo, LightStateBean paramLightStateBean)
  {
    paramGroupInfo = paramGroupInfo.getThingNames();
    if ((paramGroupInfo != null) && (!paramGroupInfo.isEmpty()))
    {
      Iterator localIterator = paramGroupInfo.iterator();
      while (localIterator.hasNext())
      {
        String str = b.d.w.h.a.g((String)localIterator.next());
        paramGroupInfo = TPIoTClientManager.I1(str);
        if ((paramGroupInfo != null) && (paramGroupInfo.isOnline())) {
          ((BulbRepository)e.d(str, BulbRepository.class)).b6(paramLightStateBean).y();
        }
      }
    }
  }
  
  private void t0(GroupInfo paramGroupInfo, boolean paramBoolean)
  {
    paramGroupInfo = paramGroupInfo.getThingNames();
    if ((paramGroupInfo != null) && (!paramGroupInfo.isEmpty()))
    {
      paramGroupInfo = paramGroupInfo.iterator();
      while (paramGroupInfo.hasNext())
      {
        String str = b.d.w.h.a.g((String)paramGroupInfo.next());
        BaseALIoTDevice localBaseALIoTDevice = TPIoTClientManager.I1(str);
        if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isOnline())) {
          ((BulbRepository)e.d(str, BulbRepository.class)).i(paramBoolean).y();
        }
      }
    }
  }
  
  private void x0(GroupInfo paramGroupInfo)
  {
    this.i.put(paramGroupInfo.getId(), paramGroupInfo);
    y0();
  }
  
  private void y0()
  {
    m0();
    n0();
  }
  
  private io.reactivex.a z0(List<String> paramList, GroupInfo paramGroupInfo)
  {
    return d().R(new n5(this, paramList, paramGroupInfo));
  }
  
  public io.reactivex.a A0(final List<String> paramList, final String paramString1, final String paramString2)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.setFamilyId(paramString1);
    localGroupInfo.setRoomId(paramString2);
    return z0(paramList, localGroupInfo).i(new a(paramList, paramString1, paramString2));
  }
  
  public io.reactivex.a B0(final String paramString1, final String paramString2)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.setAvatarUrl(paramString2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    return z0(localArrayList, localGroupInfo).i(new m(paramString1, paramString2));
  }
  
  public io.reactivex.a C0(final String paramString1, final String paramString2)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.setName(paramString2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    return z0(localArrayList, localGroupInfo).i(new p(paramString1, paramString2));
  }
  
  public io.reactivex.a D0(final String paramString, final i parami)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.setPresets(parami);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return z0(localArrayList, localGroupInfo).i(new o(paramString, parami));
  }
  
  public io.reactivex.a E(String paramString, List<String> paramList)
  {
    GroupThingGroupListParams localGroupThingGroupListParams = new GroupThingGroupListParams();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localGroupThingGroupListParams.setGroupIds(localArrayList);
    localGroupThingGroupListParams.setThingNames(paramList);
    return D(localGroupThingGroupListParams);
  }
  
  public io.reactivex.a E0(final String paramString1, final String paramString2)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.setRoomId(paramString2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    return z0(localArrayList, localGroupInfo).i(new l(paramString1, paramString2));
  }
  
  public io.reactivex.a F(List<String> paramList, String paramString)
  {
    GroupThingGroupListParams localGroupThingGroupListParams = new GroupThingGroupListParams();
    localGroupThingGroupListParams.setGroupIds(paramList);
    paramList = new ArrayList();
    paramList.add(paramString);
    localGroupThingGroupListParams.setThingNames(paramList);
    return D(localGroupThingGroupListParams);
  }
  
  public io.reactivex.a I(GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo.getId() == null) {
      paramGroupInfo.setId(N());
    }
    return d().R(new o5(this, paramGroupInfo));
  }
  
  public io.reactivex.a J(String paramString)
  {
    return d().R(new s5(this, paramString));
  }
  
  public io.reactivex.a K(List<String> paramList)
  {
    return d().R(new q5(this, paramList));
  }
  
  public io.reactivex.a L(String paramString, List<String> paramList)
  {
    return j0(paramString, paramList).i(new e());
  }
  
  public void M(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      if (!TextUtils.isEmpty(str))
      {
        Iterator localIterator2 = this.i.values().iterator();
        while (localIterator2.hasNext())
        {
          GroupInfo localGroupInfo = (GroupInfo)localIterator2.next();
          if ((localGroupInfo != null) && (!TextUtils.isEmpty(localGroupInfo.getId())))
          {
            localObject = localGroupInfo.getThingNames();
            if ((localObject != null) && (((List)localObject).contains(str))) {
              localArrayList.add(localGroupInfo.getId());
            }
          }
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    Object localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      j0((String)((Iterator)localObject).next(), paramList).y();
    }
    P().F0();
  }
  
  public List<GroupInfo> O()
  {
    if (this.i == null) {
      return new ArrayList();
    }
    return new ArrayList(this.i.values());
  }
  
  public q<List<GroupInfo>> P()
  {
    return Q(new ListParams(0)).g0(new j());
  }
  
  public GroupInfo R(String paramString)
  {
    Map localMap = this.i;
    if ((localMap != null) && (paramString != null)) {
      return (GroupInfo)localMap.get(paramString);
    }
    return null;
  }
  
  public q<GroupInfo> S(final String paramString)
  {
    return d().N(new i(paramString));
  }
  
  public MutableLiveData<List<GroupInfo>> T()
  {
    return this.j;
  }
  
  public List<GroupInfo> U(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString1)) {
      return localArrayList;
    }
    Iterator localIterator = this.i.values().iterator();
    while (localIterator.hasNext())
    {
      GroupInfo localGroupInfo = (GroupInfo)localIterator.next();
      if ((paramString1.equals(localGroupInfo.getFamilyId())) && ((localGroupInfo.getRoomId() == null) || (!localGroupInfo.getRoomId().equals(paramString2)))) {
        localArrayList.add(localGroupInfo);
      }
    }
    return localArrayList;
  }
  
  public List<GroupInfo> W(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Iterator localIterator = this.i.values().iterator();
    while (localIterator.hasNext())
    {
      GroupInfo localGroupInfo = (GroupInfo)localIterator.next();
      if (paramString.equals(localGroupInfo.getRoomId())) {
        localArrayList.add(localGroupInfo);
      }
    }
    return localArrayList;
  }
  
  public void l0()
  {
    Object localObject1 = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Object localObject2;
    try
    {
      localObject1 = b.d.w.d.a.c((String)localObject1, "all_group_list_key", "all_group_list_key", GroupInfo.class);
    }
    catch (Exception localException)
    {
      localObject2 = new ArrayList();
    }
    this.i.clear();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        GroupInfo localGroupInfo = (GroupInfo)((Iterator)localObject2).next();
        this.i.put(localGroupInfo.getId(), localGroupInfo);
      }
    }
    n0();
  }
  
  public void o0(String paramString, AutoLightBean paramAutoLightBean)
  {
    if ((H(paramString)) && (paramAutoLightBean != null))
    {
      GroupInfo localGroupInfo = (GroupInfo)this.i.get(paramString);
      if (G(localGroupInfo))
      {
        Map localMap = localGroupInfo.getStateDesired();
        paramString = localMap;
        if (localMap == null) {
          paramString = new HashMap();
        }
        paramString.put("auto_mode", paramAutoLightBean.getMode());
        paramString.put("auto", Boolean.valueOf(paramAutoLightBean.isEnable()));
        localGroupInfo.setStateDesired(paramString);
        F0(localGroupInfo.getId(), paramString).y();
        q0(localGroupInfo, paramAutoLightBean);
      }
    }
  }
  
  public void p0(String paramString, int paramInt)
  {
    if (H(paramString))
    {
      GroupInfo localGroupInfo = (GroupInfo)this.i.get(paramString);
      if (G(localGroupInfo))
      {
        Map localMap = localGroupInfo.getStateDesired();
        paramString = localMap;
        if (localMap == null) {
          paramString = new HashMap();
        }
        paramString.put("on", Boolean.TRUE);
        paramString.put("brightness", Integer.valueOf(paramInt));
        localGroupInfo.setStateDesired(paramString);
        F0(localGroupInfo.getId(), paramString).y();
        r0(localGroupInfo, paramInt);
      }
    }
  }
  
  public void u0(String paramString, boolean paramBoolean)
  {
    if (H(paramString))
    {
      GroupInfo localGroupInfo = (GroupInfo)this.i.get(paramString);
      if (G(localGroupInfo))
      {
        Map localMap = localGroupInfo.getStateDesired();
        paramString = localMap;
        if (localMap == null) {
          paramString = new HashMap();
        }
        paramString.put("on", Boolean.valueOf(paramBoolean));
        localGroupInfo.setStateDesired(paramString);
        F0(localGroupInfo.getId(), paramString).y();
        t0(localGroupInfo, paramBoolean);
      }
    }
  }
  
  public void v0(String paramString, LightStateBean paramLightStateBean)
  {
    if ((H(paramString)) && (paramLightStateBean != null))
    {
      GroupInfo localGroupInfo = (GroupInfo)this.i.get(paramString);
      if (G(localGroupInfo))
      {
        Map localMap = localGroupInfo.getStateDesired();
        paramString = localMap;
        if (localMap == null) {
          paramString = new HashMap();
        }
        paramString.put("brightness", Integer.valueOf(paramLightStateBean.getBrightness()));
        paramString.put("hue", Integer.valueOf(paramLightStateBean.getHue()));
        paramString.put("saturation", Integer.valueOf(paramLightStateBean.getSaturation()));
        paramString.put("color_temp", Integer.valueOf(paramLightStateBean.getColorTemp()));
        localGroupInfo.setStateDesired(paramString);
        F0(localGroupInfo.getId(), paramString).y();
        s0(localGroupInfo, paramLightStateBean);
      }
    }
  }
  
  public io.reactivex.a w0(final List<String> paramList, final boolean paramBoolean)
  {
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.setCommon(Boolean.valueOf(paramBoolean));
    return z0(paramList, localGroupInfo).i(new q(paramList, paramBoolean));
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a(List paramList, String paramString1, String paramString2) {}
    
    public void run()
      throws Exception
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (GroupInfo)GroupRepository.w(GroupRepository.this).get(localObject);
        if (localObject != null)
        {
          ((GroupInfo)localObject).setFamilyId(paramString1);
          ((GroupInfo)localObject).setRoomId(paramString2);
        }
      }
      GroupRepository.x(GroupRepository.this);
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b(String paramString) {}
    
    public void run()
      throws Exception
    {
      GroupRepository.w(GroupRepository.this).remove(this.a);
      GroupRepository.A(GroupRepository.this, Collections.singletonList(this.a));
      GroupRepository.x(GroupRepository.this);
    }
  }
  
  class c
    implements io.reactivex.g0.a
  {
    c(List paramList) {}
    
    public void run()
      throws Exception
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        GroupRepository.w(GroupRepository.this).remove(str);
      }
      GroupRepository.A(GroupRepository.this, this.a);
      GroupRepository.x(GroupRepository.this);
    }
  }
  
  class d
    implements io.reactivex.g0.a
  {
    d() {}
    
    public void run()
      throws Exception
    {
      GroupRepository.this.P().F0();
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e() {}
    
    public void run()
      throws Exception
    {
      GroupRepository.this.P().F0();
    }
  }
  
  class f
    implements l<Throwable>
  {
    f() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        paramThrowable = (CloudException)paramThrowable;
        if ((-2 == paramThrowable.getErrCode()) && ("DATA_RETRY".equals(paramThrowable.getMsg()))) {
          return true;
        }
      }
      boolean bool = false;
      return bool;
    }
  }
  
  class g
    implements j<PageListResult<GroupInfo>, List<GroupInfo>>
  {
    g(List paramList, ListParams paramListParams) {}
    
    public List<GroupInfo> a(PageListResult<GroupInfo> paramPageListResult)
      throws Exception
    {
      if (paramPageListResult != null)
      {
        long l = paramPageListResult.getTotal();
        if (l == 0L) {
          return new ArrayList();
        }
        if (localArrayList.size() >= l) {
          return localArrayList;
        }
        List localList = paramPageListResult.getData();
        if ((localList != null) && (!localList.isEmpty())) {
          localArrayList.addAll(localList);
        }
        if (localArrayList.size() >= l) {
          return localArrayList;
        }
        paramListParams.setPage(paramPageListResult.getPage() + 1);
        throw new CloudException(-2, "DATA_RETRY");
      }
      throw new IoTException(-1, "");
    }
  }
  
  class h
    implements j<String, t<PageListResult<GroupInfo>>>
  {
    h(ListParams paramListParams) {}
    
    public t<PageListResult<GroupInfo>> a(final String paramString)
      throws Exception
    {
      return q.f0(paramListParams).N(new a(paramString)).L0(io.reactivex.l0.a.c());
    }
    
    class a
      implements j<ListParams, t<PageListResult<GroupInfo>>>
    {
      a(String paramString) {}
      
      public t<PageListResult<GroupInfo>> a(ListParams paramListParams)
        throws Exception
      {
        return GroupRepository.y(GroupRepository.this).K1(paramString, GroupRepository.h.this.c.getPage(), 20, new String[0]);
      }
    }
  }
  
  class i
    implements j<String, t<GroupInfo>>
  {
    i(String paramString) {}
    
    public t<GroupInfo> a(String paramString)
      throws Exception
    {
      return GroupRepository.y(GroupRepository.this).K1(paramString, 0, 1, new String[] { paramString }).L0(io.reactivex.l0.a.c()).N(new b()).E(new a());
    }
    
    class a
      implements g<GroupInfo>
    {
      a() {}
      
      public void a(GroupInfo paramGroupInfo)
        throws Exception
      {
        GroupRepository.z(GroupRepository.this, paramGroupInfo);
      }
    }
    
    class b
      implements j<PageListResult<GroupInfo>, t<GroupInfo>>
    {
      b() {}
      
      public t<GroupInfo> a(PageListResult<GroupInfo> paramPageListResult)
        throws Exception
      {
        if (paramPageListResult == null) {
          return q.J(new Exception("pageListResult is null"));
        }
        paramPageListResult = paramPageListResult.getData();
        if ((paramPageListResult != null) && (!paramPageListResult.isEmpty())) {
          return q.f0(paramPageListResult.get(0));
        }
        return q.J(new Exception("groupInfoList is null"));
      }
    }
  }
  
  class j
    implements j<List<GroupInfo>, List<GroupInfo>>
  {
    j() {}
    
    public List<GroupInfo> a(List<GroupInfo> paramList)
      throws Exception
    {
      GroupRepository.w(GroupRepository.this).clear();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          GroupInfo localGroupInfo = (GroupInfo)localIterator.next();
          GroupRepository.w(GroupRepository.this).put(localGroupInfo.getId(), localGroupInfo);
        }
      }
      GroupRepository.x(GroupRepository.this);
      return paramList;
    }
  }
  
  class k
    implements io.reactivex.g0.a
  {
    k(GroupInfo paramGroupInfo) {}
    
    public void run()
      throws Exception
    {
      GroupRepository.B(GroupRepository.this, this.a.getId());
      GroupRepository.this.P().F0();
    }
  }
  
  class l
    implements io.reactivex.g0.a
  {
    l(String paramString1, String paramString2) {}
    
    public void run()
      throws Exception
    {
      GroupInfo localGroupInfo = (GroupInfo)GroupRepository.w(GroupRepository.this).get(paramString1);
      if (localGroupInfo != null) {
        localGroupInfo.setRoomId(paramString2);
      }
      GroupRepository.x(GroupRepository.this);
    }
  }
  
  class m
    implements io.reactivex.g0.a
  {
    m(String paramString1, String paramString2) {}
    
    public void run()
      throws Exception
    {
      GroupInfo localGroupInfo = (GroupInfo)GroupRepository.w(GroupRepository.this).get(paramString1);
      if (localGroupInfo != null) {
        localGroupInfo.setName(paramString2);
      }
      GroupRepository.x(GroupRepository.this);
    }
  }
  
  class n
    implements io.reactivex.g0.a
  {
    n(String paramString, Map paramMap) {}
    
    public void run()
      throws Exception
    {
      GroupInfo localGroupInfo = (GroupInfo)GroupRepository.w(GroupRepository.this).get(paramString);
      if (localGroupInfo != null) {
        localGroupInfo.setStateDesired(paramMap);
      }
      GroupRepository.x(GroupRepository.this);
    }
  }
  
  class o
    implements io.reactivex.g0.a
  {
    o(String paramString, i parami) {}
    
    public void run()
      throws Exception
    {
      GroupInfo localGroupInfo = (GroupInfo)GroupRepository.w(GroupRepository.this).get(paramString);
      if (localGroupInfo != null) {
        localGroupInfo.setPresets(parami);
      }
      GroupRepository.x(GroupRepository.this);
    }
  }
  
  class p
    implements io.reactivex.g0.a
  {
    p(String paramString1, String paramString2) {}
    
    public void run()
      throws Exception
    {
      GroupInfo localGroupInfo = (GroupInfo)GroupRepository.w(GroupRepository.this).get(paramString1);
      if (localGroupInfo != null) {
        localGroupInfo.setName(paramString2);
      }
      GroupRepository.x(GroupRepository.this);
    }
  }
  
  class q
    implements io.reactivex.g0.a
  {
    q(List paramList, boolean paramBoolean) {}
    
    public void run()
      throws Exception
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (GroupInfo)GroupRepository.w(GroupRepository.this).get(localObject);
        if (localObject != null) {
          ((GroupInfo)localObject).setCommon(Boolean.valueOf(paramBoolean));
        }
      }
      GroupRepository.x(GroupRepository.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\GroupRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */