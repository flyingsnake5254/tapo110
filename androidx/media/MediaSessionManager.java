package androidx.media;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Objects;

public final class MediaSessionManager
{
  static final boolean DEBUG = Log.isLoggable("MediaSessionManager", 3);
  static final String TAG = "MediaSessionManager";
  private static final Object sLock = new Object();
  private static volatile MediaSessionManager sSessionManager;
  MediaSessionManagerImpl mImpl;
  
  private MediaSessionManager(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      this.mImpl = new MediaSessionManagerImplApi28(paramContext);
    } else if (i >= 21) {
      this.mImpl = new MediaSessionManagerImplApi21(paramContext);
    } else {
      this.mImpl = new MediaSessionManagerImplBase(paramContext);
    }
  }
  
  @NonNull
  public static MediaSessionManager getSessionManager(@NonNull Context paramContext)
  {
    if (paramContext != null) {
      synchronized (sLock)
      {
        if (sSessionManager == null)
        {
          MediaSessionManager localMediaSessionManager = new androidx/media/MediaSessionManager;
          localMediaSessionManager.<init>(paramContext.getApplicationContext());
          sSessionManager = localMediaSessionManager;
        }
        paramContext = sSessionManager;
        return paramContext;
      }
    }
    throw new IllegalArgumentException("context cannot be null");
  }
  
  Context getContext()
  {
    return this.mImpl.getContext();
  }
  
  public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo paramRemoteUserInfo)
  {
    if (paramRemoteUserInfo != null) {
      return this.mImpl.isTrustedForMediaControl(paramRemoteUserInfo.mImpl);
    }
    throw new IllegalArgumentException("userInfo should not be null");
  }
  
  static abstract interface MediaSessionManagerImpl
  {
    public abstract Context getContext();
    
    public abstract boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl);
  }
  
  public static final class RemoteUserInfo
  {
    public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int UNKNOWN_PID = -1;
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int UNKNOWN_UID = -1;
    MediaSessionManager.RemoteUserInfoImpl mImpl;
    
    @RequiresApi(28)
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo paramRemoteUserInfo)
    {
      String str = MediaSessionManagerImplApi28.RemoteUserInfoImplApi28.getPackageName(paramRemoteUserInfo);
      Objects.requireNonNull(str, "package shouldn't be null");
      if (!TextUtils.isEmpty(str))
      {
        this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(paramRemoteUserInfo);
        return;
      }
      throw new IllegalArgumentException("packageName should be nonempty");
    }
    
    public RemoteUserInfo(@NonNull String paramString, int paramInt1, int paramInt2)
    {
      Objects.requireNonNull(paramString, "package shouldn't be null");
      if (!TextUtils.isEmpty(paramString))
      {
        if (Build.VERSION.SDK_INT >= 28) {
          this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(paramString, paramInt1, paramInt2);
        } else {
          this.mImpl = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(paramString, paramInt1, paramInt2);
        }
        return;
      }
      throw new IllegalArgumentException("packageName should be nonempty");
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof RemoteUserInfo)) {
        return false;
      }
      return this.mImpl.equals(((RemoteUserInfo)paramObject).mImpl);
    }
    
    @NonNull
    public String getPackageName()
    {
      return this.mImpl.getPackageName();
    }
    
    public int getPid()
    {
      return this.mImpl.getPid();
    }
    
    public int getUid()
    {
      return this.mImpl.getUid();
    }
    
    public int hashCode()
    {
      return this.mImpl.hashCode();
    }
  }
  
  static abstract interface RemoteUserInfoImpl
  {
    public abstract String getPackageName();
    
    public abstract int getPid();
    
    public abstract int getUid();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\MediaSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */