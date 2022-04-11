package com.tplink.libtpappcommonmedia.bean.demux;

public class DemuxResultBean
{
  private AudioPacket audioPacket;
  private VideoPacket videoPacket;
  
  public AudioPacket getAudioPacket()
  {
    return this.audioPacket;
  }
  
  public VideoPacket getVideoPacket()
  {
    return this.videoPacket;
  }
  
  public void setAudioPacket(AudioPacket paramAudioPacket)
  {
    this.audioPacket = paramAudioPacket;
  }
  
  public void setVideoPacket(VideoPacket paramVideoPacket)
  {
    this.videoPacket = paramVideoPacket;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpappcommonmedia\bean\demux\DemuxResultBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */