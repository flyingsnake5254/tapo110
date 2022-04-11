package com.tplink.iot.viewmodel.ipcamera.play;

public enum VideoDisplayMode
{
  private String value;
  
  static
  {
    VideoDisplayMode localVideoDisplayMode1 = new VideoDisplayMode("LIVE_STREAM", 0, "live");
    LIVE_STREAM = localVideoDisplayMode1;
    VideoDisplayMode localVideoDisplayMode2 = new VideoDisplayMode("PLAY_BACK", 1, "vod");
    PLAY_BACK = localVideoDisplayMode2;
    $VALUES = new VideoDisplayMode[] { localVideoDisplayMode1, localVideoDisplayMode2 };
  }
  
  private VideoDisplayMode(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\VideoDisplayMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */