package TestCases;

import java.io.IOException;

import utils.GoogleSheetUpdateUtils;

public class Dummy {

	public static void main(String[] args) throws IOException {
		GoogleSheetUpdateUtils.updateDeeperStudentLoginStatus("REG41229", "Pass");
		GoogleSheetUpdateUtils.updateDeeperStudentLoginStatus("REG14264","Pass");
	}

}
