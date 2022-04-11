package com.tplink.iot.dailysummary.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.network.DailySummaryRepository;
import com.tplink.iot.dailysummary.network.bean.common.DeleteSummaryInfo;
import com.tplink.iot.dailysummary.network.bean.params.DeleteSummaryParams;
import com.tplink.iot.e.a.c;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.j;

public final class SummaryHistoryViewModel
  extends BaseSummaryListViewModel
{
  public static final a n = new a(null);
  private final Set<DeleteSummaryInfo> o = new LinkedHashSet();
  private final MutableLiveData<d> p;
  private final LiveData<Boolean> q;
  private final MutableLiveData<Boolean> r;
  private final MutableLiveData<Boolean> s;
  private final MutableLiveData<Integer> t;
  private final MutableLiveData<Boolean> u;
  private final MutableLiveData<Integer> v;
  private final MutableLiveData<Boolean> w;
  
  public SummaryHistoryViewModel(Application paramApplication)
  {
    super(paramApplication);
    paramApplication = new MutableLiveData();
    this.p = paramApplication;
    Object localObject = Transformations.map(x(), d.a);
    j.d(localObject, "Transformations.map(mSummaryList) { it.size > 0 }");
    this.q = ((LiveData)localObject);
    this.r = new MutableLiveData();
    this.s = new MutableLiveData();
    this.t = new MutableLiveData();
    this.u = new MutableLiveData();
    this.v = new MutableLiveData();
    this.w = new MutableLiveData();
    localObject = c.k;
    paramApplication.setValue(((c)localObject).j());
    F(((c)localObject).b());
    paramApplication = r();
    localObject = (Boolean)((c)localObject).e().get(s());
    boolean bool;
    if (localObject != null) {
      bool = ((Boolean)localObject).booleanValue();
    } else {
      bool = false;
    }
    paramApplication.setValue(Boolean.valueOf(bool));
  }
  
  private final void N(final DeleteSummaryParams paramDeleteSummaryParams)
  {
    DailySummaryRepository localDailySummaryRepository = t();
    if (localDailySummaryRepository != null) {
      localDailySummaryRepository.F(paramDeleteSummaryParams).A(new b(this, paramDeleteSummaryParams), new c(this, paramDeleteSummaryParams));
    }
  }
  
  private final void Y()
  {
    this.s.setValue(Boolean.FALSE);
    this.t.setValue(Integer.valueOf(0));
    this.o.clear();
  }
  
  private final void Z()
  {
    this.r.setValue(Boolean.FALSE);
    Y();
  }
  
  public final void J(boolean paramBoolean)
  {
    this.r.setValue(Boolean.valueOf(paramBoolean));
    Y();
  }
  
  public final void K()
  {
    Object localObject = (Boolean)this.s.getValue();
    boolean bool = false;
    int i = 0;
    int j;
    if (localObject != null)
    {
      bool = ((Boolean)localObject).booleanValue() ^ true;
      ArrayList localArrayList = (ArrayList)x().getValue();
      j = i;
      if (localArrayList != null)
      {
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((b)((Iterator)localObject).next()).p(bool);
        }
        j = i;
        if (bool) {
          j = localArrayList.size();
        }
      }
    }
    else
    {
      j = 0;
    }
    this.s.setValue(Boolean.valueOf(bool));
    this.t.setValue(Integer.valueOf(j));
    x().setValue(x().getValue());
  }
  
  public final void L(int paramInt)
  {
    Object localObject = (ArrayList)x().getValue();
    if (localObject != null)
    {
      boolean bool1 = ((b)((ArrayList)localObject).get(paramInt)).n();
      boolean bool2 = true;
      bool1 ^= true;
      ((b)((ArrayList)localObject).get(paramInt)).p(bool1);
      int i = ((ArrayList)localObject).size();
      localObject = (Integer)this.t.getValue();
      if (localObject != null)
      {
        paramInt = ((Integer)localObject).intValue();
        if (bool1) {
          paramInt++;
        } else {
          paramInt--;
        }
        localObject = this.s;
        if (paramInt != i) {
          bool2 = false;
        }
        ((MutableLiveData)localObject).setValue(Boolean.valueOf(bool2));
        this.t.setValue(Integer.valueOf(Math.min(Math.max(paramInt, 0), i)));
      }
    }
  }
  
  public final void M()
  {
    if (j.a((Boolean)this.r.getValue(), Boolean.TRUE))
    {
      Object localObject1 = (ArrayList)x().getValue();
      if (localObject1 != null)
      {
        Object localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (b)((Iterator)localObject2).next();
          if (((b)localObject3).n())
          {
            localObject1 = new DeleteSummaryInfo();
            ((DeleteSummaryInfo)localObject1).setDate(((b)localObject3).c());
            ((DeleteSummaryInfo)localObject1).setUuidList(new ArrayList());
            localObject3 = ((b)localObject3).l();
            if (localObject3 != null) {
              ((DeleteSummaryInfo)localObject1).getUuidList().add(localObject3);
            }
            this.o.add(localObject1);
          }
        }
        localObject1 = new DeleteSummaryParams();
        ((DeleteSummaryParams)localObject1).setDeviceId(s());
        localObject2 = new ArrayList();
        Object localObject3 = this.o.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).add((DeleteSummaryInfo)((Iterator)localObject3).next());
        }
        ((DeleteSummaryParams)localObject1).setDateList((List)localObject2);
        N((DeleteSummaryParams)localObject1);
      }
    }
  }
  
  public final MutableLiveData<Boolean> O()
  {
    return this.u;
  }
  
  public final MutableLiveData<Boolean> P()
  {
    return this.r;
  }
  
  public final LiveData<Boolean> Q()
  {
    return this.q;
  }
  
  public final void R()
  {
    super.z(s(), 10);
  }
  
  public final MutableLiveData<d> S()
  {
    return this.p;
  }
  
  public final MutableLiveData<Boolean> T()
  {
    return this.w;
  }
  
  public final MutableLiveData<Boolean> U()
  {
    return this.s;
  }
  
  public final MutableLiveData<Integer> V()
  {
    return this.t;
  }
  
  public final void W(boolean paramBoolean)
  {
    a0(paramBoolean);
    Z();
    c.k.r(false);
  }
  
  protected void a0(boolean paramBoolean)
  {
    if (j.a((Boolean)r().getValue(), Boolean.TRUE)) {
      D(s(), 0, 10, paramBoolean);
    } else {
      A(s(), 30, paramBoolean);
    }
  }
  
  public final void b0(boolean paramBoolean)
  {
    this.w.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public static final class a {}
  
  static final class b
    implements io.reactivex.g0.a
  {
    b(SummaryHistoryViewModel paramSummaryHistoryViewModel, DeleteSummaryParams paramDeleteSummaryParams) {}
    
    public final void run()
    {
      SummaryHistoryViewModel.I(this.a).setValue(Boolean.TRUE);
      c.k.o(true);
      this.a.W(true);
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(SummaryHistoryViewModel paramSummaryHistoryViewModel, DeleteSummaryParams paramDeleteSummaryParams) {}
    
    public final void a(Throwable paramThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteSummary failed: ");
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.c("tylerTest", localStringBuilder.toString());
      SummaryHistoryViewModel.H(this.c).clear();
      SummaryHistoryViewModel.I(this.c).setValue(Boolean.FALSE);
    }
  }
  
  static final class d<I, O>
    implements Function<ArrayList<b>, Boolean>
  {
    public static final d a = new d();
    
    public final Boolean a(ArrayList<b> paramArrayList)
    {
      boolean bool;
      if (paramArrayList.size() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\viewmodel\SummaryHistoryViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */