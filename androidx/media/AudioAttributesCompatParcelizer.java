package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class AudioAttributesCompatParcelizer
{
  public static AudioAttributesCompat read(VersionedParcel paramVersionedParcel)
  {
    AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
    localAudioAttributesCompat.mImpl = ((AudioAttributesImpl)paramVersionedParcel.readVersionedParcelable(localAudioAttributesCompat.mImpl, 1));
    return localAudioAttributesCompat;
  }
  
  public static void write(AudioAttributesCompat paramAudioAttributesCompat, VersionedParcel paramVersionedParcel)
  {
    paramVersionedParcel.setSerializationFlags(false, false);
    paramVersionedParcel.writeVersionedParcelable(paramAudioAttributesCompat.mImpl, 1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioAttributesCompatParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */