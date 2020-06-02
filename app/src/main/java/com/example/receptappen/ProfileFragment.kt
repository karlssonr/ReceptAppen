package com.example.receptappen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val activity = activity as Context

        val profileImageView = view.findViewById<ImageView>(R.id.imageView_profile)

/*        Picasso.with(activity).load(R.drawable.ic_perm_identity_black_24dp)
            .transform(CropCircleTransformation)
            .into(profileImageView)*/

        return view
    }

}
