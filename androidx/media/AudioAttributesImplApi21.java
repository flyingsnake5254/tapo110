package androidx.media;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(21)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi21
  implements AudioAttributesImpl
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public AudioAttributes mAudioAttributes;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int mLegacyStreamType = -1;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public AudioAttributesImplApi21() {}
  
  AudioAttributesImplApi21(AudioAttributes paramAudioAttributes)
  {
    this(paramAudioAttributes, -1);
  }
  
  AudioAttributesImplApi21(AudioAttributes paramAudioAttributes, int paramInt)
  {
    this.mAudioAttributes = paramAudioAttributes;
    this.mLegacyStreamType = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplApi21)) {
      return false;
    }
    paramObject = (AudioAttributesImplApi21)paramObject;
    return this.mAudioAttributes.equals(((AudioAttributesImplApi21)paramObject).mAudioAttributes);
  }
  
  @Nullable
  public Object getAudioAttributes()
  {
    return this.mAudioAttributes;
  }
  
  public int getContentType()
  {
    return this.mAudioAttributes.getContentType();
  }
  
  public int getFlags()
  {
    return this.mAudioAttributes.getFlags();
  }
  
  public int getLegacyStreamType()
  {
    int i = this.mLegacyStreamType;
    if (i != -1) {
      return i;
    }
    return AudioAttributesCompat.toVolumeStreamType(false, getFlags(), getUsage());
  }
  
  public int getRawLegacyStreamType()
  {
    return this.mLegacyStreamType;
  }
  
  public int getUsage()
  {
    return this.mAudioAttributes.getUsage();
  }
  
  @SuppressLint({"NewApi"})
  public int getVolumeControlStream()
  {
    return AudioAttributesCompat.toVolumeStreamType(true, getFlags(), getUsage());
  }
  
  public int hashCode()
  {
    return this.mAudioAttributes.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioAttributesCompat: audioattributes=");
    localStringBuilder.append(this.mAudioAttributes);
    return localStringBuilder.toString();
  }
  
  static class Builder
    implements AudioAttributesImpl.Builder
  {
    final AudioAttributes.Builder mFwkBuilder;
    
    Builder()
    {
      this.mFwkBuilder = new AudioAttributes.Builder();
    }
    
    Builder(Object paramObject)
    {
      this.mFwkBuilder = new AudioAttributes.Builder((AudioAttributes)paramObject);
    }
    
    @NonNull
    public AudioAttributesImpl build()
    {
      return new AudioAttributesImplApi21(this.mFwkBuilder.build());
    }
    
    @NonNull
    public Builder setContentType(int paramInt)
    {
      this.mFwkBuilder.setContentType(paramInt);
      return this;
    }
    
    @NonNull
    public Builder setFlags(int paramInt)
    {
      this.mFwkBuilder.setFlags(paramInt);
      return this;
    }
    
    @NonNull
    public Builder setLegacyStreamType(int paramInt)
    {
      this.mFwkBuilder.setLegacyStreamType(paramInt);
      return this;
    }
    
    @NonNull
    public Builder setUsage(int paramInt)
    {
      int i = paramInt;
      if (paramInt == 16) {
        i = 12;
      }
      this.mFwkBuilder.setUsage(i);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioAttributesImplApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */