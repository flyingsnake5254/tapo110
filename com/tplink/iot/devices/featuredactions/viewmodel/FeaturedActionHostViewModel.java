package com.tplink.iot.devices.featuredactions.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;

public final class FeaturedActionHostViewModel
  extends AndroidViewModel
{
  private final kotlin.t.c b;
  
  public FeaturedActionHostViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = com.tplink.iot.Utils.extension.c.a(paramThingContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\viewmodel\FeaturedActionHostViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */