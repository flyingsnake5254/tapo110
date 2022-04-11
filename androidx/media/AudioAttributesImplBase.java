package androidx.media;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplBase
  implements AudioAttributesImpl
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int mContentType = 0;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int mFlags = 0;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int mLegacyStream = -1;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int mUsage = 0;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public AudioAttributesImplBase() {}
  
  AudioAttributesImplBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mContentType = paramInt1;
    this.mFlags = paramInt2;
    this.mUsage = paramInt3;
    this.mLegacyStream = paramInt4;
  }
  
  static int usageForStreamType(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return 0;
    case 10: 
      return 11;
    case 8: 
      return 3;
    case 6: 
      return 2;
    case 5: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      return 1;
    case 2: 
      return 6;
    case 1: 
    case 7: 
      return 13;
    }
    return 2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof AudioAttributesImplBase;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (AudioAttributesImplBase)paramObject;
    bool1 = bool2;
    if (this.mContentType == ((AudioAttributesImplBase)paramObject).getContentType())
    {
      bool1 = bool2;
      if (this.mFlags == ((AudioAttributesImplBase)paramObject).getFlags())
      {
        bool1 = bool2;
        if (this.mUsage == ((AudioAttributesImplBase)paramObject).getUsage())
        {
          bool1 = bool2;
          if (this.mLegacyStream == ((AudioAttributesImplBase)paramObject).mLegacyStream) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public Object getAudioAttributes()
  {
    return null;
  }
  
  public int getContentType()
  {
    return this.mContentType;
  }
  
  public int getFlags()
  {
    int i = this.mFlags;
    int j = getLegacyStreamType();
    int k;
    if (j == 6)
    {
      k = i | 0x4;
    }
    else
    {
      k = i;
      if (j == 7) {
        k = i | 0x1;
      }
    }
    return k & 0x111;
  }
  
  public int getLegacyStreamType()
  {
    int i = this.mLegacyStream;
    if (i != -1) {
      return i;
    }
    return AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage);
  }
  
  public int getRawLegacyStreamType()
  {
    return this.mLegacyStream;
  }
  
  public int getUsage()
  {
    return this.mUsage;
  }
  
  public int getVolumeControlStream()
  {
    return AudioAttributesCompat.toVolumeStreamType(true, this.mFlags, this.mUsage);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream) });
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (this.mLegacyStream != -1)
    {
      localStringBuilder.append(" stream=");
      localStringBuilder.append(this.mLegacyStream);
      localStringBuilder.append(" derived");
    }
    localStringBuilder.append(" usage=");
    localStringBuilder.append(AudioAttributesCompat.usageToString(this.mUsage));
    localStringBuilder.append(" content=");
    localStringBuilder.append(this.mContentType);
    localStringBuilder.append(" flags=0x");
    localStringBuilder.append(Integer.toHexString(this.mFlags).toUpperCase());
    return localStringBuilder.toString();
  }
  
  static class Builder
    implements AudioAttributesImpl.Builder
  {
    private int mContentType = 0;
    private int mFlags = 0;
    private int mLegacyStream = -1;
    private int mUsage = 0;
    
    Builder() {}
    
    Builder(AudioAttributesCompat paramAudioAttributesCompat)
    {
      this.mUsage = paramAudioAttributesCompat.getUsage();
      this.mContentType = paramAudioAttributesCompat.getContentType();
      this.mFlags = paramAudioAttributesCompat.getFlags();
      this.mLegacyStream = paramAudioAttributesCompat.getRawLegacyStreamType();
    }
    
    private Builder setInternalLegacyStreamType(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid stream type ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" for AudioAttributesCompat");
        Log.e("AudioAttributesCompat", localStringBuilder.toString());
        break;
      case 10: 
        this.mContentType = 1;
        break;
      case 9: 
        this.mContentType = 4;
        break;
      case 8: 
        this.mContentType = 4;
        break;
      case 7: 
        this.mFlags = (0x1 | this.mFlags);
        break;
      case 6: 
        this.mContentType = 1;
        this.mFlags |= 0x4;
        break;
      case 5: 
        this.mContentType = 4;
        break;
      case 4: 
        this.mContentType = 4;
        break;
      case 3: 
        this.mContentType = 2;
        break;
      case 2: 
        this.mContentType = 4;
        break;
      case 1: 
        this.mContentType = 4;
        break;
      }
      this.mContentType = 1;
      this.mUsage = AudioAttributesImplBase.usageForStreamType(paramInt);
      return this;
    }
    
    @NonNull
    public AudioAttributesImpl build()
    {
      return new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
    }
    
    @NonNull
    public Builder setContentType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
        this.mContentType = 0;
      } else {
        this.mContentType = paramInt;
      }
      return this;
    }
    
    @NonNull
    public Builder setFlags(int paramInt)
    {
      this.mFlags = (paramInt & 0x3FF | this.mFlags);
      return this;
    }
    
    @NonNull
    public Builder setLegacyStreamType(int paramInt)
    {
      if (paramInt != 10)
      {
        this.mLegacyStream = paramInt;
        return setInternalLegacyStreamType(paramInt);
      }
      throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
    }
    
    @NonNull
    public Builder setUsage(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        this.mUsage = 0;
        break;
      case 16: 
        this.mUsage = 12;
        break;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
        this.mUsage = paramInt;
      }
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioAttributesImplBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */