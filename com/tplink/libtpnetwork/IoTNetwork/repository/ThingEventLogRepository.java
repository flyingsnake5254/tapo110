package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.thing.common.ThingEventLog;
import com.tplink.iot.cloud.bean.thing.result.ThingEventLogResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Lambda;

public final class ThingEventLogRepository
  extends ThingBaseRepository
{
  public static final a p = new a(null);
  private String q = "default_thing_event_log_list";
  private int r = 10;
  private final MutableLiveData<List<ThingEventLog>> s;
  private boolean t;
  private final MutableLiveData<Boolean> u;
  private final LiveData<List<ThingEventLog>> v;
  private final LiveData<Boolean> w;
  
  public ThingEventLogRepository(ThingContext paramThingContext)
  {
    super(paramThingContext);
    paramThingContext = new MutableLiveData();
    this.s = paramThingContext;
    MutableLiveData localMutableLiveData = new MutableLiveData(Boolean.valueOf(this.t));
    this.u = localMutableLiveData;
    this.v = paramThingContext;
    this.w = localMutableLiveData;
  }
  
  private final String O0(List<? extends ThingEventLog> paramList, Long paramLong)
  {
    if ((!paramList.isEmpty()) && (paramLong != null))
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      for (int i = paramList.size() - 1; (i >= 0) && (((ThingEventLog)paramList.get(i)).getTimestamp() == paramLong.longValue()); i--)
      {
        int j;
        if (localStringBuilder.length() > 0) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(((ThingEventLog)paramList.get(i)).getEventId());
      }
      paramList = localStringBuilder.toString();
      kotlin.jvm.internal.j.d(paramList, "ids.toString()");
      return paramList;
    }
    return "";
  }
  
  private final q<List<ThingEventLog>> R0(Long paramLong1, Long paramLong2, int paramInt, String paramString1, String paramString2)
  {
    ThingCloudRepository localThingCloudRepository = this.d;
    TPBaseDeviceContext localTPBaseDeviceContext = this.a;
    kotlin.jvm.internal.j.d(localTPBaseDeviceContext, "mThingContext");
    String str = ((ThingContext)localTPBaseDeviceContext).getThingUrl();
    localTPBaseDeviceContext = this.a;
    kotlin.jvm.internal.j.d(localTPBaseDeviceContext, "mThingContext");
    paramLong1 = localThingCloudRepository.h0(str, ((ThingContext)localTPBaseDeviceContext).getThingName(), paramLong1, paramLong2, paramInt, paramString1, paramString2).g0(b.c);
    kotlin.jvm.internal.j.d(paramLong1, "mThingCloudRepository.ge…emptyList()\n            }");
    return paramLong1;
  }
  
  private final q<List<ThingEventLog>> V0()
  {
    Object localObject1 = b1();
    Object localObject2 = (ThingEventLog)kotlin.collections.l.G((List)localObject1);
    if (localObject2 != null) {
      localObject2 = Long.valueOf(((ThingEventLog)localObject2).getTimestamp());
    } else {
      localObject2 = null;
    }
    localObject1 = O0((List)localObject1, (Long)localObject2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterIds: ");
    localStringBuilder.append((String)localObject1);
    b.d.w.c.a.n("ThingEventLog", localStringBuilder.toString());
    return S0(this, null, (Long)localObject2, 0, (String)localObject1, null, 21, null);
  }
  
  private final void W0(boolean paramBoolean)
  {
    this.t = paramBoolean;
    this.u.postValue(Boolean.valueOf(paramBoolean));
  }
  
  private final void X0(List<? extends ThingEventLog> paramList, boolean paramBoolean)
  {
    boolean bool = paramList.isEmpty();
    if (paramBoolean)
    {
      paramList = kotlin.collections.l.U(paramList);
    }
    else
    {
      List localList = kotlin.collections.l.U(b1());
      localList.addAll(paramList);
      paramList = localList;
    }
    a1(paramList);
    c1(paramList);
    this.s.postValue(paramList);
    W0(bool ^ true);
  }
  
  private final q<List<ThingEventLog>> Z0()
  {
    return S0(this, null, null, 0, null, null, 31, null);
  }
  
  private final void a1(List<ThingEventLog> paramList)
  {
    List localList = kotlin.sequences.g.i(kotlin.sequences.g.e(kotlin.sequences.g.f(kotlin.collections.l.t(paramList), e.c), f.c));
    paramList.clear();
    paramList.addAll(localList);
  }
  
  private final List<ThingEventLog> b1()
  {
    Object localObject1 = b.d.s.a.a.f();
    kotlin.jvm.internal.j.d(localObject1, "TPAppCloudContext.getCurrentAccountContext()");
    localObject1 = ((b)localObject1).c();
    kotlin.jvm.internal.j.d(localObject1, "TPAppCloudContext.getCur…tAccountContext().account");
    localObject1 = b.d.w.h.a.g(((TCAccountBean)localObject1).getCloudUserName());
    Object localObject2 = this.q;
    TPBaseDeviceContext localTPBaseDeviceContext = this.a;
    kotlin.jvm.internal.j.d(localTPBaseDeviceContext, "mThingContext");
    localObject1 = b.d.w.d.a.c((String)localObject1, (String)localObject2, ((ThingContext)localTPBaseDeviceContext).getDeviceIdMD5(), ThingEventLog.class);
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("restore: ");
    ((StringBuilder)localObject2).append(i.f(localObject1));
    b.d.w.c.a.n("ThingEventLog", ((StringBuilder)localObject2).toString());
    a1((List)localObject1);
    return (List<ThingEventLog>)localObject1;
  }
  
  private final void c1(List<? extends ThingEventLog> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("save: ");
    ((StringBuilder)localObject).append(i.f(paramList));
    b.d.w.c.a.n("ThingEventLog", ((StringBuilder)localObject).toString());
    localObject = b.d.s.a.a.f();
    kotlin.jvm.internal.j.d(localObject, "TPAppCloudContext.getCurrentAccountContext()");
    localObject = ((b)localObject).c();
    kotlin.jvm.internal.j.d(localObject, "TPAppCloudContext.getCur…tAccountContext().account");
    String str = b.d.w.h.a.g(((TCAccountBean)localObject).getCloudUserName());
    localObject = this.q;
    TPBaseDeviceContext localTPBaseDeviceContext = this.a;
    kotlin.jvm.internal.j.d(localTPBaseDeviceContext, "mThingContext");
    b.d.w.d.a.l(str, paramList, (String)localObject, ((ThingContext)localTPBaseDeviceContext).getDeviceIdMD5());
  }
  
  public final LiveData<Boolean> P0()
  {
    return this.w;
  }
  
  public final LiveData<List<ThingEventLog>> Q0()
  {
    return this.v;
  }
  
  public final void T0()
  {
    this.s.postValue(b1());
  }
  
  public final io.reactivex.a U0()
  {
    if (!this.t)
    {
      W0(false);
      locala = io.reactivex.a.e();
      kotlin.jvm.internal.j.d(locala, "Completable.complete()");
      return locala;
    }
    io.reactivex.a locala = V0().E(new c(this)).Z();
    kotlin.jvm.internal.j.d(locala, "loadMoreEventLogsRemotel…        .ignoreElements()");
    return locala;
  }
  
  public final io.reactivex.a Y0()
  {
    io.reactivex.a locala = Z0().E(new d(this)).Z();
    kotlin.jvm.internal.j.d(locala, "refreshEventLogsRemotely…        .ignoreElements()");
    return locala;
  }
  
  public final void d1(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "dirName");
    this.q = paramString;
  }
  
  public static final class a {}
  
  static final class b<T, R>
    implements io.reactivex.g0.j<ThingEventLogResult, List<? extends ThingEventLog>>
  {
    public static final b c = new b();
    
    public final List<ThingEventLog> a(ThingEventLogResult paramThingEventLogResult)
    {
      kotlin.jvm.internal.j.e(paramThingEventLogResult, "result");
      paramThingEventLogResult = paramThingEventLogResult.getEvents();
      if (paramThingEventLogResult == null) {
        paramThingEventLogResult = kotlin.collections.l.d();
      }
      return paramThingEventLogResult;
    }
  }
  
  static final class c<T>
    implements io.reactivex.g0.g<List<? extends ThingEventLog>>
  {
    c(ThingEventLogRepository paramThingEventLogRepository) {}
    
    public final void a(List<? extends ThingEventLog> paramList)
    {
      ThingEventLogRepository localThingEventLogRepository = this.c;
      kotlin.jvm.internal.j.d(paramList, "it");
      ThingEventLogRepository.N0(localThingEventLogRepository, paramList, false);
    }
  }
  
  static final class d<T>
    implements io.reactivex.g0.g<List<? extends ThingEventLog>>
  {
    d(ThingEventLogRepository paramThingEventLogRepository) {}
    
    public final void a(List<? extends ThingEventLog> paramList)
    {
      ThingEventLogRepository localThingEventLogRepository = this.c;
      kotlin.jvm.internal.j.d(paramList, "it");
      ThingEventLogRepository.N0(localThingEventLogRepository, paramList, true);
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.l<ThingEventLog, Boolean>
  {
    public static final e c = new e();
    
    e()
    {
      super();
    }
    
    public final boolean a(ThingEventLog paramThingEventLog)
    {
      kotlin.jvm.internal.j.e(paramThingEventLog, "it");
      paramThingEventLog = paramThingEventLog.getEventId();
      boolean bool;
      if ((paramThingEventLog != null) && (paramThingEventLog.length() != 0)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.l<ThingEventLog, String>
  {
    public static final f c = new f();
    
    f()
    {
      super();
    }
    
    public final String a(ThingEventLog paramThingEventLog)
    {
      kotlin.jvm.internal.j.e(paramThingEventLog, "it");
      return paramThingEventLog.getEventId();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\ThingEventLogRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */