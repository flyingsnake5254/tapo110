package com.google.android.gms.internal.mlkit_common;

final class zzhm
{
  static String zza(zzdv paramzzdv)
  {
    paramzzdv = new zzhl(paramzzdv);
    StringBuilder localStringBuilder = new StringBuilder(paramzzdv.zza());
    for (int i = 0; i < paramzzdv.zza(); i++)
    {
      int j = paramzzdv.zza(i);
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
                localStringBuilder.append((char)j);
              }
              else
              {
                localStringBuilder.append('\\');
                localStringBuilder.append((char)((j >>> 6 & 0x3) + 48));
                localStringBuilder.append((char)((j >>> 3 & 0x7) + 48));
                localStringBuilder.append((char)((j & 0x7) + 48));
              }
              break;
            case 13: 
              localStringBuilder.append("\\r");
              break;
            case 12: 
              localStringBuilder.append("\\f");
              break;
            case 11: 
              localStringBuilder.append("\\v");
              break;
            case 10: 
              localStringBuilder.append("\\n");
              break;
            case 9: 
              localStringBuilder.append("\\t");
              break;
            case 8: 
              localStringBuilder.append("\\b");
              break;
            case 7: 
              localStringBuilder.append("\\a");
              break;
            }
          } else {
            localStringBuilder.append("\\\\");
          }
        }
        else {
          localStringBuilder.append("\\'");
        }
      }
      else {
        localStringBuilder.append("\\\"");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */