package com.marvinlabs.widget.slideshow.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.util.Collection;

/**
 * A GenericBitmapAdapter that loads images from the Internet.
 * <p/>
 * Created by ou @ Adore on 19/10/2019.
 */
public abstract class GenericLocalBitmapAdapter<T> extends GenericBitmapAdapter<T> {

    // Options for the BitmapFactory to decode the bitmap
    private BitmapFactory.Options bitmapFactoryOptions;

    //==============================================================================================
    // GENERAL METHODS
    //==

    /**
     * Constructor
     *
     * @param context The context in which the adapter is created (activity)
     * @param items   The items for which we have images to load
     */
    public GenericLocalBitmapAdapter(Context context, Collection<T> items) {
        super(context, items);
    }

    /**
     * Constructor
     *
     * @param context              The context in which the adapter is created (activity)
     * @param items                The items for which we have images to load
     * @param bitmapFactoryOptions The options to pass to the BitmapFactory used to decode the
     *                             bitmaps
     */
    public GenericLocalBitmapAdapter(Context context, Collection<T> items, BitmapFactory.Options bitmapFactoryOptions) {
        super(context, items);
        this.bitmapFactoryOptions = bitmapFactoryOptions;
    }

    //==============================================================================================
    // ASYNC MANAGEMENT METHODS
    //==

    protected abstract String getItemImagePath(T item, int position);

    @Override
    protected Bitmap asyncLoadBitmap(T item, int position) {
        Bitmap bm = null;
        try {
            bm = BitmapFactory.decodeFile(getItemImagePath(item, position), this.bitmapFactoryOptions);
        } catch (Exception e) {
            Log.e("LocalImageSlide", "Error while downloading image slide", e);
            e.printStackTrace();
        }
        return bm;
    }

}
