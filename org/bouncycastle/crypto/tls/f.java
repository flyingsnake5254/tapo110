package org.bouncycastle.crypto.tls;

public class f
{
  public static String a(short paramShort)
  {
    if (paramShort != 0)
    {
      if (paramShort != 10)
      {
        if (paramShort != 30)
        {
          if (paramShort != 60)
          {
            if (paramShort != 80)
            {
              if (paramShort != 86)
              {
                if (paramShort != 90)
                {
                  if (paramShort != 100)
                  {
                    if (paramShort != 70)
                    {
                      if (paramShort != 71)
                      {
                        switch (paramShort)
                        {
                        default: 
                          switch (paramShort)
                          {
                          default: 
                            switch (paramShort)
                            {
                            default: 
                              return "UNKNOWN";
                            case 115: 
                              return "unknown_psk_identity";
                            case 114: 
                              return "bad_certificate_hash_value";
                            case 113: 
                              return "bad_certificate_status_response";
                            case 112: 
                              return "unrecognized_name";
                            case 111: 
                              return "certificate_unobtainable";
                            }
                            return "unsupported_extension";
                          case 51: 
                            return "decrypt_error";
                          case 50: 
                            return "decode_error";
                          case 49: 
                            return "access_denied";
                          case 48: 
                            return "unknown_ca";
                          case 47: 
                            return "illegal_parameter";
                          case 46: 
                            return "certificate_unknown";
                          case 45: 
                            return "certificate_expired";
                          case 44: 
                            return "certificate_revoked";
                          case 43: 
                            return "unsupported_certificate";
                          case 42: 
                            return "bad_certificate";
                          case 41: 
                            return "no_certificate";
                          }
                          return "handshake_failure";
                        case 22: 
                          return "record_overflow";
                        case 21: 
                          return "decryption_failed";
                        }
                        return "bad_record_mac";
                      }
                      return "insufficient_security";
                    }
                    return "protocol_version";
                  }
                  return "no_renegotiation";
                }
                return "user_canceled";
              }
              return "inappropriate_fallback";
            }
            return "internal_error";
          }
          return "export_restriction";
        }
        return "decompression_failure";
      }
      return "unexpected_message";
    }
    return "close_notify";
  }
  
  public static String b(short paramShort)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramShort));
    localStringBuilder.append("(");
    localStringBuilder.append(paramShort);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */