package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class CLSUUID
{
  private static String _clsId;
  private static final AtomicLong _sequenceNumber = new AtomicLong(0L);
  
  CLSUUID(IdManager paramIdManager)
  {
    Object localObject = new byte[10];
    populateTime((byte[])localObject);
    populateSequenceNumber((byte[])localObject);
    populatePID((byte[])localObject);
    paramIdManager = CommonUtils.sha1(paramIdManager.getCrashlyticsInstallId());
    localObject = CommonUtils.hexify((byte[])localObject);
    Locale localLocale = Locale.US;
    _clsId = String.format(localLocale, "%s%s%s%s", new Object[] { ((String)localObject).substring(0, 12), ((String)localObject).substring(12, 16), ((String)localObject).subSequence(16, 20), paramIdManager.substring(0, 12) }).toUpperCase(localLocale);
  }
  
  private static byte[] convertLongToFourByteBuffer(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt((int)paramLong);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    return localByteBuffer.array();
  }
  
  private static byte[] convertLongToTwoByteBuffer(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.putShort((short)(int)paramLong);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.position(0);
    return localByteBuffer.array();
  }
  
  private void populatePID(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = convertLongToTwoByteBuffer(Integer.valueOf(Process.myPid()).shortValue());
    paramArrayOfByte[8] = ((byte)arrayOfByte[0]);
    paramArrayOfByte[9] = ((byte)arrayOfByte[1]);
  }
  
  private void populateSequenceNumber(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = convertLongToTwoByteBuffer(_sequenceNumber.incrementAndGet());
    paramArrayOfByte[6] = ((byte)arrayOfByte[0]);
    paramArrayOfByte[7] = ((byte)arrayOfByte[1]);
  }
  
  private void populateTime(byte[] paramArrayOfByte)
  {
    long l = new Date().getTime();
    byte[] arrayOfByte = convertLongToFourByteBuffer(l / 1000L);
    paramArrayOfByte[0] = ((byte)arrayOfByte[0]);
    paramArrayOfByte[1] = ((byte)arrayOfByte[1]);
    paramArrayOfByte[2] = ((byte)arrayOfByte[2]);
    paramArrayOfByte[3] = ((byte)arrayOfByte[3]);
    arrayOfByte = convertLongToTwoByteBuffer(l % 1000L);
    paramArrayOfByte[4] = ((byte)arrayOfByte[0]);
    paramArrayOfByte[5] = ((byte)arrayOfByte[1]);
  }
  
  public String toString()
  {
    return _clsId;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CLSUUID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */