package fun.bmkonto.cameraapi.cameraaccess;

import android.content.Context;
import android.hardware.Camera;
import android.widget.Toast;

public class CameraAccess {
    private static Camera camera;
    public static Camera getCameraInstance(Context context){
        try{
            releaseCamera();
            if(camera != null){
                Toast.makeText(context, "Camera is in use", Toast.LENGTH_SHORT).show();
            }else{
                camera = Camera.open();
            }
        }catch(Exception e){
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return camera;
    }

    private static void releaseCamera(){
        if(camera != null){
            camera.release();
            camera = null;
        }
    }
}
