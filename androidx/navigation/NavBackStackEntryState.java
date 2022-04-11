package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;

@SuppressLint({"BanParcelableUsage"})
final class NavBackStackEntryState
  implements Parcelable
{
  public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new Parcelable.Creator()
  {
    public NavBackStackEntryState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new NavBackStackEntryState(paramAnonymousParcel);
    }
    
    public NavBackStackEntryState[] newArray(int paramAnonymousInt)
    {
      return new NavBackStackEntryState[paramAnonymousInt];
    }
  };
  private final Bundle mArgs;
  private final int mDestinationId;
  private final Bundle mSavedState;
  private final UUID mUUID;
  
  NavBackStackEntryState(Parcel paramParcel)
  {
    this.mUUID = UUID.fromString(paramParcel.readString());
    this.mDestinationId = paramParcel.readInt();
    this.mArgs = paramParcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    this.mSavedState = paramParcel.readBundle(NavBackStackEntryState.class.getClassLoader());
  }
  
  NavBackStackEntryState(NavBackStackEntry paramNavBackStackEntry)
  {
    this.mUUID = paramNavBackStackEntry.mId;
    this.mDestinationId = paramNavBackStackEntry.getDestination().getId();
    this.mArgs = paramNavBackStackEntry.getArguments();
    Bundle localBundle = new Bundle();
    this.mSavedState = localBundle;
    paramNavBackStackEntry.saveState(localBundle);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Nullable
  Bundle getArgs()
  {
    return this.mArgs;
  }
  
  int getDestinationId()
  {
    return this.mDestinationId;
  }
  
  @NonNull
  Bundle getSavedState()
  {
    return this.mSavedState;
  }
  
  @NonNull
  UUID getUUID()
  {
    return this.mUUID;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mUUID.toString());
    paramParcel.writeInt(this.mDestinationId);
    paramParcel.writeBundle(this.mArgs);
    paramParcel.writeBundle(this.mSavedState);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavBackStackEntryState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */