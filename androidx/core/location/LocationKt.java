package androidx.core.location;

import android.location.Location;
import kotlin.jvm.internal.j;

public final class LocationKt
{
  public static final double component1(Location paramLocation)
  {
    j.f(paramLocation, "$this$component1");
    return paramLocation.getLatitude();
  }
  
  public static final double component2(Location paramLocation)
  {
    j.f(paramLocation, "$this$component2");
    return paramLocation.getLongitude();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\location\LocationKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */