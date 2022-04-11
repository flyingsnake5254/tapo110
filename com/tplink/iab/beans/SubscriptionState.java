package com.tplink.iab.beans;

import java.lang.annotation.Annotation;

public @interface SubscriptionState
{
  public static final int ACKNOWLEDGEMENT_ERROR = -300;
  public static final int OK = 0;
  public static final int VERIFICATION_ERROR = -200;
  public static final int VERIFICATION_SUCCESS = 100;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iab\beans\SubscriptionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */