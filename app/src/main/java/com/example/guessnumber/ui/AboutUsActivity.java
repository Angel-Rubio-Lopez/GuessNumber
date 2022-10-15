package com.example.guessnumber.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                .setName(getResources().getString(R.string.aboutName))
                .setSubTitle(getResources().getString(R.string.aboutSubTitle))
                .setBrief(getResources().getString(R.string.aboutBrief))
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink("https://github.com/Angel-Rubio-Lopez")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        setContentView(view);

    }
}
