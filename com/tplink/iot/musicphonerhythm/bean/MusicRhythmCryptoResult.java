package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;

public class MusicRhythmCryptoResult
{
  @c("iv")
  private String iv;
  @c("key")
  private String key;
  @c("port")
  private int port;
  @c("timeout")
  private int timeout;
  
  public MusicRhythmCryptoResult()
  {
    this.key = null;
    this.iv = null;
  }
  
  public MusicRhythmCryptoResult(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.key = paramString1;
    this.iv = paramString2;
    this.timeout = paramInt1;
    this.port = paramInt2;
  }
  
  public String getIv()
  {
    return this.iv;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public int getTimeout()
  {
    return this.timeout;
  }
  
  public void setIv(String paramString)
  {
    this.iv = paramString;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }
  
  public void setTimeout(int paramInt)
  {
    this.timeout = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmCryptoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */