package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1.b;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.List;

public final class TextInformationFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a();
  @Nullable
  public final String d;
  public final String f;
  
  TextInformationFrame(Parcel paramParcel)
  {
    super((String)o0.i(paramParcel.readString()));
    this.d = paramParcel.readString();
    this.f = ((String)o0.i(paramParcel.readString()));
  }
  
  public TextInformationFrame(String paramString1, @Nullable String paramString2, String paramString3)
  {
    super(paramString1);
    this.d = paramString2;
    this.f = paramString3;
  }
  
  private static List<Integer> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (paramString.length() >= 10)
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString.substring(0, 4))));
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString.substring(5, 7))));
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString.substring(8, 10))));
      }
      else if (paramString.length() >= 7)
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString.substring(0, 4))));
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString.substring(5, 7))));
      }
      else if (paramString.length() >= 4)
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString.substring(0, 4))));
      }
      return localArrayList;
    }
    catch (NumberFormatException paramString) {}
    return new ArrayList();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (TextInformationFrame.class == paramObject.getClass()))
    {
      paramObject = (TextInformationFrame)paramObject;
      if ((!o0.b(this.c, ((Id3Frame)paramObject).c)) || (!o0.b(this.d, ((TextInformationFrame)paramObject).d)) || (!o0.b(this.f, ((TextInformationFrame)paramObject).f))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.c.hashCode();
    String str = this.d;
    int j = 0;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.f;
    if (str != null) {
      j = str.hashCode();
    }
    return ((527 + i) * 31 + k) * 31 + j;
  }
  
  public void j(m1.b paramb)
  {
    Object localObject = this.c;
    ((String)localObject).hashCode();
    int i = ((String)localObject).hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 2590194: 
      if (((String)localObject).equals("TYER")) {
        j = 21;
      }
      break;
    case 2583398: 
      if (((String)localObject).equals("TRCK")) {
        j = 20;
      }
      break;
    case 2581514: 
      if (((String)localObject).equals("TPE3")) {
        j = 19;
      }
      break;
    case 2581513: 
      if (((String)localObject).equals("TPE2")) {
        j = 18;
      }
      break;
    case 2581512: 
      if (((String)localObject).equals("TPE1")) {
        j = 17;
      }
      break;
    case 2575251: 
      if (((String)localObject).equals("TIT2")) {
        j = 16;
      }
      break;
    case 2571565: 
      if (((String)localObject).equals("TEXT")) {
        j = 15;
      }
      break;
    case 2570410: 
      if (((String)localObject).equals("TDRL")) {
        j = 14;
      }
      break;
    case 2570401: 
      if (((String)localObject).equals("TDRC")) {
        j = 13;
      }
      break;
    case 2569891: 
      if (((String)localObject).equals("TDAT")) {
        j = 12;
      }
      break;
    case 2569357: 
      if (((String)localObject).equals("TCOM")) {
        j = 11;
      }
      break;
    case 2567331: 
      if (((String)localObject).equals("TALB")) {
        j = 10;
      }
      break;
    case 83552: 
      if (((String)localObject).equals("TYE")) {
        j = 9;
      }
      break;
    case 83536: 
      if (((String)localObject).equals("TXT")) {
        j = 8;
      }
      break;
    case 83378: 
      if (((String)localObject).equals("TT2")) {
        j = 7;
      }
      break;
    case 83341: 
      if (((String)localObject).equals("TRK")) {
        j = 6;
      }
      break;
    case 83255: 
      if (((String)localObject).equals("TP3")) {
        j = 5;
      }
      break;
    case 83254: 
      if (((String)localObject).equals("TP2")) {
        j = 4;
      }
      break;
    case 83253: 
      if (((String)localObject).equals("TP1")) {
        j = 3;
      }
      break;
    case 82897: 
      if (((String)localObject).equals("TDA")) {
        j = 2;
      }
      break;
    case 82878: 
      if (((String)localObject).equals("TCM")) {
        j = 1;
      }
      break;
    case 82815: 
      if (((String)localObject).equals("TAL")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      break;
    case 14: 
      localObject = a(this.f);
      j = ((List)localObject).size();
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            paramb.S((Integer)((List)localObject).get(2));
          }
        }
        else {
          paramb.T((Integer)((List)localObject).get(1));
        }
      }
      else {
        paramb.U((Integer)((List)localObject).get(0));
      }
      break;
    case 13: 
      localObject = a(this.f);
      j = ((List)localObject).size();
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            paramb.P((Integer)((List)localObject).get(2));
          }
        }
        else {
          paramb.Q((Integer)((List)localObject).get(1));
        }
      }
      else {
        paramb.R((Integer)((List)localObject).get(0));
      }
      break;
    }
    try
    {
      paramb.R(Integer.valueOf(Integer.parseInt(this.f)));
    }
    catch (NumberFormatException|StringIndexOutOfBoundsException paramb)
    {
      for (;;) {}
    }
    paramb.Y(this.f);
    break label1095;
    paramb.V(this.f);
    break label1095;
    localObject = o0.E0(this.f, "/");
    j = Integer.parseInt(localObject[0]);
    if (localObject.length > 1) {
      localObject = Integer.valueOf(Integer.parseInt(localObject[1]));
    } else {
      localObject = null;
    }
    paramb.X(Integer.valueOf(j)).W((Integer)localObject);
    break label1095;
    paramb.N(this.f);
    break label1095;
    paramb.J(this.f);
    break label1095;
    paramb.L(this.f);
    break label1095;
    j = Integer.parseInt(this.f.substring(2, 4));
    i = Integer.parseInt(this.f.substring(0, 2));
    paramb.Q(Integer.valueOf(j)).P(Integer.valueOf(i));
    break label1095;
    paramb.M(this.f);
    break label1095;
    paramb.K(this.f);
    label1095:
  }
  
  public String toString()
  {
    String str1 = this.c;
    String str2 = this.d;
    String str3 = this.f;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 22 + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(": description=");
    localStringBuilder.append(str2);
    localStringBuilder.append(": value=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
  }
  
  class a
    implements Parcelable.Creator<TextInformationFrame>
  {
    public TextInformationFrame a(Parcel paramParcel)
    {
      return new TextInformationFrame(paramParcel);
    }
    
    public TextInformationFrame[] b(int paramInt)
    {
      return new TextInformationFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\TextInformationFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */