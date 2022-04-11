package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

public final class m
{
  @Pure
  public static void a(boolean paramBoolean, @Nullable String paramString)
    throws ParserException
  {
    if (paramBoolean) {
      return;
    }
    throw ParserException.createForMalformedContainer(paramString, null);
  }
  
  public static boolean b(k paramk, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    try
    {
      boolean bool = paramk.c(paramArrayOfByte, paramInt1, paramInt2, paramBoolean);
      return bool;
    }
    catch (EOFException paramk)
    {
      if (paramBoolean) {
        return false;
      }
      throw paramk;
    }
  }
  
  public static int c(k paramk, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramk.k(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    return i;
  }
  
  public static boolean d(k paramk, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      paramk.readFully(paramArrayOfByte, paramInt1, paramInt2);
      return true;
    }
    catch (EOFException paramk) {}
    return false;
  }
  
  public static boolean e(k paramk, int paramInt)
    throws IOException
  {
    try
    {
      paramk.l(paramInt);
      return true;
    }
    catch (EOFException paramk) {}
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */