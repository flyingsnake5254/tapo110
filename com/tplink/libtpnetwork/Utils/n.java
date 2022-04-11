package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import com.google.gson.f;
import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.IoTSubResponse;
import com.tplink.libtpnetwork.exception.IoTException;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.lang.reflect.Type;
import java.util.Iterator;

public class n
{
  public static <T> u<TPIoTResponse, IoTResult<T>> a(Class<T> paramClass)
  {
    return new a(paramClass);
  }
  
  public static <T> u<com.google.gson.i, IoTSubResponse<T>> b(String paramString, final Class<T> paramClass)
  {
    return new b(paramString, paramClass);
  }
  
  static final class a
    implements u<TPIoTResponse, IoTResult<T>>
  {
    a(Class paramClass) {}
    
    public t<IoTResult<T>> a(q<TPIoTResponse> paramq)
    {
      return paramq.L(new b()).g0(new a());
    }
    
    class a
      implements j<TPIoTResponse, IoTResult<T>>
    {
      a() {}
      
      public IoTResult<T> a(TPIoTResponse paramTPIoTResponse)
        throws Exception
      {
        Object localObject = new h(IoTResult.class, new Class[] { n.a.this.a }, null);
        localObject = (IoTResult)i.b(paramTPIoTResponse.getResult(), (Type)localObject);
        paramTPIoTResponse = (TPIoTResponse)localObject;
        if (localObject == null) {
          paramTPIoTResponse = new IoTResult();
        }
        if (paramTPIoTResponse.getErrCode() == 0) {
          return paramTPIoTResponse;
        }
        throw new IoTException(paramTPIoTResponse.getErrCode(), paramTPIoTResponse.getMsg());
      }
    }
    
    class b
      implements l<TPIoTResponse>
    {
      b() {}
      
      public boolean a(TPIoTResponse paramTPIoTResponse)
        throws Exception
      {
        if (paramTPIoTResponse.getErrorCode() == 0) {
          return true;
        }
        throw new TPGeneralNetworkException(paramTPIoTResponse.getErrorCode(), paramTPIoTResponse.getErrorMsg());
      }
    }
  }
  
  static final class b
    implements u<com.google.gson.i, IoTSubResponse<T>>
  {
    b(String paramString, Class paramClass) {}
    
    public t<IoTSubResponse<T>> a(q<com.google.gson.i> paramq)
    {
      if (paramq == null) {
        return q.J(new IoTTransportException(1200));
      }
      return paramq.g0(new a());
    }
    
    class a
      implements j<com.google.gson.i, IoTSubResponse<T>>
    {
      a() {}
      
      public IoTSubResponse<T> a(com.google.gson.i parami)
        throws Exception
      {
        try
        {
          parami = parami.c().n("responseData").c();
          if (parami != null)
          {
            Iterator localIterator = parami.c().n("result").c().n("responses").b().iterator();
            while (localIterator.hasNext())
            {
              parami = (com.google.gson.i)localIterator.next();
              if (TextUtils.equals(parami.c().n("method").e(), n.b.this.a))
              {
                int i = parami.c().n("error_code").a();
                if (i == 0)
                {
                  if (parami.c().n("result") != null) {
                    parami = parami.c().n("result").toString();
                  } else {
                    parami = null;
                  }
                  parami = i.b(parami, n.b.this.b);
                  return new IoTSubResponse(i, n.b.this.a, parami);
                }
                parami = new com/tplink/libtpnetwork/exception/IoTException;
                parami.<init>(i, null);
                throw parami;
              }
            }
            parami = new com/tplink/libtpnetwork/exception/IoTException;
            parami.<init>(-1, null);
            throw parami;
          }
          parami = new com/tplink/libtpnetwork/exception/IoTException;
          parami.<init>(1200, null);
          throw parami;
        }
        catch (Exception parami)
        {
          if ((parami instanceof IoTException)) {
            throw parami;
          }
          throw new IoTException(-1, null);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */