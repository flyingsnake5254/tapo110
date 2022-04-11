package androidx.versionedparcelable;

import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class CustomVersionedParcelable
  implements VersionedParcelable
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void onPostParceling() {}
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void onPreParceling(boolean paramBoolean) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\versionedparcelable\CustomVersionedParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */