package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.media.session.MediaSessionManager.RemoteUserInfo;
import androidx.annotation.RequiresApi;

@RequiresApi(28)
class MediaSessionManagerImplApi28
  extends MediaSessionManagerImplApi21
{
  MediaSessionManager mObject;
  
  MediaSessionManagerImplApi28(Context paramContext)
  {
    super(paramContext);
    this.mObject = ((MediaSessionManager)paramContext.getSystemService("media_session"));
  }
  
  public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    return super.isTrustedForMediaControl(paramRemoteUserInfoImpl);
  }
  
  @RequiresApi(28)
  static final class RemoteUserInfoImplApi28
    extends MediaSessionManagerImplBase.RemoteUserInfoImplBase
  {
    final MediaSessionManager.RemoteUserInfo mObject;
    
    RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo)
    {
      super(paramRemoteUserInfo.getPid(), paramRemoteUserInfo.getUid());
      this.mObject = paramRemoteUserInfo;
    }
    
    RemoteUserInfoImplApi28(String paramString, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
      this.mObject = new MediaSessionManager.RemoteUserInfo(paramString, paramInt1, paramInt2);
    }
    
    static String getPackageName(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo)
    {
      return paramRemoteUserInfo.getPackageName();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\MediaSessionManagerImplApi28.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */