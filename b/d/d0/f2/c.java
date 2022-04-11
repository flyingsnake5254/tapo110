package b.d.d0.f2;

import java.util.HashMap;
import java.util.Map;

public class c
{
  public static final Map<Byte, String> a;
  public static final Map<Byte, String> b;
  public static final Map<Byte, String> c;
  public static final Map<Byte, String> d;
  public static final Map<Byte, String> e;
  public static final Map<Byte, String> f;
  public static final Map<Integer, String> g;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    Object localObject1 = Byte.valueOf((byte)0);
    localHashMap.put(localObject1, "TMP_APPV2_ERR_NO_ERROR");
    Byte localByte1 = Byte.valueOf((byte)1);
    localHashMap.put(localByte1, "TMP_APPV2_ERR_UNKNOWN_ERROR");
    Byte localByte2 = Byte.valueOf((byte)2);
    localHashMap.put(localByte2, "TMP_APPV2_ERR_BUSINESS_TYPE");
    Byte localByte3 = Byte.valueOf((byte)3);
    localHashMap.put(localByte3, "TMP_APPV2_ERR_BUSINESS_VERSION");
    Byte localByte4 = Byte.valueOf((byte)4);
    localHashMap.put(localByte4, "TMP_APPV2_ERR_OPERATION");
    Byte localByte5 = Byte.valueOf((byte)5);
    localHashMap.put(localByte5, "TMP_APPV2_ERR_FLAGS");
    Object localObject2 = Byte.valueOf((byte)6);
    localHashMap.put(localObject2, "TMP_APPV2_ERR_TRANS_ID");
    localHashMap.put(Byte.valueOf((byte)7), "TMP_APPV2_ERR_TRANS_CRC32");
    localHashMap.put(Byte.valueOf((byte)8), "TMP_APPV2_ERR_TRANS_TOTAL_BYTES");
    localHashMap.put(Byte.valueOf((byte)9), "TMP_APPV2_ERR_TRANS_START_BYTE");
    localHashMap.put(Byte.valueOf((byte)10), "TMP_APPV2_ERR_TOKEN_EXPIRED");
    localHashMap.put(Byte.valueOf((byte)11), "TMP_APPV2_ERR_TOKEN_ALLOC");
    localHashMap.put(Byte.valueOf((byte)12), "TMP_APPV2_ERR_BUSINESS_FAILED");
    localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put(localByte1, "TMP_APPV2_FLAGS_ACK");
    localHashMap.put(localByte2, "TMP_APPV2_FLAGS_PUSH");
    localHashMap.put(localByte4, "TMP_APPV2_FLAGS_PULL");
    localHashMap.put(localByte3, "TMP_APPV2_FLAGS_PUSH_ACK");
    localHashMap.put(localByte5, "TMP_APPV2_FLAGS_PULL_ACK");
    localHashMap = new HashMap();
    c = localHashMap;
    localHashMap.put(localObject1, "TMP_ERR_OK");
    localHashMap.put(localByte1, "TMP_ERR_FAILED");
    localHashMap.put(localByte2, "TMP_ERR_VERSION");
    localHashMap.put(localByte3, "TMP_ERR_PAYLOADLEN");
    localHashMap.put(localByte4, "TMP_ERR_SN");
    localHashMap.put(localByte5, "TMP_ERR_CHECKSUM");
    localHashMap = new HashMap();
    d = localHashMap;
    localHashMap.put(localObject1, "TMP_HDR_FLAG_NONE");
    localHashMap.put(localByte1, "TMP_HDR_FLAG_COMPRESS");
    localHashMap.put(localByte2, "TMP_HDR_FLAG_ENCRYPT");
    localHashMap = new HashMap();
    e = localHashMap;
    localHashMap.put(localObject1, "TMP_GPH_REASON_NO_REASON");
    localHashMap.put(localByte1, "TMP_GPH_REASON_UNKNOWN_REASON");
    localHashMap.put(localByte2, "TMP_GPH_REASON_HEART_BEAT_TIME_OUT");
    localHashMap.put(localByte3, "TMP_GPH_REASON_CLIENT_LIMIT");
    localHashMap.put(localByte4, "TMP_GPH_REASON_SYSTEM_REBOOT");
    localHashMap.put(localByte5, "TMP_GPH_REASON_WIRELESS_DOWN");
    localHashMap.put(localObject2, "TMP_GPH_REASON_SYSTEM_UPGRADE");
    localObject1 = new HashMap();
    f = (Map)localObject1;
    ((Map)localObject1).put(localByte1, "TMP_GPH_CC_ASSOC_REQ");
    ((Map)localObject1).put(localByte2, "TMP_GPH_CC_ASSOC_ACCEPT");
    ((Map)localObject1).put(localByte3, "TMP_GPH_CC_ASSOC_REFUSE");
    ((Map)localObject1).put(localByte4, "TMP_GPH_CC_HELLO");
    ((Map)localObject1).put(localByte5, "TMP_GPH_CC_DATA_TRANSFER");
    ((Map)localObject1).put(localObject2, "TMP_GPH_CC_BYE");
    localObject2 = new HashMap();
    g = (Map)localObject2;
    ((Map)localObject2).put(Integer.valueOf(0), "ERR_SUCCESS");
    ((Map)localObject2).put(Integer.valueOf(-1), "ERR_COMMON_FAILED");
    ((Map)localObject2).put(Integer.valueOf(64536), "ERR_OPEN_TMPCLIENT_PARAMS_NULL");
    ((Map)localObject2).put(Integer.valueOf(64535), "ERR_INVALID_TRANSPORT_PARAMS_SSH2_SERVER_IP_EMPTY");
    ((Map)localObject2).put(Integer.valueOf(64534), "ERR_INVALID_TRANSPORT_PARAMS_USERNAME_EMPTY");
    ((Map)localObject2).put(Integer.valueOf(64533), "ERR_INVALID_TRANSPORT_PARAMS_PASSWORD_EMPTY");
    ((Map)localObject2).put(Integer.valueOf(64532), "ERR_INVALID_TRANSPORT_PARAMS_HOST_EMPTY");
    ((Map)localObject2).put(Integer.valueOf(64531), "ERR_INVALID_TRANSPORT_PARAMS_DEVICEID_EMPTY");
    ((Map)localObject2).put(Integer.valueOf(64530), "ERR_INVALID_TRANSPORT_PARAMS_BLETRANSPORT_CALLBACK_EMPTY");
    ((Map)localObject2).put(Integer.valueOf(64529), "ERR_INVALID_TRANSPORT_PARAMS_TRANSPORT_TYPE_EMPTY");
    ((Map)localObject2).put(Integer.valueOf(64436), "ERR_INVALID_ALL_PAYLOAD_CHECKSUM");
    ((Map)localObject2).put(Integer.valueOf(64435), "ERR_TRANSACTION_HANDLING");
    ((Map)localObject2).put(Integer.valueOf(64335), "ERR_UNKNOWN_TRANSPORT");
    ((Map)localObject2).put(Integer.valueOf(64334), "ERR_INVALID_TMP_MAIN_VERSION");
    ((Map)localObject2).put(Integer.valueOf(64333), "ERR_INVALID_TMP_SECOND_VERSION");
    ((Map)localObject2).put(Integer.valueOf(64332), "ERR_INVALID_TMP_BYE_NO_RESON");
    ((Map)localObject2).put(Integer.valueOf(64331), "ERR_INVALID_TMP_BYE_UNKNOWN_REASON");
    ((Map)localObject2).put(Integer.valueOf(64330), "ERR_INVALID_TMP_BYE_HEART_BEAT_TIME_OUT");
    ((Map)localObject2).put(Integer.valueOf(64329), "ERR_INVALID_TMP_BYE_CLIENT_LIMIT");
    ((Map)localObject2).put(Integer.valueOf(64328), "ERR_INVALID_TMP_BYE_SYSTEM_REBOOT");
    ((Map)localObject2).put(Integer.valueOf(64327), "ERR_INVALID_TMP_BYE_WIRELESS_DOWN");
    ((Map)localObject2).put(Integer.valueOf(64326), "ERR_INVALID_TMP_BYE_SYSTEM_UPGRADE");
    ((Map)localObject2).put(Integer.valueOf(64325), "ERR_INVALID_TMP_INVALID_CHECKSUM");
    ((Map)localObject2).put(Integer.valueOf(64324), "ERR_INVALID_TMP_INVALID_BUSINESS_TYPE");
    ((Map)localObject2).put(Integer.valueOf(64323), "ERR_INVALID_TMP_INVALID_BUSINESS_VER");
    ((Map)localObject2).put(Integer.valueOf(64322), "ERR_INVALID_TMP_INVALID_BUSINESS_CONFIG_INFO_LACKED");
    ((Map)localObject2).put(Integer.valueOf(64321), "ERR_INVALID_TMP_INVALID_TOTAL_PAYLOAD_LENGTH");
    ((Map)localObject2).put(Integer.valueOf(64320), "ERR_INVALID_TMP_APPV2_TRANSACTION_HANDLER_NULL");
    ((Map)localObject2).put(Integer.valueOf(64319), "ERR_INVALID_TMP_INVALID_APPV2_CONFIG_INFO_LACKED");
    ((Map)localObject2).put(Integer.valueOf(64318), "ERR_INVALID_TMP_GENERAL_CONFIG_VERSION");
    ((Map)localObject2).put(Integer.valueOf(64317), "ERR_INVALID_TMP_GENERAL_CONFIG_PAYLOADLEN");
    ((Map)localObject2).put(Integer.valueOf(64316), "ERR_INVALID_TMP_GENERAL_CONFIG_SN");
    ((Map)localObject2).put(Integer.valueOf(64315), "ERR_INVALID_TMP_GENERAL_CONFIG_CHECKSUM");
    ((Map)localObject2).put(Integer.valueOf(64314), "ERR_TMP_APPV2_BUSINESS_TYPE");
    ((Map)localObject2).put(Integer.valueOf(64313), "ERR_TMP_APPV2_BUSINESS_VERSION");
    ((Map)localObject2).put(Integer.valueOf(64312), "ERR_TMP_APPV2_OPERATION");
    ((Map)localObject2).put(Integer.valueOf(64311), "ERR_TMP_APPV2_FLAGS");
    ((Map)localObject2).put(Integer.valueOf(64310), "ERR_TMP_APPV2_TRANS_ID");
    ((Map)localObject2).put(Integer.valueOf(64309), "ERR_TMP_APPV2_TRANS_CRC32");
    ((Map)localObject2).put(Integer.valueOf(64308), "ERR_TMP_APPV2_TRANS_TOTAL_BYTES");
    ((Map)localObject2).put(Integer.valueOf(64307), "ERR_TMP_APPV2_TRANS_START_BYTE");
    ((Map)localObject2).put(Integer.valueOf(64306), "ERR_TMP_APPV2_TOKEN_EXPIRED");
    ((Map)localObject2).put(Integer.valueOf(64305), "ERR_TMP_APPV2_TOKEN_ALLOC");
    ((Map)localObject2).put(Integer.valueOf(64304), "ERR_TMP_APPV2_BUSINESS_FAILED");
    ((Map)localObject2).put(Integer.valueOf(64303), "ERR_TMP_VER_ASSOC_REFUSE");
    ((Map)localObject2).put(Integer.valueOf(64302), "ERR_TMP_VER_ASSOC_FAIL");
    ((Map)localObject2).put(Integer.valueOf(64301), "ERR_TMP_COMP_ASSOC_FAIL");
    ((Map)localObject2).put(Integer.valueOf(64300), "ERR_TMP_BYE_USER_COUNT_EXCEED");
    ((Map)localObject2).put(Integer.valueOf(64299), "ERR_TMP_BYE_AUTH_CHANGED");
    ((Map)localObject2).put(Integer.valueOf(64298), "ERR_TMP_BYE_KICK_OUT");
    ((Map)localObject2).put(Integer.valueOf(64297), "ERR_TMP_BYE_UNKNOWN");
    ((Map)localObject2).put(Integer.valueOf(64296), "ERR_TMP_BYE_COMPONENT_CHANGED");
    ((Map)localObject2).put(Integer.valueOf(64528), "ERR_NULL_AVAILABLE_TMPCLIENT");
    ((Map)localObject2).put(Integer.valueOf(64527), "ERR_BUSINESSLAYER_NULL");
    ((Map)localObject2).put(Integer.valueOf(64526), "ERR_CMD_COMMAND_CANCEL");
    ((Map)localObject2).put(Integer.valueOf(64525), "ERR_TMPLAYER_NULL");
    ((Map)localObject2).put(Integer.valueOf(64524), "ERR_INVALID_TRANSPORT_PARAMS_BLETRANSPORT_DEVICE_ADDRESS_EMPTY");
    ((Map)localObject2).put(Integer.valueOf(64523), "ERR_CLIENT_MANUAL_CLOSED");
    ((Map)localObject2).put(Integer.valueOf(64236), "ERR_ATA_DISCONNECTED_NETWORK");
    ((Map)localObject2).put(Integer.valueOf(64235), "ERR_ATA_DISCONNECTED_HANDLING");
    ((Map)localObject2).put(Integer.valueOf(64234), "ERR_ATA_DISCONNECTED_RAW_DATA");
    ((Map)localObject2).put(Integer.valueOf(64233), "ERR_ATA_DISCONNECTED_SN");
    ((Map)localObject2).put(Integer.valueOf(64232), "ERR_ATA_DISCONNECTED_CONNECT");
    ((Map)localObject2).put(Integer.valueOf(64231), "ERR_ATA_DISCONNECTED_TOKEN_EXPIRED");
    ((Map)localObject2).put(Integer.valueOf(64126), "ERR_SSH2_AUTH_FAIL");
    ((Map)localObject2).put(Integer.valueOf(64125), "ERR_SSH2_TIMEOUT");
    ((Map)localObject2).put(Integer.valueOf(64124), "ERR_SSH2_EXEC_SCP_FAIL");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\f2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */