package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class GoogleSheetUpdateUtils {
	
	/** Application name. */
    private static final String APPLICATION_NAME =
        "update-deeper-app-login-status";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/update-deeper-app-login-status");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES =
        Arrays.asList(SheetsScopes.SPREADSHEETS);
    
    //"1cLlndOxUC98rhhLprWS9rrWOS4IUBGDLRK_NhFLVD-U"	Deeper Format
    //"1NPUyqx06BzvdapwZqNP-npMfi6H35lcLSA6urYYXut8"	Copy of
    static String spreadsheetId = "1NPUyqx06BzvdapwZqNP-npMfi6H35lcLSA6urYYXut8";
    static String srcRange = "Embibe Format!V:V";
    static String destRange = "Embibe Format!X";

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
        		GoogleSheetUpdateUtils.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Sheets API client service.
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

//    public static void updateStudentLoginStatus()throws IOException {
    @SuppressWarnings("unchecked")
    public static void updateDeeperStudentLoginStatus(String ApplicationId,String status) throws IOException {
        // Build a new authorized API client service.
        Sheets service = getSheetsService();

        ValueRange response = service.spreadsheets().values()
            .get(spreadsheetId, srcRange)
            .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
          int rowCount = 1;
          for (List row : values) {
            // Print columns A and E, which correspond to indices 0 and 4.
            try {
				String AppId =  row.get(0).toString();
				System.out.println(AppId);
				if(AppId.equals(ApplicationId)){
					List<List<Object>> inputValues = Arrays.asList(
					        Arrays.asList(new Object[]{status})
					);
					destRange = destRange + String.valueOf(rowCount);
					ValueRange body = new ValueRange()
					        .setValues(inputValues);
					try {
						UpdateValuesResponse result =
						        service.spreadsheets().values().update(spreadsheetId, destRange, body)
						                .setValueInputOption("USER_ENTERED")
						                .execute();
						System.out.println("Status updated for Application Id: "+ApplicationId);
					} catch (Exception e) {
						System.out.println("Status update failed for Application Id: "+ApplicationId);
					}
					break;
				}
					
					
			} catch (Exception e) {}
            rowCount++;
          }
        }
    }

}
