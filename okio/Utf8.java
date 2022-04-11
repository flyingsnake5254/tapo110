package okio;

public final class Utf8
{
  public static long size(String paramString)
  {
    return size(paramString, 0, paramString.length());
  }
  
  public static long size(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            long l1 = 0L;
            while (paramInt1 < paramInt2)
            {
              int i = paramString.charAt(paramInt1);
              if (i < 128)
              {
                l1 += 1L;
                label47:
                paramInt1++;
              }
              else
              {
                if (i < 2048) {}
                for (long l2 = 2L;; l2 = 3L)
                {
                  l1 += l2;
                  break label47;
                  if ((i >= 55296) && (i <= 57343))
                  {
                    int j = paramInt1 + 1;
                    int k;
                    if (j < paramInt2) {
                      k = paramString.charAt(j);
                    } else {
                      k = 0;
                    }
                    if ((i <= 56319) && (k >= 56320) && (k <= 57343))
                    {
                      l1 += 4L;
                      paramInt1 += 2;
                      break;
                    }
                    l1 += 1L;
                    paramInt1 = j;
                    break;
                  }
                }
              }
            }
            return l1;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("endIndex > string.length: ");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(" > ");
          localStringBuilder.append(paramString.length());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("string == null");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */