package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import android.text.TextUtils;
import com.tplink.iot.c.b.c;
import com.tplink.iot.cloud.bean.billing.common.Product;
import com.tplink.iot.cloud.bean.billing.params.ReceiptParams;
import com.tplink.iot.cloud.bean.billing.params.ReceiptParams.PurchaseData;
import com.tplink.iot.cloud.bean.billing.result.VerifyReceiptResult;
import com.tplink.iot.cloud.repository.AbstractIoTCloudRepository;
import io.reactivex.q;
import java.util.List;

public class NBUBillingRepository
  extends AbstractIoTCloudRepository
{
  private c h;
  private String i;
  private AppUrlRepository j;
  
  public NBUBillingRepository(com.tplink.iot.c.c.a parama)
  {
    super(parama);
    this.h = ((c)parama.k().R1(c.class));
    this.j = ((AppUrlRepository)b.d.b.f.b.a(b.d.s.a.a.f(), AppUrlRepository.class));
  }
  
  public q<VerifyReceiptResult> J(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ReceiptParams localReceiptParams = new ReceiptParams();
    localReceiptParams.setPlatform("android");
    ReceiptParams.PurchaseData localPurchaseData = new ReceiptParams.PurchaseData();
    localReceiptParams.setAccountId(paramString1);
    localPurchaseData.setPackageName(paramString2);
    localPurchaseData.setProductId(paramString3);
    localPurchaseData.setPurchaseToken(paramString4);
    localReceiptParams.setPurchaseData(localPurchaseData);
    return w().N(new a1(this, localReceiptParams));
  }
  
  public q<Boolean> w()
  {
    if (!TextUtils.isEmpty(this.i)) {
      return q.f0(Boolean.TRUE);
    }
    if (!TextUtils.isEmpty(this.j.f()))
    {
      this.i = this.j.f();
      return q.f0(Boolean.TRUE);
    }
    return this.j.d().E(new d1(this)).C(e1.c).L0(io.reactivex.l0.a.c());
  }
  
  public q<List<Product>> x()
  {
    return w().N(new b1(this));
  }
  
  public q<Integer> y(String paramString1, String paramString2, String paramString3)
  {
    ReceiptParams localReceiptParams = new ReceiptParams();
    localReceiptParams.setPlatform("android");
    ReceiptParams.PurchaseData localPurchaseData = new ReceiptParams.PurchaseData();
    localPurchaseData.setPackageName(paramString1);
    localPurchaseData.setProductId(paramString2);
    localPurchaseData.setPurchaseToken(paramString3);
    localReceiptParams.setPurchaseData(localPurchaseData);
    return w().N(new f1(this, localReceiptParams));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\repository\NBUBillingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */