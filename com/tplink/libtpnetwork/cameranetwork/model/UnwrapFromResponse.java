package com.tplink.libtpnetwork.cameranetwork.model;

public abstract interface UnwrapFromResponse<T>
{
  public abstract T fromResponse(Response<Wrappers> paramResponse);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\UnwrapFromResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */