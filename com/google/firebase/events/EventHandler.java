package com.google.firebase.events;

public abstract interface EventHandler<T>
{
  public abstract void handle(Event<T> paramEvent);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\events\EventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */