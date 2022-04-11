package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.c.b.e;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.family.common.RoomOrderInfo;
import com.tplink.iot.cloud.bean.family.params.ThingFamilyParams;
import com.tplink.iot.cloud.bean.family.result.FamilyCommonOrderResult;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.FamilyListParams;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyCommonSortBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.Utils.m;
import com.tplink.libtpnetwork.exception.IoTException;
import io.reactivex.d;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public class FamilyManagerRepository
  extends AbstractIoTCloudRepository
{
  private e h;
  private Map<String, FamilyInfo> i = new LinkedHashMap();
  private FamilyInfo j;
  private MutableLiveData<List<FamilyInfo>> k = new MutableLiveData();
  private MutableLiveData<FamilyInfo> l = new MutableLiveData();
  private final Map<String, FamilyCommonSortBean> m = new HashMap();
  private final MutableLiveData<List<String>> n = new MutableLiveData();
  private p o;
  
  public FamilyManagerRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.h = ((e)parama.k().R1(e.class));
  }
  
  private q<String> L(String paramString1, String paramString2, String paramString3)
  {
    return n1(paramString1, paramString2, paramString3, true).N(new f());
  }
  
  private List<String> L0(String paramString, @Nullable FamilyCommonSortBean paramFamilyCommonSortBean, @Nullable FamilyCommonOrderResult paramFamilyCommonOrderResult)
  {
    b.d.w.c.a.n("HomeSort", String.format("mergeLocalAndCloudSortList local: %s\ncloud: %s", new Object[] { i.j(paramFamilyCommonSortBean), i.j(paramFamilyCommonOrderResult) }));
    if ((paramFamilyCommonSortBean == null) && (paramFamilyCommonOrderResult == null)) {
      return new ArrayList();
    }
    if (paramFamilyCommonSortBean == null)
    {
      m1(paramString, paramFamilyCommonOrderResult);
      return paramFamilyCommonOrderResult.getCommonOrders();
    }
    if (paramFamilyCommonOrderResult == null) {
      return paramFamilyCommonSortBean.getSortList();
    }
    long l1 = paramFamilyCommonSortBean.getRecordTimestamp();
    long l2;
    if (paramFamilyCommonOrderResult.getRecordTimestamp() != null) {
      l2 = paramFamilyCommonOrderResult.getRecordTimestamp().longValue();
    } else {
      l2 = 0L;
    }
    if (l1 > l2)
    {
      k1(paramString, paramFamilyCommonSortBean.getSortList()).y();
      return paramFamilyCommonSortBean.getSortList();
    }
    m1(paramString, paramFamilyCommonOrderResult);
    return paramFamilyCommonOrderResult.getCommonOrders();
  }
  
  private void O(String paramString)
  {
    FamilyInfo localFamilyInfo = this.j;
    if ((localFamilyInfo != null) && (paramString != null) && (paramString.equals(localFamilyInfo.getId()))) {
      Y0();
    }
  }
  
  private io.reactivex.a P0(List<String> paramList, String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deviceIds=");
    localStringBuilder.append(i.f(paramList));
    localStringBuilder.append(", familyId=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(paramString2);
    b.d.w.c.a.e("setDeviceFamilyRoom1", localStringBuilder.toString());
    if (paramBoolean) {
      paramList = f1(paramString1, paramString2, paramList);
    } else {
      paramList = e1(paramString1, paramString2, paramList);
    }
    return paramList.i(new u0(paramBoolean));
  }
  
  private void Q(String paramString1, String paramString2)
  {
    FamilyInfo localFamilyInfo = (FamilyInfo)this.i.get(paramString1);
    if (localFamilyInfo != null)
    {
      paramString1 = localFamilyInfo.getRooms().iterator();
      while (paramString1.hasNext()) {
        if (paramString2.equals(((RoomInfo)paramString1.next()).getId())) {
          paramString1.remove();
        }
      }
      Z0();
      O(localFamilyInfo.getId());
    }
  }
  
  private String S()
  {
    return m.a(8);
  }
  
  private void U0()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveAllFamilyCommonSortListLocalCache: ");
    ((StringBuilder)localObject).append(i.f(this.m));
    b.d.w.c.a.n("HomeSort", ((StringBuilder)localObject).toString());
    localObject = new ArrayList(this.m.values());
    b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), localObject, "all_family_common_sort_list", "all_family_common_sort_list");
  }
  
  private q<List<FamilyInfo>> V(final FamilyListParams paramFamilyListParams)
  {
    final ArrayList localArrayList = new ArrayList();
    return e0(paramFamilyListParams).g0(new b(localArrayList, paramFamilyListParams)).w0(new a());
  }
  
  private void V0()
  {
    ArrayList localArrayList = new ArrayList(this.i.values());
    b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), localArrayList, "all_family_list_key", "all_family_list_key");
  }
  
  private void W0()
  {
    FamilyInfo localFamilyInfo = this.j;
    if ((localFamilyInfo != null) && (localFamilyInfo.getId() != null)) {
      b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), this.j, "current_family_key", "current_family_key");
    }
  }
  
  private void X0()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendCurrentFamilyCommonSortListEvent currentFamily: ");
    ((StringBuilder)localObject).append(i.f(this.j));
    b.d.w.c.a.n("HomeSort", ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null)
    {
      localObject = (FamilyCommonSortBean)this.m.get(((FamilyInfo)localObject).getId());
      if (localObject != null) {
        localObject = ((FamilyCommonSortBean)localObject).getSortList();
      } else {
        localObject = null;
      }
      this.n.postValue(localObject);
    }
  }
  
  private FamilyInfo Y(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.i.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        FamilyInfo localFamilyInfo = (FamilyInfo)((Iterator)localObject).next();
        if (paramString.equals(localFamilyInfo.getId())) {
          return localFamilyInfo;
        }
      }
    }
    paramString = this.i.values().iterator();
    while (paramString.hasNext())
    {
      localObject = (FamilyInfo)paramString.next();
      if (((FamilyInfo)localObject).isDefault()) {
        return (FamilyInfo)localObject;
      }
    }
    return null;
  }
  
  private void Y0()
  {
    this.l.postValue(this.j);
  }
  
  private void Z0()
  {
    this.k.postValue(new ArrayList(this.i.values()));
  }
  
  private void c1()
  {
    FamilyInfo localFamilyInfo = this.j;
    if ((localFamilyInfo != null) && (localFamilyInfo.getId() != null))
    {
      if (this.j.getId() != null) {
        this.j = Y(this.j.getId());
      }
    }
    else {
      this.j = Y(null);
    }
  }
  
  private q<FamilyCommonOrderResult> d0(final String paramString)
  {
    b.d.w.c.a.n("HomeSort", "getCommonThingOrder");
    return d().N(new d(paramString));
  }
  
  private q<PageListResult<FamilyInfo>> e0(final FamilyListParams paramFamilyListParams)
  {
    return d().N(new c(paramFamilyListParams));
  }
  
  private void g1(List<String> paramList, String paramString1, String paramString2)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      TPIoTClientManager localTPIoTClientManager = (TPIoTClientManager)b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
      new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = localTPIoTClientManager.Z1(b.d.w.h.a.g((String)paramList.next()));
        if ((localObject != null) && (((BaseALIoTDevice)localObject).getThingDevice() != null))
        {
          localObject = ((BaseALIoTDevice)localObject).getThingDevice();
          if (localObject != null)
          {
            localObject = ((ThingDevice)localObject).getThingInfo();
            if (localObject != null)
            {
              ((ThingInfo)localObject).setFamilyId(paramString1);
              ((ThingInfo)localObject).setRoomId(paramString2);
            }
          }
        }
      }
      localTPIoTClientManager.L3();
    }
  }
  
  private void i1(FamilyInfo paramFamilyInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.put(paramFamilyInfo.getId(), paramFamilyInfo);
    }
    else
    {
      FamilyInfo localFamilyInfo = (FamilyInfo)this.i.get(paramFamilyInfo.getId());
      if (localFamilyInfo != null)
      {
        localFamilyInfo.setName(paramFamilyInfo.getName());
        this.i.put(paramFamilyInfo.getId(), localFamilyInfo);
      }
    }
    l1();
  }
  
  private io.reactivex.a k1(String paramString, List<String> paramList)
  {
    return d().R(new q0(this, paramList, paramString));
  }
  
  private void l1()
  {
    c1();
    W0();
    V0();
    Z0();
    Y0();
  }
  
  private void m1(String paramString, @NonNull FamilyCommonOrderResult paramFamilyCommonOrderResult)
  {
    paramFamilyCommonOrderResult = new FamilyCommonSortBean(paramString, paramFamilyCommonOrderResult);
    this.m.put(paramString, paramFamilyCommonOrderResult);
    U0();
  }
  
  private void o1(String paramString, RoomInfo paramRoomInfo, boolean paramBoolean)
  {
    FamilyInfo localFamilyInfo = (FamilyInfo)this.i.get(paramString);
    if (localFamilyInfo != null)
    {
      List localList = localFamilyInfo.getRooms();
      Object localObject;
      if (paramBoolean)
      {
        localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(paramRoomInfo);
        localFamilyInfo.setRooms((List)localObject);
        this.i.put(paramString, localFamilyInfo);
      }
      else if (localList != null)
      {
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramString = (RoomInfo)((Iterator)localObject).next();
          if (paramString.getId().equals(paramRoomInfo.getId())) {
            paramString.setName(paramRoomInfo.getName());
          }
        }
      }
    }
    l1();
  }
  
  private void q1(String paramString, final List<String> paramList)
  {
    paramString = (FamilyInfo)this.i.get(paramString);
    if ((paramString != null) && (paramString.getRooms() != null))
    {
      Collections.sort(paramString.getRooms(), new o(paramList));
      Z0();
      O(paramString.getId());
    }
  }
  
  public io.reactivex.a M(final List<String> paramList, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    return io.reactivex.a.g(new e(paramBoolean1, paramString1, paramString2, paramString3, paramList, paramBoolean2)).C(io.reactivex.l0.a.c());
  }
  
  public void M0()
  {
    p localp = this.o;
    if (localp != null) {
      localp.e();
    }
  }
  
  public q<FamilyInfo> N(final String paramString)
  {
    return U().g0(new i(paramString)).C(new h(paramString));
  }
  
  public void N0(@Nullable List<String> paramList)
  {
    if ((this.o != null) && (paramList != null) && (!paramList.isEmpty())) {
      this.o.b(paramList);
    }
  }
  
  public void O0(@Nullable List<String> paramList)
  {
    if ((this.o != null) && (paramList != null) && (!paramList.isEmpty())) {
      this.o.a(paramList);
    }
  }
  
  public io.reactivex.a P(String paramString)
  {
    return d().R(new n0(this, paramString));
  }
  
  public void Q0(@Nullable List<String> paramList1, @Nullable List<String> paramList2)
  {
    Object localObject1 = new HashSet();
    Object localObject2;
    FamilyCommonSortBean localFamilyCommonSortBean;
    if ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        localObject2 = this.m.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFamilyCommonSortBean = (FamilyCommonSortBean)((Iterator)localObject2).next();
          if (localFamilyCommonSortBean.removeDevice(str)) {
            ((Set)localObject1).add(localFamilyCommonSortBean.getFamilyId());
          }
        }
      }
    }
    if ((paramList2 != null) && (!paramList2.isEmpty()))
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        localObject2 = (String)paramList2.next();
        paramList1 = this.m.values().iterator();
        while (paramList1.hasNext())
        {
          localFamilyCommonSortBean = (FamilyCommonSortBean)paramList1.next();
          if (localFamilyCommonSortBean.removeGroup((String)localObject2)) {
            ((Set)localObject1).add(localFamilyCommonSortBean.getFamilyId());
          }
        }
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      paramList1 = ((Set)localObject1).iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        localObject1 = (FamilyCommonSortBean)this.m.get(paramList2);
        if ((localObject1 != null) && (((FamilyCommonSortBean)localObject1).getSortList() != null))
        {
          ((FamilyCommonSortBean)localObject1).updateRecordTimestampNow();
          k1(paramList2, ((FamilyCommonSortBean)localObject1).getSortList()).y();
        }
      }
      U0();
    }
    b.d.w.c.a.n("HomeSort", String.format("removeDeviceGroupSortIdsFromAllFamily after change: %s", new Object[] { i.j(this.m) }));
  }
  
  public io.reactivex.a R(String paramString1, String paramString2)
  {
    return d().R(new x0(this, paramString1, paramString2));
  }
  
  public void R0()
  {
    Object localObject1 = b.d.w.h.a.g(this.b.c().getCloudUserName());
    try
    {
      localObject1 = b.d.w.d.a.c((String)localObject1, "all_family_common_sort_list", "all_family_common_sort_list", FamilyCommonSortBean.class);
    }
    catch (Exception localException)
    {
      localObject2 = new ArrayList();
    }
    this.m.clear();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (FamilyCommonSortBean)localIterator.next();
        this.m.put(((FamilyCommonSortBean)localObject2).getFamilyId(), localObject2);
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("restoreAllFamilyCommonSortListLocalCache: ");
    ((StringBuilder)localObject2).append(i.f(this.m));
    b.d.w.c.a.n("HomeSort", ((StringBuilder)localObject2).toString());
    X0();
  }
  
  public void S0()
  {
    Object localObject1 = b.d.w.h.a.g(this.b.c().getCloudUserName());
    Object localObject2;
    try
    {
      localObject1 = b.d.w.d.a.c((String)localObject1, "all_family_list_key", "all_family_list_key", FamilyInfo.class);
    }
    catch (Exception localException)
    {
      localObject2 = new ArrayList();
    }
    this.i.clear();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (FamilyInfo)localIterator.next();
        this.i.put(((FamilyInfo)localObject2).getId(), localObject2);
      }
    }
    Z0();
  }
  
  public List<FamilyInfo> T()
  {
    if (this.i == null) {
      return new ArrayList();
    }
    return new ArrayList(this.i.values());
  }
  
  public void T0()
  {
    FamilyInfo localFamilyInfo = (FamilyInfo)b.d.w.d.a.b(b.d.w.h.a.g(this.b.c().getCloudUserName()), "current_family_key", "current_family_key", FamilyInfo.class);
    if ((localFamilyInfo != null) && (localFamilyInfo.getId() != null))
    {
      this.j = localFamilyInfo;
      Y0();
    }
  }
  
  public q<List<FamilyInfo>> U()
  {
    return V(new FamilyListParams(0)).g0(new g());
  }
  
  public q<List<String>> W(String paramString)
  {
    b.d.w.c.a.n("HomeSort", "getCommonDeviceGroupSortList");
    FamilyCommonSortBean localFamilyCommonSortBean = (FamilyCommonSortBean)this.m.get(paramString);
    q localq = d0(paramString).g0(new s0(this, paramString, localFamilyCommonSortBean));
    if ((localFamilyCommonSortBean != null) && (localFamilyCommonSortBean.getSortList() != null)) {
      paramString = localFamilyCommonSortBean.getSortList();
    } else {
      paramString = new ArrayList();
    }
    return localq.q0(paramString);
  }
  
  public FamilyInfo X()
  {
    return this.j;
  }
  
  public void Z()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCurrentFamilyCommonOrderAndSend currentFamily: ");
    ((StringBuilder)localObject).append(i.f(this.j));
    b.d.w.c.a.n("HomeSort", ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null) {
      W(((FamilyInfo)localObject).getId()).E(new o0(this)).C(new y0(this)).F0();
    }
  }
  
  public MutableLiveData<List<String>> a0()
  {
    return this.n;
  }
  
  public void a1(p paramp)
  {
    this.o = paramp;
  }
  
  @Nullable
  public List<String> b0()
  {
    Object localObject1 = this.j;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    if (localObject1 != null)
    {
      localObject1 = (FamilyCommonSortBean)this.m.get(((FamilyInfo)localObject1).getId());
      localObject3 = localObject2;
      if (localObject1 != null) {
        localObject3 = ((FamilyCommonSortBean)localObject1).getSortList();
      }
    }
    return (List<String>)localObject3;
  }
  
  public io.reactivex.a b1(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return M(Collections.singletonList(paramString1), paramString2, paramString3, paramString4, paramBoolean1, paramBoolean2);
  }
  
  public MutableLiveData<FamilyInfo> c0()
  {
    return this.l;
  }
  
  public io.reactivex.a d1(String paramString1, String paramString2, List<DeviceBean> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((DeviceBean)paramList.next()).getDeviceId());
    }
    paramString1 = new ThingFamilyParams(paramString1, paramString2, localArrayList);
    return d().R(new z0(this, paramString1));
  }
  
  public io.reactivex.a e1(String paramString1, String paramString2, List<String> paramList)
  {
    ThingFamilyParams localThingFamilyParams = new ThingFamilyParams(paramString1, paramString2, paramList);
    return d().R(new t0(this, localThingFamilyParams, paramList, paramString1, paramString2));
  }
  
  public String f0(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (FamilyInfo)this.i.get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getRooms().iterator();
        while (paramString1.hasNext())
        {
          RoomInfo localRoomInfo = (RoomInfo)paramString1.next();
          if (paramString2.equals(localRoomInfo.getId())) {
            return localRoomInfo.getName();
          }
        }
      }
    }
    return null;
  }
  
  public io.reactivex.a f1(String paramString1, String paramString2, List<String> paramList)
  {
    ThingFamilyParams localThingFamilyParams = new ThingFamilyParams(paramString1, paramString2, paramList);
    return d().R(new w0(this, localThingFamilyParams, paramList, paramString1, paramString2));
  }
  
  public boolean g0(FamilyInfo paramFamilyInfo)
  {
    if ((this.j != null) && (paramFamilyInfo != null))
    {
      if (TextUtils.isEmpty(paramFamilyInfo.getId())) {
        return this.j.isDefault();
      }
      return paramFamilyInfo.getId().equals(this.j.getId());
    }
    return false;
  }
  
  public boolean h0(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (paramBoolean1) {
      return paramBoolean3;
    }
    boolean bool = true;
    paramBoolean1 = true;
    if (!paramBoolean2) {
      return true;
    }
    if (this.j == null) {
      return true;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if ((!this.j.isDefault()) || (!paramBoolean3)) {
        paramBoolean1 = false;
      }
      return paramBoolean1;
    }
    if ((paramString.equals(this.j.getId())) && (paramBoolean3)) {
      paramBoolean1 = bool;
    } else {
      paramBoolean1 = false;
    }
    return paramBoolean1;
  }
  
  public q<FamilyBean> h1(final String paramString1, String paramString2, final boolean paramBoolean)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = S();
    }
    paramString1 = new FamilyInfo(str, paramString2);
    return d().N(new j(paramString1, paramBoolean));
  }
  
  public boolean i0(boolean paramBoolean, String paramString)
  {
    FamilyInfo localFamilyInfo = this.j;
    boolean bool1 = true;
    boolean bool2 = true;
    if (localFamilyInfo == null) {
      return true;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if ((this.j.isDefault()) && (paramBoolean)) {
        paramBoolean = bool2;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
    if ((paramString.equals(this.j.getId())) && (paramBoolean)) {
      paramBoolean = bool1;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public boolean j0(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      return true;
    }
    if (!paramBoolean2) {
      return true;
    }
    if (this.j == null) {
      return true;
    }
    if (TextUtils.isEmpty(paramString)) {
      return this.j.isDefault();
    }
    return paramString.equals(this.j.getId());
  }
  
  public io.reactivex.a j1(String paramString, List<String> paramList)
  {
    FamilyCommonSortBean localFamilyCommonSortBean = (FamilyCommonSortBean)this.m.get(paramString);
    if (localFamilyCommonSortBean == null)
    {
      localFamilyCommonSortBean = new FamilyCommonSortBean(paramString, paramList, System.currentTimeMillis());
      this.m.put(paramString, localFamilyCommonSortBean);
    }
    else
    {
      localFamilyCommonSortBean.updateRecordTimestampNow();
      localFamilyCommonSortBean.setSortList(paramList);
    }
    U0();
    return k1(paramString, paramList);
  }
  
  public boolean k0(String paramString)
  {
    if (this.j == null) {
      return true;
    }
    if (TextUtils.isEmpty(paramString)) {
      return this.j.isDefault();
    }
    return paramString.equals(this.j.getId());
  }
  
  public boolean l0()
  {
    Map localMap = this.i;
    boolean bool;
    if ((localMap != null) && (!localMap.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public q<RoomBean> n1(@Nullable final String paramString1, final String paramString2, @Nullable final String paramString3, final boolean paramBoolean)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = S();
    }
    paramString2 = new RoomInfo();
    paramString2.setId(str);
    paramString2.setName(paramString3);
    return d().N(new l(paramString1, paramString2, paramBoolean, paramString3));
  }
  
  public io.reactivex.a p1(String paramString, List<String> paramList)
  {
    RoomOrderInfo localRoomOrderInfo = new RoomOrderInfo();
    localRoomOrderInfo.setRoomIds(paramList);
    return d().R(new r0(this, paramString, localRoomOrderInfo, paramList));
  }
  
  class a
    implements l<Throwable>
  {
    a() {}
    
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
  
  class b
    implements j<PageListResult<FamilyInfo>, List<FamilyInfo>>
  {
    b(List paramList, FamilyListParams paramFamilyListParams) {}
    
    public List<FamilyInfo> a(PageListResult<FamilyInfo> paramPageListResult)
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
        paramFamilyListParams.setPage(paramPageListResult.getPage() + 1);
        throw new CloudException(-2, "DATA_RETRY");
      }
      throw new IoTException(-1, "");
    }
  }
  
  class c
    implements j<String, t<PageListResult<FamilyInfo>>>
  {
    c(FamilyListParams paramFamilyListParams) {}
    
    public t<PageListResult<FamilyInfo>> a(final String paramString)
      throws Exception
    {
      return q.f0(paramFamilyListParams).N(new a(paramString)).L0(io.reactivex.l0.a.c());
    }
    
    class a
      implements j<FamilyListParams, t<PageListResult<FamilyInfo>>>
    {
      a(String paramString) {}
      
      public t<PageListResult<FamilyInfo>> a(FamilyListParams paramFamilyListParams)
        throws Exception
      {
        return FamilyManagerRepository.J(FamilyManagerRepository.this).j0(paramString, FamilyManagerRepository.c.this.c.getPage(), 20);
      }
    }
  }
  
  class d
    implements j<String, t<FamilyCommonOrderResult>>
  {
    d(String paramString) {}
    
    public t<FamilyCommonOrderResult> a(String paramString)
      throws Exception
    {
      return FamilyManagerRepository.J(FamilyManagerRepository.this).L0(paramString, paramString).L0(io.reactivex.l0.a.c());
    }
  }
  
  class e
    implements d
  {
    e(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, List paramList, boolean paramBoolean2) {}
    
    public void a(final io.reactivex.b paramb)
      throws Exception
    {
      q.X(new d()).N(new c()).E(new b(paramb)).C(new a(paramb)).F0();
    }
    
    class a
      implements g<Throwable>
    {
      a(io.reactivex.b paramb) {}
      
      public void a(Throwable paramThrowable)
        throws Exception
      {
        paramb.onError(paramThrowable);
      }
    }
    
    class b
      implements g<String>
    {
      b(io.reactivex.b paramb) {}
      
      public void a(String paramString)
        throws Exception
      {
        FamilyManagerRepository.e locale = FamilyManagerRepository.e.this;
        FamilyManagerRepository.y(locale.g, locale.e, locale.b, paramString, locale.f).i(new b()).j(new a()).y();
      }
      
      class a
        implements g<Throwable>
      {
        a() {}
        
        public void a(Throwable paramThrowable)
          throws Exception
        {
          FamilyManagerRepository.e.b.this.c.onError(paramThrowable);
        }
      }
      
      class b
        implements io.reactivex.g0.a
      {
        b() {}
        
        public void run()
          throws Exception
        {
          FamilyManagerRepository.e.b.this.c.onComplete();
        }
      }
    }
    
    class c
      implements j<Boolean, t<String>>
    {
      c() {}
      
      public t<String> a(Boolean paramBoolean)
        throws Exception
      {
        if (paramBoolean.booleanValue())
        {
          paramBoolean = FamilyManagerRepository.e.this;
          return FamilyManagerRepository.z(paramBoolean.g, paramBoolean.b, paramBoolean.c, paramBoolean.d);
        }
        b.d.w.c.a.e("setDeviceFamilyRoom", "房间已存在");
        return q.f0(FamilyManagerRepository.e.this.c);
      }
    }
    
    class d
      implements Callable<Boolean>
    {
      d() {}
      
      public Boolean a()
        throws Exception
      {
        return Boolean.valueOf(FamilyManagerRepository.e.this.a);
      }
    }
  }
  
  class f
    implements j<RoomBean, t<String>>
  {
    f() {}
    
    public t<String> a(RoomBean paramRoomBean)
      throws Exception
    {
      if ((paramRoomBean != null) && (!TextUtils.isEmpty(paramRoomBean.getRoomId())))
      {
        b.d.w.c.a.e("setDeviceFamilyRoom", "addNewRoom success");
        return q.f0(paramRoomBean.getRoomId());
      }
      throw new CloudException();
    }
  }
  
  class g
    implements j<List<FamilyInfo>, List<FamilyInfo>>
  {
    g() {}
    
    public List<FamilyInfo> a(List<FamilyInfo> paramList)
      throws Exception
    {
      FamilyManagerRepository.w(FamilyManagerRepository.this).clear();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          FamilyInfo localFamilyInfo = (FamilyInfo)localIterator.next();
          FamilyManagerRepository.w(FamilyManagerRepository.this).put(localFamilyInfo.getId(), localFamilyInfo);
        }
      }
      FamilyManagerRepository.x(FamilyManagerRepository.this);
      return paramList;
    }
  }
  
  class h
    implements g<Throwable>
  {
    h(String paramString) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable = FamilyManagerRepository.this;
      FamilyManagerRepository.D(paramThrowable, FamilyManagerRepository.E(paramThrowable, paramString));
      FamilyManagerRepository.F(FamilyManagerRepository.this);
      FamilyManagerRepository.G(FamilyManagerRepository.this);
      FamilyManagerRepository.H(FamilyManagerRepository.this);
      FamilyManagerRepository.this.Z();
    }
  }
  
  class i
    implements j<List<FamilyInfo>, FamilyInfo>
  {
    i(String paramString) {}
    
    public FamilyInfo a(List<FamilyInfo> paramList)
      throws Exception
    {
      paramList = FamilyManagerRepository.this;
      FamilyManagerRepository.D(paramList, FamilyManagerRepository.E(paramList, paramString));
      FamilyManagerRepository.F(FamilyManagerRepository.this);
      FamilyManagerRepository.G(FamilyManagerRepository.this);
      FamilyManagerRepository.H(FamilyManagerRepository.this);
      FamilyManagerRepository.this.Z();
      return FamilyManagerRepository.C(FamilyManagerRepository.this);
    }
  }
  
  class j
    implements j<String, t<FamilyBean>>
  {
    j(FamilyInfo paramFamilyInfo, boolean paramBoolean) {}
    
    public t<FamilyBean> a(String paramString)
      throws Exception
    {
      return FamilyManagerRepository.J(FamilyManagerRepository.this).m0(paramString, paramString1).L0(io.reactivex.l0.a.c()).g0(new a());
    }
    
    class a
      implements j<FamilyInfo, FamilyBean>
    {
      a() {}
      
      public FamilyBean a(FamilyInfo paramFamilyInfo)
      {
        FamilyBean localFamilyBean = new FamilyBean();
        if (paramFamilyInfo != null)
        {
          if (FamilyManagerRepository.j.this.d)
          {
            localFamilyBean.setFamilyId(paramFamilyInfo.getId());
            localFamilyBean.setFamilyName(paramFamilyInfo.getName());
          }
          else
          {
            localFamilyBean.setFamilyName(paramFamilyInfo.getName());
          }
          FamilyManagerRepository.j localj = FamilyManagerRepository.j.this;
          FamilyManagerRepository.I(localj.f, paramFamilyInfo, localj.d);
        }
        return localFamilyBean;
      }
    }
  }
  
  class k
    implements io.reactivex.g0.a
  {
    k(String paramString) {}
    
    public void run()
      throws Exception
    {
      FamilyManagerRepository.w(FamilyManagerRepository.this).remove(this.a);
      FamilyManagerRepository.x(FamilyManagerRepository.this);
    }
  }
  
  class l
    implements j<String, t<RoomBean>>
  {
    l(String paramString1, RoomInfo paramRoomInfo, boolean paramBoolean, String paramString2) {}
    
    public t<RoomBean> a(String paramString)
      throws Exception
    {
      return FamilyManagerRepository.J(FamilyManagerRepository.this).R(paramString, paramString1, paramString2).L0(io.reactivex.l0.a.c()).g0(new a());
    }
    
    class a
      implements j<RoomInfo, RoomBean>
    {
      a() {}
      
      public RoomBean a(RoomInfo paramRoomInfo)
      {
        RoomBean localRoomBean = new RoomBean();
        if (paramRoomInfo != null)
        {
          FamilyManagerRepository.l locall = FamilyManagerRepository.l.this;
          if (locall.f)
          {
            localRoomBean.setRoomId(paramRoomInfo.getId());
            localRoomBean.setRoomName(paramRoomInfo.getName());
            localRoomBean.setAvatarUrl(paramRoomInfo.getAvatarUrl());
          }
          else
          {
            localRoomBean.setRoomName(locall.q);
          }
          locall = FamilyManagerRepository.l.this;
          FamilyManagerRepository.K(locall.x, locall.c, paramRoomInfo, locall.f);
        }
        return localRoomBean;
      }
    }
  }
  
  class m
    implements io.reactivex.g0.a
  {
    m(String paramString1, String paramString2) {}
    
    public void run()
    {
      FamilyManagerRepository.B(FamilyManagerRepository.this, this.a, this.b);
    }
  }
  
  class n
    implements io.reactivex.g0.a
  {
    n(String paramString, List paramList) {}
    
    public void run()
    {
      FamilyManagerRepository.A(FamilyManagerRepository.this, this.a, this.b);
    }
  }
  
  class o
    implements Comparator<RoomInfo>
  {
    o(List paramList) {}
    
    public int a(RoomInfo paramRoomInfo1, RoomInfo paramRoomInfo2)
    {
      return paramList.indexOf(paramRoomInfo1.getId()) - paramList.indexOf(paramRoomInfo2.getId());
    }
  }
  
  public static abstract interface p
  {
    public abstract void a(@NonNull List<String> paramList);
    
    public abstract void b(@NonNull List<String> paramList);
    
    public abstract void e();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\FamilyManagerRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */