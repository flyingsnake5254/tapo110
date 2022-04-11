package android.support.v4.media;

import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplBaseParcelizer
  extends androidx.media.AudioAttributesImplBaseParcelizer
{
  public static AudioAttributesImplBase read(VersionedParcel paramVersionedParcel)
  {
    return androidx.media.AudioAttributesImplBaseParcelizer.read(paramVersionedParcel);
  }
  
  public static void write(AudioAttributesImplBase paramAudioAttributesImplBase, VersionedParcel paramVersionedParcel)
  {
    androidx.media.AudioAttributesImplBaseParcelizer.write(paramAudioAttributesImplBase, paramVersionedParcel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\android\support\v4\media\AudioAttributesImplBaseParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */