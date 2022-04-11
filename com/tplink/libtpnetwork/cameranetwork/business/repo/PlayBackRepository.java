package com.tplink.libtpnetwork.cameranetwork.business.repo;

import android.os.Build.VERSION;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.PlayBackEventType;
import com.tplink.libtpnetwork.cameranetwork.business.model.i;
import com.tplink.libtpnetwork.cameranetwork.business.model.j;
import com.tplink.libtpnetwork.cameranetwork.business.model.k;
import com.tplink.libtpnetwork.cameranetwork.business.model.l;
import com.tplink.libtpnetwork.cameranetwork.business.model.n;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ClockStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ClockTimezoneDstStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ClockTimezoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackItem;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionList;
import com.tplink.libtpnetwork.cameranetwork.model.DstInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.SnapshotPlaybackItem;
import com.tplink.libtpnetwork.cameranetwork.model.Timezone;
import com.tplink.libtpnetwork.cameranetwork.model.VodUserId;
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackItem;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpnetwork.cameranetwork.util.d;
import io.reactivex.q;
import io.reactivex.r;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class PlayBackRepository
  extends c
{
  private final String d = "PlayBackRepository";
  private final MutableLiveData<Boolean> e = new MutableLiveData();
  private final MutableLiveData<Boolean> f = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<l>> g = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Long>> h = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.business.model.m> i = new MutableLiveData();
  private final MutableLiveData<n> j = new MutableLiveData();
  private final MutableLiveData<List<j>> k = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> l = new MutableLiveData();
  private final Map<String, List<j>> m = new HashMap();
  private final List<DailyPlaybackItem> n = new ArrayList();
  private final List<DailyPlaybackItem> o = new ArrayList();
  private final List<DailyPlaybackItem> p = new ArrayList();
  private int q = -1;
  private Calendar r;
  private Calendar s;
  private long t;
  private long u;
  public long v;
  public int[] w;
  private k x;
  private TimeZone y;
  private final SimpleDateFormat z = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
  
  public PlayBackRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
    q0();
  }
  
  private List<SnapshotPlaybackItem> A(SnapshotPlaybackItem paramSnapshotPlaybackItem, long paramLong, Calendar paramCalendar)
  {
    ArrayList localArrayList = new ArrayList();
    SnapshotPlaybackItem localSnapshotPlaybackItem = new SnapshotPlaybackItem(paramSnapshotPlaybackItem.getStartTime(), paramLong - 1L, paramSnapshotPlaybackItem.getType());
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(localSnapshotPlaybackItem.getStartTime() * 1000L);
    O1(localCalendar);
    if (u0(localCalendar, paramCalendar)) {
      localArrayList.add(localSnapshotPlaybackItem);
    }
    localSnapshotPlaybackItem = new SnapshotPlaybackItem(paramLong + 1L, paramSnapshotPlaybackItem.getEndTime(), paramSnapshotPlaybackItem.getType(), String.valueOf(paramSnapshotPlaybackItem.getStartTime()));
    paramSnapshotPlaybackItem = Calendar.getInstance();
    paramSnapshotPlaybackItem.setTimeInMillis(localSnapshotPlaybackItem.getStartTime() * 1000L);
    O1(paramSnapshotPlaybackItem);
    if (u0(paramSnapshotPlaybackItem, paramCalendar)) {
      localArrayList.add(localSnapshotPlaybackItem);
    }
    return localArrayList;
  }
  
  private q<Boolean> B()
  {
    return l().u0().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).N(new a4(this)).E(new h5(this)).l0(io.reactivex.d0.b.a.a()).g0(d5.c).C(new s4(this));
  }
  
  private q<k> C(ClockTimezoneDstStatus paramClockTimezoneDstStatus, long paramLong)
  {
    DstInfo localDstInfo = paramClockTimezoneDstStatus.getDstInfo();
    if ((localDstInfo != null) && ("1".equals(localDstInfo.getSynced())) && (("1".equals(localDstInfo.getHasRule())) || ("2".equals(localDstInfo.getHasRule())))) {
      return D(true, new ClockTimezoneInfo(paramClockTimezoneDstStatus.getClockStatus(), paramClockTimezoneDstStatus.getTimezone()), paramLong);
    }
    return D(false, new ClockTimezoneInfo(paramClockTimezoneDstStatus.getClockStatus(), paramClockTimezoneDstStatus.getTimezone()), paramLong);
  }
  
  private q<k> D(boolean paramBoolean, ClockTimezoneInfo paramClockTimezoneInfo, long paramLong)
  {
    ClockStatus localClockStatus = paramClockTimezoneInfo.getClockStatus();
    Timezone localTimezone = paramClockTimezoneInfo.getTimezone();
    if ((localClockStatus != null) && (localClockStatus.getSeconds() > 0L)) {
      paramClockTimezoneInfo = new k((int)(this.z.parse(localClockStatus.getLocalTime(), new ParsePosition(0)).getTime() - localClockStatus.getSeconds() * 1000L), localClockStatus.getSeconds() * 1000L);
    } else {
      paramClockTimezoneInfo = new k(0, paramLong);
    }
    if ((paramBoolean) && (localTimezone != null))
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramClockTimezoneInfo.d(localTimezone.getZoneId(), localTimezone.getTimezone());
        return q.f0(paramClockTimezoneInfo);
      }
      return d.c().g(localTimezone.getZoneId()).g0(new q4(paramClockTimezoneInfo, localTimezone));
    }
    if (localTimezone != null) {
      paramClockTimezoneInfo.u(localTimezone.getZoneId(), localTimezone.getTimezone());
    }
    return q.f0(paramClockTimezoneInfo);
  }
  
  private com.tplink.libtpnetwork.cameranetwork.business.model.m E(List<DailyPlaybackItem> paramList, Calendar paramCalendar)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    long l1 = 0L;
    boolean bool1 = false;
    int i1 = 1;
    int i2 = 0;
    int i3 = 0;
    while (paramList.hasNext())
    {
      DailyPlaybackItem localDailyPlaybackItem = (DailyPlaybackItem)paramList.next();
      boolean bool2;
      int i5;
      int i6;
      int i7;
      long l4;
      if (this.x.p())
      {
        long l2 = this.x.h(localDailyPlaybackItem.getStartTime() * 1000L, 0);
        long l3 = this.x.g(localDailyPlaybackItem.getStartTime() * 1000L, 0);
        int i4;
        if (l2 < l3) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if ((!bool1) && (s0(localDailyPlaybackItem.getStartTime() * 1000L, l3)))
        {
          localCalendar1 = Calendar.getInstance();
          localCalendar1.setTimeInMillis(l3);
          O1(localCalendar1);
          i1 = localCalendar1.get(11);
          i2 = localCalendar1.get(12);
          i3 = this.x.k() / 1000;
          l1 = l3 / 1000L;
          bool1 = true;
        }
        if ((i4 != 0) && (!this.x.q(localDailyPlaybackItem.getStartTime() * 1000L, l2, l3)) && (this.x.q(localDailyPlaybackItem.getEndTime() * 1000L, l2, l3)))
        {
          localArrayList.addAll(z(localDailyPlaybackItem, l2 / 1000L, paramCalendar));
        }
        else if ((i4 != 0) && (this.x.q(localDailyPlaybackItem.getStartTime() * 1000L, l2, l3)) && (!this.x.q(localDailyPlaybackItem.getEndTime() * 1000L, l2, l3)))
        {
          localArrayList.addAll(z(localDailyPlaybackItem, l3 / 1000L, paramCalendar));
        }
        else if ((i4 == 0) && (!this.x.r(localDailyPlaybackItem.getStartTime() * 1000L, l2, l3)) && (this.x.r(localDailyPlaybackItem.getEndTime() * 1000L, l2, l3)))
        {
          localArrayList.addAll(z(localDailyPlaybackItem, l2 / 1000L, paramCalendar));
        }
        else
        {
          bool2 = bool1;
          i5 = i1;
          i6 = i2;
          i7 = i3;
          l4 = l1;
          if (i4 != 0) {
            break label577;
          }
          bool2 = bool1;
          i5 = i1;
          i6 = i2;
          i7 = i3;
          l4 = l1;
          if (!this.x.r(localDailyPlaybackItem.getStartTime() * 1000L, l2, l3)) {
            break label577;
          }
          bool2 = bool1;
          i5 = i1;
          i6 = i2;
          i7 = i3;
          l4 = l1;
          if (this.x.r(localDailyPlaybackItem.getEndTime() * 1000L, l2, l3)) {
            break label577;
          }
          localArrayList.addAll(z(localDailyPlaybackItem, l3 / 1000L, paramCalendar));
        }
      }
      else
      {
        l4 = l1;
        i7 = i3;
        i6 = i2;
        i5 = i1;
        bool2 = bool1;
      }
      label577:
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(localDailyPlaybackItem.getStartTime() * 1000L);
      O1(localCalendar2);
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(localDailyPlaybackItem.getEndTime() * 1000L);
      O1(localCalendar1);
      if ((u0(localCalendar2, paramCalendar)) && (u0(localCalendar1, paramCalendar)))
      {
        localArrayList.add(localDailyPlaybackItem);
      }
      else if ((u0(localCalendar2, paramCalendar)) && (!u0(localCalendar1, paramCalendar)))
      {
        localCalendar1 = Calendar.getInstance();
        if (this.x.l() != null) {
          localCalendar1.setTimeZone(this.x.l());
        }
        localCalendar1.setTimeInMillis(localDailyPlaybackItem.getEndTime() * 1000L);
        localCalendar1.set(11, 0);
        localCalendar1.set(12, 0);
        localCalendar1.set(13, 0);
        localArrayList.add(new DailyPlaybackItem(localCalendar1.getTimeInMillis() / 1000L, localDailyPlaybackItem.getEndTime(), localDailyPlaybackItem.getType()));
      }
      else if ((!u0(localCalendar2, paramCalendar)) && (u0(localCalendar1, paramCalendar)))
      {
        localCalendar1 = Calendar.getInstance();
        if (this.x.l() != null) {
          localCalendar1.setTimeZone(this.x.l());
        }
        localCalendar1.setTimeInMillis(localDailyPlaybackItem.getStartTime() * 1000L);
        localCalendar1.set(11, 23);
        localCalendar1.set(12, 59);
        localCalendar1.set(13, 59);
        localArrayList.add(new DailyPlaybackItem(localDailyPlaybackItem.getStartTime(), localCalendar1.getTimeInMillis() / 1000L, localDailyPlaybackItem.getType()));
      }
      bool1 = bool2;
      i1 = i5;
      i2 = i6;
      i3 = i7;
      l1 = l4;
    }
    return new com.tplink.libtpnetwork.cameranetwork.business.model.m(localArrayList, bool1, i1, i2, i3, l1);
  }
  
  private n G(List<SnapshotPlaybackItem> paramList, boolean paramBoolean, Calendar paramCalendar, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    int i1 = 0;
    long l1 = 0L;
    label601:
    while (localIterator.hasNext())
    {
      SnapshotPlaybackItem localSnapshotPlaybackItem = (SnapshotPlaybackItem)localIterator.next();
      if (this.x.p())
      {
        long l2 = this.x.h(localSnapshotPlaybackItem.getStartTime() * 1000L, 0);
        long l3 = this.x.g(localSnapshotPlaybackItem.getStartTime() * 1000L, 0);
        int i2;
        if (l2 < l3) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if ((!bool) && (s0(localSnapshotPlaybackItem.getStartTime() * 1000L, l3)))
        {
          i1 = this.x.k() / 1000;
          l1 = l3 / 1000L;
          bool = true;
        }
        if ((i2 != 0) && (!this.x.q(localSnapshotPlaybackItem.getStartTime() * 1000L, l2, l3)) && (this.x.q(localSnapshotPlaybackItem.getEndTime() * 1000L, l2, l3)))
        {
          localArrayList.addAll(A(localSnapshotPlaybackItem, l2 / 1000L, paramCalendar));
          break label601;
        }
        if ((i2 != 0) && (this.x.q(localSnapshotPlaybackItem.getStartTime() * 1000L, l2, l3)) && (!this.x.q(localSnapshotPlaybackItem.getEndTime() * 1000L, l2, l3)))
        {
          localArrayList.addAll(A(localSnapshotPlaybackItem, l3 / 1000L, paramCalendar));
          break label601;
        }
        if ((i2 == 0) && (!this.x.r(localSnapshotPlaybackItem.getStartTime() * 1000L, l2, l3)) && (this.x.r(localSnapshotPlaybackItem.getEndTime() * 1000L, l2, l3)))
        {
          localArrayList.addAll(A(localSnapshotPlaybackItem, l2 / 1000L, paramCalendar));
          break label601;
        }
        if ((i2 == 0) && (this.x.r(localSnapshotPlaybackItem.getStartTime() * 1000L, l2, l3)) && (!this.x.r(localSnapshotPlaybackItem.getEndTime() * 1000L, l2, l3)))
        {
          localArrayList.addAll(A(localSnapshotPlaybackItem, l3 / 1000L, paramCalendar));
          break label601;
        }
      }
      paramList = Calendar.getInstance();
      paramList.setTimeInMillis(localSnapshotPlaybackItem.getStartTime() * 1000L);
      O1(paramList);
      if (u0(paramList, paramCalendar)) {
        if (paramLong > 0L)
        {
          if ((localSnapshotPlaybackItem.getStartTime() < paramLong) && (localSnapshotPlaybackItem.getEndTime() < paramLong)) {
            localArrayList.add(localSnapshotPlaybackItem);
          } else if ((localSnapshotPlaybackItem.getStartTime() < paramLong) && (localSnapshotPlaybackItem.getEndTime() >= paramLong)) {
            localArrayList.add(new SnapshotPlaybackItem(localSnapshotPlaybackItem.getStartTime(), paramLong, localSnapshotPlaybackItem.getType()));
          }
        }
        else {
          localArrayList.add(localSnapshotPlaybackItem);
        }
      }
    }
    return new n(localArrayList, paramBoolean, bool, i1, l1);
  }
  
  private boolean H(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int i1 = paramArrayOfInt.length;
    for (int i2 = 0; i2 < i1; i2++) {
      if (paramArrayOfInt[i2] == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  private long I(long paramLong, List<DailyPlaybackItem> paramList)
  {
    long l1 = paramLong;
    if (!paramList.isEmpty())
    {
      int i1 = 0;
      Iterator localIterator = paramList.iterator();
      DailyPlaybackItem localDailyPlaybackItem;
      do
      {
        i2 = i1;
        if (!localIterator.hasNext()) {
          break;
        }
        localDailyPlaybackItem = (DailyPlaybackItem)localIterator.next();
      } while ((paramLong < localDailyPlaybackItem.getStartTime()) || (paramLong >= localDailyPlaybackItem.getEndTime()));
      int i2 = 1;
      l1 = paramLong;
      if (i2 == 0)
      {
        paramList = paramList.iterator();
        for (;;)
        {
          l1 = paramLong;
          if (!paramList.hasNext()) {
            break;
          }
          localDailyPlaybackItem = (DailyPlaybackItem)paramList.next();
          if (paramLong < localDailyPlaybackItem.getStartTime())
          {
            l1 = localDailyPlaybackItem.getStartTime();
            break;
          }
          if (!paramList.hasNext()) {
            paramLong = localDailyPlaybackItem.getStartTime();
          }
        }
      }
    }
    return l1;
  }
  
  private q<Response<List<DailyPlaybackItem>>> L(CameraComponent paramCameraComponent, j paramj, int paramInt, i parami)
  {
    if (paramCameraComponent.isSupportUtcDst())
    {
      paramCameraComponent = this.x.i(paramj.c(), paramj.b(), paramj.a());
      return N(((Long)paramCameraComponent.first).longValue(), ((Long)paramCameraComponent.second).longValue(), paramInt, parami);
    }
    return M(String.format(Locale.US, "%1$d%2$02d%3$02d", new Object[] { Integer.valueOf(paramj.c()), Integer.valueOf(paramj.b() + 1), Integer.valueOf(paramj.a()) }), paramInt, parami);
  }
  
  private q<Response<List<DailyPlaybackItem>>> M(String paramString, int paramInt, i parami)
  {
    return q.f0(parami).N(new c5(this, paramInt, paramString));
  }
  
  private q<Response<List<DailyPlaybackItem>>> N(long paramLong1, long paramLong2, int paramInt, i parami)
  {
    return q.f0(parami).N(new b4(this, paramInt, paramLong1, paramLong2));
  }
  
  private void O(CameraComponent paramCameraComponent, j paramj, int paramInt, i parami, r<List<DailyPlaybackItem>> paramr)
  {
    ArrayList localArrayList = new ArrayList();
    L(paramCameraComponent, paramj, paramInt, parami).s0(new g4(parami, localArrayList, paramr)).L0(io.reactivex.l0.a.c()).H0(new m5(localArrayList, parami), new l5(localArrayList, paramr));
  }
  
  private String P(j paramj)
  {
    paramj = y(paramj);
    return new SimpleDateFormat("yyyyMM", Locale.US).format(paramj);
  }
  
  private void P1(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar != null)
    {
      int i1 = paramInt / 1000;
      paramInt = i1 / 3600;
      i1 = (i1 - paramInt * 3600) / 60;
      paramCalendar.add(11, paramInt);
      paramCalendar.add(12, i1);
    }
  }
  
  private String Q(Date paramDate)
  {
    return new SimpleDateFormat("yyyyMM", Locale.US).format(paramDate);
  }
  
  private long S(List<DailyPlaybackItem> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList.isEmpty()) {
      return -1L;
    }
    long l1 = ((DailyPlaybackItem)paramList.get(0)).getStartTime();
    paramList = paramList.iterator();
    DailyPlaybackItem localDailyPlaybackItem;
    do
    {
      l2 = l1;
      if (!paramList.hasNext()) {
        break;
      }
      localDailyPlaybackItem = (DailyPlaybackItem)paramList.next();
      if ((PlayBackEventType.TYPE_TIMING.getName().equals(localDailyPlaybackItem.getType())) && (paramBoolean1))
      {
        l2 = localDailyPlaybackItem.getStartTime();
        break;
      }
    } while ((!PlayBackEventType.TYPE_MOTION.getName().equals(localDailyPlaybackItem.getType())) || (!paramBoolean2));
    long l2 = localDailyPlaybackItem.getStartTime();
    return l2;
  }
  
  private int[] T(List<DailyPlaybackItem> paramList)
  {
    paramList = paramList.iterator();
    int i1 = 0;
    int i2 = 0;
    while (paramList.hasNext())
    {
      DailyPlaybackItem localDailyPlaybackItem = (DailyPlaybackItem)paramList.next();
      if (PlayBackEventType.TYPE_TIMING.getName().equals(localDailyPlaybackItem.getType()))
      {
        i1 = 1;
      }
      else
      {
        PlayBackEventType.TYPE_MOTION.getName().equals(localDailyPlaybackItem.getType());
        i2 = 1;
      }
    }
    if ((i1 != 0) && (i2 != 0)) {
      return new int[] { PlayBackEventType.TYPE_TIMING.getValue(), PlayBackEventType.TYPE_MOTION.getValue() };
    }
    if ((i1 != 0) && (i2 == 0)) {
      return new int[] { PlayBackEventType.TYPE_TIMING.getValue() };
    }
    if ((i1 == 0) && (i2 != 0)) {
      return new int[] { PlayBackEventType.TYPE_MOTION.getValue() };
    }
    return new int[] { PlayBackEventType.TYPE_MOTION.getValue() };
  }
  
  private Date U(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(5, 1);
    return new Date(localCalendar.getTimeInMillis());
  }
  
  private q<List<DailyPlaybackItem>> U1(CameraComponent paramCameraComponent, j paramj, int paramInt)
  {
    if (paramCameraComponent.isSupportUtcDst()) {
      return W1(paramCameraComponent, paramj, paramInt, new i(0, 100));
    }
    Object localObject = Calendar.getInstance();
    if (this.x.l() != null) {
      ((Calendar)localObject).setTimeZone(this.x.l());
    }
    ((Calendar)localObject).set(1, paramj.c());
    ((Calendar)localObject).set(2, paramj.b());
    ((Calendar)localObject).set(5, paramj.a());
    ((Calendar)localObject).set(11, 12);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    long l1 = ((Calendar)localObject).getTimeInMillis();
    if ((this.x.p()) && (this.x.o()))
    {
      if (!v(l1))
      {
        ((Calendar)localObject).add(5, 1);
        localObject = new j(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5));
        return W1(paramCameraComponent, paramj, paramInt, new i(0, 100)).i1(W1(paramCameraComponent, (j)localObject, paramInt, new i(0, 100)).q0(new ArrayList()), n4.c);
      }
    }
    else if ((this.x.p()) && (!this.x.o()) && (v(l1)))
    {
      ((Calendar)localObject).add(5, -1);
      localObject = new j(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5));
      return W1(paramCameraComponent, paramj, paramInt, new i(0, 100)).i1(W1(paramCameraComponent, (j)localObject, paramInt, new i(0, 100)).q0(new ArrayList()), k4.c);
    }
    return W1(paramCameraComponent, paramj, paramInt, new i(0, 100));
  }
  
  private Date V(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(5, 1);
    localCalendar.add(2, 1);
    localCalendar.add(5, -1);
    return new Date(localCalendar.getTimeInMillis());
  }
  
  private q<Boolean> V1(CameraComponent paramCameraComponent)
  {
    return q.f0(Integer.valueOf(1)).N(new y4(this, paramCameraComponent));
  }
  
  private q<List<DailyPlaybackItem>> W1(CameraComponent paramCameraComponent, j paramj, int paramInt, i parami)
  {
    return q.m(new c4(this, paramCameraComponent, paramj, paramInt, parami));
  }
  
  private q<k> X(CameraComponent paramCameraComponent, long paramLong)
  {
    if (paramCameraComponent.isSupportUtcDst()) {
      return l().B().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).N(new m4(this, paramLong)).n0(new x4(paramLong));
    }
    return l().C().i(com.tplink.libtpnetwork.cameranetwork.g4.m.a()).L0(io.reactivex.l0.a.c()).N(new o5(this, paramLong)).n0(new t4(paramLong));
  }
  
  private q<Boolean> X1(CameraComponent paramCameraComponent, j paramj, int paramInt)
  {
    return U1(paramCameraComponent, paramj, paramInt).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new f5(this, paramInt)).g0(f4.c).C(new h4(this));
  }
  
  private q<Boolean> Z1()
  {
    return q.f0(Integer.valueOf(1)).N(new i5(this));
  }
  
  private q<DetectionList> a2(i parami, TimeZone paramTimeZone)
  {
    return q.m(new p5(this, paramTimeZone, parami));
  }
  
  private q<l> d2(long paramLong1, long paramLong2)
  {
    Date localDate1 = U(paramLong1);
    Date localDate2 = V(paramLong1);
    if (paramLong2 > 0L)
    {
      long l1 = 1000L * paramLong2;
      if (l1 <= paramLong1)
      {
        localDate1 = U(l1);
        localDate2 = V(paramLong1);
      }
      else
      {
        localDate1 = U(paramLong1);
        localDate2 = V(l1);
      }
    }
    return m0(l(), localDate1, localDate2).i1(l0(), new g5(this, paramLong2, paramLong1)).v0(1L, new v4(this));
  }
  
  private long e2(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return I(paramLong, this.n);
    }
    if ((paramBoolean1) && (!paramBoolean2)) {
      return I(paramLong, this.o);
    }
    long l1 = paramLong;
    if (!paramBoolean1)
    {
      l1 = paramLong;
      if (paramBoolean2) {
        l1 = I(paramLong, this.p);
      }
    }
    return l1;
  }
  
  private q<Response<DetectionList>> h0(TimeZone paramTimeZone, i parami)
  {
    return q.f0(parami).N(new e5(this, paramTimeZone));
  }
  
  private void i0(TimeZone paramTimeZone, i parami, r<DetectionList> paramr)
  {
    ArrayList localArrayList = new ArrayList();
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    h0(paramTimeZone, parami).s0(new q5(parami, localArrayList, arrayOfBoolean, paramr)).L0(io.reactivex.l0.a.c()).H0(new u4(arrayOfBoolean, localArrayList, parami), new l4(localArrayList, paramr, arrayOfBoolean));
  }
  
  private void j2(List<DailyPlaybackItem> paramList1, List<DailyPlaybackItem> paramList2, List<DailyPlaybackItem> paramList3)
  {
    paramList2.clear();
    paramList3.clear();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      DailyPlaybackItem localDailyPlaybackItem = (DailyPlaybackItem)paramList1.next();
      if (PlayBackEventType.TYPE_MOTION.getName().equals(localDailyPlaybackItem.getType())) {
        paramList3.add(localDailyPlaybackItem);
      } else if (PlayBackEventType.TYPE_TIMING.getName().equals(localDailyPlaybackItem.getType())) {
        paramList2.add(localDailyPlaybackItem);
      } else {
        paramList3.add(localDailyPlaybackItem);
      }
    }
  }
  
  private q<Response<VodUserId>> l0()
  {
    int i1 = this.q;
    if (i1 > 0) {
      return q.f0(new Response(0, "getUserID", new VodUserId(i1)));
    }
    return l().z0();
  }
  
  private q<List<YearlyPlaybackItem>> m0(com.tplink.libtpnetwork.cameranetwork.net.a parama, Date paramDate1, Date paramDate2)
  {
    return parama.a(paramDate1, paramDate2).g0(j4.c).q0(new ArrayList());
  }
  
  private void n0(int paramInt, List<DailyPlaybackItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.n.clear();
      paramList = E(paramList, this.r);
      this.n.addAll(paramList.e());
      j2(this.n, this.o, this.p);
      this.i.postValue(paramList);
      if (this.n.isEmpty())
      {
        this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new l(-1, -1L, null)));
        return;
      }
      paramList = Calendar.getInstance();
      paramList.setTimeInMillis(this.x.f());
      O1(paramList);
      if (u0(paramList, this.r))
      {
        paramList = this.n;
        paramList = (DailyPlaybackItem)paramList.get(paramList.size() - 1);
      }
      else
      {
        paramList = (DailyPlaybackItem)this.n.get(0);
      }
      long l1 = paramList.getStartTime();
      int[] arrayOfInt = T(this.n);
      l1 *= 1000L;
      paramList = new l(paramInt, l1, arrayOfInt);
      this.v = l1;
      this.w = arrayOfInt;
      this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramList));
    }
    else
    {
      this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new l(-1, -1L, null)));
    }
  }
  
  private void o0(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CameraException))
    {
      int i1 = ((CameraException)paramThrowable).getErrorCode();
      if ((i1 == -71101) || (i1 == -71102) || (i1 == -71103))
      {
        r0();
        this.l.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(i1)));
      }
    }
    this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new l(-1, -1L, null)));
  }
  
  private void p0(List<DailyPlaybackItem> paramList, long paramLong)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.n.clear();
      paramList = E(paramList, this.r);
      this.n.addAll(paramList.e());
      j2(this.n, this.o, this.p);
      this.i.postValue(paramList);
      if (this.n.isEmpty())
      {
        this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new l(-1, -1L, null)));
        return;
      }
      paramList = this.n;
      long l1 = ((DailyPlaybackItem)paramList.get(paramList.size() - 1)).getStartTime();
      paramList = T(this.n);
      if (paramLong > 0L) {
        l1 = e2(paramLong, H(paramList, PlayBackEventType.TYPE_TIMING.getValue()), H(paramList, PlayBackEventType.TYPE_MOTION.getValue()));
      }
      int i1 = this.q;
      paramLong = l1 * 1000L;
      l locall = new l(i1, paramLong, paramList);
      this.v = paramLong;
      this.w = paramList;
      this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(locall));
    }
    else
    {
      this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(new l(-1, -1L, null)));
    }
  }
  
  private boolean s0(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    O1(localCalendar1);
    O1(localCalendar2);
    return u0(localCalendar1, localCalendar2);
  }
  
  private boolean t(Date paramDate)
  {
    paramDate = Q(paramDate);
    return this.m.containsKey(paramDate);
  }
  
  private boolean t0(j paramj, Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramj.c());
    localCalendar.set(2, paramj.b());
    localCalendar.set(5, paramj.a());
    paramj = Calendar.getInstance();
    paramj.setTime(paramDate);
    return u0(localCalendar, paramj);
  }
  
  private boolean u(long paramLong, List<j> paramList)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong);
    O1(localCalendar1);
    Calendar localCalendar2 = Calendar.getInstance();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (j)localIterator.next();
      localCalendar2.set(1, paramList.c());
      localCalendar2.set(2, paramList.b());
      localCalendar2.set(5, paramList.a());
      O1(localCalendar2);
      if (u0(localCalendar2, localCalendar1)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean u0(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    boolean bool = true;
    if ((paramCalendar1.get(1) != paramCalendar2.get(1)) || (paramCalendar1.get(2) != paramCalendar2.get(2)) || (paramCalendar1.get(5) != paramCalendar2.get(5))) {
      bool = false;
    }
    return bool;
  }
  
  private boolean v(long paramLong)
  {
    if (this.x.p())
    {
      long l1 = this.x.h(paramLong, 0);
      long l2 = this.x.g(paramLong, 0);
      int i1;
      if (l1 < l2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 != 0) && (this.x.q(paramLong, l1, l2))) {
        return true;
      }
      if ((i1 == 0) && (this.x.r(paramLong, l1, l2))) {
        return true;
      }
    }
    return false;
  }
  
  private List<j> x(List<YearlyPlaybackItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (YearlyPlaybackItem)paramList.next();
        Date localDate = new SimpleDateFormat("yyyyMMdd", Locale.US).parse(((YearlyPlaybackItem)localObject).getDate(), new ParsePosition(0));
        if (localDate != null)
        {
          localObject = Calendar.getInstance();
          ((Calendar)localObject).setTime(localDate);
          localArrayList.add(new j(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5)));
        }
      }
    }
    return localArrayList;
  }
  
  private Date y(j paramj)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramj.c());
    localCalendar.set(2, paramj.b());
    localCalendar.set(5, paramj.a());
    return localCalendar.getTime();
  }
  
  private List<DailyPlaybackItem> z(DailyPlaybackItem paramDailyPlaybackItem, long paramLong, Calendar paramCalendar)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new DailyPlaybackItem(paramDailyPlaybackItem.getStartTime(), paramLong - 1L, paramDailyPlaybackItem.getType());
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(((DailyPlaybackItem)localObject).getStartTime() * 1000L);
    O1(localCalendar);
    if (u0(localCalendar, paramCalendar)) {
      localArrayList.add(localObject);
    }
    paramDailyPlaybackItem = new DailyPlaybackItem(paramLong, paramDailyPlaybackItem.getEndTime(), paramDailyPlaybackItem.getType());
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramDailyPlaybackItem.getStartTime() * 1000L);
    O1((Calendar)localObject);
    if (u0((Calendar)localObject, paramCalendar)) {
      localArrayList.add(paramDailyPlaybackItem);
    }
    return localArrayList;
  }
  
  public void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new int[0];
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2))
    {
      localObject2 = new int[2];
      Object tmp19_17 = localObject2;
      tmp19_17[0] = 1;
      Object tmp23_19 = tmp19_17;
      tmp23_19[1] = 2;
      tmp23_19;
    }
    else if ((!paramBoolean1) && (paramBoolean2))
    {
      localObject2 = new int[1];
      localObject2[0] = 2;
    }
    else
    {
      localObject2 = localObject1;
      if (paramBoolean1)
      {
        localObject2 = localObject1;
        if (!paramBoolean2)
        {
          localObject2 = new int[1];
          localObject2[0] = 1;
        }
      }
    }
    if (!this.n.isEmpty())
    {
      long l1 = S(this.n, paramBoolean1, paramBoolean2);
      long l2 = l1;
      if (l1 < 0L) {
        l2 = ((DailyPlaybackItem)this.n.get(0)).getStartTime();
      }
      localObject1 = localObject2;
      if (localObject2.length == 0) {
        localObject1 = T(this.n);
      }
      int i1 = this.q;
      l2 *= 1000L;
      localObject2 = new l(i1, l2, (int[])localObject1);
      this.v = l2;
      this.w = ((int[])localObject1);
      this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localObject2));
    }
  }
  
  public long J()
  {
    return this.u;
  }
  
  public Calendar K()
  {
    return this.r;
  }
  
  public boolean N1(long paramLong)
  {
    boolean bool1 = this.x.p();
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      long l1 = this.x.g(paramLong, 0);
      bool3 = bool2;
      if (paramLong > l1 - this.x.k())
      {
        bool3 = bool2;
        if (paramLong <= l1) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public void O1(Calendar paramCalendar)
  {
    int i1 = this.x.j();
    int i2 = i1;
    if (this.x.p())
    {
      k localk = this.x;
      long l1 = paramCalendar.getTimeInMillis();
      i2 = 0;
      long l2 = localk.h(l1, 0);
      l1 = this.x.g(paramCalendar.getTimeInMillis(), 0);
      if (l2 < l1) {
        i2 = 1;
      }
      if ((i2 != 0) && (this.x.q(paramCalendar.getTimeInMillis(), l2, l1)))
      {
        i2 = i1;
        if (this.x.o()) {}
      }
      else
      {
        for (i2 = this.x.k();; i2 = this.x.k())
        {
          i2 = i1 + i2;
          break label184;
          if ((i2 != 0) || (!this.x.r(paramCalendar.getTimeInMillis(), l2, l1))) {
            break;
          }
          i2 = i1;
          if (this.x.o()) {
            break label184;
          }
        }
        i2 = i1;
        if (this.x.o()) {
          i2 = i1 - this.x.k();
        }
      }
    }
    label184:
    P1(paramCalendar, i2);
  }
  
  public int Q1(long paramLong)
  {
    if (this.x.p())
    {
      long l1 = this.x.g(paramLong, 0);
      long l2 = paramLong - l1;
      if ((l2 > 0L) && (l2 < 86400000L) && (s0(paramLong, l1))) {
        return this.x.k() / 1000;
      }
    }
    return 0;
  }
  
  public TimeZone R()
  {
    Object localObject = this.x;
    if (localObject != null) {
      localObject = ((k)localObject).l();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      localObject = this.y;
    }
    return (TimeZone)localObject;
  }
  
  public void R1()
  {
    S1(-1L);
  }
  
  public void S1(long paramLong)
  {
    if (this.w == null) {
      this.w = T(this.n);
    }
    if ((paramLong > 0L) && (paramLong != this.v)) {
      this.v = (paramLong * 1000L);
    }
    l locall = new l(this.q, this.v, this.w);
    this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(locall));
  }
  
  public q<Boolean> T1(CameraComponent paramCameraComponent)
  {
    return V1(paramCameraComponent).v0(1L, new k5(this));
  }
  
  public long W()
  {
    return this.t;
  }
  
  public k Y()
  {
    return this.x;
  }
  
  public q<Boolean> Y1(long paramLong)
  {
    Date localDate1 = U(paramLong);
    Date localDate2 = V(paramLong);
    if (t(new Date(paramLong))) {
      return q.f0(Boolean.TRUE);
    }
    return m0(l(), localDate1, localDate2).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new b5(this)).g0(e4.c).C(f7.c);
  }
  
  public MutableLiveData<Boolean> Z()
  {
    return this.e;
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.business.model.m> a0()
  {
    return this.i;
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Long>> b0()
  {
    return this.h;
  }
  
  public q<Boolean> b2()
  {
    return Z1().v0(1L, new o4(this));
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<l>> c0()
  {
    return this.g;
  }
  
  public q<CameraComponent> c2(CameraComponent paramCameraComponent, long paramLong1, long paramLong2)
  {
    return X(paramCameraComponent, paramLong1).N(new j5(this, paramLong2)).N(new r4(this, paramCameraComponent)).v0(1L, new z4(this)).l0(io.reactivex.d0.b.a.a()).E(new d4(this, paramLong2)).o0(new r5(this)).g0(new p4(paramCameraComponent));
  }
  
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> d0()
  {
    return this.l;
  }
  
  public MutableLiveData<List<j>> e0()
  {
    return this.k;
  }
  
  public MutableLiveData<Boolean> f0()
  {
    return this.f;
  }
  
  public void f2(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      int i1 = paramInt / 3600;
      int i2 = paramInt / 60;
      int i3 = ((Calendar)localObject).get(1);
      int i4 = this.r.get(2);
      int i5 = this.r.get(5);
      long l1 = this.x.m(i3, i4, i5, i1, i2 % 60, paramInt % 60);
      long l2 = l1;
      if (paramBoolean1) {
        l2 = l1 - this.x.k() / 1000;
      }
      l2 = e2(l2, paramBoolean2, paramBoolean3);
      paramInt = this.q;
      l2 *= 1000L;
      localObject = new l(paramInt, l2, null);
      this.v = l2;
      this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(localObject));
    }
  }
  
  public MutableLiveData<n> g0()
  {
    return this.j;
  }
  
  public void g2(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramLong = e2(paramLong, paramBoolean1, paramBoolean2);
    int i1 = this.q;
    paramLong *= 1000L;
    l locall = new l(i1, paramLong, null);
    this.v = paramLong;
    this.g.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(locall));
  }
  
  public void h2(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.r == null) {
      this.r = Calendar.getInstance();
    }
    this.r.set(1, paramInt1);
    this.r.set(2, paramInt2);
    this.r.set(5, paramInt3);
  }
  
  public void i2(long paramLong)
  {
    this.v = paramLong;
  }
  
  public Calendar j0()
  {
    return this.s;
  }
  
  public int k0()
  {
    return this.q;
  }
  
  public void q0()
  {
    Calendar localCalendar = Calendar.getInstance();
    this.r = localCalendar;
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    localCalendar = Calendar.getInstance();
    this.s = localCalendar;
    localCalendar.setTimeInMillis(this.r.getTimeInMillis());
    this.v = System.currentTimeMillis();
    this.t = System.currentTimeMillis();
    this.u = System.currentTimeMillis();
    this.x = new k();
    this.m.clear();
    this.n.clear();
    this.o.clear();
    this.p.clear();
    this.i.setValue(new com.tplink.libtpnetwork.cameranetwork.business.model.m());
    this.j.setValue(new n());
    this.k.setValue(new ArrayList());
  }
  
  public void r0()
  {
    this.q = -1;
  }
  
  public boolean s(Date paramDate)
  {
    Object localObject = Q(paramDate);
    boolean bool1 = this.m.containsKey(localObject);
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      localObject = (List)this.m.get(localObject);
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      do
      {
        bool3 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!t0((j)((Iterator)localObject).next(), paramDate));
      bool3 = true;
    }
    return bool3;
  }
  
  public boolean w(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (!this.n.isEmpty())
      {
        localObject = this.n;
        localObject = (DailyPlaybackItem)((List)localObject).get(((List)localObject).size() - 1);
        if (Math.abs(paramLong / 1000L - ((DailyPlaybackItem)localObject).getEndTime()) <= 0L) {
          return true;
        }
      }
    }
    else if ((paramBoolean1) && (!paramBoolean2))
    {
      if (!this.o.isEmpty())
      {
        localObject = this.o;
        localObject = (DailyPlaybackItem)((List)localObject).get(((List)localObject).size() - 1);
        if (Math.abs(paramLong / 1000L - ((DailyPlaybackItem)localObject).getEndTime()) <= 0L) {
          return true;
        }
      }
    }
    else if ((!paramBoolean1) && (paramBoolean2) && (!this.p.isEmpty()))
    {
      localObject = this.p;
      localObject = (DailyPlaybackItem)((List)localObject).get(((List)localObject).size() - 1);
      if (Math.abs(paramLong / 1000L - ((DailyPlaybackItem)localObject).getEndTime()) <= 0L) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\PlayBackRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */