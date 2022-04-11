package com.tplink.iot.model.notification;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.push.EnumNotificationDirection;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.cloud.bean.push.params.NotificationMsgIdListParams;
import com.tplink.cloud.bean.push.params.NotificationMsgIdParams;
import com.tplink.cloud.bean.push.params.NotificationMsgTypeListParams;
import com.tplink.cloud.bean.push.params.NotificationMsgTypeParams;
import com.tplink.cloud.bean.push.params.NotificationParams;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.s;
import com.tplink.iot.core.n;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.NotificationMsgCacheBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCMessagePushRepository;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.enumerate.EnumNotificationMsgType;
import io.reactivex.d;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NotificationCenterManager
  extends b.d.b.f.a
{
  private static Comparator<NotificationMsgBean> c = new c();
  private TCMessagePushRepository d;
  private MutableLiveData<List<NotificationMsgBean>> e = new MutableLiveData();
  private MutableLiveData<Boolean> f = new MutableLiveData();
  private MutableLiveData<Boolean> g = new MutableLiveData();
  private long h = -1L;
  private boolean i = false;
  private Map<String, NotificationMsgBean> j = Collections.synchronizedMap(new LinkedHashMap());
  private Map<String, NotificationMsgBean> k = Collections.synchronizedMap(new LinkedHashMap());
  private String l;
  private Set<String> m = new HashSet();
  private AtomicInteger n = new AtomicInteger(0);
  
  public NotificationCenterManager(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.d = ((TCMessagePushRepository)b.d.b.f.b.a(paramb, TCMessagePushRepository.class));
    P();
  }
  
  private boolean A(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    return B(paramNotificationMsgBean, paramInt, paramLong);
  }
  
  private boolean B(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    boolean bool;
    if ((paramInt < 128) && (J(paramLong, paramNotificationMsgBean.getTime())) && (this.j.get(paramNotificationMsgBean.getMsgId()) == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean C(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    boolean bool;
    if ((paramInt < 32) && (J(paramLong, paramNotificationMsgBean.getTime())) && (this.j.get(paramNotificationMsgBean.getMsgId()) == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean D(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    boolean bool;
    if ((paramInt < 64) && (I(paramLong, paramNotificationMsgBean.getTime())) && (this.j.get(paramNotificationMsgBean.getMsgId()) == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean E(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    boolean bool;
    if ((paramInt < 64) && (J(paramLong, paramNotificationMsgBean.getTime())) && (this.j.get(paramNotificationMsgBean.getMsgId()) == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean F(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    return B(paramNotificationMsgBean, paramInt, paramLong);
  }
  
  private boolean G(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    return C(paramNotificationMsgBean, paramInt, paramLong);
  }
  
  private boolean H(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    return C(paramNotificationMsgBean, paramInt, paramLong);
  }
  
  private boolean I(long paramLong1, long paramLong2)
  {
    boolean bool;
    if (paramLong1 - paramLong2 < 2592000000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean J(long paramLong1, long paramLong2)
  {
    boolean bool;
    if (paramLong1 - paramLong2 < 432000000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean K(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    return C(paramNotificationMsgBean, paramInt, paramLong);
  }
  
  private void N(List<NotificationMsgBean> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (paramList.isEmpty())
    {
      paramList = new ArrayList(this.j.values()).iterator();
      while (paramList.hasNext()) {
        ((NotificationMsgBean)paramList.next()).setReadFlag(true);
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      NotificationMsgBean localNotificationMsgBean = (NotificationMsgBean)paramList.next();
      if ((localNotificationMsgBean != null) && (!TextUtils.isEmpty(localNotificationMsgBean.getMsgId())))
      {
        localNotificationMsgBean = (NotificationMsgBean)this.j.get(localNotificationMsgBean.getMsgId());
        if (localNotificationMsgBean != null) {
          localNotificationMsgBean.setReadFlag(true);
        }
      }
    }
    O();
  }
  
  private void O()
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(this.j.values());
      this.k.clear();
      int i1 = 1;
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        NotificationMsgBean localNotificationMsgBean = (NotificationMsgBean)localIterator.next();
        if ((localNotificationMsgBean != null) && (!TextUtils.isEmpty(localNotificationMsgBean.getMsgId())))
        {
          this.k.put(localNotificationMsgBean.getMsgId(), localNotificationMsgBean);
          if (i1 != 0)
          {
            this.h = localNotificationMsgBean.getTime();
            i1 = 0;
          }
        }
      }
      Q(localArrayList);
      S(localArrayList);
      this.e.postValue(localArrayList);
      return;
    }
    finally {}
  }
  
  private void P()
  {
    Object localObject1 = this.b.c();
    if (localObject1 != null) {
      localObject1 = ((TCAccountBean)localObject1).getCloudUserName();
    } else {
      localObject1 = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    localObject1 = b.d.w.h.a.g((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject2;
    try
    {
      localObject1 = (NotificationMsgCacheBean)b.d.w.d.a.b((String)localObject1, "account_notification_msg_cache_list_key2", "account_notification_msg_cache_list_key2", NotificationMsgCacheBean.class);
    }
    catch (Exception localException)
    {
      localObject2 = new NotificationMsgCacheBean();
    }
    if ((localObject2 != null) && (!s.b(((NotificationMsgCacheBean)localObject2).getList())))
    {
      this.l = ((NotificationMsgCacheBean)localObject2).getLocale();
      int i1 = 1;
      Iterator localIterator = ((NotificationMsgCacheBean)localObject2).getList().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (NotificationMsgBean)localIterator.next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((NotificationMsgBean)localObject2).getMsgId())))
        {
          int i2 = i1;
          if (i1 != 0)
          {
            this.h = ((NotificationMsgBean)localObject2).getTime();
            i2 = 0;
          }
          this.k.put(((NotificationMsgBean)localObject2).getMsgId(), localObject2);
          i1 = i2;
        }
      }
    }
  }
  
  private void S(List<NotificationMsgBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (!((NotificationMsgBean)paramList.next()).isReadFlag())
        {
          bool = true;
          break label51;
        }
      }
    }
    boolean bool = false;
    label51:
    this.f.postValue(Boolean.valueOf(bool));
  }
  
  private NotificationMsgTypeListParams k()
  {
    ArrayList localArrayList = new ArrayList();
    for (localObject : EnumNotificationMsgType.values())
    {
      NotificationMsgTypeParams localNotificationMsgTypeParams = new NotificationMsgTypeParams();
      localNotificationMsgTypeParams.setIndexTime(-1L);
      localNotificationMsgTypeParams.setDirection(EnumNotificationDirection.ASC);
      localNotificationMsgTypeParams.setMsgType(((EnumNotificationMsgType)localObject).getName());
      localArrayList.add(localNotificationMsgTypeParams);
    }
    Object localObject = new NotificationMsgTypeListParams();
    ((NotificationMsgTypeListParams)localObject).setMsgList(localArrayList);
    return (NotificationMsgTypeListParams)localObject;
  }
  
  private NotificationParams l()
  {
    b.d.s.a.b.a locala = n.a();
    NotificationParams localNotificationParams = new NotificationParams();
    String str = x.d(Locale.getDefault());
    long l1 = Math.max(System.currentTimeMillis() - 2592000000L, v(str));
    ArrayList localArrayList = new ArrayList();
    EnumNotificationMsgType[] arrayOfEnumNotificationMsgType = EnumNotificationMsgType.values();
    int i1 = arrayOfEnumNotificationMsgType.length;
    for (int i2 = 0; i2 < i1; i2++) {
      localArrayList.add(arrayOfEnumNotificationMsgType[i2].getName());
    }
    localNotificationParams.setMsgTypes(localArrayList);
    localNotificationParams.setTerminalUUID(locala.g());
    localNotificationParams.setMobileType("ANDROID");
    localNotificationParams.setAppType(locala.b());
    if (TextUtils.isEmpty(locala.e())) {
      localNotificationParams.setDeviceToken("");
    } else {
      localNotificationParams.setDeviceToken(locala.e());
    }
    localNotificationParams.setLocale(str);
    localNotificationParams.setDirection(EnumNotificationDirection.ASC);
    localNotificationParams.setIndex(0);
    localNotificationParams.setIndexTime(l1);
    localNotificationParams.setLimit(50);
    return localNotificationParams;
  }
  
  private void m(List<NotificationMsgBean> paramList1, List<NotificationMsgBean> paramList2, String paramString)
  {
    Object localObject = this;
    ((NotificationCenterManager)localObject).j.clear();
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localArrayList.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      if (TextUtils.equals(paramString, ((NotificationCenterManager)localObject).l))
      {
        localArrayList.addAll(paramList2);
      }
      else
      {
        Iterator localIterator = paramList2.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label183;
          }
          paramList1 = (NotificationMsgBean)localIterator.next();
          if ((paramList1 != null) && (paramList1.isReadFlag()))
          {
            paramList2 = localArrayList.iterator();
            if (paramList2.hasNext())
            {
              NotificationMsgBean localNotificationMsgBean = (NotificationMsgBean)paramList2.next();
              if ((localNotificationMsgBean == null) || (!TextUtils.equals(paramList1.getMsgId(), localNotificationMsgBean.getMsgId()))) {
                break;
              }
              localNotificationMsgBean.setReadFlag(true);
            }
          }
        }
        label183:
        ((NotificationCenterManager)localObject).l = paramString;
      }
    }
    Collections.sort(localArrayList, c);
    paramList1 = localArrayList.iterator();
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    int i11 = 0;
    int i12 = 0;
    int i13 = 0;
    int i14 = 0;
    int i15 = 0;
    int i16 = 0;
    int i17 = 0;
    int i18 = 0;
    int i19 = 0;
    int i20 = 0;
    int i21 = 0;
    for (;;)
    {
      paramList2 = this;
      if (!paramList1.hasNext()) {
        break;
      }
      paramString = (NotificationMsgBean)paramList1.next();
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.getMsgId())))
      {
        localObject = EnumNotificationMsgType.fromString(paramString.getMsgType());
        if (localObject != null)
        {
          switch (d.a[localObject.ordinal()])
          {
          case 28: 
          case 29: 
          default: 
          case 30: 
          case 31: 
          case 32: 
          case 33: 
          case 34: 
            do
            {
              i22 = i3;
              i3 = i14;
              i14 = i13;
              i13 = i22;
              break;
            } while (!paramList2.D(paramString, i12, l1));
            paramList2.j.put(paramString.getMsgId(), paramString);
            i12++;
            break;
          case 27: 
            if (paramList2.C(paramString, i11, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i11++;
            }
            break;
          case 26: 
            if (paramList2.E(paramString, i10, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i10++;
            }
            break;
          case 25: 
            if (paramList2.B(paramString, i9, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i9++;
            }
            break;
          case 24: 
            if (paramList2.B(paramString, i8, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i8++;
            }
            break;
          case 23: 
            if (paramList2.B(paramString, i7, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i7++;
            }
            break;
          case 22: 
            if (paramList2.B(paramString, i6, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i6++;
            }
            break;
          case 21: 
            if (paramList2.B(paramString, i5, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i5++;
            }
            break;
          case 20: 
            if (paramList2.B(paramString, i1, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i1++;
            }
            break;
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 19: 
            if (paramList2.D(paramString, i15, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i15++;
              i22 = i12;
              i12 = i9;
              i9 = i7;
              i23 = i1;
              i7 = i5;
              i24 = i6;
              i6 = i11;
              i11 = i10;
              i10 = i14;
            }
            break;
          case 14: 
            i23 = i14;
            i14 = i23;
            if (paramList2.E(paramString, i23, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i22 = i10;
              i14 = i11;
              i24 = i6;
              i10 = i23 + 1;
              i11 = i22;
              i6 = i14;
              i22 = i12;
              i12 = i9;
              i9 = i7;
              i7 = i5;
              i23 = i1;
              i25 = i13;
              i13 = i17;
              i14 = i18;
              i1 = i4;
              i4 = i2;
              i17 = i3;
              i5 = i16;
              i18 = i13;
              i3 = i23;
              i13 = i24;
              i2 = i8;
              i8 = i20;
              i20 = i19;
              i16 = i22;
              i19 = i11;
              i22 = i21;
              i11 = i25;
              i21 = i10;
              break label2071;
            }
            i22 = i3;
            i3 = i14;
            i14 = i13;
            i13 = i22;
            break;
          case 13: 
            i22 = i14;
            if (paramList2.E(paramString, i13, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i13++;
              i22 = i21;
              i21 = i13;
            }
            else
            {
              i24 = i3;
              i14 = i13;
              i3 = i22;
              i13 = i24;
            }
            break;
          case 12: 
            i22 = i14;
            if (paramList2.E(paramString, i21, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i22 = i21 + 1;
              i21 = i13;
            }
            else
            {
              i14 = i13;
              i13 = i3;
              i3 = i22;
            }
            break;
          case 10: 
          case 11: 
            i24 = i14;
            if (paramList2.A(paramString, i20, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i20++;
              i22 = i21;
              i21 = i13;
              i24 = i14;
              i23 = i12;
              i12 = i9;
              i9 = i7;
              i13 = i6;
              i7 = i5;
              i6 = i1;
              i25 = i17;
              i1 = i4;
              i14 = i18;
              i4 = i2;
              i17 = i3;
              i5 = i16;
              i18 = i25;
              i3 = i6;
              i2 = i8;
              i8 = i20;
              i20 = i19;
              i16 = i23;
              i6 = i11;
              i19 = i10;
              i11 = i21;
              i21 = i24;
              break label2071;
            }
            i22 = i3;
            i3 = i24;
            i14 = i13;
            i13 = i22;
            break;
          case 9: 
            i22 = i13;
            i24 = i14;
            if (paramList2.B(paramString, i19, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i22 = i19 + 1;
              i19 = i18;
              i18 = i22;
            }
            else
            {
              i13 = i3;
              i3 = i24;
              i14 = i22;
            }
            break;
          case 7: 
          case 8: 
            i22 = i13;
            i24 = i14;
            if (paramList2.B(paramString, i18, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i22 = i18 + 1;
              i18 = i19;
              i19 = i22;
              i22 = i14;
              i25 = i17;
              i24 = i4;
              i14 = i19;
              i4 = i2;
              i17 = i3;
              i23 = i16;
              i19 = i25;
              i16 = i22;
              i22 = i18;
              i25 = i13;
              break label1979;
            }
            i13 = i3;
            i3 = i24;
            i14 = i22;
            break;
          case 5: 
          case 6: 
            i22 = i13;
            i24 = i14;
            if (paramList2.z(paramString, i17, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i17++;
              i23 = i16;
              i16 = i17;
            }
            else
            {
              i13 = i3;
              i3 = i24;
              i14 = i22;
            }
            break;
          case 4: 
            i22 = i13;
            i24 = i14;
            if (paramList2.F(paramString, i16, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i23 = i16 + 1;
              i16 = i17;
              i22 = i14;
              i24 = i4;
              i14 = i18;
              i4 = i2;
              i17 = i3;
              i18 = i16;
              i2 = i22;
              i3 = i19;
              break label1995;
            }
            i13 = i3;
            i3 = i24;
            i14 = i22;
            break;
          case 3: 
            i22 = i13;
            i24 = i14;
            if (paramList2.G(paramString, i4, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i4++;
              i22 = i3;
            }
            else
            {
              i13 = i3;
              i3 = i24;
              i14 = i22;
            }
            break;
          case 2: 
            i22 = i3;
            if (paramList2.H(paramString, i22, l1))
            {
              paramList2.j.put(paramString.getMsgId(), paramString);
              i22++;
              i24 = i13;
              i23 = i14;
              i3 = i18;
              i14 = i2;
              i13 = i22;
              i2 = i4;
              i18 = i17;
              i4 = i23;
              i17 = i19;
              i19 = i24;
              break label1943;
            }
            break;
          }
          int i23 = i2;
          int i22 = i13;
          int i24 = i14;
          if (paramList2.K(paramString, i23, l1))
          {
            paramList2.j.put(paramString.getMsgId(), paramString);
            i14 = i23 + 1;
            i13 = i3;
            i2 = i4;
            i3 = i18;
            i18 = i17;
            i4 = i24;
            i17 = i19;
            i19 = i22;
          }
          else
          {
            i24 = i13;
            i22 = i14;
            i13 = i3;
            i14 = i24;
            i3 = i22;
            i22 = i2;
            i2 = i17;
            i24 = i18;
            i17 = i19;
            i23 = i4;
            i19 = i14;
            i4 = i3;
            i18 = i2;
            i2 = i23;
            i14 = i22;
            i3 = i24;
          }
          label1943:
          i23 = i16;
          int i25 = i19;
          i22 = i17;
          i16 = i4;
          i19 = i18;
          i24 = i2;
          i17 = i13;
          i4 = i14;
          i14 = i3;
          label1979:
          i13 = i25;
          i3 = i22;
          i2 = i16;
          i18 = i19;
          label1995:
          i19 = i10;
          int i26 = i11;
          i16 = i12;
          i25 = i8;
          i10 = i6;
          i8 = i20;
          i22 = i21;
          i21 = i2;
          i11 = i13;
          i6 = i26;
          i20 = i3;
          i12 = i9;
          i2 = i25;
          i9 = i7;
          i13 = i10;
          i7 = i5;
          i3 = i1;
          i5 = i23;
          i1 = i24;
          label2071:
          if ((i4 == 32) && (i17 == 32) && (i1 == 32) && (i5 == 128) && (i18 == 128) && (i8 == 128) && (i14 == 128) && (i20 == 128) && (i15 == 64) && (i3 == 128) && (i7 == 128) && (i13 == 128) && (i9 == 128) && (i2 == 128) && (i12 == 128) && (i19 == 64) && (i6 == 32) && (i16 == 64)) {
            break;
          }
          i24 = i1;
          i25 = i5;
          i5 = i7;
          i7 = i9;
          i9 = i12;
          i26 = i8;
          i23 = i17;
          int i27 = i14;
          i14 = i11;
          i11 = i6;
          i1 = i3;
          i6 = i13;
          i8 = i2;
          i10 = i19;
          i12 = i16;
          i13 = i14;
          i14 = i21;
          i16 = i25;
          i17 = i18;
          i18 = i27;
          i19 = i20;
          i20 = i26;
          i21 = i22;
          i2 = i4;
          i3 = i23;
          i4 = i24;
        }
      }
    }
    O();
    this.g.postValue(Boolean.TRUE);
  }
  
  private io.reactivex.a n(List<NotificationMsgBean> paramList)
  {
    if (paramList == null) {
      return io.reactivex.a.e();
    }
    final boolean bool = paramList.isEmpty();
    final ArrayList localArrayList = new ArrayList();
    if (!bool)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        NotificationMsgBean localNotificationMsgBean = (NotificationMsgBean)localIterator.next();
        if ((localNotificationMsgBean != null) && (!TextUtils.isEmpty(localNotificationMsgBean.getMsgId()))) {
          localArrayList.add(localNotificationMsgBean.getMsgId());
        }
      }
    }
    return p(paramList, bool).i(new k(localArrayList, bool)).j(new j(bool));
  }
  
  private q<Boolean> o(final NotificationMsgIdListParams paramNotificationMsgIdListParams)
  {
    final n localn = new n(true);
    return this.d.C(paramNotificationMsgIdListParams).i(new m(paramNotificationMsgIdListParams, localn)).j(new c(localn)).d(q.f0(Boolean.valueOf(n.a(localn))));
  }
  
  private io.reactivex.a p(List<NotificationMsgBean> paramList, boolean paramBoolean)
  {
    this.m.clear();
    if (paramBoolean) {
      return this.d.B(k());
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (NotificationMsgBean)localIterator.next();
      if ((paramList != null) && (!TextUtils.isEmpty(paramList.getMsgId())))
      {
        NotificationMsgIdParams localNotificationMsgIdParams = new NotificationMsgIdParams();
        localNotificationMsgIdParams.setMsgId(paramList.getMsgId());
        localArrayList.add(localNotificationMsgIdParams);
      }
    }
    return s(localArrayList);
  }
  
  private void q(List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    if (paramBoolean)
    {
      this.j.clear();
    }
    else
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.j.remove(str);
      }
    }
    O();
  }
  
  private long v(String paramString)
  {
    if (!TextUtils.equals(paramString, this.l)) {
      return -1L;
    }
    return Math.max(-1L, this.h);
  }
  
  private boolean z(NotificationMsgBean paramNotificationMsgBean, int paramInt, long paramLong)
  {
    return B(paramNotificationMsgBean, paramInt, paramLong);
  }
  
  public io.reactivex.a M(final List<NotificationMsgBean> paramList)
  {
    this.n.incrementAndGet();
    return io.reactivex.a.n(new b(paramList)).h(new a());
  }
  
  public void Q(List<NotificationMsgBean> paramList)
  {
    NotificationMsgCacheBean localNotificationMsgCacheBean = new NotificationMsgCacheBean();
    localNotificationMsgCacheBean.setLocale(this.l);
    localNotificationMsgCacheBean.setList(paramList);
    b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), localNotificationMsgCacheBean, "account_notification_msg_cache_list_key2", "account_notification_msg_cache_list_key2");
  }
  
  public void R(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public io.reactivex.a r(List<NotificationMsgBean> paramList)
  {
    this.n.incrementAndGet();
    return n(paramList).h(new i());
  }
  
  public io.reactivex.a s(List<NotificationMsgIdParams> paramList)
  {
    int i1 = paramList.size();
    int i2 = i1 / 50;
    int i3 = 0;
    if (i1 % 50 != 0) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    i2 += i4;
    final t[] arrayOft = new t[i2];
    for (int i4 = i3; i4 < i2; i4++)
    {
      if (i4 == i2 - 1) {
        i3 = i1;
      } else {
        i3 = (i4 + 1) * 50;
      }
      ArrayList localArrayList = new ArrayList(paramList.subList(i4 * 50, i3));
      NotificationMsgIdListParams localNotificationMsgIdListParams = new NotificationMsgIdListParams();
      localNotificationMsgIdListParams.setMsgIdList(localArrayList);
      arrayOft[i4] = o(localNotificationMsgIdListParams);
    }
    return io.reactivex.a.g(new l(arrayOft));
  }
  
  public q<List<NotificationMsgBean>> t()
  {
    if (this.n.get() > 0) {
      return q.f0(new ArrayList()).y(new e());
    }
    this.n.incrementAndGet();
    final NotificationParams localNotificationParams = l();
    return this.d.D(localNotificationParams).E(new h(localNotificationParams)).C(new g(localNotificationParams)).y(new f());
  }
  
  public void u()
  {
    Boolean localBoolean = (Boolean)this.f.getValue();
    if (((localBoolean != null) && (localBoolean.booleanValue())) || (this.i)) {
      return;
    }
    t().F0();
  }
  
  public MutableLiveData<List<NotificationMsgBean>> w()
  {
    return this.e;
  }
  
  public MutableLiveData<Boolean> x()
  {
    return this.f;
  }
  
  public MutableLiveData<Boolean> y()
  {
    return this.g;
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      NotificationCenterManager.e(NotificationCenterManager.this).decrementAndGet();
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b(List paramList) {}
    
    public void run()
      throws Exception
    {
      NotificationCenterManager.j(NotificationCenterManager.this, paramList);
    }
  }
  
  static final class c
    implements Comparator<NotificationMsgBean>
  {
    public int a(NotificationMsgBean paramNotificationMsgBean1, NotificationMsgBean paramNotificationMsgBean2)
    {
      if (paramNotificationMsgBean2.getTime() > paramNotificationMsgBean1.getTime()) {
        return 1;
      }
      if (paramNotificationMsgBean2.getTime() == paramNotificationMsgBean1.getTime())
      {
        if ((paramNotificationMsgBean2.isReadFlag()) && (!paramNotificationMsgBean1.isReadFlag())) {
          return 1;
        }
        if (paramNotificationMsgBean2.isReadFlag() == paramNotificationMsgBean1.isReadFlag()) {
          return 0;
        }
      }
      return -1;
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e() {}
    
    public void run()
      throws Exception
    {
      NotificationCenterManager.d(NotificationCenterManager.this).postValue(Boolean.TRUE);
    }
  }
  
  class f
    implements io.reactivex.g0.a
  {
    f() {}
    
    public void run()
      throws Exception
    {
      NotificationCenterManager.e(NotificationCenterManager.this).decrementAndGet();
    }
  }
  
  class g
    implements g<Throwable>
  {
    g(NotificationParams paramNotificationParams) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      NotificationCenterManager.g(NotificationCenterManager.this, null, new ArrayList(NotificationCenterManager.f(NotificationCenterManager.this).values()), localNotificationParams.getLocale());
    }
  }
  
  class h
    implements g<List<NotificationMsgBean>>
  {
    h(NotificationParams paramNotificationParams) {}
    
    public void a(List<NotificationMsgBean> paramList)
      throws Exception
    {
      NotificationCenterManager.g(NotificationCenterManager.this, paramList, new ArrayList(NotificationCenterManager.f(NotificationCenterManager.this).values()), localNotificationParams.getLocale());
    }
  }
  
  class i
    implements io.reactivex.g0.a
  {
    i() {}
    
    public void run()
      throws Exception
    {
      NotificationCenterManager.e(NotificationCenterManager.this).decrementAndGet();
    }
  }
  
  class j
    implements g<Throwable>
  {
    j(boolean paramBoolean) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      NotificationCenterManager.i(NotificationCenterManager.this, new ArrayList(NotificationCenterManager.h(NotificationCenterManager.this)), bool);
    }
  }
  
  class k
    implements io.reactivex.g0.a
  {
    k(List paramList, boolean paramBoolean) {}
    
    public void run()
      throws Exception
    {
      NotificationCenterManager.i(NotificationCenterManager.this, localArrayList, bool);
    }
  }
  
  class l
    implements d
  {
    l(t[] paramArrayOft) {}
    
    public void a(io.reactivex.b paramb)
      throws Exception
    {
      q.i0(arrayOft).T0(30L, TimeUnit.SECONDS).z(new a(paramb)).C(new b(paramb)).L0(io.reactivex.l0.a.c()).F0();
    }
  }
  
  class m
    implements io.reactivex.g0.a
  {
    m(NotificationMsgIdListParams paramNotificationMsgIdListParams, NotificationCenterManager.n paramn) {}
    
    public void run()
      throws Exception
    {
      Object localObject = paramNotificationMsgIdListParams.getMsgIdList();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          NotificationMsgIdParams localNotificationMsgIdParams = (NotificationMsgIdParams)((Iterator)localObject).next();
          if ((localNotificationMsgIdParams != null) && (!TextUtils.isEmpty(localNotificationMsgIdParams.getMsgId()))) {
            NotificationCenterManager.h(NotificationCenterManager.this).add(localNotificationMsgIdParams.getMsgId());
          }
        }
      }
      localn.b(true);
    }
  }
  
  private static class n
  {
    private boolean a;
    
    public n(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public void b(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\notification\NotificationCenterManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */