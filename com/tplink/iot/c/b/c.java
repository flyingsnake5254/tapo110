package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.billing.params.ReceiptParams;
import com.tplink.iot.cloud.bean.billing.result.JudgeReceiptResult;
import com.tplink.iot.cloud.bean.billing.result.ProductListResult;
import com.tplink.iot.cloud.bean.billing.result.VerifyReceiptResult;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.f;
import retrofit2.x.o;
import retrofit2.x.s;

public abstract interface c
{
  @o("{url}/v1/receipt/verify")
  public abstract q<VerifyReceiptResult> n1(@s(encoded=true, value="url") String paramString, @a ReceiptParams paramReceiptParams);
  
  @o("{url}/v1/receipt/match")
  public abstract q<JudgeReceiptResult> q(@s(encoded=true, value="url") String paramString, @a ReceiptParams paramReceiptParams);
  
  @f("{url}/v1/product/app")
  public abstract q<ProductListResult> u0(@s(encoded=true, value="url") String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */