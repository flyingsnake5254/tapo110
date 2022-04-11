package androidx.media;

import android.media.AudioManager;
import android.os.Build.VERSION;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

public final class AudioManagerCompat
{
  public static final int AUDIOFOCUS_GAIN = 1;
  public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
  public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
  public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
  private static final String TAG = "AudioManCompat";
  
  public static int abandonAudioFocusRequest(@NonNull AudioManager paramAudioManager, @NonNull AudioFocusRequestCompat paramAudioFocusRequestCompat)
  {
    if (paramAudioManager != null)
    {
      if (paramAudioFocusRequestCompat != null)
      {
        if (Build.VERSION.SDK_INT >= 26) {
          return paramAudioManager.abandonAudioFocusRequest(paramAudioFocusRequestCompat.getAudioFocusRequest());
        }
        return paramAudioManager.abandonAudioFocus(paramAudioFocusRequestCompat.getOnAudioFocusChangeListener());
      }
      throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
    }
    throw new IllegalArgumentException("AudioManager must not be null");
  }
  
  @IntRange(from=0L)
  public static int getStreamMaxVolume(@NonNull AudioManager paramAudioManager, int paramInt)
  {
    return paramAudioManager.getStreamMaxVolume(paramInt);
  }
  
  @IntRange(from=0L)
  public static int getStreamMinVolume(@NonNull AudioManager paramAudioManager, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramAudioManager.getStreamMinVolume(paramInt);
    }
    return 0;
  }
  
  public static int requestAudioFocus(@NonNull AudioManager paramAudioManager, @NonNull AudioFocusRequestCompat paramAudioFocusRequestCompat)
  {
    if (paramAudioManager != null)
    {
      if (paramAudioFocusRequestCompat != null)
      {
        if (Build.VERSION.SDK_INT >= 26) {
          return paramAudioManager.requestAudioFocus(paramAudioFocusRequestCompat.getAudioFocusRequest());
        }
        return paramAudioManager.requestAudioFocus(paramAudioFocusRequestCompat.getOnAudioFocusChangeListener(), paramAudioFocusRequestCompat.getAudioAttributesCompat().getLegacyStreamType(), paramAudioFocusRequestCompat.getFocusGain());
      }
      throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
    }
    throw new IllegalArgumentException("AudioManager must not be null");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */