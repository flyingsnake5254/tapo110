package com.googlecode.mp4parser.authoring.tracks.h264;

public enum SliceHeader$SliceType
{
  static
  {
    SliceType localSliceType1 = new SliceType("P", 0);
    P = localSliceType1;
    SliceType localSliceType2 = new SliceType("B", 1);
    B = localSliceType2;
    SliceType localSliceType3 = new SliceType("I", 2);
    I = localSliceType3;
    SliceType localSliceType4 = new SliceType("SP", 3);
    SP = localSliceType4;
    SliceType localSliceType5 = new SliceType("SI", 4);
    SI = localSliceType5;
    ENUM$VALUES = new SliceType[] { localSliceType1, localSliceType2, localSliceType3, localSliceType4, localSliceType5 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\googlecode\mp4parser\authoring\tracks\h264\SliceHeader$SliceType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */