package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.HasVideoTime;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoDevicesResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoPageListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.CountryCodeListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceIdListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceOrderListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceVideoDateResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DowngradeInfoResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.OrderPageListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.TrialResult;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.cloudvideo.CloudVideoListParams;
import com.tplink.libtpnetwork.exception.IoTException;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class CloudVideoRepository
  extends AbstractIoTCloudRepository
{
  private String h;
  private com.tplink.iot.c.b.d i;
  private MutableLiveData<List<OrderInfo>> j = new MutableLiveData();
  private MutableLiveData<DeviceCloudProduct> k = new MutableLiveData();
  private MutableLiveData<DowngradeInfoResult> l = new MutableLiveData();
  private Map<String, DeviceCloudProduct> m = new ConcurrentHashMap();
  private MutableLiveData<List<DeviceCloudProduct>> n = new MutableLiveData();
  private List<String> o = new ArrayList();
  private AppUrlRepository p;
  private List<String> q = Collections.synchronizedList(new ArrayList());
  private boolean r = false;
  private io.reactivex.m0.g<Boolean> s = io.reactivex.m0.d.n1().l1();
  private AtomicBoolean t = new AtomicBoolean(false);
  private io.reactivex.m0.g<Boolean> u = io.reactivex.m0.d.n1().l1();
  private AtomicBoolean v = new AtomicBoolean(false);
  private final io.reactivex.u<Boolean, Boolean> w = new z(this);
  
  public CloudVideoRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.i = ((com.tplink.iot.c.b.d)parama.k().R1(com.tplink.iot.c.b.d.class));
    parama = (AppUrlRepository)b.d.b.f.b.a(b.d.s.a.a.f(), AppUrlRepository.class);
    this.p = parama;
    parama.k(this.i);
  }
  
  private void A1(String paramString, DeviceCloudProduct paramDeviceCloudProduct)
  {
    b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), paramDeviceCloudProduct, "key_device_cloud_product", b.d.w.h.a.g(paramString));
  }
  
  private void B1()
  {
    if (this.o == null) {
      return;
    }
    b.d.w.d.a.l(b.d.w.h.a.g(this.b.c().getCloudUserName()), this.o, "key_support_care_region_list", "key_support_care_region_list");
  }
  
  private void C1()
  {
    this.n.postValue(new ArrayList(this.m.values()));
  }
  
  private void D1(List<DeviceCloudProduct> paramList)
  {
    this.m.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (DeviceCloudProduct)localIterator.next();
      String str = b.d.w.h.a.g(paramList.getDeviceId());
      this.m.put(str, paramList);
      com.tplink.libtpnetwork.Utils.u.j(str, paramList);
    }
  }
  
  private void E1(CountryCodeListResult paramCountryCodeListResult)
  {
    if (paramCountryCodeListResult == null)
    {
      this.o.clear();
      return;
    }
    paramCountryCodeListResult = paramCountryCodeListResult.getCountryCodeList();
    if ((paramCountryCodeListResult != null) && (!paramCountryCodeListResult.isEmpty()))
    {
      this.o.clear();
      this.o.addAll(paramCountryCodeListResult);
      return;
    }
    this.o.clear();
  }
  
  @SuppressLint({"CheckResult"})
  private void H()
  {
    q.f0(Integer.valueOf(1)).L0(io.reactivex.l0.a.d()).L(new f(this)).N(new u(this)).l0(io.reactivex.l0.a.d()).H0(new c0(this), new e0(this));
  }
  
  private q<List<DeviceCloudProduct>> J(String paramString)
  {
    return O(new CloudVideoListParams(0), paramString).E(new g());
  }
  
  private q<CountryCodeListResult> L()
  {
    return E().N(new t(this));
  }
  
  private q<DeviceOrderListResult<DeviceCloudProduct>> N(CloudVideoListParams paramCloudVideoListParams, String paramString)
  {
    return E().i(this.w).N(new s(this, paramString, paramCloudVideoListParams));
  }
  
  private q<List<DeviceCloudProduct>> O(final CloudVideoListParams paramCloudVideoListParams, String paramString)
  {
    final ArrayList localArrayList = new ArrayList();
    return N(paramCloudVideoListParams, paramString).g0(new i(localArrayList, paramCloudVideoListParams)).w0(new h());
  }
  
  private q<CloudVideoPageListResult<CloudVideo>> P(CloudVideoListParams paramCloudVideoListParams, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return E().i(this.w).N(new l(this, paramString1, paramCloudVideoListParams, paramInt, paramString2, paramString3, paramString4, paramString5));
  }
  
  private q<List<CloudVideo>> Q(CloudVideoListParams paramCloudVideoListParams, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return P(paramCloudVideoListParams, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5).g0(new b());
  }
  
  private q<Boolean> U()
  {
    return f0().N(w.c).C(j.c).L0(io.reactivex.l0.a.c());
  }
  
  private q<OrderPageListResult<OrderInfo>> a0(CloudVideoListParams paramCloudVideoListParams, String paramString)
  {
    return E().i(this.w).N(new k0(this, paramString, paramCloudVideoListParams));
  }
  
  private q<List<OrderInfo>> b0(final CloudVideoListParams paramCloudVideoListParams, String paramString)
  {
    final ArrayList localArrayList = new ArrayList();
    return a0(paramCloudVideoListParams, paramString).g0(new f(localArrayList, paramCloudVideoListParams)).w0(new e()).E(new d()).C(new c());
  }
  
  @SuppressLint({"CheckResult"})
  private void e()
  {
    q.f0(Integer.valueOf(1)).L0(io.reactivex.l0.a.d()).L(new d(this)).N(new i0(this)).l0(io.reactivex.l0.a.d()).H0(new f0(this), new n(this));
  }
  
  private q<Boolean> f()
  {
    return this.p.d().E(new m(this)).C(j0.c).L0(io.reactivex.l0.a.c());
  }
  
  private q<Boolean> u()
  {
    return this.s.Q0(1L).F(new o(this)).l0(io.reactivex.l0.a.c()).N(h.c);
  }
  
  private q<Boolean> y1()
  {
    return this.u.Q0(1L).F(new k(this)).l0(io.reactivex.l0.a.c()).N(new e(this));
  }
  
  public q<Boolean> B()
  {
    if (!this.o.isEmpty())
    {
      if (h0()) {
        return q.f0(Boolean.TRUE);
      }
      return q.f0(Boolean.FALSE);
    }
    return y1();
  }
  
  public boolean C(DeviceCloudProduct paramDeviceCloudProduct)
  {
    if ((paramDeviceCloudProduct != null) && (paramDeviceCloudProduct.getTrial() != null) && (paramDeviceCloudProduct.getTrial().getStatus() != null)) {
      return paramDeviceCloudProduct.getTrial().getStatus().equals("active");
    }
    return false;
  }
  
  public boolean D(DeviceCloudProduct paramDeviceCloudProduct)
  {
    if ((paramDeviceCloudProduct != null) && (paramDeviceCloudProduct.getOrderId() != null) && (paramDeviceCloudProduct.getStatus() != null)) {
      return paramDeviceCloudProduct.getStatus().equals("active");
    }
    return false;
  }
  
  public q<Boolean> E()
  {
    if (!TextUtils.isEmpty(this.h)) {
      return q.f0(Boolean.TRUE);
    }
    if (!TextUtils.isEmpty(this.p.f()))
    {
      this.h = this.p.f();
      return q.f0(Boolean.TRUE);
    }
    return u();
  }
  
  public io.reactivex.a F(String paramString, List<String> paramList)
  {
    return E().i(this.w).g0(new g(this, paramString, paramList)).Z();
  }
  
  public io.reactivex.a G(List<String> paramList)
  {
    return E().i(this.w).g0(new h0(this, paramList)).Z();
  }
  
  public q<List<DeviceCloudProduct>> I()
  {
    return J(b.d.s.a.a.f().c().getAccountId());
  }
  
  public DeviceCloudProduct K(String paramString)
  {
    return (DeviceCloudProduct)b.d.w.d.a.b(b.d.w.h.a.g(this.b.c().getCloudUserName()), "key_device_cloud_product", b.d.w.h.a.g(paramString), DeviceCloudProduct.class);
  }
  
  public q<DeviceCloudProduct> M(String paramString)
  {
    return E().i(this.w).N(new a0(this, paramString));
  }
  
  public q<List<CloudVideo>> R(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return Q(new CloudVideoListParams(0), paramString1, paramInt, "desc", null, paramString2, paramString3);
  }
  
  public q<List<CloudVideo>> S(String paramString1, String paramString2)
  {
    return Q(new CloudVideoListParams(0), paramString1, 1, "desc", paramString2, null, null);
  }
  
  public q<CloudVideoDevicesResult> T(int paramInt1, int paramInt2)
  {
    return E().i(this.w).N(new r(this, paramInt1, paramInt2));
  }
  
  public MutableLiveData<List<DeviceCloudProduct>> V()
  {
    return this.n;
  }
  
  public q<DowngradeInfoResult> W()
  {
    return E().i(this.w).N(new y(this));
  }
  
  public MutableLiveData<DowngradeInfoResult> X()
  {
    this.l.setValue(null);
    return this.l;
  }
  
  public q<DeviceVideoDateResult<HasVideoTime>> Y(String paramString1, String paramString2, String paramString3)
  {
    return E().i(this.w).N(new l0(this, paramString1, paramString2, paramString3));
  }
  
  @Nullable
  public DeviceCloudProduct Z(String paramString)
  {
    if (this.k.getValue() == null) {
      return null;
    }
    if (!TextUtils.equals(((DeviceCloudProduct)this.k.getValue()).getDeviceId(), paramString)) {
      return null;
    }
    return (DeviceCloudProduct)this.k.getValue();
  }
  
  protected void b()
  {
    super.b();
    b.d.w.c.a.d(" CloudVideo onCleared");
  }
  
  public MutableLiveData<List<OrderInfo>> c0()
  {
    return this.j;
  }
  
  public q<List<OrderInfo>> d0()
  {
    String str = b.d.s.a.a.f().c().getAccountId();
    return b0(new CloudVideoListParams(0), str);
  }
  
  public q<DeviceIdListResult> e0()
  {
    return E().i(this.w).N(new d0(this));
  }
  
  public q<CountryCodeListResult> f0()
  {
    return L().E(new a()).C(new j());
  }
  
  public int g0(DeviceCloudProduct paramDeviceCloudProduct, boolean paramBoolean)
  {
    if (paramDeviceCloudProduct == null) {
      return -1;
    }
    if ((paramDeviceCloudProduct.getTrialQualified()) && (!paramBoolean)) {
      return 1;
    }
    if (k0(paramDeviceCloudProduct)) {
      return 2;
    }
    return 3;
  }
  
  public boolean h0()
  {
    Object localObject1 = b.d.s.a.a.f();
    if (localObject1 != null)
    {
      localObject1 = ((com.tplink.cloud.context.b)localObject1).c();
      if (localObject1 != null)
      {
        localObject1 = ((TCAccountBean)localObject1).getCountryCode();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = new ArrayList(this.o).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((String)localObject1).equalsIgnoreCase((String)((Iterator)localObject2).next()))
            {
              b.d.w.c.a.d("isCurrentRegionSupportTapoCare countryCode contain ok");
              return true;
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("isCurrentRegionSupportTapoCare countryCode not contain:");
          ((StringBuilder)localObject2).append((String)localObject1);
          b.d.w.c.a.d(((StringBuilder)localObject2).toString());
        }
        else
        {
          b.d.w.c.a.d("isCurrentRegionSupportTapoCare countryCode is empty");
        }
      }
    }
    return false;
  }
  
  public boolean i0(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.q.contains(paramString);
  }
  
  public boolean j0()
  {
    return this.r;
  }
  
  public boolean k0(DeviceCloudProduct paramDeviceCloudProduct)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramDeviceCloudProduct != null) {
      if (!D(paramDeviceCloudProduct))
      {
        bool2 = bool1;
        if (!C(paramDeviceCloudProduct)) {}
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean l0(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = (DeviceCloudProduct)this.m.get(paramString);
    if (paramString == null) {
      return false;
    }
    return k0(paramString);
  }
  
  public void z1()
  {
    Object localObject = b.d.w.h.a.g(this.b.c().getCloudUserName());
    ArrayList localArrayList;
    try
    {
      localObject = b.d.w.d.a.c((String)localObject, "key_support_care_region_list", "key_support_care_region_list", String.class);
    }
    catch (Exception localException)
    {
      localArrayList = new ArrayList();
    }
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      this.o.clear();
      this.o.addAll(localArrayList);
    }
  }
  
  class a
    implements io.reactivex.g0.g<CountryCodeListResult>
  {
    a() {}
    
    public void a(CountryCodeListResult paramCountryCodeListResult)
      throws Exception
    {
      CloudVideoRepository.z(CloudVideoRepository.this, paramCountryCodeListResult);
      CloudVideoRepository.A(CloudVideoRepository.this);
    }
  }
  
  class b
    implements io.reactivex.g0.j<CloudVideoPageListResult<CloudVideo>, List<CloudVideo>>
  {
    b() {}
    
    public List<CloudVideo> a(CloudVideoPageListResult<CloudVideo> paramCloudVideoPageListResult)
      throws Exception
    {
      if (paramCloudVideoPageListResult != null)
      {
        paramCloudVideoPageListResult = paramCloudVideoPageListResult.getIndex();
        if ((paramCloudVideoPageListResult != null) && (!paramCloudVideoPageListResult.isEmpty())) {
          return paramCloudVideoPageListResult;
        }
        return new ArrayList();
      }
      throw new IoTException(-1, "");
    }
  }
  
  class c
    implements io.reactivex.g0.g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      CloudVideoRepository.w(CloudVideoRepository.this).postValue(null);
    }
  }
  
  class d
    implements io.reactivex.g0.g<List<OrderInfo>>
  {
    d() {}
    
    public void a(List<OrderInfo> paramList)
      throws Exception
    {
      CloudVideoRepository.w(CloudVideoRepository.this).postValue(paramList);
    }
  }
  
  class e
    implements io.reactivex.g0.l<Throwable>
  {
    e() {}
    
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
  
  class f
    implements io.reactivex.g0.j<OrderPageListResult<OrderInfo>, List<OrderInfo>>
  {
    f(List paramList, CloudVideoListParams paramCloudVideoListParams) {}
    
    public List<OrderInfo> a(OrderPageListResult<OrderInfo> paramOrderPageListResult)
      throws Exception
    {
      if (paramOrderPageListResult != null)
      {
        long l = paramOrderPageListResult.getTotal();
        if (l == 0L) {
          return new ArrayList();
        }
        if (localArrayList.size() >= l) {
          return localArrayList;
        }
        List localList = paramOrderPageListResult.getOrderList();
        if ((localList != null) && (!localList.isEmpty())) {
          localArrayList.addAll(localList);
        }
        if ((localArrayList.size() < l) && (localList != null) && (!localList.isEmpty()))
        {
          paramCloudVideoListParams.setPage(paramOrderPageListResult.getPage() + 1);
          throw new CloudException(-2, "DATA_RETRY");
        }
        return localArrayList;
      }
      throw new IoTException(-1, "");
    }
  }
  
  class g
    implements io.reactivex.g0.g<List<DeviceCloudProduct>>
  {
    g() {}
    
    public void a(List<DeviceCloudProduct> paramList)
      throws Exception
    {
      CloudVideoRepository.x(CloudVideoRepository.this, paramList);
      CloudVideoRepository.y(CloudVideoRepository.this);
    }
  }
  
  class h
    implements io.reactivex.g0.l<Throwable>
  {
    h() {}
    
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
  
  class i
    implements io.reactivex.g0.j<DeviceOrderListResult<DeviceCloudProduct>, List<DeviceCloudProduct>>
  {
    i(List paramList, CloudVideoListParams paramCloudVideoListParams) {}
    
    public List<DeviceCloudProduct> a(DeviceOrderListResult<DeviceCloudProduct> paramDeviceOrderListResult)
      throws Exception
    {
      if (paramDeviceOrderListResult != null)
      {
        long l = paramDeviceOrderListResult.getTotal();
        if (l == 0L) {
          return new ArrayList();
        }
        if (localArrayList.size() >= l) {
          return localArrayList;
        }
        List localList = paramDeviceOrderListResult.getDeviceList();
        if ((localList != null) && (!localList.isEmpty())) {
          localArrayList.addAll(localList);
        }
        if (localArrayList.size() >= l) {
          return localArrayList;
        }
        paramCloudVideoListParams.setPage(paramDeviceOrderListResult.getPage() + 1);
        throw new CloudException(-2, "DATA_RETRY");
      }
      throw new IoTException(-1, "");
    }
  }
  
  class j
    implements io.reactivex.g0.g<Throwable>
  {
    j() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.d("getTapoCareServiceCountryList doOnError");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\CloudVideoRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */