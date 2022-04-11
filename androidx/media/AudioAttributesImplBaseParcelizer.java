package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplBaseParcelizer
{
  public static AudioAttributesImplBase read(VersionedParcel paramVersionedParcel)
  {
    AudioAttributesImplBase localAudioAttributesImplBase = new AudioAttributesImplBase();
    localAudioAttributesImplBase.mUsage = paramVersionedParcel.readInt(localAudioAttributesImplBase.mUsage, 1);
    localAudioAttributesImplBase.mContentType = paramVersionedParcel.readInt(localAudioAttributesImplBase.mContentType, 2);
    localAudioAttributesImplBase.mFlags = paramVersionedParcel.readInt(localAudioAttributesImplBase.mFlags, 3);
    localAudioAttributesImplBase.mLegacyStream = paramVersionedParcel.readInt(localAudioAttributesImplBase.mLegacyStream, 4);
    return localAudioAttributesImplBase;
  }
  
  public static void write(AudioAttributesImplBase paramAudioAttributesImplBase, VersionedParcel paramVersionedParcel)
  {
    paramVersionedParcel.setSerializationFlags(false, false);
    paramVersionedParcel.writeInt(paramAudioAttributesImplBase.mUsage, 1);
    paramVersionedParcel.writeInt(paramAudioAttributesImplBase.mContentType, 2);
    paramVersionedParcel.writeInt(paramAudioAttributesImplBase.mFlags, 3);
    paramVersionedParcel.writeInt(paramAudioAttributesImplBase.mLegacyStream, 4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioAttributesImplBaseParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */