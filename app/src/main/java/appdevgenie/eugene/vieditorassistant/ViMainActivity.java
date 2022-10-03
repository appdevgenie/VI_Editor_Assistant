package appdevgenie.eugene.vieditorassistant;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

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
import appdevgenie.eugene.vieditorassistant.fragments.ViMainFragment;
import appdevgenie.eugene.vieditorassistant.fragments.YankFragment;

public class ViMainActivity extends FragmentActivity implements
        ViMainFragment.MainListHandler {

    private boolean dualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vi_main_activity);

        FrameLayout resultFrame = findViewById(R.id.resultFrame);
        if (resultFrame != null && resultFrame.getVisibility() == View.VISIBLE) {
            dualPane = true;
        }

    }

    @Override
    public void onHandleMainListClicked(int position) {

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        if (dualPane) {

            switch (position) {
                case 0:

                    Fragment modes = new ModesFragment();
                    transaction.replace(R.id.resultFrame, modes);
                    transaction.commit();

                    break;

                case 1:

                    Fragment about = new AboutFragment();
                    transaction.replace(R.id.resultFrame, about);
                    transaction.commit();

                    break;

                case 2:

                    Fragment start = new StartFragment();
                    transaction.replace(R.id.resultFrame, start);
                    transaction.commit();

                    break;

                case 3:

                    Fragment exit = new ExitFragment();
                    transaction.replace(R.id.resultFrame, exit);
                    transaction.commit();

                    break;

                case 4:

                    Fragment insert = new InsertFragment();
                    transaction.replace(R.id.resultFrame, insert);
                    transaction.commit();

                    break;

                case 5:

                    Fragment delete = new DeleteFragment();
                    transaction.replace(R.id.resultFrame, delete);
                    transaction.commit();

                    break;

                case 6:

                    Fragment yank = new YankFragment();
                    transaction.replace(R.id.resultFrame, yank);
                    transaction.commit();

                    break;

                case 7:

                    Fragment search = new SearchFragment();
                    transaction.replace(R.id.resultFrame, search);
                    transaction.commit();

                    break;

                case 8:

                    Fragment paste = new PasteFragment();
                    transaction.replace(R.id.resultFrame, paste);
                    transaction.commit();

                    break;

                case 9:

                    Fragment moveCursor = new MoveCursorFragment();
                    transaction.replace(R.id.resultFrame, moveCursor);
                    transaction.commit();

                    break;

                case 10:

                    Fragment moveScreen = new MoveScreenFragment();
                    transaction.replace(R.id.resultFrame, moveScreen);
                    transaction.commit();

                    break;

                case 11:

                    Fragment other = new OtherFragment();
                    transaction.replace(R.id.resultFrame, other);
                    transaction.commit();

                    break;

                case 12:

                    Fragment info = new InfoFragment();
                    transaction.replace(R.id.resultFrame, info);
                    transaction.commit();

                    break;

                default:
                    break;
            }

        } else {

            Intent intent = new Intent(ViMainActivity.this,
                    PhoneResultActvity.class);

            intent.putExtra("position", position);
            startActivity(intent);

        }

    }
}
