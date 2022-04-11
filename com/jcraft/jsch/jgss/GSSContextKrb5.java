package com.jcraft.jsch.jgss;

import com.jcraft.jsch.JSchException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.MessageProp;
import org.ietf.jgss.Oid;

public class GSSContextKrb5
  implements com.jcraft.jsch.GSSContext
{
  private static final String pUseSubjectCredsOnly = "javax.security.auth.useSubjectCredsOnly";
  private static String useSubjectCredsOnly = getSystemProperty("javax.security.auth.useSubjectCredsOnly");
  private org.ietf.jgss.GSSContext context = null;
  
  private static String getSystemProperty(String paramString)
  {
    try
    {
      paramString = System.getProperty(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static void setSystemProperty(String paramString1, String paramString2)
  {
    try
    {
      System.setProperty(paramString1, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
  }
  
  public void create(String paramString1, String paramString2)
    throws JSchException
  {
    try
    {
      localOid1 = new org/ietf/jgss/Oid;
      localOid1.<init>("1.2.840.113554.1.2.2");
      localOid2 = new org/ietf/jgss/Oid;
      localOid2.<init>("1.2.840.113554.1.2.2.1");
      localGSSManager = GSSManager.getInstance();
    }
    catch (GSSException paramString1)
    {
      Oid localOid1;
      Oid localOid2;
      GSSManager localGSSManager;
      label37:
      throw new JSchException(paramString1.toString());
    }
    try
    {
      paramString1 = InetAddress.getByName(paramString2).getCanonicalHostName();
      paramString2 = paramString1;
    }
    catch (UnknownHostException paramString1)
    {
      break label37;
    }
    paramString1 = new java/lang/StringBuilder;
    paramString1.<init>();
    paramString1.append("host/");
    paramString1.append(paramString2);
    paramString1 = localGSSManager.createContext(localGSSManager.createName(paramString1.toString(), localOid2), localOid1, null, 0);
    this.context = paramString1;
    paramString1.requestMutualAuth(true);
    this.context.requestConf(true);
    this.context.requestInteg(true);
    this.context.requestCredDeleg(true);
    this.context.requestAnonymity(false);
  }
  
  public void dispose()
  {
    try
    {
      this.context.dispose();
      return;
    }
    catch (GSSException localGSSException)
    {
      for (;;) {}
    }
  }
  
  public byte[] getMIC(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      MessageProp localMessageProp = new org/ietf/jgss/MessageProp;
      localMessageProp.<init>(0, true);
      paramArrayOfByte = this.context.getMIC(paramArrayOfByte, paramInt1, paramInt2, localMessageProp);
      return paramArrayOfByte;
    }
    catch (GSSException paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  public byte[] init(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws JSchException
  {
    // Byte code:
    //   0: getstatic 21	com/jcraft/jsch/jgss/GSSContextKrb5:useSubjectCredsOnly	Ljava/lang/String;
    //   3: ifnonnull +10 -> 13
    //   6: ldc 10
    //   8: ldc -125
    //   10: invokestatic 133	com/jcraft/jsch/jgss/GSSContextKrb5:setSystemProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 27	com/jcraft/jsch/jgss/GSSContextKrb5:context	Lorg/ietf/jgss/GSSContext;
    //   17: aload_1
    //   18: iconst_0
    //   19: iload_3
    //   20: invokeinterface 136 4 0
    //   25: astore_1
    //   26: getstatic 21	com/jcraft/jsch/jgss/GSSContextKrb5:useSubjectCredsOnly	Ljava/lang/String;
    //   29: ifnonnull +10 -> 39
    //   32: ldc 10
    //   34: ldc -118
    //   36: invokestatic 133	com/jcraft/jsch/jgss/GSSContextKrb5:setSystemProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: goto +37 -> 79
    //   45: astore 4
    //   47: new 43	com/jcraft/jsch/JSchException
    //   50: astore_1
    //   51: aload_1
    //   52: aload 4
    //   54: invokevirtual 139	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   57: invokespecial 112	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   60: aload_1
    //   61: athrow
    //   62: astore 4
    //   64: new 43	com/jcraft/jsch/JSchException
    //   67: astore_1
    //   68: aload_1
    //   69: aload 4
    //   71: invokevirtual 111	org/ietf/jgss/GSSException:toString	()Ljava/lang/String;
    //   74: invokespecial 112	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   77: aload_1
    //   78: athrow
    //   79: getstatic 21	com/jcraft/jsch/jgss/GSSContextKrb5:useSubjectCredsOnly	Ljava/lang/String;
    //   82: ifnonnull +10 -> 92
    //   85: ldc 10
    //   87: ldc -118
    //   89: invokestatic 133	com/jcraft/jsch/jgss/GSSContextKrb5:setSystemProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	GSSContextKrb5
    //   0	94	1	paramArrayOfByte	byte[]
    //   0	94	2	paramInt1	int
    //   0	94	3	paramInt2	int
    //   45	8	4	localSecurityException	SecurityException
    //   62	8	4	localGSSException	GSSException
    // Exception table:
    //   from	to	target	type
    //   0	13	41	finally
    //   13	26	41	finally
    //   47	62	41	finally
    //   64	79	41	finally
    //   0	13	45	java/lang/SecurityException
    //   13	26	45	java/lang/SecurityException
    //   0	13	62	org/ietf/jgss/GSSException
    //   13	26	62	org/ietf/jgss/GSSException
  }
  
  public boolean isEstablished()
  {
    return this.context.isEstablished();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jgss\GSSContextKrb5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */