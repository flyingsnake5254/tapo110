package b.d.c.a.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tplink.cloud.bean.webservice.params.DataCollectEventBean;
import com.tplink.cloud.bean.webservice.params.DataCollectRequestParams;
import com.tplink.libtpanalytics.bean.EncryptedContent;
import com.tplink.libtpanalytics.bean.EncryptedSourceParam;
import com.tplink.libtpanalytics.bean.EncryptionVersionOption;
import com.tplink.libtpanalytics.bean.EventParams;
import com.tplink.libtpanalytics.bean.PlaintextEventParam;
import com.tplink.libtpanalytics.bean.SourceParams;
import com.tplink.libtpanalytics.net.TPCloudManager;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class k
{
  private volatile boolean a = false;
  private final Handler b = new Handler(com.tplink.libtpanalytics.core.define.a.c.getLooper());
  private final Gson c = new com.google.gson.d().c().b();
  private final b.d.c.c.b d;
  private final TPCloudManager e;
  private final com.tplink.libtpanalytics.core.define.c f;
  private final b.d.c.c.c g;
  private final List<com.tplink.libtpanalytics.database.d.a> h = new ArrayList();
  
  public k(b.d.c.c.b paramb, TPCloudManager paramTPCloudManager, com.tplink.libtpanalytics.core.define.c paramc, b.d.c.c.c paramc1)
  {
    this.f = paramc;
    this.e = paramTPCloudManager;
    this.d = paramb;
    this.g = paramc1;
  }
  
  private DataCollectEventBean b(com.tplink.libtpanalytics.database.d.b paramb)
  {
    DataCollectEventBean localDataCollectEventBean = new DataCollectEventBean();
    localDataCollectEventBean.setCurrentTime(paramb.l());
    localDataCollectEventBean.setEventId(paramb.f());
    localDataCollectEventBean.setEventParams(this.c.A(e(paramb)).c());
    localDataCollectEventBean.setUserId(paramb.m());
    localDataCollectEventBean.setPageViewId(paramb.e());
    return localDataCollectEventBean;
  }
  
  private String c()
  {
    EncryptedContent localEncryptedContent = new EncryptedContent();
    localEncryptedContent.setAppId(this.f.c());
    localEncryptedContent.setAppVersion(this.f.d());
    localEncryptedContent.setRegion(this.f.k());
    localEncryptedContent.setNetworkType(this.f.i());
    localEncryptedContent.setMobileBrand(this.f.h().a());
    localEncryptedContent.setMobileModel(this.f.h().b());
    localEncryptedContent.setSystemVersion(this.f.j());
    return this.g.a(this.c.u(localEncryptedContent));
  }
  
  private List<EncryptionVersionOption> d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      com.tplink.libtpanalytics.database.d.a locala = (com.tplink.libtpanalytics.database.d.a)localIterator.next();
      EncryptionVersionOption localEncryptionVersionOption = new EncryptionVersionOption();
      localEncryptionVersionOption.setEncryptionVersionOptionId(locala.a());
      localEncryptionVersionOption.setKey(locala.b());
      localEncryptionVersionOption.setKeySize(locala.c());
      localEncryptionVersionOption.setTransformation(locala.d());
      localArrayList.add(localEncryptionVersionOption);
    }
    return localArrayList;
  }
  
  private EventParams e(com.tplink.libtpanalytics.database.d.b paramb)
  {
    EventParams localEventParams = new EventParams();
    Object localObject = (PlaintextEventParam)this.c.l(paramb.j(), PlaintextEventParam.class);
    String str1 = paramb.d();
    int i = paramb.b();
    localEventParams.setEncryptedEventParam(str1);
    localEventParams.setPlaintextEventParam((PlaintextEventParam)localObject);
    localEventParams.setEncryptedVersion(i);
    if (!TextUtils.isEmpty(paramb.c())) {
      localEventParams.setEncryptedVersionOptionId(paramb.c());
    }
    boolean bool = paramb.a().equals(this.f.d());
    EncryptedSourceParam localEncryptedSourceParam = null;
    if (bool) {
      localObject = null;
    } else {
      localObject = paramb.a();
    }
    String str2;
    if (paramb.k().equals(this.f.k())) {
      str2 = null;
    } else {
      str2 = paramb.k();
    }
    String str3;
    if (paramb.g().equals(this.f.g())) {
      str3 = null;
    } else {
      str3 = paramb.g();
    }
    if (paramb.i().equals(this.f.j())) {
      paramb = localEncryptedSourceParam;
    } else {
      paramb = paramb.i();
    }
    localEncryptedSourceParam = new EncryptedSourceParam();
    localEncryptedSourceParam.setAppVersion((String)localObject);
    localEncryptedSourceParam.setLanguage(str3);
    localEncryptedSourceParam.setRegion(str2);
    localEncryptedSourceParam.setSystemVersion(paramb);
    if (localEncryptedSourceParam.isNotAllNull())
    {
      paramb = this.g.a(this.c.u(localEncryptedSourceParam));
      if (str1 != null) {
        localEventParams.setEncryptedSourceParam(paramb);
      }
    }
    return localEventParams;
  }
  
  private SourceParams f(String paramString)
  {
    SourceParams localSourceParams = new SourceParams();
    b.d.c.c.c localc = this.g;
    if ((localc != null) && ((localc instanceof com.tplink.libtpanalytics.utils.l.f)) && (!TextUtils.isEmpty(((com.tplink.libtpanalytics.utils.l.f)localc).d()))) {
      localSourceParams.setEncryptVersionOptionId(((com.tplink.libtpanalytics.utils.l.f)this.g).d());
    }
    if (!this.h.isEmpty()) {
      localSourceParams.setEncryptVersionOption(d());
    }
    localSourceParams.setEncryptedContent(c());
    localSourceParams.setEncryptedVersion(2);
    localSourceParams.setLibraryVersion(2);
    localSourceParams.setCommitMethod(paramString);
    return localSourceParams;
  }
  
  private void w(com.tplink.libtpanalytics.core.define.b paramb, int paramInt1, int paramInt2, int paramInt3, List<DataCollectEventBean> paramList, DataCollectRequestParams paramDataCollectRequestParams, List<com.tplink.libtpanalytics.database.d.b> paramList1)
  {
    if ((paramInt2 < paramInt3) && (paramInt1 < 10))
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramList.size();
      while (i > 0)
      {
        localArrayList.addAll(paramList.subList(0, i));
        paramDataCollectRequestParams.setEventList(localArrayList);
        if (this.c.u(paramDataCollectRequestParams).getBytes().length <= 1048576) {
          break;
        }
        localArrayList.clear();
        paramDataCollectRequestParams.setEventList(null);
        i /= 2;
      }
      if ((i > 0) && (i <= paramList.size())) {
        this.e.e(paramDataCollectRequestParams).g0(new a(this, paramList1, i, paramb, paramDataCollectRequestParams, paramInt2, paramInt3, paramInt1, paramList)).C(new h(this, paramb)).F0();
      }
    }
  }
  
  private void y()
  {
    Object localObject = this.g;
    if ((localObject != null) && ((localObject instanceof com.tplink.libtpanalytics.utils.l.f)))
    {
      localObject = ((com.tplink.libtpanalytics.utils.l.f)localObject).c();
      if (localObject != null) {
        this.d.c((com.tplink.libtpanalytics.database.d.a)localObject);
      }
    }
  }
  
  private void z(com.tplink.libtpanalytics.core.define.b paramb, com.google.gson.k paramk, int paramInt, List<com.tplink.libtpanalytics.database.d.b> paramList, String paramString)
  {
    DataCollectRequestParams localDataCollectRequestParams = new DataCollectRequestParams();
    localDataCollectRequestParams.setUvi(paramString);
    localDataCollectRequestParams.setSource("android");
    localDataCollectRequestParams.setSourceParams(paramk);
    localDataCollectRequestParams.setLanguage(this.f.g());
    localDataCollectRequestParams.setTimeZone(Integer.valueOf(paramInt));
    paramk = new ArrayList();
    paramString = paramList.iterator();
    while (paramString.hasNext()) {
      paramk.add(b((com.tplink.libtpanalytics.database.d.b)paramString.next()));
    }
    w(paramb, 0, 0, paramList.size(), paramk, localDataCollectRequestParams, paramList);
  }
  
  public void a(String paramString)
  {
    if (com.tplink.libtpanalytics.utils.f.a()) {
      this.b.post(new b(this, paramString));
    }
  }
  
  public void x(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j.a().c(this);
      this.b.post(new i(this));
    }
    else
    {
      j.a().d();
      this.b.post(new f(this));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\h\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */