package com.darwinsys.expenses;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.darwinsys.expenses.dao.ExpenseDao;
import com.darwinsys.expenses.model.ExpenseItem;

/**
 * A fragment for viewing/editing a single ExpenseItem detail screen.
 * This fragment is either contained in a {@link ExpenseItemListActivity}
 * in two-pane mode (on tablets) or a {@link ExpenseItemDetailActivity}
 * on handsets.
 */
public class ExpenseItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The content this fragment is presenting.
     */
    private ExpenseItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ExpenseItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = ExpenseDao.ITEMS.get(getArguments().getInt(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.description);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.expenses_form, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.expense_date)).setText(mItem.date.toString());
            ((TextView) rootView.findViewById(R.id.expense_description)).setText(mItem.description);
            ((TextView) rootView.findViewById(R.id.expense_amount)).setText(mItem.amount.toString());
        }

        return rootView;
    }

    public void doSave(View v) {
        // finish();
    }
}
