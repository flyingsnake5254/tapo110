package com.tplink.libtpnetwork.cameranetwork.h4.p4;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.cameranetwork.h4.h4;
import com.tplink.libtpnetwork.cameranetwork.h4.k4;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.q;
import java.util.HashMap;
import java.util.Map;

public class e
  extends h4
{
  private g c;
  private String d;
  private f e;
  private Map<String, String> f;
  private com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a g = new a();
  
  public e(g paramg)
  {
    this.c = paramg;
    if (paramg.a() != null)
    {
      localObject = paramg.a();
      j4(((com.tplink.cloud.context.a)localObject).b(), ((com.tplink.cloud.context.a)localObject).q(), ((com.tplink.cloud.context.a)localObject).o(), ((com.tplink.cloud.context.a)localObject).d(), ((com.tplink.cloud.context.a)localObject).n(), ((com.tplink.cloud.context.a)localObject).l());
    }
    Object localObject = new k4();
    this.d = paramg.d();
    this.e = ((k4)localObject).a(paramg.c(), null, this.g, paramg.b());
  }
  
  protected q<Response<Wrappers>> c3(Request<MultipleRequest> paramRequest)
  {
    if (TextUtils.isEmpty(this.d)) {
      return q.J(new Throwable("cloud token is null"));
    }
    return this.e.a(this.d, paramRequest);
  }
  
  protected q<Response<MultipleResponse>> d3(Request<MultipleRequest> paramRequest)
  {
    if (TextUtils.isEmpty(this.d)) {
      return q.J(new Throwable("cloud token is null"));
    }
    return this.e.b(this.d, paramRequest);
  }
  
  protected q<Response<Wrappers>> e3(Request paramRequest)
  {
    return this.e.c(paramRequest);
  }
  
  public g i4()
  {
    return this.c;
  }
  
  public void j4(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull String paramString5, @NonNull String paramString6)
  {
    HashMap localHashMap = new HashMap(5);
    this.f = localHashMap;
    localHashMap.put("appName", paramString1);
    this.f.put("termID", paramString2);
    this.f.put("ospf", paramString3);
    this.f.put("appVer", paramString4);
    this.f.put("netType", paramString5);
    this.f.put("locale", paramString6);
  }
  
  public void k4(g paramg)
  {
    if (paramg.a() != null)
    {
      com.tplink.cloud.context.a locala = paramg.a();
      j4(locala.b(), locala.q(), locala.o(), locala.d(), locala.n(), locala.l());
    }
    if (!TextUtils.equals(this.d, paramg.d())) {
      this.d = paramg.d();
    }
    this.c = paramg;
  }
  
  class a
    implements com.tplink.libtpnetwork.cameranetwork.h4.m4.a.a
  {
    a() {}
    
    public Map<String, String> a(@NonNull String paramString)
    {
      if (e.h4(e.this) != null) {
        return e.h4(e.this);
      }
      return null;
    }
    
    public Map<String, String> b(@NonNull String paramString)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\p4\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */