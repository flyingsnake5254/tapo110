package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec.CodecException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.util.o0;

public class MediaCodecDecoderException
  extends DecoderException
{
  @Nullable
  public final r codecInfo;
  @Nullable
  public final String diagnosticInfo;
  
  public MediaCodecDecoderException(Throwable paramThrowable, @Nullable r paramr)
  {
    super(str, paramThrowable);
    this.codecInfo = paramr;
    paramr = (r)localObject;
    if (o0.a >= 21) {
      paramr = getDiagnosticInfoV21(paramThrowable);
    }
    this.diagnosticInfo = paramr;
  }
  
  @Nullable
  @RequiresApi(21)
  private static String getDiagnosticInfoV21(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MediaCodec.CodecException)) {
      return ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\mediacodec\MediaCodecDecoderException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */