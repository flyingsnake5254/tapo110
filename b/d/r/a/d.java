package b.d.r.a;

import java.util.ArrayList;
import java.util.List;

public class d
{
  private a a;
  
  public d(a parama)
  {
    this.a = parama;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 5))
    {
      int i = paramArrayOfByte.length;
      int j = 5;
      byte[] arrayOfByte;
      while (j < i - 4)
      {
        int k = i;
        int m = j;
        if (paramArrayOfByte[j] == 0)
        {
          k = i;
          m = j;
          if (paramArrayOfByte[(j + 1)] == 0)
          {
            k = i;
            m = j;
            if (paramArrayOfByte[(j + 2)] == 0)
            {
              k = i;
              m = j;
              if (paramArrayOfByte[(j + 3)] == 1)
              {
                arrayOfByte = new byte[j];
                System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, j);
                a locala = this.a;
                if (locala != null) {
                  locala.c(arrayOfByte, paramLong);
                }
                k = i - j;
                System.arraycopy(paramArrayOfByte, j, paramArrayOfByte, 0, k);
                m = 5;
              }
            }
          }
        }
        j = m + 1;
        i = k;
      }
      if (i > 5)
      {
        arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
        paramArrayOfByte = this.a;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.c(arrayOfByte, paramLong);
        }
      }
    }
  }
  
  public List<byte[]> b(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 5))
    {
      int i = paramArrayOfByte.length;
      int j = 5;
      byte[] arrayOfByte;
      while (j < i - 4)
      {
        int k = i;
        int m = j;
        if (paramArrayOfByte[j] == 0)
        {
          k = i;
          m = j;
          if (paramArrayOfByte[(j + 1)] == 0)
          {
            k = i;
            m = j;
            if (paramArrayOfByte[(j + 2)] == 0)
            {
              k = i;
              m = j;
              if (paramArrayOfByte[(j + 3)] == 1)
              {
                arrayOfByte = new byte[j];
                System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, j);
                localArrayList.add(arrayOfByte);
                k = i - j;
                System.arraycopy(paramArrayOfByte, j, paramArrayOfByte, 0, k);
                m = 5;
              }
            }
          }
        }
        j = m + 1;
        i = k;
      }
      if (i > 5)
      {
        arrayOfByte = new byte[i];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
        localArrayList.add(arrayOfByte);
      }
    }
    return localArrayList;
  }
  
  public static abstract interface a
  {
    public abstract void c(byte[] paramArrayOfByte, long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\r\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */