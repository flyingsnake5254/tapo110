package net.lucode.hackware.magicindicator;

import android.annotation.TargetApi;
import java.util.List;

@TargetApi(11)
public class a
{
  public static net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a a(List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= paramList.size() - 1)) {
      return (net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)paramList.get(paramInt);
    }
    net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a locala = new net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a();
    if (paramInt < 0)
    {
      paramList = (net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)paramList.get(0);
    }
    else
    {
      paramInt = paramInt - paramList.size() + 1;
      paramList = (net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a)paramList.get(paramList.size() - 1);
    }
    paramList.a += paramList.b() * paramInt;
    locala.b = paramList.b;
    paramList.c += paramList.b() * paramInt;
    locala.d = paramList.d;
    paramList.e += paramList.b() * paramInt;
    locala.f = paramList.f;
    paramList.g += paramInt * paramList.b();
    locala.h = paramList.h;
    return locala;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */