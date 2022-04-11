package b.d.c0.l;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.tplink.tdp.bean.BaseTDPDevice;
import com.tplink.tdp.common.TDPResult;

public class a<T extends BaseTDPDevice>
  implements b<T>
{
  private static final Gson a = new d().c().b();
  private Class<T> b;
  
  public a(Class<T> paramClass)
  {
    this.b = paramClass;
  }
  
  public T a(byte[] paramArrayOfByte)
  {
    com.tplink.tdp.common.a locala = new com.tplink.tdp.common.a(TDPResult.class, new Class[] { this.b }, null);
    try
    {
      Gson localGson = a;
      String str = new java/lang/String;
      str.<init>(paramArrayOfByte);
      paramArrayOfByte = (TDPResult)localGson.m(str, locala);
      if (paramArrayOfByte.getErrorCode() == 0)
      {
        paramArrayOfByte = (BaseTDPDevice)paramArrayOfByte.getResult();
        return paramArrayOfByte;
      }
    }
    catch (JsonSyntaxException paramArrayOfByte)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c0\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */