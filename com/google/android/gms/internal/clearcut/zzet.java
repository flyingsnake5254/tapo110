package com.google.android.gms.internal.clearcut;

final class zzet
{
  static String zzc(zzbb paramzzbb)
  {
    zzeu localzzeu = new zzeu(paramzzbb);
    StringBuilder localStringBuilder = new StringBuilder(localzzeu.size());
    for (int i = 0; i < localzzeu.size(); i++)
    {
      int j = localzzeu.zzj(i);
      if (j != 34) {
        if (j != 39) {
          if (j != 92) {
            switch (j)
            {
            default: 
              if ((j < 32) || (j > 126))
              {
                localStringBuilder.append('\\');
                localStringBuilder.append((char)((j >>> 6 & 0x3) + 48));
                localStringBuilder.append((char)((j >>> 3 & 0x7) + 48));
                j = (j & 0x7) + 48;
              }
              localStringBuilder.append((char)j);
              break;
            case 13: 
              paramzzbb = "\\r";
              break;
            case 12: 
              paramzzbb = "\\f";
              break;
            case 11: 
              paramzzbb = "\\v";
              break;
            case 10: 
              paramzzbb = "\\n";
              break;
            case 9: 
              paramzzbb = "\\t";
              break;
            case 8: 
              paramzzbb = "\\b";
              break;
            case 7: 
              paramzzbb = "\\a";
            }
          }
        }
      }
      for (;;)
      {
        localStringBuilder.append(paramzzbb);
        break;
        paramzzbb = "\\\\";
        continue;
        paramzzbb = "\\'";
        continue;
        paramzzbb = "\\\"";
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */