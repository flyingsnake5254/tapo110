package com.tplink.iot.cloud.bean.billing.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Product
{
  private String productId;
  private int productType;
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public int getProductType()
  {
    return this.productType;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void setProductType(int paramInt)
  {
    this.productType = paramInt;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProductType
  {
    public static final int AUTO_RENEW_SUBSCRIPTION = 4;
    public static final int CONSUMABLE_PRODUCT = 1;
    public static final int NON_AUTO_RENEW_SUBSCRIPTION = 3;
    public static final int NON_CONSUMABLE_PRODUCT = 2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\billing\common\Product.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */