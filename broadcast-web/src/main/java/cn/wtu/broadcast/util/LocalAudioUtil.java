package cn.wtu.broadcast.util;

import cn.wtu.broadcast.openapi.api.AudioManageService;
import cn.wtu.broadcast.openapi.model.BAudioData;
import cn.wtu.broadcast.parent.enums.UploadUrlEnum;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ws.schild.jave.MultimediaObject;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created on 2019/4/4 18:08
 *本地音源操作
 * @author LY
 */
public class LocalAudioUtil {

    public static BAudioData localaudio(CommonsMultipartFile localAudio,
                                        HttpServletRequest request,
                                        String uploadPrefixUrl,
                                        AudioManageService audioManageService ){

        //本地音源操作
        BAudioData bAudioData = new BAudioData();
        if (localAudio.getSize()> 0){
            bAudioData.setfAudioName(localAudio.getOriginalFilename());
            DiskFileItem diskFileItem = (DiskFileItem)localAudio.getFileItem();
            File source = diskFileItem.getStoreLocation();
            bAudioData.setfAudioSize(String.valueOf(source.length()));
            MultimediaObject multimediaObject = new MultimediaObject(source);
            try {
                bAudioData.setfBitRate(multimediaObject.getInfo().getAudio().getBitRate());
                bAudioData.setfSampleRate(BigDecimal.valueOf(multimediaObject.getInfo().getAudio().getSamplingRate()));
            }catch (Exception e){
                //
            }
            Date date = new Date();
            bAudioData.setfCreateTime(date);
            bAudioData.setfUpdateTime(date);
            bAudioData.setfDeleteFlag(false);
            String programPath = UploadUrlEnum.getEnumByCode("3").getDesc()+ File.separator + UUID.randomUUID().toString() + ".mp3";
            String localAudioUrl = request.getSession().getServletContext().getRealPath("/") +  programPath;
            String returnUrl = uploadPrefixUrl  + programPath;
            List<BAudioData> list=audioManageService.checkAudioname(localAudio.getOriginalFilename());
            System.out.println("====================>"+list);
            if (list.size()>0){
                bAudioData.setfAudioUrl(list.get(0).getfAudioUrl());
            }else {
                bAudioData.setfAudioUrl(returnUrl);
                try {
                    FileUtils.copyInputStreamToFile(localAudio.getInputStream(),new File(localAudioUrl));
                    //添加一条音频信息
                    audioManageService.uploadFile(bAudioData);
                } catch (Exception e) {
                    //TOOD
                }
            }
        }
        return bAudioData;
    }
}

