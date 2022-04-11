package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata.Entry;

public abstract class SpliceCommand
  implements Metadata.Entry
{
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    String str = getClass().getSimpleName();
    if (str.length() != 0) {
      str = "SCTE-35 splice command: type=".concat(str);
    } else {
      str = new String("SCTE-35 splice command: type=");
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\scte35\SpliceCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */