package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class ObservableDouble
  extends BaseObservableField
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ObservableDouble> CREATOR = new Parcelable.Creator()
  {
    public ObservableDouble createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ObservableDouble(paramAnonymousParcel.readDouble());
    }
    
    public ObservableDouble[] newArray(int paramAnonymousInt)
    {
      return new ObservableDouble[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 1L;
  private double mValue;
  
  public ObservableDouble() {}
  
  public ObservableDouble(double paramDouble)
  {
    this.mValue = paramDouble;
  }
  
  public ObservableDouble(Observable... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double get()
  {
    return this.mValue;
  }
  
  public void set(double paramDouble)
  {
    if (paramDouble != this.mValue)
    {
      this.mValue = paramDouble;
      notifyChange();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.mValue);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\ObservableDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */