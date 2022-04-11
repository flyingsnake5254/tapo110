package com.tplink.cloud.bean.common;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.b;
import java.io.IOException;

public class Base64TypeAdapter
  extends TypeAdapter<String>
{
  public String read(com.google.gson.stream.a parama)
    throws IOException
  {
    return b.d.w.h.a.a(parama.E());
  }
  
  public void write(b paramb, String paramString)
    throws IOException
  {
    if (paramString != null) {
      paramb.J(b.d.w.h.a.b(paramString));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\common\Base64TypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */