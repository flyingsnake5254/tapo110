package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.m.d;
import com.google.android.exoplayer2.text.u.i;

public abstract interface h
{
  public static final h a = new a();
  
  public abstract boolean a(Format paramFormat);
  
  public abstract g b(Format paramFormat);
  
  class a
    implements h
  {
    public boolean a(Format paramFormat)
    {
      paramFormat = paramFormat.H3;
      boolean bool;
      if ((!"text/vtt".equals(paramFormat)) && (!"text/x-ssa".equals(paramFormat)) && (!"application/ttml+xml".equals(paramFormat)) && (!"application/x-mp4-vtt".equals(paramFormat)) && (!"application/x-subrip".equals(paramFormat)) && (!"application/x-quicktime-tx3g".equals(paramFormat)) && (!"application/cea-608".equals(paramFormat)) && (!"application/x-mp4-cea-608".equals(paramFormat)) && (!"application/cea-708".equals(paramFormat)) && (!"application/dvbsubs".equals(paramFormat)) && (!"application/pgs".equals(paramFormat))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public g b(Format paramFormat)
    {
      String str = paramFormat.H3;
      if (str != null)
      {
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          break;
        case 1693976202: 
          if (str.equals("application/ttml+xml")) {
            i = 10;
          }
          break;
        case 1668750253: 
          if (str.equals("application/x-subrip")) {
            i = 9;
          }
          break;
        case 1566016562: 
          if (str.equals("application/cea-708")) {
            i = 8;
          }
          break;
        case 1566015601: 
          if (str.equals("application/cea-608")) {
            i = 7;
          }
          break;
        case 930165504: 
          if (str.equals("application/x-mp4-cea-608")) {
            i = 6;
          }
          break;
        case 822864842: 
          if (str.equals("text/x-ssa")) {
            i = 5;
          }
          break;
        case 691401887: 
          if (str.equals("application/x-quicktime-tx3g")) {
            i = 4;
          }
          break;
        case -1004728940: 
          if (str.equals("text/vtt")) {
            i = 3;
          }
          break;
        case -1026075066: 
          if (str.equals("application/x-mp4-vtt")) {
            i = 2;
          }
          break;
        case -1248334819: 
          if (str.equals("application/pgs")) {
            i = 1;
          }
          break;
        case -1351681404: 
          if (str.equals("application/dvbsubs")) {
            i = 0;
          }
          break;
        }
        switch (i)
        {
        default: 
          break;
        case 10: 
          return new com.google.android.exoplayer2.text.s.c();
        case 9: 
          return new com.google.android.exoplayer2.text.r.a();
        case 8: 
          return new d(paramFormat.Z3, paramFormat.J3);
        case 6: 
        case 7: 
          return new com.google.android.exoplayer2.text.m.c(str, paramFormat.Z3, 16000L);
        case 5: 
          return new com.google.android.exoplayer2.text.q.a(paramFormat.J3);
        case 4: 
          return new com.google.android.exoplayer2.text.t.a(paramFormat.J3);
        case 3: 
          return new i();
        case 2: 
          return new com.google.android.exoplayer2.text.u.c();
        case 1: 
          return new com.google.android.exoplayer2.text.o.a();
        case 0: 
          return new com.google.android.exoplayer2.text.n.a(paramFormat.J3);
        }
      }
      paramFormat = String.valueOf(str);
      if (paramFormat.length() != 0) {
        paramFormat = "Attempted to create decoder for unsupported MIME type: ".concat(paramFormat);
      } else {
        paramFormat = new String("Attempted to create decoder for unsupported MIME type: ");
      }
      throw new IllegalArgumentException(paramFormat);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */