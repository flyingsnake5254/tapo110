package com.tplink.iot.viewmodel.billing;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.billingclient.api.Purchase;
import com.google.gson.Gson;
import com.tplink.iab.beans.PurchaseParams;
import com.tplink.iot.model.billing.BillingManager;
import com.tplink.iot.model.billing.g0;
import java.util.List;

public class BillingViewModel
  extends AndroidViewModel
{
  private static final String a = "BillingViewModel";
  private final Gson b = new Gson();
  private io.reactivex.e0.b c = new io.reactivex.e0.b();
  private BillingManager d;
  private final MediatorLiveData<String> e = new MediatorLiveData();
  private final MutableLiveData<Boolean> f = new MutableLiveData();
  private final MutableLiveData<Integer> g = new MutableLiveData();
  private Purchase h;
  private String i;
  private boolean j;
  private String k;
  
  public BillingViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    v(paramApplication);
  }
  
  private io.reactivex.q<Integer> f(Purchase paramPurchase)
  {
    return this.d.f(paramPurchase).F(new a(this, paramPurchase)).g0(e.c).q0(Integer.valueOf(65236)).E(k.c);
  }
  
  private io.reactivex.q<Integer> g(Purchase paramPurchase, boolean paramBoolean)
  {
    return f(paramPurchase).N(new w(this, paramPurchase));
  }
  
  private void i(List<Purchase> paramList, boolean paramBoolean)
  {
    io.reactivex.q.Y(paramList).L(s.c).N(new p(this, paramBoolean)).r0(h.c).f(new n(this, paramBoolean)).d(new r(this, paramBoolean)).g(new x(this, paramBoolean)).l();
  }
  
  private void l()
  {
    b.d.w.c.a.c(a, "verifyDBReceipts");
    io.reactivex.q.Y(g0.h()).N(new g(this)).z(b.a).C(z.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.l0.a.c()).F0();
  }
  
  private io.reactivex.q<Integer> o0(Purchase paramPurchase)
  {
    return io.reactivex.q.X(new o(this, paramPurchase)).N(new f(this)).g0(new c(this)).p0(new i(this));
  }
  
  private io.reactivex.q<Integer> p0(Purchase paramPurchase, String paramString)
  {
    return o0(paramPurchase).N(j.c);
  }
  
  private void v(@NonNull Application paramApplication)
  {
    paramApplication = new BillingManager(paramApplication, (com.tplink.iot.c.c.a)b.d.s.a.a.f());
    this.d = paramApplication;
    this.e.addSource(paramApplication.i(), new q(this));
    l();
  }
  
  public void h(List<Purchase> paramList)
  {
    i(paramList, false);
  }
  
  public void j(List<Purchase> paramList)
  {
    i(paramList, true);
  }
  
  public void k(@NonNull Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = (PurchaseParams)this.b.l(paramString, PurchaseParams.class);
    this.d.e(paramActivity, paramString.getProductId());
  }
  
  @UiThread
  public void l0()
  {
    this.d.E0();
  }
  
  public LifecycleObserver m()
  {
    return this.d;
  }
  
  public io.reactivex.q<Integer> m0()
  {
    io.reactivex.q localq = g(this.h, false).F(new v(this)).y(new d(this));
    MutableLiveData localMutableLiveData = this.g;
    localMutableLiveData.getClass();
    return localq.E(new a0(localMutableLiveData));
  }
  
  public LiveData<Boolean> n()
  {
    return this.f;
  }
  
  public io.reactivex.q<Integer> n0()
  {
    io.reactivex.q localq = p0(this.h, null).F(new m(this)).y(new l(this));
    MutableLiveData localMutableLiveData = this.g;
    localMutableLiveData.getClass();
    return localq.E(new a0(localMutableLiveData));
  }
  
  public String o()
  {
    if (TextUtils.isEmpty(this.k)) {
      this.k = "";
    }
    return this.k;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    if (!this.c.isDisposed()) {
      this.c.d();
    }
  }
  
  public LiveData<Integer> p()
  {
    return this.d.k();
  }
  
  public LiveData<List<Purchase>> r()
  {
    return this.d.l();
  }
  
  public LiveData<List<Purchase>> s()
  {
    return this.d.m();
  }
  
  public LiveData<Integer> t()
  {
    return this.g;
  }
  
  public LiveData<String> u()
  {
    return this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\billing\BillingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */