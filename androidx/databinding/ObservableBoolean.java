package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class ObservableBoolean
  extends BaseObservableField
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ObservableBoolean> CREATOR = new Parcelable.Creator()
  {
    public ObservableBoolean createFromParcel(Parcel paramAnonymousParcel)
    {
      int i = paramAnonymousParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return new ObservableBoolean(bool);
    }
    
    public ObservableBoolean[] newArray(int paramAnonymousInt)
    {
      return new ObservableBoolean[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 1L;
  private boolean mValue;
  
  public ObservableBoolean() {}
  
  public ObservableBoolean(boolean paramBoolean)
  {
    this.mValue = paramBoolean;
  }
  
  public ObservableBoolean(Observable... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean get()
  {
    return this.mValue;
  }
  
  public void set(boolean paramBoolean)
  {
    if (paramBoolean != this.mValue)
    {
      this.mValue = paramBoolean;
      notifyChange();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mValue);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\ObservableBoolean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */