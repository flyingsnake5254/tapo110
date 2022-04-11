package com.google.android.gms.internal.vision;

final class zzjk
{
  static String zzd(zzfm paramzzfm)
  {
    zzjn localzzjn = new zzjn(paramzzfm);
    paramzzfm = new StringBuilder(localzzjn.size());
    for (int i = 0; i < localzzjn.size(); i++)
    {
      int j = localzzjn.zzao(i);
      if (j != 34)
      {
        if (j != 39)
        {
          if (j != 92) {
            switch (j)
            {
            default: 
              if ((j >= 32) && (j <= 126))
              {
                paramzzfm.append((char)j);
              }
              else
              {
                paramzzfm.append('\\');
                paramzzfm.append((char)((j >>> 6 & 0x3) + 48));
                paramzzfm.append((char)((j >>> 3 & 0x7) + 48));
                paramzzfm.append((char)((j & 0x7) + 48));
              }
              break;
            case 13: 
              paramzzfm.append("\\r");
              break;
            case 12: 
              paramzzfm.append("\\f");
              break;
            case 11: 
              paramzzfm.append("\\v");
              break;
            case 10: 
              paramzzfm.append("\\n");
              break;
            case 9: 
              paramzzfm.append("\\t");
              break;
            case 8: 
              paramzzfm.append("\\b");
              break;
            case 7: 
              paramzzfm.append("\\a");
              break;
            }
          } else {
            paramzzfm.append("\\\\");
          }
        }
        else {
          paramzzfm.append("\\'");
        }
      }
      else {
        paramzzfm.append("\\\"");
      }
    }
    return paramzzfm.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */