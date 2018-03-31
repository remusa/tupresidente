package com.rdevlab.tupresidentesoundboard.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rdevlab.tupresidentesoundboard.R;

import java.util.ArrayList;

/**
 * @author rms
 * @date 25/02/2018
 */

public class PhraseAdapter extends ArrayAdapter<Phrase> {

    private static final String TAG = "PhraseAdapter";

    private int mColorResourceId;

    public PhraseAdapter(@NonNull Context context, ArrayList<Phrase> phrases, int colorResourceId) {
        super(context, 0, phrases);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        Phrase currentPhrase = getItem(position);

        TextView phraseNameTextView = listItemView.findViewById(R.id.phrase_name_text_view);
        phraseNameTextView.setText(currentPhrase.getPhraseName());

        ImageView faceImageView = listItemView.findViewById(R.id.face_image_view);
        faceImageView.setBackgroundColor(ContextCompat.getColor(getContext(), this.mColorResourceId));

        if (currentPhrase.hasImageResourceId()) {
            faceImageView.setImageResource(currentPhrase.getImageResourceId());
            faceImageView.setVisibility(View.VISIBLE);
        } else {
            faceImageView.setVisibility(View.GONE);
        }

        ViewGroup textContainer = (RelativeLayout) listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(ContextCompat.getColor(getContext(), this.mColorResourceId));

        return listItemView;
    }
}
