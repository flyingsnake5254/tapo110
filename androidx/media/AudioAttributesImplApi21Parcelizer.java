package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi21Parcelizer
{
  public static AudioAttributesImplApi21 read(VersionedParcel paramVersionedParcel)
  {
    AudioAttributesImplApi21 localAudioAttributesImplApi21 = new AudioAttributesImplApi21();
    localAudioAttributesImplApi21.mAudioAttributes = ((AudioAttributes)paramVersionedParcel.readParcelable(localAudioAttributesImplApi21.mAudioAttributes, 1));
    localAudioAttributesImplApi21.mLegacyStreamType = paramVersionedParcel.readInt(localAudioAttributesImplApi21.mLegacyStreamType, 2);
    return localAudioAttributesImplApi21;
  }
  
  public static void write(AudioAttributesImplApi21 paramAudioAttributesImplApi21, VersionedParcel paramVersionedParcel)
  {
    paramVersionedParcel.setSerializationFlags(false, false);
    paramVersionedParcel.writeParcelable(paramAudioAttributesImplApi21.mAudioAttributes, 1);
    paramVersionedParcel.writeInt(paramAudioAttributesImplApi21.mLegacyStreamType, 2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioAttributesImplApi21Parcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */