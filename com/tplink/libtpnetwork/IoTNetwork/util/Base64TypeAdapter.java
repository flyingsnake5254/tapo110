package com.tplink.libtpnetwork.IoTNetwork.util;

import com.google.gson.TypeAdapter;
import java.io.IOException;

public class Base64TypeAdapter
  extends TypeAdapter<String>
{
  public String read(com.google.gson.stream.a parama)
    throws IOException
  {
    parama = parama.E();
    if ((!b.d.w.h.b.d(parama)) && (!parama.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$")))
    {
      b.d.w.c.a.m("Attention!!! illegal base64 string");
      return parama;
    }
    return b.d.w.h.a.a(parama);
  }
  
  public void write(com.google.gson.stream.b paramb, String paramString)
    throws IOException
  {
    if (paramString != null) {
      paramb.J(b.d.w.h.a.b(paramString));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\util\Base64TypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */