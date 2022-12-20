PROGRAM:
SMS:
ACTIVITY_MAIN.XML:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_marginTop="47dp"
        android:layout_marginEnd="66dp"
        android:ems="10"
        android:hint="Enter Number"
        android:inputType="number" />

    <EditText
        android:id="@+id/editTextTextPersonName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_centerVertical="true"
        android:layout_marginTop="191dp"
        android:layout_marginEnd="61dp"
        android:ems="10"
        android:hint="Enter message"
        android:inputType="textPersonName" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_alignParentBottom="true"
        android:layout_marginEnd="142dp"
        android:layout_marginBottom="53dp"
        android:text="SEND" />

    <EditText
        android:id="@+id/editTextNumber3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_centerVertical="true"
        android:layout_marginTop="297dp"
        android:layout_marginEnd="58dp"
        android:ems="10"
        android:inputType="text" />

</RelativeLayout>

ANDROID MANIFEST.XML:
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="com.example.messgaeap">
    <uses-permission android:name="android.permission.SEND_SMS">

    </uses-permission>
    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Messgaeap"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

MAINACTIVITY.JAVA:
package com.example.messgaeap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText text=(EditText) findViewById(R.id.editTextNumber);
        EditText text1=(EditText) findViewById(R.id.editTextNumber3);
        TextView show=(TextView) findViewById(R.id.editTextTextPersonName);
        Button click=(Button) findViewById(R.id.button);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = text.getText().toString();
                String b = text1.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(a, null, b, null, null);
                    Toast.makeText(getApplicationContext(), "message sent", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "message is empty", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
