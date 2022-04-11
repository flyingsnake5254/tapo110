package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import b.d.b.c.d;
import b.d.b.c.i;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.device.params.DeviceAliasParams;
import com.tplink.cloud.bean.device.params.DeviceConfigInfoParams;
import com.tplink.cloud.bean.device.params.DeviceConfigInfoUploadParams;
import com.tplink.cloud.bean.device.params.DeviceFeatureParams;
import com.tplink.cloud.bean.device.params.DeviceInfoParams;
import com.tplink.cloud.bean.device.params.DeviceListPageParams;
import com.tplink.cloud.bean.device.params.DeviceUnbindParams;
import com.tplink.cloud.bean.device.params.DeviceUserNumberLimitParams;
import com.tplink.cloud.bean.device.result.DeviceConfigInfoListResult;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.cloud.bean.device.result.DeviceListPageResult;
import com.tplink.cloud.bean.device.result.DeviceListResult;
import com.tplink.cloud.bean.device.result.DeviceUnbindFeatureResult;
import com.tplink.cloud.bean.device.result.DeviceUserNumberLimitListResult;
import com.tplink.cloud.bean.device.result.DeviceUserNumberLimitResult;
import com.tplink.cloud.bean.firmware.params.FirmwareInfoParams;
import com.tplink.cloud.bean.firmware.result.FirmwareListResult;
import com.tplink.cloud.bean.share.params.ShareBlacklistParams;
import com.tplink.cloud.bean.share.params.ShareBlacklistUpdateParams;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemUpdateResult;
import com.tplink.cloud.bean.share.result.ShareBlacklistResult;
import com.tplink.cloud.bean.share.result.ShareBlacklistUpdateResult;
import com.tplink.cloud.bean.webservice.params.WebServiceInfoParams;
import com.tplink.cloud.bean.webservice.result.DeviceAvatarResult;
import com.tplink.cloud.bean.webservice.result.WebServiceInfoResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import io.reactivex.g0.g;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

public class TCDeviceRepository
  extends b.d.b.f.a
{
  private b.d.b.c.c c;
  private i d;
  private b.d.b.c.j e;
  private d f;
  private Map<String, TCDeviceBean> g = new HashMap();
  private MutableLiveData<List<TCDeviceBean>> h = new MutableLiveData();
  private MutableLiveData<List<ShareBlacklistItemResult>> i = new MutableLiveData();
  private List<ShareBlacklistItemResult> j = new ArrayList();
  private HashMap<EnumDeviceType, Integer> k = new HashMap();
  
  public TCDeviceRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.c = paramb.d();
    this.d = paramb.d();
    this.e = paramb.d();
    this.f = paramb.d();
    HashMap localHashMap = this.k;
    paramb = EnumDeviceType.PLUG;
    Integer localInteger = Integer.valueOf(8);
    localHashMap.put(paramb, localInteger);
    this.k.put(EnumDeviceType.BULB, localInteger);
    this.k.put(EnumDeviceType.CAMERA, Integer.valueOf(2));
  }
  
  private q<DeviceListPageResult> C(DeviceListPageParams paramDeviceListPageParams)
  {
    return this.c.b1(new CloudParams("getDeviceListByPage", paramDeviceListPageParams)).g0(new i());
  }
  
  private List<TCDeviceBean> G(DeviceListPageResult paramDeviceListPageResult)
  {
    ArrayList localArrayList = new ArrayList();
    paramDeviceListPageResult = paramDeviceListPageResult.getDeviceList().iterator();
    while (paramDeviceListPageResult.hasNext()) {
      localArrayList.add(new TCDeviceBean((DeviceInfoResult)paramDeviceListPageResult.next()));
    }
    return localArrayList;
  }
  
  private q<List<ShareBlacklistItemResult>> H(final ShareBlacklistParams paramShareBlacklistParams)
  {
    final ArrayList localArrayList = new ArrayList();
    return this.d.t1(new CloudParams("getShareBlackListByPage", paramShareBlacklistParams)).L0(io.reactivex.l0.a.c()).g0(new l(localArrayList, paramShareBlacklistParams)).w0(new k());
  }
  
  private void L(String paramString)
  {
    this.g.remove(paramString);
    O();
  }
  
  private void M(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.g.remove(str);
    }
    O();
  }
  
  private void O()
  {
    this.h.postValue(new ArrayList(this.g.values()));
  }
  
  private void S(List<TCDeviceBean> paramList)
  {
    this.g.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TCDeviceBean localTCDeviceBean = (TCDeviceBean)paramList.next();
      this.g.put(localTCDeviceBean.getDeviceId(), localTCDeviceBean);
    }
  }
  
  private q<TCDeviceBean> T(final TCDeviceBean paramTCDeviceBean)
  {
    return B(paramTCDeviceBean.getAppServerUrl(), paramTCDeviceBean.getDeviceId()).g0(new b()).p0(new a(paramTCDeviceBean));
  }
  
  private void U(String paramString, DeviceInfoResult paramDeviceInfoResult)
  {
    paramDeviceInfoResult = new TCDeviceBean(paramDeviceInfoResult);
    this.g.put(paramString, paramDeviceInfoResult);
    O();
  }
  
  private void V(CloudResult<DeviceUserNumberLimitListResult> paramCloudResult)
  {
    if ((paramCloudResult != null) && (paramCloudResult.getErrorCode() == 0))
    {
      paramCloudResult = (DeviceUserNumberLimitListResult)paramCloudResult.getResult();
      if (paramCloudResult == null) {
        return;
      }
      paramCloudResult = paramCloudResult.getUserNumberLimitList();
      if (paramCloudResult == null) {
        return;
      }
      Iterator localIterator = paramCloudResult.iterator();
      while (localIterator.hasNext())
      {
        paramCloudResult = (DeviceUserNumberLimitResult)localIterator.next();
        String str = paramCloudResult.getDeviceType();
        int m = paramCloudResult.getUserNumberLimit();
        if ((str != null) && (m > 0)) {
          this.k.put(EnumDeviceType.fromType(str), Integer.valueOf(m));
        }
      }
    }
  }
  
  private q<CloudResult<DeviceUserNumberLimitListResult>> s(DeviceUserNumberLimitParams paramDeviceUserNumberLimitParams)
  {
    return this.c.y(new CloudParams("batchGetDeviceUserNumberLimit", paramDeviceUserNumberLimitParams)).L0(io.reactivex.l0.a.c()).E(new x());
  }
  
  private q<List<TCDeviceBean>> u(final DeviceListPageParams paramDeviceListPageParams)
  {
    final ArrayList localArrayList = new ArrayList();
    return C(paramDeviceListPageParams).g0(new h(localArrayList, paramDeviceListPageParams)).w0(new g());
  }
  
  private t<List<TCDeviceBean>> x(List<TCDeviceBean> paramList1, final List<TCDeviceBean> paramList2)
  {
    return q.Y(paramList1).N(new b0()).Z0().j(new a0(paramList2));
  }
  
  public q<DeviceInfoResult> A(final String paramString)
  {
    return this.c.j1(new CloudParams("getDeviceInfo", new DeviceInfoParams(paramString))).g0(new d(paramString));
  }
  
  public q<DeviceInfoResult> B(String paramString1, final String paramString2)
  {
    return this.c.p1(paramString1, new CloudParams("getDeviceInfo", new DeviceInfoParams(paramString2))).g0(new c(paramString2));
  }
  
  public q<FirmwareListResult> D(FirmwareInfoParams paramFirmwareInfoParams)
  {
    return this.f.O0(new CloudParams("getIntlFwList", paramFirmwareInfoParams)).g0(new w());
  }
  
  public MutableLiveData<List<TCDeviceBean>> E()
  {
    return this.h;
  }
  
  public int F(String paramString)
  {
    if (paramString == null) {
      return 8;
    }
    Integer localInteger = (Integer)this.k.get(EnumDeviceType.fromType(paramString));
    if (localInteger == null) {
      return 8;
    }
    int m = localInteger.intValue();
    if (m > 0) {
      return m;
    }
    if (EnumDeviceType.CAMERA == EnumDeviceType.fromType(paramString)) {
      return 2;
    }
    return 8;
  }
  
  public List<ShareBlacklistItemResult> I()
  {
    return this.j;
  }
  
  public MutableLiveData<List<ShareBlacklistItemResult>> J()
  {
    return this.i;
  }
  
  public boolean K()
  {
    b.d.b.c.c localc = this.c;
    boolean bool;
    if (((localc instanceof b.d.b.b)) && (!((b.d.b.b)localc).S1())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public q<Boolean> N(final ShareBlacklistUpdateParams paramShareBlacklistUpdateParams)
  {
    return this.d.s(new CloudParams("removeShareBlackList", paramShareBlacklistUpdateParams)).L0(io.reactivex.l0.a.c()).g0(new o(paramShareBlacklistUpdateParams));
  }
  
  public q<String> P(String paramString1, final String paramString2, String paramString3)
  {
    return this.c.z0(paramString1, new CloudParams("setAlias", new DeviceAliasParams(paramString2, paramString3))).N(new v(paramString2));
  }
  
  public q<Boolean> Q(final List<String> paramList)
  {
    return this.c.a0(new CloudParams("unbindDeviceListWithFeatureInfo", new DeviceFeatureParams(this.b.c().getCloudUserName(), paramList))).L0(io.reactivex.l0.a.c()).F(new f(paramList)).g0(new e());
  }
  
  public q<String> R(String paramString1, final String paramString2, String paramString3)
  {
    return this.c.Y0(paramString1, new CloudParams("unbindDevice", new DeviceUnbindParams(paramString2, paramString3))).N(new u(paramString2));
  }
  
  public q<DeviceAvatarResult> W(final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    return this.e.S0(new CloudParams("getWebServiceInfo", new WebServiceInfoParams(Collections.singletonList("device.avatar")))).N(new r(paramString2, paramArrayOfByte, paramString1)).g0(new q());
  }
  
  public io.reactivex.a X(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    return this.e.S0(new CloudParams("getWebServiceInfo", new WebServiceInfoParams(Collections.singletonList("device.config")))).N(new t(paramString2, paramString1, paramString3, paramString4)).Z();
  }
  
  public q<Boolean> q(ShareBlacklistUpdateParams paramShareBlacklistUpdateParams)
  {
    return this.d.Q0(new CloudParams("addShareBlackList", paramShareBlacklistUpdateParams)).L0(io.reactivex.l0.a.c()).g0(new n()).C(new m());
  }
  
  public io.reactivex.a r()
  {
    DeviceUserNumberLimitParams localDeviceUserNumberLimitParams = new DeviceUserNumberLimitParams();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(EnumDeviceType.PLUG.getDeviceType());
    localArrayList.add(EnumDeviceType.BULB.getDeviceType());
    localArrayList.add(EnumDeviceType.CAMERA.getDeviceType());
    localDeviceUserNumberLimitParams.setDeviceTypeList(localArrayList);
    return s(localDeviceUserNumberLimitParams).Z();
  }
  
  public q<List<TCDeviceBean>> t()
  {
    return v(b.d.s.c.a.a()).g0(new s());
  }
  
  public q<List<TCDeviceBean>> v(String... paramVarArgs)
  {
    return u(new DeviceListPageParams(null, 0, 20, paramVarArgs)).N(new z());
  }
  
  public q<List<ShareBlacklistItemResult>> w()
  {
    return H(new ShareBlacklistParams(0, 10)).E(new j());
  }
  
  public q<List<TCDeviceBean>> y()
  {
    return v(new String[] { EnumDeviceType.CAMERA.getDeviceType() }).E(new y());
  }
  
  public q<DeviceConfigInfoListResult> z(List<String> paramList)
  {
    return this.c.M(new CloudParams("getDeviceConfigInfo", new DeviceConfigInfoParams(paramList, true))).g0(new p());
  }
  
  class a
    implements io.reactivex.g0.j<Throwable, TCDeviceBean>
  {
    a(TCDeviceBean paramTCDeviceBean) {}
    
    public TCDeviceBean a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable.printStackTrace();
      return paramTCDeviceBean;
    }
  }
  
  class a0
    implements io.reactivex.g0.j<List<TCDeviceBean>, t<List<TCDeviceBean>>>
  {
    a0(List paramList) {}
    
    public t<List<TCDeviceBean>> a(List<TCDeviceBean> paramList)
      throws Exception
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramList2);
      localArrayList.addAll(paramList);
      return q.f0(localArrayList);
    }
  }
  
  class b
    implements io.reactivex.g0.j<DeviceInfoResult, TCDeviceBean>
  {
    b() {}
    
    public TCDeviceBean a(DeviceInfoResult paramDeviceInfoResult)
      throws Exception
    {
      return new TCDeviceBean(paramDeviceInfoResult);
    }
  }
  
  class b0
    implements io.reactivex.g0.j<TCDeviceBean, t<TCDeviceBean>>
  {
    b0() {}
    
    public t<TCDeviceBean> a(TCDeviceBean paramTCDeviceBean)
      throws Exception
    {
      return TCDeviceRepository.o(TCDeviceRepository.this, paramTCDeviceBean);
    }
  }
  
  class c
    implements io.reactivex.g0.j<CloudResult<DeviceInfoResult>, DeviceInfoResult>
  {
    c(String paramString) {}
    
    public DeviceInfoResult a(CloudResult<DeviceInfoResult> paramCloudResult)
      throws Exception
    {
      TCDeviceRepository.p(TCDeviceRepository.this, paramString2, (DeviceInfoResult)paramCloudResult.getResult());
      return (DeviceInfoResult)paramCloudResult.getResult();
    }
  }
  
  class d
    implements io.reactivex.g0.j<CloudResult<DeviceInfoResult>, DeviceInfoResult>
  {
    d(String paramString) {}
    
    public DeviceInfoResult a(CloudResult<DeviceInfoResult> paramCloudResult)
      throws Exception
    {
      TCDeviceRepository.p(TCDeviceRepository.this, paramString, (DeviceInfoResult)paramCloudResult.getResult());
      return (DeviceInfoResult)paramCloudResult.getResult();
    }
  }
  
  class e
    implements io.reactivex.g0.j<CloudResult<DeviceUnbindFeatureResult>, Boolean>
  {
    e() {}
    
    public Boolean a(CloudResult<DeviceUnbindFeatureResult> paramCloudResult)
      throws Exception
    {
      return Boolean.TRUE;
    }
  }
  
  class f
    implements g<io.reactivex.e0.c>
  {
    f(List paramList) {}
    
    public void a(io.reactivex.e0.c paramc)
      throws Exception
    {
      TCDeviceRepository.g(TCDeviceRepository.this, paramList);
    }
  }
  
  class g
    implements l<Throwable>
  {
    g() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      boolean bool;
      if (((paramThrowable instanceof CloudException)) && (((CloudException)paramThrowable).getErrCode() == -2)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  class h
    implements io.reactivex.g0.j<DeviceListPageResult, List<TCDeviceBean>>
  {
    h(List paramList, DeviceListPageParams paramDeviceListPageParams) {}
    
    public List<TCDeviceBean> a(DeviceListPageResult paramDeviceListPageResult)
      throws Exception
    {
      localArrayList.addAll(TCDeviceRepository.h(TCDeviceRepository.this, paramDeviceListPageResult));
      paramDeviceListPageResult = paramDeviceListPageParams;
      paramDeviceListPageResult.setIndex(paramDeviceListPageResult.getIndex() + paramDeviceListPageParams.getLimit());
      if (paramDeviceListPageParams.getIndex() > localArrayList.size()) {
        return localArrayList;
      }
      throw new CloudException(-2, "");
    }
  }
  
  class i
    implements io.reactivex.g0.j<CloudResult<DeviceListPageResult>, DeviceListPageResult>
  {
    i() {}
    
    public DeviceListPageResult a(CloudResult<DeviceListPageResult> paramCloudResult)
      throws Exception
    {
      return (DeviceListPageResult)paramCloudResult.getResult();
    }
  }
  
  class j
    implements g<List<ShareBlacklistItemResult>>
  {
    j() {}
    
    public void a(List<ShareBlacklistItemResult> paramList)
      throws Exception
    {
      TCDeviceRepository.i(TCDeviceRepository.this).clear();
      if ((paramList != null) && (!paramList.isEmpty())) {
        TCDeviceRepository.i(TCDeviceRepository.this).addAll(paramList);
      }
      TCDeviceRepository.j(TCDeviceRepository.this).postValue(TCDeviceRepository.i(TCDeviceRepository.this));
    }
  }
  
  class k
    implements l<Throwable>
  {
    k() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        paramThrowable = (CloudException)paramThrowable;
        if ((paramThrowable.getErrCode() == -2) && ("retry_get_data".equals(paramThrowable.getMsg()))) {
          return true;
        }
      }
      boolean bool = false;
      return bool;
    }
  }
  
  class l
    implements io.reactivex.g0.j<CloudResult<ShareBlacklistResult>, List<ShareBlacklistItemResult>>
  {
    l(List paramList, ShareBlacklistParams paramShareBlacklistParams) {}
    
    public List<ShareBlacklistItemResult> a(CloudResult<ShareBlacklistResult> paramCloudResult)
      throws Exception
    {
      ShareBlacklistResult localShareBlacklistResult = (ShareBlacklistResult)paramCloudResult.getResult();
      if (localShareBlacklistResult != null)
      {
        if (localShareBlacklistResult.getTotal() == 0) {
          return new ArrayList();
        }
        if (localArrayList.size() >= localShareBlacklistResult.getTotal()) {
          return localArrayList;
        }
        paramCloudResult = localShareBlacklistResult.getBlackList();
        if ((paramCloudResult != null) && (!paramCloudResult.isEmpty())) {
          localArrayList.addAll(paramCloudResult);
        }
        if (localArrayList.size() >= localShareBlacklistResult.getTotal()) {
          return localArrayList;
        }
        paramShareBlacklistParams.setIndex(localArrayList.size());
        throw new CloudException(-2, "retry_get_data");
      }
      throw new CloudException(-1, "");
    }
  }
  
  class m
    implements g<Throwable>
  {
    m() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {}
  }
  
  class n
    implements io.reactivex.g0.j<CloudResult<ShareBlacklistUpdateResult>, Boolean>
  {
    n() {}
    
    public Boolean a(CloudResult<ShareBlacklistUpdateResult> paramCloudResult)
      throws Exception
    {
      paramCloudResult = (ShareBlacklistUpdateResult)paramCloudResult.getResult();
      if (paramCloudResult != null)
      {
        paramCloudResult = paramCloudResult.getUpdateList();
        if ((paramCloudResult != null) && (!paramCloudResult.isEmpty()))
        {
          if (((ShareBlacklistItemUpdateResult)paramCloudResult.get(0)).getErrorCode() == 0) {
            return Boolean.TRUE;
          }
          throw new CloudException(((ShareBlacklistItemUpdateResult)paramCloudResult.get(0)).getErrorCode(), "");
        }
        throw new CloudException(-1, "");
      }
      throw new CloudException(-1, "");
    }
  }
  
  class o
    implements io.reactivex.g0.j<CloudResult<ShareBlacklistUpdateResult>, Boolean>
  {
    o(ShareBlacklistUpdateParams paramShareBlacklistUpdateParams) {}
    
    public Boolean a(CloudResult<ShareBlacklistUpdateResult> paramCloudResult)
      throws Exception
    {
      paramCloudResult = (ShareBlacklistUpdateResult)paramCloudResult.getResult();
      if (paramCloudResult != null)
      {
        paramCloudResult = paramCloudResult.getUpdateList();
        if ((paramCloudResult != null) && (!paramCloudResult.isEmpty()))
        {
          if (((ShareBlacklistItemUpdateResult)paramCloudResult.get(0)).getErrorCode() == 0)
          {
            paramCloudResult = TCDeviceRepository.i(TCDeviceRepository.this).iterator();
            Iterator localIterator = paramShareBlacklistUpdateParams.getBlackList().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              while (paramCloudResult.hasNext()) {
                if (TextUtils.equals(((ShareBlacklistItemResult)paramCloudResult.next()).getEmail(), str)) {
                  paramCloudResult.remove();
                }
              }
            }
            TCDeviceRepository.j(TCDeviceRepository.this).postValue(TCDeviceRepository.i(TCDeviceRepository.this));
            return Boolean.TRUE;
          }
          throw new CloudException(((ShareBlacklistItemUpdateResult)paramCloudResult.get(0)).getErrorCode(), "");
        }
        throw new CloudException(-1, "");
      }
      throw new CloudException(-1, "");
    }
  }
  
  class p
    implements io.reactivex.g0.j<CloudResult<DeviceConfigInfoListResult>, DeviceConfigInfoListResult>
  {
    p() {}
    
    public DeviceConfigInfoListResult a(CloudResult<DeviceConfigInfoListResult> paramCloudResult)
      throws Exception
    {
      return (DeviceConfigInfoListResult)paramCloudResult.getResult();
    }
  }
  
  class q
    implements io.reactivex.g0.j<CloudResult<DeviceAvatarResult>, DeviceAvatarResult>
  {
    q() {}
    
    public DeviceAvatarResult a(CloudResult<DeviceAvatarResult> paramCloudResult)
      throws Exception
    {
      return (DeviceAvatarResult)paramCloudResult.getResult();
    }
  }
  
  class r
    implements io.reactivex.g0.j<CloudResult<WebServiceInfoResult>, t<CloudResult<DeviceAvatarResult>>>
  {
    r(String paramString1, byte[] paramArrayOfByte, String paramString2) {}
    
    public t<CloudResult<DeviceAvatarResult>> a(CloudResult<WebServiceInfoResult> paramCloudResult)
      throws Exception
    {
      paramCloudResult = (String)((WebServiceInfoResult)paramCloudResult.getResult()).getServiceUrls().get("device.avatar");
      if (paramCloudResult == null) {
        return q.J(new CloudException(-1, null));
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramCloudResult);
      ((StringBuilder)localObject).append("/res/uploadDeviceAvatar");
      paramCloudResult = ((StringBuilder)localObject).toString();
      localObject = MultipartBody.Part.createFormData("attachment", "avatar.png", RequestBody.create(MediaType.get(paramString2), paramArrayOfByte));
      return TCDeviceRepository.k(TCDeviceRepository.this).I1(paramCloudResult, paramString1, (MultipartBody.Part)localObject);
    }
  }
  
  class s
    implements io.reactivex.g0.j<List<TCDeviceBean>, List<TCDeviceBean>>
  {
    s() {}
    
    public List<TCDeviceBean> a(List<TCDeviceBean> paramList)
      throws Exception
    {
      TCDeviceRepository.d(TCDeviceRepository.this, paramList);
      TCDeviceRepository.e(TCDeviceRepository.this);
      return paramList;
    }
  }
  
  class t
    implements io.reactivex.g0.j<CloudResult<WebServiceInfoResult>, t<CloudResult<Void>>>
  {
    t(String paramString1, String paramString2, String paramString3, String paramString4) {}
    
    public t<CloudResult<Void>> a(CloudResult<WebServiceInfoResult> paramCloudResult)
      throws Exception
    {
      String str = (String)((WebServiceInfoResult)paramCloudResult.getResult()).getServiceUrls().get("device.config");
      if (str == null) {
        return q.J(new CloudException(-1, null));
      }
      paramCloudResult = new StringBuilder();
      paramCloudResult.append(str);
      paramCloudResult.append("/res/uploadDeviceConfigInfo");
      paramCloudResult = paramCloudResult.toString();
      return TCDeviceRepository.k(TCDeviceRepository.this).i1(paramCloudResult, new DeviceConfigInfoUploadParams(paramString2, paramString1, paramString3, paramString4));
    }
  }
  
  class u
    implements io.reactivex.g0.j<CloudResult<Void>, t<String>>
  {
    u(String paramString) {}
    
    public t<String> a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      TCDeviceRepository.f(TCDeviceRepository.this, paramString2);
      return q.f0(paramString2);
    }
  }
  
  class v
    implements io.reactivex.g0.j<CloudResult<Void>, t<String>>
  {
    v(String paramString) {}
    
    public t<String> a(CloudResult<Void> paramCloudResult)
      throws Exception
    {
      return q.f0(paramString2);
    }
  }
  
  class w
    implements io.reactivex.g0.j<CloudResult<FirmwareListResult>, FirmwareListResult>
  {
    w() {}
    
    public FirmwareListResult a(CloudResult<FirmwareListResult> paramCloudResult)
      throws Exception
    {
      return (FirmwareListResult)paramCloudResult.getResult();
    }
  }
  
  class x
    implements g<CloudResult<DeviceUserNumberLimitListResult>>
  {
    x() {}
    
    public void a(CloudResult<DeviceUserNumberLimitListResult> paramCloudResult)
      throws Exception
    {
      TCDeviceRepository.l(TCDeviceRepository.this, paramCloudResult);
    }
  }
  
  class y
    implements g<List<TCDeviceBean>>
  {
    y() {}
    
    public void a(List<TCDeviceBean> paramList)
      throws Exception
    {
      Object localObject = TCDeviceRepository.m(TCDeviceRepository.this).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TCDeviceBean)((Map.Entry)((Iterator)localObject).next()).getValue()).isCamera()) {
          ((Iterator)localObject).remove();
        }
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (TCDeviceBean)paramList.next();
        TCDeviceRepository.m(TCDeviceRepository.this).put(((TCDeviceBean)localObject).getDeviceId(), localObject);
      }
      TCDeviceRepository.e(TCDeviceRepository.this);
    }
  }
  
  class z
    implements io.reactivex.g0.j<List<TCDeviceBean>, t<List<TCDeviceBean>>>
  {
    z() {}
    
    @SuppressLint({"CheckResult"})
    public t<List<TCDeviceBean>> a(List<TCDeviceBean> paramList)
      throws Exception
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (TCDeviceBean)localIterator.next();
        if ((paramList.isCamera()) && (!paramList.isSameRegion())) {
          localArrayList1.add(paramList);
        } else {
          localArrayList2.add(paramList);
        }
      }
      if (localArrayList1.isEmpty()) {
        return q.f0(localArrayList2);
      }
      return TCDeviceRepository.n(TCDeviceRepository.this, localArrayList1, localArrayList2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\TCDeviceRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */