package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.cloud.bean.push.params.NotificationMsgIdListParams;
import com.tplink.cloud.bean.push.params.NotificationMsgTypeListParams;
import com.tplink.cloud.bean.push.params.NotificationParams;
import com.tplink.cloud.bean.push.params.PushInfoParams;
import com.tplink.cloud.bean.push.params.SubscribeItemParams;
import com.tplink.cloud.bean.push.params.UnsubscribeMsgParams;
import com.tplink.cloud.bean.push.result.NotificationMsgListResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.push.params.IoTSubscribeMsgParams;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.SubscribeItemBean;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TCMessagePushRepository
  extends AbstractIoTCloudRepository
{
  private b.d.b.c.e h;
  private com.tplink.iot.c.b.g i;
  private final List<SubscribeItemBean> j = new ArrayList();
  private boolean k = true;
  
  public TCMessagePushRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.h = ((b.d.b.c.e)parama.d().R1(b.d.b.c.e.class));
    this.i = ((com.tplink.iot.c.b.g)parama.k().R1(com.tplink.iot.c.b.g.class));
  }
  
  private io.reactivex.a A(String paramString, IoTSubscribeMsgParams paramIoTSubscribeMsgParams)
  {
    if (!TextUtils.isEmpty(o.h0().Q())) {
      return this.i.n0(paramString, paramIoTSubscribeMsgParams);
    }
    return io.reactivex.a.e();
  }
  
  private q<NotificationMsgListResult> F(NotificationParams paramNotificationParams)
  {
    return this.h.b(new CloudParams("getAppNotificationByPage", paramNotificationParams)).L0(io.reactivex.l0.a.c()).g0(new f());
  }
  
  private boolean I(String paramString, List<SubscribeItemBean> paramList)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (paramString.equals(((SubscribeItemBean)paramList.next()).getDeviceId())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void P(List<String> paramList, List<SubscribeItemBean> paramList1)
  {
    synchronized (this.j)
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Object localObject1 = this.j.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubscribeItemBean)((Iterator)localObject1).next();
        if (paramList.contains(((SubscribeItemBean)localObject2).getDeviceId())) {
          localArrayList.add(localObject2);
        }
      }
      localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>();
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if ((str != null) && (!str.isEmpty()) && (!I(str, localArrayList)))
        {
          paramList = new com/tplink/libtpnetwork/TPCloudNetwork/bean/SubscribeItemBean;
          paramList.<init>(str);
          ((List)localObject1).add(paramList);
        }
      }
      localArrayList.addAll((Collection)localObject1);
      paramList1 = paramList1.iterator();
      for (;;)
      {
        if (!paramList1.hasNext()) {
          break label257;
        }
        localObject2 = (SubscribeItemBean)paramList1.next();
        paramList = localArrayList.iterator();
        if (paramList.hasNext())
        {
          localObject1 = (SubscribeItemBean)paramList.next();
          if (!((SubscribeItemBean)localObject1).getDeviceId().equals(((SubscribeItemBean)localObject2).getDeviceId())) {
            break;
          }
          ((SubscribeItemBean)localObject1).setDeviceSubscribeOffBit(((SubscribeItemBean)localObject2).getDeviceSubscribeOffBit());
        }
      }
      label257:
      this.j.clear();
      this.j.addAll(localArrayList);
      return;
    }
  }
  
  private IoTSubscribeMsgParams z()
  {
    synchronized (this.j)
    {
      ArrayList localArrayList1 = new java/util/ArrayList;
      localArrayList1.<init>();
      ArrayList localArrayList2 = new java/util/ArrayList;
      localArrayList2.<init>();
      Object localObject2 = this.j.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SubscribeItemBean localSubscribeItemBean = (SubscribeItemBean)((Iterator)localObject2).next();
        Object localObject3 = TPIoTClientManager.I1(b.d.w.h.a.g(localSubscribeItemBean.getDeviceId()));
        boolean bool = ((BaseALIoTDevice)localObject3).isSubDevice();
        localObject3 = ((BaseALIoTDevice)localObject3).getDeviceType();
        SubscribeItemParams localSubscribeItemParams;
        if (!bool)
        {
          localSubscribeItemParams = new com/tplink/cloud/bean/push/params/SubscribeItemParams;
          localSubscribeItemParams.<init>(localSubscribeItemBean.getDeviceId(), localSubscribeItemBean.toSubscribeList((String)localObject3));
          localArrayList1.add(localSubscribeItemParams);
        }
        else
        {
          localSubscribeItemParams = new com/tplink/cloud/bean/push/params/SubscribeItemParams;
          localSubscribeItemParams.<init>(localSubscribeItemBean.getDeviceId(), localSubscribeItemBean.toSubscribeList((String)localObject3));
          localArrayList2.add(localSubscribeItemParams);
        }
      }
      localObject2 = new com/tplink/iot/cloud/bean/push/params/IoTSubscribeMsgParams;
      ((IoTSubscribeMsgParams)localObject2).<init>(localArrayList1, localArrayList2);
      return (IoTSubscribeMsgParams)localObject2;
    }
  }
  
  public io.reactivex.a B(NotificationMsgTypeListParams paramNotificationMsgTypeListParams)
  {
    return this.h.c(new CloudParams("delAppNotification", paramNotificationMsgTypeListParams)).Z().C(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.a C(NotificationMsgIdListParams paramNotificationMsgIdListParams)
  {
    return this.h.d(new CloudParams("delAppNotificationById", paramNotificationMsgIdListParams)).Z().C(io.reactivex.l0.a.c());
  }
  
  public q<List<NotificationMsgBean>> D(final NotificationParams paramNotificationParams)
  {
    final ArrayList localArrayList = new ArrayList();
    paramNotificationParams.setIndex(0);
    return F(paramNotificationParams).g0(new e(localArrayList, paramNotificationParams)).w0(new d());
  }
  
  public SubscribeItemBean E(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (!bool)
    {
      Iterator localIterator = G().iterator();
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (SubscribeItemBean)localIterator.next();
      } while (!paramString.equals(((SubscribeItemBean)localObject2).getDeviceId()));
    }
    return (SubscribeItemBean)localObject2;
  }
  
  public List<SubscribeItemBean> G()
  {
    synchronized (this.j)
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(com.tplink.libtpnetwork.Utils.e.a((SubscribeItemBean)localIterator.next()));
      }
      return localArrayList;
    }
  }
  
  public boolean H()
  {
    b.d.b.c.e locale = this.h;
    boolean bool;
    if (((locale instanceof b.d.b.b)) && (!((b.d.b.b)locale).S1())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void L()
  {
    synchronized (this.j)
    {
      Object localObject1 = this.b.c();
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((TCAccountBean)localObject1).getCloudUserName();
      if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
      {
        this.j.clear();
        Object localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = com.tplink.libtpnetwork.Utils.s.d(((StringBuilder)localObject3).toString(), "subscribed", "subscribedInfoList", SubscribeItemBean.class);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          this.j.addAll((Collection)localObject1);
        }
        if (this.k)
        {
          this.k = false;
          if (!o.h0().d0())
          {
            o.h0().Q0();
            boolean bool1 = this.j.isEmpty();
            localObject1 = this.j.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (SubscribeItemBean)((Iterator)localObject1).next();
              boolean bool2 = bool1;
              if (((SubscribeItemBean)localObject3).isSubscribeNewFirmwareOld()) {
                bool2 = true;
              }
              bool1 = bool2;
              if (!((SubscribeItemBean)localObject3).isSubscribeCameraMotionOld())
              {
                ((SubscribeItemBean)localObject3).removeSubscribeFunc(EnumMsgSubscribeType.CAMERA_MOTION);
                bool1 = bool2;
              }
            }
            o.h0().g1(bool1);
            o.h0().i1(true);
          }
        }
        return;
      }
      return;
    }
  }
  
  public void M(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    N(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, paramString6).C(io.reactivex.l0.a.c()).y();
  }
  
  public io.reactivex.a N(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return this.h.a(new CloudParams("postPushInfo", new PushInfoParams(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, paramString6, true))).Z();
  }
  
  public void O()
  {
    synchronized (this.j)
    {
      Object localObject1 = this.b.c();
      if (localObject1 == null) {
        return;
      }
      String str = ((TCAccountBean)localObject1).getCloudUserName();
      if ((str != null) && (!str.isEmpty()))
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(str);
        com.tplink.libtpnetwork.Utils.s.k(((StringBuilder)localObject1).toString(), this.j, "subscribed", "subscribedInfoList");
        return;
      }
      return;
    }
  }
  
  public io.reactivex.a Q(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = G();
    if (((List)localObject).size() == 0)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new SubscribeItemBean((String)((Iterator)localObject).next()));
      }
    }
    localArrayList.addAll((Collection)localObject);
    return R(paramList, localArrayList);
  }
  
  public io.reactivex.a R(List<String> paramList, List<SubscribeItemBean> paramList1)
  {
    P(paramList, paramList1);
    return d().R(new h1(this)).C(io.reactivex.l0.a.c()).s().h(new a());
  }
  
  public q<Boolean> S(String paramString, SubscribeItemBean paramSubscribeItemBean)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.j)
    {
      Object localObject = this.j.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((SubscribeItemBean)((Iterator)localObject).next()).getDeviceId());
      }
      if (!localArrayList.contains(paramString)) {
        localArrayList.add(paramString);
      }
      localObject = new java/util/ArrayList;
      ((ArrayList)localObject).<init>(this.j);
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        if (((SubscribeItemBean)localIterator.next()).getDeviceId().equals(paramString)) {
          localIterator.remove();
        }
      }
      ((List)localObject).add(paramSubscribeItemBean);
      P(localArrayList, (List)localObject);
      return q.m(new c()).q0(Boolean.TRUE).L0(io.reactivex.l0.a.c()).y(new b());
    }
  }
  
  public q<Boolean> T(UnsubscribeMsgParams paramUnsubscribeMsgParams)
  {
    return this.h.e(new CloudParams("unsubscribeNotification", paramUnsubscribeMsgParams)).g0(new g()).L0(io.reactivex.l0.a.c());
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      TCMessagePushRepository.this.O();
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
    {
      TCMessagePushRepository.this.O();
    }
  }
  
  class c
    implements io.reactivex.s<Boolean>
  {
    c() {}
    
    public void subscribe(final r<Boolean> paramr)
      throws Exception
    {
      TCMessagePushRepository.w(TCMessagePushRepository.this).R(new g1(this)).C(io.reactivex.l0.a.c()).i(new b(paramr)).j(new a(paramr)).y();
    }
    
    class a
      implements io.reactivex.g0.g<Throwable>
    {
      a(r paramr) {}
      
      public void a(Throwable paramThrowable)
        throws Exception
      {
        paramr.onError(paramThrowable);
      }
    }
    
    class b
      implements io.reactivex.g0.a
    {
      b(r paramr) {}
      
      public void run()
        throws Exception
      {
        paramr.onNext(Boolean.TRUE);
        paramr.onComplete();
      }
    }
  }
  
  class d
    implements l<Throwable>
  {
    d() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        paramThrowable = (CloudException)paramThrowable;
        if ((-2 == paramThrowable.getErrCode()) && ("retry_get_data".equals(paramThrowable.getMsg()))) {
          return true;
        }
      }
      boolean bool = false;
      return bool;
    }
  }
  
  class e
    implements j<NotificationMsgListResult, List<NotificationMsgBean>>
  {
    e(List paramList, NotificationParams paramNotificationParams) {}
    
    public List<NotificationMsgBean> a(NotificationMsgListResult paramNotificationMsgListResult)
      throws Exception
    {
      if (paramNotificationMsgListResult != null)
      {
        int i = paramNotificationMsgListResult.getTotal();
        if (localArrayList.size() >= i)
        {
          Collections.reverse(localArrayList);
          return localArrayList;
        }
        List localList = paramNotificationMsgListResult.getNotifications();
        if ((localList != null) && (!localList.isEmpty())) {
          localArrayList.addAll(localList);
        }
        if ((localArrayList.size() < i) && (paramNotificationMsgListResult.isHasNextPage()))
        {
          paramNotificationParams.setIndex(localArrayList.size());
          throw new CloudException(-2, "retry_get_data");
        }
        Collections.reverse(localArrayList);
        return localArrayList;
      }
      throw new CloudException(-1, "");
    }
  }
  
  class f
    implements j<CloudResult<NotificationMsgListResult>, NotificationMsgListResult>
  {
    f() {}
    
    public NotificationMsgListResult a(CloudResult<NotificationMsgListResult> paramCloudResult)
      throws Exception
    {
      return (NotificationMsgListResult)paramCloudResult.getResult();
    }
  }
  
  class g
    implements j<CloudResult<Void>, Boolean>
  {
    g() {}
    
    public Boolean a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      boolean bool;
      if (paramCloudResult.getErrorCode() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\TCMessagePushRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */