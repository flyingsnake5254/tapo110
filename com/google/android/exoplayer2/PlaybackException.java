package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.o0;
import java.lang.reflect.Constructor;

public class PlaybackException
  extends Exception
{
  public static final v0<PlaybackException> CREATOR = p0.a;
  public static final int CUSTOM_ERROR_CODE_BASE = 1000000;
  public static final int ERROR_CODE_AUDIO_TRACK_INIT_FAILED = 5001;
  public static final int ERROR_CODE_AUDIO_TRACK_WRITE_FAILED = 5002;
  public static final int ERROR_CODE_BEHIND_LIVE_WINDOW = 1002;
  public static final int ERROR_CODE_DECODER_INIT_FAILED = 4001;
  public static final int ERROR_CODE_DECODER_QUERY_FAILED = 4002;
  public static final int ERROR_CODE_DECODING_FAILED = 4003;
  public static final int ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES = 4004;
  public static final int ERROR_CODE_DECODING_FORMAT_UNSUPPORTED = 4005;
  public static final int ERROR_CODE_DRM_CONTENT_ERROR = 6003;
  public static final int ERROR_CODE_DRM_DEVICE_REVOKED = 6007;
  public static final int ERROR_CODE_DRM_DISALLOWED_OPERATION = 6005;
  public static final int ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED = 6004;
  public static final int ERROR_CODE_DRM_LICENSE_EXPIRED = 6008;
  public static final int ERROR_CODE_DRM_PROVISIONING_FAILED = 6002;
  public static final int ERROR_CODE_DRM_SCHEME_UNSUPPORTED = 6001;
  public static final int ERROR_CODE_DRM_SYSTEM_ERROR = 6006;
  public static final int ERROR_CODE_DRM_UNSPECIFIED = 6000;
  public static final int ERROR_CODE_FAILED_RUNTIME_CHECK = 1004;
  public static final int ERROR_CODE_IO_BAD_HTTP_STATUS = 2004;
  public static final int ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED = 2007;
  public static final int ERROR_CODE_IO_FILE_NOT_FOUND = 2005;
  public static final int ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE = 2003;
  public static final int ERROR_CODE_IO_NETWORK_CONNECTION_FAILED = 2001;
  public static final int ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT = 2002;
  public static final int ERROR_CODE_IO_NO_PERMISSION = 2006;
  public static final int ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE = 2008;
  public static final int ERROR_CODE_IO_UNSPECIFIED = 2000;
  public static final int ERROR_CODE_PARSING_CONTAINER_MALFORMED = 3001;
  public static final int ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED = 3003;
  public static final int ERROR_CODE_PARSING_MANIFEST_MALFORMED = 3002;
  public static final int ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED = 3004;
  public static final int ERROR_CODE_REMOTE_ERROR = 1001;
  public static final int ERROR_CODE_TIMEOUT = 1003;
  public static final int ERROR_CODE_UNSPECIFIED = 1000;
  protected static final int FIELD_CUSTOM_ID_BASE = 1000;
  private static final int FIELD_INT_ERROR_CODE = 0;
  private static final int FIELD_LONG_TIMESTAMP_MS = 1;
  private static final int FIELD_STRING_CAUSE_CLASS_NAME = 3;
  private static final int FIELD_STRING_CAUSE_MESSAGE = 4;
  private static final int FIELD_STRING_MESSAGE = 2;
  public final int errorCode;
  public final long timestampMs;
  
  protected PlaybackException(Bundle paramBundle)
  {
    this(paramBundle.getString(keyForField(2)), getCauseFromBundle(paramBundle), paramBundle.getInt(keyForField(0), 1000), paramBundle.getLong(keyForField(1), SystemClock.elapsedRealtime()));
  }
  
  public PlaybackException(@Nullable String paramString, @Nullable Throwable paramThrowable, int paramInt)
  {
    this(paramString, paramThrowable, paramInt, h.a.elapsedRealtime());
  }
  
  protected PlaybackException(@Nullable String paramString, @Nullable Throwable paramThrowable, int paramInt, long paramLong)
  {
    super(paramString, paramThrowable);
    this.errorCode = paramInt;
    this.timestampMs = paramLong;
  }
  
  private static RemoteException createRemoteException(@Nullable String paramString)
  {
    return new RemoteException(paramString);
  }
  
  private static Throwable createThrowable(Class<?> paramClass, @Nullable String paramString)
    throws Exception
  {
    return (Throwable)paramClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
  }
  
  @Nullable
  private static Throwable getCauseFromBundle(Bundle paramBundle)
  {
    String str1 = paramBundle.getString(keyForField(3));
    String str2 = paramBundle.getString(keyForField(4));
    boolean bool = TextUtils.isEmpty(str1);
    paramBundle = null;
    Throwable localThrowable = null;
    if (!bool) {}
    try
    {
      paramBundle = Class.forName(str1, true, PlaybackException.class.getClassLoader());
      if (Throwable.class.isAssignableFrom(paramBundle)) {
        localThrowable = createThrowable(paramBundle, str2);
      }
      paramBundle = localThrowable;
      if (localThrowable != null) {
        break label72;
      }
    }
    finally
    {
      label72:
      for (;;) {}
    }
    paramBundle = createRemoteException(str2);
    return paramBundle;
  }
  
  public static String getErrorCodeName(int paramInt)
  {
    if (paramInt != 5001)
    {
      if (paramInt != 5002)
      {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  if (paramInt >= 1000000) {
                    return "custom error code";
                  }
                  return "invalid error code";
                case 6008: 
                  return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                case 6007: 
                  return "ERROR_CODE_DRM_DEVICE_REVOKED";
                case 6006: 
                  return "ERROR_CODE_DRM_SYSTEM_ERROR";
                case 6005: 
                  return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                case 6004: 
                  return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                case 6003: 
                  return "ERROR_CODE_DRM_CONTENT_ERROR";
                case 6002: 
                  return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                case 6001: 
                  return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                }
                return "ERROR_CODE_DRM_UNSPECIFIED";
              case 4005: 
                return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
              case 4004: 
                return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
              case 4003: 
                return "ERROR_CODE_DECODING_FAILED";
              case 4002: 
                return "ERROR_CODE_DECODER_QUERY_FAILED";
              }
              return "ERROR_CODE_DECODER_INIT_FAILED";
            case 3004: 
              return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
            case 3003: 
              return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
            case 3002: 
              return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
            }
            return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
          case 2008: 
            return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
          case 2007: 
            return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
          case 2006: 
            return "ERROR_CODE_IO_NO_PERMISSION";
          case 2005: 
            return "ERROR_CODE_IO_FILE_NOT_FOUND";
          case 2004: 
            return "ERROR_CODE_IO_BAD_HTTP_STATUS";
          case 2003: 
            return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
          case 2002: 
            return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
          case 2001: 
            return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
          }
          return "ERROR_CODE_IO_UNSPECIFIED";
        case 1004: 
          return "ERROR_CODE_FAILED_RUNTIME_CHECK";
        case 1003: 
          return "ERROR_CODE_TIMEOUT";
        case 1002: 
          return "ERROR_CODE_BEHIND_LIVE_WINDOW";
        case 1001: 
          return "ERROR_CODE_REMOTE_ERROR";
        }
        return "ERROR_CODE_UNSPECIFIED";
      }
      return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
    }
    return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
  }
  
  protected static String keyForField(int paramInt)
  {
    return Integer.toString(paramInt, 36);
  }
  
  @CallSuper
  public boolean errorInfoEquals(@Nullable PlaybackException paramPlaybackException)
  {
    boolean bool = true;
    if (this == paramPlaybackException) {
      return true;
    }
    if ((paramPlaybackException != null) && (getClass() == paramPlaybackException.getClass()))
    {
      Throwable localThrowable1 = getCause();
      Throwable localThrowable2 = paramPlaybackException.getCause();
      if ((localThrowable1 != null) && (localThrowable2 != null))
      {
        if (!o0.b(localThrowable1.getMessage(), localThrowable2.getMessage())) {
          return false;
        }
        if (!o0.b(localThrowable1.getClass(), localThrowable2.getClass())) {
          return false;
        }
      }
      else
      {
        if ((localThrowable1 != null) || (localThrowable2 != null)) {
          break label137;
        }
      }
      if ((this.errorCode != paramPlaybackException.errorCode) || (!o0.b(getMessage(), paramPlaybackException.getMessage())) || (this.timestampMs != paramPlaybackException.timestampMs)) {
        bool = false;
      }
      return bool;
    }
    label137:
    return false;
  }
  
  public final String getErrorCodeName()
  {
    return getErrorCodeName(this.errorCode);
  }
  
  @CallSuper
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt(keyForField(0), this.errorCode);
    localBundle.putLong(keyForField(1), this.timestampMs);
    localBundle.putString(keyForField(2), getMessage());
    Throwable localThrowable = getCause();
    if (localThrowable != null)
    {
      localBundle.putString(keyForField(3), localThrowable.getClass().getName());
      localBundle.putString(keyForField(4), localThrowable.getMessage());
    }
    return localBundle;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\PlaybackException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */