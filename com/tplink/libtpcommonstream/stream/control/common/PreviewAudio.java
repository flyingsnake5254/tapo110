package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PreviewAudio
{
  public static final String AUDIO_DEFAULT = "default";
  public static final String AUDIO_DISABLE = "disable";
  public static final String AUDIO_ENABLE = "enable";
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\PreviewAudio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */