package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class ObservableChar
  extends BaseObservableField
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ObservableChar> CREATOR = new Parcelable.Creator()
  {
    public ObservableChar createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ObservableChar((char)paramAnonymousParcel.readInt());
    }
    
    public ObservableChar[] newArray(int paramAnonymousInt)
    {
      return new ObservableChar[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 1L;
  private char mValue;
  
  public ObservableChar() {}
  
  public ObservableChar(char paramChar)
  {
    this.mValue = ((char)paramChar);
  }
  
  public ObservableChar(Observable... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public char get()
  {
    return this.mValue;
  }
  
  public void set(char paramChar)
  {
    if (paramChar != this.mValue)
    {
      this.mValue = ((char)paramChar);
      notifyChange();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mValue);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\ObservableChar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */