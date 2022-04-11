package com.tplink.iot.cloud.bean.billing.result;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class JudgeReceiptResult
{
  private int status;
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface JudgeStatus
  {
    public static final int EXPIRED = -10107;
    public static final int MATCHING = 0;
    public static final int NOT_MATCHING = -10102;
    public static final int RECEIPT_NOT_FOUND = -10105;
    public static final int VERIFY_FAIL = -10106;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\billing\result\JudgeReceiptResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */