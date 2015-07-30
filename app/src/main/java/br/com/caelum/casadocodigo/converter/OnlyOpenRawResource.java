package br.com.caelum.casadocodigo.converter;

import android.content.res.Resources;

import java.io.InputStream;

/**
 * Created by matheus on 24/07/15.
 */
public class OnlyOpenRawResource {
    private Resources resources;

    //SOLID

    public OnlyOpenRawResource(Resources resources) {
        this.resources = resources;
    }

    public InputStream openRawResource(int idResource) {
        return resources.openRawResource(idResource);
    }

}
