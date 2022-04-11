package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttConnectVariableHeader
{
  private final boolean hasPassword;
  private final boolean hasUserName;
  private final boolean isCleanSession;
  private final boolean isWillFlag;
  private final boolean isWillRetain;
  private final int keepAliveTimeSeconds;
  private final String name;
  private final int version;
  private final int willQos;
  
  public MqttConnectVariableHeader(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, boolean paramBoolean4, boolean paramBoolean5, int paramInt3)
  {
    this.name = paramString;
    this.version = paramInt1;
    this.hasUserName = paramBoolean1;
    this.hasPassword = paramBoolean2;
    this.isWillRetain = paramBoolean3;
    this.willQos = paramInt2;
    this.isWillFlag = paramBoolean4;
    this.isCleanSession = paramBoolean5;
    this.keepAliveTimeSeconds = paramInt3;
  }
  
  public boolean hasPassword()
  {
    return this.hasPassword;
  }
  
  public boolean hasUserName()
  {
    return this.hasUserName;
  }
  
  public boolean isCleanSession()
  {
    return this.isCleanSession;
  }
  
  public boolean isWillFlag()
  {
    return this.isWillFlag;
  }
  
  public boolean isWillRetain()
  {
    return this.isWillRetain;
  }
  
  public int keepAliveTimeSeconds()
  {
    return this.keepAliveTimeSeconds;
  }
  
  public String name()
  {
    return this.name;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", hasUserName=");
    localStringBuilder.append(this.hasUserName);
    localStringBuilder.append(", hasPassword=");
    localStringBuilder.append(this.hasPassword);
    localStringBuilder.append(", isWillRetain=");
    localStringBuilder.append(this.isWillRetain);
    localStringBuilder.append(", isWillFlag=");
    localStringBuilder.append(this.isWillFlag);
    localStringBuilder.append(", isCleanSession=");
    localStringBuilder.append(this.isCleanSession);
    localStringBuilder.append(", keepAliveTimeSeconds=");
    localStringBuilder.append(this.keepAliveTimeSeconds);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public int version()
  {
    return this.version;
  }
  
  public int willQos()
  {
    return this.willQos;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttConnectVariableHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */