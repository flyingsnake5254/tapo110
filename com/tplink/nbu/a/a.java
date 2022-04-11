package com.tplink.nbu.a;

import com.tplink.nbu.bean.iam.Event;
import com.tplink.nbu.bean.iam.MaterialsResult;
import com.tplink.nbu.bean.iam.ShowedTaskParams;
import com.tplink.nbu.bean.iam.ShowedTaskResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.k;
import retrofit2.x.o;
import retrofit2.x.s;
import retrofit2.x.t;

public abstract interface a
{
  @k({"Authorization-Required:false", "nbu-signature-required:true"})
  @o("{url}/v1/tasks/event")
  public abstract io.reactivex.a a(@s(encoded=true, value="url") String paramString, @retrofit2.x.a Event paramEvent);
  
  @f("{url}/v1/materials")
  @k({"Authorization-Required:false", "nbu-signature-required:true"})
  public abstract q<MaterialsResult> b(@s(encoded=true, value="url") String paramString1, @t("accountId") String paramString2, @t("materialType") String paramString3);
  
  @k({"Authorization-Required:false", "nbu-signature-required:true"})
  @o("{url}/v1/tasks/count")
  public abstract q<ShowedTaskResult> c(@s(encoded=true, value="url") String paramString, @retrofit2.x.a ShowedTaskParams paramShowedTaskParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */