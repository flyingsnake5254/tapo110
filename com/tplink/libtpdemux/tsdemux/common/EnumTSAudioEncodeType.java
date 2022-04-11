package com.tplink.libtpdemux.tsdemux.common;

public enum EnumTSAudioEncodeType
{
  int value;
  
  static
  {
    EnumTSAudioEncodeType localEnumTSAudioEncodeType1 = new EnumTSAudioEncodeType("TS_AUDIO_ENCODE_TYPE_INVALID", 0, -1);
    TS_AUDIO_ENCODE_TYPE_INVALID = localEnumTSAudioEncodeType1;
    EnumTSAudioEncodeType localEnumTSAudioEncodeType2 = new EnumTSAudioEncodeType("TS_AUDIO_ENCODE_TYPE_PCMA", 1, 0);
    TS_AUDIO_ENCODE_TYPE_PCMA = localEnumTSAudioEncodeType2;
    EnumTSAudioEncodeType localEnumTSAudioEncodeType3 = new EnumTSAudioEncodeType("TS_AUDIO_ENCODE_TYPE_AAC", 2, 1);
    TS_AUDIO_ENCODE_TYPE_AAC = localEnumTSAudioEncodeType3;
    EnumTSAudioEncodeType localEnumTSAudioEncodeType4 = new EnumTSAudioEncodeType("TS_AUDIO_ENCODE_TYPE_PCMU", 3, 2);
    TS_AUDIO_ENCODE_TYPE_PCMU = localEnumTSAudioEncodeType4;
    EnumTSAudioEncodeType localEnumTSAudioEncodeType5 = new EnumTSAudioEncodeType("TS_AUDIO_ENCODE_TYPE_MP2", 4, 3);
    TS_AUDIO_ENCODE_TYPE_MP2 = localEnumTSAudioEncodeType5;
    EnumTSAudioEncodeType localEnumTSAudioEncodeType6 = new EnumTSAudioEncodeType("TS_AUDIO_ENCODE_TYPE_MP3", 5, 4);
    TS_AUDIO_ENCODE_TYPE_MP3 = localEnumTSAudioEncodeType6;
    $VALUES = new EnumTSAudioEncodeType[] { localEnumTSAudioEncodeType1, localEnumTSAudioEncodeType2, localEnumTSAudioEncodeType3, localEnumTSAudioEncodeType4, localEnumTSAudioEncodeType5, localEnumTSAudioEncodeType6 };
  }
  
  private EnumTSAudioEncodeType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpdemux\tsdemux\common\EnumTSAudioEncodeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */