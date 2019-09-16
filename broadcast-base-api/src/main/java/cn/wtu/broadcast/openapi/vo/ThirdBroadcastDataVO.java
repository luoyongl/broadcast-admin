package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unused")
public class ThirdBroadcastDataVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /**
     * 8bits
     */
	private final byte tableID = (byte) 0xFD;

    /**
     * 1bit
     */
    private final byte sectionSyntaxIndicator = 1;

    /**
     * 1bit
     */
    private final byte zero = 0;

    /**
     * 2bits
     */
    private final byte reserverd1 = 0x01;

    /**
     * 12bits
     */
    private short sectionLength;

    private short table_id_extension = 0;

    private byte reserved2 = 0x03;

    public byte versionnumber;

    private byte current_next_indicator = 1;

    public byte section_number;

    public byte last_section_number;

    private byte reserved3 = (byte)0xff;

    private byte EBM_number = 0;
    public ArrayList<EBMInfo> ebminfos=new ArrayList<EBMInfo>();
    private short signature_length = 0;

    //public ArrayList<Signature_Data> signatures=new ArrayList<Signature_Data>();
    private int crc32;
    
    
    public static class EBMInfo {

        private short EBM_length;
        private byte[] EBM_id;
        public short EBM_original_network_id = 1;
        public Date EBM_start_time;//MJDDateTime
        public Date EBM_end_time;//MJDDateTime
        public String EBM_type;
        
        public byte EBM_class;
        public byte EBM_level;
        private byte EBM_resource_number = 0;
        private ArrayList<byte[]> EBM_resource_codes;
        private byte reserved1 = 0x7f;
        public byte details_channel_indicate = 1;

        public short details_channel_transport_stream_id = 1;
        public short details_channel_program_number;
        private byte reserved2 = 0x07;
        public short details_channel_PCR_PID;
        private byte reserved3 = 0x0f;
        private short details_channel_program_info_length;
        

        private short stream_info_length;

        public ArrayList<StreamInfo> streams=new  ArrayList<StreamInfo>();
        
        public static class StreamInfo {

            public byte stream_type = 3;
            private byte reserved = 0x5;
            public short elementary_PID;
            private byte reserved1 = 0x0f;
            private short ES_info_length;
        }
    }
}
