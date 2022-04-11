package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class b
{
  private final ByteArrayOutputStream a;
  private final DataOutputStream b;
  
  public b()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
    this.a = localByteArrayOutputStream;
    this.b = new DataOutputStream(localByteArrayOutputStream);
  }
  
  private static void b(DataOutputStream paramDataOutputStream, String paramString)
    throws IOException
  {
    paramDataOutputStream.writeBytes(paramString);
    paramDataOutputStream.writeByte(0);
  }
  
  public byte[] a(EventMessage paramEventMessage)
  {
    this.a.reset();
    try
    {
      b(this.b, paramEventMessage.f);
      String str = paramEventMessage.q;
      if (str == null) {
        str = "";
      }
      b(this.b, str);
      this.b.writeLong(paramEventMessage.x);
      this.b.writeLong(paramEventMessage.y);
      this.b.write(paramEventMessage.z);
      this.b.flush();
      paramEventMessage = this.a.toByteArray();
      return paramEventMessage;
    }
    catch (IOException paramEventMessage)
    {
      throw new RuntimeException(paramEventMessage);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\emsg\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */