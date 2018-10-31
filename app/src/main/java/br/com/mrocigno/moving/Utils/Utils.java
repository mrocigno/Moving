package br.com.mrocigno.moving.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

public class Utils {
    public static boolean verifiePermissions(Activity activity) {
        String[] permisions = {
                Manifest.permission.ACCESS_FINE_LOCATION
        };

        ArrayList<String> denied = new ArrayList<>();

        for (String permision : permisions) {
            if (ContextCompat.checkSelfPermission(activity, permision) == PackageManager.PERMISSION_DENIED) {
                denied.add(permision);
            }
        }

        if (denied.size() > 0) {
            String[] permisionsDenied = new String[denied.size()];
            permisionsDenied = denied.toArray(permisionsDenied);

            ActivityCompat.requestPermissions(activity, permisionsDenied, 0);
            return false;
        }
        return true;
    }
}
