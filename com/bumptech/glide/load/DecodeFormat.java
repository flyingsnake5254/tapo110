package com.bumptech.glide.load;

public enum DecodeFormat
{
  public static final DecodeFormat DEFAULT;
  
  static
  {
    DecodeFormat localDecodeFormat1 = new DecodeFormat("PREFER_ARGB_8888", 0);
    PREFER_ARGB_8888 = localDecodeFormat1;
    DecodeFormat localDecodeFormat2 = new DecodeFormat("PREFER_RGB_565", 1);
    PREFER_RGB_565 = localDecodeFormat2;
    $VALUES = new DecodeFormat[] { localDecodeFormat1, localDecodeFormat2 };
    DEFAULT = localDecodeFormat1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\DecodeFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */