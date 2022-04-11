package com.googlecode.mp4parser.authoring.tracks.h265;

public enum H265TrackImplOld$PARSE_STATE
{
  static
  {
    PARSE_STATE localPARSE_STATE1 = new PARSE_STATE("AUD_SEI_SLICE", 0);
    AUD_SEI_SLICE = localPARSE_STATE1;
    PARSE_STATE localPARSE_STATE2 = new PARSE_STATE("SEI_SLICE", 1);
    SEI_SLICE = localPARSE_STATE2;
    PARSE_STATE localPARSE_STATE3 = new PARSE_STATE("SLICE_OES_EOB", 2);
    SLICE_OES_EOB = localPARSE_STATE3;
    ENUM$VALUES = new PARSE_STATE[] { localPARSE_STATE1, localPARSE_STATE2, localPARSE_STATE3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\googlecode\mp4parser\authoring\tracks\h265\H265TrackImplOld$PARSE_STATE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */