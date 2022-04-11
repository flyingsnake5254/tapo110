package com.tplink.libtpanalytics.net;

import b.d.b.c.j;
import b.d.b.f.a;
import com.google.gson.Gson;
import com.google.gson.d;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.webservice.params.DataCollectRequestParams;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicInteger;

public class TPCloudManager
  extends a
{
  private static final Gson c = new d().c().b();
  private final j d;
  private com.tplink.libtpanalytics.core.define.c e;
  private final AtomicInteger f = new AtomicInteger(0);
  private volatile boolean g = false;
  
  public TPCloudManager(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
    this.d = ((j)paramb.d().R1(j.class));
  }
  
  public void d(com.tplink.libtpanalytics.core.define.c paramc)
  {
    if (this.g) {
      return;
    }
    this.e = paramc;
    this.g = true;
  }
  
  public q<CloudResult> e(DataCollectRequestParams paramDataCollectRequestParams)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(System.currentTimeMillis() / 1000L);
    Object localObject3 = "";
    ((StringBuilder)localObject1).append("");
    String str2 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.f.getAndAdd(1));
    ((StringBuilder)localObject1).append("");
    String str3 = ((StringBuilder)localObject1).toString();
    localObject1 = c.u(paramDataCollectRequestParams);
    try
    {
      localObject1 = com.tplink.libtpanalytics.utils.l.c.e((String)localObject1);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      str1 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("\n");
    localStringBuilder.append(str2);
    localStringBuilder.append("\n");
    localStringBuilder.append(str3);
    localStringBuilder.append("\n");
    localStringBuilder.append("/api/data/app/uploadBasicData");
    String str1 = localStringBuilder.toString();
    try
    {
      str1 = com.tplink.libtpanalytics.utils.l.b.a(str1, this.e.l());
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      localObject2 = localObject3;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Id=");
    ((StringBuilder)localObject3).append(str3);
    ((StringBuilder)localObject3).append(",TimeStamp=");
    ((StringBuilder)localObject3).append(str2);
    ((StringBuilder)localObject3).append(",AccessKey=");
    ((StringBuilder)localObject3).append(this.e.a());
    ((StringBuilder)localObject3).append(",Signature=");
    ((StringBuilder)localObject3).append((String)localObject2);
    Object localObject2 = ((StringBuilder)localObject3).toString();
    return this.d.d1(this.e.e(), (String)localObject2, paramDataCollectRequestParams);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\net\TPCloudManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */