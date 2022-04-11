package com.google.firebase.crashlytics.internal.common;

public enum DeliveryMechanism
{
  private final int id;
  
  static
  {
    DeliveryMechanism localDeliveryMechanism1 = new DeliveryMechanism("DEVELOPER", 0, 1);
    DEVELOPER = localDeliveryMechanism1;
    DeliveryMechanism localDeliveryMechanism2 = new DeliveryMechanism("USER_SIDELOAD", 1, 2);
    USER_SIDELOAD = localDeliveryMechanism2;
    DeliveryMechanism localDeliveryMechanism3 = new DeliveryMechanism("TEST_DISTRIBUTION", 2, 3);
    TEST_DISTRIBUTION = localDeliveryMechanism3;
    DeliveryMechanism localDeliveryMechanism4 = new DeliveryMechanism("APP_STORE", 3, 4);
    APP_STORE = localDeliveryMechanism4;
    $VALUES = new DeliveryMechanism[] { localDeliveryMechanism1, localDeliveryMechanism2, localDeliveryMechanism3, localDeliveryMechanism4 };
  }
  
  private DeliveryMechanism(int paramInt)
  {
    this.id = paramInt;
  }
  
  public static DeliveryMechanism determineFrom(String paramString)
  {
    if (paramString != null) {
      paramString = APP_STORE;
    } else {
      paramString = DEVELOPER;
    }
    return paramString;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String toString()
  {
    return Integer.toString(this.id);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\DeliveryMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */