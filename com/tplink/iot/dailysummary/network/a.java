package com.tplink.iot.dailysummary.network;

import com.tplink.iot.dailysummary.network.bean.common.SummaryConfig;
import com.tplink.iot.dailysummary.network.bean.params.CancelCreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.params.CreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.params.DeleteSummaryParams;
import com.tplink.iot.dailysummary.network.bean.result.RecentSummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryClipInfoResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryEventIdResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import com.tplink.iot.dailysummary.network.bean.result.SummarySupportResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.h;
import retrofit2.x.o;
import retrofit2.x.s;
import retrofit2.x.t;

public abstract interface a
{
  @f("{url}/v1/summary/config")
  public abstract q<SummaryConfig> a(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2);
  
  @o("{url}/v1/summary")
  public abstract q<SummaryEventIdResult> b(@s(encoded=true, value="url") String paramString, @retrofit2.x.a CreateSummaryParams paramCreateSummaryParams);
  
  @f("{url}/v1/summary/recent")
  public abstract q<RecentSummaryListResult> c(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2, @t("size") int paramInt);
  
  @f("{url}/v1/summary/metadata")
  public abstract q<SummaryClipInfoResult> d(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2, @t("date") String paramString3, @t("uuid") String paramString4);
  
  @f("{url}/v1/summary")
  public abstract q<SummaryResult> e(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2, @t("date") String paramString3);
  
  @f("{url}/v1/summary/version")
  public abstract q<SummarySupportResult> f(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2, @t("timezone") String paramString3, @t("deviceType") String paramString4);
  
  @f("{url}/v1/summary/list")
  public abstract q<SummaryListResult> g(@s(encoded=true, value="url") String paramString1, @t("deviceId") String paramString2, @t("page") int paramInt1, @t("pageSize") int paramInt2);
  
  @h(hasBody=true, method="DELETE", path="{url}/v1/summary")
  public abstract io.reactivex.a h(@s(encoded=true, value="url") String paramString, @retrofit2.x.a DeleteSummaryParams paramDeleteSummaryParams);
  
  @o("{url}/v1/summary/cancel")
  public abstract q<SummaryEventIdResult> i(@s(encoded=true, value="url") String paramString, @retrofit2.x.a CancelCreateSummaryParams paramCancelCreateSummaryParams);
  
  @o("{url}/v1/summary/config")
  public abstract io.reactivex.a j(@s(encoded=true, value="url") String paramString, @retrofit2.x.a SummaryConfig paramSummaryConfig);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */