package davi.Mandelbrot;


//import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Mandelbrot extends Thread{

	private int Width;
	private int Height;
	private double xStart;
	private double xEnd;
	private double yStart;
	private double yEnd;
	private String name;
	private int iteration;
	private double magnitude;
	
	public Mandelbrot(int Width, int Height, double xStart, double xEnd, double yStart, double yEnd, String name, int iteration, double magnitude){
		this.Width = Width;
		this.Height = Height;
		this.xStart = xStart;
		this.xEnd = xEnd;
		this.yStart = yStart;
		this.yEnd = yEnd;
		this.name = name;
		this.iteration = iteration;
		this.magnitude = magnitude;
	}
	
	public void run()
	{
		writeImage();
	}
	
	
	public void Gewichtungsfunktion(){
		
	}
	
	public static int[] calcHistogram(int[] data, double min, double max, int numBins) {
	  final int[] result = new int[numBins];
	  final double binSize = (max - min)/numBins;

	  for (int d : data) {
	    int bin = (int) ((d - min) / binSize);
	    if (bin < 0) { /* this data is smaller than min */ }
	    else if (bin >= numBins) { /* this data point is bigger than max */ }
	    else {
	      result[bin] += 1;
	    }
	  }
	  return result;
	}
	

	public void writeImage()
	{
		System.out.println(name);
	    // retrieve image
		BufferedImage bufferedImage = mandelbrot(); // This is the function where the mandelbrotset is calculated
		
		File outputfile = new File(name);
		int count=0;
		
		try 
		{
			ImageIO.write(bufferedImage, "png", outputfile);
			} catch (IOException e) {
			System.out.println(" fail ");
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
	}
	
	private static int calculateVersatz(double xStart, int VersatzZentrum)
	{	
		if(xStart < 0 && VersatzZentrum < 0){
			VersatzZentrum *=-1;
		}
		else if(xStart > 0 && VersatzZentrum > 0){
			VersatzZentrum*=-1;
		}
		return VersatzZentrum;
	}
	
	public BufferedImage mandelbrot(){
		
		int[] data = new int[(Width*Height)+1]; 
		int count = 0;
		
		int max=0;
		int min=0;

		Complex z0 = new Complex(0,0); //  Anfangsglied
		Complex zn = new Complex();
		Complex c = new Complex(-0.4, 0.7);
		int iterator = 0;
		
		zn=z0;
		
		// Berechnung vom Bildausschnitt
		double xZwischenraum = Math.abs(xStart - xEnd);
		double yZwischenraum = Math.abs(yStart - yEnd);
		
		// Berechung Schrittweite
		double xSchrittweite = xZwischenraum/(double)Width;
		double ySchrittweite = yZwischenraum/(double)Height;
		
		// Berechnung des Versatztes zum Mittelpunkt
		int VersatzZentrumX = (int)((Math.abs(xStart))/xSchrittweite);
		int VersatzZentrumY = (int)((Math.abs(yStart))/ySchrittweite);
		
		VersatzZentrumX = calculateVersatz(xStart, VersatzZentrumX);
		VersatzZentrumY = calculateVersatz(yStart, VersatzZentrumY);
		
		BufferedImage bufferedImage = new BufferedImage(Width,Height,BufferedImage.TYPE_INT_RGB);
		
		for(double y = yStart; y <= yEnd; y += ySchrittweite){
			for(double x = xStart; x <= xEnd; x += xSchrittweite){
		
				c.setReal(x);
				c.setImag(y);
				do{
					zn = zn.mult(zn, zn);
					zn = zn.add(zn, c);
					iterator++;
				}while((zn.magnitude() < magnitude) && iterator < iteration);
				
				
				// calculate maximum
				if(iterator > max){
					max = iterator;
				}
				if(iterator < min)
				{
					min = iterator;
				}
				//data[count]=iterator;
				count++;
				
				//Versatz ins Zentrum!!				
				double pX = (Math.abs((1.0f/xSchrittweite)) * x)+VersatzZentrumX;
				double pY = (Math.abs((1.0f/ySchrittweite)) * y)+VersatzZentrumY;
				
				// Iterator nimmt werte wischen 0 und 500 an
				Color color = new Color(iterator);
				//color = Color.getHSBColor((((float)iterator/((float)16.6666))+210)/360f, 0.85f, 1.0f);
				color = Color.getHSBColor(((float)iterator/360f), 0.85f, 1.0f);
				//color = Color.getHSBColor((((float)iterator/((float)2.7777))+300.0f)/360f, 0.8f, 1.0f);
				
				try{
					bufferedImage.setRGB((int)pX, (int)pY, color.getRGB());
				}
				catch(Exception e) // Out of bounds
				{
					System.out.println("x: " +x +" y: " + y + " pX: "+ (int)pX + " pY: " + (int)pY + " Schrittweite: " + xSchrittweite + "    " + 1.0f/xSchrittweite * x);
				}
				zn = z0;
				iterator = 0;
			}
			
		}
		int numberBins=100;
		int histogramm[] = calcHistogram(data, min, max, numberBins);
		/*
		for(int i=0;i<numberBins;++i)
		{
			System.out.println("Stelle: " + (max/numberBins)*i + " Histogrammwert: " + histogramm[i]);
		}
		*/
		System.out.println("min: "+min+"\nmax: "+max);
		
		return bufferedImage;
	}
	
	public static void main(String[] args) {
		
		long lStartTime = System.currentTimeMillis();

		for(int i=19; i< 20;i++){
			Mandelbrot mn = new Mandelbrot(5000,2812,-1.6,-0.0,-0.7,0.2,"test"+i+".png", 70,2.5);
			//Mandelbrot mn = new Mandelbrot(5000,2812,-1.6,-0.0,-0.7,0.2,"test"+i+".png", 700,2.5);
			mn.writeImage();
		}	
		
		long lEndTime = System.currentTimeMillis();

		long difference = lEndTime - lStartTime;

		System.out.println("Elapsed in seconds: " + difference/1000);
		
		
	}
}
