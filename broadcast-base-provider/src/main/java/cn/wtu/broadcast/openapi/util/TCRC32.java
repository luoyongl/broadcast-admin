package cn.wtu.broadcast.openapi.util;

/**
 * @description:
 * @author: AYY
 * @date: 2019-02-15 19:54
 */
public class TCRC32 {

    private static final int CN = 0x04C11DB7;

    private static int[] ptiTable = new int[256];

    static {
        build(CN);
    }

    private static void build(int cn) {
        int nData = 0;
        int nAccum = 0;

        for (int i = 0; i < 256; i++) {
            nData = i << 24;
            nAccum = 0;
            for (int j = 0; j < 8; j++) {
                if (0 != ((nData ^ nAccum) & 0x80000000)) {
                    nAccum = (nAccum << 1) ^ cn;
                } else {
                    nAccum <<= 1;
                }
                nData <<= 1;
            }
            ptiTable[i] = nAccum;
        }
    }

/*    public static int calculate(byte[] datas) {
        int crc32 = 0xFFFFFFFF;

        if (null == datas || datas.length < 1) {
            return crc32;
        }

        for (byte data : datas) {
            crc32 = (crc32 << 8) ^ ptiTable[(crc32 >>> 24) ^ (data & 0xFF)];
        }

        return crc32;
    }*/
    
    public static int crc_Calculate(byte[] data, int StartIndex, int length) {
        int[] ptiTable = new int[256];
        int nData = 0, CRCPloy = 0x04C11DB7;
        int nAccum = 0;

        for (int i = 0; i < 256; i++) {
            nData = i << 24;
            nAccum = 0;
            for (int j = 0; j < 8; j++) {
                if (0 != ((nData ^ nAccum) & 0x80000000)) {
                    nAccum = (nAccum << 1) ^ CRCPloy;
                } else {
                    nAccum <<= 1;
                }
                nData <<= 1;
            }
            ptiTable[i] = nAccum;
        }
        int crc32 = 0xFFFFFFFF;
        int byteCount = 0;
        while (byteCount < length) {
            crc32 = (crc32 << 8) ^ ptiTable[(crc32 >>> 24) ^ (data[StartIndex + byteCount] & 0xFF)];
            byteCount++;
        }

        return crc32;

    }
}