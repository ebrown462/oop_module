package part02;

import part01.AudioFile;

public class AudioFileTesting {
	public static void main(String[] args) {
		testCase1();
		System.out.println();
		testCase2();
		System.out.println();
		testCase3();
		System.out.println();
		testCase4();
		System.out.println();
		testCase5();
		System.out.println();
		testCase6();
	}

	private static void testCase1() {
		System.out.println("TC1 - Successful Construction using Good Data");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		String title = "Hit The Diff";
		int duration = 60;
		String dataSource = "sound//HTD.wav";
		int playCount = 0;
		try {
			AudioFile af1 = new AudioFile(title, duration, dataSource);
			System.out.println("Construction of audioFile Suceeded, (toString)data below:");
			System.out.println(af1.toString());
			System.out.println("Title should be: " + title);
			System.out.println("Duration should be: " + duration);
			System.out.println("DataSource should be: " + dataSource);
			System.out.println("Play count should be:" + playCount);
		} catch (Exception ex) {
			System.out.println("Exception - Construction of object rejected.");
		}
		System.out.println("+++++++++++++++++END TC1+++++++++++++++++++++");
	}

	private static void testCase2() {
		System.out.println("TC2 - Failed Construction using bad title & duration");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String defaultTitle = " default title ";
		String title = "";
		int duration = 0;
		String dataSource = "sound//HTD2.wav";
		int playCount = 0;
		try {
			AudioFile af1 = new AudioFile(title, duration, dataSource);
			System.out.println("Construction of AudioFile Suceeded, (toString)data below:");
			System.out.println(af1);
			System.out.println();
			System.out.println("Title should be: blank");
			System.out.println("Duration should be 0");
			System.out.println("dataSource should be: " + dataSource);
			System.out.println("playCount should be: " + playCount);
			System.out.println();
		} catch (Exception ex) {
			System.out.println("Exception - Construction of object rejected.");
		}
		System.out.println("+++++++++++++++++END TC2+++++++++++++++++++++++++++++");
	}

	private static void testCase3() {
		System.out.println("TC3 - Successful toString using Good Data");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		String title = "Hit The Diff";
		int duration = 60;
		String dataSource = "sound//HTD.wav";
		int playCount = 0;
		try {
			AudioFile af1 = new AudioFile(title, duration, dataSource);
			System.out.println(af1.toString());
			System.out.println("Title should be: " + title);
			System.out.println("Duration should be: " + duration);
			System.out.println("DataSource should be: " + dataSource);
			System.out.println("Play count should be:  " + playCount);
		} catch (Exception ex) {
			System.out.println("Exception - toString failed.");
		}
		System.out.println("+++++++++++++++++END TC3+++++++++++++++++++++");
	}
	
	private static void testCase4() {
		System.out.println("TC4 - Successful execution of the registerPlay function");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		String title = "Hit The Diff";
		int duration = 60;
		String dataSource = "sound//HTD.wav";
		try {
			AudioFile af1 = new AudioFile(title, duration, dataSource);
			System.out.println("playCount before running function: " + af1.getPlayCount());
			af1.registerPlay();
			System.out.println("(Function executed)");
			System.out.println("playCount after running function: " + af1.getPlayCount());
			System.out.println("playCount should be: 1");
			
		} catch (Exception ex) {
			System.out.println("Exception - registerPlay function failed.");
		}
		System.out.println("+++++++++++++++++END TC4+++++++++++++++++++++");
	}
	
	private static void testCase5() {
		System.out.println("TC5 - Successful execution of the registerPlay function for different objects");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		String title1 = "Hit The Diff";
		int duration1 = 60;
		String dataSource1 = "sound//HTD.wav";
		String title2 = "Slip the Clutch";
		int duration2 = 61;
		String dataSource2 = "sound//STC.wav";
		try {
			AudioFile af1 = new AudioFile(title1, duration1, dataSource1);
			AudioFile af2 = new AudioFile(title2, duration2, dataSource2);
			System.out.println("playCount before running function for object 1: " + af1.getPlayCount());
			System.out.println("playCount before running function for object 2: " + af2.getPlayCount());
			af1.registerPlay();
			System.out.println("(Function executed)");
			System.out.println("playCount after running function for object 1: " + af1.getPlayCount());
			System.out.println("playCount after running function for object 2: " + af2.getPlayCount());
			System.out.println("playCount for object 1 should be 1, and playCount for object 2 should remain 0");
			
		} catch (Exception ex) {
			System.out.println("Exception - registerPlay function failed.");
		}
		System.out.println("+++++++++++++++++END TC5+++++++++++++++++++++");
	}
	
	private static void testCase6() {
		System.out.println("TC6 - Successful execution of the registerPlay function for different objects");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		String title1 = "Hit The Diff";
		int duration1 = 60;
		String dataSource1 = "sound//HTD.wav";
		String title2 = "Slip the Clutch";
		int duration2 = 61;
		String dataSource2 = "sound//STC.wav";
		try {
			AudioFile af1 = new AudioFile(title1, duration1, dataSource1);
			AudioFile af2 = new AudioFile(title2, duration2, dataSource2);
			System.out.println("Code for Audio File 1: " + af1.getCode());
			System.out.println("Code for Audio File 2: " + af2.getCode());
			System.out.println();
			System.out.println("If all test functions are run at once, code for af1 should be 7, and code for af2 should be 8");
			System.out.println("If just test 6 is ran, code for af1 should be 1, and code for af2 should be 2");
			
		} catch (Exception ex) {
			System.out.println("Exception - registerPlay function failed.");
		}
		System.out.println("+++++++++++++++++END TC6+++++++++++++++++++++");
	}
}
