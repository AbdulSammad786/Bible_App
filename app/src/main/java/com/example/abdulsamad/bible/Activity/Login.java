package com.example.abdulsamad.bible.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.abdulsamad.bible.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
public class Login extends AppCompatActivity implements  GoogleApiClient.OnConnectionFailedListener{
    private CallbackManager callbackManager;
    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;
    ProgressDialog progress;
    String facebook_id ,f_name ,m_name , l_name ,gender , profile_image ,full_name , email_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init_fb();
        setContentView(R.layout.activity_login);
        setupGoogleClients();
    }
    public void login(View view)
    {
        finish();
        startActivity(new Intent(this,Home.class));
    }
    public void signup(View view)
    {
        finish();
        startActivity(new Intent(this,Signup.class));
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //facebook login methods
    private void init_fb(){

    progress = new ProgressDialog(Login.this);
    progress.setMessage("Please wait,Facebook is loading for you!");
    progress.setIndeterminate(false);
    progress.setCancelable(false);
    facebook_id = f_name = m_name = l_name = gender = profile_image = full_name = email_id = "";

    //for facebook
    FacebookSdk.sdkInitialize(getApplicationContext());
    callbackManager = CallbackManager.Factory.create();

    //register callback object for facebook result
    LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            // progress.show();
            Profile profile = Profile.getCurrentProfile();
            if (profile != null) {
                Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();
                facebook_id = profile.getId();
                f_name = profile.getFirstName();
                m_name = profile.getMiddleName();
                l_name = profile.getLastName();
                full_name = profile.getName();
                profile_image = profile.getProfilePictureUri(400, 400).toString();
            }
            //Toast.makeText(FacebookLogin.this,"Wait...",Toast.LENGTH_SHORT).show();
            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            try {
                                Log.d("there", "onCompleted: ");
                                email_id = object.getString("email");
                                Toast.makeText(Login.this, "Logged In as: " + email_id, Toast.LENGTH_SHORT).show();
                                   /* gender=object.getString("gender");
                                    String profile_name=object.getString("name");
                                    long fb_id=object.getLong("id"); //use this for logout
                                    //Start new activity or use this info in your project.
                                    Intent i=new Intent(Login.this, Register.class);
                                    i.putExtra("type","facebook");
                                    i.putExtra("facebook_id",facebook_id);
                                    i.putExtra("f_name",f_name);
                                    i.putExtra("m_name",m_name);
                                    i.putExtra("l_name",l_name);
                                    i.putExtra("full_name",full_name);
                                    i.putExtra("profile_image",profile_image);
                                    i.putExtra("email_id",email_id);
                                    i.putExtra("gender",gender);
                                    progress.dismiss();
                                    startActivity(i);
                                    finish();*/
                               // startActivity(new Intent(Login.this, Home.class));
                            } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                //  e.printStackTrace();
                            }
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id, first_name, last_name, email,gender, birthday, location"); // Parámetros que pedimos a facebook
            request.setParameters(parameters);
            request.executeAsync();
        }
        @Override
        public void onCancel() {
            Toast.makeText(Login.this, "Login cancelled", Toast.LENGTH_SHORT).show();
            progress.dismiss();
        }
        @Override
        public void onError(FacebookException error) {
            Toast.makeText(Login.this, "Login error", Toast.LENGTH_SHORT).show();
            progress.dismiss();
        }
    });
}
    public void facebook(View view){
    LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends", "email"));
}
    //Google signup methods
    private void setupGoogleClients() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }
    public void google(View view) {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent,1);
    }
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d("", "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            Log.e("", "display name: " + acct.getDisplayName());
            String personName = acct.getDisplayName();
            String personPhotoUrl="";
            try {
                 personPhotoUrl = acct.getPhotoUrl().toString();
            }catch (Exception ex)
            {
                Log.d("No photo found", "handleSignInResult: ");
            }
                String email = acct.getEmail();
            Log.e("", "Name: " + personName + ", email: " + email
                    + ", Image: " + personPhotoUrl);
        } else {
            // Signed out, show unauthenticated UI.
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 1) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }else
        {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d("", "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d("", "onConnectionFailed:" + connectionResult);
    }
    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Please wait...");
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }
    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }
    public void redirectSignup(View view) {
        finish();
        startActivity(new Intent(this,Signup.class));
    }
}