package com.tplink.iot.model.billing;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.Purchase.a;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.c.a;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iab.SingleLiveEvent;
import com.tplink.iab.beans.BillingResponse;
import com.tplink.iab.beans.ProductDetails;
import com.tplink.iab.exception.BillingException;
import com.tplink.iot.cloud.bean.billing.common.Product;
import com.tplink.iot.cloud.bean.billing.result.VerifyReceiptResult;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.NBUBillingRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BillingManager
  implements LifecycleObserver, com.android.billingclient.api.k
{
  private final MutableLiveData<List<ProductDetails>> H3 = new MutableLiveData();
  private final ArrayList<Purchase> I3 = new ArrayList();
  private final ArrayList<String> J3 = new ArrayList();
  private final ArrayList<String> K3 = new ArrayList();
  private final HashMap<String, SkuDetails> L3 = new HashMap();
  private final Context c;
  private com.android.billingclient.api.c d;
  private NBUBillingRepository f;
  private final io.reactivex.m0.g<BillingResponse> p0 = io.reactivex.m0.b.n1().l1();
  private final SingleLiveEvent<Integer> p1 = new SingleLiveEvent();
  private final SingleLiveEvent<List<Purchase>> p2 = new SingleLiveEvent();
  private final SingleLiveEvent<List<Purchase>> p3 = new SingleLiveEvent();
  private TCAccountRepository q;
  private long x;
  private final io.reactivex.e0.b y = new io.reactivex.e0.b();
  private final AtomicInteger z = new AtomicInteger();
  
  public BillingManager(@NonNull Context paramContext, @NonNull com.tplink.iot.c.c.a parama)
  {
    io.reactivex.h0.a.b.e(paramContext, "Context can't be null");
    io.reactivex.h0.a.b.e(parama, "NBUCloudContext can't be null");
    this.c = paramContext.getApplicationContext();
    this.f = ((NBUBillingRepository)b.d.b.f.b.c(parama).a(NBUBillingRepository.class));
    this.q = ((TCAccountRepository)b.d.b.f.b.a(parama, TCAccountRepository.class));
  }
  
  private List<Purchase> A0(String paramString)
  {
    paramString = this.d.h(paramString);
    if ((paramString != null) && (paramString.c() == 0)) {
      return paramString.b();
    }
    return null;
  }
  
  private io.reactivex.q<List<ProductDetails>> B0()
    throws BillingException
  {
    ArrayList localArrayList = new ArrayList();
    if (!this.J3.isEmpty()) {
      localArrayList.add(C0("inapp", this.J3));
    }
    if ((!this.K3.isEmpty()) && (d())) {
      localArrayList.add(C0("subs", this.K3));
    }
    if (!localArrayList.isEmpty()) {
      return io.reactivex.q.g1(localArrayList, new v(this)).F(new m(this));
    }
    throw new BillingException("Sku list can't be empty");
  }
  
  private io.reactivex.q<List<SkuDetails>> C0(String paramString, List<String> paramList)
  {
    return G0().N(new g(this, paramString, paramList));
  }
  
  private void D0(Activity paramActivity, SkuDetails paramSkuDetails)
  {
    Object localObject = paramSkuDetails.l();
    if ("inapp".equals(localObject))
    {
      p(paramActivity, paramSkuDetails);
    }
    else if ("subs".equals(localObject))
    {
      localObject = n();
      if (localObject == null) {
        p(paramActivity, paramSkuDetails);
      } else {
        v((Purchase)localObject, paramActivity, paramSkuDetails);
      }
    }
    else
    {
      this.p1.postValue(Integer.valueOf(1004));
    }
  }
  
  @UiThread
  private io.reactivex.q<Boolean> F0()
  {
    final int i = this.z.incrementAndGet();
    this.d.j(new a(i));
    return h(i).g0(b.c);
  }
  
  @UiThread
  private io.reactivex.q<Boolean> G0()
  {
    if (this.d.e()) {
      return io.reactivex.q.f0(Boolean.TRUE).L0(io.reactivex.d0.b.a.a());
    }
    return F0().L0(io.reactivex.d0.b.a.a());
  }
  
  private int H0(int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != 4)
      {
        if (paramInt != 7)
        {
          if (paramInt != 0)
          {
            if (paramInt != 1) {
              return 1001;
            }
            return 1003;
          }
          return 0;
        }
        return 1005;
      }
      return 1004;
    }
    return 1002;
  }
  
  @UiThread
  private boolean d()
  {
    return s("subscriptions");
  }
  
  private io.reactivex.q<BillingResponse> h(int paramInt)
  {
    return this.p0.L(new j(paramInt)).Q0(1L).E(s.c);
  }
  
  private io.reactivex.q<List<Product>> j()
  {
    return this.f.x().F(new t(this)).E(new e(this));
  }
  
  private Purchase n()
  {
    Object localObject = this.I3;
    if (((List)localObject).isEmpty()) {
      return null;
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (Purchase)localIterator.next();
      if (localObject != null) {
        return (Purchase)localObject;
      }
    }
    return null;
  }
  
  private io.reactivex.q<List<ProductDetails>> o()
  {
    this.x = System.currentTimeMillis();
    return j().N(new f0(this)).N(new l(this)).C(o.c).z(c.a);
  }
  
  private void p(Activity paramActivity, SkuDetails paramSkuDetails)
  {
    r(paramActivity, paramSkuDetails, null, null);
  }
  
  private void r(Activity paramActivity, SkuDetails paramSkuDetails, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!t()))
    {
      this.p1.postValue(Integer.valueOf(1002));
      return;
    }
    G0().E(new x(this, paramSkuDetails, paramString1, paramString2, paramActivity)).F0();
  }
  
  @UiThread
  private boolean s(String paramString)
  {
    paramString = this.d.d(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.a() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @UiThread
  private boolean t()
  {
    return s("subscriptionsUpdate");
  }
  
  private boolean u(List<Purchase> paramList)
  {
    return false;
  }
  
  private void v(Purchase paramPurchase, Activity paramActivity, SkuDetails paramSkuDetails)
  {
    this.f.y(paramPurchase.c(), paramPurchase.f(), paramPurchase.d()).E(new k(this, paramActivity, paramSkuDetails, paramPurchase)).C(new d(this)).F0();
  }
  
  private void w0(List<Product> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Product localProduct = (Product)localIterator.next();
      paramList = localProduct.getProductId();
      if (paramList != null)
      {
        int i = localProduct.getProductType();
        if ((i != 1) && (i != 2))
        {
          if ((i == 3) || (i == 4)) {
            this.K3.add(paramList);
          }
        }
        else {
          this.J3.add(paramList);
        }
      }
    }
  }
  
  private void x0(List<Purchase> paramList)
  {
    if (u(paramList))
    {
      this.p1.postValue(Integer.valueOf(1001));
      return;
    }
    this.p2.postValue(paramList);
  }
  
  private io.reactivex.q<Boolean> z0()
  {
    return G0().E(new d0(this));
  }
  
  public void E0()
  {
    io.reactivex.q localq = G0().N(new c0(this));
    MutableLiveData localMutableLiveData = this.H3;
    localMutableLiveData.getClass();
    localq.E(new a(localMutableLiveData)).C(new h(this)).F0();
  }
  
  public io.reactivex.q<VerifyReceiptResult> I0(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.f.J(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(com.android.billingclient.api.g paramg, @Nullable List<Purchase> paramList)
  {
    Integer localInteger = Integer.valueOf(1001);
    if (paramg == null)
    {
      this.p1.postValue(localInteger);
      return;
    }
    int i = paramg.a();
    if (i == 0)
    {
      if (paramList == null) {
        this.p1.postValue(localInteger);
      } else {
        x0(paramList);
      }
    }
    else {
      this.p1.postValue(Integer.valueOf(H0(i)));
    }
  }
  
  public io.reactivex.q<Boolean> c(@NonNull Purchase paramPurchase)
  {
    return G0().N(new i(this, paramPurchase));
  }
  
  public void e(@NonNull Activity paramActivity, String paramString)
  {
    Object localObject = Integer.valueOf(1004);
    if (paramString == null)
    {
      this.p1.postValue(localObject);
      return;
    }
    paramString = (SkuDetails)this.L3.get(paramString);
    if (paramString == null)
    {
      this.p1.postValue(localObject);
      return;
    }
    localObject = b.d.s.a.a.f().c();
    if (localObject == null)
    {
      this.p1.postValue(Integer.valueOf(1001));
      return;
    }
    if (TextUtils.isEmpty(((TCAccountBean)localObject).getAccountId()))
    {
      localObject = this.q;
      ((TCAccountRepository)localObject).s(((TCAccountRepository)localObject).u().getCloudUserName()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new y(this, paramActivity, paramString)).C(new e0(this)).F0();
    }
    else
    {
      D0(paramActivity, paramString);
    }
  }
  
  public io.reactivex.q<Boolean> f(@NonNull Purchase paramPurchase)
  {
    String str = paramPurchase.f();
    if (this.J3.contains(str)) {
      return g(paramPurchase);
    }
    if (this.K3.contains(str)) {
      return c(paramPurchase);
    }
    return io.reactivex.q.f0(Boolean.FALSE);
  }
  
  public io.reactivex.q<Boolean> g(@NonNull Purchase paramPurchase)
  {
    return G0().N(new n(this, paramPurchase));
  }
  
  public LiveData<List<ProductDetails>> i()
  {
    return this.H3;
  }
  
  public LiveData<Integer> k()
  {
    return this.p1;
  }
  
  public LiveData<List<Purchase>> l()
  {
    return this.p3;
  }
  
  public LiveData<List<Purchase>> m()
  {
    return this.p2;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public void onCreate()
  {
    if (this.d == null) {
      this.d = com.android.billingclient.api.c.g(this.c).b().c(this).a();
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy()
  {
    if (this.d.e()) {
      this.d.c();
    }
    if ((!this.p0.j1()) && (!this.p0.k1())) {
      this.p0.onComplete();
    }
    if (!this.y.isDisposed()) {
      this.y.d();
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void onStart()
  {
    if (this.d.e())
    {
      y0();
    }
    else
    {
      io.reactivex.q localq = F0().N(new a0(this));
      MutableLiveData localMutableLiveData = this.H3;
      localMutableLiveData.getClass();
      localq.E(new a(localMutableLiveData)).C(new q(this)).F0();
    }
  }
  
  public void y0()
  {
    z0().F0();
  }
  
  class a
    implements com.android.billingclient.api.e
  {
    a(int paramInt) {}
    
    public void a(com.android.billingclient.api.g paramg)
    {
      BillingResponse localBillingResponse = new BillingResponse(i);
      if (paramg == null) {
        localBillingResponse.setResponseCode(6);
      } else {
        localBillingResponse.setResponseCode(paramg.a());
      }
      BillingManager.b(BillingManager.this).onNext(localBillingResponse);
    }
    
    public void b() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\billing\BillingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */