package com.tplink.libtpmediastatistics;

import b.d.d.m.g;
import b.d.d.m.h;
import com.tplink.libmediakit.jniinterface.RemoteConnection;
import com.tplink.libtpmediastatistics.bean.StatisticsCameraDevice;
import com.tplink.libtpmediastatistics.utils.StatisticsRemoteServerInfoUtils;
import io.reactivex.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatisticsManager
{
  private static final String TAG = "StatisticsManager";
  private static StatisticsManager instance;
  private Map<String, ConnectionInfoVO> connectionInfoVOMap = new ConcurrentHashMap();
  private ExecutorService executorService = Executors.newSingleThreadExecutor();
  private Map<String, OnceConnectionVO> onceConnectionVOMap = new ConcurrentHashMap();
  
  public static StatisticsManager getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null)
        {
          StatisticsManager localStatisticsManager = new com/tplink/libtpmediastatistics/StatisticsManager;
          localStatisticsManager.<init>();
          instance = localStatisticsManager;
        }
      }
      finally {}
    }
    return instance;
  }
  
  private void requestFeedback(StatisticsCameraDevice paramStatisticsCameraDevice)
  {
    if ((paramStatisticsCameraDevice != null) && (!paramStatisticsCameraDevice.isLocalOnly()))
    {
      Object localObject1 = b.d.d.m.a.a();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TP-Link_Tapo_Android Android ");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = StatisticsRemoteServerInfoUtils.getStatServerName(b.d.d.f.a.h());
      FeedbackUploadManager.getInstance().initSSLClient((String)localObject2, 443, (String)localObject1, b.d.d.a.a.c());
      localObject2 = paramStatisticsCameraDevice.getDeviceIdMD5();
      localObject1 = new BasicVO();
      ((BasicVO)localObject1).setAppID(h.a());
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Android ");
      ((StringBuilder)localObject3).append(b.d.d.m.a.a());
      ((BasicVO)localObject1).setClientType(((StringBuilder)localObject3).toString());
      ((BasicVO)localObject1).setDevID(paramStatisticsCameraDevice.getDeviceId());
      if (paramStatisticsCameraDevice.getModel() != null) {
        ((BasicVO)localObject1).setDevModel(paramStatisticsCameraDevice.getModel());
      }
      ((BasicVO)localObject1).setNetworkType(g.a());
      ((BasicVO)localObject1).setFirmwareVersion(paramStatisticsCameraDevice.getSoftwareVersion());
      localObject3 = StatisticsStreamType.MIXED;
      Object localObject4 = getConnectionInfoCacheKey((String)localObject2, (StatisticsStreamType)localObject3);
      localObject4 = (ConnectionInfoVO)this.connectionInfoVOMap.remove(localObject4);
      if (localObject4 != null)
      {
        ((BasicVO)localObject1).setStreamType(((StatisticsStreamType)localObject3).toString());
        ((ConnectionInfoVO)localObject4).setConnectionBasicVO(((BasicVO)localObject1).clone());
        localObject3 = new FeedbackPayload();
        ((FeedbackPayload)localObject3).setVersion("0.1");
        ((FeedbackPayload)localObject3).setType("appSession");
        ((FeedbackPayload)localObject3).addData("basic", ((ConnectionInfoVO)localObject4).getConnectionBasicVO());
        ((FeedbackPayload)localObject3).addData("relay", ((ConnectionInfoVO)localObject4).getRelayConnectionVO());
        localObject4 = ((ConnectionInfoVO)localObject4).getP2pConnectionVO();
        ((ConnectionVO)localObject4).setNatTypeApp(Integer.valueOf(RemoteConnection.d().f()));
        ((ConnectionVO)localObject4).setNatTypeDev(Integer.valueOf(RemoteConnection.d().g(paramStatisticsCameraDevice.getDeviceId())));
        ((FeedbackPayload)localObject3).addData("p2p", localObject4);
        FeedbackUploadManager.getInstance().offerFeedbackPayload(MediaJsonUtils.toJSON(localObject3));
        b.d.p.d.e("NNNNNNNNNNN", MediaJsonUtils.toJSON(localObject3));
      }
      localObject4 = StatisticsStreamType.SD_VOD;
      localObject3 = getConnectionInfoCacheKey((String)localObject2, (StatisticsStreamType)localObject4);
      localObject3 = (ConnectionInfoVO)this.connectionInfoVOMap.remove(localObject3);
      if (localObject3 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sdVODConnectionInfoVO:");
        localStringBuilder.append(((ConnectionInfoVO)localObject3).toString());
        b.d.p.d.a("StatisticsManager", localStringBuilder.toString());
        ((BasicVO)localObject1).setStreamType(((StatisticsStreamType)localObject4).toString());
        ((ConnectionInfoVO)localObject3).setConnectionBasicVO(((BasicVO)localObject1).clone());
        localObject4 = new FeedbackPayload();
        ((FeedbackPayload)localObject4).setVersion("0.1");
        ((FeedbackPayload)localObject4).setType("appSession");
        ((FeedbackPayload)localObject4).addData("basic", ((ConnectionInfoVO)localObject3).getConnectionBasicVO());
        ((FeedbackPayload)localObject4).addData("relay", ((ConnectionInfoVO)localObject3).getRelayConnectionVO());
        localObject3 = ((ConnectionInfoVO)localObject3).getP2pConnectionVO();
        ((ConnectionVO)localObject3).setNatTypeApp(Integer.valueOf(RemoteConnection.d().f()));
        ((ConnectionVO)localObject3).setNatTypeDev(Integer.valueOf(RemoteConnection.d().g(paramStatisticsCameraDevice.getDeviceId())));
        ((FeedbackPayload)localObject4).addData("p2p", localObject3);
        FeedbackUploadManager.getInstance().offerFeedbackPayload(MediaJsonUtils.toJSON(localObject4));
        b.d.p.d.e("NNNNNNNNNNN", MediaJsonUtils.toJSON(localObject4));
      }
      localObject3 = StatisticsStreamType.DOUBLE_TALK;
      localObject2 = getConnectionInfoCacheKey((String)localObject2, (StatisticsStreamType)localObject3);
      localObject2 = (ConnectionInfoVO)this.connectionInfoVOMap.remove(localObject2);
      if (localObject2 != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("doubleTalkConnectionInfoVO:");
        ((StringBuilder)localObject4).append(((ConnectionInfoVO)localObject2).toString());
        b.d.p.d.a("StatisticsManager", ((StringBuilder)localObject4).toString());
        ((BasicVO)localObject1).setStreamType(((StatisticsStreamType)localObject3).toString());
        ((ConnectionInfoVO)localObject2).setConnectionBasicVO(((BasicVO)localObject1).clone());
        localObject1 = new FeedbackPayload();
        ((FeedbackPayload)localObject1).setVersion("0.1");
        ((FeedbackPayload)localObject1).setType("appSession");
        ((FeedbackPayload)localObject1).addData("basic", ((ConnectionInfoVO)localObject2).getConnectionBasicVO());
        ((FeedbackPayload)localObject1).addData("relay", ((ConnectionInfoVO)localObject2).getRelayConnectionVO());
        localObject3 = ((ConnectionInfoVO)localObject2).getP2pConnectionVO();
        ((ConnectionVO)localObject3).setNatTypeApp(Integer.valueOf(RemoteConnection.d().f()));
        ((ConnectionVO)localObject3).setNatTypeDev(Integer.valueOf(RemoteConnection.d().g(paramStatisticsCameraDevice.getDeviceId())));
        ((FeedbackPayload)localObject1).addData("p2p", localObject3);
        ((FeedbackPayload)localObject1).addData("local", ((ConnectionInfoVO)localObject2).getLocalConnectionVO());
        FeedbackUploadManager.getInstance().offerFeedbackPayload(MediaJsonUtils.toJSON(localObject1));
        b.d.p.d.e("NNNNNNNNNNN", MediaJsonUtils.toJSON(localObject1));
      }
    }
  }
  
  public OnceConnectionVO getAndRemoveOnceConnectionVO(String paramString)
  {
    return (OnceConnectionVO)this.onceConnectionVOMap.remove(paramString);
  }
  
  public String getConnectionInfoCacheKey(String paramString, StatisticsStreamType paramStatisticsStreamType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramStatisticsStreamType.value());
    return localStringBuilder.toString();
  }
  
  public ConnectionInfoVO getConnectionInfoVO(String paramString)
  {
    return (ConnectionInfoVO)this.connectionInfoVOMap.get(paramString);
  }
  
  public String getOnceConnectionCacheKey(String paramString, StatisticsStreamType paramStatisticsStreamType, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramStatisticsStreamType.value());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public OnceConnectionVO getOnceConnectionVO(String paramString)
  {
    return (OnceConnectionVO)this.onceConnectionVOMap.get(paramString);
  }
  
  public void insertConnectionInfoVO(String paramString, ConnectionInfoVO paramConnectionInfoVO)
  {
    this.connectionInfoVOMap.put(paramString, paramConnectionInfoVO);
  }
  
  public void insertOnceConnectionVO(String paramString, OnceConnectionVO paramOnceConnectionVO)
  {
    this.onceConnectionVOMap.put(paramString, paramOnceConnectionVO);
  }
  
  public void removeConnectionInfoVO(String paramString)
  {
    this.connectionInfoVOMap.remove(paramString);
  }
  
  public void removeOnceConnectionVO(String paramString)
  {
    this.onceConnectionVOMap.remove(paramString);
  }
  
  public void sendFeedback(StatisticsCameraDevice paramStatisticsCameraDevice)
  {
    if (paramStatisticsCameraDevice == null) {
      return;
    }
    q.f0(paramStatisticsCameraDevice).L0(io.reactivex.l0.a.b(this.executorService)).E(new d(this)).F0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\StatisticsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */