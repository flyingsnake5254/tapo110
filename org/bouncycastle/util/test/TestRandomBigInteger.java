package org.bouncycastle.util.test;

import java.math.BigInteger;
import org.bouncycastle.util.b;

public class TestRandomBigInteger
  extends FixedSecureRandom
{
  public TestRandomBigInteger(int paramInt, byte[] paramArrayOfByte)
  {
    super(new FixedSecureRandom.e[] { new FixedSecureRandom.a(paramInt, paramArrayOfByte) });
  }
  
  public TestRandomBigInteger(String paramString)
  {
    this(paramString, 10);
  }
  
  public TestRandomBigInteger(String paramString, int paramInt)
  {
    super(new FixedSecureRandom.e[] { new FixedSecureRandom.a(b.b(new BigInteger(paramString, paramInt))) });
  }
  
  public TestRandomBigInteger(byte[] paramArrayOfByte)
  {
    super(new FixedSecureRandom.e[] { new FixedSecureRandom.a(paramArrayOfByte) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\test\TestRandomBigInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */