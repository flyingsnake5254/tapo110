package com.tplink.iot.cloud.bean.billing.result;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class VerifyReceiptResult
{
  private String orderId;
  private int status;
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VerifyStatus
  {
    public static final int OK = 0;
    public static final int RECEIPT_INVALID = -10100;
    public static final int RECEIPT_NOT_MATCH = -10102;
    public static final int RECEIPT_SERVER_ERROR = -10103;
    public static final int RECEIPT_SYSTEM_ERROR = -10104;
    public static final int RECEIPT_UNRESOLVED = -10101;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\billing\result\VerifyReceiptResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */