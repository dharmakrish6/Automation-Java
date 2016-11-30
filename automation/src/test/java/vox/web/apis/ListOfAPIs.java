package vox.web.apis;

public final class ListOfAPIs {

	// User APIs
	public static final String GET_VERIFICATION_CODE = "/user/getVerificationCode";  //Done
	public static final String GET_ACCESS_TOKEN = "/user/getAccessToken";            //Done
	public static final String GET_COGNITO_TOKEN = "/user/getCognitoToken";          //Not Done
	public static final String UPDATE_PROFILE = "/user/updateProfile";               //Done
	public static final String VIEW_PROFILE = "/user/viewProfile";                   //Done
	public static final String GET_NOTIFICATIONS = "/user/getNotifications";         //Not Done

	// Life APIs
	public static final String GET_LIFE_PAGE = "/life/getLifePage";                        //Done
	public static final String UPLOAD_LIFE_POST = "/life/uploadLifePost";                  //Done only for text
	public static final String REMOVE_VOICE_FROM_VOX_PIC = "/life/removeVoiceFromVoxPic";  //Not Done
	public static final String DELETE_LIFE_POST = "/life/deleteLifePost";                  //Done only for text
	public static final String UPLOAD_LIKE = "/life/uploadLike";                           //Done
	public static final String DELETE_LIKE = "/life/deleteLike";                           //Done
	public static final String GET_POST_LIKES = "/life/getPostLikes";                      //Done
	public static final String UPLOAD_COMMENT = "/life/uploadComment";                     //Done
	public static final String GET_POST_COMMENTS = "/life/getPostComments";                //Done
	public static final String GET_HASHTAH_PAGE = "/life/getHashtagPage";                  //Not Done
	public static final String REPORT_CONTENT = "/life/reportContent";                     //Not Done

	// Social APIs
	public static final String UPLOAD_CONTACTS = "/social/uploadContacts";                 //Done
	public static final String GET_IP_CONTACTS = "/social/getIPContacts";                  //Not Done
	public static final String BLOCK_CONTACT = "/social/blockContact";                     //Not Done
	public static final String UNBLOCK_CONTACT = "/social/unblockContact";                 //Not Done
	public static final String FOLOLOW_USER = "/social/followUser";                        //Done need to test
	public static final String UNFOLOLOW_USER = "/social/unfollowUser";                    //Done need to test
	public static final String GET_FOLLOWERS = "/social/getFollowers";                     //Done
	public static final String GET_FOLLOWING = "/social/getFollowing";                     //Done
	public static final String SEARCH_USER = "/social/searchUser";                         //Done

}
