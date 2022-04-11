package android.support.v4.app;

import androidx.annotation.RestrictTo;
import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public final class RemoteActionCompatParcelizer
  extends androidx.core.app.RemoteActionCompatParcelizer
{
  public static RemoteActionCompat read(VersionedParcel paramVersionedParcel)
  {
    return androidx.core.app.RemoteActionCompatParcelizer.read(paramVersionedParcel);
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, VersionedParcel paramVersionedParcel)
  {
    androidx.core.app.RemoteActionCompatParcelizer.write(paramRemoteActionCompat, paramVersionedParcel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\android\support\v4\app\RemoteActionCompatParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */