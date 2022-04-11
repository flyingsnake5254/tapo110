package org.bouncycastle.util.test;

import org.bouncycastle.util.encoders.d;

public class TestRandomData
  extends FixedSecureRandom
{
  public TestRandomData(String paramString)
  {
    super(new FixedSecureRandom.e[] { new FixedSecureRandom.b(d.a(paramString)) });
  }
  
  public TestRandomData(byte[] paramArrayOfByte)
  {
    super(new FixedSecureRandom.e[] { new FixedSecureRandom.b(paramArrayOfByte) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\test\TestRandomData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */