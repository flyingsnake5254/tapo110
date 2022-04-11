package com.tplink.iot.dailysummary.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.dailysummary.network.DailySummaryRepository;
import com.tplink.iot.dailysummary.network.bean.common.Summary;
import com.tplink.iot.dailysummary.network.bean.params.CancelCreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.params.CreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.result.RecentSummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryEventIdResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;

public abstract class BaseSummaryListViewModel
  extends AndroidViewModel
{
  public static final a a = new a(null);
  private String b = "";
  private DailySummaryRepository c;
  private final HashMap<String, String> d;
  private int e;
  private final MutableLiveData<Boolean> f = new MutableLiveData();
  private final MutableLiveData<HashMap<String, Integer>> g;
  private final MutableLiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> h;
  private final MutableLiveData<Boolean> i;
  private final MutableLiveData<Boolean> j;
  private final MutableLiveData<Boolean> k;
  private final MutableLiveData<Boolean> l;
  private final MutableLiveData<Boolean> m;
  
  public BaseSummaryListViewModel(Application paramApplication)
  {
    super(paramApplication);
    paramApplication = new MutableLiveData();
    this.g = paramApplication;
    this.h = new MutableLiveData();
    this.i = new MutableLiveData();
    this.j = new MutableLiveData();
    this.k = new MutableLiveData();
    this.l = new MutableLiveData();
    this.m = new MutableLiveData();
    if (this.c == null) {
      this.c = ((DailySummaryRepository)b.d.b.f.b.a(b.d.s.a.a.f(), DailySummaryRepository.class));
    }
    com.tplink.iot.e.a.c localc = com.tplink.iot.e.a.c.k;
    this.d = localc.f();
    paramApplication.setValue(localc.k());
  }
  
  private final void j(final CancelCreateSummaryParams paramCancelCreateSummaryParams, final String paramString, final int paramInt)
  {
    Object localObject = (ArrayList)this.h.getValue();
    int n;
    if (localObject != null) {
      n = ((ArrayList)localObject).size();
    } else {
      n = 0;
    }
    if (n <= paramInt) {
      return;
    }
    localObject = this.c;
    if (localObject != null) {
      ((DailySummaryRepository)localObject).C(paramCancelCreateSummaryParams).H0(new b(this, paramCancelCreateSummaryParams, paramInt, paramString), new c(this, paramCancelCreateSummaryParams, paramInt, paramString));
    }
  }
  
  private final void l(final CreateSummaryParams paramCreateSummaryParams, final String paramString, final int paramInt)
  {
    Object localObject = (ArrayList)this.h.getValue();
    int n;
    if (localObject != null) {
      n = ((ArrayList)localObject).size();
    } else {
      n = 0;
    }
    if (n <= paramInt) {
      return;
    }
    localObject = this.c;
    if (localObject != null) {
      ((DailySummaryRepository)localObject).E(paramCreateSummaryParams).E(new d(this, paramCreateSummaryParams, paramInt, paramString)).C(new e(this, paramCreateSummaryParams, paramInt, paramString)).F0();
    }
  }
  
  protected final void A(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    j.e(paramString, "deviceId");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    DailySummaryRepository localDailySummaryRepository = this.c;
    if (localDailySummaryRepository != null) {
      localDailySummaryRepository.H(paramString, paramInt).F(new h(this, paramString, paramInt, paramBoolean)).H0(new i(this, paramString, paramInt, paramBoolean), new j(this, paramString, paramInt, paramBoolean));
    }
  }
  
  public final MutableLiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> C()
  {
    return this.h;
  }
  
  protected final void D(final String paramString, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    j.e(paramString, "deviceId");
    if (paramString.length() == 0) {
      return;
    }
    DailySummaryRepository localDailySummaryRepository = this.c;
    if (localDailySummaryRepository != null) {
      localDailySummaryRepository.L(paramString, paramInt1, paramInt2).F(new k(this, paramString, paramInt1, paramInt2, paramBoolean)).H0(new l(this, paramString, paramInt1, paramInt2, paramBoolean), new m(this, paramString, paramInt1, paramInt2, paramBoolean));
    }
  }
  
  protected final void F(String paramString)
  {
    j.e(paramString, "<set-?>");
    this.b = paramString;
  }
  
  protected final void G(DailySummaryRepository paramDailySummaryRepository)
  {
    this.c = paramDailySummaryRepository;
  }
  
  public final void k(int paramInt1, int paramInt2)
  {
    Object localObject1 = (ArrayList)this.h.getValue();
    int n;
    if (localObject1 != null) {
      n = ((ArrayList)localObject1).size();
    } else {
      n = 0;
    }
    if (n <= paramInt1) {
      return;
    }
    Object localObject2;
    if (paramInt2 != 0)
    {
      if (paramInt2 == 1)
      {
        localObject1 = (ArrayList)this.h.getValue();
        if (localObject1 != null)
        {
          localObject1 = ((com.tplink.iot.dailysummary.model.b)((ArrayList)localObject1).get(paramInt1)).c();
          localObject2 = new CreateSummaryParams();
          ((CreateSummaryParams)localObject2).setDeviceId(this.b);
          ((CreateSummaryParams)localObject2).setDate((String)localObject1);
          l((CreateSummaryParams)localObject2, (String)localObject1, paramInt1);
        }
      }
    }
    else
    {
      localObject1 = (ArrayList)this.h.getValue();
      if (localObject1 != null)
      {
        localObject1 = ((com.tplink.iot.dailysummary.model.b)((ArrayList)localObject1).get(paramInt1)).c();
        localObject2 = new CancelCreateSummaryParams();
        ((CancelCreateSummaryParams)localObject2).setDeviceId(this.b);
        if (this.d.containsKey(localObject1)) {
          ((CancelCreateSummaryParams)localObject2).setEventId((String)this.d.get(localObject1));
        }
        j((CancelCreateSummaryParams)localObject2, (String)localObject1, paramInt1);
      }
    }
  }
  
  public final MutableLiveData<Boolean> m()
  {
    return this.k;
  }
  
  public final MutableLiveData<Boolean> n()
  {
    return this.f;
  }
  
  public final MutableLiveData<Boolean> o()
  {
    return this.i;
  }
  
  public final MutableLiveData<Boolean> p()
  {
    return this.j;
  }
  
  protected final MutableLiveData<Boolean> r()
  {
    return this.f;
  }
  
  protected final String s()
  {
    return this.b;
  }
  
  protected final DailySummaryRepository t()
  {
    return this.c;
  }
  
  protected final HashMap<String, String> u()
  {
    return this.d;
  }
  
  protected final MutableLiveData<Boolean> v()
  {
    return this.i;
  }
  
  protected final MutableLiveData<Boolean> w()
  {
    return this.j;
  }
  
  protected final MutableLiveData<ArrayList<com.tplink.iot.dailysummary.model.b>> x()
  {
    return this.h;
  }
  
  protected final MutableLiveData<HashMap<String, Integer>> y()
  {
    return this.g;
  }
  
  protected final void z(final String paramString, final int paramInt)
  {
    j.e(paramString, "deviceId");
    DailySummaryRepository localDailySummaryRepository = this.c;
    if (localDailySummaryRepository != null) {
      localDailySummaryRepository.L(paramString, this.e, paramInt).H0(new f(this, paramString, paramInt), new g(this, paramString, paramInt));
    }
  }
  
  public static final class a {}
  
  static final class b<T>
    implements g<SummaryEventIdResult>
  {
    b(BaseSummaryListViewModel paramBaseSummaryListViewModel, CancelCreateSummaryParams paramCancelCreateSummaryParams, int paramInt, String paramString) {}
    
    public final void a(SummaryEventIdResult paramSummaryEventIdResult)
    {
      b.d.w.c.a.c("tylerTest", "cancel create success!");
      paramSummaryEventIdResult = (ArrayList)this.c.x().getValue();
      if (paramSummaryEventIdResult != null) {
        ((com.tplink.iot.dailysummary.model.b)paramSummaryEventIdResult.get(paramInt)).r(0);
      }
      this.c.x().setValue(this.c.x().getValue());
      if (this.c.u().containsKey(paramString)) {
        this.c.u().remove(paramString);
      }
      BaseSummaryListViewModel.f(this.c).setValue(Boolean.TRUE);
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(BaseSummaryListViewModel paramBaseSummaryListViewModel, CancelCreateSummaryParams paramCancelCreateSummaryParams, int paramInt, String paramString) {}
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.c("tylerTest", "cancel create summary failed!");
      BaseSummaryListViewModel.f(this.c).setValue(Boolean.FALSE);
    }
  }
  
  static final class d<T>
    implements g<SummaryEventIdResult>
  {
    d(BaseSummaryListViewModel paramBaseSummaryListViewModel, CreateSummaryParams paramCreateSummaryParams, int paramInt, String paramString) {}
    
    public final void a(SummaryEventIdResult paramSummaryEventIdResult)
    {
      Object localObject = (ArrayList)this.c.x().getValue();
      if (localObject != null) {
        ((com.tplink.iot.dailysummary.model.b)((ArrayList)localObject).get(paramInt)).r(1);
      }
      this.c.x().setValue(this.c.x().getValue());
      BaseSummaryListViewModel.g(this.c).setValue(Boolean.TRUE);
      HashMap localHashMap = this.c.u();
      localObject = paramString;
      j.d(paramSummaryEventIdResult, "it");
      localHashMap.put(localObject, paramSummaryEventIdResult.getEventId());
      com.tplink.iot.e.a.c.k.o(true);
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(BaseSummaryListViewModel paramBaseSummaryListViewModel, CreateSummaryParams paramCreateSummaryParams, int paramInt, String paramString) {}
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.c("BaseSLViewModel-tyler", "create summary failed!");
      BaseSummaryListViewModel.g(this.c).setValue(Boolean.FALSE);
    }
  }
  
  static final class f<T>
    implements g<SummaryListResult>
  {
    f(BaseSummaryListViewModel paramBaseSummaryListViewModel, String paramString, int paramInt) {}
    
    public final void a(SummaryListResult paramSummaryListResult)
    {
      j.d(paramSummaryListResult, "it");
      Object localObject1 = paramSummaryListResult.getDateList();
      paramSummaryListResult = (ArrayList)this.c.x().getValue();
      if (paramSummaryListResult == null) {
        paramSummaryListResult = new ArrayList();
      }
      int i = ((List)localObject1).size() - 1;
      if (i >= 0) {
        for (int j = 0;; j++)
        {
          SummaryResult localSummaryResult = (SummaryResult)((List)localObject1).get(j);
          j.d(localSummaryResult, "summaryResult");
          Object localObject2 = com.tplink.iot.e.a.a.e(localSummaryResult);
          if (localObject2 != null)
          {
            int k = ((com.tplink.iot.dailysummary.model.b)localObject2).j();
            if ((k == 2) || (k == 1) || (k == 0))
            {
              localObject3 = com.tplink.iot.e.a.c.k;
              ((com.tplink.iot.e.a.c)localObject3).k().put(((com.tplink.iot.dailysummary.model.b)localObject2).c(), Integer.valueOf(k));
              this.c.y().setValue(((com.tplink.iot.e.a.c)localObject3).k());
            }
            paramSummaryListResult.add(localObject2);
            Object localObject3 = localSummaryResult.getSummaryList().get(0);
            j.d(localObject3, "summaryResult.summaryList[0]");
            localObject3 = ((Summary)localObject3).getEventId();
            if (localObject3 != null) {
              localObject2 = (String)this.c.u().put(((com.tplink.iot.dailysummary.model.b)localObject2).c(), localObject3);
            }
          }
          if (j == i) {
            break;
          }
        }
      }
      localObject1 = this.c;
      BaseSummaryListViewModel.i((BaseSummaryListViewModel)localObject1, BaseSummaryListViewModel.h((BaseSummaryListViewModel)localObject1) + 1);
      localObject1 = com.tplink.iot.e.a.c.k;
      if (((com.tplink.iot.e.a.c)localObject1).c() < BaseSummaryListViewModel.h(this.c)) {
        ((com.tplink.iot.e.a.c)localObject1).n(BaseSummaryListViewModel.h(this.c));
      }
      this.c.x().setValue(paramSummaryListResult);
      this.c.v().setValue(Boolean.TRUE);
      this.c.w().postValue(Boolean.FALSE);
    }
  }
  
  static final class g<T>
    implements g<Throwable>
  {
    g(BaseSummaryListViewModel paramBaseSummaryListViewModel, String paramString, int paramInt) {}
    
    public final void a(Throwable paramThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c.getClass().getSimpleName());
      ((StringBuilder)localObject).append(" getSummaryList failed!\n");
      ((StringBuilder)localObject).append(paramThrowable.getMessage());
      b.d.w.c.a.c("tylerTest", ((StringBuilder)localObject).toString());
      localObject = this.c.w();
      Boolean localBoolean = Boolean.FALSE;
      ((MutableLiveData)localObject).postValue(localBoolean);
      if ((!"parameter errror".equals(paramThrowable.getMessage())) && (!"Index: 0".equals(paramThrowable.getMessage()))) {
        this.c.v().setValue(localBoolean);
      }
    }
  }
  
  static final class h<T>
    implements g<io.reactivex.e0.c>
  {
    h(BaseSummaryListViewModel paramBaseSummaryListViewModel, String paramString, int paramInt, boolean paramBoolean) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      this.c.w().postValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  static final class i<T>
    implements g<RecentSummaryListResult>
  {
    i(BaseSummaryListViewModel paramBaseSummaryListViewModel, String paramString, int paramInt, boolean paramBoolean) {}
    
    public final void a(RecentSummaryListResult paramRecentSummaryListResult)
    {
      j.d(paramRecentSummaryListResult, "it");
      List localList = paramRecentSummaryListResult.getDateList();
      int i;
      if (localList != null) {
        i = localList.size();
      } else {
        i = 0;
      }
      if (i > 0)
      {
        paramRecentSummaryListResult = new ArrayList();
        int j = localList.size() - 1;
        if (j >= 0) {
          for (i = 0;; i++)
          {
            SummaryResult localSummaryResult = (SummaryResult)localList.get(i);
            j.d(localSummaryResult, "summryResult");
            Object localObject1 = com.tplink.iot.e.a.a.e(localSummaryResult);
            if (localObject1 != null)
            {
              int k = ((com.tplink.iot.dailysummary.model.b)localObject1).j();
              if (k == 2)
              {
                localObject2 = com.tplink.iot.e.a.c.k;
                ((com.tplink.iot.e.a.c)localObject2).k().put(((com.tplink.iot.dailysummary.model.b)localObject1).c(), Integer.valueOf(k));
                this.c.y().setValue(((com.tplink.iot.e.a.c)localObject2).k());
              }
              paramRecentSummaryListResult.add(localObject1);
              Object localObject2 = localSummaryResult.getSummaryList().get(0);
              j.d(localObject2, "summryResult.summaryList[0]");
              localObject2 = ((Summary)localObject2).getEventId();
              if (localObject2 != null) {
                localObject1 = (String)this.c.u().put(((com.tplink.iot.dailysummary.model.b)localObject1).c(), localObject2);
              }
            }
            if (i == j) {
              break;
            }
          }
        }
        this.c.x().setValue(paramRecentSummaryListResult);
        if (paramInt == 30) {
          com.tplink.iot.e.a.c.k.p(true);
        }
      }
      this.c.v().setValue(Boolean.TRUE);
      this.c.w().postValue(Boolean.FALSE);
    }
  }
  
  static final class j<T>
    implements g<Throwable>
  {
    j(BaseSummaryListViewModel paramBaseSummaryListViewModel, String paramString, int paramInt, boolean paramBoolean) {}
    
    public final void a(Throwable paramThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRecentSummaryList failed: \n");
      ((StringBuilder)localObject).append(paramThrowable.getMessage());
      b.d.w.c.a.c("BaseSLViewModel-tyler", ((StringBuilder)localObject).toString());
      localObject = this.c.w();
      paramThrowable = Boolean.FALSE;
      ((MutableLiveData)localObject).postValue(paramThrowable);
      this.c.v().setValue(paramThrowable);
    }
  }
  
  static final class k<T>
    implements g<io.reactivex.e0.c>
  {
    k(BaseSummaryListViewModel paramBaseSummaryListViewModel, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      this.c.w().postValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  static final class l<T>
    implements g<SummaryListResult>
  {
    l(BaseSummaryListViewModel paramBaseSummaryListViewModel, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {}
    
    public final void a(SummaryListResult paramSummaryListResult)
    {
      j.d(paramSummaryListResult, "it");
      Object localObject1 = paramSummaryListResult.getDateList();
      paramSummaryListResult = new ArrayList();
      int i = ((List)localObject1).size() - 1;
      if (i >= 0) {
        for (j = 0;; j++)
        {
          SummaryResult localSummaryResult = (SummaryResult)((List)localObject1).get(j);
          j.d(localSummaryResult, "summryResult");
          Object localObject2 = com.tplink.iot.e.a.a.e(localSummaryResult);
          if (localObject2 != null)
          {
            k = ((com.tplink.iot.dailysummary.model.b)localObject2).j();
            if ((k == 2) || (k == 1) || (k == 0))
            {
              localObject3 = com.tplink.iot.e.a.c.k;
              ((com.tplink.iot.e.a.c)localObject3).k().put(((com.tplink.iot.dailysummary.model.b)localObject2).c(), Integer.valueOf(k));
              this.c.y().setValue(((com.tplink.iot.e.a.c)localObject3).k());
            }
            paramSummaryListResult.add(localObject2);
            Object localObject3 = localSummaryResult.getSummaryList().get(0);
            j.d(localObject3, "summryResult.summaryList[0]");
            localObject3 = ((Summary)localObject3).getEventId();
            if (localObject3 != null) {
              localObject2 = (String)this.c.u().put(((com.tplink.iot.dailysummary.model.b)localObject2).c(), localObject3);
            }
          }
          if (j == i) {
            break;
          }
        }
      }
      if ((paramInt1 == 0) && (paramInt2 == 10))
      {
        BaseSummaryListViewModel.i(this.c, 1);
        localObject1 = com.tplink.iot.e.a.c.k;
        if (((com.tplink.iot.e.a.c)localObject1).c() < BaseSummaryListViewModel.h(this.c)) {
          ((com.tplink.iot.e.a.c)localObject1).n(BaseSummaryListViewModel.h(this.c));
        }
      }
      int j = paramSummaryListResult.size();
      int k = paramInt1;
      i = paramInt2;
      if (j < (k + 1) * i) {
        this.c.z(paramString, i);
      }
      this.c.x().setValue(paramSummaryListResult);
      this.c.v().setValue(Boolean.TRUE);
      this.c.w().postValue(Boolean.FALSE);
    }
  }
  
  static final class m<T>
    implements g<Throwable>
  {
    m(BaseSummaryListViewModel paramBaseSummaryListViewModel, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {}
    
    public final void a(Throwable paramThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSummaryList failed: \n");
      ((StringBuilder)localObject).append(paramThrowable.getMessage());
      b.d.w.c.a.c("BaseSLViewModel-tyler", ((StringBuilder)localObject).toString());
      localObject = this.c.w();
      Boolean localBoolean = Boolean.FALSE;
      ((MutableLiveData)localObject).postValue(localBoolean);
      if ((!"parameter errror".equals(paramThrowable.getMessage())) && (!"Index: 0".equals(paramThrowable.getMessage()))) {
        this.c.v().setValue(localBoolean);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\viewmodel\BaseSummaryListViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */