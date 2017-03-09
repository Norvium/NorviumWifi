package war.dvcnxc.norviumwifi;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textInfo = (TextView)findViewById(R.id.info);
        TextView textSpeed = (TextView)findViewById(R.id.speed);
        TextView textFreq = (TextView)findViewById(R.id.frequency);

        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if(wifiManager!=null){
            textInfo.setText(wifiManager.toString());
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            textSpeed.setText("Link Speed: " + wifiInfo.getLinkSpeed() + wifiInfo.LINK_SPEED_UNITS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textFreq.setText("Freuency: " + wifiInfo.getFrequency() + wifiInfo.FREQUENCY_UNITS);
            }
        }else{
            textInfo.setText("wifiManager == null!");
        }
    }


}
