package androidx.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public abstract interface AudioAttributesImpl
  extends VersionedParcelable
{
  @Nullable
  public abstract Object getAudioAttributes();
  
  public abstract int getContentType();
  
  public abstract int getFlags();
  
  public abstract int getLegacyStreamType();
  
  public abstract int getRawLegacyStreamType();
  
  public abstract int getUsage();
  
  public abstract int getVolumeControlStream();
  
  public static abstract interface Builder
  {
    @NonNull
    public abstract AudioAttributesImpl build();
    
    @NonNull
    public abstract Builder setContentType(int paramInt);
    
    @NonNull
    public abstract Builder setFlags(int paramInt);
    
    @NonNull
    public abstract Builder setLegacyStreamType(int paramInt);
    
    @NonNull
    public abstract Builder setUsage(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioAttributesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */