package com.tplink.iab.beans;

import android.text.TextUtils;
import com.android.billingclient.api.SkuDetails;
import com.tplink.iab.b;

public class ProductDetails
{
  private String country;
  private String currency;
  private int discountDuration;
  private int discountDurationUnit;
  private Double discountPrice;
  private int duration;
  private int durationUnit;
  private int introDuration;
  private int introDurationUnit;
  private Double introductoryPrice;
  private Double price;
  private String productDescription;
  private String productId;
  private String productName;
  
  public ProductDetails() {}
  
  public ProductDetails(SkuDetails paramSkuDetails)
  {
    this.productId = paramSkuDetails.i();
    if ((paramSkuDetails.f() != 0L) && (paramSkuDetails.f() != paramSkuDetails.g()))
    {
      this.price = Double.valueOf(b.a(paramSkuDetails.f() / 1000000.0D));
      this.discountPrice = Double.valueOf(b.a(paramSkuDetails.g() / 1000000.0D));
    }
    else
    {
      this.price = Double.valueOf(b.a(paramSkuDetails.g() / 1000000.0D));
      this.discountPrice = null;
    }
    this.introductoryPrice = calIntroductoryPrice(paramSkuDetails);
    this.productName = paramSkuDetails.k();
    this.currency = paramSkuDetails.h();
    this.productDescription = paramSkuDetails.a();
    String str = getNullableString(paramSkuDetails.j());
    this.duration = b.b(str);
    this.durationUnit = b.c(str);
    this.introDuration = paramSkuDetails.d();
  }
  
  private Double calIntroductoryPrice(SkuDetails paramSkuDetails)
  {
    if (TextUtils.isEmpty(paramSkuDetails.b())) {
      return null;
    }
    return Double.valueOf(b.a(paramSkuDetails.c() / 1000000.0D));
  }
  
  private String getNullableString(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return paramString;
    }
    return null;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public String getCurrency()
  {
    return this.currency;
  }
  
  public int getDiscountDuration()
  {
    return this.discountDuration;
  }
  
  public int getDiscountDurationUnit()
  {
    return this.discountDurationUnit;
  }
  
  public double getDiscountPrice()
  {
    return this.discountPrice.doubleValue();
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public int getDurationUnit()
  {
    return this.durationUnit;
  }
  
  public int getIntroDuration()
  {
    return this.introDuration;
  }
  
  public int getIntroDurationUnit()
  {
    return this.introDurationUnit;
  }
  
  public double getIntroductoryPrice()
  {
    return this.introductoryPrice.doubleValue();
  }
  
  public double getPrice()
  {
    return this.price.doubleValue();
  }
  
  public String getProductDescription()
  {
    return this.productDescription;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public String getProductName()
  {
    return this.productName;
  }
  
  public void setCountry(String paramString)
  {
    this.country = paramString;
  }
  
  public void setCurrency(String paramString)
  {
    this.currency = paramString;
  }
  
  public void setDiscountDuration(int paramInt)
  {
    this.discountDuration = paramInt;
  }
  
  public void setDiscountDurationUnit(int paramInt)
  {
    this.discountDurationUnit = paramInt;
  }
  
  public void setDiscountPrice(double paramDouble)
  {
    this.discountPrice = Double.valueOf(paramDouble);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setDurationUnit(int paramInt)
  {
    this.durationUnit = paramInt;
  }
  
  public void setIntroDuration(int paramInt)
  {
    this.introDuration = paramInt;
  }
  
  public void setIntroDurationUnit(int paramInt)
  {
    this.introDurationUnit = paramInt;
  }
  
  public void setIntroductoryPrice(double paramDouble)
  {
    this.introductoryPrice = Double.valueOf(paramDouble);
  }
  
  public void setPrice(double paramDouble)
  {
    this.price = Double.valueOf(paramDouble);
  }
  
  public void setProductDescription(String paramString)
  {
    this.productDescription = paramString;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void setProductName(String paramString)
  {
    this.productName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iab\beans\ProductDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */