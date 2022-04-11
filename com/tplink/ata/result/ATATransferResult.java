package com.tplink.ata.result;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.ata.common.ByteArrayBase64TypeAdapter;

public class ATATransferResult
  extends ATABaseResult
{
  @b(ByteArrayBase64TypeAdapter.class)
  @c("raw_data")
  private byte[] rawData;
  private long sn;
  
  public byte[] getRawData()
  {
    return this.rawData;
  }
  
  public long getSn()
  {
    return this.sn;
  }
  
  public void setRawData(byte[] paramArrayOfByte)
  {
    this.rawData = paramArrayOfByte;
  }
  
  public void setSn(long paramLong)
  {
    this.sn = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\result\ATATransferResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */