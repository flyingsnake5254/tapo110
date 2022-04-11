package com.tplink.libtpappcommonmedia.bean.stream;

public class StreamMediaData
{
  private static final long PTS_TIME_SCALE = 90000L;
  public String deviceIdMD5;
  public long duration;
  public int flags;
  public MediaDataFormat format;
  public int height;
  public boolean isConfigFrame;
  public boolean isKeyFrame;
  public boolean isLiveStream;
  public int offset;
  public long playTimeMs;
  public long ptsUs;
  public byte[] rawData;
  public int size;
  public int width;
  
  public StreamMediaData()
  {
    this.isLiveStream = true;
  }
  
  public StreamMediaData(boolean paramBoolean)
  {
    this.isLiveStream = paramBoolean;
  }
  
  public static long parsePtsUs(long paramLong)
  {
    return paramLong * 1000000L / 90000L;
  }
  
  public StreamMediaData clone()
  {
    StreamMediaData localStreamMediaData = new StreamMediaData();
    localStreamMediaData.width = this.width;
    localStreamMediaData.height = this.height;
    localStreamMediaData.deviceIdMD5 = this.deviceIdMD5;
    localStreamMediaData.format = this.format;
    localStreamMediaData.playTimeMs = this.playTimeMs;
    localStreamMediaData.duration = this.duration;
    localStreamMediaData.ptsUs = this.ptsUs;
    localStreamMediaData.isKeyFrame = this.isKeyFrame;
    localStreamMediaData.isConfigFrame = this.isConfigFrame;
    localStreamMediaData.flags = this.flags;
    localStreamMediaData.offset = this.offset;
    localStreamMediaData.size = this.size;
    localStreamMediaData.isLiveStream = this.isLiveStream;
    byte[] arrayOfByte1 = this.rawData;
    if (arrayOfByte1 != null)
    {
      int i = arrayOfByte1.length;
      byte[] arrayOfByte2 = new byte[i];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
      localStreamMediaData.rawData = arrayOfByte2;
    }
    return localStreamMediaData;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpappcommonmedia\bean\stream\StreamMediaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */