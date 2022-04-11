package b.d.d.e;

import b.d.d.d.c;
import b.d.p.d;
import b.d.p.e.b;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import java.util.HashMap;

public class a
{
  private static final String a = "a";
  private static final HashMap<String, BitStreamType> b = new HashMap();
  
  public static void a(String paramString, b<BitStreamType> paramb)
  {
    HashMap localHashMap = b;
    Object localObject1 = (BitStreamType)localHashMap.get(paramString);
    Object localObject2;
    if (localObject1 != null)
    {
      paramString = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("use last display resolution:");
      ((StringBuilder)localObject2).append(localObject1);
      d.a(paramString, ((StringBuilder)localObject2).toString());
      paramb.a(localObject1);
      return;
    }
    StringBuilder localStringBuilder;
    if ((c.i(paramString) ^ true))
    {
      localObject2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("remote device, default resolution:");
      localObject1 = BitStreamType.MINOR_VGA;
      localStringBuilder.append(localObject1);
      d.a((String)localObject2, localStringBuilder.toString());
      localHashMap.put(paramString, localObject1);
      paramb.a(localObject1);
    }
    else
    {
      localObject2 = b.d.d.l.a.a(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = BitStreamType.MAIN_HD;
        localObject2 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("local device, default resolution:");
        localStringBuilder.append(localObject1);
        d.a((String)localObject2, localStringBuilder.toString());
      }
      localHashMap.put(paramString, localObject1);
      paramb.a(localObject1);
    }
  }
  
  public static BitStreamType b(String paramString)
  {
    if (c.c(paramString) == null) {
      paramString = BitStreamType.MINOR_VGA;
    } else if (!c.i(paramString)) {
      paramString = BitStreamType.MINOR_VGA;
    } else {
      paramString = BitStreamType.MAIN_HD;
    }
    return paramString;
  }
  
  public static void c(String paramString, BitStreamType paramBitStreamType)
  {
    b.put(paramString, paramBitStreamType);
    if (c.i(paramString)) {
      b.d.d.l.a.b(paramString, paramBitStreamType);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */