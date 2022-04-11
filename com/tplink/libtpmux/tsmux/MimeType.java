package com.tplink.libtpmux.tsmux;

public enum MimeType
{
  int value;
  
  static
  {
    MimeType localMimeType1 = new MimeType("MUXTS_CODEC_HEVC", 0, 0);
    MUXTS_CODEC_HEVC = localMimeType1;
    MimeType localMimeType2 = new MimeType("MUXTS_CODEC_AVC", 1, 1);
    MUXTS_CODEC_AVC = localMimeType2;
    MimeType localMimeType3 = new MimeType("MUXTS_CODEC_AAC", 2, 2);
    MUXTS_CODEC_AAC = localMimeType3;
    MimeType localMimeType4 = new MimeType("MUXTS_CODEC_PCMA", 3, 3);
    MUXTS_CODEC_PCMA = localMimeType4;
    $VALUES = new MimeType[] { localMimeType1, localMimeType2, localMimeType3, localMimeType4 };
  }
  
  private MimeType(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmux\tsmux\MimeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */