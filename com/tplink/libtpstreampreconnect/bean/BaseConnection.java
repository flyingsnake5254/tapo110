package com.tplink.libtpstreampreconnect.bean;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseConnection
{
  protected String audioType;
  protected BitStreamType bitStreamType;
  protected int connectionType;
  protected long createTime = 0L;
  protected String deviceIdMD5;
  protected DeviceModel deviceModel;
  protected String encryptType;
  protected long endTime;
  protected String ip;
  protected boolean isLocal;
  protected int mediaType;
  protected int port;
  protected int portId;
  protected int relayTime = 300;
  protected long startTime;
  protected List<NatStatistics> statistics;
  protected int streamType;
  protected String talkMode;
  protected String url;
  
  public BaseConnection(String paramString, DeviceModel paramDeviceModel)
  {
    this.deviceIdMD5 = paramString;
    this.deviceModel = paramDeviceModel;
    this.statistics = new ArrayList();
  }
  
  public abstract BaseConnection clone();
  
  public String getAudioType()
  {
    return this.audioType;
  }
  
  public BitStreamType getBitStreamType()
  {
    return this.bitStreamType;
  }
  
  public int getConnectionType()
  {
    return this.connectionType;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public String getDeviceIdMD5()
  {
    return this.deviceIdMD5;
  }
  
  public DeviceModel getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getEncryptType()
  {
    return this.encryptType;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public int getPortId()
  {
    return this.portId;
  }
  
  public int getRelayTime()
  {
    return this.relayTime;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public List<NatStatistics> getStatistics()
  {
    return this.statistics;
  }
  
  public int getStreamType()
  {
    return this.streamType;
  }
  
  public String getTalkMode()
  {
    return this.talkMode;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isLocal()
  {
    return this.isLocal;
  }
  
  public void setAudioType(String paramString)
  {
    this.audioType = paramString;
  }
  
  public void setBitStreamType(BitStreamType paramBitStreamType)
  {
    this.bitStreamType = paramBitStreamType;
  }
  
  public void setConnectionType(int paramInt)
  {
    this.connectionType = paramInt;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    this.deviceIdMD5 = paramString;
  }
  
  public void setDeviceModel(DeviceModel paramDeviceModel)
  {
    this.deviceModel = paramDeviceModel;
  }
  
  public void setEncryptType(String paramString)
  {
    this.encryptType = paramString;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.isLocal = paramBoolean;
  }
  
  public void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }
  
  public void setPortId(int paramInt)
  {
    this.portId = paramInt;
  }
  
  public void setRelayTime(int paramInt)
  {
    this.relayTime = paramInt;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setStatistics(List<NatStatistics> paramList)
  {
    this.statistics = paramList;
  }
  
  public void setStreamType(int paramInt)
  {
    this.streamType = paramInt;
  }
  
  public void setTalkMode(String paramString)
  {
    this.talkMode = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreampreconnect\bean\BaseConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */