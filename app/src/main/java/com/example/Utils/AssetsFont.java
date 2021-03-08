package com.example.Utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by
 * Dilipkumar R. Kaklotar
 * [ Senior Android Developer ]
 * Mobile: +91 8000722607
 * Skype: dilipkaklotar
 * Created On 2019-06-14.
 */
public class AssetsFont {


    public static Typeface setHeaderTypeface(Context context)
    {
        Typeface tfBold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Roboto-Medium.ttf");

        return tfBold;
    }

}
