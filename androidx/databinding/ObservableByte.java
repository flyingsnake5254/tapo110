package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class ObservableByte
  extends BaseObservableField
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ObservableByte> CREATOR = new Parcelable.Creator()
  {
    public ObservableByte createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ObservableByte(paramAnonymousParcel.readByte());
    }
    
    public ObservableByte[] newArray(int paramAnonymousInt)
    {
      return new ObservableByte[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 1L;
  private byte mValue;
  
  public ObservableByte() {}
  
  public ObservableByte(byte paramByte)
  {
    this.mValue = ((byte)paramByte);
  }
  
  public ObservableByte(Observable... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte get()
  {
    return this.mValue;
  }
  
  public void set(byte paramByte)
  {
    if (paramByte != this.mValue)
    {
      this.mValue = ((byte)paramByte);
      notifyChange();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte(this.mValue);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\ObservableByte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */