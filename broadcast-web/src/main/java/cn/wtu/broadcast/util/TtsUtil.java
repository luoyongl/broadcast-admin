package cn.wtu.broadcast.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;

import cn.wtu.broadcast.openapi.api.SystemConfigurationService;
import cn.wtu.broadcast.openapi.model.TSystemConfiguration;
import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;


/**
 * Created on 2019/1/13 11:43
 *
 * @author LY
 */
@Component
public class TtsUtil implements InitializingBean {

    private static ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    private static SystemConfigurationService systemConfigurationService;

    private static  String APP_ID = "";

    private static  String API_KEY = "";

    private static  String SECRET_KEY = "";

    @SuppressWarnings("static-access")
	@Autowired
    public TtsUtil(SystemConfigurationService systemConfigurationService){
        this.systemConfigurationService=systemConfigurationService;
    }


    public static void update(){
        List<TSystemConfiguration> list = systemConfigurationService.selectList();
        list.forEach(tSystemConfiguration -> {
            String value = tSystemConfiguration.getfConfigurationValue();
            //ConcurrentHashMap value不能为空
            map.put(tSystemConfiguration.getfConfigurationName(), value == null ? "" : value);
        });
        APP_ID=map.get("baidu_tts_appid");
        API_KEY=map.get("baidu_tts_apikey");
        SECRET_KEY=map.get("baidu_tts_secretkey");
    }

    public static String get(String configName) {
        return map.get(configName);
    }


    /**
     * 文本转语音
     *
     * @param text     输入的String字符串，
     * @param filePath mp3存放的位置
     * @return 返回mp3文件存放地址
     */
    public static String toTTS(String text, String filePath) {
        System.out.println(APP_ID);
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        //client.setConnectionTimeoutInMillis(2000);
        //client.setSocketTimeoutInMillis(60000);

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        /**
         * tex	String	合成的文本，使用UTF-8编码，请注意文本长度必须小于1024字节	是
         * cuid	String	用户唯一标识，用来区分用户，填写机器 MAC 地址或 IMEI 码，长度为60以内	否
         * spd	String	语速，取值0-9，默认为5中语速	否
         * pit	String	音调，取值0-9，默认为5中语调	否
         * vol	String	音量，取值0-15，默认为5中音量	否
         * per	String	发音人选择, 0为女声，1为男声，
         * 3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女
         HashMap<String, Object> options = new HashMap<String, Object>();
         options.put("spd", "5");
         options.put("pit", "5");
         options.put("per", "4");
         TtsResponse res = client.synthesis(text, "zh", 1, options);
         **/

        TtsResponse res = client.synthesis(text, "zh", 1, null);

        //生成的音频数据
        byte[] data = res.getData();

        //服务器返回的内容，合成成功时为null,失败时包含error_no等信息
        JSONObject res1 = res.getResult();
        if (data != null) {
            String filename = UUID.randomUUID().toString() + ".mp3";
            String filename1 = UUID.randomUUID().toString() + ".mp3";
            getFile(data, filePath,filename,filename1);
            return filename1;
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
            return "";
        }
        return "";
    }

    /**
     * byte[] 转成文件
     *
     * @param bfile    byte[]数据
     * @param filePath 文件路径
     * @param fileName 文件名称
     */
    public static void getFile(byte[] bfile, String filePath, String fileName,String fileName1) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file=null;
        File file1=null;
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {//判断文件目录是否存在
                dir.mkdirs();
            }//原来为 "\\"
             file = new File(filePath + File.separator + fileName);
             file1 = new File(filePath + File.separator + fileName1);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                    changeBitRate(file, file1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

    public static void saveFile(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file=null;
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {//判断文件目录是否存在
                dir.mkdirs();
            }//原来为 "\\"
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }


   public static void changeBitRate(File file,File file1){
       MultimediaObject multimediaObject = new MultimediaObject(file);
       Encoder encoder = new Encoder();
       EncodingAttributes encodingAttributes=new EncodingAttributes();
       encodingAttributes.setFormat("mp3");
       AudioAttributes audioAttributes=new AudioAttributes();
       audioAttributes.setBitRate(128000);
       encodingAttributes.setAudioAttributes(audioAttributes);
       try {
           encoder.encode(multimediaObject,file1,encodingAttributes);
       } catch (EncoderException e) {
           e.printStackTrace();
       }
       file.delete();
   }

    @Override
    public void afterPropertiesSet() throws Exception {
        update();
    }
}

