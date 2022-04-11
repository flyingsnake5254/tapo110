package androidx.media;

import android.media.VolumeProvider;
import android.os.Build.VERSION;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat
{
  public static final int VOLUME_CONTROL_ABSOLUTE = 2;
  public static final int VOLUME_CONTROL_FIXED = 0;
  public static final int VOLUME_CONTROL_RELATIVE = 1;
  private Callback mCallback;
  private final String mControlId;
  private final int mControlType;
  private int mCurrentVolume;
  private final int mMaxVolume;
  private VolumeProvider mVolumeProviderFwk;
  
  public VolumeProviderCompat(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, null);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public VolumeProviderCompat(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    this.mControlType = paramInt1;
    this.mMaxVolume = paramInt2;
    this.mCurrentVolume = paramInt3;
    this.mControlId = paramString;
  }
  
  public final int getCurrentVolume()
  {
    return this.mCurrentVolume;
  }
  
  public final int getMaxVolume()
  {
    return this.mMaxVolume;
  }
  
  public final int getVolumeControl()
  {
    return this.mControlType;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final String getVolumeControlId()
  {
    return this.mControlId;
  }
  
  public Object getVolumeProvider()
  {
    if (this.mVolumeProviderFwk == null)
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 30) {
        this.mVolumeProviderFwk = new VolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, this.mControlId)
        {
          public void onAdjustVolume(int paramAnonymousInt)
          {
            VolumeProviderCompat.this.onAdjustVolume(paramAnonymousInt);
          }
          
          public void onSetVolumeTo(int paramAnonymousInt)
          {
            VolumeProviderCompat.this.onSetVolumeTo(paramAnonymousInt);
          }
        };
      } else if (i >= 21) {
        this.mVolumeProviderFwk = new VolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume)
        {
          public void onAdjustVolume(int paramAnonymousInt)
          {
            VolumeProviderCompat.this.onAdjustVolume(paramAnonymousInt);
          }
          
          public void onSetVolumeTo(int paramAnonymousInt)
          {
            VolumeProviderCompat.this.onSetVolumeTo(paramAnonymousInt);
          }
        };
      }
    }
    return this.mVolumeProviderFwk;
  }
  
  public void onAdjustVolume(int paramInt) {}
  
  public void onSetVolumeTo(int paramInt) {}
  
  public void setCallback(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public final void setCurrentVolume(int paramInt)
  {
    this.mCurrentVolume = paramInt;
    if (Build.VERSION.SDK_INT >= 21) {
      ((VolumeProvider)getVolumeProvider()).setCurrentVolume(paramInt);
    }
    Callback localCallback = this.mCallback;
    if (localCallback != null) {
      localCallback.onVolumeChanged(this);
    }
  }
  
  public static abstract class Callback
  {
    public abstract void onVolumeChanged(VolumeProviderCompat paramVolumeProviderCompat);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface ControlType {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\VolumeProviderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */