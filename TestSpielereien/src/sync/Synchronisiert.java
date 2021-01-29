package sync;

import org.junit.jupiter.api.Test;

public class Synchronisiert {
	private static boolean istBesetzt = false;
	private static Object besetztLock = new Object();
	
	private static int a = 2;
	
	public void conflictMethod(int number) {
		System.out.println("a = " + Synchronisiert.a + " (" + number + ")");
		synchronized (Synchronisiert.besetztLock) {
			while (Synchronisiert.istBesetzt) {
				System.out.println("Ist (noch) besetzt (" + number + ")");
				//			synchronized (Synchronisiert.besetztLock) {
				try {
					Synchronisiert.besetztLock.wait();
				} catch (InterruptedException e) {
					System.out.println("Warten unterbrochen (" + number + ")");
				}

				System.out.println("Fertig, jetzt bin ich dran (" + number + ")");
				return;
				//			}

			}

			if (Synchronisiert.a == 1) {
				//			synchronized (Synchronisiert.besetztLock) {
				Synchronisiert.istBesetzt = true;
				System.out.println("gefunden (" + number + ")");
				try {
					for (int i = 1; i <= 10; i++) {
						System.out.println("Warte 1 sek. (" + number + ")");
						Thread.sleep(1000);
						System.out.println("Noch " + (10 - i) + " mal warten (" + number + ")");
					}
				} catch (InterruptedException e) {
					System.out.println("Thread.sleep unterbrochen (" + number + ")");
				}
				System.out.println("Warten beendet (" + number + ")");
				// Synchronisiert.a = Synchronisiert.a + 1;
				Synchronisiert.istBesetzt = false;
				Synchronisiert.besetztLock.notifyAll();
				//			}
			}
		}
	}
	
	@Test
	public void test1() {
		Runnable one = () -> {
			System.out.println("Task 1");
			this.conflictMethod(1);
		};
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Aufruf-Warten unterbrochen");
		}
		
		Runnable two = () -> {
			System.out.println("Task 2");
			this.conflictMethod(2);			
		};
		
		Thread eins = new Thread(one);
		Synchronisiert.a = 1;
		System.out.println("Starte Task 1");
		eins.start();

		Thread zwei = new Thread(two);
		System.out.println("Starte Task 2");
		zwei.start();
		
	}
}
