package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;

public abstract interface c
{
  public static final c a = new a();
  
  public abstract boolean a(Format paramFormat);
  
  public abstract b b(Format paramFormat);
  
  class a
    implements c
  {
    public boolean a(Format paramFormat)
    {
      paramFormat = paramFormat.H3;
      boolean bool;
      if ((!"application/id3".equals(paramFormat)) && (!"application/x-emsg".equals(paramFormat)) && (!"application/x-scte35".equals(paramFormat)) && (!"application/x-icy".equals(paramFormat)) && (!"application/vnd.dvb.ait".equals(paramFormat))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public b b(Format paramFormat)
    {
      paramFormat = paramFormat.H3;
      if (paramFormat != null)
      {
        int i = -1;
        switch (paramFormat.hashCode())
        {
        default: 
          break;
        case 1652648887: 
          if (paramFormat.equals("application/x-scte35")) {
            i = 4;
          }
          break;
        case 1154383568: 
          if (paramFormat.equals("application/x-emsg")) {
            i = 3;
          }
          break;
        case -1248341703: 
          if (paramFormat.equals("application/id3")) {
            i = 2;
          }
          break;
        case -1348231605: 
          if (paramFormat.equals("application/x-icy")) {
            i = 1;
          }
          break;
        case -1354451219: 
          if (paramFormat.equals("application/vnd.dvb.ait")) {
            i = 0;
          }
          break;
        }
        switch (i)
        {
        default: 
          break;
        case 4: 
          return new com.google.android.exoplayer2.metadata.scte35.a();
        case 3: 
          return new com.google.android.exoplayer2.metadata.emsg.a();
        case 2: 
          return new com.google.android.exoplayer2.metadata.id3.b();
        case 1: 
          return new com.google.android.exoplayer2.metadata.icy.a();
        case 0: 
          return new com.google.android.exoplayer2.metadata.dvbsi.a();
        }
      }
      paramFormat = String.valueOf(paramFormat);
      if (paramFormat.length() != 0) {
        paramFormat = "Attempted to create decoder for unsupported MIME type: ".concat(paramFormat);
      } else {
        paramFormat = new String("Attempted to create decoder for unsupported MIME type: ");
      }
      throw new IllegalArgumentException(paramFormat);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */