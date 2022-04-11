package com.bumptech.glide.load;

public enum EncodeStrategy
{
  static
  {
    EncodeStrategy localEncodeStrategy1 = new EncodeStrategy("SOURCE", 0);
    SOURCE = localEncodeStrategy1;
    EncodeStrategy localEncodeStrategy2 = new EncodeStrategy("TRANSFORMED", 1);
    TRANSFORMED = localEncodeStrategy2;
    EncodeStrategy localEncodeStrategy3 = new EncodeStrategy("NONE", 2);
    NONE = localEncodeStrategy3;
    $VALUES = new EncodeStrategy[] { localEncodeStrategy1, localEncodeStrategy2, localEncodeStrategy3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\EncodeStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */