package part02;
import part01.AudioFile;
import part01.AudioManager;


public class AudioManagerTesting {
	
	public static AudioManager am = new AudioManager();
	
	public static void main(String[] args) {
		System.out.println("*WARNING* MOST OF THESE TESTS WILL ONLY WORK WHEN RAN ON THEIR OWN");
		System.out.println();
		//testCase1();
		//testCase2();
		//testCase3();
		//testCase4();
		//testCase5();
		//testCase6();
		//testCase7();
	}
	
	public static void testCase1() {
		System.out.println("TC1 - Successful use of the loadAudio function");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		try {
			String title = "Hit The Diff";
			int duration = 60;
			String dataSource = "sound//HTD.wav";
			int playCount = 0;
			AudioFile temp = new AudioFile(title, duration, dataSource);
			am.loadAudio(temp);
			System.out.println(temp.toString());
			System.out.println();
			System.out.println("Title should be: " + title);
			System.out.println("Duration should be: " + duration);
			System.out.println("DataSource should be: " + dataSource);
			System.out.println("Play count should be:" + playCount + "\n");
		} catch (Exception ex) {
			System.out.println("Exception - loadAudio function executed successfully");
		}
		System.out.println("+++++++++++++++++END TC1+++++++++++++++++++++");
	}
	
	public static void testCase2() {
		System.out.println("\nTC2 - Successful use of deleteAudio function");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		try {
			String title = "Hit The Diff";
			int duration = 60;
			String dataSource = "sound//HTD.wav";;
			int delCode = 1;
			AudioFile temp = new AudioFile(title, duration, dataSource);
			am.loadAudio(temp);
			System.out.println("BEFORE RUNNING DELETE FUNCTION");
			System.out.println(temp.toString());
			System.out.println();
			System.out.println("AFTER RUNNING DELETE FUNCTION");
			am.deleteAudio(delCode);
			System.out.println("If the test worked, no data about AudioFile should be displayed here");
		} catch (Exception ex) {
			System.out.println("Exception - Removal of AudioFile has failed");
		}
		System.out.println("+++++++++++++++++END TC2+++++++++++++++++++++");
	}
	
	public static void testCase3() {
		System.out.println("\nTC3 - Unsuccessful use of deleteAudio function (should display error message)");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		try {
			String title = "Hit The Diff";
			int duration = 60;
			String dataSource = "sound//HTD.wav";;
			int delCode = 99;
			AudioFile temp = new AudioFile(title, duration, dataSource);
			am.deleteAudio(delCode);
			System.out.println();
			System.out.println("If the test worked, an error message should appear above");
			// if delete function works the below code shouldn't run as there's nothing to display, and the error message should appear
		} catch (Exception ex) {
			System.out.println("Exception - Error messaged HAS NOT APPEARED");
		}
		System.out.println("+++++++++++++++++END TC3+++++++++++++++++++++");
	}
	public static void testCase4() {
		System.out.println("\nTC4 - Successful use of the displayAllData function for one audioFile");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		try {
			String title = "Hit The Diff";
			int duration = 60;
			String dataSource = "sound//HTD4a.wav";
			AudioFile temp = new AudioFile(title, duration, dataSource);
			am.loadAudio(temp);
			String title2 = "Hit The Diff";
			int duration2 = 60;
			String dataSource2 = "sound//HTD4b.wav";
			AudioFile temp2 = new AudioFile(title2, duration2, dataSource2);
			am.loadAudio(temp);
			System.out.println();
			am.loadAudio(temp2);
			for (String data : am.getAllData()) {
				System.out.println(data);
			}
			System.out.println("If this test works, all data about audioFiles should be displayed above");
		} catch (Exception ex) {
			System.out.println("Exception - If no data appears above, the audioFile has successfully been deleted");
		}
		System.out.println("+++++++++++++++++END TC4+++++++++++++++++++++");
	}
	
	public static void testCase5() {
		System.out.println("\nTC5 - Successful use of the play (int) function");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		try {
			String title = "Hit The Diff";
			int duration = 60;
			String dataSource = "sound//HTD.wav";
			int code = 1;
			AudioFile temp = new AudioFile(title, duration, dataSource);
			am.loadAudio(temp);
			System.out.println(title + "should now be playing");
			System.out.println(am.play(code));

		} catch (Exception ex) {
			System.out.println("Exception - AudioFile failed to play");
		}
		System.out.println("+++++++++++++++++END TC5+++++++++++++++++++++");
	}
	
	public static void testCase6() {
		System.out.println("\nTC6 - Successful use of the top songs function");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		try {
			// Adding 10 new AudioFiles
			
			//Number 1
			String title1 = "1st";
			int duration1 = 1;
			String dataSource1 = "1st.wav";
			AudioFile temp1 = new AudioFile(title1, duration1, dataSource1);
			for(int i = 0; i < 10; ++i) {
				temp1.registerPlay();
			}
			am.loadAudio(temp1);
			//Number 2
			String title2 = "2nd";
			int duration2 = 2;
			String dataSource2 = "2st.wav";
			AudioFile temp2 = new AudioFile(title2, duration2, dataSource2);
			for(int i = 0; i < 9; ++i) {
				temp2.registerPlay();
			}
			am.loadAudio(temp2);
			//Number 3
			String title3 = "3rd";
			int duration3 = 1;
			String dataSource3 = "3rd.wav";
			AudioFile temp3 = new AudioFile(title3, duration3, dataSource3);
			for(int i = 0; i < 8; ++i) {
				temp3.registerPlay();
			}
			am.loadAudio(temp3);
			//Number 4
			String title4 = "4th";
			int duration4 = 4;
			String dataSource4 = "4th.wav";
			AudioFile temp4 = new AudioFile(title4, duration4, dataSource4);
			for(int i = 0; i < 7; ++i) {
				temp4.registerPlay();
			}
			am.loadAudio(temp4);
			//Number 5
			String title5 = "5th";
			int duration5 = 5;
			String dataSource5 = "5th.wav";
			AudioFile temp5 = new AudioFile(title5, duration5, dataSource5);
			for(int i = 0; i < 6; ++i) {
				temp5.registerPlay();
			}
			am.loadAudio(temp5);
			//Number 6
			String title6 = "6th";
			int duration6 = 6;
			String dataSource6 = "6th.wav";
			AudioFile temp6 = new AudioFile(title6, duration6, dataSource6);
			for(int i = 0; i < 5; ++i) {
				temp6.registerPlay();
			}
			am.loadAudio(temp6);
			//Number 7
			String title7 = "7th";
			int duration7 = 7;
			String dataSource7 = "7th.wav";
			AudioFile temp7 = new AudioFile(title7, duration7, dataSource7);
			for(int i = 0; i < 4; ++i) {
				temp7.registerPlay();
			}
			am.loadAudio(temp7);
			//Number 8
			String title8 = "8th";
			int duration8 = 8;
			String dataSource8 = "8th.wav";
			AudioFile temp8 = new AudioFile(title8, duration8, dataSource8);
			for(int i = 0; i < 3; ++i) {
				temp8.registerPlay();
			}
			am.loadAudio(temp8);
			//Number 9
			String title9 = "9th";
			int duration9 = 9;
			String dataSource9 = "9th.wav";
			AudioFile temp9 = new AudioFile(title9, duration9, dataSource9);
			for(int i = 0; i < 2; ++i) {
				temp9.registerPlay();
			}
			am.loadAudio(temp9);
			//Number 10
			String title10 = "10th";
			int duration10 = 10;
			String dataSource10 = "10th.wav";
			AudioFile temp10 = new AudioFile(title10, duration10, dataSource10);
			for(int i = 0; i < 1; ++i) {
				temp10.registerPlay();
			}
			am.loadAudio(temp10);
			//Number 11
			String title11 = "11th";
			int duration11 = 11;
			String dataSource11 = "11th.wav";
			AudioFile temp11 = new AudioFile(title11, duration11, dataSource11);
			for(int i = 0; i < 0; ++i) {
				temp11.registerPlay();
			}
			am.loadAudio(temp11);
			
			System.out.println(am.topTen());
			System.out.println("If this test was worked, ten audioFiles should display listing from the most played, to the least");
			
		} catch (Exception ex) {
			System.out.println("Exception - loadAudio function executed unsuccessfully");
		}
		System.out.println("+++++++++++++++++END TC6+++++++++++++++++++++");
	}
	
	public static void testCase7() {
		System.out.println("\nTC7 - Successful use of the top songs function (with less than 10 AudioFiles)");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		try {
			// Adding 10 new AudioFiles
			
			//Number 1
			String title1 = "1st";
			int duration1 = 1;
			String dataSource1 = "1stA.wav";
			AudioFile temp1 = new AudioFile(title1, duration1, dataSource1);
			for(int i = 0; i < 10; ++i) {
				temp1.registerPlay();
			}
			am.loadAudio(temp1);
			//Number 2
			String title2 = "2nd";
			int duration2 = 2;
			String dataSource2 = "2stB.wav";
			AudioFile temp2 = new AudioFile(title2, duration2, dataSource2);
			for(int i = 0; i < 9; ++i) {
				temp2.registerPlay();
			}
			am.loadAudio(temp2);
			//Number 3
			String title3 = "3rd";
			int duration3 = 1;
			String dataSource3 = "3rdC.wav";
			AudioFile temp3 = new AudioFile(title3, duration3, dataSource3);
			for(int i = 0; i < 8; ++i) {
				temp3.registerPlay();
			}
			am.loadAudio(temp3);
			
			System.out.println(am.topTen());
			System.out.println("If this test was worked, three audioFiles should display listing from the most played, to the least");
			
		} catch (Exception ex) {
			System.out.println("Exception - TopTen function executed unsuccessfully");
		}
		System.out.println("+++++++++++++++++END TC7+++++++++++++++++++++");
	}
}
