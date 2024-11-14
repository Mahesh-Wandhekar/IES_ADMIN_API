package com.nt.Utility;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncodePwdDecodePwd {

    public static String encode(String str) {
        Encoder encoder = Base64.getEncoder();
        byte[] emsg = encoder.encode(str.getBytes());
        return new String(emsg); // Convert byte array to string correctly
    }

    public static String decode(String str) {
        Decoder decoder = Base64.getDecoder();
        byte[] emsg = decoder.decode(str.getBytes());
        return new String(emsg); // Convert byte array to string correctly
    }
}
