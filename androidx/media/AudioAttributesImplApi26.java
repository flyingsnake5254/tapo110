package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(26)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi26
  extends AudioAttributesImplApi21
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public AudioAttributesImplApi26() {}
  
  AudioAttributesImplApi26(AudioAttributes paramAudioAttributes)
  {
    super(paramAudioAttributes, -1);
  }
  
  public int getVolumeControlStream()
  {
    return this.mAudioAttributes.getVolumeControlStream();
  }
  
  static class Builder
    extends AudioAttributesImplApi21.Builder
  {
    Builder() {}
    
    Builder(Object paramObject)
    {
      super();
    }
    
    @NonNull
    public AudioAttributesImpl build()
    {
      return new AudioAttributesImplApi26(this.mFwkBuilder.build());
    }
    
    @NonNull
    public Builder setUsage(int paramInt)
    {
      this.mFwkBuilder.setUsage(paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioAttributesImplApi26.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */