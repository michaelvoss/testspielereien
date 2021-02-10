package grafik;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.GlyphVector;
import java.awt.image.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class SimpleAvatarGenerator {
	BufferedImage image = null;
	private String initials;
	private int width;
	private int height;
	private int innerBorder;
	
	public SimpleAvatarGenerator(String initials, int size, int innerBorder) {
		this.initials = initials;
		this.width = size;
		this.height = size;
		this.innerBorder = innerBorder;
		this.createImage();
	}
	
	
	public InputStream getInputStream() {
		ByteArrayOutputStream imagebuffer = new ByteArrayOutputStream();
		try {
			// Write the image to a buffer
			ImageIO.write(this.image, "png", imagebuffer);
		} catch (IOException e) {
			return null;
		}
		return new ByteArrayInputStream(imagebuffer.toByteArray());
	}

	public ByteArrayOutputStream getByteArrayOutputsStream() {
		try {
			ByteArrayOutputStream imagebuffer = new ByteArrayOutputStream();
			ImageIO.write(this.image, "png", imagebuffer);
			return imagebuffer;
		} catch (IOException e) {
			return null;
		}
	}
	
	public byte[] getByteArray() {
		try {
			ByteArrayOutputStream imagebuffer = new ByteArrayOutputStream();
			ImageIO.write(this.image, "png", imagebuffer);
			return imagebuffer.toByteArray();
		} catch (IOException e) {
			return null;
		}
	}
	
	private void createImage() {
		// Create an image
		this.image = new BufferedImage (this.width, this.height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D drawable = this.image.createGraphics();
		int fontSize = 48; // Erstmal initiale Fontsize raten
		Font textFont = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
		FontMetrics fm = drawable.getFontMetrics(textFont);
		GlyphVector vector = textFont.createGlyphVector(fm.getFontRenderContext(), this.initials);
		Shape outline = vector.getOutline(0, 0);
		Rectangle textRect = outline.getBounds();
		double exWidth = textRect.getWidth();
		double exHeight = textRect.getHeight();
		boolean fits = (((this.width - this.innerBorder) > exWidth) && ((this.height - this.innerBorder ) > exHeight));
		if (!fits) {
			double newSizeOnWidth = (textFont.getSize2D() * (this.width - this.innerBorder)) / exWidth;
			double newSizeOnHeight = (textFont.getSize2D() * (this.height - this.innerBorder)) / exHeight;
			double newFontSize = newSizeOnHeight < newSizeOnWidth ? newSizeOnHeight : newSizeOnWidth;
			textFont = textFont.deriveFont(textFont.getStyle(), (float)newFontSize);
			fm = drawable.getFontMetrics(textFont);
			vector = textFont.createGlyphVector(fm.getFontRenderContext(), this.initials);
			outline = vector.getOutline(0, 0);
			textRect = outline.getBounds();
		}
		// Hintergrund füllen
		drawable.setStroke(new BasicStroke(5));
		drawable.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		
		drawable.setColor(Color.LIGHT_GRAY);
		drawable.fillRect(0, 0, this.width, this.height);
		
		// Text darüberlegen
		drawable.setColor(Color.WHITE);
		drawable.setFont(textFont);
		int x = (this.width - textRect.width) / 2;
		
		System.out.println("Rect height = " + this.height);
		System.out.println("Text height = " + textRect.height);
		
		int y = (this.height + textRect.height) / 2;
		
		System.out.println("Position = " + y);
		
		// int x = ((this.width - fm.stringWidth(this.initials)) / 2);
		// int y = (((this.height - fm.getHeight()) / 2) + fm.getAscent());
		drawable.drawString(this.initials, x, y);
	}
}
