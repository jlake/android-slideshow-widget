package com.marvinlabs.widget.slideshow.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.Collection;

/**
 * A GenericBitmapAdapter that loads images from the Internet.
 * <p/>
 * Created by ou @ Adore on 19/10/2019.
 */
public class LocalBitmapAdapter extends GenericLocalBitmapAdapter<String> {

    /**
     * Constructor
     *
     * @param context The context in which the adapter is created (activity)
     * @param imagePaths    The imagePaths for which we have images to load
     */
    public LocalBitmapAdapter(Context context, Collection<String> imagePaths) {
        super(context, imagePaths);
    }

    /**
     * Constructor
     *
     * @param context              The context in which the adapter is created (activity)
     * @param imagePaths                 The imagePaths for which we have images to load
     * @param bitmapFactoryOptions The options to pass to the BitmapFactory used to decode the
     *                             bitmaps
     */
    public LocalBitmapAdapter(Context context, Collection<String> imagePaths, BitmapFactory.Options bitmapFactoryOptions) {
        super(context, imagePaths, bitmapFactoryOptions);
    }

    protected String getItemImagePath(String item, int position) {
        return item;
    }

}
