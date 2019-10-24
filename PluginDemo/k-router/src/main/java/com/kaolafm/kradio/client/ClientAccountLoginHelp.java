//package com.kaolafm.kradio.client;
//
//import android.os.RemoteException;
//import android.util.Log;
//
//import com.google.gson.Gson;
//import com.kaolafm.kradio.lib.sdk.utils.UserInfoManager;
//import com.kaolafm.opensdk.account.token.AccessTokenManager;
//import com.kaolafm.opensdk.account.token.ITingbanTokenObserver;
//import com.kaolafm.opensdk.account.token.KaolaAccessToken;
//import com.kaolafm.sdk.client.IExecuteResult;
//import com.kaolafm.sdk.client.ex.ErrorCode;
//import com.kaolafm.sdk.client.ex.bean.UserInfo;
//import com.kaolafm.sdk.client.ex.cmd.BindListenerCmd;
//
///**
// * <pre>
// *     @author : Wenchl
// *     e-mail : wenclwlm@yeah.net
// *     time   : 2019/07/16
// *     desc   :
// *     version: 1.0
// * </pre>
// */
//public class ClientAccountLoginHelp {
//
//    private String TAG = "ClientAccountLoginHelp";
//
//    private IExecuteResult bindResult;
//
//    private Gson mGson;
//
//    private String token = null;
//
//
//    public ClientAccountLoginHelp(Gson gson) {
//        mGson = gson;
//        UserInfoManager.getInstance().addUserInfoStateListener(iUserInfoStateListener);
//        AccessTokenManager.getInstance().registerObserver(iTingbanTokenObserver);
//    }
//
//    public void setBindResult(IExecuteResult iExecuteResult){
//        bindResult = iExecuteResult;
//    }
//
//    public UserInfo getUserInfoFromNet() {
//        UserInfo userInfo = new UserInfo();
//        //
//        UserInfoManager userInfoManager = UserInfoManager.getInstance();
//        userInfo.setNickName(userInfoManager.getBoundUserNickName());
//        userInfo.setAvatar(userInfoManager.getBoundUserFavicon());
//        userInfo.setUserId(userInfoManager.getUserId());
//        //
//        KaolaAccessToken accessToken = AccessTokenManager.getInstance().getKaolaAccessToken();
//        userInfo.setToken(accessToken.getAccessToken());
//        userInfo.setRefreshToken(accessToken.getRefreshToken());
//
//        return userInfo;
//    }
//
//    private ITingbanTokenObserver iTingbanTokenObserver = new ITingbanTokenObserver() {
//        @Override
//        public void onChange(KaolaAccessToken kaolaAccessToken) {
//            if (bindResult == null) {
//                return;
//            }
//
//            //第一次不通知，与bind 重复
//            if (token == null) {
//                token = kaolaAccessToken.getAccessToken();
//                return;
//            }
//
//            //如果token相同就不通知cliensdk
//            if (token.equals(kaolaAccessToken.getAccessToken())) {
//                return;
//            }
//
//            token = kaolaAccessToken.getAccessToken();
//
//            BindListenerCmd.Result bind = new BindListenerCmd.Result();
//            bind.state = BindListenerCmd.Result.UPDATE_TOKEN;
//            bind.setCode(ErrorCode.Success);
//            bind.setUserInfo(getUserInfoFromNet());
//            try {
//                bindResult.onResult(mGson.toJson(bind));
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    };
//
//    private UserInfoManager.IUserInfoStateListener iUserInfoStateListener = new UserInfoManager.IUserInfoStateListener(){
//
//        @Override
//        public void userLogin() {
//
//        }
//
//        @Override
//        public void userLogout() {
//
//        }
//
//        @Override
//        public void userBound() {
//            Log.i(TAG,"userBound:"+bindResult);
//            if (bindResult == null) {
//                return;
//            }
//            BindListenerCmd.Result bind = new BindListenerCmd.Result();
//            bind.state = BindListenerCmd.Result.BIND;
//            bind.setCode(ErrorCode.Success);
//            bind.setUserInfo(getUserInfoFromNet());
//            try {
//                bindResult.onResult(mGson.toJson(bind));
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void userCancelBound() {
//            Log.i(TAG,"userCancelBound:"+bindResult);
//            if (bindResult == null) {
//                return;
//            }
//            BindListenerCmd.Result bind = new BindListenerCmd.Result();
//            bind.state = BindListenerCmd.Result.UNBIND;
//            bind.setCode(ErrorCode.Success);
//            try {
//                bindResult.onResult(mGson.toJson(bind));
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void userCancel() {
//
//        }
//    };
//}
