package com.jcraft.jsch.jce;

import com.jcraft.jsch.ECDH;

public class ECDH384
  extends ECDHN
  implements ECDH
{
  public void init()
    throws Exception
  {
    super.init(384);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\ECDH384.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */