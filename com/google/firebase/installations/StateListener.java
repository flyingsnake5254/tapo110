package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

abstract interface StateListener
{
  public abstract boolean onException(Exception paramException);
  
  public abstract boolean onStateReached(PersistedInstallationEntry paramPersistedInstallationEntry);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\StateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */