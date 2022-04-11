package com.tplink.ata.common;

import android.util.Base64;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;

public class ByteArrayBase64TypeAdapter
  extends TypeAdapter<byte[]>
{
  public byte[] a(a parama)
    throws IOException
  {
    parama = parama.E();
    if ((parama != null) && (!parama.isEmpty())) {
      return Base64.decode(parama, 2);
    }
    return new byte[0];
  }
  
  public void b(b paramb, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      paramb.J(Base64.encodeToString(paramArrayOfByte, 2));
    } else {
      paramb.J("");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\common\ByteArrayBase64TypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */