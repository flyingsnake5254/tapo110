package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator()
  {
    public ParcelImpl createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ParcelImpl(paramAnonymousParcel);
    }
    
    public ParcelImpl[] newArray(int paramAnonymousInt)
    {
      return new ParcelImpl[paramAnonymousInt];
    }
  };
  private final VersionedParcelable mParcel;
  
  protected ParcelImpl(Parcel paramParcel)
  {
    this.mParcel = new VersionedParcelParcel(paramParcel).readVersionedParcelable();
  }
  
  public ParcelImpl(VersionedParcelable paramVersionedParcelable)
  {
    this.mParcel = paramVersionedParcelable;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public <T extends VersionedParcelable> T getVersionedParcel()
  {
    return this.mParcel;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new VersionedParcelParcel(paramParcel).writeVersionedParcelable(this.mParcel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\versionedparcelable\ParcelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */