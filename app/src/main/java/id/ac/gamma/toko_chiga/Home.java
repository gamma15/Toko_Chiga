package id.ac.gamma.toko_chiga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void gmail(View view) {
        String [] TO ={"radengamma15@gmail.com"};
        Intent GmailInten = new Intent(Intent.ACTION_SEND);

        GmailInten.setData(Uri.parse("mailto:"));
        GmailInten.setType("massage/rfc822");
        GmailInten.putExtra(Intent.EXTRA_EMAIL,TO);

        try {
            startActivity(Intent.createChooser(GmailInten, "send mail..."));
            finish();
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(Home.this, "there is not email installed.", Toast.LENGTH_SHORT).show();;
        }
    }

    public void telepon(View view) {
        Intent Telp = new Intent(Intent.ACTION_DIAL);
        Telp.setData(Uri.parse("tel: (0895411460300)"));
        startActivity(Telp);
    }

    public void maps(View view) {
        Uri link_maps = Uri.parse("https://www.google.co.id/maps/place/Toko+Chiga/@-5.4119394,105.245525,17z/data=!3m1!4b1!4m5!3m4!1s0x2e40da5ebb9e6715:0xf6cee0dbfa49397b!8m2!3d-5.4119447!4d105.2477137");
        Intent buka_maps = new Intent(Intent.ACTION_VIEW,link_maps);
        startActivity(buka_maps);
    }

    public void info(View view) {
        Intent i = new Intent(this, information.class);
        startActivity(i);
    }

    public void whatsapp(View view) {
        String url = "https://api.whatsapp.com/send?phone=+62895411460300";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}