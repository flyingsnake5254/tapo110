package com.tplink.iot.cloud.bean.billing.result;

import com.tplink.iot.cloud.bean.billing.common.Product;
import java.util.List;

public class ProductListResult
{
  private List<Product> productList;
  
  public List<Product> getProductList()
  {
    return this.productList;
  }
  
  public void setProductList(List<Product> paramList)
  {
    this.productList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\billing\result\ProductListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */