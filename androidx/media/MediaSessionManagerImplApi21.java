package androidx.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class MediaSessionManagerImplApi21
  extends MediaSessionManagerImplBase
{
  MediaSessionManagerImplApi21(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  private boolean hasMediaControlPermission(@NonNull MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    boolean bool;
    if (getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", paramRemoteUserInfoImpl.getPid(), paramRemoteUserInfoImpl.getUid()) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    boolean bool;
    if ((!hasMediaControlPermission(paramRemoteUserInfoImpl)) && (!super.isTrustedForMediaControl(paramRemoteUserInfoImpl))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\MediaSessionManagerImplApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */