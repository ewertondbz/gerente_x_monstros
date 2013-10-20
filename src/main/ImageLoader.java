package main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static Image load(InputStream resource) {
		Image image = null;
		try {
			image = ImageIO.read(resource);
			ImageFilter filter = new RGBImageFilter() {
				@Override
				public int filterRGB(int x, int y, int rgb) {
					return rgb == 0xFF209C00 ? 0x00000000 : rgb;
				}
			};
			ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
			return Toolkit.getDefaultToolkit().createImage(ip);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
