package vox.web.tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import vox.web.apis.APIResponse;
import vox.web.apis.LifeAPIs;
import vox.web.apis.ListOfAPIs;
import vox.web.apis.SocialAPIs;
import vox.web.apis.UserAPIs;
import vox.web.utils.PingPoller;

import com.jayway.restassured.response.Response;

public class UserFlow extends BaseTest {

	@Test
	public void testViewUserProfile() throws IOException {

		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();
		// Get the access token
		Response resposne = getAccessTokenResposne();
		// Get the userid and access token
		String userId = UserAPIs.getValues(resposne.getBody().asString(),
				"userId");
		String password = UserAPIs.getValues(resposne.getBody().asString(),
				"accessToken");

		// View user profile
		Response apiWithAuthentication = APIResponse
				.getResponseWithAuthentication(UserAPIs.getUserId(userId),
						ListOfAPIs.VIEW_PROFILE, userId, password);

		UserAPIs.printOutput(ListOfAPIs.VIEW_PROFILE, apiWithAuthentication);
		// TODO Assert user profile

	}

	@Test
	public void testUpdateUserProfile() throws IOException {
		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();
		// Get the access token
		Response resposne = getAccessTokenResposne();
		// Get the userid and access token
		String userId = UserAPIs.getValues(resposne.getBody().asString(),
				"userId");
		String password = UserAPIs.getValues(resposne.getBody().asString(),
				"accessToken");
		// Update user profile
		Response apiWithAuthentication = APIResponse
				.getResponseWithAuthentication(UserAPIs.updateUserProfile(),
						ListOfAPIs.UPDATE_PROFILE, userId, password);
		UserAPIs.printOutput(ListOfAPIs.UPDATE_PROFILE, apiWithAuthentication);

		// TODO Assert user profile got updated or not

	}

	@Test
	public void testLifePage() throws IOException {
		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();
		// Get the access token
		Response accessTokenResposne = getAccessTokenResposne();
		// Get the userid and access token
		String userId = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "userId");
		String password = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "accessToken");
		// Get life page
		Response apiWithAuthentication = APIResponse
				.getResponseWithAuthentication(UserAPIs.getUserId(userId),
						ListOfAPIs.GET_LIFE_PAGE, userId, password);
		UserAPIs.printOutput(ListOfAPIs.GET_LIFE_PAGE, apiWithAuthentication);

		// TODO Assert life page
	}

	@Test
	public void testUploadLifePostAndDeleteIt() throws IOException {
		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();
		// Get the access token
		Response accessTokenResposne = getAccessTokenResposne();
		// Get the userid and access token
		String userId = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "userId");
		String password = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "accessToken");
		// Upload life post
		Response apiWithAuthentication = APIResponse
				.getResponseWithAuthentication(LifeAPIs.updateLifePost(),
						ListOfAPIs.UPLOAD_LIFE_POST, userId, password);
		UserAPIs.printOutput(ListOfAPIs.UPLOAD_LIFE_POST, apiWithAuthentication);

		// Get the post id
		String setPostId = LifeAPIs.setPostId(apiWithAuthentication.getBody()
				.asString());
		// TODO Assert life uploaded or not

		// Delete life post
		Response deleteLifePost1 = APIResponse.getResponseWithAuthentication(
				LifeAPIs.deleteLifePost(setPostId),
				ListOfAPIs.DELETE_LIFE_POST, userId, password);
		UserAPIs.printOutput(ListOfAPIs.DELETE_LIFE_POST, deleteLifePost1);
		// Print updated life page
		Response responeLife = APIResponse.getResponseWithAuthentication(
				UserAPIs.getUserId(userId), ListOfAPIs.GET_LIFE_PAGE, userId,
				password);
		UserAPIs.printOutput(ListOfAPIs.GET_LIFE_PAGE, responeLife);

		// Assert the post deleted or not
		Assert.assertTrue(setPostId + " PostId is present", LifeAPIs
				.isPostIdPresent(setPostId, responeLife.getBody().asString()));

	}

	@Test
	public void testUploadLikeAndDeleteLike() throws IOException {
		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();

		// Get the access token
		Response accessTokenResposne = getAccessTokenResposne();

		// Get the userid and access token
		String userId = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "userId");
		String password = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "accessToken");

		// Upload life post
		Response apiWithAuthentication = APIResponse
				.getResponseWithAuthentication(LifeAPIs.updateLifePost(),
						ListOfAPIs.UPLOAD_LIFE_POST, userId, password);
		UserAPIs.printOutput(ListOfAPIs.UPLOAD_LIFE_POST, apiWithAuthentication);

		// Get the post id
		String setPostId = LifeAPIs.setPostId(apiWithAuthentication.getBody()
				.asString());

		// Assert uploaded post using post id
		// Assert.assertTrue(setPostId + " Post id is not present", LifeAPIs
		// .isPostIdPresent(setPostId, apiWithAuthentication.getBody()
		// .asString()) == false);

		// Upload like
		Response uploadLike = APIResponse.getResponseWithAuthentication(
				LifeAPIs.postLike(setPostId, userId), ListOfAPIs.UPLOAD_LIKE,
				userId, password);
		UserAPIs.printOutput(ListOfAPIs.UPLOAD_LIKE, uploadLike);

		// TODO Assert like uploaded or not

		// Get post like
		Response postLikes = APIResponse.getResponseWithAuthentication(
				LifeAPIs.getPostId(setPostId), ListOfAPIs.GET_POST_LIKES,
				userId, password);
		UserAPIs.printOutput(ListOfAPIs.GET_POST_LIKES, postLikes);

		// Delete like
		Response deleteLike = APIResponse.getResponseWithAuthentication(
				LifeAPIs.postLike(setPostId, userId), ListOfAPIs.DELETE_LIKE,
				userId, password);
		UserAPIs.printOutput(ListOfAPIs.DELETE_LIKE, deleteLike);

		// TODO Assert like deleted or not

		// Delete life post
		Response deleteLifePost = APIResponse.getResponseWithAuthentication(
				LifeAPIs.deleteLifePost(setPostId),
				ListOfAPIs.DELETE_LIFE_POST, userId, password);
		UserAPIs.printOutput(ListOfAPIs.DELETE_LIFE_POST, deleteLifePost);

		// Print updated life page
		Response responeLife = APIResponse.getResponseWithAuthentication(
				UserAPIs.getUserId(userId), ListOfAPIs.GET_LIFE_PAGE, userId,
				password);
		UserAPIs.printOutput(ListOfAPIs.GET_LIFE_PAGE, responeLife);

		// Assert the post deleted or not
		Assert.assertTrue(setPostId + " PostId is present", LifeAPIs
				.isPostIdPresent(setPostId, responeLife.getBody().asString()));

	}

	@Test
	public void testUploadCommentAndGetPostComments() throws IOException {
		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();
		// Get the access token
		Response accessTokenResposne = getAccessTokenResposne();

		// Get the userid and access token
		String userId = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "userId");
		String password = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "accessToken");

		// Upload life post
		Response apiWithAuthentication = APIResponse
				.getResponseWithAuthentication(LifeAPIs.updateLifePost(),
						ListOfAPIs.UPLOAD_LIFE_POST, userId, password);
		UserAPIs.printOutput(ListOfAPIs.UPLOAD_LIFE_POST, apiWithAuthentication);

		// Get the post id
		String setPostId = LifeAPIs.setPostId(apiWithAuthentication.getBody()
				.asString());

		// Upload comment
		Response uploadLike = APIResponse.getResponseWithAuthentication(
				LifeAPIs.uploadComments(setPostId, userId),
				ListOfAPIs.UPLOAD_COMMENT, userId, password);
		UserAPIs.printOutput(ListOfAPIs.UPLOAD_COMMENT, uploadLike);

		// Get Post comments
		Response deleteLike = APIResponse.getResponseWithAuthentication(
				LifeAPIs.getPostId(setPostId), ListOfAPIs.GET_POST_COMMENTS,
				userId, password);
		UserAPIs.printOutput(ListOfAPIs.GET_POST_COMMENTS, deleteLike);

		// Delete life post
		Response deleteLifePost = APIResponse.getResponseWithAuthentication(
				LifeAPIs.deleteLifePost(setPostId),
				ListOfAPIs.DELETE_LIFE_POST, userId, password);
		UserAPIs.printOutput(ListOfAPIs.DELETE_LIFE_POST, deleteLifePost);

		// Print updated life page
		Response responeLife = APIResponse.getResponseWithAuthentication(
				UserAPIs.getUserId(userId), ListOfAPIs.GET_LIFE_PAGE, userId,
				password);
		UserAPIs.printOutput(ListOfAPIs.GET_LIFE_PAGE, responeLife);

	}

	@Test
	public void testUpdateContacts() throws IOException {
		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();

		// Get the access token
		Response accessTokenResposne = getAccessTokenResposne();

		// Get the userid and access token
		String userId = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "userId");
		String password = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "accessToken");
		// Upload contacts
		Response apiWithAuthentication = APIResponse
				.getResponseWithAuthentication(SocialAPIs.updateContats(),
						ListOfAPIs.UPLOAD_CONTACTS, userId, password);
		UserAPIs.printOutput(ListOfAPIs.UPLOAD_CONTACTS, apiWithAuthentication);

	}

	@Test
	public void testFollowUser() throws IOException {
		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();
		// Get the access token
		Response accessTokenResposne = getAccessTokenResposne();

		// Get the userid and access token
		String userId = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "userId");
		String password = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "accessToken");

		// get the followers
		Response getFollowers = APIResponse.getResponseWithAuthentication(
				UserAPIs.getUserId(userId), ListOfAPIs.GET_FOLLOWERS, userId,
				password);
		UserAPIs.printOutput(ListOfAPIs.GET_FOLLOWERS, getFollowers);
		// Get the following
		Response getFollowing = APIResponse.getResponseWithAuthentication(
				UserAPIs.getUserId(userId), ListOfAPIs.GET_FOLLOWING, userId,
				password);
		UserAPIs.printOutput(ListOfAPIs.GET_FOLLOWING, getFollowing);

		// follow the User
		// Response followerUser = APIResponse.APIWithAuthentication(
		// UserAPIs.getUserId(userId), ListOfAPIs.FOLOLOW_USER, userId,
		// password);
		// UserAPIs.printOutput(ListOfAPIs.FOLOLOW_USER, followerUser);

		// unfollowUser
		// Response unFollowUser = APIResponse.APIWithAuthentication(
		// UserAPIs.getUserId(userId), ListOfAPIs.UNFOLOLOW_USER, userId,
		// password);
		// UserAPIs.printOutput(ListOfAPIs.UNFOLOLOW_USER, unFollowUser);

	}

	@Test
	public void testSearchUser() throws IOException {
		// Print the menthod name
		System.out.println(Thread.currentThread().getStackTrace()[1]
				.getMethodName() + "::");
		PingPoller.getServerStatus();
		// Get the access token
		Response accessTokenResposne = getAccessTokenResposne();

		// Get the userid and access token
		String userId = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "userId");
		String password = UserAPIs.getValues(accessTokenResposne.getBody()
				.asString(), "accessToken");
		// search user
		Response searchUser = APIResponse.getResponseWithAuthentication(
				SocialAPIs.searchUser(), ListOfAPIs.SEARCH_USER, userId,
				password);
		UserAPIs.printOutput(ListOfAPIs.SEARCH_USER, searchUser);
	}
}