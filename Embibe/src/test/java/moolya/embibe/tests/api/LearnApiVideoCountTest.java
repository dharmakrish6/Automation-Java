package moolya.embibe.tests.api;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import moolya.embibe.pages.api.LearnApi;
import moolya.embibe.utils.SqliteUtils;

public class LearnApiVideoCountTest {
	
	@Test(dataProvider="getLearnParams")
	public void learnApiVideoCountTest(String learn_path,String entity_code) throws JSONException, IOException{
		String response = LearnApi.getLearnApiResponse(learn_path, entity_code);
		String videoCount = LearnApi.getVideosCount(response);
		SqliteUtils.updateLearnVideoCount(learn_path, entity_code, videoCount);
	}
	
	@DataProvider
	public Object[][] getLearnParams() throws IOException{
//		Object[][] obj = SqliteUtils.getLearnParams();
		Object[][] obj = SqliteUtils.getLearnParamsForReRun();
		return obj;
	}

}
