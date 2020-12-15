package com.demo.contact.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;

@SuppressWarnings("restriction")
public class ContactUtils {
	public static BufferedImage decodeToImage(String imageString) {
		BufferedImage image = null;
		byte[] imageByte;
		try {
			Base64.Decoder decoder = Base64.getDecoder();
			imageByte = decoder.decode(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

	public static boolean saveImageToServer(BufferedImage image, String fileName) {
		if (image != null) {
			try {
				File file = new File(
						ContactConstants.IMAGES_PATH + fileName + ContactConstants.PROFILE_PICTURE_EXTENSION);

				return ImageIO.write(image, "png", file);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public static InputStream getProfilePicture(Long contactId) {
		InputStream is = null;
		try {
			File theFile = new File(ContactConstants.IMAGES_PATH);
			theFile.mkdirs();
			String logoName = contactId + ContactConstants.PROFILE_PICTURE_EXTENSION;
			is = new FileInputStream(ContactConstants.IMAGES_PATH + logoName);
		} catch (Exception e) {
			e.printStackTrace();
			is = null;
		}
		if (is == null) {
			System.out.println("image NotFound");
			try {
				is = ContactUtils.class.getClassLoader().getResourceAsStream("default.jpg");
			} catch (Exception e) {
				e.printStackTrace();
				is = null;
			}
		}
		return is;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
