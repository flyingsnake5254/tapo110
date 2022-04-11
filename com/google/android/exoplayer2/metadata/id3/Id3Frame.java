package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata.Entry;

public abstract class Id3Frame
  implements Metadata.Entry
{
  public final String c;
  
  public Id3Frame(String paramString)
  {
    this.c = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\Id3Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */