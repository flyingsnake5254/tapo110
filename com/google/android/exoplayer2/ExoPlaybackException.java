package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

public final class ExoPlaybackException
  extends PlaybackException
{
  public static final v0<ExoPlaybackException> CREATOR = c.a;
  private static final int FIELD_IS_RECOVERABLE = 1006;
  private static final int FIELD_RENDERER_FORMAT = 1004;
  private static final int FIELD_RENDERER_FORMAT_SUPPORT = 1005;
  private static final int FIELD_RENDERER_INDEX = 1003;
  private static final int FIELD_RENDERER_NAME = 1002;
  private static final int FIELD_TYPE = 1001;
  public static final int TYPE_REMOTE = 3;
  public static final int TYPE_RENDERER = 1;
  public static final int TYPE_SOURCE = 0;
  public static final int TYPE_UNEXPECTED = 2;
  final boolean isRecoverable;
  @Nullable
  public final c0 mediaPeriodId;
  @Nullable
  public final Format rendererFormat;
  public final int rendererFormatSupport;
  public final int rendererIndex;
  @Nullable
  public final String rendererName;
  public final int type;
  
  private ExoPlaybackException(int paramInt1, Throwable paramThrowable, int paramInt2)
  {
    this(paramInt1, paramThrowable, null, paramInt2, null, -1, null, 4, false);
  }
  
  private ExoPlaybackException(int paramInt1, @Nullable Throwable paramThrowable, @Nullable String paramString1, int paramInt2, @Nullable String paramString2, int paramInt3, @Nullable Format paramFormat, int paramInt4, boolean paramBoolean)
  {
    this(deriveMessage(paramInt1, paramString1, paramString2, paramInt3, paramFormat, paramInt4), paramThrowable, paramInt2, paramInt1, paramString2, paramInt3, paramFormat, paramInt4, null, SystemClock.elapsedRealtime(), paramBoolean);
  }
  
  private ExoPlaybackException(Bundle paramBundle)
  {
    super(paramBundle);
    this.type = paramBundle.getInt(PlaybackException.keyForField(1001), 2);
    this.rendererName = paramBundle.getString(PlaybackException.keyForField(1002));
    this.rendererIndex = paramBundle.getInt(PlaybackException.keyForField(1003), -1);
    this.rendererFormat = ((Format)paramBundle.getParcelable(PlaybackException.keyForField(1004)));
    this.rendererFormatSupport = paramBundle.getInt(PlaybackException.keyForField(1005), 4);
    this.isRecoverable = paramBundle.getBoolean(PlaybackException.keyForField(1006), false);
    this.mediaPeriodId = null;
  }
  
  private ExoPlaybackException(String paramString1, @Nullable Throwable paramThrowable, int paramInt1, int paramInt2, @Nullable String paramString2, int paramInt3, @Nullable Format paramFormat, int paramInt4, @Nullable c0 paramc0, long paramLong, boolean paramBoolean)
  {
    super(paramString1, paramThrowable, paramInt1, paramLong);
    boolean bool1 = false;
    boolean bool2;
    if ((paramBoolean) && (paramInt2 != 1)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    g.a(bool2);
    if (paramThrowable == null)
    {
      bool2 = bool1;
      if (paramInt2 != 3) {}
    }
    else
    {
      bool2 = true;
    }
    g.a(bool2);
    this.type = paramInt2;
    this.rendererName = paramString2;
    this.rendererIndex = paramInt3;
    this.rendererFormat = paramFormat;
    this.rendererFormatSupport = paramInt4;
    this.mediaPeriodId = paramc0;
    this.isRecoverable = paramBoolean;
  }
  
  public static ExoPlaybackException createForRemote(String paramString)
  {
    return new ExoPlaybackException(3, null, paramString, 1001, null, -1, null, 4, false);
  }
  
  public static ExoPlaybackException createForRenderer(Throwable paramThrowable, String paramString, int paramInt1, @Nullable Format paramFormat, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramFormat == null) {
      paramInt2 = 4;
    }
    return new ExoPlaybackException(1, paramThrowable, null, paramInt3, paramString, paramInt1, paramFormat, paramInt2, paramBoolean);
  }
  
  public static ExoPlaybackException createForSource(IOException paramIOException, int paramInt)
  {
    return new ExoPlaybackException(0, paramIOException, paramInt);
  }
  
  @Deprecated
  public static ExoPlaybackException createForUnexpected(RuntimeException paramRuntimeException)
  {
    return createForUnexpected(paramRuntimeException, 1000);
  }
  
  public static ExoPlaybackException createForUnexpected(RuntimeException paramRuntimeException, int paramInt)
  {
    return new ExoPlaybackException(2, paramRuntimeException, paramInt);
  }
  
  private static String deriveMessage(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, int paramInt2, @Nullable Format paramFormat, int paramInt3)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 3) {
          paramString2 = "Unexpected runtime error";
        } else {
          paramString2 = "Remote error";
        }
      }
      else
      {
        paramFormat = String.valueOf(paramFormat);
        String str = w0.c(paramInt3);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 53 + paramFormat.length() + String.valueOf(str).length());
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" error, index=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", format=");
        localStringBuilder.append(paramFormat);
        localStringBuilder.append(", format_supported=");
        localStringBuilder.append(str);
        paramString2 = localStringBuilder.toString();
      }
    }
    else {
      paramString2 = "Source error";
    }
    paramFormat = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramFormat = String.valueOf(paramString2);
      paramString2 = new StringBuilder(paramFormat.length() + 2 + String.valueOf(paramString1).length());
      paramString2.append(paramFormat);
      paramString2.append(": ");
      paramString2.append(paramString1);
      paramFormat = paramString2.toString();
    }
    return paramFormat;
  }
  
  @CheckResult
  ExoPlaybackException copyWithMediaPeriodId(@Nullable c0 paramc0)
  {
    return new ExoPlaybackException((String)o0.i(getMessage()), getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, paramc0, this.timestampMs, this.isRecoverable);
  }
  
  public boolean errorInfoEquals(@Nullable PlaybackException paramPlaybackException)
  {
    boolean bool1 = super.errorInfoEquals(paramPlaybackException);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramPlaybackException = (ExoPlaybackException)o0.i(paramPlaybackException);
    bool1 = bool2;
    if (this.type == paramPlaybackException.type)
    {
      bool1 = bool2;
      if (o0.b(this.rendererName, paramPlaybackException.rendererName))
      {
        bool1 = bool2;
        if (this.rendererIndex == paramPlaybackException.rendererIndex)
        {
          bool1 = bool2;
          if (o0.b(this.rendererFormat, paramPlaybackException.rendererFormat))
          {
            bool1 = bool2;
            if (this.rendererFormatSupport == paramPlaybackException.rendererFormatSupport)
            {
              bool1 = bool2;
              if (o0.b(this.mediaPeriodId, paramPlaybackException.mediaPeriodId))
              {
                bool1 = bool2;
                if (this.isRecoverable == paramPlaybackException.isRecoverable) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public Exception getRendererException()
  {
    int i = this.type;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    g.g(bool);
    return (Exception)g.e(getCause());
  }
  
  public IOException getSourceException()
  {
    boolean bool;
    if (this.type == 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    return (IOException)g.e(getCause());
  }
  
  public RuntimeException getUnexpectedException()
  {
    boolean bool;
    if (this.type == 2) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    return (RuntimeException)g.e(getCause());
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = super.toBundle();
    localBundle.putInt(PlaybackException.keyForField(1001), this.type);
    localBundle.putString(PlaybackException.keyForField(1002), this.rendererName);
    localBundle.putInt(PlaybackException.keyForField(1003), this.rendererIndex);
    localBundle.putParcelable(PlaybackException.keyForField(1004), this.rendererFormat);
    localBundle.putInt(PlaybackException.keyForField(1005), this.rendererFormatSupport);
    localBundle.putBoolean(PlaybackException.keyForField(1006), this.isRecoverable);
    return localBundle;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ExoPlaybackException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */