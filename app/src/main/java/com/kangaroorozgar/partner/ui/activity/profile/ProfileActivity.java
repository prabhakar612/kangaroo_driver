package com.kangaroorozgar.partner.ui.activity.profile;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kangaroorozgar.partner.BuildConfig;
import com.kangaroorozgar.partner.MvpApplication;
import com.kangaroorozgar.partner.R;
import com.kangaroorozgar.partner.base.BaseActivity;
import com.kangaroorozgar.partner.common.Constants;
import com.kangaroorozgar.partner.common.SharedHelper;
import com.kangaroorozgar.partner.common.Utilities;
import com.kangaroorozgar.partner.data.network.model.UserResponse;
import com.kangaroorozgar.partner.ui.activity.change_password.ChangePasswordActivtiy;
import com.kangaroorozgar.partner.ui.activity.main.MainActivity;
import com.kangaroorozgar.partner.ui.countrypicker.Country;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import id.zelory.compressor.Compressor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.kangaroorozgar.partner.common.Constants.MULTIPLE_PERMISSION;
import static com.kangaroorozgar.partner.common.Constants.RC_MULTIPLE_PERMISSION_CODE;

public class ProfileActivity extends BaseActivity implements ProfileIView {

    private ProfilePresenter presenter = new ProfilePresenter();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgProfile)
    CircleImageView imgProfile;
    @BindView(R.id.completeData)
    LinearLayout completeData;
    @BindView(R.id.txtFirstName)
    EditText txtFirstName;
    @BindView(R.id.txtLastName)
    EditText txtLastName;
    @BindView(R.id.txtPhoneNumber)
    TextView txtPhoneNumber;
    @BindView(R.id.txtEmail)
    EditText txtEmail;
    @BindView(R.id.txtService)
    EditText txtService;
    @BindView(R.id.txtModel)
    EditText txtModel;
    @BindView(R.id.txtNumber)
    EditText txtNumber;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.lblChangePassword)
    TextView lblChangePassword;
    @BindView(R.id.qr_scan)
    ImageView ivQrScan;

    private File imgFile = null;
    private String countryDialCode = Constants.DEFAULT_COUNTRY_DIAL_CODE;
    private String countryCode = Constants.DEFAULT_COUNTRY_CODE;
    private String qrCodeUrl;

    private AlertDialog mDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        presenter.attachView(this);
        showLoading();
        presenter.getProfile();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.profile));

        getUserCountryInfo();
        setupSpinnerCities();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick({R.id.btnSave, R.id.lblChangePassword, R.id.imgProfile, R.id.qr_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                profileUpdate();
                break;
            case R.id.lblChangePassword:
                startActivity(new Intent(ProfileActivity.this, ChangePasswordActivtiy.class));
                break;
            case R.id.imgProfile:
                MultiplePermissionTask();
                break;
            case R.id.qr_scan:
                if (!TextUtils.isEmpty(qrCodeUrl)) showQRCodePopup();
                break;
        }
    }


    private void getUserCountryInfo() {
        Country country = getDeviceCountry(ProfileActivity.this);
        countryDialCode = country.getDialCode();
        countryCode = country.getCode();
    }

    private void showQRCodePopup() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.AlertDialogCustom);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_qrcode_image, null);

        ImageView qr_image = view.findViewById(R.id.qr_image);
        ImageView close = view.findViewById(R.id.ivClose);

        Glide.with(ProfileActivity.this)
                .load(qrCodeUrl)
                .apply(RequestOptions
                        .placeholderOf(R.drawable.ic_qr_code)
                        .dontAnimate().error(R.drawable.ic_qr_code))
                .into(qr_image);

        builder.setView(view);
        mDialog = builder.create();
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        close.setOnClickListener(view1 -> mDialog.dismiss());

        mDialog.show();
    }

    void profileUpdate() {

        if (Constants.userAvatar == null && imgFile == null) {
            Toast.makeText(this, "Please submit your profile picture", Toast.LENGTH_SHORT).show();
        } else if (txtFirstName.getText().toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.invalid_first_name), Toast.LENGTH_SHORT).show();
        } else if (txtLastName.getText().toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.invalid_last_name), Toast.LENGTH_SHORT).show();
        } else if (txtPhoneNumber.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, getString(R.string.invalid_phone_number), Toast.LENGTH_SHORT).show();
        } else if (txtEmail.getText().toString().isEmpty()
                || !Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches()) {
            Toast.makeText(this, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show();
//        } else if (!phoneNumber.equalsIgnoreCase(txtPhoneNumber.getText().toString())) {
            //Mobile number having both country code or not so we simply sending empty here
//            fbOtpVerify(countryCode, countryDialCode, "");
        } else updateDetails();
    }
    private void setupSpinnerCities(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.gender_list, R.layout.spinner);
        adapter.setDropDownViewResource(R.layout.spinner);
        sexy_Spinner.setAdapter(adapter);
    }
    @BindView(R.id.sexy_spinner)
    AppCompatSpinner sexy_Spinner;

    private void updateDetails() {
        Map<String, RequestBody> map = new HashMap<>();

        map.put("first_name", toRequestBody(txtFirstName.getText().toString()));
        map.put("last_name", toRequestBody(txtLastName.getText().toString()));
        map.put("email", toRequestBody(txtEmail.getText().toString()));
        map.put("mobile", toRequestBody(txtPhoneNumber.getText().toString()));
        map.put("gender",toRequestBody(sexy_Spinner.getSelectedItem().toString()));

        MultipartBody.Part filePart = null;
        if (imgFile != null)
            try {
                File compressedImageFile = new Compressor(this).compressToFile(imgFile);
                filePart = MultipartBody.Part.createFormData("avatar", compressedImageFile.getName(),
                        RequestBody.create(MediaType.parse("image*//*"), compressedImageFile));
            } catch (IOException e) {
                e.printStackTrace();
            }

        Utilities.printV("Params ===> 2", map.toString());
        showLoading();
        presenter.profileUpdate(map, filePart);
    }

    @Override
    public void onSuccess(UserResponse user) {
        hideLoading();
        Utilities.printV("User===>", user.getFirstName() + user.getLastName());
        Utilities.printV("TOKEN===>", SharedHelper.getKey(MvpApplication.getInstance(),
                Constants.SharedPref.ACCESS_TOKEN, ""));

        String loginBy = user.getLoginBy();

        if (loginBy.equalsIgnoreCase("facebook") || loginBy.equalsIgnoreCase("google"))
            lblChangePassword.setVisibility(View.INVISIBLE);
        else lblChangePassword.setVisibility(View.VISIBLE);

        txtFirstName.setText(user.getFirstName());
        txtLastName.setText(user.getLastName());
        txtPhoneNumber.setText(String.valueOf(user.getMobile()));
        txtNumber.setText(user.getService().getServiceNumber());
        txtModel.setText(user.getService().getServiceModel());

        txtEmail.setText(user.getEmail());
        SharedHelper.putKey(this, Constants.SharedPref.STRIPE_PUBLISHABLE_KEY, user.getStripePublishableKey());
        if (user.getService() != null)
            txtService.setText((user.getService().getServiceType() != null)
                    ?getNameResult( user.getService().getServiceType().getName()) : "");
        Glide.with(activity())
                .load(BuildConfig.BASE_IMAGE_URL + user.getAvatar())
                .apply(RequestOptions
                        .placeholderOf(R.drawable.ic_user_placeholder)
                        .dontAnimate()
                        .error(R.drawable.ic_user_placeholder))
                .into(imgProfile);
        Constants.showOTP = user.getRide_otp().equals("1");
        Constants.showTOLL = user.getRide_toll().equals("1");
        qrCodeUrl = !TextUtils.isEmpty(user.getQrcode_url()) ? BuildConfig.BASE_URL + user.getQrcode_url() : null;
        ivQrScan.setVisibility(TextUtils.isEmpty(qrCodeUrl) ? View.GONE : View.GONE);
    }

    @Override
    public void onSuccessUpdate(UserResponse object) {
        hideLoading();
        Intent profileIntent = new Intent(this, MainActivity.class);
        profileIntent.putExtra("avatar", BuildConfig.BASE_IMAGE_URL + object.getAvatar());
        Constants.userAvatar = BuildConfig.BASE_IMAGE_URL + object.getAvatar();
        startActivity(profileIntent);
        Toasty.success(this, getString(R.string.profile_updated), Toast.LENGTH_SHORT, true).show();
    }

    @Override
    public void onError(Throwable e) {
        hideLoading();
        if (e != null)
            onErrorBase(e);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, ProfileActivity.this,
                new DefaultCallback() {
                    @Override
                    public void onImagesPicked(@NonNull List<File> imageFiles,
                                               EasyImage.ImageSource source, int type) {
                        imgFile = imageFiles.get(0);
                        Glide.with(activity())
                                .load(Uri.fromFile(imgFile))
                                .apply(RequestOptions
                                        .placeholderOf(R.drawable.ic_user_placeholder)
                                        .dontAnimate()
                                        .error(R.drawable.ic_user_placeholder))
                                .into(imgProfile);
                    }
                });
    }

    private boolean hasMultiplePermission() {
        return EasyPermissions.hasPermissions(this, MULTIPLE_PERMISSION);
    }

    @AfterPermissionGranted(RC_MULTIPLE_PERMISSION_CODE)
    void MultiplePermissionTask() {
        if (hasMultiplePermission()) pickImage();
        else EasyPermissions.requestPermissions(
                this, getString(R.string.please_accept_permission),
                RC_MULTIPLE_PERMISSION_CODE,
                MULTIPLE_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onSuccessPhoneNumber(Object object) {
        updateDetails();
    }

    @Override
    public void onVerifyPhoneNumberError(Throwable e) {
        Toasty.error(this, getString(R.string.phone_number_already_exists), Toast.LENGTH_SHORT).show();
        txtPhoneNumber.requestFocus();
    }
}
