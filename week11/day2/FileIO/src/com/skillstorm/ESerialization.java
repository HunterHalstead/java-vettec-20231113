package com.skillstorm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ESerialization {

	private static final File path = new File("src/com/skillstorm/resources/");

	public static void main(String[] args) {
		/*
		 * Serialization is turning a Java object into a sequence of bytes that can be
		 * stored in a file
		 * 
		 * java.io provides serialization functionality - ObjectInputStream -- decorator
		 * pattern (can wrap any InputStream ex: BufferedInputStream, FileinputStream) -
		 * ObjectOutputStream
		 * 
		 * .data or .dat is the file type we will be writing/reading from
		 * 
		 * java.io.Serializable interface - no methods in interface - each Serializable
		 * class will have a serialVersionUID (whenever the class is refactored update
		 * the id)
		 */
//		writeObjects();
	}

	public static List<Cereal> readAll() {
		// Recommended way to loop through objects in file
		// is go till EODException
		// Warning: Do not use .isAvailable() == 0 might stop preemptively
		List<Cereal> cereals = new ArrayList<>();
		try (FileInputStream fin = new FileInputStream(new File(path, "cereal.data"));
				BufferedInputStream bin = new BufferedInputStream(fin);
				ObjectInputStream in = new ObjectInputStream(bin)) {

			while (true) {
				try {
					Object obj = in.readObject();
					if (obj instanceof Cereal) {
						Cereal cereal = (Cereal) obj;
						cereals.add(cereal);
					}
				} catch (EOFException e) {
					// End of file reached
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cereals;
	}

	public static void readObjects() {
		try (FileInputStream fin = new FileInputStream(new File(path, "cereal.data"));
				BufferedInputStream bin = new BufferedInputStream(fin);
				ObjectInputStream in = new ObjectInputStream(bin)) {

			Object obj = in.readObject();
			Object obj2 = in.readObject();
//			Object obj3 = in.readObject(); // EOF exception

			System.out.println(obj.toString());
			System.out.println(obj2.toString());
//			System.out.println(obj3.toString());

			System.out.println("Cereal count: " + Cereal.getCount());
//			if (obj instanceof Cereal) {
//				Cereal c = (Cereal) obj;
//				System.out.println(c);
//			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeObjects() {
		try (FileOutputStream fout = new FileOutputStream(new File(path, "cereal.data"));
				BufferedOutputStream bos = new BufferedOutputStream(fout);
				ObjectOutputStream out = new ObjectOutputStream(bos)) {

			Cereal fruitLoops = new Cereal("fruit loops", false);
			System.out.println(fruitLoops);
			Cereal honeyOatCrunch = new Cereal("Honey Oat Crunch", true);
			System.out.println(honeyOatCrunch);
			System.out.println("Cereal count " + Cereal.getCount());
			out.writeObject(fruitLoops);
			out.writeObject(honeyOatCrunch);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Cereal implements Serializable {

	private static int count = 0; // static properties are not serialized

	private String name;

	private transient boolean stale; // transient properties are not serialized

	private static final long serialVersionUID = 1L; // default
	// If you change this between write-read you get java.io.InvalidClassException
//	private static final long serialVersionUID = 268319651332723092L;

	public Cereal(String name, boolean stale) {
		super();
		count++;
		this.name = name;
		this.stale = stale;
	}

	@Override
	public String toString() {
		return "Cereal [name=" + name + ", stale=" + stale + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStale() {
		return stale;
	}

	public void setStale(boolean stale) {
		this.stale = stale;
	}

	public static int getCount() {
		return count;
	}

}
