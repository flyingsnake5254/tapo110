package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import java.util.Map;

public final class Model
{
  public static final <T> List<T> extractFromMapList(List<? extends Map<String, ? extends T>> paramList)
  {
    return Model__ModelAdapterKt.extractFromMapList(paramList);
  }
  
  public static final <T> List<T> extractMapList(List<? extends Map<String, ? extends T>> paramList)
  {
    return Model__ModelAdapterKt.extractMapList(paramList);
  }
  
  public static final AESEncryptKey getAESEncryptKeyFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getAESEncryptKeyFromWrapper(paramWrappers);
  }
  
  public static final DiagnoseStatus getDiagnoseStateFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getDiagnoseStateFromWrapper(paramWrappers);
  }
  
  public static final MarkPositionConfirmInfo getMarkPositionConfirmInfoFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getMarkPositionConfirmInfoFromWrapper(paramWrappers);
  }
  
  public static final NetworkInfo getNetworkInfoFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getNetworkInfoFromWrapper(paramWrappers);
  }
  
  public static final P2PSharePwd getP2PSharePasswordFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getP2PSharePasswordFromWrapper(paramWrappers);
  }
  
  public static final ResetSupportInfo getResetSupportInfoFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getResetSupportInfoFromWrapper(paramWrappers);
  }
  
  public static final SdCardFormatProgress getSdCardFormatProgressFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getSdCardFormatProgressFromWrapper(paramWrappers);
  }
  
  public static final StartUpdateFirmwareInfo getStartFirmUpdateInfoFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getStartFirmUpdateInfoFromWrapper(paramWrappers);
  }
  
  public static final VodUserId getVodUserIdFromWrapper(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.getVodUserIdFromWrapper(paramWrappers);
  }
  
  public static final Account passwordDigest(Account paramAccount)
  {
    return Model__ModelKt.passwordDigest(paramAccount);
  }
  
  public static final <R> Response<R> safeCast(Response<? extends Object> paramResponse, Method paramMethod)
  {
    return Model__BaseKt.safeCast(paramResponse, paramMethod);
  }
  
  public static final List<ComponentBean> toComponentList(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.toComponentList(paramWrappers);
  }
  
  public static final List<OsdElement> toOsdList(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.toOsdList(paramWrappers);
  }
  
  public static final List<Wifi> toWifiList(Wrappers paramWrappers)
  {
    return Model__ModelAdapterKt.toWifiList(paramWrappers);
  }
  
  public static final <R> R typeCast(Wrappers paramWrappers, Module paramModule, Section paramSection)
  {
    return (R)Model__ModelAdapterKt.typeCast(paramWrappers, paramModule, paramSection);
  }
  
  public static final <R> R typeCast(Wrappers paramWrappers, Class<R> paramClass)
  {
    return (R)Model__ModelAdapterKt.typeCast(paramWrappers, paramClass);
  }
  
  public static final Response<List<Object>> unwrap(Response<Wrappers> paramResponse)
  {
    return Model__ModelAdapterKt.unwrap(paramResponse);
  }
  
  public static final <R> Response<R> unwrap(Response<Wrappers> paramResponse, Class<R> paramClass)
  {
    return Model__ModelAdapterKt.unwrap(paramResponse, paramClass);
  }
  
  public static final <T> Wrapper<Map<String, List<T>>> wrapper(List<? extends T> paramList, Module paramModule, Section paramSection, String paramString)
  {
    return Model__ModelAdapterKt.wrapper(paramList, paramModule, paramSection, paramString);
  }
  
  public static final <T> List<Map<String, T>> wrapperToMapList(List<? extends T> paramList, String paramString)
  {
    return Model__ModelAdapterKt.wrapperToMapList(paramList, paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Model.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */