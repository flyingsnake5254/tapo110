package com.google.android.exoplayer2.video;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.r;

public class MediaCodecVideoDecoderException
  extends MediaCodecDecoderException
{
  public final boolean isSurfaceValid;
  public final int surfaceIdentityHashCode;
  
  public MediaCodecVideoDecoderException(Throwable paramThrowable, @Nullable r paramr, @Nullable Surface paramSurface)
  {
    super(paramThrowable, paramr);
    this.surfaceIdentityHashCode = System.identityHashCode(paramSurface);
    boolean bool;
    if ((paramSurface != null) && (!paramSurface.isValid())) {
      bool = false;
    } else {
      bool = true;
    }
    this.isSurfaceValid = bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\MediaCodecVideoDecoderException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */