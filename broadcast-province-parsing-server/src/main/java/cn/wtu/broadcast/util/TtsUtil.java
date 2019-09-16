package cn.wtu.broadcast.util;

import java.io.File;

import org.springframework.stereotype.Component;

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
public class TtsUtil {
	public static void changeBitRate(File file, File file1) {
		MultimediaObject multimediaObject = new MultimediaObject(file);
		Encoder encoder = new Encoder();
		EncodingAttributes encodingAttributes = new EncodingAttributes();
		encodingAttributes.setFormat("mp3");
		AudioAttributes audioAttributes = new AudioAttributes();
		audioAttributes.setBitRate(128000);
		encodingAttributes.setAudioAttributes(audioAttributes);
		try {
			encoder.encode(multimediaObject, file1, encodingAttributes);
		} catch (EncoderException e) {
			e.printStackTrace();
		}
		file.delete();
	}

}
