package android.support.v4.media;

import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImplApi21;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer
  extends androidx.media.AudioAttributesImplApi21Parcelizer
{
  public static AudioAttributesImplApi21 read(VersionedParcel paramVersionedParcel)
  {
    return androidx.media.AudioAttributesImplApi21Parcelizer.read(paramVersionedParcel);
  }
  
  public static void write(AudioAttributesImplApi21 paramAudioAttributesImplApi21, VersionedParcel paramVersionedParcel)
  {
    androidx.media.AudioAttributesImplApi21Parcelizer.write(paramAudioAttributesImplApi21, paramVersionedParcel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\android\support\v4\media\AudioAttributesImplApi21Parcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */