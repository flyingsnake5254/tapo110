package com.jcraft.jsch;

import java.util.Vector;

class LocalIdentityRepository
  implements IdentityRepository
{
  private static final String name = "Local Identity Repository";
  private Vector identities = new Vector();
  private JSch jsch;
  
  LocalIdentityRepository(JSch paramJSch)
  {
    this.jsch = paramJSch;
  }
  
  private void removeDupulicates()
  {
    Vector localVector = new Vector();
    int i = this.identities.size();
    if (i == 0) {
      return;
    }
    int j = 0;
    int m;
    for (int k = 0;; k++)
    {
      m = j;
      if (k >= i) {
        break;
      }
      Identity localIdentity1 = (Identity)this.identities.elementAt(k);
      byte[] arrayOfByte1 = localIdentity1.getPublicKeyBlob();
      if (arrayOfByte1 != null) {
        for (m = k + 1; m < i; m++)
        {
          Identity localIdentity2 = (Identity)this.identities.elementAt(m);
          byte[] arrayOfByte2 = localIdentity2.getPublicKeyBlob();
          if ((arrayOfByte2 != null) && (Util.array_equals(arrayOfByte1, arrayOfByte2)) && (localIdentity1.isEncrypted() == localIdentity2.isEncrypted()))
          {
            localVector.addElement(arrayOfByte1);
            break;
          }
        }
      }
    }
    while (m < localVector.size())
    {
      remove((byte[])localVector.elementAt(m));
      m++;
    }
  }
  
  public void add(Identity paramIdentity)
  {
    try
    {
      if (!this.identities.contains(paramIdentity))
      {
        byte[] arrayOfByte1 = paramIdentity.getPublicKeyBlob();
        if (arrayOfByte1 == null)
        {
          this.identities.addElement(paramIdentity);
          return;
        }
        for (int i = 0; i < this.identities.size(); i++)
        {
          byte[] arrayOfByte2 = ((Identity)this.identities.elementAt(i)).getPublicKeyBlob();
          if ((arrayOfByte2 != null) && (Util.array_equals(arrayOfByte1, arrayOfByte2))) {
            if ((!paramIdentity.isEncrypted()) && (((Identity)this.identities.elementAt(i)).isEncrypted())) {
              remove(arrayOfByte2);
            } else {
              return;
            }
          }
        }
        this.identities.addElement(paramIdentity);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean add(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 72
    //   5: aload_1
    //   6: aconst_null
    //   7: aload_0
    //   8: getfield 26	com/jcraft/jsch/LocalIdentityRepository:jsch	Lcom/jcraft/jsch/JSch;
    //   11: invokestatic 78	com/jcraft/jsch/IdentityFile:newInstance	(Ljava/lang/String;[B[BLcom/jcraft/jsch/JSch;)Lcom/jcraft/jsch/IdentityFile;
    //   14: invokevirtual 80	com/jcraft/jsch/LocalIdentityRepository:add	(Lcom/jcraft/jsch/Identity;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: iconst_1
    //   20: ireturn
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iconst_0
    //   30: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	LocalIdentityRepository
    //   0	31	1	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	17	21	finally
    //   2	17	26	com/jcraft/jsch/JSchException
  }
  
  public Vector getIdentities()
  {
    try
    {
      removeDupulicates();
      Vector localVector = new java/util/Vector;
      localVector.<init>();
      for (int i = 0; i < this.identities.size(); i++) {
        localVector.addElement(this.identities.elementAt(i));
      }
      return localVector;
    }
    finally {}
  }
  
  public String getName()
  {
    return "Local Identity Repository";
  }
  
  public int getStatus()
  {
    return 2;
  }
  
  void remove(Identity paramIdentity)
  {
    try
    {
      if (this.identities.contains(paramIdentity))
      {
        this.identities.removeElement(paramIdentity);
        paramIdentity.clear();
      }
      else
      {
        remove(paramIdentity.getPublicKeyBlob());
      }
      return;
    }
    finally {}
  }
  
  public boolean remove(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    int i = 0;
    try
    {
      while (i < this.identities.size())
      {
        Identity localIdentity = (Identity)this.identities.elementAt(i);
        byte[] arrayOfByte = localIdentity.getPublicKeyBlob();
        if ((arrayOfByte != null) && (Util.array_equals(paramArrayOfByte, arrayOfByte)))
        {
          this.identities.removeElement(localIdentity);
          localIdentity.clear();
          return true;
        }
        i++;
      }
      return false;
    }
    finally {}
  }
  
  public void removeAll()
  {
    int i = 0;
    try
    {
      while (i < this.identities.size())
      {
        ((Identity)this.identities.elementAt(i)).clear();
        i++;
      }
      this.identities.removeAllElements();
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\LocalIdentityRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */