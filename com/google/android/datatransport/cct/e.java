package com.google.android.datatransport.cct;

public final class e
{
  static String a(String paramString1, String paramString2)
  {
    int i = paramString1.length() - paramString2.length();
    if ((i >= 0) && (i <= 1))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString1.length() + paramString2.length());
      for (i = 0; i < paramString1.length(); i++)
      {
        localStringBuilder.append(paramString1.charAt(i));
        if (paramString2.length() > i) {
          localStringBuilder.append(paramString2.charAt(i));
        }
      }
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Invalid input received");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */