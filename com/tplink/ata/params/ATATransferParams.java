package com.tplink.ata.params;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.ata.common.ATAMethodType;
import com.tplink.ata.common.ByteArrayBase64TypeAdapter;

public class ATATransferParams
  extends ATABaseParams
{
  @b(ByteArrayBase64TypeAdapter.class)
  @c("raw_data")
  private byte[] rawData;
  private long sn;
  
  public ATATransferParams() {}
  
  public ATATransferParams(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    super(paramString, ATAMethodType.TRANSFER);
    this.sn = paramLong;
    this.rawData = paramArrayOfByte;
  }
  
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\params\ATATransferParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */