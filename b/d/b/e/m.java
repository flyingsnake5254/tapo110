package b.d.b.e;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.Locale;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class m
  implements Interceptor
{
  private final o.a a;
  
  public m(o.a parama)
  {
    this.a = parama;
  }
  
  @NonNull
  public Response intercept(@NonNull Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    Object localObject1 = localRequest.url();
    String str = localRequest.header("query-params-required");
    Object localObject2 = null;
    Object localObject3 = null;
    if ((str == null) || (!str.equals("false")))
    {
      str = localRequest.header("token-required");
      if (str != null)
      {
        localObject2 = localObject3;
        if (str.equals("false")) {}
      }
      else
      {
        localObject2 = this.a.getToken();
      }
      localObject1 = ((HttpUrl)localObject1).newBuilder().addQueryParameter("appName", this.a.o()).addQueryParameter("appVer", this.a.a()).addQueryParameter("netType", this.a.b()).addQueryParameter("termID", this.a.d());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Android ");
      ((StringBuilder)localObject3).append(Build.VERSION.RELEASE);
      localObject1 = ((HttpUrl.Builder)localObject1).addQueryParameter("ospf", ((StringBuilder)localObject3).toString());
      if (this.a.l() == null) {
        localObject3 = "TPLINK";
      } else {
        localObject3 = this.a.l();
      }
      localObject1 = ((HttpUrl.Builder)localObject1).addQueryParameter("brand", (String)localObject3);
      str = this.a.c();
      localObject3 = str;
      if (str == null) {
        localObject3 = Locale.getDefault().toString();
      }
      ((HttpUrl.Builder)localObject1).addQueryParameter("locale", (String)localObject3);
      if (this.a.i() != null) {
        ((HttpUrl.Builder)localObject1).addQueryParameter("model", this.a.i());
      }
      if (this.a.n() != null) {
        ((HttpUrl.Builder)localObject1).addQueryParameter("termName", this.a.n());
      }
      if (this.a.p() != null) {
        ((HttpUrl.Builder)localObject1).addQueryParameter("termMeta", this.a.p());
      }
      if (localObject2 != null) {
        ((HttpUrl.Builder)localObject1).addQueryParameter("token", (String)localObject2);
      }
      localObject2 = localObject1;
    }
    localObject3 = localRequest.newBuilder();
    if (localObject2 != null) {
      ((Request.Builder)localObject3).url(((HttpUrl.Builder)localObject2).build());
    }
    ((Request.Builder)localObject3).removeHeader("token-required");
    ((Request.Builder)localObject3).removeHeader("query-params-required");
    if (localRequest.header("Content-Type") == null) {
      ((Request.Builder)localObject3).addHeader("Content-Type", "application/json;charset=UTF-8");
    }
    return paramChain.proceed(((Request.Builder)localObject3).build());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\e\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */