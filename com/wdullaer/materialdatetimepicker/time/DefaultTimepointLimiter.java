package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.TreeSet;

class DefaultTimepointLimiter
  implements TimepointLimiter
{
  public static final Parcelable.Creator<DefaultTimepointLimiter> CREATOR = new a();
  private TreeSet<Timepoint> c = new TreeSet();
  private TreeSet<Timepoint> d = new TreeSet();
  private TreeSet<Timepoint> f = new TreeSet();
  private Timepoint q;
  private Timepoint x;
  
  DefaultTimepointLimiter() {}
  
  public DefaultTimepointLimiter(Parcel paramParcel)
  {
    this.q = ((Timepoint)paramParcel.readParcelable(Timepoint.class.getClassLoader()));
    this.x = ((Timepoint)paramParcel.readParcelable(Timepoint.class.getClassLoader()));
    TreeSet localTreeSet = this.c;
    Parcelable.Creator localCreator = Timepoint.CREATOR;
    localTreeSet.addAll(Arrays.asList(paramParcel.createTypedArray(localCreator)));
    this.d.addAll(Arrays.asList(paramParcel.createTypedArray(localCreator)));
    this.f = a(this.c, this.d);
  }
  
  private TreeSet<Timepoint> a(TreeSet<Timepoint> paramTreeSet1, TreeSet<Timepoint> paramTreeSet2)
  {
    paramTreeSet1 = new TreeSet(paramTreeSet1);
    paramTreeSet1.removeAll(paramTreeSet2);
    return paramTreeSet1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.q, paramInt);
    paramParcel.writeParcelable(this.x, paramInt);
    TreeSet localTreeSet = this.c;
    paramParcel.writeTypedArray((Parcelable[])localTreeSet.toArray(new Timepoint[localTreeSet.size()]), paramInt);
    localTreeSet = this.d;
    paramParcel.writeTypedArray((Parcelable[])localTreeSet.toArray(new Timepoint[localTreeSet.size()]), paramInt);
  }
  
  static final class a
    implements Parcelable.Creator<DefaultTimepointLimiter>
  {
    public DefaultTimepointLimiter a(Parcel paramParcel)
    {
      return new DefaultTimepointLimiter(paramParcel);
    }
    
    public DefaultTimepointLimiter[] b(int paramInt)
    {
      return new DefaultTimepointLimiter[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\time\DefaultTimepointLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */