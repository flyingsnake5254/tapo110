package com.tplink.tpble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;

public class z
{
  private static BluetoothAdapter a(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    BluetoothManager localBluetoothManager = (BluetoothManager)paramContext.getSystemService("bluetooth");
    paramContext = (Context)localObject;
    if (localBluetoothManager != null) {
      paramContext = localBluetoothManager.getAdapter();
    }
    return paramContext;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = a(paramContext);
    boolean bool;
    if ((paramContext != null) && (paramContext.isEnabled())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */