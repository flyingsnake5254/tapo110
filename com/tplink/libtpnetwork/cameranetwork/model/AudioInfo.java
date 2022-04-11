package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class AudioInfo
{
  public static final Companion Companion = new Companion(null);
  @c("microphone")
  private MicroPhoneInfo microPhoneInfo;
  @c("speaker")
  private SpeakerInfo speakerInfo;
  
  public AudioInfo(MicroPhoneInfo paramMicroPhoneInfo, SpeakerInfo paramSpeakerInfo)
  {
    this.microPhoneInfo = paramMicroPhoneInfo;
    this.speakerInfo = paramSpeakerInfo;
  }
  
  public final MicroPhoneInfo component1()
  {
    return this.microPhoneInfo;
  }
  
  public final SpeakerInfo component2()
  {
    return this.speakerInfo;
  }
  
  public final AudioInfo copy(MicroPhoneInfo paramMicroPhoneInfo, SpeakerInfo paramSpeakerInfo)
  {
    return new AudioInfo(paramMicroPhoneInfo, paramSpeakerInfo);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AudioInfo))
      {
        paramObject = (AudioInfo)paramObject;
        if ((j.a(this.microPhoneInfo, ((AudioInfo)paramObject).microPhoneInfo)) && (j.a(this.speakerInfo, ((AudioInfo)paramObject).speakerInfo))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final MicroPhoneInfo getMicroPhoneInfo()
  {
    return this.microPhoneInfo;
  }
  
  public final SpeakerInfo getSpeakerInfo()
  {
    return this.speakerInfo;
  }
  
  public int hashCode()
  {
    Object localObject = this.microPhoneInfo;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.speakerInfo;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public final void setMicroPhoneInfo(MicroPhoneInfo paramMicroPhoneInfo)
  {
    this.microPhoneInfo = paramMicroPhoneInfo;
  }
  
  public final void setSpeakerInfo(SpeakerInfo paramSpeakerInfo)
  {
    this.speakerInfo = paramSpeakerInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioInfo(microPhoneInfo=");
    localStringBuilder.append(this.microPhoneInfo);
    localStringBuilder.append(", speakerInfo=");
    localStringBuilder.append(this.speakerInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
    implements UnwrapFromResponse<AudioInfo>
  {
    public AudioInfo fromResponse(Response<Wrappers> paramResponse)
    {
      j.e(paramResponse, "response");
      if (j.a(paramResponse.getMethod(), Method.GET_AUDIO_CONFIG.getValue()))
      {
        Wrappers localWrappers = (Wrappers)paramResponse.getResult();
        paramResponse = Module.AUDIO_CONFIG;
        paramResponse = new AudioInfo((MicroPhoneInfo)Model.typeCast(localWrappers, paramResponse, Section.MICROPHONE), (SpeakerInfo)Model.typeCast(localWrappers, paramResponse, Section.SPEAKER));
      }
      else
      {
        paramResponse = null;
      }
      return paramResponse;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AudioInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */