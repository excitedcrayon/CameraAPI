package fun.bmkonto.cameraapi.cameradetect;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import fun.bmkonto.cameraapi.R;
import fun.bmkonto.cameraapi.cameraaccess.CameraAccess;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = (Button) findViewById(R.id.button_check_camera);
        checkButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_check_camera:
                checkCameraHardware(MainActivity.this);
                CameraAccess.getCameraInstance(this);
        }
    }

    private boolean checkCameraHardware(Context context){
        if(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(context,"This device has a camera", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(context,"This device does not have a camera", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
