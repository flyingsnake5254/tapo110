package com.tplink.libtpappcommonmedia.bean.stream;

public enum MediaDataFormat
{
  private String value;
  
  static
  {
    MediaDataFormat localMediaDataFormat1 = new MediaDataFormat("AUDIO_WAV", 0, "audio/x-wav");
    AUDIO_WAV = localMediaDataFormat1;
    MediaDataFormat localMediaDataFormat2 = new MediaDataFormat("VIDEO_H264", 1, "video/x-h264");
    VIDEO_H264 = localMediaDataFormat2;
    MediaDataFormat localMediaDataFormat3 = new MediaDataFormat("VIDEO_MP2T", 2, "video/mp2t");
    VIDEO_MP2T = localMediaDataFormat3;
    MediaDataFormat localMediaDataFormat4 = new MediaDataFormat("AUDIO_MP2T", 3, "audio/mp2t");
    AUDIO_MP2T = localMediaDataFormat4;
    MediaDataFormat localMediaDataFormat5 = new MediaDataFormat("VOD_STREAM_FINISH", 4, "vodStreamFinish");
    VOD_STREAM_FINISH = localMediaDataFormat5;
    $VALUES = new MediaDataFormat[] { localMediaDataFormat1, localMediaDataFormat2, localMediaDataFormat3, localMediaDataFormat4, localMediaDataFormat5 };
  }
  
  private MediaDataFormat(String paramString)
  {
    this.value = paramString;
  }
  
  public static MediaDataFormat fromValue(String paramString)
  {
    for (MediaDataFormat localMediaDataFormat : ) {
      if (localMediaDataFormat.value.equalsIgnoreCase(paramString)) {
        return localMediaDataFormat;
      }
    }
    return null;
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpappcommonmedia\bean\stream\MediaDataFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */