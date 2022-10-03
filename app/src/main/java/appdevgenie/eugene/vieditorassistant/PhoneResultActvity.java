package appdevgenie.eugene.vieditorassistant;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import appdevgenie.eugene.vieditorassistant.fragments.AboutFragment;
import appdevgenie.eugene.vieditorassistant.fragments.DeleteFragment;
import appdevgenie.eugene.vieditorassistant.fragments.ExitFragment;
import appdevgenie.eugene.vieditorassistant.fragments.InfoFragment;
import appdevgenie.eugene.vieditorassistant.fragments.InsertFragment;
import appdevgenie.eugene.vieditorassistant.fragments.ModesFragment;
import appdevgenie.eugene.vieditorassistant.fragments.MoveCursorFragment;
import appdevgenie.eugene.vieditorassistant.fragments.MoveScreenFragment;
import appdevgenie.eugene.vieditorassistant.fragments.OtherFragment;
import appdevgenie.eugene.vieditorassistant.fragments.PasteFragment;
import appdevgenie.eugene.vieditorassistant.fragments.SearchFragment;
import appdevgenie.eugene.vieditorassistant.fragments.StartFragment;
import appdevgenie.eugene.vieditorassistant.fragments.YankFragment;

public class PhoneResultActvity extends FragmentActivity {

    private boolean largeLand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.phone_result_frame);

        checkScreenSize();
        getIntentInfo();
    }

    private void checkScreenSize() {

        int screenSize = this.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK;

        if (screenSize > Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            largeLand = true;
        }

        if ((this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                && (largeLand)) {
            finish();
        }

    }

    private void getIntentInfo() {

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        switch (position) {

            case 0:

                Fragment modes = new ModesFragment();
                transaction.replace(R.id.phoneResultFrame, modes);
                transaction.commit();

                break;

            case 1:

                Fragment about = new AboutFragment();
                transaction.replace(R.id.phoneResultFrame, about);
                transaction.commit();

                break;

            case 2:

                Fragment start = new StartFragment();
                transaction.replace(R.id.phoneResultFrame, start);
                transaction.commit();

                break;

            case 3:

                Fragment exit = new ExitFragment();
                transaction.replace(R.id.phoneResultFrame, exit);
                transaction.commit();

                break;

            case 4:

                Fragment insert = new InsertFragment();
                transaction.replace(R.id.phoneResultFrame, insert);
                transaction.commit();

                break;

            case 5:

                Fragment delete = new DeleteFragment();
                transaction.replace(R.id.phoneResultFrame, delete);
                transaction.commit();

                break;

            case 6:

                Fragment yank = new YankFragment();
                transaction.replace(R.id.phoneResultFrame, yank);
                transaction.commit();

                break;

            case 7:

                Fragment search = new SearchFragment();
                transaction.replace(R.id.phoneResultFrame, search);
                transaction.commit();

                break;

            case 8:

                Fragment paste = new PasteFragment();
                transaction.replace(R.id.phoneResultFrame, paste);
                transaction.commit();

                break;

            case 9:

                Fragment moveCursor = new MoveCursorFragment();
                transaction.replace(R.id.phoneResultFrame, moveCursor);
                transaction.commit();

                break;

            case 10:

                Fragment moveScreen = new MoveScreenFragment();
                transaction.replace(R.id.phoneResultFrame, moveScreen);
                transaction.commit();

                break;

            case 11:

                Fragment other = new OtherFragment();
                transaction.replace(R.id.phoneResultFrame, other);
                transaction.commit();

                break;

            case 12:

                Fragment info = new InfoFragment();
                transaction.replace(R.id.phoneResultFrame, info);
                transaction.commit();

                break;

            default:
                break;
        }

    }

}
