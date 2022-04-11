package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi26Parcelizer
{
  public static AudioAttributesImplApi26 read(VersionedParcel paramVersionedParcel)
  {
    AudioAttributesImplApi26 localAudioAttributesImplApi26 = new AudioAttributesImplApi26();
    localAudioAttributesImplApi26.mAudioAttributes = ((AudioAttributes)paramVersionedParcel.readParcelable(localAudioAttributesImplApi26.mAudioAttributes, 1));
    localAudioAttributesImplApi26.mLegacyStreamType = paramVersionedParcel.readInt(localAudioAttributesImplApi26.mLegacyStreamType, 2);
    return localAudioAttributesImplApi26;
  }
  
  public static void write(AudioAttributesImplApi26 paramAudioAttributesImplApi26, VersionedParcel paramVersionedParcel)
  {
    paramVersionedParcel.setSerializationFlags(false, false);
    paramVersionedParcel.writeParcelable(paramAudioAttributesImplApi26.mAudioAttributes, 1);
    paramVersionedParcel.writeInt(paramAudioAttributesImplApi26.mLegacyStreamType, 2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioAttributesImplApi26Parcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */